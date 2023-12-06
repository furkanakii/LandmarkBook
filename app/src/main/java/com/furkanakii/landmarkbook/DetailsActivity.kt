package com.furkanakii.landmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.furkanakii.landmarkbook.databinding.ActivityDetailsBinding


@Suppress("DEPRECATION")
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        val selecetedChar = intent.getSerializableExtra("Characters") as Characters
        binding.nameText.text = selecetedChar.name
        binding.informationText.text = selecetedChar.information
        binding.imageView.setImageResource(selecetedChar.image)



    }
}