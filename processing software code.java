Import processing.serial, *; //imports library for serial communication
Import java.awt.event.keyevent; //import library for reading the data from the 
	Serial port
Import java.io.IDException;
Serial myport; // defines object serial
// defubes variables
String angle “”;
String distance “”;
String data “”;
String noobject;
Float pixdistance;
Int iAngle, iDistance;
Int index1-0;
Int index2-0;
PFont orcFont;
Void setup() {

Size (1280,720); //***CHANGE THIS TO YOUR SCREEN RESOUTION***
Smooth();
Myport – new serial(this, “COM3”, 9600); //starts the serial communication, 
                Change this to your port type
Myport.bufferunit(‘,’);// reads the data from the serial port up to the character ‘,’. 
                	So actually it reads this: angle, distance.
}
Void draw(){
 Fill(98,245,31);
//simulating motion blur and slow fade of the moving line
Nostroke();
Fill(0,4);
Rect(0,0, width, height- height*0.065);

Fill(98,245,31);//green color
//calls the function for drawing the radar
Drawradar();
Drawline();
Drewobject();
Drawtext();
}
Void serialevent (serial myport){// starts reading data from the serial port
//reads the data from the serial port up to the character ‘,’ and put it into the string variable “data”.
Data- myport.readstringuntil(‘,’);
Data- data.substring(0, data.length()-1);

Index – data.indexof(“,”);//find the character ‘,’ and puts it into the variable “index1”
Angle- data.substring(0,index1);// read the data from postion “0” to position of the variable index1 or that the value of the angle the Arduino board sent into the serial port
Distance – data.substring(index1+1,data.length());//read the data from poition “index1” to the end the data pr that value of the distance

//convert the string variables into integer
iAngle – int(angle);
iDistance – int(distance);
}
Void drawradar(){
Pushmatrix();
iAngle – int(angle);
iDistance – int(distance);
}
Void drawradar() {
Pushmatrix();
Translate(width/2, height-height*0.074);// moves the starting to new location
noFill();
strokeweight(2);
stroke (98,245,31);
//draws the arc lines
Arc(0,0,(width-width*0.0625),(width-width*0.0625),PI,TWO_PI);
Arc(0,0,(width-width*0.27),(width-width*0.27),PI,TWO_PI);
Arc(0,0,(width-width*0.479),(width-width*0.479),PI,TWO_PI);
Arc(0,0,(width-width*0.687),(width-width*0.687),PI,TWO_PI);
//draws the angle lines
Line(-width/2, 0, width/2, 0);
Line(0,0,(-width/2)*cos(radians(30)),(-width/2)*sin(radians(30)));
Line(0,0,(-width/2)*cos(radians(60)),(-width/2)*sin(radians(60)));
Line(0,0,(-width/2)*cos(radians(90)),(-width/2)*sin(radians(90)));
Line(0,0,(-width/2)*cos(radians(120)),(-width/2)*sin(radians(120)));
Line(0,0,(-width/2)*cos(radians(150)),(-width/2)*sin(radians(150)));
Line((-width/2)*cos(radians(30)),0, width/2,0);
Popmatrix();
}
Void drawobject(){
Pushmatrix():
Translate(width/2,height-height*0.074);//moves the starting coordinates to new location
//limiting the range to 40 cms
If(iDistance<40){
//draws the object according to the angle and the distance
Line(pixsDistance*cos(radians(angle)),-pixsDistance*sin(radians(iAangle)), (width-width*0.505)*cos(radians(iAngle)), -(width-width*0.505)*sin
(radians(iAangle)));
}
Popmatrix();
}
Void drawline(){
Pushmatrix();
Strokeweight(9);
Stroke(30,250,60);
Translate(width/2,height-height*0.074);//moves the starting coordinates to new location
Line(0,0(height-height*0.12)*cos(radians(iAangle)),-(height-height*0.12) 
*sin(radians(iAngle))); // draws the line according to the angle
Popmartix();
}
Void drawtext(){//draws the texts on the screen
Pushmatrix();
If(iDistance>40){
Noobject-“Out Of Range”;
}
Else{
Noobject – “In Range”;
Translated(width/2,height-height*0.074);// moves the starting coordinates to new location
Line(0,0(height-height*0.12)*cos(radians(iAangle)),-(height-height*0.12) 
*sin(radians(iAngle))); // draws the line according to the angle
Popmartix();
}
Void drawtext() {// draws the texts on the screen 
Pushmatrix();
If(iDistance>40){
noObject –“Out Of Range”;
}
Else{
noObject –“In Range”;
}
Fill(0,0,0);
Nostroke();
Rect(0, height-height*0.0648, width, height);
Fill(98,245,31);
Textsize(25);
Text(“10cm”, width-width*0.3854, height-height*0.0833);
Text(“20cm”, width-width*0.281, height-height*0.0833);
Text(“30cm”, width-width*0.177, height-height*0.0833);
Text(“40cm”, width-width*0.0729, height-height*0.0833);
Textsize(40);
Text(“object:” +noobject, width- width*0.875,height-height*0.0277);
Text(“angle:” +iangle +”0”, width- width*0.48,height-height*0.0277);
Text(“distance:”, width- width*0.26,height-height*0.0277);
If(iDistance<40){
Text(“   ” +iDistance+ “cm” width- width*0.225,height-height*0.0277);
}
Textsize(25);
Fill(98,245,60);
Translate((width-width*0.4994)+width/2*cos(radians(30)),(height-height
*0.0907 ) -width/2*sin(radians (30)));
Rotate(-radians(-60));
Text(“300”, 0,0);
Resetmatrix();
Translate((width-width*0.503)+width/2*cos(radians(60)),(height-height
*0.0888 ) -width/2*sin(radians (60)));
Rotate(-radians(-30));
Text(“600”, 0,0);
Resetmatrix();
Translate((width-width*0.507)+width/2*cos(radians(90)),(height-height
*0.0833 ) -width/2*sin(radians (90)));
Rotate(-radians(0));
Text(“900”, 0,0);
Resetmatrix();
Translate((width-width*0.513)+width/2*cos(radians(120)),(height-height
*0.07129 ) -width/2*sin(radians (120)));
Rotate(-radians(-30));
Text(“120”, 0,0);
Resetmatrix();
Translate((width-width*0.5104)+width/2*cos(radians(150)),(height-height
*0.0574 ) -width/2*sin(radians (150)));
Rotate(-radians(-60));
Text(“150”, 0,0);
popmatrix();
}