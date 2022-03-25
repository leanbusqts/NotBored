package dev.bulean.notbored.hint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.bulean.notbored.R
import dev.bulean.notbored.databinding.ActivityHintBinding

class HintActivity : AppCompatActivity() {

    private val viewModel by viewModels<HintViewModel>()
    private lateinit var binding: ActivityHintBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHintBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.activities)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val t = intent.getStringExtra("type") ?: ""
        val p = intent.getIntExtra("participants", 0)
        val r = intent.getBooleanExtra("isRandom", false)

        binding.typeImage.visibility = if (r) View.VISIBLE else View.INVISIBLE
        binding.typeTitle.visibility = if (r) View.VISIBLE else View.INVISIBLE
        if (r) binding.typeTitle.text = t

        viewModel.getActivityByParticipantsAndType(p, t)

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
            viewModel.getActivityByParticipantsAndType(p, t)
        }
        viewModel.progressBar.observe(this, Observer {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })
    }
}