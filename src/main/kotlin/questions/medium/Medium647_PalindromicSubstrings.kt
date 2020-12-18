package questions.medium

fun main() {
    val s = "abc"
    println(countSubstrings(s))
}

// Time complexity: O(n), being n the length of the input string
// Space complexity: O(1), no extra space required
fun countSubstrings(s: String): Int {
    var count = 0
    for (i in s.indices) {
        count += countPalindromes(s, i, i).plus(countPalindromes(s, i, i.plus(1)))
    }
    return count
}

private fun countPalindromes(s: String, start: Int, end: Int): Int {
    var count = 0
    var left = start
    var right = end
    while (left >= 0 && right < s.length) {
        if (s[left--] == s[right++]) ++count
        else break
    }
    return count
}


