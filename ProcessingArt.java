
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;


public class ProcessingArt  extends PApplet{


    public static final int WIDTH = 840;
    public static final int HEIGHT = 752;
    int ballCount = 30;

    float[] x = new float[ballCount];
    float[] y = new float[ballCount];
    float[] xSpeed = new float[ballCount];
    float[] ySpeed = new float[ballCount];
    float[] size = new float[ballCount];
    float[] r = new float[ballCount];
    float[] g = new float[ballCount];
    float[] b = new float[ballCount];
    PFont myFont;
    float xPos = 10;
    float yPos = 40;
    float vx = 100;
    float vy = 0;
    float dt = (float) (1.0/30.0);
    float gravity = 400;
    float restitution = (float) .9;
    private double theta=0.05;

    public static void main(String args[])
    {PApplet.main("ProcessingArt",args);}


    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }



    @Override
    public void setup() {
        myFont = createFont("FFScala", 24);
        textFont(myFont);
        PImage crackers = loadImage("/Users/anushag/Downloads/crackers.jpeg");
        background(crackers);
        for(int i = 0; i < ballCount; i++){
            x[i] = random(width);
            y[i] = random(height);
            xSpeed[i] = random(-5, 5);
            ySpeed[i] = random(-5, 5);
            size[i] = random(5, 20);
            r[i] = random(256);
            g[i] = random(256);
            b[i] = random(256);
        }
    }
    @Override
    public void draw() {

        //background(255, 204, 0);
        fill(0,0,0,60);
        rect(0,0,width,height);
        fill(255);
        text("Happy New Year", xPos, yPos);
        textSize(40);
        vy += gravity*dt;
        xPos += vx*dt;
        yPos += vy*dt;
        if (xPos < 0){
            xPos = 0;
            vx *= -restitution;
        } else if (xPos > width-100){
            //The 100 here is roughly the width
            //of the text
            xPos = width-100;
            vx *= -restitution;
        }
        if (yPos > height){
            yPos = height;
            vy *= -restitution;
        }
        for(int i = 0; i < ballCount; i++){
            text("2021",WIDTH/2-10,70);
            fill(r[i]);
            textSize(40);
            x[i] += xSpeed[i];
            if(x[i] < 0 || x[i] > width-10){
                xSpeed[i] *= -1;
            }

            y[i] += ySpeed[i];
            if(y[i] < 0 || y[i] > height-10){
                ySpeed[i] *= -1;
            }

            fill(r[i], g[i], b[i]);
            ellipse(x[i], y[i], size[i], size[i]);

        }

        }
    }


