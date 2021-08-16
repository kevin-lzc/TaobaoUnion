package com.example.taobaounion.presenter.impl;

import com.example.taobaounion.view.IHomeCallBack;

public interface IHomePresenter {
    /*
    获取商品分类
     */
    void getCategories();
    /*
    注册UI通知的接口
     */
    void registerCallback(IHomeCallBack callBack);
    /*
    取消UI通知的接口
     */
    void UnregisterCallback(IHomeCallBack callBack);
}
