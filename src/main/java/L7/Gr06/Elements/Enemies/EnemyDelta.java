package L7.Gr06.Elements.Enemies;

import L7.Gr06.Audio.SoundPlayer;
import L7.Gr06.Common.Globals;
import L7.Gr06.Elements.Shots.Bullet;
import L7.Gr06.Elements.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;



public class EnemyDelta extends Enemy {
    SoundPlayer soundPlayer = new SoundPlayer();
    Integer value = 500;
    Integer health = 200;

    public EnemyDelta(Position pos, int vector) {
        super(pos, vector);
    }
    @Override
    public Integer getValue() { return value;}
    @Override
    public Integer getHealth() { return health;}
    @Override
    public void setHealth(Integer health) {this.health = health;}
    @Override
    public void shoot(int randomNum){
        if (randomNum > 40){
            Position pos = new Position(getX(), getY() + 1);
            Bullet newShot = new Bullet(pos, 1);
            addShot(newShot);
            soundPlayer.playShootSound();
        }
    }
    @Override
    public boolean collide(Position object){
        return  (getX() <= object.getX() && getX() + 2 >= object.getX()) &&
                (getY() <= object.getY() && getY() + 2 >= object.getY());
    }
    @Override
    public void draw(TextGraphics s){
        s.setBackgroundColor(TextColor.Factory.fromString(Globals.bgColor));
        if (health == 2)
            s.setForegroundColor(TextColor.Factory.fromString(Globals.textColor));
        else
            s.setForegroundColor(TextColor.Factory.fromString("#db7e46"));
        s.putString(new TerminalPosition(getX(), getY()), "vwx");
        s.putString(new TerminalPosition(getX(), getY()+1), "yz{");
        s.putString(new TerminalPosition(getX(), getY()+2), "|}~");
        if (!getShots().isEmpty()){
            for (Bullet shot : getShots()){
                shot.draw(s);
            }
        }
    }
}
