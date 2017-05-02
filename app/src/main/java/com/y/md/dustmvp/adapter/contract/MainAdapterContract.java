package com.y.md.dustmvp.adapter.contract;

import com.y.md.dustmvp.data.Dust;

import java.util.List;

/**
 * Created by prompt32 on 2017-05-02.
 */

public interface MainAdapterContract {
    interface View {
        void notifyAdapter();
    }

    interface Model {
        void addItems(List<Dust> items);
        void clearItem();
    }
}
