package com.example.administrator.mircale;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.intent.IntentMonitorRegistry;

import com.example.administrator.mircale.utils.DisPlayUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by 王春雪 on 2017/6/21.
 */
@RunWith(AndroidJUnit4.class)
public class DisplayUtilsTest {
    @Test
    public void test(){
        Context context = InstrumentationRegistry.getContext();
        assertEquals(2, DisPlayUtils.px2dp(context,4));

    }

}
