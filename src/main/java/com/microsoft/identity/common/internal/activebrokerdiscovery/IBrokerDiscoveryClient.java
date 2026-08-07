package com.microsoft.identity.common.internal.activebrokerdiscovery;

import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.java.exception.ClientException;
import kotlin.Metadata;

/* JADX INFO: compiled from: IBrokerDiscoveryClient.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClient;", "", "forceBrokerRediscovery", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "brokerCandidate", "getActiveBroker", "shouldSkipCache", "", "telemetryCallback", "Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClientTelemetryCallback;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IBrokerDiscoveryClient {
    BrokerData forceBrokerRediscovery(BrokerData brokerCandidate) throws ClientException;

    BrokerData getActiveBroker(boolean shouldSkipCache);

    BrokerData getActiveBroker(boolean shouldSkipCache, IBrokerDiscoveryClientTelemetryCallback telemetryCallback);

    /* JADX INFO: compiled from: IBrokerDiscoveryClient.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ BrokerData getActiveBroker$default(IBrokerDiscoveryClient iBrokerDiscoveryClient, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActiveBroker");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            return iBrokerDiscoveryClient.getActiveBroker(z);
        }

        public static /* synthetic */ BrokerData getActiveBroker$default(IBrokerDiscoveryClient iBrokerDiscoveryClient, boolean z, IBrokerDiscoveryClientTelemetryCallback iBrokerDiscoveryClientTelemetryCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActiveBroker");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            return iBrokerDiscoveryClient.getActiveBroker(z, iBrokerDiscoveryClientTelemetryCallback);
        }
    }
}
