package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: BasicTooltip.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u0014\u001aP\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0018\u001a^\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\n*\u00020\n2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a,\u0010\u001f\u001a\u00020\n*\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001aH\u0010\"\u001a\u00020\n*\u00020\n2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u0002\u001a+\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\u0010)\u001a&\u0010*\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020(H\u0001\u001a\u0013\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0,H\u0003¢\u0006\u0002\u0010-\"\u0018\u0010.\u001a\u00020\r*\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0018\u00102\u001a\u00020\r*\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00101¨\u00064"}, d2 = {"BasicTooltipBox", "", "positionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "tooltip", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "state", "Landroidx/compose/material3/TooltipState;", "modifier", "Landroidx/compose/ui/Modifier;", "onDismissRequest", "focusable", "", "enableUserInput", "hasAction", "content", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TooltipState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "shouldForceFocusableForA11y", "forceFocusableForKeyboardNav", "(ZLandroidx/compose/runtime/Composer;I)Z", "WrappedAnchor", "forceKeyboardFocusable", "Landroidx/compose/runtime/MutableState;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/runtime/MutableState;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TooltipPopup", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Landroidx/compose/material3/TooltipState;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineScope;ZLandroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "handleGestures", "enabled", "anchorSemantics", "label", "", "keyboardBehavior", "receivedKeyboardFocus", "rememberBasicTooltipState", "initialIsVisible", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TooltipState;", "BasicTooltipState", "rememberTouchExplorationOrSwitchAccessServiceState", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isTab", "Landroidx/compose/ui/input/key/KeyEvent;", "isTab-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEscape", "isEscape-ZmokQxo", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicTooltipKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTooltipBox$lambda$3(PopupPositionProvider popupPositionProvider, Function2 function2, TooltipState tooltipState, Modifier modifier, Function0 function0, boolean z, boolean z2, boolean z3, Function2 function3, int i, int i2, Composer composer, int i3) {
        BasicTooltipBox(popupPositionProvider, function2, tooltipState, modifier, function0, z, z2, z3, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipPopup$lambda$2(PopupPositionProvider popupPositionProvider, TooltipState tooltipState, Function0 function0, CoroutineScope coroutineScope, boolean z, MutableState mutableState, Function2 function2, int i, Composer composer, int i2) {
        TooltipPopup(popupPositionProvider, tooltipState, function0, coroutineScope, z, mutableState, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrappedAnchor$lambda$2(boolean z, TooltipState tooltipState, MutableState mutableState, boolean z2, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        WrappedAnchor(z, tooltipState, mutableState, z2, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012c  */
    /* JADX WARN: Code duplicated, block: B:103:0x012f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0132  */
    /* JADX WARN: Code duplicated, block: B:106:0x0136  */
    /* JADX WARN: Code duplicated, block: B:107:0x0138  */
    /* JADX WARN: Code duplicated, block: B:110:0x0140  */
    /* JADX WARN: Code duplicated, block: B:113:0x0166  */
    /* JADX WARN: Code duplicated, block: B:116:0x018e  */
    /* JADX WARN: Code duplicated, block: B:119:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:120:0x01be  */
    /* JADX WARN: Code duplicated, block: B:123:0x0211  */
    /* JADX WARN: Code duplicated, block: B:126:0x021d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0221  */
    /* JADX WARN: Code duplicated, block: B:130:0x0246  */
    /* JADX WARN: Code duplicated, block: B:132:0x0254  */
    /* JADX WARN: Code duplicated, block: B:135:0x0285  */
    /* JADX WARN: Code duplicated, block: B:137:0x0292 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:140:0x0298  */
    /* JADX WARN: Code duplicated, block: B:142:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:145:0x0315  */
    /* JADX WARN: Code duplicated, block: B:153:0x0328  */
    /* JADX WARN: Code duplicated, block: B:155:0x0330  */
    /* JADX WARN: Code duplicated, block: B:158:0x034a  */
    /* JADX WARN: Code duplicated, block: B:160:0x0352  */
    /* JADX WARN: Code duplicated, block: B:163:0x0365  */
    /* JADX WARN: Code duplicated, block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x009a  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x010d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0110  */
    /* JADX WARN: Code duplicated, block: B:93:0x0119 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:94:0x011b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0122  */
    /* JADX WARN: Code duplicated, block: B:98:0x0127  */
    /* JADX WARN: Code duplicated, block: B:99:0x0129  */
    public static final void BasicTooltipBox(final PopupPositionProvider popupPositionProvider, final Function2<? super Composer, ? super Integer, Unit> function2, TooltipState tooltipState, Modifier modifier, Function0<Unit> function0, boolean z, boolean z2, boolean z3, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Modifier modifier2;
        int i4;
        Function0<Unit> function1;
        int i5;
        int i6;
        int i7;
        boolean z4;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z5;
        boolean z6;
        final TooltipState tooltipState2;
        final boolean z7;
        final Modifier modifier3;
        final Function0<Unit> function5;
        final boolean z8;
        final boolean z9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function0<Unit> function6;
        boolean z10;
        boolean z11;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        Object objRememberedValue2;
        MutableState mutableState;
        boolean zShouldForceFocusableForA11y;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Function0<Unit> function7;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        MutableState mutableState2;
        Object objRememberedValue3;
        boolean z12;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1221877520);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicTooltipBox)N(positionProvider,tooltip,state,modifier,onDismissRequest,focusable,enableUserInput,hasAction,content)106@5031L24,107@5095L34,112@5359L710,135@6099L35,135@6075L59:BasicTooltip.kt#mqatfk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            function4 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 32 : 16;
        } else {
            function4 = function2;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 256 : 128;
        }
        int i14 = i2 & 8;
        if (i14 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i7 = 196608;
                    z4 = z;
                } else {
                    i7 = 196608;
                    z4 = z;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(z4)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i3 |= i8;
                    }
                }
                i9 = i2 & 64;
                if (i9 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                i11 = i2 & 128;
                if (i11 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                z5 = true;
                if ((i3 & 38347923) != 38347922) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                    tooltipState2 = tooltipState;
                    composerStartRestartGroup.skipToGroupEnd();
                    z7 = z2;
                    modifier3 = modifier2;
                    function5 = function1;
                    z8 = z3;
                } else {
                    if (i14 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function1;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    }
                    if (i9 != 0) {
                        z10 = true;
                    } else {
                        z10 = z2;
                    }
                    if (i11 != 0) {
                        z11 = false;
                    } else {
                        z11 = z3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1221877520, i3, -1, "androidx.compose.material3.internal.BasicTooltipBox (BasicTooltip.kt:105)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698211150, "CC(remember):BasicTooltip.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z11) {
                        composerStartRestartGroup.startReplaceGroup(-1698204881);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "110@5290L63");
                        zShouldForceFocusableForA11y = shouldForceFocusableForA11y(((Boolean) mutableState.getValue()).booleanValue(), composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1104742522);
                        composerStartRestartGroup.endReplaceGroup();
                        zShouldForceFocusableForA11y = false;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    boolean z13 = zShouldForceFocusableForA11y;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function7 = function6;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1891254757, "C125@5799L264:BasicTooltip.kt#mqatfk");
                    if (tooltipState.getIsVisible()) {
                        mutableState2 = mutableState;
                        composerStartRestartGroup.startReplaceGroup(-1896607156);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1891243071);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "114@5408L371");
                        if (!z4 || z13) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function8 = function4;
                        mutableState2 = mutableState;
                        TooltipPopup(popupPositionProvider, tooltipState, function7, coroutineScope, z12, mutableState2, function8, composerStartRestartGroup, (i3 & 14) | i7 | ((i3 >> 3) & 112) | ((i3 >> 6) & 896) | ((i3 << 15) & 3670016));
                        composerStartRestartGroup = composerStartRestartGroup;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i15 = ((i3 >> 18) & 14) | 384 | ((i3 >> 3) & 112) | ((i3 >> 12) & 7168) | ((i3 << 3) & 57344) | ((i3 >> 9) & 458752);
                    tooltipState2 = tooltipState;
                    boolean z14 = z10;
                    boolean z15 = z11;
                    modifier3 = modifier4;
                    WrappedAnchor(z14, tooltipState2, mutableState2, z15, modifier3, function3, composerStartRestartGroup, i15, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698179021, "CC(remember):BasicTooltip.kt#9igjgp");
                    if ((i3 & 896) != 256 && ((i3 & 512) == 0 || !composerStartRestartGroup.changedInstance(tooltipState2))) {
                        z5 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BasicTooltipKt.BasicTooltipBox$lambda$2$0(tooltipState2, (DisposableEffectScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.DisposableEffect(tooltipState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, (i3 >> 6) & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z7 = z14;
                    z8 = z15;
                    function5 = function7;
                }
                Composer composer2 = composerStartRestartGroup;
                z9 = z4;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final TooltipState tooltipState3 = tooltipState2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BasicTooltipKt.BasicTooltipBox$lambda$3(popupPositionProvider, function2, tooltipState3, modifier3, function5, z9, z7, z8, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function1 = function0;
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i7 = 196608;
                z4 = z;
            } else {
                i7 = 196608;
                z4 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
            }
            i9 = i2 & 64;
            if (i9 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            i11 = i2 & 128;
            if (i11 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            z5 = true;
            if ((i3 & 38347923) != 38347922) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                tooltipState2 = tooltipState;
                composerStartRestartGroup.skipToGroupEnd();
                z7 = z2;
                modifier3 = modifier2;
                function5 = function1;
                z8 = z3;
            } else {
                if (i14 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function1;
                }
                if (i6 != 0) {
                    z4 = false;
                }
                if (i9 != 0) {
                    z10 = true;
                } else {
                    z10 = z2;
                }
                if (i11 != 0) {
                    z11 = false;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1221877520, i3, -1, "androidx.compose.material3.internal.BasicTooltipBox (BasicTooltip.kt:105)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698211150, "CC(remember):BasicTooltip.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z11) {
                    composerStartRestartGroup.startReplaceGroup(-1698204881);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "110@5290L63");
                    zShouldForceFocusableForA11y = shouldForceFocusableForA11y(((Boolean) mutableState.getValue()).booleanValue(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1104742522);
                    composerStartRestartGroup.endReplaceGroup();
                    zShouldForceFocusableForA11y = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                boolean z16 = zShouldForceFocusableForA11y;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function7 = function6;
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
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1891254757, "C125@5799L264:BasicTooltip.kt#mqatfk");
                if (tooltipState.getIsVisible()) {
                    mutableState2 = mutableState;
                    composerStartRestartGroup.startReplaceGroup(-1896607156);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1891243071);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@5408L371");
                    if (z4) {
                        z12 = true;
                    } else {
                        z12 = true;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function9 = function4;
                    mutableState2 = mutableState;
                    TooltipPopup(popupPositionProvider, tooltipState, function7, coroutineScope, z12, mutableState2, function9, composerStartRestartGroup, (i3 & 14) | i7 | ((i3 >> 3) & 112) | ((i3 >> 6) & 896) | ((i3 << 15) & 3670016));
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                composerStartRestartGroup.endReplaceGroup();
                int i16 = ((i3 >> 18) & 14) | 384 | ((i3 >> 3) & 112) | ((i3 >> 12) & 7168) | ((i3 << 3) & 57344) | ((i3 >> 9) & 458752);
                tooltipState2 = tooltipState;
                boolean z17 = z10;
                boolean z18 = z11;
                modifier3 = modifier4;
                WrappedAnchor(z17, tooltipState2, mutableState2, z18, modifier3, function3, composerStartRestartGroup, i16, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698179021, "CC(remember):BasicTooltip.kt#9igjgp");
                if ((i3 & 896) != 256) {
                    z5 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BasicTooltipKt.BasicTooltipBox$lambda$2$0(tooltipState2, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BasicTooltipKt.BasicTooltipBox$lambda$2$0(tooltipState2, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(tooltipState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, (i3 >> 6) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z17;
                z8 = z18;
                function5 = function7;
            }
            Composer composer3 = composerStartRestartGroup;
            z9 = z4;
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final TooltipState tooltipState4 = tooltipState2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BasicTooltipKt.BasicTooltipBox$lambda$3(popupPositionProvider, function2, tooltipState4, modifier3, function5, z9, z7, z8, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i7 = 196608;
                z4 = z;
            } else {
                i7 = 196608;
                z4 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(z4)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
            }
            i9 = i2 & 64;
            if (i9 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            i11 = i2 & 128;
            if (i11 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            z5 = true;
            if ((i3 & 38347923) != 38347922) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
                tooltipState2 = tooltipState;
                composerStartRestartGroup.skipToGroupEnd();
                z7 = z2;
                modifier3 = modifier2;
                function5 = function1;
                z8 = z3;
            } else {
                if (i14 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function1;
                }
                if (i6 != 0) {
                    z4 = false;
                }
                if (i9 != 0) {
                    z10 = true;
                } else {
                    z10 = z2;
                }
                if (i11 != 0) {
                    z11 = false;
                } else {
                    z11 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1221877520, i3, -1, "androidx.compose.material3.internal.BasicTooltipBox (BasicTooltip.kt:105)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698211150, "CC(remember):BasicTooltip.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z11) {
                    composerStartRestartGroup.startReplaceGroup(-1698204881);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "110@5290L63");
                    zShouldForceFocusableForA11y = shouldForceFocusableForA11y(((Boolean) mutableState.getValue()).booleanValue(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1104742522);
                    composerStartRestartGroup.endReplaceGroup();
                    zShouldForceFocusableForA11y = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion3 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                boolean z19 = zShouldForceFocusableForA11y;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function7 = function6;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1891254757, "C125@5799L264:BasicTooltip.kt#mqatfk");
                if (tooltipState.getIsVisible()) {
                    mutableState2 = mutableState;
                    composerStartRestartGroup.startReplaceGroup(-1896607156);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1891243071);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@5408L371");
                    if (z4) {
                        z12 = true;
                    } else {
                        z12 = true;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function10 = function4;
                    mutableState2 = mutableState;
                    TooltipPopup(popupPositionProvider, tooltipState, function7, coroutineScope, z12, mutableState2, function10, composerStartRestartGroup, (i3 & 14) | i7 | ((i3 >> 3) & 112) | ((i3 >> 6) & 896) | ((i3 << 15) & 3670016));
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                composerStartRestartGroup.endReplaceGroup();
                int i17 = ((i3 >> 18) & 14) | 384 | ((i3 >> 3) & 112) | ((i3 >> 12) & 7168) | ((i3 << 3) & 57344) | ((i3 >> 9) & 458752);
                tooltipState2 = tooltipState;
                boolean z110 = z10;
                boolean z111 = z11;
                modifier3 = modifier4;
                WrappedAnchor(z110, tooltipState2, mutableState2, z111, modifier3, function3, composerStartRestartGroup, i17, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698179021, "CC(remember):BasicTooltip.kt#9igjgp");
                if ((i3 & 896) != 256) {
                    z5 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BasicTooltipKt.BasicTooltipBox$lambda$2$0(tooltipState2, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BasicTooltipKt.BasicTooltipBox$lambda$2$0(tooltipState2, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(tooltipState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, (i3 >> 6) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z110;
                z8 = z111;
                function5 = function7;
            }
            Composer composer4 = composerStartRestartGroup;
            z9 = z4;
            scopeUpdateScopeEndRestartGroup = composer4.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final TooltipState tooltipState5 = tooltipState2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BasicTooltipKt.BasicTooltipBox$lambda$3(popupPositionProvider, function2, tooltipState5, modifier3, function5, z9, z7, z8, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function1 = function0;
        i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i7 = 196608;
            z4 = z;
        } else {
            i7 = 196608;
            z4 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
        }
        i9 = i2 & 64;
        if (i9 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        i11 = i2 & 128;
        if (i11 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i3 |= i12;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i3 |= i13;
        }
        z5 = true;
        if ((i3 & 38347923) != 38347922) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i3 & 1)) {
            tooltipState2 = tooltipState;
            composerStartRestartGroup.skipToGroupEnd();
            z7 = z2;
            modifier3 = modifier2;
            function5 = function1;
            z8 = z3;
        } else {
            if (i14 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                function6 = null;
            } else {
                function6 = function1;
            }
            if (i6 != 0) {
                z4 = false;
            }
            if (i9 != 0) {
                z10 = true;
            } else {
                z10 = z2;
            }
            if (i11 != 0) {
                z11 = false;
            } else {
                z11 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1221877520, i3, -1, "androidx.compose.material3.internal.BasicTooltipBox (BasicTooltip.kt:105)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698211150, "CC(remember):BasicTooltip.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z11) {
                composerStartRestartGroup.startReplaceGroup(-1698204881);
                ComposerKt.sourceInformation(composerStartRestartGroup, "110@5290L63");
                zShouldForceFocusableForA11y = shouldForceFocusableForA11y(((Boolean) mutableState.getValue()).booleanValue(), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1104742522);
                composerStartRestartGroup.endReplaceGroup();
                zShouldForceFocusableForA11y = false;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion4 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            boolean z112 = zShouldForceFocusableForA11y;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            function7 = function6;
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
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1891254757, "C125@5799L264:BasicTooltip.kt#mqatfk");
            if (tooltipState.getIsVisible()) {
                mutableState2 = mutableState;
                composerStartRestartGroup.startReplaceGroup(-1896607156);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1891243071);
                ComposerKt.sourceInformation(composerStartRestartGroup, "114@5408L371");
                if (z4) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                Function2<? super Composer, ? super Integer, Unit> function11 = function4;
                mutableState2 = mutableState;
                TooltipPopup(popupPositionProvider, tooltipState, function7, coroutineScope, z12, mutableState2, function11, composerStartRestartGroup, (i3 & 14) | i7 | ((i3 >> 3) & 112) | ((i3 >> 6) & 896) | ((i3 << 15) & 3670016));
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceGroup();
            int i18 = ((i3 >> 18) & 14) | 384 | ((i3 >> 3) & 112) | ((i3 >> 12) & 7168) | ((i3 << 3) & 57344) | ((i3 >> 9) & 458752);
            tooltipState2 = tooltipState;
            boolean z113 = z10;
            boolean z114 = z11;
            modifier3 = modifier4;
            WrappedAnchor(z113, tooltipState2, mutableState2, z114, modifier3, function3, composerStartRestartGroup, i18, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1698179021, "CC(remember):BasicTooltip.kt#9igjgp");
            if ((i3 & 896) != 256) {
                z5 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BasicTooltipKt.BasicTooltipBox$lambda$2$0(tooltipState2, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BasicTooltipKt.BasicTooltipBox$lambda$2$0(tooltipState2, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(tooltipState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, (i3 >> 6) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z7 = z113;
            z8 = z114;
            function5 = function7;
        }
        Composer composer5 = composerStartRestartGroup;
        z9 = z4;
        scopeUpdateScopeEndRestartGroup = composer5.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final TooltipState tooltipState6 = tooltipState2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTooltipKt.BasicTooltipBox$lambda$3(popupPositionProvider, function2, tooltipState6, modifier3, function5, z9, z7, z8, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean shouldForceFocusableForA11y(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -935001672, "C(shouldForceFocusableForA11y)N(forceFocusableForKeyboardNav)140@6269L52:BasicTooltip.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-935001672, i, -1, "androidx.compose.material3.internal.shouldForceFocusableForA11y (BasicTooltip.kt:139)");
        }
        boolean z2 = rememberTouchExplorationOrSwitchAccessServiceState(composer, 0).getValue().booleanValue() || z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return z2;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x008d  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:69:0x0104  */
    /* JADX WARN: Code duplicated, block: B:72:0x0161  */
    /* JADX WARN: Code duplicated, block: B:75:0x016d  */
    /* JADX WARN: Code duplicated, block: B:76:0x0171  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:88:0x0200  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    private static final void WrappedAnchor(final boolean z, final TooltipState tooltipState, final MutableState<Boolean> mutableState, final boolean z2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        Modifier modifier2;
        int i4;
        boolean z4;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue;
        Object objRememberedValue2;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1873232064);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WrappedAnchor)N(enableUserInput,state,forceKeyboardFocusable,hasAction,modifier,content)153@6654L24,154@6724L7,155@6764L34,156@6803L474:BasicTooltip.kt#mqatfk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(mutableState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z3 = z2;
            i3 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
        } else {
            z3 = z2;
        }
        int i6 = i2 & 16;
        if (i6 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            i4 = i3;
            if ((74899 & i4) != 74898) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1873232064, i4, -1, "androidx.compose.material3.internal.WrappedAnchor (BasicTooltip.kt:152)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String strLabel = BasicTooltipStrings.INSTANCE.label(composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 584727746, "CC(remember):BasicTooltip.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierKeyboardBehavior = keyboardBehavior(anchorSemantics(handleGestures(modifier2, z, tooltipState), strLabel, z, tooltipState, coroutineScope), z, tooltipState, coroutineScope, z3, mutableState, (MutableState) objRememberedValue2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierKeyboardBehavior);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 918653216, "C170@7262L9:BasicTooltip.kt#mqatfk");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 15) & 14));
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
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BasicTooltipKt.WrappedAnchor$lambda$2(z, tooltipState, mutableState, z2, modifier3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i5 = 131072;
            } else {
                i5 = 65536;
            }
            i3 |= i5;
        }
        i4 = i3;
        if ((74899 & i4) != 74898) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i6 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1873232064, i4, -1, "androidx.compose.material3.internal.WrappedAnchor (BasicTooltip.kt:152)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strLabel2 = BasicTooltipStrings.INSTANCE.label(composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 584727746, "CC(remember):BasicTooltip.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierKeyboardBehavior2 = keyboardBehavior(anchorSemantics(handleGestures(modifier2, z, tooltipState), strLabel2, z, tooltipState, coroutineScope2), z, tooltipState, coroutineScope2, z3, mutableState, (MutableState) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierKeyboardBehavior2);
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
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 918653216, "C170@7262L9:BasicTooltip.kt#mqatfk");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 15) & 14));
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
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTooltipKt.WrappedAnchor$lambda$2(z, tooltipState, mutableState, z2, modifier3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void TooltipPopup(final PopupPositionProvider popupPositionProvider, final TooltipState tooltipState, final Function0<Unit> function0, final CoroutineScope coroutineScope, final boolean z, final MutableState<Boolean> mutableState, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1413720282);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TooltipPopup)N(positionProvider,state,onDismissRequest,scope,focusable,forceKeyboardFocusable,content)184@7618L13,187@7720L382,199@8196L251,185@7636L811:BasicTooltip.kt#mqatfk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(popupPositionProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(coroutineScope) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1413720282, i2, -1, "androidx.compose.material3.internal.TooltipPopup (BasicTooltip.kt:183)");
            }
            final String strDescription = BasicTooltipStrings.INSTANCE.description(composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1375511676, "CC(remember):BasicTooltip.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 896) == 256) | ((i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(tooltipState))) | composerStartRestartGroup.changedInstance(coroutineScope) | ((458752 & i2) == 131072);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicTooltipKt.TooltipPopup$lambda$0$0(function0, tooltipState, coroutineScope, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidPopup_androidKt.Popup(popupPositionProvider, (Function0) objRememberedValue, new PopupProperties(z, false, false, false, 6, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1287705660, true, new Function2() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTooltipKt.TooltipPopup$lambda$1(strDescription, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2 & 14) | 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTooltipKt.TooltipPopup$lambda$2(popupPositionProvider, tooltipState, function0, coroutineScope, z, mutableState, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipPopup$lambda$0$0(Function0 function0, TooltipState tooltipState, CoroutineScope coroutineScope, MutableState mutableState) {
        if (function0 == null) {
            if (tooltipState.getIsVisible()) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BasicTooltipKt$TooltipPopup$1$1$1(tooltipState, null), 3, null);
                mutableState.setValue(false);
            }
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TooltipPopup$lambda$1(final String str, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C202@8269L128,200@8206L235:BasicTooltip.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1287705660, i, -1, "androidx.compose.material3.internal.TooltipPopup.<anonymous> (BasicTooltip.kt:200)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -534555548, "CC(remember):BasicTooltip.kt#9igjgp");
            boolean zChanged = composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BasicTooltipKt.TooltipPopup$lambda$1$0$0(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1518074908, "C207@8422L9:BasicTooltip.kt#mqatfk");
            function2.invoke(composer, 0);
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
    public static final Unit TooltipPopup$lambda$1$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8850setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8823getAssertive0phEisY());
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    private static final Modifier handleGestures(Modifier modifier, boolean z, final TooltipState tooltipState) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, tooltipState, new PointerInputEventHandler() { // from class: androidx.compose.material3.internal.BasicTooltipKt.handleGestures.1

            /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: BasicTooltip.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1", f = "BasicTooltip.kt", i = {}, l = {JfifUtil.MARKER_EOI}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ TooltipState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00651(PointerInputScope pointerInputScope, TooltipState tooltipState, Continuation<? super C00651> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00651 c00651 = new C00651(this.$this_pointerInput, this.$state, continuation);
                    c00651.L$0 = obj;
                    return c00651;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: BasicTooltip.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1", f = "BasicTooltip.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {224, 230, 252}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "isLongPressedFlow", "pass", "longPressTimeout", "$this$awaitEachGesture", "isLongPressedFlow", "pass", "isLongPressedFlow"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$0"}, v = 1)
                static final class C00661 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ TooltipState $state;
                    long J$0;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00661(CoroutineScope coroutineScope, TooltipState tooltipState, Continuation<? super C00661> continuation) {
                        super(2, continuation);
                        this.$$this$coroutineScope = coroutineScope;
                        this.$state = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00661 c00661 = new C00661(this.$$this$coroutineScope, this.$state, continuation);
                        c00661.L$0 = obj;
                        return c00661;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00661) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code duplicated, block: B:39:0x00fa  */
                    /* JADX WARN: Code duplicated, block: B:42:0x00ff A[Catch: all -> 0x0021, TRY_LEAVE, TryCatch #0 {all -> 0x0021, blocks: (B:8:0x001a, B:40:0x00fb, B:42:0x00ff), top: B:48:0x001a }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        AwaitPointerEventScope awaitPointerEventScope;
                        MutableStateFlow MutableStateFlow;
                        long longPressTimeoutMillis;
                        PointerEventPass pointerEventPass;
                        Object objAwaitFirstDown$default;
                        AwaitPointerEventScope awaitPointerEventScope2;
                        MutableStateFlow mutableStateFlow;
                        MutableStateFlow mutableStateFlow2;
                        Object objWaitForUpOrCancellation;
                        PointerInputChange pointerInputChange;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            MutableStateFlow = StateFlowKt.MutableStateFlow(Boxing.boxBoolean(false));
                            longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                            pointerEventPass = PointerEventPass.Initial;
                            this.L$0 = awaitPointerEventScope;
                            this.L$1 = MutableStateFlow;
                            this.L$2 = pointerEventPass;
                            this.J$0 = longPressTimeoutMillis;
                            this.label = 1;
                            objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, pointerEventPass, this, 1, null);
                            if (objAwaitFirstDown$default != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        }
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                mutableStateFlow2 = (MutableStateFlow) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    objWaitForUpOrCancellation = obj;
                                    pointerInputChange = (PointerInputChange) objWaitForUpOrCancellation;
                                    if (pointerInputChange != null) {
                                        pointerInputChange.consume();
                                    }
                                    mutableStateFlow2.tryEmit(Boxing.boxBoolean(false));
                                    return Unit.INSTANCE;
                                } catch (Throwable th) {
                                    th = th;
                                    mutableStateFlow2.tryEmit(Boxing.boxBoolean(false));
                                    throw th;
                                }
                            }
                            PointerEventPass pointerEventPass2 = (PointerEventPass) this.L$2;
                            mutableStateFlow = (MutableStateFlow) this.L$1;
                            awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                mutableStateFlow.tryEmit(Boxing.boxBoolean(false));
                            } catch (PointerEventTimeoutCancellationException unused) {
                                pointerEventPass = pointerEventPass2;
                                MutableStateFlow = mutableStateFlow;
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass3(MutableStateFlow, this.$state, null), 1, null);
                                this.L$0 = MutableStateFlow;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 3;
                                objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope2, pointerEventPass, this);
                                if (objWaitForUpOrCancellation != coroutine_suspended) {
                                    mutableStateFlow2 = MutableStateFlow;
                                    pointerInputChange = (PointerInputChange) objWaitForUpOrCancellation;
                                    if (pointerInputChange != null) {
                                        pointerInputChange.consume();
                                    }
                                    mutableStateFlow2.tryEmit(Boxing.boxBoolean(false));
                                }
                                return coroutine_suspended;
                            } catch (Throwable th2) {
                                th = th2;
                                mutableStateFlow2 = mutableStateFlow;
                                mutableStateFlow2.tryEmit(Boxing.boxBoolean(false));
                                throw th;
                            }
                            return Unit.INSTANCE;
                        }
                        long j = this.J$0;
                        PointerEventPass pointerEventPass3 = (PointerEventPass) this.L$2;
                        MutableStateFlow mutableStateFlow3 = (MutableStateFlow) this.L$1;
                        AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        longPressTimeoutMillis = j;
                        awaitPointerEventScope = awaitPointerEventScope3;
                        pointerEventPass = pointerEventPass3;
                        MutableStateFlow = mutableStateFlow3;
                        objAwaitFirstDown$default = obj;
                        int type = ((PointerInputChange) objAwaitFirstDown$default).getType();
                        if (PointerType.m8205equalsimpl0(type, PointerType.INSTANCE.m8212getTouchT8wyACA()) || PointerType.m8205equalsimpl0(type, PointerType.INSTANCE.m8211getStylusT8wyACA())) {
                            try {
                                try {
                                    this.L$0 = awaitPointerEventScope;
                                    this.L$1 = MutableStateFlow;
                                    this.L$2 = pointerEventPass;
                                    this.label = 2;
                                    if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, new C00671(pointerEventPass, null), this) != coroutine_suspended) {
                                        mutableStateFlow = MutableStateFlow;
                                        mutableStateFlow.tryEmit(Boxing.boxBoolean(false));
                                    }
                                } catch (PointerEventTimeoutCancellationException unused2) {
                                    awaitPointerEventScope2 = awaitPointerEventScope;
                                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass3(MutableStateFlow, this.$state, null), 1, null);
                                    this.L$0 = MutableStateFlow;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.label = 3;
                                    objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation(awaitPointerEventScope2, pointerEventPass, this);
                                    if (objWaitForUpOrCancellation != coroutine_suspended) {
                                        mutableStateFlow2 = MutableStateFlow;
                                        pointerInputChange = (PointerInputChange) objWaitForUpOrCancellation;
                                        if (pointerInputChange != null) {
                                            pointerInputChange.consume();
                                        }
                                        mutableStateFlow2.tryEmit(Boxing.boxBoolean(false));
                                        return Unit.INSTANCE;
                                    }
                                }
                                return coroutine_suspended;
                            } catch (Throwable th3) {
                                th = th3;
                                mutableStateFlow2 = MutableStateFlow;
                                mutableStateFlow2.tryEmit(Boxing.boxBoolean(false));
                                throw th;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$1", f = "BasicTooltip.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class C00671 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                        final /* synthetic */ PointerEventPass $pass;
                        private /* synthetic */ Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00671(PointerEventPass pointerEventPass, Continuation<? super C00671> continuation) {
                            super(2, continuation);
                            this.$pass = pointerEventPass;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C00671 c00671 = new C00671(this.$pass, continuation);
                            c00671.L$0 = obj;
                            return c00671;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                            return ((C00671) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i != 0) {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return obj;
                            }
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            Object objWaitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation((AwaitPointerEventScope) this.L$0, this.$pass, this);
                            return objWaitForUpOrCancellation == coroutine_suspended ? coroutine_suspended : objWaitForUpOrCancellation;
                        }
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3, reason: invalid class name */
                    /* JADX INFO: compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3", f = "BasicTooltip.kt", i = {}, l = {238, 241, 241}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableStateFlow<Boolean> $isLongPressedFlow;
                        final /* synthetic */ TooltipState $state;
                        Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass3(MutableStateFlow<Boolean> mutableStateFlow, TooltipState tooltipState, Continuation<? super AnonymousClass3> continuation) {
                            super(2, continuation);
                            this.$isLongPressedFlow = mutableStateFlow;
                            this.$state = tooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass3(this.$isLongPressedFlow, this.$state, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
                        
                            if (kotlinx.coroutines.flow.FlowKt.collectLatest(r7.$isLongPressedFlow, new androidx.compose.material3.internal.BasicTooltipKt.AnonymousClass1.C00651.C00661.AnonymousClass3.C00681(r7.$state, null), r7) == r0) goto L30;
                         */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
                            /*
                                r7 = this;
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r7.label
                                r2 = 0
                                r3 = 3
                                r4 = 2
                                r5 = 1
                                if (r1 == 0) goto L2e
                                if (r1 == r5) goto L28
                                if (r1 == r4) goto L24
                                if (r1 == r3) goto L1b
                                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                                r7.<init>(r8)
                                throw r7
                            L1b:
                                java.lang.Object r7 = r7.L$0
                                java.lang.Throwable r7 = (java.lang.Throwable) r7
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L92
                            L24:
                                kotlin.ResultKt.throwOnFailure(r8)
                                goto L6b
                            L28:
                                kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L2c
                                goto L4a
                            L2c:
                                r8 = move-exception
                                goto L6e
                            L2e:
                                kotlin.ResultKt.throwOnFailure(r8)
                                kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r8 = r7.$isLongPressedFlow     // Catch: java.lang.Throwable -> L2c
                                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch: java.lang.Throwable -> L2c
                                r8.tryEmit(r1)     // Catch: java.lang.Throwable -> L2c
                                androidx.compose.material3.TooltipState r8 = r7.$state     // Catch: java.lang.Throwable -> L2c
                                androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.PreventUserInput     // Catch: java.lang.Throwable -> L2c
                                r6 = r7
                                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Throwable -> L2c
                                r7.label = r5     // Catch: java.lang.Throwable -> L2c
                                java.lang.Object r8 = r8.show(r1, r6)     // Catch: java.lang.Throwable -> L2c
                                if (r8 != r0) goto L4a
                                goto L90
                            L4a:
                                androidx.compose.material3.TooltipState r8 = r7.$state
                                boolean r8 = r8.getIsVisible()
                                if (r8 == 0) goto L6b
                                kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r8 = r7.$isLongPressedFlow
                                kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
                                androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1 r1 = new androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1
                                androidx.compose.material3.TooltipState r3 = r7.$state
                                r1.<init>(r3, r2)
                                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                                r2 = r7
                                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                                r7.label = r4
                                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.collectLatest(r8, r1, r2)
                                if (r7 != r0) goto L6b
                                goto L90
                            L6b:
                                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                return r7
                            L6e:
                                androidx.compose.material3.TooltipState r1 = r7.$state
                                boolean r1 = r1.getIsVisible()
                                if (r1 == 0) goto L93
                                kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r1 = r7.$isLongPressedFlow
                                kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
                                androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1 r4 = new androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1
                                androidx.compose.material3.TooltipState r5 = r7.$state
                                r4.<init>(r5, r2)
                                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                                r2 = r7
                                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                                r7.L$0 = r8
                                r7.label = r3
                                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.collectLatest(r1, r4, r2)
                                if (r7 != r0) goto L91
                            L90:
                                return r0
                            L91:
                                r7 = r8
                            L92:
                                r8 = r7
                            L93:
                                throw r8
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt.AnonymousClass1.C00651.C00661.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: BasicTooltip.kt */
                        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isLongPressed", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$3$1", f = "BasicTooltip.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class C00681 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
                            final /* synthetic */ TooltipState $state;
                            /* synthetic */ boolean Z$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00681(TooltipState tooltipState, Continuation<? super C00681> continuation) {
                                super(2, continuation);
                                this.$state = tooltipState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                C00681 c00681 = new C00681(this.$state, continuation);
                                c00681.Z$0 = ((Boolean) obj).booleanValue();
                                return c00681;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                                return invoke(bool.booleanValue(), continuation);
                            }

                            public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
                                return ((C00681) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                if (!this.Z$0) {
                                    this.$state.dismiss();
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00661(coroutineScope, this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00651(pointerInputScope, tooltipState, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }), tooltipState, new PointerInputEventHandler() { // from class: androidx.compose.material3.internal.BasicTooltipKt.handleGestures.2

            /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: BasicTooltip.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1", f = "BasicTooltip.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ TooltipState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, TooltipState tooltipState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = tooltipState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: BasicTooltip.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1", f = "BasicTooltip.kt", i = {0, 0}, l = {267}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "pass"}, s = {"L$0", "L$1"}, v = 1)
                static final class C00691 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ TooltipState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00691(CoroutineScope coroutineScope, TooltipState tooltipState, Continuation<? super C00691> continuation) {
                        super(2, continuation);
                        this.$$this$coroutineScope = coroutineScope;
                        this.$state = tooltipState;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00691 c00691 = new C00691(this.$$this$coroutineScope, this.$state, continuation);
                        c00691.L$0 = obj;
                        return c00691;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00691) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code duplicated, block: B:11:0x0039 A[RETURN] */
                    /* JADX WARN: Code duplicated, block: B:14:0x0057  */
                    /* JADX WARN: Code duplicated, block: B:16:0x0067  */
                    /* JADX WARN: Code duplicated, block: B:17:0x007b  */
                    /* JADX WARN: Code duplicated, block: B:19:0x0087  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0037 -> B:12:0x003a). Please report as a decompilation issue!!! */
                    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:11:0x0039
                        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                        */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                        /*
                            r11 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r11.label
                            r2 = 1
                            if (r1 == 0) goto L20
                            if (r1 != r2) goto L17
                            java.lang.Object r1 = r11.L$1
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = (androidx.compose.ui.input.pointer.PointerEventPass) r1
                            java.lang.Object r3 = r11.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                            kotlin.ResultKt.throwOnFailure(r12)
                            goto L3a
                        L17:
                            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                            r11.<init>(r12)
                            throw r11
                        L20:
                            kotlin.ResultKt.throwOnFailure(r12)
                            java.lang.Object r12 = r11.L$0
                            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
                            androidx.compose.ui.input.pointer.PointerEventPass r1 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                            r3 = r12
                        L2a:
                            r12 = r11
                            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
                            r11.L$0 = r3
                            r11.L$1 = r1
                            r11.label = r2
                            java.lang.Object r12 = r3.awaitPointerEvent(r1, r12)
                            if (r12 != r0) goto L3a
                            return r0
                        L3a:
                            androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
                            java.util.List r4 = r12.getChanges()
                            r5 = 0
                            java.lang.Object r4 = r4.get(r5)
                            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                            int r4 = r4.getType()
                            androidx.compose.ui.input.pointer.PointerType$Companion r5 = androidx.compose.ui.input.pointer.PointerType.INSTANCE
                            int r5 = r5.m8210getMouseT8wyACA()
                            boolean r4 = androidx.compose.ui.input.pointer.PointerType.m8205equalsimpl0(r4, r5)
                            if (r4 == 0) goto L2a
                            int r12 = r12.getType()
                            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                            int r4 = r4.m8087getEnter7fucELk()
                            boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m8083equalsimpl0(r12, r4)
                            if (r4 == 0) goto L7b
                            kotlinx.coroutines.CoroutineScope r5 = r11.$$this$coroutineScope
                            androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1$1 r12 = new androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1$1
                            androidx.compose.material3.TooltipState r4 = r11.$state
                            r6 = 0
                            r12.<init>(r4, r6)
                            r8 = r12
                            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                            r9 = 3
                            r10 = 0
                            r7 = 0
                            kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)
                            goto L2a
                        L7b:
                            androidx.compose.ui.input.pointer.PointerEventType$Companion r4 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                            int r4 = r4.m8088getExit7fucELk()
                            boolean r12 = androidx.compose.ui.input.pointer.PointerEventType.m8083equalsimpl0(r12, r4)
                            if (r12 == 0) goto L2a
                            androidx.compose.material3.TooltipState r12 = r11.$state
                            boolean r12 = r12.getIsPersistent()
                            if (r12 != 0) goto L2a
                            androidx.compose.material3.TooltipState r12 = r11.$state
                            r12.dismiss()
                            goto L2a
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt.AnonymousClass2.AnonymousClass1.C00691.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: BasicTooltip.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipKt$handleGestures$2$1$1$1", f = "BasicTooltip.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class C00701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ TooltipState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00701(TooltipState tooltipState, Continuation<? super C00701> continuation) {
                            super(2, continuation);
                            this.$state = tooltipState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00701(this.$state, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$state.show(MutatePriority.UserInput, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (this.$this_pointerInput.awaitPointerEventScope(new C00691(coroutineScope, this.$state, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipState, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }
        }) : modifier;
    }

    private static final Modifier anchorSemantics(Modifier modifier, final String str, boolean z, final TooltipState tooltipState, final CoroutineScope coroutineScope) {
        return z ? ChildParentSemanticsKt.parentSemantics(modifier, new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BasicTooltipKt.anchorSemantics$lambda$0(str, coroutineScope, tooltipState, (SemanticsPropertyReceiver) obj);
            }
        }) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit anchorSemantics$lambda$0(String str, final CoroutineScope coroutineScope, final TooltipState tooltipState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, str, new Function0() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(BasicTooltipKt.anchorSemantics$lambda$0$0(coroutineScope, tooltipState));
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean anchorSemantics$lambda$0$0(CoroutineScope coroutineScope, TooltipState tooltipState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BasicTooltipKt$anchorSemantics$1$1$1(tooltipState, null), 3, null);
        return true;
    }

    private static final Modifier keyboardBehavior(Modifier modifier, boolean z, final TooltipState tooltipState, final CoroutineScope coroutineScope, final boolean z2, final MutableState<Boolean> mutableState, final MutableState<Boolean> mutableState2) {
        if (z) {
            return KeyInputModifierKt.onPreviewKeyEvent(FocusChangedModifierKt.onFocusChanged(modifier, new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BasicTooltipKt.keyboardBehavior$lambda$0(coroutineScope, mutableState2, tooltipState, (FocusState) obj);
                }
            }), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.internal.BasicTooltipKt.keyboardBehavior.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m4953invokeZmokQxo(keyEvent.m7966unboximpl());
                }

                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m4953invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    if (!tooltipState.getIsVisible()) {
                        mutableState.setValue(false);
                    } else if (!z2 || !BasicTooltipKt.m4952isTabZmokQxo(keyEvent)) {
                        if (BasicTooltipKt.m4951isEscapeZmokQxo(keyEvent)) {
                            mutableState2.setValue(false);
                            tooltipState.dismiss();
                            return true;
                        }
                    } else {
                        mutableState.setValue(true);
                        return true;
                    }
                    return false;
                }
            });
        }
        mutableState.setValue(false);
        return modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit keyboardBehavior$lambda$0(CoroutineScope coroutineScope, MutableState mutableState, TooltipState tooltipState, FocusState focusState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BasicTooltipKt$keyboardBehavior$1$1(focusState, mutableState, tooltipState, null), 3, null);
        return Unit.INSTANCE;
    }

    public static final TooltipState rememberBasicTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1483057531, "C(rememberBasicTooltipState)N(initialIsVisible,isPersistent,mutatorMutex)367@15351L216:BasicTooltip.kt#mqatfk");
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1483057531, i, -1, "androidx.compose.material3.internal.rememberBasicTooltipState (BasicTooltip.kt:367)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 710861597, "CC(remember):BasicTooltip.kt#9igjgp");
        boolean z3 = ((((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(mutatorMutex)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new BasicTooltipStateImpl(z, z2, mutatorMutex);
            composer.updateRememberedValue(objRememberedValue);
        }
        BasicTooltipStateImpl basicTooltipStateImpl = (BasicTooltipStateImpl) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return basicTooltipStateImpl;
    }

    public static /* synthetic */ TooltipState BasicTooltipState$default(boolean z, boolean z2, MutatorMutex mutatorMutex, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.INSTANCE.getGlobalMutatorMutex();
        }
        return BasicTooltipState(z, z2, mutatorMutex);
    }

    public static final TooltipState BasicTooltipState(boolean z, boolean z2, MutatorMutex mutatorMutex) {
        return new BasicTooltipStateImpl(z, z2, mutatorMutex);
    }

    private static final State<Boolean> rememberTouchExplorationOrSwitchAccessServiceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1960751094, "C(rememberTouchExplorationOrSwitchAccessServiceState)477@19535L170:BasicTooltip.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1960751094, i, -1, "androidx.compose.material3.internal.rememberTouchExplorationOrSwitchAccessServiceState (BasicTooltip.kt:477)");
        }
        State<Boolean> stateRememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(true, true, false, composer, 438, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateRememberAccessibilityServiceState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isTab-ZmokQxo, reason: not valid java name */
    public static final boolean m4952isTabZmokQxo(android.view.KeyEvent keyEvent) {
        return KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isEscape-ZmokQxo, reason: not valid java name */
    public static final boolean m4951isEscapeZmokQxo(android.view.KeyEvent keyEvent) {
        return KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BasicTooltipBox$lambda$2$0(final TooltipState tooltipState, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.BasicTooltipKt$BasicTooltipBox$lambda$2$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                tooltipState.onDispose();
            }
        };
    }
}
