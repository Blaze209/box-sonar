package com.box.android.boxai.clearchat;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxAiClearChatConfirmationDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxAiClearChatConfirmationDialogKt {
    public static final ComposableSingletons$BoxAiClearChatConfirmationDialogKt INSTANCE = new ComposableSingletons$BoxAiClearChatConfirmationDialogKt();
    private static Function2<Composer, Integer, Unit> lambda$1715536736 = ComposableLambdaKt.composableLambdaInstance(1715536736, false, new Function2() { // from class: com.box.android.boxai.clearchat.ComposableSingletons$BoxAiClearChatConfirmationDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAiClearChatConfirmationDialogKt.lambda_1715536736$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1715536736$boxai_generalProdRelease() {
        return lambda$1715536736;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1715536736$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C38@1459L2,39@1499L2,37@1389L122:BoxAiClearChatConfirmationDialog.kt#g1poit");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1715536736, i, -1, "com.box.android.boxai.clearchat.ComposableSingletons$BoxAiClearChatConfirmationDialogKt.lambda$1715536736.<anonymous> (BoxAiClearChatConfirmationDialog.kt:37)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -636635806, "CC(remember):BoxAiClearChatConfirmationDialog.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.boxai.clearchat.ComposableSingletons$BoxAiClearChatConfirmationDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -636634526, "CC(remember):BoxAiClearChatConfirmationDialog.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.clearchat.ComposableSingletons$BoxAiClearChatConfirmationDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAiClearChatConfirmationDialogKt.BoxAiClearChatConfirmationDialog(function0, (Function0) objRememberedValue2, composer, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
