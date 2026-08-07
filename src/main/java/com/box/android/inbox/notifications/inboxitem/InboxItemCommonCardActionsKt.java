package com.box.android.inbox.notifications.inboxitem;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.ActionStyleLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxItemCommonCardActions.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aQ\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"InboxItemCommonCardActions", "", "primaryAction", "Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "secondaryAction", "onPrimaryClick", "Lkotlin/Function0;", "onSecondaryClick", "modifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "", "(Lcom/box/android/domain/models/inboxnotifications/ActionModel;Lcom/box/android/domain/models/inboxnotifications/ActionModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "InboxItemCommonCardActionsPreview", "(Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InboxItemCommonCardActionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCommonCardActions$lambda$1(ActionModel actionModel, ActionModel actionModel2, Function0 function0, Function0 function1, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        InboxItemCommonCardActions(actionModel, actionModel2, function0, function1, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCommonCardActionsPreview$lambda$0(int i, Composer composer, int i2) {
        InboxItemCommonCardActionsPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:45:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x0089  */
    /* JADX WARN: Code duplicated, block: B:49:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:70:0x0122  */
    /* JADX WARN: Code duplicated, block: B:73:0x012e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0132  */
    /* JADX WARN: Code duplicated, block: B:77:0x0184  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:81:0x0268  */
    /* JADX WARN: Code duplicated, block: B:84:0x0322  */
    /* JADX WARN: Code duplicated, block: B:85:0x032a  */
    /* JADX WARN: Code duplicated, block: B:88:0x03df  */
    /* JADX WARN: Code duplicated, block: B:90:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:93:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    public static final void InboxItemCommonCardActions(final ActionModel actionModel, final ActionModel actionModel2, final Function0<Unit> onPrimaryClick, final Function0<Unit> onSecondaryClick, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        Composer composer2;
        final boolean z4;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        final String strStringResource;
        float f;
        Function0<ComposeUiNode> constructor;
        final String str;
        int i6;
        float f2;
        boolean z6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(onPrimaryClick, "onPrimaryClick");
        Intrinsics.checkNotNullParameter(onSecondaryClick, "onSecondaryClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-118608335);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemCommonCardActions)N(primaryAction,secondaryAction,onPrimaryClick,onSecondaryClick,modifier,isEnabled)31@1235L59,33@1300L2801:InboxItemCommonCardActions.kt#2fg1pg");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(actionModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(actionModel2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPrimaryClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onSecondaryClick) ? 2048 : 1024;
        }
        int i9 = i2 & 16;
        if (i9 == 0) {
            if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-118608335, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActions (InboxItemCommonCardActions.kt:30)");
                    }
                    strStringResource = StringResources_androidKt.stringResource(R.string.inbox_notification_action_fallback, composerStartRestartGroup, 6);
                    f = 8;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -206975152, "C:InboxItemCommonCardActions.kt#2fg1pg");
                    if (actionModel == null) {
                        composerStartRestartGroup.startReplaceGroup(-206987306);
                        composerStartRestartGroup.endReplaceGroup();
                        str = strStringResource;
                        i6 = i3;
                        modifier = companion;
                        f2 = f;
                        composer2 = composerStartRestartGroup;
                        z6 = z5;
                        i7 = 817889328;
                        i8 = 32;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-206987305);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (actionModel.getStyleLevel() == ActionStyleLevel.SUCCESS) {
                            composerStartRestartGroup.startReplaceGroup(-1461892858);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "48@1979L6,47@1915L110,50@2044L270,39@1521L793");
                            i7 = 817889328;
                            i6 = i3;
                            f2 = f;
                            modifier = companion;
                            str = strStringResource;
                            z6 = z5;
                            ButtonKt.Button(onPrimaryClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z6, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-933156402, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$0$0(actionModel, strStringResource, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 6) & 14) | 817889328 | ((i6 >> 9) & 896), 352);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                            i8 = 32;
                        } else {
                            str = strStringResource;
                            i6 = i3;
                            modifier = companion;
                            f2 = f;
                            z6 = z5;
                            i7 = 817889328;
                            composerStartRestartGroup.startReplaceGroup(-1461066367);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "66@2754L94,69@2907L6,70@2951L263,58@2352L862");
                            i8 = 32;
                            ButtonKt.OutlinedButton(onPrimaryClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z6, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 14), (ButtonElevation) null, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU()), PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1019877785, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$0$1(actionModel, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 6) & 14) | 817889328 | ((i6 >> 9) & 896), 288);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        }
                        composer2.endReplaceGroup();
                    }
                    if (actionModel2 == null) {
                        composer2.startReplaceGroup(-205191538);
                    } else {
                        composer2.startReplaceGroup(-205191537);
                        ComposerKt.sourceInformation(composer2, "*89@3665L86,92@3806L6,93@3846L239,81@3293L792");
                        Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(i8));
                        RoundedCornerShape circleShape = RoundedCornerShapeKt.getCircleShape();
                        PaddingValues paddingValuesM1212PaddingValuesYgX7TsA = PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0));
                        ButtonColors buttonColorsM2850buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composer2, (ButtonDefaults.$stable << 12) | 6, 14);
                        BorderStroke borderStrokeM622BorderStrokecXLIe8U = BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU());
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(346307308, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$1$0(actionModel2, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composer2, 54);
                        int i10 = i6 >> 9;
                        Composer composer3 = composer2;
                        ButtonKt.OutlinedButton(onSecondaryClick, modifierM1252height3ABfNKs, z6, circleShape, buttonColorsM2850buttonColorsro_MJ88, (ButtonElevation) null, borderStrokeM622BorderStrokecXLIe8U, paddingValuesM1212PaddingValuesYgX7TsA, (MutableInteractionSource) null, composableLambdaRememberComposableLambda, composer3, (i10 & 14) | i7 | (i10 & 896), 288);
                        composer2 = composer3;
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z6;
                }
                modifier2 = modifier;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$1(actionModel, actionModel2, onPrimaryClick, onSecondaryClick, modifier2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-118608335, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActions (InboxItemCommonCardActions.kt:30)");
                }
                strStringResource = StringResources_androidKt.stringResource(R.string.inbox_notification_action_fallback, composerStartRestartGroup, 6);
                f = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f));
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -206975152, "C:InboxItemCommonCardActions.kt#2fg1pg");
                if (actionModel == null) {
                    composerStartRestartGroup.startReplaceGroup(-206987306);
                    composerStartRestartGroup.endReplaceGroup();
                    str = strStringResource;
                    i6 = i3;
                    modifier = companion;
                    f2 = f;
                    composer2 = composerStartRestartGroup;
                    z6 = z5;
                    i7 = 817889328;
                    i8 = 32;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-206987305);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (actionModel.getStyleLevel() == ActionStyleLevel.SUCCESS) {
                        composerStartRestartGroup.startReplaceGroup(-1461892858);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "48@1979L6,47@1915L110,50@2044L270,39@1521L793");
                        i7 = 817889328;
                        i6 = i3;
                        f2 = f;
                        modifier = companion;
                        str = strStringResource;
                        z6 = z5;
                        ButtonKt.Button(onPrimaryClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z6, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-933156402, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$0$0(actionModel, strStringResource, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 6) & 14) | 817889328 | ((i6 >> 9) & 896), 352);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                        i8 = 32;
                    } else {
                        str = strStringResource;
                        i6 = i3;
                        modifier = companion;
                        f2 = f;
                        z6 = z5;
                        i7 = 817889328;
                        composerStartRestartGroup.startReplaceGroup(-1461066367);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@2754L94,69@2907L6,70@2951L263,58@2352L862");
                        i8 = 32;
                        ButtonKt.OutlinedButton(onPrimaryClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z6, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 14), (ButtonElevation) null, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU()), PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1019877785, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$0$1(actionModel, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 6) & 14) | 817889328 | ((i6 >> 9) & 896), 288);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    composer2.endReplaceGroup();
                }
                if (actionModel2 == null) {
                    composer2.startReplaceGroup(-205191538);
                } else {
                    composer2.startReplaceGroup(-205191537);
                    ComposerKt.sourceInformation(composer2, "*89@3665L86,92@3806L6,93@3846L239,81@3293L792");
                    Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(i8));
                    RoundedCornerShape circleShape2 = RoundedCornerShapeKt.getCircleShape();
                    PaddingValues paddingValuesM1212PaddingValuesYgX7TsA2 = PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0));
                    ButtonColors buttonColorsM2850buttonColorsro_MJ89 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composer2, (ButtonDefaults.$stable << 12) | 6, 14);
                    BorderStroke borderStrokeM622BorderStrokecXLIe8U2 = BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU());
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(346307308, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$1$0(actionModel2, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer2, 54);
                    int i11 = i6 >> 9;
                    Composer composer4 = composer2;
                    ButtonKt.OutlinedButton(onSecondaryClick, modifierM1252height3ABfNKs2, z6, circleShape2, buttonColorsM2850buttonColorsro_MJ89, (ButtonElevation) null, borderStrokeM622BorderStrokecXLIe8U2, paddingValuesM1212PaddingValuesYgX7TsA2, (MutableInteractionSource) null, composableLambdaRememberComposableLambda2, composer4, (i11 & 14) | i7 | (i11 & 896), 288);
                    composer2 = composer4;
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
            }
            modifier2 = modifier;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$1(actionModel, actionModel2, onPrimaryClick, onSecondaryClick, modifier2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-118608335, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActions (InboxItemCommonCardActions.kt:30)");
                }
                strStringResource = StringResources_androidKt.stringResource(R.string.inbox_notification_action_fallback, composerStartRestartGroup, 6);
                f = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_6 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f));
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -206975152, "C:InboxItemCommonCardActions.kt#2fg1pg");
                if (actionModel == null) {
                    composerStartRestartGroup.startReplaceGroup(-206987306);
                    composerStartRestartGroup.endReplaceGroup();
                    str = strStringResource;
                    i6 = i3;
                    modifier = companion;
                    f2 = f;
                    composer2 = composerStartRestartGroup;
                    z6 = z5;
                    i7 = 817889328;
                    i8 = 32;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-206987305);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (actionModel.getStyleLevel() == ActionStyleLevel.SUCCESS) {
                        composerStartRestartGroup.startReplaceGroup(-1461892858);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "48@1979L6,47@1915L110,50@2044L270,39@1521L793");
                        i7 = 817889328;
                        i6 = i3;
                        f2 = f;
                        modifier = companion;
                        str = strStringResource;
                        z6 = z5;
                        ButtonKt.Button(onPrimaryClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z6, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-933156402, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$0$0(actionModel, strStringResource, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 6) & 14) | 817889328 | ((i6 >> 9) & 896), 352);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                        i8 = 32;
                    } else {
                        str = strStringResource;
                        i6 = i3;
                        modifier = companion;
                        f2 = f;
                        z6 = z5;
                        i7 = 817889328;
                        composerStartRestartGroup.startReplaceGroup(-1461066367);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@2754L94,69@2907L6,70@2951L263,58@2352L862");
                        i8 = 32;
                        ButtonKt.OutlinedButton(onPrimaryClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z6, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 14), (ButtonElevation) null, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU()), PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1019877785, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$0$1(actionModel, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 6) & 14) | 817889328 | ((i6 >> 9) & 896), 288);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    composer2.endReplaceGroup();
                }
                if (actionModel2 == null) {
                    composer2.startReplaceGroup(-205191538);
                } else {
                    composer2.startReplaceGroup(-205191537);
                    ComposerKt.sourceInformation(composer2, "*89@3665L86,92@3806L6,93@3846L239,81@3293L792");
                    Modifier modifierM1252height3ABfNKs3 = SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(i8));
                    RoundedCornerShape circleShape3 = RoundedCornerShapeKt.getCircleShape();
                    PaddingValues paddingValuesM1212PaddingValuesYgX7TsA3 = PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0));
                    ButtonColors buttonColorsM2850buttonColorsro_MJ810 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composer2, (ButtonDefaults.$stable << 12) | 6, 14);
                    BorderStroke borderStrokeM622BorderStrokecXLIe8U3 = BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU());
                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(346307308, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$1$0(actionModel2, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer2, 54);
                    int i12 = i6 >> 9;
                    Composer composer5 = composer2;
                    ButtonKt.OutlinedButton(onSecondaryClick, modifierM1252height3ABfNKs3, z6, circleShape3, buttonColorsM2850buttonColorsro_MJ810, (ButtonElevation) null, borderStrokeM622BorderStrokecXLIe8U3, paddingValuesM1212PaddingValuesYgX7TsA3, (MutableInteractionSource) null, composableLambdaRememberComposableLambda3, composer5, (i12 & 14) | i7 | (i12 & 896), 288);
                    composer2 = composer5;
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
            }
            modifier2 = modifier;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$1(actionModel, actionModel2, onPrimaryClick, onSecondaryClick, modifier2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i9 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (i4 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-118608335, i3, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActions (InboxItemCommonCardActions.kt:30)");
            }
            strStringResource = StringResources_androidKt.stringResource(R.string.inbox_notification_action_fallback, composerStartRestartGroup, 6);
            f = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_7 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f));
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -206975152, "C:InboxItemCommonCardActions.kt#2fg1pg");
            if (actionModel == null) {
                composerStartRestartGroup.startReplaceGroup(-206987306);
                composerStartRestartGroup.endReplaceGroup();
                str = strStringResource;
                i6 = i3;
                modifier = companion;
                f2 = f;
                composer2 = composerStartRestartGroup;
                z6 = z5;
                i7 = 817889328;
                i8 = 32;
            } else {
                composerStartRestartGroup.startReplaceGroup(-206987305);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (actionModel.getStyleLevel() == ActionStyleLevel.SUCCESS) {
                    composerStartRestartGroup.startReplaceGroup(-1461892858);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "48@1979L6,47@1915L110,50@2044L270,39@1521L793");
                    i7 = 817889328;
                    i6 = i3;
                    f2 = f;
                    modifier = companion;
                    str = strStringResource;
                    z6 = z5;
                    ButtonKt.Button(onPrimaryClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z6, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-933156402, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$0$0(actionModel, strStringResource, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 6) & 14) | 817889328 | ((i6 >> 9) & 896), 352);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                    i8 = 32;
                } else {
                    str = strStringResource;
                    i6 = i3;
                    modifier = companion;
                    f2 = f;
                    z6 = z5;
                    i7 = 817889328;
                    composerStartRestartGroup.startReplaceGroup(-1461066367);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@2754L94,69@2907L6,70@2951L263,58@2352L862");
                    i8 = 32;
                    ButtonKt.OutlinedButton(onPrimaryClick, SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(32)), z6, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 14), (ButtonElevation) null, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU()), PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0)), (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1019877785, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$0$1(actionModel, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 6) & 14) | 817889328 | ((i6 >> 9) & 896), 288);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            }
            if (actionModel2 == null) {
                composer2.startReplaceGroup(-205191538);
            } else {
                composer2.startReplaceGroup(-205191537);
                ComposerKt.sourceInformation(composer2, "*89@3665L86,92@3806L6,93@3846L239,81@3293L792");
                Modifier modifierM1252height3ABfNKs4 = SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(i8));
                RoundedCornerShape circleShape4 = RoundedCornerShapeKt.getCircleShape();
                PaddingValues paddingValuesM1212PaddingValuesYgX7TsA4 = PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(12), Dp.m9687constructorimpl(0));
                ButtonColors buttonColorsM2850buttonColorsro_MJ811 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, composer2, (ButtonDefaults.$stable << 12) | 6, 14);
                BorderStroke borderStrokeM622BorderStrokecXLIe8U4 = BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU());
                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(346307308, true, new Function3() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$0$1$0(actionModel2, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                int i13 = i6 >> 9;
                Composer composer6 = composer2;
                ButtonKt.OutlinedButton(onSecondaryClick, modifierM1252height3ABfNKs4, z6, circleShape4, buttonColorsM2850buttonColorsro_MJ811, (ButtonElevation) null, borderStrokeM622BorderStrokecXLIe8U4, paddingValuesM1212PaddingValuesYgX7TsA4, (MutableInteractionSource) null, composableLambdaRememberComposableLambda4, composer6, (i13 & 14) | i7 | (i13 & 896), 288);
                composer2 = composer6;
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z6;
        }
        modifier2 = modifier;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemCommonCardActionsKt.InboxItemCommonCardActions$lambda$1(actionModel, actionModel2, onPrimaryClick, onSecondaryClick, modifier2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCommonCardActions$lambda$0$0$0(ActionModel actionModel, String str, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C53@2180L6,51@2066L230:InboxItemCommonCardActions.kt#2fg1pg");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-933156402, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActions.<anonymous>.<anonymous>.<anonymous> (InboxItemCommonCardActions.kt:51)");
            }
            String value = actionModel.getValue();
            if (value == null) {
                value = str;
            }
            TextKt.m4494TextNvy7gAk(value, null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11535getMainActiveControlContent0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold12(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCommonCardActions$lambda$0$0$1(ActionModel actionModel, String str, RowScope OutlinedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation(composer, "C73@3087L6,71@2973L223:InboxItemCommonCardActions.kt#2fg1pg");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1019877785, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActions.<anonymous>.<anonymous>.<anonymous> (InboxItemCommonCardActions.kt:71)");
            }
            String value = actionModel.getValue();
            if (value == null) {
                value = str;
            }
            TextKt.m4494TextNvy7gAk(value, null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold12(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InboxItemCommonCardActions$lambda$0$1$0(ActionModel actionModel, String str, RowScope OutlinedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation(composer, "C96@3970L6,94@3864L207:InboxItemCommonCardActions.kt#2fg1pg");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(346307308, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActions.<anonymous>.<anonymous>.<anonymous> (InboxItemCommonCardActions.kt:94)");
            }
            String value = actionModel.getValue();
            if (value == null) {
                value = str;
            }
            TextKt.m4494TextNvy7gAk(value, null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxBold12(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void InboxItemCommonCardActionsPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(628936106);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InboxItemCommonCardActionsPreview)109@4242L1236:InboxItemCommonCardActions.kt#2fg1pg");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(628936106, i, -1, "com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsPreview (InboxItemCommonCardActions.kt:108)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$InboxItemCommonCardActionsKt.INSTANCE.m12668getLambda$415966017$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.inbox.notifications.inboxitem.InboxItemCommonCardActionsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxItemCommonCardActionsKt.InboxItemCommonCardActionsPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
