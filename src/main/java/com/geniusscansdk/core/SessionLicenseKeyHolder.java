package com.geniusscansdk.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SessionLicenseKeyHolder.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\nR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/geniusscansdk/core/SessionLicenseKeyHolder;", "", "<init>", "()V", "value", "", "storedLicenseKey", "getStoredLicenseKey", "()Ljava/lang/String;", "rememberLicenseKey", "", "licenseKey", "forgetLicenseKey", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionLicenseKeyHolder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SessionLicenseKeyHolder shared = new SessionLicenseKeyHolder();
    private volatile String storedLicenseKey;

    /* JADX INFO: compiled from: SessionLicenseKeyHolder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/core/SessionLicenseKeyHolder$Companion;", "", "<init>", "()V", "shared", "Lcom/geniusscansdk/core/SessionLicenseKeyHolder;", "getShared", "()Lcom/geniusscansdk/core/SessionLicenseKeyHolder;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SessionLicenseKeyHolder getShared() {
            return SessionLicenseKeyHolder.shared;
        }
    }

    public final String getStoredLicenseKey() {
        return this.storedLicenseKey;
    }

    public final void rememberLicenseKey(String licenseKey) {
        Intrinsics.checkNotNullParameter(licenseKey, "licenseKey");
        this.storedLicenseKey = licenseKey;
    }

    public final void forgetLicenseKey() {
        this.storedLicenseKey = null;
    }
}
