 package dev.bulean.notbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.bulean.notbored.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val participants = binding.etParticipants.text.toString()
            if (participants.isNotEmpty() && participants.toInt() >= 1) {
                startActivity(Intent(this, ActivitiesActivity::class.java))
            }
        }

        binding.tvTermsAndConditions.setOnClickListener {
            startActivity(Intent(this, TermsConditionsActivity::class.java))
        }

    }
}