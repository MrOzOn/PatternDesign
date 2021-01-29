package structural_patterns.bridge

fun main(){
    val tv = Tv()
    var remote = Remote(tv)
    remote.togglePower()
    remote.volumeUp()
    remote.volumeUp()
    remote.volumeDown()
    remote.channelDown()
    remote.channelDown()
    remote.togglePower()

    val radio = Radio()
    remote = Remote(radio)
    remote.togglePower()
    remote.volumeUp()
    remote.volumeUp()
    remote.volumeDown()
    remote.channelDown()
    remote.channelDown()
    remote.togglePower()

    val advancedRemote = AdvancedRemote(radio)
    advancedRemote.mute()
}