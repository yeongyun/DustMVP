package com.y.md.dustmvp.image;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by prompt32 on 2017-04-28.
 */

public class GlideHelper extends ContextWrapper{

    public GlideHelper(Context context) {
        super(context);
    }

    public void setImage(String url, ImageView view) {
        Glide.with(getApplicationContext()).load(url).into(view);
    }
}
