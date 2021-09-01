package me.bytebeats.generator.impl

import me.bytebeats.generator.GenericGenerator

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/9/1 21:43
 * @Version 1.0
 * @Description TO-DO
 */

class ChineseMobilePhoneNumberGenerator : GenericGenerator() {
    override fun generate(): String {
        val prefix = randPrefix()
        val mid4Digits = random.nextInt(0, 10000).toString().padStart(4, '0')
        val last4Digits = random.nextInt(0, 10000).toString().padStart(4, '0')
        return "$prefix$mid4Digits$last4Digits"
    }

    private fun randPrefix(): Int {
        return PHONE_NUMBER_PREFIX[random.nextInt(PHONE_NUMBER_PREFIX.size)]
    }

    companion object {
        private val PHONE_NUMBER_PREFIX = listOf(
            133, 153, 177, 180, 181, 189, 134, 135, 136, 137, 138, 139, 150, 151, 152, 157, 158,
            159, 178, 182, 183, 184, 187, 188, 130, 131, 132, 155, 156, 176, 185, 186, 145, 147, 170
        )
    }
}