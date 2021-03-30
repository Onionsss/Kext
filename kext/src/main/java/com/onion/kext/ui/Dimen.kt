package com.onion.kext.ui

import android.content.res.Resources
import android.util.TypedValue

/**
 * Copyright (C), 2019-2020, 游加科技
 * FileName: Dimen
 * Author: EDZ by 张琦
 * Date: 2020/9/10 13:54
 * Description:
 */
val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )

val Int.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )

val String.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )