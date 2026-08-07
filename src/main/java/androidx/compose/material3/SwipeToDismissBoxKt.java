package androidx.compose.material3;

import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchors;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.DraggableAnchorsKt;
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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.profileinstaller.ProfileVerifier;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwipeToDismissBox.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\n\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u00052#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\r\u001a\u008f\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u00052\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u001c\u001ay\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\f2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006!"}, d2 = {"rememberSwipeToDismissBoxState", "Landroidx/compose/material3/SwipeToDismissBoxState;", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "confirmValueChange", "", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SwipeToDismissBoxState;", "SwipeToDismissBox", "", "state", "backgroundContent", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "enableDismissFromStartToEnd", "enableDismissFromEndToStart", "gesturesEnabled", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "content", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SwipeToDismissBoxState;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SwipeToDismissBoxKt {
    private static final float DismissVelocityThreshold = Dp.m9687constructorimpl(125);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDismissBox$lambda$3(SwipeToDismissBoxState swipeToDismissBoxState, Function3 function3, Modifier modifier, boolean z, boolean z2, boolean z3, Function1 function1, Function3 function4, int i, int i2, Composer composer, int i3) {
        SwipeToDismissBox(swipeToDismissBoxState, function3, modifier, z, z2, z3, function1, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDismissBox$lambda$5(SwipeToDismissBoxState swipeToDismissBoxState, Function3 function3, Modifier modifier, boolean z, boolean z2, boolean z3, Function3 function4, int i, int i2, Composer composer, int i3) {
        SwipeToDismissBox(swipeToDismissBoxState, function3, modifier, z, z2, z3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberSwipeToDismissBoxState$lambda$1$0(SwipeToDismissBoxValue swipeToDismissBoxValue) {
        return true;
    }

    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(final SwipeToDismissBoxValue swipeToDismissBoxValue, final Function1<? super Float, Float> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -470572556, "C(rememberSwipeToDismissBoxState)N(initialValue,positionalThreshold)242@9958L19,246@10130L73,244@10018L185:SwipeToDismissBox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            swipeToDismissBoxValue = SwipeToDismissBoxValue.Settled;
        }
        if ((i2 & 2) != 0) {
            function1 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold(composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-470572556, i, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:243)");
        }
        Object[] objArr = new Object[0];
        Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver = SwipeToDismissBoxState.INSTANCE.Saver(function1);
        ComposerKt.sourceInformationMarkerStart(composer, -1248648131, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((6 ^ (i & 14)) > 4 && composer.changed(swipeToDismissBoxValue.ordinal())) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(function1)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SwipeToDismissBoxKt.rememberSwipeToDismissBoxState$lambda$0$0(swipeToDismissBoxValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SwipeToDismissBoxState swipeToDismissBoxState = (SwipeToDismissBoxState) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeToDismissBoxState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState$lambda$0$0(SwipeToDismissBoxValue swipeToDismissBoxValue, Function1 function1) {
        return new SwipeToDismissBoxState(swipeToDismissBoxValue, function1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = DraggableAnchorsKt.ConfirmValueChangeDeprecated, replaceWith = @ReplaceWith(expression = "rememberSwipeToDismissBoxState(initialValue, positionalThreshold)", imports = {}))
    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState(final SwipeToDismissBoxValue swipeToDismissBoxValue, final Function1<? super SwipeToDismissBoxValue, Boolean> function1, final Function1<? super Float, Float> function2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -246335487, "C(rememberSwipeToDismissBoxState)N(initialValue,confirmValueChange,positionalThreshold)270@11212L8,272@11315L19,274@11395L7,282@11661L102,275@11414L349:SwipeToDismissBox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            swipeToDismissBoxValue = SwipeToDismissBoxValue.Settled;
        }
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -505196183, "CC(remember):SwipeToDismissBox.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SwipeToDismissBoxKt.rememberSwipeToDismissBoxState$lambda$1$0((SwipeToDismissBoxValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if ((i2 & 4) != 0) {
            function2 = SwipeToDismissBoxDefaults.INSTANCE.getPositionalThreshold(composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-246335487, i, -1, "androidx.compose.material3.rememberSwipeToDismissBoxState (SwipeToDismissBox.kt:273)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Object[] objArr = new Object[0];
        Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver = SwipeToDismissBoxState.INSTANCE.Saver(function1, function2, density);
        ComposerKt.sourceInformationMarkerStart(composer, -505181721, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        boolean z = true;
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(swipeToDismissBoxValue.ordinal())) || (i & 6) == 4) | composer.changed(density) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32);
        if ((((i & 896) ^ 384) <= 256 || !composer.changed(function2)) && (i & 384) != 256) {
            z = false;
        }
        boolean z2 = zChanged | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SwipeToDismissBoxKt.rememberSwipeToDismissBoxState$lambda$2$0(swipeToDismissBoxValue, density, function1, function2);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SwipeToDismissBoxState swipeToDismissBoxState = (SwipeToDismissBoxState) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeToDismissBoxState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SwipeToDismissBoxState rememberSwipeToDismissBoxState$lambda$2$0(SwipeToDismissBoxValue swipeToDismissBoxValue, Density density, Function1 function1, Function1 function2) {
        return new SwipeToDismissBoxState(swipeToDismissBoxValue, density, function1, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDismissBox$lambda$0$0(SwipeToDismissBoxValue swipeToDismissBoxValue) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0135  */
    /* JADX WARN: Code duplicated, block: B:106:0x0146  */
    /* JADX WARN: Code duplicated, block: B:109:0x0151  */
    /* JADX WARN: Code duplicated, block: B:112:0x0159  */
    /* JADX WARN: Code duplicated, block: B:113:0x0182  */
    /* JADX WARN: Code duplicated, block: B:116:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:119:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:120:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:123:0x0211  */
    /* JADX WARN: Code duplicated, block: B:125:0x021f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0299  */
    /* JADX WARN: Code duplicated, block: B:131:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:132:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:135:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:137:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:140:0x032f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0331  */
    /* JADX WARN: Code duplicated, block: B:144:0x033a  */
    /* JADX WARN: Code duplicated, block: B:145:0x033c  */
    /* JADX WARN: Code duplicated, block: B:148:0x0349  */
    /* JADX WARN: Code duplicated, block: B:150:0x0351  */
    /* JADX WARN: Code duplicated, block: B:153:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:156:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:157:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:160:0x03da  */
    /* JADX WARN: Code duplicated, block: B:162:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:165:0x044c  */
    /* JADX WARN: Code duplicated, block: B:166:0x044e  */
    /* JADX WARN: Code duplicated, block: B:169:0x0456  */
    /* JADX WARN: Code duplicated, block: B:171:0x045e  */
    /* JADX WARN: Code duplicated, block: B:174:0x047c  */
    /* JADX WARN: Code duplicated, block: B:176:0x0486  */
    /* JADX WARN: Code duplicated, block: B:179:0x0494  */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:88:0x0100  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:91:0x0105  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x010b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0110  */
    /* JADX WARN: Code duplicated, block: B:99:0x0122  */
    public static final void SwipeToDismissBox(final SwipeToDismissBoxState swipeToDismissBoxState, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean z, boolean z2, boolean z3, Function1<? super SwipeToDismissBoxValue, Unit> function1, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z5;
        int i9;
        int i10;
        final Function1<? super SwipeToDismissBoxValue, Unit> function2;
        int i11;
        boolean z6;
        final Modifier modifier3;
        final boolean z7;
        final boolean z8;
        final boolean z9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final boolean z10;
        final boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        TargetedFlingBehavior targetedFlingBehaviorFlingBehavior;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM6062constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean z15;
        boolean z16;
        boolean zChangedInstance;
        Object objRememberedValue;
        int currentCompositeKeyHash3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM6062constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        boolean z17;
        boolean z18;
        SwipeToDismissBoxKt$SwipeToDismissBox$3$1 swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue;
        Object objRememberedValue2;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-741495334);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwipeToDismissBox)N(state,backgroundContent,modifier,enableDismissFromStartToEnd,enableDismissFromEndToStart,gesturesEnabled,onDismiss,content)311@13042L2,314@13100L2134,360@15285L200,360@15239L246:SwipeToDismissBox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(swipeToDismissBoxState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(z5)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                        function2 = function1;
                    } else {
                        function2 = function1;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z5;
                        z9 = z2;
                    } else {
                        if (i13 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            z10 = true;
                        } else {
                            z10 = z4;
                        }
                        if (i6 != 0) {
                            z11 = true;
                        } else {
                            z11 = z2;
                        }
                        if (i8 != 0) {
                            z12 = true;
                        } else {
                            z12 = z5;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387565852, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$0$0((SwipeToDismissBoxValue) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            function2 = (Function1) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-741495334, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
                        }
                        AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material3 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                        Orientation orientation = Orientation.Horizontal;
                        if (z12 || swipeToDismissBoxState.getSettledValue() != SwipeToDismissBoxValue.Settled) {
                            z13 = false;
                        } else {
                            z13 = true;
                        }
                        if (swipeToDismissBoxState.getUseFlingBehavior$material3()) {
                            composerStartRestartGroup.startReplaceGroup(387580721);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "322@13501L183");
                            z14 = true;
                            targetedFlingBehaviorFlingBehavior = AnchoredDraggableDefaults.INSTANCE.flingBehavior(swipeToDismissBoxState.getAnchoredDraggableState$material3(), swipeToDismissBoxState.getPositionalThreshold$material3(), null, composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 4);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            z14 = true;
                            composerStartRestartGroup.startReplaceGroup(-869697757);
                            composerStartRestartGroup.endReplaceGroup();
                            targetedFlingBehaviorFlingBehavior = null;
                        }
                        Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modifier4, anchoredDraggableState$material3, orientation, z13, null, null, targetedFlingBehaviorFlingBehavior, 24, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1704011422, "C330@13787L71,334@14022L1195,331@13867L1361:SwipeToDismissBox.kt#uh7d8r");
                        Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                        int i14 = (i3 << 6) & 7168;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMatchParentSize);
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
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                        function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i14 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material4 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                        Orientation orientation2 = Orientation.Horizontal;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609150165, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        if ((57344 & i3) == 16384) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        zChangedInstance = z16 | z15 | composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierDraggableAnchors = DraggableAnchorsKt.draggableAnchors(companion, anchoredDraggableState$material4, orientation2, (Function2) objRememberedValue);
                        int i15 = (i3 >> 12) & 7168;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDraggableAnchors);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor3);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                        function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i15 >> 6) & 112) | 6));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SwipeToDismissBoxValue settledValue = swipeToDismissBoxState.getSettledValue();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387637826, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                        if ((3670016 & i3) == 1048576) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        z18 = zChangedInstance2 | z17;
                        swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z18 || swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                            composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(settledValue, function2, (Function2) swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z12;
                        z9 = z11;
                        modifier3 = modifier4;
                        z7 = z10;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$3(swipeToDismissBoxState, function3, modifier3, z7, z9, z8, function2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    function2 = function1;
                } else {
                    function2 = function1;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    z9 = z2;
                } else {
                    if (i13 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z10 = true;
                    } else {
                        z10 = z4;
                    }
                    if (i6 != 0) {
                        z11 = true;
                    } else {
                        z11 = z2;
                    }
                    if (i8 != 0) {
                        z12 = true;
                    } else {
                        z12 = z5;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387565852, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$0$0((SwipeToDismissBoxValue) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        function2 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-741495334, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
                    }
                    AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material5 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                    Orientation orientation3 = Orientation.Horizontal;
                    if (z12) {
                        z13 = false;
                    } else {
                        z13 = false;
                    }
                    if (swipeToDismissBoxState.getUseFlingBehavior$material3()) {
                        composerStartRestartGroup.startReplaceGroup(387580721);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "322@13501L183");
                        z14 = true;
                        targetedFlingBehaviorFlingBehavior = AnchoredDraggableDefaults.INSTANCE.flingBehavior(swipeToDismissBoxState.getAnchoredDraggableState$material3(), swipeToDismissBoxState.getPositionalThreshold$material3(), null, composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 4);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z14 = true;
                        composerStartRestartGroup.startReplaceGroup(-869697757);
                        composerStartRestartGroup.endReplaceGroup();
                        targetedFlingBehaviorFlingBehavior = null;
                    }
                    Modifier modifierAnchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modifier4, anchoredDraggableState$material5, orientation3, z13, null, null, targetedFlingBehaviorFlingBehavior, 24, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1704011422, "C330@13787L71,334@14022L1195,331@13867L1361:SwipeToDismissBox.kt#uh7d8r");
                    Modifier modifierMatchParentSize2 = boxScopeInstance2.matchParentSize(Modifier.INSTANCE);
                    int i16 = (i3 << 6) & 7168;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMatchParentSize2);
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
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting()) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i16 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material6 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                    Orientation orientation4 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609150165, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if ((57344 & i3) == 16384) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    zChangedInstance = z16 | z15 | composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDraggableAnchors2 = DraggableAnchorsKt.draggableAnchors(companion2, anchoredDraggableState$material6, orientation4, (Function2) objRememberedValue);
                    int i17 = (i3 >> 12) & 7168;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDraggableAnchors2);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl3.getInserting()) {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i17 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SwipeToDismissBoxValue settledValue2 = swipeToDismissBoxState.getSettledValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387637826, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                    if ((3670016 & i3) == 1048576) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = zChangedInstance3 | z17;
                    swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z18) {
                        swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                        composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                    } else {
                        swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                        composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(settledValue2, function2, (Function2) swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z12;
                    z9 = z11;
                    modifier3 = modifier4;
                    z7 = z10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$3(swipeToDismissBoxState, function3, modifier3, z7, z9, z8, function2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    function2 = function1;
                } else {
                    function2 = function1;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    z9 = z2;
                } else {
                    if (i13 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z10 = true;
                    } else {
                        z10 = z4;
                    }
                    if (i6 != 0) {
                        z11 = true;
                    } else {
                        z11 = z2;
                    }
                    if (i8 != 0) {
                        z12 = true;
                    } else {
                        z12 = z5;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387565852, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$0$0((SwipeToDismissBoxValue) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        function2 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-741495334, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
                    }
                    AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material7 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                    Orientation orientation5 = Orientation.Horizontal;
                    if (z12) {
                        z13 = false;
                    } else {
                        z13 = false;
                    }
                    if (swipeToDismissBoxState.getUseFlingBehavior$material3()) {
                        composerStartRestartGroup.startReplaceGroup(387580721);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "322@13501L183");
                        z14 = true;
                        targetedFlingBehaviorFlingBehavior = AnchoredDraggableDefaults.INSTANCE.flingBehavior(swipeToDismissBoxState.getAnchoredDraggableState$material3(), swipeToDismissBoxState.getPositionalThreshold$material3(), null, composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 4);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z14 = true;
                        composerStartRestartGroup.startReplaceGroup(-869697757);
                        composerStartRestartGroup.endReplaceGroup();
                        targetedFlingBehaviorFlingBehavior = null;
                    }
                    Modifier modifierAnchoredDraggable$default3 = AnchoredDraggableKt.anchoredDraggable$default(modifier4, anchoredDraggableState$material7, orientation5, z13, null, null, targetedFlingBehaviorFlingBehavior, 24, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1704011422, "C330@13787L71,334@14022L1195,331@13867L1361:SwipeToDismissBox.kt#uh7d8r");
                    Modifier modifierMatchParentSize3 = boxScopeInstance3.matchParentSize(Modifier.INSTANCE);
                    int i18 = (i3 << 6) & 7168;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMatchParentSize3);
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
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting()) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i18 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material8 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                    Orientation orientation6 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609150165, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if ((57344 & i3) == 16384) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    zChangedInstance = z16 | z15 | composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDraggableAnchors3 = DraggableAnchorsKt.draggableAnchors(companion3, anchoredDraggableState$material8, orientation6, (Function2) objRememberedValue);
                    int i19 = (i3 >> 12) & 7168;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDraggableAnchors3);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl3.getInserting()) {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i19 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SwipeToDismissBoxValue settledValue3 = swipeToDismissBoxState.getSettledValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387637826, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                    if ((3670016 & i3) == 1048576) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = zChangedInstance4 | z17;
                    swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z18) {
                        swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                        composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                    } else {
                        swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                        composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(settledValue3, function2, (Function2) swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z12;
                    z9 = z11;
                    modifier3 = modifier4;
                    z7 = z10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$3(swipeToDismissBoxState, function3, modifier3, z7, z9, z8, function2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z5 = z3;
            } else {
                z5 = z3;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                z9 = z2;
            } else {
                if (i13 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z10 = true;
                } else {
                    z10 = z4;
                }
                if (i6 != 0) {
                    z11 = true;
                } else {
                    z11 = z2;
                }
                if (i8 != 0) {
                    z12 = true;
                } else {
                    z12 = z5;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387565852, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$0$0((SwipeToDismissBoxValue) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function2 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-741495334, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
                }
                AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material9 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                Orientation orientation7 = Orientation.Horizontal;
                if (z12) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                if (swipeToDismissBoxState.getUseFlingBehavior$material3()) {
                    composerStartRestartGroup.startReplaceGroup(387580721);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "322@13501L183");
                    z14 = true;
                    targetedFlingBehaviorFlingBehavior = AnchoredDraggableDefaults.INSTANCE.flingBehavior(swipeToDismissBoxState.getAnchoredDraggableState$material3(), swipeToDismissBoxState.getPositionalThreshold$material3(), null, composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 4);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z14 = true;
                    composerStartRestartGroup.startReplaceGroup(-869697757);
                    composerStartRestartGroup.endReplaceGroup();
                    targetedFlingBehaviorFlingBehavior = null;
                }
                Modifier modifierAnchoredDraggable$default4 = AnchoredDraggableKt.anchoredDraggable$default(modifier4, anchoredDraggableState$material9, orientation7, z13, null, null, targetedFlingBehaviorFlingBehavior, 24, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1704011422, "C330@13787L71,334@14022L1195,331@13867L1361:SwipeToDismissBox.kt#uh7d8r");
                Modifier modifierMatchParentSize4 = boxScopeInstance4.matchParentSize(Modifier.INSTANCE);
                int i110 = (i3 << 6) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMatchParentSize4);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i110 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion4 = Modifier.INSTANCE;
                AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material10 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                Orientation orientation8 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609150165, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((57344 & i3) == 16384) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                zChangedInstance = z16 | z15 | composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDraggableAnchors4 = DraggableAnchorsKt.draggableAnchors(companion4, anchoredDraggableState$material10, orientation8, (Function2) objRememberedValue);
                int i111 = (i3 >> 12) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDraggableAnchors4);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl3.getInserting()) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i111 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SwipeToDismissBoxValue settledValue4 = swipeToDismissBoxState.getSettledValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387637826, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                if ((3670016 & i3) == 1048576) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = zChangedInstance5 | z17;
                swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z18) {
                    swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                    composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                } else {
                    swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                    composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(settledValue4, function2, (Function2) swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z12;
                z9 = z11;
                modifier3 = modifier4;
                z7 = z10;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$3(swipeToDismissBoxState, function3, modifier3, z7, z9, z8, function2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z4 = z;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z5 = z3;
                } else {
                    z5 = z3;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    function2 = function1;
                } else {
                    function2 = function1;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    z9 = z2;
                } else {
                    if (i13 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z10 = true;
                    } else {
                        z10 = z4;
                    }
                    if (i6 != 0) {
                        z11 = true;
                    } else {
                        z11 = z2;
                    }
                    if (i8 != 0) {
                        z12 = true;
                    } else {
                        z12 = z5;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387565852, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$0$0((SwipeToDismissBoxValue) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        function2 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-741495334, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
                    }
                    AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material11 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                    Orientation orientation9 = Orientation.Horizontal;
                    if (z12) {
                        z13 = false;
                    } else {
                        z13 = false;
                    }
                    if (swipeToDismissBoxState.getUseFlingBehavior$material3()) {
                        composerStartRestartGroup.startReplaceGroup(387580721);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "322@13501L183");
                        z14 = true;
                        targetedFlingBehaviorFlingBehavior = AnchoredDraggableDefaults.INSTANCE.flingBehavior(swipeToDismissBoxState.getAnchoredDraggableState$material3(), swipeToDismissBoxState.getPositionalThreshold$material3(), null, composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 4);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z14 = true;
                        composerStartRestartGroup.startReplaceGroup(-869697757);
                        composerStartRestartGroup.endReplaceGroup();
                        targetedFlingBehaviorFlingBehavior = null;
                    }
                    Modifier modifierAnchoredDraggable$default5 = AnchoredDraggableKt.anchoredDraggable$default(modifier4, anchoredDraggableState$material11, orientation9, z13, null, null, targetedFlingBehaviorFlingBehavior, 24, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default5);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1704011422, "C330@13787L71,334@14022L1195,331@13867L1361:SwipeToDismissBox.kt#uh7d8r");
                    Modifier modifierMatchParentSize5 = boxScopeInstance5.matchParentSize(Modifier.INSTANCE);
                    int i112 = (i3 << 6) & 7168;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy9 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMatchParentSize5);
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
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting()) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i112 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier.Companion companion5 = Modifier.INSTANCE;
                    AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material12 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                    Orientation orientation10 = Orientation.Horizontal;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609150165, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if ((57344 & i3) == 16384) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    zChangedInstance = z16 | z15 | composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDraggableAnchors5 = DraggableAnchorsKt.draggableAnchors(companion5, anchoredDraggableState$material12, orientation10, (Function2) objRememberedValue);
                    int i113 = (i3 >> 12) & 7168;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy10 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDraggableAnchors5);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl3.getInserting()) {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i113 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SwipeToDismissBoxValue settledValue5 = swipeToDismissBoxState.getSettledValue();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387637826, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    boolean zChangedInstance6 = composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                    if ((3670016 & i3) == 1048576) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    z18 = zChangedInstance6 | z17;
                    swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z18) {
                        swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                        composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                    } else {
                        swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                        composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(settledValue5, function2, (Function2) swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 112);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z12;
                    z9 = z11;
                    modifier3 = modifier4;
                    z7 = z10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$3(swipeToDismissBoxState, function3, modifier3, z7, z9, z8, function2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z5 = z3;
            } else {
                z5 = z3;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                z9 = z2;
            } else {
                if (i13 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z10 = true;
                } else {
                    z10 = z4;
                }
                if (i6 != 0) {
                    z11 = true;
                } else {
                    z11 = z2;
                }
                if (i8 != 0) {
                    z12 = true;
                } else {
                    z12 = z5;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387565852, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$0$0((SwipeToDismissBoxValue) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function2 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-741495334, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
                }
                AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material13 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                Orientation orientation11 = Orientation.Horizontal;
                if (z12) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                if (swipeToDismissBoxState.getUseFlingBehavior$material3()) {
                    composerStartRestartGroup.startReplaceGroup(387580721);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "322@13501L183");
                    z14 = true;
                    targetedFlingBehaviorFlingBehavior = AnchoredDraggableDefaults.INSTANCE.flingBehavior(swipeToDismissBoxState.getAnchoredDraggableState$material3(), swipeToDismissBoxState.getPositionalThreshold$material3(), null, composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 4);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z14 = true;
                    composerStartRestartGroup.startReplaceGroup(-869697757);
                    composerStartRestartGroup.endReplaceGroup();
                    targetedFlingBehaviorFlingBehavior = null;
                }
                Modifier modifierAnchoredDraggable$default6 = AnchoredDraggableKt.anchoredDraggable$default(modifier4, anchoredDraggableState$material13, orientation11, z13, null, null, targetedFlingBehaviorFlingBehavior, 24, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default6);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1704011422, "C330@13787L71,334@14022L1195,331@13867L1361:SwipeToDismissBox.kt#uh7d8r");
                Modifier modifierMatchParentSize6 = boxScopeInstance6.matchParentSize(Modifier.INSTANCE);
                int i114 = (i3 << 6) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy11 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMatchParentSize6);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i114 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion6 = Modifier.INSTANCE;
                AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material14 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                Orientation orientation12 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609150165, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((57344 & i3) == 16384) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                zChangedInstance = z16 | z15 | composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDraggableAnchors6 = DraggableAnchorsKt.draggableAnchors(companion6, anchoredDraggableState$material14, orientation12, (Function2) objRememberedValue);
                int i115 = (i3 >> 12) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy12 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDraggableAnchors6);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl3.getInserting()) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i115 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SwipeToDismissBoxValue settledValue6 = swipeToDismissBoxState.getSettledValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387637826, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                if ((3670016 & i3) == 1048576) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = zChangedInstance7 | z17;
                swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z18) {
                    swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                    composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                } else {
                    swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                    composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(settledValue6, function2, (Function2) swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z12;
                z9 = z11;
                modifier3 = modifier4;
                z7 = z10;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$3(swipeToDismissBoxState, function3, modifier3, z7, z9, z8, function2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z5 = z3;
            } else {
                z5 = z3;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                z9 = z2;
            } else {
                if (i13 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z10 = true;
                } else {
                    z10 = z4;
                }
                if (i6 != 0) {
                    z11 = true;
                } else {
                    z11 = z2;
                }
                if (i8 != 0) {
                    z12 = true;
                } else {
                    z12 = z5;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387565852, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$0$0((SwipeToDismissBoxValue) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function2 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-741495334, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
                }
                AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material15 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                Orientation orientation13 = Orientation.Horizontal;
                if (z12) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                if (swipeToDismissBoxState.getUseFlingBehavior$material3()) {
                    composerStartRestartGroup.startReplaceGroup(387580721);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "322@13501L183");
                    z14 = true;
                    targetedFlingBehaviorFlingBehavior = AnchoredDraggableDefaults.INSTANCE.flingBehavior(swipeToDismissBoxState.getAnchoredDraggableState$material3(), swipeToDismissBoxState.getPositionalThreshold$material3(), null, composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 4);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z14 = true;
                    composerStartRestartGroup.startReplaceGroup(-869697757);
                    composerStartRestartGroup.endReplaceGroup();
                    targetedFlingBehaviorFlingBehavior = null;
                }
                Modifier modifierAnchoredDraggable$default7 = AnchoredDraggableKt.anchoredDraggable$default(modifier4, anchoredDraggableState$material15, orientation13, z13, null, null, targetedFlingBehaviorFlingBehavior, 24, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default7);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1704011422, "C330@13787L71,334@14022L1195,331@13867L1361:SwipeToDismissBox.kt#uh7d8r");
                Modifier modifierMatchParentSize7 = boxScopeInstance7.matchParentSize(Modifier.INSTANCE);
                int i116 = (i3 << 6) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy13 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMatchParentSize7);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i116 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier.Companion companion7 = Modifier.INSTANCE;
                AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material16 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
                Orientation orientation14 = Orientation.Horizontal;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609150165, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                if ((57344 & i3) == 16384) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                zChangedInstance = z16 | z15 | composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDraggableAnchors7 = DraggableAnchorsKt.draggableAnchors(companion7, anchoredDraggableState$material16, orientation14, (Function2) objRememberedValue);
                int i117 = (i3 >> 12) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy14 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDraggableAnchors7);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl3.getInserting()) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i117 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SwipeToDismissBoxValue settledValue7 = swipeToDismissBoxState.getSettledValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387637826, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                boolean zChangedInstance8 = composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
                if ((3670016 & i3) == 1048576) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                z18 = zChangedInstance8 | z17;
                swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z18) {
                    swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                    composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                } else {
                    swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                    composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(settledValue7, function2, (Function2) swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 112);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z12;
                z9 = z11;
                modifier3 = modifier4;
                z7 = z10;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$3(swipeToDismissBoxState, function3, modifier3, z7, z9, z8, function2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        i8 = i2 & 32;
        if (i8 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z5 = z3;
        } else {
            z5 = z3;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z5)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
        }
        i10 = i2 & 64;
        if (i10 != 0) {
            i3 |= 1572864;
            function2 = function1;
        } else {
            function2 = function1;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i3 |= i12;
        }
        if ((i3 & 4793491) != 4793490) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z7 = z4;
            z8 = z5;
            z9 = z2;
        } else {
            if (i13 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                z10 = true;
            } else {
                z10 = z4;
            }
            if (i6 != 0) {
                z11 = true;
            } else {
                z11 = z2;
            }
            if (i8 != 0) {
                z12 = true;
            } else {
                z12 = z5;
            }
            if (i10 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387565852, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$0$0((SwipeToDismissBoxValue) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function2 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-741495334, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:313)");
            }
            AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material17 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
            Orientation orientation15 = Orientation.Horizontal;
            if (z12) {
                z13 = false;
            } else {
                z13 = false;
            }
            if (swipeToDismissBoxState.getUseFlingBehavior$material3()) {
                composerStartRestartGroup.startReplaceGroup(387580721);
                ComposerKt.sourceInformation(composerStartRestartGroup, "322@13501L183");
                z14 = true;
                targetedFlingBehaviorFlingBehavior = AnchoredDraggableDefaults.INSTANCE.flingBehavior(swipeToDismissBoxState.getAnchoredDraggableState$material3(), swipeToDismissBoxState.getPositionalThreshold$material3(), null, composerStartRestartGroup, AnchoredDraggableDefaults.$stable << 9, 4);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                z14 = true;
                composerStartRestartGroup.startReplaceGroup(-869697757);
                composerStartRestartGroup.endReplaceGroup();
                targetedFlingBehaviorFlingBehavior = null;
            }
            Modifier modifierAnchoredDraggable$default8 = AnchoredDraggableKt.anchoredDraggable$default(modifier4, anchoredDraggableState$material17, orientation15, z13, null, null, targetedFlingBehaviorFlingBehavior, 24, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default8);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1704011422, "C330@13787L71,334@14022L1195,331@13867L1361:SwipeToDismissBox.kt#uh7d8r");
            Modifier modifierMatchParentSize8 = boxScopeInstance8.matchParentSize(Modifier.INSTANCE);
            int i118 = (i3 << 6) & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy15 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierMatchParentSize8);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl2.getInserting()) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i118 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier.Companion companion8 = Modifier.INSTANCE;
            AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState$material18 = swipeToDismissBoxState.getAnchoredDraggableState$material3();
            Orientation orientation16 = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -609150165, "CC(remember):SwipeToDismissBox.kt#9igjgp");
            if ((i3 & 7168) == 2048) {
                z15 = true;
            } else {
                z15 = false;
            }
            if ((57344 & i3) == 16384) {
                z16 = true;
            } else {
                z16 = false;
            }
            zChangedInstance = z16 | z15 | composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0(swipeToDismissBoxState, z10, z11, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDraggableAnchors8 = DraggableAnchorsKt.draggableAnchors(companion8, anchoredDraggableState$material18, orientation16, (Function2) objRememberedValue);
            int i119 = (i3 >> 12) & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy16 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDraggableAnchors8);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl3.getInserting()) {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            function4.invoke(RowScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i119 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SwipeToDismissBoxValue settledValue8 = swipeToDismissBoxState.getSettledValue();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 387637826, "CC(remember):SwipeToDismissBox.kt#9igjgp");
            boolean zChangedInstance9 = composerStartRestartGroup.changedInstance(swipeToDismissBoxState);
            if ((3670016 & i3) == 1048576) {
                z17 = true;
            } else {
                z17 = false;
            }
            z18 = zChangedInstance9 | z17;
            swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z18) {
                swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
            } else {
                swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue = new SwipeToDismissBoxKt$SwipeToDismissBox$3$1(swipeToDismissBoxState, function2, null);
                composerStartRestartGroup.updateRememberedValue(swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(settledValue8, function2, (Function2) swipeToDismissBoxKt$SwipeToDismissBox$3$1RememberedValue, composerStartRestartGroup, (i3 >> 15) & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z8 = z12;
            z9 = z11;
            modifier3 = modifier4;
            z7 = z10;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$3(swipeToDismissBoxState, function3, modifier3, z7, z9, z8, function2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair SwipeToDismissBox$lambda$1$0$0(SwipeToDismissBoxState swipeToDismissBoxState, final boolean z, final boolean z2, final IntSize intSize, Constraints constraints) {
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$1$0$0$0(intSize, z, z2, (DraggableAnchorsConfig) obj);
            }
        });
        boolean z3 = swipeToDismissBoxState.getAnchoredDraggableState$material3().getAnchors().getSize() > 0;
        SwipeToDismissBoxValue currentValue = swipeToDismissBoxState.getCurrentValue();
        SwipeToDismissBoxValue targetValue = swipeToDismissBoxState.getTargetValue();
        if (z3 || !DraggableAnchors.hasPositionFor(currentValue)) {
            currentValue = DraggableAnchors.hasPositionFor(targetValue) ? targetValue : SwipeToDismissBoxValue.Settled;
        }
        return TuplesKt.to(DraggableAnchors, currentValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDismissBox$lambda$1$0$0$0(IntSize intSize, boolean z, boolean z2, DraggableAnchorsConfig draggableAnchorsConfig) {
        float fM9862unboximpl = (int) (intSize.m9862unboximpl() >> 32);
        draggableAnchorsConfig.at(SwipeToDismissBoxValue.Settled, 0.0f);
        if (z) {
            draggableAnchorsConfig.at(SwipeToDismissBoxValue.StartToEnd, fM9862unboximpl);
        }
        if (z2) {
            draggableAnchorsConfig.at(SwipeToDismissBoxValue.EndToStart, -fM9862unboximpl);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x016a  */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:55:0x0093  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00de  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:93:0x0117  */
    /* JADX WARN: Code duplicated, block: B:96:0x0151  */
    /* JADX WARN: Code duplicated, block: B:98:0x0159  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use updated signature with onDismissed parameter.")
    public static final /* synthetic */ void SwipeToDismissBox(final SwipeToDismissBoxState swipeToDismissBoxState, final Function3 function3, Modifier modifier, boolean z, boolean z2, boolean z3, final Function3 function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Function3 function5;
        boolean z5;
        Composer composer2;
        final boolean z6;
        final Modifier modifier3;
        final boolean z7;
        final boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z9;
        boolean z10;
        boolean z11;
        Object objRememberedValue;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1807005299);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwipeToDismissBox)N(state,backgroundContent,modifier,enableDismissFromStartToEnd,enableDismissFromEndToStart,gesturesEnabled,content)398@16674L2,391@16359L351:SwipeToDismissBox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(swipeToDismissBoxState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            if (composerStartRestartGroup.changed(z3)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((i & 1572864) == 0) {
                            function5 = function4;
                            if (composerStartRestartGroup.changedInstance(function5)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        } else {
                            function5 = function4;
                        }
                        if ((i3 & 599187) != 599186) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z6 = z2;
                            modifier3 = modifier2;
                            z7 = z4;
                            z8 = z3;
                        } else {
                            if (i11 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                z9 = true;
                            } else {
                                z9 = z4;
                            }
                            if (i6 != 0) {
                                z10 = true;
                            } else {
                                z10 = z2;
                            }
                            if (i8 != 0) {
                                z11 = true;
                            } else {
                                z11 = z3;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z7 = z9;
                            z6 = z10;
                            z8 = z11;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    if ((i & 1572864) == 0) {
                        function5 = function4;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    } else {
                        function5 = function4;
                    }
                    if ((i3 & 599187) != 599186) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z6 = z2;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            z9 = true;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            z10 = true;
                        } else {
                            z10 = z2;
                        }
                        if (i8 != 0) {
                            z11 = true;
                        } else {
                            z11 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z7 = z9;
                        z6 = z10;
                        z8 = z11;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i & 1572864) == 0) {
                        function5 = function4;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    } else {
                        function5 = function4;
                    }
                    if ((i3 & 599187) != 599186) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z6 = z2;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            z9 = true;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            z10 = true;
                        } else {
                            z10 = z2;
                        }
                        if (i8 != 0) {
                            z11 = true;
                        } else {
                            z11 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z7 = z9;
                        z6 = z10;
                        z8 = z11;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((i & 1572864) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                } else {
                    function5 = function4;
                }
                if ((i3 & 599187) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z6 = z2;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z3;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z9 = true;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        z10 = true;
                    } else {
                        z10 = z2;
                    }
                    if (i8 != 0) {
                        z11 = true;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z7 = z9;
                    z6 = z10;
                    z8 = z11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i & 1572864) == 0) {
                        function5 = function4;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    } else {
                        function5 = function4;
                    }
                    if ((i3 & 599187) != 599186) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z6 = z2;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            z9 = true;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            z10 = true;
                        } else {
                            z10 = z2;
                        }
                        if (i8 != 0) {
                            z11 = true;
                        } else {
                            z11 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z7 = z9;
                        z6 = z10;
                        z8 = z11;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((i & 1572864) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                } else {
                    function5 = function4;
                }
                if ((i3 & 599187) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z6 = z2;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z3;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z9 = true;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        z10 = true;
                    } else {
                        z10 = z2;
                    }
                    if (i8 != 0) {
                        z11 = true;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z7 = z9;
                    z6 = z10;
                    z8 = z11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i & 1572864) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                } else {
                    function5 = function4;
                }
                if ((i3 & 599187) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z6 = z2;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z3;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z9 = true;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        z10 = true;
                    } else {
                        z10 = z2;
                    }
                    if (i8 != 0) {
                        z11 = true;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z7 = z9;
                    z6 = z10;
                    z8 = z11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i & 1572864) == 0) {
                function5 = function4;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            } else {
                function5 = function4;
            }
            if ((i3 & 599187) != 599186) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z6 = z2;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z3;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z9 = true;
                } else {
                    z9 = z4;
                }
                if (i6 != 0) {
                    z10 = true;
                } else {
                    z10 = z2;
                }
                if (i8 != 0) {
                    z11 = true;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z7 = z9;
                z6 = z10;
                z8 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z4 = z;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((i & 1572864) == 0) {
                        function5 = function4;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    } else {
                        function5 = function4;
                    }
                    if ((i3 & 599187) != 599186) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z6 = z2;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z3;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            z9 = true;
                        } else {
                            z9 = z4;
                        }
                        if (i6 != 0) {
                            z10 = true;
                        } else {
                            z10 = z2;
                        }
                        if (i8 != 0) {
                            z11 = true;
                        } else {
                            z11 = z3;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z7 = z9;
                        z6 = z10;
                        z8 = z11;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((i & 1572864) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                } else {
                    function5 = function4;
                }
                if ((i3 & 599187) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z6 = z2;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z3;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z9 = true;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        z10 = true;
                    } else {
                        z10 = z2;
                    }
                    if (i8 != 0) {
                        z11 = true;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z7 = z9;
                    z6 = z10;
                    z8 = z11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i & 1572864) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                } else {
                    function5 = function4;
                }
                if ((i3 & 599187) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z6 = z2;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z3;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z9 = true;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        z10 = true;
                    } else {
                        z10 = z2;
                    }
                    if (i8 != 0) {
                        z11 = true;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z7 = z9;
                    z6 = z10;
                    z8 = z11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i & 1572864) == 0) {
                function5 = function4;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            } else {
                function5 = function4;
            }
            if ((i3 & 599187) != 599186) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z6 = z2;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z3;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z9 = true;
                } else {
                    z9 = z4;
                }
                if (i6 != 0) {
                    z10 = true;
                } else {
                    z10 = z2;
                }
                if (i8 != 0) {
                    z11 = true;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z7 = z9;
                z6 = z10;
                z8 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i & 1572864) == 0) {
                    function5 = function4;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                } else {
                    function5 = function4;
                }
                if ((i3 & 599187) != 599186) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z6 = z2;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z3;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        z9 = true;
                    } else {
                        z9 = z4;
                    }
                    if (i6 != 0) {
                        z10 = true;
                    } else {
                        z10 = z2;
                    }
                    if (i8 != 0) {
                        z11 = true;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z7 = z9;
                    z6 = z10;
                    z8 = z11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((i & 1572864) == 0) {
                function5 = function4;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            } else {
                function5 = function4;
            }
            if ((i3 & 599187) != 599186) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z6 = z2;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z3;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z9 = true;
                } else {
                    z9 = z4;
                }
                if (i6 != 0) {
                    z10 = true;
                } else {
                    z10 = z2;
                }
                if (i8 != 0) {
                    z11 = true;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z7 = z9;
                z6 = z10;
                z8 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((i & 1572864) == 0) {
                function5 = function4;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            } else {
                function5 = function4;
            }
            if ((i3 & 599187) != 599186) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z6 = z2;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z3;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    z9 = true;
                } else {
                    z9 = z4;
                }
                if (i6 != 0) {
                    z10 = true;
                } else {
                    z10 = z2;
                }
                if (i8 != 0) {
                    z11 = true;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z7 = z9;
                z6 = z10;
                z8 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((i & 1572864) == 0) {
            function5 = function4;
            if (composerStartRestartGroup.changedInstance(function5)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        } else {
            function5 = function4;
        }
        if ((i3 & 599187) != 599186) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z6 = z2;
            modifier3 = modifier2;
            z7 = z4;
            z8 = z3;
        } else {
            if (i11 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                z9 = true;
            } else {
                z9 = z4;
            }
            if (i6 != 0) {
                z10 = true;
            } else {
                z10 = z2;
            }
            if (i8 != 0) {
                z11 = true;
            } else {
                z11 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1807005299, i3, -1, "androidx.compose.material3.SwipeToDismissBox (SwipeToDismissBox.kt:391)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1365283857, "CC(remember):SwipeToDismissBox.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$4$0((SwipeToDismissBoxValue) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            SwipeToDismissBox(swipeToDismissBoxState, function3, modifier4, z9, z10, z11, (Function1) objRememberedValue, function5, composer2, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | ((i3 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z7 = z9;
            z6 = z10;
            z8 = z11;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SwipeToDismissBoxKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwipeToDismissBoxKt.SwipeToDismissBox$lambda$5(swipeToDismissBoxState, function3, modifier3, z7, z6, z8, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDismissBox$lambda$4$0(SwipeToDismissBoxValue swipeToDismissBoxValue) {
        return Unit.INSTANCE;
    }
}
