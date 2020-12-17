package questions.easy

fun main() {
    val headA = ListNode(1)
    val headB = ListNode(2)
    val intersection = ListNode(3)
    headA.next = intersection
    headB.next = intersection
    println(getIntersectionNode(headA, headB)?.value)
}

// Time complexity: O(n + m), being n and m the amount of nodes of headA and headB respectively
// Space complexity: O(1), no extra space required
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var pa = headA
    var pb = headB
    var isAlreadyFlippedA = false
    var isAlreadyFlippedB = false
    while (pa != pb) {
        pa = pa?.next
        if (pa == null) {
            if (isAlreadyFlippedA) return pa
            else {
                pa = headB
                isAlreadyFlippedA = true
            }
        }
        pb = pb?.next
        if (pb == null) {
            if (isAlreadyFlippedB) return pb
            else {
                pb = headA
                isAlreadyFlippedB = true
            }
        }
    }
    return pa
}
