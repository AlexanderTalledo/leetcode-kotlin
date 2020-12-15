package questions.easy

fun main() {
    val nums = intArrayOf(3, 4, 5, 2)
    println(maxProduct(nums))
}

// Time complexity: O(n), being n the number of numbers
// Space complexity: O(1), no extra space required
fun maxProduct(nums: IntArray): Int {
    var max1 = Math.max(nums[0], nums[1])
    var max2 = Math.min(nums[0], nums[1])
    for (i in 2 until nums.size) {
        val num = nums[i]
        if (num > max1) {
            max2 = max1
            max1 = num
        } else {
            max2 = Math.max(max2, num)
        }
    }
    return getProduct(max1, max2)
}

private fun getProduct(num1: Int, num2: Int) = (num1.minus(1)).times(num2.minus(1))
