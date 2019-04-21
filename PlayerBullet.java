package program.player;

import program.GameObject;
import program.Settings;
import program.Vector2D;
import program.enemy.Enemy;
import program.physics.BoxCollider;
import program.renderer.AnimationRenderer;
import program.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
//    BufferedImage image;
//    Vector2D position;
//    Vector2D velocity;
    public int damage;
    public  PlayerBullet(){
       // image= SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        renderer=new AnimationRenderer("assets/images/player-bullets/a");

        position=new Vector2D();//(0,0))
        velocity=new Vector2D(0,-Settings.PBULLET_SPEED);//hoặc velocity.set(x,y);
        hitbox=new BoxCollider(this,24,24);
        damage=Settings.PBULLET_DAMAGE;
    }

    //có thể xóa render();
    public void render(Graphics g){
        super.render(g);
//        g.drawImage(image,(int)position.x,(int)position.y,null);
    }

    //có thể xóa
    @Override
    public void run(){
        super.run();
        this.deactiveIfNeeded();
        this.intersectsEnemy();
    }
    public void deactiveIfNeeded(){
        if(position.y<-30)this.deactive();

    }
    public void intersectsEnemy(){
        Enemy enemy=GameObject.findIntersect(Enemy.class,this.hitbox);
        if(enemy!=null){
            this.deactive();
            enemy.takeDamage(this.damage);
        }
    }
}
