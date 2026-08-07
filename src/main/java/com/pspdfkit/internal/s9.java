package com.pspdfkit.internal;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnitKt;
import com.pspdfkit.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class s9 {
    public static final ComposableLambda a = ComposableLambdaKt.composableLambdaInstance(-1439095043, false, new Function3() { // from class: com.pspdfkit.internal.s9$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return s9.a((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public static final Unit a(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1439095043, i, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.ComposableSingletons$SignatureListKt.lambda$-1439095043.<anonymous> (SignatureList.kt:102)");
        }
        TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__no_signatures, composer, 0), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, TextUnitKt.getSp(21), null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composer, 24576, 0, 261098);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
