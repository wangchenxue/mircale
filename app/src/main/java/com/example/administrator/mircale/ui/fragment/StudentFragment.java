package com.example.administrator.mircale.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.example.administrator.mircale.R;
import com.example.administrator.mircale.api.ProvinceSelectCallback;
import com.example.administrator.mircale.utils.LogUtils;
import com.example.administrator.mircale.utils.ViewShowUtils;
import com.example.administrator.mircale.view.MyDialog;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 王春雪 on 2017/6/22.
 */

public class StudentFragment extends BaseFragment implements TimePickerView.OnTimeSelectListener, ProvinceSelectCallback, View.OnClickListener, MyDialog.MakesureListener {

    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.name2)
    TextView mName2;
    @BindView(R.id.name3)
    TextView mName3;
    private Unbinder mBind;
    private TimePickerView mPvTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_student_layout, null);
        mBind = ButterKnife.bind(this, mView);
        initView();
        return mView;
    }

    private void initView() {
        //选中事件回调

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
    }

    @OnClick(R.id.show_pik)
    public void onClick(View view) {
        /*ViewShowUtils.showTimePicker(getActivity(),StudentFragment.this
        );  */
       ViewShowUtils.showMyDialog(getContext(),
              "&*（&&………………ＦＧＧＢＹＨ恢复和安抚东风街化蝶飞",this);
    }

    @Override
    public void onTimeSelect(Date date, View v) {
        mName.setText(ViewShowUtils.getTime(date, "yyyyy-MM-dd"));
    }


    @Override
    public void getProvince(String string) {
        mName2.setText(string);
    }


    @Override
    public void domakesure() {
        LogUtils.logi("main","***");
        ViewShowUtils.dismissDialog();

    }
}
