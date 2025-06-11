package tuf.binarysearch.answers

/**
 * Aggressive Cows
 *
 * Link: https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/
 */

fun main() {
//    val stalls = listOf<Long>(4,2,1,3,6)
//    val k = 2L
//    val minimumMaximumDistance = findMinimumMaximumDistanceBetweenCows(stalls, k)
//    println(minimumMaximumDistance.toString())

    solution()
}

private fun solution() {
    val tests = readlnOrNull()?.toInt() ?: return
    repeat(tests) {
        val (numberOfStalls, cows) = readlnOrNull()?.split(" ") ?: return
        val stalls = mutableListOf<Long>()
        repeat(numberOfStalls.toInt()) {
            stalls.add(readlnOrNull()?.toLong() ?: return)
        }
        println(findMinimumMaximumDistanceBetweenCows(stalls = stalls, cows = cows.toLong()))
    }
}

private fun findMinimumMaximumDistanceBetweenCows(stalls: List<Long>, cows: Long): Long {
    if (stalls.size == 1) return 0
    val sortedStalls = stalls.sorted()
    var low = 1L
    var high = sortedStalls.last() - sortedStalls.first()
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (
            isPossibleMaximumDistance(stalls = sortedStalls, cows = cows, distance = mid)
        ) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return high
}

private fun isPossibleMaximumDistance(stalls: List<Long>, cows: Long, distance: Long): Boolean {
    var count = 0
    var i = 0
    var j = 1
    while (j < stalls.size && i < j) {
        if ((stalls[j] - stalls[i]) >= distance) {
            ++count
            i = j
            ++j
        } else {
            ++j
        }
    }
    return (count + 1) >= cows
}
