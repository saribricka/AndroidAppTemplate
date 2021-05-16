package com.example.template.RecyclerView;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.CardItem;
import com.example.template.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<CardItem> cardItemList;

    private Activity activity;

    private OnItemListener itemListener;

    public CardAdapter(List<CardItem> cardItemList, Activity activity, OnItemListener itemListener) {
        this.cardItemList = cardItemList;
        this.activity = activity;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,
                parent, false);
        return new CardViewHolder(layoutView, itemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem currentCardItem = cardItemList.get(position);

        holder.placeTextView.setText(currentCardItem.getPlace());
        holder.dateTextView.setText(currentCardItem.getDate());

        String image_path = currentCardItem.getImageResource();
        if (image_path.contains("ic_")){
            Drawable drawable = ContextCompat.getDrawable(activity, activity.getResources()
                    .getIdentifier(image_path, "drawable", activity.getPackageName()));
            holder.imageCardView.setImageDrawable(drawable);
        }
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }
}
