package com.github.welingtonveiga.xadrez.model.movement.direction;

import com.github.welingtonveiga.xadrez.model.Position;

public class DownLeftDirection extends AbstractPositionDirection {

    public DownLeftDirection(Position p) {
        super(p);
    }

    @Override
    public Position get() {
        return Position.of(decAndGetRow(), incAndGetCol());
    }
}
