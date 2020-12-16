package questions.easy

fun main() {
    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println(maxSubArray(nums))
}

// Time complexity: O(n), being n the amount of numbers
// Space complexity: O(1), no extra space required
fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var maxSum = nums[0]
    var currentMaxSum = maxSum
    for (i in 1 until nums.size) {
        val current = nums[i]
        currentMaxSum = Math.max(currentMaxSum.plus(current), current)
        maxSum = Math.max(maxSum, currentMaxSum)
    }
    return maxSum
}
