import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class Game extends JPanel implements KeyListener
{
    private Player player;
    private Circle circle;
    private Projectile projectileW;
    private Projectile projectileA;
    private Projectile projectileS;
    private Projectile projectileD;
    private JLabel label;
    private int points;
    private Sound track;
    boolean projectileInitW;
    boolean projectileInitA;
    boolean projectileInitS;
    boolean projectileInitD;
    boolean over;
    //constructor - sets the initial conditions for this Game object
    public Game(int width, int height)
    {
        //make a panel with dimensions width by height with a black background
        this.setLayout( null );//Don't change
        this.setBackground( new Color(150,150,150 ));
        this.setPreferredSize( new Dimension( constants.getWidth(), constants.getHeight () ));//Don't change
        
        //initialize the instance variables
        over = false;
        player = new Player( (constants.getWidth())/2, (constants.getHeight())/2);  //change these numbers and see what happens
        circle = new Circle( 400, 200 );
        label = new JLabel("Points: " + points);
        this.add( label );
        label.setBounds(300,50,400,50);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Arial",Font.BOLD,32));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        projectileInitW=false;
        projectileInitA=false;
        projectileInitS=false;
        projectileInitD=false;
        this.addKeyListener(this);//allows the program to respond to key presses - Don't change
        track = new Sound("song.wav");
        track.loop();
        this.setFocusable(true);//I'll tell you later - Don't change
    }

    //This is the method that runs the game
    public void playGame()
    {
        while( !over )
        {
            circle.move();
            player.move();
            Circle.collision();
            points++;
            label.setText("Points = " + points);
            if (projectileInitW)
                {projectileW.moveW();}
            if (projectileInitA)
                {projectileA.moveA();}
            if (projectileInitS)
                {projectileS.moveS();}
            if (projectileInitD)
                {projectileD.moveD();}
            try
            {
                Thread.sleep( 17 );//pause for 17 milliseconds
            }
            catch( InterruptedException ex ){}
            Circle.collision();
            this.repaint();//redraw the screen with the updated locations; calls paintComponent below
        }
        track.stop();
    }

    //Precondition: executed when repaint() or paintImmediately is called
    //Postcondition: the screen has been updated with current player location
    public void paintComponent( Graphics page )
    {
        super.paintComponent( page );//I'll tell you later.
        player.draw( page );//calls the draw method in the Player class
        circle.draw( page );
        if (projectileInitW)
            projectileW.draw( page );
        if (projectileInitA)
            projectileA.draw( page );
        if (projectileInitS)
            projectileS.draw( page );
        if (projectileInitD)
            projectileD.draw( page );
    }

    //tells the program what to do when keys are pressed
    public void keyReleased( KeyEvent event )
    {
        if( event.getKeyCode() == KeyEvent.VK_RIGHT )
        {
            player.setRight(false);
        }
        else if( event.getKeyCode() == KeyEvent.VK_LEFT )
        {
            player.setLeft(false);
        }
        if( event.getKeyCode() == KeyEvent.VK_UP )
        {
            player.setUp(false);
        }
        else if( event.getKeyCode() == KeyEvent.VK_DOWN )
        {
            player.setDown(false);
        }
        if( event.getKeyCode() == KeyEvent.VK_W )
        {
            projectileW = new Projectile(player.getX(), player.getY());
            projectileInitW=true;
        }
        if( event.getKeyCode() == KeyEvent.VK_A )
        {
            projectileA = new Projectile(player.getX(), player.getY());
            projectileInitA=true;
        }
        if( event.getKeyCode() == KeyEvent.VK_S )
        {
            projectileS = new Projectile(player.getX(), player.getY());
            projectileInitS=true;
        }
        if( event.getKeyCode() == KeyEvent.VK_D )
        {
            projectileD = new Projectile(player.getX(), player.getY());
            projectileInitD=true;
        }
    }
    
    //not used but must be present
    public void keyPressed( KeyEvent event )
    {
        if( event.getKeyCode() == KeyEvent.VK_RIGHT )
        {
            player.setRight(true);
        }
        else if( event.getKeyCode() == KeyEvent.VK_LEFT )
        {
            player.setLeft(true);
        }
        if( event.getKeyCode() == KeyEvent.VK_UP )
        {
            player.setUp(true);
        }
        else if( event.getKeyCode() == KeyEvent.VK_DOWN )
        {
            player.setDown(true);
        }
    }
    //not used but must be present
    public void keyTyped( KeyEvent event )
    {}
}