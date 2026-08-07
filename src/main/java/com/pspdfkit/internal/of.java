package com.pspdfkit.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class of {
    public boolean a;
    public hn.c b;
    public Runnable c;
    public fk.a d;

    public static final void a(Ref.BooleanRef booleanRef, Runnable runnable) {
        if (booleanRef.element) {
            return;
        }
        booleanRef.element = true;
        runnable.run();
    }

    public final void a(final FrameLayout frameLayout, final Runnable runnable) {
        runnable.getClass();
        hn.c cVar = this.b;
        if (cVar != null) {
            cVar.b();
        }
        this.b = null;
        Runnable runnable2 = this.c;
        if (runnable2 != null) {
            frameLayout.removeCallbacks(runnable2);
            this.c = null;
        }
        Context context = frameLayout.getContext();
        context.getClass();
        fk fkVarA = gk.a(context);
        Activity activityA = a80.a(context);
        this.a = fkVarA != null && fkVarA.c && activityA != null && gk.d(activityA);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Runnable runnable3 = new Runnable() { // from class: com.pspdfkit.internal.of$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                of.a(booleanRef, runnable);
            }
        };
        this.c = runnable3;
        hn.d dVar = new hn.d() { // from class: com.pspdfkit.internal.of$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.internal.hn.d
            public final void a(boolean z) {
                of.a(this.f$0, frameLayout, runnable3, z);
            }
        };
        WeakHashMap weakHashMap = hn.a;
        this.b = new hn.c(a80.a((View) frameLayout), dVar);
        frameLayout.postDelayed(this.c, 300L);
    }

    public static final void a(of ofVar, View view, Runnable runnable, boolean z) {
        if (z) {
            Runnable runnable2 = ofVar.c;
            if (runnable2 != null) {
                view.removeCallbacks(runnable2);
                ofVar.c = null;
            }
            runnable.run();
        }
    }

    public final void a(Context context, boolean z) {
        context.getClass();
        Activity activityA = a80.a(context);
        if (activityA != null && !activityA.isFinishing() && !activityA.isDestroyed()) {
            fk fkVarA = gk.a(context);
            if (fkVarA == null || !fkVarA.c) {
                this.d = null;
                return;
            }
            if (z) {
                fkVarA.b(true);
                this.d = null;
                return;
            }
            fk.a aVar = this.d;
            if (aVar != null) {
                fkVarA.d.remove(aVar);
                fkVarA.b();
                this.d = null;
                return;
            }
            return;
        }
        this.d = null;
    }
}
