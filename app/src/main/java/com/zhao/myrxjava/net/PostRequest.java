package com.zhao.myrxjava.net;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhao.myrxjava.Interface.GetRequestInterface;
import com.zhao.myrxjava.Interface.PostRequestInterface;
import com.zhao.myrxjava.R;
import com.zhao.myrxjava.bean.PostTranslationBean;
import com.zhao.myrxjava.bean.TranslationBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YBD-TECH029 on 2019/12/3.
 */

public class PostRequest extends AppCompatActivity {

    public static final String TAG = "RetrofitPost";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        request();
    }
    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        PostRequestInterface request = retrofit.create(PostRequestInterface.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<PostTranslationBean> call = request.getCall("I love you");

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<PostTranslationBean>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<PostTranslationBean> call, Response<PostTranslationBean> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                Log.d(TAG, response.body().getTranslateResult().get(0).get(0).getTgt());
//                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<PostTranslationBean> call, Throwable throwable) {
                Log.d(TAG, "连接失败");
                Log.d(TAG, throwable.getMessage());
//                System.out.println("请求失败");
//                System.out.println(throwable.getMessage());
            }
        });
        finish();
    }

}
