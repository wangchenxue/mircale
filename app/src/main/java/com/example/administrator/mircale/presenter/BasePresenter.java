package com.example.administrator.mircale.presenter;

import com.example.administrator.mircale.ui.view.MvpView;

/**
 * Created by wangchunxue on 2017/6/15.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {
    private T mMvpView;

    /**
     * 在presenter初始化后调用
     * @param mvpView
     */
    @Override
    public void attachView(T mvpView) {
        mvpView = mvpView;
    }

    /**
     * 在activity或者fragment的destroy中调用
     */
    @Override
    public void detachView() {

        mMvpView = null;
    }
    public boolean isViewAttached(){
        return mMvpView!=null;
    }
    public T getMvpView(){
        return mMvpView;
    }
    public void checkViewAttached(){
        if (!isViewAttached()) throw  new MvpViewNoattachedException();
    }
    public static class  MvpViewNoattachedException extends RuntimeException{
        public MvpViewNoattachedException(){
            super("please call Presenter.attachView before request data to the Presenter");
        }
    }

}
