package creational_patterns.prototype

enum class Color {
    Black,
    White,
    Red,
    Green,
    Blue
}

class TextItem: ReportItemPrototype {

    var text: String? = null
    var color: Color? = null

    constructor()

    constructor(source: TextItem) {
        this.text = source.text
        this.color = source.color
    }

    fun initializeText(newText: String, newColor: Color) {
        this.text = newText
        this.color = newColor
    }

    override fun clone(): TextItem = TextItem(this)

}