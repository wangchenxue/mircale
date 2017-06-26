package com.example.administrator.mircale.utils;

import android.content.Context;
import android.view.View;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.example.administrator.mircale.api.ProvinceSelectCallback;
import com.example.administrator.mircale.entity.ProvinceData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间选择，省份选择，加载对话框的show和消失
 * Created by 王春雪 on 2017/6/26.
 */

public class ViewShowUtils {
    private static TimePickerView mPvTime;
    static boolean[] types = new boolean[]{true, true, true, false, false, false};//年月日时分秒的显示
    private ArrayList<ProvinceData> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    public static void showTimePicker(Context context, TimePickerView.OnTimeSelectListener listener) {
        mPvTime = new TimePickerView.Builder(context, listener)
                .setType(types)//默认全部显示
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(false)//是否循环滚动
                // .setTitleColor(Color.BLACK)//标题文字颜色
                // .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                // .setCancelColor(Color.BLUE)//取消按钮文字颜色
                //.setTitleBgColor(Color.GRAY)//标题背景颜色 Night mode
                //.setBgColor(Color.WHITE)//滚轮背景颜色 Night mode
                .isCenterLabel(true) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(false)//是否显示为对话框样式
                .setTitleText("时间")
                .build();
        mPvTime.setDate(Calendar.getInstance());
        mPvTime.show();
    }

    /**
     * 把date按格式转换
     *
     * @param date
     * @param formate
     * @return
     */
    public static String getTime(Date date, String formate) {
        SimpleDateFormat format = new SimpleDateFormat(formate);
        return format.format(date);
    }

    /**
     * 从assets中读取json数据，并解析成实体类，这里的实体类需要实现IPickerViewData 接口，
     * PickerView会通过getPickerViewText方法获取字符串显示出来。
     *
     * @param context
     */
    private void initProvinceData(Context context) {
        String jsonData = FileUtils.getAsset(context, "province_data.json");
        ArrayList<ProvinceData> provinceDatas = getProvince(jsonData);
        options1Items = provinceDatas;

        for (int i = 0; i < provinceDatas.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < provinceDatas.get(i).getCity().size(); c++) {//遍历该省份的所有城市
                String CityName = provinceDatas.get(i).getCity().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (provinceDatas.get(i).getCity().get(c).getArea() == null
                        || provinceDatas.get(i).getCity().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < provinceDatas.get(i).getCity().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = provinceDatas.get(i).getCity().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }

    }

    /**
     * json解析
     *
     * @param json
     * @return
     */
    private ArrayList<ProvinceData> getProvince(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<ArrayList<ProvinceData>>() {
        }.getType());

    }

    /**
     * 选择省市县的三级联动
     *
     * @param context
     * @param callback
     */
    public void showProvince(Context context, final ProvinceSelectCallback callback) {
        initProvinceData(context);
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String text = options1Items.get(options1).getPickerViewText() +
                        options2Items.get(options1).get(options2) +
                        options3Items.get(options1).get(options2).get(options3);
                callback.getProvince(text);
            }
        })
                .setTitleText("")
                //  .setDividerColor(Color.GRAY)
                //   .setTextColorCenter(Color.GRAY)
                // .setContentTextSize(13)
                .setOutSideCancelable(false)
                .build();
          /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();

    }

}
