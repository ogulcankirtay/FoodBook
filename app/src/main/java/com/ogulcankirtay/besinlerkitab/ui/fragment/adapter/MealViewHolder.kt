package com.ogulcankirtay.besinlerkitab.ui.fragment.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ogulcankirtay.besinlerkitab.base.listener.RecyclerItemClickListener
import com.ogulcankirtay.besinlerkitab.data.model.Meal
import com.ogulcankirtay.besinlerkitab.databinding.ItemMealBinding
import com.squareup.picasso.Picasso

class MealViewHolder(val binding: ItemMealBinding): RecyclerView.ViewHolder(binding.root) {


    fun bind(position:Int,meal:Meal,recyclerItemClickListener: RecyclerItemClickListener<Int>){
        println("viewHolder Calıştı")
       //dataBinding
        binding.meal=meal
        //viewBinding
      //  binding.tvMealName.setText(meal.isim)
        //binding.tvMealCalories.setText(meal.kalori)
       // Picasso.get().load(meal.gorsel).into(binding.ivMealImage)

        binding.root.setOnClickListener{
            recyclerItemClickListener.onClick(position)
        }

    }
}