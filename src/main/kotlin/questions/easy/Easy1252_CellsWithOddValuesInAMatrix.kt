package questions.easy

fun main() {
    val n = 2
    val m = 3
    val indices = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 1)
    )
    println(oddCells(n, m, indices))
}

// Time complexity: O(mn)
// Space complexity: O(k), being k the largest value between n and m
fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
    var oddCount = 0
    val row = IntArray(n)
    val col = IntArray(m)
    for (index in indices) {
        row[index[0]]++
        col[index[1]]++
    }
    for (r in 0 until n) {
        for (c in 0 until m) {
            oddCount += (row[r].plus(col[c])).rem(2)
        }
    }
    return oddCount
}
