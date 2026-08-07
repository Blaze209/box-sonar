package androidx.work.impl.diagnostics;

import android.content.Context;
import android.content.Intent;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.workers.DiagnosticsWorker;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: loaded from: classes9.dex */
public class DiagnosticsReceiver extends MAMBroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix("DiagnosticsRcvr");

    @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public void onMAMReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Logger.get().debug(TAG, "Requesting diagnostics");
        try {
            WorkManager.getInstance(context).enqueue(OneTimeWorkRequest.from((Class<? extends ListenableWorker>) DiagnosticsWorker.class));
        } catch (IllegalStateException e) {
            Logger.get().error(TAG, "WorkManager is not initialized", e);
        }
    }
}
