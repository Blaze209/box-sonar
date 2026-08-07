package com.box.android.data.datasource.errors;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RemoteError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/datasource/errors/ObservabilityRemoteError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "<init>", "()V", "SecurityError", "JWTCreationError", "Lcom/box/android/data/datasource/errors/ObservabilityRemoteError$JWTCreationError;", "Lcom/box/android/data/datasource/errors/ObservabilityRemoteError$SecurityError;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ObservabilityRemoteError extends RemoteError {
    public /* synthetic */ ObservabilityRemoteError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/ObservabilityRemoteError$SecurityError;", "Lcom/box/android/data/datasource/errors/ObservabilityRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SecurityError extends ObservabilityRemoteError {
        private final String message;

        public static /* synthetic */ SecurityError copy$default(SecurityError securityError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = securityError.message;
            }
            return securityError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final SecurityError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new SecurityError(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SecurityError) && Intrinsics.areEqual(this.message, ((SecurityError) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "SecurityError(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SecurityError(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }

    private ObservabilityRemoteError() {
        super(-1, null, 2, null);
    }

    /* JADX INFO: compiled from: RemoteError.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/errors/ObservabilityRemoteError$JWTCreationError;", "Lcom/box/android/data/datasource/errors/ObservabilityRemoteError;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class JWTCreationError extends ObservabilityRemoteError {
        private final String message;

        public static /* synthetic */ JWTCreationError copy$default(JWTCreationError jWTCreationError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jWTCreationError.message;
            }
            return jWTCreationError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final JWTCreationError copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new JWTCreationError(message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof JWTCreationError) && Intrinsics.areEqual(this.message, ((JWTCreationError) other).message);
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "JWTCreationError(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JWTCreationError(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        @Override // com.box.android.data.datasource.errors.RemoteError
        public String getMessage() {
            return this.message;
        }
    }
}
