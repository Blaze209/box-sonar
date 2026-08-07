package io.split.android.client.service.sseclient;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SseJwtToken {
    private final List<String> channels;
    private final long expirationTime;
    private final long issuedAtTime;
    private final String rawJwt;

    public SseJwtToken(long issuedAtTime, long expirationTime, List<String> channels, String rawJwt) {
        this.issuedAtTime = issuedAtTime;
        this.expirationTime = expirationTime;
        this.channels = channels;
        this.rawJwt = rawJwt;
    }

    public long getExpirationTime() {
        return this.expirationTime;
    }

    public long getIssuedAtTime() {
        return this.issuedAtTime;
    }

    public List<String> getChannels() {
        return this.channels;
    }

    public String getRawJwt() {
        return this.rawJwt;
    }
}
