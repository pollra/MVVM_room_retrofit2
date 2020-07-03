package com.pollra.mvvm.data.repositories

import android.os.Build
import androidx.annotation.RequiresApi
import com.pollra.mvvm.data.network.YoutubeApi

class YoutubeApiRepository(private val api: YoutubeApi): SaveApiRequest(){
    @RequiresApi(Build.VERSION_CODES.N)
    suspend fun getYoutubeForm() = apiRequest { api.getYoutubeForm() }
}