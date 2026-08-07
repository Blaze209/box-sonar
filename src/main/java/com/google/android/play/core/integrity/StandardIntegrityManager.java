package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public interface StandardIntegrityManager {

    /* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
    public static abstract class PrepareIntegrityTokenRequest {

        /* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
        public static abstract class Builder {
            public abstract PrepareIntegrityTokenRequest build();

            public abstract Builder setCloudProjectNumber(long j);
        }

        public static Builder builder() {
            return new f();
        }

        public abstract long a();
    }

    /* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
    public static abstract class StandardIntegrityToken {
        public abstract String token();
    }

    /* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
    public interface StandardIntegrityTokenProvider {
        Task<StandardIntegrityToken> request(StandardIntegrityTokenRequest standardIntegrityTokenRequest);
    }

    /* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
    public static abstract class StandardIntegrityTokenRequest {

        /* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
        public static abstract class Builder {
            public abstract StandardIntegrityTokenRequest build();

            public abstract Builder setRequestHash(String str);
        }

        public static Builder builder() {
            return new i();
        }

        public abstract String a();
    }

    Task<StandardIntegrityTokenProvider> prepareIntegrityToken(PrepareIntegrityTokenRequest prepareIntegrityTokenRequest);
}
