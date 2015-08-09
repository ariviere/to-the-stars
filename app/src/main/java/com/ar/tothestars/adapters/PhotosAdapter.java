package com.ar.tothestars.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ar.tothestars.models.APODPhoto;
import com.ar.tothestars.ui.APODPhotoView;

import java.util.ArrayList;

/**
 * Created by ariviere on 09/08/15.
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {

    private final Context mContext;
    private ArrayList<APODPhoto> mPhotos;

    public PhotosAdapter(Context context, ArrayList<APODPhoto> mPhotos) {
        this.mContext = context;
        this.mPhotos = mPhotos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder viewHolder = new ViewHolder(new APODPhotoView(mContext));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.photoView.setModel(mPhotos.get(i));
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private APODPhotoView photoView;

        public ViewHolder(APODPhotoView view) {
            super(view);
            photoView = view;
        }
    }
}