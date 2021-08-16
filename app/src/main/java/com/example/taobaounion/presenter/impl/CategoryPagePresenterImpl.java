package com.example.taobaounion.presenter.impl;

import com.example.taobaounion.model.Api;
import com.example.taobaounion.model.domain.HomePagerContent;
import com.example.taobaounion.utils.LogUtils;
import com.example.taobaounion.utils.RetrofitManager;
import com.example.taobaounion.utils.UrlUtils;
import com.example.taobaounion.view.ICategoryPagerCallBack;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CategoryPagePresenterImpl implements ICategoryPagerPresenter{
    //设置一个集合用于保存categoryId和page,便于确认哪个id属于哪个页面
    private Map<Integer,Integer> pagesInfo=new HashMap<>();
    public static final int DEFAULT_PAGE=1;
    /*
    创建单例模式设置单个presenter
    饿汉式
     */
private CategoryPagePresenterImpl(){

}
private  static ICategoryPagerPresenter sInstance=null;

public static ICategoryPagerPresenter getsInstance(){
    if (sInstance == null) {
        sInstance=new CategoryPagePresenterImpl();
    }
    return sInstance;
}




    @Override
    public void getContentByCategoryId(int categoryId) {
/*
根据title的分类ID去加载内容
 */
        Retrofit retrofit = RetrofitManager.getInstance().getmRetrofit();
        Api api = retrofit.create(Api.class);
        Integer targetPage = pagesInfo.get(categoryId);
        if (targetPage == null) {
            targetPage = DEFAULT_PAGE;
            pagesInfo.put(categoryId, targetPage);
        }
        String homePagerUrl = UrlUtils.createHomePagerUrl(categoryId, targetPage);
        LogUtils.d(this,"home pager url--->"+homePagerUrl);
        Call<HomePagerContent> call = api.getHomePageContent(homePagerUrl);
        call.enqueue(new Callback<HomePagerContent>() {
            @Override
            public void onResponse(Call<HomePagerContent> call, Response<HomePagerContent> response) {
                int code = response.code();
                if (code== HttpURLConnection.HTTP_OK){
                    HomePagerContent PagerContent = response.body();
                    LogUtils.d(CategoryPagePresenterImpl.this,">>>>>>"+PagerContent+">>>>>>");
                }else {

                }
            }

            @Override
            public void onFailure(Call<HomePagerContent> call, Throwable t) {

            }
        });
    }

    @Override
    public void LoadMore(int categoryId) {

    }

    @Override
    public void reload(int categoryId) {

    }

    @Override
    public void registerViewCallBack(ICategoryPagerCallBack CallBack) {

    }

    @Override
    public void unregisterViewCallBack(ICategoryPagerCallBack CallBack) {

    }
}
