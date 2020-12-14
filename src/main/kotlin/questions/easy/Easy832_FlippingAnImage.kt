package questions.easy

fun main() {
    val A = arrayOf(
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 0)
    )
    flipAndInvertImage(A)
    for (row in A.indices) {
        for (col in A[0].indices) {
            print(A[row][col])
        }
        println()
    }
}

// Time complexity: O(mn), being m the number of rows and n the number of columns
// Space complexity: O(1), since we are modifying in place, no extra space is required
fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
    for (row in A) {
        var left = 0
        var right = row.size.minus(1)
        while (left <= right) {
            if (row[left] == row[right]) {
                val flipped = 1.minus(row[left])
                row[left] = flipped
                row[right] = flipped
            }
            ++left
            --right
        }
    }
    return A
}
