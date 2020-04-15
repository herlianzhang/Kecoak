package com.example.kecoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kecoa.about.AboutActivity
import com.example.kecoa.detail.DetailActivity
import com.example.kecoa.model.KecoaModel
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import com.example.kecoa.adapter.ListAdapter as KecoaAdapter

class MainActivity : AppCompatActivity() {
    private val kecoaAdapter = KecoaAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Cockroach"
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        rvList.layoutManager = LinearLayoutManager(this)
        kecoaAdapter.addData(generateData())
        kecoaAdapter.setOnItemClickCallback(object: KecoaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: KecoaModel) {
                val moveToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                moveToDetail.putExtra("DETAIL", data as Serializable)
                startActivity(moveToDetail)
            }
        })
        rvList.adapter = kecoaAdapter
    }

    private fun generateData() : List<KecoaModel> {
        val data: MutableList<KecoaModel> = mutableListOf()

        data.add(KecoaModel("Oriental cockroach", listOf(R.drawable.oriental1, R.drawable.oriental2, R.drawable.oriental3, R.drawable.oriental4), "The oriental cockroach, also known as the waterbug or black beetle, is a large species of cockroach, adult males being 18–29 mm and adult females being 20–27 mm. It is dark brown or black in color and has a glossy body.", "Blatta orientalis", "Blattodea", "Blatta", "Species", "B. orientalis", "Animalia"))

        data.add(KecoaModel("Ectobius vittiventris", listOf(R.drawable.ectobius1, R.drawable.ectobius2, R.drawable.ectobius3, R.drawable.ectobius4), "Ectobius vittiventris is a blattodea that mainly lives Southern of the Alps. During the past years, it managed to spread to Northern regions of the Alps and can regularly be seen in Swiss cities like Bern, Geneva and Zurich. The animal is harmless to humans.", "Ectobius vittiventris", "Blattodea", "Ectobius", "Species", "E. floridana", "Animalia"))

        data.add(KecoaModel("Florida woods", listOf(R.drawable.florida1, R.drawable.florida2), "The Florida woods cockroach or palmetto bug is a large cockroach species which typically grows to a length of 30–40 mm.", "Eurycotis floridana", "Blattodea", "Eurycotis", "Species", "E. floridana", "Animalia"))

        data.add(KecoaModel("Madagascar hissing", listOf(R.drawable.madagascar1, R.drawable.madagascar2, R.drawable.madagascar3), "The Madagascar hissing cockroach, also known as the hissing cockroach or simply hisser, is one of the largest species of cockroach, reaching 2 to 3 inches at maturity. They are native to the island of Madagascar, which is off the African mainland, where they are known to be found inside of rotting logs.", "Gromphadorhina portentosa", "Blattodea", "Insecta", "Species", "G. portentosa", "Animalia"))

        data.add(KecoaModel("Blaberus giganteus", listOf(R.drawable.blaberus1, R.drawable.blaberus2), "The Central American giant cave cockroach, also known as the Brazilian cockroach, is a cockroach belonging to the family Blaberidae.", "Blaberus giganteus", "Blattodea", "Blaberus", "Species", "B. giganteus", "Animalia"))

        data.add(KecoaModel("Parcoblatta fulvescens", listOf(R.drawable.parcoblatta1, R.drawable.parcoblatta2), "Parcoblatta fulvescens, the fulvous wood cockroach, is a species of cockroach endemic to the United States and possibly Canada that measures around 13 mm long.", "Parcoblatta fulvescens", "Blattodea", "Parcoblatta", "Species", "P. fulvescens", "Animalia"))

        data.add(KecoaModel("Gromphadorhina oblongonota", listOf(R.drawable.gromphadorhina1, R.drawable.gromphadorhina2), "Gromphadorhina oblongonota is one of four roach species in the genus Gromphadorhina, which is one of several genera collectively known as hissing cockroaches; like all members of the tribe Gromphadorhinini, they are from the island of Madagascar.", "Gromphadorhina oblongonota", "Blattodea", "Hissing cockroaches", "Species", "G. oblongonota", "Animalia"))

        data.add(KecoaModel("Cuban cockroach", listOf(R.drawable.cuban1, R.drawable.cuban2), "Panchlora nivea, the Cuban cockroach or green banana cockroach, is a small species of cockroach found in Cuba and the Caribbean, and along the Gulf Coast from Florida to Texas, and has been observed as far north as Summerville, South Carolina. It is found in subtropical or tropical climates.", "Panchlora nivea", "Blattodea", "Panchlora", "Species", "P. nivea", "Animalia"))

        data.add(KecoaModel("Australian cockroach", listOf(R.drawable.australian1, R.drawable.australian2), "The Australian cockroach is a common species of tropical cockroach, with a length of 23–35 mm. It is brown overall, with the tegmina having a conspicuous lateral pale stripe or margin, and the pronotum with a sharply contrasting pale or yellow margin.", "Periplaneta australasiae", "Blattodea", "Periplaneta", "Species", "P. australasiae", "Animalia"))

        data.add(KecoaModel("Saltoblattella montistabularis", listOf(R.drawable.saltoblattella1, R.drawable.saltoblattella2), "Saltoblattella montistabularis is a species of jumping cockroach known only from Table Mountain near Cape Town, South Africa. Both the species and genus were newly described in 2009. Researchers nicknamed the species leaproach.", "Saltoblattella montistabularis", "Blattodea", "Saltoblatella", "Species", "Saltoblattella montistabularis", "Animalia"))

        return data.toList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(aboutIntent)
        return super.onOptionsItemSelected(item)
    }

}
