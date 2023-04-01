package com.blackpearl.android.onboadingapp.knowledge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpearl.android.onboadingapp.databinding.TopicListItemBinding

class TopicsAdapter(
    private val topics: List<Topic>,
    private val onItemClicked: ((Topic) -> Unit)? = null
) : RecyclerView.Adapter<TopicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicListItemBinding.inflate(inflater, parent, false)
        return TopicViewHolder(binding)
    }

    override fun getItemCount() = topics.size

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(topics[position], onItemClicked)
    }

}

class TopicViewHolder(
    private val binding: TopicListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(topic: Topic, onItemClicked: ((Topic) -> Unit)?) {
        binding.title.text = topic.name

        onItemClicked?.also { callback ->
            binding.root.setOnClickListener {
                callback(topic)
            }
        }
    }
}