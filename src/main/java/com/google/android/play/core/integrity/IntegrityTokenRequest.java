package com.google.android.play.core.integrity;

import android.net.Network;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public abstract class IntegrityTokenRequest {

    /* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
    public static abstract class Builder {
        public abstract IntegrityTokenRequest build();

        public abstract Builder setCloudProjectNumber(long j);

        public abstract Builder setNonce(String str);
    }

    public static Builder builder() {
        return new c();
    }

    public abstract Network a();

    public abstract Long cloudProjectNumber();

    public abstract String nonce();
}
