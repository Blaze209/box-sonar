package com.box.android.base.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SimpleBottomSheet.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SimpleBottomSheetKt {
    public static final ComposableSingletons$SimpleBottomSheetKt INSTANCE = new ComposableSingletons$SimpleBottomSheetKt();
    private static Function2<Composer, Integer, Unit> lambda$541026718 = ComposableLambdaKt.composableLambdaInstance(541026718, false, new Function2() { // from class: com.box.android.base.compose.ComposableSingletons$SimpleBottomSheetKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SimpleBottomSheetKt.lambda_541026718$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$541026718$base_generalProdRelease() {
        return lambda$541026718;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_541026718$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C141@6208L48:SimpleBottomSheet.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(541026718, i, -1, "com.box.android.base.compose.ComposableSingletons$SimpleBottomSheetKt.lambda$541026718.<anonymous> (SimpleBottomSheet.kt:141)");
            }
            BoxKt.Box(SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(32), Dp.m9687constructorimpl(4)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
