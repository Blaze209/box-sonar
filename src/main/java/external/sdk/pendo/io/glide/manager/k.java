package external.sdk.pendo.io.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
final class k {
    private static volatile k d;
    private final c a;
    final Set<ConnectivityMonitor.a> b = new HashSet();
    private boolean c;

    class a implements sdk.pendo.io.y.f.b<ConnectivityManager> {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // sdk.pendo.io.y.f.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.a.getSystemService("connectivity");
        }
    }

    class b implements ConnectivityMonitor.a {
        b() {
        }

        @Override // external.sdk.pendo.io.glide.manager.ConnectivityMonitor.a
        public void a(boolean z) {
            ArrayList arrayList;
            l.b();
            synchronized (k.this) {
                arrayList = new ArrayList(k.this.b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ConnectivityMonitor.a) it.next()).a(z);
            }
        }
    }

    private interface c {
        void a();

        boolean b();
    }

    private static final class d implements c {
        boolean a;
        final ConnectivityMonitor.a b;
        private final sdk.pendo.io.y.f.b<ConnectivityManager> c;
        private final ConnectivityManager.NetworkCallback d = new a();

        class a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: external.sdk.pendo.io.glide.manager.k$d$a$a, reason: collision with other inner class name */
            class RunnableC0319a implements Runnable {
                final /* synthetic */ boolean a;

                RunnableC0319a(boolean z) {
                    this.a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.a);
                }
            }

            a() {
            }

            private void b(boolean z) {
                l.b(new RunnableC0319a(z));
            }

            void a(boolean z) {
                l.b();
                d dVar = d.this;
                boolean z2 = dVar.a;
                dVar.a = z;
                if (z2 != z) {
                    dVar.b.a(z);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                b(false);
            }
        }

        d(sdk.pendo.io.y.f.b<ConnectivityManager> bVar, ConnectivityMonitor.a aVar) {
            this.c = bVar;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.manager.k.c
        public void a() {
            this.c.get().unregisterNetworkCallback(this.d);
        }

        @Override // external.sdk.pendo.io.glide.manager.k.c
        public boolean b() {
            this.a = this.c.get().getActiveNetwork() != null;
            try {
                this.c.get().registerDefaultNetworkCallback(this.d);
                return true;
            } catch (RuntimeException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e);
                }
                return false;
            }
        }
    }

    private static final class e implements c {
        static final Executor g = AsyncTask.SERIAL_EXECUTOR;
        final Context a;
        final ConnectivityMonitor.a b;
        private final sdk.pendo.io.y.f.b<ConnectivityManager> c;
        volatile boolean d;
        volatile boolean e;
        final BroadcastReceiver f = new a();

        class a extends MAMBroadcastReceiver {
            a() {
            }

            @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
            public void onMAMReceive(Context context, Intent intent) {
                e.this.d();
            }
        }

        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.d = eVar.c();
                try {
                    e eVar2 = e.this;
                    eVar2.a.registerReceiver(eVar2.f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    e.this.e = true;
                } catch (SecurityException e) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e);
                    }
                    e.this.e = false;
                }
            }
        }

        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.e) {
                    e.this.e = false;
                    e eVar = e.this;
                    eVar.a.unregisterReceiver(eVar.f);
                }
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.d;
                e eVar = e.this;
                eVar.d = eVar.c();
                if (z != e.this.d) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.d);
                    }
                    e eVar2 = e.this;
                    eVar2.a(eVar2.d);
                }
            }
        }

        /* JADX INFO: renamed from: external.sdk.pendo.io.glide.manager.k$e$e, reason: collision with other inner class name */
        class RunnableC0320e implements Runnable {
            final /* synthetic */ boolean a;

            RunnableC0320e(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.b.a(this.a);
            }
        }

        e(Context context, sdk.pendo.io.y.f.b<ConnectivityManager> bVar, ConnectivityMonitor.a aVar) {
            this.a = context.getApplicationContext();
            this.c = bVar;
            this.b = aVar;
        }

        void a(boolean z) {
            l.b(new RunnableC0320e(z));
        }

        @Override // external.sdk.pendo.io.glide.manager.k.c
        public boolean b() {
            g.execute(new b());
            return true;
        }

        boolean c() {
            try {
                NetworkInfo activeNetworkInfo = this.c.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
                }
                return true;
            }
        }

        void d() {
            g.execute(new d());
        }

        @Override // external.sdk.pendo.io.glide.manager.k.c
        public void a() {
            g.execute(new c());
        }
    }

    private k(Context context) {
        this.a = new d(sdk.pendo.io.y.f.a(new a(context)), new b());
    }

    static k a(Context context) {
        if (d == null) {
            synchronized (k.class) {
                if (d == null) {
                    d = new k(context.getApplicationContext());
                }
            }
        }
        return d;
    }

    private void b() {
        if (this.c && this.b.isEmpty()) {
            this.a.a();
            this.c = false;
        }
    }

    private void a() {
        if (this.c || this.b.isEmpty()) {
            return;
        }
        this.c = this.a.b();
    }

    synchronized void b(ConnectivityMonitor.a aVar) {
        this.b.remove(aVar);
        b();
    }

    synchronized void a(ConnectivityMonitor.a aVar) {
        this.b.add(aVar);
        a();
    }
}
