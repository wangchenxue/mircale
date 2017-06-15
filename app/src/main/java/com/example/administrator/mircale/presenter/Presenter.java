package com.example.administrator.mircale.presenter;

import com.example.administrator.mircale.ui.view.MvpView;

/**
 * Created by wangchunxue on 2017/6/15.
 */

public interface Presenter<V extends MvpView> {
    void attachView(V mvpView);

    void detachView();
}
