package io.split.android.client.service.sseclient;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
class SseAuthToken {

    @SerializedName("x-ably-capability")
    private final String channelList;

    @SerializedName("exp")
    private final long expirationAt;

    @SerializedName("iat")
    private final long issuedAt;

    public SseAuthToken(String channelList, long issuedAt, long expirationAt) {
        this.channelList = channelList;
        this.issuedAt = issuedAt;
        this.expirationAt = expirationAt;
    }

    public String getChannelList() {
        return this.channelList;
    }

    public long getIssuedAt() {
        return this.issuedAt;
    }

    public long getExpirationAt() {
        return this.expirationAt;
    }
}
