package questions.easy

fun main() {
    val num = 9669
    println(maximum69Number(num))
}

// Time complexity: O(1)
// Space complexity: O(1), no extra space required
fun maximum69Number(num: Int): Int {
    var max = num
    var remaining = num
    var divider = 10000
    while (divider > 0) {
        val digit = remaining.div(divider)
        if (digit == 6) {
            max = divider.times(9.minus(6)).plus(num)
            break
        }
        remaining = remaining.rem(divider)
        divider = divider.div(10)
    }
    return max
}
