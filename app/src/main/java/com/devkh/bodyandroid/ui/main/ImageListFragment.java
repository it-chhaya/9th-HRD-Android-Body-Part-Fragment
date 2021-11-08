package com.devkh.bodyandroid.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devkh.bodyandroid.R;
import com.devkh.bodyandroid.data.ImageAssets;

public class ImageListFragment extends Fragment {

    private final static String TAG = ImageListFragment.class.getName();

    private RecyclerView rcvImageList;
    private GridLayoutManager layoutManager;
    private ImageListAdapter imageListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image_list, container, false);

        rcvImageList = view.findViewById(R.id.rcv_image_list);

        layoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

        imageListAdapter = new ImageListAdapter(getActivity(), ImageAssets.getAll());

        rcvImageList.setLayoutManager(layoutManager);
        rcvImageList.setAdapter(imageListAdapter);

        return view;
    }

}
