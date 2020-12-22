package questions.medium

fun main() {
    val grid = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(numIslands(grid))
}

fun numIslands(grid: Array<CharArray>): Int {
    var islandCount = 0
    for (row in grid.indices) {
        for (col in grid[0].indices) {
            if (grid[row][col] == '1') {
                ++islandCount
                visitIslandCells(grid, row, col)
            }
        }
    }
    return islandCount
}

private fun visitIslandCells(grid: Array<CharArray>, row: Int, col: Int) {
    if (row !in grid.indices) return
    if (col !in grid[0].indices) return
    if (grid[row][col] == '0') return
    grid[row][col] = '0'
    visitIslandCells(grid, row, col.minus(1))
    visitIslandCells(grid, row, col.plus(1))
    visitIslandCells(grid, row.minus(1), col)
    visitIslandCells(grid, row.plus(1), col)
}