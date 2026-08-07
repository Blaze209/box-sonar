package com.google.android.datatransport.runtime.backends;

import android.content.Intent;
import android.os.IBinder;
import com.microsoft.intune.mam.client.app.MAMService;

/* JADX INFO: loaded from: classes13.dex */
public class TransportBackendDiscovery extends MAMService {
    @Override // com.microsoft.intune.mam.client.app.HookedService
    public IBinder onMAMBind(Intent intent) {
        return null;
    }
}
