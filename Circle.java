import java.awt.*;//must be imported to use Graphics

public class Circle
{
    private static int x;
    private static int y;
    private int xShift;
    private int yShift;
    private static int radius = 70;
    private static int hits = 0;
    public Circle( int xLoc, int yLoc )
    {
        xShift=5;
        yShift=5;
        x = xLoc+radius/2;
        y = yLoc+radius/2;
    }
    public static int getHit(){
        return hits;
    }
    public void move()
    {
        x = x + xShift;
        y = y + yShift;
        if (x<= 0&&xShift<0){
            xShift *=-1;
        }
        if (y<=0&&yShift<0){
            yShift = -1*yShift;
        }
        
        if (x+radius>=constants.getWidth()&&xShift>0){
            xShift = -1*xShift;
        }
        if (y+radius>=constants.getHeight()&&yShift>0){
            yShift = -1*yShift;
        }
    }
    public int getCircX(){
        return x;
    }
    public int getCircY(){
        return y;
    }
    public int getCircRad(){
        return radius;
    }
    public static int collision(){
        if (Math.sqrt((x-Projectile.getX())*(x-Projectile.getX())+
        (y-Projectile.getY())*(y-Projectile.getY()))
        <= radius+constants.getProjectileRadius()){
            hits++;
            constants.setProjectileRadius(0);
        }
        return hits;
    }
    public void draw( Graphics page )
    {
        if (Circle.collision()==0){page.setColor( new Color( 0, 255, 0) );}//color defined using rgb values (0-255 each)
        else if (Circle.collision()==1){page.setColor( new Color( 255, 240, 95) );}//color defined using rgb values (0-255 each)
        else if (Circle.collision()==2){page.setColor( new Color( 255, 190, 70) );}//color defined using rgb values (0-255 each)
        else if (Circle.collision()==3){page.setColor( new Color( 255, 0, 0) );}//color defined using rgb values (0-255 each)
        else {page.setColor( new Color( 10, 10, 10) );}//color defined using rgb values (0-255 each)
        page.fillOval( x, y, radius, radius );//change the last two numbers and see what happens
    }
}