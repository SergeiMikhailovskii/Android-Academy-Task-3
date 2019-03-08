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
        final int WIDTH = getWindowManager().getDefaultDisplay().getWidth()/ getResources().
                getInteger(R.integer.rows);
        previewImages.addItemDecoration(new SpacesItemDecoration(getResources().
                getDimensionPixelSize(R.dimen.default_separator_line)));
        previewImages.setLayoutManager(new GridLayoutManager(this, getResources().
                getInteger(R.integer.rows)));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(actors, this, WIDTH);
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener<Actor>() {
            @Override
            public void onItemClicked(int position, Actor item) {
                Intent intent = new Intent(getApplicationContext(), ActorDetailActivity.class);
                intent.putExtra(ActorDetailActivity.INTENT_IMAGE_URI, actors.get(position).
                        getLargeImage());
                intent.putExtra(ActorDetailActivity.INTENT_DESCRIPTION, actors.get(position).
                        getDescription());
                startActivity(intent);
            }
        });
        previewImages.setAdapter(recyclerViewAdapter);

    }

}