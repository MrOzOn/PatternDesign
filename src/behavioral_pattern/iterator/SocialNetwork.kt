package behavioral_pattern.iterator

interface SocialNetwork {
    fun createFriendsIterator(profileEmail: String): ProfileIterator
    fun createCoworkersIterator(profileEmail: String): ProfileIterator
}