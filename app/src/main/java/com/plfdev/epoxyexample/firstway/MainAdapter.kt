package com.plfdev.epoxyexample.firstway

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.plfdev.epoxyexample.databinding.ItemCategoriesBinding
import com.plfdev.epoxyexample.databinding.ItemSectionListBinding

class MainAdapter(
    private val simpleList: List<ModelContentEpoxy>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM_TYPE_CATEGORIES = 1
        private const val ITEM_TYPE_FILTERS = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        0 -> FiltersViewHolder(
            ItemSectionListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
        else -> CategoriesViewHolder(
            ItemCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = simpleList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoriesViewHolder -> {
                holder.bindView(simpleList[position])
            }

            is FiltersViewHolder -> {
                holder.bindView(simpleList[position])
            }
        }
    }

    override fun getItemViewType(position: Int) = when (simpleList[position].content) {
        "categories" -> ITEM_TYPE_CATEGORIES
        else -> ITEM_TYPE_FILTERS
    }

    class FiltersViewHolder(private val viewBinding: ItemSectionListBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindView(item: ModelContentEpoxy) {
            viewBinding.tvContent.text = item.title
        }

    }

    class CategoriesViewHolder(private val viewBinding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindView(item: ModelContentEpoxy) {
            viewBinding.tvHeader.text = item.title
        }
    }

}