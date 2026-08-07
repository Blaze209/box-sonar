package com.microsoft.identity.common.internal.msafederation;

import com.microsoft.identity.common.internal.msafederation.google.GoogleSignInProvider;
import com.microsoft.identity.common.internal.msafederation.google.SignInWithGoogleParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MsaFederatedSignInProviderFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInProviderFactory;", "", "()V", "getProvider", "Lcom/microsoft/identity/common/internal/msafederation/IMsaFederatedSignInProvider;", "parameters", "Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedSignInParameters;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MsaFederatedSignInProviderFactory {
    public static final MsaFederatedSignInProviderFactory INSTANCE = new MsaFederatedSignInProviderFactory();

    /* JADX INFO: compiled from: MsaFederatedSignInProviderFactory.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MsaFederatedSignInProviderName.values().length];
            try {
                iArr[MsaFederatedSignInProviderName.GOOGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MsaFederatedSignInProviderFactory() {
    }

    public final IMsaFederatedSignInProvider getProvider(MsaFederatedSignInParameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        if (WhenMappings.$EnumSwitchMapping$0[parameters.getProviderName().ordinal()] == 1) {
            return GoogleSignInProvider.INSTANCE.create((SignInWithGoogleParameters) parameters);
        }
        throw new IllegalArgumentException("Unsupported provider type");
    }
}
