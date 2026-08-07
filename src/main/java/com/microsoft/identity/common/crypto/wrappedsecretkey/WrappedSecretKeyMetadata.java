package com.microsoft.identity.common.crypto.wrappedsecretkey;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WrappedSecretKeyMetadata.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKeyMetadata;", "", "algorithm", "", "cipherTransformation", "keyLength", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAlgorithm", "()Ljava/lang/String;", "getCipherTransformation", "getKeyLength", "()I", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WrappedSecretKeyMetadata {
    private final String algorithm;
    private final String cipherTransformation;
    private final int keyLength;

    public static /* synthetic */ WrappedSecretKeyMetadata copy$default(WrappedSecretKeyMetadata wrappedSecretKeyMetadata, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = wrappedSecretKeyMetadata.algorithm;
        }
        if ((i2 & 2) != 0) {
            str2 = wrappedSecretKeyMetadata.cipherTransformation;
        }
        if ((i2 & 4) != 0) {
            i = wrappedSecretKeyMetadata.keyLength;
        }
        return wrappedSecretKeyMetadata.copy(str, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAlgorithm() {
        return this.algorithm;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCipherTransformation() {
        return this.cipherTransformation;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getKeyLength() {
        return this.keyLength;
    }

    public final WrappedSecretKeyMetadata copy(String algorithm, String cipherTransformation, int keyLength) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(cipherTransformation, "cipherTransformation");
        return new WrappedSecretKeyMetadata(algorithm, cipherTransformation, keyLength);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WrappedSecretKeyMetadata)) {
            return false;
        }
        WrappedSecretKeyMetadata wrappedSecretKeyMetadata = (WrappedSecretKeyMetadata) other;
        return Intrinsics.areEqual(this.algorithm, wrappedSecretKeyMetadata.algorithm) && Intrinsics.areEqual(this.cipherTransformation, wrappedSecretKeyMetadata.cipherTransformation) && this.keyLength == wrappedSecretKeyMetadata.keyLength;
    }

    public int hashCode() {
        return (((this.algorithm.hashCode() * 31) + this.cipherTransformation.hashCode()) * 31) + Integer.hashCode(this.keyLength);
    }

    public String toString() {
        return "WrappedSecretKeyMetadata(algorithm=" + this.algorithm + ", cipherTransformation=" + this.cipherTransformation + ", keyLength=" + this.keyLength + ')';
    }

    public WrappedSecretKeyMetadata(String algorithm, String cipherTransformation, int i) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(cipherTransformation, "cipherTransformation");
        this.algorithm = algorithm;
        this.cipherTransformation = cipherTransformation;
        this.keyLength = i;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final String getCipherTransformation() {
        return this.cipherTransformation;
    }

    public final int getKeyLength() {
        return this.keyLength;
    }
}
