// Node Class를 구성하는 방법에 유의할 것
class Node(
    val children: MutableMap<Char, Node> = mutableMapOf(),
    var endOrWord: Boolean = false
)

class Trie() {
    val root = Node()

    fun insert(word: String) {
        var cur = root
        for (c in word) {
            if (!cur.children.contains(c)) {
                cur.children[c] = Node()
            }
            cur = cur.children[c]!!
        }
        cur.endOrWord = true
    }

    fun search(word: String): Boolean {
        var cur = root
        for (c in word) {
            if (!cur.children.contains(c)) {
                return false
            }
            cur = cur.children[c]!!
        }
        return cur.endOrWord
    }

    fun startsWith(prefix: String): Boolean {
        var cur = root
        for (c in prefix) {
            if (!cur.children.contains(c)) {
                return false
            }
            cur = cur.children[c]!!
        }
        return true
    }
}
