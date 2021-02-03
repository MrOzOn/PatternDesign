package behavioral_pattern.command

import java.awt.FlowLayout
import javax.swing.*

class Editor {
    val textField: JTextArea = JTextArea()
    var clipboard: String? = null
    private val history = CommandHistory()

    init {
        val frame = JFrame("Simple text editor")
        val content = JPanel()
        frame.contentPane = content
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        content.layout = BoxLayout(content, BoxLayout.Y_AXIS)
        textField.lineWrap = true
        content.add(textField)
        val buttons = JPanel(FlowLayout(FlowLayout.CENTER))
        val ctrlC = JButton("Ctrl+C")
        val ctrlX = JButton("Ctrl+X")
        val ctrlV = JButton("Ctrl+V")
        val ctrlZ = JButton("Ctrl+Z")
        ctrlC.addActionListener {
            executeCommand(CopyCommand(this))
        }
        ctrlX.addActionListener {
            executeCommand(CutCommand(this))
        }
        ctrlV.addActionListener {
            executeCommand(PastCommand(this))
        }
        ctrlZ.addActionListener {
            undo()
        }
        buttons.add(ctrlC)
        buttons.add(ctrlX)
        buttons.add(ctrlV)
        buttons.add(ctrlZ)
        content.add(buttons)
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.isVisible = true;
    }

    private fun executeCommand(command: Command) {
        if (command.execute()) {
            println("push $command")
            history.push(command)
        }
    }

    private fun undo() {
        if (history.isEmpty) return
        val command = history.pop()
        command.undo()
    }
}