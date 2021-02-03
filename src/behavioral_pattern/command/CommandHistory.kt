package behavioral_pattern.command

import java.util.*

class CommandHistory{
    private val history = Stack<Command>()

    fun push(command: Command){
        history.push(command)
    }

    fun pop():Command = history.pop()

    val isEmpty: Boolean get() = history.isEmpty()
}