package com.onion.kext.ui.view

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Checkable
import android.widget.EditText
import android.widget.ProgressBar
import java.util.*

/**
 * Copyright (C), 2019-2020, 里德软件
 * FileName: ViewExt
 * Author: Administrator by 张琦
 * Date: 2020/8/8 0008 20:54
 * Description:
 */

/**
 * View
 */
fun View.gone(): View{
    this.visibility = View.GONE
    return this
}

fun View.show(): View{
    this.visibility = View.VISIBLE
    return this
}

fun View.hide(): View {
    this.visibility = View.INVISIBLE
    return this
}

fun View.click(){

}

fun Checkable.check(): Checkable{
    this.isChecked = true
    return this
}

fun Checkable.unCheck(): Checkable{
    this.isChecked = false
    return this
}


/**
 * editText
 */
fun EditText.toEnd(){
    val length = this.text.toString().length
    this.setSelection(length)
}

fun EditText.hideKeyBoard(ctx: Context){
    val imm: InputMethodManager =
        ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager;
    imm.hideSoftInputFromWindow(this.windowToken,0)
}

fun EditText.openKeyBoard(ctx: Context){

    isFocusable = true
    isFocusableInTouchMode = true
    requestFocus()
    val timer = Timer()
    timer.schedule(object: TimerTask(){
        override fun run() {
            val imm: InputMethodManager =
                ctx
                    .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(this@openKeyBoard,0)
            toEnd()
        }
    },200)
}

/**
 * webview
 * webview Setting
 */
fun WebView.setting(progressBar: ProgressBar){
    val settings = this.settings
    settings.javaScriptEnabled = true
    settings.domStorageEnabled = true
    settings.javaScriptCanOpenWindowsAutomatically = true
    settings.defaultTextEncodingName = "UTF-8"
    settings.setSupportZoom(false)
    settings.cacheMode = WebSettings.LOAD_NO_CACHE
    settings.pluginState = WebSettings.PluginState.ON
    this.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

    this.webChromeClient = object : WebChromeClient() {
        override fun onProgressChanged(view: WebView, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            if (newProgress == 100) {
                progressBar.visibility = View.GONE
            } else {
                progressBar.visibility = View.VISIBLE
                progressBar.progress = newProgress
            }
        }

    }

    this.webViewClient = object : WebViewClient() {
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
        }
    }
}