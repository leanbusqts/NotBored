package dev.bulean.notbored.hint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.bulean.notbored.R
import dev.bulean.notbored.databinding.ActivityHintBinding

class HintActivity : AppCompatActivity() {

    private val viewModel by viewModels<SharedViewModel>()
    private lateinit var binding: ActivityHintBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHintBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.activities)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val type = intent.getStringExtra("type") ?: ""
        val participants = intent.getIntExtra("participants", 0)
        val isRandom = intent.getBooleanExtra("isRandom", false)


        binding.typeImage.visibility = if (isRandom) View.VISIBLE else View.INVISIBLE
        binding.typeTitle.visibility = if (isRandom) View.VISIBLE else View.INVISIBLE
        if (isRandom) binding.typeTitle.text = type

        viewModel.getActivityByParticipantsAndType(participants, type)

        viewModel.participantsValue.observe(this, Observer {
            binding.participantsValue.text = it.toString()
        })

        viewModel.priceValue.observe(this, Observer {
            binding.priceValue.text = it.toString()
        })

        viewModel.activityHint.observe(this, Observer {
            binding.hintTitle.text = it.toString()
        })

        binding.randomButton.setOnClickListener {
            viewModel.getRandomActivity()
        }
        viewModel.progressBar.observe(this, Observer {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
    }
}