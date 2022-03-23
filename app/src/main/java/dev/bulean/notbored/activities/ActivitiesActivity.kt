package dev.bulean.notbored.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.bulean.notbored.data.DataSource
import dev.bulean.notbored.databinding.ActivityActivitiesBinding
import dev.bulean.notbored.hint.HintActivity

class ActivitiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var adapter: ActivitiesAdapter
    private val activities = mutableListOf<String>()
    private var s: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        s = intent.getIntExtra("participants", 0)

        binding.randombtn.setOnClickListener {
            startActivity(Intent(this, HintActivity::class.java))
        }

        initRecyclerView()
    }



    private fun initRecyclerView() {
        val fil = filterList(s, DataSource().loadData())
        adapter = ActivitiesAdapter(fil)
        binding.recycler.adapter = adapter
    }

    private fun filterList(filter: Int, list: List<TypesActivities>) : List<TypesActivities>{
        return list.filter { it.participants == filter }
    }
}



