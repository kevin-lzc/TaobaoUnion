package com.example.taobaounion.view;

import com.example.taobaounion.model.domain.HomePagerContent;

import java.util.List;

/*
Date:
Time:
Author:lzc
*/   public interface ICategoryPagerCallBack {
/*
数据加载回来的回调
 */
    void onContentLoaded(List<HomePagerContent.DataBean> contents);
    /*
    加载中
     */
    void onLoading(int categoryId);
    /*
    网络错误
     */
    void onError(int cateGoryId);
    /*
    数据为空
     */
    void onEmpty(int cateGoryId);

    /*
    下拉刷新加载更多网络错误
     */
    void onLoadMoreError(int categoryId);
    /*
    下拉刷新加载更多为空
     */
    void onLoadMoreEmpty(int categoryId);
    /*
    下拉刷新加载更多成功
     */
    void onLoadMoreLoaded(List<HomePagerContent.DataBean> contents);
    /*
    加载轮播图
     */
    void onLooperListLoaded(List<HomePagerContent.DataBean> contents);
}


