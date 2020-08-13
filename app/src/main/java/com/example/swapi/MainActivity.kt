package com.example.swapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainActivityViewModel
    private var adapter : FilmsAdapter = FilmsAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainActivityViewModel()
        viewModel.loadFilms()
        createRecyclerView()

        viewModel.filmList.observe(this, Observer {
            setTheme(R.style.AppTheme)
            viewModel.filmList.value?.let { adapter.updateData(it) }
            adapter.notifyDataSetChanged()
        })
    }

    private fun createRecyclerView() {
        film_recycler_view.layoutManager = LinearLayoutManager(this)
        film_recycler_view.adapter = adapter
    }
}