package tuf.binarysearch.answers

import kotlin.math.ceil

/**
 * Koko Eating Bananas
 *
 * Link: https://takeuforward.org/binary-search/koko-eating-bananas/
 */

private fun main() {
    val bananas = intArrayOf(805306368, 805306368, 805306368)
    val maxHours = 1000000000
    val minimumBananasToEatPerHour = findMinimumBananasToEatPerHour(bananas, maxHours)
    println("Minimum Bananas To Eat Per Hour: $minimumBananasToEatPerHour")
}

private fun findMinimumBananasToEatPerHour(pilesOfBananas: IntArray, maxAvailableHours: Int): Int {
    val minBananasPerPile = 1
    val maxBananasPerPile = pilesOfBananas.max()
    var low = minBananasPerPile
    var high = maxBananasPerPile
    while (low <= high) {
        val mid = low + (high - low) / 2
        val timeTakenToEatAllBananas = findTimeTakenToEatAllBananas(
            bananasToEatPerHour = mid,
            pilesOfBananas = pilesOfBananas
        )
        if (timeTakenToEatAllBananas <= maxAvailableHours) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return low
}

private fun findTimeTakenToEatAllBananas(
    bananasToEatPerHour: Int,
    pilesOfBananas: IntArray
): Long = pilesOfBananas.fold(0) { acc, banana ->
    acc + ceil(banana / bananasToEatPerHour.toDouble()).toLong()
}
