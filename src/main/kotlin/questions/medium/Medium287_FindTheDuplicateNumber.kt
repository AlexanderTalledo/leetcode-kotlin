package questions.medium

fun main() {
    val nums = intArrayOf(1, 3, 4, 2, 2)
    println(findDuplicate(nums))
}

// Time complexity: O(n)), being n the amount of numbers
// Space complexity: O(1), no extra space required
fun findDuplicate(nums: IntArray): Int {
    var slow = nums[0]
    var fast = nums[0]
    do {
        slow = next(nums, slow)
        fast = next(nums, next(nums, fast))
    } while (slow != fast)
    slow = nums[0]
    while (slow != fast) {
        slow = next(nums, slow)
        fast = next(nums, fast)
    }
    return slow
}

private fun next(nums: IntArray, value: Int) = nums[value]

