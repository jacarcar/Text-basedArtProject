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

public class TextProject extends PApplet {

//you can press 0,1,2,3,4,5,6,7,8,-,+

//first part is from someone else
public int idcount=0;
public class myTextField
{
  float dec=10;
  int id=(idcount);
  String textStr = "";
  float alpha = 255;
  int myx=0;
  int myy=0;
  
  public myTextField(String str,int a,int x,int y,float dec)
  {
    idcount++;
    this.textStr = str;
    this.alpha = a;
    this.myx=x;
    this.myy=y;
    this.dec=dec;
  }
  
  public void showText()
  {
    if(colorMode == 1)
    {
      fill(PApplet.parseInt(random(2))*PApplet.parseInt(random(255)),PApplet.parseInt(random(2))*PApplet.parseInt(random(255)),PApplet.parseInt(random(2))*PApplet.parseInt(random(255)),(int)alpha);
    }
    else
    {
      fill(0,0,0,(int)alpha);
    }
    stroke(0);
    strokeWeight(10);
    text(textStr,myx,myy);
  }
}

int size = 120;
int state = 0;
int bgMode, colorMode, textMode, i, start = 0;
int bgShade = 200;
ArrayList<String> lines = new ArrayList<String>();
//test list/programming themed
String[] list = {"Error", "False", "True", "While", "For", "If", "Else"};
//themed lists
String[] list1 = {"Anxiety", "Stress", "Pressure", "Deadlines", "Depression", "Work"};
String[] list2 = {"Now you see me", "Now you don't", "Over here", "Look at me", "Don't look at me"};
myTextField[] mylist = new myTextField[100];

public void setup()
{
  
  fill(0);
  textSize(size);
  
  if(bgMode == 1)
  {
    background(PApplet.parseInt(random(2))*PApplet.parseInt(random(200)),PApplet.parseInt(random(2))*PApplet.parseInt(random(200)),PApplet.parseInt(random(2))*PApplet.parseInt(random(200)));
  }
  else
  {
    background(bgShade);
  }
  
  if(state == 1)
  {
    lines.clear();
    lines.ensureCapacity(list1.length);
    for(int i=0;i<list1.length;i++)
    {
      lines.add(list1[i]);
    }
    lines.trimToSize();
  }
  else if(state == 2)
  {
    lines.clear();
    lines.ensureCapacity(list2.length);
    for(int i=0;i<list2.length;i++)
    {
      lines.add(list2[i]);
    }
    lines.trimToSize();
  }
  else
  {
    lines.clear();
    lines.ensureCapacity(list.length);
    for(int i=0;i<list.length;i++)
    {
      lines.add(list[i]);
    }
    lines.trimToSize();
  }
  
  if(textMode == 0)
  {
    for(int i=0;i<lines.size();i++)
    {
      mylist[i] = new myTextField(lines.get(i),PApplet.parseInt(random(200,255)),PApplet.parseInt(random(displayWidth-(lines.get(i).length()+2)*size/2)),PApplet.parseInt(random(size,displayHeight)),PApplet.parseInt(random(30,50)));
      mylist[i].showText();
    }
  }
}

public void draw()
{
  if(textMode == 0)
  {
    if(millis()-start >= 200)
    {
      if(bgMode == 1)
      {
        background(PApplet.parseInt(random(2))*PApplet.parseInt(random(200)),PApplet.parseInt(random(2))*PApplet.parseInt(random(200)),PApplet.parseInt(random(2))*PApplet.parseInt(random(200)));
      }
      else
      {
        background(bgShade);
      }
      
      for(int i=0;i<lines.size();i++)
      {
        if(mylist[i].alpha <= 0)
        {
          mylist[i] = new myTextField(lines.get(i),PApplet.parseInt(random(200,255)),PApplet.parseInt(random(displayWidth-(lines.get(i).length()+2)*size/2)),PApplet.parseInt(random(size,displayHeight)),PApplet.parseInt(random(30,50)));
        }
        else
        {
          mylist[i].alpha-=mylist[i].dec;
        }
        mylist[i].showText();
        if(keyPressed)
        {
          break;
        }
      }
      start = millis();
    }
  }
  
  else
  {
    if(millis()-start >= 100)
    {
        if(colorMode == 1)
      {
        fill(PApplet.parseInt(random(2))*PApplet.parseInt(random(255)),PApplet.parseInt(random(2))*PApplet.parseInt(random(255)),PApplet.parseInt(random(2))*PApplet.parseInt(random(255)));
      }
      else
      {
        fill(0,0,0);
      }
      //original concept
      text(lines.get(i),PApplet.parseInt(random(displayWidth-(lines.get(i).length()+2)*size/2)),PApplet.parseInt(random(size,displayHeight)));
      if(i+1 >= lines.size())
      {
        i = 0;
      }
      else
      {
        i++;
      }
      start = millis();
    }
  }
  
  if(keyPressed)
  {
    if(key == '0')
    {
      state = 0;
      setup();
    }
    else if(key == '1')
    {
      state = 1;
      setup();
    }
    else if(key == '2')
    {
      state = 2;
      setup();
    }
    else if(key == '3')
    {
      bgMode = 1;
      setup();
    }
    else if(key == '4')
    {
      bgMode = 0;
      setup();
    }
    else if(key == '5')
    {
      colorMode = 1;
      setup();
    }
    else if(key == '6')
    {
      colorMode = 0;
      setup();
    }
    else if(key == '+')
    {
      if(size < 500)
      {
        size += 10;
        setup();
      }
    }
    else if(key == '-')
    {
      if(size > 10)
      {
        size -= 10;
        setup();
      }
    }
    else if(key == '7')
    {
      textMode = 1;
      mylist[i].alpha = 255;
      setup();
    }
    else if(key == '8')
    {
      textMode = 0;
      setup();
    }
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "TextProject" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
