package structural_patterns.decorator

open class DataSourceDecorator(private val source: DataSource): DataSource {
    override fun writeData(data: String) {
        source.writeData(data)
    }

    override fun readData(): String {
        return source.readData()
    }

}

class EncryptionDecorator(private val source: DataSource): DataSourceDecorator(source) {
    override fun writeData(data: String) {
        println("encrypt \"$data\" before write")
        super.writeData(data)
    }

    override fun readData(): String {
        val data = super.readData()
        println("decrypt data before return")
        return data
    }
}

class CompressionDecorator(private val source: DataSource): DataSourceDecorator(source) {
    override fun writeData(data: String) {
        println("compress \"$data\" before write")
        super.writeData(data)
    }

    override fun readData(): String {
        val data = super.readData()
        println("decompress data before return")
        return data
    }
}