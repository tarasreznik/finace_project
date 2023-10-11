package com.finaceproject.adapter;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.finaceproject.fragment.AbstractTabFragment;
import com.finaceproject.fragment.AddButtonFragment;
import com.finaceproject.fragment.AddIncomesFragment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PagesFragmentAdapter extends FragmentPagerAdapter {
    private Map<Integer, AbstractTabFragment> tabs;

    public PagesFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        initTabMap(context);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Objects.requireNonNull(tabs.get(position)).getTitle();
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        return Objects.requireNonNull(tabs.get(i));
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(0, AddButtonFragment.newInstance(context));
        tabs.put(1, AddIncomesFragment.newInstance(context));
    }
}
