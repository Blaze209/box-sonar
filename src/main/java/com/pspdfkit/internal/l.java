package com.pspdfkit.internal;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public final Context a;
    public final Lazy b;
    public final Lazy c;

    public l(Context context) {
        context.getClass();
        this.a = context;
        this.b = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.l$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return l.a(this.f$0);
            }
        });
        this.c = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.l$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return l.b(this.f$0);
            }
        });
    }

    public static final rb a(l lVar) {
        return new rb(lVar.a);
    }

    public static final yo b(l lVar) {
        return new yo(lVar.a);
    }
}
