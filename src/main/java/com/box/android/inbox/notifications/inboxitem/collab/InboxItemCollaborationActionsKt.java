package com.box.android.inbox.notifications.inboxitem.collab;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemCollaborationActions.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"InboxItemCollaborationActions", "", "onAcceptClick", "Lkotlin/Function0;", "onDeclineClick", "modifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "InboxItemCollaborationActionsPreview", "(Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemCollaborationActionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaborationActions$lambda$1(Function0 function0, Function0 function1, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        InboxItemCollaborationActions(function0, function1, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCollaborationActionsPreview$lambda$2(int i, Composer composer, int i2) {
        InboxItemCollaborationActionsPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080  */
    /* JADX WARN: Code duplicated, block: B:42:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x008d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0092  */
    /* JADX WARN: Code duplicated, block: B:49:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:55:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:59:0x0102  */
    /* JADX WARN: Code duplicated, block: B:62:0x027c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0283  */
    /* JADX WARN: Code duplicated, block: B:67:0x028e  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemCollaborationActions(final Function0<Unit> onAcceptClick, final Function0<Unit> onDeclineClick, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        Intrinsics.checkNotNullParameter(onAcceptClick, "onAcceptClick");
        Intrinsics.checkNotNullParameter(onDeclineClick, "onDeclineClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-911346486);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemCollaborationActions)N(onAcceptClick,onDeclineClick,modifier,isEnabled)30@1151L1562:InboxItemCollaborationActions.kt#46vz6n");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onAcceptClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDeclineClick) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-911346486, i3, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActions (InboxItemCollaborationActions.kt:29)");
                    }
                    float f = 8;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1687880534, "C43@1659L6,42@1603L94,34@1260L687,61@2309L78,64@2438L6,53@1957L750:InboxItemCollaborationActions.kt#46vz6n");
                    float f2 = 32;
                    Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(f2));
                    float f3 = 16;
                    RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f3));
                    float f4 = 12;
                    float f5 = 0;
                    PaddingValues paddingValuesM1212PaddingValuesYgX7TsA = PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(f4), Dp.m9687constructorimpl(f5));
                    int i7 = (i3 & 14) | 817889328;
                    int i8 = i3 >> 3;
                    int i9 = i8 & 896;
                    Modifier modifier4 = companion;
                    boolean z5 = z2;
                    ButtonKt.Button(onAcceptClick, modifierM1252height3ABfNKs, z5, roundedCornerShapeM1573RoundedCornerShape0680j_4, ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, paddingValuesM1212PaddingValuesYgX7TsA, (MutableInteractionSource) null, ComposableSingletons$InboxItemCollaborationActionsKt.INSTANCE.m12685getLambda$2004083978$box_generalProdRelease(), composerStartRestartGroup, i7 | i9, 352);
                    ButtonKt.OutlinedButton(onDeclineClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(f2)), z5, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f3)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 14), (ButtonElevation) null, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU()), PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(f4), Dp.m9687constructorimpl(f5)), (MutableInteractionSource) null, ComposableSingletons$InboxItemCollaborationActionsKt.INSTANCE.getLambda$1097741108$box_generalProdRelease(), composerStartRestartGroup, (i8 & 14) | 817889328 | i9, 288);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActionsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return InboxItemCollaborationActionsKt.InboxItemCollaborationActions$lambda$1(onAcceptClick, onDeclineClick, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-911346486, i3, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActions (InboxItemCollaborationActions.kt:29)");
                }
                float f6 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f6));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1687880534, "C43@1659L6,42@1603L94,34@1260L687,61@2309L78,64@2438L6,53@1957L750:InboxItemCollaborationActions.kt#46vz6n");
                float f7 = 32;
                Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f6), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(f7));
                float f8 = 16;
                RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f8));
                float f9 = 12;
                float f10 = 0;
                PaddingValues paddingValuesM1212PaddingValuesYgX7TsA2 = PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(f9), Dp.m9687constructorimpl(f10));
                int i10 = (i3 & 14) | 817889328;
                int i11 = i3 >> 3;
                int i12 = i11 & 896;
                Modifier modifier5 = companion;
                boolean z6 = z2;
                ButtonKt.Button(onAcceptClick, modifierM1252height3ABfNKs2, z6, roundedCornerShapeM1573RoundedCornerShape0680j_5, ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, paddingValuesM1212PaddingValuesYgX7TsA2, (MutableInteractionSource) null, ComposableSingletons$InboxItemCollaborationActionsKt.INSTANCE.m12685getLambda$2004083978$box_generalProdRelease(), composerStartRestartGroup, i10 | i12, 352);
                ButtonKt.OutlinedButton(onDeclineClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f6), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(f7)), z6, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f8)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 14), (ButtonElevation) null, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU()), PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(f9), Dp.m9687constructorimpl(f10)), (MutableInteractionSource) null, ComposableSingletons$InboxItemCollaborationActionsKt.INSTANCE.getLambda$1097741108$box_generalProdRelease(), composerStartRestartGroup, (i11 & 14) | 817889328 | i12, 288);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActionsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemCollaborationActionsKt.InboxItemCollaborationActions$lambda$1(onAcceptClick, onDeclineClick, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-911346486, i3, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActions (InboxItemCollaborationActions.kt:29)");
                }
                float f11 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_6 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f11));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_6, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1687880534, "C43@1659L6,42@1603L94,34@1260L687,61@2309L78,64@2438L6,53@1957L750:InboxItemCollaborationActions.kt#46vz6n");
                float f12 = 32;
                Modifier modifierM1252height3ABfNKs3 = SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f11), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(f12));
                float f13 = 16;
                RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_6 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f13));
                float f14 = 12;
                float f15 = 0;
                PaddingValues paddingValuesM1212PaddingValuesYgX7TsA3 = PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(f14), Dp.m9687constructorimpl(f15));
                int i13 = (i3 & 14) | 817889328;
                int i14 = i3 >> 3;
                int i15 = i14 & 896;
                Modifier modifier6 = companion;
                boolean z7 = z2;
                ButtonKt.Button(onAcceptClick, modifierM1252height3ABfNKs3, z7, roundedCornerShapeM1573RoundedCornerShape0680j_6, ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, paddingValuesM1212PaddingValuesYgX7TsA3, (MutableInteractionSource) null, ComposableSingletons$InboxItemCollaborationActionsKt.INSTANCE.m12685getLambda$2004083978$box_generalProdRelease(), composerStartRestartGroup, i13 | i15, 352);
                ButtonKt.OutlinedButton(onDeclineClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f11), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(f12)), z7, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f13)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 14), (ButtonElevation) null, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU()), PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(f14), Dp.m9687constructorimpl(f15)), (MutableInteractionSource) null, ComposableSingletons$InboxItemCollaborationActionsKt.INSTANCE.getLambda$1097741108$box_generalProdRelease(), composerStartRestartGroup, (i14 & 14) | 817889328 | i15, 288);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z7;
                modifier3 = modifier6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActionsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemCollaborationActionsKt.InboxItemCollaborationActions$lambda$1(onAcceptClick, onDeclineClick, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                z2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-911346486, i3, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActions (InboxItemCollaborationActions.kt:29)");
            }
            float f16 = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_7 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f16));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_7, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1687880534, "C43@1659L6,42@1603L94,34@1260L687,61@2309L78,64@2438L6,53@1957L750:InboxItemCollaborationActions.kt#46vz6n");
            float f17 = 32;
            Modifier modifierM1252height3ABfNKs4 = SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f16), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(f17));
            float f18 = 16;
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_7 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f18));
            float f19 = 12;
            float f110 = 0;
            PaddingValues paddingValuesM1212PaddingValuesYgX7TsA4 = PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(f19), Dp.m9687constructorimpl(f110));
            int i16 = (i3 & 14) | 817889328;
            int i17 = i3 >> 3;
            int i18 = i17 & 896;
            Modifier modifier7 = companion;
            boolean z8 = z2;
            ButtonKt.Button(onAcceptClick, modifierM1252height3ABfNKs4, z8, roundedCornerShapeM1573RoundedCornerShape0680j_7, ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, paddingValuesM1212PaddingValuesYgX7TsA4, (MutableInteractionSource) null, ComposableSingletons$InboxItemCollaborationActionsKt.INSTANCE.m12685getLambda$2004083978$box_generalProdRelease(), composerStartRestartGroup, i16 | i18, 352);
            ButtonKt.OutlinedButton(onDeclineClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f16), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(f17)), z8, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f18)), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 14), (ButtonElevation) null, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU()), PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(f19), Dp.m9687constructorimpl(f110)), (MutableInteractionSource) null, ComposableSingletons$InboxItemCollaborationActionsKt.INSTANCE.getLambda$1097741108$box_generalProdRelease(), composerStartRestartGroup, (i17 & 14) | 817889328 | i18, 288);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z8;
            modifier3 = modifier7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActionsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemCollaborationActionsKt.InboxItemCollaborationActions$lambda$1(onAcceptClick, onDeclineClick, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void InboxItemCollaborationActionsPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1320267085);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemCollaborationActionsPreview)81@2912L3,82@2942L3,80@2857L120:InboxItemCollaborationActions.kt#46vz6n");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1320267085, i, -1, "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActionsPreview (InboxItemCollaborationActions.kt:79)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1761319696, "CC(remember):InboxItemCollaborationActions.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActionsKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1761320656, "CC(remember):InboxItemCollaborationActions.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActionsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            InboxItemCollaborationActions(function0, (Function0) objRememberedValue2, null, true, composerStartRestartGroup, 3126, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationActionsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemCollaborationActionsKt.InboxItemCollaborationActionsPreview$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
