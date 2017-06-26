package com.example.administrator.mircale.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.administrator.mircale.R;
import com.example.administrator.mircale.ui.fragment.AccountFragment;
import com.example.administrator.mircale.ui.fragment.ClassManagerFragment;
import com.example.administrator.mircale.ui.fragment.StudentFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 王春雪 on 2017/6/19.
 */

public class HomeActivity extends BaseActivity {
    @BindView(R.id.class_fragment)
    FrameLayout mClassFragment;
    @BindView(R.id.home_tablayout)
    TabLayout mHomeTablayout;
    private Fragment[] mFragments ;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        ClassManagerFragment fragment1 = new ClassManagerFragment();
        StudentFragment fragment2 = new StudentFragment();
        AccountFragment fragment3 = new AccountFragment();
        mFragments=new Fragment[]{fragment1,fragment2,fragment3};
        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        mTransaction.replace(R.id.class_fragment,fragment1);
        mTransaction.commit();
        mHomeTablayout.addTab(mHomeTablayout.newTab().setCustomView(R.layout.layout_tab_class),true);
        mHomeTablayout.addTab(mHomeTablayout.newTab().setCustomView(R.layout.layout_tab_student),false);
        mHomeTablayout.addTab(mHomeTablayout.newTab().setCustomView(R.layout.layout_tab_account),false);
        mHomeTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTransaction = mFragmentManager.beginTransaction();
                mTransaction.replace(R.id.class_fragment,mFragments[tab.getPosition()]);
                mTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
