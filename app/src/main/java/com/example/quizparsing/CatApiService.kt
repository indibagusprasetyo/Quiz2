package com.example.quizparsing

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Selesai     : 14 Juli 2024. 13:03 ;

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiService {
    @GET("v1/images/search")
    fun getCatImages(@Query("limit") limit: Int): Call<List<CatImage>>
}