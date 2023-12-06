package com.furkanakii.landmarkbook

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.furkanakii.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var charactersList: ArrayList<Characters>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        charactersList = ArrayList<Characters>()

        // data
        val teemo = Characters(
            "Teemo",
            "Bandle Şehri'ndeki yordle kardeşleri arasında bir efsanedir.",
            R.drawable.temo
        )
        val sylas = Characters(
            "Sylas",
            "Atıldığı zindandan kaçmış olan Sylas artık kalbi katılaşmış bir devrim lideri olarak yaşıyor ve bir zamanlar hizmet ettiği krallığı yok etmek için çevresindekilerin büyü gücünü kullanıyor.",
            R.drawable.sylas
        )
        val caitlyn = Characters(
            "Caitlyn",
            "Barış gücünün en iyisi sayılan Caitlyn, Piltover'ın en iyi nişancısı olarak şehri kurnaz suçlulardan arındırma konusunda rakip tanımıyor.",
            R.drawable.caitlyn
        )
        val warwick = Characters(
            "Warwick",
            "Warwick, Zaun'un gri sokaklarında avlanan bir canavar.",
            R.drawable.warwick
        )

        charactersList.add(teemo)
        charactersList.add(warwick)
        charactersList.add(caitlyn)
        charactersList.add(sylas)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val characterAdapter = characterAdapter(charactersList)
        binding.recyclerView.adapter = characterAdapter
/*
        ///Adapter : Layout & datta

        //Mapping

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            charactersList.map { characters -> characters.name })

        binding.listView.adapter = adapter
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, i, l ->
                val intent = Intent(MainActivity@this, DetailsActivity::class.java)
                intent.putExtra("Characters", charactersList.get(i))
                startActivity(intent)
            }*/
    }


}
