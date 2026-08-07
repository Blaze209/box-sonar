package com.box.android.sync;

import android.content.Intent;
import android.os.IBinder;
import com.box.android.coreservices.services.IntentServices;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class AuthenticatorService extends Hilt_AuthenticatorService {
    private Authenticator mAuthenticator;

    @Inject
    protected IntentServices mIntentServices;

    @Override // com.box.android.sync.Hilt_AuthenticatorService, android.app.Service
    public void onCreate() {
        this.mAuthenticator = new Authenticator(this, this.mIntentServices);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedService
    public IBinder onMAMBind(Intent intent) {
        return this.mAuthenticator.getIBinder();
    }
}
