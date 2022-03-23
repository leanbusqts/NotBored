package dev.bulean.notbored.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.bulean.notbored.data.ActivitiesApiService
import dev.bulean.notbored.data.retrofit
import dev.bulean.notbored.databinding.ActivityDescriptionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DescriptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val type = intent.getStringExtra("type")
        val participants = intent.getIntExtra("participants", 0)

        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofit.create(ActivitiesApiService::class.java).getActivities(
                "activity?participants=$participants&type=$type")
            val activity = call.body()
            runOnUiThread {
                if(call.isSuccessful){
                    binding.tvTitle.text = activity?.activity ?: ""
                    binding.tvParticipants.text = activity?.participants.toString()
                    binding.tvPrice.text = activity?.price.toString()
                }
            }
        }

    }
}