package games.fatsquirrel.core;

import games.fatsquirrel.entities.Entity;

public class Board {

    private Entity[][] entities;

    public BoardConfig getBoardConfig() {
        return boardConfig;
    }

    private BoardConfig boardConfig;
    private FlattenedBoard boardCache;

    public Board(BoardConfig config) {
        this.boardConfig = config;
        this.entities = new Entity[config.getSize().getX()][config.getSize().getY()];
    }

    public XY getSize() {
        return boardConfig.getSize();
    }

    public FlattenedBoard flatten() {
        if (boardCache == null)
            boardCache = new FlattenedBoard(this);
        return boardCache;
    }

    public Entity[][] getEntities() {
        return entities;
    }

    public Entity getEntity (XY location){
        return null;
    }
}
