package com.github.welingtonveiga.xadrez.model.movement.direction;

import com.github.welingtonveiga.xadrez.model.Position;

public class UpDirection extends AbstractPositionDirection {

    public UpDirection(Position p) {
        super(p);
    }

    @Override
    public Position get() {
        return Position.of(decAndGetRow(), getCol());
    }
}
