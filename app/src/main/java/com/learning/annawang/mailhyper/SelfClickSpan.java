package com.learning.annawang.mailhyper;

import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

/**
 * Created by Anna.Wang on 2017/7/6.
 * version: 1.0
 */

public class SelfClickSpan extends ClickableSpan {

    private static final String TAG = SelfClickSpan.class.getName();

    String text;

    public SelfClickSpan(String text) {
        super();
        this.text = text;
    }

    @Override
    public void onClick(View widget) {
//                        getChildFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.frame_fragment_container, new WebViewFragment(), WebViewFragment.class.getSimpleName())
//                        .commit();
        Log.d(TAG, "self click span ...");
        Log.d("#########", "self click span ...");
    }
}
