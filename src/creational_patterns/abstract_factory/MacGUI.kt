package creational_patterns.abstract_factory

class MacFactory: GUIFactory {

    init {
        println("using Mac")
    }

    class MacButton: Button {
        override fun paint() {
            println("paint button on MAC style")
        }
    }

    class MacCheckbox: Checkbox {
        override fun paint() {
            println("paint checkbox on MAC style")
        }
    }

    override fun createButton(): Button = MacButton()
    override fun createCheckbox(): Checkbox = MacCheckbox()
}