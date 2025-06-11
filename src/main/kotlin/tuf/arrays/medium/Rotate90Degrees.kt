package tuf.arrays.medium

/**
 * Rotate image by 90 degrees
 *
 * Link: https://takeuforward.org/data-structure/rotate-image-by-90-degree/
 */

private fun main() {
    val image = arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7),
        intArrayOf(15, 14, 12, 16),
    )
    rotate90Degrees(image = image)
    image.forEach { println(it.contentToString()) }
}

private fun rotate90Degrees(image: Array<IntArray>) {
    transpose(image = image)
    image.forEach { it.reverse() }
}

private fun transpose(image: Array<IntArray>) {
    val n = image.size
    for (i in 0..<n) {
        for (j in i..<n) {
            if (i == j) continue
            val temp = image[i][j]
            image[i][j] = image[j][i]
            image[j][i] = temp
        }
    }
}