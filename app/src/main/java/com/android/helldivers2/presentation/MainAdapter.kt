package com.android.helldivers2.presentation

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.helldivers2.data.StratagemData
import com.android.helldivers2.databinding.ItemBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.Holder>() {
//    private lateinit var data : List<StratagemData>
//    private var data : List<StratagemData> = emptyList()
    private var data : MutableList<StratagemData> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        Log.d("MainAdapter", "Holder")
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currentItem = data[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        Log.d("MainAdapter", "Count")
        return data.size
    }

    class Holder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StratagemData) {
            binding.apply {
                tvItemId.text = item.id.toString()
                tvItemName.text = item.name
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newData: List<StratagemData>) {
        Log.d("MainAdapter", "update data: $newData")
//        data = newData
        data.addAll(newData)
        Log.d("MainAdapter", "change data: $data")
        notifyDataSetChanged()
    }
}