package asus.example.com.exercise3;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private Context context;

    SpacesItemDecoration(int space, Context context){
        this.space = space;
        this.context = context;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRec, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state){
        outRec.left = space;
        outRec.bottom = space;
        if (parent.getChildAdapterPosition(view)>=0 && parent.getChildAdapterPosition(view)<context.getResources().getInteger(R.integer.rows)){
            outRec.top = space;
        }
    }
}
