package L7.Gr06.elements.Enemies;

import L7.Gr06.common.Globals;
import L7.Gr06.elements.Bullet;
import L7.Gr06.elements.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EnemyBeta extends Enemy {
    int vector = 1;
    Integer value = 20;
    Random rand = new Random();

    public EnemyBeta(Position pos, int vector) {
        super(pos, vector);
    }
    @Override
    public Integer getValue() { return value;}
    public boolean collide(Position object){
        return  (getX() <= object.getX() && getX() + 2 >= object.getX()) &&
                (getY() <= object.getY() && getY() + 2 >= object.getY());
    }
@Override
    public void shoot(){
        if (rand.nextInt(100) > 90){
            Position pos = new Position(getX(), getY() + 1);
            Bullet newShot = new Bullet(pos, 1);
            addShot(newShot);
        }
    }

    @Override
    public void draw(TextGraphics s){
        s.setBackgroundColor(TextColor.Factory.fromString(Globals.bgColor));
        s.setForegroundColor(TextColor.Factory.fromString(Globals.textColor));
        s.putString(new TerminalPosition(getX(), getY()), "jk");
        s.putString(new TerminalPosition(getX(), getY()+1), "lm");
        if (!getShots().isEmpty()){
            for (Bullet shot : getShots()){
                shot.draw(s);
            }
        }
    }
}
