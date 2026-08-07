package com.microsoft.identity.common.internal.activebrokerdiscovery;

import kotlin.Metadata;

/* JADX INFO: compiled from: IBrokerDiscoveryClientTelemetryCallback.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClientTelemetryCallback;", "", "onFinishCheckingIfPackageIsInstalled", "", "timeSpentInNanoSeconds", "", "onFinishCheckingIfSupportedByTargetedBroker", "onFinishCheckingIfValidBroker", "onFinishQueryingResultFromBroker", "onLockAcquired", "onReadFromCache", "onUseAccountManager", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IBrokerDiscoveryClientTelemetryCallback {
    void onFinishCheckingIfPackageIsInstalled(long timeSpentInNanoSeconds);

    void onFinishCheckingIfSupportedByTargetedBroker(long timeSpentInNanoSeconds);

    void onFinishCheckingIfValidBroker(long timeSpentInNanoSeconds);

    void onFinishQueryingResultFromBroker(long timeSpentInNanoSeconds);

    void onLockAcquired(long timeSpentInNanoSeconds);

    void onReadFromCache(long timeSpentInNanoSeconds);

    void onUseAccountManager();
}
