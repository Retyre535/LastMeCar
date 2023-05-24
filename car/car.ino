#include <DFPlayerMini_Fast.h>
#include "TFLidar.h"
#include <SoftwareSerial.h>

int a;
int E1 = 10;
int M1 = 12;
int E2 = 11;
int M2 = 13;

SoftwareSerial mySerial(6, 5);
SoftwareSerial mySerialLidar(3, 9);

#define LIDAR_SERIAL    mySerialLidar
 

TFLidar lidar;
int dist;

DFPlayerMini_Fast myMP3;

boolean myAvailable = true ;
 
void setup() {
  mySerial.begin(9600);
  myMP3.begin(mySerial);
  myMP3.volume(20);
  play();
  pause();
  
  Serial.begin(9600);
  while (!Serial);

  Serial.print("Serial init OK\r\n");
  LIDAR_SERIAL.begin(115200);
  lidar.begin(&LIDAR_SERIAL);
  
  pinMode(M1, OUTPUT);
  pinMode(M2, OUTPUT);

  stopp();
}
 
void loop() {
  lidar.getData(dist);
  //Serial.println(dist);
  pause();
  if ((dist > 1) and (dist <30)){
    backward();
    delay(10);
    stopp();
    myAvailable = true;
    }
  else{
    boolean myAvailable = false ;
    }
  if (Serial.available()) {
    a = Serial.read();
    //Serial.println(a);
    Serial.println(myAvailable);
    Serial.println(dist);
    if (myAvailable){
    switch (a) {
      case (49):
        forward();
        break;
      case (50):
        backward();
        break;
      case (51):
        left();
        break;
      case (52):
        right();
        break;
      case (53):
        resum();
        break;
      case (54):
        stopp();
        break;  
    }
  }
  delay(10);
}
}

void play() {
  myMP3.play(1);  
}

void pause() {
  myMP3.pause();
}

void resum(){
  myMP3.resume();
  }

void stopp() {
  digitalWrite(M1, LOW);
  digitalWrite(M2, LOW);
  analogWrite(E1, 0);
  analogWrite(E2, 0);
}

void forward() {
  for (int value = 0 ; value <= 255; value += 5) {
    digitalWrite(M1, LOW);
    digitalWrite(M2, LOW);
    analogWrite(E1, value);
    analogWrite(E2, value);
  }
}

void backward() {
  for (int value = 0 ; value <= 255; value += 5) {
    digitalWrite(M1, HIGH);
    digitalWrite(M2, HIGH);
    analogWrite(E1, value);
    analogWrite(E2, value);
  }
}

void left() {
  for (int value = 0 ; value <= 255; value += 5) {
    digitalWrite(M1, LOW);
    digitalWrite(M2, HIGH);
    analogWrite(E1, value);
    analogWrite(E2, value);
  }
}

void right() {
  for (int value = 0 ; value <= 255; value += 5) {
    digitalWrite(M1, HIGH);
    digitalWrite(M2, LOW);
    analogWrite(E1, value);
    analogWrite(E2, value);
  }
}
