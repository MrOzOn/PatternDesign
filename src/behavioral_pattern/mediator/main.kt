package behavioral_pattern.mediator

import javax.swing.DefaultListModel

fun main(){
    val mediator = Editor()
    mediator.registerComponent(Title())
    mediator.registerComponent(TextBox())
    mediator.registerComponent(AddButton())
    mediator.registerComponent(DeleteButton())
    mediator.registerComponent(SaveButton())
    mediator.registerComponent(List(DefaultListModel<Note>()))
    mediator.registerComponent(Filter())

    mediator.createGUI()
}