package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: loaded from: classes9.dex */
public class RescheduleReceiver extends MAMBroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix("RescheduleReceiver");

    @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public void onMAMReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, "Received intent " + intent);
        try {
            WorkManagerImpl.getInstance(context).setReschedulePendingResult(goAsync());
        } catch (IllegalStateException e) {
            Logger.get().error(TAG, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
        }
    }
}
