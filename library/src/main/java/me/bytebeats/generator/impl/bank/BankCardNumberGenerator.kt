package me.bytebeats.generator.impl.bank

import me.bytebeats.generator.GenericGenerator
import java.util.*
import kotlin.random.Random

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/9/2 11:27
 * @Version 1.0
 * @Description TO-DO
 */

class BankCardNumberGenerator : GenericGenerator() {
    override fun generate(): String {
        val prefix = 622126 + random.nextInt(925 + 1 - 126)
        return generateByPrefix(prefix)
    }

    private fun generateByPrefix(prefix: Int): String {
        val next9Digits = random.nextInt(100000000).toString().padStart(9, '0')
        val cardNumber = "$prefix$next9Digits"
        val chs = cardNumber.toCharArray()
        var luhn = 0
        var j = 0
        for (i in chs.lastIndex downTo 0) {
            var k = chs[i] - '0'
            if (j and 1 == 0) {
                k *= 2
                k = k / 10 + k % 10
            }
            luhn += k
            j++
        }
        val checkCode = if (luhn % 10 == 0) '0' else '0' + (10 - luhn % 10)
        return "$cardNumber$checkCode"
    }

    companion object {
        fun generate(bankInfo: BankInfo, cardType: BankCardType?): String {
            val candidatePrefixes = if (cardType == BankCardType.DEBIT) {
                bankInfo.debtCardPrefixes
            } else if (cardType == BankCardType.CREDIT) {
                bankInfo.debtCardPrefixes
            } else {
                bankInfo.allCardPrefixes
            }
            return if (candidatePrefixes?.isNotEmpty() == true) {
                BankCardNumberGenerator().generateByPrefix(
                    candidatePrefixes[Random(Date().time).nextInt(
                        candidatePrefixes.size
                    )]
                )
            } else {
                throw IllegalArgumentException("没有该银行的相关卡号信息")
            }
        }
    }

}