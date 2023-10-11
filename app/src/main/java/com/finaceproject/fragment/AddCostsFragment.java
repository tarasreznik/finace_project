package com.finaceproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finaceproject.R;

public class AddCostsFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_add_costs;

    public void setContext(Context context) {
        this.context = context;
    }

    public static AddCostsFragment newInstance(Context context) {
        AddCostsFragment fragment = new AddCostsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.costs));
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }
}