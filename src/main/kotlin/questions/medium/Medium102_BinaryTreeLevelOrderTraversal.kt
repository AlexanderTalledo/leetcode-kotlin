package questions.medium

import questions.easy.TreeNode
import java.util.*

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    levelOrder(root).forEach { level ->
        level.forEach { value -> print("$value ") }
        println()
    }
}

// Time complexity: O(n)), being n the amount of nodes
// Space complexity: O(n), being n the amount of nodes
fun levelOrder(root: TreeNode?): List<List<Int>> {
    val levels = mutableListOf<MutableList<Int>>()
    if (root != null) {
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            for (i in 0 until queue.size) {
                val currentNode = queue.pop()
                level.add(currentNode.value)
                if (currentNode.left != null) queue.add(currentNode.left!!)
                if (currentNode.right != null) queue.add(currentNode.right!!)
            }
            levels.add(level)
        }
    }
    return levels
}
