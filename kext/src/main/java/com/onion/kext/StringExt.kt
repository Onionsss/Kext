package com.onion.kext
import java.text.SimpleDateFormat
import java.util.*

/**
 * Copyright (C), 2019-2019, 里德软件
 * FileName: StringExt
 * Author: OnionMac by 张琦
 * Date: 2019/4/25 10:08 AM
 * Description: 字符串扩展
 */

fun String.toDate(): String{
    val date = Date(toLong())
    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.format(date)
}

fun String.toStamp(): Long{
    if(isEmpty()){
        return 0
    }

    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.parse(this).time
}

fun String.toDateM(): String{
    val date = Date(toLong() * 1000)
    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.format(date)
}

fun String.toDateMM(): String{
    val date = Date(toLong() * 1000)
    val format = SimpleDateFormat("yyyy-MM-dd hh:mm ")
    return format.format(date)
}

fun String.toStampM(): Long{
    if(isEmpty()){
        return 0
    }

    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.parse(this).time / 1000
}
