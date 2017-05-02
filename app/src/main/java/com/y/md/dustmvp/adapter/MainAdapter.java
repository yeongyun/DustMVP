package com.y.md.dustmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.y.md.dustmvp.adapter.contract.MainAdapterContract;
import com.y.md.dustmvp.adapter.holder.MainPagerViewHolder;
import com.y.md.dustmvp.adapter.holder.MainViewHolder;
import com.y.md.dustmvp.data.Dust;
import com.y.md.dustmvp.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prompt32 on 2017-04-26.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MainAdapterContract.Model, MainAdapterContract.View{

    private List<Dust> mItemList;
    private Context context;

    private final static int TYPE_NORMAL    = 101;
    private final static int TYPE_PAGER     = 102;

    private OnItemClickListener listener;

    public MainAdapter(Context context, OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return mItemList.get(position).getUltraMicroDust() % 3 == 0 ? TYPE_PAGER : TYPE_NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_NORMAL) {
            return new MainViewHolder(context, parent, listener);
        } else {
            return new MainPagerViewHolder(context, parent, listener);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == TYPE_PAGER) {
            MainPagerViewHolder mainPagerViewHolder = (MainPagerViewHolder) holder;
            mainPagerViewHolder.onBind(mItemList.get(position), position);
        } else {
            MainViewHolder mainViewHolder = (MainViewHolder) holder;
            mainViewHolder.onBind(mItemList.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return mItemList != null ? mItemList.size() : 0;
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public void addItems(List<Dust> items) {
        if(mItemList == null) {
            mItemList = new ArrayList<>();
        }

        int oldPosition = mItemList.size();
        this.mItemList.addAll(items);
        notifyItemInserted(oldPosition);
    }

    @Override
    public void clearItem() {
        if(mItemList != null) {
            mItemList.clear();
        }
    }
}
