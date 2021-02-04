package behavioral_pattern.iterator

class Profile(val email: String, name: String, vararg contacts: String) {

    private val contacts: MutableMap<String, MutableList<String>> = mutableMapOf()

    init {
        contacts.forEach { contact ->
            val parts = contact.split(":")
            var contactType = "friend"
            var contactEmail = ""
            if (parts.size==1){
                contactEmail = parts[0]
            } else {
                contactType = parts[0]
                contactEmail = parts[1]
            }
            if (!this.contacts.containsKey(contactType)) {
                this.contacts[contactType] = mutableListOf()
            }
            this.contacts[contactType]?.add(contactEmail)
        }
    }
    fun getContacts(contactType: String): List<String>? = contacts[contactType]?.toList()
}