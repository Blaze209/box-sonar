package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ModalBottomSheet.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ModalBottomSheet_androidKt {
    public static final ComposableSingletons$ModalBottomSheet_androidKt INSTANCE = new ComposableSingletons$ModalBottomSheet_androidKt();

    /* JADX INFO: renamed from: lambda$-91331245, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f100lambda$91331245 = ComposableLambdaKt.composableLambdaInstance(-91331245, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ModalBottomSheet_androidKt.lambda__91331245$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-91331245$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3100getLambda$91331245$material3() {
        return f100lambda$91331245;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__91331245$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ModalBottomSheet.android.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-91331245, i, -1, "androidx.compose.material3.ComposableSingletons$ModalBottomSheet_androidKt.lambda$-91331245.<anonymous> (ModalBottomSheet.android.kt:292)");
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
