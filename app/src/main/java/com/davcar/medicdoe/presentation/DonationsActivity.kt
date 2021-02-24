package com.davcar.medicdoe.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.davcar.medicdoe.R
import com.davcar.medicdoe.databinding.ActivityDonationsBinding
import com.davcar.medicdoe.domain.Donation
import com.davcar.medicdoe.presentation.adapter.DonationsAdapter
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.orhanobut.hawk.Hawk

class DonationsActivity : AppCompatActivity() {

    companion object {
        const val DISPLAY_DONATIONS_CONTENT = 0
        const val DISPLAY_DONATIONS_EMPTY = 1
    }

    private val donations by lazy {
        Gson().fromJson<List<Donation>>(
            Hawk.get("donations", "[]"),
            object : TypeToken<List<Donation>>(){}.type
        ).toMutableList()
    }

    private val viewBinder by lazy {
        ActivityDonationsBinding.inflate(layoutInflater)
    }

    private val donationsAdapter by lazy {
        DonationsAdapter(this, donations)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinder.root)

        viewBinder.donationsRv.adapter = donationsAdapter

        viewBinder.arrowBack.setOnClickListener {
            finish()
        }

        viewBinder.tabLayout.addOnTabSelectedListener (object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab?.position == 0) {
                    viewBinder.donationsFlipper.displayedChild = DISPLAY_DONATIONS_CONTENT
                }
                else {
                    viewBinder.donationsFlipper.displayedChild = DISPLAY_DONATIONS_EMPTY
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}