package com.github.welingtonveiga.xadrez.model.movement.direction;

import com.github.welingtonveiga.xadrez.model.Position;

public class DownDirection extends AbstractPositionDirection {

    public DownDirection(Position p) {
        super(p);
    }

    @Override
    public Position get() {
        return Position.of(incAndGetRow(), getCol());
    }
}
