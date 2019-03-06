package asus.example.com.exercise3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ActorDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_detail);
        int position = getIntent().getIntExtra("position", 0);
        ImageView avatar = findViewById(R.id.big_avatar);
        TextView information = findViewById(R.id.information);
        Glide.with(getApplicationContext()).load(DataUtil.generateActors().get(position).getLargeImage()).into(avatar);
        information.setText(DataUtil.generateActors().get(position).getDescription());
    }


}
