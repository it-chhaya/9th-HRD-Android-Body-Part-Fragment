package com.devkh.bodyandroid.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devkh.bodyandroid.databinding.ActivityMainBinding;
import com.devkh.bodyandroid.ui.body.BodyPartActivity;

public class MainActivity extends AppCompatActivity
        implements ImageListAdapter.OnImageClickListener {

    private ActivityMainBinding binding;

    public final static String HEAD_INDEX = "HEAD_INDEX";
    public final static String BODY_INDEX = "BODY_INDEX";
    public final static String LEG_INDEX = "LEG_INDEX";

    private int mHeadIndex;
    private int mBodyIndex;
    private int mLegIndex;

    private final static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Bind event on button next
        onButtonNextClicked();
    }

    @Override
    public void onImageClick(int position) {

        int bodyPart = position / 12;
        int imageIndex = position - (bodyPart * 12);

        switch (bodyPart) {
            case 0:
                mHeadIndex = imageIndex;
                break;
            case 1:
                mBodyIndex = imageIndex;
                break;
            case 2:
                mLegIndex = imageIndex;
                break;
        }

    }

    private void onButtonNextClicked() {
        binding.buttonNext.setOnClickListener(view -> {
            Intent intent = new Intent(this, BodyPartActivity.class);
            intent.putExtra(HEAD_INDEX, mHeadIndex);
            intent.putExtra(BODY_INDEX, mBodyIndex);
            intent.putExtra(LEG_INDEX, mLegIndex);
            startActivity(intent);
        });
    }

}