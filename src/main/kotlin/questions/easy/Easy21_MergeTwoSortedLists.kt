package questions.easy

fun main() {
    val l1 = ListNode(1)
    intArrayOf(2, 4).forEach { l1.append(it) }
    val l2 = ListNode(1)
    intArrayOf(3, 4).forEach { l2.append(it) }
    val merged = mergeTwoLists(l1, l2)
    merged?.printValues()
}

// Time complexity: O(n + m), being n and m the amount of nodes on l1 and l2 respectively
// Space complexity: O(1), not extra space required
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val dummyHead = ListNode(-1)
    var current: ListNode? = dummyHead
    var h1 = l1
    var h2 = l2
    while (h1 != null || h2 != null) {
        val value: Int
        when {
            h1 == null -> {
                value = h2!!.value
                h2 = h2.next
            }
            h2 == null -> {
                value = h1.value
                h1 = h1.next
            }
            h1.value < h2.value -> {
                value = h1.value
                h1 = h1.next
            }
            else -> {
                value = h2.value
                h2 = h2.next
            }
        }
        current!!.next = ListNode(value)
        current = current.next
    }
    return dummyHead.next
}


