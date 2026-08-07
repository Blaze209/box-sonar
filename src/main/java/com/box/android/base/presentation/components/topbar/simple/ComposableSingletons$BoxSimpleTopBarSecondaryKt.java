package com.box.android.base.presentation.components.topbar.simple;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxSimpleTopBarSecondary.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxSimpleTopBarSecondaryKt {
    public static final ComposableSingletons$BoxSimpleTopBarSecondaryKt INSTANCE = new ComposableSingletons$BoxSimpleTopBarSecondaryKt();
    private static Function2<Composer, Integer, Unit> lambda$878778035 = ComposableLambdaKt.composableLambdaInstance(878778035, false, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.ComposableSingletons$BoxSimpleTopBarSecondaryKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxSimpleTopBarSecondaryKt.lambda_878778035$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$878778035$base_generalProdRelease() {
        return lambda$878778035;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_878778035$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BoxSimpleTopBarSecondary.kt#osoi5s");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(878778035, i, -1, "com.box.android.base.presentation.components.topbar.simple.ComposableSingletons$BoxSimpleTopBarSecondaryKt.lambda$878778035.<anonymous> (BoxSimpleTopBarSecondary.kt:26)");
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
