package com.example.administrator.mircale.ui.fragment;


import android.support.v4.app.Fragment;

import com.example.administrator.mircale.ui.view.MvpView;

/**
 * Created by wangchunxue on 2017/6/15.
 */

public class BaseFragment extends Fragment implements MvpView {

    @Override
    public void startLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }
}
