package structural_patterns.composite

class Dot(private var x:Int, private var y: Int): Graphic {
    override fun move(x: Int, y: Int) {
        this.x += x
        this.y += y
    }
    override fun draw() {
        println("draw Dot in coordinate ($x, $y)")
    }
}

class Circle(private val x: Int, private val y: Int, private val radius: Int): Graphic{
    override fun move(x: Int, y: Int) {
        // realise moving circle relative to it center
        println("realise moving circle relative to it center")
    }
    override fun draw() {
        println("draw Circle in coordinate ($x, $y) and radius = $radius")
    }
}