package questions.easy

fun main() {
    val S = "()()"
    println(removeOuterParentheses(S))
}

// Time complexity: O(n), being n the length of the input string
// Space complexity: O(1), no extra space required
fun removeOuterParentheses(S: String): String {
    val sb = StringBuilder()
    var openCount = 0
    for (c in S) {
        if (isOpenParentheses(c)) {
            ++openCount
            if (openCount > 1) sb.append(c)
        } else {
            --openCount
            if (openCount > 0) sb.append(c)
        }
    }
    return sb.toString()
}

fun isOpenParentheses(c: Char) = c == '('


