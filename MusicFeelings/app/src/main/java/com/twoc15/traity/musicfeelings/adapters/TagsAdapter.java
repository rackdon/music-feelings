package com.twoc15.traity.musicfeelings.adapters;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.twoc15.traity.musicfeelings.R;

public class TagsAdapter extends ArrayAdapter<String> {

    Context mContext;
    int layoutResourceId;
    String[] data = null;

    public TagsAdapter(Context mContext, int layoutResourceId, String[] data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        String objectItem = data[position];

        TextView textViewItem = (TextView) convertView.findViewById(R.id.textTag);
        textViewItem.setText(objectItem);

        return convertView;

    }

    public View getViewWithButton(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        String objectItem = data[position];

        TextView textViewItem = (TextView) convertView.findViewById(R.id.textTag);
        textViewItem.setText(objectItem);
        Button deleteButton = (Button) convertView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

        return convertView;
    }

}
