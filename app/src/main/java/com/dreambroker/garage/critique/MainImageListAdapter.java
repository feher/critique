package com.dreambroker.garage.critique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreambroker.garage.critique.glide.GlideApp;
import com.dreambroker.garage.critique.model.Image;

import java.util.ArrayList;
import java.util.List;

class MainImageListAdapter extends BaseAdapter {

    private List<Image> images = new ArrayList<>();

    final LayoutInflater inflater;

    MainImageListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    public void setImages(List<Image> images) {
        this.images.clear();
        this.images.addAll(images);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_main_list, parent, false);

        Image image = images.get(position);

        TextView titleView = (TextView) view.findViewById(R.id.title);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);

        titleView.setText(image.getText());
        GlideApp.with(imageView).load(image.getUri()).into(imageView);

        return view;
    }

}
