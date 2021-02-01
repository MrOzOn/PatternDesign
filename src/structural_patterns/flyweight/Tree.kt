package structural_patterns.flyweight

import java.awt.Color
import java.awt.Graphics

class TreeType(private val name: String, private val color: Color, otherTreeData: String) {
    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = Color.BLACK
        g.fillRect(x - 1, y, 3, 5)
        g.color = color
        g.fillOval(x - 5, y - 10, 10, 10)
    }
}

class Tree(private val x: Int, private val y:Int, private val treeType: TreeType){
    fun draw(g: Graphics){
        treeType.draw(g, x, y)
    }
}

class TreeFactory {
    companion object {
        private val treeTypes: MutableMap<String, TreeType> = mutableMapOf()

        fun getTreeType(name: String, color: Color, otherTreeData: String): TreeType {
            var result = treeTypes[name]
            if (result==null) {
                result = TreeType(name, color, otherTreeData)
                treeTypes.put(name, result)
            }
            return result
        }
    }
}