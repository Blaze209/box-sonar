package com.pspdfkit.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class p9 {
    public static final ComposableLambda a = ComposableLambdaKt.composableLambdaInstance(1558659621, false, new Function2() { // from class: com.pspdfkit.internal.p9$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return p9.a((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public static final Unit a(Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1558659621, i, -1, "com.pspdfkit.internal.ui.composables.ComposableSingletons$ComposeViewUtilKt.lambda$1558659621.<anonymous> (ComposeViewUtil.kt:20)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
