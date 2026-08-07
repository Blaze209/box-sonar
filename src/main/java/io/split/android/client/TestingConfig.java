package io.split.android.client;

import io.split.android.android_client.BuildConfig;

/* JADX INFO: loaded from: classes4.dex */
public class TestingConfig {
    private int cdnBackoffTime = 60;
    private String mFlagsSpec = BuildConfig.FLAGS_SPEC;

    public int getCdnBackoffTime() {
        return this.cdnBackoffTime;
    }

    public void setCdnBackoffTime(int cdnBackoffTime) {
        this.cdnBackoffTime = cdnBackoffTime;
    }

    String getFlagsSpec() {
        return this.mFlagsSpec;
    }

    public void setFlagsSpec(String flagsSpec) {
        this.mFlagsSpec = flagsSpec;
    }
}
