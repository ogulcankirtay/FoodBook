package com.ogulcankirtay.besinlerkitab.data.util.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:LoadImage")
fun ImageView.downlandImage(url:String){
    Picasso.get().load(url).into(this)
}