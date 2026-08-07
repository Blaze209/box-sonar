package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ScaffoldKt {
    public static final ComposableSingletons$ScaffoldKt INSTANCE = new ComposableSingletons$ScaffoldKt();

    /* JADX INFO: renamed from: lambda$-39202156, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f102lambda$39202156 = ComposableLambdaKt.composableLambdaInstance(-39202156, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$ScaffoldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScaffoldKt.lambda__39202156$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1582488484 = ComposableLambdaKt.composableLambdaInstance(1582488484, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$ScaffoldKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScaffoldKt.lambda_1582488484$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$414328099 = ComposableLambdaKt.composableLambdaInstance(414328099, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$ScaffoldKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScaffoldKt.lambda_414328099$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1514016380, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f101lambda$1514016380 = ComposableLambdaKt.composableLambdaInstance(-1514016380, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$ScaffoldKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScaffoldKt.lambda__1514016380$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1514016380$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3101getLambda$1514016380$material3() {
        return f101lambda$1514016380;
    }

    /* JADX INFO: renamed from: getLambda$-39202156$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3102getLambda$39202156$material3() {
        return f102lambda$39202156;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1582488484$material3() {
        return lambda$1582488484;
    }

    public final Function2<Composer, Integer, Unit> getLambda$414328099$material3() {
        return lambda$414328099;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__39202156$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:Scaffold.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-39202156, i, -1, "androidx.compose.material3.ComposableSingletons$ScaffoldKt.lambda$-39202156.<anonymous> (Scaffold.kt:84)");
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
    public static final Unit lambda_1582488484$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:Scaffold.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1582488484, i, -1, "androidx.compose.material3.ComposableSingletons$ScaffoldKt.lambda$1582488484.<anonymous> (Scaffold.kt:85)");
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
    public static final Unit lambda_414328099$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:Scaffold.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(414328099, i, -1, "androidx.compose.material3.ComposableSingletons$ScaffoldKt.lambda$414328099.<anonymous> (Scaffold.kt:86)");
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
    public static final Unit lambda__1514016380$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:Scaffold.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1514016380, i, -1, "androidx.compose.material3.ComposableSingletons$ScaffoldKt.lambda$-1514016380.<anonymous> (Scaffold.kt:87)");
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
