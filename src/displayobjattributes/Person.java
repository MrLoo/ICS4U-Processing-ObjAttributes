package displayobjattributes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import processing.core.PApplet;
import processing.core.PImage;

public class Person {
  private int x, y; // position of the person
  private String name; // name of the person
  private int age; // age of the person
  private PImage image; // image of the person
  private PApplet app; // the canvas used to display
  public Person(PApplet p, int x, int y, String name, int age, String imagePath) {
    this.app = p;
    this.x = x;
    this.y = y;
    this.name = name;
    this.age = age;
    this.image = app.loadImage(imagePath);
  }
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }
  public void draw() {
    // draw the image at the person's position
    app.image(image, x, y); 
    
  }
  
  public boolean isClicked(int mouseX, int mouseY) {
    float d = PApplet.dist(mouseX, mouseY, x+(image.pixelWidth/2), y+(image.pixelHeight/2));
    System.out.print(image.pixelHeight);
    System.out.println(image.pixelWidth);
    app.ellipse(x, y, 2, 2);
    // return true if  mouse is within 25px of the person's position
    return d < 16; 
  }

  public void displayInfo(PApplet p) {
    app.fill(0); // set the fill color to black
    // display the name and age above the person's position
    app.text("Name: " + name, x, y - 50);
    app.text("Age: " + age, x, y - 30); 
  }
}

