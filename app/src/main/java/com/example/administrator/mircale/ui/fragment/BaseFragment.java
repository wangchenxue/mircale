package com.example.administrator.mircale.ui.fragment;


import android.support.v4.app.Fragment;

import com.example.administrator.mircale.ui.view.MvpView;
import com.example.administrator.mircale.view.LoadingDialog;

/**
 * Created by wangchunxue on 2017/6/15.
 */

public class BaseFragment extends Fragment implements MvpView {
    protected LoadingDialog mDialog;

    @Override
    public void startLoading() {
        if (mDialog == null) {
            mDialog = new LoadingDialog(getContext());
        }
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    @Override
    public void showError(String msg) {

    }
}
