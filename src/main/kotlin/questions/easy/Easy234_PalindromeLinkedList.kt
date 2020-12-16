package questions.easy

fun main() {
    val head = ListNode(1)
    intArrayOf(2, 2, 1).forEach { head.append(it) }
    println(isPalindrome(head))
}

// Time complexity: O(n), being n the amount of nodes
// Space complexity: O(1), no extra space required
fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) return true
    var slow = head
    var fast = head
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    slow = reverse(slow)
    fast = head
    while (slow != null) {
        if (slow.value != fast!!.value) return false
        slow = slow.next
        fast = fast.next
    }
    return true
}

private fun reverse(head: ListNode?): ListNode? {
    var current = head
    var prev: ListNode? = null
    while (current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}
