package com.example.googleplay

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.googleplay.databinding.ItemMenuBinding

class MenuInnerAdapter : RecyclerView.Adapter<MenuInnerAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(private val binding: ItemMenuBinding) : ViewHolder(binding.root) {
        fun bind(menu: Menu) {
            binding.apply {
                menuTvName.text = menu.name1
            }
        }
    }

    var models = listOf<Menu>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        val binding = ItemMenuBinding.bind(view)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(models[position])
    }
}
