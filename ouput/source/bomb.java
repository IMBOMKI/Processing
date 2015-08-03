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
int total_pattern=stage_num+4;


int x_pos= 150; int y_pos=150;
dodge mydodge = new dodge(x_pos, y_pos,60);


int[] space = new int[9];
boolean moving_trigger = false;
boolean game_stage_trigger = false;


int interval=250;
int last_recorded_time=0;
int x_vert, y_vert;
int pattern_num=0;

int[] arr_x_vert = new int[stage_num+100];   // bomb pattern
int[] arr_y_vert = new int[stage_num+100];

// initial pattern

int temp_x; int temp_y;






public void setup(){

size(canvaswidth, canvasheight);
background(0xffF52A42);
//mydodge.initialization();


line(0,0,0,300); stroke(0);
line(0,0,300,0); stroke(0);
line(300,0,300,300); stroke(0);
line(0,300,300,300); stroke(0);
line(100,0,100,300); stroke(0); 
line(200,0,200,300); stroke(0);
line(0,100,300,100); stroke(0);
line(0,200,300,200); stroke(0);



for (int i=0; i<(total_pattern); i++){
	temp_x = PApplet.parseInt(random(0,3));
	temp_y = PApplet.parseInt(random(0,3));
	
	if (i==0){
		arr_x_vert[i] = temp_x;
    	arr_y_vert[i] = temp_y;	
	}
	
	else if (i>0){
		while(temp_x == arr_x_vert[i-1]  && temp_y == arr_y_vert[i-1])
		{
			temp_x = PApplet.parseInt(random(0,3));
			temp_y = PApplet.parseInt(random(0,3));
		}
		arr_x_vert[i] = temp_x;
		arr_y_vert[i] = temp_y;
	}

	
	}
}



public void draw(){


//--PreStage--//

if (game_stage_trigger == false){

if (millis()-last_recorded_time>interval){
	
//---------Safe Space-------------------------/

if (pattern_num>0){	
fill(0xffF52A42);
rect(arr_x_vert[pattern_num-1]*100,arr_y_vert[pattern_num-1]*100,100,100);
	
}
	
fill(0xff62E2FA);	
rect(arr_x_vert[pattern_num]*100,arr_y_vert[pattern_num]*100,100,100);


	
//--------------------------------------------/

last_recorded_time=millis();

pattern_num++;
}

if (pattern_num == total_pattern){
	fill(0xffF52A42);
	rect(arr_x_vert[pattern_num-1]*100,arr_y_vert[pattern_num-1]*100,100,100);
	game_stage_trigger = true;
	moving_trigger = true;
	pattern_num=0;
}

}
//-----------//




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
 // float past_x, past_y;
  float rad; // width and height
 
  dodge(float temp_x, float temp_y, float temp_r)
  {
	x = temp_x;
    y = temp_y;
    rad = temp_r;	
  }
  	
  public void display(){
 	
	  fill(0xff29CB4D);
	  ellipse(x,y,60,60);	
	  
	  noStroke();
  }	
  
  public void move_left(){
	fill(0xffF52A42);
	rect((x-50),(y-50),100,100);
	if (x>100){
		x -= 100;
		fill(0xffF52A42);
	}
	//display();
  }
 
  public void move_right(){
	fill(0xffF52A42);
	rect((x-50),(y-50),100,100);
	if (x<200){
		x+=100;
	}  
  }
  
  public void move_up(){
	fill(0xffF52A42);
	rect((x-50),(y-50),100,100);
	if (y>100){
	   y-=100;	
	}  
  }
  
  public void move_down(){
	fill(0xffF52A42);
	rect((x-50),(y-50),100,100);
	if (y<200){
		y+=100;
	}  
  }
  public void fill_up(){
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
