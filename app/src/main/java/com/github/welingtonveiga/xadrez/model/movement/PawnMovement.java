package com.github.welingtonveiga.xadrez.model.movement;

import android.support.annotation.NonNull;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Piece;
import com.github.welingtonveiga.xadrez.model.Position;

import java.util.HashSet;
import java.util.Set;

public class PawnMovement implements PieceMovement {

    private static final int WHITE_DIRECTION = -1;
    private static final int BLACK_DIRECTION = +1;

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
        int direction = getDirection(pawn);

        Set<Position> ables = new HashSet<>();
        Position position = getFrontPosition(current, direction);

        ables.addAll(getAbleEnemyPosition(board, pawn, getLeftPosition(current, direction)));
        ables.addAll(getAbleEnemyPosition(board, pawn, getRightPosition(current, direction)));
        ables.addAll(getAbleFrontPosition(board, position));

        if (ables.contains(position)) {
            ables.addAll(getAbleInitialFrontExtra(board, pawn, current, getFrontPosition(position, direction)));
        }

        return ables;
    }

    private int getDirection(Piece pawn) {
        int direction = WHITE_DIRECTION;
        if (pawn.getColor() == Piece.Color.BLACK) {
            direction = BLACK_DIRECTION;
        }
        return direction;
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
        if (board.isInBoard(position) && pawn.isInitial(current) && (board.isEmpty(position) || board.hasEnemyAt(pawn, position))){
            ables.add(position);
        }
        return ables;
    }

    private  Set<Position> getAbleEnemyPosition(Board board, Piece pawn, Position enemy) {
        Set<Position> ables = new HashSet<>();
        if (board.isInBoard(enemy) && hasAnEnemy(board, pawn, enemy)) {
            ables.add(enemy);
        }
        return ables;
    }

    private boolean hasAnEnemy(Board board, Piece pawn, Position position) {
        return !board.isEmpty(position) && board.getAt(position).getColor() == pawn.getColor().inverse();
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
}
