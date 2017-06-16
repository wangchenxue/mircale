package com.example.administrator.mircale.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mircale.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by wangchunxue on 2017/6/15.
 */

public class LoadingDialog extends Dialog {
    @BindView(R.id.img_load)
    ImageView mImgLoad;
    @BindView(R.id.dialog_text)
    TextView mDialogText;
    private Context mContext;
    private Unbinder mUnbinder;

    public LoadingDialog(Context context) {
        this(context, R.style.MyDialog);
    }

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydialog_layout);
        mUnbinder = ButterKnife.bind(this);
        setCanceledOnTouchOutside(false);//点击外部不允许消失
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.loading_dialog_anim);
            mImgLoad.startAnimation(animation);
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mUnbinder.unbind();

    }
}

