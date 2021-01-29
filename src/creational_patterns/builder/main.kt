package creational_patterns.builder

fun main() {

    println("This is builder pattern for single class")
    val modernCar = ModernCar.Builder()
        .seats(2)
        .engine(Engine.PremiumCar)
        .GPS(false)
        .tripCounter(11)
        .build()
    modernCar.getInfo()

    // OR

    println("\nThis is builder pattern for some class with director")
    val director = Director()

    val carBuilder = CarBuilder()
    director.constructSportCar(carBuilder)
    val car = carBuilder.getResult()
    car.getTechnicalInfo()

    val manualBuilder = ManualBuilder()
    director.constructSportCar(manualBuilder)
    val manual = manualBuilder.getResult()
    manual.showManual()
}