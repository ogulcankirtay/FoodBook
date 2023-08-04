package com.ogulcankirtay.besinlerkitab.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ogulcankirtay.besinlerkitab.R
import com.ogulcankirtay.besinlerkitab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}