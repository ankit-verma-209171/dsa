package neetcode.arrays

/**
 * https://neetcode.io/problems/is-anagram?list=neetcode150
 */

private fun main() {
    val s = "anagram"
    val t = "nagaram"
    println("Are s and t anagram? ${areAnagrams(s = s, t = t)}")
}

private fun areAnagrams(s: String, t: String): Boolean {
    val map = mutableMapOf<Char, Int>()
    s.forEach { c ->
        map[c] = map.getOrDefault(c, 0) + 1
    }
    t.forEach { c ->
        map[c] = map.getOrDefault(c, 0) - 1
    }
    return map.values.all { it == 0 }
}
