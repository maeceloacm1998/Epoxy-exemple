package com.plfdev.epoxyexample.secondway

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.plfdev.epoxyexample.R

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.item_categories)
abstract class CategoriesHolder : EpoxyModelWithHolder<CategoriesHolder.MainCategoriesHolder>() {

    @EpoxyAttribute
    lateinit var title : String

    override fun bind(holder: MainCategoriesHolder){
        holder.tvHeader.text = title
    }

    inner class MainCategoriesHolder : EpoxyHolder(){

        lateinit var tvHeader : TextView

        override fun bindView(itemView: View) {
            tvHeader = itemView.findViewById(R.id.tvHeader)
        }
    }
}