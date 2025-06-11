package tuf.arrays.easy

/**
 * Find union of 2 sorted tuf.arrays
 *
 * Link: https://takeuforward.org/data-structure/union-of-two-sorted-arrays/
 */

private fun main() {
    val nums1 = intArrayOf(1, 2, 3, 4, 5)
    val nums2 = intArrayOf(2, 3, 4, 4, 5)
    val union = findUnion(nums1, nums2)
    println(union.contentToString())
}

private fun findUnion(nums1: IntArray, nums2: IntArray): IntArray {
    var i = 0
    var j = 0
    var union = mutableListOf<Int>()
    while (i < nums1.size && j < nums2.size) {
        when {
            nums1[i] == nums2[j] -> {
                union += nums1[i]
                ++i; ++j
            }

            // Whichever is smaller will also be not present in other array ahead
            // as tuf.arrays are sorted in ascending order
            nums1[i] < nums2[j] -> ++i
            else -> ++j
        }
    }
    return union.toIntArray()
}