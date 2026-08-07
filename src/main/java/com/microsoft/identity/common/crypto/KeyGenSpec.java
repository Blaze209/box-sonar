package com.microsoft.identity.common.crypto;

import android.security.keystore.KeyGenParameterSpec;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyGenSpec.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÂ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÂ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J[\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060&H\u0002¢\u0006\u0002\u0010'J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060&H\u0002¢\u0006\u0002\u0010'J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\b\u0010)\u001a\u00020\u0006H\u0016R\u0014\u0010\n\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/microsoft/identity/common/crypto/KeyGenSpec;", "Lcom/microsoft/identity/common/crypto/IKeyGenSpec;", "purposes", "", "digestAlgorithms", "", "", "keyAlias", "keySize", "description", "algorithm", "encryptionPaddings", "(ILjava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAlgorithm", "()Ljava/lang/String;", "algorithmParameterSpec", "Ljava/security/spec/AlgorithmParameterSpec;", "getAlgorithmParameterSpec", "()Ljava/security/spec/AlgorithmParameterSpec;", "getDescription", "getEncryptionPaddings", "()Ljava/util/List;", "getKeyAlias", "getKeySize", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "getDigestAlgorithms", "", "()[Ljava/lang/String;", "hashCode", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class KeyGenSpec implements IKeyGenSpec {
    private final String algorithm;
    private final AlgorithmParameterSpec algorithmParameterSpec;
    private final String description;
    private final List<String> digestAlgorithms;
    private final List<String> encryptionPaddings;
    private final String keyAlias;
    private final int keySize;
    private final int purposes;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final int getPurposes() {
        return this.purposes;
    }

    private final List<String> component2() {
        return this.digestAlgorithms;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KeyGenSpec copy$default(KeyGenSpec keyGenSpec, int i, List list, String str, int i2, String str2, String str3, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = keyGenSpec.purposes;
        }
        if ((i3 & 2) != 0) {
            list = keyGenSpec.digestAlgorithms;
        }
        if ((i3 & 4) != 0) {
            str = keyGenSpec.getKeyAlias();
        }
        if ((i3 & 8) != 0) {
            i2 = keyGenSpec.getKeySize();
        }
        if ((i3 & 16) != 0) {
            str2 = keyGenSpec.getDescription();
        }
        if ((i3 & 32) != 0) {
            str3 = keyGenSpec.getAlgorithm();
        }
        if ((i3 & 64) != 0) {
            list2 = keyGenSpec.mo13841getEncryptionPaddings();
        }
        String str4 = str3;
        List list3 = list2;
        String str5 = str2;
        String str6 = str;
        return keyGenSpec.copy(i, list, str6, i2, str5, str4, list3);
    }

    public final String component3() {
        return getKeyAlias();
    }

    public final int component4() {
        return getKeySize();
    }

    public final String component5() {
        return getDescription();
    }

    public final String component6() {
        return getAlgorithm();
    }

    public final List<String> component7() {
        return mo13841getEncryptionPaddings();
    }

    public final KeyGenSpec copy(int purposes, List<String> digestAlgorithms, String keyAlias, int keySize, String description, String algorithm, List<String> encryptionPaddings) {
        Intrinsics.checkNotNullParameter(digestAlgorithms, "digestAlgorithms");
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(encryptionPaddings, "encryptionPaddings");
        return new KeyGenSpec(purposes, digestAlgorithms, keyAlias, keySize, description, algorithm, encryptionPaddings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyGenSpec)) {
            return false;
        }
        KeyGenSpec keyGenSpec = (KeyGenSpec) other;
        return this.purposes == keyGenSpec.purposes && Intrinsics.areEqual(this.digestAlgorithms, keyGenSpec.digestAlgorithms) && Intrinsics.areEqual(getKeyAlias(), keyGenSpec.getKeyAlias()) && getKeySize() == keyGenSpec.getKeySize() && Intrinsics.areEqual(getDescription(), keyGenSpec.getDescription()) && Intrinsics.areEqual(getAlgorithm(), keyGenSpec.getAlgorithm()) && Intrinsics.areEqual(mo13841getEncryptionPaddings(), keyGenSpec.mo13841getEncryptionPaddings());
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.purposes) * 31) + this.digestAlgorithms.hashCode()) * 31) + getKeyAlias().hashCode()) * 31) + Integer.hashCode(getKeySize())) * 31) + getDescription().hashCode()) * 31) + getAlgorithm().hashCode()) * 31) + mo13841getEncryptionPaddings().hashCode();
    }

    public KeyGenSpec(int i, List<String> digestAlgorithms, String keyAlias, int i2, String description, String algorithm, List<String> encryptionPaddings) {
        Intrinsics.checkNotNullParameter(digestAlgorithms, "digestAlgorithms");
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(encryptionPaddings, "encryptionPaddings");
        this.purposes = i;
        this.digestAlgorithms = digestAlgorithms;
        this.keyAlias = keyAlias;
        this.keySize = i2;
        this.description = description;
        this.algorithm = algorithm;
        this.encryptionPaddings = encryptionPaddings;
        KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(getKeyAlias(), i).setKeySize(getKeySize());
        String[] digestAlgorithms2 = getDigestAlgorithms();
        KeyGenParameterSpec.Builder digests = keySize.setDigests((String[]) Arrays.copyOf(digestAlgorithms2, digestAlgorithms2.length));
        String[] encryptionPaddings2 = getEncryptionPaddings();
        KeyGenParameterSpec keyGenParameterSpecBuild = digests.setEncryptionPaddings((String[]) Arrays.copyOf(encryptionPaddings2, encryptionPaddings2.length)).build();
        Intrinsics.checkNotNullExpressionValue(keyGenParameterSpecBuild, "Builder(keyAlias, purpos…s())\n            .build()");
        this.algorithmParameterSpec = keyGenParameterSpecBuild;
    }

    @Override // com.microsoft.identity.common.crypto.IKeyGenSpec
    public String print() {
        return IKeyGenSpec.DefaultImpls.print(this);
    }

    @Override // com.microsoft.identity.common.crypto.IKeyGenSpec
    public String getKeyAlias() {
        return this.keyAlias;
    }

    @Override // com.microsoft.identity.common.crypto.IKeyGenSpec
    public int getKeySize() {
        return this.keySize;
    }

    @Override // com.microsoft.identity.common.crypto.IKeyGenSpec
    public String getDescription() {
        return this.description;
    }

    @Override // com.microsoft.identity.common.crypto.IKeyGenSpec
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // com.microsoft.identity.common.crypto.IKeyGenSpec
    /* JADX INFO: renamed from: getEncryptionPaddings, reason: collision with other method in class */
    public List<String> mo13841getEncryptionPaddings() {
        return this.encryptionPaddings;
    }

    public String toString() {
        return print();
    }

    private final String[] getDigestAlgorithms() {
        return (String[]) this.digestAlgorithms.toArray(new String[0]);
    }

    private final String[] getEncryptionPaddings() {
        return (String[]) mo13841getEncryptionPaddings().toArray(new String[0]);
    }

    @Override // com.microsoft.identity.common.crypto.IKeyGenSpec
    public AlgorithmParameterSpec getAlgorithmParameterSpec() {
        return this.algorithmParameterSpec;
    }
}
