package behavioral_pattern.chain_of_responsibility

fun main(){
    val authServer = AuthServer()
    val middleware = ThrottlingMiddleware(5)
    middleware.linkWith(RoleCheckMiddleware())
        .linkWith(UserExistsMiddleware(authServer.loadUsers()))

    authServer.initializeMiddleware(middleware)
    authServer.logIn("aaa@mydomain.com","bbbb")
    authServer.logIn("user3@mydomain.com","bbbb")
    authServer.logIn("aDmIn@mydomain.com","bbbb")
    authServer.logIn("user3@mydomain.com","user3")
    authServer.logIn("user3@mydomain.com","bbbb")
    authServer.logIn("user3@mydomain.com","bbbb")
}