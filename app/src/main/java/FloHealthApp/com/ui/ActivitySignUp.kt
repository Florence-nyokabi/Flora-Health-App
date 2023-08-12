package FloHealthApp.com.ui

import FloHealthApp.com.databinding.ActivitySignUpBinding
import FloHealthApp.com.model.RegisterRequest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels

class ActivitySignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            clearErrors()
            validateSignUp()
        }
        userViewModel.errLiveData.observe(this) { err ->
            Toast.makeText(this, err, Toast.LENGTH_SHORT).show()

        }
        userViewModel.regLiveData.observe(this) { regResponse ->
            Toast.makeText(this, regResponse.message, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ActivityLogIn::class.java))
        }

        binding.btnLogIn.setOnClickListener {
            val intent = Intent(this, ActivityLogIn::class.java)
            startActivity(intent)
        }
    }

    fun validateSignUp() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val emailAddress = binding.etEmailAddress.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val createPassword = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()

        var error = false

        if (firstName.isBlank()) {
            binding.tilFirstName.error = "Please input first name"
            error = true
        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "Please input last name"
            error = true
        }
        if (emailAddress.isBlank()) {
            binding.tilEmailAddress.error = "Please input email address"
            error = true
        }
        if (phoneNumber.isEmpty()) {
            binding.tilPhoneNumber.error = "Please input phone number"
            error = true
        }
        if (createPassword.isBlank()) {
            binding.tilPassword.error = "Please create password"
            error = true
        }
        if (confirmPassword.isBlank()) {
            binding.tilConfirmPassword.error = "Please confirm password created"
            error = true
        }
        if (createPassword.length < 8 && createPassword.length > 12) {
            binding.tilPassword.error = "Password must be 8 to 12 characters long"
            error = true
        }

        if (createPassword != confirmPassword) {
            binding.tilConfirmPassword.error = "Password and confirmation do not match."
            error = true
        }
        if (!error) {
            val registerRequest = RegisterRequest(
                firstName = firstName,
                lastName = lastName,
                email = emailAddress,
                password = createPassword,
                phoneNumber = phoneNumber
            )
        }
        fun clearErrors() {
            binding.tilFirstName.error = null
            binding.tilLastName.error = null
            binding.tilEmailAddress.error = null
            binding.tilPhoneNumber.error = null
            binding.tilPassword.error = null
            binding.tilConfirmPassword.error = null

        }
    }
}