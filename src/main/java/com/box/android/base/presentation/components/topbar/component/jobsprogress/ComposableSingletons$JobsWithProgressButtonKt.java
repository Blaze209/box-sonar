package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.box.android.base.compose.ComposePreviewUtilsKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: JobsWithProgressButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$JobsWithProgressButtonKt {
    public static final ComposableSingletons$JobsWithProgressButtonKt INSTANCE = new ComposableSingletons$JobsWithProgressButtonKt();
    private static Function2<Composer, Integer, Unit> lambda$212913607 = ComposableLambdaKt.composableLambdaInstance(212913607, false, new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.ComposableSingletons$JobsWithProgressButtonKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$JobsWithProgressButtonKt.lambda_212913607$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2068109878, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f188lambda$2068109878 = ComposableLambdaKt.composableLambdaInstance(-2068109878, false, new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.ComposableSingletons$JobsWithProgressButtonKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$JobsWithProgressButtonKt.lambda__2068109878$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1164367845 = ComposableLambdaKt.composableLambdaInstance(1164367845, false, new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.ComposableSingletons$JobsWithProgressButtonKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$JobsWithProgressButtonKt.lambda_1164367845$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-2068109878$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11843getLambda$2068109878$base_generalProdRelease() {
        return f188lambda$2068109878;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1164367845$base_generalProdRelease() {
        return lambda$1164367845;
    }

    public final Function2<Composer, Integer, Unit> getLambda$212913607$base_generalProdRelease() {
        return lambda$212913607;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_212913607$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C111@4306L2,102@3911L407:JobsWithProgressButton.kt#ojl5fy");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(212913607, i, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.ComposableSingletons$JobsWithProgressButtonKt.lambda$212913607.<anonymous> (JobsWithProgressButton.kt:102)");
            }
            Store storeCreateMockStore = ComposePreviewUtilsKt.createMockStore(new JobsProgressReducer.State(new JobsProgressReducer.StatusIndicationState(45.0f, JobsProgressReducer.JobsCollectiveStatus.IN_PROGRESS)));
            ComposerKt.sourceInformationMarkerStart(composer, -1548440919, "CC(remember):JobsWithProgressButton.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.ComposableSingletons$JobsWithProgressButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            JobsWithProgressButtonKt.JobsWithProgressButton((Store<JobsProgressReducer.State, JobsProgressReducer.Action>) storeCreateMockStore, (Function0<Unit>) objRememberedValue, (Modifier) null, composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2068109878$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C129@4823L2,120@4433L402:JobsWithProgressButton.kt#ojl5fy");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2068109878, i, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.ComposableSingletons$JobsWithProgressButtonKt.lambda$-2068109878.<anonymous> (JobsWithProgressButton.kt:120)");
            }
            Store storeCreateMockStore = ComposePreviewUtilsKt.createMockStore(new JobsProgressReducer.State(new JobsProgressReducer.StatusIndicationState(100.0f, JobsProgressReducer.JobsCollectiveStatus.ERROR)));
            ComposerKt.sourceInformationMarkerStart(composer, 1116278092, "CC(remember):JobsWithProgressButton.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.ComposableSingletons$JobsWithProgressButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            JobsWithProgressButtonKt.JobsWithProgressButton((Store<JobsProgressReducer.State, JobsProgressReducer.Action>) storeCreateMockStore, (Function0<Unit>) objRememberedValue, (Modifier) null, composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1164367845$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C147@5337L2,138@4948L401:JobsWithProgressButton.kt#ojl5fy");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1164367845, i, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.ComposableSingletons$JobsWithProgressButtonKt.lambda$1164367845.<anonymous> (JobsWithProgressButton.kt:138)");
            }
            Store storeCreateMockStore = ComposePreviewUtilsKt.createMockStore(new JobsProgressReducer.State(new JobsProgressReducer.StatusIndicationState(100.0f, JobsProgressReducer.JobsCollectiveStatus.DONE)));
            ComposerKt.sourceInformationMarkerStart(composer, -2028952441, "CC(remember):JobsWithProgressButton.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.ComposableSingletons$JobsWithProgressButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            JobsWithProgressButtonKt.JobsWithProgressButton((Store<JobsProgressReducer.State, JobsProgressReducer.Action>) storeCreateMockStore, (Function0<Unit>) objRememberedValue, (Modifier) null, composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
