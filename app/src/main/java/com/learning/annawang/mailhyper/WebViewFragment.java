package com.learning.annawang.mailhyper;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Anna.Wang on 2017/7/6.
 * version: 1.0
 */

public class WebViewFragment extends Fragment {
    private WebView mGuideView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.guid_frag, container, false);

        mGuideView = (WebView) view.findViewById(R.id.view_guide);
        mGuideView.loadUrl("http://172.20.245.30:8080");
        mGuideView.getSettings().setJavaScriptEnabled(true);
        mGuideView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mGuideView.getSettings().setSupportZoom(true);
        mGuideView.getSettings().setBuiltInZoomControls(true);
        mGuideView.getSettings().setDisplayZoomControls(true);
        mGuideView.getSettings().setDomStorageEnabled(true);
        String appCachePath = getActivity().getApplicationContext().getCacheDir().getAbsolutePath();
        mGuideView.getSettings().setAppCachePath(appCachePath);
        mGuideView.getSettings().setAllowFileAccess(true);
        mGuideView.getSettings().setAppCacheEnabled(true);
        mGuideView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && mGuideView.canGoBack() && event.getAction() == KeyEvent.ACTION_UP) {
                    mGuideView.goBack();
                    return true;
                }
                return false;
            }
        });
        return view;
    }
}
