package arenas;
/*
    Generic Arena for all game levels.
 */

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import common.Globals;
import elements.*;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    String bgColor = "#117491";
    String fgColor = "#ede9dd";
    public Hero hero = new Hero(new Position(Globals.width/2, Globals.height-2));

    public List<Enemy> enemies = new ArrayList<Enemy>();

    public Arena(){
        //constructor
    }



    //if the draw function wouldn't be overridden, default graphic appears
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString(bgColor));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(Globals.width, Globals.height), ' ');
        graphics.enableModifiers(SGR.BOLD);
        graphics.setForegroundColor(TextColor.Factory.fromString(fgColor));
        graphics.putString(new TerminalPosition(Globals.width/2-7, Globals.height/2), "default graphic");

    }
}
