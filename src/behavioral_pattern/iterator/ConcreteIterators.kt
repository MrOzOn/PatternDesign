package behavioral_pattern.iterator

class FacebookIterator(private val facebook: Facebook, private val type: String, private val email: String): ProfileIterator {

    private var currentPosition = 0
    private val emails: MutableList<String> = mutableListOf()
    private val profiles: MutableList<Profile?> = mutableListOf()

    private fun lazyLoad(){
        if(emails.isEmpty()) {
            val facebookProfiles = facebook.requestProfileFriendsFromFacebook(email, type)
            facebookProfiles.forEach { profile ->
                emails.add(profile)
                profiles.add(null)
            }
        }
    }

    override fun hasNext(): Boolean {
        lazyLoad()
        return currentPosition < emails.size
    }

    override fun getNext(): Profile? {
        if(!hasNext())
            return null
        val friendEmail = emails[currentPosition]
        var friendProfile = profiles[currentPosition]
        if (friendProfile==null){
            friendProfile = facebook.requestProfileFromFacebook(friendEmail)
            profiles.set(currentPosition, friendProfile)
        }
        currentPosition++
        return friendProfile
    }

    override fun reset() {
        currentPosition = 0
    }

}

class LinkedInIterator(private val linkedIn: LinkedIn, private val type: String, private val email: String): ProfileIterator {
    private var currentPosition = 0
    private val emails: MutableList<String> = mutableListOf()
    private val profiles: MutableList<Profile?> = mutableListOf()

    private fun lazyLoad(){
        if(emails.isEmpty()) {
            val facebookProfiles = linkedIn.requestRelatedContactsFromLinkedInAPI(email, type)
            facebookProfiles.forEach { profile ->
                emails.add(profile)
                profiles.add(null)
            }
        }
    }

    override fun hasNext(): Boolean {
        lazyLoad()
        return currentPosition < emails.size
    }

    override fun getNext(): Profile? {
        if(!hasNext())
            return null
        val friendEmail = emails[currentPosition]
        var friendProfile = profiles[currentPosition]
        if (friendProfile==null){
            friendProfile = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail)
            profiles.set(currentPosition, friendProfile)
        }
        currentPosition++
        return friendProfile
    }

    override fun reset() {
        currentPosition = 0
    }

}