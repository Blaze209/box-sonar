package external.sdk.pendo.io.glide.manager;

import external.sdk.pendo.io.glide.request.target.Target;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public final class TargetTracker implements sdk.pendo.io.r.b {
    private final Set<Target<?>> targets = Collections.newSetFromMap(new WeakHashMap());

    public void clear() {
        this.targets.clear();
    }

    public List<Target<?>> getAll() {
        return l.a(this.targets);
    }

    @Override // sdk.pendo.io.r.b
    public void onDestroy() {
        Iterator it = l.a(this.targets).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onDestroy();
        }
    }

    @Override // sdk.pendo.io.r.b
    public void onStart() {
        Iterator it = l.a(this.targets).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStart();
        }
    }

    @Override // sdk.pendo.io.r.b
    public void onStop() {
        Iterator it = l.a(this.targets).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStop();
        }
    }

    public void track(Target<?> target) {
        this.targets.add(target);
    }

    public void untrack(Target<?> target) {
        this.targets.remove(target);
    }
}
