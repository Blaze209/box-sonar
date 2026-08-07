package com.box.android.base.compose.dialog;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import com.box.android.base.R;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.model.DialogButtonsConfig;
import com.box.android.base.compose.textfield.BoxTextFieldKt;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PasswordEnterDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"PasswordInputDialog", "", "invalidPassword", "", "onPasswordSubmitted", "Lkotlin/Function1;", "", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease", "passwordEntered"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PasswordEnterDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordInputDialog$lambda$5(boolean z, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        PasswordInputDialog(z, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void PasswordInputDialog(boolean z, final Function1<? super String, Unit> onPasswordSubmitted, final Function0<Unit> onDismiss, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        final boolean z3;
        Intrinsics.checkNotNullParameter(onPasswordSubmitted, "onPasswordSubmitted");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(360454081);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PasswordInputDialog)N(invalidPassword,onPasswordSubmitted,onDismiss)23@1042L31,50@2215L47,36@1495L519,25@1079L1444:PasswordEnterDialog.kt#fwd9q");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPasswordSubmitted) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z3 = z2;
        } else {
            final boolean z4 = i4 != 0 ? false : z2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(360454081, i3, -1, "com.box.android.base.compose.dialog.PasswordInputDialog (PasswordEnterDialog.kt:22)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1495974336, "CC(remember):PasswordEnterDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = R.string.alert_dialog_ok;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1495936784, "CC(remember):PasswordEnterDialog.kt#9igjgp");
            boolean z5 = (i3 & 112) == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.dialog.PasswordEnterDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PasswordEnterDialogKt.PasswordInputDialog$lambda$3$0(onPasswordSubmitted, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            z3 = z4;
            BoxDialogKt.m11710BoxDialog0S3VyRs(onDismiss, ComposableLambdaKt.rememberComposableLambda(-173380486, true, new Function2() { // from class: com.box.android.base.compose.dialog.PasswordEnterDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PasswordEnterDialogKt.PasswordInputDialog$lambda$4(z4, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), new DialogButtonsConfig.PositiveAndNegativeButtons(new ButtonItem.TextButtonItem(true, (Function0) objRememberedValue2, i5), new ButtonItem.TextButtonItem(true, onDismiss, R.string.alert_dialog_cancel)), null, "PasswordInputDialog", null, null, ComposableSingletons$PasswordEnterDialogKt.INSTANCE.m11722getLambda$641322112$base_generalProdRelease(), 0L, 0L, composerStartRestartGroup, ((i3 >> 6) & 14) | 12607536, 872);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.PasswordEnterDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PasswordEnterDialogKt.PasswordInputDialog$lambda$5(z3, onPasswordSubmitted, onDismiss, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String PasswordInputDialog$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordInputDialog$lambda$4(boolean z, final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C39@1594L24,41@1736L33,37@1509L495:PasswordEnterDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-173380486, i, -1, "com.box.android.base.compose.dialog.PasswordInputDialog.<anonymous> (PasswordEnterDialog.kt:37)");
            }
            String strPasswordInputDialog$lambda$1 = PasswordInputDialog$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, 885080690, "CC(remember):PasswordEnterDialog.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.dialog.PasswordEnterDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PasswordEnterDialogKt.PasswordInputDialog$lambda$4$0$0(mutableState, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            String strStringResource = null;
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), "PasswordInputTextField");
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.password, composer, 0);
            if (z) {
                composer.startReplaceGroup(885087939);
                ComposerKt.sourceInformation(composer, "42@1820L41");
                strStringResource = StringResources_androidKt.stringResource(R.string.invalid_password, composer, 0);
            } else {
                composer.startReplaceGroup(1667967811);
            }
            composer.endReplaceGroup();
            BoxTextFieldKt.BoxTextField(strPasswordInputDialog$lambda$1, function1, modifierTestTag, false, false, null, strStringResource2, strStringResource, false, 0, 1, new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m9335getPasswordPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (DefaultConstructorMarker) null), null, composer, 432, 54, 4920);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordInputDialog$lambda$4$0$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordInputDialog$lambda$3$0(Function1 function1, MutableState mutableState) {
        function1.invoke(PasswordInputDialog$lambda$1(mutableState));
        return Unit.INSTANCE;
    }
}
