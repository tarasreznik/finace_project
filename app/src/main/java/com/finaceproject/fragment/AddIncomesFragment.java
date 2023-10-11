package com.finaceproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finaceproject.R;

public class AddIncomesFragment extends AbstractTabFragment {

    private static final int LAYOUT = R.layout.fragment_add_incomes;

    public void setContext(Context context) {
        this.context = context;
    }

    public static AddIncomesFragment newInstance(Context context) {
        AddIncomesFragment fragment = new AddIncomesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.incomes));
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }
}