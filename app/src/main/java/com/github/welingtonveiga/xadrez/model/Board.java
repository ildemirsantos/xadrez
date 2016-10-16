package com.github.welingtonveiga.xadrez.model;

import com.github.welingtonveiga.xadrez.model.exception.OutOfBoardException;

import java.util.HashMap;
import java.util.Map;

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

    public Piece getAt(Position p) {
        if (isInBoard(p)) {
            return pieces.get(p);
        } else {
            throw  new OutOfBoardException(p);
        }
    }


    public boolean isInBoard(Position position) {
        return position.getRow() >= 0 && position.getRow() < DIMENSION_SIZE
                && position.getCol() >= 0 && position.getCol() < DIMENSION_SIZE;
    }
}
