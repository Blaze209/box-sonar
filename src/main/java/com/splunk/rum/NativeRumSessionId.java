package com.splunk.rum;

import android.webkit.JavascriptInterface;

/* JADX INFO: loaded from: classes3.dex */
class NativeRumSessionId {
    private final SplunkRum splunkRum;

    public NativeRumSessionId(SplunkRum splunkRum) {
        this.splunkRum = splunkRum;
    }

    @JavascriptInterface
    public String getNativeSessionId() {
        return this.splunkRum.getRumSessionId();
    }
}
