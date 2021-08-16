package com.example.taobaounion.base;

import com.example.taobaounion.view.ICategoryPagerCallBack;

/*
使用泛型指定IBasePresenter<>中的变量
 */
public interface IBasePresenter<T> {
    //进行注册
    void registerViewCallBack(T CallBack);
    //取消注册
    void unregisterViewCallBack(T CallBack);
}
