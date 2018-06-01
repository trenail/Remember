package com.test.remember;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by home on 2018/5/30.
 */

public class StartPageAdapter extends BaseAdapter {


    private List<StartPageBean> startPageBeanList;

    private LayoutInflater inflater;

    public StartPageAdapter(Context context, List<StartPageBean> startPageBeanList) {
        this.startPageBeanList = startPageBeanList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return startPageBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return startPageBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        Holder holder;
        if (convertView == null) {
            view = inflater.inflate(R.layout.layout, null);
            holder = new Holder();
            holder.tvName = view.findViewById(R.id.tv_name);
            view.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.tvName.setText(startPageBeanList.get(position).text);
        return view;
    }

    public static class Holder {
        public TextView tvName;
    }
}
