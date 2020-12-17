package questions.medium

import questions.easy.TreeNode

fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(3)
    inorderTraversal(root).forEach { println(it) }
}


// Time complexity: O(n), being n the amount of nodes in the tree
// Space complexity: O(n), being n the amount of nodes in the tree
fun inorderTraversal(root: TreeNode?): List<Int> {
    val values = mutableListOf<Int>()
    traverseInOrder(root, values)
    return values
}

private fun traverseInOrder(root: TreeNode?, values: MutableList<Int>) {
    if (root == null) return
    traverseInOrder(root.left, values)
    values.add(root.value)
    traverseInOrder(root.right, values)
}
