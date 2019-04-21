package program.enemy;

import program.GameObject;
import program.Settings;

import java.util.Random;

public class EnemySummoner extends GameObject {
    Random rd=new Random();

    public EnemySummoner(){}
    int count=0;
    public void run(){
        count++;
        while(count> Settings.ENEMY_SUMMON_DELAY) {
            Enemy enemy= Enemy.recycle(Enemy.class);
            enemy.position.set(rd.nextInt(Settings.BACKGROUND_WIDTH),rd.nextInt(Settings.GAME_HEIGHT-100));
            count=0;

        }


    }

}
