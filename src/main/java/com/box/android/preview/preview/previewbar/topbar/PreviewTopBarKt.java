package com.box.android.preview.preview.previewbar.topbar;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.MoreVertKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.ConstraintSetForInlineDsl;
import androidx.constraintlayout.compose.Measurer;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxSizes;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.base.compose.popup.BoxPopupMenuKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.base.models.ButtonState;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.fileactions.FileAction;
import com.box.android.preview.fileactions.FileActionMapperKt;
import com.box.android.preview.fileactions.UpdateItemInfoMessagesKt;
import com.box.android.preview.fileactions.UpdateItemInfoReducer;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.preview.PreviewReducerHelpersKt;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewTopBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a7\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0003¢\u0006\u0002\u0010\f\u001a7\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0003¢\u0006\u0002\u0010\f\u001a?\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0003¢\u0006\u0002\u0010\u0016\u001aO\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0003¢\u0006\u0002\u0010\u001f\u001a+\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u001cH\u0003¢\u0006\u0002\u0010$¨\u0006%²\u0006\n\u0010\u000b\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002"}, d2 = {"PreviewTopBar", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "PreviewTopBarTitle", "renameTransition", "Landroidx/compose/animation/core/Transition;", "", "state", "(Landroidx/compose/animation/core/Transition;Lcom/box/android/preview/preview/PreviewReducer$State;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "TopBarActionsButton", "renameButtonsTransition", "MoreActionsButton", "moreActionsButtonState", "Lcom/box/android/base/models/ButtonState;", "moreActionsExpanded", "moreActionItems", "", "Lcom/box/android/preview/fileactions/FileAction;", "(Lcom/box/android/base/models/ButtonState;ZLjava/util/List;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "BackOrCancelRenameButton", "isInCancelRenameState", "isCancelRenameEnabled", "isSearchingState", "onCancelRenameClick", "Lkotlin/Function0;", "onPreviewBackClick", "onSearchBackClick", "(ZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ConfirmRenameButton", "isInProgress", "isEnabled", ViewProps.ON_CLICK, "(ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "height", "Landroidx/compose/ui/unit/Dp;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackOrCancelRenameButton$lambda$0(boolean z, boolean z2, boolean z3, Function0 function0, Function0 function1, Function0 function2, int i, Composer composer, int i2) {
        BackOrCancelRenameButton(z, z2, z3, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmRenameButton$lambda$0(boolean z, boolean z2, Function0 function0, int i, Composer composer, int i2) {
        ConfirmRenameButton(z, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreActionsButton$lambda$1(ButtonState buttonState, boolean z, List list, Store store, int i, Composer composer, int i2) {
        MoreActionsButton(buttonState, z, list, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBar$lambda$4(Store store, int i, Composer composer, int i2) {
        PreviewTopBar(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBarTitle$lambda$2(Transition transition, PreviewReducer.State state, Store store, int i, Composer composer, int i2) {
        PreviewTopBarTitle(transition, state, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarActionsButton$lambda$1(Transition transition, PreviewReducer.State state, Store store, int i, Composer composer, int i2) {
        TopBarActionsButton(transition, state, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void PreviewTopBar(final Store<PreviewReducer.State, PreviewReducer.Action> store, Composer composer, final int i) {
        int i2;
        final Store<PreviewReducer.State, PreviewReducer.Action> store2;
        Object currentState;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1644801083);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewTopBar)N(store)66@3331L29,67@3409L63,69@3536L81,70@3645L64,71@3745L162,76@3991L6,77@4076L12,80@4181L6,74@3912L3542:PreviewTopBar.kt#l0df2e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1644801083, i2, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBar (PreviewTopBar.kt:65)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final Transition transitionUpdateTransition = TransitionKt.updateTransition(Boolean.valueOf(PreviewTopBar$lambda$0(stateCollectAsStateWithLifecycle).getIsRenaming()), "rename transition", composerStartRestartGroup, 48, 0);
            final Transition transitionUpdateTransition2 = TransitionKt.updateTransition(Boolean.valueOf(PreviewTopBar$lambda$0(stateCollectAsStateWithLifecycle).getIsExplicitRenameMode()), "rename buttons transition", composerStartRestartGroup, 48, 0);
            final Transition transitionUpdateTransition3 = TransitionKt.updateTransition(Boolean.valueOf(PreviewTopBar$lambda$0(stateCollectAsStateWithLifecycle).getIsSearching()), "search transition", composerStartRestartGroup, 48, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -89793049, "CC(animateDp)N(transitionSpec,label,targetValueByState)1981@85315L75:Transition.kt#pdpnli");
            PreviewTopBarKt$PreviewTopBar$$inlined$animateDp$1 previewTopBarKt$PreviewTopBar$$inlined$animateDp$1 = new Function3<Transition.Segment<Boolean>, Composer, Integer, SpringSpec<Dp>>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$$inlined$animateDp$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ SpringSpec<Dp> invoke(Transition.Segment<Boolean> segment, Composer composer2, Integer num) {
                    return invoke(segment, composer2, num.intValue());
                }

                public final SpringSpec<Dp> invoke(Transition.Segment<Boolean> segment, Composer composer2, int i3) {
                    composer2.startReplaceGroup(-1953972046);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1953972046, i3, -1, "androidx.compose.animation.core.animateDp.<anonymous> (Transition.kt:1977)");
                    }
                    SpringSpec<Dp> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m9685boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
            TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
            if (transitionUpdateTransition.isSeeking()) {
                composerStartRestartGroup.startReplaceGroup(1666827533);
                composerStartRestartGroup.endReplaceGroup();
                currentState = transitionUpdateTransition.getCurrentState();
            } else {
                composerStartRestartGroup.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1844@78495L67");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054612652, "CC(remember):Transition.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(transitionUpdateTransition);
                currentState = composerStartRestartGroup.rememberedValue();
                if (zChanged || currentState == Composer.INSTANCE.getEmpty()) {
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        Object currentState2 = transitionUpdateTransition.getCurrentState();
                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        composerStartRestartGroup.updateRememberedValue(currentState2);
                        currentState = currentState2;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            boolean zBooleanValue = ((Boolean) currentState).booleanValue();
            composerStartRestartGroup.startReplaceGroup(569142868);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):PreviewTopBar.kt#l0df2e");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(569142868, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBar.<anonymous> (PreviewTopBar.kt:72)");
            }
            float fM11610getExpandedRenameTopBarHeightD9Ej5fM = zBooleanValue ? BoxSizes.INSTANCE.m11610getExpandedRenameTopBarHeightD9Ej5fM() : BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Dp dpM9685boximpl = Dp.m9685boximpl(fM11610getExpandedRenameTopBarHeightD9Ej5fM);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054592958, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$$inlined$animateDp$2
                    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Boolean, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return transitionUpdateTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zBooleanValue2 = ((Boolean) ((State) objRememberedValue).getValue()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(569142868);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(isRenaming):PreviewTopBar.kt#l0df2e");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(569142868, 0, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBar.<anonymous> (PreviewTopBar.kt:72)");
            }
            BoxSizes boxSizes = BoxSizes.INSTANCE;
            float fM11610getExpandedRenameTopBarHeightD9Ej5fM2 = zBooleanValue2 ? boxSizes.m11610getExpandedRenameTopBarHeightD9Ej5fM() : boxSizes.m11614getTopBarHeightD9Ej5fM();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Dp dpM9685boximpl2 = Dp.m9685boximpl(fM11610getExpandedRenameTopBarHeightD9Ej5fM2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054589890, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<Boolean>>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$$inlined$animateDp$3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<Boolean> invoke() {
                        return transitionUpdateTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, dpM9685boximpl, dpM9685boximpl2, previewTopBarKt$PreviewTopBar$$inlined$animateDp$1.invoke(((State) objRememberedValue2).getValue(), composerStartRestartGroup, 0), vectorConverter, "rename toolbar height transition", composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag = TestTagKt.testTag(ComposeUtilsKt.m11635bottomBorderHht5A8o$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11576getTopBarBackgroundSecondary0d7_KjU(), null, 2, null), TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable)), PreviewTopBar$lambda$2(stateCreateTransitionAnimation)), 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11517getDivider0d7_KjU(), 0.0f, 2, null), "Preview:TopBar");
            composerStartRestartGroup.startReplaceGroup(-1003410150);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
            composerStartRestartGroup.startReplaceGroup(212064437);
            ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
            composerStartRestartGroup.endReplaceGroup();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Measurer(density);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final Measurer measurer = (Measurer) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new ConstraintLayoutScope();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
            final int i3 = 257;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$$inlined$ConstraintLayout$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List<? extends Measurable> list, long j) {
                        mutableState2.getValue();
                        long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i3);
                        mutableState.getValue();
                        int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                        int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                        final Measurer measurer2 = measurer;
                        return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$$inlined$ConstraintLayout$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                measurer2.performLayout(placementScope, list);
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = (Function0) new Function0<Unit>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$$inlined$ConstraintLayout$3
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
                        MutableState mutableState3 = mutableState;
                        mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                        constraintSetForInlineDsl.setKnownDirty(true);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            final Function0 function0 = (Function0) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$$inlined$ConstraintLayout$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierTestTag, false, (Function1) objRememberedValue9, 1, null);
            Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$$inlined$ConstraintLayout$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ComposerKt.sourceInformation(composer2, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                    if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1200550679, i4, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                        }
                        mutableState2.setValue(Unit.INSTANCE);
                        int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                        constraintLayoutScope.reset();
                        ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                        composer2.startReplaceGroup(-802479431);
                        ComposerKt.sourceInformation(composer2, "C87@4435L30,84@4309L1133,110@5600L247,118@5858L839,107@5468L1229,139@6861L62,142@6947L31,145@7170L278,136@6724L724:PreviewTopBar.kt#l0df2e");
                        ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent3 = constrainedLayoutReferencesCreateRefs.component3();
                        Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
                        ComposerKt.sourceInformationMarkerStart(composer2, -718620404, "CC(remember):PreviewTopBar.kt#9igjgp");
                        PreviewTopBarKt$PreviewTopBar$1$1$1 previewTopBarKt$PreviewTopBar$1$1$1RememberedValue = composer2.rememberedValue();
                        if (previewTopBarKt$PreviewTopBar$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previewTopBarKt$PreviewTopBar$1$1$1RememberedValue = PreviewTopBarKt$PreviewTopBar$1$1$1.INSTANCE;
                            composer2.updateRememberedValue(previewTopBarKt$PreviewTopBar$1$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1252height3ABfNKs, constrainedLayoutReferenceComponent1, (Function1) previewTopBarKt$PreviewTopBar$1$1$1RememberedValue);
                        Alignment centerStart = Alignment.INSTANCE.getCenterStart();
                        ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierConstrainAs);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1026716605, "C90@4578L854,90@4568L864:PreviewTopBar.kt#l0df2e");
                        CrossfadeKt.Crossfade(transitionUpdateTransition2, (Modifier) null, (FiniteAnimationSpec<Float>) null, (Function1) null, ComposableLambdaKt.rememberComposableLambda(518243432, true, new PreviewTopBarKt$PreviewTopBar$1$2$1(store, stateCollectAsStateWithLifecycle), composer2, 54), composer2, 24576, 7);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Transition transition = transitionUpdateTransition3;
                        Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
                        ComposerKt.sourceInformationMarkerStart(composer2, -718582907, "CC(remember):PreviewTopBar.kt#9igjgp");
                        PreviewTopBarKt$PreviewTopBar$1$3$1 previewTopBarKt$PreviewTopBar$1$3$1RememberedValue = composer2.rememberedValue();
                        if (previewTopBarKt$PreviewTopBar$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previewTopBarKt$PreviewTopBar$1$3$1RememberedValue = PreviewTopBarKt$PreviewTopBar$1$3$1.INSTANCE;
                            composer2.updateRememberedValue(previewTopBarKt$PreviewTopBar$1$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        AnimatedContentKt.AnimatedContent(transition, constraintLayoutScope2.constrainAs(modifierM1252height3ABfNKs2, constrainedLayoutReferenceComponent2, (Function1) previewTopBarKt$PreviewTopBar$1$3$1RememberedValue), null, null, null, ComposableLambdaKt.rememberComposableLambda(-1619529431, true, new PreviewTopBarKt$PreviewTopBar$1$4(store, transitionUpdateTransition, stateCollectAsStateWithLifecycle), composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 14);
                        Modifier modifierM1252height3ABfNKs3 = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM());
                        ComposerKt.sourceInformationMarkerStart(composer2, -718542740, "CC(remember):PreviewTopBar.kt#9igjgp");
                        PreviewTopBarKt$PreviewTopBar$1$5$1 previewTopBarKt$PreviewTopBar$1$5$1RememberedValue = composer2.rememberedValue();
                        if (previewTopBarKt$PreviewTopBar$1$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previewTopBarKt$PreviewTopBar$1$5$1RememberedValue = PreviewTopBarKt$PreviewTopBar$1$5$1.INSTANCE;
                            composer2.updateRememberedValue(previewTopBarKt$PreviewTopBar$1$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        Modifier modifierConstrainAs2 = constraintLayoutScope2.constrainAs(modifierM1252height3ABfNKs3, constrainedLayoutReferenceComponent3, (Function1) previewTopBarKt$PreviewTopBar$1$5$1RememberedValue);
                        EnterTransition enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.spring$default(0.0f, 200.0f, null, 5, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m389scaleInL8ZKhE$default(AnimationSpecKt.spring$default(0.0f, 200.0f, null, 5, null), 0.0f, 0L, 6, null));
                        ExitTransition exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.spring$default(0.0f, 200.0f, null, 5, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m391scaleOutL8ZKhE$default(AnimationSpecKt.spring$default(0.0f, 200.0f, null, 5, null), 0.0f, 0L, 6, null));
                        Transition transition2 = transitionUpdateTransition3;
                        ComposerKt.sourceInformationMarkerStart(composer2, -718540019, "CC(remember):PreviewTopBar.kt#9igjgp");
                        PreviewTopBarKt$PreviewTopBar$1$6$1 previewTopBarKt$PreviewTopBar$1$6$1RememberedValue = composer2.rememberedValue();
                        if (previewTopBarKt$PreviewTopBar$1$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previewTopBarKt$PreviewTopBar$1$6$1RememberedValue = PreviewTopBarKt$PreviewTopBar$1$6$1.INSTANCE;
                            composer2.updateRememberedValue(previewTopBarKt$PreviewTopBar$1$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        AnimatedVisibilityKt.AnimatedVisibility(transition2, (Function1) previewTopBarKt$PreviewTopBar$1$6$1RememberedValue, modifierConstrainAs2, enterTransitionPlus, exitTransitionPlus, ComposableLambdaKt.rememberComposableLambda(1660379991, true, new PreviewTopBarKt$PreviewTopBar$1$7(transitionUpdateTransition2, store, stateCollectAsStateWithLifecycle), composer2, 54), composer2, 224304, 0);
                        composer2.endReplaceGroup();
                        if (constraintLayoutScope.getHelpersHashCode() != helpersHashCode) {
                            EffectsKt.SideEffect(function0, composer2, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            };
            store2 = store;
            LayoutKt.MultiMeasureLayout(modifierSemantics$default, ComposableLambdaKt.rememberComposableLambda(1200550679, true, function2, composerStartRestartGroup, 54), measurePolicy, composerStartRestartGroup, 48, 0);
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            store2 = store;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewTopBarKt.PreviewTopBar$lambda$4(store2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:72:0x0118  */
    /* JADX WARN: Code duplicated, block: B:73:0x011a  */
    /* JADX WARN: Code duplicated, block: B:78:0x012a  */
    /* JADX WARN: Code duplicated, block: B:81:0x014f  */
    public static final void PreviewTopBarTitle(final Transition<Boolean> transition, final PreviewReducer.State state, final Store<PreviewReducer.State, PreviewReducer.Action> store, Composer composer, final int i) {
        int i2;
        String name;
        int i3;
        boolean z;
        boolean z2;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-942647009);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewTopBarTitle)N(renameTransition,state,store)173@8219L196,180@8443L319,165@7714L1054:PreviewTopBar.kt#l0df2e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(state) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-942647009, i2, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBarTitle (PreviewTopBar.kt:162)");
            }
            final UpdateItemInfoReducer.State renameItemState = state.getFileActionsState().getRenameItemState();
            if (renameItemState == null || (name = renameItemState.getUpdatedName()) == null) {
                name = state.getFileModel().getName();
            }
            TopBarReducer.SubtitleState subtitle = state.getTopBarState().getSubtitle();
            String str = name;
            boolean isRenaming = state.getIsRenaming();
            boolean z3 = state.getIsExplicitRenameMode() || state.isNewlyCreatedFile();
            boolean z4 = state.getIsPermanentRenameMode() && renameItemState != null && renameItemState.isRenamePending();
            String message = null;
            UpdateItemInfoReducer.NameError nameError = renameItemState != null ? renameItemState.getNameError() : null;
            if (nameError == null) {
                composerStartRestartGroup.startReplaceGroup(-1900168137);
            } else {
                composerStartRestartGroup.startReplaceGroup(354346250);
                ComposerKt.sourceInformation(composerStartRestartGroup, "172@8179L11");
                message = UpdateItemInfoMessagesKt.toMessage(nameError, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 354347715, "CC(remember):PreviewTopBar.kt#9igjgp");
            int i4 = i2 & 896;
            boolean z5 = i4 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z5) {
                i3 = i2;
            } else {
                i3 = i2;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                Function1 function1 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 354355006, "CC(remember):PreviewTopBar.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(state) | composerStartRestartGroup.changedInstance(renameItemState);
                if (i4 == 256) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = zChangedInstance | z;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PreviewTopBarKt.PreviewTopBarTitle$lambda$1$0(state, renameItemState, store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TopBarTitleKt.PreviewTopBarTitle(str, subtitle, isRenaming, z3, z4, transition, message, function1, (Function0) objRememberedValue, null, composerStartRestartGroup, (i3 << 15) & 458752, 512);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            objRememberedValue2 = new Function1() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PreviewTopBarKt.PreviewTopBarTitle$lambda$0$0(store, (String) obj);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            Function1 function2 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 354355006, "CC(remember):PreviewTopBar.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(state) | composerStartRestartGroup.changedInstance(renameItemState);
            if (i4 == 256) {
                z = true;
            } else {
                z = false;
            }
            z2 = zChangedInstance2 | z;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreviewTopBarKt.PreviewTopBarTitle$lambda$1$0(state, renameItemState, store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreviewTopBarKt.PreviewTopBarTitle$lambda$1$0(state, renameItemState, store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TopBarTitleKt.PreviewTopBarTitle(str, subtitle, isRenaming, z3, z4, transition, message, function2, (Function0) objRememberedValue, null, composerStartRestartGroup, (i3 << 15) & 458752, 512);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewTopBarKt.PreviewTopBarTitle$lambda$2(transition, state, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBarTitle$lambda$0$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(PreviewReducerHelpersKt.rename(PreviewReducer.Action.FileActionsAction.INSTANCE, new UpdateItemInfoReducer.Action.NameUpdated(it)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTopBarTitle$lambda$1$0(PreviewReducer.State state, UpdateItemInfoReducer.State state2, Store store) {
        if (state.getIsPermanentRenameMode() && (state2 == null || !state2.isRenamePending())) {
            store.send(PreviewReducerHelpersKt.rename(PreviewReducer.Action.FileActionsAction.INSTANCE, UpdateItemInfoReducer.Action.PerformUpdate.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TopBarActionsButton(Transition<Boolean> transition, final PreviewReducer.State state, final Store<PreviewReducer.State, PreviewReducer.Action> store, Composer composer, final int i) {
        int i2;
        final Transition<Boolean> transition2;
        Composer composerStartRestartGroup = composer.startRestartGroup(755034274);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TopBarActionsButton)N(renameButtonsTransition,state,store)198@9010L1036,198@8994L1052:PreviewTopBar.kt#l0df2e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(state) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            transition2 = transition;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755034274, i2, -1, "com.box.android.preview.preview.previewbar.topbar.TopBarActionsButton (PreviewTopBar.kt:197)");
            }
            transition2 = transition;
            AnimatedContentKt.AnimatedContent(transition2, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-846960025, true, new Function4() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return PreviewTopBarKt.TopBarActionsButton$lambda$0(state, store, (AnimatedContentScope) obj, ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewTopBarKt.TopBarActionsButton$lambda$1(transition2, state, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarActionsButton$lambda$0(PreviewReducer.State state, final Store store, AnimatedContentScope AnimatedContent, boolean z, Composer composer, int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation(composer, "CN(isRenaming)213@9611L429:PreviewTopBar.kt#l0df2e");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-846960025, i, -1, "com.box.android.preview.preview.previewbar.topbar.TopBarActionsButton.<anonymous> (PreviewTopBar.kt:199)");
        }
        if (z) {
            composer.startReplaceGroup(1146816019);
            ComposerKt.sourceInformation(composer, "203@9301L242,200@9064L493");
            UpdateItemInfoReducer.State renameItemState = state.getFileActionsState().getRenameItemState();
            boolean z2 = renameItemState != null && renameItemState.isRenamePending();
            UpdateItemInfoReducer.State renameItemState2 = state.getFileActionsState().getRenameItemState();
            boolean z3 = renameItemState2 != null && renameItemState2.isConfirmEnabled();
            ComposerKt.sourceInformationMarkerStart(composer, 2115211769, "CC(remember):PreviewTopBar.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreviewTopBarKt.TopBarActionsButton$lambda$0$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ConfirmRenameButton(z2, z3, (Function0) objRememberedValue, composer, 0);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
        composer.startReplaceGroup(1137820315);
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
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
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 225625199, "C:PreviewTopBar.kt#l0df2e");
        if (!state.getTopBarState().getMoreActionsButtonState().isVisible()) {
            composer2 = composer;
            composer2.startReplaceGroup(216059807);
        } else {
            composer.startReplaceGroup(225680936);
            ComposerKt.sourceInformation(composer, "215@9705L311");
            composer2 = composer;
            MoreActionsButton(state.getTopBarState().getMoreActionsButtonState(), state.getTopBarState().getMoreActionsExpanded(), state.getTopBarState().getMoreActionItems(), store, composer2, 0);
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarActionsButton$lambda$0$0$0(Store store) {
        store.send(PreviewReducerHelpersKt.rename(PreviewReducer.Action.FileActionsAction.INSTANCE, UpdateItemInfoReducer.Action.PerformUpdate.INSTANCE));
        return Unit.INSTANCE;
    }

    private static final void MoreActionsButton(final ButtonState buttonState, final boolean z, final List<? extends FileAction> list, final Store<PreviewReducer.State, PreviewReducer.Action> store, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-453247370);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MoreActionsButton)N(moreActionsButtonState,moreActionsExpanded,moreActionItems,store)233@10277L790:PreviewTopBar.kt#l0df2e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(buttonState.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        } else {
            z2 = z;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-453247370, i2, -1, "com.box.android.preview.preview.previewbar.topbar.MoreActionsButton (PreviewTopBar.kt:232)");
            }
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -763553787, "C239@10659L52,238@10548L72,234@10291L444,244@10826L73,242@10744L317:PreviewTopBar.kt#l0df2e");
            ButtonItemIconResource.ImageVectorResource imageVectorResource = new ButtonItemIconResource.ImageVectorResource(MoreVertKt.getMoreVert(Icons.Outlined.INSTANCE));
            boolean zIsEnabled = buttonState.isEnabled();
            String strStringResource = StringResources_androidKt.stringResource(R.string.more_actions_talkback_label, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1499397412, "CC(remember):PreviewTopBar.kt#9igjgp");
            int i3 = i2 & 7168;
            boolean z3 = i3 == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreviewTopBarKt.MoreActionsButton$lambda$0$0$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(zIsEnabled, (Function0) objRememberedValue, strStringResource, imageVectorResource, false, 16, null), null, null, 0L, 0.0f, composerStartRestartGroup, 0, 30);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1499406309, "CC(remember):PreviewTopBar.kt#9igjgp");
            boolean z4 = i3 == 2048;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreviewTopBarKt.MoreActionsButton$lambda$0$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxPopupMenuKt.m11733BoxPopupMenuUTokNlU(z2, (Function0) objRememberedValue2, FileActionMapperKt.mapToPopupMenuItem(list, store), null, null, DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(-8))) << 32) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(16))) & 4294967295L)), composerStartRestartGroup, ((i2 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewTopBarKt.MoreActionsButton$lambda$1(buttonState, z, list, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreActionsButton$lambda$0$0$0(Store store) {
        store.send(PreviewReducerHelpersKt.showMoreActionsMenu(PreviewReducer.Action.TopBarAction.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoreActionsButton$lambda$0$1$0(Store store) {
        store.send(PreviewReducerHelpersKt.closeMoreActionsMenu(PreviewReducer.Action.TopBarAction.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackOrCancelRenameButton(final boolean z, final boolean z2, final boolean z3, final Function0<Unit> function0, Function0<Unit> function1, final Function0<Unit> function2, Composer composer, final int i) {
        int i2;
        boolean z4;
        Function0<Unit> function3;
        Function0<Unit> function4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1264878488);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackOrCancelRenameButton)N(isInCancelRenameState,isCancelRenameEnabled,isSearchingState,onCancelRenameClick,onPreviewBackClick,onSearchBackClick):PreviewTopBar.kt#l0df2e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            z4 = z2;
            i2 |= composerStartRestartGroup.changed(z4) ? 32 : 16;
        } else {
            z4 = z2;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function3 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        } else {
            function3 = function0;
        }
        if ((i & 24576) == 0) {
            function4 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
        } else {
            function4 = function1;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1264878488, i2, -1, "com.box.android.preview.preview.previewbar.topbar.BackOrCancelRenameButton (PreviewTopBar.kt:259)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-2047734111);
                ComposerKt.sourceInformation(composerStartRestartGroup, "266@11676L53,261@11376L377");
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(z4, function3, StringResources_androidKt.stringResource(R.string.cancel_rename_talkback_label, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_close_24dp), false, 16, null), null, null, 0L, 0.0f, composerStartRestartGroup, 0, 30);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2047338210);
                ComposerKt.sourceInformation(composerStartRestartGroup, "274@12078L53,270@11775L380");
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, z3 ? function2 : function4, StringResources_androidKt.stringResource(R.string.close_preview_talkback_label, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left_secondary), false, 17, null), null, null, 0L, 0.0f, composerStartRestartGroup, 0, 30);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function5 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewTopBarKt.BackOrCancelRenameButton$lambda$0(z, z2, z3, function0, function5, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ConfirmRenameButton(final boolean z, final boolean z2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-706944212);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConfirmRenameButton)N(isInProgress,isEnabled,onClick):PreviewTopBar.kt#l0df2e");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-706944212, i2, -1, "com.box.android.preview.preview.previewbar.topbar.ConfirmRenameButton (PreviewTopBar.kt:281)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1944715400);
                ComposerKt.sourceInformation(composerStartRestartGroup, "283@12307L126");
                BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(SizeKt.m1266size3ABfNKs(PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), Dp.m9687constructorimpl(24)), null, 0L, 0L, 0.0f, 0, null, composerStartRestartGroup, 6, 126);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(1944869501);
                ComposerKt.sourceInformation(composerStartRestartGroup, "294@12738L54,289@12455L361");
                composer2 = composerStartRestartGroup;
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(z2, function0, StringResources_androidKt.stringResource(R.string.confirm_rename_talkback_label, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_baseline_check_24), false, 16, null), null, null, 0L, 0.0f, composer2, 0, 30);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewTopBarKt.ConfirmRenameButton$lambda$0(z, z2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewReducer.State PreviewTopBar$lambda$0(State<PreviewReducer.State> state) {
        return state.getValue();
    }

    private static final float PreviewTopBar$lambda$2(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }
}
