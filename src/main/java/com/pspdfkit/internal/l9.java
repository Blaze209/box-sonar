package com.pspdfkit.internal;

import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.pspdfkit.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class l9 {
    public static final ComposableLambda a = ComposableLambdaKt.composableLambdaInstance(-562717945, false, new Function2() { // from class: com.pspdfkit.internal.l9$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return l9.b((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    public static final ComposableLambda b = ComposableLambdaKt.composableLambdaInstance(167734183, false, new Function2() { // from class: com.pspdfkit.internal.l9$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return l9.a((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public static final Unit a(Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(167734183, i, -1, "io.nutrient.internal.ui.ai.ui.ComposableSingletons$AiAssistantTopBarKt.lambda$167734183.<anonymous> (AiAssistantTopBar.kt:49)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.pspdf__ic_close, composer, 0), "", (Modifier) null, 0L, composer, Painter.$stable | 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit b(Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-562717945, i, -1, "io.nutrient.internal.ui.ai.ui.ComposableSingletons$AiAssistantTopBarKt.lambda$-562717945.<anonymous> (AiAssistantTopBar.kt:43)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__ai_assistant_title, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
