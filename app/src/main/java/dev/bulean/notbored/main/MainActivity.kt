package dev.bulean.notbored.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import dev.bulean.notbored.R
import dev.bulean.notbored.activities.ActivitiesActivity
import dev.bulean.notbored.activities.TermsConditionsActivity
import dev.bulean.notbored.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val participants: String = binding.etParticipants.text.toString()
            when {
                !binding.checkTermsConditions.isChecked -> checkTermsConditions()
                participants.isEmpty() -> equalZero()
                participants.toInt() == 0 -> equalZero()
                participants.toInt() > 8 -> errorService()
                participants.toInt() >= 1 -> navigateToActivities(participants.toInt())
            }
        }

        binding.tvTermsAndConditions.setOnClickListener {
            startActivity(Intent(this, TermsConditionsActivity::class.java))
        }

    }

    private fun navigateToActivities(participants: Int) {
        val intent = Intent(this, ActivitiesActivity::class.java)
        intent.putExtra("participants", participants)
        startActivity(intent)
    }

    private fun errorService() {
        Snackbar.make(binding.root, R.string.errorservice_by_participants, Snackbar.LENGTH_SHORT).show()
    }

    private fun equalZero() {
        Snackbar.make(binding.root, getString(R.string.please_put_number), Snackbar.LENGTH_SHORT).show()
    }

    private fun checkTermsConditions() {
        Snackbar.make(binding.root, getString(R.string.accept_terms_conditions), Snackbar.LENGTH_SHORT).show()
    }

}