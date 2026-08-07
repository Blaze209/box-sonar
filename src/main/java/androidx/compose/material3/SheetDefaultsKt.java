package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.configurations.GuideCapping;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001aW\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\"\u0010\u0010\u001d\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"DragHandleWithTooltip", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Lkotlin/Function1;", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "positionalThreshold", "Landroidx/compose/ui/unit/Dp;", "velocityThreshold", "rememberSheetState-AGcomas", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "DragHandleVerticalPadding", "F", "BottomSheetAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getBottomSheetAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SheetDefaultsKt {
    private static final float DragHandleVerticalPadding = Dp.m9687constructorimpl(22);
    private static final AnimationSpec<Float> BottomSheetAnimationSpec = AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandleWithTooltip$lambda$1(Modifier modifier, Function2 function2, int i, Composer composer, int i2) {
        DragHandleWithTooltip(modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberSheetState_AGcomas$lambda$0$0(SheetValue sheetValue) {
        return true;
    }

    public static final void DragHandleWithTooltip(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1361920385);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DragHandleWithTooltip)N(modifier,content)443@18499L51,444@18555L408:SheetDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1361920385, i2, -1, "androidx.compose.material3.DragHandleWithTooltip (SheetDefaults.kt:442)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_drag_handle_description), composerStartRestartGroup, 0);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 124564130, "C448@18739L60,450@18893L22,449@18823L48,445@18631L326:SheetDefaults.kt#uh7d8r");
            composer2 = composerStartRestartGroup;
            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composer2, 390, 2), ComposableLambdaKt.rememberComposableLambda(1497042086, true, new Function3() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SheetDefaultsKt.DragHandleWithTooltip$lambda$0$0(strM5086getString2EP1pXo, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composer2, 0, 7), modifier, null, false, false, false, function2, composerStartRestartGroup, ((i2 << 9) & 7168) | 48 | ((i2 << 21) & 234881024), PsExtractor.VIDEO_STREAM_MASK);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SheetDefaultsKt.DragHandleWithTooltip$lambda$1(modifier, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandleWithTooltip$lambda$0$0(final String str, TooltipScope tooltipScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C449@18838L31,449@18825L44:SheetDefaults.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(tooltipScope) : composer.changedInstance(tooltipScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1497042086, i2, -1, "androidx.compose.material3.DragHandleWithTooltip.<anonymous>.<anonymous> (SheetDefaults.kt:449)");
            }
            TooltipKt.m4746PlainTooltipgv3ox5I(tooltipScope, null, null, 0.0f, null, 0L, 0L, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(435848468, true, new Function2() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SheetDefaultsKt.DragHandleWithTooltip$lambda$0$0$0(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (i2 & 14) | 805306368, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DragHandleWithTooltip$lambda$0$0$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C449@18840L27:SheetDefaults.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(435848468, i, -1, "androidx.compose.material3.DragHandleWithTooltip.<anonymous>.<anonymous>.<anonymous> (SheetDefaults.kt:449)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: SheetDefaults.kt */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/material3/SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", GuideCapping.INSERT_CAPPING_CONSUMED, "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ FlingBehavior $flingBehavior;
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ SheetState $sheetState;

        AnonymousClass1(SheetState sheetState, FlingBehavior flingBehavior, Orientation orientation) {
            this.$sheetState = sheetState;
            this.$flingBehavior = flingBehavior;
            this.$orientation = orientation;
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
        public long mo1299onPreScrollOzD1aCk(long available, int source) {
            float fOffsetToFloat = offsetToFloat(available);
            if (fOffsetToFloat < 0.0f && NestedScrollSource.m8002equalsimpl0(source, NestedScrollSource.INSTANCE.m8014getUserInputWNlRxjI())) {
                return toOffset(this.$sheetState.getAnchoredDraggableState$material3().dispatchRawDelta(fOffsetToFloat));
            }
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public long mo946onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (NestedScrollSource.m8002equalsimpl0(source, NestedScrollSource.INSTANCE.m8014getUserInputWNlRxjI())) {
                return toOffset(this.$sheetState.getAnchoredDraggableState$material3().dispatchRawDelta(offsetToFloat(available)));
            }
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo */
        public Object mo1298onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
            SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1;
            if (continuation instanceof SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) {
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = (SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) continuation;
                if ((sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                    sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
                } else {
                    sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, continuation);
                }
            } else {
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, continuation);
            }
            Object obj = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = this.$sheetState.requireOffset();
                float fMinPosition = this.$sheetState.getAnchoredDraggableState$material3().getAnchors().minPosition();
                if (fVelocityToFloat < 0.0f && fRequireOffset > fMinPosition) {
                    SheetState sheetState = this.$sheetState;
                    FlingBehavior flingBehavior = this.$flingBehavior;
                    sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0 = j;
                    sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = 1;
                    if (sheetState.anchoredDrag$material3(flingBehavior, fVelocityToFloat, sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    j = Velocity.INSTANCE.m9936getZero9UxMQ8M();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0;
                ResultKt.throwOnFailure(obj);
            }
            return Velocity.m9916boximpl(j);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
            SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1;
            if (continuation instanceof SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) {
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = (SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) continuation;
                if ((sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                    sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                } else {
                    sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, continuation);
                }
            } else {
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, continuation);
            }
            Object objAnchoredDrag$material3 = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(objAnchoredDrag$material3);
                float fVelocityToFloat = velocityToFloat(j2);
                SheetState sheetState = this.$sheetState;
                FlingBehavior flingBehavior = this.$flingBehavior;
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0 = j;
                sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = 1;
                objAnchoredDrag$material3 = sheetState.anchoredDrag$material3(flingBehavior, fVelocityToFloat, sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1);
                if (objAnchoredDrag$material3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = sheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0;
                ResultKt.throwOnFailure(objAnchoredDrag$material3);
            }
            return Velocity.m9916boximpl(VelocityKt.Velocity(Velocity.m9925getXimpl(j), ((Number) objAnchoredDrag$material3).floatValue()));
        }

        private final long toOffset(float f) {
            float f2 = this.$orientation == Orientation.Horizontal ? f : 0.0f;
            if (this.$orientation != Orientation.Vertical) {
                f = 0.0f;
            }
            return Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f)) & 4294967295L) | (((long) Float.floatToRawIntBits(f2)) << 32));
        }

        private final float velocityToFloat(long j) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m9925getXimpl(j) : Velocity.m9926getYimpl(j);
        }

        private final float offsetToFloat(long j) {
            return Float.intBitsToFloat((int) (this.$orientation == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
        }
    }

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(SheetState sheetState, Orientation orientation, FlingBehavior flingBehavior) {
        return new AnonymousClass1(sheetState, flingBehavior, orientation);
    }

    /* JADX INFO: renamed from: rememberSheetState-AGcomas, reason: not valid java name */
    public static final SheetState m4161rememberSheetStateAGcomas(boolean z, Function1<? super SheetValue, Boolean> function1, SheetValue sheetValue, boolean z2, float f, float f2, Composer composer, int i, int i2) {
        final Function1<? super SheetValue, Boolean> function2;
        ComposerKt.sourceInformationMarkerStart(composer, -20307384, "C(rememberSheetState)N(skipPartiallyExpanded,confirmValueChange,initialValue,skipHiddenState,positionalThreshold:c#ui.unit.Dp,velocityThreshold:c#ui.unit.Dp)520@21583L8,526@21855L7,527@21897L48,528@21978L46,541@22498L231,529@22036L693:SheetDefaults.kt#uh7d8r");
        final boolean z3 = (i2 & 1) != 0 ? false : z;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 1959444240, "CC(remember):SheetDefaults.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SheetDefaultsKt.rememberSheetState_AGcomas$lambda$0$0((SheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function2 = (Function1) objRememberedValue;
        } else {
            function2 = function1;
        }
        final SheetValue sheetValue2 = (i2 & 4) != 0 ? SheetValue.Hidden : sheetValue;
        final boolean z4 = (i2 & 8) != 0 ? false : z2;
        final float fM2814getPositionalThresholdD9Ej5fM$material3 = (i2 & 16) != 0 ? BottomSheetDefaults.INSTANCE.m2814getPositionalThresholdD9Ej5fM$material3() : f;
        final float fM2817getVelocityThresholdD9Ej5fM$material3 = (i2 & 32) != 0 ? BottomSheetDefaults.INSTANCE.m2817getVelocityThresholdD9Ej5fM$material3() : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20307384, i, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:525)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, 1959454328, "CC(remember):SheetDefaults.kt#9igjgp");
        boolean z5 = true;
        boolean zChanged = composer.changed(density) | ((((57344 & i) ^ 24576) > 16384 && composer.changed(fM2814getPositionalThresholdD9Ej5fM$material3)) || (i & 24576) == 16384);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(density.mo754toPx0680j_4(fM2814getPositionalThresholdD9Ej5fM$material3));
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        final Function0<Float> function0 = (Function0) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1959456918, "CC(remember):SheetDefaults.kt#9igjgp");
        boolean zChanged2 = composer.changed(density) | ((((458752 & i) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(fM2817getVelocityThresholdD9Ej5fM$material3)) || (i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(density.mo754toPx0680j_4(fM2817getVelocityThresholdD9Ej5fM$material3));
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        final Function0<Float> function3 = (Function0) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object[] objArr = {Boolean.valueOf(z3), function2, Boolean.valueOf(z4)};
        Saver<SheetState, SheetValue> Saver = SheetState.INSTANCE.Saver(z3, function0, function3, function2, z4);
        ComposerKt.sourceInformationMarkerStart(composer, 1959473743, "CC(remember):SheetDefaults.kt#9igjgp");
        boolean zChanged3 = ((((i & 14) ^ 6) > 4 && composer.changed(z3)) || (i & 6) == 4) | composer.changed(function0) | composer.changed(function3) | ((((i & 896) ^ 384) > 256 && composer.changed(sheetValue2.ordinal())) || (i & 384) == 256) | ((((i & 112) ^ 48) > 32 && composer.changed(function2)) || (i & 48) == 32);
        if ((((i & 7168) ^ 3072) <= 2048 || !composer.changed(z4)) && (i & 3072) != 2048) {
            z5 = false;
        }
        boolean z6 = zChanged3 | z5;
        Object objRememberedValue4 = composer.rememberedValue();
        if (z6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SheetDefaultsKt.rememberSheetState_AGcomas$lambda$3$0(z3, function0, function3, sheetValue2, function2, z4);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SheetState sheetState = (SheetState) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue4, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SheetState rememberSheetState_AGcomas$lambda$3$0(boolean z, Function0 function0, Function0 function1, SheetValue sheetValue, Function1 function2, boolean z2) {
        return new SheetState(z, function0, function1, sheetValue, function2, z2);
    }

    public static final AnimationSpec<Float> getBottomSheetAnimationSpec() {
        return BottomSheetAnimationSpec;
    }
}
