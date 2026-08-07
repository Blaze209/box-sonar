package com.pspdfkit.internal;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class o9 {
    public static final ComposableLambda a = ComposableLambdaKt.composableLambdaInstance(-1384750673, false, new Function3() { // from class: com.pspdfkit.internal.o9$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return o9.a((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public static final Unit a(LazyItemScope lazyItemScope, Composer composer, int i) {
        lazyItemScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1384750673, i, -1, "io.nutrient.internal.ui.ai.ui.ComposableSingletons$ChatListKt.lambda$-1384750673.<anonymous> (ChatList.kt:134)");
            }
            v8.a(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
