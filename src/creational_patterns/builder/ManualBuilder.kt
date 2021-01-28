package creational_patterns.builder

class Manual {
    var text = ""

    fun showManual() {
        println(text)
    }
}

class ManualBuilder : Builder<Manual> {

    private var manual = Manual().apply {
        text = "Your manual include sections:\n"
    }

    override fun reset() {
        manual.text = "Your manual include sections:\n"
    }

    override fun setSeats(number: Int) {
        manual.text += "\thow using seats\n"
    }

    override fun setEngine(engine: Engine) {
        manual.text += "\thow using engine\n"
    }

    override fun setTripCounter(number: Int) {
        manual.text += "\thow using different speeds\n"
    }

    override fun setGPS(enabled: Boolean) {
        manual.text += "\thow using GPS module\n"
    }

    override fun getResult(): Manual {
        manual.text.trim()
        return manual
    }
}