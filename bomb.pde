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

void setup(){

size(canvaswidth, canvasheight);
background(#F52A42);
}



void draw(){

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




int x_vert= int(random(0,3));
int y_vert= int(random(0,3));


rect(x_vert*100,y_vert*100,100,100);
fill(#62E2FA);
	

last_recorded_time=millis();
}




if (moving_trigger == true){
mydodge.display(); 
}
// Define losing condition


}

void keyPressed(){
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