package structural_patterns.proxy

import kotlin.random.Random

class ThirdPartyYouTubeLib: IThirdPartyYouTubeLib {

    override fun listVideos(): List<Video> {
        println("get videos from network")
        Thread.sleep(1500)
        val list: MutableList<Video> = mutableListOf()
        list.add(Video("123","Title1", 100, "bla-bla-Title1".toByteArray()))
        list.add(Video("56","Title2", 150, "bla-bla-Title2".toByteArray()))
        list.add(Video("57","Title3", 300, "bla-bla-Title3".toByteArray()))
        list.add(Video("387","Title4", 2300, "bla-bla-Title4".toByteArray()))
        list.add(Video("33","Title5", 230, "bla-bla-Title5".toByteArray()))
        return list
    }

    override fun getVideoInfo(videoId: String): String {
        println("get video info by id from network")
        Thread.sleep(500)
        return "Info: videoId=$videoId, title=\"Title$videoId\", duration=${Random.nextInt(0, 1000)}"
    }

    override fun downloadVideo(videoId: String): Video {
        println("download video info by id from network")
        Thread.sleep(3000)
        return Video(videoId,"Title$videoId", Random.nextInt(0, 1000),
            "bla-bla-Title$videoId".toByteArray())
    }
}