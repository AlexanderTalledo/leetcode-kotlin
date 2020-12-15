package questions.easy

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    println(maxDepth(root))
}

// Time complexity: O(n), being n the max depth of the tree
// Space complexity: O(n), being n the max depth of the tree
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return Math.max(maxDepth(root.left), maxDepth(root.right)).plus(1)
}

