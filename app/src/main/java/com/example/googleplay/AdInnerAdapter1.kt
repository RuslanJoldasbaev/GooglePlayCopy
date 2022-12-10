package com.example.googleplay

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.googleplay.databinding.ItemAd1Binding

class AdInnerAdapter1: RecyclerView.Adapter<AdInnerAdapter1.AdViewHolder1>() {

    inner class AdViewHolder1(private val binding: ItemAd1Binding): ViewHolder(binding.root) {
        fun bind(ad1: Ad1) {
            binding.apply {
                ad1Image.setImageResource(ad1.image)
                ad1Image2.setImageResource(ad1.image2)
                ad1TvName.text = ad1.name
                ad1TvDescription.text = ad1.description
            }
        }
    }

    var models = listOf<Ad1>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdViewHolder1 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ad1, parent, false)
        val binding = ItemAd1Binding.bind(view)
        return AdViewHolder1(binding)
    }

    override fun onBindViewHolder(holder: AdViewHolder1, position: Int) {
        holder.bind(models[position])
    }
}
