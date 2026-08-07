package com.microsoft.identity.common.crypto;

import com.pspdfkit.analytics.Analytics;
import java.security.spec.AlgorithmParameterSpec;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: KeyGenSpec.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/microsoft/identity/common/crypto/IKeyGenSpec;", "", "algorithm", "", "getAlgorithm", "()Ljava/lang/String;", "algorithmParameterSpec", "Ljava/security/spec/AlgorithmParameterSpec;", "getAlgorithmParameterSpec", "()Ljava/security/spec/AlgorithmParameterSpec;", "description", "getDescription", "encryptionPaddings", "", "getEncryptionPaddings", "()Ljava/util/List;", "keyAlias", "getKeyAlias", "keySize", "", "getKeySize", "()I", Analytics.Event.PRINT, "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IKeyGenSpec {
    String getAlgorithm();

    AlgorithmParameterSpec getAlgorithmParameterSpec();

    String getDescription();

    /* JADX INFO: renamed from: getEncryptionPaddings */
    List<String> mo13841getEncryptionPaddings();

    String getKeyAlias();

    int getKeySize();

    String print();

    /* JADX INFO: compiled from: KeyGenSpec.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String print(IKeyGenSpec iKeyGenSpec) {
            return "KeyGenSpec(description='" + iKeyGenSpec.getDescription() + "', algorithm='" + iKeyGenSpec.getAlgorithm() + "', encryptionPaddings='" + iKeyGenSpec.mo13841getEncryptionPaddings() + "')";
        }
    }
}
