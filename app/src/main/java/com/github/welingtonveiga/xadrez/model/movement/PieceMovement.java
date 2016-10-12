package com.github.welingtonveiga.xadrez.model.movement;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Position;

import java.util.Set;

public interface PieceMovement {

    Set<Position> ableMoves(Board board);

}
