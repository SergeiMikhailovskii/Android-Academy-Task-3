package asus.example.com.exercise3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private RecyclerView previewImages;
    private final List<Actor> actors = DataUtil.generateActors();


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        previewImages = findViewById(R.id.previewImages);
        previewImages.addItemDecoration(new SpacesItemDecoration(4));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            previewImages.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            previewImages.setLayoutManager(new GridLayoutManager(this, 4));
        }



        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(actors, this);
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener<Actor>() {
            @Override
            public void onItemClicked(int position, Actor item) {
                Intent intent = new Intent(GalleryActivity.this, ActorDetailActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        previewImages.setAdapter(recyclerViewAdapter);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            previewImages.setLayoutManager(new GridLayoutManager(this, 4));
        }
        else {
            previewImages.setLayoutManager(new GridLayoutManager(this, 2));
        }
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putBundle("BUNDLE", bundle);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle onSavedInstance){
//        super.onRestoreInstanceState(onSavedInstance);
//        onSavedInstance.getBundle("BUNDLE");
//    }


}