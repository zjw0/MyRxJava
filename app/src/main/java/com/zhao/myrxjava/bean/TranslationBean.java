package com.zhao.myrxjava.bean;

import android.util.Log;

import static com.zhao.myrxjava.net.GetRequest.TAG;

/**
 * Created by YBD-TECH029 on 2019/12/3.
 */

public class TranslationBean {

    private int status;

    private content content;
    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;
    }

    //定义 输出返回数据 的方法
    public void show() {
        Log.d(TAG, String.valueOf(status));

        Log.d(TAG, content.from);
        Log.d(TAG, content.to);
        Log.d(TAG, content.vendor);
        Log.d(TAG, content.out);
        Log.d(TAG, String.valueOf(content.errNo));

//        System.out.println(status);
//
//        System.out.println(content.from);
//        System.out.println(content.to);
//        System.out.println(content.vendor);
//        System.out.println(content.out);
//        System.out.println(content.errNo);
    }
}
