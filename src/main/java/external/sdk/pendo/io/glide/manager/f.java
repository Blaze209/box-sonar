package external.sdk.pendo.io.glide.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
final class f implements g {
    final Set<Activity> a = Collections.newSetFromMap(new WeakHashMap());
    volatile boolean b;

    class a implements ViewTreeObserver.OnDrawListener {
        final /* synthetic */ View a;

        /* JADX INFO: renamed from: external.sdk.pendo.io.glide.manager.f$a$a, reason: collision with other inner class name */
        class RunnableC0318a implements Runnable {
            final /* synthetic */ ViewTreeObserver.OnDrawListener a;

            RunnableC0318a(ViewTreeObserver.OnDrawListener onDrawListener) {
                this.a = onDrawListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                external.sdk.pendo.io.glide.load.resource.bitmap.e.b().f();
                f.this.b = true;
                f.a(a.this.a, this.a);
                f.this.a.clear();
            }
        }

        a(View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            l.b(new RunnableC0318a(this));
        }
    }

    f() {
    }

    @Override // external.sdk.pendo.io.glide.manager.g
    public void a(Activity activity) {
        if (!this.b && this.a.add(activity)) {
            View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new a(decorView));
        }
    }

    static void a(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }
}
