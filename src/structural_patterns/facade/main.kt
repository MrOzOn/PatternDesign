package structural_patterns.facade

// Mock type for imitation complext class, in this case File
typealias MockFile = String

class VideoFile(filename: String) {
    init {
        println("read file \"$filename\" into memory")
    }
}

open class CompressionCodec

class MPEG4CompressionCodec: CompressionCodec() {
    //different realization video codec
    init {
        println("initialize settings for MPEG4 codec")
    }
    override fun toString(): String = "MPEG4CompressionCodec"
}

class OggCompressionCodec: CompressionCodec() {
    //different realization video codec
    init {
        println("initialize settings for OGG codec")
    }
    override fun toString(): String = "OggCompressionCodec"
}

class CodecFactory {
    companion object {
        // emulate any work
        fun extract(file: Any):Any {
            println("analyze file, get current video codec")
            return file
        }
    }
}

class BitrateReader {
    companion object {
        fun read(file: String, sourceCodec: Any): ByteArray {
            println("decoding file, return raw stream")
            return "bla-bla".encodeToByteArray()
        }
        fun convert(buffer: ByteArray, destinationCodec: CompressionCodec): MockFile {
            println("convert stream using $destinationCodec, save to file")
            return "Bingo!"
        }
    }
}

// It's facade
interface IVideoConverter {
    fun convert(filename: String, format: String): MockFile
}

class VideoConverter: IVideoConverter {
    override fun convert(filename: String, format: String): MockFile {
        val file = VideoFile(filename)
        val sourceCodec = CodecFactory.extract(file)
        val destinationCodec = if(format=="mp4") {
            MPEG4CompressionCodec()
        } else {
            OggCompressionCodec()
        }
        val buffer = BitrateReader.read(filename, sourceCodec)
        return BitrateReader.convert(buffer, destinationCodec)
    }
}

fun main(){
    val convertor = VideoConverter()
    val mp4File = convertor.convert("my_favorite_film.ogg", "mp4")
    println("done!")
}