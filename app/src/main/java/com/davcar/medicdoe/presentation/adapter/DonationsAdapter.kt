package com.davcar.medicdoe.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ViewFlipper
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.davcar.medicdoe.R
import com.davcar.medicdoe.domain.Donation

class DonationsAdapter(
    private val context : Context,
    val donations : MutableList<Donation>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return object : RecyclerView.ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.donation_item, parent, false)
        ) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val donation = donations[position]
        val nameTxt = holder.itemView.findViewById<AppCompatTextView>(R.id.textView5)

        nameTxt.text = donation.name
    }

    override fun getItemCount(): Int {
        return donations.size
    }
}