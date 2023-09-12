package com.finaceproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.finaceproject.R;
import com.finaceproject.model.dto.CardDto;

import java.util.List;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardViewHolder> {

    private List<CardDto> data;

    public CardListAdapter(List<CardDto> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardDto cardDto = data.get(position);
        holder.title.setText(cardDto.getTitle());
        holder.sum.setText(cardDto.getSum().toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView title;
        TextView sum;
        TextView currency;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.incomes_card);
            title = itemView.findViewById(R.id.incomes_name);
            sum = itemView.findViewById(R.id.incomes_sum);
            currency = itemView.findViewById(R.id.incomes_currency);
        }
    }
}
