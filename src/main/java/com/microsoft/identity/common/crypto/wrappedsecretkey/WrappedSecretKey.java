package com.microsoft.identity.common.crypto.wrappedsecretkey;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WrappedSecretKey.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKey;", "", "wrappedKeyData", "", "algorithm", "", "cipherTransformation", "([BLjava/lang/String;Ljava/lang/String;)V", "getAlgorithm", "()Ljava/lang/String;", "getCipherTransformation", "getWrappedKeyData", "()[B", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "serialize", "toString", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class WrappedSecretKey {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String algorithm;
    private final String cipherTransformation;
    private final byte[] wrappedKeyData;

    public static /* synthetic */ WrappedSecretKey copy$default(WrappedSecretKey wrappedSecretKey, byte[] bArr, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = wrappedSecretKey.wrappedKeyData;
        }
        if ((i & 2) != 0) {
            str = wrappedSecretKey.algorithm;
        }
        if ((i & 4) != 0) {
            str2 = wrappedSecretKey.cipherTransformation;
        }
        return wrappedSecretKey.copy(bArr, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final byte[] getWrappedKeyData() {
        return this.wrappedKeyData;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAlgorithm() {
        return this.algorithm;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCipherTransformation() {
        return this.cipherTransformation;
    }

    public final WrappedSecretKey copy(byte[] wrappedKeyData, String algorithm, String cipherTransformation) {
        Intrinsics.checkNotNullParameter(wrappedKeyData, "wrappedKeyData");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(cipherTransformation, "cipherTransformation");
        return new WrappedSecretKey(wrappedKeyData, algorithm, cipherTransformation);
    }

    public String toString() {
        return "WrappedSecretKey(wrappedKeyData=" + Arrays.toString(this.wrappedKeyData) + ", algorithm=" + this.algorithm + ", cipherTransformation=" + this.cipherTransformation + ')';
    }

    public WrappedSecretKey(byte[] wrappedKeyData, String algorithm, String cipherTransformation) {
        Intrinsics.checkNotNullParameter(wrappedKeyData, "wrappedKeyData");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(cipherTransformation, "cipherTransformation");
        this.wrappedKeyData = wrappedKeyData;
        this.algorithm = algorithm;
        this.cipherTransformation = cipherTransformation;
    }

    public final byte[] getWrappedKeyData() {
        return this.wrappedKeyData;
    }

    public final String getAlgorithm() {
        return this.algorithm;
    }

    public final String getCipherTransformation() {
        return this.cipherTransformation;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.microsoft.identity.common.crypto.wrappedsecretkey.WrappedSecretKey");
        WrappedSecretKey wrappedSecretKey = (WrappedSecretKey) other;
        return Arrays.equals(this.wrappedKeyData, wrappedSecretKey.wrappedKeyData) && Intrinsics.areEqual(this.algorithm, wrappedSecretKey.algorithm) && Intrinsics.areEqual(this.cipherTransformation, wrappedSecretKey.cipherTransformation);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.wrappedKeyData) * 31) + this.algorithm.hashCode()) * 31) + this.cipherTransformation.hashCode();
    }

    public final byte[] serialize() {
        return WrappedSecretKeySerializerManager.INSTANCE.getSerializer(CommonFlightsManager.INSTANCE.getFlightsProvider().getIntValue(CommonFlight.WRAPPED_SECRET_KEY_SERIALIZER_VERSION)).serialize(this);
    }

    /* JADX INFO: compiled from: WrappedSecretKey.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKey$Companion;", "", "()V", "deserialize", "Lcom/microsoft/identity/common/crypto/wrappedsecretkey/WrappedSecretKey;", "data", "", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WrappedSecretKey deserialize(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return WrappedSecretKeySerializerManager.INSTANCE.getSerializer(WrappedSecretKeySerializerManager.INSTANCE.identifySerializer(data)).deserialize(data);
        }
    }
}
