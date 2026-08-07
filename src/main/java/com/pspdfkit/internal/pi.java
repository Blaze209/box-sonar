package com.pspdfkit.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class pi extends FunctionReferenceImpl implements Function0<Unit> {
    public pi(zo zoVar) {
        super(0, zoVar, zo.class, "recycleIfOwned", "recycleIfOwned()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        ((zo) this.receiver).b();
        return Unit.INSTANCE;
    }
}
