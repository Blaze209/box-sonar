package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.actions.configurations.GuideCapping;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\n\u001a!\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001aý\u0001\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\f2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020&2\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b-\u0010.\u001ao\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020$2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010+\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\b¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0004\b1\u00102\u001a\u0098\u0001\u00103\u001a\u00020\u00122\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\u0011\u00104\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u00152\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u00152\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b¢\u0006\u0002\b\u00152\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\u0002\b\u00152\u0006\u0010(\u001a\u00020$2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u0001H\u0003¢\u0006\u0004\b8\u00109\u001a\u001c\u0010:\u001a\u00020;2\n\u00100\u001a\u0006\u0012\u0002\b\u00030<2\u0006\u0010=\u001a\u00020>H\u0002\"\u0010\u0010?\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@¨\u0006C"}, d2 = {"rememberBottomSheetState", "Landroidx/compose/material/BottomSheetState;", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "rememberBottomSheetScaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "bottomSheetState", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "(Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "BottomSheetScaffold", "", "sheetContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "topBar", "Lkotlin/Function0;", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetGesturesEnabled", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "Landroidx/compose/ui/unit/Dp;", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "backgroundColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-HnlDQGw", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheet", "state", "BottomSheet-dAqlCkY", "(Landroidx/compose/material/BottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJFLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "sheetState", "BottomSheetScaffoldLayout-HJHHjMs", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;ILandroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "FabSpacing", "F", "BottomSheetScaffoldPositionalThreshold", "BottomSheetScaffoldVelocityThreshold", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetScaffoldKt {
    private static final float FabSpacing = Dp.m9687constructorimpl(16);
    private static final float BottomSheetScaffoldPositionalThreshold = Dp.m9687constructorimpl(56);
    private static final float BottomSheetScaffoldVelocityThreshold = Dp.m9687constructorimpl(125);

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BottomSheetValue.values().length];
            try {
                iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BottomSheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffoldLayout_HJHHjMs$lambda$1(Function2 function2, Function2 function3, Function2 function4, Function2 function5, Function2 function6, float f, Function0 function0, int i, BottomSheetState bottomSheetState, int i2, Composer composer, int i3) {
        m2298BottomSheetScaffoldLayoutHJHHjMs(function2, function3, function4, function5, function6, f, function0, i, bottomSheetState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_HnlDQGw$lambda$1(Function3 function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, Function2 function2, Function3 function4, Function2 function5, int i, boolean z, Shape shape, float f, long j, long j2, float f2, long j3, long j4, Function3 function6, int i2, int i3, int i4, Composer composer, int i5) {
        m2297BottomSheetScaffoldHnlDQGw(function3, modifier, bottomSheetScaffoldState, function2, function4, function5, i, z, shape, f, j, j2, f2, j3, j4, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheet_dAqlCkY$lambda$4(BottomSheetState bottomSheetState, boolean z, Shape shape, float f, long j, long j2, float f2, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2296BottomSheetdAqlCkY(bottomSheetState, z, shape, f, j, j2, f2, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberBottomSheetState$lambda$0$0(BottomSheetValue bottomSheetValue) {
        return true;
    }

    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue bottomSheetValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1808153344, "C(rememberBottomSheetState)N(initialValue,animationSpec,confirmStateChange)223@8800L8,225@8863L7,234@9135L211,226@8882L464:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = BottomSheetScaffoldDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1826384664, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(BottomSheetScaffoldKt.rememberBottomSheetState$lambda$0$0((BottomSheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, i, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:224)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Object[] objArr = {animationSpec};
        Saver<BottomSheetState, ?> Saver = BottomSheetState.INSTANCE.Saver(animationSpec, function1, density);
        ComposerKt.sourceInformationMarkerStart(composer, -1826373741, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = true;
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(bottomSheetValue.ordinal())) || (i & 6) == 4) | composer.changed(density) | composer.changedInstance(animationSpec);
        if ((((i & 896) ^ 384) <= 256 || !composer.changed(function1)) && (i & 384) != 256) {
            z = false;
        }
        boolean z2 = zChanged | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BottomSheetScaffoldKt.rememberBottomSheetState$lambda$1$0(bottomSheetValue, density, animationSpec, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return bottomSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BottomSheetState rememberBottomSheetState$lambda$1$0(BottomSheetValue bottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1) {
        return new BottomSheetState(bottomSheetValue, density, animationSpec, function1);
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        Composer composer2;
        ComposerKt.sourceInformationMarkerStart(composer, -1022285988, "C(rememberBottomSheetScaffoldState)N(bottomSheetState,snackbarHostState)264@10031L35,265@10111L32,267@10186L197:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            composer2 = composer;
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer2, 6, 6);
        } else {
            composer2 = composer;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 1130681436, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1022285988, i, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:266)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 1130684001, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer2.changed(bottomSheetState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(snackbarHostState)) || (i & 48) == 32);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return bottomSheetScaffoldState;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x012f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x0136  */
    /* JADX WARN: Code duplicated, block: B:108:0x013c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0142  */
    /* JADX WARN: Code duplicated, block: B:113:0x014b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0150  */
    /* JADX WARN: Code duplicated, block: B:118:0x0157  */
    /* JADX WARN: Code duplicated, block: B:120:0x015f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0168  */
    /* JADX WARN: Code duplicated, block: B:125:0x016d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0177  */
    /* JADX WARN: Code duplicated, block: B:130:0x017b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0186 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:136:0x018d  */
    /* JADX WARN: Code duplicated, block: B:139:0x0195  */
    /* JADX WARN: Code duplicated, block: B:141:0x019b  */
    /* JADX WARN: Code duplicated, block: B:144:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:146:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:149:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:151:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ba A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:157:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:160:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:162:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:163:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:167:0x01df  */
    /* JADX WARN: Code duplicated, block: B:171:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:174:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:176:0x0202  */
    /* JADX WARN: Code duplicated, block: B:205:0x0259 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:206:0x025b  */
    /* JADX WARN: Code duplicated, block: B:209:0x0264  */
    /* JADX WARN: Code duplicated, block: B:211:0x026f  */
    /* JADX WARN: Code duplicated, block: B:212:0x0271  */
    /* JADX WARN: Code duplicated, block: B:214:0x0275  */
    /* JADX WARN: Code duplicated, block: B:216:0x027d  */
    /* JADX WARN: Code duplicated, block: B:218:0x0280  */
    /* JADX WARN: Code duplicated, block: B:219:0x0287  */
    /* JADX WARN: Code duplicated, block: B:221:0x028a  */
    /* JADX WARN: Code duplicated, block: B:224:0x0290  */
    /* JADX WARN: Code duplicated, block: B:225:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:228:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:229:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:232:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:233:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:236:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:237:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:240:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:241:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:244:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:245:0x0305  */
    /* JADX WARN: Code duplicated, block: B:248:0x030a  */
    /* JADX WARN: Code duplicated, block: B:249:0x031b  */
    /* JADX WARN: Code duplicated, block: B:253:0x0332  */
    /* JADX WARN: Code duplicated, block: B:254:0x033d  */
    /* JADX WARN: Code duplicated, block: B:257:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:259:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:262:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:264:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006b  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x0098  */
    /* JADX WARN: Code duplicated, block: B:51:0x009b  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00da  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:86:0x0102  */
    /* JADX WARN: Code duplicated, block: B:88:0x0106  */
    /* JADX WARN: Code duplicated, block: B:91:0x0111 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:94:0x0118  */
    /* JADX WARN: Code duplicated, block: B:97:0x0120  */
    /* JADX WARN: Code duplicated, block: B:99:0x0124  */
    /* JADX INFO: renamed from: BottomSheetScaffold-HnlDQGw, reason: not valid java name */
    public static final void m2297BottomSheetScaffoldHnlDQGw(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, int i, boolean z, Shape shape, float f, long j, long j2, float f2, long j3, long j4, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function6, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        BottomSheetScaffoldState bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
        int i6;
        int i7;
        int i8;
        Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> lambda$937349512$material;
        int i9;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z2;
        int i16;
        int i17;
        int i18;
        int i19;
        long jM2335getBackground0d7_KjU;
        boolean z3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final Shape shape2;
        final long j5;
        final long j6;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function9;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final int i20;
        final Modifier modifier3;
        final BottomSheetScaffoldState bottomSheetScaffoldState2;
        final boolean z4;
        final float f3;
        final long j7;
        final long j8;
        final float f4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function11;
        int iM2421getEnd5ygKITE;
        CornerBasedShape large;
        final float fM2289getSheetElevationD9Ej5fM;
        long jM2346getSurface0d7_KjU;
        long jM2360contentColorForek8zF_U;
        int i21;
        float fM2290getSheetPeekHeightD9Ej5fM;
        float f5;
        int i22;
        long j9;
        long j10;
        long j11;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Composer composerStartRestartGroup = composer.startRestartGroup(194495313);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffold)N(sheetContent,modifier,scaffoldState,topBar,snackbarHost,floatingActionButton,floatingActionButtonPosition:c#material.FabPosition,sheetGesturesEnabled,sheetShape,sheetElevation:c#ui.unit.Dp,sheetBackgroundColor:c#ui.graphics.Color,sheetContentColor:c#ui.graphics.Color,sheetPeekHeight:c#ui.unit.Dp,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)337@14316L1792,337@14230L1878:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i28 = i4 & 2;
        if (i28 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i4 & 4) == 0) {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                    int i29 = composerStartRestartGroup.changed(bottomSheetScaffoldStateRememberBottomSheetScaffoldState) ? 256 : 128;
                    i5 |= i29;
                } else {
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                }
                i5 |= i29;
            } else {
                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
            }
            i6 = i4 & 8;
            if (i6 != 0) {
                if ((i2 & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 16;
                if (i8 != 0) {
                    if ((i2 & 24576) == 0) {
                        lambda$937349512$material = function4;
                        if (composerStartRestartGroup.changedInstance(lambda$937349512$material)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i5 |= i9;
                    }
                    i10 = i4 & 32;
                    if (i10 != 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function7 = function5;
                    } else {
                        function7 = function5;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function7)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i5 |= i11;
                        }
                    }
                    i12 = i4 & 64;
                    if (i12 != 0) {
                        i5 |= 1572864;
                        i13 = i;
                    } else {
                        i13 = i;
                        if ((i2 & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(i13)) {
                                i14 = 1048576;
                            } else {
                                i14 = 524288;
                            }
                            i5 |= i14;
                        }
                    }
                    i15 = i4 & 128;
                    if (i15 != 0) {
                        i5 |= 12582912;
                        z2 = z;
                    } else {
                        z2 = z;
                        if ((i2 & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(z2)) {
                                i16 = 8388608;
                            } else {
                                i16 = 4194304;
                            }
                            i5 |= i16;
                        }
                    }
                    if ((i2 & 100663296) != 0) {
                        i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
                    }
                    if ((i2 & 805306368) != 0) {
                        i5 |= ((i4 & 512) == 0 || !composerStartRestartGroup.changed(f)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    if ((i3 & 6) == 0) {
                        if ((i4 & 1024) == 0 || !composerStartRestartGroup.changed(j)) {
                            i27 = 2;
                        } else {
                            i27 = 4;
                        }
                        i17 = i3 | i27;
                    } else {
                        i17 = i3;
                    }
                    if ((i3 & 48) == 0) {
                        int i30 = i17;
                        if ((i4 & 2048) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i26 = 16;
                        } else {
                            i26 = 32;
                        }
                        i17 = i30 | i26;
                    }
                    i18 = i17;
                    if ((i3 & 384) == 0) {
                        i19 = i18 | (((i4 & 4096) == 0 || !composerStartRestartGroup.changed(f2)) ? 128 : 256);
                    } else {
                        i19 = i18;
                    }
                    if ((i3 & 3072) == 0) {
                        jM2335getBackground0d7_KjU = j3;
                        i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(jM2335getBackground0d7_KjU)) ? 1024 : 2048;
                    } else {
                        jM2335getBackground0d7_KjU = j3;
                    }
                    if ((i3 & 24576) != 0) {
                        i19 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j4)) ? 8192 : 16384;
                    }
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i25 = 131072;
                        } else {
                            i25 = 65536;
                        }
                        i19 |= i25;
                    }
                    if ((306783379 & i5) == 306783378 || (i19 & 74899) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "322@13393L34,328@13762L6,330@13893L6,331@13940L37,333@14093L6,334@14138L32");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i28 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i6 != 0) {
                                function11 = null;
                            } else {
                                function11 = function2;
                            }
                            if (i8 != 0) {
                                lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                            }
                            if (i10 != 0) {
                                function7 = null;
                            }
                            if (i12 != 0) {
                                iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                            } else {
                                iM2421getEnd5ygKITE = i13;
                            }
                            if (i15 != 0) {
                                z2 = true;
                            }
                            if ((i4 & 256) != 0) {
                                large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                                i5 &= -234881025;
                            } else {
                                large = shape;
                            }
                            if ((i4 & 512) != 0) {
                                fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                                i5 &= -1879048193;
                            } else {
                                fM2289getSheetElevationD9Ej5fM = f;
                            }
                            if ((i4 & 1024) != 0) {
                                i19 &= -15;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i4 & 2048) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                                i19 &= -113;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            i21 = i19;
                            function2 = function11;
                            if ((i4 & 4096) != 0) {
                                fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                                i21 &= -897;
                            } else {
                                fM2290getSheetPeekHeightD9Ej5fM = f2;
                            }
                            f5 = fM2290getSheetPeekHeightD9Ej5fM;
                            if ((i4 & 8192) != 0) {
                                jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                                i22 = i21 & (-7169);
                            } else {
                                i22 = i21;
                            }
                            if ((i4 & 16384) != 0) {
                                long jM2360contentColorForek8zF_U2 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                                i22 &= -57345;
                                j9 = jM2360contentColorForek8zF_U2;
                            } else {
                                j9 = j4;
                            }
                            j10 = jM2335getBackground0d7_KjU;
                            j11 = jM2346getSurface0d7_KjU;
                            z2 = z2;
                            i23 = i5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                            }
                            if ((i4 & 256) != 0) {
                                i5 &= -234881025;
                            }
                            if ((i4 & 512) != 0) {
                                i5 &= -1879048193;
                            }
                            if ((i4 & 1024) != 0) {
                                i19 &= -15;
                            }
                            if ((i4 & 2048) != 0) {
                                i19 &= -113;
                            }
                            i22 = i19;
                            if ((i4 & 4096) != 0) {
                                i22 &= -897;
                            }
                            if ((i4 & 8192) != 0) {
                                i22 &= -7169;
                            }
                            if ((i4 & 16384) != 0) {
                                i22 &= -57345;
                            }
                            fM2289getSheetElevationD9Ej5fM = f;
                            jM2360contentColorForek8zF_U = j2;
                            f5 = f2;
                            j9 = j4;
                            j10 = jM2335getBackground0d7_KjU;
                            i23 = i5;
                            iM2421getEnd5ygKITE = i13;
                            large = shape;
                            j11 = j;
                        }
                        i24 = i22;
                        final Function2<? super Composer, ? super Integer, Unit> function12 = function2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(194495313, i23, i24, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
                        }
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                        final float f6 = f5;
                        final long j12 = j11;
                        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function13 = lambda$937349512$material;
                        final int i31 = iM2421getEnd5ygKITE;
                        final Function2<? super Composer, ? super Integer, Unit> function14 = function7;
                        final Shape shape3 = large;
                        final BottomSheetScaffoldState bottomSheetScaffoldState3 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        final boolean z5 = z2;
                        final long j13 = jM2360contentColorForek8zF_U;
                        float f7 = fM2289getSheetElevationD9Ej5fM;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-747577963, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0(bottomSheetScaffoldState3, function12, function14, f6, i31, function6, z5, shape3, fM2289getSheetElevationD9Ej5fM, j12, j13, function3, function13, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        int i32 = i24 >> 3;
                        long j14 = j10;
                        long j15 = j9;
                        SurfaceKt.m2584SurfaceFjzlyU(modifierFillMaxSize$default, null, j14, j15, null, 0.0f, composableLambdaRememberComposableLambda, composerStartRestartGroup, (i32 & 7168) | (i32 & 896) | 1572864, 50);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function8 = function12;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        z4 = z2;
                        j5 = j15;
                        j8 = j13;
                        f4 = f6;
                        function10 = function7;
                        f3 = f7;
                        function9 = lambda$937349512$material;
                        i20 = iM2421getEnd5ygKITE;
                        shape2 = large;
                        modifier3 = modifier2;
                        j7 = j12;
                        j6 = j14;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function8 = function2;
                        shape2 = shape;
                        j5 = j4;
                        j6 = jM2335getBackground0d7_KjU;
                        function9 = lambda$937349512$material;
                        function10 = function7;
                        i20 = i13;
                        modifier3 = modifier2;
                        bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                        z4 = z2;
                        f3 = f;
                        j7 = j;
                        j8 = j2;
                        f4 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$1(function3, modifier3, bottomSheetScaffoldState2, function8, function9, function10, i20, z4, shape2, f3, j7, j8, f4, j6, j5, function6, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= 24576;
                lambda$937349512$material = function4;
                i10 = i4 & 32;
                if (i10 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function7 = function5;
                } else {
                    function7 = function5;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i5 |= i11;
                    }
                }
                i12 = i4 & 64;
                if (i12 != 0) {
                    i5 |= 1572864;
                    i13 = i;
                } else {
                    i13 = i;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i13)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i5 |= i14;
                    }
                }
                i15 = i4 & 128;
                if (i15 != 0) {
                    i5 |= 12582912;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i16 = 8388608;
                        } else {
                            i16 = 4194304;
                        }
                        i5 |= i16;
                    }
                }
                if ((i2 & 100663296) != 0) {
                    i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
                }
                if ((i2 & 805306368) != 0) {
                    i5 |= ((i4 & 512) == 0 || !composerStartRestartGroup.changed(f)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                if ((i3 & 6) == 0) {
                    if ((i4 & 1024) == 0) {
                        i27 = 2;
                    } else {
                        i27 = 2;
                    }
                    i17 = i3 | i27;
                } else {
                    i17 = i3;
                }
                if ((i3 & 48) == 0) {
                    int i33 = i17;
                    if ((i4 & 2048) == 0) {
                        i26 = 16;
                    } else {
                        i26 = 16;
                    }
                    i17 = i33 | i26;
                }
                i18 = i17;
                if ((i3 & 384) == 0) {
                    i19 = i18 | (((i4 & 4096) == 0 || !composerStartRestartGroup.changed(f2)) ? 128 : 256);
                } else {
                    i19 = i18;
                }
                if ((i3 & 3072) == 0) {
                    jM2335getBackground0d7_KjU = j3;
                    i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(jM2335getBackground0d7_KjU)) ? 1024 : 2048;
                } else {
                    jM2335getBackground0d7_KjU = j3;
                }
                if ((i3 & 24576) != 0) {
                    i19 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j4)) ? 8192 : 16384;
                }
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i25 = 131072;
                    } else {
                        i25 = 65536;
                    }
                    i19 |= i25;
                }
                if ((306783379 & i5) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "322@13393L34,328@13762L6,330@13893L6,331@13940L37,333@14093L6,334@14138L32");
                    if ((i2 & 1) != 0) {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i4 & 4) != 0) {
                            i5 &= -897;
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i6 != 0) {
                            function11 = null;
                        } else {
                            function11 = function2;
                        }
                        if (i8 != 0) {
                            lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                        }
                        if (i10 != 0) {
                            function7 = null;
                        }
                        if (i12 != 0) {
                            iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                        } else {
                            iM2421getEnd5ygKITE = i13;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        }
                        if ((i4 & 256) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i5 &= -234881025;
                        } else {
                            large = shape;
                        }
                        if ((i4 & 512) != 0) {
                            fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                            i5 &= -1879048193;
                        } else {
                            fM2289getSheetElevationD9Ej5fM = f;
                        }
                        if ((i4 & 1024) != 0) {
                            i19 &= -15;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i4 & 2048) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                            i19 &= -113;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        i21 = i19;
                        function2 = function11;
                        if ((i4 & 4096) != 0) {
                            fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                            i21 &= -897;
                        } else {
                            fM2290getSheetPeekHeightD9Ej5fM = f2;
                        }
                        f5 = fM2290getSheetPeekHeightD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                            i22 = i21 & (-7169);
                        } else {
                            i22 = i21;
                        }
                        if ((i4 & 16384) != 0) {
                            long jM2360contentColorForek8zF_U3 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                            i22 &= -57345;
                            j9 = jM2360contentColorForek8zF_U3;
                        } else {
                            j9 = j4;
                        }
                        j10 = jM2335getBackground0d7_KjU;
                        j11 = jM2346getSurface0d7_KjU;
                        z2 = z2;
                        i23 = i5;
                    } else {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i4 & 4) != 0) {
                            i5 &= -897;
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i6 != 0) {
                            function11 = null;
                        } else {
                            function11 = function2;
                        }
                        if (i8 != 0) {
                            lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                        }
                        if (i10 != 0) {
                            function7 = null;
                        }
                        if (i12 != 0) {
                            iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                        } else {
                            iM2421getEnd5ygKITE = i13;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        }
                        if ((i4 & 256) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i5 &= -234881025;
                        } else {
                            large = shape;
                        }
                        if ((i4 & 512) != 0) {
                            fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                            i5 &= -1879048193;
                        } else {
                            fM2289getSheetElevationD9Ej5fM = f;
                        }
                        if ((i4 & 1024) != 0) {
                            i19 &= -15;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i4 & 2048) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                            i19 &= -113;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        i21 = i19;
                        function2 = function11;
                        if ((i4 & 4096) != 0) {
                            fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                            i21 &= -897;
                        } else {
                            fM2290getSheetPeekHeightD9Ej5fM = f2;
                        }
                        f5 = fM2290getSheetPeekHeightD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                            i22 = i21 & (-7169);
                        } else {
                            i22 = i21;
                        }
                        if ((i4 & 16384) != 0) {
                            long jM2360contentColorForek8zF_U4 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                            i22 &= -57345;
                            j9 = jM2360contentColorForek8zF_U4;
                        } else {
                            j9 = j4;
                        }
                        j10 = jM2335getBackground0d7_KjU;
                        j11 = jM2346getSurface0d7_KjU;
                        z2 = z2;
                        i23 = i5;
                    }
                    i24 = i22;
                    final Function2 function15 = function2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(194495313, i23, i24, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
                    }
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                    final float f8 = f5;
                    final long j16 = j11;
                    final Function3 function16 = lambda$937349512$material;
                    final int i34 = iM2421getEnd5ygKITE;
                    final Function2 function17 = function7;
                    final Shape shape4 = large;
                    final BottomSheetScaffoldState bottomSheetScaffoldState4 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    final boolean z6 = z2;
                    final long j17 = jM2360contentColorForek8zF_U;
                    float f9 = fM2289getSheetElevationD9Ej5fM;
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-747577963, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0(bottomSheetScaffoldState4, function15, function17, f8, i34, function6, z6, shape4, fM2289getSheetElevationD9Ej5fM, j16, j17, function3, function16, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i35 = i24 >> 3;
                    long j18 = j10;
                    long j19 = j9;
                    SurfaceKt.m2584SurfaceFjzlyU(modifierFillMaxSize$default2, null, j18, j19, null, 0.0f, composableLambdaRememberComposableLambda2, composerStartRestartGroup, (i35 & 7168) | (i35 & 896) | 1572864, 50);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function8 = function15;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    z4 = z2;
                    j5 = j19;
                    j8 = j17;
                    f4 = f8;
                    function10 = function7;
                    f3 = f9;
                    function9 = lambda$937349512$material;
                    i20 = iM2421getEnd5ygKITE;
                    shape2 = large;
                    modifier3 = modifier2;
                    j7 = j16;
                    j6 = j18;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function8 = function2;
                    shape2 = shape;
                    j5 = j4;
                    j6 = jM2335getBackground0d7_KjU;
                    function9 = lambda$937349512$material;
                    function10 = function7;
                    i20 = i13;
                    modifier3 = modifier2;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    z4 = z2;
                    f3 = f;
                    j7 = j;
                    j8 = j2;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$1(function3, modifier3, bottomSheetScaffoldState2, function8, function9, function10, i20, z4, shape2, f3, j7, j8, f4, j6, j5, function6, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            i8 = i4 & 16;
            if (i8 != 0) {
                if ((i2 & 24576) == 0) {
                    lambda$937349512$material = function4;
                    if (composerStartRestartGroup.changedInstance(lambda$937349512$material)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 32;
                if (i10 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function7 = function5;
                } else {
                    function7 = function5;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i5 |= i11;
                    }
                }
                i12 = i4 & 64;
                if (i12 != 0) {
                    i5 |= 1572864;
                    i13 = i;
                } else {
                    i13 = i;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i13)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i5 |= i14;
                    }
                }
                i15 = i4 & 128;
                if (i15 != 0) {
                    i5 |= 12582912;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i16 = 8388608;
                        } else {
                            i16 = 4194304;
                        }
                        i5 |= i16;
                    }
                }
                if ((i2 & 100663296) != 0) {
                    i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
                }
                if ((i2 & 805306368) != 0) {
                    i5 |= ((i4 & 512) == 0 || !composerStartRestartGroup.changed(f)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                if ((i3 & 6) == 0) {
                    if ((i4 & 1024) == 0) {
                        i27 = 2;
                    } else {
                        i27 = 2;
                    }
                    i17 = i3 | i27;
                } else {
                    i17 = i3;
                }
                if ((i3 & 48) == 0) {
                    int i36 = i17;
                    if ((i4 & 2048) == 0) {
                        i26 = 16;
                    } else {
                        i26 = 16;
                    }
                    i17 = i36 | i26;
                }
                i18 = i17;
                if ((i3 & 384) == 0) {
                    i19 = i18 | (((i4 & 4096) == 0 || !composerStartRestartGroup.changed(f2)) ? 128 : 256);
                } else {
                    i19 = i18;
                }
                if ((i3 & 3072) == 0) {
                    jM2335getBackground0d7_KjU = j3;
                    i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(jM2335getBackground0d7_KjU)) ? 1024 : 2048;
                } else {
                    jM2335getBackground0d7_KjU = j3;
                }
                if ((i3 & 24576) != 0) {
                    i19 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j4)) ? 8192 : 16384;
                }
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i25 = 131072;
                    } else {
                        i25 = 65536;
                    }
                    i19 |= i25;
                }
                if ((306783379 & i5) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "322@13393L34,328@13762L6,330@13893L6,331@13940L37,333@14093L6,334@14138L32");
                    if ((i2 & 1) != 0) {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i4 & 4) != 0) {
                            i5 &= -897;
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i6 != 0) {
                            function11 = null;
                        } else {
                            function11 = function2;
                        }
                        if (i8 != 0) {
                            lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                        }
                        if (i10 != 0) {
                            function7 = null;
                        }
                        if (i12 != 0) {
                            iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                        } else {
                            iM2421getEnd5ygKITE = i13;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        }
                        if ((i4 & 256) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i5 &= -234881025;
                        } else {
                            large = shape;
                        }
                        if ((i4 & 512) != 0) {
                            fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                            i5 &= -1879048193;
                        } else {
                            fM2289getSheetElevationD9Ej5fM = f;
                        }
                        if ((i4 & 1024) != 0) {
                            i19 &= -15;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i4 & 2048) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                            i19 &= -113;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        i21 = i19;
                        function2 = function11;
                        if ((i4 & 4096) != 0) {
                            fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                            i21 &= -897;
                        } else {
                            fM2290getSheetPeekHeightD9Ej5fM = f2;
                        }
                        f5 = fM2290getSheetPeekHeightD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                            i22 = i21 & (-7169);
                        } else {
                            i22 = i21;
                        }
                        if ((i4 & 16384) != 0) {
                            long jM2360contentColorForek8zF_U5 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                            i22 &= -57345;
                            j9 = jM2360contentColorForek8zF_U5;
                        } else {
                            j9 = j4;
                        }
                        j10 = jM2335getBackground0d7_KjU;
                        j11 = jM2346getSurface0d7_KjU;
                        z2 = z2;
                        i23 = i5;
                    } else {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i4 & 4) != 0) {
                            i5 &= -897;
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i6 != 0) {
                            function11 = null;
                        } else {
                            function11 = function2;
                        }
                        if (i8 != 0) {
                            lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                        }
                        if (i10 != 0) {
                            function7 = null;
                        }
                        if (i12 != 0) {
                            iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                        } else {
                            iM2421getEnd5ygKITE = i13;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        }
                        if ((i4 & 256) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i5 &= -234881025;
                        } else {
                            large = shape;
                        }
                        if ((i4 & 512) != 0) {
                            fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                            i5 &= -1879048193;
                        } else {
                            fM2289getSheetElevationD9Ej5fM = f;
                        }
                        if ((i4 & 1024) != 0) {
                            i19 &= -15;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i4 & 2048) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                            i19 &= -113;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        i21 = i19;
                        function2 = function11;
                        if ((i4 & 4096) != 0) {
                            fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                            i21 &= -897;
                        } else {
                            fM2290getSheetPeekHeightD9Ej5fM = f2;
                        }
                        f5 = fM2290getSheetPeekHeightD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                            i22 = i21 & (-7169);
                        } else {
                            i22 = i21;
                        }
                        if ((i4 & 16384) != 0) {
                            long jM2360contentColorForek8zF_U6 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                            i22 &= -57345;
                            j9 = jM2360contentColorForek8zF_U6;
                        } else {
                            j9 = j4;
                        }
                        j10 = jM2335getBackground0d7_KjU;
                        j11 = jM2346getSurface0d7_KjU;
                        z2 = z2;
                        i23 = i5;
                    }
                    i24 = i22;
                    final Function2 function18 = function2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(194495313, i23, i24, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
                    }
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                    final float f10 = f5;
                    final long j110 = j11;
                    final Function3 function19 = lambda$937349512$material;
                    final int i37 = iM2421getEnd5ygKITE;
                    final Function2 function110 = function7;
                    final Shape shape5 = large;
                    final BottomSheetScaffoldState bottomSheetScaffoldState5 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    final boolean z7 = z2;
                    final long j111 = jM2360contentColorForek8zF_U;
                    float f11 = fM2289getSheetElevationD9Ej5fM;
                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-747577963, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0(bottomSheetScaffoldState5, function18, function110, f10, i37, function6, z7, shape5, fM2289getSheetElevationD9Ej5fM, j110, j111, function3, function19, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i38 = i24 >> 3;
                    long j112 = j10;
                    long j113 = j9;
                    SurfaceKt.m2584SurfaceFjzlyU(modifierFillMaxSize$default3, null, j112, j113, null, 0.0f, composableLambdaRememberComposableLambda3, composerStartRestartGroup, (i38 & 7168) | (i38 & 896) | 1572864, 50);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function8 = function18;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    z4 = z2;
                    j5 = j113;
                    j8 = j111;
                    f4 = f10;
                    function10 = function7;
                    f3 = f11;
                    function9 = lambda$937349512$material;
                    i20 = iM2421getEnd5ygKITE;
                    shape2 = large;
                    modifier3 = modifier2;
                    j7 = j110;
                    j6 = j112;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function8 = function2;
                    shape2 = shape;
                    j5 = j4;
                    j6 = jM2335getBackground0d7_KjU;
                    function9 = lambda$937349512$material;
                    function10 = function7;
                    i20 = i13;
                    modifier3 = modifier2;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    z4 = z2;
                    f3 = f;
                    j7 = j;
                    j8 = j2;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$1(function3, modifier3, bottomSheetScaffoldState2, function8, function9, function10, i20, z4, shape2, f3, j7, j8, f4, j6, j5, function6, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            lambda$937349512$material = function4;
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function7 = function5;
            } else {
                function7 = function5;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i5 |= i11;
                }
            }
            i12 = i4 & 64;
            if (i12 != 0) {
                i5 |= 1572864;
                i13 = i;
            } else {
                i13 = i;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i13)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i5 |= i14;
                }
            }
            i15 = i4 & 128;
            if (i15 != 0) {
                i5 |= 12582912;
                z2 = z;
            } else {
                z2 = z;
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i5 |= i16;
                }
            }
            if ((i2 & 100663296) != 0) {
                i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
            }
            if ((i2 & 805306368) != 0) {
                i5 |= ((i4 & 512) == 0 || !composerStartRestartGroup.changed(f)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            if ((i3 & 6) == 0) {
                if ((i4 & 1024) == 0) {
                    i27 = 2;
                } else {
                    i27 = 2;
                }
                i17 = i3 | i27;
            } else {
                i17 = i3;
            }
            if ((i3 & 48) == 0) {
                int i39 = i17;
                if ((i4 & 2048) == 0) {
                    i26 = 16;
                } else {
                    i26 = 16;
                }
                i17 = i39 | i26;
            }
            i18 = i17;
            if ((i3 & 384) == 0) {
                i19 = i18 | (((i4 & 4096) == 0 || !composerStartRestartGroup.changed(f2)) ? 128 : 256);
            } else {
                i19 = i18;
            }
            if ((i3 & 3072) == 0) {
                jM2335getBackground0d7_KjU = j3;
                i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(jM2335getBackground0d7_KjU)) ? 1024 : 2048;
            } else {
                jM2335getBackground0d7_KjU = j3;
            }
            if ((i3 & 24576) != 0) {
                i19 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j4)) ? 8192 : 16384;
            }
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i25 = 131072;
                } else {
                    i25 = 65536;
                }
                i19 |= i25;
            }
            if ((306783379 & i5) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "322@13393L34,328@13762L6,330@13893L6,331@13940L37,333@14093L6,334@14138L32");
                if ((i2 & 1) != 0) {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i4 & 4) != 0) {
                        i5 &= -897;
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i6 != 0) {
                        function11 = null;
                    } else {
                        function11 = function2;
                    }
                    if (i8 != 0) {
                        lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                    }
                    if (i10 != 0) {
                        function7 = null;
                    }
                    if (i12 != 0) {
                        iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                    } else {
                        iM2421getEnd5ygKITE = i13;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    }
                    if ((i4 & 256) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i5 &= -234881025;
                    } else {
                        large = shape;
                    }
                    if ((i4 & 512) != 0) {
                        fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                        i5 &= -1879048193;
                    } else {
                        fM2289getSheetElevationD9Ej5fM = f;
                    }
                    if ((i4 & 1024) != 0) {
                        i19 &= -15;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i4 & 2048) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                        i19 &= -113;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i21 = i19;
                    function2 = function11;
                    if ((i4 & 4096) != 0) {
                        fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                        i21 &= -897;
                    } else {
                        fM2290getSheetPeekHeightD9Ej5fM = f2;
                    }
                    f5 = fM2290getSheetPeekHeightD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                        i22 = i21 & (-7169);
                    } else {
                        i22 = i21;
                    }
                    if ((i4 & 16384) != 0) {
                        long jM2360contentColorForek8zF_U7 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                        i22 &= -57345;
                        j9 = jM2360contentColorForek8zF_U7;
                    } else {
                        j9 = j4;
                    }
                    j10 = jM2335getBackground0d7_KjU;
                    j11 = jM2346getSurface0d7_KjU;
                    z2 = z2;
                    i23 = i5;
                } else {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i4 & 4) != 0) {
                        i5 &= -897;
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i6 != 0) {
                        function11 = null;
                    } else {
                        function11 = function2;
                    }
                    if (i8 != 0) {
                        lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                    }
                    if (i10 != 0) {
                        function7 = null;
                    }
                    if (i12 != 0) {
                        iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                    } else {
                        iM2421getEnd5ygKITE = i13;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    }
                    if ((i4 & 256) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i5 &= -234881025;
                    } else {
                        large = shape;
                    }
                    if ((i4 & 512) != 0) {
                        fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                        i5 &= -1879048193;
                    } else {
                        fM2289getSheetElevationD9Ej5fM = f;
                    }
                    if ((i4 & 1024) != 0) {
                        i19 &= -15;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i4 & 2048) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                        i19 &= -113;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i21 = i19;
                    function2 = function11;
                    if ((i4 & 4096) != 0) {
                        fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                        i21 &= -897;
                    } else {
                        fM2290getSheetPeekHeightD9Ej5fM = f2;
                    }
                    f5 = fM2290getSheetPeekHeightD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                        i22 = i21 & (-7169);
                    } else {
                        i22 = i21;
                    }
                    if ((i4 & 16384) != 0) {
                        long jM2360contentColorForek8zF_U8 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                        i22 &= -57345;
                        j9 = jM2360contentColorForek8zF_U8;
                    } else {
                        j9 = j4;
                    }
                    j10 = jM2335getBackground0d7_KjU;
                    j11 = jM2346getSurface0d7_KjU;
                    z2 = z2;
                    i23 = i5;
                }
                i24 = i22;
                final Function2 function111 = function2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(194495313, i23, i24, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
                }
                Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                final float f12 = f5;
                final long j114 = j11;
                final Function3 function112 = lambda$937349512$material;
                final int i310 = iM2421getEnd5ygKITE;
                final Function2 function113 = function7;
                final Shape shape6 = large;
                final BottomSheetScaffoldState bottomSheetScaffoldState6 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                final boolean z8 = z2;
                final long j115 = jM2360contentColorForek8zF_U;
                float f13 = fM2289getSheetElevationD9Ej5fM;
                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-747577963, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0(bottomSheetScaffoldState6, function111, function113, f12, i310, function6, z8, shape6, fM2289getSheetElevationD9Ej5fM, j114, j115, function3, function112, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i311 = i24 >> 3;
                long j116 = j10;
                long j117 = j9;
                SurfaceKt.m2584SurfaceFjzlyU(modifierFillMaxSize$default4, null, j116, j117, null, 0.0f, composableLambdaRememberComposableLambda4, composerStartRestartGroup, (i311 & 7168) | (i311 & 896) | 1572864, 50);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function8 = function111;
                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                z4 = z2;
                j5 = j117;
                j8 = j115;
                f4 = f12;
                function10 = function7;
                f3 = f13;
                function9 = lambda$937349512$material;
                i20 = iM2421getEnd5ygKITE;
                shape2 = large;
                modifier3 = modifier2;
                j7 = j114;
                j6 = j116;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function8 = function2;
                shape2 = shape;
                j5 = j4;
                j6 = jM2335getBackground0d7_KjU;
                function9 = lambda$937349512$material;
                function10 = function7;
                i20 = i13;
                modifier3 = modifier2;
                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                z4 = z2;
                f3 = f;
                j7 = j;
                j8 = j2;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$1(function3, modifier3, bottomSheetScaffoldState2, function8, function9, function10, i20, z4, shape2, f3, j7, j8, f4, j6, j5, function6, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 48;
        modifier2 = modifier;
        if ((i2 & 384) == 0) {
            if ((i4 & 4) == 0) {
                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
                if (composerStartRestartGroup.changed(bottomSheetScaffoldStateRememberBottomSheetScaffoldState)) {
                }
                i5 |= i29;
            } else {
                bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
            }
            i5 |= i29;
        } else {
            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = bottomSheetScaffoldState;
        }
        i6 = i4 & 8;
        if (i6 != 0) {
            if ((i2 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i5 |= i7;
            }
            i8 = i4 & 16;
            if (i8 != 0) {
                if ((i2 & 24576) == 0) {
                    lambda$937349512$material = function4;
                    if (composerStartRestartGroup.changedInstance(lambda$937349512$material)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i5 |= i9;
                }
                i10 = i4 & 32;
                if (i10 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function7 = function5;
                } else {
                    function7 = function5;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i5 |= i11;
                    }
                }
                i12 = i4 & 64;
                if (i12 != 0) {
                    i5 |= 1572864;
                    i13 = i;
                } else {
                    i13 = i;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(i13)) {
                            i14 = 1048576;
                        } else {
                            i14 = 524288;
                        }
                        i5 |= i14;
                    }
                }
                i15 = i4 & 128;
                if (i15 != 0) {
                    i5 |= 12582912;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i2 & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i16 = 8388608;
                        } else {
                            i16 = 4194304;
                        }
                        i5 |= i16;
                    }
                }
                if ((i2 & 100663296) != 0) {
                    i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
                }
                if ((i2 & 805306368) != 0) {
                    i5 |= ((i4 & 512) == 0 || !composerStartRestartGroup.changed(f)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                if ((i3 & 6) == 0) {
                    if ((i4 & 1024) == 0) {
                        i27 = 2;
                    } else {
                        i27 = 2;
                    }
                    i17 = i3 | i27;
                } else {
                    i17 = i3;
                }
                if ((i3 & 48) == 0) {
                    int i312 = i17;
                    if ((i4 & 2048) == 0) {
                        i26 = 16;
                    } else {
                        i26 = 16;
                    }
                    i17 = i312 | i26;
                }
                i18 = i17;
                if ((i3 & 384) == 0) {
                    i19 = i18 | (((i4 & 4096) == 0 || !composerStartRestartGroup.changed(f2)) ? 128 : 256);
                } else {
                    i19 = i18;
                }
                if ((i3 & 3072) == 0) {
                    jM2335getBackground0d7_KjU = j3;
                    i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(jM2335getBackground0d7_KjU)) ? 1024 : 2048;
                } else {
                    jM2335getBackground0d7_KjU = j3;
                }
                if ((i3 & 24576) != 0) {
                    i19 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j4)) ? 8192 : 16384;
                }
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i25 = 131072;
                    } else {
                        i25 = 65536;
                    }
                    i19 |= i25;
                }
                if ((306783379 & i5) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "322@13393L34,328@13762L6,330@13893L6,331@13940L37,333@14093L6,334@14138L32");
                    if ((i2 & 1) != 0) {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i4 & 4) != 0) {
                            i5 &= -897;
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i6 != 0) {
                            function11 = null;
                        } else {
                            function11 = function2;
                        }
                        if (i8 != 0) {
                            lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                        }
                        if (i10 != 0) {
                            function7 = null;
                        }
                        if (i12 != 0) {
                            iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                        } else {
                            iM2421getEnd5ygKITE = i13;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        }
                        if ((i4 & 256) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i5 &= -234881025;
                        } else {
                            large = shape;
                        }
                        if ((i4 & 512) != 0) {
                            fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                            i5 &= -1879048193;
                        } else {
                            fM2289getSheetElevationD9Ej5fM = f;
                        }
                        if ((i4 & 1024) != 0) {
                            i19 &= -15;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i4 & 2048) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                            i19 &= -113;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        i21 = i19;
                        function2 = function11;
                        if ((i4 & 4096) != 0) {
                            fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                            i21 &= -897;
                        } else {
                            fM2290getSheetPeekHeightD9Ej5fM = f2;
                        }
                        f5 = fM2290getSheetPeekHeightD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                            i22 = i21 & (-7169);
                        } else {
                            i22 = i21;
                        }
                        if ((i4 & 16384) != 0) {
                            long jM2360contentColorForek8zF_U9 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                            i22 &= -57345;
                            j9 = jM2360contentColorForek8zF_U9;
                        } else {
                            j9 = j4;
                        }
                        j10 = jM2335getBackground0d7_KjU;
                        j11 = jM2346getSurface0d7_KjU;
                        z2 = z2;
                        i23 = i5;
                    } else {
                        if (i28 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i4 & 4) != 0) {
                            i5 &= -897;
                            bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i6 != 0) {
                            function11 = null;
                        } else {
                            function11 = function2;
                        }
                        if (i8 != 0) {
                            lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                        }
                        if (i10 != 0) {
                            function7 = null;
                        }
                        if (i12 != 0) {
                            iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                        } else {
                            iM2421getEnd5ygKITE = i13;
                        }
                        if (i15 != 0) {
                            z2 = true;
                        }
                        if ((i4 & 256) != 0) {
                            large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                            i5 &= -234881025;
                        } else {
                            large = shape;
                        }
                        if ((i4 & 512) != 0) {
                            fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                            i5 &= -1879048193;
                        } else {
                            fM2289getSheetElevationD9Ej5fM = f;
                        }
                        if ((i4 & 1024) != 0) {
                            i19 &= -15;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i4 & 2048) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                            i19 &= -113;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        i21 = i19;
                        function2 = function11;
                        if ((i4 & 4096) != 0) {
                            fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                            i21 &= -897;
                        } else {
                            fM2290getSheetPeekHeightD9Ej5fM = f2;
                        }
                        f5 = fM2290getSheetPeekHeightD9Ej5fM;
                        if ((i4 & 8192) != 0) {
                            jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                            i22 = i21 & (-7169);
                        } else {
                            i22 = i21;
                        }
                        if ((i4 & 16384) != 0) {
                            long jM2360contentColorForek8zF_U10 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                            i22 &= -57345;
                            j9 = jM2360contentColorForek8zF_U10;
                        } else {
                            j9 = j4;
                        }
                        j10 = jM2335getBackground0d7_KjU;
                        j11 = jM2346getSurface0d7_KjU;
                        z2 = z2;
                        i23 = i5;
                    }
                    i24 = i22;
                    final Function2 function114 = function2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(194495313, i23, i24, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
                    }
                    Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                    final float f14 = f5;
                    final long j118 = j11;
                    final Function3 function115 = lambda$937349512$material;
                    final int i313 = iM2421getEnd5ygKITE;
                    final Function2 function116 = function7;
                    final Shape shape7 = large;
                    final BottomSheetScaffoldState bottomSheetScaffoldState7 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    final boolean z9 = z2;
                    final long j119 = jM2360contentColorForek8zF_U;
                    float f15 = fM2289getSheetElevationD9Ej5fM;
                    ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-747577963, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0(bottomSheetScaffoldState7, function114, function116, f14, i313, function6, z9, shape7, fM2289getSheetElevationD9Ej5fM, j118, j119, function3, function115, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i314 = i24 >> 3;
                    long j1110 = j10;
                    long j1111 = j9;
                    SurfaceKt.m2584SurfaceFjzlyU(modifierFillMaxSize$default5, null, j1110, j1111, null, 0.0f, composableLambdaRememberComposableLambda5, composerStartRestartGroup, (i314 & 7168) | (i314 & 896) | 1572864, 50);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function8 = function114;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    z4 = z2;
                    j5 = j1111;
                    j8 = j119;
                    f4 = f14;
                    function10 = function7;
                    f3 = f15;
                    function9 = lambda$937349512$material;
                    i20 = iM2421getEnd5ygKITE;
                    shape2 = large;
                    modifier3 = modifier2;
                    j7 = j118;
                    j6 = j1110;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function8 = function2;
                    shape2 = shape;
                    j5 = j4;
                    j6 = jM2335getBackground0d7_KjU;
                    function9 = lambda$937349512$material;
                    function10 = function7;
                    i20 = i13;
                    modifier3 = modifier2;
                    bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                    z4 = z2;
                    f3 = f;
                    j7 = j;
                    j8 = j2;
                    f4 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$1(function3, modifier3, bottomSheetScaffoldState2, function8, function9, function10, i20, z4, shape2, f3, j7, j8, f4, j6, j5, function6, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            lambda$937349512$material = function4;
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function7 = function5;
            } else {
                function7 = function5;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i5 |= i11;
                }
            }
            i12 = i4 & 64;
            if (i12 != 0) {
                i5 |= 1572864;
                i13 = i;
            } else {
                i13 = i;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i13)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i5 |= i14;
                }
            }
            i15 = i4 & 128;
            if (i15 != 0) {
                i5 |= 12582912;
                z2 = z;
            } else {
                z2 = z;
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i5 |= i16;
                }
            }
            if ((i2 & 100663296) != 0) {
                i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
            }
            if ((i2 & 805306368) != 0) {
                i5 |= ((i4 & 512) == 0 || !composerStartRestartGroup.changed(f)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            if ((i3 & 6) == 0) {
                if ((i4 & 1024) == 0) {
                    i27 = 2;
                } else {
                    i27 = 2;
                }
                i17 = i3 | i27;
            } else {
                i17 = i3;
            }
            if ((i3 & 48) == 0) {
                int i315 = i17;
                if ((i4 & 2048) == 0) {
                    i26 = 16;
                } else {
                    i26 = 16;
                }
                i17 = i315 | i26;
            }
            i18 = i17;
            if ((i3 & 384) == 0) {
                i19 = i18 | (((i4 & 4096) == 0 || !composerStartRestartGroup.changed(f2)) ? 128 : 256);
            } else {
                i19 = i18;
            }
            if ((i3 & 3072) == 0) {
                jM2335getBackground0d7_KjU = j3;
                i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(jM2335getBackground0d7_KjU)) ? 1024 : 2048;
            } else {
                jM2335getBackground0d7_KjU = j3;
            }
            if ((i3 & 24576) != 0) {
                i19 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j4)) ? 8192 : 16384;
            }
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i25 = 131072;
                } else {
                    i25 = 65536;
                }
                i19 |= i25;
            }
            if ((306783379 & i5) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "322@13393L34,328@13762L6,330@13893L6,331@13940L37,333@14093L6,334@14138L32");
                if ((i2 & 1) != 0) {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i4 & 4) != 0) {
                        i5 &= -897;
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i6 != 0) {
                        function11 = null;
                    } else {
                        function11 = function2;
                    }
                    if (i8 != 0) {
                        lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                    }
                    if (i10 != 0) {
                        function7 = null;
                    }
                    if (i12 != 0) {
                        iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                    } else {
                        iM2421getEnd5ygKITE = i13;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    }
                    if ((i4 & 256) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i5 &= -234881025;
                    } else {
                        large = shape;
                    }
                    if ((i4 & 512) != 0) {
                        fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                        i5 &= -1879048193;
                    } else {
                        fM2289getSheetElevationD9Ej5fM = f;
                    }
                    if ((i4 & 1024) != 0) {
                        i19 &= -15;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i4 & 2048) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                        i19 &= -113;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i21 = i19;
                    function2 = function11;
                    if ((i4 & 4096) != 0) {
                        fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                        i21 &= -897;
                    } else {
                        fM2290getSheetPeekHeightD9Ej5fM = f2;
                    }
                    f5 = fM2290getSheetPeekHeightD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                        i22 = i21 & (-7169);
                    } else {
                        i22 = i21;
                    }
                    if ((i4 & 16384) != 0) {
                        long jM2360contentColorForek8zF_U11 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                        i22 &= -57345;
                        j9 = jM2360contentColorForek8zF_U11;
                    } else {
                        j9 = j4;
                    }
                    j10 = jM2335getBackground0d7_KjU;
                    j11 = jM2346getSurface0d7_KjU;
                    z2 = z2;
                    i23 = i5;
                } else {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i4 & 4) != 0) {
                        i5 &= -897;
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i6 != 0) {
                        function11 = null;
                    } else {
                        function11 = function2;
                    }
                    if (i8 != 0) {
                        lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                    }
                    if (i10 != 0) {
                        function7 = null;
                    }
                    if (i12 != 0) {
                        iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                    } else {
                        iM2421getEnd5ygKITE = i13;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    }
                    if ((i4 & 256) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i5 &= -234881025;
                    } else {
                        large = shape;
                    }
                    if ((i4 & 512) != 0) {
                        fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                        i5 &= -1879048193;
                    } else {
                        fM2289getSheetElevationD9Ej5fM = f;
                    }
                    if ((i4 & 1024) != 0) {
                        i19 &= -15;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i4 & 2048) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                        i19 &= -113;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i21 = i19;
                    function2 = function11;
                    if ((i4 & 4096) != 0) {
                        fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                        i21 &= -897;
                    } else {
                        fM2290getSheetPeekHeightD9Ej5fM = f2;
                    }
                    f5 = fM2290getSheetPeekHeightD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                        i22 = i21 & (-7169);
                    } else {
                        i22 = i21;
                    }
                    if ((i4 & 16384) != 0) {
                        long jM2360contentColorForek8zF_U12 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                        i22 &= -57345;
                        j9 = jM2360contentColorForek8zF_U12;
                    } else {
                        j9 = j4;
                    }
                    j10 = jM2335getBackground0d7_KjU;
                    j11 = jM2346getSurface0d7_KjU;
                    z2 = z2;
                    i23 = i5;
                }
                i24 = i22;
                final Function2 function117 = function2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(194495313, i23, i24, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
                }
                Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                final float f16 = f5;
                final long j1112 = j11;
                final Function3 function118 = lambda$937349512$material;
                final int i316 = iM2421getEnd5ygKITE;
                final Function2 function119 = function7;
                final Shape shape8 = large;
                final BottomSheetScaffoldState bottomSheetScaffoldState8 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                final boolean z10 = z2;
                final long j1113 = jM2360contentColorForek8zF_U;
                float f17 = fM2289getSheetElevationD9Ej5fM;
                ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-747577963, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0(bottomSheetScaffoldState8, function117, function119, f16, i316, function6, z10, shape8, fM2289getSheetElevationD9Ej5fM, j1112, j1113, function3, function118, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i317 = i24 >> 3;
                long j1114 = j10;
                long j1115 = j9;
                SurfaceKt.m2584SurfaceFjzlyU(modifierFillMaxSize$default6, null, j1114, j1115, null, 0.0f, composableLambdaRememberComposableLambda6, composerStartRestartGroup, (i317 & 7168) | (i317 & 896) | 1572864, 50);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function8 = function117;
                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                z4 = z2;
                j5 = j1115;
                j8 = j1113;
                f4 = f16;
                function10 = function7;
                f3 = f17;
                function9 = lambda$937349512$material;
                i20 = iM2421getEnd5ygKITE;
                shape2 = large;
                modifier3 = modifier2;
                j7 = j1112;
                j6 = j1114;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function8 = function2;
                shape2 = shape;
                j5 = j4;
                j6 = jM2335getBackground0d7_KjU;
                function9 = lambda$937349512$material;
                function10 = function7;
                i20 = i13;
                modifier3 = modifier2;
                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                z4 = z2;
                f3 = f;
                j7 = j;
                j8 = j2;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$1(function3, modifier3, bottomSheetScaffoldState2, function8, function9, function10, i20, z4, shape2, f3, j7, j8, f4, j6, j5, function6, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        i8 = i4 & 16;
        if (i8 != 0) {
            if ((i2 & 24576) == 0) {
                lambda$937349512$material = function4;
                if (composerStartRestartGroup.changedInstance(lambda$937349512$material)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i5 |= i9;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function7 = function5;
            } else {
                function7 = function5;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i5 |= i11;
                }
            }
            i12 = i4 & 64;
            if (i12 != 0) {
                i5 |= 1572864;
                i13 = i;
            } else {
                i13 = i;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(i13)) {
                        i14 = 1048576;
                    } else {
                        i14 = 524288;
                    }
                    i5 |= i14;
                }
            }
            i15 = i4 & 128;
            if (i15 != 0) {
                i5 |= 12582912;
                z2 = z;
            } else {
                z2 = z;
                if ((i2 & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i16 = 8388608;
                    } else {
                        i16 = 4194304;
                    }
                    i5 |= i16;
                }
            }
            if ((i2 & 100663296) != 0) {
                i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
            }
            if ((i2 & 805306368) != 0) {
                i5 |= ((i4 & 512) == 0 || !composerStartRestartGroup.changed(f)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            if ((i3 & 6) == 0) {
                if ((i4 & 1024) == 0) {
                    i27 = 2;
                } else {
                    i27 = 2;
                }
                i17 = i3 | i27;
            } else {
                i17 = i3;
            }
            if ((i3 & 48) == 0) {
                int i318 = i17;
                if ((i4 & 2048) == 0) {
                    i26 = 16;
                } else {
                    i26 = 16;
                }
                i17 = i318 | i26;
            }
            i18 = i17;
            if ((i3 & 384) == 0) {
                i19 = i18 | (((i4 & 4096) == 0 || !composerStartRestartGroup.changed(f2)) ? 128 : 256);
            } else {
                i19 = i18;
            }
            if ((i3 & 3072) == 0) {
                jM2335getBackground0d7_KjU = j3;
                i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(jM2335getBackground0d7_KjU)) ? 1024 : 2048;
            } else {
                jM2335getBackground0d7_KjU = j3;
            }
            if ((i3 & 24576) != 0) {
                i19 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j4)) ? 8192 : 16384;
            }
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i25 = 131072;
                } else {
                    i25 = 65536;
                }
                i19 |= i25;
            }
            if ((306783379 & i5) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "322@13393L34,328@13762L6,330@13893L6,331@13940L37,333@14093L6,334@14138L32");
                if ((i2 & 1) != 0) {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i4 & 4) != 0) {
                        i5 &= -897;
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i6 != 0) {
                        function11 = null;
                    } else {
                        function11 = function2;
                    }
                    if (i8 != 0) {
                        lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                    }
                    if (i10 != 0) {
                        function7 = null;
                    }
                    if (i12 != 0) {
                        iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                    } else {
                        iM2421getEnd5ygKITE = i13;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    }
                    if ((i4 & 256) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i5 &= -234881025;
                    } else {
                        large = shape;
                    }
                    if ((i4 & 512) != 0) {
                        fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                        i5 &= -1879048193;
                    } else {
                        fM2289getSheetElevationD9Ej5fM = f;
                    }
                    if ((i4 & 1024) != 0) {
                        i19 &= -15;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i4 & 2048) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                        i19 &= -113;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i21 = i19;
                    function2 = function11;
                    if ((i4 & 4096) != 0) {
                        fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                        i21 &= -897;
                    } else {
                        fM2290getSheetPeekHeightD9Ej5fM = f2;
                    }
                    f5 = fM2290getSheetPeekHeightD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                        i22 = i21 & (-7169);
                    } else {
                        i22 = i21;
                    }
                    if ((i4 & 16384) != 0) {
                        long jM2360contentColorForek8zF_U13 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                        i22 &= -57345;
                        j9 = jM2360contentColorForek8zF_U13;
                    } else {
                        j9 = j4;
                    }
                    j10 = jM2335getBackground0d7_KjU;
                    j11 = jM2346getSurface0d7_KjU;
                    z2 = z2;
                    i23 = i5;
                } else {
                    if (i28 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i4 & 4) != 0) {
                        i5 &= -897;
                        bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i6 != 0) {
                        function11 = null;
                    } else {
                        function11 = function2;
                    }
                    if (i8 != 0) {
                        lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                    }
                    if (i10 != 0) {
                        function7 = null;
                    }
                    if (i12 != 0) {
                        iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                    } else {
                        iM2421getEnd5ygKITE = i13;
                    }
                    if (i15 != 0) {
                        z2 = true;
                    }
                    if ((i4 & 256) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i5 &= -234881025;
                    } else {
                        large = shape;
                    }
                    if ((i4 & 512) != 0) {
                        fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                        i5 &= -1879048193;
                    } else {
                        fM2289getSheetElevationD9Ej5fM = f;
                    }
                    if ((i4 & 1024) != 0) {
                        i19 &= -15;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i4 & 2048) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                        i19 &= -113;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    i21 = i19;
                    function2 = function11;
                    if ((i4 & 4096) != 0) {
                        fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                        i21 &= -897;
                    } else {
                        fM2290getSheetPeekHeightD9Ej5fM = f2;
                    }
                    f5 = fM2290getSheetPeekHeightD9Ej5fM;
                    if ((i4 & 8192) != 0) {
                        jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                        i22 = i21 & (-7169);
                    } else {
                        i22 = i21;
                    }
                    if ((i4 & 16384) != 0) {
                        long jM2360contentColorForek8zF_U14 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                        i22 &= -57345;
                        j9 = jM2360contentColorForek8zF_U14;
                    } else {
                        j9 = j4;
                    }
                    j10 = jM2335getBackground0d7_KjU;
                    j11 = jM2346getSurface0d7_KjU;
                    z2 = z2;
                    i23 = i5;
                }
                i24 = i22;
                final Function2 function1110 = function2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(194495313, i23, i24, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
                }
                Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                final float f18 = f5;
                final long j1116 = j11;
                final Function3 function1111 = lambda$937349512$material;
                final int i319 = iM2421getEnd5ygKITE;
                final Function2 function1112 = function7;
                final Shape shape9 = large;
                final BottomSheetScaffoldState bottomSheetScaffoldState9 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                final boolean z11 = z2;
                final long j1117 = jM2360contentColorForek8zF_U;
                float f19 = fM2289getSheetElevationD9Ej5fM;
                ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(-747577963, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0(bottomSheetScaffoldState9, function1110, function1112, f18, i319, function6, z11, shape9, fM2289getSheetElevationD9Ej5fM, j1116, j1117, function3, function1111, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i3110 = i24 >> 3;
                long j1118 = j10;
                long j1119 = j9;
                SurfaceKt.m2584SurfaceFjzlyU(modifierFillMaxSize$default7, null, j1118, j1119, null, 0.0f, composableLambdaRememberComposableLambda7, composerStartRestartGroup, (i3110 & 7168) | (i3110 & 896) | 1572864, 50);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function8 = function1110;
                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                z4 = z2;
                j5 = j1119;
                j8 = j1117;
                f4 = f18;
                function10 = function7;
                f3 = f19;
                function9 = lambda$937349512$material;
                i20 = iM2421getEnd5ygKITE;
                shape2 = large;
                modifier3 = modifier2;
                j7 = j1116;
                j6 = j1118;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function8 = function2;
                shape2 = shape;
                j5 = j4;
                j6 = jM2335getBackground0d7_KjU;
                function9 = lambda$937349512$material;
                function10 = function7;
                i20 = i13;
                modifier3 = modifier2;
                bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
                z4 = z2;
                f3 = f;
                j7 = j;
                j8 = j2;
                f4 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$1(function3, modifier3, bottomSheetScaffoldState2, function8, function9, function10, i20, z4, shape2, f3, j7, j8, f4, j6, j5, function6, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        lambda$937349512$material = function4;
        i10 = i4 & 32;
        if (i10 != 0) {
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function7 = function5;
        } else {
            function7 = function5;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i5 |= i11;
            }
        }
        i12 = i4 & 64;
        if (i12 != 0) {
            i5 |= 1572864;
            i13 = i;
        } else {
            i13 = i;
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(i13)) {
                    i14 = 1048576;
                } else {
                    i14 = 524288;
                }
                i5 |= i14;
            }
        }
        i15 = i4 & 128;
        if (i15 != 0) {
            i5 |= 12582912;
            z2 = z;
        } else {
            z2 = z;
            if ((i2 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i16 = 8388608;
                } else {
                    i16 = 4194304;
                }
                i5 |= i16;
            }
        }
        if ((i2 & 100663296) != 0) {
            i5 |= ((i4 & 256) == 0 || !composerStartRestartGroup.changed(shape)) ? 33554432 : 67108864;
        }
        if ((i2 & 805306368) != 0) {
            i5 |= ((i4 & 512) == 0 || !composerStartRestartGroup.changed(f)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
        }
        if ((i3 & 6) == 0) {
            if ((i4 & 1024) == 0) {
                i27 = 2;
            } else {
                i27 = 2;
            }
            i17 = i3 | i27;
        } else {
            i17 = i3;
        }
        if ((i3 & 48) == 0) {
            int i3111 = i17;
            if ((i4 & 2048) == 0) {
                i26 = 16;
            } else {
                i26 = 16;
            }
            i17 = i3111 | i26;
        }
        i18 = i17;
        if ((i3 & 384) == 0) {
            i19 = i18 | (((i4 & 4096) == 0 || !composerStartRestartGroup.changed(f2)) ? 128 : 256);
        } else {
            i19 = i18;
        }
        if ((i3 & 3072) == 0) {
            jM2335getBackground0d7_KjU = j3;
            i19 |= ((i4 & 8192) == 0 || !composerStartRestartGroup.changed(jM2335getBackground0d7_KjU)) ? 1024 : 2048;
        } else {
            jM2335getBackground0d7_KjU = j3;
        }
        if ((i3 & 24576) != 0) {
            i19 |= ((i4 & 16384) == 0 || !composerStartRestartGroup.changed(j4)) ? 8192 : 16384;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i25 = 131072;
            } else {
                i25 = 65536;
            }
            i19 |= i25;
        }
        if ((306783379 & i5) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "322@13393L34,328@13762L6,330@13893L6,331@13940L37,333@14093L6,334@14138L32");
            if ((i2 & 1) != 0) {
                if (i28 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                }
                if (i6 != 0) {
                    function11 = null;
                } else {
                    function11 = function2;
                }
                if (i8 != 0) {
                    lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                }
                if (i10 != 0) {
                    function7 = null;
                }
                if (i12 != 0) {
                    iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                } else {
                    iM2421getEnd5ygKITE = i13;
                }
                if (i15 != 0) {
                    z2 = true;
                }
                if ((i4 & 256) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i5 &= -234881025;
                } else {
                    large = shape;
                }
                if ((i4 & 512) != 0) {
                    fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                    i5 &= -1879048193;
                } else {
                    fM2289getSheetElevationD9Ej5fM = f;
                }
                if ((i4 & 1024) != 0) {
                    i19 &= -15;
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i4 & 2048) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                    i19 &= -113;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i21 = i19;
                function2 = function11;
                if ((i4 & 4096) != 0) {
                    fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                    i21 &= -897;
                } else {
                    fM2290getSheetPeekHeightD9Ej5fM = f2;
                }
                f5 = fM2290getSheetPeekHeightD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                    i22 = i21 & (-7169);
                } else {
                    i22 = i21;
                }
                if ((i4 & 16384) != 0) {
                    long jM2360contentColorForek8zF_U15 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                    i22 &= -57345;
                    j9 = jM2360contentColorForek8zF_U15;
                } else {
                    j9 = j4;
                }
                j10 = jM2335getBackground0d7_KjU;
                j11 = jM2346getSurface0d7_KjU;
                z2 = z2;
                i23 = i5;
            } else {
                if (i28 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i4 & 4) != 0) {
                    i5 &= -897;
                    bottomSheetScaffoldStateRememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                }
                if (i6 != 0) {
                    function11 = null;
                } else {
                    function11 = function2;
                }
                if (i8 != 0) {
                    lambda$937349512$material = ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$937349512$material();
                }
                if (i10 != 0) {
                    function7 = null;
                }
                if (i12 != 0) {
                    iM2421getEnd5ygKITE = FabPosition.INSTANCE.m2421getEnd5ygKITE();
                } else {
                    iM2421getEnd5ygKITE = i13;
                }
                if (i15 != 0) {
                    z2 = true;
                }
                if ((i4 & 256) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i5 &= -234881025;
                } else {
                    large = shape;
                }
                if ((i4 & 512) != 0) {
                    fM2289getSheetElevationD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2289getSheetElevationD9Ej5fM();
                    i5 &= -1879048193;
                } else {
                    fM2289getSheetElevationD9Ej5fM = f;
                }
                if ((i4 & 1024) != 0) {
                    i19 &= -15;
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i4 & 2048) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, i19 & 14);
                    i19 &= -113;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i21 = i19;
                function2 = function11;
                if ((i4 & 4096) != 0) {
                    fM2290getSheetPeekHeightD9Ej5fM = BottomSheetScaffoldDefaults.INSTANCE.m2290getSheetPeekHeightD9Ej5fM();
                    i21 &= -897;
                } else {
                    fM2290getSheetPeekHeightD9Ej5fM = f2;
                }
                f5 = fM2290getSheetPeekHeightD9Ej5fM;
                if ((i4 & 8192) != 0) {
                    jM2335getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2335getBackground0d7_KjU();
                    i22 = i21 & (-7169);
                } else {
                    i22 = i21;
                }
                if ((i4 & 16384) != 0) {
                    long jM2360contentColorForek8zF_U16 = ColorsKt.m2360contentColorForek8zF_U(jM2335getBackground0d7_KjU, composerStartRestartGroup, (i22 >> 9) & 14);
                    i22 &= -57345;
                    j9 = jM2360contentColorForek8zF_U16;
                } else {
                    j9 = j4;
                }
                j10 = jM2335getBackground0d7_KjU;
                j11 = jM2346getSurface0d7_KjU;
                z2 = z2;
                i23 = i5;
            }
            i24 = i22;
            final Function2 function1113 = function2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(194495313, i23, i24, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:336)");
            }
            Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
            final float f110 = f5;
            final long j11110 = j11;
            final Function3 function1114 = lambda$937349512$material;
            final int i3112 = iM2421getEnd5ygKITE;
            final Function2 function1115 = function7;
            final Shape shape10 = large;
            final BottomSheetScaffoldState bottomSheetScaffoldState10 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
            final boolean z12 = z2;
            final long j11111 = jM2360contentColorForek8zF_U;
            float f111 = fM2289getSheetElevationD9Ej5fM;
            ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-747577963, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0(bottomSheetScaffoldState10, function1113, function1115, f110, i3112, function6, z12, shape10, fM2289getSheetElevationD9Ej5fM, j11110, j11111, function3, function1114, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            int i3113 = i24 >> 3;
            long j11112 = j10;
            long j11113 = j9;
            SurfaceKt.m2584SurfaceFjzlyU(modifierFillMaxSize$default8, null, j11112, j11113, null, 0.0f, composableLambdaRememberComposableLambda8, composerStartRestartGroup, (i3113 & 7168) | (i3113 & 896) | 1572864, 50);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function8 = function1113;
            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
            z4 = z2;
            j5 = j11113;
            j8 = j11111;
            f4 = f110;
            function10 = function7;
            f3 = f111;
            function9 = lambda$937349512$material;
            i20 = iM2421getEnd5ygKITE;
            shape2 = large;
            modifier3 = modifier2;
            j7 = j11110;
            j6 = j11112;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function8 = function2;
            shape2 = shape;
            j5 = j4;
            j6 = jM2335getBackground0d7_KjU;
            function9 = lambda$937349512$material;
            function10 = function7;
            i20 = i13;
            modifier3 = modifier2;
            bottomSheetScaffoldState2 = bottomSheetScaffoldStateRememberBottomSheetScaffoldState;
            z4 = z2;
            f3 = f;
            j7 = j;
            j8 = j2;
            f4 = f2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$1(function3, modifier3, bottomSheetScaffoldState2, function8, function9, function10, i20, z4, shape2, f3, j7, j8, f4, j6, j5, function6, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_HnlDQGw$lambda$0$0(Function3 function3, float f, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C340@14403L48:BottomSheetScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(601061661, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:340)");
            }
            function3.invoke(PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f, 7, null), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_HnlDQGw$lambda$0$1(boolean z, BottomSheetScaffoldState bottomSheetScaffoldState, float f, Shape shape, float f2, long j, long j2, Function3 function3, Composer composer, int i) {
        Modifier.Companion companionNestedScroll$default;
        ComposerKt.sourceInformation(composer, "C353@15111L576:BottomSheetScaffold.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1835125948, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:342)");
            }
            if (z) {
                composer.startReplaceGroup(-401495582);
                ComposerKt.sourceInformation(composer, "345@14641L391");
                Modifier.Companion companion = Modifier.INSTANCE;
                AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material = bottomSheetScaffoldState.getBottomSheetState().getAnchoredDraggableState$material();
                ComposerKt.sourceInformationMarkerStart(composer, -1675517117, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                boolean zChanged = composer.changed(anchoredDraggableState$material);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(bottomSheetScaffoldState.getBottomSheetState().getAnchoredDraggableState$material(), Orientation.Vertical);
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion, (NestedScrollConnection) objRememberedValue, null, 2, null);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1675503260);
                composer.endReplaceGroup();
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            m2296BottomSheetdAqlCkY(bottomSheetScaffoldState.getBottomSheetState(), z, shape, f2, j, j2, f, SizeKt.m1257requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(companionNestedScroll$default, 0.0f, 1, null), f, 0.0f, 2, null), function3, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_HnlDQGw$lambda$0$2(Function3 function3, BottomSheetScaffoldState bottomSheetScaffoldState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C366@15789L45:BottomSheetScaffold.kt#jmzs0o");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(8287226, i, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous>.<anonymous> (BottomSheetScaffold.kt:366)");
            }
            function3.invoke(bottomSheetScaffoldState.getSnackbarHostState(), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetScaffold_HnlDQGw$lambda$0(final BottomSheetScaffoldState bottomSheetScaffoldState, Function2 function2, Function2 function3, final float f, int i, final Function3 function4, final boolean z, final Shape shape, final float f2, final long j, final long j2, final Function3 function5, final Function3 function6, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C340@14401L52,341@14481L1220,366@15787L49,369@15968L50,338@14326L1776:BottomSheetScaffold.kt#jmzs0o");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-747577963, i2, -1, "androidx.compose.material.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:338)");
            }
            BottomSheetState bottomSheetState = bottomSheetScaffoldState.getBottomSheetState();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(601061661, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0$0(function4, f, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1835125948, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0$1(z, bottomSheetScaffoldState, f, shape, f2, j, j2, function5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(8287226, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0$2(function6, bottomSheetScaffoldState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1162831097, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean zChanged = composer.changed(bottomSheetScaffoldState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(BottomSheetScaffoldKt.BottomSheetScaffold_HnlDQGw$lambda$0$3$0(bottomSheetScaffoldState));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m2298BottomSheetScaffoldLayoutHJHHjMs(function2, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, function3, composableLambdaRememberComposableLambda3, f, (Function0) objRememberedValue, i, bottomSheetState, composer, 25008);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomSheetScaffold_HnlDQGw$lambda$0$3$0(BottomSheetScaffoldState bottomSheetScaffoldState) {
        return bottomSheetScaffoldState.getBottomSheetState().requireOffset();
    }

    /* JADX INFO: renamed from: BottomSheet-dAqlCkY, reason: not valid java name */
    private static final void m2296BottomSheetdAqlCkY(final BottomSheetState bottomSheetState, final boolean z, final Shape shape, final float f, final long j, final long j2, final float f2, Modifier modifier, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-426833549);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheet)N(state,sheetGesturesEnabled,sheetShape,sheetElevation:c#ui.unit.Dp,sheetBackgroundColor:c#ui.graphics.Color,sheetContentColor:c#ui.graphics.Color,sheetPeekHeight:c#ui.unit.Dp,modifier,content)388@16491L24,389@16557L7,392@16705L816,415@17745L893,440@18802L29,390@16597L2241:BottomSheetScaffold.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(bottomSheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        int i5 = i2 & 128;
        if (i5 != 0) {
            i3 |= 12582912;
            i4 = 1572864;
            modifier2 = modifier;
        } else {
            i4 = 1572864;
            modifier2 = modifier;
            if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier2) ? 8388608 : 4194304;
            }
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-426833549, i3, -1, "androidx.compose.material.BottomSheet (BottomSheetScaffold.kt:387)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fMo754toPx0680j_4 = ((Density) objConsume).mo754toPx0680j_4(f2);
            AnchoredDraggableState<BottomSheetValue> anchoredDraggableState$material = bottomSheetState.getAnchoredDraggableState$material();
            Orientation orientation = Orientation.Vertical;
            int i6 = i3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2129837731, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            int i7 = i6 & 14;
            boolean zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | (i7 == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$1$0(bottomSheetState, fMo754toPx0680j_4, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(modifier2, anchoredDraggableState$material, orientation, (Function2) objRememberedValue2), bottomSheetState.getAnchoredDraggableState$material(), Orientation.Vertical, z, false, null, false, 56, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2129871088, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean zChangedInstance = (i7 == 4) | composerStartRestartGroup.changedInstance(coroutineScope);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$2$0(bottomSheetState, coroutineScope, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i8 = i6 >> 6;
            int i9 = ((i6 >> 3) & 112) | i4 | (i8 & 896) | (i8 & 7168) | (458752 & (i6 << 6));
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2584SurfaceFjzlyU(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable$default, false, (Function1) objRememberedValue3, 1, null), shape, j, j2, null, f, ComposableLambdaKt.rememberComposableLambda(1065607095, true, new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, i9, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$4(bottomSheetState, z, shape, f, j, j2, f2, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair BottomSheet_dAqlCkY$lambda$1$0(BottomSheetState bottomSheetState, final float f, IntSize intSize, Constraints constraints) {
        BottomSheetValue bottomSheetValue;
        final int iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(constraints.getValue());
        final float fM9862unboximpl = (int) (intSize.m9862unboximpl() & 4294967295L);
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$1$0$0(iM9639getMaxHeightimpl, f, fM9862unboximpl, (DraggableAnchorsConfig) obj);
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getAnchoredDraggableState$material().getTargetValue().ordinal()];
        if (i == 1) {
            bottomSheetValue = BottomSheetValue.Collapsed;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            bottomSheetValue = DraggableAnchors.hasAnchorFor(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed;
        }
        return TuplesKt.to(DraggableAnchors, bottomSheetValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheet_dAqlCkY$lambda$1$0$0(int i, float f, float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        float f3 = i;
        draggableAnchorsConfig.at(BottomSheetValue.Collapsed, f3 - f);
        if (f2 > 0.0f && f2 != f) {
            draggableAnchorsConfig.at(BottomSheetValue.Expanded, f3 - f2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheet_dAqlCkY$lambda$2$0(final BottomSheetState bottomSheetState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (bottomSheetState.getAnchoredDraggableState$material().getAnchors().getSize() > 1) {
            if (bottomSheetState.isCollapsed()) {
                SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$2$0$0(bottomSheetState, coroutineScope));
                    }
                }, 1, null);
            } else {
                SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomSheetScaffoldKt.BottomSheet_dAqlCkY$lambda$2$0$1(bottomSheetState, coroutineScope));
                    }
                }, 1, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BottomSheet_dAqlCkY$lambda$2$0$0(BottomSheetState bottomSheetState, CoroutineScope coroutineScope) {
        if (!bottomSheetState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(BottomSheetValue.Expanded).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$BottomSheet$2$1$1$1(bottomSheetState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BottomSheet_dAqlCkY$lambda$2$0$1(BottomSheetState bottomSheetState, CoroutineScope coroutineScope) {
        if (!bottomSheetState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(BottomSheetValue.Collapsed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$BottomSheet$2$1$2$1(bottomSheetState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheet_dAqlCkY$lambda$3(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C440@18804L25:BottomSheetScaffold.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1065607095, i, -1, "androidx.compose.material.BottomSheet.<anonymous> (BottomSheetScaffold.kt:440)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: BottomSheetScaffoldLayout-HJHHjMs, reason: not valid java name */
    private static final void m2298BottomSheetScaffoldLayoutHJHHjMs(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, final float f, final Function0<Float> function0, final int i, final BottomSheetState bottomSheetState, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(757616750);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffoldLayout)N(topBar,body,bottomSheet,floatingActionButton,snackbarHost,sheetPeekHeight:c#ui.unit.Dp,sheetOffset,floatingActionButtonPosition:c#material.FabPosition,sheetState)479@20010L2783,470@19764L3029:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function6) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(bottomSheetState) ? 67108864 : 33554432;
        }
        if (!composerStartRestartGroup.shouldExecute((38347923 & i3) != 38347922, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(757616750, i3, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:469)");
            }
            Function2[] function2Arr = new Function2[5];
            function2Arr[0] = function2 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2365getLambda$505419337$material() : function2;
            function2Arr[1] = function3;
            function2Arr[2] = function4;
            function2Arr[3] = function5 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$687232378$material() : function5;
            function2Arr[4] = function6;
            List listListOf = CollectionsKt.listOf((Object[]) function2Arr);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2074720627, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z = ((3670016 & i3) == 1048576) | ((29360128 & i3) == 8388608) | ((458752 & i3) == 131072) | ((i3 & 234881024) == 67108864);
            BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(function0, i, f, bottomSheetState);
                composerStartRestartGroup.updateRememberedValue(bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) bottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicy);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetScaffoldKt.BottomSheetScaffoldLayout_HJHHjMs$lambda$1(function2, function3, function4, function5, function6, f, function0, i, bottomSheetState, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/material/BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", GuideCapping.INSERT_CAPPING_CONSUMED, "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        AnonymousClass1(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = orientation;
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
        public long mo1299onPreScrollOzD1aCk(long available, int source) {
            float fOffsetToFloat = offsetToFloat(available);
            if (fOffsetToFloat < 0.0f && NestedScrollSource.m8002equalsimpl0(source, NestedScrollSource.INSTANCE.m8014getUserInputWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(fOffsetToFloat));
            }
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public long mo946onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (NestedScrollSource.m8002equalsimpl0(source, NestedScrollSource.INSTANCE.m8014getUserInputWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
            }
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo */
        public Object mo1298onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
            BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1;
            if (continuation instanceof BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) {
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = (BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) continuation;
                if ((bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
                } else {
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, continuation);
                }
            } else {
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, continuation);
            }
            Object obj = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = this.$state.requireOffset();
                if (fVelocityToFloat < 0.0f && fRequireOffset > this.$state.getAnchors().minAnchor()) {
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0 = j;
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    j = Velocity.INSTANCE.m9936getZero9UxMQ8M();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0;
                ResultKt.throwOnFailure(obj);
            }
            return Velocity.m9916boximpl(j);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
            BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1;
            if (continuation instanceof BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) {
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = (BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) continuation;
                if ((bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                } else {
                    bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, continuation);
                }
            } else {
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, continuation);
            }
            Object obj = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                float fVelocityToFloat = velocityToFloat(j2);
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0 = j2;
                bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = 1;
                if (anchoredDraggableState.settle(fVelocityToFloat, bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = bottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0;
                ResultKt.throwOnFailure(obj);
            }
            return Velocity.m9916boximpl(j2);
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

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new AnonymousClass1(anchoredDraggableState, orientation);
    }
}
