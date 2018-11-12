import java.awt.*;//must be imported to use Graphics
public class Projectile
{
    private static int x;
    private static int y;
    private Projectile projectile;
    public Projectile(int xCoor, int yCoor){
        x = xCoor+(constants.getProjectileRadius())/2;
        y = yCoor;
    }
    public void moveW()
    {
        x = x;
        y = y - 5;
    }
    public void moveA()
    {
        x = x - 5;
        y = y;
    }
    public void moveS()
    {
        x = x;
        y = y + 5;
    }
    public void moveD()
    {
        x = x + 5;
        y = y;
    }
    public static int getX(){
        return x;
    }
    public static int getY(){
        return y;
    }
    public void draw( Graphics page )
    {
        page.setColor( new Color( 255, 0, 0 ) );//color defined using rgb values (0-255 each)
        page.fillOval( x, y, constants.getProjectileRadius(), constants.getProjectileRadius() );//change the last two numbers and see what happens
    }
}
