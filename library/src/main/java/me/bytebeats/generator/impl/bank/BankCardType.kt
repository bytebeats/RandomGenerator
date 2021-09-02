package me.bytebeats.generator.impl.bank

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/9/2 11:24
 * @Version 1.0
 * @Description 枚举类: 银行卡类型
 */

enum class BankCardType(val fullName: String) {
    /**
     * 借记卡/储蓄卡
     */
    DEBIT("借记卡/储蓄卡"),

    /**
     * 信用卡/贷记卡
     */
    CREDIT("信用卡/贷记卡");
}