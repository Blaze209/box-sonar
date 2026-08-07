package com.margelo.nitro.boxcontext;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PendingItemError.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/margelo/nitro/boxcontext/PendingItemError;", "", "code", "", "message", "isApiError", "", "isRetryPossible", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCode", "()Ljava/lang/String;", "getMessage", "()Z", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PendingItemError {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String code;
    private final boolean isApiError;
    private final boolean isRetryPossible;
    private final String message;

    public static /* synthetic */ PendingItemError copy$default(PendingItemError pendingItemError, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pendingItemError.code;
        }
        if ((i & 2) != 0) {
            str2 = pendingItemError.message;
        }
        if ((i & 4) != 0) {
            z = pendingItemError.isApiError;
        }
        if ((i & 8) != 0) {
            z2 = pendingItemError.isRetryPossible;
        }
        return pendingItemError.copy(str, str2, z, z2);
    }

    @JvmStatic
    private static final PendingItemError fromCpp(String str, String str2, boolean z, boolean z2) {
        return INSTANCE.fromCpp(str, str2, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsApiError() {
        return this.isApiError;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsRetryPossible() {
        return this.isRetryPossible;
    }

    public final PendingItemError copy(String code, String message, boolean isApiError, boolean isRetryPossible) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new PendingItemError(code, message, isApiError, isRetryPossible);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingItemError)) {
            return false;
        }
        PendingItemError pendingItemError = (PendingItemError) other;
        return Intrinsics.areEqual(this.code, pendingItemError.code) && Intrinsics.areEqual(this.message, pendingItemError.message) && this.isApiError == pendingItemError.isApiError && this.isRetryPossible == pendingItemError.isRetryPossible;
    }

    public int hashCode() {
        String str = this.code;
        return ((((((str == null ? 0 : str.hashCode()) * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.isApiError)) * 31) + Boolean.hashCode(this.isRetryPossible);
    }

    public String toString() {
        return "PendingItemError(code=" + this.code + ", message=" + this.message + ", isApiError=" + this.isApiError + ", isRetryPossible=" + this.isRetryPossible + ")";
    }

    public PendingItemError(String str, String message, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = str;
        this.message = message;
        this.isApiError = z;
        this.isRetryPossible = z2;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean isApiError() {
        return this.isApiError;
    }

    public final boolean isRetryPossible() {
        return this.isRetryPossible;
    }

    /* JADX INFO: compiled from: PendingItemError.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0003¨\u0006\f"}, d2 = {"Lcom/margelo/nitro/boxcontext/PendingItemError$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/boxcontext/PendingItemError;", "code", "", "message", "isApiError", "", "isRetryPossible", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final PendingItemError fromCpp(String code, String message, boolean isApiError, boolean isRetryPossible) {
            return new PendingItemError(code, message, isApiError, isRetryPossible);
        }
    }
}
