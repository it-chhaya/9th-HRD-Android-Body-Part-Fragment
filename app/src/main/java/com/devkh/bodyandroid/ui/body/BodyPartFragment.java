package com.devkh.bodyandroid.ui.body;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.devkh.bodyandroid.R;
import com.devkh.bodyandroid.ui.main.MainActivity;

import java.util.ArrayList;

public class BodyPartFragment extends Fragment {

    private int imageIndex;
    private ArrayList<Integer> imageIds;

    private final static String IMAGE_IDS = "image_ids";
    private final static String IMAGE_INDEX = "image_index";

    public void setImageIds(ArrayList<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            setImageIds(savedInstanceState.getIntegerArrayList(IMAGE_IDS));
            setImageIndex(savedInstanceState.getInt(IMAGE_INDEX));
        }

        View view = inflater.inflate(R.layout.fragment_body, container, false);

        ImageView imageView = view.findViewById(R.id.image_body_part);
        imageView.setImageResource(imageIds.get(imageIndex));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageIndex < imageIds.size() - 1) {
                    imageIndex += 1;
                } else {
                    imageIndex = 0;
                }
                imageView.setImageResource(imageIds.get(imageIndex));
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_IDS, imageIds);
        outState.putInt(IMAGE_INDEX, imageIndex);
    }
}
