package engine.utils;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Cursor extends java.awt.Cursor
{
    public Cursor(int type) {
        super(type);
    }
 
    public static java.awt.Cursor hiddenCursor()
    {
        // Transparent 16 x 16 pixel cursor image.
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        // Create a new blank cursor.
        java.awt.Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");

        return blankCursor;
    }
}
