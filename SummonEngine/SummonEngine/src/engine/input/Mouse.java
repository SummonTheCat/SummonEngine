package engine.input;

import java.awt.MouseInfo;
import java.awt.Point;

public class Mouse 
{
    public static boolean MOUSE_DOWN[] = new boolean[4];
    public static boolean MOUSE_UP[] = new boolean[4];
    public static boolean MOUSE_TYPED[] = new boolean[4];
    
    public static void ClearMouseTypedState()
    {
        for(boolean state : MOUSE_TYPED) {state = false;}
        for(boolean state : MOUSE_UP) {state = false;}
    }
    
    public static boolean getMouseDown(int button)
    {
        boolean isDown = false;
        if(MOUSE_DOWN[button] == true) isDown = true;
        
        return isDown;
    }
    
    public static boolean getMouseUp(int button)
    {
        boolean isUp = false;
        if(MOUSE_UP[button] == true) isUp = true;
        
        return isUp;
    }
    
    public static boolean getMouseTyped(int button)
    {
        boolean isClicked = false;
        if(MOUSE_TYPED[button] == true) isClicked = true;
        
        return isClicked;
    }
    
    public static Point getMousePos()
    {
        return MouseInfo.getPointerInfo().getLocation();
    }
    
    public static void mouseDown(int mouse, boolean state)
    {MOUSE_DOWN[mouse] = state;}
    
    public static void mouseUp(int mouse, boolean state)
    {MOUSE_UP[mouse] = state;}
    
    public static void mouseTyped(int mouse, boolean state)
    {MOUSE_TYPED[mouse] = state;} 
}
