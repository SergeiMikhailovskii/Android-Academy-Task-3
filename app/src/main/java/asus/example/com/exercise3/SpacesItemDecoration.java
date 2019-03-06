package asus.example.com.exercise3;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    SpacesItemDecoration(int space){
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRec, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state){
        outRec.left = space;
        outRec.right = space;
        outRec.bottom = space;
    }
}
