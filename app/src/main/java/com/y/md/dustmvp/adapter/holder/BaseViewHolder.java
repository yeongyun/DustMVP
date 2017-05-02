package com.y.md.dustmvp.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.y.md.dustmvp.R;
import com.y.md.dustmvp.data.Dust;
import com.y.md.dustmvp.listener.OnItemClickListener;

/**
 * Created by prompt32 on 2017-05-02.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public Context context;
    public OnItemClickListener listener;

    public TextView tvDate;
    public TextView tvMeasureLoc;
    public TextView tvDust;
    public TextView tvMicroDust;
    public TextView tvEnvRating;

    public BaseViewHolder(Context context, ViewGroup viewGroup, int layoutRes, OnItemClickListener listener) {
        super(LayoutInflater.from(context).inflate(layoutRes, viewGroup, false));
        this.context = context;
        this.listener = listener;

        tvDate          = (TextView) itemView.findViewById(R.id.tvDate);
        tvMeasureLoc    = (TextView) itemView.findViewById(R.id.tvMeasureLoc);
        tvDust          = (TextView) itemView.findViewById(R.id.tvDust);
        tvMicroDust     = (TextView) itemView.findViewById(R.id.tvMicroDust);
        tvEnvRating     = (TextView) itemView.findViewById(R.id.tvEnvRating);
    }

    public void onBind(Dust dust, final int position) {
    }
}
