package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zbt;
import com.microsoft.intune.mam.client.app.MAMService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class RevocationBoundService extends MAMService {
    @Override // com.microsoft.intune.mam.client.app.HookedService
    public IBinder onMAMBind(Intent intent) {
        if (!"com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) && !"com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            Log.w("RevocationService", "Unknown action sent to RevocationBoundService: ".concat(String.valueOf(intent.getAction())));
            return null;
        }
        if (Log.isLoggable("RevocationService", 2)) {
            Log.v("RevocationService", "RevocationBoundService handling ".concat(String.valueOf(intent.getAction())));
        }
        return new zbt(this);
    }
}
