package com.microsoft.intune.mam.client.app;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.microsoft.intune.mam.client.identity.MAMIdentity;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMService extends Service implements HookedService {
    private ServiceBehavior mBehavior;
    private MAMIdentity mOfflineIdentity;

    @Override // com.microsoft.intune.mam.client.app.HookedService
    public Service asService() {
        return this;
    }

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        MAMComponents.initialize(context);
        ServiceBehavior serviceBehavior = (ServiceBehavior) MAMComponents.get(ServiceBehavior.class);
        this.mBehavior = serviceBehavior;
        serviceBehavior.attachBaseContext(this, context);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public final void attachBaseContextReal(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.mBehavior.onBind(intent);
    }

    @Override // android.app.Service
    @Deprecated
    public final void onStart(Intent intent, int i) {
        this.mBehavior.onStart(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedService
    @Deprecated
    public final void onStartReal(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Deprecated
    public void onMAMStart(Intent intent, int i) {
        this.mBehavior.onMAMStart(intent, i);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        return this.mBehavior.onStartCommand(intent, i, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedService
    public final int onStartCommandReal(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public int onMAMStartCommand(Intent intent, int i, int i2) {
        return this.mBehavior.onMAMStartCommand(intent, i, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public void setMAMOfflineIdentity(MAMIdentity mAMIdentity) {
        this.mOfflineIdentity = mAMIdentity;
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public MAMIdentity getMAMOfflineIdentity() {
        return this.mOfflineIdentity;
    }
}
