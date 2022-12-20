package com.example.cw61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.cw61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var list = mutableListOf<String>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillList()
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnSubmit.setOnClickListener {
                if(URLUtil.isValidUrl(etInput.text.toString()) && etInput.text.isNotEmpty()) {
                    list.add(etInput.text.toString())
                    etInput.text.clear()
                }else{
                    Toast.makeText(this@MainActivity,"You should input URL",Toast.LENGTH_SHORT).show()
                }
            }

            btnRandom.setOnClickListener {
                Glide.with(this@MainActivity).load(list.random()).into(ivImage)
            }
        }
    }

    private fun fillList() {
        list.add("https://i.natgeofe.com/k/63b1a8a7-0081-493e-8b53-81d01261ab5d/red-panda-full-body_4x3.jpg")
        list.add("https://media.wired.com/photos/593261cab8eb31692072f129/master/pass/85120553.jpg")
        list.add("https://aldf.org/wp-content/uploads/2018/05/lamb-iStock-665494268-16x9-e1559777676675-1200x675.jpg")
        list.add("https://a-z-animals.com/media/tiger_laying_hero_background.jpg")
        list.add("https://m3.healio.com/~/media/slack-news/infectious-disease/misc/infographics/2021/12_december/idn1221teres_graphic_01_web.jpg")
    }
}