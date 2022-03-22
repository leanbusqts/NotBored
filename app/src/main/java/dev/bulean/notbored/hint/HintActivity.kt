package dev.bulean.notbored.hint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.bulean.notbored.R

class HintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)



    }

    //    private fun callService() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                var s = ActivitiesApi.retrofitService.getActivities()
//                val a : ActivityItem? = s.body()
//            } catch (e: Exception) {
//                Log.e("network", "$e")
//            }
//
//
//        }
//    }

}