package com.box.android.base.compose.progressbar;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxCircularProgressBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxCircularProgressBarKt {
    public static final ComposableSingletons$BoxCircularProgressBarKt INSTANCE = new ComposableSingletons$BoxCircularProgressBarKt();

    /* JADX INFO: renamed from: lambda$-1425929549, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f180lambda$1425929549 = ComposableLambdaKt.composableLambdaInstance(-1425929549, false, new Function2() { // from class: com.box.android.base.compose.progressbar.ComposableSingletons$BoxCircularProgressBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxCircularProgressBarKt.lambda__1425929549$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1425929549$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11736getLambda$1425929549$base_generalProdRelease() {
        return f180lambda$1425929549;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1425929549$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C65@2391L24:BoxCircularProgressBar.kt#s0fs70");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1425929549, i, -1, "com.box.android.base.compose.progressbar.ComposableSingletons$BoxCircularProgressBarKt.lambda$-1425929549.<anonymous> (BoxCircularProgressBar.kt:65)");
            }
            BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(null, null, 0L, 0L, 0.0f, 0, null, composer, 0, 127);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
