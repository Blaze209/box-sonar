package com.box.android.base.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.R;
import com.box.android.base.compose.button.BoxTextButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.common.utilities.CommonBoxUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RationaleScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\n\u001a)\u0010\u000b\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"RationaleScreen", "", "itemsStateConfig", "Lcom/box/android/base/compose/ItemsStateConfig;", "acceptRationaleText", "", "rejectRationaleText", "onAcceptRationale", "Lkotlin/Function0;", "onDenyRationale", "(Lcom/box/android/base/compose/ItemsStateConfig;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NotificationRationaleScreen", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RationaleScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationRationaleScreen$lambda$0(Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        NotificationRationaleScreen(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RationaleScreen$lambda$1(ItemsStateConfig itemsStateConfig, int i, int i2, Function0 function0, Function0 function1, int i3, Composer composer, int i4) {
        RationaleScreen(itemsStateConfig, i, i2, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    public static final void RationaleScreen(final ItemsStateConfig itemsStateConfig, int i, int i2, final Function0<Unit> onAcceptRationale, Function0<Unit> function0, Composer composer, final int i3) {
        int i4;
        int i5;
        final int i6 = i2;
        final Function0<Unit> onDenyRationale = function0;
        Intrinsics.checkNotNullParameter(itemsStateConfig, "itemsStateConfig");
        Intrinsics.checkNotNullParameter(onAcceptRationale, "onAcceptRationale");
        Intrinsics.checkNotNullParameter(onDenyRationale, "onDenyRationale");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2087213887);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RationaleScreen)N(itemsStateConfig,acceptRationaleText,rejectRationaleText,onAcceptRationale,onDenyRationale)32@1139L6,29@1057L1594:RationaleScreen.kt#vejmn0");
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(itemsStateConfig) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i6) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onAcceptRationale) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onDenyRationale) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            i5 = i;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087213887, i4, -1, "com.box.android.base.compose.RationaleScreen (RationaleScreen.kt:28)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1458770225, "C34@1219L203,34@1180L242,41@1431L1214:RationaleScreen.kt#vejmn0");
            SurfaceKt.m4323SurfaceT9BRK9s(OffsetKt.m1175offsetVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(-64), 1, null), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(183729792, true, new Function2() { // from class: com.box.android.base.compose.RationaleScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RationaleScreenKt.RationaleScreen$lambda$0$0(itemsStateConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582918, 126);
            float f = 48;
            Modifier modifierM1175offsetVpY3zN4$default = OffsetKt.m1175offsetVpY3zN4$default(boxScopeInstance.align(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenter()), 0.0f, Dp.m9687constructorimpl(f), 1, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1175offsetVpY3zN4$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565032682, "C60@2217L6,59@2153L154,48@1667L654,64@2334L301:RationaleScreen.kt#vejmn0");
            i5 = i;
            ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(true, onAcceptRationale, i5);
            Modifier modifierTestTag = TestTagKt.testTag(ClipKt.clip(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.7f), Dp.m9687constructorimpl(f)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(10))), "AcceptRationale");
            ButtonColors buttonColorsM2878textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), Color.INSTANCE.m6851getWhite0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 48, 12);
            composerStartRestartGroup = composerStartRestartGroup;
            BoxTextButtonKt.BoxTextButton(textButtonItem, modifierTestTag, buttonColorsM2878textButtonColorsro_MJ88, composerStartRestartGroup, 0, 0);
            i6 = i2;
            onDenyRationale = function0;
            BoxTextButtonKt.BoxTextButton(new ButtonItem.TextButtonItem(true, onDenyRationale, i6), TestTagKt.testTag(Modifier.INSTANCE, "RejectRationale"), null, composerStartRestartGroup, 48, 4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final int i7 = i5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.RationaleScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RationaleScreenKt.RationaleScreen$lambda$1(itemsStateConfig, i7, i6, onAcceptRationale, onDenyRationale, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RationaleScreen$lambda$0$0(ItemsStateConfig itemsStateConfig, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C35@1233L179:RationaleScreen.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(183729792, i, -1, "com.box.android.base.compose.RationaleScreen.<anonymous>.<anonymous> (RationaleScreen.kt:35)");
            }
            ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(itemsStateConfig, "RationaleScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, 0L, composer, 432, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void NotificationRationaleScreen(final Function0<Unit> onAcceptRationale, final Function0<Unit> onDenyRationale, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onAcceptRationale, "onAcceptRationale");
        Intrinsics.checkNotNullParameter(onDenyRationale, "onDenyRationale");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1735078909);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotificationRationaleScreen)N(onAcceptRationale,onDenyRationale)78@2765L426:RationaleScreen.kt#vejmn0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onAcceptRationale) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDenyRationale) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1735078909, i2, -1, "com.box.android.base.compose.NotificationRationaleScreen (RationaleScreen.kt:77)");
            }
            RationaleScreen(new ItemsStateConfig(R.drawable.activity, CommonBoxUtil.LS(R.string.notification_rationale_messasge), CommonBoxUtil.LS(R.string.notification_rationale_submessage), null, 8, null), R.string.enable_notifications, R.string.dismiss, onAcceptRationale, onDenyRationale, composerStartRestartGroup, 64512 & (i2 << 9));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.RationaleScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RationaleScreenKt.NotificationRationaleScreen$lambda$0(onAcceptRationale, onDenyRationale, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
