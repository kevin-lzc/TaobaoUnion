package com.example.taobaounion.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;
import com.example.taobaounion.ui.fragment.HomeFragment;
import com.example.taobaounion.ui.fragment.RedPacketFragment;
import com.example.taobaounion.ui.fragment.SearchFragment;
import com.example.taobaounion.ui.fragment.SelectFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.main_navigation_bar)
    BottomNavigationView mNavigationView;
    private HomeFragment homeFragment;
    private RedPacketFragment redPacketFragment;
    private SearchFragment searchFragment;
    private SelectFragment selectFragment;
    private FragmentManager mFm;
    private FragmentTransaction fragmentTransaction;
    private Unbinder mBind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initFragment();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        redPacketFragment = new RedPacketFragment();
        searchFragment = new SearchFragment();
        selectFragment = new SelectFragment();
        mFm = getSupportFragmentManager();
        switchFragment(homeFragment);
    }

    private void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(item -> {
    if (item.getItemId()==R.id.home){
        switchFragment(homeFragment);
    }else if(item.getItemId()==R.id.selected){
        switchFragment(selectFragment);
    }else if(item.getItemId()==R.id.red_packet){
        switchFragment(redPacketFragment);
    }else if(item.getItemId()==R.id.search){
        switchFragment(searchFragment);
    }

return true;
});
    }

    private void switchFragment(BaseFragment targetFragment) {
        fragmentTransaction = mFm.beginTransaction();
        fragmentTransaction.replace(R.id.main_page_container,targetFragment);
        fragmentTransaction.commit();
    }


}