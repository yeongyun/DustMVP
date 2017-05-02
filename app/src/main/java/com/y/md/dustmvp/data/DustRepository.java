package com.y.md.dustmvp.data;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-01.
 */

public class DustRepository implements DustDataSource {

    private static DustRepository mInstance = null;

    private final DustDataSource mDustsRemoteDateSource;

    private DustRepository(@NonNull DustDataSource dustsRemoteDataSource) {
        mDustsRemoteDateSource = dustsRemoteDataSource;
    }

    public static DustRepository getInstance(DustDataSource dustsRemoteDataSource) {
        if(mInstance == null) {
            mInstance = new DustRepository(dustsRemoteDataSource);
        }
        return mInstance;
    }

    public static void destroyInstance() {
        mInstance = null;
    }

    @Override
    public void getDusts(@NonNull final LoadDustsCallback callback) {
        getDustsFromRemoteDataSource(callback);
    }

    @Override
    public void getDust(@NonNull final String dustId, @NonNull final GetDustCallback callback) {
        mDustsRemoteDateSource.getDust(dustId, new GetDustCallback() {
            @Override
            public void onDustLoaded(Dust dust) {
                    callback.onDustLoaded(dust);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveDust(@NonNull Dust dust) {
        mDustsRemoteDateSource.saveDust(dust);
    }

    @Override
    public void refreshDusts() {
        mDustsRemoteDateSource.refreshDusts();
    }

    @Override
    public void deleteAllDusts() {
        mDustsRemoteDateSource.deleteAllDusts();
    }

    @Override
    public void deleteDust(@NonNull String dustId) {
        mDustsRemoteDateSource.deleteDust(dustId);
    }

    private void getDustsFromRemoteDataSource(@NonNull final LoadDustsCallback callback) {
        mDustsRemoteDateSource.getDusts(new LoadDustsCallback() {
            @Override
            public void onDustLoaded(List<Dust> dusts) {
                callback.onDustLoaded(dusts);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }
}
