package questions.medium

fun main() {
    val m = 2
    val n = 2
    println(uniquePaths(m, n))
}

// Time complexity: O(mn))
// Space complexity: O(mn), being m and n the amount of rows and columns of the created grid
fun uniquePaths(m: Int, n: Int): Int {
    val grid = Array(m) { IntArray(n) }
    for (row in 0 until m) {
        for (col in 0 until n) {
            calculatePaths(grid, m, n, row, col)
        }
    }
    return grid[m.minus(1)][n.minus(1)]
}

private fun calculatePaths(grid: Array<IntArray>, m: Int, n: Int, row: Int, col: Int) {
    if (row == 0 && col == 0) {
        grid[row][col] = 1
        return
    }
    val upRow = row.minus(1)
    val leftCol = col.minus(1)
    val upPaths = if (upRow in 0 until m) grid[upRow][col] else 0
    val leftPaths = if (leftCol in 0 until n) grid[row][leftCol] else 0
    grid[row][col] = upPaths.plus(leftPaths)
}
