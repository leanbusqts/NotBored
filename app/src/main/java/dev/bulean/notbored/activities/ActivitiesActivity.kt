package dev.bulean.notbored.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import dev.bulean.notbored.R
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
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.activities)
        participants = intent.getIntExtra("participants", 0)

        initRecyclerView()
    }

    private fun initRecyclerView() {
//        val data = filterList(participants, DataSource().loadData())
        val data = DataSource().loadData()
        adapter = ActivitiesAdapter(data) { activity ->
            val intent = Intent(this, HintActivity::class.java)
            intent.putExtra("type", activity)
            intent.putExtra("participants", participants)
            intent.putExtra("isRandom", false)
            startActivity(intent)
        }
        binding.recycler.adapter = adapter
    }

//    private fun filterList(filter: Int, list: List<TypesActivities>) : List<TypesActivities>{
//        return list.filter { it.participants == filter }
//    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_random, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_random -> {
                val intent = Intent(this, HintActivity::class.java)
//                intent.putExtra("type", rant())
//                intent.putExtra("participants", ranp())
                intent.putExtra("isRandom", true)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
//
//    fun ranp() : Int {
//        return (1..9).random()
//    }
//    fun rant() : String {
//        return DataSource().loadData().random()
//    }

}



