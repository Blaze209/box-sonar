package com.box.android.preview.fileactions.openin;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogWithIconKt;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.wopi.OfficeAppType;
import com.box.android.preview.wopi.WopiConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WopiDialog.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"WopiDialog", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$State;", "Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "wopiDialogAttributes", "Lcom/box/android/preview/fileactions/openin/WopiDialogAttributes;", "wopiConfig", "Lcom/box/android/preview/wopi/WopiConfiguration;", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WopiDialogKt {

    /* JADX INFO: compiled from: WopiDialog.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfficeAppType.values().length];
            try {
                iArr[OfficeAppType.OFFICE_365.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OfficeAppType.WORD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OfficeAppType.EXCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[OfficeAppType.POWERPOINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WopiDialog$lambda$2(Store store, int i, Composer composer, int i2) {
        WopiDialog(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void WopiDialog(final Store<OpenInReducer.State, OpenInReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-273336);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WopiDialog)N(store)17@718L29:WopiDialog.kt#c8t2kx");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273336, i2, -1, "com.box.android.preview.fileactions.openin.WopiDialog (WopiDialog.kt:16)");
            }
            WopiConfiguration wopiConfiguration = WopiDialog$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getWopiConfiguration();
            if (wopiConfiguration == null) {
                composerStartRestartGroup.startReplaceGroup(447163229);
            } else {
                composerStartRestartGroup.startReplaceGroup(447163230);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                WopiDialogAttributes wopiDialogAttributes = wopiDialogAttributes(wopiConfiguration);
                composerStartRestartGroup.startReplaceGroup(-262667353);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*27@1107L46,31@1307L47,22@895L534");
                int titleRes = wopiDialogAttributes.getTitleRes();
                int textRes = wopiDialogAttributes.getTextRes();
                int iconRes = wopiDialogAttributes.getIconRes();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -699909336, "CC(remember):WopiDialog.kt#9igjgp");
                int i3 = i2 & 14;
                boolean z = i3 == 4;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.fileactions.openin.WopiDialogKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return WopiDialogKt.WopiDialog$lambda$1$0$0$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue, R.string.yes, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -699902935, "CC(remember):WopiDialog.kt#9igjgp");
                boolean z2 = i3 == 4;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.preview.fileactions.openin.WopiDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return WopiDialogKt.WopiDialog$lambda$1$0$1$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxAlertDialogWithIconKt.BoxAlertDialogWithIcon(titleRes, textRes, iconRes, textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.no, 1, null), null, composerStartRestartGroup, 0, 32);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.fileactions.openin.WopiDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WopiDialogKt.WopiDialog$lambda$2(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WopiDialog$lambda$1$0$0$0(Store store) {
        store.send(OpenInReducer.Action.StartWopi.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WopiDialog$lambda$1$0$1$0(Store store) {
        store.send(OpenInReducer.Action.RejectWopi.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final WopiDialogAttributes wopiDialogAttributes(WopiConfiguration wopiConfiguration) {
        int i = WhenMappings.$EnumSwitchMapping$0[wopiConfiguration.getAppType().ordinal()];
        if (i == 1) {
            return new WopiDialogAttributes(R.drawable.promoted_partner_app_logo_office_new, R.string.microsoft_office, wopiConfiguration.isEditable() ? R.string.office_open_edit_text : R.string.office_open_text);
        }
        if (i == 2) {
            return new WopiDialogAttributes(R.drawable.promoted_partner_app_logo_word, R.string.microsoft_word, wopiConfiguration.isEditable() ? R.string.word_open_edit_text : R.string.word_open_text);
        }
        if (i == 3) {
            return new WopiDialogAttributes(R.drawable.promoted_partner_tooltip_excel, R.string.microsoft_excel, wopiConfiguration.isEditable() ? R.string.excel_open_edit_text : R.string.excel_open_text);
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return new WopiDialogAttributes(R.drawable.promoted_partner_tooltip_powerpoint, R.string.microsoft_powerpoint, wopiConfiguration.isEditable() ? R.string.powerpoint_open_edit_text : R.string.powerpoint_open_text);
    }

    private static final OpenInReducer.State WopiDialog$lambda$0(State<OpenInReducer.State> state) {
        return state.getValue();
    }
}
