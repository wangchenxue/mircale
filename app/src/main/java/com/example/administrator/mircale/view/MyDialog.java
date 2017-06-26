package com.example.administrator.mircale.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.mircale.R;
import com.example.administrator.mircale.utils.DisPlayUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 王春雪 on 2017/6/26.
 */

public class MyDialog extends Dialog {
    private TextView mDialogTitle, mDialogContent, mBtnCancle, mBtnMakesure;
    private View mView;
    private MyDialog.MakesureListener mListener;

    public MyDialog(@NonNull Context context) {
        this(context, R.style.MyDialog);
    }

    public MyDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        setCanceledOnTouchOutside(false);
        initView(context);
    }

    private void initView(Context context) {
        mView = LayoutInflater.from(context).inflate(R.layout.layout_mydialog, null);
        setContentView(mView);
        mDialogTitle = (TextView) mView.findViewById(R.id.dialog_title);
        mDialogContent = (TextView) mView.findViewById(R.id.dialog_content);
        mBtnCancle = (TextView) mView.findViewById(R.id.btn_cancle);
        mBtnMakesure = (TextView) mView.findViewById(R.id.btn_makesure);
        mBtnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = (int) (DisPlayUtils.getDisplayWidth(context) * 0.6);
        getWindow().setAttributes(layoutParams);
    }
    public void showDialog(String title, String content, MakesureListener makesureListener){
        mDialogTitle.setText(title);
        mDialogContent.setText(content);
        this.mListener = makesureListener;
        mBtnMakesure.setOnClickListener(new MakesureCallBack());
        show();
    }
    public void showDialog( String content, MakesureListener makesureListener){
        mDialogTitle.setVisibility(View.GONE);
        mDialogContent.setText(content);
        this.mListener = makesureListener;
        mBtnMakesure.setOnClickListener(new MakesureCallBack());
        show();
    }
    public class MakesureCallBack implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            mListener.domakesure();
        }
    }
    public interface MakesureListener {
        void domakesure();
    }
}
