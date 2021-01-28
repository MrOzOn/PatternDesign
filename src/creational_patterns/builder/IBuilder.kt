package creational_patterns.builder

enum class Engine {
    DriveCar,
    SportCar,
    PremiumCar
}

interface Builder<T> {
    fun reset()
    fun setSeats(number: Int)
    fun setEngine(engine: Engine)
    fun setTripCounter(number: Int)
    fun setGPS(enabled: Boolean)
    fun getResult(): T
}