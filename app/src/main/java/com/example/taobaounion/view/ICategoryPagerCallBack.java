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
    void onContentLoaded(List<HomePagerContent> contents);
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


}


