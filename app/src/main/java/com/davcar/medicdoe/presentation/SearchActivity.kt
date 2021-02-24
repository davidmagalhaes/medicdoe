package com.davcar.medicdoe.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davcar.medicdoe.R
import com.davcar.medicdoe.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private val viewBinders by lazy {
        ActivitySearchBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinders.root)

        viewBinders.arrowBack.setOnClickListener {
            finish()
        }
    }
}