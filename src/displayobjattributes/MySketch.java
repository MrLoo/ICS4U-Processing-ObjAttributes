package displayobjattributes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 090464
 */
import processing.core.PApplet;

public class MySketch extends PApplet {
  private Person person; // declare a person object
  private boolean showInfo = false; // whether or not to display the person's info

  
  public void settings() {
    size(400, 400);
  }
  public void setup() {
    background(255); // set the background color to white
    // create a person object in the center of the screen
    person = new Person(this, 100, 100, "Mr. Lu", 99, "images/person.png"); 
  }
  
  public void draw() {
    background(255); // clear the screen
    person.draw(); // draw the person on the screen
   if (showInfo) {
      // display the person's info if the showInfo flag is true
      person.displayInfo(this); 
    }
  }
  
  public void mousePressed() {
    if (person.isClicked(mouseX, mouseY)) {
      // toggle the showInfo flag when the person is clicked
      showInfo = !showInfo; 
    } else {
      // hide the person's info if the mouse is clicked elsewhere
      showInfo = false; 
    }
  }
}



