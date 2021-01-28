package creational_patterns.factory_method

fun main() {
    val dialog1 = WindowsDialog()
    dialog1.render()

    val dialog2 = WebDialog()
    dialog2.render()
}