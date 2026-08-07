package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ListItemKt {
    public static final ComposableSingletons$ListItemKt INSTANCE = new ComposableSingletons$ListItemKt();

    /* JADX INFO: renamed from: lambda$-489887388, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f98lambda$489887388 = ComposableLambdaKt.composableLambdaInstance(-489887388, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$ListItemKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ListItemKt.lambda__489887388$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1629163587 = ComposableLambdaKt.composableLambdaInstance(1629163587, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$ListItemKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ListItemKt.lambda_1629163587$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-546752734, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f99lambda$546752734 = ComposableLambdaKt.composableLambdaInstance(-546752734, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$ListItemKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ListItemKt.lambda__546752734$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1572298241 = ComposableLambdaKt.composableLambdaInstance(1572298241, false, new Function2() { // from class: androidx.compose.material3.ComposableSingletons$ListItemKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ListItemKt.lambda_1572298241$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-489887388$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3096getLambda$489887388$material3() {
        return f98lambda$489887388;
    }

    /* JADX INFO: renamed from: getLambda$-546752734$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3097getLambda$546752734$material3() {
        return f99lambda$546752734;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1572298241$material3() {
        return lambda$1572298241;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1629163587$material3() {
        return lambda$1629163587;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1572298241$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1572298241, i, -1, "androidx.compose.material3.ComposableSingletons$ListItemKt.lambda$1572298241.<anonymous> (ListItem.kt:733)");
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
    public static final Unit lambda_1629163587$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1629163587, i, -1, "androidx.compose.material3.ComposableSingletons$ListItemKt.lambda$1629163587.<anonymous> (ListItem.kt:733)");
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
    public static final Unit lambda__489887388$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-489887388, i, -1, "androidx.compose.material3.ComposableSingletons$ListItemKt.lambda$-489887388.<anonymous> (ListItem.kt:733)");
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
    public static final Unit lambda__546752734$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-546752734, i, -1, "androidx.compose.material3.ComposableSingletons$ListItemKt.lambda$-546752734.<anonymous> (ListItem.kt:733)");
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
