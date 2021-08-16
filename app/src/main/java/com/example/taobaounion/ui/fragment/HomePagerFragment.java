package com.example.taobaounion.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.taobaounion.R;
import com.example.taobaounion.base.BaseFragment;
import com.example.taobaounion.model.domain.Categories;
import com.example.taobaounion.model.domain.HomePagerContent;
import com.example.taobaounion.presenter.impl.CategoryPagePresenterImpl;
import com.example.taobaounion.presenter.impl.ICategoryPagerPresenter;
import com.example.taobaounion.utils.Constants;
import com.example.taobaounion.view.ICategoryPagerCallBack;

import java.util.List;

public class HomePagerFragment extends BaseFragment implements ICategoryPagerCallBack {

    private ICategoryPagerPresenter categoryPagerPresenter;

    //这个方法是设置使用Bundle装数据，然后进行fragment之间的数据传递
    public static HomePagerFragment newInstance(Categories.DataBean category){
        HomePagerFragment homePagerFragment=new HomePagerFragment();
        Bundle bundle=new Bundle();
        bundle.putString(Constants.KEY_HOME_PAGER_TITLE,category.getTitle());
        bundle.putInt(Constants.KEY_HOME_PAGER_MATERIAL_ID,category.getId());
        homePagerFragment.setArguments(bundle);
        return homePagerFragment;
    }
    @Override
    protected int getRootViewId() {
        return R.layout.fragment_home_pager;
    }

    @Override
    protected void initView(View rootView) {
        setUpState(State.SUCCESS);
    }

    @Override
    protected void loadData() {
        Bundle arguments = getArguments();
        String title = arguments.getString(Constants.KEY_HOME_PAGER_TITLE);
        int materialId = arguments.getInt(Constants.KEY_HOME_PAGER_MATERIAL_ID);
        if (categoryPagerPresenter != null) {
            categoryPagerPresenter.getContentByCategoryId(materialId);
        }
    }


    @Override
    protected void initPresenter() {
        categoryPagerPresenter = CategoryPagePresenterImpl.getsInstance();
        categoryPagerPresenter.registerViewCallBack(this);
    }

    @Override
    public void onContentLoaded(List<HomePagerContent.DataBean> contents) {

    }

    @Override
    public void onLoading(int categoryId) {

    }

    @Override
    public void onError(int cateGoryId) {

    }

    @Override
    public void onEmpty(int cateGoryId) {

    }

    @Override
    public void onLoadMoreError(int categoryId) {

    }

    @Override
    public void onLoadMoreEmpty(int categoryId) {

    }

    @Override
    public void onLoadMoreLoaded(List<HomePagerContent.DataBean> contents) {

    }

    @Override
    public void onLooperListLoaded(List<HomePagerContent.DataBean> contents) {

    }

    @Override
    protected void release() {
        if (categoryPagerPresenter != null) {
            categoryPagerPresenter.unregisterViewCallBack(this);

        }

    }
}
