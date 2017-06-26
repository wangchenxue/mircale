package com.example.administrator.mircale.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mircale.ui.view.MvpView;
import com.example.administrator.mircale.view.LoadingDialog;

/**
 * Created by wangchunxue on 2017/6/15.
 */

public class BaseActivity extends AppCompatActivity implements MvpView {
    protected  LoadingDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void startLoading() {
        if (mDialog == null) {
            mDialog = new LoadingDialog(this);
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

    protected void initView() {

    }

    protected void initData() {

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

}
