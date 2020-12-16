package questions.easy

fun main() {
    val head = ListNode(1)
    println(hasCycle(head))
}

// Time complexity: O(n), being n the amount of nodes
// Space complexity: O(1), no extra space required
fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head?.next
    while (slow != fast) {
        slow = slow?.next
        fast = fast?.next?.next
    }
    return fast != null
}
