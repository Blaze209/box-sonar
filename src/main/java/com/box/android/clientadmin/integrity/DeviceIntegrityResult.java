package com.box.android.clientadmin.integrity;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceIntegrityVerifier.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/clientadmin/integrity/DeviceIntegrityResult;", "", "<init>", "()V", "IntegrityToken", "IntegrityTokenError", "Lcom/box/android/clientadmin/integrity/DeviceIntegrityResult$IntegrityToken;", "Lcom/box/android/clientadmin/integrity/DeviceIntegrityResult$IntegrityTokenError;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class DeviceIntegrityResult {
    public static final int $stable = 0;

    public /* synthetic */ DeviceIntegrityResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: DeviceIntegrityVerifier.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/clientadmin/integrity/DeviceIntegrityResult$IntegrityToken;", "Lcom/box/android/clientadmin/integrity/DeviceIntegrityResult;", "token", "", "<init>", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IntegrityToken extends DeviceIntegrityResult {
        public static final int $stable = 0;
        private final String token;

        public static /* synthetic */ IntegrityToken copy$default(IntegrityToken integrityToken, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = integrityToken.token;
            }
            return integrityToken.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        public final IntegrityToken copy(String token) {
            return new IntegrityToken(token);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof IntegrityToken) && Intrinsics.areEqual(this.token, ((IntegrityToken) other).token);
        }

        public int hashCode() {
            String str = this.token;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "IntegrityToken(token=" + this.token + ")";
        }

        public IntegrityToken(String str) {
            super(null);
            this.token = str;
        }

        public final String getToken() {
            return this.token;
        }
    }

    private DeviceIntegrityResult() {
    }

    /* JADX INFO: compiled from: DeviceIntegrityVerifier.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/clientadmin/integrity/DeviceIntegrityResult$IntegrityTokenError;", "Lcom/box/android/clientadmin/integrity/DeviceIntegrityResult;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class IntegrityTokenError extends DeviceIntegrityResult {
        public static final int $stable = 0;
        private final String message;

        public static /* synthetic */ IntegrityTokenError copy$default(IntegrityTokenError integrityTokenError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = integrityTokenError.message;
            }
            return integrityTokenError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final IntegrityTokenError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new IntegrityTokenError(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof IntegrityTokenError) && Intrinsics.areEqual(this.message, ((IntegrityTokenError) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "IntegrityTokenError(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IntegrityTokenError(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
