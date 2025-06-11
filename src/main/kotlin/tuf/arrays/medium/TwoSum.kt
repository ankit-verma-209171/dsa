package tuf.arrays.medium

/**
 * Two Sum : Check if a pair with given sum exists in Array
 *
 * Link: https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/
 */

private fun main() {
    val nums = intArrayOf(2, 6, 5, 8, 11)
    val target = 14
    val (a, b) = findPositionsOfPairWithSum(nums = nums, target = target)
    println("$a, $b")
}

private fun findPairWithSum(nums: IntArray, target: Int): Pair<Int, Int> {
    var lookUp = mutableSetOf<Int>()
    for (num in nums) {
        val remainingTarget = target - num
        if (remainingTarget in lookUp) return remainingTarget to num
        else lookUp += num
    }
    return -1 to -1
}

private fun findPositionsOfPairWithSum(nums: IntArray, target: Int): Pair<Int, Int> {
    var lookUp = mutableMapOf<Int, Int>()
    for ((index, num) in nums.withIndex()) {
        val remainingTarget = target - num
        lookUp[remainingTarget]
            ?.let { return it to index }
            ?: run { lookUp[num] = index }
    }
    return -1 to -1
}
