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


    public boolean isEmpty(Position position) {
        return getAt(position) == Piece.NONE;
    }

    public boolean hasEnemyAt(Piece piece, Position p) {
        Piece enemyCandidate = getAt(p);
        return enemyCandidate!= Piece.NONE && enemyCandidate.getColor()!=piece.getColor();
    }

    public boolean areEnemies(Position position, Position enemyPosition) {
        Piece piece = getAt(position);
        return hasEnemyAt(piece, enemyPosition);
    }

    public void move(Position from, Position to) {
        Piece source = getAt(from);
        Piece target = getAt(to);

        if (source!=Piece.NONE && source.getColor()!=target.getColor()) {
            pieces.put(to, source);
            pieces.put(from, Piece.NONE);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
