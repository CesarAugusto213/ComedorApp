package com.ecoservicios.comedorapp.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ecoservicios.comedorapp.data.local.database.entities.CampusEntity
import com.ecoservicios.comedorapp.data.viewModel.CampusViewModel
import com.ecoservicios.comedorapp.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<CampusViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {

        val campus = CampusEntity("A002", "TACNA", "TACNA")
        lifecycleScope.launch {
            viewModel.insertCampus(campus)
            Toast.makeText(this@LoginActivity,"Entre", Toast.LENGTH_SHORT).show()
        }
    }

}