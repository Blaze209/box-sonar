package sdk.pendo.io.d6;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.k3.m;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.h;
import sdk.pendo.io.q3.j;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static volatile b a;
    private static volatile sdk.pendo.io.j4.a<e> b = sdk.pendo.io.j4.a.m();

    class a implements j<Long> {
        final /* synthetic */ AtomicBoolean a;

        a(AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // sdk.pendo.io.q3.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Long l) {
            return !this.a.get();
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.d6.b$b, reason: collision with other inner class name */
    class C0375b implements sdk.pendo.io.q3.e<Long> {
        final /* synthetic */ Activity a;
        final /* synthetic */ String b;
        final /* synthetic */ sdk.pendo.io.j4.a c;
        final /* synthetic */ sdk.pendo.io.t4.a d;
        final /* synthetic */ AtomicBoolean e;

        C0375b(Activity activity, String str, sdk.pendo.io.j4.a aVar, sdk.pendo.io.t4.a aVar2, AtomicBoolean atomicBoolean) {
            this.a = activity;
            this.b = str;
            this.c = aVar;
            this.d = aVar2;
            this.e = atomicBoolean;
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) {
            for (Fragment fragment : ((FragmentActivity) this.a).getSupportFragmentManager().getFragments()) {
                if (fragment != null && fragment.isVisible() && fragment.isMenuVisible() && !fragment.getClass().getSimpleName().equals(this.b)) {
                    PendoLogger.d("New Fragment =  " + fragment.getClass().getSimpleName(), new Object[0]);
                    this.c.onNext(this.d);
                    this.e.set(true);
                    return;
                }
            }
        }
    }

    class c implements h<e, sdk.pendo.io.t4.a> {
        c() {
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.t4.a apply(e eVar) {
            return eVar.b;
        }
    }

    class d implements j<e> {
        final /* synthetic */ e a;

        d(e eVar) {
            this.a = eVar;
        }

        @Override // sdk.pendo.io.q3.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(e eVar) {
            return eVar.a(this.a);
        }
    }

    private static final class e {
        final int a;
        final sdk.pendo.io.t4.a b;

        private e(int i, sdk.pendo.io.t4.a aVar) {
            this.a = i;
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(Activity activity, sdk.pendo.io.t4.a aVar) {
            return new e(a(activity), aVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.a == eVar.a && this.b.equals(eVar.b);
        }

        public int hashCode() {
            return (this.a * 37) + (this.b.hashCode() * 23);
        }

        private static int a(Activity activity) {
            if (activity instanceof PendoGuideVisualActivity) {
                return 0;
            }
            return activity.getLocalClassName().hashCode();
        }

        public boolean a(Object obj) {
            e eVar;
            int i;
            return (equals(obj) || !(obj instanceof e) || (i = (eVar = (e) obj).a) == 0 || this.a == i || !this.b.equals(eVar.b)) ? false : true;
        }
    }

    private b() {
    }

    public static synchronized b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    void a(Activity activity, sdk.pendo.io.t4.a aVar) {
        if (activity instanceof PendoGuideVisualActivity) {
            return;
        }
        b.onNext(e.a(activity, aVar));
    }

    public sdk.pendo.io.o3.b a(Activity activity, sdk.pendo.io.t4.a aVar, String str, sdk.pendo.io.q3.e<sdk.pendo.io.t4.a> eVar) {
        b bVar;
        Activity activity2;
        sdk.pendo.io.t4.a aVar2;
        sdk.pendo.io.j4.a aVarM = sdk.pendo.io.j4.a.m();
        if (!(activity instanceof FragmentActivity) || str == null) {
            bVar = this;
            activity2 = activity;
            aVar2 = aVar;
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            PendoLogger.d("Current Fragment =  " + str, new Object[0]);
            bVar = this;
            activity2 = activity;
            aVar2 = aVar;
            sdk.pendo.io.k3.j.c(250L, TimeUnit.MILLISECONDS, sdk.pendo.io.i4.a.a()).b(new a(atomicBoolean)).a(sdk.pendo.io.t6.d.a(bVar.new C0375b(activity2, str, aVarM, aVar2, atomicBoolean), "ActivityLifeCycleEventsObserver interval observable for fragment change observer"));
        }
        return b.a(bVar.new d(e.a(activity2, aVar2))).c(bVar.new c()).c((m<? extends R>) aVarM).a(sdk.pendo.io.n3.a.a()).a(eVar, new sdk.pendo.io.q6.a("ActivityLifeCycleEventsObserver observer error consumer"));
    }
}
