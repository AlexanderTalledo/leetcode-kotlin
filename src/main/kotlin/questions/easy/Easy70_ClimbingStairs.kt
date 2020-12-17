package questions.easy

fun main() {
    val n = 2
    println(climbStairs(n))
}

// Time complexity: O(n), being n the amount of stairs
// Space complexity: O(1), no extra space required
fun climbStairs(n: Int): Int {
    if (n <= 1) return 1
    var first = 1
    var second = 1
    for (i in 2..n) {
        val temp = second
        second = second.plus(first)
        first = temp
    }
    return second
}
