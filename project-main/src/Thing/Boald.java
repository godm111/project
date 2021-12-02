package Thing;

import java.awt.*;

public class Boald {
    private int boaldState = 0;
    private int boaldX;
    private int boaldY;
    private Color color = Color.blue;
    private final int BOALD_WIDTH = 130;
    private final int BOALD_HEIGHT = 20;

    public Boald(int boaldX, int boaldY) {

        this.boaldX = boaldX;
        this.boaldY = boaldY;
    }

    public int getBoaldX() {
        return boaldX;
    }

    public void setBoaldX(int boaldX) {
        this.boaldX = boaldX;
    }

    public int getBoaldY() {
        return boaldY;
    }

    public void setBoaldY(int boaldY) {
        this.boaldY = boaldY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public int getBOALD_WIDTH() {
        return BOALD_WIDTH;
    }

    public int getBOALD_HEIGHT() {
        return BOALD_HEIGHT;
    }


    public void setBoaldState(int boaldState) {
        this.boaldState = boaldState;
    }
}
