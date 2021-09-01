package me.bytebeats.generator

import java.util.*
import kotlin.random.Random

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/9/1 20:32
 * @Version 1.0
 * @Description TO-DO
 */

abstract class GenericGenerator {
    protected val random: Random
        get() = Random(Date().time)

    abstract fun generate(): String
}