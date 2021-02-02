package behavioral_pattern.chain_of_responsibility

abstract class Middleware {
    private var next: Middleware? = null

    fun linkWith(next: Middleware): Middleware {
        this.next = next
        return next
    }

    abstract fun check(email: String, password: String): Boolean

    protected fun checkNext(email: String, password: String): Boolean{
        return if (next==null){
            println("for user \"$email\" access allowed")
            true
        } else {
            next!!.check(email, password)
        }
    }
}