package com.onion.kext.ui.view

import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.widget.TextView
import org.json.JSONObject

/**
 * Copyright (C), 2019-2020, 里德软件
 * FileName: TextViewExt
 * Author: OnionMac by 张琦
 * Date: 2020/8/12 15:41
 * Description:
 */
/**
 * 定义不同的尺寸
 * text: 文本内容
 * startPos: 开始
 * endPos: 结束
 * sizes: 字体大小 不是dp
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

/**
 * 首字母小写
 */
fun TextView.firstLower(text: String?,sizes: Array<Int>){
    if(text != null && text.length > 0){
        diffSize(text, arrayOf(0,1), arrayOf(1,text.length),sizes)
    }
}

/**
 * 设置空
 */
fun TextView.empty(){
    this.text = ""
}

fun TextView.setDrawableLeft(resId: Int) {
    val drawable = this.context.resources.getDrawable(resId)
    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    this.setCompoundDrawables(drawable, null, null, null)
}

fun TextView.setDrawableRight(resId: Int) {
    val drawable = this.context.resources.getDrawable(resId)
    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    this.setCompoundDrawables(null, null, drawable, null)
}

fun TextView.setDrawableTop(resId: Int) {
    val drawable = this.context.resources.getDrawable(resId)
    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    this.setCompoundDrawables(null, drawable, null, null)
}

fun TextView.setDrawableBottom(resId: Int) {
    val drawable = this.context.resources.getDrawable(resId)
    drawable.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    this.setCompoundDrawables(null, null, null, drawable)
}
