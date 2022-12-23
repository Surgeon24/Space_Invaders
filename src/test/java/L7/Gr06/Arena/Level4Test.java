package L7.Gr06.Arena;

import L7.Gr06.Common.Globals;
import L7.Gr06.Elements.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Level4Test {
    private Screen screen;
    private TextGraphics tg;
    @Test
    void createEnemies(){
        Arena arena = new Level4();
        assertEquals(new Position(3,9),  arena.enemies.get(1).getPosition());
        assertEquals(new Position(3,12),  arena.enemies.get(2).getPosition());
        assertEquals(new Position(3,21),  arena.enemies.get(4).getPosition());
        assertEquals(new Position(9,12), arena.enemies.get(7).getPosition());
    }

    @Test
    void createWalls(){
        Arena arena = new Level4();
        assertEquals(new Position(5, Globals.height-8), arena.walls.get(0).getPosition());
        assertEquals(new Position(25,Globals.height-8), arena.walls.get(1).getPosition());
        assertEquals(new Position(45,Globals.height-8), arena.walls.get(2).getPosition());
    }

    @Test
    void changePositions() {
        Arena arena = new Level4();
        assertEquals(new Position(3,12),  arena.enemies.get(2).getPosition());
        assertEquals(new Position(3,21),  arena.enemies.get(4).getPosition());
        assertEquals(new Position(9,12),  arena.enemies.get(7).getPosition());
        arena.changePositions();
        assertEquals(new Position(4,12),  arena.enemies.get(2).getPosition());
        assertEquals(new Position(2,21),  arena.enemies.get(4).getPosition());
        assertEquals(new Position(10,12), arena.enemies.get(7).getPosition());
        //shouldn't change anything, because frame didn't change
        arena.changePositions();
        assertEquals(new Position(4,12),  arena.enemies.get(2).getPosition());
        assertEquals(new Position(2,21),  arena.enemies.get(4).getPosition());
        assertEquals(new Position(10,12), arena.enemies.get(7).getPosition());
    }
    @Test
    void draw(){
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        Arena arena = new Level1();
        arena.draw(tg);
        Mockito.verify(tg, Mockito.times(arena.enemies.size()+2)).setBackgroundColor(TextColor.Factory.fromString(Globals.bgColor));
        Mockito.verify(tg, Mockito.times(arena.enemies.size()+2)).setBackgroundColor(TextColor.Factory.fromString(Globals.bgColor));
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(Globals.width, Globals.height), ' ');;
        Mockito.verify(tg, Mockito.times(2)).enableModifiers(SGR.BOLD);
    }

}
