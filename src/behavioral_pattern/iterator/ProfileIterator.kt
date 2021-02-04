package behavioral_pattern.iterator

interface ProfileIterator {
    fun hasNext(): Boolean
    fun getNext(): Profile?
    fun reset()
}