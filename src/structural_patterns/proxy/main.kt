package structural_patterns.proxy

fun main(){
    val videoService = ThirdPartyYouTubeLib()
    val videoServiceProxy = CachedYouTubeClass(videoService)
    println("get list videos first time")
    var videos = videoServiceProxy.listVideos()
    println("${videos.size} items")
    println("get list videos second time")
    videos = videoServiceProxy.listVideos()
    println("${videos.size} items")
    println("get info video first time")
    println(videoServiceProxy.getVideoInfo("111"))
    println("get info video second time")
    println(videoServiceProxy.getVideoInfo("111"))
    println("get video first time")
    println("downloaded file \"${videoServiceProxy.downloadVideo("911").title}\"")
    println("get video second time")
    println("downloaded file \"${videoServiceProxy.downloadVideo("911").title}\"")
    println("get list videos second time")
    videos = videoServiceProxy.listVideos()
    println("${videos.size} items")
}