package com.example.taobaounion.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;
import com.example.taobaounion.model.domain.Categories;
import com.example.taobaounion.presenter.impl.HomePresenterImpl;
import com.example.taobaounion.presenter.impl.IHomePresenter;
import com.example.taobaounion.ui.adapter.HomePagerAdapter;
import com.example.taobaounion.view.IHomeCallBack;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

public class HomeFragment extends BaseFragment implements IHomeCallBack {

    @BindView(R.id.home_indicator)
    public TabLayout mTabLayout;

    @BindView(R.id.home_pager)
    public ViewPager mHomePager;


    private IHomePresenter homePresenter;
    private FragmentManager childFragmentManager;
    private HomePagerAdapter homePagerAdapter;

    @Override
    protected int getRootViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View rootView) {
        /*
        因为TabLayout要与下面的ViewPager进行联动，所以要设置ViewPager与TabLayout
         */
        mTabLayout.setupWithViewPager(mHomePager);
        //在fragment中得到它的孩子Fragment
        childFragmentManager = getChildFragmentManager();
        homePagerAdapter = new HomePagerAdapter(childFragmentManager);
        mHomePager.setAdapter(homePagerAdapter);
    }

    @Override
    protected void initPresenter() {
        homePresenter = new HomePresenterImpl();
        //注册callback
        homePresenter.registerViewCallBack(this);
    }

    @Override
    protected void loadData() {
        //加载数据时显示这个LOADING VIEW
        setUpState(State.LOADING);
        homePresenter.getCategories();
    }

    @Override
    public void onCategoriesLoaded(Categories categories) {
            setUpState(State.SUCCESS);
        if (homePagerAdapter != null) {
            homePagerAdapter.setCategories(categories);
        }
    }

    @Override
    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.base_home_fragment_layout,container,false);
    }

    @Override
    public void onError() {
        setUpState(State.ERROR);
    }

    @Override
    public void onLoading() {
        setUpState(State.LOADING);
    }

    @Override
    public void onEmpty() {
        setUpState(State.EMPTY);
    }

    @Override
    protected void release() {
      //取消回调注册
        if (homePresenter != null) {
            homePresenter.unregisterViewCallBack(this);
        }
    }

    @Override
    protected void onRetryClick() {
        //网络错误点击重试
        //重新加载分类内容
        if (homePresenter != null) {
            homePresenter.getCategories();
        }
    }
}
