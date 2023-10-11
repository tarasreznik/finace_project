package com.finaceproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.finaceproject.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddButtonFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_add_button;

    public void setContext(Context context) {
        this.context = context;
    }

    public static AddButtonFragment newInstance(Context context) {
        AddButtonFragment fragment = new AddButtonFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.add));
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btnAddCosts = getActivity().findViewById(R.id.costs_btn);
        Button btnAddIncomes = getActivity().findViewById(R.id.income_btn);
//        FloatingActionButton cancelButton = getActivity().findViewById(R.id.back_button_add);

        initFragmentTransaction(new AddCostsFragment());
//        btnAddCosts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                initFragmentTransaction(new AddCostsFragment());
//            }
//        });
//        btnAddIncomes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                initFragmentTransaction(new AddIncomesFragment());
//            }
//        });
//        cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                initFragmentTransaction(new HomeFragment());
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }

    private void initFragmentTransaction(AbstractTabFragment fragment) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }

}