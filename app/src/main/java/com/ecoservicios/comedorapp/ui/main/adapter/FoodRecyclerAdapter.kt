package com.ecoservicios.comedorapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecoservicios.comedorapp.databinding.ItemFoodBinding
import com.ecoservicios.comedorapp.ui.main.model.Food

class FoodRecyclerAdapter(private val listFood: List<Food>) :
    RecyclerView.Adapter<FoodRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(food: Food) {
            with(binding) {
                imgFood.setImageResource(food.img)
                titleFood.text = food.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFoodBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listFood.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = listFood[position]
        holder.bind(food)
    }

}