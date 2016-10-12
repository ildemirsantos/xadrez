package com.github.welingtonveiga.xadrez.model.initialposition;

import com.github.welingtonveiga.xadrez.model.Position;

import java.util.HashSet;
import java.util.Set;

public class PieceInitialPositionByInterval implements PieceInitialPosition {

    private final int startX,  startY,  endX,  endY;

    public PieceInitialPositionByInterval(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public PieceInitialPositionByInterval(int line, int endX, int endY) {
        this.startX = line;
        this.startY = line + 1;
        this.endX = endX;
        this.endY = endY;
    }

    @Override
    public Set<Position> get() {
        Set<Position> positions = new HashSet<>();
        for (int i = startX; i < startY; i++) {
            for (int j=endX; j < endY; j++) {
                positions.add(Position.of(i, j));
            }
        }
        return positions;
    }
}
