package program.enemy;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import program.physics.BoxCollider;
import program.player.PlayerBullet;
import program.renderer.AnimationRenderer;
import program.renderer.Renderer;
import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import static java.lang.Math.PI;

public class Enemy extends GameObject {
    public int hp;
    public Enemy(){
        //image= SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        renderer=new AnimationRenderer("assets/images/enemies/level0/pink");
        position.set(150,200);
        hitbox=new BoxCollider(this,28,28);
        hp=Settings.ENEMY_HP;
    }
    public void run(){
        super.run();
        //this.fire();
    }


    public void takeDamage(int damage){
        hp-=damage;
        if(hp<=0){
            hp=0;
            this.deactive();
        }
    }


}
