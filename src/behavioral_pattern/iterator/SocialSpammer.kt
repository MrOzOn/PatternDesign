package behavioral_pattern.iterator

import java.lang.NullPointerException

class SocialSpammer(private val socialNetwork: SocialNetwork) {

    var iterator: ProfileIterator? = null

    fun sendSpamToFriends(profileEmail: String, message: String) {
        println("Iterating over friends...")
        iterator = socialNetwork.createFriendsIterator(profileEmail)
        if (iterator==null) {
            throw NullPointerException("iterator is null")
        }
        while (iterator!!.hasNext()) {
            val profile = iterator!!.getNext()
            sendMessage(profile?.email,message)
        }
    }

    fun sendSpamToCoworkers(profileEmail: String, message: String) {
        println("Iterating over coworkers...")
        iterator = socialNetwork.createCoworkersIterator(profileEmail)
        if (iterator==null) {
            throw NullPointerException("iterator is null")
        }
        while (iterator!!.hasNext()) {
            val profile = iterator!!.getNext()
            sendMessage(profile?.email,message)
        }
    }

    private fun sendMessage(email: String?, message: String) {
        email?.let {
            println("Sent message to: '$email'. Message body: '$message'")
        }
    }
}