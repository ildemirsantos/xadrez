package com.github.welingtonveiga.xadrez;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.welingtonveiga.xadrez.boardui.PieceSelectionClickListener;
import com.github.welingtonveiga.xadrez.model.Board;
import com.github.welingtonveiga.xadrez.model.Piece;
import com.github.welingtonveiga.xadrez.model.Position;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final String BOARD_BACKGROUND = "#b2ebf2";
    private Board game = Board.newGame();
    private HashMap<Position, View> boardUI = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout board = (LinearLayout) findViewById(R.id.chess_board);
        int positionSize = positionSize();
        for (int i = 0; i < Board.DIMENSION_SIZE; i++) {

            LinearLayout line = new LinearLayout(this);
            line.setOrientation(LinearLayout.HORIZONTAL);
            line.setLayoutParams(new LinearLayout.LayoutParams(8*positionSize, positionSize));

            board.addView(line);

            for (int j=0; j < Board.DIMENSION_SIZE; j++) {
                Position position = Position.of(i, j);
                final FrameLayout positionContent = new FrameLayout(this);
                positionContent.setLayoutParams(new LinearLayout.LayoutParams(positionSize, positionSize));
                positionContent.setTag(position);

                final int color;
                if ( (i+j) % 2 != 0) {
                    color = Color.parseColor(BOARD_BACKGROUND);
                } else {
                    color = Color.WHITE;
                }
                positionContent.setBackgroundColor(color);

                Piece piece = game.getAt(position);
                if (piece != Piece.NONE) {
                   ImageView img = new ImageView(this);
                   img.setImageResource(getResources().getIdentifier(piece.name().toLowerCase(), "drawable", this.getPackageName()));
                   img.setLayoutParams(new LinearLayout.LayoutParams(positionSize, positionSize));
                   positionContent.addView(img);
                }

                positionContent.setOnClickListener(new PieceSelectionClickListener(game, boardUI));
                boardUI.put(position, positionContent);
                line.addView(positionContent);
            }
        }
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
