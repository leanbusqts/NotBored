package dev.bulean.notbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.bulean.notbored.databinding.ActivityActivitiesBinding

class ActivitiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var adapter: ActivitiesAdapter
    private val activities = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = ActivitiesAdapter(activities)
        binding.recycler.adapter = adapter
    }
}