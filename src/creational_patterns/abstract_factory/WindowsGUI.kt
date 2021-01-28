package creational_patterns.abstract_factory

class WinFactory: GUIFactory {
    init {
        println("using Windows")
    }

    class WinButton: Button {
        override fun paint() {
            println("paint button on WINDOWS style")
        }
    }

    class WinCheckbox: Checkbox {
        override fun paint() {
            println("paint checkbox on WINDOWS style")
        }
    }

    override fun createButton(): Button = WinButton()
    override fun createCheckbox(): Checkbox = WinCheckbox()
}