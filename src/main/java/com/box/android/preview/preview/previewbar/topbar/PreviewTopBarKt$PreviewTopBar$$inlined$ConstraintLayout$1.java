package com.box.android.preview.preview.previewbar.topbar;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.constraintlayout.compose.CompositionSource;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.RawConstraintSet;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxSizes;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$contentDelegate$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
public final class PreviewTopBarKt$PreviewTopBar$$inlined$ConstraintLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ Ref $compositionSource;
    final /* synthetic */ MutableState $contentTracker;
    final /* synthetic */ MutableState $end;
    final /* synthetic */ Transition $renameButtonsTransition$inlined;
    final /* synthetic */ Transition $renameTransition$inlined;
    final /* synthetic */ ConstraintLayoutScope $scope;
    final /* synthetic */ Transition $searchTransition$inlined;
    final /* synthetic */ MutableState $start;
    final /* synthetic */ State $state$delegate$inlined;
    final /* synthetic */ Store $store$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewTopBarKt$PreviewTopBar$$inlined$ConstraintLayout$1(MutableState mutableState, Ref ref, ConstraintLayoutScope constraintLayoutScope, Channel channel, MutableState mutableState2, MutableState mutableState3, Transition transition, Transition transition2, Store store, State state, Transition transition3) {
        super(2);
        this.$contentTracker = mutableState;
        this.$compositionSource = ref;
        this.$scope = constraintLayoutScope;
        this.$channel = channel;
        this.$start = mutableState2;
        this.$end = mutableState3;
        this.$searchTransition$inlined = transition;
        this.$renameButtonsTransition$inlined = transition2;
        this.$store$inlined = store;
        this.$state$delegate$inlined = state;
        this.$renameTransition$inlined = transition3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C381@17480L14,383@17562L681,383@17551L692:ConstraintLayout.kt#fysre8");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-74958949, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
            }
            this.$contentTracker.setValue(Unit.INSTANCE);
            if (this.$compositionSource.getValue() == CompositionSource.Unknown) {
                this.$compositionSource.setValue(CompositionSource.Content);
            }
            this.$scope.reset();
            ConstraintLayoutScope constraintLayoutScope = this.$scope;
            composer.startReplaceGroup(-802479431);
            ComposerKt.sourceInformation(composer, "C87@4435L30,84@4309L1133,110@5600L247,118@5858L839,107@5468L1229,139@6861L62,142@6947L31,145@7170L278,136@6724L724:PreviewTopBar.kt#l0df2e");
            ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope.createRefs();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent3 = constrainedLayoutReferencesCreateRefs.component3();
            Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composer, -718620404, "CC(remember):PreviewTopBar.kt#9igjgp");
            PreviewTopBarKt$PreviewTopBar$1$1$1 previewTopBarKt$PreviewTopBar$1$1$1RememberedValue = composer.rememberedValue();
            if (previewTopBarKt$PreviewTopBar$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                previewTopBarKt$PreviewTopBar$1$1$1RememberedValue = PreviewTopBarKt$PreviewTopBar$1$1$1.INSTANCE;
                composer.updateRememberedValue(previewTopBarKt$PreviewTopBar$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierConstrainAs = constraintLayoutScope.constrainAs(modifierM1252height3ABfNKs, constrainedLayoutReferenceComponent1, (Function1) previewTopBarKt$PreviewTopBar$1$1$1RememberedValue);
            Alignment centerStart = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierConstrainAs);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1026716605, "C90@4578L854,90@4568L864:PreviewTopBar.kt#l0df2e");
            CrossfadeKt.Crossfade(this.$renameButtonsTransition$inlined, (Modifier) null, (FiniteAnimationSpec<Float>) null, (Function1) null, ComposableLambdaKt.rememberComposableLambda(518243432, true, new PreviewTopBarKt$PreviewTopBar$1$2$1(this.$store$inlined, this.$state$delegate$inlined), composer, 54), composer, 24576, 7);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Transition transition = this.$searchTransition$inlined;
            Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composer, -718582907, "CC(remember):PreviewTopBar.kt#9igjgp");
            PreviewTopBarKt$PreviewTopBar$1$3$1 previewTopBarKt$PreviewTopBar$1$3$1RememberedValue = composer.rememberedValue();
            if (previewTopBarKt$PreviewTopBar$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                previewTopBarKt$PreviewTopBar$1$3$1RememberedValue = PreviewTopBarKt$PreviewTopBar$1$3$1.INSTANCE;
                composer.updateRememberedValue(previewTopBarKt$PreviewTopBar$1$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AnimatedContentKt.AnimatedContent(transition, constraintLayoutScope.constrainAs(modifierM1252height3ABfNKs2, constrainedLayoutReferenceComponent2, (Function1) previewTopBarKt$PreviewTopBar$1$3$1RememberedValue), null, null, null, ComposableLambdaKt.rememberComposableLambda(-1619529431, true, new PreviewTopBarKt$PreviewTopBar$1$4(this.$store$inlined, this.$renameTransition$inlined, this.$state$delegate$inlined), composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 14);
            Modifier modifierM1252height3ABfNKs3 = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composer, -718542740, "CC(remember):PreviewTopBar.kt#9igjgp");
            PreviewTopBarKt$PreviewTopBar$1$5$1 previewTopBarKt$PreviewTopBar$1$5$1RememberedValue = composer.rememberedValue();
            if (previewTopBarKt$PreviewTopBar$1$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                previewTopBarKt$PreviewTopBar$1$5$1RememberedValue = PreviewTopBarKt$PreviewTopBar$1$5$1.INSTANCE;
                composer.updateRememberedValue(previewTopBarKt$PreviewTopBar$1$5$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierConstrainAs2 = constraintLayoutScope.constrainAs(modifierM1252height3ABfNKs3, constrainedLayoutReferenceComponent3, (Function1) previewTopBarKt$PreviewTopBar$1$5$1RememberedValue);
            EnterTransition enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.spring$default(0.0f, 200.0f, null, 5, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m389scaleInL8ZKhE$default(AnimationSpecKt.spring$default(0.0f, 200.0f, null, 5, null), 0.0f, 0L, 6, null));
            ExitTransition exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.spring$default(0.0f, 200.0f, null, 5, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m391scaleOutL8ZKhE$default(AnimationSpecKt.spring$default(0.0f, 200.0f, null, 5, null), 0.0f, 0L, 6, null));
            Transition transition2 = this.$searchTransition$inlined;
            ComposerKt.sourceInformationMarkerStart(composer, -718540019, "CC(remember):PreviewTopBar.kt#9igjgp");
            PreviewTopBarKt$PreviewTopBar$1$6$1 previewTopBarKt$PreviewTopBar$1$6$1RememberedValue = composer.rememberedValue();
            if (previewTopBarKt$PreviewTopBar$1$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                previewTopBarKt$PreviewTopBar$1$6$1RememberedValue = PreviewTopBarKt$PreviewTopBar$1$6$1.INSTANCE;
                composer.updateRememberedValue(previewTopBarKt$PreviewTopBar$1$6$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AnimatedVisibilityKt.AnimatedVisibility(transition2, (Function1) previewTopBarKt$PreviewTopBar$1$6$1RememberedValue, modifierConstrainAs2, enterTransitionPlus, exitTransitionPlus, ComposableLambdaKt.rememberComposableLambda(1660379991, true, new PreviewTopBarKt$PreviewTopBar$1$7(this.$renameButtonsTransition$inlined, this.$store$inlined, this.$state$delegate$inlined), composer, 54), composer, 224304, 0);
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer, -1730039667, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(this.$scope) | composer.changedInstance(this.$channel);
            final ConstraintLayoutScope constraintLayoutScope2 = this.$scope;
            final MutableState mutableState = this.$start;
            final MutableState mutableState2 = this.$end;
            final Channel channel = this.$channel;
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$$inlined$ConstraintLayout$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope2.getContainerObject().mo10168clone());
                        if (mutableState.getValue() == null || mutableState2.getValue() == null) {
                            mutableState.setValue(rawConstraintSet);
                            mutableState2.setValue(mutableState.getValue());
                        } else {
                            channel.mo11206trySendJP2dKIU(rawConstraintSet);
                        }
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.SideEffect((Function0) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
