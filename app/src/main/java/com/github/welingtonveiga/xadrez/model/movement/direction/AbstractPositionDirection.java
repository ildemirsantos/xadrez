package com.github.welingtonveiga.xadrez.model.movement.direction;

import com.github.welingtonveiga.xadrez.model.Position;

public abstract class AbstractPositionDirection implements  PositionDirection{

    private int row;
    private int col;

    public AbstractPositionDirection(Position start) {
        this.row = start.getRow();
        this.col = start.getCol();
    }

    @Override
    abstract public Position get();

    protected int getCol() {
        return col;
    }

    protected int getRow() {
        return row;
    }

    protected int incAndGetCol() {
        return ++col;
    }

    protected int incAndGetRow() {
        return ++row;
    }


    protected int decAndGetCol() {
        return --col;
    }

    protected int decAndGetRow() {
        return --row;
    }
}
