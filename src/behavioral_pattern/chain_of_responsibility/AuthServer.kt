package behavioral_pattern.chain_of_responsibility

class AuthServer {
    private val users: MutableMap<String, String> = mutableMapOf()
    private var middleware: Middleware? = null

    init {
        println("loading users")
        users["user1@mydomain.com"]="user1"
        users["user2@mydomain.com"]="user2"
        users["user3@mydomain.com"]="user3"
        users["aDmIn@mydomain.com"]="topsecret"
    }

    fun initializeMiddleware(middleware: Middleware) {
        this.middleware = middleware
    }

    fun loadUsers() = users.toMap()

    fun logIn(email: String, password: String){
        middleware?.check(email, password)
    }
}