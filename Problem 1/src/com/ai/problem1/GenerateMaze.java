import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;

public class GenerateMaze extends JPanel
{
	private int size;

    public GenerateMaze(int size)
    {
    	this.setPreferredSize(new Dimension(size, size));

        this.size = size;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
    	super.paintComponent(g);

        int tileSize = size / 101;

        for (int i=0; i<101;i++)
        	{
        		g.drawLine(i*tileSize, 0 , i*tileSize, 101*size );
        		g.drawLine(0, i*tileSize,  101*size, i*tileSize );
        	}
        
        g.setColor(Color.BLACK);
        Random rand1= new Random();
        int RandomNumber=rand1.nextInt(101);
        
        for (int i=0; i < RandomNumber; i++) 
        {
        	for (int j = 0; i+j<RandomNumber; j++)
        	{
        		int RandomRow=rand1.nextInt(101);
        		int RandomCol=rand1.nextInt(101);
        			g.fillRect(RandomRow * tileSize, RandomCol * tileSize, tileSize, tileSize);
        		}
            }
        }

    public static void main(String[] args) 
    {
    	JFrame f = new JFrame();
        Container c = new GenerateMaze(2020);
        f.setContentPane(c);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
    }
}