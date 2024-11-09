package arrays.hard

/**
 * Merge Overlapping Sub-intervals
 *
 * Link: https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/
 */

private fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(0, 0),
    )
    val mergedIntervals = mergeOverlappingSubIntervals(intervals = intervals)
    println(mergedIntervals.joinToString(prefix = "[", postfix = "]") { it.contentToString() })
}

private fun mergeOverlappingSubIntervals(intervals: Array<IntArray>): Array<IntArray> {
    val n = intervals.size
    if (n < 2) return intervals
    intervals.sortBy { it[0] }
    val mergedIntervals = mutableListOf(intervals[0])
    for (i in 1..<n) {
        val lastMergedInterval = mergedIntervals.removeLast()
        val currentInterval = intervals[i]
        if (currentInterval[0] <= lastMergedInterval[1]) {
            mergedIntervals.add(
                intArrayOf(
                    minOf(lastMergedInterval[0], currentInterval[0]),
                    maxOf(lastMergedInterval[1], currentInterval[1]),
                )
            )
        } else {
            mergedIntervals += lastMergedInterval
            mergedIntervals += currentInterval
        }
    }
    return mergedIntervals.toTypedArray()
}
