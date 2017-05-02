package com.y.md.dustmvp;

import android.support.annotation.NonNull;

import com.y.md.dustmvp.data.Dust;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-01.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);
        void showDusts(List<Dust> dusts);
        void showAddDust();
        void showDustDetailsUi(String taskId);
        void showLoadingDustsError();
        void showNoDusts();
    }

    interface Presenter extends BasePresenter {
        void loadDusts(boolean forceUpdate);
        void result(int requestCode, int resultCode);
        void addNewDust();
        void openDustDetails(@NonNull Dust requestedTask);
    }
}
