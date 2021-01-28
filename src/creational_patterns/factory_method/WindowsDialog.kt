package creational_patterns.factory_method

class WindowsButton : Button {
    override fun render() {
        println("render WindowsButton")
    }
    override fun onClick(f: () -> Unit) {
        f()
        println("clicked WindowsButton")
    }
}

class WindowsDialog : Dialog() {
    override fun createButton(): Button = WindowsButton()
}