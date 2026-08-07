package sdk.pendo.io.r;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private final Set<sdk.pendo.io.u.a> a = Collections.newSetFromMap(new WeakHashMap());
    private final Set<sdk.pendo.io.u.a> b = new HashSet();
    private boolean c;

    public boolean a(sdk.pendo.io.u.a aVar) {
        boolean z = true;
        if (aVar == null) {
            return true;
        }
        boolean zRemove = this.a.remove(aVar);
        if (!this.b.remove(aVar) && !zRemove) {
            z = false;
        }
        if (z) {
            aVar.clear();
        }
        return z;
    }

    public boolean b() {
        return this.c;
    }

    public void c() {
        this.c = true;
        for (sdk.pendo.io.u.a aVar : l.a(this.a)) {
            if (aVar.isRunning() || aVar.isComplete()) {
                aVar.clear();
                this.b.add(aVar);
            }
        }
    }

    public void d() {
        this.c = true;
        for (sdk.pendo.io.u.a aVar : l.a(this.a)) {
            if (aVar.isRunning()) {
                aVar.pause();
                this.b.add(aVar);
            }
        }
    }

    public void e() {
        for (sdk.pendo.io.u.a aVar : l.a(this.a)) {
            if (!aVar.isComplete() && !aVar.isCleared()) {
                aVar.clear();
                if (this.c) {
                    this.b.add(aVar);
                } else {
                    aVar.begin();
                }
            }
        }
    }

    public void f() {
        this.c = false;
        for (sdk.pendo.io.u.a aVar : l.a(this.a)) {
            if (!aVar.isComplete() && !aVar.isRunning()) {
                aVar.begin();
            }
        }
        this.b.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.c + "}";
    }

    public void a() {
        Iterator it = l.a(this.a).iterator();
        while (it.hasNext()) {
            a((sdk.pendo.io.u.a) it.next());
        }
        this.b.clear();
    }

    public void b(sdk.pendo.io.u.a aVar) {
        this.a.add(aVar);
        if (!this.c) {
            aVar.begin();
            return;
        }
        aVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.b.add(aVar);
    }
}
