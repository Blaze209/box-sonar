package com.box.android.base.compose;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.SnackbarData;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwipeableSnackbarHost.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SwipeableSnackbarHostKt {
    public static final ComposableSingletons$SwipeableSnackbarHostKt INSTANCE = new ComposableSingletons$SwipeableSnackbarHostKt();
    private static Function3<SnackbarData, Composer, Integer, Unit> lambda$42799046 = ComposableLambdaKt.composableLambdaInstance(42799046, false, new Function3() { // from class: com.box.android.base.compose.ComposableSingletons$SwipeableSnackbarHostKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SwipeableSnackbarHostKt.lambda_42799046$lambda$0((SnackbarData) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1052744823, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f167lambda$1052744823 = ComposableLambdaKt.composableLambdaInstance(-1052744823, false, new Function3() { // from class: com.box.android.base.compose.ComposableSingletons$SwipeableSnackbarHostKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$SwipeableSnackbarHostKt.lambda__1052744823$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1052744823$base_generalProdRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m11623getLambda$1052744823$base_generalProdRelease() {
        return f167lambda$1052744823;
    }

    public final Function3<SnackbarData, Composer, Integer, Unit> getLambda$42799046$base_generalProdRelease() {
        return lambda$42799046;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_42799046$lambda$0(SnackbarData snackbarData, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
        ComposerKt.sourceInformation(composer, "CN(snackbarData)30@1115L31:SwipeableSnackbarHost.kt#vejmn0");
        if ((i & 6) == 0) {
            i |= composer.changed(snackbarData) ? 4 : 2;
        }
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(42799046, i, -1, "com.box.android.base.compose.ComposableSingletons$SwipeableSnackbarHostKt.lambda$42799046.<anonymous> (SwipeableSnackbarHost.kt:30)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbar(snackbarData, composer, i & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1052744823$lambda$0(RowScope SwipeToDismissBox, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(SwipeToDismissBox, "$this$SwipeToDismissBox");
        ComposerKt.sourceInformation(composer, "C:SwipeableSnackbarHost.kt#vejmn0");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1052744823, i, -1, "com.box.android.base.compose.ComposableSingletons$SwipeableSnackbarHostKt.lambda$-1052744823.<anonymous> (SwipeableSnackbarHost.kt:47)");
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
