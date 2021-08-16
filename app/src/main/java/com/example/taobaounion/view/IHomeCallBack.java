package com.example.taobaounion.view;

import com.example.taobaounion.base.IBaseCallBack;
import com.example.taobaounion.model.domain.Categories;

public interface IHomeCallBack extends IBaseCallBack {
    void onCategoriesLoaded(Categories categories);

}
