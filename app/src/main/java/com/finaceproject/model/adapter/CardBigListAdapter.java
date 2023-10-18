package com.finaceproject.model.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.finaceproject.R;
import com.finaceproject.model.dto.CardBigDto;

import java.util.List;

public class CardBigListAdapter extends RecyclerView.Adapter<CardBigListAdapter.CardBigViewHolder> {

    private List<CardBigDto> cardBigList;

    public CardBigListAdapter(List<CardBigDto> cardBigList) {
        this.cardBigList = cardBigList;
    }

    @NonNull
    @Override
    public CardBigViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_cards_big, parent, false);
        return new CardBigViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardBigViewHolder holder, int position) {
        CardBigDto cardBigDto = cardBigList.get(position);

        String mainText = cardBigDto.getDate() + " " + cardBigDto.getSum() + " " + cardBigDto.getCurrency();
        String comment = cardBigDto.getComment();

        holder.mainTextView.setText(mainText);
        holder.commentInCardTextView.setText(comment);
    }

    @Override
    public int getItemCount() {
        return cardBigList.size();
    }

    static class CardBigViewHolder extends RecyclerView.ViewHolder {
        TextView mainTextView;
        TextView commentInCardTextView;

        CardBigViewHolder(@NonNull View itemView) {
            super(itemView);
            mainTextView = itemView.findViewById(R.id.main_text);
            commentInCardTextView = itemView.findViewById(R.id.comment_in_card);
        }
    }
}
