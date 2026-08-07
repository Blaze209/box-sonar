package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
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
import com.facebook.react.uimanager.ViewProps;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.actions.configurations.GuideCapping;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0090\u0001\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b2\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\r0\u001f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b \u0010!\u001a\u0014\u0010\"\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a-\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\u001f2\u0006\u0010&\u001a\u00020\tH\u0003¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010)\u001a\u00020*2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020.H\u0002\"\u0010\u0010/\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00101\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00102\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u00063²\u0006\n\u00104\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"rememberModalBottomSheetState", "Landroidx/compose/material/ModalBottomSheetState;", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "ModalBottomSheetLayout", "", "sheetContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "sheetGesturesEnabled", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "Landroidx/compose/ui/unit/Dp;", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "modalBottomSheetAnchors", "Scrim", "color", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, ViewProps.VISIBLE, "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "ModalBottomSheetPositionalThreshold", "F", "ModalBottomSheetVelocityThreshold", "MaxModalBottomSheetWidth", "material", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt {
    private static final float ModalBottomSheetPositionalThreshold = Dp.m9687constructorimpl(56);
    private static final float ModalBottomSheetVelocityThreshold = Dp.m9687constructorimpl(125);
    private static final float MaxModalBottomSheetWidth = Dp.m9687constructorimpl(640);

    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModalBottomSheetValue.values().length];
            try {
                iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModalBottomSheetValue.HalfExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ModalBottomSheetValue.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetLayout_Gs3lGvM$lambda$1(Function3 function3, Modifier modifier, ModalBottomSheetState modalBottomSheetState, boolean z, Shape shape, float f, long j, long j2, long j3, Function2 function2, int i, int i2, Composer composer, int i3) {
        m2460ModalBottomSheetLayoutGs3lGvM(function3, modifier, modalBottomSheetState, z, shape, f, j, j2, j3, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_3J_VO9M$lambda$4(long j, Function0 function0, boolean z, int i, Composer composer, int i2) {
        m2461Scrim3JVO9M(j, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberModalBottomSheetState$lambda$0$0(ModalBottomSheetValue modalBottomSheetValue) {
        return true;
    }

    public static final ModalBottomSheetState rememberModalBottomSheetState(final ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, boolean z, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -126412120, "C(rememberModalBottomSheetState)N(initialValue,animationSpec,confirmValueChange,skipHalfExpanded)275@11458L8,278@11565L7:ModalBottomSheet.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = ModalBottomSheetDefaults.INSTANCE.getAnimationSpec();
        }
        final AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1222956016, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ModalBottomSheetKt.rememberModalBottomSheetState$lambda$0$0((ModalBottomSheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        final Function1<? super ModalBottomSheetValue, Boolean> function2 = function1;
        final boolean z2 = (i2 & 8) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126412120, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:277)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        composer.startMovableGroup(-1222944377, modalBottomSheetValue);
        ComposerKt.sourceInformation(composer, "296@12260L299,283@11826L733");
        Object[] objArr = {modalBottomSheetValue, animationSpec2, Boolean.valueOf(z2), function2, density};
        Saver<ModalBottomSheetState, ?> Saver = ModalBottomSheetState.INSTANCE.Saver(animationSpec2, function2, z2, density);
        ComposerKt.sourceInformationMarkerStart(composer, -1222930061, "CC(remember):ModalBottomSheet.kt#9igjgp");
        boolean z3 = true;
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(modalBottomSheetValue.ordinal())) || (i & 6) == 4) | composer.changed(density) | ((((i & 896) ^ 384) > 256 && composer.changed(function2)) || (i & 384) == 256) | composer.changedInstance(animationSpec2);
        if ((((i & 7168) ^ 3072) <= 2048 || !composer.changed(z2)) && (i & 3072) != 2048) {
            z3 = false;
        }
        boolean z4 = zChanged | z3;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Object obj = new Function0() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ModalBottomSheetKt.rememberModalBottomSheetState$lambda$1$0(modalBottomSheetValue, density, function2, animationSpec2, z2);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue2 = obj;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modalBottomSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModalBottomSheetState rememberModalBottomSheetState$lambda$1$0(ModalBottomSheetValue modalBottomSheetValue, Density density, Function1 function1, AnimationSpec animationSpec, boolean z) {
        return new ModalBottomSheetState(modalBottomSheetValue, density, function1, animationSpec, z);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0125  */
    /* JADX WARN: Code duplicated, block: B:104:0x0127  */
    /* JADX WARN: Code duplicated, block: B:107:0x0130  */
    /* JADX WARN: Code duplicated, block: B:131:0x018b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x018d  */
    /* JADX WARN: Code duplicated, block: B:133:0x0192  */
    /* JADX WARN: Code duplicated, block: B:136:0x0198  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:142:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:146:0x01da  */
    /* JADX WARN: Code duplicated, block: B:147:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:154:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:155:0x0208  */
    /* JADX WARN: Code duplicated, block: B:158:0x020e  */
    /* JADX WARN: Code duplicated, block: B:159:0x0227  */
    /* JADX WARN: Code duplicated, block: B:163:0x0240  */
    /* JADX WARN: Code duplicated, block: B:166:0x0262  */
    /* JADX WARN: Code duplicated, block: B:169:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:172:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:173:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:178:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:181:0x036f  */
    /* JADX WARN: Code duplicated, block: B:184:0x037b  */
    /* JADX WARN: Code duplicated, block: B:185:0x037f  */
    /* JADX WARN: Code duplicated, block: B:190:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:195:0x0407  */
    /* JADX WARN: Code duplicated, block: B:198:0x0420  */
    /* JADX WARN: Code duplicated, block: B:199:0x0422  */
    /* JADX WARN: Code duplicated, block: B:202:0x0465  */
    /* JADX WARN: Code duplicated, block: B:206:0x0490  */
    /* JADX WARN: Code duplicated, block: B:208:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:214:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:217:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:221:0x0521  */
    /* JADX WARN: Code duplicated, block: B:223:0x0539  */
    /* JADX WARN: Code duplicated, block: B:226:0x0596  */
    /* JADX WARN: Code duplicated, block: B:228:0x05a9  */
    /* JADX WARN: Code duplicated, block: B:231:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:233:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x0103  */
    /* JADX WARN: Code duplicated, block: B:96:0x010c  */
    /* JADX WARN: Code duplicated, block: B:98:0x0112  */
    /* JADX WARN: Code duplicated, block: B:99:0x0115  */
    /* JADX WARN: Type inference failed for: r0v17, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v43 */
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
    /* JADX INFO: renamed from: ModalBottomSheetLayout-Gs3lGvM, reason: not valid java name */
    public static final void m2460ModalBottomSheetLayoutGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, ModalBottomSheetState modalBottomSheetState, boolean z, Shape shape, float f, long j, long j2, long j3, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        ModalBottomSheetState modalBottomSheetState2;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        float f2;
        long j4;
        int i6;
        boolean z3;
        final Modifier modifier2;
        final ModalBottomSheetState modalBottomSheetState3;
        final long j5;
        final boolean z4;
        final Shape shape3;
        final float f3;
        final long j6;
        final long j7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i7;
        boolean z5;
        final ModalBottomSheetState modalBottomSheetStateRememberModalBottomSheetState;
        CornerBasedShape large;
        float fM2453getElevationD9Ej5fM;
        long jM2346getSurface0d7_KjU;
        long jM2360contentColorForek8zF_U;
        int i8;
        long scrimColor;
        int i9;
        Modifier modifier3;
        ?? r0;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        Orientation orientation;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM6062constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean z6;
        Modifier.Companion companionNestedScroll$default;
        boolean z7;
        Modifier.Companion companionSemantics$default;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        boolean zChanged;
        Object objRememberedValue4;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-336264970);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalBottomSheetLayout)N(sheetContent,modifier,sheetState,sheetGesturesEnabled,sheetShape,sheetElevation:c#ui.unit.Dp,sheetBackgroundColor:c#ui.graphics.Color,sheetContentColor:c#ui.graphics.Color,scrimColor:c#ui.graphics.Color,content)353@15034L24,355@15106L3927:ModalBottomSheet.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    modalBottomSheetState2 = modalBottomSheetState;
                    int i15 = composerStartRestartGroup.changedInstance(modalBottomSheetState2) ? 256 : 128;
                    i3 |= i15;
                } else {
                    modalBottomSheetState2 = modalBottomSheetState;
                }
                i3 |= i15;
            } else {
                modalBottomSheetState2 = modalBottomSheetState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                i3 |= 3072;
                z2 = z;
            } else {
                z2 = z;
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
            }
            if ((i & 24576) == 0) {
                shape2 = shape;
                if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(shape2)) {
                    i13 = 8192;
                } else {
                    i13 = 16384;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    f2 = f;
                    int i16 = composerStartRestartGroup.changed(f2) ? 131072 : 65536;
                    i3 |= i16;
                } else {
                    f2 = f;
                }
                i3 |= i16;
            } else {
                f2 = f;
            }
            if ((i & 1572864) == 0) {
                j4 = j;
                if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(j4)) {
                    i12 = 524288;
                } else {
                    i12 = 1048576;
                }
                i3 |= i12;
            } else {
                j4 = j;
            }
            if ((12582912 & i) != 0) {
                if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                    i11 = 4194304;
                } else {
                    i11 = 8388608;
                }
                i3 |= i11;
            }
            if ((100663296 & i) == 0) {
                if ((i2 & 256) == 0) {
                    i6 = i14;
                    int i17 = composerStartRestartGroup.changed(j3) ? 67108864 : 33554432;
                    i3 |= i17;
                } else {
                    i6 = i14;
                }
                i3 |= i17;
            } else {
                i6 = i14;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i10 = 268435456;
                }
                i3 |= i10;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "344@14588L37,346@14707L6,348@14830L6,349@14877L37,350@14965L10");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        int i18 = i3;
                        z5 = false;
                        modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, composerStartRestartGroup, 6, 14);
                        i7 = i18 & (-897);
                    } else {
                        i7 = i3;
                        z5 = false;
                        modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                        i7 &= -57345;
                    } else {
                        large = shape2;
                    }
                    if ((i2 & 32) != 0) {
                        fM2453getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m2453getElevationD9Ej5fM();
                        i7 &= -458753;
                    } else {
                        fM2453getElevationD9Ej5fM = f;
                    }
                    if ((i2 & 64) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i7 &= -3670017;
                    } else {
                        jM2346getSurface0d7_KjU = j4;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i7 >> 18) & 14);
                        i7 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if ((i2 & 256) != 0) {
                        scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, z5 ? 1 : 0);
                        i9 = i7 & (-234881025);
                        i8 = -336264970;
                    } else {
                        i8 = -336264970;
                        scrimColor = j3;
                        i9 = i7;
                    }
                    modifier3 = companion;
                    r0 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                    }
                    ModalBottomSheetState modalBottomSheetState4 = modalBottomSheetState2;
                    i9 = i3;
                    modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState4;
                    modifier3 = modifier;
                    jM2360contentColorForek8zF_U = j2;
                    r0 = 0;
                    fM2453getElevationD9Ej5fM = f2;
                    jM2346getSurface0d7_KjU = j4;
                    large = shape2;
                    i8 = -336264970;
                    scrimColor = j3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i9, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:352)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                orientation = Orientation.Vertical;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                Modifier modifier4 = modifier3;
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                long j8 = scrimColor;
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 350779258, "C356@15130L431,437@18973L54,368@15570L3457:ModalBottomSheet.kt#jmzs0o");
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1832269826, "C357@15172L9,360@15265L188,358@15194L357:ModalBottomSheet.kt#jmzs0o");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i9 >> 27) & 14));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -751839354, "CC(remember):ModalBottomSheet.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(modalBottomSheetStateRememberModalBottomSheetState) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$0$0$0(modalBottomSheetStateRememberModalBottomSheetState, coroutineScope);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material().getTargetValue() != ModalBottomSheetValue.Hidden) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                m2461Scrim3JVO9M(j8, function0, z6, composerStartRestartGroup, (i9 >> 24) & 14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i19 = i9;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m1273widthInVpY3zN4$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), 0.0f, MaxModalBottomSheetWidth, 1, null), 0.0f, 1, null);
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(351375666);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "375@15915L355");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState$material = modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1258263027, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(anchoredDraggableState$material);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material(), orientation);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) objRememberedValue4, null, 2, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1258275768);
                    composerStartRestartGroup.endReplaceGroup();
                    companionNestedScroll$default = Modifier.INSTANCE;
                }
                Modifier modifierModalBottomSheetAnchors = modalBottomSheetAnchors(modifierFillMaxWidth$default.then(companionNestedScroll$default), modalBottomSheetStateRememberModalBottomSheetState);
                AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState$material2 = modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material();
                if (z2 || modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material().getCurrentValue() == ModalBottomSheetValue.Hidden) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modifierModalBottomSheetAnchors, anchoredDraggableState$material2, orientation, z7, false, null, false, 56, null);
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(352377090);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "394@16846L1901");
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1258294365, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(modalBottomSheetStateRememberModalBottomSheetState) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0(modalBottomSheetStateRememberModalBottomSheetState, coroutineScope, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue3, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1258354200);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics$default = Modifier.INSTANCE;
                }
                int i20 = i19 >> 12;
                SurfaceKt.m2584SurfaceFjzlyU(modifierAnchoredDraggable$default.then(companionSemantics$default), large, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U, null, fM2453getElevationD9Ej5fM, ComposableLambdaKt.rememberComposableLambda(-1557535116, true, new Function2() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i19 >> 9) & 112) | 1572864 | (i20 & 896) | (i20 & 7168) | (i19 & 458752), 16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modalBottomSheetState3 = modalBottomSheetStateRememberModalBottomSheetState;
                z4 = z2;
                shape3 = large;
                j5 = jM2346getSurface0d7_KjU;
                f3 = fM2453getElevationD9Ej5fM;
                modifier2 = modifier4;
                j7 = j8;
                j6 = jM2360contentColorForek8zF_U;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier2 = modifier;
                modalBottomSheetState3 = modalBottomSheetState2;
                j5 = j4;
                z4 = z2;
                shape3 = shape2;
                f3 = f;
                j6 = j2;
                j7 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$1(function3, modifier2, modalBottomSheetState3, z4, shape3, f3, j5, j6, j7, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                modalBottomSheetState2 = modalBottomSheetState;
                if (composerStartRestartGroup.changedInstance(modalBottomSheetState2)) {
                }
                i3 |= i15;
            } else {
                modalBottomSheetState2 = modalBottomSheetState;
            }
            i3 |= i15;
        } else {
            modalBottomSheetState2 = modalBottomSheetState;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
            z2 = z;
        } else {
            z2 = z;
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
        }
        if ((i & 24576) == 0) {
            shape2 = shape;
            if ((i2 & 16) == 0) {
                i13 = 8192;
            } else {
                i13 = 8192;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                }
                i3 |= i16;
            } else {
                f2 = f;
            }
            i3 |= i16;
        } else {
            f2 = f;
        }
        if ((i & 1572864) == 0) {
            j4 = j;
            if ((i2 & 64) == 0) {
                i12 = 524288;
            } else {
                i12 = 524288;
            }
            i3 |= i12;
        } else {
            j4 = j;
        }
        if ((12582912 & i) != 0) {
            if ((i2 & 128) == 0) {
                i11 = 4194304;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        if ((100663296 & i) == 0) {
            if ((i2 & 256) == 0) {
                i6 = i14;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i17;
            } else {
                i6 = i14;
            }
            i3 |= i17;
        } else {
            i6 = i14;
        }
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i10 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i10 = 268435456;
            }
            i3 |= i10;
        }
        if ((i3 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "344@14588L37,346@14707L6,348@14830L6,349@14877L37,350@14965L10");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    int i110 = i3;
                    z5 = false;
                    modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, composerStartRestartGroup, 6, 14);
                    i7 = i110 & (-897);
                } else {
                    i7 = i3;
                    z5 = false;
                    modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i7 &= -57345;
                } else {
                    large = shape2;
                }
                if ((i2 & 32) != 0) {
                    fM2453getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m2453getElevationD9Ej5fM();
                    i7 &= -458753;
                } else {
                    fM2453getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i7 &= -3670017;
                } else {
                    jM2346getSurface0d7_KjU = j4;
                }
                if ((i2 & 128) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i7 >> 18) & 14);
                    i7 &= -29360129;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, z5 ? 1 : 0);
                    i9 = i7 & (-234881025);
                    i8 = -336264970;
                } else {
                    i8 = -336264970;
                    scrimColor = j3;
                    i9 = i7;
                }
                modifier3 = companion;
                r0 = z5;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    int i111 = i3;
                    z5 = false;
                    modalBottomSheetStateRememberModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, null, null, false, composerStartRestartGroup, 6, 14);
                    i7 = i111 & (-897);
                } else {
                    i7 = i3;
                    z5 = false;
                    modalBottomSheetStateRememberModalBottomSheetState = modalBottomSheetState2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    large = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i7 &= -57345;
                } else {
                    large = shape2;
                }
                if ((i2 & 32) != 0) {
                    fM2453getElevationD9Ej5fM = ModalBottomSheetDefaults.INSTANCE.m2453getElevationD9Ej5fM();
                    i7 &= -458753;
                } else {
                    fM2453getElevationD9Ej5fM = f;
                }
                if ((i2 & 64) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i7 &= -3670017;
                } else {
                    jM2346getSurface0d7_KjU = j4;
                }
                if ((i2 & 128) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i7 >> 18) & 14);
                    i7 &= -29360129;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if ((i2 & 256) != 0) {
                    scrimColor = ModalBottomSheetDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, z5 ? 1 : 0);
                    i9 = i7 & (-234881025);
                    i8 = -336264970;
                } else {
                    i8 = -336264970;
                    scrimColor = j3;
                    i9 = i7;
                }
                modifier3 = companion;
                r0 = z5;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i9, -1, "androidx.compose.material.ModalBottomSheetLayout (ModalBottomSheet.kt:352)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            orientation = Orientation.Vertical;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
            Modifier modifier5 = modifier3;
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            long j9 = scrimColor;
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
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 350779258, "C356@15130L431,437@18973L54,368@15570L3457:ModalBottomSheet.kt#jmzs0o");
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl2.getInserting()) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1832269826, "C357@15172L9,360@15265L188,358@15194L357:ModalBottomSheet.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i9 >> 27) & 14));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -751839354, "CC(remember):ModalBottomSheet.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(modalBottomSheetStateRememberModalBottomSheetState) | composerStartRestartGroup.changedInstance(coroutineScope);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$0$0$0(modalBottomSheetStateRememberModalBottomSheetState, coroutineScope);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$0$0$0(modalBottomSheetStateRememberModalBottomSheetState, coroutineScope);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material().getTargetValue() != ModalBottomSheetValue.Hidden) {
                z6 = true;
            } else {
                z6 = false;
            }
            m2461Scrim3JVO9M(j9, function1, z6, composerStartRestartGroup, (i9 >> 24) & 14);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i112 = i9;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(SizeKt.m1273widthInVpY3zN4$default(boxScopeInstance3.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), 0.0f, MaxModalBottomSheetWidth, 1, null), 0.0f, 1, null);
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(351375666);
                ComposerKt.sourceInformation(composerStartRestartGroup, "375@15915L355");
                Modifier.Companion companion4 = Modifier.INSTANCE;
                AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState$material3 = modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1258263027, "CC(remember):ModalBottomSheet.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(anchoredDraggableState$material3);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue4 = ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material(), orientation);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material(), orientation);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion4, (NestedScrollConnection) objRememberedValue4, null, 2, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1258275768);
                composerStartRestartGroup.endReplaceGroup();
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            Modifier modifierModalBottomSheetAnchors2 = modalBottomSheetAnchors(modifierFillMaxWidth$default2.then(companionNestedScroll$default), modalBottomSheetStateRememberModalBottomSheetState);
            AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState$material4 = modalBottomSheetStateRememberModalBottomSheetState.getAnchoredDraggableState$material();
            if (z2) {
                z7 = false;
            } else {
                z7 = false;
            }
            Modifier modifierAnchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modifierModalBottomSheetAnchors2, anchoredDraggableState$material4, orientation, z7, false, null, false, 56, null);
            if (z2) {
                composerStartRestartGroup.startReplaceGroup(352377090);
                ComposerKt.sourceInformation(composerStartRestartGroup, "394@16846L1901");
                Modifier.Companion companion5 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1258294365, "CC(remember):ModalBottomSheet.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(modalBottomSheetStateRememberModalBottomSheetState) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0(modalBottomSheetStateRememberModalBottomSheetState, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0(modalBottomSheetStateRememberModalBottomSheetState, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionSemantics$default = SemanticsModifierKt.semantics$default(companion5, false, (Function1) objRememberedValue3, 1, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1258354200);
                composerStartRestartGroup.endReplaceGroup();
                companionSemantics$default = Modifier.INSTANCE;
            }
            int i21 = i112 >> 12;
            SurfaceKt.m2584SurfaceFjzlyU(modifierAnchoredDraggable$default2.then(companionSemantics$default), large, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U, null, fM2453getElevationD9Ej5fM, ComposableLambdaKt.rememberComposableLambda(-1557535116, true, new Function2() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i112 >> 9) & 112) | 1572864 | (i21 & 896) | (i21 & 7168) | (i112 & 458752), 16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modalBottomSheetState3 = modalBottomSheetStateRememberModalBottomSheetState;
            z4 = z2;
            shape3 = large;
            j5 = jM2346getSurface0d7_KjU;
            f3 = fM2453getElevationD9Ej5fM;
            modifier2 = modifier5;
            j7 = j9;
            j6 = jM2360contentColorForek8zF_U;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            modalBottomSheetState3 = modalBottomSheetState2;
            j5 = j4;
            z4 = z2;
            shape3 = shape2;
            f3 = f;
            j6 = j2;
            j7 = j3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$1(function3, modifier2, modalBottomSheetState3, z4, shape3, f3, j5, j6, j7, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetLayout_Gs3lGvM$lambda$0$0$0$0(ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope) {
        if (modalBottomSheetState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheetLayout$1$1$1$1$1(modalBottomSheetState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0(final ModalBottomSheetState modalBottomSheetState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (modalBottomSheetState.isVisible()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0$0(modalBottomSheetState, coroutineScope));
                }
            }, 1, null);
            if (modalBottomSheetState.getAnchoredDraggableState$material().getCurrentValue() == ModalBottomSheetValue.HalfExpanded) {
                SemanticsPropertiesKt.expand$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0$1(modalBottomSheetState, coroutineScope));
                    }
                }, 1, null);
            } else if (modalBottomSheetState.getHasHalfExpandedState$material()) {
                SemanticsPropertiesKt.collapse$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ModalBottomSheetKt.ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0$2(modalBottomSheetState, coroutineScope));
                    }
                }, 1, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0$0(ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope) {
        if (!modalBottomSheetState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(ModalBottomSheetValue.Hidden).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$1$1(modalBottomSheetState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0$1(ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope) {
        if (!modalBottomSheetState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(ModalBottomSheetValue.Expanded).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$2$1(modalBottomSheetState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalBottomSheetLayout_Gs3lGvM$lambda$0$2$0$2(ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope) {
        if (!modalBottomSheetState.getAnchoredDraggableState$material().getConfirmValueChange$material().invoke(ModalBottomSheetValue.HalfExpanded).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheetLayout$1$3$1$3$1(modalBottomSheetState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetLayout_Gs3lGvM$lambda$0$3(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C438@18987L30:ModalBottomSheet.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1557535116, i, -1, "androidx.compose.material.ModalBottomSheetLayout.<anonymous>.<anonymous> (ModalBottomSheet.kt:438)");
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

    private static final Modifier modalBottomSheetAnchors(Modifier modifier, final ModalBottomSheetState modalBottomSheetState) {
        return AnchoredDraggableKt.draggableAnchors(modifier, modalBottomSheetState.getAnchoredDraggableState$material(), Orientation.Vertical, new Function2() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ModalBottomSheetKt.modalBottomSheetAnchors$lambda$0(modalBottomSheetState, (IntSize) obj, (Constraints) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair modalBottomSheetAnchors$lambda$0(final ModalBottomSheetState modalBottomSheetState, final IntSize intSize, Constraints constraints) {
        ModalBottomSheetValue modalBottomSheetValue;
        final float fM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(constraints.getValue());
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModalBottomSheetKt.modalBottomSheetAnchors$lambda$0$0(fM9639getMaxHeightimpl, modalBottomSheetState, intSize, (DraggableAnchorsConfig) obj);
            }
        });
        boolean z = modalBottomSheetState.getAnchoredDraggableState$material().getAnchors().getSize() > 0;
        ModalBottomSheetValue currentValue = modalBottomSheetState.getCurrentValue();
        if (z || !DraggableAnchors.hasAnchorFor(currentValue)) {
            int i = WhenMappings.$EnumSwitchMapping$0[modalBottomSheetState.getTargetValue().ordinal()];
            if (i == 1) {
                currentValue = ModalBottomSheetValue.Hidden;
            } else {
                if (i != 2 && i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (DraggableAnchors.hasAnchorFor(ModalBottomSheetValue.HalfExpanded)) {
                    modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
                } else if (DraggableAnchors.hasAnchorFor(ModalBottomSheetValue.Expanded)) {
                    modalBottomSheetValue = ModalBottomSheetValue.Expanded;
                } else {
                    modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                }
                currentValue = modalBottomSheetValue;
            }
        }
        return TuplesKt.to(DraggableAnchors, currentValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit modalBottomSheetAnchors$lambda$0$0(float f, ModalBottomSheetState modalBottomSheetState, IntSize intSize, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(ModalBottomSheetValue.Hidden, f);
        float f2 = f / 2.0f;
        if (!modalBottomSheetState.getIsSkipHalfExpanded() && ((int) (intSize.m9862unboximpl() & 4294967295L)) > f2) {
            draggableAnchorsConfig.at(ModalBottomSheetValue.HalfExpanded, f2);
        }
        if (((int) (intSize.m9862unboximpl() & 4294967295L)) != 0) {
            draggableAnchorsConfig.at(ModalBottomSheetValue.Expanded, Math.max(0.0f, f - ((int) (intSize.m9862unboximpl() & 4294967295L))));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    private static final void m2461Scrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-526532668);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(color:c#ui.graphics.Color,onDismiss,visible):ModalBottomSheet.kt#jmzs0o");
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
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526532668, i2, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:489)");
            }
            if (j != 16) {
                composerStartRestartGroup.startReplaceGroup(-714029408);
                ComposerKt.sourceInformation(composerStartRestartGroup, "492@21083L87,493@21196L29,508@21761L79,508@21708L132");
                int i3 = i2;
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                final String strM2581getString4foXLRw = Strings_androidKt.m2581getString4foXLRw(Strings.INSTANCE.m2574getCloseSheetUdPEhr4(), composerStartRestartGroup, 6);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-713811509);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "496@21332L37,497@21426L212");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 808259113, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    int i4 = i3 & 112;
                    boolean z2 = i4 == 32;
                    ModalBottomSheetKt$Scrim$dismissModifier$1$1 modalBottomSheetKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z2 || modalBottomSheetKt$Scrim$dismissModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        modalBottomSheetKt$Scrim$dismissModifier$1$1RememberedValue = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0);
                        composerStartRestartGroup.updateRememberedValue(modalBottomSheetKt$Scrim$dismissModifier$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (PointerInputEventHandler) modalBottomSheetKt$Scrim$dismissModifier$1$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 808262296, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChanged = (i4 == 32) | composerStartRestartGroup.changed(strM2581getString4foXLRw);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ModalBottomSheetKt.Scrim_3J_VO9M$lambda$2$0(strM2581getString4foXLRw, function0, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-713447786);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 808272883, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(stateAnimateFloatAsState) | ((i3 & 14) == 4);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.Scrim_3J_VO9M$lambda$3$0(j, stateAnimateFloatAsState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-734934754);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.Scrim_3J_VO9M$lambda$4(j, function0, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_3J_VO9M$lambda$2$0(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.ModalBottomSheetKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ModalBottomSheetKt.Scrim_3J_VO9M$lambda$2$0$0(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_3J_VO9M$lambda$2$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_3J_VO9M$lambda$3$0(long j, State state, DrawScope drawScope) {
        DrawScope.m7389drawRectnJ9OG0$default(drawScope, j, 0L, 0L, RangesKt.coerceIn(Scrim_3J_VO9M$lambda$0(state), 0.0f, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material.ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0003*\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u000eH\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0017\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/material/ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", GuideCapping.INSERT_CAPPING_CONSUMED, "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
            ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1;
            if (continuation instanceof ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) {
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = (ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) continuation;
                if ((modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label -= Integer.MIN_VALUE;
                } else {
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, continuation);
                }
            } else {
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, continuation);
            }
            Object obj = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float fVelocityToFloat = velocityToFloat(j);
                float fRequireOffset = this.$state.requireOffset();
                if (fVelocityToFloat < 0.0f && fRequireOffset > this.$state.getAnchors().minAnchor()) {
                    AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0 = j;
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.label = 1;
                    if (anchoredDraggableState.settle(fVelocityToFloat, modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    j = Velocity.INSTANCE.m9936getZero9UxMQ8M();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1.J$0;
                ResultKt.throwOnFailure(obj);
            }
            return Velocity.m9916boximpl(j);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
            ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1;
            if (continuation instanceof ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) {
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = (ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) continuation;
                if ((modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                } else {
                    modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, continuation);
                }
            } else {
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 = new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, continuation);
            }
            Object obj = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnchoredDraggableState<?> anchoredDraggableState = this.$state;
                float fVelocityToFloat = velocityToFloat(j2);
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0 = j2;
                modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.label = 1;
                if (anchoredDraggableState.settle(fVelocityToFloat, modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j2 = modalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1.J$0;
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

    private static final float Scrim_3J_VO9M$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
