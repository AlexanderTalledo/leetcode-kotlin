package questions.easy

fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(nums)
    nums.forEach { println(it) }
}

// Time complexity: O(n), being n the amount of numbers
// Space complexity: O(1), no extra space required
fun moveZeroes(nums: IntArray) {
    var lastNonZeroIndex = 0
    for (i in nums.indices) {
        if (nums[i] != 0) swap(nums, lastNonZeroIndex++, i)
    }
}

private fun swap(array: IntArray, start: Int, end: Int) {
    val temp = array[start]
    array[start] = array[end]
    array[end] = temp
}



