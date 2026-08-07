package com.microsoft.identity.common.internal.broker;

import android.os.Bundle;
import com.microsoft.identity.common.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SdmQrPinManager.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/SdmQrPinManager;", "", "()V", "TAG", "", "authenticatorPackageName", "restrictionsManager", "Lcom/microsoft/identity/common/internal/broker/IRestrictionsManager;", "getPreferredAuthConfig", "initializeSdmQrPinManager", "", "isCameraConsentSuppressed", "", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SdmQrPinManager {
    private static final String TAG = "SdmQrPinManager";
    private static IRestrictionsManager restrictionsManager;
    public static final SdmQrPinManager INSTANCE = new SdmQrPinManager();
    private static final String authenticatorPackageName = BrokerData.INSTANCE.getProdMicrosoftAuthenticator().getPackageName();

    private SdmQrPinManager() {
    }

    public final void initializeSdmQrPinManager(IRestrictionsManager restrictionsManager2) {
        Intrinsics.checkNotNullParameter(restrictionsManager2, "restrictionsManager");
        restrictionsManager = restrictionsManager2;
    }

    public final String getPreferredAuthConfig() {
        IRestrictionsManager iRestrictionsManager = restrictionsManager;
        if (iRestrictionsManager != null) {
            return iRestrictionsManager.getString("preferred_auth_config", authenticatorPackageName, null);
        }
        Logger.warn("SdmQrPinManager:getPreferredAuthConfig", "Broker restrictions manager is not initialized.");
        return null;
    }

    public final boolean isCameraConsentSuppressed() {
        IRestrictionsManager iRestrictionsManager = restrictionsManager;
        if (iRestrictionsManager != null) {
            Bundle multiValues = iRestrictionsManager.getMultiValues(authenticatorPackageName, IRestrictionsManager.Companion.buildMultiValueRequest$default(IRestrictionsManager.INSTANCE, null, SetsKt.setOf((Object[]) new String[]{"suppress_camera_consent", "sdm_suppress_camera_consent"}), 1, null));
            return multiValues.getBoolean("suppress_camera_consent", false) || multiValues.getBoolean("sdm_suppress_camera_consent", false);
        }
        Logger.warn("SdmQrPinManager:isCameraConsentSuppressed", "Broker restrictions manager is not initialized.");
        return false;
    }
}
