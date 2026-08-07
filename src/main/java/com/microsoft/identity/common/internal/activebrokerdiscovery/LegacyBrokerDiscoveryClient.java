package com.microsoft.identity.common.internal.activebrokerdiscovery;

import android.content.Context;
import com.microsoft.identity.common.internal.broker.BrokerData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LegacyBrokerDiscoveryClient.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/LegacyBrokerDiscoveryClient;", "Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClient;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "forceBrokerRediscovery", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "brokerCandidate", "getActiveBroker", "shouldSkipCache", "", "telemetryCallback", "Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClientTelemetryCallback;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyBrokerDiscoveryClient implements IBrokerDiscoveryClient {
    private final Context context;

    public LegacyBrokerDiscoveryClient(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.microsoft.identity.common.internal.activebrokerdiscovery.IBrokerDiscoveryClient
    public BrokerData getActiveBroker(boolean shouldSkipCache) {
        return new AccountManagerBrokerDiscoveryUtil(this.context).getActiveBrokerFromAccountManager();
    }

    @Override // com.microsoft.identity.common.internal.activebrokerdiscovery.IBrokerDiscoveryClient
    public BrokerData getActiveBroker(boolean shouldSkipCache, IBrokerDiscoveryClientTelemetryCallback telemetryCallback) {
        Intrinsics.checkNotNullParameter(telemetryCallback, "telemetryCallback");
        telemetryCallback.onUseAccountManager();
        return new AccountManagerBrokerDiscoveryUtil(this.context).getActiveBrokerFromAccountManager();
    }

    @Override // com.microsoft.identity.common.internal.activebrokerdiscovery.IBrokerDiscoveryClient
    public BrokerData forceBrokerRediscovery(BrokerData brokerCandidate) {
        Intrinsics.checkNotNullParameter(brokerCandidate, "brokerCandidate");
        throw new UnsupportedOperationException("LegacyBrokerDiscoveryClient does not support forceBrokerRediscovery.");
    }
}
