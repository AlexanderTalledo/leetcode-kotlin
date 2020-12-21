package questions.medium

fun main() {
    val n = 12
    println(numSquares(n))
}

// Time complexity: O(n*sqrt(n))
// Space complexity: O(n)
fun numSquares(n: Int): Int {
    if (n <= 3) return n
    val dp = IntArray(n.plus(1))
    for (i in 0..3) {
        dp[i] = i
    }
    for (i in 4..n) {
        dp[i] = i
        var j = 1
        while (j.times(j) <= i) {
            dp[i] = Math.min(dp[i], dp[i.minus(j.times(j))].plus(1))
            ++j
        }
    }
    return dp[n]
}
