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
    /*calculates distance from mouse click at mouseX and mouseY to center 
    * of image since (x,y) of image is postioned at the top left corner  
    * we use x+(image.pixelWidth/2), y+(image.pixelHeight/2)) to get center*/
    int centerX = x+(image.pixelWidth/2);
    int centerY = y+(image.pixelHeight/2);        
    float d = PApplet.dist(mouseX, mouseY, centerX ,centerY );
    
    //gives us the dimensions of the image 32px by 32px
    System.out.println("image height"+image.pixelHeight);
    System.out.println("image width"+image.pixelWidth);
    
    // returns true if  mouse clicked is within 16px from the center of image
    // we use 16px because the image is 32px by 32px
    return d < 16; 
  }

  public void displayInfo(PApplet p) {
    app.fill(0); // set the fill color to black
    // display the name and age above the person's position
    app.text("Name: " + name, x, y - 50);
    app.text("Age: " + age, x, y - 30); 
  }
}