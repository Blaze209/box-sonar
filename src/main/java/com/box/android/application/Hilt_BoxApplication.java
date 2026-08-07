package com.box.android.application;

import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes9.dex */
abstract class Hilt_BoxApplication extends BoxBaseApplication implements GeneratedComponentManagerHolder {
    private boolean injected = false;
    private final ApplicationComponentManager componentManager = new ApplicationComponentManager(new ComponentSupplier() { // from class: com.box.android.application.Hilt_BoxApplication.1
        @Override // dagger.hilt.android.internal.managers.ComponentSupplier
        public Object get() {
            return DaggerBoxApplication_HiltComponents_SingletonC.builder().applicationContextModule(new ApplicationContextModule(Hilt_BoxApplication.this)).build();
        }
    });

    Hilt_BoxApplication() {
    }

    @Override // dagger.hilt.internal.GeneratedComponentManagerHolder
    public final ApplicationComponentManager componentManager() {
        return this.componentManager;
    }

    @Override // dagger.hilt.internal.GeneratedComponentManager
    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    @Override // com.box.android.application.BoxBaseApplication, com.microsoft.intune.mam.client.app.MAMApplication, com.microsoft.intune.mam.client.app.HookedApplication
    public void onMAMCreate() {
        hiltInternalInject();
        super.onMAMCreate();
    }

    protected void hiltInternalInject() {
        if (this.injected) {
            return;
        }
        this.injected = true;
        ((BoxApplication_GeneratedInjector) generatedComponent()).injectBoxApplication((BoxApplication) UnsafeCasts.unsafeCast(this));
    }
}
