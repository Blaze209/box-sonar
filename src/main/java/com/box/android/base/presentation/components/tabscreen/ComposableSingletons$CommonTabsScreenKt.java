package com.box.android.base.presentation.components.tabscreen;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CommonTabsScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CommonTabsScreenKt {
    public static final ComposableSingletons$CommonTabsScreenKt INSTANCE = new ComposableSingletons$CommonTabsScreenKt();

    /* JADX INFO: renamed from: lambda$-946834485, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f185lambda$946834485 = ComposableLambdaKt.composableLambdaInstance(-946834485, false, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.ComposableSingletons$CommonTabsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CommonTabsScreenKt.lambda__946834485$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1549156295 = ComposableLambdaKt.composableLambdaInstance(1549156295, false, new Function2() { // from class: com.box.android.base.presentation.components.tabscreen.ComposableSingletons$CommonTabsScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CommonTabsScreenKt.lambda_1549156295$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-946834485$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11835getLambda$946834485$base_generalProdRelease() {
        return f185lambda$946834485;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1549156295$base_generalProdRelease() {
        return lambda$1549156295;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__946834485$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:CommonTabsScreen.kt#gqlnsh");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-946834485, i, -1, "com.box.android.base.presentation.components.tabscreen.ComposableSingletons$CommonTabsScreenKt.lambda$-946834485.<anonymous> (CommonTabsScreen.kt:163)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1549156295$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:CommonTabsScreen.kt#gqlnsh");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1549156295, i, -1, "com.box.android.base.presentation.components.tabscreen.ComposableSingletons$CommonTabsScreenKt.lambda$1549156295.<anonymous> (CommonTabsScreen.kt:180)");
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
