package questions.medium

import questions.easy.TreeNode

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.left!!.right = TreeNode(2)
    val k = 1
    println(kthSmallest(root, k))
}

// Time complexity: O(n), being n the amount of nodes
// Space complexity: O(n), being n the amount of nodes
fun kthSmallest(root: TreeNode?, k: Int): Int {
    val values = mutableListOf<Int>()
    inOrderTraverse(root, k, values)
    return values.last()
}

private fun inOrderTraverse(root: TreeNode?, k: Int, values: MutableList<Int>) {
    if (root == null) return
    inOrderTraverse(root.left, k, values)
    if (values.size == k) return
    values.add(root.value)
    inOrderTraverse(root.right, k, values)
}


