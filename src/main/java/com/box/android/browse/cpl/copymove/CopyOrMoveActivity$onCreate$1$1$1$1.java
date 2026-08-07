package com.box.android.browse.cpl.copymove;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: CopyOrMoveActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CopyOrMoveActivity$onCreate$1$1$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    CopyOrMoveActivity$onCreate$1$1$1$1(Object obj) {
        super(0, obj, CopyOrMoveActivity.class, "finish", "finish()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((CopyOrMoveActivity) this.receiver).finish();
    }
}
