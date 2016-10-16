package com.github.welingtonveiga.xadrez.model.movement.direction;

import com.github.welingtonveiga.xadrez.model.Position;

public class LeftDirection extends AbstractPositionDirection {

    public LeftDirection(Position p) {
        super(p);
    }

    @Override
    public Position get() {
        return Position.of(getRow(), decAndGetCol());
    }
}
