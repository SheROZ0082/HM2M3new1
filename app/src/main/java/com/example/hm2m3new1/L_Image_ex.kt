package com.example.hm2m3new1

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.gallery.R

fun View.loadImage(url:String){
    Glide.with(this).load(url).placeholder(R.drawable.ic_launcher_background).centerCrop().into(this as ImageView)}