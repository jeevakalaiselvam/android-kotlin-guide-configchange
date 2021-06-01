package com.gamerguide.android.starterapp

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import com.gamerguide.android.starterapp.helpers.BlurHelper
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.gamerguide.android.starterapp.databinding.ActivityMainBinding
import io.github.inflationx.viewpump.ViewPump
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.calligraphy3.CalligraphyConfig

class MainActivity : AppCompatActivity() {
    private var background: ImageView? = null
    private var blurHelper: BlurHelper? = null

    private lateinit var binding: ActivityMainBinding

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/sourcesanspro.ttf")
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        blurHelper = BlurHelper()
        background = findViewById(R.id.background)
        blurHelper!!.setupImageBlurBackground(this, background!!)

        binding.title.text = "Application Title"
    }

}