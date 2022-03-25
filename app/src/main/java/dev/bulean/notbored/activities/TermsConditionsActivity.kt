package dev.bulean.notbored.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.bulean.notbored.R
import dev.bulean.notbored.databinding.ActivityActivitiesBinding
import dev.bulean.notbored.databinding.ActivityTermsConditionsBinding

class TermsConditionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTermsConditionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsConditionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibExitTermsConditions.setOnClickListener { finish() }

    }
}