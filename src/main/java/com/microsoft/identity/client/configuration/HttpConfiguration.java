package com.microsoft.identity.client.configuration;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes14.dex */
public class HttpConfiguration {

    @SerializedName("connect_timeout")
    private int mConnectTimeout;

    @SerializedName("read_timeout")
    private int mReadTimeout;

    public int getReadTimeout() {
        return this.mReadTimeout;
    }

    public void setReadTimeout(int i) {
        this.mReadTimeout = i;
    }

    public int getConnectTimeout() {
        return this.mConnectTimeout;
    }

    public void setConnectTimeout(int i) {
        this.mConnectTimeout = i;
    }
}
