package com.androidcss.jsonexample;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

public class AdapterForum extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataForum> data= Collections.emptyList();
    DataForum current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterForum(Context context, List<DataForum> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_fish, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        DataForum current=data.get(position);
        myHolder.t1.setText(current.f2);
       // myHolder.textSize.setText("Size: " + current.f3);
        myHolder.t4.setText("Query: " + current.f4);
      //  myHolder.t2.setText("Rs. " + current.f5 + "\\Kg");
        myHolder.t2.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        // load image into imageview using glide
        Glide.with(context).load("http://192.168.1.7/test/images/" + current.f1)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(myHolder.iv1);

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView t1;
        ImageView iv1;
        TextView t3;
        TextView t4;
        TextView t2;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            t1= (TextView) itemView.findViewById(R.id.t1);
            iv1= (ImageView) itemView.findViewById(R.id.iv1);
            t3 = (TextView) itemView.findViewById(R.id.t3);
            t4 = (TextView) itemView.findViewById(R.id.t4);
            t2 = (TextView) itemView.findViewById(R.id.t2);
        }

    }

}
