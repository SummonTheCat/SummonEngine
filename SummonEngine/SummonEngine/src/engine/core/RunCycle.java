package engine.core;

import engine.graphics.GraphicsWindow;
import engine.input.Keyboard;
import engine.utils.Screen;

public class RunCycle 
{
    //Engine Components
    static GraphicsWindow gameWindow;
    
    //Engine States
    static boolean engineRunning = true;
    
    //Engine stats
    public static int lastFPS;
    public static int lastTicks;
    
    public static void main(String[] args)
    {
        // Setup windows
        gameWindow = new GraphicsWindow("Test Window", Screen.width, Screen.height, true);
        gameWindow.Init();

        //Game loop
        GameLoop(75);
        
    }
    
    //Game loop
    static void GameLoop(int targetFPS)
    {
        //Game Loop
        long lastTime = System.nanoTime();
        double amountOfTicks = targetFPS;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        
        while(engineRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
		Update();
                frames++;
                Draw();
		updates++;
                Keyboard.ClearKeyTypedState();
		delta--;
            }
            
            if(System.currentTimeMillis() - timer > 1000)
            {
                lastFPS = frames;
                lastTicks = updates;
                timer += 1000;
            	frames = 0;
            	updates = 0;
            }
        }
    }
    
    //Update loop
    private static void Update()
    {
        
    }
    
    //Update loop
    private static void Draw()
    {
        gameWindow.repaint();
    }
}
