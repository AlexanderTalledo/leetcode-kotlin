package questions.easy

fun main() {
    val nums = intArrayOf(3, 2, 3)
    println(majorityElement(nums))
}

// Time complexity: O(n), being n the amount of numbers
// Space complexity: O(1), no extra space required
fun majorityElement(nums: IntArray): Int {
    var candidate = nums[0]
    var votes = 1
    for (i in 1 until nums.size) {
        val currentCandidate = nums[i]
        if (votes == 0) candidate = currentCandidate
        if (candidate == currentCandidate) votes++
        else votes--
    }
    return candidate
}
