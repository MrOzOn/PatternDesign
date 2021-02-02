package structural_patterns.proxy

interface IThirdPartyYouTubeLib {
    fun listVideos(): List<Video>
    fun getVideoInfo(videoId: String): String
    fun downloadVideo(videoId: String): Video
}

class Video(val id: String,
            val title: String,
            val duration: Int,
            val data: ByteArray)