package dev.bulean.notbored.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.bulean.notbored.data.DataSource
import dev.bulean.notbored.databinding.ActivityActivitiesBinding
import dev.bulean.notbored.hint.HintActivity

class ActivitiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var adapter: ActivitiesAdapter
    private var participants: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        participants = intent.getIntExtra("participants", 0)

        binding.randombtn.setOnClickListener {
            startActivity(Intent(this, HintActivity::class.java))
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
//        val data = filterList(participants, DataSource().loadData())
        val data = DataSource().loadData()
        adapter = ActivitiesAdapter(data) { activity ->
            val intent = Intent(this, HintActivity::class.java)
            intent.putExtra("type", activity)
            intent.putExtra("participants", participants)
            startActivity(intent)
        }
        binding.recycler.adapter = adapter
    }

//    private fun filterList(filter: Int, list: List<TypesActivities>) : List<TypesActivities>{
//        return list.filter { it.participants == filter }
//    }
}



