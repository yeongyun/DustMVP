package com.y.md.dustmvp.data;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-01.
 */

public interface DustDataSource {

    interface LoadDustsCallback {
        void onDustLoaded(List<Dust> dusts);
        void onDataNotAvailable();
    }

    interface GetDustCallback {
        void onDustLoaded(Dust dust);
        void onDataNotAvailable();
    }

    void getDusts(@NonNull LoadDustsCallback callback);

    void getDust(@NonNull String dustId, @NonNull GetDustCallback callback);

    void saveDust(@NonNull Dust dust);

    void refreshDusts();

    void deleteAllDusts();

    void deleteDust(@NonNull String dustId);
}
