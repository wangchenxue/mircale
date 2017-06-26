package com.example.administrator.mircale.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.mircale.R;
import com.example.administrator.mircale.utils.LogUtils;
import com.example.administrator.mircale.view.DoubleText;
import com.example.administrator.mircale.view.LoadingDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.total_people)
    DoubleText mTotalPeople;
    @BindView(R.id.total)
    DoubleText mTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        mTotalPeople.setNumTxt("12");
        mTotalPeople.setNameTxt("距离考试结束时间");
        mTotal.setNumTxt("12");
      //  mTotal.setNameTxt("距离考试结束时间");

    }

    @OnClick(R.id.btn_load)
    public void onClick(View view) {
        LoadingDialog dialog = new LoadingDialog(this);
        dialog.show();

    }

}
