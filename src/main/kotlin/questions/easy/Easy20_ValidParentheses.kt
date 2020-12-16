package questions.easy

import java.util.*

fun main() {
    val s = "()"
    println(isValid(s))
}

// Time complexity: O(n), being n the length of the input string
// Space complexity: O(n), being n the length of the input string
fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    val open = hashSetOf('(', '[', '{')
    val closeMap = mapOf(
        ')' to '(',
        ']' to '[',
        '}' to '{'
    )
    for (c in s) {
        if (open.contains(c)) {
            stack.push(c)
            continue
        }
        if (stack.isEmpty() || stack.pop() != closeMap[c]!!) return false
    }
    return stack.isEmpty()
}
