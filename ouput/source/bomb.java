import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class bomb extends PApplet {

int canvaswidth=300;
int canvasheight=300;

int stage_num=1; float bomb_speed;
int x_pos= 150; int y_pos=150;
dodge mydodge = new dodge(x_pos, y_pos,60);


int[] space = new int[9];
boolean moving_trigger = false;

int interval=1000;
int last_recorded_time=0;
int x_vert, y_vert;

public void setup(){

size(canvaswidth, canvasheight);
background(0xffF52A42);
}



public void draw(){

line(0,0,0,300); stroke(0);
line(0,0,300,0); stroke(0);
line(300,0,300,300); stroke(0);
line(0,300,300,300); stroke(0);
line(100,0,100,300); stroke(0); 
line(200,0,200,300); stroke(0);
line(0,100,300,100); stroke(0);
line(0,200,300,200); stroke(0);


if (millis()-last_recorded_time>interval){
// Define bomb PATTERN

int[] arr_x_vert = new int[stage_num+4];
int[] arr_y_vert = new int[stage_num+4];

//




int x_vert= PApplet.parseInt(random(0,3));
int y_vert= PApplet.parseInt(random(0,3));


rect(x_vert*100,y_vert*100,100,100);
fill(0xff62E2FA);
	

last_recorded_time=millis();
}




if (moving_trigger == true){
mydodge.display(); 
}
// Define losing condition


}

public void keyPressed(){
	switch(key){
	case 'd':
		mydodge.move_right();
		break;
	case 's':
		mydodge.move_down();
		break;
	case 'a':
		mydodge.move_left();
		break;
	case 'w':
		mydodge.move_up();
		break;
	}
}
class dodge {


  float x, y; // x,y location
  float rad; // width and height
  
  dodge(float temp_x, float temp_y, float temp_r)
  {
	x = temp_x;
    y = temp_y;
    rad = temp_r;	
  }
   	
  public void display(){	  
	  ellipse(x,y,60,60);	
	  fill(0xff29CB4D);
	  noStroke();
  }	
  
  public void move_left(){
	if (x>100){
		x -= 100;
	}
	//display();
  }
 
  public void move_right(){
	if (x<200){
		x+=100;
	}  
  }
  
  public void move_up(){
	if (y>100){
	   y-=100;	
	}  
  }
  
  public void move_down(){
	if (y<200){
		y+=100;
	}  
  }
  
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "bomb" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
