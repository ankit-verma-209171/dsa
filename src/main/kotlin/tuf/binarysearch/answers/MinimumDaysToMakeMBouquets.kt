package tuf.binarysearch.answers

/**
 * Minimum days to make M bouquets
 *
 * Link: https://takeuforward.org/arrays/minimum-days-to-make-m-bouquets/
 */

private fun main() {
    val blooms = intArrayOf(5, 37, 55, 92, 22, 52, 31, 62, 99, 64, 92, 53, 34, 84, 93, 50, 28)
    val mBouquets = 8
    val kRoses = 2
    val minimumDaysToMakeMBouquets = findMinimumDaysToMakeMBouquets(
        blooms = blooms,
        mBouquets = mBouquets,
        kRoses = kRoses
    )
    println(minimumDaysToMakeMBouquets)
}

private fun findMinimumDaysToMakeMBouquets(blooms: IntArray, mBouquets: Int, kRoses: Int): Int {
    if (mBouquets.toLong() * kRoses > blooms.size) return -1
    var low = blooms.min()
    var high = blooms.max()
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (
            canMakeMBouquetsWithGivenDays(
                days = mid,
                blooms = blooms,
                mBouquets = mBouquets,
                kRoses = kRoses
            )
        ) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return low
}

private fun canMakeMBouquetsWithGivenDays(
    days: Int,
    blooms: IntArray,
    mBouquets: Int,
    kRoses: Int
): Boolean {
    var bouquets = 0
    var current = 0
    blooms.forEach { bloom ->
        if (bloom <= days) {
            ++current
        } else {
            bouquets += (current / kRoses)
            current = 0
        }
    }
    bouquets += (current / kRoses)
    return bouquets >= mBouquets
}
