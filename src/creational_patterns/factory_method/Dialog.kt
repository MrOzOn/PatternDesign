package creational_patterns.factory_method

interface Button {
    fun render()
    fun onClick(f: ()-> Unit)
}

abstract class Dialog {
    fun render() {
        val okButton = createButton()
        okButton.onClick {
            println("okButton clicked")
        }
        okButton.render()
    }
    // factory method
    abstract fun createButton(): Button
}