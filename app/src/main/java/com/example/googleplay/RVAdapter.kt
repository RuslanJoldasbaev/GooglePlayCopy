package com.example.googleplay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.googleplay.databinding.ItemAd2Binding
import com.example.googleplay.databinding.ItemRvBinding

class RVAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val AD1 = 0
        private const val MENU = 1
        private const val AD2 = 2
    }

    var models = listOf<Item>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class RVViewHolder(private val binding: ItemRvBinding): ViewHolder(binding.root) {
        fun bind(rvItem: RVItem) {
            val adInnerAdapter1 = AdInnerAdapter1()
            binding.innerRecyclerView.adapter = adInnerAdapter1

            adInnerAdapter1.models = rvItem.items
        }
    }

    inner class RVViewHolder2(private val binding: ItemRvBinding): ViewHolder(binding.root) {
        fun bind(rvItem2: RVItem2) {
            val menuInnerAdapter = MenuInnerAdapter()
            binding.apply {
                binding.innerRecyclerView.adapter = menuInnerAdapter
            }
            menuInnerAdapter.models = rvItem2.items
        }
    }

    inner class AdViewHolder(private val binding: ItemAd2Binding) : ViewHolder(binding.root) {
        fun bind(ad: Ad2) {
            binding.apply {
                image.setImageResource(ad.image)
                ad2TvName.text = ad.name
                ad2TvDescription.text = ad.description
                ad2TvAdd.text = ad.add
            }
        }
    }

    override fun getItemCount(): Int = models.size

    override fun getItemViewType(position: Int): Int {
        return if (models[position] is RVItem) {
            AD1
        } else if(models[position] is RVItem2) {
            MENU
        } else {
            AD2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            AD1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
                val binding = ItemRvBinding.bind(view)
                RVViewHolder(binding)
            }
            MENU -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
                val binding = ItemRvBinding.bind(view)
                RVViewHolder2(binding)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ad2, parent, false)
                val binding = ItemAd2Binding.bind(view)
                AdViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            AD1 -> {
                (holder as RVViewHolder).bind(models[position] as RVItem)
            }
            MENU -> {
                (holder as RVViewHolder2).bind(models[position] as RVItem2)
            }
            AD2 -> {
                (holder as AdViewHolder).bind(models[position] as Ad2)
            }
        }
    }
}
