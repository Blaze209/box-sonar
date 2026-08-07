package com.box.android.base.compose.dialog;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.model.DialogButtonsConfig;
import com.pspdfkit.internal.jni.NativeProcessorConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxDialogKt {
    public static final ComposableSingletons$BoxDialogKt INSTANCE = new ComposableSingletons$BoxDialogKt();
    private static Function2<Composer, Integer, Unit> lambda$569770110 = ComposableLambdaKt.composableLambdaInstance(569770110, false, new Function2() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxDialogKt.lambda_569770110$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1849433604 = ComposableLambdaKt.composableLambdaInstance(1849433604, false, new Function2() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxDialogKt.lambda_1849433604$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1811286523, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f176lambda$1811286523 = ComposableLambdaKt.composableLambdaInstance(-1811286523, false, new Function2() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxDialogKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxDialogKt.lambda__1811286523$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1811286523$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11720getLambda$1811286523$base_generalProdRelease() {
        return f176lambda$1811286523;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1849433604$base_generalProdRelease() {
        return lambda$1849433604;
    }

    public final Function2<Composer, Integer, Unit> getLambda$569770110$base_generalProdRelease() {
        return lambda$569770110;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1811286523$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C107@4768L3,111@4931L3,100@4490L607:BoxDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1811286523, i, -1, "com.box.android.base.compose.dialog.ComposableSingletons$BoxDialogKt.lambda$-1811286523.<anonymous> (BoxDialog.kt:100)");
            }
            Function2<Composer, Integer, Unit> function2 = lambda$569770110;
            ComposerKt.sourceInformationMarkerStart(composer, -1184584504, "CC(remember):BoxDialog.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, R.string.button_ok, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1184579288, "CC(remember):BoxDialog.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxDialogKt.m11710BoxDialog0S3VyRs(null, function2, new DialogButtonsConfig.PositiveAndNegativeButtons(textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.button_cancel, 1, null)), null, null, null, null, lambda$1849433604, 0L, 0L, composer, 12582966, 888);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_569770110$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C103@4578L15:BoxDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(569770110, i, -1, "com.box.android.base.compose.dialog.ComposableSingletons$BoxDialogKt.lambda$569770110.<anonymous> (BoxDialog.kt:103)");
            }
            TextKt.m4494TextNvy7gAk("Content", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1849433604$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C116@5060L13:BoxDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1849433604, i, -1, "com.box.android.base.compose.dialog.ComposableSingletons$BoxDialogKt.lambda$1849433604.<anonymous> (BoxDialog.kt:116)");
            }
            TextKt.m4494TextNvy7gAk(NativeProcessorConfiguration.METADATA_TITLE, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
