package com.example.taobaounion.view;

import com.example.taobaounion.base.IBaseCallBack;
import com.example.taobaounion.model.domain.HomePagerContent;

import java.util.List;

/*
Date:
Time:
Author:lzc
*/   public interface ICategoryPagerCallBack extends IBaseCallBack {
/*
数据加载回来的回调
 */
    void onContentLoaded(List<HomePagerContent.DataBean> contents);
    /*
    加载中
     */
    int getCategoryId();


    /*
    下拉刷新加载更多网络错误
     */
    void onLoadMoreError();
    /*
    下拉刷新加载更多为空
     */
    void onLoadMoreEmpty();
    /*
    下拉刷新加载更多成功
     */
    void onLoadMoreLoaded(List<HomePagerContent.DataBean> contents);
    /*
    加载轮播图
     */
    void onLooperListLoaded(List<HomePagerContent.DataBean> contents);
}


