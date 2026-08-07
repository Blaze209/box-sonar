package com.box.android.services;

import com.google.firebase.messaging.FirebaseMessagingService;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes13.dex */
abstract class Hilt_FirebaseMessagingListenerService extends FirebaseMessagingService implements GeneratedComponentManagerHolder {
    private volatile ServiceComponentManager componentManager;
    private final Object componentManagerLock = new Object();
    private boolean injected = false;

    Hilt_FirebaseMessagingListenerService() {
    }

    @Override // android.app.Service
    public void onCreate() {
        inject();
        super.onCreate();
    }

    protected ServiceComponentManager createComponentManager() {
        return new ServiceComponentManager(this);
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final ServiceComponentManager componentManager() {
        if (this.componentManager == null) {
            synchronized (this.componentManagerLock) {
                if (this.componentManager == null) {
                    this.componentManager = createComponentManager();
                }
            }
        }
        return this.componentManager;
    }

    protected void inject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((FirebaseMessagingListenerService_GeneratedInjector) generatedComponent()).injectFirebaseMessagingListenerService((FirebaseMessagingListenerService) UnsafeCasts.unsafeCast(this));
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }
}
