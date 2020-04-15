package com.example.kecoa.detail

import PageDecoration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.kecoa.R
import com.example.kecoa.adapter.DetailAdapter
import com.example.kecoa.model.KecoaModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private val detailAdapter = DetailAdapter() 
    private lateinit var data: KecoaModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        data = intent.extras?.get("DETAIL") as KecoaModel
        title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        initView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
    
    private fun initView() {
        rvDetailActivity.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        detailAdapter.addData(data.image)
        rvDetailActivity.addItemDecoration(PageDecoration())
        rvDetailActivity.setOnFlingListener(null)
        PagerSnapHelper().attachToRecyclerView(rvDetailActivity)
        rvDetailActivity.adapter = detailAdapter

        tvDetailName.text = data.name
        tvDetailInfo.text = data.desc
        tvDetailScientificName.text = "Scientific name: ${data.scientific}"
        tvDetailOrder.text = "Order: ${data.order}"
        tvDetailClassification.text = "Higher classification: ${data.classification}"
        tvDetailRank.text = "Rank: ${data.rank}"
        tvDetailSpecies.text = "Species: ${data.species}"
        tvDetailKingdom.text = "Kingdom: ${data.kingdom}"
    }
}
