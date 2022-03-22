package dev.bulean.notbored.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bulean.notbored.R
import dev.bulean.notbored.databinding.ItemActivitiesBinding

//class ActivitiesAdapter(private val activities: List<String>): RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>() {
class ActivitiesAdapter(private val activities: List<TypesActivities>): RecyclerView.Adapter<ActivitiesAdapter.ActivitiesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActivitiesViewHolder(layoutInflater.inflate(R.layout.item_activities, parent, false))
    }

    override fun onBindViewHolder(holder: ActivitiesViewHolder, position: Int) {
        val item = activities[position]
        holder.bind(item)
    }

    override fun getItemCount() = activities.size

    class ActivitiesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemActivitiesBinding.bind(view)
        fun bind(activities: TypesActivities){
            binding.tvActivityTitle.text = activities.type
        }
    }
}