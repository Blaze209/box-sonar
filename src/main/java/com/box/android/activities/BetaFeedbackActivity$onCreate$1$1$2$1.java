package com.box.android.activities;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: BetaFeedbackActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BetaFeedbackActivity$onCreate$1$1$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    BetaFeedbackActivity$onCreate$1$1$2$1(Object obj) {
        super(0, obj, BetaFeedbackActivity.class, "finishAndNotify", "finishAndNotify()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((BetaFeedbackActivity) this.receiver).finishAndNotify();
    }
}
