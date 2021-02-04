package behavioral_pattern.mediator

import javax.swing.DefaultListModel
import javax.swing.ListModel

interface Mediator {
    fun addNewNote(note: Note)
    fun deleteNote()
    fun setElementsList(listModel: ListModel<Note>)
    fun sendToFilter(listModel: DefaultListModel<Note>)
    fun hideElements(flag: Boolean)
    fun saveChanges()
    fun markNote()
    fun getInfoFromList(note: Note)
    fun clear()
    fun registerComponent(component: Component)
    fun createGUI()
}