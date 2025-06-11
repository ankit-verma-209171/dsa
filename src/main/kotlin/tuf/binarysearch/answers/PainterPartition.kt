package tuf.binarysearch.answers

/**
 * Painter's Partition Problem
 *
 * Link: https://takeuforward.org/arrays/painters-partition-problem/
 */

private fun main() {
    val boards = intArrayOf(48, 90)
    val painters = 2
    val maxTimeTaken = findMaxTimeTaken(boards = boards, painters = painters)
    println(maxTimeTaken)
}

private fun findMaxTimeTaken(boards: IntArray, painters: Int): Int {
    if (boards.size <= painters) return boards.max()
    var low = boards.max()
    var high = boards.sum()
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (isPossibleTime(boards = boards, time = mid, painters = painters)) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return low
}

private fun isPossibleTime(boards: IntArray, time: Int, painters: Int): Boolean {
    var paintersNeeded = 1
    var timeTaken = 0
    for (board in boards) {
        if (timeTaken + board <= time) {
            timeTaken += board
        } else {
            paintersNeeded++
            timeTaken = board
        }
    }
    return paintersNeeded > painters
}
