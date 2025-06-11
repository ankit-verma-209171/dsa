package tuf.arrays.hard

/**
 * Majority Elements(>N/3 times) | Find the elements that appears more than N/3 times in the array
 *
 * Link: https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/
 */

private fun main() {
    val nums = intArrayOf(1, 2, 2, 3, 2)
    val majorityNumbers = findMajorityNumbers(nums = nums)
    println(majorityNumbers.contentToString())
}

private fun findMajorityNumbers(nums: IntArray): IntArray {
    var el1 = Int.MIN_VALUE
    var el2 = Int.MIN_VALUE
    var cnt1 = 0
    var cnt2 = 0

    for (num in nums) {
        when {
            cnt1 == 0 && num != el2 -> {
                el1 = num
                ++cnt1
            }

            cnt2 == 0 && num != el1 -> {
                el2 = num
                ++cnt2
            }

            num == el1 -> ++cnt1

            num == el2 -> ++cnt2

            else -> {
                --cnt1
                --cnt2
            }
        }
    }

    return buildList {
        if (nums.count { it == el1 } > nums.size / 3) add(el1)
        if (nums.count { it == el2 } > nums.size / 3) add(el2)
    }.toIntArray()
}
