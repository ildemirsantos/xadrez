package com.github.welingtonveiga.xadrez.model.movement;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Position;

import java.util.Collections;
import java.util.Set;

public interface PieceMovement {

    static PieceMovement EMPTY_MOVEMENT = new PieceMovement() {
        @Override
        public Set<Position> ableMoves(Position current, Board board) {
            return Collections.emptySet();
        }
    };

    Set<Position> ableMoves(Position current, Board board);

}
