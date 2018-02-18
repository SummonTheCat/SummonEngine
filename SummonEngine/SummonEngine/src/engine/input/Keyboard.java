package engine.input;

public class Keyboard 
{
    public static boolean KEY_DOWN[] = new boolean[249];
    public static boolean KEY_UP[] = new boolean[249];
    public static boolean KEY_TYPED[] = new boolean[249];
    
    
    
    public static void ClearKeyTypedState()
    {
        for(boolean state : KEY_TYPED) {state = false;}
        for(boolean state : KEY_UP) {state = false;}
    }
    
    public static boolean getKeyDown(int key)
    {
        boolean isDown = false;
        if(KEY_DOWN[key] == true) isDown = true;
        
        return isDown;
    }
    
    public static boolean getKeyUp(int key)
    {
        boolean isUp = false;
        if(KEY_UP[key] == true) isUp = true;
        
        return isUp;
    }
    
    public static boolean getKeyTyped(int key)
    {
        boolean isTyped = false;
        if(KEY_TYPED[key] == true) isTyped = true;
        
        return isTyped;
    }
    
    public static void keyDown(int key, boolean state)
    {KEY_DOWN[key] = state;}
    public static void keyUp(int key, boolean state)
    {KEY_UP[key] = state;}
    public static void keyTyped(int key, boolean state)
    {KEY_TYPED[key] = state;}
}
