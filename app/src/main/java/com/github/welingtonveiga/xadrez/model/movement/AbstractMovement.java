package com.github.welingtonveiga.xadrez.model.movement;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Piece;
import com.github.welingtonveiga.xadrez.model.Position;
import com.github.welingtonveiga.xadrez.model.movement.direction.PositionDirection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractMovement implements PieceMovement{

    @Override
    public Set<Position> ableMoves(Position current, Board board) {
        return null;
    }

    protected abstract int getMaxMoves();


    protected  Set<Position> resolveAbleMoves(Board board, Position current, Collection<PositionDirection> positionDirections) {
        Set<Position> ables = new HashSet<>();
        for (PositionDirection direction : positionDirections) {
            ables.addAll(resolveDirectionAbleMoves(board, current, direction));
        }
        return ables;
    }

    protected Set<Position> resolveDirectionAbleMoves(Board board, Position current, PositionDirection positionDirection) {
        Set<Position> ables = new HashSet<>();

        int moves = getMaxMoves();
        Piece currentPiece = board.getAt(current);
        for ( Position p = positionDirection.get(); board.isInBoard(p); p = positionDirection.get() ) {
            Piece piece = board.getAt(p);

            if (piece == Piece.NONE) {
                ables.add(p);
                moves--;
                if (moves != 0) {
                    continue;
                }
            }

            if (piece.getColor() != currentPiece.getColor()) {
                ables.add(p);
            }

            break;
        }

        return ables;
    }
}
