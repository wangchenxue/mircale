package com.example.administrator.mircale.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.mircale.R;
import com.example.administrator.mircale.ui.adapter.HomeRecyclerAdapter;
import com.example.administrator.mircale.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 王春雪 on 2017/6/21.
 */

public class ClassManagerFragment extends BaseFragment {
    @BindView(R.id.img_btn_search)
    ImageView mImgBtnSearch;
    @BindView(R.id.img_btn_add)
    ImageView mImgBtnAdd;
    @BindView(R.id.home_class_recycle)
    RecyclerView mHomeClassRecycle;
    @BindView(R.id.btn_floatingAction)
    FloatingActionButton mBtnFloatingAction;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classmanager, null);
        mUnbinder = ButterKnife.bind(this, view);
        mHomeClassRecycle.setAdapter(new HomeRecyclerAdapter());
        //设置排列方式  上下文 排列方式 是否反转
        mHomeClassRecycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @OnClick(value = {R.id.btn_floatingAction, R.id.img_btn_search, R.id.img_btn_add})
    public void onClickListener(View view) {
        switch (view.getId()) {
            case R.id.img_btn_search:
                break;
            case R.id.btn_floatingAction:
            case R.id.img_btn_add:
                break;
        }
    }


}
