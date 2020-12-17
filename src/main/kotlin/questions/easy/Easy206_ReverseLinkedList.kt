package questions.easy

fun main() {
    val values = intArrayOf(2, 3, 4, 5)
    val head = ListNode(1)
    values.forEach { head.append(it) }
    val reversed = reverseList(head)
    reversed?.printValues()
}

class ListNode(val value: Int) {
    var next: ListNode? = null

    fun append(newValue: Int) {
        var current: ListNode? = this
        while (current!!.next != null) {
            current = current.next
        }
        current.next = ListNode(newValue)
    }

    fun printValues() {
        var current: ListNode? = this
        while (current != null) {
            println(current.value)
            current = current.next
        }
    }
}

// Time complexity: O(n), being n the amount nodes
// Space complexity: O(1), no extra space required
fun reverseList(head: ListNode?): ListNode? {
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
