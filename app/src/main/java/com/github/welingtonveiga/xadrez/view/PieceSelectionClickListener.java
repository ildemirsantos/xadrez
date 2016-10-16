package com.github.welingtonveiga.xadrez.view;

import android.graphics.Color;
import android.view.View;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Piece;
import com.github.welingtonveiga.xadrez.model.Position;
import com.github.welingtonveiga.xadrez.model.movement.PieceMovement;

import java.util.Set;

public class PieceSelectionClickListener implements View.OnClickListener{

    private static final String TAG = PieceSelectionClickListener.class.getName();
    private static int DEFAULT_COLOR_KEY = 1;

    private final Board board;
    private final BoardUI ui;
    private Position selected = null;


    public PieceSelectionClickListener(Board board, BoardUI ui) {
        this.board = board;
        this.ui = ui;
    }

    @Override
    public void onClick(View view) {

        Position clickedPosition = (Position) view.getTag();
        Piece piece = board.getAt(clickedPosition);

        if (piece != Piece.NONE) {

            ui.repaint();

            PieceMovement movement = piece.getMovement();
            Set<Position> ableMoves = movement.ableMoves(clickedPosition, board);

            view.setBackgroundColor(Color.BLUE);

            for (Position position : ableMoves) {
                View v = ui.getViewAt(position);
                v.setBackgroundColor(Color.GREEN);
            }
        }
    }
}
