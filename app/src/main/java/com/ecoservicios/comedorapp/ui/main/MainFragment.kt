package com.ecoservicios.comedorapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ecoservicios.comedorapp.R
import com.ecoservicios.comedorapp.databinding.FragmentMainBinding
import com.ecoservicios.comedorapp.ui.main.adapter.CountRecyclerAdapter
import com.ecoservicios.comedorapp.ui.main.adapter.FoodRecyclerAdapter
import com.ecoservicios.comedorapp.ui.main.model.Count
import com.ecoservicios.comedorapp.ui.main.model.Food

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var listFood: List<Food>
    private lateinit var listCount: List<Count>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        setupView()
        return binding.root
    }

    private fun setupView() {
        initListFoodAndListCount()
        setupAdapterFood()
        setupAdapterCount()
    }

    private fun initListFoodAndListCount() {
        listFood = listOf(
            Food(R.drawable.breakfast, getString(R.string.breakfast)),
            Food(R.drawable.lunch, getString(R.string.launch)),
            Food(R.drawable.dinner, getString(R.string.dinner))
        )

        listCount = listOf(
            Count("12", "21", "41")
        )
    }

    private fun setupAdapterFood() {
        val adapter = FoodRecyclerAdapter(listFood)
        binding.recyclerFood.adapter = adapter
    }

    private fun setupAdapterCount() {
        val adapter = CountRecyclerAdapter(listCount)
        binding.recyclerCount.adapter = adapter
    }

}