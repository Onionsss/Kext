package com.onion.kext.ui.view

import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.widget.TextView

/**
 * Copyright (C), 2019-2020, 里德软件
 * FileName: TextViewExt
 * Author: OnionMac by 张琦
 * Date: 2020/8/12 15:41
 * Description:
 */

fun TextView.diffSize(text: String,startPos: Array<Int>,endPos: Array<Int>,sizes: Array<Int>){
    val span = SpannableString(text)
    if(startPos.size == endPos.size && endPos.size == sizes.size){
        startPos.forEachIndexed { index, i ->
            span.setSpan(AbsoluteSizeSpan(sizes[index]), startPos[index], endPos[index], Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        }
    }

    this.text = span
}

/**
 * 金额保留两位小数
 */
fun TextView.diffSizeM2(m2: String,sizes: Array<Int>){
    diffSize(m2,
            arrayOf(0,m2.length - 3),
            arrayOf(m2.length - 3,m2.length),
            sizes)
}