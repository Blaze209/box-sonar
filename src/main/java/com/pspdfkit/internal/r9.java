package com.pspdfkit.internal;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class r9 {
    public static final ComposableLambda a = ComposableLambdaKt.composableLambdaInstance(207713086, false, new Function3() { // from class: com.pspdfkit.internal.r9$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return r9.a((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public static final Unit a(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(207713086, i, -1, "com.pspdfkit.internal.views.outline.embed.ComposableSingletons$EmbeddedFilesComposableKt.lambda$207713086.<anonymous> (EmbeddedFilesComposable.kt:98)");
        }
        ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(null, 0L, 0.0f, 0L, 0, 0.0f, composer, 0, 63);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
