package arrays.medium

/**
 * next_permutation: find next lexicographically greater permutation
 *
 * Link: https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/
 */

private fun main() {
    val nums = intArrayOf(1, 3, 2)
    val nextPermutations = findNextPermutation(nums = nums)
    println(nextPermutations.contentToString())
}

private fun findNextPermutation(nums: IntArray): IntArray {
    // Find first number from end to start where Ai < Ai+1 (ascending order)
    var edge = -1
    for (i in (nums.lastIndex - 1) downTo 0) {
        if (nums[i] < nums[i + 1]) {
            edge = i
            break
        }
    }

    // If no such element; it's last permutation, so first permutation will be next
    if (edge == -1) return nums.reversedArray()

    // If we found edge, we found element that is just more than edge element,
    // swap it with edge
    for (i in nums.lastIndex downTo (edge + 1)) {
        if (nums[i] > nums[edge]) {
            swap(nums, edge, i)
            break
        }
    }

    // and reverse the right portion to get next permutation
    val updatedNums = nums.copyOf()
    updatedNums.reverse(edge + 1, updatedNums.size)
    return updatedNums
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
}