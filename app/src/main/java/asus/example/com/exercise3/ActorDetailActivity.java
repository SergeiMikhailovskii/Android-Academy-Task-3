package asus.example.com.exercise3;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class ActorDetailActivity extends AppCompatActivity {
    public static final String INTENT_IMAGE_URI = "IMAGE_URI";
    public static final String INTENT_DESCRIPTION = "DESCRIPTION";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_actor_detail);
        ImageView avatar = findViewById(R.id.big_avatar);
        TextView information = findViewById(R.id.information);
        Uri uri = getIntent().getParcelableExtra(INTENT_IMAGE_URI);
        String description = getIntent().getStringExtra(INTENT_DESCRIPTION);
        Glide.with(getApplicationContext()).load(uri).into(avatar);
        information.setText(description);
    }


}
