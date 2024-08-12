package projects;


import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shameer.etree.ApplicationMain;
import com.shameer.etree.R;
import com.shameer.etree.UpdateSelectedItems;

import java.util.ArrayList;


public class DynamicRVAdapter extends RecyclerView.Adapter<DynamicRVAdapter.DynamicViewHolder> {


    ArrayList<DynamicRVModel> dynamicLocations;
    Application activity;
    Context context;
    String name;
    String price;
    UpdateSelectedItems updateSelectedItems;

    public DynamicRVAdapter(ArrayList<DynamicRVModel> dynamicLocation,Context context,UpdateSelectedItems updateSelectedItems) {
        this.dynamicLocations = dynamicLocation;
        this.context = context;
        this.updateSelectedItems = updateSelectedItems;
    }



    @NonNull
    @Override
    public DynamicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv_item_layout,parent,false);
        DynamicViewHolder dynamicViewHolder = new DynamicViewHolder(view);
        return dynamicViewHolder;
    }

    @Override
    public void onBindViewHolder( DynamicRVAdapter.DynamicViewHolder holder, int position) {
        DynamicRVModel dynamicRVModel = dynamicLocations.get(position);
        holder.image.setImageResource(dynamicRVModel.getImage());
        holder.title.setText(dynamicRVModel.getName());
        holder.desc.setText(dynamicRVModel.getDesc());

       holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = dynamicRVModel.getName();

                price =dynamicRVModel.getDesc();


                ((UpdateSelectedItems) ApplicationMain.getMyContext()).addItems(name, price);
                holder.add.setVisibility(View.INVISIBLE);
                holder.check.setVisibility(View.VISIBLE);

            }
        });

    }

    @Override
    public int getItemCount() {
        return dynamicLocations.size();
    }


    public static class DynamicViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, desc;
     ImageView add, check;

        public DynamicViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView2);
            title = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.detail);
            add = itemView.findViewById(R.id.add_item);
            check = itemView.findViewById(R.id.done);

        }
    }
}