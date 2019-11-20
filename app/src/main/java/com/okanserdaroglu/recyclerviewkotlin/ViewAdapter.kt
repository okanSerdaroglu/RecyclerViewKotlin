package com.okanserdaroglu.recyclerviewkotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_main.view.*

class ViewAdapter(private var allViews: ArrayList<com.okanserdaroglu.recyclerviewkotlin.View>) :
    RecyclerView.Adapter<ViewAdapter.ViewViewHolder>() {

    override fun getItemCount(): Int { // 0
        Log.e("RECYCLERVIEW", "getItemCount")
        return allViews.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewViewHolder { // 1

        Log.e("RECYCLERVIEW", "onCreateViewHolder")
        val inflater = LayoutInflater.from(parent.context)
        val rowLayout = inflater.inflate(
            R.layout.adapter_main,
            parent,
            false
        ) // false means system adds this layout
        return ViewViewHolder(rowLayout)

    }

    override fun onBindViewHolder(holder: ViewViewHolder, position: Int) { // 3

        holder.bind(position,allViews[position])
        Log.e("RECYCLERVIEW", "onBindViewHolder")

    }

    inner class ViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { // 2

        fun bind(position: Int, view : com.okanserdaroglu.recyclerviewkotlin.View) {
            textViewHeader.text = view.header
            textViewDetail.text = view.detail
            imageViewHeader.setImageResource(view.image)
            imageViewDelete.setOnClickListener {

                allViews.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,allViews.size) // this method notifies new positions of elements in list


            }

            imageViewCopy.setOnClickListener {

                allViews.add(position,view)
                notifyItemInserted(position)
                notifyItemRangeChanged(position,allViews.size) // this method notifies new positions of elements in list

            }
        }

        init {
            Log.e("RECYCLERVIEW", "ViewViewHolder")
        }

        var rowLayout = itemView as ConstraintLayout

        var textViewHeader = rowLayout.textViewHeader!!
        var textViewDetail = rowLayout.textViewDetail!!
        var imageViewHeader = rowLayout.imageViewView!!
        var imageViewDelete = rowLayout.imageViewDelete!!
        var imageViewCopy = rowLayout.imageViewCopy!!



    }
}