package com.example.taobaounion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.taobaounion.R;

import org.jetbrains.annotations.NotNull;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

//为什么要使用abstract关键字，因为只有抽象类被子类继承，抽象类里面的抽象方法才能被子类调用
public abstract class BaseFragment extends Fragment {
    //设置网络请求状态的一个枚举类
    private State currentState=State.NONE;
    private View successView;
    private View loadingView;
    private View loadErrorView;
    private View loadEmptyView;

    public enum State{
        NONE,LOADING,SUCCESS,ERROR,EMPTY
    }

    @OnClick(R.id.network_error_tips)
    public void retry(){
        onRetryClick();
    }

    protected void onRetryClick() {

    }

    private Unbinder bind;
    private FrameLayout baseContainer;

    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View rootView = loadRootView(inflater,container);
        baseContainer = rootView.findViewById(R.id.base_container);
        //这个方法是为了管理加载结果的各种View的显示
        loadStateView(inflater,container);
        bind = ButterKnife.bind(this, rootView);
        initView(rootView);
        initPresenter();
        loadData();
        return  rootView;
    }

    protected View loadRootView(LayoutInflater inflater, ViewGroup container) {
       return inflater.inflate(R.layout.base_fragment_layout, container, false);
    }

    /*
    这个方法是为了管理加载结果的各种View的显示
     */
    private void loadStateView(LayoutInflater inflater, ViewGroup container) {
        //加载成功的显示View
        successView = loadSuccessView(inflater, container);
        baseContainer.addView(successView);
        //加载失败显示的View
        loadingView = loadLoadingView(inflater, container);
        baseContainer.addView(loadingView);
        //加载错误页面
        loadErrorView = loadErrorView(inflater, container);
        baseContainer.addView(loadErrorView);
        //加载空页面
      loadEmptyView = loadEmptyView(inflater, container);
      baseContainer.addView(loadEmptyView);
        setUpState(State.NONE);
    }

    protected View loadErrorView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_error, container,false);
    }

    protected View loadLoadingView(LayoutInflater inflater, ViewGroup container) {
     return inflater.inflate(R.layout.fragment_loading, container,false);
    }
    protected View loadEmptyView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_empty, container,false);
    }

    public void setUpState(State state){
       this.currentState=state;
        //更新View显示状态的方法
    successView.setVisibility(currentState==State.SUCCESS?View.VISIBLE:View.GONE);
    loadEmptyView.setVisibility(currentState==State.EMPTY?View.VISIBLE:View.GONE);
    loadingView.setVisibility(currentState==State.LOADING?View.VISIBLE:View.GONE);
    loadErrorView.setVisibility(currentState==State.ERROR?View.VISIBLE:View.GONE);
    }
    protected void initView(View rootView) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            //解绑释放资源
            bind.unbind();
        }
        release();
    }

    protected void release() {
        //释放资源，也就是调用UnCallback()方法
    }

    protected void initPresenter() {
    //创建presenter
    }

    protected void loadData() {
    //加载数据
    }

    protected  View loadSuccessView(@NotNull LayoutInflater inflater, @org.jetbrains.annotations.Nullable ViewGroup container){
      int resId=getRootViewId();
        return inflater.inflate(resId,container,false);
    }

    protected abstract int getRootViewId();


}
