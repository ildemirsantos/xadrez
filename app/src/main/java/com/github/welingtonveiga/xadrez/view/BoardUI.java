package com.github.welingtonveiga.xadrez.view;


import android.view.View;

import com.github.welingtonveiga.xadrez.model.Position;

public interface BoardUI {

    void repaint();

    View getViewAt(Position p);
}
