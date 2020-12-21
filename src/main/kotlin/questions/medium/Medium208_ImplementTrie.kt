package questions.medium

fun main() {
    val trie = Trie()
    trie.insert("apple")
    println(trie.search("apple"))
    println(trie.search("app"))
    println(trie.startsWith("app"))
    trie.insert("app")
    println(trie.search("app"))
}

class Trie {

    private val root: TrieNode = TrieNode('-')

    fun insert(word: String) {
        var current: TrieNode? = root
        for (c in word) {
            if (current!!.children[getIndex(c)] == null) {
                current.children[getIndex(c)] = TrieNode(c)
            }
            current = current.children[getIndex(c)]
        }
        current!!.isWord = true
    }

    fun search(word: String): Boolean {
        val current = getTrieNode(word)
        return current != null && current.isWord
    }

    fun startsWith(prefix: String) = getTrieNode(prefix) != null

    private fun getTrieNode(s: String): TrieNode? {
        var current: TrieNode? = root
        for (c in s) {
            if (current!!.children[getIndex(c)] == null) return null
            current = current.children[getIndex(c)]
        }
        return current
    }

    private fun getIndex(c: Char) = c.minus('a')

}

class TrieNode(private val c: Char) {
    var isWord = false
    val children = Array<TrieNode?>(26) { null }
}

