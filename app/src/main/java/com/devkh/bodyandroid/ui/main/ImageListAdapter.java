package com.devkh.bodyandroid.ui.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devkh.bodyandroid.R;

import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageViewHolder> {

    private final static String TAG = ImageListAdapter.class.getName();

    private final LayoutInflater inflater;
    private List<Integer> dataSet;

    // Create listener instance
    private OnImageClickListener listener;

    public ImageListAdapter(Context context, List<Integer> dataSet) {
        this.inflater = LayoutInflater.from(context);
        this.dataSet = dataSet;

        // Init listener instance
        try {
            this.listener = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            Log.e(TAG, "You must implement OnImageClickListener");
        }

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Bind event
                    // Trigger method
                    listener.onImageClick(getAdapterPosition());
                }
            });
        }
    }

    interface OnImageClickListener {
        void onImageClick(int position);
    }

}
