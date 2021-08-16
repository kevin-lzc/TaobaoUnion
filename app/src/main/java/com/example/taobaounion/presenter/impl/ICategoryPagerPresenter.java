package com.example.taobaounion.presenter.impl;

import com.example.taobaounion.base.IBasePresenter;
import com.example.taobaounion.view.ICategoryPagerCallBack;

/*
Date:
Time:
Author:lzc
*/
public interface ICategoryPagerPresenter extends IBasePresenter<ICategoryPagerCallBack> {
    //根据分类的Id获取相应title的内容
    void getContentByCategoryId(int categoryId);
    //加载更多
    void LoadMore(int categoryId);
    //重新加载
    void reload(int categoryId);

}
