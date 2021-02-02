package structural_patterns.proxy

class CachedYouTubeClass(private val service: IThirdPartyYouTubeLib): IThirdPartyYouTubeLib {

    private val cacheVideoList = mutableMapOf<String, Video>()
    private val cacheVideoInfo = mutableMapOf<String, String>()

    override fun listVideos(): List<Video> {
        if (cacheVideoList.isEmpty()) {
            println("empty cacheVideoList!!!")
            val list = service.listVideos()
            list.forEach { video ->
                cacheVideoList[video.id] = video
            }
        }
        return cacheVideoList.values.toList()
    }

    override fun getVideoInfo(videoId: String): String {
        var info = cacheVideoInfo[videoId]
        if (info==null) {
            println("video info not found in cache!!!")
            info = service.getVideoInfo(videoId)
            cacheVideoInfo[videoId] = info
        }
        return info
    }

    override fun downloadVideo(videoId: String): Video {
        var video = cacheVideoList[videoId]
        if (video==null) {
            println("cache don't contain video, download it and caching")
            video = service.downloadVideo(videoId)
            cacheVideoList[videoId] = video
        }
        return video
    }

}