package com.ecoservicios.comedorapp.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ecoservicios.comedorapp.data.local.database.entities.CampusEntity
import com.ecoservicios.comedorapp.data.local.database.entities.UserEntity
import com.ecoservicios.comedorapp.databinding.ActivityLoginBinding
import com.ecoservicios.comedorapp.ui.main.MainActivity
import com.ecoservicios.comedorapp.util.Extension
import com.ecoservicios.comedorapp.util.launchAndCollect
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
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDataMock()
        setupViewModelObservers()
        setupView()
    }

    private fun initDataMock() {
        val campus = CampusEntity("A002", "TACNA", "TACNA")
        val user = UserEntity(
            id = "USER1",
            user = "cesar",
            password = "created",
            idCampus = "A002",
            dateRegion = Extension.getCurrentDate()
        )
        lifecycleScope.launch {
            viewModel.insertCampus(campus)
            viewModel.insertUser(user)
        }
    }

    private fun setupViewModelObservers() {
        launchAndCollect(viewModel.stateUser) { state ->
            state.user?.let {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                //Borrar
                Log.d("Login", it.toString())
                MainActivity.start(this@LoginActivity)
            }
        }
    }

    private fun setupView() {

        with(binding) {
            val user = this.inputUserLogin.text
            val password = this.inputPasswordLogin.text

            btnLogin.setOnClickListener {
                lifecycleScope.launch {
                    val responseCampus = viewModel.getCampus()
                    viewModel.searchUserToLogIn(user.toString(), password.toString())
                    viewModel.getUsers()
                    val x = viewModel.stateUser.value.listUser

                    Log.d("Logins", x.toString())
                    //Borrar
                    Log.d("Login", responseCampus.toString())
                }
            }

        }

    }

}