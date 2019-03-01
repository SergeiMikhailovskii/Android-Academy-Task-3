package asus.example.com.exercise3;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ActorDetailActivity extends AppCompatActivity {

    private String uri;
    private String sInformation;
    private ImageView avatar;
    private TextView information;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_detail);
        int position = getIntent().getIntExtra("position", 0);
        sInformation = DataUtil.generateActors().get(position).getDescription();
        uri = DataUtil.generateActors().get(position).getLargeImage().toString();
        initializeView();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_actor_detail);
            initializeView();
        }
        else {
            setContentView(R.layout.activity_actor_detail);
            initializeView();
        }
    }

    private void initializeView(){
        avatar = findViewById(R.id.big_avatar);
        information = findViewById(R.id.information);
        Glide.with(getApplicationContext()).load(Uri.parse(uri)).into(avatar);
        information.setText(sInformation);
    }

}
