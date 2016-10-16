package com.github.welingtonveiga.xadrez.model.movement.direction;

import com.github.welingtonveiga.xadrez.model.Position;

public class RightDirection extends AbstractPositionDirection {

    public RightDirection(Position p) {
        super(p);
    }

    @Override
    public Position get() {
        return Position.of(getRow(), incAndGetCol());
    }
}
