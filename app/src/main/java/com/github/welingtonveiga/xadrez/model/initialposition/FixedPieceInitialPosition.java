package com.github.welingtonveiga.xadrez.model.initialposition;

import com.github.welingtonveiga.xadrez.model.Position;
import com.github.welingtonveiga.xadrez.model.initialposition.PieceInitialPosition;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FixedPieceInitialPosition implements PieceInitialPosition {
    private final Set<Position> positions;

    public FixedPieceInitialPosition(Position... pos) {
        this.positions = new HashSet<>();
        Collections.addAll(this.positions, pos);
    }

    @Override
    public Set<Position> get() {
        return Collections.unmodifiableSet(positions);
    }
}
