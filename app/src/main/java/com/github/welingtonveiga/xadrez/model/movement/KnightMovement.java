package com.github.welingtonveiga.xadrez.model.movement;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Piece;
import com.github.welingtonveiga.xadrez.model.Position;

import java.util.HashSet;
import java.util.Set;

public class KnightMovement implements PieceMovement {

    @Override
    public Set<Position> ableMoves(Position current, Board board) {
        final Set<Position> ables;

        final Piece knight = board.getAt(current);
        if (knight == Piece.BLACK_KNIGHT || knight == Piece.WHITE_KNIGHT) {
            ables = resolveAbleMoves(current, board);
        } else {
            throw new IllegalArgumentException(knight + " is trying to use a Knight movement!");
        }

        return ables;
    }

    private Set<Position> resolveAbleMoves(Position current, Board board) {
        Set<Position> ables = new HashSet<>();

        for (Position position : getMoves(current)) {
            if (board.isInBoard(position) && (board.areEnemies(current, position) || board.isEmpty(position))) {
                ables.add(position);
            }
        }

        return ables;
    }

    private Position[] getMoves(Position current) {
        return new Position[]{
            Position.of(current.getRow()+2, current.getCol()+1),
            Position.of(current.getRow()+2, current.getCol()-1),
            Position.of(current.getRow()-2, current.getCol()+1),
            Position.of(current.getRow()-2, current.getCol()-1),
            Position.of(current.getRow()+1, current.getCol()+2),
            Position.of(current.getRow()+1, current.getCol()-2),
            Position.of(current.getRow()-1, current.getCol()+2),
            Position.of(current.getRow()-1, current.getCol()-2),
        };
    }
}
