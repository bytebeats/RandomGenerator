package me.bytebeats.generator.impl

import me.bytebeats.generator.ChineseCharHelper
import me.bytebeats.generator.GenericGenerator
import me.bytebeats.generator.provinceCityList

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/9/1 21:27
 * @Version 1.0
 * @Description TO-DO
 */

class ChineseAddressGenerator: GenericGenerator() {
    override fun generate(): String {
        val provinceCity = provinceCityList[random.nextInt(provinceCityList.size)]
        val road = ChineseCharHelper.instance().randomChineseCharsWithSizeBetween(2,3)
        val roadNo = random.nextInt(1, 800)
        val community = ChineseCharHelper.instance().randomChineseCharsWithSizeBetween(2,5)
        val unit = random.nextInt(1,100)
        val room = random.nextInt(101, 2500)
        return "$provinceCity${road}路${roadNo}号${community}小区${unit}单元${room}室"
    }
}