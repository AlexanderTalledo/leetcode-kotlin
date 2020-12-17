package questions.medium

fun main() {
    val S = "ababcbacadefegdehijhklij"
    partitionLabels(S).forEach { println(it) }
}

// Time complexity: O(n), being n the length of the input string
// Space complexity: O(n), being n the length of the input string
fun partitionLabels(S: String): List<Int> {
    val letters = getLettersLastPosition(S)
    return getLabels(S, letters)
}

private fun getLettersLastPosition(s: String): IntArray {
    val letters = IntArray(26)
    for (i in s.indices) {
        val c = s[i]
        letters[getIndex(c)] = i
    }
    return letters
}

private fun getLabels(s: String, letters: IntArray): List<Int> {
    val labels = mutableListOf<Int>()
    var start = 0
    var end = 0
    for (i in s.indices) {
        val c = s[i]
        end = Math.max(end, letters[getIndex(c)])
        if (i == end) {
            labels.add(i.minus(start).plus(1))
            start = i.plus(1)
        }
    }
    return labels
}

private fun getIndex(c: Char) = c.minus('a')

