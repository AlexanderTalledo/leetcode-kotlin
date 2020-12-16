package questions.easy

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    twoSum(nums, target).forEach { println(it) }
}

// Time complexity: O(n), being n the amount of numbers
// Space complexity: O(n), being n the amount of numbers
fun twoSum(nums: IntArray, target: Int): IntArray {
    val indices = intArrayOf(-1, -1)
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val num = nums[i]
        val needed = target.minus(num)
        if (map.containsKey(needed)) {
            indices[0] = map[needed]!!
            indices[1] = i
            break
        } else {
            map[num] = i
        }
    }
    return indices
}
