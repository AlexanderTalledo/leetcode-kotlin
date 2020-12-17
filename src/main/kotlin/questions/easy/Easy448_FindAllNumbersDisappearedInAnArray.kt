package questions.easy

fun main() {
    val nums = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    findDisappearedNumbers(nums).forEach { println(it) }
}

// Time complexity: O(n), being n the amount of numbers
// Space complexity: O(1), assuming returned list doesn't count as extra space
fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val disappeared = mutableListOf<Int>()
    for (i in nums.indices) {
        val index = Math.abs(nums[i]).minus(1)
        if (nums[index] > 0) nums[index] = nums[index].times(-1)
    }
    for (i in nums.indices) {
        val num = nums[i]
        if (num > 0) disappeared.add(i.plus(1))
    }
    return disappeared
}
