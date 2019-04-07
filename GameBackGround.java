package program;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameBackGround extends GameObject
{
//    BufferedImage image;

//    Vector2D position;
//    Vector2D velocity;

    public GameBackGround() {
        image= SpriteUtils.loadImage("assets/images/background/0.png");
        position=new Vector2D(0,600-3109);
        velocity=new Vector2D(0,10);
    }

    public void render(Graphics g)
    {
//        g.drawImage(image,(int)position.x,(int)position.y,null);
        super.render(g);
    }

    public void run()
    {
//        position.add(velocity.x,velocity.y);//thay vi positon.y+=10;
        super.run();
        if(position.y>=0) position.setY(600-3109);
    }

}
