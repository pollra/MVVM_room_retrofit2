package com.pollra.mvvm

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.pollra.mvvm.data.network.YoutubeApi
import com.pollra.mvvm.data.repositories.YoutubeApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = YoutubeApiRepository(YoutubeApi())

        GlobalScope.launch(Dispatchers.Main) {
            val youtube = repository.getYoutubeForm()
            Toast.makeText(this@MainActivity, youtube.toString(), Toast.LENGTH_SHORT).show()
        }

    }
}