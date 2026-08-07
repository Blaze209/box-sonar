package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes14.dex */
public abstract class BoundServiceClient<T extends IInterface> {
    private static final int DEFAULT_BIND_TIMEOUT_IN_SECONDS = 30;
    private static final String TAG = "BoundServiceClient";
    private BoundServiceConnection mConnection;
    protected final Context mContext;
    private boolean mHasStartedBinding;
    private final String mTargetServiceClassName;
    private final String mTargetServiceIntentFilter;
    private final int mTimeOutInSeconds;

    abstract T getInterfaceFromIBinder(IBinder iBinder);

    abstract Bundle performOperationInternal(BrokerOperationBundle brokerOperationBundle, T t) throws BrokerCommunicationException, RemoteException;

    public BoundServiceClient(Context context, String str, String str2) {
        this(context, str, str2, 30);
    }

    public BoundServiceClient(Context context, String str, String str2, int i) {
        this.mContext = context;
        this.mTimeOutInSeconds = i;
        this.mTargetServiceClassName = str;
        this.mTargetServiceIntentFilter = str2;
    }

    public Bundle performOperation(BrokerOperationBundle brokerOperationBundle) throws ExecutionException, InterruptedException, BrokerCommunicationException, TimeoutException, RemoteException {
        return performOperationInternal(brokerOperationBundle, connect(brokerOperationBundle.getTargetBrokerAppPackageName()));
    }

    protected T connect(String str) throws ExecutionException, InterruptedException, BrokerCommunicationException, TimeoutException {
        String str2 = TAG + ":connect";
        if (!isBoundServiceSupported(str)) {
            Logger.info(str2, "Bound service is not supported.");
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE, IIpcStrategy.Type.BOUND_SERVICE, "Bound service is not supported.", null);
        }
        ResultFuture resultFuture = new ResultFuture();
        this.mConnection = new BoundServiceConnection(resultFuture);
        boolean zBindService = this.mContext.bindService(getIntentForBoundService(str), this.mConnection, 1);
        this.mHasStartedBinding = zBindService;
        if (!zBindService) {
            Logger.info(str2, "failed to bind. The service is not available.");
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE, IIpcStrategy.Type.BOUND_SERVICE, "failed to bind. The service is not available.", null);
        }
        Logger.info(str2, "Android is establishing the bound service connection.");
        return (T) getInterfaceFromIBinder((IBinder) resultFuture.get(this.mTimeOutInSeconds, TimeUnit.SECONDS));
    }

    public void disconnect() {
        String str = TAG + ":disconnect";
        if (this.mHasStartedBinding) {
            try {
                this.mContext.unbindService(this.mConnection);
            } catch (IllegalArgumentException e) {
                Logger.error(str, "Error occurred while unbinding bound Service with " + getClass().getSimpleName(), e);
            }
            this.mHasStartedBinding = false;
        }
    }

    public boolean isBoundServiceSupported(String str) {
        List<ResolveInfo> listQueryIntentServices = MAMPackageManagement.queryIntentServices(this.mContext.getPackageManager(), getIntentForBoundService(str), 0);
        return listQueryIntentServices != null && listQueryIntentServices.size() > 0;
    }

    private Intent getIntentForBoundService(String str) {
        Intent intent = new Intent(this.mTargetServiceIntentFilter);
        intent.setPackage(str);
        intent.setClassName(str, this.mTargetServiceClassName);
        return intent;
    }
}
