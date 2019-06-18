package com.example.tasks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tasks.R;
import com.example.tasks.model.MyDataModel;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<MyDataModel> {

    List<MyDataModel> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyArrayAdapter(Context context, List<MyDataModel> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        modelList = objects;
    }

    @Override
    public MyDataModel getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        MyDataModel item = getItem(position);

        vh.textViewDay.setText(item.getDay());
//        vh.textViewTuesday.setText(item.getTuesday());
//        vh.textViewWednesday.setText(item.getWednesday());
//        vh.textViewThursday.setText(item.getThursday());
//        vh.textViewFriday.setText(item.getFriday());
//        vh.textViewSaturday.setText(item.getSaturday());
//        //vh.textViewsession.setText(item.getSession());
        vh.textViewMenu.setText(item.getMenu());
        return vh.rootView;
    }



    private static class ViewHolder {
        public final RelativeLayout rootView;

        public final TextView textViewDay;
        public final TextView textViewMenu;
        private ViewHolder(RelativeLayout rootView, TextView textViewDay, TextView textViewMenu) {
            this.rootView = rootView;
            this.textViewDay = textViewDay;
//            this.textViewTuesday = textViewTuesday;
//            this.textViewWednesday = textViewWednesday;
//            this.textViewThursday = textViewThursday;
//            this.textViewFriday = textViewFriday;
//            this.textViewSaturday = textViewSaturday;

            //this.textViewsession = textViewsession;
            this.textViewMenu=textViewMenu;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView textViewDay = (TextView) rootView.findViewById(R.id.textViewDay);
            TextView textviewMenu=(TextView) rootView.findViewById(R.id.textViewMenu);
            return new ViewHolder(rootView, textViewDay,textviewMenu);
        }
    }
}