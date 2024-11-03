package com.example.kuliner.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuliner.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var kulinerAdapter: KulinerAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inisialisasi RecyclerView
        recyclerView = binding.recyclerViewKuliner
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Mengisi daftar kuliner dan mengatur adapter
        kulinerAdapter = KulinerAdapter(getKulinerList())
        recyclerView.adapter = kulinerAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Method untuk mendapatkan daftar kuliner
    private fun getKulinerList(): List<Kuliner> {
        return listOf(
            Kuliner("Bakpia Pathok", "https://bob.kemenparekraf.go.id/wp-content/uploads/2022/09/pathok-25-by-@bakpia25_official.jpg", "Jl. Pathok, Yogyakarta", 4.7f),
            Kuliner("Gudeg Yu Djum", "https://bob.kemenparekraf.go.id/wp-content/uploads/2022/09/pathok-25-by-@bakpia25_official.jpg", "Jl. Wijilan, Yogyakarta", 4.5f),
            Kuliner("Sate Klathak", "https://bob.kemenparekraf.go.id/wp-content/uploads/2022/09/pathok-25-by-@bakpia25_official.jpg", "Jl. Imogiri, Yogyakarta", 4.2f),
            Kuliner("Bakmi Jawa", "https://bob.kemenparekraf.go.id/wp-content/uploads/2022/09/pathok-25-by-@bakpia25_official.jpg", "Jl. Bantul, Yogyakarta", 4.6f),
            Kuliner("Apem", "https://bob.kemenparekraf.go.id/wp-content/uploads/2022/09/pathok-25-by-@bakpia25_official.jpg", "Jl. Bantul, Yogyakarta", 4.6f),
            Kuliner("Wajik", "https://bob.kemenparekraf.go.id/wp-content/uploads/2022/09/pathok-25-by-@bakpia25_official.jpg", "Jl. Bantul, Yogyakarta", 4.6f)
        )
    }
}