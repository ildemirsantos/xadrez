package com.github.welingtonveiga.xadrez.model;

import com.github.welingtonveiga.xadrez.model.initialposition.FixedPieceInitialPosition;
import com.github.welingtonveiga.xadrez.model.initialposition.PieceInitialPosition;
import com.github.welingtonveiga.xadrez.model.initialposition.PieceInitialPositionByInterval;

import java.util.Collections;
import java.util.Set;

public enum Piece {
    NONE(null, new PieceInitialPositionByInterval(2, 6, 0, 8)),
    BLACK_BISHOP(Color.BLACK, new FixedPieceInitialPosition(Position.of(0, 2), Position.of(0, 5))),
    BLACK_KING(Color.BLACK, new FixedPieceInitialPosition(Position.of(0, 3))),
    BLACK_QUEEN(Color.BLACK, new FixedPieceInitialPosition(Position.of(0, 4))),
    BLACK_PAWN(Color.BLACK, new  PieceInitialPositionByInterval(1, 2, 0, 8)),
    BLACK_KNIGHT(Color.BLACK, new FixedPieceInitialPosition(Position.of(0, 1), Position.of(0, 6))),
    BLACK_ROOK(Color.BLACK, new FixedPieceInitialPosition(Position.of(0, 0), Position.of(0, 7))),
    WHITE_BISHOP(Color.BLACK, new FixedPieceInitialPosition(Position.of(7, 2), Position.of(7, 5))),
    WHITE_KING(Color.WHITE, new FixedPieceInitialPosition(Position.of(7, 4))),
    WHITE_QUEEN(Color.WHITE, new FixedPieceInitialPosition(Position.of(7, 3))),
    WHITE_PAWN(Color.WHITE, new  PieceInitialPositionByInterval(6, 7, 0, 8)),
    WHITE_KNIGHT(Color.WHITE, new FixedPieceInitialPosition(Position.of(7, 1), Position.of(7, 6))),
    WHITE_ROOK(Color.WHITE, new FixedPieceInitialPosition(Position.of(7, 0), Position.of(7, 7)));

    private final Color color;

    private final PieceInitialPosition initialPosition;


    Piece(Color color, PieceInitialPosition initialPosition) {
        this.color = color;
        this.initialPosition = initialPosition;
    }

    public Set<Position> getInitialPositions() {
        return Collections.unmodifiableSet(initialPosition.get());
    }

    public enum Color {
        WHITE,
        BLACK;
    }

}
