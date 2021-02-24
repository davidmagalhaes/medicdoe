package com.davcar.medicdoe.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davcar.medicdoe.databinding.ActivityDonateBinding
import com.davcar.medicdoe.domain.Donation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.orhanobut.hawk.Hawk

class DonateActivity : AppCompatActivity() {

    private val viewBinder by lazy {
        ActivityDonateBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinder.root)

        viewBinder.arrowBack.setOnClickListener {
            finish()
        }

        viewBinder.donateBtn.setOnClickListener {
            val gson = Gson()
            val donationList = gson.fromJson<List<Donation>>(
                Hawk.get("donations", "[]"),
                object : TypeToken<List<Donation>>(){}.type
            ).toMutableList()

            donationList.add(Donation(
                codigoBarra = viewBinder.codigoBarra.text.toString(),
                name = viewBinder.nomeProduto.text.toString()
            ))

            Hawk.put("donations", gson.toJson(donationList))

            finish()
        }
    }
}