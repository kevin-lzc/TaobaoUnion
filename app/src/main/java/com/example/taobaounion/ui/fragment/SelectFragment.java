package com.example.taobaounion.ui.fragment;

import android.view.View;

import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;

public class SelectFragment extends BaseFragment {

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_select;
    }
    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
    }
}

