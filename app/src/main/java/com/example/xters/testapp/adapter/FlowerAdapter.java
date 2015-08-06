package com.example.xters.testapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xters.testapp.R;
import com.example.xters.testapp.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Aleksandar Karafilovski
 *         Created on 8/5/15.
 */
public class FlowerAdapter extends ArrayAdapter<Flower> {

    private Context context;
    private List<Flower> flowerList;
    private static final String PHOTO_BASE_URL = "http://services.hanselandpetal.com/photos/";


    public FlowerAdapter(Context context, int resource, List<Flower> objects) {
        super(context, resource, objects);
        this.context = context;
        this.flowerList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            // inflate the layout
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.item_flower, parent, false);
            // set up the ViewHolder
            viewHolder = new ViewHolder(convertView);
            // store the holder with the view.
            convertView.setTag(viewHolder);
        } else {
            // use the viewHolder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Flower flower = flowerList.get(position);
        viewHolder.tvFlowerName.setText(flower.getName());
        Picasso.with(context).load(PHOTO_BASE_URL + flower.getPhoto()).into(viewHolder.ivFlowerImage);
        return convertView;
    }


    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'item_flower.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @Bind(R.id.ivFlowerImage)
        ImageView ivFlowerImage;
        @Bind(R.id.tvFlowerName)
        TextView tvFlowerName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
