package com.devkh.bodyandroid.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.devkh.bodyandroid.R;
import com.devkh.bodyandroid.data.ImageAssets;
import com.devkh.bodyandroid.databinding.ActivityMainBinding;
import com.devkh.bodyandroid.ui.body.BodyPartActivity;
import com.devkh.bodyandroid.ui.body.BodyPartFragment;

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

    private boolean mTwoPaneMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
//        setContentView(view);

        setContentView(R.layout.activity_main);

        if (findViewById(R.id.button_next) != null) {
            // Bind event on button next
            onButtonNextClicked();
        }

        if (findViewById(R.id.body_part_layout) != null) {

            Log.i(TAG, "onCreate: Two pane");

            mTwoPaneMode = true;

            if (savedInstanceState == null) {

                BodyPartFragment headFragment = new BodyPartFragment();
                BodyPartFragment bodyFragment = new BodyPartFragment();
                BodyPartFragment legFragment = new BodyPartFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();


                // add head fragment
                headFragment.setImageIds(ImageAssets.getHeads());
                headFragment.setImageIndex(mHeadIndex);
                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .commit();

                // add body fragment
                bodyFragment.setImageIds(ImageAssets.getBodies());
                bodyFragment.setImageIndex(mBodyIndex);
                fragmentManager.beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit();

                //add leg fragment
                legFragment.setImageIds(ImageAssets.getLegs());
                legFragment.setImageIndex(mLegIndex);
                fragmentManager.beginTransaction()
                        .add(R.id.leg_container, legFragment)
                        .commit();
            }
        } else {
            Log.i(TAG, "onCreate: One pane");
            mTwoPaneMode = false;
        }



    }

    @Override
    public void onImageClick(int position) {

        int bodyPart = position / 12;
        int imageIndex = position - (bodyPart * 12);

        if (!mTwoPaneMode) {
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
        } else {
            BodyPartFragment newFragment = new BodyPartFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (bodyPart) {
                case 0:
                    newFragment.setImageIds(ImageAssets.getHeads());
                    newFragment.setImageIndex(imageIndex);
                    transaction.replace(R.id.head_container, newFragment).commit();
                    break;
                case 1:
                    newFragment.setImageIds(ImageAssets.getBodies());
                    newFragment.setImageIndex(imageIndex);
                    transaction.replace(R.id.body_container, newFragment).commit();
                    break;
                case 2:
                    newFragment.setImageIds(ImageAssets.getLegs());
                    newFragment.setImageIndex(imageIndex);
                    transaction.replace(R.id.leg_container, newFragment).commit();
                    break;
            }
        }

    }

    private void onButtonNextClicked() {
        findViewById(R.id.button_next).setOnClickListener(view -> {
            Intent intent = new Intent(this, BodyPartActivity.class);
            intent.putExtra(HEAD_INDEX, mHeadIndex);
            intent.putExtra(BODY_INDEX, mBodyIndex);
            intent.putExtra(LEG_INDEX, mLegIndex);
            startActivity(intent);
        });
    }

}