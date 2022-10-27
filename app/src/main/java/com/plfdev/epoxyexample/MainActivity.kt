package com.plfdev.epoxyexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.plfdev.epoxyexample.databinding.ActivityMainBinding
import com.plfdev.epoxyexample.firstway.MainAdapter
import com.plfdev.epoxyexample.firstway.ModelContentEpoxy
import com.plfdev.epoxyexample.secondway.MainEpoxyController
import com.plfdev.epoxyexample.secondway.Section
import com.plfdev.epoxyexample.secondway.SectionModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var controller = MainEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFirstWay()
//        setupSecondWay()
    }

    private fun setupFirstWay() {
        val listRecycler = getDataFirstWay()

        binding.recyclerView.apply {
            adapter = MainAdapter(listRecycler)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setupSecondWay() {

        binding.recyclerView.apply {
            setController(controller)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        controller.setData(getDataSecondWay())
    }

    private fun getDataFirstWay(): List<ModelContentEpoxy> {
        return listOf(
            ModelContentEpoxy("categories", "Categories"),
            ModelContentEpoxy("category1", "Food"),
            ModelContentEpoxy("category2", "Work"),
            ModelContentEpoxy("category3", "Entertainment"),
            ModelContentEpoxy("category4", "Finance"),
            ModelContentEpoxy("category5", "Health"),
            ModelContentEpoxy("category6", "Sport"),
            ModelContentEpoxy("category7", "Drink"),
            ModelContentEpoxy("category8", "Environment"),
            ModelContentEpoxy("category9", "Tech"),
            ModelContentEpoxy("category10", "Education"),
            ModelContentEpoxy("category11", "Home"),
            ModelContentEpoxy("category12", "Office"),
            ModelContentEpoxy("categories", "Filters"),
            ModelContentEpoxy("filter1", "Alphabetical"),
            ModelContentEpoxy("filter2", "Popularity"),
            ModelContentEpoxy("filter1", "Numbers"),
            ModelContentEpoxy("filter2", "Grid"),
            ModelContentEpoxy("filter1", "Layout"),
            ModelContentEpoxy("filter2", "Horizontal"),
            ModelContentEpoxy("filter1", "Vertical")
        )
    }


    private fun getListSectionCategories(): List<Section> {
        return listOf(
            Section("Food", "acom://home"),
            Section("Work", "acom://home"),
            Section("Entertainment", "acom://home"),
            Section("Finance", "acom://home"),
            Section("Health", "acom://home"),
            Section("Sport", "acom://home"),
            Section("Drink", "acom://home"),
            Section("Environment", "acom://home")
        )
    }

    private fun getListSectionFilters(): List<Section> {//suba://home
        return listOf(
            Section("Alphabetical", "acom://home"),
            Section("Popularity", "acom://home"),
            Section("Numbers", "acom://home"),
            Section("Grid", "acom://home"),
            Section("Layout", "acom://home"),
            Section("Horizontal", "acom://home"),
            Section("Vertical", "acom://home")
        )
    }

    private fun getDataSecondWay(): List<SectionModel> {
        return listOf(
            SectionModel("categories", "Categories", "section_carousel", getListSectionCategories()),
            SectionModel("filters", "Filters", "section_list", getListSectionFilters())
        )
    }

}