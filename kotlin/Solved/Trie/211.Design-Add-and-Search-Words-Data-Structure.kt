class Node(
    val children: MutableMap<Char, Node> = mutableMapOf(),
    var endOrWord: Boolean = false
)

class WordDictionary() {
    val root = Node()

    fun addWord(word: String) {
        var current = root
        for (c in word) {
            if (!current.children.contains(c)) {
                current.children[c] = Node()
            }
            current = current.children[c]!!
        }
        current.endOrWord = true
    }

    fun search(word: String): Boolean {
        return searchNode(word, root)
    }

    private fun searchNode(word: String, node: Node): Boolean {
        if (word.isEmpty()) {
            return node.endOrWord
        } else {
            if (word[0] == '.') {
                for (next in node.children.values) {
                    val result = searchNode(word.substring(1), next)
                    if (result) return true
                }
                return false
            } else if (node.children.contains(word[0])) {
                return searchNode(word.substring(1), node.children[word[0]]!!)
            } else {
                return false
            }
        }
    }
}