package behavioral_pattern.iterator

class LinkedIn(cache: List<Profile>?): SocialNetwork {
    private val contacts: List<Profile> = cache ?: emptyList()

    fun requestRelatedContactsFromLinkedInAPI(profileEmail: String, contactType: String): List<String> {
        simulateNetworkLatency()
        println("LinkedIn: Loading \"$contactType\" list of \"$profileEmail\" over the network...")
        val profile = findContact(profileEmail)
        return profile?.getContacts(contactType) ?: emptyList()
    }

    fun requestContactInfoFromLinkedInAPI(profileEmail: String): Profile? {
        simulateNetworkLatency()
        println("LinkedIn: loading profile \"$profileEmail\" over the network...")
        return findContact(profileEmail)
    }

    private fun findContact(profileEmail: String): Profile? {
        return contacts.find { profile ->
            profile.email == profileEmail
        }
    }

    override fun createFriendsIterator(profileEmail: String): ProfileIterator =
        LinkedInIterator(this, "friends", profileEmail)

    override fun createCoworkersIterator(profileEmail: String): ProfileIterator =
        LinkedInIterator(this, "coworkers", profileEmail)

    private fun simulateNetworkLatency() {
        try {
            Thread.sleep(2500)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

}

class Facebook(cache: List<Profile>?): SocialNetwork {
    private val profiles: List<Profile> = cache ?: emptyList()

    fun requestProfileFriendsFromFacebook(profileEmail: String, contactType: String): List<String> {
        simulateNetworkLatency()
        println("Facebook: Loading \"$contactType\" list of \"$profileEmail\" over the network...")
        val profile = findProfile(profileEmail)
        return profile?.getContacts(contactType) ?: emptyList()
    }

    private fun simulateNetworkLatency() {
        try {
            Thread.sleep(2500)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

    fun requestProfileFromFacebook(profileEmail: String): Profile? {
        simulateNetworkLatency()
        println("Facebook: loading profile \"$profileEmail\" over the network...")
        return findProfile(profileEmail)
    }

    private fun findProfile(profileEmail: String): Profile? {
        return profiles.find { profile ->
            profile.email == profileEmail
        }
    }

    override fun createFriendsIterator(profileEmail: String): ProfileIterator =
        FacebookIterator(this,"friends", profileEmail)

    override fun createCoworkersIterator(profileEmail: String): ProfileIterator =
        FacebookIterator(this,"coworkers", profileEmail)
}