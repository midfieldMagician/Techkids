package program.renderer;

import program.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerRender extends Renderer {
    ArrayList<BufferedImage> imagesl;
    ArrayList<BufferedImage> imagesr;
    ArrayList<BufferedImage> imagess;

    int currentImageIndex;
    int count=0;
    public PlayerRender(String dirPathl,String dirPathr,String dirPaths ){
        imagesl= SpriteUtils.loadImages(dirPathl);
        imagesr=SpriteUtils.loadImages(dirPathr);
        imagess=SpriteUtils.loadImages(dirPaths);
        currentImageIndex=0;
    }




    @Override
    public void render(Graphics g, GameObject player) {

    if(player.velocity.x<0){
       // images=imagesl;
        //for(int i=0;i<imagesl.size();i++)images.add(imagesl.get(i));
        this.render1(g,player,imagesl);
        //images.remove(imagesl);
    }
    else if(player.velocity.x>0){
        images=imagesr;
        //for(int i=0;i<imagesr.size();i++)images.add(imagesr.get(i));
        this.render1(g,player,imagesr);
        //images.remove(imagesr);
    }
    else {
        images=imagess;
        //for(int i=0;i<imagess.size();i++)images.add(imagess.get(i));
        this.render1(g,player,imagess);
        //images.remove(imagess);
    }

    }

    public void render1(Graphics g, GameObject master,ArrayList<BufferedImage> images) {
        BufferedImage currentImage=images.get(currentImageIndex);
        g.drawImage(currentImage,(int)master.position.x,(int)master.position.y,null);
        count++;
        if(count>25){
            currentImageIndex++;
            if(currentImageIndex>=images.size())currentImageIndex=0;
        }
    count=0;
    }
}
