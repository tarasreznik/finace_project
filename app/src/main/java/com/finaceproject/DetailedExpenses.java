package com.finaceproject;

import static com.finaceproject.R.style.btnOption;

import android.annotation.SuppressLint;
//import android.content.res.ColorStateList;
//import android.os.Build;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.LinearLayout;

//import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.finaceproject.model.adapter.CardBigListAdapter;
import com.finaceproject.model.dto.CardBigDto;

import java.util.ArrayList;
import java.util.List;

public class DetailedExpenses extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_expenses);

        btn1 = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button5);
        btn3 = findViewById(R.id.button6);

        // Sample data - replace this with your actual data
        List<CardBigDto> cardBigDtoList = new ArrayList<>();
        cardBigDtoList.add(new CardBigDto("2023-10-04", "100", "грн", "Sample comment 1"));
        cardBigDtoList.add(new CardBigDto("2023-10-05", "200", "грн", "Sample comment 2"));
        cardBigDtoList.add(new CardBigDto("2023-10-06", "300", "грн", "Sample comment 3"));
        cardBigDtoList.add(new CardBigDto("2023-10-07", "400", "грн", "Sample comment 4"));
        cardBigDtoList.add(new CardBigDto("2023-10-08", "500", "грн", "Sample comment 5"));

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CardBigListAdapter adapter = new CardBigListAdapter(cardBigDtoList);
        recyclerView.setAdapter(adapter);


        btn1.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                changeButton(btn1, R.color.black, R.color.lime);
                changeButton(btn2, R.color.white, R.color.grey_cards);
                changeButton(btn3, R.color.white, R.color.grey_cards);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButton(btn2, R.color.black, R.color.lime);
                changeButton(btn1, R.color.white, R.color.grey_cards);
                changeButton(btn3, R.color.white, R.color.grey_cards);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeButton(btn3, R.color.black, R.color.lime);
                changeButton(btn2, R.color.white, R.color.grey_cards);
                changeButton(btn1, R.color.white, R.color.grey_cards);
            }
        });
    }

    private String returnHexColor(int color){
        return String.format("#%06X",(0xFFFFFF & ContextCompat.getColor(this, color)));
    }

    private void changeButton(Button btn, int textColor, int backgroundColor){
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(returnHexColor(backgroundColor))));
        btn.setTextColor(ColorStateList.valueOf(Color.parseColor(returnHexColor(textColor))));
    }
}
