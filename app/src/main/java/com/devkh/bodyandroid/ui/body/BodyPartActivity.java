package com.devkh.bodyandroid.ui.body;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.devkh.bodyandroid.R;
import com.devkh.bodyandroid.data.ImageAssets;
import com.devkh.bodyandroid.ui.main.MainActivity;

public class BodyPartActivity extends AppCompatActivity {

    private final static String TAG = BodyPartActivity.class.getName();

    private int mHeadIndex;
    private int mBodyIndex;
    private int mLegIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        Log.i(TAG, "savedInstanceState: " + savedInstanceState);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            mHeadIndex = intent.getIntExtra(MainActivity.HEAD_INDEX, 0);
            mBodyIndex = intent.getIntExtra(MainActivity.BODY_INDEX, 0);
            mLegIndex = intent.getIntExtra(MainActivity.LEG_INDEX, 0);

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

    }

}