package tuf.arrays.hard

/**
 * 3 Sum : Find triplets that add up to a zero
 *
 * Link: https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
 */

private fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    val results = find3Sum(nums = nums)
    println(results)
}

private fun find3Sum(nums: IntArray): List<List<Int>>? {
    nums.sort()
    val n = nums.size
    val results = mutableListOf<List<Int>>()
    for (i in 0..<n) {
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var j = i + 1
        var k = n - 1
        while (j < k) {
            val currSum = nums[i] + nums[j] + nums[k]
            when {
                currSum < 0 -> ++j
                currSum > 0 -> --k
                else -> {
                    results += listOf(nums[i], nums[j], nums[k])
                    ++j; --k
                    while (j < k && nums[j] == nums[j - 1]) ++j
                    while (k > j && nums[k] == nums[k + 1]) ++k
                }
            }
        }
    }
    return results
}