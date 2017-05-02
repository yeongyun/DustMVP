package com.y.md.dustmvp.adapter.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.y.md.dustmvp.R;
import com.y.md.dustmvp.common.Util;
import com.y.md.dustmvp.data.Dust;
import com.y.md.dustmvp.listener.OnItemClickListener;

/**
 * Created by prompt32 on 2017-04-26.
 */

public class MainViewHolder extends BaseViewHolder {

    private Util util = new Util();

    public MainViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener listener) {
        super(context, viewGroup, R.layout.row_dust, listener);
    }

    @Override
    public void onBind(Dust dust, final int position) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) {
                    listener.onItemClick(position);
                }
            }
        });

        tvMeasureLoc.setText("NO." + (position + 1) + " " + dust.getMeasureLocation());
        tvDate.setText("측정일: " + util.changeDateFormat(dust.getMeasureDate()));
        tvDust.setText("미세먼지:" + dust.getMicroDust());
        tvMicroDust.setText("초미세먼지: " + dust.getUltraMicroDust());
        tvEnvRating.setText("통합대기환경등급: " + dust.getEnvRating());
    }
}
