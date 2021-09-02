package me.bytebeats.generator.impl

import java.io.File
import java.nio.charset.Charset

/**
 * @Author bytebeats
 * @Email <happychinapc@gmail.com>
 * @Github https://github.com/bytebeats
 * @Created on 2021/9/2 11:43
 * @Version 1.0
 * @Description Write CSV data to file
 */

class CSVFileGenerator {
    companion object CSVFileGenerator {
        fun generate(data: List<Map<String, Any>>, columns: Array<String>, fileName: String) {
            val file = File(fileName)
            if (file.exists()) {
                file.delete()
            }
            for (map in data) {
                val lists = mutableListOf<String>()
                for (column in columns) {
                    lists.add(map[column]?.toString() ?: "")
                }
                val lineData = lists.filter { !it.isNullOrBlank() }
                    .joinToString(separator = ",", postfix = System.getProperty("line.separator") ?: "")
                file.writeText(lineData, Charset.forName("utf-8"))
            }
        }
    }
}