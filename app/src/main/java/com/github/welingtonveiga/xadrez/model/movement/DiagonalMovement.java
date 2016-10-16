package com.github.welingtonveiga.xadrez.model.movement;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Position;
import com.github.welingtonveiga.xadrez.model.movement.direction.DownLeftDirection;
import com.github.welingtonveiga.xadrez.model.movement.direction.DownRightDirection;
import com.github.welingtonveiga.xadrez.model.movement.direction.PositionDirection;
import com.github.welingtonveiga.xadrez.model.movement.direction.UpLeftDirection;
import com.github.welingtonveiga.xadrez.model.movement.direction.UpRightDirection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class DiagonalMovement extends AbstractMovement {

    private final int maxMoves;

    public DiagonalMovement(int maxMoves) {
        this.maxMoves = maxMoves;
    }

    public DiagonalMovement() {
        this(-1);
    }

    @Override
    public Set<Position> ableMoves(Position current, Board board) {
        Collection<PositionDirection> directions = new ArrayList<>(4);
        directions.add(new UpLeftDirection(current));
        directions.add(new UpRightDirection(current));
        directions.add(new DownLeftDirection(current));
        directions.add(new DownRightDirection(current));

        return resolveAbleMoves(board, current, directions);
    }

    @Override
    protected int getMaxMoves() {
        return maxMoves;
    }
}
