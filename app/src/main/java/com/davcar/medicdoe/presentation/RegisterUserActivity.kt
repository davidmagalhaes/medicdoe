package com.davcar.medicdoe.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davcar.medicdoe.R
import com.davcar.medicdoe.databinding.ActivityDonateBinding
import com.davcar.medicdoe.databinding.ActivityRegisterUserBinding

class RegisterUserActivity : AppCompatActivity() {

    private val viewBinder by lazy {
        ActivityRegisterUserBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinder.root)

        viewBinder.arrowBack.setOnClickListener {
            finish()
        }
    }
}