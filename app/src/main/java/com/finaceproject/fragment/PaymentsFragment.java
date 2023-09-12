package com.finaceproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finaceproject.R;

public class PaymentsFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_payments;

    public void setContext(Context context) {
        this.context = context;
    }

    public static PaymentsFragment newInstance(Context context) {
        PaymentsFragment fragment = new PaymentsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.payments));
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(LAYOUT, container, false);
    }
}