package com.box.android.preview.item.labels.offline;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxColorPalette;
import com.box.android.cpl.Store;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OfflineLabel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"PreviewOfflineLabel", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$State;", "Lcom/box/android/preview/item/labels/offline/PreviewOfflineLabelReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "OfflineTooltip", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OfflineLabelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineTooltip$lambda$0(Function0 function0, int i, Composer composer, int i2) {
        OfflineTooltip(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewOfflineLabel$lambda$1(Store store, int i, Composer composer, int i2) {
        PreviewOfflineLabel(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewOfflineLabel$lambda$3(Store store, int i, Composer composer, int i2) {
        PreviewOfflineLabel(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PreviewOfflineLabel(final Store<PreviewOfflineLabelReducer.State, PreviewOfflineLabelReducer.Action> store, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(1091000369);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewOfflineLabel)N(store)36@1578L29,39@1651L1034:OfflineLabel.kt#qyzkze");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1091000369, i2, -1, "com.box.android.preview.item.labels.offline.PreviewOfflineLabel (OfflineLabel.kt:35)");
            }
            PreviewOfflineLabelReducer.OfflineLabel label = PreviewOfflineLabel$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7)).getLabel();
            if (label == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.preview.item.labels.offline.OfflineLabelKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflineLabelKt.PreviewOfflineLabel$lambda$1(store, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1041825930, "C57@2302L62,50@2015L664:OfflineLabel.kt#qyzkze");
                if (!label.isTooltipVisible()) {
                    composerStartRestartGroup.startReplaceGroup(-1043510037);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1041819917);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "42@1751L66,41@1707L124,44@1872L123,44@1844L151");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1213320505, "CC(remember):OfflineLabel.kt#9igjgp");
                    int i3 = i2 & 14;
                    boolean z = i3 == 4;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.preview.item.labels.offline.OfflineLabelKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OfflineLabelKt.PreviewOfflineLabel$lambda$2$0$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    OfflineTooltip((Function0) objRememberedValue, composerStartRestartGroup, 0);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1213324434, "CC(remember):OfflineLabel.kt#9igjgp");
                    boolean z2 = i3 == 4;
                    OfflineLabelKt$PreviewOfflineLabel$1$2$1 offlineLabelKt$PreviewOfflineLabel$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z2 || offlineLabelKt$PreviewOfflineLabel$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        offlineLabelKt$PreviewOfflineLabel$1$2$1RememberedValue = new OfflineLabelKt$PreviewOfflineLabel$1$2$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(offlineLabelKt$PreviewOfflineLabel$1$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) offlineLabelKt$PreviewOfflineLabel$1$2$1RememberedValue, composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierTestTag = TestTagKt.testTag(SizeKt.m1266size3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(ShadowKt.m6412shadows4CzXII$default(Modifier.INSTANCE, Dp.m9687constructorimpl(4), RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 28, null), RoundedCornerShapeKt.getCircleShape()), BoxColorPalette.INSTANCE.m11387getLIGHT_GREEN_500d7_KjU(), null, 2, null), Dp.m9687constructorimpl(32)), "PreviewLabel:OfflineChip");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1213338133, "CC(remember):OfflineLabel.kt#9igjgp");
                boolean z3 = (i2 & 14) == 4;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.preview.item.labels.offline.OfflineLabelKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OfflineLabelKt.PreviewOfflineLabel$lambda$2$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconButtonKt.IconButton((Function0<Unit>) objRememberedValue2, modifierTestTag, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$OfflineLabelKt.INSTANCE.getLambda$827134421$preview_generalProdRelease(), composerStartRestartGroup, 1572864, 60);
                composerStartRestartGroup = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.preview.item.labels.offline.OfflineLabelKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfflineLabelKt.PreviewOfflineLabel$lambda$3(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewOfflineLabel$lambda$2$0$0(Store store) {
        store.send(PreviewOfflineLabelReducer.Action.TooltipDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewOfflineLabel$lambda$2$2$0(Store store) {
        store.send(PreviewOfflineLabelReducer.Action.LabelClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void OfflineTooltip(final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1268819563);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OfflineTooltip)N(onDismiss)70@2757L1412:OfflineLabel.kt#qyzkze");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1268819563, i2, -1, "com.box.android.preview.item.labels.offline.OfflineTooltip (OfflineLabel.kt:69)");
            }
            AndroidPopup_androidKt.m9942PopupK5zGePQ(Alignment.INSTANCE.getBottomCenter(), 0L, function0, new PopupProperties(true, false, true, false, 8, (DefaultConstructorMarker) null), ComposableSingletons$OfflineLabelKt.INSTANCE.m12833getLambda$1982599218$preview_generalProdRelease(), composerStartRestartGroup, ((i2 << 6) & 896) | 27654, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.item.labels.offline.OfflineLabelKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfflineLabelKt.OfflineTooltip$lambda$0(function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final PreviewOfflineLabelReducer.State PreviewOfflineLabel$lambda$0(State<PreviewOfflineLabelReducer.State> state) {
        return state.getValue();
    }
}
