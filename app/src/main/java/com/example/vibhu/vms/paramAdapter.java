package com.example.vibhu.vms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class paramAdapter extends RecyclerView.Adapter<paramAdapter.UserViewHolder> {
    interface OnItemClickListener {

        void onItemClick(int position);
    }
    ArrayList<showobj> arrayList;
    Context context;
    RecyclerAdapter.OnItemClickListener listener;

    public paramAdapter(ArrayList<showobj> arrayList, Context context, RecyclerAdapter.OnItemClickListener listener) {
        this.arrayList = arrayList;
        this.context = context;
        this.listener = listener;
    }

    public paramAdapter(ArrayList<showobj> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public paramAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.param,viewGroup,false);
        paramAdapter.UserViewHolder holder = new paramAdapter.UserViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull paramAdapter.UserViewHolder userViewHolder, int i) {
        showobj newobj=arrayList.get(i);
        userViewHolder.textView2.setText(newobj.getName1());
        userViewHolder.textView.setText(newobj.getVal1().toString());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class UserViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView textView2;
        TextView textView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            textView2=itemView.findViewById(R.id.paramname);
            textView=itemView.findViewById(R.id.paramval);
        }
    }

}
