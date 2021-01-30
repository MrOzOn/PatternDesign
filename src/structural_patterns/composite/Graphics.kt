package structural_patterns.composite

// this is general interface for any component
interface Graphic {
    fun move(x: Int, y: Int)
    fun draw()
}

class CompoundGraphic: Graphic {

    private val children: MutableList<Graphic> = mutableListOf()

    override fun move(x: Int, y: Int) {
        children.forEach { child ->
            child.move(x,y)
        }
    }

    override fun draw() {
        println("draw CompoundGraphic:")
        children.forEach { child ->
            child.draw()
        }
    }

    fun add(child: Graphic) {
        children.add(child)
    }

    fun remove(child: Graphic) {
        children.remove(child)
    }

}