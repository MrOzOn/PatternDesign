package creational_patterns.singleton

class Database private constructor() {

    companion object {
        private var _instance: Database? = null
        @Synchronized
        fun getInstance(): Database {
            if (_instance==null){
                _instance = Database()
            }
            return _instance!!
        }
    }

    init {
        println("Singleton created!!!")
    }

    fun doSomething() {
        println("doing something...")
    }
}

fun main(){
    //first val from Database
    val database1 = Database.getInstance()
    database1.doSomething()
    //second val from Database
    val database2 = Database.getInstance()
    database2.doSomething()

}