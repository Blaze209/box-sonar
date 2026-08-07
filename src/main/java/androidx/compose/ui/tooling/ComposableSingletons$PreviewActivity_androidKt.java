package androidx.compose.ui.tooling;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.extractor.WavUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PreviewActivity.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$PreviewActivity_androidKt {
    public static final ComposableSingletons$PreviewActivity_androidKt INSTANCE = new ComposableSingletons$PreviewActivity_androidKt();

    /* JADX INFO: renamed from: lambda$-426398407, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f156lambda$426398407 = ComposableLambdaKt.composableLambdaInstance(-426398407, false, new Function2() { // from class: androidx.compose.ui.tooling.ComposableSingletons$PreviewActivity_androidKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PreviewActivity_androidKt.lambda__426398407$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-426398407$ui_tooling, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9589getLambda$426398407$ui_tooling() {
        return f156lambda$426398407;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__426398407$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C118@5197L12:PreviewActivity.android.kt#hevd2p");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-426398407, i, -1, "androidx.compose.ui.tooling.ComposableSingletons$PreviewActivity_androidKt.lambda$-426398407.<anonymous> (PreviewActivity.android.kt:118)");
            }
            TextKt.m2665TextfLXpl1I("Next", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, 6, 0, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
