package com.microsoft.identity.common.internal.msafederation;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MsaFederatedCredential.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedCredential;", "", "signInProviderName", "Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInProviderName;", "(Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInProviderName;)V", "getSignInProviderName", "()Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInProviderName;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class MsaFederatedCredential {

    @SerializedName("signInProviderName")
    private final MsaFederatedSignInProviderName signInProviderName;

    public MsaFederatedCredential(MsaFederatedSignInProviderName signInProviderName) {
        Intrinsics.checkNotNullParameter(signInProviderName, "signInProviderName");
        this.signInProviderName = signInProviderName;
    }

    public final MsaFederatedSignInProviderName getSignInProviderName() {
        return this.signInProviderName;
    }
}
