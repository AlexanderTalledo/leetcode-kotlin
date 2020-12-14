package questions.easy

fun main() {
    val s = "10#11#12"
    println(freqAlphabets(s))
}

// Time complexity: O(n), being n the length of the input string
// Space complexity: O(n), being n the length of the input string
fun freqAlphabets(s: String): String {
    val sb = StringBuilder()
    val map = getAlphabetMap()
    var index = s.length.minus(1)
    while (index >= 0) {
        val num = StringBuilder()
        val c = s[index]
        if (c == '#') {
            num.insert(0, s[--index])
            num.insert(0, s[--index])
        } else {
            num.append(c)
        }
        sb.insert(0, map[getIndex(num.toString())])
        --index
    }
    return sb.toString()
}

fun getAlphabetMap() = CharArray(26) { i -> 'a'.plus(i) }

fun getIndex(num: String) = Integer.parseInt(num).minus(1)


