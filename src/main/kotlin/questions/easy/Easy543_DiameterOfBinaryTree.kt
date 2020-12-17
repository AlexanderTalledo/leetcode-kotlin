package questions.easy

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right = TreeNode(3)
    println(diameterOfBinaryTree(root))
}

// Time complexity: O(n), being n the amount of nodes in the tree
// Space complexity: O(n), being n the amount of nodes in the tree
fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) return 0
    val info = getBinaryTreeInfo(root)
    return Math.max(info.path, info.diameter).minus(1)
}

data class BinaryTreeInfo(val path: Int, val diameter: Int)

private fun getBinaryTreeInfo(root: TreeNode?): BinaryTreeInfo {
    if (root == null) return BinaryTreeInfo(0, 0)
    val left = getBinaryTreeInfo(root.left)
    val right = getBinaryTreeInfo(root.right)
    val maxPath = Math.max(left.path, right.path).plus(1)
    val maxDiameterSubTree = Math.max(left.diameter, right.diameter)
    val maxDiameterRoot = left.path.plus(right.path).plus(1)
    val maxDiameter = Math.max(maxDiameterSubTree, maxDiameterRoot)
    return BinaryTreeInfo(maxPath, maxDiameter)
}
