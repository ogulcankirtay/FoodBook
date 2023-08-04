package com.ogulcankirtay.besinlerkitab.ui.fragment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ogulcankirtay.besinlerkitab.R
import com.ogulcankirtay.besinlerkitab.base.listener.RecyclerItemClickListener
import com.ogulcankirtay.besinlerkitab.data.model.Meal
import com.ogulcankirtay.besinlerkitab.databinding.ItemMealBinding

class MealAdapter(
    private val recyclerItemClickListener: RecyclerItemClickListener<Int>
): ListAdapter<Meal,MealViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view=DataBindingUtil.inflate<ItemMealBinding>(LayoutInflater.from(parent.context), R.layout.item_meal,parent,false)
        //val binding = ItemMealBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        println("calıştı")
        holder.bind(position,currentList.get(position), recyclerItemClickListener)
    }


    companion object{
        private val diffCallback=object : DiffUtil.ItemCallback<Meal>(){
            override fun areItemsTheSame(
                oldItem: Meal,
                newItem: Meal): Boolean {
                return oldItem==newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: Meal,
                newItem: Meal
            ): Boolean {
                return oldItem == newItem
            }

        }
    }


}