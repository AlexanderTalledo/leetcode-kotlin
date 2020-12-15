package questions.easy

fun main() {
    val mat = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    println(diagonalSum(mat))
}

// Time complexity: O(n), being n the number of rows or columns
// Space complexity: O(1), no extra space required
fun diagonalSum(mat: Array<IntArray>): Int {
    var sum = 0
    var row = 0
    var col = 0
    while (row < mat.size) {
        sum += mat[row++][col++]
    }
    row = 0
    col = mat.size.minus(1)
    while (col >= 0) {
        if (col != row) sum += mat[row][col]
        ++row
        --col
    }
    return sum
}


