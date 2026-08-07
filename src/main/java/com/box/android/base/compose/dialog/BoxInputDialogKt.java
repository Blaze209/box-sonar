package com.box.android.base.compose.dialog;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.model.DialogButtonsConfig;
import com.box.android.base.compose.textfield.BoxTextFieldKt;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxInputDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"BoxInputDialog", "", "title", "", "label", ReactTextInputShadowNode.PROP_PLACEHOLDER, StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "onValueChanged", "Lkotlin/Function1;", "value", "confirmButtonItem", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "dismissButtonItem", "description", "errorMessage", "extraContent", "Landroidx/compose/runtime/Composable;", "initialFocus", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/runtime/Composer;III)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxInputDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxInputDialog$lambda$2(String str, String str2, String str3, Function0 function0, Function1 function1, String str4, ButtonItem.TextButtonItem textButtonItem, ButtonItem.TextButtonItem textButtonItem2, String str5, String str6, Function2 function2, boolean z, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, int i, int i2, int i3, Composer composer, int i4) {
        BoxInputDialog(str, str2, str3, function0, function1, str4, textButtonItem, textButtonItem2, str5, str6, function2, z, keyboardOptions, keyboardActions, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static final void BoxInputDialog(final String title, final String label, final String placeholder, final Function0<Unit> onDismiss, final Function1<? super String, Unit> onValueChanged, final String value, final ButtonItem.TextButtonItem confirmButtonItem, final ButtonItem.TextButtonItem dismissButtonItem, String str, String str2, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        String str3;
        int i5;
        int i6;
        int i7;
        final String str4;
        final Function2<? super Composer, ? super Integer, Unit> function3;
        final KeyboardOptions keyboardOptions2;
        final String str5;
        Composer composer2;
        final boolean z2;
        final KeyboardActions keyboardActions2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onValueChanged, "onValueChanged");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(confirmButtonItem, "confirmButtonItem");
        Intrinsics.checkNotNullParameter(dismissButtonItem, "dismissButtonItem");
        Composer composerStartRestartGroup = composer.startRestartGroup(-202099473);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxInputDialog)N(title,label,placeholder,onDismiss,onValueChanged,value,confirmButtonItem,dismissButtonItem,description,errorMessage,extraContent,initialFocus,keyboardOptions,keyboardActions)43@1564L900,36@1363L181,34@1298L1379:BoxInputDialog.kt#fwd9q");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(label) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(placeholder) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onDismiss) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onValueChanged) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(value) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(confirmButtonItem) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(dismissButtonItem) ? 8388608 : 4194304;
        }
        int i8 = i3 & 256;
        if (i8 != 0) {
            i4 |= 100663296;
            str3 = str;
        } else {
            str3 = str;
            if ((i & 100663296) == 0) {
                i4 |= composerStartRestartGroup.changed(str3) ? 67108864 : 33554432;
            }
        }
        int i9 = i3 & 512;
        if (i9 != 0) {
            i4 |= 805306368;
        } else if ((i & 805306368) == 0) {
            i4 |= composerStartRestartGroup.changed(str2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i10 = i3 & 1024;
        if (i10 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = i2 | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
        } else {
            i5 = i2;
        }
        int i11 = i3 & 2048;
        if (i11 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        int i12 = i5;
        int i13 = i3 & 4096;
        if (i13 != 0) {
            i6 = i12 | 384;
        } else if ((i2 & 384) == 0) {
            i6 = i12 | (composerStartRestartGroup.changed(keyboardOptions) ? 256 : 128);
        } else {
            i6 = i12;
        }
        int i14 = i3 & 8192;
        if (i14 != 0) {
            i7 = i6 | 3072;
        } else {
            int i15 = i6;
            if ((i2 & 3072) == 0) {
                i15 |= composerStartRestartGroup.changed(keyboardActions) ? 2048 : 1024;
            }
            i7 = i15;
        }
        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i7 & 1171) == 1170) ? false : true, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            str4 = str2;
            function3 = function2;
            keyboardOptions2 = keyboardOptions;
            str5 = str3;
            composer2 = composerStartRestartGroup;
            z2 = z;
            keyboardActions2 = keyboardActions;
        } else {
            final String str6 = i8 != 0 ? null : str3;
            final String str7 = i9 != 0 ? null : str2;
            final Function2<? super Composer, ? super Integer, Unit> function4 = i10 != 0 ? null : function2;
            final boolean z3 = i11 != 0 ? false : z;
            KeyboardOptions keyboardOptions3 = i13 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
            final KeyboardActions keyboardActions3 = i14 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-202099473, i4, i7, "com.box.android.base.compose.dialog.BoxInputDialog (BoxInputDialog.kt:33)");
            }
            final KeyboardOptions keyboardOptions4 = keyboardOptions3;
            int i16 = i4;
            String str8 = str6;
            String str9 = str7;
            boolean z4 = z3;
            KeyboardActions keyboardActions4 = keyboardActions3;
            Function2<? super Composer, ? super Integer, Unit> function5 = function4;
            BoxDialogKt.m11710BoxDialog0S3VyRs(onDismiss, ComposableLambdaKt.rememberComposableLambda(-1462910616, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxInputDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxInputDialogKt.BoxInputDialog$lambda$0(str6, value, onValueChanged, label, placeholder, str7, z3, keyboardOptions4, keyboardActions3, function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), new DialogButtonsConfig.PositiveAndNegativeButtons(confirmButtonItem, dismissButtonItem), null, null, title, null, ComposableLambdaKt.rememberComposableLambda(-1988277522, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxInputDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxInputDialogKt.BoxInputDialog$lambda$1(title, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), 0L, 0L, composerStartRestartGroup, ((i16 >> 9) & 14) | 12582960 | ((i16 << 15) & 458752), 856);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            str5 = str8;
            str4 = str9;
            function3 = function5;
            z2 = z4;
            keyboardOptions2 = keyboardOptions4;
            keyboardActions2 = keyboardActions4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxInputDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxInputDialogKt.BoxInputDialog$lambda$2(title, label, placeholder, onDismiss, onValueChanged, value, confirmButtonItem, dismissButtonItem, str5, str4, function3, z2, keyboardOptions2, keyboardActions2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxInputDialog$lambda$1(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C40@1503L6,37@1377L157:BoxInputDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1988277522, i, -1, "com.box.android.base.compose.dialog.BoxInputDialog.<anonymous> (BoxInputDialog.kt:37)");
            }
            TextKt.m4494TextNvy7gAk(str, null, BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium20(), composer, 0, 12582912, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxInputDialog$lambda$0(String str, String str2, Function1 function1, String str3, String str4, String str5, boolean z, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, Function2 function2, Composer composer, int i) {
        int i2;
        int i3;
        ComposerKt.sourceInformation(composer, "C44@1578L876:BoxInputDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1462910616, i, -1, "com.box.android.base.compose.dialog.BoxInputDialog.<anonymous> (BoxInputDialog.kt:44)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1018960768, "C52@1878L483:BoxInputDialog.kt#fwd9q");
            if (str == null) {
                composer.startReplaceGroup(1018955310);
                composer.endReplaceGroup();
                i3 = 1;
                i2 = 0;
            } else {
                composer.startReplaceGroup(1018955311);
                ComposerKt.sourceInformation(composer, "*49@1793L6,46@1642L201");
                i2 = 0;
                i3 = 1;
                TextKt.m4494TextNvy7gAk(str, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null), BoxTheme.INSTANCE.getColors(composer, 6).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 262136);
                composer.endReplaceGroup();
            }
            BoxTextFieldKt.BoxTextField(str2, function1, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i3, null), false, false, str3, str4, str5, z, 0, 0, keyboardOptions, keyboardActions, composer, 384, 0, 1560);
            if (function2 == null) {
                composer.startReplaceGroup(1019718995);
            } else {
                composer.startReplaceGroup(1019718996);
                ComposerKt.sourceInformation(composer, "*65@2418L4");
                function2.invoke(composer, Integer.valueOf(i2));
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
