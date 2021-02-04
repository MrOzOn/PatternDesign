package behavioral_pattern.iterator

fun main(){
    println("LinkedIn")
    var socialNetwork: SocialNetwork  = LinkedIn(createTestProfiles())
    var socialSpammer = SocialSpammer(socialNetwork)
    socialSpammer.sendSpamToFriends("anna.smith@bing.com",
        "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?")
    socialSpammer.sendSpamToCoworkers("anna.smith@bing.com",
        "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].")
    println("\nFacebook")
    socialNetwork = Facebook(createTestProfiles())
    socialSpammer = SocialSpammer(socialNetwork)
    socialSpammer.sendSpamToFriends("anna.smith@bing.com",
        "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?")
    socialSpammer.sendSpamToCoworkers("anna.smith@bing.com",
        "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].")

}

fun createTestProfiles(): List<Profile> {
    val data = mutableListOf<Profile>()
    data.add(Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"))
    data.add(Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"))
    data.add(Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"))
    data.add(Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"))
    data.add(Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"))
    data.add(Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"))
    return data.toList()
}
