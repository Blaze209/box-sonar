package com.box.android.base;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FeatureFlipsToggleFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$FeatureFlipsToggleFragmentKt {
    public static final ComposableSingletons$FeatureFlipsToggleFragmentKt INSTANCE = new ComposableSingletons$FeatureFlipsToggleFragmentKt();

    /* JADX INFO: renamed from: lambda$-1553004366, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f165lambda$1553004366 = ComposableLambdaKt.composableLambdaInstance(-1553004366, false, new Function2() { // from class: com.box.android.base.ComposableSingletons$FeatureFlipsToggleFragmentKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FeatureFlipsToggleFragmentKt.lambda__1553004366$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1553004366$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11341getLambda$1553004366$base_generalProdRelease() {
        return f165lambda$1553004366;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1553004366$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C151@5777L29:FeatureFlipsToggleFragment.kt#i3t43k");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1553004366, i, -1, "com.box.android.base.ComposableSingletons$FeatureFlipsToggleFragmentKt.lambda$-1553004366.<anonymous> (FeatureFlipsToggleFragment.kt:151)");
            }
            TextKt.m4494TextNvy7gAk("Metro URL (host:port)", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
