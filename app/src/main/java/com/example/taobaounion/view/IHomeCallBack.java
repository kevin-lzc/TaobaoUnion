package com.example.taobaounion.view;

import com.example.taobaounion.model.domain.Categories;

public interface IHomeCallBack {
    void onCategoriesLoaded(Categories categories);
    void onNetWorkError();
    void onLoading();
    void onEmpty();
}
