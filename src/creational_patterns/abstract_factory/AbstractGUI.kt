package creational_patterns.abstract_factory

//abstract factory!!!
interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

interface Button {
    fun paint()
}

interface Checkbox {
    fun paint()
}