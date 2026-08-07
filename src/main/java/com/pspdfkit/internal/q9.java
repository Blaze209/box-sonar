package com.pspdfkit.internal;

import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.pspdfkit.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class q9 {
    public static final ComposableLambda a = ComposableLambdaKt.composableLambdaInstance(673890033, false, new Function2() { // from class: com.pspdfkit.internal.q9$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return q9.a((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public static final Unit a(Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(673890033, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.ComposableSingletons$CustomStampCreatorComposableKt.lambda$673890033.<anonymous> (CustomStampCreatorComposable.kt:121)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.pspdf__ic_arrow_back, composer, 0), "", (Modifier) null, 0L, composer, Painter.$stable | 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
