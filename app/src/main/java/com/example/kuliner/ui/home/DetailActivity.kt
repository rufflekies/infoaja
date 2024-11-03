package com.example.kuliner.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kuliner.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data dari intent
        val imageUrl = intent.getStringExtra("WISATA_IMAGE_URL")
        val name = intent.getStringExtra("WISATA_NAME")
        val address = intent.getStringExtra("WISATA_ADDRESS")
        val rating = intent.getFloatExtra("WISATA_RATING", 0f)

        // Menampilkan data di tampilan
        binding.textDetailName.text = name
        binding.textDetailAddress.text = address
        binding.ratingDetailBar.rating = rating

        // Memuat gambar
        Glide.with(this)
            .load(imageUrl)
            .into(binding.imageDetail)
    }
}
