package com.example.administrator.mircale.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.mircale.R;
import com.example.administrator.mircale.view.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_load)
    public void onClick(View view) {
        LoadingDialog dialog = new LoadingDialog(this);
        dialog.show();

    }
}
