package games.fatsquirrel.core;

import games.fatsquirrel.botapi.ControllerContext;
import games.fatsquirrel.entities.EntityType;
import games.fatsquirrel.entities.MasterSquirrel;
import games.fatsquirrel.entities.PlayerEntity;

public class MasterSquirrelBot extends MasterSquirrel {

    public MasterSquirrelBot(int id, int startEnergy, XY startPos) {
        super(id, startEnergy, startPos);
        /*ControllerContext proxy = (ControllerContext) Proxy.newProxyInstance(
                ControllerContext.class.getClassLoader(),
                new Class[]{ControllerContext.class},
                handler);*/
    }

    private class ControllerContextImpl implements ControllerContext {

        private final XY xy;
        private final EntityContext entityContext;
        private final int sightRange = 31;


        public ControllerContextImpl(PlayerEntity playerEntity, XY xy, EntityContext entityContext) {
            this.xy = xy;
            this.entityContext = entityContext;
        }

        @Override
        public XY getViewLowerLeft() {
        return new XY(MasterSquirrelBot.this.getPosition().getX() - sightRange, MasterSquirrelBot.this.getPosition().getY() - sightRange);
        }

        @Override
        public XY getViewUpperRight() {
            return new XY(MasterSquirrelBot.this.getPosition().getX() + sightRange, MasterSquirrelBot.this.getPosition().getY() + sightRange);
        }

        @Override
        public XY locate() {
            return null;
        }

        @Override
        public EntityType getEntityAt(XY xy) {
            return entityContext.getEntityType(xy);
        }

        @Override
        public boolean isMine(XY xy) {
            return false;
        }

        @Override
        public void move(XY direction) {
            XY toMove = new XY(MasterSquirrelBot.this.getPosition().getX() + direction.getX(), MasterSquirrelBot.this.getPosition().getY() + direction.getY());
            MasterSquirrelBot.this.setPosition(toMove);
        }

        @Override
        public void spawnMiniBot(XY direction, int energy) {
            //TODO
        }

        @Override
        public void implode(int impactRadius) {
        }

        @Override
        public int getEnergy() {
            return MasterSquirrelBot.this.getEnergy();
        }

        @Override
        public XY directionOfMaster() {
            return null;
        }

        @Override
        public long getRemainingSteps() {
            return 0;
        }
    }
}