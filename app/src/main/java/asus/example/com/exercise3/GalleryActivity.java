package asus.example.com.exercise3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private final List<Actor> actors = DataUtil.generateActors();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        RecyclerView previewImages = findViewById(R.id.previewImages);
        previewImages.addItemDecoration(new SpacesItemDecoration(4));
        previewImages.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.rows)));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(actors, this);
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener<Actor>() {
            @Override
            public void onItemClicked(int position, Actor item) {
                Intent intent = new Intent(getApplicationContext(), ActorDetailActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        previewImages.setAdapter(recyclerViewAdapter);


    }

}