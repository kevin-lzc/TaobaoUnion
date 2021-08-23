package com.example.taobaounion.presenter.impl;

import com.example.taobaounion.model.Api;
import com.example.taobaounion.model.domain.Categories;
import com.example.taobaounion.utils.LogUtils;
import com.example.taobaounion.utils.RetrofitManager;
import com.example.taobaounion.view.IHomeCallBack;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenterImpl implements IHomePresenter{
    private IHomeCallBack mCallback=null;

    @Override
    public void getCategories() {
        //处理网络请求的状态信息
        if (mCallback != null) {
            mCallback.onLoading();
        }
//加载分类内容
        Retrofit retrofit = RetrofitManager.getInstance().getmRetrofit();
        Api api = retrofit.create(Api.class);
        Call<Categories> task = api.getCategories();
        task.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                int code = response.code();
                LogUtils.d(HomePresenterImpl.this,"Result code is--->"+code);
                if (code== HttpURLConnection.HTTP_OK){
                    Categories categories = response.body();
                    if (mCallback!=null){
                        if (categories == null||categories.getData().size()==0) {
                    mCallback.onEmpty();
                        }else {
                            mCallback.onCategoriesLoaded(categories);
                        }
                    }
                    else {
                        if (mCallback != null) {
                            mCallback.onError();
                        }
                    }
                    LogUtils.d(HomePresenterImpl.this,"categories-->"+categories);
                }else {

                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                if (mCallback != null) {
                    mCallback.onError();
                }
            }
        });
    }

    @Override
    public void registerViewCallBack(IHomeCallBack CallBack) {
        this.mCallback=CallBack;
    }

    @Override
    public void unregisterViewCallBack(IHomeCallBack CallBack) {
mCallback=null;
    }
}
