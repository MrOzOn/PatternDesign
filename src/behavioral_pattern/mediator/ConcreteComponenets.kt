package behavioral_pattern.mediator

import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import javax.swing.*

class AddButton : JButton("Add"), Component {

    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun getName(): String = "AddButton"

    override fun fireActionPerformed(event: ActionEvent?) {
        mediator?.addNewNote(Note())
    }

}

class DeleteButton : JButton("Del"), Component {

    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun getName(): String = "DelButton"

    override fun fireActionPerformed(event: ActionEvent?) {
        mediator?.deleteNote()
    }

}

class Filter: JTextField(), Component {

    private var mediator: Mediator? = null
    private var listModel: ListModel<Note>? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    fun setList(listModel: ListModel<Note>){
        this.listModel = listModel
    }

    override fun getName(): String = "Filter"

    override fun processComponentKeyEvent(e: KeyEvent?) {
        val start = text
        searchElements(start)
    }

    private fun searchElements(s: String) {
        if (listModel==null)
            return
        if(s.isEmpty()) {
            mediator?.setElementsList(listModel!!)
            return
        }
        val notes = mutableListOf<Note>()
        for (i in 0..listModel!!.size) {
            notes.add(listModel!!.getElementAt(i))
        }
        val listModel = DefaultListModel<Note>()
        for (note in notes) {
            if (note.name.contains(s)) {
                listModel.addElement(note)
            }
        }
        mediator?.setElementsList(listModel)
    }

}

class List(private val listModel: DefaultListModel<Note>): JList<Note>(listModel), Component {

    private var mediator: Mediator? = null

    init {
        model = listModel
        layoutOrientation = VERTICAL
        val thread = Thread(Hide(this, mediator))
        thread.start()
    }

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun getName(): String = "List"

    fun addElement(note: Note) {
        listModel.addElement(note)
        val index = listModel.size()-1
        selectedIndex = index
        ensureIndexIsVisible(index)
        mediator?.sendToFilter(listModel)
    }

    fun deleteElement(){
        val index = selectedIndex
        try {
            listModel.remove(index)
            mediator?.sendToFilter(listModel)
        } catch (ex: ArrayIndexOutOfBoundsException) {}
    }

    fun getCurrentElement(): Note = selectedValue

    class Hide(private val list: List, val mediator: Mediator?): Runnable {
        override fun run() {
            while (true) {
                try {
                    Thread.sleep(300)
                } catch (ex: InterruptedException) {
                    println(ex.printStackTrace())
                }
                mediator?.hideElements(list.isSelectionEmpty)
            }
        }
    }

}

class SaveButton: JButton("Save"), Component{
    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun getName(): String = "Save"

    override fun fireActionPerformed(event: ActionEvent?) {
        mediator?.saveChanges()
    }
}

class TextBox: JTextArea(), Component {
    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun getName(): String = "TextBox"

    override fun processComponentKeyEvent(e: KeyEvent?) {
        mediator?.markNote()
    }

}

class Title: JTextField(), Component {
    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun getName(): String = "Title"

    override fun processComponentKeyEvent(e: KeyEvent?) {
        mediator?.markNote()
    }

}