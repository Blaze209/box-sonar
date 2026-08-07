package com.box.android.base.compose.dialog;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxDismissAlertDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxDismissAlertDialogKt {
    public static final ComposableSingletons$BoxDismissAlertDialogKt INSTANCE = new ComposableSingletons$BoxDismissAlertDialogKt();

    /* JADX INFO: renamed from: lambda$-51044344, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f177lambda$51044344 = ComposableLambdaKt.composableLambdaInstance(-51044344, false, new Function2() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxDismissAlertDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxDismissAlertDialogKt.lambda__51044344$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$683735905 = ComposableLambdaKt.composableLambdaInstance(683735905, false, new Function2() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxDismissAlertDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxDismissAlertDialogKt.lambda_683735905$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-51044344$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11721getLambda$51044344$base_generalProdRelease() {
        return f177lambda$51044344;
    }

    public final Function2<Composer, Integer, Unit> getLambda$683735905$base_generalProdRelease() {
        return lambda$683735905;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_683735905$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@2356L3,60@2133L306:BoxDismissAlertDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(683735905, i, -1, "com.box.android.base.compose.dialog.ComposableSingletons$BoxDismissAlertDialogKt.lambda$683735905.<anonymous> (BoxDismissAlertDialog.kt:60)");
            }
            int i2 = R.string.microsoft_office;
            Function2<Composer, Integer, Unit> function2 = f177lambda$51044344;
            ComposerKt.sourceInformationMarkerStart(composer, -59784124, "CC(remember):BoxDismissAlertDialog.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxDismissAlertDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxDismissAlertDialogKt.m11712BoxDismissAlertDialogV9fs2A(i2, function2, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, R.string.alert_dialog_cancel, 1, null), null, null, 0L, composer, 48, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__51044344$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@2243L15:BoxDismissAlertDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-51044344, i, -1, "com.box.android.base.compose.dialog.ComposableSingletons$BoxDismissAlertDialogKt.lambda$-51044344.<anonymous> (BoxDismissAlertDialog.kt:63)");
            }
            TextKt.m4494TextNvy7gAk("Content", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
