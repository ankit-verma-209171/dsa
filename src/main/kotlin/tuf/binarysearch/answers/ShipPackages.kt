package tuf.binarysearch.answers

/**
 * Capacity to Ship Packages within D Days
 *
 * Link: https://takeuforward.org/arrays/capacity-to-ship-packages-within-d-days/
 */

private fun main() {
    val weights = intArrayOf(1, 2, 3, 1, 1)
    val maxDaysToShip = 4
    val minimumWeightCapacity = findMinimumWeightCapacityForShippingInGivenDays(
        weights = weights,
        maxDaysToShip = maxDaysToShip
    )
    println(minimumWeightCapacity)
}

private fun findMinimumWeightCapacityForShippingInGivenDays(
    weights: IntArray,
    maxDaysToShip: Int
): Int {
    var low = weights.max()
    var high = weights.sum()
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (canShipWithCapacity(capacity = mid, maxDaysToShip = maxDaysToShip, weights = weights)) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return low
}

private fun canShipWithCapacity(
    capacity: Int,
    maxDaysToShip: Int,
    weights: IntArray
): Boolean {
    var daysTaken = 0
    var runningSum = 0
    for (weight in weights) {
        runningSum += weight
        if (capacity < runningSum) {
            ++daysTaken
            runningSum = weight
        }
    }
    if (runningSum > 0) ++daysTaken
    return daysTaken <= maxDaysToShip
}
