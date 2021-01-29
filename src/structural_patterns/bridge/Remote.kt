package structural_patterns.bridge

// This is BRIDGE between concrete remote and concrete device
open class Remote(private val device:Device) {

    fun togglePower() {
        if (device.isEnabled()) {
            device.disable()
            println("$device disable")
        }
        else {
            device.enable()
            println("$device enable")
        }
    }
    fun volumeDown() {
        if (device.getVolume()>=10) {
            device.setVolume(device.getVolume() - 10)
            println("$device set volume = ${device.getVolume()}")
        }
    }
    fun volumeUp() {
        if (device.getVolume()<90) {
            device.setVolume(device.getVolume() + 10)
            println("$device set volume = ${device.getVolume()}")
        }
    }
    fun channelDown() {
        if (device.getChannel()>1) {
            device.setChannel(device.getChannel() - 1)
            println("$device set channel = ${device.getChannel()}")
        }
    }
    fun channelUp() {
        device.setChannel(device.getChannel() + 1)
        println("$device set channel = ${device.getChannel()}")
    }
}

interface Device {
    fun isEnabled():Boolean
    fun enable()
    fun disable()
    fun getVolume(): Int
    fun setVolume(_volume: Int)
    fun getChannel(): Int
    fun setChannel(_channel: Int)
}