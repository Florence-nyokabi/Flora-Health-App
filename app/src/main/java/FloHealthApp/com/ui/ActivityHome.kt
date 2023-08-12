package FloHealthApp.com.ui

import FloHealthApp.com.databinding.ActivityHomeBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityHome : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}