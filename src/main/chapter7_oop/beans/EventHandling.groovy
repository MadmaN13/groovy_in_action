package chapter7_oop.beans

import javax.swing.JButton
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

// Java
final JButton javaButton = new JButton("Push me!");
javaButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent event){
        System.out.println(javaButton.getText());
    }
} );

// Groovy
groovyButton = new JButton('Push me!')
groovyButton.actionPerformed = { event ->
    println groovyButton.text
}
