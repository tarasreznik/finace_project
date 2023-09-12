package com.finaceproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finaceproject.R;

public class SupportFragment extends AbstractTabFragment {
    public static final int LAYOUT = R.layout.fragment_support;

    public void setContext(Context context) {
        this.context = context;
    }

    public static SupportFragment newInstance(Context context) {
        SupportFragment fragment = new SupportFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.support));
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(LAYOUT, container, false);
    }
}