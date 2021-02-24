package com.davcar.medicdoe.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davcar.medicdoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private val viewBinder by lazy {
		ActivityMainBinding.inflate(layoutInflater)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(viewBinder.root)

		viewBinder.searchOpt.setOnClickListener {
			startActivity(Intent(this, SearchActivity::class.java))
		}

		viewBinder.donateOpt.setOnClickListener {
			startActivity(Intent(this, DonateActivity::class.java))
		}

		viewBinder.donationsOpt.setOnClickListener {
			startActivity(Intent(this, DonationsActivity::class.java))
		}

		viewBinder.userOpt.setOnClickListener {
			startActivity(Intent(this, RegisterUserActivity::class.java))
		}

		viewBinder.shareOpt.setOnClickListener {
			//startActivity(Intent(this, ShareActivity::class.java))
		}

		viewBinder.logoutOpt.setOnClickListener {
			finish()
		}
	}
}