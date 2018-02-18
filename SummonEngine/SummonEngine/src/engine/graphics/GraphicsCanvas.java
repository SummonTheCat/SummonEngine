package engine.graphics;

import static engine.input.Mouse.getMousePos;
import engine.utils.Screen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GraphicsCanvas extends JPanel
{
    @Override
    public void paintComponent(Graphics g) 
    {
        Graphics2D g2D = (Graphics2D)g;
        Draw(g2D);
    }
    
    private void Draw(Graphics2D g)
    {
        g.fillRect(0, 0, Screen.width, Screen.height);
        
        g.setColor(Color.lightGray);
        g.drawOval(getMousePos().x - 5, getMousePos().y - 5, 10, 10);
    }
}
