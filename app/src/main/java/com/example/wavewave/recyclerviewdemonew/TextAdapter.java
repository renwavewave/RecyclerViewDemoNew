package com.example.wavewave.recyclerviewdemonew;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder> {
    private LinkedList<String> list;
    private TextView textView;
    private int oldPosition = 0;

    public TextAdapter(LinkedList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final TextViewHolder holder, final int position) {
        holder.textView.setText(list.get(position) + "");
        if (position == oldPosition) {
            textView = holder.textView;
            holder.textView.setTextColor(Color.parseColor("#FF4081"));
        } else {
            holder.textView.setTextColor(Color.parseColor("#000000"));
        }
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView != null) {
                    textView.setTextColor(Color.parseColor("#000000"));
                }
                holder.textView.setTextColor(Color.parseColor("#FF4081"));
                textView = holder.textView;
                oldPosition = position;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class TextViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public TextViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
