package dev.bulean.notbored.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bulean.notbored.R
import dev.bulean.notbored.databinding.ItemActivitiesBinding

class ActivitiesAdapter(private val activities: List<String>, private val onClickListener: (String) -> Unit):
    RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActivitiesViewHolder(layoutInflater.inflate(R.layout.item_activities, parent, false))
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val item = activities[position]
        holder.bind(item, onClickListener)
    }

    override fun getItemCount() = activities.size

    class ActivitiesViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val binding = ItemActivitiesBinding.bind(view)

        fun bind(activities: String, onClickListener: (String) -> Unit){
            binding.tvActivityTitle.text = activities
            itemView.setOnClickListener{
                onClickListener(activities)
            }
        }
    }
}