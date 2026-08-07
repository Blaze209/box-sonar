package com.box.android.base.presentation.components.topbar.component.searchbar;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeAnimationUtilsKt;
import com.box.android.base.compose.SearchBarToSearchScreenTransition;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopBarSearchBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0003¢\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u0007*\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u0007*\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u0018\u001a%\u0010\u0019\u001a\u00020\u0007*\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0003¢\u0006\u0002\u0010\u001a\u001a%\u0010\u001b\u001a\u00020\u0007*\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0003¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002"}, d2 = {"TopBarSearchBar", "", "text", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "animatedCornerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "(Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/RoundedCornerShape;", "sharedTransitionAnimatedBackground", "transitionColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor", "sharedTransitionAnimatedBackground-9z6LAg8", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/AnimatedVisibilityScope;JJLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "sharedBoundsModifier", "sharedTransitionScope", "Landroidx/compose/animation/SharedTransitionScope;", "roundedCornerShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/SharedTransitionScope;Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/foundation/shape/RoundedCornerShape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "sharedElementText", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/SharedTransitionScope;Landroidx/compose/animation/AnimatedVisibilityScope;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "sharedElementInputRowContent", "TopBarSearchBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease", "dp", "Landroidx/compose/ui/unit/Dp;", "progress", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TopBarSearchBarKt {

    /* JADX INFO: compiled from: TopBarSearchBar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnterExitState.values().length];
            try {
                iArr[EnterExitState.PreEnter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterExitState.Visible.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterExitState.PostExit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarSearchBar$lambda$1(String str, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TopBarSearchBar(str, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarSearchBarPreview$lambda$1(int i, Composer composer, int i2) {
        TopBarSearchBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:34:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:36:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x007f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0182  */
    /* JADX WARN: Code duplicated, block: B:45:0x018e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0192  */
    /* JADX WARN: Code duplicated, block: B:49:0x021e  */
    /* JADX WARN: Code duplicated, block: B:52:0x022a  */
    /* JADX WARN: Code duplicated, block: B:53:0x022e  */
    /* JADX WARN: Code duplicated, block: B:56:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:58:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:61:0x0306  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    public static final void TopBarSearchBar(final String text, final Function0<Unit> onClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> constructor2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(2011146280);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopBarSearchBar)N(text,onClick,modifier)44@2319L7,45@2393L7,46@2423L44,50@2519L81,56@2820L6,57@2882L6,54@2700L229,61@3014L6,48@2473L1255:TopBarSearchBar.kt#v0zfoc");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i3;
            if ((i4 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2011146280, i4, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBar (TopBarSearchBar.kt:43)");
                }
                ProvidableCompositionLocal<SharedTransitionScope> localSharedTransitionScope = ComposeAnimationUtilsKt.getLocalSharedTransitionScope();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localSharedTransitionScope);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SharedTransitionScope sharedTransitionScope = (SharedTransitionScope) objConsume;
                ProvidableCompositionLocal<AnimatedVisibilityScope> localNavAnimatedVisibilityScope = ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localNavAnimatedVisibilityScope);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnimatedVisibilityScope animatedVisibilityScope = (AnimatedVisibilityScope) objConsume2;
                RoundedCornerShape roundedCornerShapeAnimatedCornerShape = animatedCornerShape(animatedVisibilityScope, composerStartRestartGroup, 0);
                Modifier modifier4 = companion;
                Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(sharedBoundsModifier(companion, sharedTransitionScope, animatedVisibilityScope, roundedCornerShapeAnimatedCornerShape, composerStartRestartGroup, (i4 >> 6) & 14), 0.0f, 1, null), Dp.m9687constructorimpl(56));
                RoundedCornerShape roundedCornerShape = roundedCornerShapeAnimatedCornerShape;
                Modifier modifierTestTag = TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(BorderKt.m604borderxT4_qwU(m11847sharedTransitionAnimatedBackground9z6LAg8(ClipKt.clip(modifierM1252height3ABfNKs, roundedCornerShape), animatedVisibilityScope, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11547getSearchBarCapsuleBackground0d7_KjU(), composerStartRestartGroup, 0), Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), roundedCornerShape), false, null, null, null, onClick, 15, null), "SearchBarCapsule");
                Alignment centerStart = Alignment.INSTANCE.getCenterStart();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 111490644, "C68@3242L76,68@3229L493:TopBarSearchBar.kt#v0zfoc");
                Modifier modifierSharedElementInputRowContent = sharedElementInputRowContent(Modifier.INSTANCE, sharedTransitionScope, animatedVisibilityScope, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedElementInputRowContent);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714858605, "C74@3511L65,76@3668L6,69@3334L378:TopBarSearchBar.kt#v0zfoc");
                TextKt.m4494TextNvy7gAk(text, sharedElementText(SizeKt.fillMaxWidth$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, 2, null), 0.0f, 1, null), sharedTransitionScope, animatedVisibilityScope, composerStartRestartGroup, 6), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11548getSearchBarCapsuleContent0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, i4 & 14, 12582912, 131064);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TopBarSearchBarKt.TopBarSearchBar$lambda$1(text, onClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2011146280, i4, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBar (TopBarSearchBar.kt:43)");
            }
            ProvidableCompositionLocal<SharedTransitionScope> localSharedTransitionScope2 = ComposeAnimationUtilsKt.getLocalSharedTransitionScope();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localSharedTransitionScope2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SharedTransitionScope sharedTransitionScope2 = (SharedTransitionScope) objConsume3;
            ProvidableCompositionLocal<AnimatedVisibilityScope> localNavAnimatedVisibilityScope2 = ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localNavAnimatedVisibilityScope2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnimatedVisibilityScope animatedVisibilityScope2 = (AnimatedVisibilityScope) objConsume4;
            RoundedCornerShape roundedCornerShapeAnimatedCornerShape2 = animatedCornerShape(animatedVisibilityScope2, composerStartRestartGroup, 0);
            Modifier modifier5 = companion;
            Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(sharedBoundsModifier(companion, sharedTransitionScope2, animatedVisibilityScope2, roundedCornerShapeAnimatedCornerShape2, composerStartRestartGroup, (i4 >> 6) & 14), 0.0f, 1, null), Dp.m9687constructorimpl(56));
            RoundedCornerShape roundedCornerShape2 = roundedCornerShapeAnimatedCornerShape2;
            Modifier modifierTestTag2 = TestTagKt.testTag(ClickableKt.m632clickableoSLSa3U$default(BorderKt.m604borderxT4_qwU(m11847sharedTransitionAnimatedBackground9z6LAg8(ClipKt.clip(modifierM1252height3ABfNKs2, roundedCornerShape2), animatedVisibilityScope2, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11547getSearchBarCapsuleBackground0d7_KjU(), composerStartRestartGroup, 0), Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), roundedCornerShape2), false, null, null, null, onClick, 15, null), "SearchBarCapsule");
            Alignment centerStart2 = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
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
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 111490644, "C68@3242L76,68@3229L493:TopBarSearchBar.kt#v0zfoc");
            Modifier modifierSharedElementInputRowContent2 = sharedElementInputRowContent(Modifier.INSTANCE, sharedTransitionScope2, animatedVisibilityScope2, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSharedElementInputRowContent2);
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
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714858605, "C74@3511L65,76@3668L6,69@3334L378:TopBarSearchBar.kt#v0zfoc");
            TextKt.m4494TextNvy7gAk(text, sharedElementText(SizeKt.fillMaxWidth$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, 2, null), 0.0f, 1, null), sharedTransitionScope2, animatedVisibilityScope2, composerStartRestartGroup, 6), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11548getSearchBarCapsuleContent0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, i4 & 14, 12582912, 131064);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopBarSearchBarKt.TopBarSearchBar$lambda$1(text, onClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final RoundedCornerShape animatedCornerShape(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Object currentState;
        float fM9687constructorimpl;
        float fM9687constructorimpl2;
        composer.startReplaceGroup(1913392878);
        ComposerKt.sourceInformation(composer, "C(animatedCornerShape)N(animatedVisibilityScope)85@4029L410:TopBarSearchBar.kt#v0zfoc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1913392878, i, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.animatedCornerShape (TopBarSearchBar.kt:83)");
        }
        if (animatedVisibilityScope == null) {
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(SearchBarToSearchScreenTransition.INSTANCE.m11663getSearchBarCapsuleCornerRadiusD9Ej5fM());
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return roundedCornerShapeM1573RoundedCornerShape0680j_4;
        }
        final Transition<EnterExitState> transition = animatedVisibilityScope.getTransition();
        Function3 function3 = new Function3() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TopBarSearchBarKt.animatedCornerShape$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, -89793049, "CC(animateDp)N(transitionSpec,label,targetValueByState)1981@85315L75:Transition.kt#pdpnli");
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged = composer.changed(transition);
            currentState = composer.rememberedValue();
            if (zChanged || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    EnterExitState currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        EnterExitState enterExitState = (EnterExitState) currentState;
        composer.startReplaceGroup(1382998009);
        ComposerKt.sourceInformation(composer, "CN(enterExitState):TopBarSearchBar.kt#v0zfoc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1382998009, 0, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.animatedCornerShape.<anonymous> (TopBarSearchBar.kt:88)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i2 == 1) {
            fM9687constructorimpl = Dp.m9687constructorimpl(0);
        } else {
            if (i2 != 2 && i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            fM9687constructorimpl = SearchBarToSearchScreenTransition.INSTANCE.m11663getSearchBarCapsuleCornerRadiusD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Dp dpM9685boximpl = Dp.m9685boximpl(fM9687constructorimpl);
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged2 = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<EnterExitState>() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$animatedCornerShape$$inlined$animateDp$1
                /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.animation.EnterExitState, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final EnterExitState invoke() {
                    return transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EnterExitState enterExitState2 = (EnterExitState) ((State) objRememberedValue).getValue();
        composer.startReplaceGroup(1382998009);
        ComposerKt.sourceInformation(composer, "CN(enterExitState):TopBarSearchBar.kt#v0zfoc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1382998009, 0, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.animatedCornerShape.<anonymous> (TopBarSearchBar.kt:88)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[enterExitState2.ordinal()];
        if (i3 == 1) {
            fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
        } else {
            if (i3 != 2 && i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            fM9687constructorimpl2 = SearchBarToSearchScreenTransition.INSTANCE.m11663getSearchBarCapsuleCornerRadiusD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Dp dpM9685boximpl2 = Dp.m9685boximpl(fM9687constructorimpl2);
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged3 = composer.changed(transition);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<EnterExitState>>() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$animatedCornerShape$$inlined$animateDp$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<EnterExitState> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, dpM9685boximpl, dpM9685boximpl2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue2).getValue(), composer, 0), vectorConverter, "DpAnimation", composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_5 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(animatedCornerShape$lambda$2(stateCreateTransitionAnimation));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return roundedCornerShapeM1573RoundedCornerShape0680j_5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec animatedCornerShape$lambda$0(Transition.Segment animateDp, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animateDp, "$this$animateDp");
        composer.startReplaceGroup(-1998072363);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1998072363, i, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.animatedCornerShape.<anonymous> (TopBarSearchBar.kt:86)");
        }
        TweenSpec tweenSpecAnimationSpec = SearchBarToSearchScreenTransition.INSTANCE.animationSpec();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecAnimationSpec;
    }

    /* JADX INFO: renamed from: sharedTransitionAnimatedBackground-9z6LAg8, reason: not valid java name */
    private static final Modifier m11847sharedTransitionAnimatedBackground9z6LAg8(Modifier modifier, AnimatedVisibilityScope animatedVisibilityScope, long j, long j2, Composer composer, int i) {
        Object currentState;
        float f;
        float f2;
        composer.startReplaceGroup(114006015);
        ComposerKt.sourceInformation(composer, "C(sharedTransitionAnimatedBackground)N(animatedVisibilityScope,transitionColor:c#ui.graphics.Color,defaultColor:c#ui.graphics.Color)105@4898L291:TopBarSearchBar.kt#v0zfoc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(114006015, i, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.sharedTransitionAnimatedBackground (TopBarSearchBar.kt:102)");
        }
        if (animatedVisibilityScope == null) {
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(modifier, j2, null, 2, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifierM589backgroundbw27NRU$default;
        }
        final Transition<EnterExitState> transition = animatedVisibilityScope.getTransition();
        Function3 function3 = new Function3() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TopBarSearchBarKt.sharedTransitionAnimatedBackground_9z6LAg8$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1951@83597L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged = composer.changed(transition);
            currentState = composer.rememberedValue();
            if (zChanged || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    EnterExitState currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        EnterExitState enterExitState = (EnterExitState) currentState;
        composer.startReplaceGroup(-1045107331);
        ComposerKt.sourceInformation(composer, "CN(enterExitState):TopBarSearchBar.kt#v0zfoc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1045107331, 0, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.sharedTransitionAnimatedBackground.<anonymous> (TopBarSearchBar.kt:108)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
        if (i2 == 1) {
            f = 0.0f;
        } else if (i2 != 2) {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(f);
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged2 = composer.changed(transition);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<EnterExitState>() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$sharedTransitionAnimatedBackground-9z6LAg8$$inlined$animateFloat$1
                /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.animation.EnterExitState, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final EnterExitState invoke() {
                    return transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EnterExitState enterExitState2 = (EnterExitState) ((State) objRememberedValue).getValue();
        composer.startReplaceGroup(-1045107331);
        ComposerKt.sourceInformation(composer, "CN(enterExitState):TopBarSearchBar.kt#v0zfoc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1045107331, 0, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.sharedTransitionAnimatedBackground.<anonymous> (TopBarSearchBar.kt:108)");
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[enterExitState2.ordinal()];
        if (i3 == 1) {
            f2 = 0.0f;
        } else if (i3 != 2) {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f2 = 0.0f;
        } else {
            f2 = 1.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf2 = Float.valueOf(f2);
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged3 = composer.changed(transition);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<EnterExitState>>() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$sharedTransitionAnimatedBackground-9z6LAg8$$inlined$animateFloat$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<EnterExitState> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transition, fValueOf, fValueOf2, (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue2).getValue(), composer, 0), vectorConverter, "FloatAnimation", composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(modifier, ColorKt.m6865lerpjxsXWHM(j, j2, sharedTransitionAnimatedBackground_9z6LAg8$lambda$2(stateCreateTransitionAnimation)), null, 2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM589backgroundbw27NRU$default2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec sharedTransitionAnimatedBackground_9z6LAg8$lambda$0(Transition.Segment animateFloat, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
        composer.startReplaceGroup(-11036949);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-11036949, i, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.sharedTransitionAnimatedBackground.<anonymous> (TopBarSearchBar.kt:106)");
        }
        TweenSpec tweenSpecAnimationSpec = SearchBarToSearchScreenTransition.INSTANCE.animationSpec();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecAnimationSpec;
    }

    private static final Modifier sharedBoundsModifier(Modifier modifier, SharedTransitionScope sharedTransitionScope, AnimatedVisibilityScope animatedVisibilityScope, RoundedCornerShape roundedCornerShape, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1249981908, "C(sharedBoundsModifier)N(sharedTransitionScope,animatedVisibilityScope,roundedCornerShape):TopBarSearchBar.kt#v0zfoc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1249981908, i, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.sharedBoundsModifier (TopBarSearchBar.kt:122)");
        }
        if (sharedTransitionScope != null && animatedVisibilityScope != null) {
            composer.startReplaceGroup(-844278931);
            ComposerKt.sourceInformation(composer, "*125@5667L52");
            modifier = SharedTransitionScope.sharedBounds$default(sharedTransitionScope, modifier, sharedTransitionScope.rememberSharedContentState(SearchBarToSearchScreenTransition.SEARCH_SCREEN_BOUNDS_KEY, composer, 6), animatedVisibilityScope, EnterExitTransitionKt.fadeIn$default(SearchBarToSearchScreenTransition.INSTANCE.animationSpec(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(SearchBarToSearchScreenTransition.INSTANCE.animationSpec(), 0.0f, 2, null), SearchBarToSearchScreenTransition.INSTANCE.getSearchBoundsTransform(), SharedTransitionScope.ResizeMode.INSTANCE.getRemeasureToBounds(), null, false, 0.0f, sharedTransitionScope.OverlayClip(roundedCornerShape), 448, null);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-843648918);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifier;
    }

    private static final Modifier sharedElementText(Modifier modifier, SharedTransitionScope sharedTransitionScope, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Modifier modifierSharedElement$default;
        ComposerKt.sourceInformationMarkerStart(composer, -2062129672, "C(sharedElementText)N(sharedTransitionScope,animatedVisibilityScope):TopBarSearchBar.kt#v0zfoc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2062129672, i, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.sharedElementText (TopBarSearchBar.kt:143)");
        }
        if (sharedTransitionScope != null && animatedVisibilityScope != null) {
            composer.startReplaceGroup(-1987593935);
            ComposerKt.sourceInformation(composer, "*146@6661L62");
            modifierSharedElement$default = SharedTransitionScope.sharedElement$default(sharedTransitionScope, modifier, sharedTransitionScope.rememberSharedContentState(SearchBarToSearchScreenTransition.SEARCH_SCREEN_PLACEHOLDER_TEXT_KEY, composer, 6), animatedVisibilityScope, SearchBarToSearchScreenTransition.INSTANCE.getSearchBoundsTransform(), null, false, 0.0f, null, 120, null);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1987256066);
            composer.endReplaceGroup();
            modifierSharedElement$default = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierSharedElement$default;
    }

    private static final Modifier sharedElementInputRowContent(Modifier modifier, SharedTransitionScope sharedTransitionScope, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Modifier modifierSharedElement$default;
        ComposerKt.sourceInformationMarkerStart(composer, 647599576, "C(sharedElementInputRowContent)N(sharedTransitionScope,animatedVisibilityScope):TopBarSearchBar.kt#v0zfoc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(647599576, i, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.sharedElementInputRowContent (TopBarSearchBar.kt:164)");
        }
        if (sharedTransitionScope != null && animatedVisibilityScope != null) {
            composer.startReplaceGroup(-353883803);
            ComposerKt.sourceInformation(composer, "*167@7451L63");
            modifierSharedElement$default = SharedTransitionScope.sharedElement$default(sharedTransitionScope, modifier, sharedTransitionScope.rememberSharedContentState(SearchBarToSearchScreenTransition.SEARCH_SCREEN_INPUT_ROW_CONTENT_KEY, composer, 6), animatedVisibilityScope, SearchBarToSearchScreenTransition.INSTANCE.getSearchBoundsTransform(), null, false, 0.0f, null, 120, null);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-353534402);
            composer.endReplaceGroup();
            modifierSharedElement$default = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierSharedElement$default;
    }

    private static final void TopBarSearchBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-245078970);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopBarSearchBarPreview)181@7871L2,181@7828L46:TopBarSearchBar.kt#v0zfoc");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-245078970, i, -1, "com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarPreview (TopBarSearchBar.kt:180)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 702313608, "CC(remember):TopBarSearchBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TopBarSearchBar("Search", (Function0) objRememberedValue, null, composerStartRestartGroup, 54, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.searchbar.TopBarSearchBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TopBarSearchBarKt.TopBarSearchBarPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float animatedCornerShape$lambda$2(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }

    private static final float sharedTransitionAnimatedBackground_9z6LAg8$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }
}
