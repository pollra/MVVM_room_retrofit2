package com.pollra.mvvm.data.models

data class YoutubeForm(
    val kind: String,
    val etag: String,
    val nextPageToken: String,
    val regionCode: String,
    val pageInfo: PageInfo,
    val items: List<Items>
){

    data class PageInfo(
        val totalResults: Int,
        val resultsPerPage: Int
    )

    data class Items(
        val kind: String,
        val etag: String,
        val id: Id,
        val snippet: Snippet,
        val favorite: Boolean
    ) {
        data class Id(
            val kind: String,
            val videoId: String
        )

        data class Snippet(
            val publishedAt: String,
            val channelId: String,
            val title: String,
            val description: String,
            val thumbnails: Thumbnails,
            val channelTitle: String,
            val liveBroadcastContent: String,
            val publishTime: String
        ) {
            data class Thumbnails(
                val default: ImageSize,
                val medium: ImageSize,
                val high: ImageSize
            )
        }
    }
}

data class ImageSize(
    val url: String,
    val width: String,
    val height: String
)