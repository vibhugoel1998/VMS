package com.example.vibhu.vms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customAdapter extends BaseAdapter{
    ArrayList<obj> arrayList;
    Context context;

    public customAdapter(ArrayList<obj> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public obj getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1=view;
        if(view==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view1 = inflater.inflate(R.layout.row, viewGroup, false);
            ViewHolder holder=new ViewHolder();
            holder.nameTextView=view1.findViewById(R.id.name);
            view1.setTag(holder);
        }
        ViewHolder holder1=(ViewHolder) view1.getTag();
        obj expense=getItem(i);
        holder1.nameTextView.setText(expense.getName());
        return view1;
    }
    class ViewHolder{
        TextView nameTextView;
    }
}
