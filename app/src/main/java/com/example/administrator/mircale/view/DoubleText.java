package com.example.administrator.mircale.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.mircale.R;

/**
 * Created by 王春雪 on 2017/6/22.
 */

public class DoubleText extends LinearLayout {
    private View mView;
    private TextView mNomtxt;
    private TextView mNameText;
    private String txt_num,txt_name;

    public DoubleText(Context context) {
        this(context,null);
    }


    public DoubleText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);

    }
    public DoubleText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mView = LayoutInflater.from(context).inflate(R.layout.layout_custom_doubletext,this,true);
        getStyable(context,attrs);
        initView();
    }

    private void getStyable(Context context,AttributeSet attrs) {
        TypedArray array =context.obtainStyledAttributes(attrs,R.styleable.doubletext);
        txt_num = array.getString(R.styleable.doubletext_txt_num);
        txt_name = array.getString(R.styleable.doubletext_txt_name);
    }


    private void initView() {
        mNomtxt = (TextView) mView.findViewById(R.id.txt_num);
        mNameText = (TextView)mView. findViewById(R.id.txt_name);
        mNomtxt.setText(txt_num);
        mNameText.setText(txt_name);
    }
    public void setNumTxt(String num){
        if (num!=null){
        mNomtxt.setText(num);
        }
        invalidate();
    }
    public void setNameTxt(String name){
        if (name!=null){
            mNameText.setText(name);
        }
        invalidate();

    }

}
