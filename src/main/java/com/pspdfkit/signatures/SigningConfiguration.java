package com.pspdfkit.signatures;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.internal.lv;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/pspdfkit/signatures/SigningConfiguration;", "", "privateKey", "Ljava/security/PrivateKey;", "certificates", "", "Ljava/security/cert/X509Certificate;", "metadata", "Lcom/pspdfkit/signatures/DigitalSignatureMetadata;", "<init>", "(Ljava/security/PrivateKey;Ljava/util/List;Lcom/pspdfkit/signatures/DigitalSignatureMetadata;)V", "getPrivateKey", "()Ljava/security/PrivateKey;", "getCertificates", "()Ljava/util/List;", "getMetadata", "()Lcom/pspdfkit/signatures/DigitalSignatureMetadata;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SigningConfiguration {
    private final List<X509Certificate> certificates;
    private final DigitalSignatureMetadata metadata;
    private final PrivateKey privateKey;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/pspdfkit/signatures/SigningConfiguration$Companion;", "", "<init>", "()V", "fromSignerOptions", "Lcom/pspdfkit/signatures/SigningConfiguration;", "signerOptions", "Lcom/pspdfkit/signatures/SignerOptions;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SigningConfiguration fromSignerOptions(SignerOptions signerOptions) {
            signerOptions.getClass();
            PrivateKey privateKey = signerOptions.getPrivateKey();
            if (privateKey == null) {
                KeyStore.PrivateKeyEntry privateKeyEntry = signerOptions.getPrivateKeyEntry();
                privateKey = privateKeyEntry != null ? privateKeyEntry.getPrivateKey() : null;
                if (privateKey == null) {
                    throw new IllegalArgumentException("SigningConfiguration: Private key must not be null. Cannot sign without the private key.");
                }
            }
            return new SigningConfiguration(privateKey, signerOptions.getCertificates(), signerOptions.getMetadata());
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SigningConfiguration(PrivateKey privateKey, List<? extends X509Certificate> list, DigitalSignatureMetadata digitalSignatureMetadata) {
        privateKey.getClass();
        list.getClass();
        this.privateKey = privateKey;
        this.certificates = list;
        this.metadata = digitalSignatureMetadata;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SigningConfiguration copy$default(SigningConfiguration signingConfiguration, PrivateKey privateKey, List list, DigitalSignatureMetadata digitalSignatureMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            privateKey = signingConfiguration.privateKey;
        }
        if ((i & 2) != 0) {
            list = signingConfiguration.certificates;
        }
        if ((i & 4) != 0) {
            digitalSignatureMetadata = signingConfiguration.metadata;
        }
        return signingConfiguration.copy(privateKey, list, digitalSignatureMetadata);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public final List<X509Certificate> component2() {
        return this.certificates;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DigitalSignatureMetadata getMetadata() {
        return this.metadata;
    }

    public final SigningConfiguration copy(PrivateKey privateKey, List<? extends X509Certificate> certificates, DigitalSignatureMetadata metadata) {
        privateKey.getClass();
        certificates.getClass();
        return new SigningConfiguration(privateKey, certificates, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SigningConfiguration)) {
            return false;
        }
        SigningConfiguration signingConfiguration = (SigningConfiguration) other;
        return Intrinsics.areEqual(this.privateKey, signingConfiguration.privateKey) && Intrinsics.areEqual(this.certificates, signingConfiguration.certificates) && Intrinsics.areEqual(this.metadata, signingConfiguration.metadata);
    }

    public final List<X509Certificate> getCertificates() {
        return this.certificates;
    }

    public final DigitalSignatureMetadata getMetadata() {
        return this.metadata;
    }

    public final PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public int hashCode() {
        int iA = lv.a(this.certificates, this.privateKey.hashCode() * 31, 31);
        DigitalSignatureMetadata digitalSignatureMetadata = this.metadata;
        return iA + (digitalSignatureMetadata == null ? 0 : digitalSignatureMetadata.hashCode());
    }

    public String toString() {
        return "SigningConfiguration(privateKey=" + this.privateKey + ", certificates=" + this.certificates + ", metadata=" + this.metadata + ")";
    }

    public /* synthetic */ SigningConfiguration(PrivateKey privateKey, List list, DigitalSignatureMetadata digitalSignatureMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(privateKey, list, (i & 4) != 0 ? null : digitalSignatureMetadata);
    }
}
