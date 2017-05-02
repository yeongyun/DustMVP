package com.y.md.dustmvp.adapter.holder;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.y.md.dustmvp.R;
import com.y.md.dustmvp.common.Util;
import com.y.md.dustmvp.data.Dust;
import com.y.md.dustmvp.image.GlideHelper;
import com.y.md.dustmvp.listener.OnItemClickListener;

/**
 * Created by prompt32 on 2017-04-26.
 */

public class MainPagerViewHolder extends BaseViewHolder {
    private ViewPager viewPager;

    private Util util = new Util();
    private GlideHelper glideHelper;

    public MainPagerViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener listener) {
        super(context, viewGroup, R.layout.row_dust_pager, listener);
        glideHelper = new GlideHelper(context);
        viewPager = (ViewPager) itemView.findViewById(R.id.viewPager);
    }

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

        viewPagerAdapter imageAdapter = new viewPagerAdapter(dust);
        viewPager.setAdapter(imageAdapter);
        viewPager.setVisibility(View.VISIBLE);
        viewPager.setPageMargin(-50);
    }

    private class viewPagerAdapter extends PagerAdapter {

        private LayoutInflater mInflater;
        private Dust dust;

        viewPagerAdapter(Dust dust) {
            mInflater = LayoutInflater.from(context);
            this.dust = dust;
        }
        @Override
        public int getCount() {
            return dust.getImages() != null ? dust.getImages().size() : 0;
        }

        @Override
        public float getPageWidth(int position) {
            return 1.0f;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = mInflater.inflate(R.layout.row_pager, container, false);
            ImageView ivTest = (ImageView) v.findViewById(R.id.ivTest);

            glideHelper.setImage(dust.getImages().get(position), ivTest);

            container.addView(v);

            return v;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
