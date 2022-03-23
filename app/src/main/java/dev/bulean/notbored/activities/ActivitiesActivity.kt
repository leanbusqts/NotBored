package dev.bulean.notbored.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.bulean.notbored.data.DataSource
import dev.bulean.notbored.databinding.ActivityActivitiesBinding
import dev.bulean.notbored.main.TermsConditionsActivity

class ActivitiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityActivitiesBinding
    private lateinit var adapter: ActivitiesAdapter
    private var participants: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        participants = intent.getIntExtra("participants", 0)
//        callService()

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val fil = filterList(participants, DataSource().loadData())
        adapter = ActivitiesAdapter(fil) { activity ->
            val intent = Intent(this, DescriptionActivity::class.java)
            intent.putExtra("type", activity.type)
            intent.putExtra("participants", activity.participants)
            startActivity(intent)
        }
        binding.recycler.adapter = adapter
    }

    private fun filterList(filter: Int, list: List<TypesActivities>) : List<TypesActivities>{
        return list.filter { it.participants == filter }
    }
}



