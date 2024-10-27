package arrays.medium

/**
 * Find the Majority Element that occurs more than N/2 times
 *
 * Link: https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
 */

private fun main() {
    val nums = intArrayOf(6, 5, 5)
    val majorityElement = findMajorityElement(nums = nums)
    println(majorityElement)
}

/**
 * Moore’s Voting Algorithm
 */
private fun findMajorityElement(nums: IntArray): Int? {
    var element: Int? = null
    var count = 0

    nums.forEach { num ->
        when {
            count == 0 -> {
                element = num
                ++count
            }

            element == num -> ++count

            element != num -> --count
        }
    }

    return element
}