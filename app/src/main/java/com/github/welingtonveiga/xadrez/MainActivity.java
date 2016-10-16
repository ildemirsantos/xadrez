package com.github.welingtonveiga.xadrez;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Piece;
import com.github.welingtonveiga.xadrez.model.Position;
import com.github.welingtonveiga.xadrez.view.BoardUI;
import com.github.welingtonveiga.xadrez.view.PieceSelectionClickListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements BoardUI {

    public static final String BOARD_BACKGROUND = "#b2ebf2";
    private Board game = Board.newGame();
    private HashMap<Position, View> boardViews = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout board = (LinearLayout) findViewById(R.id.chess_board);
        for (int i = 0; i < Board.DIMENSION_SIZE; i++) {

            LinearLayout row = newRowLayout();

            for (int j=0; j < Board.DIMENSION_SIZE; j++) {
                Position position = Position.of(i, j);
                FrameLayout col = createColLayout(position);
                col.setOnClickListener(new PieceSelectionClickListener(game, this));

                boardViews.put(position, col);
                row.addView(col);
            }

            board.addView(row);
        }

        repaint();
    }


    @NonNull
    private FrameLayout createColLayout(Position position) {
        final Piece piece = game.getAt(position);
        final FrameLayout positionContent = new FrameLayout(this);
        positionContent.setLayoutParams(new LinearLayout.LayoutParams( positionSize(),  positionSize()));
        positionContent.setTag(position);
        if (piece != Piece.NONE) {
            positionContent.addView(createPieceView(piece));
        }
        return positionContent;
    }

    @Nullable
    private ImageView createPieceView(Piece piece) {
        ImageView img = new ImageView(this);
        img.setImageResource(getResources().getIdentifier(piece.name().toLowerCase(), "drawable", this.getPackageName()));
        img.setLayoutParams(new LinearLayout.LayoutParams( positionSize(),  positionSize()));
        return img;
    }

    @Override
    public void repaint() {
        for (Map.Entry<Position, View> pos : boardViews.entrySet()) {
            View v = pos.getValue();
            Position p = pos.getKey();
            v.setBackgroundColor(resolveBackgroundColor(p));
        }
    }

    @Override
    public View getViewAt(Position p) {
        return boardViews.get(p);
    }

    private int resolveBackgroundColor(Position position) {
        final int color;
        if ( (position.getRow()+position.getCol()) % 2 != 0) {
            color = Color.parseColor(BOARD_BACKGROUND);
        } else {
            color = Color.WHITE;
        }
        return color;
    }

    @NonNull
    private LinearLayout newRowLayout() {
        LinearLayout line = new LinearLayout(this);
        line.setOrientation(LinearLayout.HORIZONTAL);
        line.setLayoutParams(new LinearLayout.LayoutParams(8* positionSize(),  positionSize()));
        return line;
    }

    private int positionSize() {
        int size = 48;
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        switch(metrics.densityDpi){
            case DisplayMetrics.DENSITY_LOW:
                size = 48;
                break;
            case DisplayMetrics.DENSITY_HIGH:
                size = 72;
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                size = 96;
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                size = 144;
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                size = 192;
                break;
        }
        return  (int) Math.floor(size*0.85);
    }
}
