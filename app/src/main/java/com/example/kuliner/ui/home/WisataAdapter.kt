package com.example.kuliner.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuliner.R
import com.example.kuliner.databinding.ItemWisataBinding

class WisataAdapter(private val wisataList: List<Wisata>) : RecyclerView.Adapter<WisataAdapter.WisataViewHolder>() {

    // ViewHolder untuk item wisata
    inner class WisataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_wisata)
        val textView: TextView = view.findViewById(R.id.text_wisata_name)
        val textViewAddress: TextView = view.findViewById(R.id.text_wisata_address)
        val ratingBar: RatingBar = view.findViewById(R.id.rating_wisata)
        val ratingTextView: TextView = view.findViewById(R.id.text_rating_value) // Tambahkan ini
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        // Inflate layout item_wisata.xml
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        return WisataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        // Ambil objek wisata berdasarkan posisi
        val wisata = wisataList[position]

        // Mengisi data ke view holder
        holder.textView.text = wisata.name
        holder.textViewAddress.text = wisata.address
        holder.ratingBar.rating = wisata.rating

        // Memuat gambar menggunakan Glide
        Glide.with(holder.itemView.context)
            .load(wisata.imageUrl)
            .into(holder.imageView)

        // Menampilkan rating sebagai teks
        holder.ratingTextView.text = "${wisata.rating} / 5" // Set nilai rating di samping bintang

        // Set click listener untuk setiap item
        holder.itemView.setOnClickListener {
            // Navigasi ke halaman detail
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra("WISATA_NAME", wisata.name)
                putExtra("WISATA_ADDRESS", wisata.address)
                putExtra("WISATA_IMAGE_URL", wisata.imageUrl)
                putExtra("WISATA_RATING", wisata.rating)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return wisataList.size
    }
}
