import java.awt.*;//must be imported to use Graphics
public class Player
{
    private static int x;
    private static int y;
    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;
    public Player( int xLoc, int yLoc )
    {
        x = xLoc;
        y = yLoc;
        right = false;
        left = false;
        up = false;
        down = false;
    }
    public void move()
    {
        if (left) {
            if(x>0){x = x - 5;}
            else{x=x;}
        }
        if (right) {
            if(x<constants.getWidth()-constants.getPlayerRadius()){x = x + 5;}
            else{x=x;}
        }
        if (up){
            if(y>0){y = y - 5;}
            else{y=y;}
        }
        if (down) {
            if(y<constants.getHeight()-constants.getPlayerRadius()){y = y + 5;}
            else{y=y;}
        }
    }
    public void setLeft(boolean l)
    {
        left = l;
    }
    public void setRight(boolean r)
    {
        right = r;
    }
    public void setUp(boolean u)
    {
        up = u;
    }
    public void setDown(boolean d)
    {
        down = d;
    }
    public void draw( Graphics page )
    {
        page.setColor( Color.BLUE );
        page.fillOval( x, y, constants.getPlayerRadius(), constants.getPlayerRadius() );//change the last two numbers and see what happens
    }
    public static int getX(){return x;}
    public static int getY(){return y;}
}