package games.fatsquirrel.core;
import games.fatsquirrel.botapi.ControllerContext;
import games.fatsquirrel.entities.EntityType;
import games.fatsquirrel.entities.MasterSquirrel;
import games.fatsquirrel.entities.MiniSquirrel;
import games.fatsquirrel.entities.PlayerEntity;

public class MiniSquirrelBot extends MiniSquirrel {

    public MiniSquirrelBot(int id, XY startPos, MasterSquirrel master) {
        super(id, startPos, master);
    }

    private class ControllerContextImpl implements ControllerContext {

        private final XY xy;
        private final EntityContext entityContext;
        private final int sightRange = 21;
        public ControllerContextImpl(PlayerEntity playerEntity, XY xy, EntityContext entityContext){
            this.xy = xy;
            this.entityContext = entityContext;
        }

        @Override
        public XY getViewLowerLeft() {
            return new XY(MiniSquirrelBot.this.getPosition().getX() - sightRange,MiniSquirrelBot.this.getPosition().getY()- sightRange);
        }

        @Override
        public XY getViewUpperRight() {
            return new XY(MiniSquirrelBot.this.getPosition().getX() + sightRange,MiniSquirrelBot.this.getPosition().getY()+ sightRange);
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
            XY toMove = new XY(MiniSquirrelBot.this.getPosition().getX()+ direction.getX(), MiniSquirrelBot.this.getPosition().getY() + direction.getY());
            MiniSquirrelBot.this.setPosition(toMove);
        }

        @Override
        public void spawnMiniBot(XY direction, int energy) {
            //TODO should not be allowed --> Exception?
        }

        @Override
        public void implode(int impactRadius) {
            this.entityContext.implode(MiniSquirrelBot.this, impactRadius);
        }

        @Override
        public int getEnergy() {
            return MiniSquirrelBot.this.getEnergy();
        }

        @Override
        public XY directionOfMaster() {
            return null;
        }

        @Override
        public long getRemainingSteps() {
            return 0;
        }

        @Override
        public void shout(String text) {

        }
    }
}
