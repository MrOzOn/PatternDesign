package behavioral_pattern.mediator

class Note(var name: String = "New note", var text: String = "") {
    override fun toString(): String = name
}