package questions.easy

fun main() {
    val nums = intArrayOf(2, 2, 1)
    println(singleNumber(nums))
}

// Time complexity: O(n), being n the amount of numbers
// Space complexity: O(1), no extra space required
fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (num in nums) {
        result = result.xor(num)
    }
    return result
}
