package FloHealthApp.com

import FloHealthApp.com.databinding.ActivityLogInBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ActivityLogIn : AppCompatActivity() {

    lateinit var binding: ActivityLogInBinding

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
    }

    fun validateLogIn(){
        val userName = binding.etUserName.text.toString()
        val password = binding.etPassword.text.toString()

        var error = false

        if (userName.isEmpty()){
            binding.tilUserName.error = "Please input your user name"
            error = true
        }
        if (password.isEmpty()){
            binding.tilPassword.error = "Please input your password"
            error = true
        }
        if(!error){
            Toast.makeText(this, "You've logged In Successfully", Toast.LENGTH_SHORT).show()
            finish()
            val intent = Intent(this, ActivityHome::class.java)
            startActivity(intent)
        }
    }

    fun clearLogInErrors(){
        binding.tilUserName.error = null
        binding.tilPassword.error = null
    }
}