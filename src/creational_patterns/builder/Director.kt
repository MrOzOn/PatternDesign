package creational_patterns.builder

class Director {
    fun constructSportCar(builder: Builder<*>){
        builder.reset()
        builder.setSeats(2)
        builder.setEngine(Engine.SportCar)
        builder.setTripCounter(7)
//        builder.setGPS(true)
    }
}