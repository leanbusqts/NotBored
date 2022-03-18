 package dev.bulean.notbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import dev.bulean.notbored.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnStart.setOnClickListener {
            val participants = binding.etParticipants.text.toString()
            if (participants.toInt() >= 1) {
                // TODO ("otro activity")
            }

        }


    }
}