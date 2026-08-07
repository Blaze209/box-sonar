package com.microsoft.identity.common.java.broker;

import com.microsoft.identity.common.java.interfaces.IRefreshTokenCredentialProvider;
import com.microsoft.identity.common.java.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommonRefreshTokenCredentialProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/microsoft/identity/common/java/broker/CommonRefreshTokenCredentialProvider;", "Lcom/microsoft/identity/common/java/interfaces/IRefreshTokenCredentialProvider;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mRefreshTokenCredentialProvider", "getRefreshTokenCredential", "inputUrl", "username", "getRefreshTokenCredentialUsingNewNonce", "nonce", "initializeCommonRefreshTokenCredentialProvider", "", "refreshTokenCredentialProvider", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonRefreshTokenCredentialProvider implements IRefreshTokenCredentialProvider {
    public static final CommonRefreshTokenCredentialProvider INSTANCE = new CommonRefreshTokenCredentialProvider();
    private static final String TAG = "CommonRefreshTokenCredentialProvider";
    private static IRefreshTokenCredentialProvider mRefreshTokenCredentialProvider;

    private CommonRefreshTokenCredentialProvider() {
    }

    public final void initializeCommonRefreshTokenCredentialProvider(IRefreshTokenCredentialProvider refreshTokenCredentialProvider) {
        Intrinsics.checkNotNullParameter(refreshTokenCredentialProvider, "refreshTokenCredentialProvider");
        Logger.info(TAG + ":initializeCommonRefreshTokenCredentialProvider", "Initializing common prt credential provider with " + refreshTokenCredentialProvider.getClass().getSimpleName());
        mRefreshTokenCredentialProvider = refreshTokenCredentialProvider;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IRefreshTokenCredentialProvider
    public String getRefreshTokenCredentialUsingNewNonce(String inputUrl, String username, String nonce) {
        Intrinsics.checkNotNullParameter(inputUrl, "inputUrl");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        String str = TAG + ":getRefreshTokenCredentialUsingNewNonce";
        IRefreshTokenCredentialProvider iRefreshTokenCredentialProvider = mRefreshTokenCredentialProvider;
        if (iRefreshTokenCredentialProvider != null) {
            Intrinsics.checkNotNull(iRefreshTokenCredentialProvider);
            return iRefreshTokenCredentialProvider.getRefreshTokenCredentialUsingNewNonce(inputUrl, username, nonce);
        }
        Logger.warn(str, "mRefreshTokenCredentialHolder is not initialized!");
        return null;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IRefreshTokenCredentialProvider
    public String getRefreshTokenCredential(String inputUrl, String username) {
        Intrinsics.checkNotNullParameter(inputUrl, "inputUrl");
        Intrinsics.checkNotNullParameter(username, "username");
        String str = TAG + ":getRefreshTokenCredential";
        IRefreshTokenCredentialProvider iRefreshTokenCredentialProvider = mRefreshTokenCredentialProvider;
        if (iRefreshTokenCredentialProvider == null) {
            Logger.warn(str, "mRefreshTokenCredentialHolder is not initialized!");
            return null;
        }
        if (iRefreshTokenCredentialProvider != null) {
            return iRefreshTokenCredentialProvider.getRefreshTokenCredential(inputUrl, username);
        }
        return null;
    }
}
