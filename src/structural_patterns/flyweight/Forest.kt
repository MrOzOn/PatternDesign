package structural_patterns.flyweight

import java.awt.Color
import java.awt.Graphics
import javax.swing.JFrame

class Forest: JFrame() {
    private val trees: MutableList<Tree> = mutableListOf()

    fun plantTree(x: Int, y: Int, name: String, color: Color, otherTreeData: String) {
        val treeType = TreeFactory.getTreeType(name, color, otherTreeData)
        val tree = Tree(x, y, treeType)
        trees.add(tree)
    }

    override fun paint(g: Graphics?) {
        g?.let {
            trees.forEach { tree ->
                tree.draw(g)
            }
        }
    }
}