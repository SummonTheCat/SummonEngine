package engine.graphics;

import engine.input.Keyboard;
import engine.input.Mouse;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// Class imports
import javax.swing.JFrame;

public class GraphicsWindow extends JFrame{
    
    private final String windowTitle;
    
    private final int windowHeight;
    private final int windowWidth;
    private final boolean windowUndecorated;
    
    //The components in the JFrame
    private GraphicsCanvas canvas;
    
    // Sort out window settings
    public GraphicsWindow(String title, int ww, int wh, boolean undecorated)
    {
        windowTitle = title;
        windowHeight = wh;
        windowWidth = ww;
        windowUndecorated = undecorated;
    }
    
    // used to setup the window
    public void Init()
    {
        //General setup stuff
        setTitle(windowTitle);
        setUndecorated(windowUndecorated);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Setting up the canvas
        canvas = new GraphicsCanvas();
        canvas.setFocusable(true);
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
        canvas.setCursor(engine.utils.Cursor.hiddenCursor());
        
        //Setup for input
        setFocusable(true);
        requestFocusInWindow();
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                Keyboard.keyDown(e.getKeyCode(), true);
                Keyboard.keyTyped(e.getKeyCode(), false);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Keyboard.keyUp(e.getKeyCode(), true);
                Keyboard.keyDown(e.getKeyCode(), false);
            }
        });
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                Mouse.mouseDown(e.getButton(), true);
                Mouse.mouseTyped(e.getButton(), false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Mouse.mouseUp(e.getButton(), true);
                Mouse.mouseDown(e.getButton(), false);
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        
        setContentPane(canvas);
        
        //Pack the components to make sure the window fits the canvas
        pack();
    }
}
