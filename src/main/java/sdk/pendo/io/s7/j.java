package sdk.pendo.io.s7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.content.ContextCompat;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.utilities.AndroidUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class j {
    private static BroadcastReceiver a;
    private static sdk.pendo.io.j4.b<Boolean> b = sdk.pendo.io.j4.b.m();

    class a extends MAMBroadcastReceiver {
        a() {
        }

        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            sdk.pendo.io.j4.b bVar;
            if (!j.a() || (bVar = j.b) == null) {
                return;
            }
            bVar.onNext(Boolean.TRUE);
        }
    }

    class b implements sdk.pendo.io.q3.j<Boolean> {
        b() {
        }

        @Override // sdk.pendo.io.q3.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Boolean bool) {
            return bool.booleanValue();
        }
    }

    private static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static synchronized void b(Context context) {
        if (a == null) {
            a = new a();
            ContextCompat.registerReceiver(context, a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 4);
        }
    }

    public static synchronized void c(Context context) {
        BroadcastReceiver broadcastReceiver = a;
        if (broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused) {
                PendoLogger.i("ConnectivityUtils -> trying to unregister not registered receiver", new Object[0]);
            }
            a = null;
        }
    }

    public static boolean a() {
        if (!AndroidUtils.b("android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo networkInfoA = a(PendoInternal.o());
        return networkInfoA != null && networkInfoA.isConnected();
    }

    public static sdk.pendo.io.o3.b a(sdk.pendo.io.q3.e<Boolean> eVar) {
        return b.a(new b()).b(sdk.pendo.io.i4.a.b()).a(sdk.pendo.io.i4.a.b()).a(eVar, new sdk.pendo.io.q6.a("ConnectivityUtils connection error consumer"));
    }
}
