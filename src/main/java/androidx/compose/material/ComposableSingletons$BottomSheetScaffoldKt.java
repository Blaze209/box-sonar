package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$BottomSheetScaffoldKt {
    public static final ComposableSingletons$BottomSheetScaffoldKt INSTANCE = new ComposableSingletons$BottomSheetScaffoldKt();
    private static Function3<SnackbarHostState, Composer, Integer, Unit> lambda$937349512 = ComposableLambdaKt.composableLambdaInstance(937349512, false, new Function3() { // from class: androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BottomSheetScaffoldKt.lambda_937349512$lambda$0((SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-505419337, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f67lambda$505419337 = ComposableLambdaKt.composableLambdaInstance(-505419337, false, new Function2() { // from class: androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BottomSheetScaffoldKt.lambda__505419337$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$687232378 = ComposableLambdaKt.composableLambdaInstance(687232378, false, new Function2() { // from class: androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BottomSheetScaffoldKt.lambda_687232378$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-505419337$material, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2365getLambda$505419337$material() {
        return f67lambda$505419337;
    }

    public final Function2<Composer, Integer, Unit> getLambda$687232378$material() {
        return lambda$687232378;
    }

    public final Function3<SnackbarHostState, Composer, Integer, Unit> getLambda$937349512$material() {
        return lambda$937349512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_937349512$lambda$0(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(it)324@13537L16:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 6) == 0) {
            i |= composer.changed(snackbarHostState) ? 4 : 2;
        }
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(937349512, i, -1, "androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt.lambda$937349512.<anonymous> (BottomSheetScaffold.kt:324)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, null, null, composer, i & 14, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__505419337$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BottomSheetScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-505419337, i, -1, "androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt.lambda$-505419337.<anonymous> (BottomSheetScaffold.kt:473)");
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
    public static final Unit lambda_687232378$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BottomSheetScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(687232378, i, -1, "androidx.compose.material.ComposableSingletons$BottomSheetScaffoldKt.lambda$687232378.<anonymous> (BottomSheetScaffold.kt:476)");
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
