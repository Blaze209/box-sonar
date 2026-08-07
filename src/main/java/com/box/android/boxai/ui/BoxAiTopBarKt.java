package com.box.android.boxai.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ExpandMoreKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxSizes;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.boxai.R;
import com.box.android.boxai.agents.BoxAiAgentPopupMenuKt;
import com.box.android.boxai.agents.BoxAiAgentsReducer;
import com.box.android.domain.models.boxai.AiAgentModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiTopBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001aM\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0019²\u0006\n\u0010\u0010\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"BoxAiTopBar", "", "isClearChatEnabled", "", "onCloseClicked", "Lkotlin/Function0;", "onClearClicked", "onAgentSelected", "Lkotlin/Function1;", "Lcom/box/android/domain/models/boxai/AiAgentModel;", "agentsState", "Lcom/box/android/boxai/agents/BoxAiAgentsReducer$State;", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lcom/box/android/boxai/agents/BoxAiAgentsReducer$State;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BoxAiAgentsDropdown", "agentListExpanded", "state", "onButtonClick", "onDismissMenu", "(ZLcom/box/android/boxai/agents/BoxAiAgentsReducer$State;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "BoxAiTopBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiTopBarEmptyChatPreview", "BoxAiTopBarAgentsPreview", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAgentsDropdown$lambda$1(boolean z, BoxAiAgentsReducer.State state, Function0 function0, Function1 function1, Function0 function2, int i, Composer composer, int i2) {
        BoxAiAgentsDropdown(z, state, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBar$lambda$4(boolean z, Function0 function0, Function0 function1, Function1 function2, BoxAiAgentsReducer.State state, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BoxAiTopBar(z, function0, function1, function2, state, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBarAgentsPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiTopBarAgentsPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBarEmptyChatPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiTopBarEmptyChatPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBarPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiTopBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0417  */
    /* JADX WARN: Code duplicated, block: B:104:0x0423  */
    /* JADX WARN: Code duplicated, block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:66:0x014b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0157  */
    /* JADX WARN: Code duplicated, block: B:70:0x015b  */
    /* JADX WARN: Code duplicated, block: B:73:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:76:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:77:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:80:0x0323  */
    /* JADX WARN: Code duplicated, block: B:82:0x0346  */
    /* JADX WARN: Code duplicated, block: B:85:0x0361  */
    /* JADX WARN: Code duplicated, block: B:86:0x0363  */
    /* JADX WARN: Code duplicated, block: B:91:0x0372  */
    /* JADX WARN: Code duplicated, block: B:94:0x0391  */
    /* JADX WARN: Code duplicated, block: B:96:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:99:0x0411  */
    public static final void BoxAiTopBar(boolean z, final Function0<Unit> onCloseClicked, final Function0<Unit> function0, final Function1<? super AiAgentModel, Unit> onAgentSelected, final BoxAiAgentsReducer.State agentsState, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        final boolean z3;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Object objRememberedValue;
        final MutableState mutableState;
        Function0<ComposeUiNode> constructor;
        int i4;
        Function0<ComposeUiNode> constructor2;
        Object objRememberedValue2;
        boolean z4;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onAgentSelected, "onAgentSelected");
        Intrinsics.checkNotNullParameter(agentsState, "agentsState");
        Composer composerStartRestartGroup = composer.startRestartGroup(384103039);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiTopBar)N(isClearChatEnabled,onCloseClicked,onClearClicked,onAgentSelected,agentsState,modifier)55@2337L34,57@2377L2140:BoxAiTopBar.kt#bwxcym");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCloseClicked) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onAgentSelected) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(agentsState) ? 16384 : 8192;
        }
        int i5 = i2 & 32;
        if (i5 == 0) {
            if ((196608 & i) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                z3 = z;
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(384103039, i3, -1, "com.box.android.boxai.ui.BoxAiTopBar (BoxAiTopBar.kt:54)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -244158239, "CC(remember):BoxAiTopBar.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(24), 0.0f, 2, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2091040832, "C66@2657L42,64@2583L165,69@2757L39,71@2830L31,73@2947L6,70@2805L222,76@3036L579,90@3687L6,90@3709L802,90@3624L887:BoxAiTopBar.kt#bwxcym");
                Modifier modifier3 = companion;
                i4 = i3;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_box_ai, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(32)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 432, 120);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(20)), composerStartRestartGroup, 6);
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai, composerStartRestartGroup, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(6), 0.0f, 11, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold22(), composerStartRestartGroup, 48, 0, 131064);
                composerStartRestartGroup = composerStartRestartGroup;
                Modifier modifierWeight = rowScopeInstance.weight(Modifier.INSTANCE, 1.0f, true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 812972692, "C:BoxAiTopBar.kt#bwxcym");
                if (agentsState.getAgents().size() > 1) {
                    composerStartRestartGroup.startReplaceGroup(809881805);
                } else {
                    composerStartRestartGroup.startReplaceGroup(813004404);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@3307L42,82@3389L117,86@3544L29,78@3150L441");
                    boolean zBoxAiTopBar$lambda$1 = BoxAiTopBar$lambda$1(mutableState);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1688799103, "CC(remember):BoxAiTopBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiTopBarKt.BoxAiTopBar$lambda$3$0$0$0(mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function1 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1688801802, "CC(remember):BoxAiTopBar.kt#9igjgp");
                    if ((i4 & 7168) == 2048) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiTopBarKt.BoxAiTopBar$lambda$3$0$1$0(onAgentSelected, mutableState, (AiAgentModel) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function2 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1688806674, "CC(remember):BoxAiTopBar.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiTopBarKt.BoxAiTopBar$lambda$3$0$2$0(mutableState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxAiAgentsDropdown(zBoxAiTopBar$lambda$1, agentsState, function1, function2, (Function0) objRememberedValue4, composerStartRestartGroup, ((i4 >> 9) & 112) | 24960);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                z3 = z;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12061getTopBarControl0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(1617328603, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiTopBarKt.BoxAiTopBar$lambda$3$1(function0, z3, onCloseClicked, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z5 = z3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiTopBarKt.BoxAiTopBar$lambda$4(z5, onCloseClicked, function0, onAgentSelected, agentsState, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            z3 = z;
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(384103039, i3, -1, "com.box.android.boxai.ui.BoxAiTopBar (BoxAiTopBar.kt:54)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -244158239, "CC(remember):BoxAiTopBar.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(24), 0.0f, 2, null);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default2);
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
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2091040832, "C66@2657L42,64@2583L165,69@2757L39,71@2830L31,73@2947L6,70@2805L222,76@3036L579,90@3687L6,90@3709L802,90@3624L887:BoxAiTopBar.kt#bwxcym");
            Modifier modifier4 = companion;
            i4 = i3;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_box_ai, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(32)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 432, 120);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(20)), composerStartRestartGroup, 6);
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai, composerStartRestartGroup, 0), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(6), 0.0f, 11, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold22(), composerStartRestartGroup, 48, 0, 131064);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifierWeight2 = rowScopeInstance2.weight(Modifier.INSTANCE, 1.0f, true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight2);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 812972692, "C:BoxAiTopBar.kt#bwxcym");
            if (agentsState.getAgents().size() > 1) {
                composerStartRestartGroup.startReplaceGroup(809881805);
            } else {
                composerStartRestartGroup.startReplaceGroup(813004404);
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@3307L42,82@3389L117,86@3544L29,78@3150L441");
                boolean zBoxAiTopBar$lambda$2 = BoxAiTopBar$lambda$1(mutableState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1688799103, "CC(remember):BoxAiTopBar.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiTopBarKt.BoxAiTopBar$lambda$3$0$0$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function3 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1688801802, "CC(remember):BoxAiTopBar.kt#9igjgp");
                if ((i4 & 7168) == 2048) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiTopBarKt.BoxAiTopBar$lambda$3$0$1$0(onAgentSelected, mutableState, (AiAgentModel) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiTopBarKt.BoxAiTopBar$lambda$3$0$1$0(onAgentSelected, mutableState, (AiAgentModel) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function1 function4 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1688806674, "CC(remember):BoxAiTopBar.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiTopBarKt.BoxAiTopBar$lambda$3$0$2$0(mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxAiAgentsDropdown(zBoxAiTopBar$lambda$2, agentsState, function3, function4, (Function0) objRememberedValue4, composerStartRestartGroup, ((i4 >> 9) & 112) | 24960);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            z3 = z;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, 6).m12061getTopBarControl0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(1617328603, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTopBarKt.BoxAiTopBar$lambda$3$1(function0, z3, onCloseClicked, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z6 = z3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTopBarKt.BoxAiTopBar$lambda$4(z6, onCloseClicked, function0, onAgentSelected, agentsState, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean BoxAiTopBar$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void BoxAiTopBar$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBar$lambda$3$0$0$0(MutableState mutableState) {
        BoxAiTopBar$lambda$2(mutableState, !BoxAiTopBar$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBar$lambda$3$0$1$0(Function1 function1, MutableState mutableState, AiAgentModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        BoxAiTopBar$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBar$lambda$3$0$2$0(MutableState mutableState) {
        BoxAiTopBar$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBar$lambda$3$1(Function0 function0, boolean z, Function0 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C103@4208L293:BoxAiTopBar.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1617328603, i, -1, "com.box.android.boxai.ui.BoxAiTopBar.<anonymous>.<anonymous> (BoxAiTopBar.kt:91)");
            }
            if (function0 != null) {
                composer.startReplaceGroup(893340875);
                ComposerKt.sourceInformation(composer, "92@3769L412");
                IconButtonKt.IconButton((Function0<Unit>) function0, (Modifier) null, z, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$BoxAiTopBarKt.INSTANCE.m12120getLambda$1380788094$boxai_generalProdRelease(), composer, 1572864, 58);
            } else {
                composer.startReplaceGroup(889605127);
            }
            composer.endReplaceGroup();
            IconButtonKt.IconButton((Function0<Unit>) function1, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxAiTopBarKt.INSTANCE.getLambda$122350461$boxai_generalProdRelease(), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxAiAgentsDropdown(final boolean z, final BoxAiAgentsReducer.State state, final Function0<Unit> function0, final Function1<? super AiAgentModel, Unit> function1, final Function0<Unit> function2, Composer composer, final int i) {
        boolean z2;
        int i2;
        Function1<? super AiAgentModel, Unit> function3;
        Function0<Unit> function4;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-122970025);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiAgentsDropdown)N(agentListExpanded,state,onButtonClick,onAgentSelected,onDismissMenu)126@4927L702,122@4749L880,144@5634L223:BoxAiTopBar.kt#bwxcym");
        if ((i & 6) == 0) {
            z2 = z;
            i2 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(state) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function3 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function1;
        }
        if ((i & 24576) == 0) {
            function4 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
        } else {
            function4 = function2;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-122970025, i2, -1, "com.box.android.boxai.ui.BoxAiAgentsDropdown (BoxAiTopBar.kt:121)");
            }
            composer2 = composerStartRestartGroup;
            ButtonKt.TextButton(function0, TestTagKt.testTag(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(28)), "BoxAi:AgentSwitcher"), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1215PaddingValuesa9UjIt4$default(Dp.m9687constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-158969068, true, new Function3() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxAiTopBarKt.BoxAiAgentsDropdown$lambda$0(state, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i2 >> 6) & 14) | 817889328, 380);
            List<AiAgentModel> agents = state.getAgents();
            AiAgentModel selectedAgent = state.getSelectedAgent();
            BoxAiAgentPopupMenuKt.BoxAiAgentPopupMenu(z2, agents, selectedAgent != null ? selectedAgent.getId() : null, function3, function4, composer2, i2 & 64526);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTopBarKt.BoxAiAgentsDropdown$lambda$1(z, state, function0, function1, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAgentsDropdown$lambda$0(BoxAiAgentsReducer.State state, RowScope TextButton, Composer composer, int i) {
        int i2;
        String id;
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C130@5154L6,127@4937L411,140@5554L6,135@5357L266:BoxAiTopBar.kt#bwxcym");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(TextButton) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-158969068, i2, -1, "com.box.android.boxai.ui.BoxAiAgentsDropdown.<anonymous> (BoxAiTopBar.kt:127)");
            }
            AiAgentModel selectedAgent = state.getSelectedAgent();
            if (selectedAgent == null || (id = selectedAgent.getName()) == null) {
                AiAgentModel selectedAgent2 = state.getSelectedAgent();
                id = selectedAgent2 != null ? selectedAgent2.getId() : null;
            }
            if (id == null) {
                composer.startReplaceGroup(1849551270);
                ComposerKt.sourceInformation(composer, "128@5018L50");
                id = StringResources_androidKt.stringResource(R.string.box_ai_default_agent_name, composer, 0);
            } else {
                composer.startReplaceGroup(1849549534);
            }
            composer.endReplaceGroup();
            TextKt.m4494TextNvy7gAk(id, TextButton.weight(SizeKt.m1272widthInVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(20), Dp.m9687constructorimpl(80)), 1.0f, false), BoxAITheme.INSTANCE.getColors(composer, 6).m12060getTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer, 0, 24960, 110584);
            IconKt.m3576Iconww6aTOc(ExpandMoreKt.getExpandMore(Icons.Outlined.INSTANCE), (String) null, PaddingKt.m1220paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m9687constructorimpl(4), 1, null), BoxAITheme.INSTANCE.getColors(composer, 6).m12060getTextSecondary0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxAiTopBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-640379124);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiTopBarPreview)159@6010L351:BoxAiTopBar.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-640379124, i, -1, "com.box.android.boxai.ui.BoxAiTopBarPreview (BoxAiTopBar.kt:158)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiTopBarKt.INSTANCE.m12121getLambda$1459860969$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTopBarKt.BoxAiTopBarPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiTopBarEmptyChatPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(611802059);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiTopBarEmptyChatPreview)176@6470L352:BoxAiTopBar.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(611802059, i, -1, "com.box.android.boxai.ui.BoxAiTopBarEmptyChatPreview (BoxAiTopBar.kt:175)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiTopBarKt.INSTANCE.getLambda$1248912672$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTopBarKt.BoxAiTopBarEmptyChatPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiTopBarAgentsPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1905666438);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiTopBarAgentsPreview)193@6928L656:BoxAiTopBar.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1905666438, i, -1, "com.box.android.boxai.ui.BoxAiTopBarAgentsPreview (BoxAiTopBar.kt:192)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiTopBarKt.INSTANCE.getLambda$1705235781$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiTopBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTopBarKt.BoxAiTopBarAgentsPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
