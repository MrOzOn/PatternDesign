package behavioral_pattern.chain_of_responsibility

import java.util.*

class ThrottlingMiddleware(private val requestPerMinute: Int) : Middleware() {

    private var currentTime: Long = Date().time
    private var request = 0

    init {
        println("ThrottlingMiddleware")
    }

    override fun check(email: String, password: String): Boolean {
        if (Date().time > currentTime + 60_000) {
            request = 0
            currentTime = Date().time
        }
        request++
        if (request > requestPerMinute) {
            println("reject - request limit")
            return false
        }
        return checkNext(email, password)
    }
}

class UserExistsMiddleware(private val users: Map<String, String>): Middleware() {

    init {
        println("UserExistsMiddleware")
    }

    override fun check(email: String, password: String): Boolean {
        val passwordForUser = users[email]
        if (passwordForUser==null){
            println("reject - user \"$email\" not found")
            return false
        }
        if (passwordForUser != password) {
            println("reject - incorrect password")
            return false
        }
        return checkNext(email, password)
    }
}

class RoleCheckMiddleware: Middleware() {

    init {
        println("RoleCheckMiddleware")
    }

    override fun check(email: String, password: String): Boolean {
        if (email.startsWith("aDmIn")) {
            println("success - welcome admin")
            return true
        }
        return checkNext(email, password)
    }

}