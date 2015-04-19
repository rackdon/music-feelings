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

import java.util.ArrayList;
import java.util.List;

public class TagsAdapter extends ArrayAdapter<String> {

    Context mContext;
    int layoutResourceId;
    List<String> data = null;
    boolean showDeleteButton;

    public TagsAdapter(Context mContext, int layoutResourceId, List<String> data, boolean showDeleteButton) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
        this.showDeleteButton = showDeleteButton;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            // inflate the layout
            LayoutInflater infalInflater = (LayoutInflater) mContext.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(layoutResourceId, parent, false);
        }

        String objectItem = data.get(position);

        TextView textViewItem = (TextView) convertView.findViewById(R.id.textTag);
        textViewItem.setText(objectItem);
        if(showDeleteButton) {
            showDeleteButton(convertView, objectItem);
        }

        return convertView;

    }

    public void showDeleteButton(View convertView, final String item){
        final Button deleteButton = (Button) convertView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteButton.setVisibility(View.VISIBLE);
                remove(item);
            }
        });
    }

}
