package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zabx extends MAMBroadcastReceiver {
    Context zaa;
    private final zabw zab;

    public zabx(zabw zabwVar) {
        this.zab = zabwVar;
    }

    @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public final void onMAMReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.zab.zaa();
            zab();
        }
    }

    public final void zaa(Context context) {
        this.zaa = context;
    }

    public final synchronized void zab() {
        Context context = this.zaa;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.zaa = null;
    }
}
