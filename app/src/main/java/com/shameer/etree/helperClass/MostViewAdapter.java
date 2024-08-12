package com.shameer.etree.helperClass;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.shameer.etree.ApplicationMain;
import com.shameer.etree.R;
import com.shameer.etree.UpdateSelectedItems;

import java.util.ArrayList;

public class MostViewAdapter extends RecyclerView.Adapter<MostViewAdapter.MostViewHolder> {
    ArrayList<MostViewHelperClass> mostviewedlocations;
    Context context;
    String name;
    String price;
    UpdateSelectedItems updateSelectedItems;

    public MostViewAdapter(ArrayList<MostViewHelperClass> mostviewedlocations) {
        this.mostviewedlocations = mostviewedlocations;
        this.context = context;
        this.updateSelectedItems = updateSelectedItems;
    }


    @Override
    public MostViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        MostViewHolder mostViewHolder = new MostViewHolder(view);
        return mostViewHolder;
    }

    @Override
    public void onBindViewHolder( MostViewHolder holder, int position) {
   MostViewHelperClass mostViewHelperClass = mostviewedlocations.get(position);
   holder.image.setImageResource( mostViewHelperClass.getImage());
   holder.title.setText( mostViewHelperClass.getTitle());
   holder.desc.setText( mostViewHelperClass.getDescription());

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = MostViewHelperClass.getTitle();

                price =MostViewHelperClass.getDescription();


                ((UpdateSelectedItems) ApplicationMain.getMyContext()).addItems(name, price);
                holder.add.setVisibility(View.INVISIBLE);
                holder.check.setVisibility(View.VISIBLE);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mostviewedlocations.size();
    }


    public static class MostViewHolder extends RecyclerView.ViewHolder{
 ImageView image;
 TextView title, desc;
        ImageView add, check;

     public MostViewHolder( View itemView) {
         super(itemView);

         image = itemView.findViewById(R.id.mv_image);
         title = itemView.findViewById(R.id.mv_title);
         desc = itemView.findViewById(R.id.mv_desc);
         add = itemView.findViewById(R.id.add_item);
         check = itemView.findViewById(R.id.done);
     }
 }
}