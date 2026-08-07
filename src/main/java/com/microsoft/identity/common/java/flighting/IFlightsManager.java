package com.microsoft.identity.common.java.flighting;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IFlightsManager.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/common/java/flighting/IFlightsManager;", "", "getFlightsProvider", "Lcom/microsoft/identity/common/java/flighting/IFlightsProvider;", "waitForConfigsWithTimeoutInMs", "", "getFlightsProviderForTenant", "tenantId", "", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IFlightsManager {
    IFlightsProvider getFlightsProvider();

    IFlightsProvider getFlightsProvider(long waitForConfigsWithTimeoutInMs);

    IFlightsProvider getFlightsProviderForTenant(String tenantId);

    IFlightsProvider getFlightsProviderForTenant(String tenantId, long waitForConfigsWithTimeoutInMs);

    /* JADX INFO: compiled from: IFlightsManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static IFlightsProvider getFlightsProvider(IFlightsManager iFlightsManager) {
            return iFlightsManager.getFlightsProvider(0L);
        }

        public static /* synthetic */ IFlightsProvider getFlightsProvider$default(IFlightsManager iFlightsManager, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFlightsProvider");
            }
            if ((i & 1) != 0) {
                j = 0;
            }
            return iFlightsManager.getFlightsProvider(j);
        }

        public static IFlightsProvider getFlightsProviderForTenant(IFlightsManager iFlightsManager, String tenantId) {
            Intrinsics.checkNotNullParameter(tenantId, "tenantId");
            return iFlightsManager.getFlightsProviderForTenant(tenantId, 0L);
        }

        public static /* synthetic */ IFlightsProvider getFlightsProviderForTenant$default(IFlightsManager iFlightsManager, String str, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFlightsProviderForTenant");
            }
            if ((i & 2) != 0) {
                j = 0;
            }
            return iFlightsManager.getFlightsProviderForTenant(str, j);
        }
    }
}
