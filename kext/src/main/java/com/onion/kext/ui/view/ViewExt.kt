package com.onion.kext.ui.view

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Checkable
import android.widget.EditText
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

