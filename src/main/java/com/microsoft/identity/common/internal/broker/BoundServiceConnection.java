package com.microsoft.identity.common.internal.broker;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class BoundServiceConnection implements ServiceConnection {
    private static final String TAG = "BoundServiceConnection";
    private final ResultFuture<IBinder> mFuture;

    public BoundServiceConnection(ResultFuture<IBinder> resultFuture) {
        this.mFuture = resultFuture;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Logger.info(TAG + ":onServiceConnected", componentName.getClassName() + " is connected.");
        this.mFuture.setResult(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Logger.info(TAG + ":onServiceDisconnected", componentName.getClassName() + " is disconnected.");
    }
}
