package questions.easy

fun main() {
    val n = 5
    sumZero(n).forEach { println(it) }
}

// Time complexity: O(n)
// Space complexity: O(n)
fun sumZero(n: Int): IntArray {
    val array = IntArray(n)
    var left = 0
    var right = n.minus(1)
    while (left < right) {
        val value = left.plus(1)
        array[left++] = value.times(-1)
        array[right--] = value
    }
    return array
}
