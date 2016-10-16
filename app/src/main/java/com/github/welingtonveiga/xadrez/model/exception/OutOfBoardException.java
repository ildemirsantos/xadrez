package com.github.welingtonveiga.xadrez.model.exception;

import com.github.welingtonveiga.xadrez.model.Position;

public class OutOfBoardException extends IllegalArgumentException {

    public OutOfBoardException(Position p) {
        super("Out of Board "+p);
    }
}
