package com.pspdfkit.internal;

import android.view.View;
import com.pspdfkit.annotations.Annotation;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class ft<T extends Annotation> {
    public final View a;
    public final go<z4.a<T>> b = new go<>();

    /* JADX WARN: Multi-variable type inference failed */
    public ft(z4<T> z4Var) {
        this.a = (View) z4Var;
    }

    public final void a() {
        Iterator<z4.a<T>> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.a);
        }
        this.b.clear();
    }
}
