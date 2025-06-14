package neetcode.arrays

import java.util.TreeMap

/**
 * https://neetcode.io/problems/anagram-groups?list=neetcode150
 */

private fun main() {
    val strings = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(groupAnagrams(strings = strings))
}

private fun groupAnagrams(strings: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, List<String>>()

    strings.forEach { string ->
        val frequencyMap = TreeMap<Char, Int>()

        string.forEach { char ->
            frequencyMap[char] = frequencyMap.getOrDefault(char, 0) + 1
        }

        val key = frequencyMap.map { "${it.key}:${it.value}" }.joinToString("")
        val group = map.getOrDefault(key, listOf()) + string
        map[key] = group
    }
    return map.values.toList()
}
