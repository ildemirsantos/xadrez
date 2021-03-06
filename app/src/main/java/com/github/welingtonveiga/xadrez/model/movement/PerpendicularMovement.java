package com.github.welingtonveiga.xadrez.model.movement;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Position;
import com.github.welingtonveiga.xadrez.model.movement.direction.DownDirection;
import com.github.welingtonveiga.xadrez.model.movement.direction.LeftDirection;
import com.github.welingtonveiga.xadrez.model.movement.direction.PositionDirection;
import com.github.welingtonveiga.xadrez.model.movement.direction.RightDirection;
import com.github.welingtonveiga.xadrez.model.movement.direction.UpDirection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class PerpendicularMovement extends AbstractMovement {

    private final int maxMoves;

    public PerpendicularMovement(int maxMoves) {
        this.maxMoves = maxMoves;
    }

    public PerpendicularMovement() {
        this(-1);
    }

    @Override
    public Set<Position> ableMoves(Position current, Board board) {
        Collection<PositionDirection> directions = new ArrayList<>(4);
        directions.add(new UpDirection(current));
        directions.add(new RightDirection(current));
        directions.add(new LeftDirection(current));
        directions.add(new DownDirection(current));

        return resolveAbleMoves(board, current, directions);
    }

    @Override
    protected int getMaxMoves() {
        return maxMoves;
    }
}
