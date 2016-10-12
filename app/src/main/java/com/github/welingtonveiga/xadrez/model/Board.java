package com.github.welingtonveiga.xadrez.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {

    public static int DIMENSION_SIZE = 8;


    private final Map<Position,Piece> pieces = new HashMap<>(64);

    public static Board newGame() {

        Board board = new Board();

        for (Piece piece : Piece.values()) {
            for (Position position : piece.getInitialPositions()) {
                board.pieces.put(position, piece);
            }
        }

        return board;
    }


    private Board(){

    }

    public Piece getAt(int x, int y) {
        return getAt(Position.of(x, y));
    }

    public Piece getAt(Position p) {
        return pieces.get(p);
    }


}
