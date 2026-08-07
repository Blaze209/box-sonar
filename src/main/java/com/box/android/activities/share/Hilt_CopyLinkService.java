package com.box.android.activities.share;

import com.microsoft.intune.mam.client.app.MAMIntentService;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes9.dex */
abstract class Hilt_CopyLinkService extends MAMIntentService implements GeneratedComponentManagerHolder {
    private volatile ServiceComponentManager componentManager;
    private final Object componentManagerLock;
    private boolean injected;

    Hilt_CopyLinkService(String str) {
        super(str);
        this.componentManagerLock = new Object();
        this.injected = false;
    }

    @Override // android.app.IntentService, android.app.Service
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
        ((CopyLinkService_GeneratedInjector) generatedComponent()).injectCopyLinkService((CopyLinkService) UnsafeCasts.unsafeCast(this));
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }
}
