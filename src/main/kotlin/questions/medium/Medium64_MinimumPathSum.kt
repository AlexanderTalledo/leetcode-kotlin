package questions.medium

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 1),
        intArrayOf(4, 2, 1)
    )
    println(minPathSum(grid))
}

// Time complexity: O(mn)), being m and n the amount of rows and columns in the grid
// Space complexity: O(1), no extra space required
fun minPathSum(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    for (row in 0 until m) {
        for (col in 0 until n) {
            calculateMinPath(grid, m, n, row, col)
        }
    }
    return grid[m.minus(1)][n.minus(1)]
}

private fun calculateMinPath(grid: Array<IntArray>, m: Int, n: Int, row: Int, col: Int) {
    val up = row.minus(1)
    val left = col.minus(1)
    when {
        up !in 0 until m && left !in 0 until n -> return
        up !in 0 until m -> grid[row][col] += grid[row][left]
        left !in 0 until n -> grid[row][col] += grid[up][col]
        else -> grid[row][col] += Math.min(grid[row][left], grid[up][col])
    }
}

