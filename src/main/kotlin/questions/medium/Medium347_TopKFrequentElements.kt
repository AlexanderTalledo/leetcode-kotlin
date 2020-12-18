package questions.medium

import java.util.*

fun main() {
    val nums = intArrayOf(1, 1, 1, 2, 2, 3)
    val k = 2
    topKFrequent(nums, k).forEach { println(it) }
}

// Time complexity: O(nlog(k)), being n the amount of numbers and k the required most frequent numbers amount
// Space complexity: O(n + k), being n the amount of numbers and k the required most frequent numbers amount
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val frequencies = mapFrequencies(nums)
    return kMostFrequents(frequencies, k)
}

private fun mapFrequencies(nums: IntArray): Map<Int, Int> {
    val map = hashMapOf<Int, Int>()
    for (num in nums) {
        if (map.containsKey(num)) map[num] = map[num]!!.plus(1)
        else map[num] = 1
    }
    return map
}

private fun kMostFrequents(map: Map<Int, Int>, k: Int): IntArray {
    val result = IntArray(k)
    val minHeap = PriorityQueue<Int> { a, b -> map[a]!!.minus(map[b]!!) }
    map.keys.forEach { num ->
        minHeap.add(num)
        if (minHeap.size > k) minHeap.poll()
    }
    var index = 0
    while (minHeap.isNotEmpty()) {
        result[index++] = minHeap.poll()
    }
    return result
}



