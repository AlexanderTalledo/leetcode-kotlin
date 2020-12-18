package questions.medium

import java.util.*

fun main() {
    val nums = intArrayOf(3, 2, 1, 5, 6, 4)
    val k = 2
    println(findKthLargest(nums, k))
}

// Time complexity: O(nlog(k)), being n the amount of numbers and k the kth value
// Space complexity: O(k), being k the kth value
fun findKthLargest(nums: IntArray, k: Int): Int {
    val minHeap = PriorityQueue<Int> { a, b -> a.minus(b) }
    for (num in nums) {
        minHeap.add(num)
        if (minHeap.size > k) minHeap.poll()
    }
    return minHeap.poll()
}
