package com.example.taobaounion.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.taobaounion.model.domain.Categories;
import com.example.taobaounion.ui.fragment.HomePagerFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
/*
这个类是设置TabLayout里面的内容
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
private List<Categories.DataBean> categoryList=new ArrayList<>();
    private HomePagerFragment homePagerFragment;


    public HomePagerAdapter(@NonNull @NotNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        /*
        得到数据，将数据返回到HomePagerAdapter中
         */
        Categories.DataBean dataBean = categoryList.get(position);
        homePagerFragment = HomePagerFragment.newInstance(dataBean);
        return homePagerFragment;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return categoryList.get(position).getTitle();
    }

    public void setCategories(Categories categories) {
        categoryList.clear();
        List<Categories.DataBean> categoriesData = categories.getData();
        categoryList.addAll(categoriesData);
        notifyDataSetChanged();
    }
}
