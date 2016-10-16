package com.github.welingtonveiga.xadrez.model.movement.direction;

import com.github.welingtonveiga.xadrez.model.Position;

public class DownRightDirection extends AbstractPositionDirection {

    public DownRightDirection(Position p) {
        super(p);
    }

    @Override
    public Position get() {
        return Position.of(incAndGetRow(), incAndGetCol());
    }
}
