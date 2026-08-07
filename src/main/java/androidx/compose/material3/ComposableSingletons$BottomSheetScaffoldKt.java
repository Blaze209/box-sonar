package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$BottomSheetScaffoldKt {
    public static final ComposableSingletons$BottomSheetScaffoldKt INSTANCE = new ComposableSingletons$BottomSheetScaffoldKt();
    private static Function2<Composer, Integer, Unit> lambda$1392012807 = ComposableLambdaKt.composableLambdaInstance(1392012807, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BottomSheetScaffoldKt.lambda_1392012807$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<SnackbarHostState, Composer, Integer, Unit> lambda$1768941633 = ComposableLambdaKt.composableLambdaInstance(1768941633, false, new Function3() { // from class: androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BottomSheetScaffoldKt.lambda_1768941633$lambda$0((SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-788244078, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f97lambda$788244078 = ComposableLambdaKt.composableLambdaInstance(-788244078, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BottomSheetScaffoldKt.lambda__788244078$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-788244078$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3091getLambda$788244078$material3() {
        return f97lambda$788244078;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1392012807$material3() {
        return lambda$1392012807;
    }

    public final Function3<SnackbarHostState, Composer, Integer, Unit> getLambda$1768941633$material3() {
        return lambda$1768941633;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1392012807$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C130@7072L12:BottomSheetScaffold.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1392012807, i, -1, "androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.lambda$1392012807.<anonymous> (BottomSheetScaffold.kt:130)");
            }
            BottomSheetDefaults.INSTANCE.m2812DragHandlelgZ2HuY(null, 0.0f, 0.0f, null, 0L, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1768941633$lambda$0(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(it)133@7235L16:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i |= composer.changed(snackbarHostState) ? 4 : 2;
        }
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1768941633, i, -1, "androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.lambda$1768941633.<anonymous> (BottomSheetScaffold.kt:133)");
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
    public static final Unit lambda__788244078$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BottomSheetScaffold.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-788244078, i, -1, "androidx.compose.material3.ComposableSingletons$BottomSheetScaffoldKt.lambda$-788244078.<anonymous> (BottomSheetScaffold.kt:436)");
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
