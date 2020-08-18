package com.gransoft.geoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<String> _id, message, messageBody, freeUse;

    public CustomAdapter(Context context, ArrayList<String> _id, ArrayList<String> message, ArrayList<String> messageBody, ArrayList<String> freeUse) {
        this.context = context;
        this._id = _id;
        this.message = message;
        this.messageBody = messageBody;
        this.freeUse = freeUse;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder._id_txt.setText(String.valueOf(_id.get(position)));
        holder.message_txt.setText(String.valueOf(message.get(position)));
        holder.message_body_txt.setText(String.valueOf(messageBody.get(position)));
        holder.free_use_txt.setText(String.valueOf(freeUse.get(position)));
    }

    @Override
    public int getItemCount() {
        return _id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView _id_txt, message_txt, message_body_txt, free_use_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            _id_txt = itemView.findViewById(R.id._id_txt);
            message_txt = itemView.findViewById(R.id.message_txt);
            message_body_txt = itemView.findViewById(R.id.message_body_txt);
            free_use_txt = itemView.findViewById(R.id.free_use_txt);
        }
    }
}
