package questions.easy

fun main() {
    val tree1 = TreeNode(1)
    tree1.left = TreeNode(2)
    tree1.right = TreeNode(3)

    val tree2 = TreeNode(1)
    tree2.left = TreeNode(2)
    tree2.right = TreeNode(3)

    val merged = mergeTrees(tree1, tree2)
    printTreeValues(merged)
}

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

// Time complexity: O(n), being n the amount of nodes in the tree
// Space complexity: O(n), being n the amount of nodes in the tree
fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null) return t2
    if (t2 == null) return t1
    t1.value = t1.value.plus(t2.value)
    t1.left = mergeTrees(t1.left, t2.left)
    t1.right = mergeTrees(t1.right, t2.right)
    return t1
}

private fun printTreeValues(root: TreeNode?) {
    if (root == null) return
    println(root.value)
    printTreeValues(root.left)
    printTreeValues(root.right)
}