package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: compiled from: com.google.android.play:app-update@@2.1.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzk extends MAMBroadcastReceiver {
    final /* synthetic */ zzl zza;

    @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public final void onMAMReceive(Context context, Intent intent) {
        this.zza.zza(context, intent);
    }
}
