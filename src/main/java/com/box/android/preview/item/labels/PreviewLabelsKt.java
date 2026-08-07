package com.box.android.preview.item.labels;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.box.android.cpl.Store;
import com.box.android.preview.item.labels.classification.ClassificationLabelKt;
import com.box.android.preview.item.labels.offline.OfflineLabelKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: PreviewLabels.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"PreviewLabels", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$State;", "Lcom/box/android/preview/item/labels/ItemPreviewLabelsReducer$Action;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewLabelsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewLabels$lambda$1(Store store, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PreviewLabels(store, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void PreviewLabels(final Store<ItemPreviewLabelsReducer.State, ItemPreviewLabelsReducer.Action> store, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1208777629);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewLabels)N(store,modifier)17@763L362:PreviewLabels.kt#f7mc57");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1208777629, i3, -1, "com.box.android.preview.item.labels.PreviewLabels (PreviewLabels.kt:16)");
            }
            Arrangement.Horizontal horizontalM1074spacedByD5KLDUw = Arrangement.INSTANCE.m1074spacedByD5KLDUw(Dp.m9687constructorimpl(12), Alignment.INSTANCE.getCenterHorizontally());
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM1074spacedByD5KLDUw, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2026835716, "C22@1007L15,22@959L65,23@1095L22,23@1033L86:PreviewLabels.kt#f7mc57");
            PreviewLabelsKt$PreviewLabels$1$1 previewLabelsKt$PreviewLabels$1$1 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.labels.PreviewLabelsKt$PreviewLabels$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((ItemPreviewLabelsReducer.State) obj).getOffline();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 350261590, "CC(remember):PreviewLabels.kt#9igjgp");
            PreviewLabelsKt$PreviewLabels$1$2$1 previewLabelsKt$PreviewLabels$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (previewLabelsKt$PreviewLabels$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                previewLabelsKt$PreviewLabels$1$2$1RememberedValue = PreviewLabelsKt$PreviewLabels$1$2$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(previewLabelsKt$PreviewLabels$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            OfflineLabelKt.PreviewOfflineLabel(store.scope(previewLabelsKt$PreviewLabels$1$1, (Function1) ((KFunction) previewLabelsKt$PreviewLabels$1$2$1RememberedValue)), composerStartRestartGroup, 0);
            PreviewLabelsKt$PreviewLabels$1$3 previewLabelsKt$PreviewLabels$1$3 = new PropertyReference1Impl() { // from class: com.box.android.preview.item.labels.PreviewLabelsKt$PreviewLabels$1$3
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((ItemPreviewLabelsReducer.State) obj).getClassification();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 350264413, "CC(remember):PreviewLabels.kt#9igjgp");
            PreviewLabelsKt$PreviewLabels$1$4$1 previewLabelsKt$PreviewLabels$1$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (previewLabelsKt$PreviewLabels$1$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                previewLabelsKt$PreviewLabels$1$4$1RememberedValue = PreviewLabelsKt$PreviewLabels$1$4$1.INSTANCE;
                composerStartRestartGroup.updateRememberedValue(previewLabelsKt$PreviewLabels$1$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ClassificationLabelKt.PreviewClassificationLabel(store.scope(previewLabelsKt$PreviewLabels$1$3, (Function1) ((KFunction) previewLabelsKt$PreviewLabels$1$4$1RememberedValue)), null, composerStartRestartGroup, 0, 2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.item.labels.PreviewLabelsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewLabelsKt.PreviewLabels$lambda$1(store, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
