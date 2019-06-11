package com.dreambroker.garage.critique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MainListAdapter extends BaseAdapter {

    final int[] photos = {
            R.drawable.photo_1,
            R.drawable.photo_2,
            R.drawable.photo_3,
            R.drawable.photo_4,
            R.drawable.photo_5,
            R.drawable.photo_6
    };

    final int itemCount;

    final LayoutInflater inflater;
    final String[] titles;

    MainListAdapter(Context context, int itemCount) {
        this.inflater = LayoutInflater.from(context);
        this.titles = context.getResources().getStringArray(R.array.titles);
        this.itemCount = itemCount;
    }

    @Override
    public int getCount() {
        return itemCount;
    }

    @Override
    public Object getItem(int position) {
        return titles[position % titles.length];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_main_list, parent, false);

        TextView title = (TextView) view.findViewById(R.id.title);
        ImageView image = (ImageView) view.findViewById(R.id.image);

        title.setText(titles[position % titles.length]);
        image.setImageResource(photos[position % photos.length]);

        return view;
    }

}
