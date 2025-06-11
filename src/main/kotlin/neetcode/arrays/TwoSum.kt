package neetcode.arrays

/**
 * https://neetcode.io/problems/two-integer-sum?list=neetcode150
 */

private fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    println("Two sum: ${twoSum(nums = nums, target = target).contentToString()}")
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>() // num - index pair
    nums.forEachIndexed { index, num ->
        val remaining = target - num
        map[remaining]?.run {
            return intArrayOf(this, index)
        }
        map[num] = index
    }
    return intArrayOf(-1, -1)
}
