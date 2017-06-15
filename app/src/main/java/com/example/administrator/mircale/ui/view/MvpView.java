package com.example.administrator.mircale.ui.view;

import java.util.HashMap;

/**
 * Created by wangchunxue on 2017/6/15.
 */

public interface MvpView {
    void startLoading();
    void hideLoading();
    void showError(String msg);

}
