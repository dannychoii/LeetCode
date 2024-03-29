// DFS로 해결하면 된다. 위의 implementation 에서는 visited를 위해서 + 연산을 수행했더니 매우 느린 결과가 나왔다.
class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = MutableList<MutableList<Int>>(numCourses) { mutableListOf<Int>() }

        for (prerequisite in prerequisites) {
            val a = prerequisite[0]
            val b = prerequisite[1]
            adj[a].add(b)
        }

        fun hasCycle(node: Int, visited: Set<Int>): Boolean {
            if (visited.contains(node)) return true
            adj[node].forEach {
                val result = hasCycle(it, visited + setOf(node))
                if (result) return true
            }
            adj[node] = emptyList<Int>().toMutableList()
            return false
        }

        for (i in 0..adj.lastIndex) {
            if (adj[i].isNotEmpty()) {
                if (hasCycle(i, setOf())) return false
            }
        }

        return true
    }
}

// DFS로 해결하면 된다. 위의 implementation 에서는 visited를 위해서 booleanArray로 처리했더니 훨씬 좋은 성능이 나타났다. PS에서는 array가 확실히 유리한 측면이 있다.
class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = MutableList<MutableList<Int>>(numCourses) { mutableListOf<Int>() }

        for (prerequisite in prerequisites) {
            val a = prerequisite[0]
            val b = prerequisite[1]
            adj[a].add(b)
        }

        fun hasCycle(node: Int, visited: Array<Boolean>): Boolean {
            if (visited[node]) return true
            adj[node].forEach {
                visited[node] = true
                val result = hasCycle(it, visited)
                visited[node] = false
                if (result) return true
            }
            adj[node] = emptyList<Int>().toMutableList()
            return false
        }

        for (i in 0..adj.lastIndex) {
            if (adj[i].isNotEmpty()) {
                if (hasCycle(i, Array<Boolean>(numCourses) { false })) return false
            }
        }

        return true
    }
}