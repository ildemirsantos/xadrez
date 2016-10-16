package com.github.welingtonveiga.xadrez.model.movement.direction;

import com.github.welingtonveiga.xadrez.model.Position;

public class UpRightDirection extends AbstractPositionDirection {

    public UpRightDirection(Position p) {
        super(p);
    }

    @Override
    public Position get() {
        return Position.of(incAndGetRow(), decAndGetCol());
    }
}
