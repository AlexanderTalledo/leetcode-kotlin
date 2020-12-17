package questions.easy

fun main() {
    val points = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(3, 4),
        intArrayOf(-1, 0)
    )
    println(minTimeToVisitAllPoints(points))
}

// Time complexity: O(n), being n the number of given points
// Space complexity: O(1), no extra space required
fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var minTime = 0
    for (i in 1 until points.size) {
        val startPoint = points[i.minus(1)]
        val endPoint = points[i]
        val dx = Math.abs(startPoint[0].minus(endPoint[0]))
        val dy = Math.abs(startPoint[1].minus(endPoint[1]))
        minTime = minTime.plus(Math.max(dx, dy))
    }
    return minTime
}
