package com.box.android.collections.presentation.navigationmodernization.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxInputDialogKt;
import com.box.android.collections.R;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CreateCollectionDialog.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"CreateCollectionDialog", "", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "onCreate", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "collections_generalProdRelease", "collectionName"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CreateCollectionDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateCollectionDialog$lambda$5(Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        CreateCollectionDialog(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CreateCollectionDialog(Function0<Unit> function0, final Function1<? super String, Unit> onCreate, Composer composer, final int i) {
        int i2;
        final Function0<Unit> onDismiss = function0;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onCreate, "onCreate");
        Composer composerStartRestartGroup = composer.startRestartGroup(965296943);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CreateCollectionDialog)N(onDismiss,onCreate)18@698L31,22@821L42,23@881L37,24@942L37,26@1037L23,30@1210L28,37@1463L50,21@789L759:CreateCollectionDialog.kt#gddg0c");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(onDismiss) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCreate) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(965296943, i3, -1, "com.box.android.collections.presentation.navigationmodernization.component.CreateCollectionDialog (CreateCollectionDialog.kt:17)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -62570290, "CC(remember):CreateCollectionDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z = !StringsKt.isBlank(CreateCollectionDialog$lambda$1(mutableState));
            String strStringResource = StringResources_androidKt.stringResource(R.string.create_collection, composerStartRestartGroup, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.enter_a_name, composerStartRestartGroup, 0);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.enter_a_name, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -62559450, "CC(remember):CreateCollectionDialog.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.component.CreateCollectionDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateCollectionDialogKt.CreateCollectionDialog$lambda$3$0(mutableState, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strCreateCollectionDialog$lambda$1 = CreateCollectionDialog$lambda$1(mutableState);
            int i4 = R.string.create;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -62553909, "CC(remember):CreateCollectionDialog.kt#9igjgp");
            boolean z2 = (i3 & 112) == 32;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.component.CreateCollectionDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateCollectionDialogKt.CreateCollectionDialog$lambda$4$0(onCreate, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxInputDialogKt.BoxInputDialog(strStringResource, strStringResource2, strStringResource3, function0, function1, strCreateCollectionDialog$lambda$1, new ButtonItem.TextButtonItem(z, (Function0) objRememberedValue3, i4), new ButtonItem.TextButtonItem(false, onDismiss, R.string.alert_dialog_cancel, 1, null), StringResources_androidKt.stringResource(R.string.create_collection_message, composerStartRestartGroup, 0), null, null, true, null, null, composerStartRestartGroup, ((i3 << 9) & 7168) | 24576, 48, 13824);
            onDismiss = function0;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.component.CreateCollectionDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateCollectionDialogKt.CreateCollectionDialog$lambda$5(onDismiss, onCreate, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String CreateCollectionDialog$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateCollectionDialog$lambda$3$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateCollectionDialog$lambda$4$0(Function1 function1, MutableState mutableState) {
        function1.invoke(CreateCollectionDialog$lambda$1(mutableState));
        return Unit.INSTANCE;
    }
}
