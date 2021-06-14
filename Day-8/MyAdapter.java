package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    int[] image;
    String[] name;
    Context context;
    LayoutInflater layoutInflater;

    public MyAdapter( Context context,int[] image, String[] name) {
        this.image = image;
        this.name = name;
        this.context = context;
        layoutInflater=(LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view=layoutInflater.inflate(R.layout.custom_list,null);
        ImageView iv1=(ImageView) view.findViewById(R.id.iv1);
        TextView tv1=(TextView) view.findViewById(R.id.tv1);
        tv1.setText(name[i]);
        iv1.setImageResource(image[i]);

        return view;
    }
}
