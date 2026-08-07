package com.box.android.base.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ScaffoldWithCollapsingTopBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ScaffoldWithCollapsingTopBarKt {
    public static final ComposableSingletons$ScaffoldWithCollapsingTopBarKt INSTANCE = new ComposableSingletons$ScaffoldWithCollapsingTopBarKt();
    private static Function2<Composer, Integer, Unit> lambda$934188961 = ComposableLambdaKt.composableLambdaInstance(934188961, false, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$ScaffoldWithCollapsingTopBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScaffoldWithCollapsingTopBarKt.lambda_934188961$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$934188961$base_generalProdRelease() {
        return lambda$934188961;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_934188961$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ScaffoldWithCollapsingTopBar.kt#vejmn0");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(934188961, i, -1, "com.box.android.base.compose.ComposableSingletons$ScaffoldWithCollapsingTopBarKt.lambda$934188961.<anonymous> (ScaffoldWithCollapsingTopBar.kt:36)");
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
