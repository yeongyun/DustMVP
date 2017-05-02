package com.y.md.dustmvp;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.y.md.dustmvp.data.Dust;
import com.y.md.dustmvp.data.DustDataSource;
import com.y.md.dustmvp.data.DustRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prompt32 on 2017-05-01.
 */

public class MainPresenter implements MainContract.Presenter {

    private final DustRepository mDustRepository;
    private final MainContract.View mDustView;

    public MainPresenter(@NonNull DustRepository dustRepository, @NonNull MainContract.View dustView) {
        mDustRepository = dustRepository;
        mDustView = dustView;

        mDustView.setPresenter(this);
    }

    @Override
    public void start() {
        loadDusts(false);
    }

    @Override
    public void loadDusts(boolean forceUpdate) {
        loadDusts(forceUpdate, true);
    }

    private void loadDusts(final boolean forceUpdate, final boolean showLoadingUI) {
        if(showLoadingUI) {
            mDustView.setLoadingIndicator(true);
        }
        if(forceUpdate) {
            mDustRepository.refreshDusts();
        }

        mDustRepository.getDusts(new DustDataSource.LoadDustsCallback() {

            @Override
            public void onDustLoaded(List<Dust> dusts) {
                List<Dust> dustToShow = new ArrayList<>();

                for(Dust dust : dusts) {
                    dustToShow.add(dust);
                }

                if(showLoadingUI) {
                    mDustView.setLoadingIndicator(false);
                }

                processDusts(dustToShow);
            }

            @Override
            public void onDataNotAvailable() {
                mDustView.showLoadingDustsError();
            }
        });
    }

    private void processDusts(List<Dust> dusts) {
        if(dusts.isEmpty()) {
            processEmptyDusts();
        } else {
            mDustView.showDusts(dusts);
        }
    }

    private void processEmptyDusts() {
        mDustView.showNoDusts();
    }

    @Override
    public void result(int requestCode, int resultCode) {
        if(Activity.RESULT_OK == resultCode) {
        }
    }

    @Override
    public void addNewDust() {
        mDustView.showAddDust();
    }

    @Override
    public void openDustDetails(@NonNull Dust requestedTask) {
        mDustView.showDustDetailsUi(requestedTask.getId());
    }
}
