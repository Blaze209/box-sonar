package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$AppBarKt {
    public static final ComposableSingletons$AppBarKt INSTANCE = new ComposableSingletons$AppBarKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$269254275 = ComposableLambdaKt.composableLambdaInstance(269254275, false, new Function3() { // from class: androidx.compose.material.ComposableSingletons$AppBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AppBarKt.lambda_269254275$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1260131259 = ComposableLambdaKt.composableLambdaInstance(1260131259, false, new Function3() { // from class: androidx.compose.material.ComposableSingletons$AppBarKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AppBarKt.lambda_1260131259$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1260131259$material() {
        return lambda$1260131259;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$269254275$material() {
        return lambda$269254275;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_269254275$lambda$0(RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:AppBar.kt#jmzs0o");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(269254275, i, -1, "androidx.compose.material.ComposableSingletons$AppBarKt.lambda$269254275.<anonymous> (AppBar.kt:88)");
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
    public static final Unit lambda_1260131259$lambda$0(RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:AppBar.kt#jmzs0o");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1260131259, i, -1, "androidx.compose.material.ComposableSingletons$AppBarKt.lambda$1260131259.<anonymous> (AppBar.kt:164)");
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
