package androidx.camera.core.impl;

import android.content.Intent;
import android.os.IBinder;
import com.microsoft.intune.mam.client.app.MAMService;

/* JADX INFO: loaded from: classes.dex */
public class MetadataHolderService extends MAMService {
    @Override // com.microsoft.intune.mam.client.app.HookedService
    public IBinder onMAMBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    private MetadataHolderService() {
    }
}
