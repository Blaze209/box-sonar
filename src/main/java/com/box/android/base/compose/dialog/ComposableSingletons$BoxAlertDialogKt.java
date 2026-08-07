package com.box.android.base.compose.dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxAlertDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxAlertDialogKt {
    public static final ComposableSingletons$BoxAlertDialogKt INSTANCE = new ComposableSingletons$BoxAlertDialogKt();
    private static Function2<Composer, Integer, Unit> lambda$1358145865 = ComposableLambdaKt.composableLambdaInstance(1358145865, false, new Function2() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxAlertDialogKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAlertDialogKt.lambda_1358145865$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1358145865$base_generalProdRelease() {
        return lambda$1358145865;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1358145865$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C69@2296L3,73@2437L3,65@2066L437:BoxAlertDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1358145865, i, -1, "com.box.android.base.compose.dialog.ComposableSingletons$BoxAlertDialogKt.lambda$1358145865.<anonymous> (BoxAlertDialog.kt:65)");
            }
            int i2 = R.string.end_collaboration_confirmation_title;
            int i3 = R.string.end_collaboration_confirmation_text;
            ComposerKt.sourceInformationMarkerStart(composer, -491874036, "CC(remember):BoxAlertDialog.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxAlertDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, R.string.yes, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -491869524, "CC(remember):BoxAlertDialog.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxAlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i2, i3, textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.no, 1, null), null, null, 0L, 0L, composer, 0, PsExtractor.VIDEO_STREAM_MASK);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
