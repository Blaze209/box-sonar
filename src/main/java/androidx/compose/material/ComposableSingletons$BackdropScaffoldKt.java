package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$BackdropScaffoldKt {
    public static final ComposableSingletons$BackdropScaffoldKt INSTANCE = new ComposableSingletons$BackdropScaffoldKt();
    private static Function3<SnackbarHostState, Composer, Integer, Unit> lambda$2057676608 = ComposableLambdaKt.composableLambdaInstance(2057676608, false, new Function3() { // from class: androidx.compose.material.ComposableSingletons$BackdropScaffoldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BackdropScaffoldKt.lambda_2057676608$lambda$0((SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<SnackbarHostState, Composer, Integer, Unit> getLambda$2057676608$material() {
        return lambda$2057676608;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2057676608$lambda$0(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(it)350@15992L16:BackdropScaffold.kt#jmzs0o");
        if ((i & 6) == 0) {
            i |= composer.changed(snackbarHostState) ? 4 : 2;
        }
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2057676608, i, -1, "androidx.compose.material.ComposableSingletons$BackdropScaffoldKt.lambda$2057676608.<anonymous> (BackdropScaffold.kt:350)");
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
}
