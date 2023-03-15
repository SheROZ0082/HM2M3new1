package com.example.hm2m3new1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.R
import com.example.hm2m3new1.model.model_G
import com.example.gallery.databinding.ItemGBinding




    class Adapter(private var list: ArrayList<model_G>) :
        RecyclerView.Adapter<Adapter.ViewHolderGallery>() {
        var clickListener: ((model_G)-> Unit)? = null

        fun updateLIst(list1:List<model_G>) {
            list = list1 as ArrayList<model_G>
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGallery {
            return ViewHolderGallery(
                ItemGBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: ViewHolderGallery, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount(): Int {
            return list.size
        }

        inner class ViewHolderGallery(private val binding: ItemGBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(model_G: model_G) {
                binding.imageItem.loadImage(model_G.image)
                itemView.setOnClickListener {
                    clickListener?.invoke(model_G)
                    binding.containerItem.apply {
                        if ( it.isPressed){
                            it.setBackgroundResource(R.drawable.selected)
                            binding.imageCheck.isVisible = true
                            clickListener?.invoke(model_G)

                        }
                    }

                }
            }
        }
    }
