package com.example.quizparsing

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Selesai     : 31 Juli 2024. 23:50 ;

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CatImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val retrofit = RetrofitClient.client
        val apiService = retrofit.create(CatApiService::class.java)

        val call = apiService.getCatImages(10)
        call.enqueue(object : Callback<List<CatImage>> {
            override fun onResponse(call: Call<List<CatImage>>, response: Response<List<CatImage>>) {
                if (response.isSuccessful && response.body() != null) {
                    val catImages = response.body()!!
                    adapter = CatImageAdapter(catImages)
                    recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<CatImage>>, t: Throwable) {
                Log.e("MainActivity", "Gagal menampilkan Gambar", t)
            }
        })
    }
}
