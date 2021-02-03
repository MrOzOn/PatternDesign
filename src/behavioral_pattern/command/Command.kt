package behavioral_pattern.command

abstract class Command(private val editor: Editor) {
    private var backup: String? = null

    fun backup(){
        backup = editor.textField.text
    }

    fun undo(){
        editor.textField.text = backup
    }

    override fun toString(): String = javaClass.canonicalName

    abstract fun execute(): Boolean
}