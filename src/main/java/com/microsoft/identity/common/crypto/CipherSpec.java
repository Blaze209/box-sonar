package com.microsoft.identity.common.crypto;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.observability.DiagnosisParams;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CipherSpec.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/microsoft/identity/common/crypto/CipherSpec;", "", "algorithmParameterSpec", "Ljava/security/spec/AlgorithmParameterSpec;", "algorithm", "", DiagnosisParams.DIAGNOSIS_MODE, ViewProps.PADDING, "(Ljava/security/spec/AlgorithmParameterSpec;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlgorithmParameterSpec", "()Ljava/security/spec/AlgorithmParameterSpec;", "getPadding", "()Ljava/lang/String;", "transformation", "getTransformation", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CipherSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MODE_ECB = "ECB";
    private static final String MODE_NONE = "NONE";
    private static final String OAEP_PADDING_WITH_256MGF1 = "OAEPwithSHA-256andMGF1Padding";
    private static final OAEPParameterSpec OAEP_SPECS;
    private static final String PKCS1_PADDING = "PKCS1Padding";
    private static final String RSA_ALGORITHM = "RSA";
    private static final CipherSpec oaepCipherSpec;
    private static final CipherSpec pkcs1CipherSpec;
    private final String algorithm;
    private final AlgorithmParameterSpec algorithmParameterSpec;
    private final String mode;
    private final String padding;
    private final String transformation;

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getAlgorithm() {
        return this.algorithm;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final String getMode() {
        return this.mode;
    }

    public static /* synthetic */ CipherSpec copy$default(CipherSpec cipherSpec, AlgorithmParameterSpec algorithmParameterSpec, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            algorithmParameterSpec = cipherSpec.algorithmParameterSpec;
        }
        if ((i & 2) != 0) {
            str = cipherSpec.algorithm;
        }
        if ((i & 4) != 0) {
            str2 = cipherSpec.mode;
        }
        if ((i & 8) != 0) {
            str3 = cipherSpec.padding;
        }
        return cipherSpec.copy(algorithmParameterSpec, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final AlgorithmParameterSpec getAlgorithmParameterSpec() {
        return this.algorithmParameterSpec;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPadding() {
        return this.padding;
    }

    public final CipherSpec copy(AlgorithmParameterSpec algorithmParameterSpec, String algorithm, String mode, String padding) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(padding, "padding");
        return new CipherSpec(algorithmParameterSpec, algorithm, mode, padding);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CipherSpec)) {
            return false;
        }
        CipherSpec cipherSpec = (CipherSpec) other;
        return Intrinsics.areEqual(this.algorithmParameterSpec, cipherSpec.algorithmParameterSpec) && Intrinsics.areEqual(this.algorithm, cipherSpec.algorithm) && Intrinsics.areEqual(this.mode, cipherSpec.mode) && Intrinsics.areEqual(this.padding, cipherSpec.padding);
    }

    public int hashCode() {
        AlgorithmParameterSpec algorithmParameterSpec = this.algorithmParameterSpec;
        return ((((((algorithmParameterSpec == null ? 0 : algorithmParameterSpec.hashCode()) * 31) + this.algorithm.hashCode()) * 31) + this.mode.hashCode()) * 31) + this.padding.hashCode();
    }

    public CipherSpec(AlgorithmParameterSpec algorithmParameterSpec, String algorithm, String mode, String padding) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(padding, "padding");
        this.algorithmParameterSpec = algorithmParameterSpec;
        this.algorithm = algorithm;
        this.mode = mode;
        this.padding = padding;
        this.transformation = algorithm + '/' + mode + '/' + padding;
    }

    public final AlgorithmParameterSpec getAlgorithmParameterSpec() {
        return this.algorithmParameterSpec;
    }

    public final String getPadding() {
        return this.padding;
    }

    public final String getTransformation() {
        return this.transformation;
    }

    public String toString() {
        return "CipherSpec(transformation='" + this.transformation + "')";
    }

    /* JADX INFO: compiled from: CipherSpec.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/microsoft/identity/common/crypto/CipherSpec$Companion;", "", "()V", "MODE_ECB", "", "MODE_NONE", "OAEP_PADDING_WITH_256MGF1", "OAEP_SPECS", "Ljavax/crypto/spec/OAEPParameterSpec;", "PKCS1_PADDING", "RSA_ALGORITHM", "oaepCipherSpec", "Lcom/microsoft/identity/common/crypto/CipherSpec;", "getOaepCipherSpec", "()Lcom/microsoft/identity/common/crypto/CipherSpec;", "pkcs1CipherSpec", "getPkcs1CipherSpec", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CipherSpec getPkcs1CipherSpec() {
            return CipherSpec.pkcs1CipherSpec;
        }

        public final CipherSpec getOaepCipherSpec() {
            return CipherSpec.oaepCipherSpec;
        }
    }

    static {
        OAEPParameterSpec oAEPParameterSpec = new OAEPParameterSpec("SHA-256", IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT);
        OAEP_SPECS = oAEPParameterSpec;
        pkcs1CipherSpec = new CipherSpec(null, "RSA", MODE_ECB, PKCS1_PADDING);
        oaepCipherSpec = new CipherSpec(oAEPParameterSpec, "RSA", MODE_NONE, OAEP_PADDING_WITH_256MGF1);
    }
}
