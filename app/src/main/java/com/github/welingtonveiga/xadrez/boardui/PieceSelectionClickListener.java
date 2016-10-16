package com.github.welingtonveiga.xadrez.boardui;

import android.graphics.Color;
import android.util.Log;
import android.view.View;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Piece;
import com.github.welingtonveiga.xadrez.model.Position;
import com.github.welingtonveiga.xadrez.model.movement.PieceMovement;

import java.util.HashMap;
import java.util.Set;

public class PieceSelectionClickListener implements View.OnClickListener{

    private static final String TAG = PieceSelectionClickListener.class.getName();

    private final Board board;
    private final HashMap<Position, View> ui;
    private Position selected = null;


    public PieceSelectionClickListener(Board board, HashMap<Position, View> ui) {
        this.board = board;
        this.ui = ui;
    }

    @Override
    public void onClick(View view) {

        Position clickedPosition = (Position) view.getTag();
        Piece piece = board.getAt(clickedPosition);

        PieceMovement movement = piece.getMovement();
        Set<Position> ableMoves = movement.ableMoves(clickedPosition, board);

        view.setBackgroundColor(Color.BLUE);
        for (Position position : ableMoves) {
            ui.get(position).setBackgroundColor(Color.GREEN);
        }



    }
}
