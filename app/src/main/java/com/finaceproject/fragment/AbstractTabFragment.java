package com.finaceproject.fragment;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.Fragment;

public class AbstractTabFragment extends Fragment {
    private String title;
    protected Context context;
    protected View view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
