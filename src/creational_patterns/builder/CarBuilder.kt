package creational_patterns.builder

class Car {
    var seats: Int = 1
    var engine: Engine = Engine.DriveCar
    var tripCounter: Int = 5
    var GPS: Boolean = false

    fun getTechnicalInfo(){
        val info = """
            Your car have specification:
            Count seats=$seats
            Engine = $engine
            TripCounter have $tripCounter speeds
            GPS including = $GPS
        """.trimIndent()
        println(info)
    }
}

class CarBuilder : Builder<Car> {
    private var car = Car()

    override fun reset() {
        car = Car()
    }

    override fun setSeats(number: Int) {
        car.seats = number
    }

    override fun setEngine(engine: Engine) {
        car.engine = engine
    }

    override fun setTripCounter(number: Int) {
        car.tripCounter = number
    }

    override fun setGPS(enabled: Boolean) {
        car.GPS = enabled
    }

    override fun getResult() = car
}