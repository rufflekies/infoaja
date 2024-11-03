package com.example.kuliner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kuliner.ui.home.Wisata
import com.example.kuliner.ui.home.WisataAdapter
import com.example.kuliner.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var wisataAdapter: WisataAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inisialisasi RecyclerView
        recyclerView = binding.recyclerViewWisata // Sesuaikan dengan ID RecyclerView di layout Fragment
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Mengisi daftar wisata dan mengatur adapter
        wisataAdapter = WisataAdapter(getWisataList())
        recyclerView.adapter = wisataAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Method untuk mendapatkan daftar wisata
// Method untuk mendapatkan daftar wisata
    private fun getWisataList(): List<Wisata> {
        return listOf(
            Wisata("Candi Prambanan", "https://www.suwatu.id/wp-content/uploads/2021/06/CANDI-01-PRAMBANAN.jpg", "Candi Prambanan, Sleman", 4.7f),
            Wisata("Malioboro", "https://www.suwatu.id/wp-content/uploads/2021/06/CANDI-01-PRAMBANAN.jpg", "Malioboro, Yogyakarta", 4.5f),
            Wisata("Pantai Parangtritis", "https://www.suwatu.id/wp-content/uploads/2021/06/CANDI-01-PRAMBANAN.jpg", "Parangtritis, Yogyakarta", 4.2f),
            Wisata("Keraton Yogyakarta", "https://www.suwatu.id/wp-content/uploads/2021/06/CANDI-01-PRAMBANAN.jpg", "Kraton, Yogyakarta", 4.7f),
            Wisata("Taman Sari", "https://www.suwatu.id/wp-content/uploads/2021/06/CANDI-01-PRAMBANAN.jpg", "Taman Sari, Yogyakarta", 4.6f),
            Wisata("Gunung Merapi", "https://www.suwatu.id/wp-content/uploads/2021/06/CANDI-01-PRAMBANAN.jpg", "Desa Selo, Boyolali", 4.6f),
            Wisata("Museum Ullen", "https://www.suwatu.id/wp-content/uploads/2021/06/CANDI-01-PRAMBANAN.jpg", "Kaliurang, Yogyakarta", 4.7f),
            Wisata("Air Terjun Sri Gethuk", "https://www.suwatu.id/wp-content/uploads/2021/06/CANDI-01-PRAMBANAN.jpg", "Gunung Kidul, Yogyakarta", 4.6f),
        )
    }

}
