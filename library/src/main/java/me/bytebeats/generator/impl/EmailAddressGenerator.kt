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
        val part2 = alphaNumbericWithSizeBetween(1, 3)
        return "$prefix@${part1}.$part2"
    }

    private fun alphaNumbericWithSizeBetween(start: Int, end: Int): String {
        val size = random.nextInt(start, end + 1)
        return alphaNumbericWithSize(size)
    }

    private fun alphaNumbericWithSize(size: Int): String {
        val sb = StringBuilder()
        for (i in 0 until size) {
            sb.append(ALPHA_NUMBERIC[random.nextInt(ALPHA_NUMBERIC.length)])
        }
        return sb.toString()
    }

    companion object {
        private const val ALPHA_NUMBERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    }
}