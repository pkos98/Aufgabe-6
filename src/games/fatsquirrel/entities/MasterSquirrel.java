package games.fatsquirrel.entities;

import games.fatsquirrel.console.GameCommandType;
import games.fatsquirrel.core.EntityContext;
import games.fatsquirrel.core.XY;
import games.fatsquirrel.util.XYSupport;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class MasterSquirrel extends PlayerEntity {

    private GameCommandType input;
    private List<MiniSquirrel> miniSquirrels = new LinkedList<>();
    private static int START_ENERGY = 0;
    private Logger logger = Logger.getLogger(this.getClass().getName());


    public MasterSquirrel(int id, int startEnergy,XY startPos) {
        super(id, startEnergy, startPos);
    }

    public boolean checkEntity(Entity entity) {
        return false;
    }

    public void setInput(GameCommandType input) {
        this.input = input;
    }

    public void addMiniSquirrel(MiniSquirrel miniSquirrel) {
        miniSquirrels.add(miniSquirrel);
    }

    @Override
    public XY nextStep(EntityContext entityContext) {
        if (input == null)
            return getPosition();

        if (isParalyzed(true))
            return getPosition();
        entityContext.tryMove(this, XYSupport.convertFromGameCommand(input));
        return getPosition();
    }

    @Override
    public int getStartEnergy() {
        return START_ENERGY;
    }

    @Override
    public String toString() {
        return "MasterSquirrel";
    }

    public GameCommandType getInput() {
        return input;
    }
}
