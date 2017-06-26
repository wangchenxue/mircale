package com.example.administrator.mircale.ui.activity;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.mircale.R;
import com.example.administrator.mircale.utils.DisPlayUtils;

/**
 * Created by 王春雪 on 2017/6/20.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    private Context mContext;

    //这里的泛型是观察者 FloatingActionButton
    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        //dependency是被观察者

        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        if (dependency instanceof AppBarLayout) {
            int toolBarHeight = parent.findViewById(R.id.toolbar).getHeight();
            ImageView imageView = (ImageView) parent.findViewById(R.id.img_btn_add);
            //floatingActionButton的位移比上APPBarLayout的位移，
            // 这里floatingActionButton是相对于AppBarlayout的相对位移，为toolBar高度的1/2，
            // appBarLayout的位移为appbarLayout的高度减去toolbar的高度
            float ratio = toolBarHeight / 2 / ((float) (dependency.getHeight() - toolBarHeight));
            int height = (int) ((int) dependency.getY() * ratio);
            child.setTranslationY(height);
            //这里floatingActionBar在X轴上的位移为屏幕宽度减去floatingActionBar宽度的一半
            //根据APPbarLayout在Y轴上的位移计算floatingActionButton在X轴上的位移变化
            float displayWidth = DisPlayUtils.getDisplayWidth(mContext);
            float radioW = (displayWidth - child.getWidth()) / 2 / (dependency.getHeight() - toolBarHeight);
            int translateWidth = (int) (dependency.getY() * radioW) * (-1);
            child.setTranslationX(translateWidth);
            //floatingActionButton的透明度变化
            child.setAlpha((1+(dependency.getY() / (dependency.getHeight() - toolBarHeight))));
            //imageview的变化
            imageView.setAlpha((-1)*dependency.getY() / (dependency.getHeight() - toolBarHeight));
        }
        return true;
    }


}
