package com.vaibhav.shoppingapp.activity

import android.content.Intent
import android.os.Bundle
import com.vaibhav.shoppingapp.databinding.ActivityIntroBinding

class IntroActivity :BaseActivity(){
    private lateinit var binding:ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
            finish()
        }
    }
}