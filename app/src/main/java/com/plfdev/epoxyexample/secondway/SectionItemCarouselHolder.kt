package com.plfdev.epoxyexample.secondway

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.plfdev.epoxyexample.R

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.item_section_carousel)
abstract class SectionItemCarouselHolder : EpoxyModelWithHolder<SectionItemCarouselHolder.SectionHolder>() {

    @EpoxyAttribute
    lateinit var title : String

    @EpoxyAttribute
    lateinit var deepLink : String

    override fun bind(holder: SectionHolder){
        holder.tvContent.text = title
        holder.cardContent.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
            it.context.startActivity(intent)
        }
    }

    inner class SectionHolder : EpoxyHolder(){
        lateinit var tvContent : TextView
        lateinit var cardContent : CardView

        override fun bindView(itemView: View) {
            tvContent = itemView.findViewById(R.id.tvContent)
            cardContent = itemView.findViewById(R.id.cardContent)
        }
    }
}