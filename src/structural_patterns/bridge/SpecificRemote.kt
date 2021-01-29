package structural_patterns.bridge

class AdvancedRemote(private  val device: Device): Remote(device) {
    fun mute() {
        device.setVolume(0)
        println("$device set volume = 0")
    }
}