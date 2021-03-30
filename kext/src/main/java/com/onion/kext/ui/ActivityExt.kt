package com.onion.kext.ui

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Bitmap
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager

/**
 * Copyright (C), 2019-2020, 里德软件
 * FileName: ActivityExt
 * Author: Administrator by 张琦
 * Date: 2020/8/8 0008 20:54
 * Description:
 */
// 屏幕宽度（像素）
fun Activity.getWidth(): Int {
    val metric = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metric)
    return metric.widthPixels
}

// 屏幕高度（像素）
fun Activity.getHeight(): Int {
    val metric = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metric)
    return metric.heightPixels
}

/**
 * 屏幕截图
 */
fun Activity.screenShot(activity: Activity, isDeleteStatusBar: Boolean = true): Bitmap {
    val decorView = activity.window.decorView
    decorView.isDrawingCacheEnabled = true
    decorView.buildDrawingCache()
    val bmp = decorView.drawingCache
    val dm = DisplayMetrics()
    activity.windowManager.defaultDisplay.getMetrics(dm)
    var ret: Bitmap? = null
    if (isDeleteStatusBar) {
        val resources = activity.resources
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        val statusBarHeight = resources.getDimensionPixelSize(resourceId)
        ret = Bitmap.createBitmap(bmp, 0, statusBarHeight, dm.widthPixels, dm.heightPixels - statusBarHeight)
    } else {
        ret = Bitmap.createBitmap(bmp, 0, 0, dm.widthPixels, dm.heightPixels)
    }
    decorView.destroyDrawingCache()
    return ret!!
}

/**
 * 是否竖屏
 */
fun Activity.isPortrait(): Boolean {
    return resources.configuration.orientation === Configuration.ORIENTATION_PORTRAIT
}

/**
 * 是否横屏
 */
fun Activity.isLandscape(): Boolean {
    return resources.configuration.orientation === Configuration.ORIENTATION_LANDSCAPE
}


/**
 * 设置竖屏
 */
fun Activity.setPortrait() {
    this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}

/**
 * 设置横屏
 */
fun Activity.setLandscape() {
    this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
}

/**
 * 设置全屏
 */
fun Activity.setFullScreen() {
    this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
}

/**
 * 显示软键盘
 */
fun Activity.showKeyboard() {
    var imm: InputMethodManager = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        ?: return
    var view = this.currentFocus
    if (view == null) {
        view = View(this)
        view!!.isFocusable = true
        view!!.isFocusableInTouchMode = true
        view!!.requestFocus()
    }
    imm.showSoftInput(view, InputMethodManager.SHOW_FORCED)
}

/**
 * 隐藏软键盘
 */
fun Activity.hideKeyboard() {
    var imm: InputMethodManager = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        ?: return
    var view = this.currentFocus
    if (view == null) {
        view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}