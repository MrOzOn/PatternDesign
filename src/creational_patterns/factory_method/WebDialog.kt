package creational_patterns.factory_method

class HTMLButton : Button {
    override fun render() {
        println("render HTMLButton")
    }
    override fun onClick(f: () -> Unit) {
        f()
        println("clicked HTMLButton")
    }
}

class WebDialog : Dialog() {
    override fun createButton(): Button = HTMLButton()
}