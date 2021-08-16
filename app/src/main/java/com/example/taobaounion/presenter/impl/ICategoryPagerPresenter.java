package com.example.taobaounion.presenter.impl;

/*
Date:
Time:
Author:lzc
*/
public interface ICategoryPagerPresenter {
    //根据分类的Id获取相应title的内容
    void getContentByCategoryId(int categoryId);
    //加载更多
    void LoadMore(int categoryId);
    //重新加载
    void reload(int categoryId);
}
