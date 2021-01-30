package structural_patterns.decorator

fun main(){
    println("\tpure data")
    var source: DataSource  = FileDataSource("sensitive.dat")
    source.writeData("secret")
    println("\n\tpure + compress data")
    source = CompressionDecorator(source)
    source.writeData("secret")
    println("\n\tpure + compress + encrypt data")
    source = EncryptionDecorator(source)
    source.writeData("secret")
    // OR
    println("\nall together")
    val source1: DataSource  = CompressionDecorator(EncryptionDecorator(FileDataSource("sensitive.dat")))
    source1.writeData("secret")
}