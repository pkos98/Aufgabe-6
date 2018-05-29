package games.fatsquirrel.entities;

import games.fatsquirrel.core.XY;

import java.util.logging.Logger;

public abstract class Entity {

    private static int idCounter;
    private XY position;
    private int id;
    private int energy;

    public static final int ID_AUTO_GENERATE = -1;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public int getId() {
        return id;
    }

    public XY getPosition() {
        return position;
    }

    public int getEnergy() {
        return energy;
    }

    public abstract int getStartEnergy();

    public void setPosition(XY pos) {
        position = pos;
        logger.info(this.toString() + ": New position " + pos);
    }

    public void updateEnergy(int delta) { //TODO think about Energy<0 in nextStep or new method
            energy += delta;
    }

    @Override
    public String toString() {
        String result = "";
        result += "ID: " + id + System.lineSeparator();
        result += "Position: " + position.toString() + System.lineSeparator();
        result += "Energy: " + energy + System.lineSeparator();
        return result;
    }

    public Entity(int id, int startEnergy, XY startPos) {
        if (id == -1)
            id = idCounter++;
        this.id = id;
        this.energy = startEnergy;
        this.position = startPos;
    }

}
