package com.pollra.mvvm.data.network

import com.pollra.mvvm.data.YoutubeApiProperties
import com.pollra.mvvm.data.models.YoutubeForm
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {
    @GET("/youtube/v3/search")
    suspend fun getYoutubeForm(
        @Query("part") part: String = "snippet",
        @Query("key") sort: String = YoutubeApiProperties.API_KEY,
        @Query("order") order: String = "viewCount",
        @Query("regionCode") regionCode: String = "KR",
        @Query("safeSearch") safeSearch: String = "strict",
        @Query("maxResults") maxResults: Int = YoutubeApiProperties.DEFAULT_VIEW_COUNT,
        @Query("pageToken") pageToken: String? = null,
        @Query("q") q: String = YoutubeApiProperties.DEFAULT_SEARCH_KEYWORD
    ): Response<YoutubeForm>

    companion object {
        operator fun invoke(): YoutubeApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.googleapis.com/")
                .build()
                .create(YoutubeApi::class.java)
        }
    }
}