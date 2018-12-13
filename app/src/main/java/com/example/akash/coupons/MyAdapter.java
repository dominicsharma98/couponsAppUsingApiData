package com.example.akash.coupons;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder>{

    private List<Coupon> coupons = new ArrayList<>();
    private Context context;
    private onItemclicklistner mitemclicklistner;

    String url;


    public interface onItemclicklistner{

        void onitemclick(int position);
    }

    public  void setonitemclicklistener(onItemclicklistner itemclicklistner){

        this.mitemclicklistner = itemclicklistner;


    }

    public MyAdapter(Context context, List<Coupon> coupons) {
        this.coupons = coupons;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.card_layout,viewGroup,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, final int i) {
        Coupon c1=coupons.get(i);

        viewHolder.name.setText(c1.getName());
        viewHolder.url.setText(c1.getUrl());
        Picasso.with(context).load(c1.getPurl()).into(viewHolder.imageurl);






//        viewHolder.url.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent in = new Intent(context,Main2Activity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("url2",url);
//                in.putExtras(bundle);
//                context.startActivity(in);
//
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return coupons.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView url;
        ImageView  imageurl;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            url=itemView.findViewById(R.id.url);
            imageurl=itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mitemclicklistner != null){

                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mitemclicklistner.onitemclick(position);
                        }
                    }
                }
            });

        }
    }
}
