package com.pollra.mvvm.data.repositories

import android.util.Log
import retrofit2.Response
import java.io.IOException

abstract class SaveApiRequest {
    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if(response.isSuccessful) {
            return response.body()!!
        }else {
            Log.e("YOUTUBE_API", response.message())
            throw YoutubeVideoApiException(
                response.code().toString()
            )
        }
    }
}
class YoutubeVideoApiException(message: String): IOException(message)