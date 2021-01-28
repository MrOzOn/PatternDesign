package creational_patterns.builder

class ModernCar private constructor(
    val seats: Int?,
    val engine: Engine?,
    val tripCounter: Int?,
    val GPS: Boolean?
){
    data class Builder (
        var seats: Int = 1,
        var engine: Engine = Engine.DriveCar,
        var tripCounter: Int = 5,
        var GPS: Boolean = false) {

        fun seats(seats: Int) = apply { this.seats = seats }
        fun engine(engine: Engine) = apply { this.engine = engine }
        fun tripCounter(tripCounter: Int) = apply { this.tripCounter = tripCounter }
        fun GPS(enabled: Boolean) = apply { this.GPS = enabled }

        fun build() = ModernCar(seats, engine, tripCounter, GPS)
    }

    fun getInfo(){
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