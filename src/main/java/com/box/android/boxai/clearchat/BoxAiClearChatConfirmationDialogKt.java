package com.box.android.boxai.clearchat;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.boxai.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiClearChatConfirmationDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a\r\u0010\u0006\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"BoxAiClearChatConfirmationDialog", "", "onPositiveButtonClick", "Lkotlin/Function0;", "onNegativeButtonClick", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "BoxAiClearChatConfirmationDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiClearChatConfirmationDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiClearChatConfirmationDialog$lambda$0(Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        BoxAiClearChatConfirmationDialog(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiClearChatConfirmationDialogPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiClearChatConfirmationDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxAiClearChatConfirmationDialog(Function0<Unit> onPositiveButtonClick, Function0<Unit> onNegativeButtonClick, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        final Function0<Unit> function1;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onPositiveButtonClick, "onPositiveButtonClick");
        Intrinsics.checkNotNullParameter(onNegativeButtonClick, "onNegativeButtonClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1874141095);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiClearChatConfirmationDialog)N(onPositiveButtonClick,onNegativeButtonClick)24@1058L6,25@1120L6,13@547L649:BoxAiClearChatConfirmationDialog.kt#g1poit");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onPositiveButtonClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onNegativeButtonClick) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = onPositiveButtonClick;
            function1 = onNegativeButtonClick;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1874141095, i2, -1, "com.box.android.boxai.clearchat.BoxAiClearChatConfirmationDialog (BoxAiClearChatConfirmationDialog.kt:12)");
            }
            function1 = onNegativeButtonClick;
            composer2 = composerStartRestartGroup;
            function0 = onPositiveButtonClick;
            BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(R.string.box_ai_clear_chat_confirmation_title, R.string.box_ai_clear_chat_confirmation_message, new ButtonItem.TextButtonItem(false, onPositiveButtonClick, R.string.box_ai_clear_chat_confirmation_clear, 1, null), new ButtonItem.TextButtonItem(false, function1, R.string.button_cancel, 1, null), "ClearChatConfirmationDialog", null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11563getTextFieldError0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11543getPopupSecondary0d7_KjU(), composer2, 24576, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.clearchat.BoxAiClearChatConfirmationDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiClearChatConfirmationDialogKt.BoxAiClearChatConfirmationDialog$lambda$0(function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiClearChatConfirmationDialogPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(85340939);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiClearChatConfirmationDialogPreview)36@1370L147:BoxAiClearChatConfirmationDialog.kt#g1poit");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(85340939, i, -1, "com.box.android.boxai.clearchat.BoxAiClearChatConfirmationDialogPreview (BoxAiClearChatConfirmationDialog.kt:35)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiClearChatConfirmationDialogKt.INSTANCE.getLambda$1715536736$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.clearchat.BoxAiClearChatConfirmationDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiClearChatConfirmationDialogKt.BoxAiClearChatConfirmationDialogPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
