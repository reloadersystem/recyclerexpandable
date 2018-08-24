package com.example.recyclerexpandable.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.recyclerexpandable.Interface.ItemClickListener;
import com.example.recyclerexpandable.R;

public class MyViewHolderWithoutChild extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textView;

    ItemClickListener itemClickListener;


    public MyViewHolderWithoutChild(View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.textView);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
