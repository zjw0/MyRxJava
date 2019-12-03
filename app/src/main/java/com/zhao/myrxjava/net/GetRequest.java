package com.zhao.myrxjava.net;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhao.myrxjava.Interface.GetRequestInterface;
import com.zhao.myrxjava.R;
import com.zhao.myrxjava.bean.TranslationBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YBD-TECH029 on 2019/12/3.
 */

public class GetRequest extends AppCompatActivity {

    public static final String TAG = "RetrofitGet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request();
        // 使用Retrofit封装的方法
    }
    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);

        //对 发送请求 进行封装
        Call<TranslationBean> call = request.getCall();

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<TranslationBean>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<TranslationBean> call, Response<TranslationBean> response) {
                // 步骤7：处理返回的数据结果
                response.body().show();
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<TranslationBean> call, Throwable throwable) {
                Log.d(TAG, "连接失败");
            }
        });
        finish();
    }
}
