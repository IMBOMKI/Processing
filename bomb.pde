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






void setup(){

size(canvaswidth, canvasheight);
background(#F52A42);
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
	temp_x = int(random(0,3));
	temp_y = int(random(0,3));
	
	if (i==0){
		arr_x_vert[i] = temp_x;
    	arr_y_vert[i] = temp_y;	
	}
	
	else if (i>0){
		while(temp_x == arr_x_vert[i-1]  && temp_y == arr_y_vert[i-1])
		{
			temp_x = int(random(0,3));
			temp_y = int(random(0,3));
		}
		arr_x_vert[i] = temp_x;
		arr_y_vert[i] = temp_y;
	}

	
	}
}



void draw(){


//--PreStage--//

if (game_stage_trigger == false){

if (millis()-last_recorded_time>interval){
	
//---------Safe Space-------------------------/

if (pattern_num>0){	
fill(#F52A42);
rect(arr_x_vert[pattern_num-1]*100,arr_y_vert[pattern_num-1]*100,100,100);
	
}
	
fill(#62E2FA);	
rect(arr_x_vert[pattern_num]*100,arr_y_vert[pattern_num]*100,100,100);


	
//--------------------------------------------/

last_recorded_time=millis();

pattern_num++;
}

if (pattern_num == total_pattern){
	fill(#F52A42);
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