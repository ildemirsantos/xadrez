package com.github.welingtonveiga.xadrez.model.movement.direction;

import com.github.welingtonveiga.xadrez.model.Position;

public class UpLeftDirection extends AbstractPositionDirection {

    public UpLeftDirection(Position p) {
        super(p);
    }

    @Override
    public Position get() {
        return Position.of(decAndGetRow(), decAndGetCol());
    }
}
