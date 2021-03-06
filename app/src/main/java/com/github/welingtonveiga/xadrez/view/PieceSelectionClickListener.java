package com.github.welingtonveiga.xadrez.view;

import android.graphics.Color;
import android.view.View;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Piece;
import com.github.welingtonveiga.xadrez.model.Position;
import com.github.welingtonveiga.xadrez.model.movement.PieceMovement;

import java.util.Set;

public class PieceSelectionClickListener implements View.OnClickListener {

    private static final String TAG = PieceSelectionClickListener.class.getName();
    private static int DEFAULT_COLOR_KEY = 1;

    private final Board board;
    private final BoardUI ui;
    private static Position selected = null;


    public PieceSelectionClickListener(Board board, BoardUI ui) {
        this.board = board;
        this.ui = ui;
    }

    @Override
    public void onClick(View view) {

        Position clickedPosition = (Position) view.getTag();
        Piece piece = board.getAt(clickedPosition);

        if (selected == null || !board.getAt(selected).getMovement().ableMoves(selected, board).contains(clickedPosition)) {

            ui.repaint();

            PieceMovement movement = piece.getMovement();
            Set<Position> ableMoves = movement.ableMoves(clickedPosition, board);

            view.setBackgroundColor(Color.BLUE);

            for (Position position : ableMoves) {
                Piece target = board.getAt(position);
                int color = Color.GREEN;
                if (target != Piece.NONE) {
                    color = Color.RED;
                }

                View v = ui.getViewAt(position);
                v.setBackgroundColor(color);
            }

            selected = clickedPosition;

        } else {
            board.move(selected, clickedPosition);
            selected = null;
            ui.repaint();
        }
    }
}
