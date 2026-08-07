package external.sdk.pendo.io.glide.manager;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
final class c implements ConnectivityMonitor {
    private final Context a;
    final ConnectivityMonitor.a b;

    c(Context context, ConnectivityMonitor.a aVar) {
        this.a = context.getApplicationContext();
        this.b = aVar;
    }

    private void a() {
        k.a(this.a).a(this.b);
    }

    private void b() {
        k.a(this.a).b(this.b);
    }

    @Override // external.sdk.pendo.io.glide.manager.ConnectivityMonitor, sdk.pendo.io.r.b
    public void onDestroy() {
    }

    @Override // external.sdk.pendo.io.glide.manager.ConnectivityMonitor, sdk.pendo.io.r.b
    public void onStart() {
        a();
    }

    @Override // external.sdk.pendo.io.glide.manager.ConnectivityMonitor, sdk.pendo.io.r.b
    public void onStop() {
        b();
    }
}
