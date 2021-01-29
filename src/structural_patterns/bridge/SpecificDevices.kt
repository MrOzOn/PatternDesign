package structural_patterns.bridge

class Tv: Device {

    private var powerOff = true
    private var volume = 50
    private var channel = 1

    override fun toString(): String = "Tv"

    override fun isEnabled(): Boolean {
        return !powerOff
    }

    override fun enable() {
        powerOff = false
    }

    override fun disable() {
        powerOff = true
    }

    override fun getVolume(): Int {
        return volume
    }

    override fun setVolume(_volume: Int) {
        volume = _volume
    }

    override fun getChannel(): Int {
        return channel
    }

    override fun setChannel(_channel: Int) {
        channel = _channel
    }
}

class Radio: Device {

    private var powerOff = true
    private var volume = 20
    private var channel = 10

    override fun toString(): String = "Radio"

    override fun isEnabled(): Boolean {
        return !powerOff
    }

    override fun enable() {
        powerOff = false
    }

    override fun disable() {
        powerOff = true
    }

    override fun getVolume(): Int {
        return volume
    }

    override fun setVolume(_volume: Int) {
        volume = _volume
    }

    override fun getChannel(): Int {
        return channel
    }

    override fun setChannel(_channel: Int) {
        channel = _channel
    }
}