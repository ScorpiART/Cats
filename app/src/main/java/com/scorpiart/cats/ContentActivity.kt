package com.scorpiart.cats

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.scorpiart.cats.databinding.ContentLayoutBinding


class ContentActivity: AppCompatActivity() {

    lateinit var bindingClass : ContentLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ContentLayoutBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        bindingClass.tvTitle.text = intent.getStringExtra("title")
        bindingClass.tvContent.text = intent.getStringExtra("content")
        bindingClass.im.setImageResource(intent.getIntExtra("image",
            R.drawable.ic_launcher_background))
    }



}