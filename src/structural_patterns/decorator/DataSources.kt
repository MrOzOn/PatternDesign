package structural_patterns.decorator

interface DataSource {
    fun writeData(data: String)
    fun readData(): String
}

class FileDataSource(private val fileName: String): DataSource {
    override fun writeData(data: String) {
        println("write \"$data\" in file $fileName")
    }
    override fun readData(): String {
        println("read data from file $fileName")
        return "bla-bla"
    }
}