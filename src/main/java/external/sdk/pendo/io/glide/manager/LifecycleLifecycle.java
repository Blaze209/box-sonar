package external.sdk.pendo.io.glide.manager;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
final class LifecycleLifecycle implements sdk.pendo.io.r.a, LifecycleObserver {
    private final Set<sdk.pendo.io.r.b> a = new HashSet();
    private final Lifecycle b;

    LifecycleLifecycle(Lifecycle lifecycle) {
        this.b = lifecycle;
        lifecycle.addObserver(this);
    }

    @Override // sdk.pendo.io.r.a
    public void a(sdk.pendo.io.r.b bVar) {
        this.a.add(bVar);
        if (this.b.getCurrentState() == Lifecycle.State.DESTROYED) {
            bVar.onDestroy();
        } else if (this.b.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            bVar.onStart();
        } else {
            bVar.onStop();
        }
    }

    @Override // sdk.pendo.io.r.a
    public void b(sdk.pendo.io.r.b bVar) {
        this.a.remove(bVar);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Iterator it = l.a(this.a).iterator();
        while (it.hasNext()) {
            ((sdk.pendo.io.r.b) it.next()).onDestroy();
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        Iterator it = l.a(this.a).iterator();
        while (it.hasNext()) {
            ((sdk.pendo.io.r.b) it.next()).onStart();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        Iterator it = l.a(this.a).iterator();
        while (it.hasNext()) {
            ((sdk.pendo.io.r.b) it.next()).onStop();
        }
    }
}
