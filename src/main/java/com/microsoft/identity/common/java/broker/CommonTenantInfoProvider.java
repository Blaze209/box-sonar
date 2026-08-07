package com.microsoft.identity.common.java.broker;

import com.microsoft.identity.common.java.interfaces.ITenantInfoProvider;
import com.microsoft.identity.common.java.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommonTenantInfoProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/java/broker/CommonTenantInfoProvider;", "Lcom/microsoft/identity/common/java/interfaces/ITenantInfoProvider;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "mTenantInfoProvider", "getHomeTenantId", "username", "initializeCommonTenantInfoProvider", "", "tenantInfoProvider", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonTenantInfoProvider implements ITenantInfoProvider {
    public static final CommonTenantInfoProvider INSTANCE = new CommonTenantInfoProvider();
    private static final String TAG = "CommonTenantInfoProvider";
    private static ITenantInfoProvider mTenantInfoProvider;

    private CommonTenantInfoProvider() {
    }

    public final void initializeCommonTenantInfoProvider(ITenantInfoProvider tenantInfoProvider) {
        Intrinsics.checkNotNullParameter(tenantInfoProvider, "tenantInfoProvider");
        Logger.info(TAG + ":initializeCommonTenantInfoProvider", "Initializing common tenant information provider with " + tenantInfoProvider.getClass().getSimpleName());
        mTenantInfoProvider = tenantInfoProvider;
    }

    @Override // com.microsoft.identity.common.java.interfaces.ITenantInfoProvider
    public String getHomeTenantId(String username) {
        Intrinsics.checkNotNullParameter(username, "username");
        String str = TAG + ":getTenantId";
        ITenantInfoProvider iTenantInfoProvider = mTenantInfoProvider;
        if (iTenantInfoProvider != null) {
            Intrinsics.checkNotNull(iTenantInfoProvider);
            return iTenantInfoProvider.getHomeTenantId(username);
        }
        Logger.warn(str, "mTenantInfoProvider is not initialized!");
        return null;
    }
}
