package com.github.welingtonveiga.xadrez.model.movement;

import android.support.annotation.NonNull;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Piece;
import com.github.welingtonveiga.xadrez.model.Position;

import java.util.HashSet;
import java.util.Set;

public class PawnMovement implements PieceMovement {

    @Override
    public Set<Position> ableMoves(Position current, Board board) {
        final Set<Position> ables;

        final Piece pawn = board.getAt(current);
        if (pawn == Piece.BLACK_PAWN || pawn == Piece.WHITE_PAWN) {
            ables = resolveAbleMoves(current, board, pawn);
        } else {
            throw new IllegalArgumentException(pawn + " is trying to use a pawn movement!");
        }

        return ables;
    }

    @NonNull
    private Set<Position> resolveAbleMoves(Position current, Board board, Piece pawn) {
        Set<Position> ables;
        int direction = -1;
        if (pawn.getColor() == Piece.Color.BLACK) {
            direction = +1;
        }
        return resolveAbleMoves(current, board, pawn, direction);
    }

    @NonNull
    private Set<Position> resolveAbleMoves(Position current, Board board, Piece pawn, int direction) {
        Set<Position> ables = new HashSet<>();
        Position position = getFrontPosition(current, direction);

        ables.addAll(getAbleFrontPosition(board, position));
        if (!ables.isEmpty()) {
            ables.addAll(getAbleInitialFrontExtra(board, pawn, current, getFrontPosition(position, direction)));
        }
        ables.addAll(getAbleEnemyPosition(board, pawn, getLeftPosition(current, direction)));
        ables.addAll(getAbleEnemyPosition(board, pawn, getRightPosition(current, direction)));

        return ables;
    }

    private Set<Position> getAbleFrontPosition(Board board,Position position) {
        Set<Position> ables = new HashSet<>();
        if (board.isInBoard(position) && board.isEmpty(position)) {
            ables.add(position);
        }
        return ables;
    }

    private Set<Position> getAbleInitialFrontExtra(Board board, Piece pawn, Position current, Position position) {
        Set<Position> ables = new HashSet<>();
        if (board.isInBoard(position) && pawn.getInitialPositions().contains(current) && (board.isEmpty(position) || hasAnEnemy(board, pawn, position))){
            ables.add(position);
        }
        return ables;
    }

    private Position getFrontPosition(Position current, int direction) {
        return Position.of(current.getRow()+direction, current.getCol());
    }

    private Position getRightPosition(Position current, int direction) {
        return Position.of(current.getRow()+direction, current.getCol()+1);
    }

    private Position getLeftPosition(Position current, int direction) {
        return Position.of(current.getRow()+direction, current.getCol()-1);
    }

    private  Set<Position> getAbleEnemyPosition(Board board, Piece pawn, Position left) {
        Set<Position> ables = new HashSet<>();
        if (board.isInBoard(left) && hasAnEnemy(board, pawn, left)) {
            ables.add(left);
        }
        return ables;
    }

    private boolean hasAnEnemy(Board board, Piece pawn, Position position) {
        return !board.isEmpty(position) && board.getAt(position).getColor() == pawn.getColor().inverse();
    }
}
