package questions.easy

fun main() {
    val startTime = intArrayOf(1, 2, 3)
    val endTime = intArrayOf(3, 2, 7)
    val queryTime = 4
    println(busyStudent(startTime, endTime, queryTime))
}

// Time complexity: O(n), being n the number of students
// Space complexity: O(1), no extra space required
fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
    var studentCount = 0
    for (i in startTime.indices) {
        if (queryTime in startTime[i]..endTime[i]) ++studentCount
    }
    return studentCount
}
