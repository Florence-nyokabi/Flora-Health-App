package FloHealthApp.com

import FloHealthApp.com.databinding.ActivityPersonalInformationBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PersonalInformation : AppCompatActivity() {

    lateinit var binding: ActivityPersonalInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPersonalInformationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        setContentView(binding.root)


        binding.btnNext.setOnClickListener {
            clearErrors()
            validatePersonalInformationForm()
            val intent = Intent(this, ActivityHome::class.java)
            startActivity(intent)
        }
    }

    fun validatePersonalInformationForm(){
        val age  = binding.etAge.text.toString()
        val weight = binding.etWeight.text.toString()
        val height = binding.etHeight.text.toString()
        val bloodgroup = binding.etBloodGroup.text.toString()
        val lastperiodsdate = binding.etLastPeriodsDate.text.toString()
        val cyclelength = binding.etCycleLength.text.toString()
        val periodsdays = binding.etPeriodsDays.text.toString()

        var error = false

        if (age.isEmpty()){
           binding.tilAge.error = "Please input age"
           error = true
        }

        if (weight.isEmpty()){
            binding.tilWeight.error = "Please input weight"
            error = true
        }
        if (height.isEmpty()){
            binding.tilHeight.error = "Please input height"
            error = true
        }
        if( bloodgroup.isEmpty()){
            binding.tilBloodGroup.error = "Please enter your blood group"
            error = true
        }
        if (lastperiodsdate.isEmpty()){
            binding.tilLastPeriodsDate.error = "PLease enter your last periods date"
            error = true
        }
        if (cyclelength.isEmpty()){
            binding.tilCycleLength.error = "Please enter your cycle length"
            error = true
        }
        if (periodsdays.isEmpty()){
            binding.tilPeriodsDays.error = "PLease enter you periods duration"
            error = true
        }
    }
    fun clearErrors(){
        binding.tilAge.error = null
        binding.tilCycleLength.error = null
        binding.tilPeriodsDays.error = null
        binding.tilHeight.error = null
        binding.tilWeight.error = null
        binding.tilBloodGroup.error = null
        binding.tilLastPeriodsDate.error = null
    }


}
