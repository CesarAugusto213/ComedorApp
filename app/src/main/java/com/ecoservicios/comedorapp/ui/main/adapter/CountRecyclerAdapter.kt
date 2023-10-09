package com.ecoservicios.comedorapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecoservicios.comedorapp.databinding.ItemCountBinding
import com.ecoservicios.comedorapp.ui.main.model.Count

class CountRecyclerAdapter(private val listCount: List<Count>) :
    RecyclerView.Adapter<CountRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCountBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(count: Count) {
            with(binding) {
                breakfast.text = count.breakfast
                launch.text = count.launch
                dinner.text = count.dinner
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCountBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listCount.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val count = listCount[position]
        holder.bind(count)
    }


}