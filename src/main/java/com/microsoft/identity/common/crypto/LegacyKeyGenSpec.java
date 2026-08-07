package com.microsoft.identity.common.crypto;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: KeyGenSpec.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÂ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\b\u0010$\u001a\u00020\u0010H\u0002J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\b\u0010&\u001a\u00020\u0005H\u0016R\u0014\u0010\t\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/microsoft/identity/common/crypto/LegacyKeyGenSpec;", "Lcom/microsoft/identity/common/crypto/IKeyGenSpec;", "context", "Landroid/content/Context;", "keyAlias", "", "keySize", "", "description", "algorithm", "encryptionPaddings", "", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAlgorithm", "()Ljava/lang/String;", "algorithmParameterSpec", "Ljava/security/spec/AlgorithmParameterSpec;", "getAlgorithmParameterSpec", "()Ljava/security/spec/AlgorithmParameterSpec;", "getDescription", "getEncryptionPaddings", "()Ljava/util/List;", "getKeyAlias", "getKeySize", "()I", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "getLegacyKeyGenParamSpec", "hashCode", "toString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LegacyKeyGenSpec implements IKeyGenSpec {
    private final String algorithm;
    private final AlgorithmParameterSpec algorithmParameterSpec;
    private final Context context;
    private final String description;
    private final List<String> encryptionPaddings;
    private final String keyAlias;
    private final int keySize;

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LegacyKeyGenSpec copy$default(LegacyKeyGenSpec legacyKeyGenSpec, Context context, String str, int i, String str2, String str3, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            context = legacyKeyGenSpec.context;
        }
        if ((i2 & 2) != 0) {
            str = legacyKeyGenSpec.getKeyAlias();
        }
        if ((i2 & 4) != 0) {
            i = legacyKeyGenSpec.getKeySize();
        }
        if ((i2 & 8) != 0) {
            str2 = legacyKeyGenSpec.getDescription();
        }
        if ((i2 & 16) != 0) {
            str3 = legacyKeyGenSpec.getAlgorithm();
        }
        if ((i2 & 32) != 0) {
            list = legacyKeyGenSpec.mo13841getEncryptionPaddings();
        }
        String str4 = str3;
        List list2 = list;
        return legacyKeyGenSpec.copy(context, str, i, str2, str4, list2);
    }

    public final String component2() {
        return getKeyAlias();
    }

    public final int component3() {
        return getKeySize();
    }

    public final String component4() {
        return getDescription();
    }

    public final String component5() {
        return getAlgorithm();
    }

    public final List<String> component6() {
        return mo13841getEncryptionPaddings();
    }

    public final LegacyKeyGenSpec copy(Context context, String keyAlias, int keySize, String description, String algorithm, List<String> encryptionPaddings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(encryptionPaddings, "encryptionPaddings");
        return new LegacyKeyGenSpec(context, keyAlias, keySize, description, algorithm, encryptionPaddings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyKeyGenSpec)) {
            return false;
        }
        LegacyKeyGenSpec legacyKeyGenSpec = (LegacyKeyGenSpec) other;
        return Intrinsics.areEqual(this.context, legacyKeyGenSpec.context) && Intrinsics.areEqual(getKeyAlias(), legacyKeyGenSpec.getKeyAlias()) && getKeySize() == legacyKeyGenSpec.getKeySize() && Intrinsics.areEqual(getDescription(), legacyKeyGenSpec.getDescription()) && Intrinsics.areEqual(getAlgorithm(), legacyKeyGenSpec.getAlgorithm()) && Intrinsics.areEqual(mo13841getEncryptionPaddings(), legacyKeyGenSpec.mo13841getEncryptionPaddings());
    }

    public int hashCode() {
        return (((((((((this.context.hashCode() * 31) + getKeyAlias().hashCode()) * 31) + Integer.hashCode(getKeySize())) * 31) + getDescription().hashCode()) * 31) + getAlgorithm().hashCode()) * 31) + mo13841getEncryptionPaddings().hashCode();
    }

    public LegacyKeyGenSpec(Context context, String keyAlias, int i, String description, String algorithm, List<String> encryptionPaddings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(keyAlias, "keyAlias");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(encryptionPaddings, "encryptionPaddings");
        this.context = context;
        this.keyAlias = keyAlias;
        this.keySize = i;
        this.description = description;
        this.algorithm = algorithm;
        this.encryptionPaddings = encryptionPaddings;
        this.algorithmParameterSpec = getLegacyKeyGenParamSpec();
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
    /* JADX INFO: renamed from: getEncryptionPaddings */
    public List<String> mo13841getEncryptionPaddings() {
        return this.encryptionPaddings;
    }

    @Override // com.microsoft.identity.common.crypto.IKeyGenSpec
    public AlgorithmParameterSpec getAlgorithmParameterSpec() {
        return this.algorithmParameterSpec;
    }

    public String toString() {
        return print();
    }

    private final AlgorithmParameterSpec getLegacyKeyGenParamSpec() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.ROOT, "CN=%s, OU=%s", Arrays.copyOf(new Object[]{getKeyAlias(), this.context.getPackageName()}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(1, 100);
        KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(this.context).setAlias(getKeyAlias()).setSubject(new X500Principal(str)).setSerialNumber(BigInteger.ONE).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
        Intrinsics.checkNotNullExpressionValue(keyPairGeneratorSpecBuild, "Builder(context)\n       …ime)\n            .build()");
        return keyPairGeneratorSpecBuild;
    }
}
