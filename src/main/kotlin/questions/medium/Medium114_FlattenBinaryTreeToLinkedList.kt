package questions.medium

import questions.easy.TreeNode
import java.util.*

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(5)
    root.right!!.right = TreeNode(6)
    flatten(root)
    var current: TreeNode? = root
    while (current != null) {
        println(current.value)
        current = current.right
    }
}

// Time complexity: O(n)), being n the amount of nodes
// Space complexity: O(n), being n the amount of nodes
fun flatten(root: TreeNode?) {
    if (root == null) return
    val stack = Stack<TreeNode>()
    stack.add(root)
    while (stack.isNotEmpty()) {
        val current = stack.pop()
        current.right?.run { stack.add(current.right) }
        current.left?.run { stack.add(current.left) }
        if (stack.isNotEmpty()) current.right = stack.peek()
        current.left = null
    }
}

