package com.imposter.partygame;

import android.os.Bundle;
import android.webkit.WebSettings;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fixWebView();
    }

    @Override
    public void onResume() {
        super.onResume();
        fixWebView();
    }

    // Android-Schriftgröße darf das Layout nicht verzerren: Text immer 100 %.
    private void fixWebView() {
        if (getBridge() == null || getBridge().getWebView() == null) return;
        WebSettings s = getBridge().getWebView().getSettings();
        s.setTextZoom(100);
        s.setSupportZoom(false);
        s.setBuiltInZoomControls(false);
        s.setDisplayZoomControls(false);
        s.setMediaPlaybackRequiresUserGesture(false);
    }
}
