package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.github.ybq.android.spinkit.style.WanderingCubes
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

   private val splashTimeOut : Int = 4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val progressBar = findViewById<ProgressBar>(R.id.spin_kit)
        val wanderingCubes = WanderingCubes()
        progressBar.indeterminateDrawable = wanderingCubes

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)

            startActivity(intent)
            finish()
        }, splashTimeOut.toLong())
    }
}