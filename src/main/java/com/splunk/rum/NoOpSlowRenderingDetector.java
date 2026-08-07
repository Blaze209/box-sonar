package com.splunk.rum;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
enum NoOpSlowRenderingDetector implements SlowRenderingDetector {
    INSTANCE;

    @Override // com.splunk.rum.SlowRenderingDetector
    public void start(Application application) {
    }
}
