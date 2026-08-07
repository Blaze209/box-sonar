package com.box.android.base.compose.dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxAlertDialogWithIcon.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BoxAlertDialogWithIconKt {
    public static final ComposableSingletons$BoxAlertDialogWithIconKt INSTANCE = new ComposableSingletons$BoxAlertDialogWithIconKt();

    /* JADX INFO: renamed from: lambda$-1060935319, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f175lambda$1060935319 = ComposableLambdaKt.composableLambdaInstance(-1060935319, false, new Function2() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxAlertDialogWithIconKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BoxAlertDialogWithIconKt.lambda__1060935319$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1060935319$base_generalProdRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m11716getLambda$1060935319$base_generalProdRelease() {
        return f175lambda$1060935319;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1060935319$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C82@2699L3,86@2840L3,77@2432L474:BoxAlertDialogWithIcon.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1060935319, i, -1, "com.box.android.base.compose.dialog.ComposableSingletons$BoxAlertDialogWithIconKt.lambda$-1060935319.<anonymous> (BoxAlertDialogWithIcon.kt:77)");
            }
            int i2 = R.string.microsoft_office;
            int i3 = R.string.office_install_title;
            int i4 = R.drawable.promoted_partner_app_logo_office;
            ComposerKt.sourceInformationMarkerStart(composer, -1651583540, "CC(remember):BoxAlertDialogWithIcon.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxAlertDialogWithIconKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, R.string.yes, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1651579028, "CC(remember):BoxAlertDialogWithIcon.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.dialog.ComposableSingletons$BoxAlertDialogWithIconKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon(i2, i3, i4, textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.no, 1, null), null, composer, 0, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
