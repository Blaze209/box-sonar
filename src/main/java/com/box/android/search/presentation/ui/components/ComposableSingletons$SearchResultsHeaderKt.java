package com.box.android.search.presentation.ui.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchResultsHeader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SearchResultsHeaderKt {
    public static final ComposableSingletons$SearchResultsHeaderKt INSTANCE = new ComposableSingletons$SearchResultsHeaderKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1203588223 = ComposableLambdaKt.composableLambdaInstance(1203588223, false, new Function3() { // from class: com.box.android.search.presentation.ui.components.ComposableSingletons$SearchResultsHeaderKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SearchResultsHeaderKt.lambda_1203588223$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1203588223$search_generalProdRelease() {
        return lambda$1203588223;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1203588223$lambda$0(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        ComposerKt.sourceInformation(composer, "C:SearchResultsHeader.kt#1mmsr7");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1203588223, i, -1, "com.box.android.search.presentation.ui.components.ComposableSingletons$SearchResultsHeaderKt.lambda$1203588223.<anonymous> (SearchResultsHeader.kt:65)");
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
