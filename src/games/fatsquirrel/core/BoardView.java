package games.fatsquirrel.core;

import games.fatsquirrel.entities.EntityType;

public interface BoardView {

    EntityType getEntityType(int x, int y);

    XY getSize();

}
