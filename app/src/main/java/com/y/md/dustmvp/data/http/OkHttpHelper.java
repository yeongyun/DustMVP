package com.y.md.dustmvp.data.http;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by prompt32 on 2017-04-28.
 */

public class OkHttpHelper {

    public void getDustInfo(Callback callback) {
        String testUrl = "http://openapi.seoul.go.kr:8088/734253595079656f36387947586e69/json/RealtimeCityAir/1/100";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(testUrl).build();
        client.newCall(request).enqueue(callback);
    }
}
