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

import java.util.ArrayList;

public class BodyPartFragment extends Fragment {

    private int imageIndex;
    private ArrayList<Integer> imageIds;

    public void setImageIds(ArrayList<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_body, container, false);

        ImageView imageView = view.findViewById(R.id.image_body_part);
        imageView.setImageResource(imageIds.get(imageIndex));

        return view;
    }
}
