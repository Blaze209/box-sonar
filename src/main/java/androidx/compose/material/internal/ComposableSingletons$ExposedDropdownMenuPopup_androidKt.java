package androidx.compose.material.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ExposedDropdownMenuPopup_androidKt {
    public static final ComposableSingletons$ExposedDropdownMenuPopup_androidKt INSTANCE = new ComposableSingletons$ExposedDropdownMenuPopup_androidKt();

    /* JADX INFO: renamed from: lambda$-1578637197, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f79lambda$1578637197 = ComposableLambdaKt.composableLambdaInstance(-1578637197, false, new Function2() { // from class: androidx.compose.material.internal.ComposableSingletons$ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ExposedDropdownMenuPopup_androidKt.lambda__1578637197$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1578637197$material, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2673getLambda$1578637197$material() {
        return f79lambda$1578637197;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1578637197$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ExposedDropdownMenuPopup.android.kt#mnwmf7");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1578637197, i, -1, "androidx.compose.material.internal.ComposableSingletons$ExposedDropdownMenuPopup_androidKt.lambda$-1578637197.<anonymous> (ExposedDropdownMenuPopup.android.kt:287)");
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
