package com.plfdev.epoxyexample.secondway

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.plfdev.epoxyexample.R

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.item_section_list)
abstract class SectionItemListHolder : EpoxyModelWithHolder<SectionItemListHolder.SectionHolder>() {

    @EpoxyAttribute
    lateinit var title : String

    @EpoxyAttribute
    lateinit var deepLink : String

    @SuppressLint("SetTextI18n")
    override fun bind(holder: SectionHolder){
        holder.tvContent.text = title
        holder.cardContent.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deepLink))
            it.context.startActivity(intent)
        }

        holder.subtract.setOnClickListener {
            val number = holder.textQuantity.text.toString().toInt()
            if(number != 0)
                holder.textQuantity.setText((number - 1).toString())
        }

        holder.sum.setOnClickListener {
            val number = holder.textQuantity.text.toString().toInt()
            holder.textQuantity.setText((number + 1).toString())
        }
    }

    inner class SectionHolder : EpoxyHolder(){

        lateinit var tvContent : TextView
        lateinit var cardContent : CardView
        lateinit var subtract : Button
        lateinit var sum : Button
        lateinit var textQuantity: EditText

        override fun bindView(itemView: View) {
            tvContent = itemView.findViewById(R.id.tvContent)
            cardContent = itemView.findViewById(R.id.cardContent)
            subtract = itemView.findViewById(R.id.subtract)
            sum = itemView.findViewById(R.id.sum)
            textQuantity = itemView.findViewById(R.id.edtContent)
        }
    }
}