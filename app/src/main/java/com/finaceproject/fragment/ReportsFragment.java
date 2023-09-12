package com.finaceproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.finaceproject.R;
import com.finaceproject.adapter.CardListAdapter;
import com.finaceproject.model.dto.CardDto;

import java.util.ArrayList;
import java.util.List;

public class ReportsFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_reports;

    public static ReportsFragment newInstance() {
        ReportsFragment fragment = new ReportsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        RecyclerView rv = view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new CardListAdapter(createMockData()));
        return view;
    }

    private List<CardDto> createMockData() {
        List<CardDto> data = new ArrayList<>();
        data.add(new CardDto("Транспорт", "1200", "грн"));
        data.add(new CardDto("Продукти", "3000", "грн"));
        data.add(new CardDto("Здоров'я", "4000", "грн"));
        data.add(new CardDto("Подорожі", "10000", "грн"));
        data.add(new CardDto("Діти", "5000", "грн"));
        data.add(new CardDto("Інше", "12000", "грн"));
        return data;
    }
}
