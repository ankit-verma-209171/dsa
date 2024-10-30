package arrays.medium

/**
 * Longest Consecutive Sequence in an Array
 *
 * Link: https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/
 */

private fun main() {
    val nums = intArrayOf(3, 8, 5, 7, 6)
    val longestConsecutiveSequenceLength = findLengthOfLongestConsecutiveSequence(nums = nums)
    println(longestConsecutiveSequenceLength)
}

private fun findLengthOfLongestConsecutiveSequence(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val lookUp = nums.toSet()
    var longest = 1
    for (num in nums) {
        if ((num - 1) !in lookUp) {
            var cnt = 1
            var next = num
            while (lookUp.contains(++next)) ++cnt
            longest = maxOf(longest, cnt)
        }
    }
    return longest
}