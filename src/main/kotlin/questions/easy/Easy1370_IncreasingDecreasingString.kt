package questions.easy

fun main() {
    val s = "aaaabbbbcccc"
    println(sortString(s))
}

// Time complexity: O(n), being n the length of the input string
// Space complexity: O(n), being n the length of the input string
fun sortString(s: String): String {
    val sb = StringBuilder(s.length)
    val letters = IntArray(26)
    for (c in s) {
        letters[getIndex(c)]++
    }
    var count = 1
    while (count <= s.length) {
        if (count.rem(2) != 0) {
            for (i in letters.indices) {
                if (letters[i] == 0) continue
                updateState(letters, sb, i)
            }
        } else {
            for (i in letters.size.minus(1) downTo 0) {
                if (letters[i] == 0) continue
                updateState(letters, sb, i)
            }
        }
        ++count
    }
    return sb.toString()
}

private fun getIndex(c: Char) = c.minus('a')

private fun updateState(letters: IntArray, sb: StringBuilder, i: Int) {
    letters[i]--
    sb.append(getChar(i))
}

private fun getChar(index: Int) = 'a'.plus(index)


