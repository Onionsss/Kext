package com.onion.kext

import android.app.Application
import com.onion.kext.Kext.app

object Kext {

    @JvmStatic
    var app: Application? = null

    @JvmStatic
    fun init(app: Application){
        this.app = app
    }
}

fun getApp(): Application {
    return app!!
}