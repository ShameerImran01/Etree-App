package com.shameer.etree;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConfirmOrdActivityAdapter extends RecyclerView.Adapter<ConfirmOrdActivityAdapter.ConfirmOrderVirewHolder> {

    private ArrayList<OrderListModel> orderListModels;
    Activity activity;
    public ConfirmOrdActivityAdapter(Activity activity){
        this.activity = activity;
        orderListModels= ((UpdateSelectedItems) ApplicationMain.getMyContext()).getItems();
    }

    public class ConfirmOrderVirewHolder extends RecyclerView.ViewHolder{
       TextView name, price;
        public ConfirmOrderVirewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name2);
           price= itemView.findViewById(R.id.price2);

        }
    }
    @NonNull
    @Override
    public ConfirmOrderVirewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent, false);
        ConfirmOrderVirewHolder confirmOrderVirewHolder = new ConfirmOrderVirewHolder( view);
        return confirmOrderVirewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmOrderVirewHolder holder, int position) {
   OrderListModel orderListModel = orderListModels.get(position);
   holder.name.setText(orderListModel.getName());
   holder.price.setText(orderListModel.getPrice());
    }

    @Override
    public int getItemCount() {
        return orderListModels.size();
    }


}
