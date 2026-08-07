package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: AppBarRow.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$AppBarRowKt {
    public static final ComposableSingletons$AppBarRowKt INSTANCE = new ComposableSingletons$AppBarRowKt();
    private static Function3<AppBarMenuState, Composer, Integer, Unit> lambda$1581062749 = ComposableLambdaKt.composableLambdaInstance(1581062749, false, new Function3() { // from class: androidx.compose.material3.ComposableSingletons$AppBarRowKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AppBarRowKt.lambda_1581062749$lambda$0((AppBarMenuState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<AppBarMenuState, Composer, Integer, Unit> getLambda$1581062749$material3() {
        return lambda$1581062749;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1581062749$lambda$0(AppBarMenuState appBarMenuState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(menuState)54@2786L34:AppBarRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1581062749, i, -1, "androidx.compose.material3.ComposableSingletons$AppBarRowKt.lambda$1581062749.<anonymous> (AppBarRow.kt:54)");
        }
        AppBarDslKt.AppBarOverflowIndicator(appBarMenuState, null, false, null, null, null, composer, i & 14, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
