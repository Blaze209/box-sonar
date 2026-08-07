package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchors;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.internal.DraggableAnchorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aË\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aå\u0001\u0010\u001f\u001a\u00020\u0001*\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020&2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0001¢\u0006\u0004\b(\u0010)\u001a\u0014\u0010*\u001a\u00020#*\u00020+2\u0006\u0010,\u001a\u00020#H\u0002\u001a\u0014\u0010-\u001a\u00020#*\u00020+2\u0006\u0010,\u001a\u00020#H\u0002\u001a-\u0010.\u001a\u00020\u00072\b\b\u0002\u0010/\u001a\u00020\u000b2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u000b0\u001aH\u0007¢\u0006\u0002\u00102\u001a5\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bH\u0003¢\u0006\u0004\b7\u00108\"\u0010\u00109\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010:\"\u0010\u0010;\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010:\"\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>¨\u0006?²\u0006\n\u0010@\u001a\u00020#X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "sheetGesturesEnabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-YbuCTN8", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetContent", "Landroidx/compose/foundation/layout/BoxScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animateToDismiss", "ModalBottomSheetContent-7---e2Q", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "calculatePredictiveBackScaleY", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "Scrim", "color", ViewProps.VISIBLE, "dismissEnabled", "Scrim-KTwxG1Y", "(JLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;I)V", "PredictiveBackMaxScaleXDistance", "F", "PredictiveBackMaxScaleYDistance", "PredictiveBackChildTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "material3", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt {
    private static final float PredictiveBackMaxScaleXDistance = Dp.m9687constructorimpl(48);
    private static final float PredictiveBackMaxScaleYDistance = Dp.m9687constructorimpl(24);
    private static final long PredictiveBackChildTransformOrigin = TransformOriginKt.TransformOrigin(0.5f, 0.0f);

    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$8(BoxScope boxScope, Animatable animatable, CoroutineScope coroutineScope, Function0 function0, Function0 function1, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, Function2 function2, Function2 function3, Function3 function4, int i, int i2, int i3, Composer composer, int i4) {
        m3812ModalBottomSheetContent7e2Q(boxScope, animatable, coroutineScope, function0, function1, modifier, sheetState, f, z, shape, j, j2, f2, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$7(Function0 function0, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, long j3, Function2 function2, Function2 function3, ModalBottomSheetProperties modalBottomSheetProperties, Function3 function4, int i, int i2, int i3, Composer composer, int i4) {
        m3811ModalBottomSheetYbuCTN8(function0, modifier, sheetState, f, z, shape, j, j2, f2, j3, function2, function3, modalBottomSheetProperties, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$4(long j, Function0 function0, boolean z, boolean z2, int i, Composer composer, int i2) {
        m3813ScrimKTwxG1Y(j, function0, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberModalBottomSheetState$lambda$0$0(SheetValue sheetValue) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets ModalBottomSheet_YbuCTN8$lambda$0(Composer composer, int i) {
        composer.startReplaceGroup(-511854661);
        ComposerKt.sourceInformation(composer, "C137@7176L12:ModalBottomSheet.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511854661, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:137)");
        }
        WindowInsets windowInsets = BottomSheetDefaults.INSTANCE.getWindowInsets(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return windowInsets;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0124  */
    /* JADX WARN: Code duplicated, block: B:103:0x0128  */
    /* JADX WARN: Code duplicated, block: B:106:0x012e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0137  */
    /* JADX WARN: Code duplicated, block: B:109:0x013b  */
    /* JADX WARN: Code duplicated, block: B:111:0x0145  */
    /* JADX WARN: Code duplicated, block: B:112:0x0148  */
    /* JADX WARN: Code duplicated, block: B:114:0x014d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0157  */
    /* JADX WARN: Code duplicated, block: B:119:0x015b  */
    /* JADX WARN: Code duplicated, block: B:122:0x0166 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:125:0x016d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0175  */
    /* JADX WARN: Code duplicated, block: B:129:0x017a  */
    /* JADX WARN: Code duplicated, block: B:131:0x0180  */
    /* JADX WARN: Code duplicated, block: B:133:0x0188  */
    /* JADX WARN: Code duplicated, block: B:134:0x018b  */
    /* JADX WARN: Code duplicated, block: B:139:0x0196  */
    /* JADX WARN: Code duplicated, block: B:141:0x019e  */
    /* JADX WARN: Code duplicated, block: B:143:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:150:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:155:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:177:0x021f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:178:0x0221  */
    /* JADX WARN: Code duplicated, block: B:181:0x022a  */
    /* JADX WARN: Code duplicated, block: B:183:0x0235  */
    /* JADX WARN: Code duplicated, block: B:184:0x023c  */
    /* JADX WARN: Code duplicated, block: B:186:0x023f  */
    /* JADX WARN: Code duplicated, block: B:189:0x0244  */
    /* JADX WARN: Code duplicated, block: B:192:0x0253  */
    /* JADX WARN: Code duplicated, block: B:193:0x025f  */
    /* JADX WARN: Code duplicated, block: B:196:0x0265  */
    /* JADX WARN: Code duplicated, block: B:197:0x0272  */
    /* JADX WARN: Code duplicated, block: B:199:0x0276  */
    /* JADX WARN: Code duplicated, block: B:200:0x027c  */
    /* JADX WARN: Code duplicated, block: B:203:0x0282  */
    /* JADX WARN: Code duplicated, block: B:204:0x028d  */
    /* JADX WARN: Code duplicated, block: B:206:0x0291  */
    /* JADX WARN: Code duplicated, block: B:207:0x0298  */
    /* JADX WARN: Code duplicated, block: B:210:0x029e  */
    /* JADX WARN: Code duplicated, block: B:211:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:214:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:215:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:219:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:222:0x0311  */
    /* JADX WARN: Code duplicated, block: B:226:0x031b  */
    /* JADX WARN: Code duplicated, block: B:228:0x0321 A[PHI: r39
      0x0321: PHI (r39v3 float) = (r39v1 float), (r39v4 float) binds: [B:227:0x031f, B:225:0x0318] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:229:0x0323  */
    /* JADX WARN: Code duplicated, block: B:232:0x0339  */
    /* JADX WARN: Code duplicated, block: B:234:0x0341  */
    /* JADX WARN: Code duplicated, block: B:237:0x036e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:240:0x038c  */
    /* JADX WARN: Code duplicated, block: B:242:0x0392  */
    /* JADX WARN: Code duplicated, block: B:248:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:249:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:252:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:254:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:257:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:258:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:261:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:263:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:269:0x0414  */
    /* JADX WARN: Code duplicated, block: B:270:0x0416  */
    /* JADX WARN: Code duplicated, block: B:273:0x041e  */
    /* JADX WARN: Code duplicated, block: B:275:0x0426  */
    /* JADX WARN: Code duplicated, block: B:278:0x048e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:280:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:282:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:288:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:290:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:292:0x04db  */
    /* JADX WARN: Code duplicated, block: B:295:0x04ea  */
    /* JADX WARN: Code duplicated, block: B:297:0x0501  */
    /* JADX WARN: Code duplicated, block: B:300:0x0520  */
    /* JADX WARN: Code duplicated, block: B:302:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x0102  */
    /* JADX WARN: Code duplicated, block: B:91:0x0108  */
    /* JADX WARN: Code duplicated, block: B:92:0x010b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0115  */
    /* JADX WARN: Code duplicated, block: B:98:0x011b  */
    /* JADX INFO: renamed from: ModalBottomSheet-YbuCTN8, reason: not valid java name */
    public static final void m3811ModalBottomSheetYbuCTN8(final Function0<Unit> function0, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, long j3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function3, ModalBottomSheetProperties modalBottomSheetProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        SheetState sheetStateRememberModalBottomSheetState;
        int i5;
        float f3;
        int i6;
        int i7;
        boolean z2;
        int i8;
        Shape expandedShape;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z3;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function5;
        final ModalBottomSheetProperties modalBottomSheetProperties2;
        Composer composer2;
        final float f4;
        final boolean z4;
        final Modifier modifier3;
        final SheetState sheetState2;
        final Shape shape2;
        final long j4;
        final long j5;
        final float f5;
        final long j6;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM2815getSheetMaxWidthD9Ej5fM;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        float fM9687constructorimpl;
        long scrimColor;
        final Function2<? super Composer, ? super Integer, Unit> lambda$1121996006$material3;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> function7;
        int i20;
        final long j7;
        ModalBottomSheetProperties modalBottomSheetProperties3;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function8;
        final float f6;
        int i21;
        final SheetState sheetState3;
        Modifier modifier4;
        final Shape shape3;
        final long j8;
        final FiniteAnimationSpec finiteAnimationSpecValue;
        final FiniteAnimationSpec finiteAnimationSpecValue2;
        final FiniteAnimationSpec finiteAnimationSpecValue3;
        int i22;
        float f7;
        boolean z5;
        boolean zChangedInstance;
        Object objRememberedValue;
        Object objRememberedValue2;
        final CoroutineScope coroutineScope;
        int i23;
        boolean z6;
        boolean z7;
        Object objRememberedValue3;
        Object objRememberedValue4;
        final Animatable animatable;
        boolean z8;
        boolean z9;
        Object objRememberedValue5;
        int i24;
        boolean z10;
        ModalBottomSheetKt$ModalBottomSheet$5$1 modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue;
        int i25;
        int i26;
        int i27;
        int i28;
        Composer composerStartRestartGroup = composer.startRestartGroup(1904798512);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,sheetGesturesEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,contentWindowInsets,properties,content)143@7499L7,144@7593L7,145@7684L7,147@7708L174,147@7697L185,152@7899L24,153@7963L304,165@8302L42,170@8471L708,182@9244L884,167@8350L1778:ModalBottomSheet.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i29 = i3 & 2;
        if (i29 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0) {
                    sheetStateRememberModalBottomSheetState = sheetState;
                    int i30 = composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState) ? 256 : 128;
                    i4 |= i30;
                } else {
                    sheetStateRememberModalBottomSheetState = sheetState;
                }
                i4 |= i30;
            } else {
                sheetStateRememberModalBottomSheetState = sheetState;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    f3 = f;
                    if (composerStartRestartGroup.changed(f3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    if ((i & 24576) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        expandedShape = shape;
                        if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(expandedShape)) {
                            i28 = 65536;
                        } else {
                            i28 = 131072;
                        }
                        i4 |= i28;
                    } else {
                        expandedShape = shape;
                    }
                    if ((i & 1572864) != 0) {
                        if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(j)) {
                            i27 = 524288;
                        } else {
                            i27 = 1048576;
                        }
                        i4 |= i27;
                    }
                    if ((i & 12582912) == 0) {
                        int i31 = i4;
                        if ((i3 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i26 = 4194304;
                        } else {
                            i26 = 8388608;
                        }
                        i9 = i31 | i26;
                    } else {
                        i9 = i4;
                    }
                    i10 = i3 & 256;
                    if (i10 != 0) {
                        i9 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i9 |= i11;
                    }
                    if ((i & 805306368) != 0) {
                        if ((i3 & 512) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i25 = 268435456;
                        } else {
                            i25 = C.BUFFER_FLAG_LAST_SAMPLE;
                        }
                        i9 |= i25;
                    }
                    i12 = i3 & 1024;
                    if (i12 != 0) {
                        i13 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i14 = 4;
                        } else {
                            i14 = 2;
                        }
                        i13 = i2 | i14;
                    } else {
                        i13 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
                    }
                    i15 = i13;
                    i16 = i3 & 4096;
                    if (i16 != 0) {
                        i17 = i15;
                        if ((i2 & 384) == 0) {
                            if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                                i18 = 256;
                            } else {
                                i18 = 128;
                            }
                            i17 |= i18;
                        }
                        if ((i2 & 3072) != 0) {
                            i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                        }
                        i19 = i17;
                        if ((i9 & 306783379) == 306783378 || (i19 & 1171) != 1170) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i29 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i3 & 4) != 0) {
                                    i9 &= -897;
                                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                                }
                                if (i5 != 0) {
                                    fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                                } else {
                                    fM2815getSheetMaxWidthD9Ej5fM = f3;
                                }
                                if (i7 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 32) != 0) {
                                    i9 &= -458753;
                                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 64) != 0) {
                                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i9 &= -3670017;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                    i9 &= -29360129;
                                } else {
                                    jM3051contentColorForek8zF_U = j2;
                                }
                                if (i10 != 0) {
                                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                                } else {
                                    fM9687constructorimpl = f2;
                                }
                                if ((i3 & 512) != 0) {
                                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                    i9 &= -1879048193;
                                } else {
                                    scrimColor = j3;
                                }
                                if (i12 != 0) {
                                    lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                                } else {
                                    lambda$1121996006$material3 = function2;
                                }
                                if ((i3 & 2048) != 0) {
                                    function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    };
                                    i19 &= -113;
                                } else {
                                    function7 = function3;
                                }
                                i20 = i19;
                                if (i16 != 0) {
                                    modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                    j7 = jM3051contentColorForek8zF_U;
                                } else {
                                    j7 = jM3051contentColorForek8zF_U;
                                    modalBottomSheetProperties3 = modalBottomSheetProperties;
                                }
                                function8 = function7;
                                f6 = fM9687constructorimpl;
                                i21 = i9;
                                sheetState3 = sheetStateRememberModalBottomSheetState;
                                long j9 = containerColor;
                                f3 = fM2815getSheetMaxWidthD9Ej5fM;
                                modifier4 = modifier2;
                                shape3 = expandedShape;
                                j8 = j9;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i9 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i9 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i9 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i9 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i9 &= -1879048193;
                                }
                                if ((i3 & 2048) != 0) {
                                    i19 &= -113;
                                }
                                j7 = j2;
                                f6 = f2;
                                scrimColor = j3;
                                lambda$1121996006$material3 = function2;
                                function8 = function3;
                                i20 = i19;
                                i21 = i9;
                                modifier4 = modifier2;
                                sheetState3 = sheetStateRememberModalBottomSheetState;
                                shape3 = expandedShape;
                                j8 = j;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                            }
                            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                            finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                            final ModalBottomSheetProperties modalBottomSheetProperties4 = modalBottomSheetProperties3;
                            finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                            int i32 = i20;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            i22 = (i21 & 896) ^ 384;
                            final Modifier modifier5 = modifier4;
                            if (i22 > 256 || !composerStartRestartGroup.changed(sheetState3)) {
                                f7 = f3;
                                if ((i21 & 384) != 256) {
                                    z5 = false;
                                }
                                zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                coroutineScope = (CoroutineScope) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                boolean zChangedInstance2 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                                i23 = i21 & 14;
                                if (i23 == 4) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                z7 = zChangedInstance2 | z6;
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z7 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                final Function0 function1 = (Function0) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                animatable = (Animatable) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                boolean zChangedInstance3 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                                if (i23 == 4) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                z9 = z8 | zChangedInstance3;
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (!z9 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                final float f8 = f7;
                                final boolean z11 = z2;
                                i24 = i21;
                                final long j10 = scrimColor;
                                ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties4, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j10, function1, sheetState3, modalBottomSheetProperties4, animatable, coroutineScope, function0, modifier5, f8, z11, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i32 & 896) | (Animatable.$stable << 9));
                                if (!sheetState3.getHasExpandedState()) {
                                    composerStartRestartGroup.startReplaceGroup(738111218);
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(748198866);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                    z10 = (i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i24 & 384) == 256;
                                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (!z10 || modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                sheetState2 = sheetState3;
                                composer2 = composerStartRestartGroup;
                                modifier3 = modifier5;
                                f4 = f8;
                                shape2 = shape3;
                                j4 = j8;
                                j5 = j7;
                                function6 = lambda$1121996006$material3;
                                function5 = function8;
                                j6 = j10;
                                modalBottomSheetProperties2 = modalBottomSheetProperties4;
                                z4 = z11;
                                f5 = f6;
                            } else {
                                f7 = f3;
                            }
                            z5 = true;
                            zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            coroutineScope = (CoroutineScope) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean zChangedInstance4 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                            i23 = i21 & 14;
                            if (i23 == 4) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            z7 = zChangedInstance4 | z6;
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z7) {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            final Function0 function9 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            animatable = (Animatable) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean zChangedInstance5 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                            if (i23 == 4) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            z9 = z8 | zChangedInstance5;
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (!z9) {
                                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final float f9 = f7;
                            final boolean z12 = z2;
                            i24 = i21;
                            final long j11 = scrimColor;
                            ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties4, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j11, function9, sheetState3, modalBottomSheetProperties4, animatable, coroutineScope, function0, modifier5, f9, z12, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i32 & 896) | (Animatable.$stable << 9));
                            if (!sheetState3.getHasExpandedState()) {
                                composerStartRestartGroup.startReplaceGroup(738111218);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(748198866);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                if (i22 <= 256) {
                                }
                                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z10) {
                                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                    composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                    composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sheetState2 = sheetState3;
                            composer2 = composerStartRestartGroup;
                            modifier3 = modifier5;
                            f4 = f9;
                            shape2 = shape3;
                            j4 = j8;
                            j5 = j7;
                            function6 = lambda$1121996006$material3;
                            function5 = function8;
                            j6 = j11;
                            modalBottomSheetProperties2 = modalBottomSheetProperties4;
                            z4 = z12;
                            f5 = f6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            function5 = function3;
                            modalBottomSheetProperties2 = modalBottomSheetProperties;
                            composer2 = composerStartRestartGroup;
                            f4 = f3;
                            z4 = z2;
                            modifier3 = modifier2;
                            sheetState2 = sheetStateRememberModalBottomSheetState;
                            shape2 = expandedShape;
                            j4 = j;
                            j5 = j2;
                            f5 = f2;
                            j6 = j3;
                            function6 = function2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i17 = i15 | 384;
                    if ((i2 & 3072) != 0) {
                        i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                    }
                    i19 = i17;
                    if ((i9 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM2815getSheetMaxWidthD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                i9 &= -458753;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                j7 = jM3051contentColorForek8zF_U;
                            } else {
                                j7 = jM3051contentColorForek8zF_U;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            function8 = function7;
                            f6 = fM9687constructorimpl;
                            i21 = i9;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            long j12 = containerColor;
                            f3 = fM2815getSheetMaxWidthD9Ej5fM;
                            modifier4 = modifier2;
                            shape3 = expandedShape;
                            j8 = j12;
                        } else {
                            if (i29 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM2815getSheetMaxWidthD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                i9 &= -458753;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                j7 = jM3051contentColorForek8zF_U;
                            } else {
                                j7 = jM3051contentColorForek8zF_U;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            function8 = function7;
                            f6 = fM9687constructorimpl;
                            i21 = i9;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            long j13 = containerColor;
                            f3 = fM2815getSheetMaxWidthD9Ej5fM;
                            modifier4 = modifier2;
                            shape3 = expandedShape;
                            j8 = j13;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        final ModalBottomSheetProperties modalBottomSheetProperties5 = modalBottomSheetProperties3;
                        finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                        int i33 = i20;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        i22 = (i21 & 896) ^ 384;
                        final Modifier modifier6 = modifier4;
                        if (i22 > 256) {
                            f7 = f3;
                            if ((i21 & 384) != 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        } else {
                            f7 = f3;
                            if ((i21 & 384) != 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        }
                        zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        boolean zChangedInstance6 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        i23 = i21 & 14;
                        if (i23 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance6 | z6;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final Function0 function10 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        animatable = (Animatable) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        boolean zChangedInstance7 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                        if (i23 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z8 | zChangedInstance7;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f10 = f7;
                        final boolean z13 = z2;
                        i24 = i21;
                        final long j14 = scrimColor;
                        ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties5, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j14, function10, sheetState3, modalBottomSheetProperties5, animatable, coroutineScope, function0, modifier6, f10, z13, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i33 & 896) | (Animatable.$stable << 9));
                        if (!sheetState3.getHasExpandedState()) {
                            composerStartRestartGroup.startReplaceGroup(738111218);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(748198866);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            if (i22 <= 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z10) {
                                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        sheetState2 = sheetState3;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier6;
                        f4 = f10;
                        shape2 = shape3;
                        j4 = j8;
                        j5 = j7;
                        function6 = lambda$1121996006$material3;
                        function5 = function8;
                        j6 = j14;
                        modalBottomSheetProperties2 = modalBottomSheetProperties5;
                        z4 = z13;
                        f5 = f6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function3;
                        modalBottomSheetProperties2 = modalBottomSheetProperties;
                        composer2 = composerStartRestartGroup;
                        f4 = f3;
                        z4 = z2;
                        modifier3 = modifier2;
                        sheetState2 = sheetStateRememberModalBottomSheetState;
                        shape2 = expandedShape;
                        j4 = j;
                        j5 = j2;
                        f5 = f2;
                        j6 = j3;
                        function6 = function2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                z2 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    expandedShape = shape;
                    if ((i3 & 32) == 0) {
                        i28 = 65536;
                    } else {
                        i28 = 65536;
                    }
                    i4 |= i28;
                } else {
                    expandedShape = shape;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i27 = 524288;
                    } else {
                        i27 = 524288;
                    }
                    i4 |= i27;
                }
                if ((i & 12582912) == 0) {
                    int i34 = i4;
                    if ((i3 & 128) == 0) {
                        i26 = 4194304;
                    } else {
                        i26 = 4194304;
                    }
                    i9 = i34 | i26;
                } else {
                    i9 = i4;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i9 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i9 |= i11;
                }
                if ((i & 805306368) != 0) {
                    if ((i3 & 512) == 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 268435456;
                    }
                    i9 |= i25;
                }
                i12 = i3 & 1024;
                if (i12 != 0) {
                    i13 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 4;
                    } else {
                        i14 = 2;
                    }
                    i13 = i2 | i14;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) != 0) {
                    i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
                }
                i15 = i13;
                i16 = i3 & 4096;
                if (i16 != 0) {
                    i17 = i15;
                    if ((i2 & 384) == 0) {
                        if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                            i18 = 256;
                        } else {
                            i18 = 128;
                        }
                        i17 |= i18;
                    }
                    if ((i2 & 3072) != 0) {
                        i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                    }
                    i19 = i17;
                    if ((i9 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM2815getSheetMaxWidthD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                i9 &= -458753;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                j7 = jM3051contentColorForek8zF_U;
                            } else {
                                j7 = jM3051contentColorForek8zF_U;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            function8 = function7;
                            f6 = fM9687constructorimpl;
                            i21 = i9;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            long j15 = containerColor;
                            f3 = fM2815getSheetMaxWidthD9Ej5fM;
                            modifier4 = modifier2;
                            shape3 = expandedShape;
                            j8 = j15;
                        } else {
                            if (i29 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM2815getSheetMaxWidthD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                i9 &= -458753;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                j7 = jM3051contentColorForek8zF_U;
                            } else {
                                j7 = jM3051contentColorForek8zF_U;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            function8 = function7;
                            f6 = fM9687constructorimpl;
                            i21 = i9;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            long j16 = containerColor;
                            f3 = fM2815getSheetMaxWidthD9Ej5fM;
                            modifier4 = modifier2;
                            shape3 = expandedShape;
                            j8 = j16;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        final ModalBottomSheetProperties modalBottomSheetProperties6 = modalBottomSheetProperties3;
                        finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                        int i35 = i20;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        i22 = (i21 & 896) ^ 384;
                        final Modifier modifier7 = modifier4;
                        if (i22 > 256) {
                            f7 = f3;
                            if ((i21 & 384) != 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        } else {
                            f7 = f3;
                            if ((i21 & 384) != 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        }
                        zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        boolean zChangedInstance8 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        i23 = i21 & 14;
                        if (i23 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance8 | z6;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final Function0 function11 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        animatable = (Animatable) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        boolean zChangedInstance9 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                        if (i23 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z8 | zChangedInstance9;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f11 = f7;
                        final boolean z14 = z2;
                        i24 = i21;
                        final long j17 = scrimColor;
                        ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties6, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j17, function11, sheetState3, modalBottomSheetProperties6, animatable, coroutineScope, function0, modifier7, f11, z14, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i35 & 896) | (Animatable.$stable << 9));
                        if (!sheetState3.getHasExpandedState()) {
                            composerStartRestartGroup.startReplaceGroup(738111218);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(748198866);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            if (i22 <= 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z10) {
                                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        sheetState2 = sheetState3;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier7;
                        f4 = f11;
                        shape2 = shape3;
                        j4 = j8;
                        j5 = j7;
                        function6 = lambda$1121996006$material3;
                        function5 = function8;
                        j6 = j17;
                        modalBottomSheetProperties2 = modalBottomSheetProperties6;
                        z4 = z14;
                        f5 = f6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function3;
                        modalBottomSheetProperties2 = modalBottomSheetProperties;
                        composer2 = composerStartRestartGroup;
                        f4 = f3;
                        z4 = z2;
                        modifier3 = modifier2;
                        sheetState2 = sheetStateRememberModalBottomSheetState;
                        shape2 = expandedShape;
                        j4 = j;
                        j5 = j2;
                        f5 = f2;
                        j6 = j3;
                        function6 = function2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i17 = i15 | 384;
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j18 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j18;
                    } else {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j19 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j19;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    final ModalBottomSheetProperties modalBottomSheetProperties7 = modalBottomSheetProperties3;
                    finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    int i36 = i20;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i22 = (i21 & 896) ^ 384;
                    final Modifier modifier8 = modifier4;
                    if (i22 > 256) {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance10 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    i23 = i21 & 14;
                    if (i23 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance10 | z6;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final Function0 function12 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    animatable = (Animatable) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance11 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                    if (i23 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance11;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f12 = f7;
                    final boolean z15 = z2;
                    i24 = i21;
                    final long j110 = scrimColor;
                    ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties7, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j110, function12, sheetState3, modalBottomSheetProperties7, animatable, coroutineScope, function0, modifier8, f12, z15, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i36 & 896) | (Animatable.$stable << 9));
                    if (!sheetState3.getHasExpandedState()) {
                        composerStartRestartGroup.startReplaceGroup(738111218);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(748198866);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i22 <= 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sheetState2 = sheetState3;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier8;
                    f4 = f12;
                    shape2 = shape3;
                    j4 = j8;
                    j5 = j7;
                    function6 = lambda$1121996006$material3;
                    function5 = function8;
                    j6 = j110;
                    modalBottomSheetProperties2 = modalBottomSheetProperties7;
                    z4 = z15;
                    f5 = f6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    composer2 = composerStartRestartGroup;
                    f4 = f3;
                    z4 = z2;
                    modifier3 = modifier2;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    shape2 = expandedShape;
                    j4 = j;
                    j5 = j2;
                    f5 = f2;
                    j6 = j3;
                    function6 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            f3 = f;
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    expandedShape = shape;
                    if ((i3 & 32) == 0) {
                        i28 = 65536;
                    } else {
                        i28 = 65536;
                    }
                    i4 |= i28;
                } else {
                    expandedShape = shape;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i27 = 524288;
                    } else {
                        i27 = 524288;
                    }
                    i4 |= i27;
                }
                if ((i & 12582912) == 0) {
                    int i37 = i4;
                    if ((i3 & 128) == 0) {
                        i26 = 4194304;
                    } else {
                        i26 = 4194304;
                    }
                    i9 = i37 | i26;
                } else {
                    i9 = i4;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i9 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i9 |= i11;
                }
                if ((i & 805306368) != 0) {
                    if ((i3 & 512) == 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 268435456;
                    }
                    i9 |= i25;
                }
                i12 = i3 & 1024;
                if (i12 != 0) {
                    i13 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 4;
                    } else {
                        i14 = 2;
                    }
                    i13 = i2 | i14;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) != 0) {
                    i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
                }
                i15 = i13;
                i16 = i3 & 4096;
                if (i16 != 0) {
                    i17 = i15;
                    if ((i2 & 384) == 0) {
                        if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                            i18 = 256;
                        } else {
                            i18 = 128;
                        }
                        i17 |= i18;
                    }
                    if ((i2 & 3072) != 0) {
                        i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                    }
                    i19 = i17;
                    if ((i9 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM2815getSheetMaxWidthD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                i9 &= -458753;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                j7 = jM3051contentColorForek8zF_U;
                            } else {
                                j7 = jM3051contentColorForek8zF_U;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            function8 = function7;
                            f6 = fM9687constructorimpl;
                            i21 = i9;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            long j111 = containerColor;
                            f3 = fM2815getSheetMaxWidthD9Ej5fM;
                            modifier4 = modifier2;
                            shape3 = expandedShape;
                            j8 = j111;
                        } else {
                            if (i29 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM2815getSheetMaxWidthD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                i9 &= -458753;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                j7 = jM3051contentColorForek8zF_U;
                            } else {
                                j7 = jM3051contentColorForek8zF_U;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            function8 = function7;
                            f6 = fM9687constructorimpl;
                            i21 = i9;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            long j112 = containerColor;
                            f3 = fM2815getSheetMaxWidthD9Ej5fM;
                            modifier4 = modifier2;
                            shape3 = expandedShape;
                            j8 = j112;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        final ModalBottomSheetProperties modalBottomSheetProperties8 = modalBottomSheetProperties3;
                        finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                        int i38 = i20;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        i22 = (i21 & 896) ^ 384;
                        final Modifier modifier9 = modifier4;
                        if (i22 > 256) {
                            f7 = f3;
                            if ((i21 & 384) != 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        } else {
                            f7 = f3;
                            if ((i21 & 384) != 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        }
                        zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        boolean zChangedInstance12 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        i23 = i21 & 14;
                        if (i23 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance12 | z6;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final Function0 function13 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        animatable = (Animatable) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        boolean zChangedInstance13 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                        if (i23 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z8 | zChangedInstance13;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f13 = f7;
                        final boolean z16 = z2;
                        i24 = i21;
                        final long j113 = scrimColor;
                        ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties8, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j113, function13, sheetState3, modalBottomSheetProperties8, animatable, coroutineScope, function0, modifier9, f13, z16, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i38 & 896) | (Animatable.$stable << 9));
                        if (!sheetState3.getHasExpandedState()) {
                            composerStartRestartGroup.startReplaceGroup(738111218);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(748198866);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            if (i22 <= 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z10) {
                                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        sheetState2 = sheetState3;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier9;
                        f4 = f13;
                        shape2 = shape3;
                        j4 = j8;
                        j5 = j7;
                        function6 = lambda$1121996006$material3;
                        function5 = function8;
                        j6 = j113;
                        modalBottomSheetProperties2 = modalBottomSheetProperties8;
                        z4 = z16;
                        f5 = f6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function3;
                        modalBottomSheetProperties2 = modalBottomSheetProperties;
                        composer2 = composerStartRestartGroup;
                        f4 = f3;
                        z4 = z2;
                        modifier3 = modifier2;
                        sheetState2 = sheetStateRememberModalBottomSheetState;
                        shape2 = expandedShape;
                        j4 = j;
                        j5 = j2;
                        f5 = f2;
                        j6 = j3;
                        function6 = function2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i17 = i15 | 384;
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j114 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j114;
                    } else {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j115 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j115;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    final ModalBottomSheetProperties modalBottomSheetProperties9 = modalBottomSheetProperties3;
                    finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    int i39 = i20;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i22 = (i21 & 896) ^ 384;
                    final Modifier modifier10 = modifier4;
                    if (i22 > 256) {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance14 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    i23 = i21 & 14;
                    if (i23 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance14 | z6;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final Function0 function14 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    animatable = (Animatable) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance15 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                    if (i23 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance15;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f14 = f7;
                    final boolean z17 = z2;
                    i24 = i21;
                    final long j116 = scrimColor;
                    ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties9, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j116, function14, sheetState3, modalBottomSheetProperties9, animatable, coroutineScope, function0, modifier10, f14, z17, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i39 & 896) | (Animatable.$stable << 9));
                    if (!sheetState3.getHasExpandedState()) {
                        composerStartRestartGroup.startReplaceGroup(738111218);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(748198866);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i22 <= 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sheetState2 = sheetState3;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier10;
                    f4 = f14;
                    shape2 = shape3;
                    j4 = j8;
                    j5 = j7;
                    function6 = lambda$1121996006$material3;
                    function5 = function8;
                    j6 = j116;
                    modalBottomSheetProperties2 = modalBottomSheetProperties9;
                    z4 = z17;
                    f5 = f6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    composer2 = composerStartRestartGroup;
                    f4 = f3;
                    z4 = z2;
                    modifier3 = modifier2;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    shape2 = expandedShape;
                    j4 = j;
                    j5 = j2;
                    f5 = f2;
                    j6 = j3;
                    function6 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            z2 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                expandedShape = shape;
                if ((i3 & 32) == 0) {
                    i28 = 65536;
                } else {
                    i28 = 65536;
                }
                i4 |= i28;
            } else {
                expandedShape = shape;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i27 = 524288;
                } else {
                    i27 = 524288;
                }
                i4 |= i27;
            }
            if ((i & 12582912) == 0) {
                int i310 = i4;
                if ((i3 & 128) == 0) {
                    i26 = 4194304;
                } else {
                    i26 = 4194304;
                }
                i9 = i310 | i26;
            } else {
                i9 = i4;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                i9 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i9 |= i11;
            }
            if ((i & 805306368) != 0) {
                if ((i3 & 512) == 0) {
                    i25 = 268435456;
                } else {
                    i25 = 268435456;
                }
                i9 |= i25;
            }
            i12 = i3 & 1024;
            if (i12 != 0) {
                i13 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 4;
                } else {
                    i14 = 2;
                }
                i13 = i2 | i14;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) != 0) {
                i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
            }
            i15 = i13;
            i16 = i3 & 4096;
            if (i16 != 0) {
                i17 = i15;
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                        i18 = 256;
                    } else {
                        i18 = 128;
                    }
                    i17 |= i18;
                }
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j117 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j117;
                    } else {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j118 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j118;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    final ModalBottomSheetProperties modalBottomSheetProperties10 = modalBottomSheetProperties3;
                    finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    int i311 = i20;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i22 = (i21 & 896) ^ 384;
                    final Modifier modifier11 = modifier4;
                    if (i22 > 256) {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance16 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    i23 = i21 & 14;
                    if (i23 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance16 | z6;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final Function0 function15 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    animatable = (Animatable) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance17 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                    if (i23 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance17;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f15 = f7;
                    final boolean z18 = z2;
                    i24 = i21;
                    final long j119 = scrimColor;
                    ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties10, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j119, function15, sheetState3, modalBottomSheetProperties10, animatable, coroutineScope, function0, modifier11, f15, z18, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i311 & 896) | (Animatable.$stable << 9));
                    if (!sheetState3.getHasExpandedState()) {
                        composerStartRestartGroup.startReplaceGroup(738111218);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(748198866);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i22 <= 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sheetState2 = sheetState3;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier11;
                    f4 = f15;
                    shape2 = shape3;
                    j4 = j8;
                    j5 = j7;
                    function6 = lambda$1121996006$material3;
                    function5 = function8;
                    j6 = j119;
                    modalBottomSheetProperties2 = modalBottomSheetProperties10;
                    z4 = z18;
                    f5 = f6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    composer2 = composerStartRestartGroup;
                    f4 = f3;
                    z4 = z2;
                    modifier3 = modifier2;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    shape2 = expandedShape;
                    j4 = j;
                    j5 = j2;
                    f5 = f2;
                    j6 = j3;
                    function6 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i17 = i15 | 384;
            if ((i2 & 3072) != 0) {
                i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
            }
            i19 = i17;
            if ((i9 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM2815getSheetMaxWidthD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        i9 &= -458753;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        j7 = jM3051contentColorForek8zF_U;
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    function8 = function7;
                    f6 = fM9687constructorimpl;
                    i21 = i9;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    long j1110 = containerColor;
                    f3 = fM2815getSheetMaxWidthD9Ej5fM;
                    modifier4 = modifier2;
                    shape3 = expandedShape;
                    j8 = j1110;
                } else {
                    if (i29 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM2815getSheetMaxWidthD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        i9 &= -458753;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        j7 = jM3051contentColorForek8zF_U;
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    function8 = function7;
                    f6 = fM9687constructorimpl;
                    i21 = i9;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    long j1111 = containerColor;
                    f3 = fM2815getSheetMaxWidthD9Ej5fM;
                    modifier4 = modifier2;
                    shape3 = expandedShape;
                    j8 = j1111;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                final ModalBottomSheetProperties modalBottomSheetProperties11 = modalBottomSheetProperties3;
                finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                int i312 = i20;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                i22 = (i21 & 896) ^ 384;
                final Modifier modifier12 = modifier4;
                if (i22 > 256) {
                    f7 = f3;
                    if ((i21 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                } else {
                    f7 = f3;
                    if ((i21 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChangedInstance18 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                i23 = i21 & 14;
                if (i23 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance18 | z6;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final Function0 function16 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                animatable = (Animatable) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChangedInstance19 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                if (i23 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChangedInstance19;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float f16 = f7;
                final boolean z19 = z2;
                i24 = i21;
                final long j1112 = scrimColor;
                ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties11, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j1112, function16, sheetState3, modalBottomSheetProperties11, animatable, coroutineScope, function0, modifier12, f16, z19, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i312 & 896) | (Animatable.$stable << 9));
                if (!sheetState3.getHasExpandedState()) {
                    composerStartRestartGroup.startReplaceGroup(738111218);
                } else {
                    composerStartRestartGroup.startReplaceGroup(748198866);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i22 <= 256) {
                    }
                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                    } else {
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                sheetState2 = sheetState3;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier12;
                f4 = f16;
                shape2 = shape3;
                j4 = j8;
                j5 = j7;
                function6 = lambda$1121996006$material3;
                function5 = function8;
                j6 = j1112;
                modalBottomSheetProperties2 = modalBottomSheetProperties11;
                z4 = z19;
                f5 = f6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                composer2 = composerStartRestartGroup;
                f4 = f3;
                z4 = z2;
                modifier3 = modifier2;
                sheetState2 = sheetStateRememberModalBottomSheetState;
                shape2 = expandedShape;
                j4 = j;
                j5 = j2;
                f5 = f2;
                j6 = j3;
                function6 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i3 & 4) == 0) {
                sheetStateRememberModalBottomSheetState = sheetState;
                if (composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) {
                }
                i4 |= i30;
            } else {
                sheetStateRememberModalBottomSheetState = sheetState;
            }
            i4 |= i30;
        } else {
            sheetStateRememberModalBottomSheetState = sheetState;
        }
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                f3 = f;
                if (composerStartRestartGroup.changed(f3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    expandedShape = shape;
                    if ((i3 & 32) == 0) {
                        i28 = 65536;
                    } else {
                        i28 = 65536;
                    }
                    i4 |= i28;
                } else {
                    expandedShape = shape;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i27 = 524288;
                    } else {
                        i27 = 524288;
                    }
                    i4 |= i27;
                }
                if ((i & 12582912) == 0) {
                    int i313 = i4;
                    if ((i3 & 128) == 0) {
                        i26 = 4194304;
                    } else {
                        i26 = 4194304;
                    }
                    i9 = i313 | i26;
                } else {
                    i9 = i4;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    i9 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i9 |= i11;
                }
                if ((i & 805306368) != 0) {
                    if ((i3 & 512) == 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 268435456;
                    }
                    i9 |= i25;
                }
                i12 = i3 & 1024;
                if (i12 != 0) {
                    i13 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i14 = 4;
                    } else {
                        i14 = 2;
                    }
                    i13 = i2 | i14;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) != 0) {
                    i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
                }
                i15 = i13;
                i16 = i3 & 4096;
                if (i16 != 0) {
                    i17 = i15;
                    if ((i2 & 384) == 0) {
                        if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                            i18 = 256;
                        } else {
                            i18 = 128;
                        }
                        i17 |= i18;
                    }
                    if ((i2 & 3072) != 0) {
                        i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                    }
                    i19 = i17;
                    if ((i9 & 306783379) == 306783378) {
                        z3 = true;
                    } else {
                        z3 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                        if ((i & 1) != 0) {
                            if (i29 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM2815getSheetMaxWidthD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                i9 &= -458753;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                j7 = jM3051contentColorForek8zF_U;
                            } else {
                                j7 = jM3051contentColorForek8zF_U;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            function8 = function7;
                            f6 = fM9687constructorimpl;
                            i21 = i9;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            long j1113 = containerColor;
                            f3 = fM2815getSheetMaxWidthD9Ej5fM;
                            modifier4 = modifier2;
                            shape3 = expandedShape;
                            j8 = j1113;
                        } else {
                            if (i29 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                i9 &= -897;
                                sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                            }
                            if (i5 != 0) {
                                fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                            } else {
                                fM2815getSheetMaxWidthD9Ej5fM = f3;
                            }
                            if (i7 != 0) {
                                z2 = true;
                            }
                            if ((i3 & 32) != 0) {
                                i9 &= -458753;
                                expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 64) != 0) {
                                containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i9 &= -3670017;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                                i9 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            } else {
                                fM9687constructorimpl = f2;
                            }
                            if ((i3 & 512) != 0) {
                                scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                                i9 &= -1879048193;
                            } else {
                                scrimColor = j3;
                            }
                            if (i12 != 0) {
                                lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                            } else {
                                lambda$1121996006$material3 = function2;
                            }
                            if ((i3 & 2048) != 0) {
                                function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                    }
                                };
                                i19 &= -113;
                            } else {
                                function7 = function3;
                            }
                            i20 = i19;
                            if (i16 != 0) {
                                modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                                j7 = jM3051contentColorForek8zF_U;
                            } else {
                                j7 = jM3051contentColorForek8zF_U;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                            }
                            function8 = function7;
                            f6 = fM9687constructorimpl;
                            i21 = i9;
                            sheetState3 = sheetStateRememberModalBottomSheetState;
                            long j1114 = containerColor;
                            f3 = fM2815getSheetMaxWidthD9Ej5fM;
                            modifier4 = modifier2;
                            shape3 = expandedShape;
                            j8 = j1114;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        final ModalBottomSheetProperties modalBottomSheetProperties12 = modalBottomSheetProperties3;
                        finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                        int i314 = i20;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        i22 = (i21 & 896) ^ 384;
                        final Modifier modifier13 = modifier4;
                        if (i22 > 256) {
                            f7 = f3;
                            if ((i21 & 384) != 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        } else {
                            f7 = f3;
                            if ((i21 & 384) != 256) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                        }
                        zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        boolean zChangedInstance110 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        i23 = i21 & 14;
                        if (i23 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance110 | z6;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z7) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        final Function0 function17 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        animatable = (Animatable) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        boolean zChangedInstance111 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                        if (i23 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z8 | zChangedInstance111;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final float f17 = f7;
                        final boolean z110 = z2;
                        i24 = i21;
                        final long j1115 = scrimColor;
                        ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties12, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j1115, function17, sheetState3, modalBottomSheetProperties12, animatable, coroutineScope, function0, modifier13, f17, z110, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i314 & 896) | (Animatable.$stable << 9));
                        if (!sheetState3.getHasExpandedState()) {
                            composerStartRestartGroup.startReplaceGroup(738111218);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(748198866);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            if (i22 <= 256) {
                            }
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z10) {
                                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                            } else {
                                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                                composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        sheetState2 = sheetState3;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier13;
                        f4 = f17;
                        shape2 = shape3;
                        j4 = j8;
                        j5 = j7;
                        function6 = lambda$1121996006$material3;
                        function5 = function8;
                        j6 = j1115;
                        modalBottomSheetProperties2 = modalBottomSheetProperties12;
                        z4 = z110;
                        f5 = f6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function3;
                        modalBottomSheetProperties2 = modalBottomSheetProperties;
                        composer2 = composerStartRestartGroup;
                        f4 = f3;
                        z4 = z2;
                        modifier3 = modifier2;
                        sheetState2 = sheetStateRememberModalBottomSheetState;
                        shape2 = expandedShape;
                        j4 = j;
                        j5 = j2;
                        f5 = f2;
                        j6 = j3;
                        function6 = function2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i17 = i15 | 384;
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j1116 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j1116;
                    } else {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j1117 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j1117;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    final ModalBottomSheetProperties modalBottomSheetProperties13 = modalBottomSheetProperties3;
                    finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    int i315 = i20;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i22 = (i21 & 896) ^ 384;
                    final Modifier modifier14 = modifier4;
                    if (i22 > 256) {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance112 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    i23 = i21 & 14;
                    if (i23 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance112 | z6;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final Function0 function18 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    animatable = (Animatable) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance113 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                    if (i23 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance113;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f18 = f7;
                    final boolean z111 = z2;
                    i24 = i21;
                    final long j1118 = scrimColor;
                    ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties13, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j1118, function18, sheetState3, modalBottomSheetProperties13, animatable, coroutineScope, function0, modifier14, f18, z111, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i315 & 896) | (Animatable.$stable << 9));
                    if (!sheetState3.getHasExpandedState()) {
                        composerStartRestartGroup.startReplaceGroup(738111218);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(748198866);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i22 <= 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sheetState2 = sheetState3;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier14;
                    f4 = f18;
                    shape2 = shape3;
                    j4 = j8;
                    j5 = j7;
                    function6 = lambda$1121996006$material3;
                    function5 = function8;
                    j6 = j1118;
                    modalBottomSheetProperties2 = modalBottomSheetProperties13;
                    z4 = z111;
                    f5 = f6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    composer2 = composerStartRestartGroup;
                    f4 = f3;
                    z4 = z2;
                    modifier3 = modifier2;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    shape2 = expandedShape;
                    j4 = j;
                    j5 = j2;
                    f5 = f2;
                    j6 = j3;
                    function6 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            z2 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                expandedShape = shape;
                if ((i3 & 32) == 0) {
                    i28 = 65536;
                } else {
                    i28 = 65536;
                }
                i4 |= i28;
            } else {
                expandedShape = shape;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i27 = 524288;
                } else {
                    i27 = 524288;
                }
                i4 |= i27;
            }
            if ((i & 12582912) == 0) {
                int i316 = i4;
                if ((i3 & 128) == 0) {
                    i26 = 4194304;
                } else {
                    i26 = 4194304;
                }
                i9 = i316 | i26;
            } else {
                i9 = i4;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                i9 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i9 |= i11;
            }
            if ((i & 805306368) != 0) {
                if ((i3 & 512) == 0) {
                    i25 = 268435456;
                } else {
                    i25 = 268435456;
                }
                i9 |= i25;
            }
            i12 = i3 & 1024;
            if (i12 != 0) {
                i13 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 4;
                } else {
                    i14 = 2;
                }
                i13 = i2 | i14;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) != 0) {
                i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
            }
            i15 = i13;
            i16 = i3 & 4096;
            if (i16 != 0) {
                i17 = i15;
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                        i18 = 256;
                    } else {
                        i18 = 128;
                    }
                    i17 |= i18;
                }
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j1119 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j1119;
                    } else {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j11110 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j11110;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    final ModalBottomSheetProperties modalBottomSheetProperties14 = modalBottomSheetProperties3;
                    finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    int i317 = i20;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i22 = (i21 & 896) ^ 384;
                    final Modifier modifier15 = modifier4;
                    if (i22 > 256) {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance114 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    i23 = i21 & 14;
                    if (i23 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance114 | z6;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final Function0 function19 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    animatable = (Animatable) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance115 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                    if (i23 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance115;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f19 = f7;
                    final boolean z112 = z2;
                    i24 = i21;
                    final long j11111 = scrimColor;
                    ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties14, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j11111, function19, sheetState3, modalBottomSheetProperties14, animatable, coroutineScope, function0, modifier15, f19, z112, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i317 & 896) | (Animatable.$stable << 9));
                    if (!sheetState3.getHasExpandedState()) {
                        composerStartRestartGroup.startReplaceGroup(738111218);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(748198866);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i22 <= 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sheetState2 = sheetState3;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier15;
                    f4 = f19;
                    shape2 = shape3;
                    j4 = j8;
                    j5 = j7;
                    function6 = lambda$1121996006$material3;
                    function5 = function8;
                    j6 = j11111;
                    modalBottomSheetProperties2 = modalBottomSheetProperties14;
                    z4 = z112;
                    f5 = f6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    composer2 = composerStartRestartGroup;
                    f4 = f3;
                    z4 = z2;
                    modifier3 = modifier2;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    shape2 = expandedShape;
                    j4 = j;
                    j5 = j2;
                    f5 = f2;
                    j6 = j3;
                    function6 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i17 = i15 | 384;
            if ((i2 & 3072) != 0) {
                i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
            }
            i19 = i17;
            if ((i9 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM2815getSheetMaxWidthD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        i9 &= -458753;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        j7 = jM3051contentColorForek8zF_U;
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    function8 = function7;
                    f6 = fM9687constructorimpl;
                    i21 = i9;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    long j11112 = containerColor;
                    f3 = fM2815getSheetMaxWidthD9Ej5fM;
                    modifier4 = modifier2;
                    shape3 = expandedShape;
                    j8 = j11112;
                } else {
                    if (i29 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM2815getSheetMaxWidthD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        i9 &= -458753;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        j7 = jM3051contentColorForek8zF_U;
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    function8 = function7;
                    f6 = fM9687constructorimpl;
                    i21 = i9;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    long j11113 = containerColor;
                    f3 = fM2815getSheetMaxWidthD9Ej5fM;
                    modifier4 = modifier2;
                    shape3 = expandedShape;
                    j8 = j11113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                final ModalBottomSheetProperties modalBottomSheetProperties15 = modalBottomSheetProperties3;
                finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                int i318 = i20;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                i22 = (i21 & 896) ^ 384;
                final Modifier modifier16 = modifier4;
                if (i22 > 256) {
                    f7 = f3;
                    if ((i21 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                } else {
                    f7 = f3;
                    if ((i21 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChangedInstance116 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                i23 = i21 & 14;
                if (i23 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance116 | z6;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final Function0 function110 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                animatable = (Animatable) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChangedInstance117 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                if (i23 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChangedInstance117;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float f110 = f7;
                final boolean z113 = z2;
                i24 = i21;
                final long j11114 = scrimColor;
                ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties15, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j11114, function110, sheetState3, modalBottomSheetProperties15, animatable, coroutineScope, function0, modifier16, f110, z113, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i318 & 896) | (Animatable.$stable << 9));
                if (!sheetState3.getHasExpandedState()) {
                    composerStartRestartGroup.startReplaceGroup(738111218);
                } else {
                    composerStartRestartGroup.startReplaceGroup(748198866);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i22 <= 256) {
                    }
                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                    } else {
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                sheetState2 = sheetState3;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier16;
                f4 = f110;
                shape2 = shape3;
                j4 = j8;
                j5 = j7;
                function6 = lambda$1121996006$material3;
                function5 = function8;
                j6 = j11114;
                modalBottomSheetProperties2 = modalBottomSheetProperties15;
                z4 = z113;
                f5 = f6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                composer2 = composerStartRestartGroup;
                f4 = f3;
                z4 = z2;
                modifier3 = modifier2;
                sheetState2 = sheetStateRememberModalBottomSheetState;
                shape2 = expandedShape;
                j4 = j;
                j5 = j2;
                f5 = f2;
                j6 = j3;
                function6 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        f3 = f;
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                expandedShape = shape;
                if ((i3 & 32) == 0) {
                    i28 = 65536;
                } else {
                    i28 = 65536;
                }
                i4 |= i28;
            } else {
                expandedShape = shape;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i27 = 524288;
                } else {
                    i27 = 524288;
                }
                i4 |= i27;
            }
            if ((i & 12582912) == 0) {
                int i319 = i4;
                if ((i3 & 128) == 0) {
                    i26 = 4194304;
                } else {
                    i26 = 4194304;
                }
                i9 = i319 | i26;
            } else {
                i9 = i4;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                i9 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i9 |= i11;
            }
            if ((i & 805306368) != 0) {
                if ((i3 & 512) == 0) {
                    i25 = 268435456;
                } else {
                    i25 = 268435456;
                }
                i9 |= i25;
            }
            i12 = i3 & 1024;
            if (i12 != 0) {
                i13 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i14 = 4;
                } else {
                    i14 = 2;
                }
                i13 = i2 | i14;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) != 0) {
                i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
            }
            i15 = i13;
            i16 = i3 & 4096;
            if (i16 != 0) {
                i17 = i15;
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                        i18 = 256;
                    } else {
                        i18 = 128;
                    }
                    i17 |= i18;
                }
                if ((i2 & 3072) != 0) {
                    i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
                }
                i19 = i17;
                if ((i9 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                    if ((i & 1) != 0) {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j11115 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j11115;
                    } else {
                        if (i29 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            i9 &= -897;
                            sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                        }
                        if (i5 != 0) {
                            fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                        } else {
                            fM2815getSheetMaxWidthD9Ej5fM = f3;
                        }
                        if (i7 != 0) {
                            z2 = true;
                        }
                        if ((i3 & 32) != 0) {
                            i9 &= -458753;
                            expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 64) != 0) {
                            containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i9 &= -3670017;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                            i9 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        } else {
                            fM9687constructorimpl = f2;
                        }
                        if ((i3 & 512) != 0) {
                            scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                            i9 &= -1879048193;
                        } else {
                            scrimColor = j3;
                        }
                        if (i12 != 0) {
                            lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                        } else {
                            lambda$1121996006$material3 = function2;
                        }
                        if ((i3 & 2048) != 0) {
                            function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                            i19 &= -113;
                        } else {
                            function7 = function3;
                        }
                        i20 = i19;
                        if (i16 != 0) {
                            modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                            j7 = jM3051contentColorForek8zF_U;
                        } else {
                            j7 = jM3051contentColorForek8zF_U;
                            modalBottomSheetProperties3 = modalBottomSheetProperties;
                        }
                        function8 = function7;
                        f6 = fM9687constructorimpl;
                        i21 = i9;
                        sheetState3 = sheetStateRememberModalBottomSheetState;
                        long j11116 = containerColor;
                        f3 = fM2815getSheetMaxWidthD9Ej5fM;
                        modifier4 = modifier2;
                        shape3 = expandedShape;
                        j8 = j11116;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    final ModalBottomSheetProperties modalBottomSheetProperties16 = modalBottomSheetProperties3;
                    finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    int i3110 = i20;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    i22 = (i21 & 896) ^ 384;
                    final Modifier modifier17 = modifier4;
                    if (i22 > 256) {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        f7 = f3;
                        if ((i21 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance118 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    i23 = i21 & 14;
                    if (i23 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance118 | z6;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final Function0 function111 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    animatable = (Animatable) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChangedInstance119 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                    if (i23 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChangedInstance119;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float f111 = f7;
                    final boolean z114 = z2;
                    i24 = i21;
                    final long j11117 = scrimColor;
                    ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties16, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j11117, function111, sheetState3, modalBottomSheetProperties16, animatable, coroutineScope, function0, modifier17, f111, z114, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i3110 & 896) | (Animatable.$stable << 9));
                    if (!sheetState3.getHasExpandedState()) {
                        composerStartRestartGroup.startReplaceGroup(738111218);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(748198866);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        if (i22 <= 256) {
                        }
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        } else {
                            modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                            composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sheetState2 = sheetState3;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier17;
                    f4 = f111;
                    shape2 = shape3;
                    j4 = j8;
                    j5 = j7;
                    function6 = lambda$1121996006$material3;
                    function5 = function8;
                    j6 = j11117;
                    modalBottomSheetProperties2 = modalBottomSheetProperties16;
                    z4 = z114;
                    f5 = f6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function3;
                    modalBottomSheetProperties2 = modalBottomSheetProperties;
                    composer2 = composerStartRestartGroup;
                    f4 = f3;
                    z4 = z2;
                    modifier3 = modifier2;
                    sheetState2 = sheetStateRememberModalBottomSheetState;
                    shape2 = expandedShape;
                    j4 = j;
                    j5 = j2;
                    f5 = f2;
                    j6 = j3;
                    function6 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i17 = i15 | 384;
            if ((i2 & 3072) != 0) {
                i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
            }
            i19 = i17;
            if ((i9 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM2815getSheetMaxWidthD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        i9 &= -458753;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        j7 = jM3051contentColorForek8zF_U;
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    function8 = function7;
                    f6 = fM9687constructorimpl;
                    i21 = i9;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    long j11118 = containerColor;
                    f3 = fM2815getSheetMaxWidthD9Ej5fM;
                    modifier4 = modifier2;
                    shape3 = expandedShape;
                    j8 = j11118;
                } else {
                    if (i29 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM2815getSheetMaxWidthD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        i9 &= -458753;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        j7 = jM3051contentColorForek8zF_U;
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    function8 = function7;
                    f6 = fM9687constructorimpl;
                    i21 = i9;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    long j11119 = containerColor;
                    f3 = fM2815getSheetMaxWidthD9Ej5fM;
                    modifier4 = modifier2;
                    shape3 = expandedShape;
                    j8 = j11119;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                final ModalBottomSheetProperties modalBottomSheetProperties17 = modalBottomSheetProperties3;
                finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                int i3111 = i20;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                i22 = (i21 & 896) ^ 384;
                final Modifier modifier18 = modifier4;
                if (i22 > 256) {
                    f7 = f3;
                    if ((i21 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                } else {
                    f7 = f3;
                    if ((i21 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChangedInstance1110 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                i23 = i21 & 14;
                if (i23 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance1110 | z6;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final Function0 function112 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                animatable = (Animatable) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChangedInstance1111 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                if (i23 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChangedInstance1111;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float f112 = f7;
                final boolean z115 = z2;
                i24 = i21;
                final long j111110 = scrimColor;
                ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties17, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j111110, function112, sheetState3, modalBottomSheetProperties17, animatable, coroutineScope, function0, modifier18, f112, z115, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i3111 & 896) | (Animatable.$stable << 9));
                if (!sheetState3.getHasExpandedState()) {
                    composerStartRestartGroup.startReplaceGroup(738111218);
                } else {
                    composerStartRestartGroup.startReplaceGroup(748198866);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i22 <= 256) {
                    }
                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                    } else {
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                sheetState2 = sheetState3;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier18;
                f4 = f112;
                shape2 = shape3;
                j4 = j8;
                j5 = j7;
                function6 = lambda$1121996006$material3;
                function5 = function8;
                j6 = j111110;
                modalBottomSheetProperties2 = modalBottomSheetProperties17;
                z4 = z115;
                f5 = f6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                composer2 = composerStartRestartGroup;
                f4 = f3;
                z4 = z2;
                modifier3 = modifier2;
                sheetState2 = sheetStateRememberModalBottomSheetState;
                shape2 = expandedShape;
                j4 = j;
                j5 = j2;
                f5 = f2;
                j6 = j3;
                function6 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        z2 = z;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            expandedShape = shape;
            if ((i3 & 32) == 0) {
                i28 = 65536;
            } else {
                i28 = 65536;
            }
            i4 |= i28;
        } else {
            expandedShape = shape;
        }
        if ((i & 1572864) != 0) {
            if ((i3 & 64) == 0) {
                i27 = 524288;
            } else {
                i27 = 524288;
            }
            i4 |= i27;
        }
        if ((i & 12582912) == 0) {
            int i3112 = i4;
            if ((i3 & 128) == 0) {
                i26 = 4194304;
            } else {
                i26 = 4194304;
            }
            i9 = i3112 | i26;
        } else {
            i9 = i4;
        }
        i10 = i3 & 256;
        if (i10 != 0) {
            i9 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(f2)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i9 |= i11;
        }
        if ((i & 805306368) != 0) {
            if ((i3 & 512) == 0) {
                i25 = 268435456;
            } else {
                i25 = 268435456;
            }
            i9 |= i25;
        }
        i12 = i3 & 1024;
        if (i12 != 0) {
            i13 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i13 = i2 | i14;
        } else {
            i13 = i2;
        }
        if ((i2 & 48) != 0) {
            i13 |= ((i3 & 2048) == 0 || !composerStartRestartGroup.changedInstance(function3)) ? 16 : 32;
        }
        i15 = i13;
        i16 = i3 & 4096;
        if (i16 != 0) {
            i17 = i15;
            if ((i2 & 384) == 0) {
                if (composerStartRestartGroup.changed(modalBottomSheetProperties)) {
                    i18 = 256;
                } else {
                    i18 = 128;
                }
                i17 |= i18;
            }
            if ((i2 & 3072) != 0) {
                i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
            }
            i19 = i17;
            if ((i9 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
                if ((i & 1) != 0) {
                    if (i29 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM2815getSheetMaxWidthD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        i9 &= -458753;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        j7 = jM3051contentColorForek8zF_U;
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    function8 = function7;
                    f6 = fM9687constructorimpl;
                    i21 = i9;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    long j111111 = containerColor;
                    f3 = fM2815getSheetMaxWidthD9Ej5fM;
                    modifier4 = modifier2;
                    shape3 = expandedShape;
                    j8 = j111111;
                } else {
                    if (i29 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i3 & 4) != 0) {
                        i9 &= -897;
                        sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                    }
                    if (i5 != 0) {
                        fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                    } else {
                        fM2815getSheetMaxWidthD9Ej5fM = f3;
                    }
                    if (i7 != 0) {
                        z2 = true;
                    }
                    if ((i3 & 32) != 0) {
                        i9 &= -458753;
                        expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 64) != 0) {
                        containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i9 &= -3670017;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                        i9 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f2;
                    }
                    if ((i3 & 512) != 0) {
                        scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        i9 &= -1879048193;
                    } else {
                        scrimColor = j3;
                    }
                    if (i12 != 0) {
                        lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                    } else {
                        lambda$1121996006$material3 = function2;
                    }
                    if ((i3 & 2048) != 0) {
                        function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                        i19 &= -113;
                    } else {
                        function7 = function3;
                    }
                    i20 = i19;
                    if (i16 != 0) {
                        modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                        j7 = jM3051contentColorForek8zF_U;
                    } else {
                        j7 = jM3051contentColorForek8zF_U;
                        modalBottomSheetProperties3 = modalBottomSheetProperties;
                    }
                    function8 = function7;
                    f6 = fM9687constructorimpl;
                    i21 = i9;
                    sheetState3 = sheetStateRememberModalBottomSheetState;
                    long j111112 = containerColor;
                    f3 = fM2815getSheetMaxWidthD9Ej5fM;
                    modifier4 = modifier2;
                    shape3 = expandedShape;
                    j8 = j111112;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                final ModalBottomSheetProperties modalBottomSheetProperties18 = modalBottomSheetProperties3;
                finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                int i3113 = i20;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
                i22 = (i21 & 896) ^ 384;
                final Modifier modifier19 = modifier4;
                if (i22 > 256) {
                    f7 = f3;
                    if ((i21 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                } else {
                    f7 = f3;
                    if ((i21 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                coroutineScope = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChangedInstance1112 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                i23 = i21 & 14;
                if (i23 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChangedInstance1112 | z6;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final Function0 function113 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                animatable = (Animatable) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChangedInstance1113 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                if (i23 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChangedInstance1113;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float f113 = f7;
                final boolean z116 = z2;
                i24 = i21;
                final long j111113 = scrimColor;
                ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties18, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j111113, function113, sheetState3, modalBottomSheetProperties18, animatable, coroutineScope, function0, modifier19, f113, z116, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i3113 & 896) | (Animatable.$stable << 9));
                if (!sheetState3.getHasExpandedState()) {
                    composerStartRestartGroup.startReplaceGroup(738111218);
                } else {
                    composerStartRestartGroup.startReplaceGroup(748198866);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i22 <= 256) {
                    }
                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                    } else {
                        modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                sheetState2 = sheetState3;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier19;
                f4 = f113;
                shape2 = shape3;
                j4 = j8;
                j5 = j7;
                function6 = lambda$1121996006$material3;
                function5 = function8;
                j6 = j111113;
                modalBottomSheetProperties2 = modalBottomSheetProperties18;
                z4 = z116;
                f5 = f6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function3;
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                composer2 = composerStartRestartGroup;
                f4 = f3;
                z4 = z2;
                modifier3 = modifier2;
                sheetState2 = sheetStateRememberModalBottomSheetState;
                shape2 = expandedShape;
                j4 = j;
                j5 = j2;
                f5 = f2;
                j6 = j3;
                function6 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i17 = i15 | 384;
        if ((i2 & 3072) != 0) {
            i17 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
        }
        i19 = i17;
        if ((i9 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i9 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "128@6616L31,131@6789L13,132@6852L14,133@6894L31,135@7002L10");
            if ((i & 1) != 0) {
                if (i29 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 4) != 0) {
                    i9 &= -897;
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                }
                if (i5 != 0) {
                    fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                } else {
                    fM2815getSheetMaxWidthD9Ej5fM = f3;
                }
                if (i7 != 0) {
                    z2 = true;
                }
                if ((i3 & 32) != 0) {
                    i9 &= -458753;
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                }
                if ((i3 & 64) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i9 &= -3670017;
                } else {
                    containerColor = j;
                }
                if ((i3 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                    i9 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if (i10 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f2;
                }
                if ((i3 & 512) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i9 &= -1879048193;
                } else {
                    scrimColor = j3;
                }
                if (i12 != 0) {
                    lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                } else {
                    lambda$1121996006$material3 = function2;
                }
                if ((i3 & 2048) != 0) {
                    function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    i19 &= -113;
                } else {
                    function7 = function3;
                }
                i20 = i19;
                if (i16 != 0) {
                    modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    j7 = jM3051contentColorForek8zF_U;
                    modalBottomSheetProperties3 = modalBottomSheetProperties;
                }
                function8 = function7;
                f6 = fM9687constructorimpl;
                i21 = i9;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                long j111114 = containerColor;
                f3 = fM2815getSheetMaxWidthD9Ej5fM;
                modifier4 = modifier2;
                shape3 = expandedShape;
                j8 = j111114;
            } else {
                if (i29 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 4) != 0) {
                    i9 &= -897;
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                }
                if (i5 != 0) {
                    fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                } else {
                    fM2815getSheetMaxWidthD9Ej5fM = f3;
                }
                if (i7 != 0) {
                    z2 = true;
                }
                if ((i3 & 32) != 0) {
                    i9 &= -458753;
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                }
                if ((i3 & 64) != 0) {
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i9 &= -3670017;
                } else {
                    containerColor = j;
                }
                if ((i3 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i9 >> 18) & 14);
                    i9 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if (i10 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f2;
                }
                if ((i3 & 512) != 0) {
                    scrimColor = BottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i9 &= -1879048193;
                } else {
                    scrimColor = j3;
                }
                if (i12 != 0) {
                    lambda$1121996006$material3 = ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3();
                } else {
                    lambda$1121996006$material3 = function2;
                }
                if ((i3 & 2048) != 0) {
                    function7 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    i19 &= -113;
                } else {
                    function7 = function3;
                }
                i20 = i19;
                if (i16 != 0) {
                    modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, null);
                    j7 = jM3051contentColorForek8zF_U;
                } else {
                    j7 = jM3051contentColorForek8zF_U;
                    modalBottomSheetProperties3 = modalBottomSheetProperties;
                }
                function8 = function7;
                f6 = fM9687constructorimpl;
                i21 = i9;
                sheetState3 = sheetStateRememberModalBottomSheetState;
                long j111115 = containerColor;
                f3 = fM2815getSheetMaxWidthD9Ej5fM;
                modifier4 = modifier2;
                shape3 = expandedShape;
                j8 = j111115;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1904798512, i21, i20, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:140)");
            }
            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            final ModalBottomSheetProperties modalBottomSheetProperties19 = modalBottomSheetProperties3;
            finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            int i3114 = i20;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855340894, "CC(remember):ModalBottomSheet.kt#9igjgp");
            i22 = (i21 & 896) ^ 384;
            final Modifier modifier110 = modifier4;
            if (i22 > 256) {
                f7 = f3;
                if ((i21 & 384) != 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
            } else {
                f7 = f3;
                if ((i21 & 384) != 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
            }
            zChangedInstance = z5 | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$0(sheetState3, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855349184, "CC(remember):ModalBottomSheet.kt#9igjgp");
            boolean zChangedInstance1114 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
            i23 = i21 & 14;
            if (i23 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = zChangedInstance1114 | z6;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0(sheetState3, coroutineScope, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final Function0 function114 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855359770, "CC(remember):ModalBottomSheet.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            animatable = (Animatable) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855365844, "CC(remember):ModalBottomSheet.kt#9igjgp");
            boolean zChangedInstance1115 = ((i22 <= 256 && composerStartRestartGroup.changed(sheetState3)) || (i21 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
            if (i23 == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z8 | zChangedInstance1115;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!z9) {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0(sheetState3, coroutineScope, animatable, function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float f114 = f7;
            final boolean z117 = z2;
            i24 = i21;
            final long j111116 = scrimColor;
            ModalBottomSheet_androidKt.m3818ModalBottomSheetDialogsW7UJKQ((Function0) objRememberedValue5, j7, modalBottomSheetProperties19, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5(j111116, function114, sheetState3, modalBottomSheetProperties19, animatable, coroutineScope, function0, modifier110, f114, z117, shape3, j8, j7, f6, lambda$1121996006$material3, function8, function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i24 >> 18) & 112) | 24576 | (i3114 & 896) | (Animatable.$stable << 9));
            if (!sheetState3.getHasExpandedState()) {
                composerStartRestartGroup.startReplaceGroup(738111218);
            } else {
                composerStartRestartGroup.startReplaceGroup(748198866);
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@10203L21,210@10176L48");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 855420581, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i22 <= 256) {
                }
                modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                    composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                } else {
                    modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState3, null);
                    composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(sheetState3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) modalBottomSheetKt$ModalBottomSheet$5$1RememberedValue, composerStartRestartGroup, (i24 >> 6) & 14);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            sheetState2 = sheetState3;
            composer2 = composerStartRestartGroup;
            modifier3 = modifier110;
            f4 = f114;
            shape2 = shape3;
            j4 = j8;
            j5 = j7;
            function6 = lambda$1121996006$material3;
            function5 = function8;
            j6 = j111116;
            modalBottomSheetProperties2 = modalBottomSheetProperties19;
            z4 = z117;
            f5 = f6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function5 = function3;
            modalBottomSheetProperties2 = modalBottomSheetProperties;
            composer2 = composerStartRestartGroup;
            f4 = f3;
            z4 = z2;
            modifier3 = modifier2;
            sheetState2 = sheetStateRememberModalBottomSheetState;
            shape2 = expandedShape;
            j4 = j;
            j5 = j2;
            f5 = f2;
            j6 = j3;
            function6 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7(function0, modifier3, sheetState2, f4, z4, shape2, j4, j5, f5, j6, function6, function5, modalBottomSheetProperties2, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$1$0(SheetState sheetState, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        sheetState.setShowMotionSpec$material3(finiteAnimationSpec);
        sheetState.setHideMotionSpec$material3(finiteAnimationSpec2);
        sheetState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$2$0(final SheetState sheetState, CoroutineScope coroutineScope, final Function0 function0) {
        if (sheetState.getConfirmValueChange$material3().invoke(SheetValue.Hidden).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$animateToDismiss$1$1$1(sheetState, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$2$0$0(sheetState, function0, (Throwable) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$2$0$0(SheetState sheetState, Function0 function0, Throwable th) {
        if (!sheetState.isVisible()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$4$0(SheetState sheetState, CoroutineScope coroutineScope, Animatable animatable, final Function0 function0) {
        if (sheetState.getCurrentValue() != SheetValue.Expanded || !sheetState.getHasPartiallyExpandedState()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$3(sheetState, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$0$0(function0, (Throwable) obj);
                }
            });
        } else {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$1(animatable, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$2(sheetState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$4$0$0(Function0 function0, Throwable th) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$5(long j, Function0 function0, SheetState sheetState, ModalBottomSheetProperties modalBottomSheetProperties, Animatable animatable, CoroutineScope coroutineScope, Function0 function1, Modifier modifier, float f, boolean z, Shape shape, long j2, long j3, float f2, Function2 function2, Function2 function3, Function3 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C183@9315L27,183@9254L868:ModalBottomSheet.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1010026864, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:183)");
            }
            Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null));
            ComposerKt.sourceInformationMarkerStart(composer, -26790293, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$5$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierImePadding, false, (Function1) objRememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 824032423, "C184@9358L242,190@9613L499:ModalBottomSheet.kt#uh7d8r");
            m3813ScrimKTwxG1Y(j, function0, sheetState.getTargetValue() != SheetValue.Hidden, modalBottomSheetProperties.getShouldDismissOnClickOutside(), composer, 0);
            m3812ModalBottomSheetContent7e2Q(boxScopeInstance, animatable, coroutineScope, function1, function0, modifier, sheetState, f, z, shape, j2, j3, f2, function2, function3, function4, composer, 6 | (Animatable.$stable << 3), 0, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$5$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets ModalBottomSheetContent_7___e2Q$lambda$0(Composer composer, int i) {
        composer.startReplaceGroup(1439026310);
        ComposerKt.sourceInformation(composer, "C230@11073L12:ModalBottomSheet.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1439026310, i, -1, "androidx.compose.material3.ModalBottomSheetContent.<anonymous> (ModalBottomSheet.kt:230)");
        }
        WindowInsets windowInsets = BottomSheetDefaults.INSTANCE.getWindowInsets(composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return windowInsets;
    }

    /* JADX WARN: Code duplicated, block: B:233:0x034a  */
    /* JADX WARN: Code duplicated, block: B:236:0x0383  */
    /* JADX WARN: Code duplicated, block: B:239:0x038e  */
    /* JADX WARN: Code duplicated, block: B:243:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:245:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:247:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:253:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:255:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:257:0x0405  */
    /* JADX WARN: Code duplicated, block: B:260:0x0426  */
    /* JADX WARN: Code duplicated, block: B:262:0x042c  */
    /* JADX WARN: Code duplicated, block: B:268:0x0439  */
    /* JADX WARN: Code duplicated, block: B:270:0x0441  */
    /* JADX WARN: Code duplicated, block: B:273:0x045a  */
    /* JADX WARN: Code duplicated, block: B:276:0x0464  */
    /* JADX WARN: Code duplicated, block: B:279:0x0495  */
    /* JADX WARN: Code duplicated, block: B:281:0x049d  */
    /* JADX WARN: Code duplicated, block: B:284:0x04df  */
    /* JADX WARN: Code duplicated, block: B:286:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:292:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:298:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:301:0x0508  */
    /* JADX WARN: Code duplicated, block: B:303:0x0510  */
    /* JADX WARN: Code duplicated, block: B:306:0x057f  */
    /* JADX INFO: renamed from: ModalBottomSheetContent-7---e2Q, reason: not valid java name */
    public static final void m3812ModalBottomSheetContent7e2Q(final BoxScope boxScope, final Animatable<Float, AnimationVector1D> animatable, final CoroutineScope coroutineScope, final Function0<Unit> function0, final Function0<Unit> function1, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function5;
        Modifier modifier2;
        final SheetState sheetStateRememberModalBottomSheetState;
        float fM2815getSheetMaxWidthD9Ej5fM;
        boolean z2;
        int i5;
        int i6;
        long j3;
        int i7;
        int i8;
        final Shape shape2;
        final float f3;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final Modifier modifier3;
        final float f4;
        final boolean z3;
        final SheetState sheetState2;
        Composer composer2;
        final long j4;
        final long j5;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function7;
        Shape expandedShape;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        Function2<? super Composer, ? super Integer, Unit> lambda$2132285819$material3;
        long j6;
        float f5;
        int i9;
        int i10;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> function8;
        Shape shape3;
        Modifier modifier4;
        long j7;
        AnchoredDraggableState<SheetValue> anchoredDraggableState;
        boolean z4;
        Object objRememberedValue;
        boolean zChanged;
        Object objRememberedValue2;
        long j8;
        ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1 modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1;
        Modifier.Companion companionNestedScroll$default;
        boolean z5;
        Object objRememberedValue3;
        boolean z6;
        boolean zChanged2;
        Object objRememberedValue4;
        boolean z7;
        boolean z8;
        Object objRememberedValue5;
        boolean z9;
        Object objRememberedValue6;
        Composer composerStartRestartGroup = composer.startRestartGroup(377926385);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheetContent)N(predictiveBackProgress,scope,onDismissRequest,animateToDismiss,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,sheetGesturesEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,dragHandle,contentWindowInsets,content)233@11173L48,237@11401L48,235@11297L217,241@11563L601,275@13048L1645,315@15050L112,320@15295L612,340@16472L3585,256@12170L7887:ModalBottomSheet.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= (i & 64) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(coroutineScope) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        int i11 = 8192;
        if ((i & 24576) == 0) {
            function5 = function1;
            i4 |= composerStartRestartGroup.changedInstance(function5) ? 16384 : 8192;
        } else {
            function5 = function1;
        }
        int i12 = i3 & 16;
        if (i12 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
        }
        if ((i & 1572864) == 0) {
            sheetStateRememberModalBottomSheetState = sheetState;
            i4 |= ((i3 & 32) == 0 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) ? 1048576 : 524288;
        } else {
            sheetStateRememberModalBottomSheetState = sheetState;
        }
        int i13 = i3 & 64;
        if (i13 != 0) {
            i4 |= 12582912;
            fM2815getSheetMaxWidthD9Ej5fM = f;
        } else {
            fM2815getSheetMaxWidthD9Ej5fM = f;
            if ((i & 12582912) == 0) {
                i4 |= composerStartRestartGroup.changed(fM2815getSheetMaxWidthD9Ej5fM) ? 8388608 : 4194304;
            }
        }
        int i14 = i3 & 128;
        if (i14 != 0) {
            i4 |= 100663296;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 100663296) == 0) {
                i4 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
            }
        }
        if ((i & 805306368) == 0) {
            i4 |= ((i3 & 256) == 0 && composerStartRestartGroup.changed(shape)) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            if ((i3 & 512) == 0) {
                i5 = i14;
                int i15 = composerStartRestartGroup.changed(j) ? 4 : 2;
                i6 = i2 | i15;
            } else {
                i5 = i14;
            }
            i6 = i2 | i15;
        } else {
            i5 = i14;
            i6 = i2;
        }
        if ((i2 & 48) == 0) {
            j3 = j2;
            i6 |= ((i3 & 1024) == 0 && composerStartRestartGroup.changed(j3)) ? 32 : 16;
        } else {
            j3 = j2;
        }
        int i16 = i6;
        int i17 = i3 & 2048;
        if (i17 != 0) {
            i7 = i16 | 384;
        } else if ((i2 & 384) == 0) {
            i7 = i16 | (composerStartRestartGroup.changed(f2) ? 256 : 128);
        } else {
            i7 = i16;
        }
        int i18 = i3 & 4096;
        if (i18 != 0) {
            i8 = i7 | 3072;
        } else {
            int i19 = i7;
            if ((i2 & 3072) == 0) {
                i8 = i19 | (composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024);
            } else {
                i8 = i19;
            }
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 8192) == 0 && composerStartRestartGroup.changedInstance(function3)) {
                i11 = 16384;
            }
            i8 |= i11;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i8 & 74899) == 74898) ? false : true, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "222@10544L31,225@10717L13,226@10780L14,227@10822L31");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 32) != 0) {
                    i4 &= -3670017;
                }
                if ((i3 & 256) != 0) {
                    i4 &= -1879048193;
                }
                if ((i3 & 512) != 0) {
                    i8 &= -15;
                }
                if ((i3 & 1024) != 0) {
                    i8 &= -113;
                }
                if ((i3 & 8192) != 0) {
                    i8 &= -57345;
                }
                lambda$2132285819$material3 = function2;
                modifier4 = modifier2;
                f5 = fM2815getSheetMaxWidthD9Ej5fM;
                i9 = i8;
                i10 = i4;
                function8 = function3;
                j7 = j3;
                shape3 = shape;
                j6 = j;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i3 & 32) != 0) {
                    i4 &= -3670017;
                    sheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(false, null, composerStartRestartGroup, 0, 3);
                }
                if (i13 != 0) {
                    fM2815getSheetMaxWidthD9Ej5fM = BottomSheetDefaults.INSTANCE.m2815getSheetMaxWidthD9Ej5fM();
                }
                if (i5 != 0) {
                    z2 = true;
                }
                if ((i3 & 256) != 0) {
                    expandedShape = BottomSheetDefaults.INSTANCE.getExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -1879048193;
                } else {
                    expandedShape = shape;
                }
                if ((i3 & 512) != 0) {
                    i8 &= -15;
                    containerColor = BottomSheetDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                } else {
                    containerColor = j;
                }
                if ((i3 & 1024) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, i8 & 14);
                    i8 &= -113;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                float fM2813getElevationD9Ej5fM = i17 != 0 ? BottomSheetDefaults.INSTANCE.m2813getElevationD9Ej5fM() : f2;
                lambda$2132285819$material3 = i18 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$2132285819$material3() : function2;
                if ((i3 & 8192) != 0) {
                    f2 = fM2813getElevationD9Ej5fM;
                    j6 = containerColor;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    i9 = i8 & (-57345);
                    shape3 = expandedShape;
                    function8 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$0((Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    modifier4 = modifier2;
                    j7 = jM3051contentColorForek8zF_U;
                    i10 = i4;
                } else {
                    f2 = fM2813getElevationD9Ej5fM;
                    j6 = containerColor;
                    f5 = fM2815getSheetMaxWidthD9Ej5fM;
                    i9 = i8;
                    i10 = i4;
                    function8 = function3;
                    shape3 = expandedShape;
                    modifier4 = modifier2;
                    j7 = jM3051contentColorForek8zF_U;
                }
            }
            composerStartRestartGroup.endDefaults();
            Shape shape4 = shape3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(377926385, i10, i9, "androidx.compose.material3.ModalBottomSheetContent (ModalBottomSheet.kt:232)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_pane_title), composerStartRestartGroup, 0);
            AnchoredDraggableDefaults anchoredDraggableDefaults = AnchoredDraggableDefaults.INSTANCE;
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
            int i20 = i9;
            int i21 = i10;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884928287, "CC(remember):ModalBottomSheet.kt#9igjgp");
            int i22 = (i21 & 3670016) ^ 1572864;
            if (i22 <= 1048576 || !composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) {
                anchoredDraggableState = anchoredDraggableState$material3;
                if ((i21 & 1572864) != 1048576) {
                    z4 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Float.valueOf(ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$1$0(sheetStateRememberModalBottomSheetState, ((Float) obj).floatValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                TargetedFlingBehavior targetedFlingBehaviorFlingBehavior = anchoredDraggableDefaults.flingBehavior(anchoredDraggableState, (Function1) objRememberedValue, SheetDefaultsKt.getBottomSheetAnimationSpec(), composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884922550, "CC(remember):ModalBottomSheet.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(targetedFlingBehaviorFlingBehavior);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    j8 = j7;
                } else {
                    j8 = j7;
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1 = (ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier5 = modifier4;
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m1273widthInVpY3zN4$default(boxScope.align(modifier4, Alignment.INSTANCE.getTopCenter()), 0.0f, f5, 1, null), 0.0f, 1, null);
                    if (z2) {
                        composerStartRestartGroup.startReplaceGroup(-1884894530);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "265@12485L393");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884893254, "CC(remember):ModalBottomSheet.kt#9igjgp");
                        z9 = (i22 <= 1048576 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i21 & 1572864) == 1048576;
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!z9 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetStateRememberModalBottomSheetState, Orientation.Vertical, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) objRememberedValue6, null, 2, null);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1884879399);
                        composerStartRestartGroup.endReplaceGroup();
                        companionNestedScroll$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen = modifierFillMaxWidth$default.then(companionNestedScroll$default);
                    AnchoredDraggableState<SheetValue> anchoredDraggableState$material4 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
                    Orientation orientation = Orientation.Vertical;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884873986, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    z5 = (i22 <= 1048576 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i21 & 1572864) == 1048576;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda26
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$4$0(sheetStateRememberModalBottomSheetState, (IntSize) obj, (Constraints) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDraggableAnchors = DraggableAnchorsKt.draggableAnchors(modifierThen, anchoredDraggableState$material4, orientation, (Function2) objRememberedValue3);
                    AnchoredDraggableState<SheetValue> anchoredDraggableState$material5 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
                    Orientation orientation2 = Orientation.Vertical;
                    if (z2 || sheetStateRememberModalBottomSheetState.getCurrentValue() == SheetValue.Hidden) {
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                    Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modifierDraggableAnchors, anchoredDraggableState$material5, orientation2, z6, null, null, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1, 24, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884811455, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$5$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable$default, false, (Function1) objRememberedValue4, 1, null), WindowInsetsKt.WindowInsets$default(0, RangesKt.coerceAtLeast((int) sheetStateRememberModalBottomSheetState.getOffset$material3(), 0), 0, 0, 13, null));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884803115, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean z10 = (i22 <= 1048576 && composerStartRestartGroup.changed(sheetStateRememberModalBottomSheetState)) || (i21 & 1572864) == 1048576;
                    if ((i21 & 112) != 32 || ((i21 & 64) != 0 && composerStartRestartGroup.changedInstance(animatable))) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z10 | z7;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!z8 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$6$0(sheetStateRememberModalBottomSheetState, animatable, (GraphicsLayerScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final boolean z11 = z2;
                    final SheetState sheetState3 = sheetStateRememberModalBottomSheetState;
                    final Function0<Unit> function9 = function5;
                    final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function10 = function8;
                    final Function2<? super Composer, ? super Integer, Unit> function11 = lambda$2132285819$material3;
                    int i23 = i20 << 6;
                    float f6 = f2;
                    long j9 = j8;
                    SurfaceKt.m4323SurfaceT9BRK9s(BottomSheetScaffoldKt.verticalScaleUp(GraphicsLayerModifierKt.graphicsLayer(modifierConsumeWindowInsets, (Function1) objRememberedValue5), sheetStateRememberModalBottomSheetState), shape4, j6, j9, f6, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1144070092, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7(function10, animatable, sheetState3, function11, function9, coroutineScope, z11, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i21 >> 24) & 112) | 12582912 | (i23 & 896) | (i23 & 7168) | (i23 & 57344), 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    sheetState2 = sheetState3;
                    z3 = z11;
                    function6 = function11;
                    shape2 = shape4;
                    f3 = f6;
                    composer2 = composerStartRestartGroup;
                    f4 = f5;
                    function7 = function10;
                    j5 = j9;
                    j4 = j6;
                    modifier3 = modifier5;
                }
                objRememberedValue2 = new ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1(targetedFlingBehaviorFlingBehavior, sheetStateRememberModalBottomSheetState, function0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1 = (ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier6 = modifier4;
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(SizeKt.m1273widthInVpY3zN4$default(boxScope.align(modifier4, Alignment.INSTANCE.getTopCenter()), 0.0f, f5, 1, null), 0.0f, 1, null);
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(-1884894530);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "265@12485L393");
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884893254, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i22 <= 1048576) {
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue6 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetStateRememberModalBottomSheetState, Orientation.Vertical, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetStateRememberModalBottomSheetState, Orientation.Vertical, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion3, (NestedScrollConnection) objRememberedValue6, null, 2, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1884879399);
                    composerStartRestartGroup.endReplaceGroup();
                    companionNestedScroll$default = Modifier.INSTANCE;
                }
                Modifier modifierThen2 = modifierFillMaxWidth$default2.then(companionNestedScroll$default);
                AnchoredDraggableState<SheetValue> anchoredDraggableState$material6 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
                Orientation orientation3 = Orientation.Vertical;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884873986, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i22 <= 1048576) {
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue3 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$4$0(sheetStateRememberModalBottomSheetState, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$4$0(sheetStateRememberModalBottomSheetState, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDraggableAnchors2 = DraggableAnchorsKt.draggableAnchors(modifierThen2, anchoredDraggableState$material6, orientation3, (Function2) objRememberedValue3);
                AnchoredDraggableState<SheetValue> anchoredDraggableState$material7 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
                Orientation orientation4 = Orientation.Vertical;
                if (z2) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                Modifier modifierAnchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modifierDraggableAnchors2, anchoredDraggableState$material7, orientation4, z6, null, null, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1, 24, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884811455, "CC(remember):ModalBottomSheet.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$5$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$5$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierConsumeWindowInsets2 = WindowInsetsPaddingKt.consumeWindowInsets(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable$default2, false, (Function1) objRememberedValue4, 1, null), WindowInsetsKt.WindowInsets$default(0, RangesKt.coerceAtLeast((int) sheetStateRememberModalBottomSheetState.getOffset$material3(), 0), 0, 0, 13, null));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884803115, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i22 <= 1048576) {
                }
                if ((i21 & 112) != 32) {
                    z7 = true;
                } else {
                    z7 = true;
                }
                z8 = z10 | z7;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$6$0(sheetStateRememberModalBottomSheetState, animatable, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$6$0(sheetStateRememberModalBottomSheetState, animatable, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final boolean z12 = z2;
                final SheetState sheetState4 = sheetStateRememberModalBottomSheetState;
                final Function0 function12 = function5;
                final Function2 function13 = function8;
                final Function2 function14 = lambda$2132285819$material3;
                int i24 = i20 << 6;
                float f7 = f2;
                long j10 = j8;
                SurfaceKt.m4323SurfaceT9BRK9s(BottomSheetScaffoldKt.verticalScaleUp(GraphicsLayerModifierKt.graphicsLayer(modifierConsumeWindowInsets2, (Function1) objRememberedValue5), sheetStateRememberModalBottomSheetState), shape4, j6, j10, f7, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1144070092, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7(function13, animatable, sheetState4, function14, function12, coroutineScope, z12, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i21 >> 24) & 112) | 12582912 | (i24 & 896) | (i24 & 7168) | (i24 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                sheetState2 = sheetState4;
                z3 = z12;
                function6 = function14;
                shape2 = shape4;
                f3 = f7;
                composer2 = composerStartRestartGroup;
                f4 = f5;
                function7 = function13;
                j5 = j10;
                j4 = j6;
                modifier3 = modifier6;
            } else {
                anchoredDraggableState = anchoredDraggableState$material3;
            }
            z4 = true;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Float.valueOf(ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$1$0(sheetStateRememberModalBottomSheetState, ((Float) obj).floatValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Float.valueOf(ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$1$0(sheetStateRememberModalBottomSheetState, ((Float) obj).floatValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TargetedFlingBehavior targetedFlingBehaviorFlingBehavior2 = anchoredDraggableDefaults.flingBehavior(anchoredDraggableState, (Function1) objRememberedValue, SheetDefaultsKt.getBottomSheetAnimationSpec(), composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884922550, "CC(remember):ModalBottomSheet.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(targetedFlingBehaviorFlingBehavior2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                j8 = j7;
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1 = (ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier7 = modifier4;
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(SizeKt.m1273widthInVpY3zN4$default(boxScope.align(modifier4, Alignment.INSTANCE.getTopCenter()), 0.0f, f5, 1, null), 0.0f, 1, null);
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(-1884894530);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "265@12485L393");
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884893254, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    if (i22 <= 1048576) {
                    }
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        objRememberedValue6 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetStateRememberModalBottomSheetState, Orientation.Vertical, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetStateRememberModalBottomSheetState, Orientation.Vertical, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion4, (NestedScrollConnection) objRememberedValue6, null, 2, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1884879399);
                    composerStartRestartGroup.endReplaceGroup();
                    companionNestedScroll$default = Modifier.INSTANCE;
                }
                Modifier modifierThen3 = modifierFillMaxWidth$default3.then(companionNestedScroll$default);
                AnchoredDraggableState<SheetValue> anchoredDraggableState$material8 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
                Orientation orientation5 = Orientation.Vertical;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884873986, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i22 <= 1048576) {
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue3 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$4$0(sheetStateRememberModalBottomSheetState, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$4$0(sheetStateRememberModalBottomSheetState, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDraggableAnchors3 = DraggableAnchorsKt.draggableAnchors(modifierThen3, anchoredDraggableState$material8, orientation5, (Function2) objRememberedValue3);
                AnchoredDraggableState<SheetValue> anchoredDraggableState$material9 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
                Orientation orientation6 = Orientation.Vertical;
                if (z2) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                Modifier modifierAnchoredDraggable$default3 = AnchoredDraggableKt.anchoredDraggable$default(modifierDraggableAnchors3, anchoredDraggableState$material9, orientation6, z6, null, null, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1, 24, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884811455, "CC(remember):ModalBottomSheet.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$5$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$5$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierConsumeWindowInsets3 = WindowInsetsPaddingKt.consumeWindowInsets(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable$default3, false, (Function1) objRememberedValue4, 1, null), WindowInsetsKt.WindowInsets$default(0, RangesKt.coerceAtLeast((int) sheetStateRememberModalBottomSheetState.getOffset$material3(), 0), 0, 0, 13, null));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884803115, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i22 <= 1048576) {
                }
                if ((i21 & 112) != 32) {
                    z7 = true;
                } else {
                    z7 = true;
                }
                z8 = z10 | z7;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$6$0(sheetStateRememberModalBottomSheetState, animatable, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$6$0(sheetStateRememberModalBottomSheetState, animatable, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final boolean z13 = z2;
                final SheetState sheetState5 = sheetStateRememberModalBottomSheetState;
                final Function0 function15 = function5;
                final Function2 function16 = function8;
                final Function2 function17 = lambda$2132285819$material3;
                int i25 = i20 << 6;
                float f8 = f2;
                long j11 = j8;
                SurfaceKt.m4323SurfaceT9BRK9s(BottomSheetScaffoldKt.verticalScaleUp(GraphicsLayerModifierKt.graphicsLayer(modifierConsumeWindowInsets3, (Function1) objRememberedValue5), sheetStateRememberModalBottomSheetState), shape4, j6, j11, f8, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1144070092, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7(function16, animatable, sheetState5, function17, function15, coroutineScope, z13, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i21 >> 24) & 112) | 12582912 | (i25 & 896) | (i25 & 7168) | (i25 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                sheetState2 = sheetState5;
                z3 = z13;
                function6 = function17;
                shape2 = shape4;
                f3 = f8;
                composer2 = composerStartRestartGroup;
                f4 = f5;
                function7 = function16;
                j5 = j11;
                j4 = j6;
                modifier3 = modifier7;
            } else {
                j8 = j7;
            }
            objRememberedValue2 = new ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1(targetedFlingBehaviorFlingBehavior2, sheetStateRememberModalBottomSheetState, function0);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1 = (ModalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier8 = modifier4;
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(SizeKt.m1273widthInVpY3zN4$default(boxScope.align(modifier4, Alignment.INSTANCE.getTopCenter()), 0.0f, f5, 1, null), 0.0f, 1, null);
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(-1884894530);
                ComposerKt.sourceInformation(composerStartRestartGroup, "265@12485L393");
                Modifier.Companion companion5 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884893254, "CC(remember):ModalBottomSheet.kt#9igjgp");
                if (i22 <= 1048576) {
                }
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    objRememberedValue6 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetStateRememberModalBottomSheetState, Orientation.Vertical, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetStateRememberModalBottomSheetState, Orientation.Vertical, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion5, (NestedScrollConnection) objRememberedValue6, null, 2, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1884879399);
                composerStartRestartGroup.endReplaceGroup();
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            Modifier modifierThen4 = modifierFillMaxWidth$default4.then(companionNestedScroll$default);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material10 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
            Orientation orientation7 = Orientation.Vertical;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884873986, "CC(remember):ModalBottomSheet.kt#9igjgp");
            if (i22 <= 1048576) {
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue3 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$4$0(sheetStateRememberModalBottomSheetState, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$4$0(sheetStateRememberModalBottomSheetState, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDraggableAnchors4 = DraggableAnchorsKt.draggableAnchors(modifierThen4, anchoredDraggableState$material10, orientation7, (Function2) objRememberedValue3);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material11 = sheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material3();
            Orientation orientation8 = Orientation.Vertical;
            if (z2) {
                z6 = false;
            } else {
                z6 = false;
            }
            Modifier modifierAnchoredDraggable$default4 = AnchoredDraggableKt.anchoredDraggable$default(modifierDraggableAnchors4, anchoredDraggableState$material11, orientation8, z6, null, null, modalBottomSheetKt$ModalBottomSheetContent$modalBottomSheetFlingBehavior$1$1, 24, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884811455, "CC(remember):ModalBottomSheet.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$5$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$5$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierConsumeWindowInsets4 = WindowInsetsPaddingKt.consumeWindowInsets(SemanticsModifierKt.semantics$default(modifierAnchoredDraggable$default4, false, (Function1) objRememberedValue4, 1, null), WindowInsetsKt.WindowInsets$default(0, RangesKt.coerceAtLeast((int) sheetStateRememberModalBottomSheetState.getOffset$material3(), 0), 0, 0, 13, null));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1884803115, "CC(remember):ModalBottomSheet.kt#9igjgp");
            if (i22 <= 1048576) {
            }
            if ((i21 & 112) != 32) {
                z7 = true;
            } else {
                z7 = true;
            }
            z8 = z10 | z7;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!z8) {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$6$0(sheetStateRememberModalBottomSheetState, animatable, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$6$0(sheetStateRememberModalBottomSheetState, animatable, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean z14 = z2;
            final SheetState sheetState6 = sheetStateRememberModalBottomSheetState;
            final Function0 function18 = function5;
            final Function2 function19 = function8;
            final Function2 function110 = lambda$2132285819$material3;
            int i26 = i20 << 6;
            float f9 = f2;
            long j12 = j8;
            SurfaceKt.m4323SurfaceT9BRK9s(BottomSheetScaffoldKt.verticalScaleUp(GraphicsLayerModifierKt.graphicsLayer(modifierConsumeWindowInsets4, (Function1) objRememberedValue5), sheetStateRememberModalBottomSheetState), shape4, j6, j12, f9, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1144070092, true, new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7(function19, animatable, sheetState6, function110, function18, coroutineScope, z14, function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i21 >> 24) & 112) | 12582912 | (i26 & 896) | (i26 & 7168) | (i26 & 57344), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            sheetState2 = sheetState6;
            z3 = z14;
            function6 = function110;
            shape2 = shape4;
            f3 = f9;
            composer2 = composerStartRestartGroup;
            f4 = f5;
            function7 = function19;
            j5 = j12;
            j4 = j6;
            modifier3 = modifier8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            shape2 = shape;
            f3 = f2;
            function6 = function2;
            modifier3 = modifier2;
            f4 = fM2815getSheetMaxWidthD9Ej5fM;
            z3 = z2;
            sheetState2 = sheetStateRememberModalBottomSheetState;
            composer2 = composerStartRestartGroup;
            j4 = j;
            j5 = j2;
            function7 = function3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$8(boxScope, animatable, coroutineScope, function0, function1, modifier3, sheetState2, f4, z3, shape2, j4, j5, f3, function6, function7, function4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalBottomSheetContent_7___e2Q$lambda$1$0(SheetState sheetState, float f) {
        return sheetState.getPositionalThreshold$material3().invoke().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair ModalBottomSheetContent_7___e2Q$lambda$4$0(final SheetState sheetState, final IntSize intSize, Constraints constraints) {
        SheetValue sheetValue;
        final float fM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(constraints.getValue());
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$4$0$0(fM9639getMaxHeightimpl, intSize, sheetState, (DraggableAnchorsConfig) obj);
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[sheetState.getAnchoredDraggableState$material3().getTargetValue().ordinal()];
        if (i == 1) {
            sheetValue = SheetValue.Hidden;
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sheetValue = DraggableAnchors.hasPositionFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
        } else if (DraggableAnchors.hasPositionFor(SheetValue.PartiallyExpanded)) {
            sheetValue = SheetValue.PartiallyExpanded;
        } else {
            sheetValue = DraggableAnchors.hasPositionFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
        }
        return TuplesKt.to(DraggableAnchors, sheetValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$4$0$0(float f, IntSize intSize, SheetState sheetState, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(SheetValue.Hidden, f);
        if (((int) (intSize.m9862unboximpl() & 4294967295L)) > f / 2 && !sheetState.getSkipPartiallyExpanded()) {
            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, f / 2.0f);
        }
        if (((int) (intSize.m9862unboximpl() & 4294967295L)) != 0) {
            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(0.0f, f - ((int) (intSize.m9862unboximpl() & 4294967295L))));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$5$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 0.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$6$0(SheetState sheetState, Animatable animatable, GraphicsLayerScope graphicsLayerScope) {
        float offset = sheetState.getAnchoredDraggableState$material3().getOffset();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L));
        if (!Float.isNaN(offset) && !Float.isNaN(fIntBitsToFloat) && fIntBitsToFloat != 0.0f) {
            float fFloatValue = ((Number) animatable.getValue()).floatValue();
            graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue));
            graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue));
            graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, (offset + fIntBitsToFloat) / fIntBitsToFloat));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$7(Function2 function2, final Animatable animatable, final SheetState sheetState, Function2 function3, final Function0 function0, final CoroutineScope coroutineScope, final boolean z, Function3 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C343@16563L21,344@16617L586,341@16482L3569:ModalBottomSheet.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1144070092, i, -1, "androidx.compose.material3.ModalBottomSheetContent.<anonymous> (ModalBottomSheet.kt:341)");
            }
            Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), (WindowInsets) function2.invoke(composer, 0));
            ComposerKt.sourceInformationMarkerStart(composer, -60264138, "CC(remember):ModalBottomSheet.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(animatable);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7$0$0(animatable, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierVerticalScaleDown = BottomSheetScaffoldKt.verticalScaleDown(GraphicsLayerModifierKt.graphicsLayer(modifierWindowInsetsPadding, (Function1) objRememberedValue), sheetState);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScaleDown);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 553315907, "C403@20032L9:ModalBottomSheet.kt#uh7d8r");
            if (function3 == null) {
                composer.startReplaceGroup(535873260);
            } else {
                composer.startReplaceGroup(553338288);
                ComposerKt.sourceInformation(composer, "361@17571L54,362@17667L48,363@17756L47,366@17917L370,373@18352L1592,364@17820L2185");
                Strings.Companion companion = Strings.INSTANCE;
                final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer, 0);
                Strings.Companion companion2 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer, 0);
                Strings.Companion companion3 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo3 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer, 0);
                Modifier.Companion companion4 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -120687352, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChanged = composer.changed(sheetState) | composer.changed(function0) | composer.changedInstance(coroutineScope);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7$1$0$0(sheetState, function0, coroutineScope);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierM630clickableXHw0xAI$default = ClickableKt.m630clickableXHw0xAI$default(companion4, false, null, null, (Function0) objRememberedValue2, 7, null);
                ComposerKt.sourceInformationMarkerStart(composer, -120672210, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChanged2 = composer.changed(z) | composer.changed(sheetState) | composer.changed(strM5086getString2EP1pXo2) | composer.changed(function0) | composer.changed(strM5086getString2EP1pXo3) | composer.changedInstance(coroutineScope) | composer.changed(strM5086getString2EP1pXo);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    Object obj = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7$1$1$0(z, sheetState, strM5086getString2EP1pXo2, strM5086getString2EP1pXo3, strM5086getString2EP1pXo, function0, coroutineScope, (SemanticsPropertyReceiver) obj2);
                        }
                    };
                    composer.updateRememberedValue(obj);
                    objRememberedValue3 = obj;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SheetDefaultsKt.DragHandleWithTooltip(SemanticsModifierKt.semantics(modifierM630clickableXHw0xAI$default, true, (Function1) objRememberedValue3), function3, composer, 0);
            }
            composer.endReplaceGroup();
            function4.invoke(columnScopeInstance, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$7$0$0(Animatable animatable, GraphicsLayerScope graphicsLayerScope) {
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        float fCalculatePredictiveBackScaleX = calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue);
        float fCalculatePredictiveBackScaleY = calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue);
        graphicsLayerScope.setScaleY(fCalculatePredictiveBackScaleY == 0.0f ? 1.0f : fCalculatePredictiveBackScaleX / fCalculatePredictiveBackScaleY);
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(PredictiveBackChildTransformOrigin);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$7$1$0$0(SheetState sheetState, Function0 function0, CoroutineScope coroutineScope) {
        int i = WhenMappings.$EnumSwitchMapping$0[sheetState.getCurrentValue().ordinal()];
        if (i == 2) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheetContent$6$2$1$1$1(sheetState, null), 3, null);
        } else if (i != 3) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheetContent$6$2$1$1$2(sheetState, null), 3, null);
        } else {
            function0.invoke();
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$7$1$1$0(boolean z, final SheetState sheetState, String str, String str2, String str3, final Function0 function0, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (z) {
            SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str, new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7$1$1$0$0$0(function0));
                }
            });
            if (sheetState.getCurrentValue() == SheetValue.PartiallyExpanded) {
                SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str2, new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7$1$1$0$0$1(sheetState, coroutineScope, sheetState));
                    }
                });
            } else if (sheetState.getHasPartiallyExpandedState()) {
                SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str3, new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$7$1$1$0$0$2(sheetState, coroutineScope));
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalBottomSheetContent_7___e2Q$lambda$7$1$1$0$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalBottomSheetContent_7___e2Q$lambda$7$1$1$0$0$1(SheetState sheetState, CoroutineScope coroutineScope, SheetState sheetState2) {
        if (!sheetState.getConfirmValueChange$material3().invoke(SheetValue.Expanded).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheetContent$6$2$2$1$1$2$1(sheetState2, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalBottomSheetContent_7___e2Q$lambda$7$1$1$0$0$2(SheetState sheetState, CoroutineScope coroutineScope) {
        if (!sheetState.getConfirmValueChange$material3().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheetContent$6$2$2$1$1$3$1(sheetState, null), 3, null);
        return true;
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo754toPx0680j_4(PredictiveBackMaxScaleXDistance), fIntBitsToFloat), f) / fIntBitsToFloat);
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo754toPx0680j_4(PredictiveBackMaxScaleYDistance), fIntBitsToFloat), f) / fIntBitsToFloat);
    }

    public static final SheetState rememberModalBottomSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -778250030, "C(rememberModalBottomSheetState)N(skipPartiallyExpanded,confirmValueChange)465@22167L8,467@22185L160:ModalBottomSheet.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -573965190, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ModalBottomSheetKt.rememberModalBottomSheetState$lambda$0$0((SheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function1<? super SheetValue, Boolean> function2 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-778250030, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:467)");
        }
        SheetState sheetStateM4161rememberSheetStateAGcomas = SheetDefaultsKt.m4161rememberSheetStateAGcomas(z2, function2, SheetValue.Hidden, false, 0.0f, 0.0f, composer, (i & 14) | 384 | (i & 112), 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sheetStateM4161rememberSheetStateAGcomas;
    }

    /* JADX INFO: renamed from: Scrim-KTwxG1Y, reason: not valid java name */
    private static final void m3813ScrimKTwxG1Y(final long j, final Function0<Unit> function0, final boolean z, final boolean z2, Composer composer, final int i) {
        int i2;
        int i3;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-391613911);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(color:c#ui.graphics.Color,onDismissRequest,visible,dismissEnabled):ModalBottomSheet.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-391613911, i2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:479)");
            }
            if (j != 16) {
                composerStartRestartGroup.startReplaceGroup(-1438602166);
                ComposerKt.sourceInformation(composerStartRestartGroup, "485@22764L7,483@22619L167,487@22812L29,502@23442L79,502@23392L129");
                int i4 = i2;
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                Strings.Companion companion = Strings.INSTANCE;
                final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.close_sheet), composerStartRestartGroup, 0);
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(-1438303419);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "490@22959L44,491@23060L263");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616172565, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    int i5 = i4 & 112;
                    boolean z3 = i5 == 32;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (PointerInputEventHandler) new ModalBottomSheetKt$Scrim$dismissSheet$1$1(function0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (PointerInputEventHandler) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616176016, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | (i5 == 32);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$2$0(strM5086getString2EP1pXo, function0, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 = 1;
                    companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i3 = 1;
                    composerStartRestartGroup.startReplaceGroup(-1437877231);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, i3, null).then(companionSemantics);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616188056, "CC(remember):ModalBottomSheet.kt#9igjgp");
                int i6 = (composerStartRestartGroup.changed(stateAnimateFloatAsState) ? 1 : 0) | ((i4 & 14) == 4 ? i3 : 0);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (i6 != 0 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$3$0(j, stateAnimateFloatAsState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1461035719);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$4(j, function0, z, z2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$2$0(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 1.0f);
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$2$0$0(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_KTwxG1Y$lambda$2$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$3$0(long j, State state, DrawScope drawScope) {
        DrawScope.m7389drawRectnJ9OG0$default(drawScope, j, 0L, 0L, RangesKt.coerceIn(Scrim_KTwxG1Y$lambda$0(state), 0.0f, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    private static final float Scrim_KTwxG1Y$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
