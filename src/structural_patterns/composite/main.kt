package structural_patterns.composite

fun main(){
    val graphicElements: MutableList<Graphic> = mutableListOf()
    graphicElements.add(Dot(1,1))
    graphicElements.add(Dot(3,4))
    graphicElements.add(Circle(3,5, 10))
    val compoundGraphic = CompoundGraphic()
    compoundGraphic.add(Dot(2,2))
    compoundGraphic.add(Circle(7,7, 7))
    graphicElements.add(compoundGraphic)

    graphicElements.forEach { element ->
        element.draw()
    }
}