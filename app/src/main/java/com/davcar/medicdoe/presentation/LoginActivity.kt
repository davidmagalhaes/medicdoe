package com.davcar.medicdoe.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davcar.medicdoe.R
import com.davcar.medicdoe.databinding.ActivityLoginBinding
import com.davcar.medicdoe.databinding.ActivitySearchBinding
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {

    private val viewBinders by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinders.root)

        viewBinders.button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}