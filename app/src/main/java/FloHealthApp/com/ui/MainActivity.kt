package FloHealthApp.com.ui

import FloHealthApp.com.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
            Picasso
                .get()
                .load("https://res.cloudinary.com/dyxt6pqtx/image/upload/v1689856402/Android_Large_-_2_4_tziezo.jpg")
                .fit()
                .centerCrop()
                .into(binding.backgroundImageView)

        binding.btnGetStarted.setOnClickListener {
            val intent = Intent(this, ActivitySignUp::class.java)
            startActivity(intent)
        }
    }
}

