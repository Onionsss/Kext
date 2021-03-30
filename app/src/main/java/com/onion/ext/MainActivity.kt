package com.onion.ext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jaeger.library.StatusBarUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        StatusBarUtil.setTranslucentForImageView(this,0,null)
        StatusBarUtil.setLightMode(this)


    }
}
