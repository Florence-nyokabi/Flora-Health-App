package FloHealthApp.com.ui

import FloHealthApp.com.ViewModel.LoginUserViewModel
import FloHealthApp.com.databinding.ActivityLogInBinding
import FloHealthApp.com.model.LoginRequest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class ActivityLogIn : AppCompatActivity() {

    lateinit var binding: ActivityLogInBinding
    val loginUserViewModel: LoginUserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityLogInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)

        binding.btnLoggingIn.setOnClickListener {
            clearLogInErrors()
            validateLogIn()
        }
        loginUserViewModel.errLiveData.observe(this, Observer { err->
            Toast.makeText(this, err, Toast.LENGTH_SHORT).show()
            binding.pbLogin.visibility = View.GONE
        })

        loginUserViewModel.regLiveData.observe(this, Observer { logResponse->
            binding.pbLogin.visibility = View.GONE
            Toast.makeText(this, logResponse.message,Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityHome::class.java))
            finish()
        })
    }

    fun validateLogIn(){
        val emailAddress = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        var error = false

        if (emailAddress.isBlank()){
            binding.tilEmail.error = "Please input user name"
            error = true
        }
        if (password.isBlank()){
            binding.tilPassword.error = "Please input password"
            error = true
        }
        if(!error){
            val loginRequest = LoginRequest(
                email = emailAddress,
                password = password
            )
            binding.pbLogin.visibility = View.VISIBLE
            loginUserViewModel.loginUser(loginRequest)
        }
    }

    fun clearLogInErrors(){
        binding.tilEmail.error = null
        binding.tilPassword.error = null
    }
}