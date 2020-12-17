package questions.easy

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(4)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(4)
    root.right!!.right = TreeNode(3)
    println(isSymmetric(root))
}

// Time complexity: O(n), being n the depth of the tree
// Space complexity: O(n), being n the depth of the tree
fun isSymmetric(root: TreeNode?): Boolean {
    return areSymmetric(root, root)
}

private fun areSymmetric(node1: TreeNode?, node2: TreeNode?): Boolean {
    if (node1 == null && node2 == null) return true
    if (node1 == null || node2 == null) return false
    val hasSameValue = node1.value == node2.value
    return hasSameValue && areSymmetric(node1.left, node2.right) && areSymmetric(node1.right, node2.left)
}

