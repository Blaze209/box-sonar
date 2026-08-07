package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: AppBarColumn.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$AppBarColumnKt {
    public static final ComposableSingletons$AppBarColumnKt INSTANCE = new ComposableSingletons$AppBarColumnKt();
    private static Function3<AppBarMenuState, Composer, Integer, Unit> lambda$479541071 = ComposableLambdaKt.composableLambdaInstance(479541071, false, new Function3() { // from class: androidx.compose.material3.ComposableSingletons$AppBarColumnKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AppBarColumnKt.lambda_479541071$lambda$0((AppBarMenuState) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<AppBarMenuState, Composer, Integer, Unit> getLambda$479541071$material3() {
        return lambda$479541071;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_479541071$lambda$0(AppBarMenuState appBarMenuState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(menuState)52@2612L34:AppBarColumn.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(479541071, i, -1, "androidx.compose.material3.ComposableSingletons$AppBarColumnKt.lambda$479541071.<anonymous> (AppBarColumn.kt:52)");
        }
        AppBarDslKt.AppBarOverflowIndicator(appBarMenuState, null, false, null, null, null, composer, i & 14, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
