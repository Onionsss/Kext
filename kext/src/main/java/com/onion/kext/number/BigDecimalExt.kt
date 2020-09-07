package com.onion.kext.number

import java.math.BigDecimal
import java.text.DecimalFormat

/**
 * Copyright (C), 2019-2020, 里德软件
 * FileName: BigDecimalExt
 * Author: OnionMac by 张琦
 * Date: 2020/8/13 13:43
 * Description:
 */

/**
 * 保留两个小数点
 */
fun Double.m2(): String {
    val df = DecimalFormat("#.00")
    val d = df.format(this)
    return when {
        d == ".00" -> "0.00"
        d.substring(0, 1) == "." -> "0$d"
        else -> d
    }
}

fun String.m2(): String{
    val format = DecimalFormat("0.00")
    return format.format(BigDecimal(this))
}

fun Float.m2(): String{
    val format = DecimalFormat("0.00")
    return format.format(BigDecimal("$this"))
}

fun BigDecimal.m2(): String{
    val format = DecimalFormat("0.00")
    return format.format(this)
}