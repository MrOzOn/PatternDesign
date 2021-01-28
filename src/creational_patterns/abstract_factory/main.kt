package creational_patterns.abstract_factory

fun showGUI(factory: GUIFactory) {
    val button = factory.createButton()
    button.paint()
    val checkbox = factory.createCheckbox()
    checkbox.paint()
}

fun main() {
    // Using Mac
    showGUI(MacFactory())
    // Using Windows
    showGUI(WinFactory())
}