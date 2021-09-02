package me.bytebeats.generator.impl

import me.bytebeats.generator.GenericGenerator

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/9/1 21:47
 * @Version 1.0
 * @Description TO-DO
 */

class EmailAddressGenerator : GenericGenerator() {
    override fun generate(): String {
        val prefix = alphaNumbericWithSizeBetween(5, 9)
        val part1 = alphaNumbericWithSizeBetween(1, 10)
        val part2 = alphaNumbericWithSizeBetween(2, 3)
        return "$prefix@${part1}.$part2"
    }

    private fun alphaNumbericWithSizeBetween(start: Int, end: Int): String {
        val size = random.nextInt(start, end + 1)
        return alphaNumbericWithSize(size)
    }

    private fun alphaNumbericWithSize(size: Int): String {
        return (0 until size).map { ALPHA_NUMBERIC.random() }.joinToString(separator = "")
    }

    companion object {
        private const val ALPHA_NUMBERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    }
}