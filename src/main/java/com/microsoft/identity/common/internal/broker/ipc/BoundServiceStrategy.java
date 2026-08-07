package com.microsoft.identity.common.internal.broker.ipc;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.BoundServiceClient;
import com.microsoft.identity.common.logging.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes14.dex */
public class BoundServiceStrategy<T extends IInterface> extends AbstractIpcStrategyWithServiceValidation {
    private static final String TAG = "BoundServiceStrategy";
    private final BoundServiceClient<T> mClient;

    public BoundServiceStrategy(BoundServiceClient<T> boundServiceClient) {
        super(false);
        this.mClient = boundServiceClient;
    }

    protected BoundServiceStrategy(BoundServiceClient<T> boundServiceClient, boolean z) {
        super(z);
        this.mClient = boundServiceClient;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.AbstractIpcStrategyWithServiceValidation
    protected Bundle communicateToBrokerAfterValidation(BrokerOperationBundle brokerOperationBundle) throws BrokerCommunicationException {
        String str = TAG + ":communicateToBroker";
        Logger.info(str, "Broker operation: " + brokerOperationBundle.getOperation().name() + " brokerPackage: " + brokerOperationBundle.getTargetBrokerAppPackageName());
        try {
            try {
                Bundle bundlePerformOperation = this.mClient.performOperation(brokerOperationBundle);
                this.mClient.disconnect();
                return bundlePerformOperation;
            } catch (RemoteException | InterruptedException | RuntimeException | ExecutionException | TimeoutException e) {
                String str2 = "Error occurred while awaiting (get) return of bound Service with " + this.mClient.getClass().getSimpleName();
                Logger.error(str, str2, e);
                throw new BrokerCommunicationException(BrokerCommunicationException.Category.CONNECTION_ERROR, getType(), str2, e);
            }
        } catch (Throwable th) {
            this.mClient.disconnect();
            throw th;
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public IIpcStrategy.Type getType() {
        return IIpcStrategy.Type.BOUND_SERVICE;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public boolean isSupportedByTargetedBroker(String str) {
        return this.mClient.isBoundServiceSupported(str);
    }
}
