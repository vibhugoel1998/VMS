package com.example.vibhu.vms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.UserViewHolder> {
    interface OnItemClickListener {

        void onItemClick(int position);
    }
    ArrayList<fireobj> related;
    Context context;
    OnItemClickListener listener;

    public RecyclerAdapter(ArrayList<fireobj> related, Context context) {
        this.related = related;
        this.context = context;
    }

    public RecyclerAdapter(ArrayList<fireobj> related, Context context, OnItemClickListener listener) {
        this.related = related;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.recycrow,viewGroup,false);
        UserViewHolder holder = new UserViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        fireobj newobj=related.get(i);
        String name=newobj.getName();
        userViewHolder.textView.setText(name);
    }

    @Override
    public int getItemCount() {
        return related.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView imageView;
        TextView textView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            imageView=itemView.findViewById(R.id.mechimg);
            textView=itemView.findViewById(R.id.mechtext);
        }
    }
}
