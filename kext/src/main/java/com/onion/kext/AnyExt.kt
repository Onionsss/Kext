package com.onion.kext

/**
 * Copyright (C), 2021-2021, 游加科技
 * FileName: AnyExt
 * Author: EDZ by 张琦
 * Date: 2021/1/28 9:49
 * Description:
 */

inline fun <reified T> T?.notNull(notNullAction: (T) -> Unit, nullAction: () -> Unit = {}) {
    if (this != null) {
        notNullAction.invoke(this)
    } else {
        nullAction.invoke()
    }
}