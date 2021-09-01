package me.bytebeats.generator.impl

import me.bytebeats.generator.GenericGenerator
import java.text.SimpleDateFormat
import java.util.*

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/9/1 20:46
 * @Version 1.0
 * @Description 随机生成中国大陆18位身份证号码
 */

class ChineseIdCardGenerator : GenericGenerator() {

    override fun generate(): String {
        val provinceCode = PROVINCE_CODES[random.nextInt(PROVINCE_CODES.size)]
        val cityCode = random.nextInt(1, 9999).toString().padStart(4, '0')
        val birthDay = SimpleDateFormat("yyyyMMdd").format(randomDate())
        val randomCode = random.nextInt(0, 999).toString().padStart(3, '0')
        val idCard17 = "$provinceCode$cityCode$birthDay$randomCode"
        val verifyCode = verifyCode(idCard17)
        return "$idCard17$verifyCode"
    }

    private fun randomDate(): Date {
        val calendar = Calendar.getInstance()
        val now = calendar.time.time
        calendar.set(1970, 1, 1)
        val earliestDate = calendar.time.time
        return Date(random.nextLong(earliestDate, now))
    }

    private fun verifyCode(idCard: String): String {
        var iSum17 = 0
        BIT_POWERS.forEachIndexed { index, s ->
            iSum17 += idCard[index].toString().toInt() * s.toInt()
        }
        return CHECK_CODES[iSum17 % 11]
    }

    companion object {
        /** 省、直辖市代码表 */
        val PROVINCE_CODES = arrayOf(
            "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35", "36", "37", "41",
            "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65", "71",
            "81", "82", "91"
        )
        val CHECK_CODES = arrayOf(
            "1", "0", "X", "9", "8", "7", "6", "5", "4",
            "3", "2"
        )
        val BIT_POWERS = arrayOf(
            "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
            "9", "10", "5", "8", "4", "2"
        )
    }
}