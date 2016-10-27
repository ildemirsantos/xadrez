package com.github.welingtonveiga.xadrez.model;

import com.github.welingtonveiga.xadrez.model.initialposition.FixedPieceInitialPosition;
import com.github.welingtonveiga.xadrez.model.initialposition.PieceInitialPosition;
import com.github.welingtonveiga.xadrez.model.initialposition.PieceInitialPositionByInterval;
import com.github.welingtonveiga.xadrez.model.movement.DiagonalMovement;
import com.github.welingtonveiga.xadrez.model.movement.FullMovement;
import com.github.welingtonveiga.xadrez.model.movement.KnightMovement;
import com.github.welingtonveiga.xadrez.model.movement.PawnMovement;
import com.github.welingtonveiga.xadrez.model.movement.PerpendicularMovement;
import com.github.welingtonveiga.xadrez.model.movement.PieceMovement;

import java.util.Collections;
import java.util.Set;

public enum Piece {
    NONE(null, PieceMovement.EMPTY_MOVEMENT, new PieceInitialPositionByInterval(2, 6, 0, 8)),
    BLACK_BISHOP(Color.BLACK, new DiagonalMovement(), new FixedPieceInitialPosition(Position.of(0, 2), Position.of(0, 5))),
    BLACK_KING(Color.BLACK, new FullMovement(1), new FixedPieceInitialPosition(Position.of(0, 3))),
    BLACK_QUEEN(Color.BLACK, new FullMovement(), new FixedPieceInitialPosition(Position.of(0, 4))),
    BLACK_PAWN(Color.BLACK, new PawnMovement(), new  PieceInitialPositionByInterval(1, 2, 0, 8)),
    BLACK_KNIGHT(Color.BLACK, new KnightMovement(), new FixedPieceInitialPosition(Position.of(0, 1), Position.of(0, 6))),
    BLACK_ROOK(Color.BLACK, new PerpendicularMovement(), new FixedPieceInitialPosition(Position.of(0, 0), Position.of(0, 7))),
    WHITE_BISHOP(Color.WHITE, new DiagonalMovement(), new FixedPieceInitialPosition(Position.of(7, 2), Position.of(7, 5))),
    WHITE_KING(Color.WHITE, new FullMovement(1), new FixedPieceInitialPosition(Position.of(7, 4))),
    WHITE_QUEEN(Color.WHITE, new FullMovement(), new FixedPieceInitialPosition(Position.of(7, 3))),
    WHITE_PAWN(Color.WHITE, new PawnMovement(), new  PieceInitialPositionByInterval(6, 7, 0, 8)),
    WHITE_KNIGHT(Color.WHITE, new KnightMovement(), new FixedPieceInitialPosition(Position.of(7, 1), Position.of(7, 6))),
    WHITE_ROOK(Color.WHITE, new PerpendicularMovement(), new FixedPieceInitialPosition(Position.of(7, 0), Position.of(7, 7)));

    private final Color color;

    private final PieceInitialPosition initialPosition;

    private final PieceMovement movement;

    Piece(Color color, PieceMovement movement, PieceInitialPosition initialPosition) {
        this.color = color;
        this.initialPosition = initialPosition;
        this.movement = movement;
    }

    public Boolean isInitial(Position position) {
        return initialPosition.get().contains(position);
    }

    public Color getColor() {
        return color;
    }

    public PieceMovement getMovement() {
        return movement;
    }

    public Set<Position> getInitialPositions() {
        return Collections.unmodifiableSet(initialPosition.get());
    }

    public enum Color {
        WHITE,
        BLACK;

        public Color inverse() {
            Color reverse = WHITE;
            if (this == WHITE) {
                reverse = BLACK;
            }
            return reverse;
        }
    }

}
