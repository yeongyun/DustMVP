package com.y.md.dustmvp.data.source;

import android.support.annotation.NonNull;

import com.y.md.dustmvp.data.Dust;
import com.y.md.dustmvp.data.DustDataSource;
import com.y.md.dustmvp.data.http.OkHttpHelper;
import com.y.md.dustmvp.parser.JSONParserHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by prompt32 on 2017-05-01.
 */

public class DustsRemoteDataSource implements DustDataSource {

    private static DustsRemoteDataSource mInstance;
    private OkHttpHelper mOkHttpHelper;

    private final static Map<String, Dust> DUSTS_SERVICE_DATA;

    static {
        DUSTS_SERVICE_DATA = new LinkedHashMap<>(2);
    }

    public static DustsRemoteDataSource getInstance() {
        if(mInstance == null) {
            mInstance = new DustsRemoteDataSource();
        }
        return mInstance;
    }

    private DustsRemoteDataSource(){}

    private static void addDust() {
        Dust newDust = new Dust();
        DUSTS_SERVICE_DATA.put(newDust.getId(), newDust);
    }

    @Override
    public void getDusts(@NonNull final LoadDustsCallback callback) {
        if(mOkHttpHelper == null) {
            mOkHttpHelper = new OkHttpHelper();
        }

        mOkHttpHelper.getDustInfo(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                JSONParserHelper parserHelper = new JSONParserHelper();
                List<Dust> dustList = null;
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    dustList = parserHelper.parseDustList(jsonObject);
                    callback.onDustLoaded(dustList);
                } catch (JSONException e) {
                    e.printStackTrace();
                    callback.onDataNotAvailable();
                }
            }
        });
    }

    @Override
    public void getDust(@NonNull String dustId, @NonNull GetDustCallback callback) {

    }

    @Override
    public void saveDust(@NonNull Dust dust) {
        DUSTS_SERVICE_DATA.put(dust.getId(), dust);
    }

    @Override
    public void refreshDusts() {
        //TODO refresh
    }

    @Override
    public void deleteAllDusts() {
        DUSTS_SERVICE_DATA.clear();
    }

    @Override
    public void deleteDust(@NonNull String dustId) {
        DUSTS_SERVICE_DATA.remove(dustId);
    }
}
