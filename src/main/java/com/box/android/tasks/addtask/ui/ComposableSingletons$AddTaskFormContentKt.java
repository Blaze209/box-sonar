package com.box.android.tasks.addtask.ui;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.tasks.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AddTaskFormContent.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AddTaskFormContentKt {
    public static final ComposableSingletons$AddTaskFormContentKt INSTANCE = new ComposableSingletons$AddTaskFormContentKt();
    private static Function2<Composer, Integer, Unit> lambda$1402067977 = ComposableLambdaKt.composableLambdaInstance(1402067977, false, new Function2() { // from class: com.box.android.tasks.addtask.ui.ComposableSingletons$AddTaskFormContentKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddTaskFormContentKt.lambda_1402067977$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1645604840 = ComposableLambdaKt.composableLambdaInstance(1645604840, false, new Function2() { // from class: com.box.android.tasks.addtask.ui.ComposableSingletons$AddTaskFormContentKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddTaskFormContentKt.lambda_1645604840$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1402067977$tasks_generalProdRelease() {
        return lambda$1402067977;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1645604840$tasks_generalProdRelease() {
        return lambda$1645604840;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1402067977$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C61@2584L41,61@2579L47:AddTaskFormContent.kt#184uln");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1402067977, i, -1, "com.box.android.tasks.addtask.ui.ComposableSingletons$AddTaskFormContentKt.lambda$1402067977.<anonymous> (AddTaskFormContent.kt:61)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task_message, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1645604840$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C62@2663L53,62@2658L59:AddTaskFormContent.kt#184uln");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1645604840, i, -1, "com.box.android.tasks.addtask.ui.ComposableSingletons$AddTaskFormContentKt.lambda$1645604840.<anonymous> (AddTaskFormContent.kt:62)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task_message_placeholder, composer, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
