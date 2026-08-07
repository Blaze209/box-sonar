package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.microsoft.intune.mam.client.app.MAMService;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;

/* JADX INFO: loaded from: classes.dex */
public final class AppLocalesMetadataHolderService extends MAMService {
    @Override // com.microsoft.intune.mam.client.app.HookedService
    public IBinder onMAMBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    public static ServiceInfo getServiceInfo(Context context) throws PackageManager.NameNotFoundException {
        return MAMPackageManagement.getServiceInfo(context.getPackageManager(), new ComponentName(context, (Class<?>) AppLocalesMetadataHolderService.class), Api24Impl.getDisabledComponentFlag() | 128);
    }

    private static class Api24Impl {
        static int getDisabledComponentFlag() {
            return 512;
        }

        private Api24Impl() {
        }
    }
}
