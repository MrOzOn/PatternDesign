package behavioral_pattern.mediator

interface Component {
    fun setMediator(mediator: Mediator)
    fun getName(): String
}