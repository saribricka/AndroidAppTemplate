package com.example.template.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.R;

public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imageCardView;
    TextView placeTextView;
    TextView dateTextView;

    private OnItemListener itemListener;

    public CardViewHolder(@NonNull View itemView, OnItemListener itemListener) {
        super(itemView);

        imageCardView = itemView.findViewById(R.id.placeImage);
        placeTextView = itemView.findViewById(R.id.placeTextView);
        dateTextView = itemView.findViewById(R.id.dateTextView);

        itemListener = itemListener;

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        itemListener.onItemClick(getAdapterPosition());
    }
}
