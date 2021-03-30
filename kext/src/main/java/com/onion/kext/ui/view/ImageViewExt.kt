package com.onion.kext.ui.view

import android.view.ViewGroup
import android.widget.ImageView

/**
 * Copyright (C), 2021-2021, 游加科技
 * FileName: ImageViewExt
 * Author: EDZ by 张琦
 * Date: 2021/1/28 9:46
 * Description:
 */
/**
 * 设置图片的比例
 */
fun ImageView.setSize(width: Int, w: Float, h: Float){
    val height: Float = width / w * h
    val params = this.layoutParams as ViewGroup.MarginLayoutParams
    params.height = height.toInt()
    params.width = width
    this.layoutParams = params
}