package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SegmentedButton.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$SegmentedButtonKt {
    public static final ComposableSingletons$SegmentedButtonKt INSTANCE = new ComposableSingletons$SegmentedButtonKt();
    private static Function2<Composer, Integer, Unit> lambda$1863131183 = ComposableLambdaKt.composableLambdaInstance(1863131183, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$SegmentedButtonKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SegmentedButtonKt.lambda_1863131183$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1863131183$material3() {
        return lambda$1863131183;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1863131183$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C633@27874L12:SegmentedButton.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1863131183, i, -1, "androidx.compose.material3.ComposableSingletons$SegmentedButtonKt.lambda$1863131183.<anonymous> (SegmentedButton.kt:633)");
            }
            SegmentedButtonDefaults.INSTANCE.ActiveIcon(composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
