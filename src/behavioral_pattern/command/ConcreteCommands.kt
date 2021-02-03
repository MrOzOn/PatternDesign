package behavioral_pattern.command

class CopyCommand(private val editor: Editor): Command(editor){
    override fun execute(): Boolean {
        editor.clipboard = editor.textField.text
        return false
    }
}

class PastCommand(private val editor: Editor): Command(editor){
    override fun execute(): Boolean {
        if(editor.clipboard.isNullOrEmpty()) return false
        backup()
        editor.textField.insert(editor.clipboard, editor.textField.caretPosition)
        return true
    }
}

class CutCommand(private val editor: Editor): Command(editor){
    override fun execute(): Boolean {
        if(editor.textField.selectedText.isNullOrEmpty()) return false
        backup()
        val source = editor.textField.text
        editor.clipboard = editor.textField.selectedText
        editor.textField.text = cutString(source)
        return true
    }

    private fun cutString(source: String): String {
        val start = source.substring(0, editor.textField.selectionStart)
        val end = source.substring(editor.textField.selectionEnd)
        return start+end
    }
}