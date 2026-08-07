package com.google.mlkit.common.internal;

import android.content.Intent;
import android.os.IBinder;
import com.microsoft.intune.mam.client.app.MAMService;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
/* JADX INFO: loaded from: classes14.dex */
public class MlKitComponentDiscoveryService extends MAMService {
    @Override // com.microsoft.intune.mam.client.app.HookedService
    public final IBinder onMAMBind(Intent intent) {
        return null;
    }
}
