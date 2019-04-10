package program;

import program.Vector2D;

public class Rectangle {
    public Vector2D position;
    public int width;
    public int height;

    public Rectangle() {
        this(new Vector2D(0, 0), 1, 1);
    }

    public Rectangle(double x, double y, int width, int height) {
        this(new Vector2D(x, y), width, height);
    }

    public Rectangle(Vector2D position, int with, int height) {
        this.position = position;
        this.width = with;
        this.height = height;
    }

    /**
     * return true if: this rectangle intersects with the other rectangle
     * else return false
     * @param other: the rectangle need to check intersects with this rectangle
     * @return
     */
    public boolean intersects(Rectangle other) {
        // 1. TODO: remove default return statement and implements methods
        double diffY=this.position.y-other.position.y;
        double diffX=this.position.x-other.position.x;
        if(this.position.y>other.position.y){
            if(diffY>other.height) return false;

            else if(diffY<other.height)return true;

            else{
                if(this.position.x>other.position.x){
                    if(diffX>other.width)return false;
                    else return true;
                }
                else if(this.position.x<other.position.x){
                    if(-diffX>this.width)return false;
                    else return true;
                }
                else return true;
            }
        }
        else if(this.position.y<other.position.y){
            if(-diffY>this.height)return false;
            else if(-diffY<this.height)return true;
            else{
                if(this.position.x>other.position.x){
                    if(diffX>other.width)return false;
                    else return true;
                }
                else if(this.position.x<other.position.x){
                    if(-diffX>this.width)return false;
                    else return true;
                }
                else return true;
            }
        }
        else {
            if(this.position.x<other.position.x){
                if(-diffX>this.width)return false;
                else return true;
            }
            else if(this.position.x>other.position.x){
                    if(diffX>other.width)return false;
                    else return true;
            }
            else return true;
        }

    }



    public static void main(String[] args) {
        // 2. Run this file to test the result
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(3, 3, 5, 5);
        Rectangle rect3 = new Rectangle(6, 6, 5, 5);
        Rectangle rect4 = new Rectangle(7, 5, 3, 12);
//        System.out.println(rect1.intersects(rect2) + " " + true);
//        System.out.println(rect2.intersects(rect3) + " " + true);
//        System.out.println(rect1.intersects(rect3) + " " + false);
//        System.out.println(rect2.intersects(rect1) + " " + true);
//        System.out.println(rect1.intersects(rect2) + " " + true);
        System.out.println(rect1.intersects(rect4));
        System.out.println(rect2.intersects(rect4));
        System.out.println(rect3.intersects(rect4));
        System.out.println(rect4.intersects(rect4));
        // the result must be:
        // true true
        // true true
        // false false
    }
}
