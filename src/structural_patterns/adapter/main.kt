package structural_patterns.adapter

import kotlin.math.roundToInt
import kotlin.math.sqrt

class RoundHole(private val radius:Int){
    fun fits(peg: RoundPeg) = radius >= peg.radius
}

open class RoundPeg(val radius:Int)

class SquarePeg(val width:Int)

// This is object adapter, it's contains refer to "our" instance object
class SquarePegAdapter(peg: SquarePeg): RoundPeg((peg.width * sqrt(2.0) / 2).roundToInt())

fun main(){
    val hole = RoundHole(5)
    val roundPeg = RoundPeg(5)
    println("roundPeg fits in hole = ${hole.fits(roundPeg)}")

    val smallSquarePeg = SquarePeg(5)
    val largeSquarePeg = SquarePeg(10)
    /*
        !!!Compile-time error
        Type mismatch.
            Required:
            RoundPeg
            Found:
            SquarePeg
     */
//    print("roundPeg fits in hole = ${hole.fits(smallSquarePeg)}")
//    print("roundPeg fits in hole = ${hole.fits(smallSquarePeg)}")

    // Use adapter for "alien" class SquarePeg
    val smallSquarePegAdapter = SquarePegAdapter(smallSquarePeg)
    val largeSquarePegAdapter = SquarePegAdapter(largeSquarePeg)
    println("smallSquarePeg fits in hole = ${hole.fits(smallSquarePegAdapter)}")
    println("largeSquarePeg fits in hole = ${hole.fits(largeSquarePegAdapter)}")
}