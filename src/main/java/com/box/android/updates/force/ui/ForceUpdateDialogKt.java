package com.box.android.updates.force.ui;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.updates.R;
import com.box.android.updates.force.ForceUpdateDialogConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: ForceUpdateDialog.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"ForceUpdateDialog", "", "onUpdate", "Lkotlin/Function0;", "onOpenGooglePlay", "onCloseApp", "config", "Lcom/box/android/updates/force/ForceUpdateDialogConfig;", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/box/android/updates/force/ForceUpdateDialogConfig;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app-updates_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ForceUpdateDialog$lambda$2(Function0 function0, Function0 function1, Function0 function2, ForceUpdateDialogConfig forceUpdateDialogConfig, String str, int i, int i2, Composer composer, int i3) {
        ForceUpdateDialog(function0, function1, function2, forceUpdateDialogConfig, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0091  */
    /* JADX WARN: Code duplicated, block: B:45:0x0093  */
    /* JADX WARN: Code duplicated, block: B:48:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x009e  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00da  */
    /* JADX WARN: Code duplicated, block: B:60:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:71:0x0123  */
    /* JADX WARN: Code duplicated, block: B:74:0x014f  */
    /* JADX WARN: Code duplicated, block: B:76:0x0154  */
    /* JADX WARN: Code duplicated, block: B:79:0x0160  */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    public static final void ForceUpdateDialog(final Function0<Unit> onUpdate, final Function0<Unit> onOpenGooglePlay, final Function0<Unit> onCloseApp, final ForceUpdateDialogConfig config, String str, Composer composer, final int i, final int i2) {
        int i3;
        String str2;
        int i4;
        boolean z;
        Composer composer2;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str4;
        Object objRememberedValue;
        int i5;
        int i6;
        Function0<Unit> function0;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        Intrinsics.checkNotNullParameter(onOpenGooglePlay, "onOpenGooglePlay");
        Intrinsics.checkNotNullParameter(onCloseApp, "onCloseApp");
        Intrinsics.checkNotNullParameter(config, "config");
        Composer composerStartRestartGroup = composer.startRestartGroup(-708842081);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ForceUpdateDialog)N(onUpdate,onOpenGooglePlay,onCloseApp,config,testTag)19@661L15,19@633L43,50@1496L2,39@1095L436:ForceUpdateDialog.kt#tvgx56");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onUpdate) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onOpenGooglePlay) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCloseApp) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(config) ? 2048 : 1024;
        }
        int i7 = i2 & 16;
        if (i7 == 0) {
            if ((i & 24576) == 0) {
                str2 = str;
                i3 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
            }
            i4 = i3;
            if ((i4 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str3 = str2;
            } else {
                if (i7 != 0) {
                    str4 = null;
                } else {
                    str4 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-708842081, i4, -1, "com.box.android.updates.force.ui.ForceUpdateDialog (ForceUpdateDialog.kt:17)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1702569006, "CC(remember):ForceUpdateDialog.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.updates.force.ui.ForceUpdateDialogKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BackHandlerKt.BackHandler(true, (Function0) objRememberedValue, composerStartRestartGroup, 54, 0);
                if (config.isEmmDialog()) {
                    i5 = R.string.force_update_emm_message;
                } else {
                    i5 = R.string.force_update_message;
                }
                int i8 = i5;
                if (config.isEmmDialog()) {
                    i6 = R.string.open_google_play_button;
                } else {
                    i6 = R.string.update_button;
                }
                int i9 = i6;
                if (config.isEmmDialog()) {
                    function0 = onOpenGooglePlay;
                } else {
                    function0 = onUpdate;
                }
                int i10 = R.string.force_update_title;
                ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, function0, i9, 1, null);
                ButtonItem.TextButtonItem textButtonItem2 = new ButtonItem.TextButtonItem(false, onCloseApp, R.string.close_app_button, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1702595713, "CC(remember):ForceUpdateDialog.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.updates.force.ui.ForceUpdateDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i10, i8, textButtonItem, textButtonItem2, str4, (Function0) objRememberedValue2, 0L, 0L, composer2, (57344 & i4) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 192);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.updates.force.ui.ForceUpdateDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ForceUpdateDialogKt.ForceUpdateDialog$lambda$2(onUpdate, onOpenGooglePlay, onCloseApp, config, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        str2 = str;
        i4 = i3;
        if ((i4 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            str3 = str2;
        } else {
            if (i7 != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-708842081, i4, -1, "com.box.android.updates.force.ui.ForceUpdateDialog (ForceUpdateDialog.kt:17)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1702569006, "CC(remember):ForceUpdateDialog.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.updates.force.ui.ForceUpdateDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandlerKt.BackHandler(true, (Function0) objRememberedValue, composerStartRestartGroup, 54, 0);
            if (config.isEmmDialog()) {
                i5 = R.string.force_update_emm_message;
            } else {
                i5 = R.string.force_update_message;
            }
            int i11 = i5;
            if (config.isEmmDialog()) {
                i6 = R.string.open_google_play_button;
            } else {
                i6 = R.string.update_button;
            }
            int i12 = i6;
            if (config.isEmmDialog()) {
                function0 = onOpenGooglePlay;
            } else {
                function0 = onUpdate;
            }
            int i13 = R.string.force_update_title;
            ButtonItem.TextButtonItem textButtonItem3 = new ButtonItem.TextButtonItem(false, function0, i12, 1, null);
            ButtonItem.TextButtonItem textButtonItem4 = new ButtonItem.TextButtonItem(false, onCloseApp, R.string.close_app_button, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1702595713, "CC(remember):ForceUpdateDialog.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.updates.force.ui.ForceUpdateDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i13, i11, textButtonItem3, textButtonItem4, str4, (Function0) objRememberedValue2, 0L, 0L, composer2, (57344 & i4) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str3 = str4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.updates.force.ui.ForceUpdateDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ForceUpdateDialogKt.ForceUpdateDialog$lambda$2(onUpdate, onOpenGooglePlay, onCloseApp, config, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
