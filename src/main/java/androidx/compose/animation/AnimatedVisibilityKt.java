package androidx.compose.animation;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: AnimatedVisibility.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a[\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a_\u0010\u0000\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001a_\u0010\u0000\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0015\u001aa\u0010\u0000\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001ae\u0010\u0000\u001a\u00020\u0001*\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0019\u001ae\u0010\u0000\u001a\u00020\u0001*\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001a\u001am\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001d\u001ak\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010 \u001a\u0091\u0001\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010'\u001a9\u0010+\u001a\u00020$\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010,\u001a\u0002H\u001bH\u0003¢\u0006\u0002\u0010-\"\u001e\u0010(\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020$0\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006.²\u0006\u001c\u0010/\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"AnimatedVisibility", "", ViewProps.VISIBLE, "", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "label", "", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/Transition;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "AnimatedVisibilityImpl", "transition", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "AnimatedEnterExitImpl", "shouldDisposeBlock", "Lkotlin/Function2;", "Landroidx/compose/animation/EnterExitState;", "onLookaheadMeasured", "Landroidx/compose/animation/OnLookaheadMeasured;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function2;Landroidx/compose/animation/OnLookaheadMeasured;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "exitFinished", "getExitFinished", "(Landroidx/compose/animation/core/Transition;)Z", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation", "shouldDisposeBlockUpdated", "shouldDisposeAfterExit"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnimatedVisibilityKt {
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:76:0x0106  */
    /* JADX WARN: Code duplicated, block: B:78:0x0109  */
    /* JADX WARN: Code duplicated, block: B:79:0x010c  */
    /* JADX WARN: Code duplicated, block: B:82:0x0114  */
    /* JADX WARN: Code duplicated, block: B:85:0x0140  */
    /* JADX WARN: Code duplicated, block: B:88:0x0169  */
    /* JADX WARN: Code duplicated, block: B:90:0x0171  */
    /* JADX WARN: Code duplicated, block: B:93:0x017f  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        final boolean z2;
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        int i8;
        int i9;
        boolean z3;
        final String str2;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Modifier modifier4;
        EnterTransition enterTransitionPlus;
        ExitTransition exitTransitionPlus;
        String str3;
        AnimatedVisibilityKt$AnimatedVisibility$1$1 animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1448730565);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)131@7032L32,132@7104L6,132@7069L84:AnimatedVisibility.kt#xbi5r1");
        if ((i & 6) == 0) {
            z2 = z;
            i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    enterTransition2 = enterTransition;
                    if (composerStartRestartGroup.changed(enterTransition2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        exitTransition2 = exitTransition;
                        if (composerStartRestartGroup.changed(exitTransition2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((196608 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((74899 & i3) != 74898) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            str2 = str;
                            modifier3 = modifier2;
                            enterTransition3 = enterTransition2;
                            exitTransition3 = exitTransition2;
                        } else {
                            if (i12 != 0) {
                                modifier4 = Modifier.INSTANCE;
                                i10 = i8;
                            } else {
                                i10 = i8;
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                            } else {
                                enterTransitionPlus = enterTransition2;
                            }
                            if (i6 != 0) {
                                exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                            } else {
                                exitTransitionPlus = exitTransition2;
                            }
                            if (i10 != 0) {
                                str3 = "AnimatedVisibility";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                            }
                            Transition transitionUpdateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                                    public final Boolean invoke(boolean z4) {
                                        return Boolean.valueOf(z4);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                            }
                            Function1 function1 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i13 = i3 << 3;
                            AnimatedVisibilityImpl(transitionUpdateTransition, function1, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i13 & 57344) | (i13 & 896) | 48 | (i13 & 7168) | (i3 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier3 = modifier4;
                            enterTransition3 = enterTransitionPlus;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i14) {
                                    AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str2 = str;
                        modifier3 = modifier2;
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    } else {
                        if (i12 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i10 = i8;
                        } else {
                            i10 = i8;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i10 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                        }
                        Transition transitionUpdateTransition2 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                                public final Boolean invoke(boolean z4) {
                                    return Boolean.valueOf(z4);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                        }
                        Function1 function2 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i14 = i3 << 3;
                        AnimatedVisibilityImpl(transitionUpdateTransition2, function2, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i14 & 57344) | (i14 & 896) | 48 | (i14 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition3 = enterTransitionPlus;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                exitTransition2 = exitTransition;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str2 = str;
                        modifier3 = modifier2;
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    } else {
                        if (i12 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i10 = i8;
                        } else {
                            i10 = i8;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i10 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                        }
                        Transition transitionUpdateTransition3 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                                public final Boolean invoke(boolean z4) {
                                    return Boolean.valueOf(z4);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                        }
                        Function1 function4 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i15 = i3 << 3;
                        AnimatedVisibilityImpl(transitionUpdateTransition3, function4, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i15 & 57344) | (i15 & 896) | 48 | (i15 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition3 = enterTransitionPlus;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i16) {
                                AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                    }
                    Transition transitionUpdateTransition4 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                            public final Boolean invoke(boolean z4) {
                                return Boolean.valueOf(z4);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                    }
                    Function1 function5 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i16 = i3 << 3;
                    AnimatedVisibilityImpl(transitionUpdateTransition4, function5, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i16 & 57344) | (i16 & 896) | 48 | (i16 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i17) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            enterTransition2 = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str2 = str;
                        modifier3 = modifier2;
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    } else {
                        if (i12 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i10 = i8;
                        } else {
                            i10 = i8;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i10 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                        }
                        Transition transitionUpdateTransition5 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                                public final Boolean invoke(boolean z4) {
                                    return Boolean.valueOf(z4);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                        }
                        Function1 function6 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i17 = i3 << 3;
                        AnimatedVisibilityImpl(transitionUpdateTransition5, function6, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i17 & 57344) | (i17 & 896) | 48 | (i17 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition3 = enterTransitionPlus;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i18) {
                                AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                    }
                    Transition transitionUpdateTransition6 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                            public final Boolean invoke(boolean z4) {
                                return Boolean.valueOf(z4);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                    }
                    Function1 function7 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i18 = i3 << 3;
                    AnimatedVisibilityImpl(transitionUpdateTransition6, function7, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i18 & 57344) | (i18 & 896) | 48 | (i18 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i19) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                    }
                    Transition transitionUpdateTransition7 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                            public final Boolean invoke(boolean z4) {
                                return Boolean.valueOf(z4);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                    }
                    Function1 function8 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i19 = i3 << 3;
                    AnimatedVisibilityImpl(transitionUpdateTransition7, function8, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i19 & 57344) | (i19 & 896) | 48 | (i19 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i110) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                enterTransition3 = enterTransition2;
                exitTransition3 = exitTransition2;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i10 = i8;
                } else {
                    i10 = i8;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i10 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                }
                Transition transitionUpdateTransition8 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                        public final Boolean invoke(boolean z4) {
                            return Boolean.valueOf(z4);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                }
                Function1 function9 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i110 = i3 << 3;
                AnimatedVisibilityImpl(transitionUpdateTransition8, function9, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i110 & 57344) | (i110 & 896) | 48 | (i110 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition3 = enterTransitionPlus;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111) {
                        AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                enterTransition2 = enterTransition;
                if (composerStartRestartGroup.changed(enterTransition2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str2 = str;
                        modifier3 = modifier2;
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    } else {
                        if (i12 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i10 = i8;
                        } else {
                            i10 = i8;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i10 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                        }
                        Transition transitionUpdateTransition9 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                                public final Boolean invoke(boolean z4) {
                                    return Boolean.valueOf(z4);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                        }
                        Function1 function10 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i111 = i3 << 3;
                        AnimatedVisibilityImpl(transitionUpdateTransition9, function10, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i111 & 57344) | (i111 & 896) | 48 | (i111 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition3 = enterTransitionPlus;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i112) {
                                AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                    }
                    Transition transitionUpdateTransition10 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                            public final Boolean invoke(boolean z4) {
                                return Boolean.valueOf(z4);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                    }
                    Function1 function11 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i112 = i3 << 3;
                    AnimatedVisibilityImpl(transitionUpdateTransition10, function11, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i112 & 57344) | (i112 & 896) | 48 | (i112 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i113) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                    }
                    Transition transitionUpdateTransition11 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                            public final Boolean invoke(boolean z4) {
                                return Boolean.valueOf(z4);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                    }
                    Function1 function12 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i113 = i3 << 3;
                    AnimatedVisibilityImpl(transitionUpdateTransition11, function12, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i113 & 57344) | (i113 & 896) | 48 | (i113 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i114) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                enterTransition3 = enterTransition2;
                exitTransition3 = exitTransition2;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i10 = i8;
                } else {
                    i10 = i8;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i10 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                }
                Transition transitionUpdateTransition12 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                        public final Boolean invoke(boolean z4) {
                            return Boolean.valueOf(z4);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                }
                Function1 function13 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i114 = i3 << 3;
                AnimatedVisibilityImpl(transitionUpdateTransition12, function13, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i114 & 57344) | (i114 & 896) | 48 | (i114 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition3 = enterTransitionPlus;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i115) {
                        AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        enterTransition2 = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                exitTransition2 = exitTransition;
                if (composerStartRestartGroup.changed(exitTransition2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                    }
                    Transition transitionUpdateTransition13 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                            public final Boolean invoke(boolean z4) {
                                return Boolean.valueOf(z4);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                    }
                    Function1 function14 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i115 = i3 << 3;
                    AnimatedVisibilityImpl(transitionUpdateTransition13, function14, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i115 & 57344) | (i115 & 896) | 48 | (i115 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i116) {
                            AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                enterTransition3 = enterTransition2;
                exitTransition3 = exitTransition2;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i10 = i8;
                } else {
                    i10 = i8;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i10 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                }
                Transition transitionUpdateTransition14 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                        public final Boolean invoke(boolean z4) {
                            return Boolean.valueOf(z4);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                }
                Function1 function15 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i116 = i3 << 3;
                AnimatedVisibilityImpl(transitionUpdateTransition14, function15, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i116 & 57344) | (i116 & 896) | 48 | (i116 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition3 = enterTransitionPlus;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i117) {
                        AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        exitTransition2 = exitTransition;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                enterTransition3 = enterTransition2;
                exitTransition3 = exitTransition2;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i10 = i8;
                } else {
                    i10 = i8;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i10 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
                }
                Transition transitionUpdateTransition15 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                        public final Boolean invoke(boolean z4) {
                            return Boolean.valueOf(z4);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
                }
                Function1 function16 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i117 = i3 << 3;
                AnimatedVisibilityImpl(transitionUpdateTransition15, function16, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i117 & 57344) | (i117 & 896) | 48 | (i117 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition3 = enterTransitionPlus;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i118) {
                        AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i3 |= i11;
        }
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            str2 = str;
            modifier3 = modifier2;
            enterTransition3 = enterTransition2;
            exitTransition3 = exitTransition2;
        } else {
            if (i12 != 0) {
                modifier4 = Modifier.INSTANCE;
                i10 = i8;
            } else {
                i10 = i8;
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
            } else {
                enterTransitionPlus = enterTransition2;
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i10 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1448730565, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:130)");
            }
            Transition transitionUpdateTransition16 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z2), str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 9) & 112), 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660656671, "CC(remember):AnimatedVisibility.kt#9igjgp");
            animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$1$1
                    public final Boolean invoke(boolean z4) {
                        return Boolean.valueOf(z4);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue);
            }
            Function1 function17 = (Function1) animatedVisibilityKt$AnimatedVisibility$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i118 = i3 << 3;
            AnimatedVisibilityImpl(transitionUpdateTransition16, function17, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i118 & 57344) | (i118 & 896) | 48 | (i118 & 7168) | (i3 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
            modifier3 = modifier4;
            enterTransition3 = enterTransitionPlus;
            exitTransition3 = exitTransitionPlus;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i119) {
                    AnimatedVisibilityKt.AnimatedVisibility(z2, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:77:0x0102  */
    /* JADX WARN: Code duplicated, block: B:78:0x0105  */
    /* JADX WARN: Code duplicated, block: B:81:0x010d  */
    /* JADX WARN: Code duplicated, block: B:84:0x013b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0163  */
    /* JADX WARN: Code duplicated, block: B:89:0x016b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0179  */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(final RowScope rowScope, final boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransitionPlus;
        int i5;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        int i8;
        int i9;
        boolean z2;
        final Modifier modifier3;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition3;
        final String str2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        ExitTransition exitTransitionPlus;
        String str3;
        AnimatedVisibilityKt$AnimatedVisibility$3$1 animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(234057107);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)205@11418L32,206@11490L6,206@11455L84:AnimatedVisibility.kt#xbi5r1");
        if ((i & 48) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    enterTransitionPlus = enterTransition;
                    if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        if (composerStartRestartGroup.changed(exitTransition2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((1572864 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                        if ((599185 & i3) != 599184) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition2 = enterTransitionPlus;
                            exitTransition3 = exitTransition2;
                            str2 = str;
                        } else {
                            if (i11 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                            }
                            if (i6 != 0) {
                                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                            } else {
                                exitTransitionPlus = exitTransition2;
                            }
                            if (i8 != 0) {
                                str3 = "AnimatedVisibility";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                            }
                            int i12 = i3 >> 3;
                            Transition transitionUpdateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i12 & 14) | ((i3 >> 12) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                                    public final Boolean invoke(boolean z3) {
                                        return Boolean.valueOf(z3);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EnterTransition enterTransition3 = enterTransitionPlus;
                            AnimatedVisibilityImpl(transitionUpdateTransition, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition3, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i12));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier3 = modifier4;
                            enterTransition2 = enterTransition3;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                        }
                        int i13 = i3 >> 3;
                        Transition transitionUpdateTransition2 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i13 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition4 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionUpdateTransition2, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition4, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i13));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition4;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i14) {
                                AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                exitTransition2 = exitTransition;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                        }
                        int i14 = i3 >> 3;
                        Transition transitionUpdateTransition3 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i14 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition5 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionUpdateTransition3, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition5, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition5;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                    }
                    int i15 = i3 >> 3;
                    Transition transitionUpdateTransition4 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i15 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition6 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition4, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition6, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i15));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition6;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i16) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            enterTransitionPlus = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                        }
                        int i16 = i3 >> 3;
                        Transition transitionUpdateTransition5 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i16 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition7 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionUpdateTransition5, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition7, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i16));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition7;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i17) {
                                AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                    }
                    int i17 = i3 >> 3;
                    Transition transitionUpdateTransition6 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i17 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition8 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition6, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition8, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i17));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition8;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i18) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                    }
                    int i18 = i3 >> 3;
                    Transition transitionUpdateTransition7 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i18 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition9 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition7, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition9, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i18));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition9;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i19) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                }
                int i19 = i3 >> 3;
                Transition transitionUpdateTransition8 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i19 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition10 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionUpdateTransition8, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition10, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i19));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition10;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i110) {
                        AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                enterTransitionPlus = enterTransition;
                if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                        }
                        int i110 = i3 >> 3;
                        Transition transitionUpdateTransition9 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i110 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition11 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionUpdateTransition9, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition11, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i110));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition11;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i111) {
                                AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                    }
                    int i111 = i3 >> 3;
                    Transition transitionUpdateTransition10 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i111 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition12 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition10, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition12, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i111));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition12;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i112) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                    }
                    int i112 = i3 >> 3;
                    Transition transitionUpdateTransition11 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i112 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition13 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition11, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition13, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition13;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i113) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                }
                int i113 = i3 >> 3;
                Transition transitionUpdateTransition12 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i113 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition14 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionUpdateTransition12, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition14, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i113));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition14;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i114) {
                        AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        enterTransitionPlus = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                exitTransition2 = exitTransition;
                if (composerStartRestartGroup.changed(exitTransition2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                    }
                    int i114 = i3 >> 3;
                    Transition transitionUpdateTransition13 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i114 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition15 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition13, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition15, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i114));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition15;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i115) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                }
                int i115 = i3 >> 3;
                Transition transitionUpdateTransition14 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i115 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition16 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionUpdateTransition14, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition16, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i115));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition16;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i116) {
                        AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        exitTransition2 = exitTransition;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
                }
                int i116 = i3 >> 3;
                Transition transitionUpdateTransition15 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i116 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition17 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionUpdateTransition15, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition17, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i116));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition17;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i117) {
                        AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        if ((599185 & i3) != 599184) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            enterTransition2 = enterTransitionPlus;
            exitTransition3 = exitTransition2;
            str2 = str;
        } else {
            if (i11 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null));
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i8 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(234057107, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:204)");
            }
            int i117 = i3 >> 3;
            Transition transitionUpdateTransition16 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i117 & 14) | ((i3 >> 12) & 112), 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1590593721, "CC(remember):AnimatedVisibility.kt#9igjgp");
            animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$3$1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EnterTransition enterTransition18 = enterTransitionPlus;
            AnimatedVisibilityImpl(transitionUpdateTransition16, (Function1) animatedVisibilityKt$AnimatedVisibility$3$1RememberedValue, modifier4, enterTransition18, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i117));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
            modifier3 = modifier4;
            enterTransition2 = enterTransition18;
            exitTransition3 = exitTransitionPlus;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i118) {
                    AnimatedVisibilityKt.AnimatedVisibility(rowScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:77:0x0102  */
    /* JADX WARN: Code duplicated, block: B:78:0x0105  */
    /* JADX WARN: Code duplicated, block: B:81:0x010d  */
    /* JADX WARN: Code duplicated, block: B:84:0x013b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0163  */
    /* JADX WARN: Code duplicated, block: B:89:0x016b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0179  */
    /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(final ColumnScope columnScope, final boolean z, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransitionPlus;
        int i5;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        int i8;
        int i9;
        boolean z2;
        final Modifier modifier3;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition3;
        final String str2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        ExitTransition exitTransitionPlus;
        String str3;
        AnimatedVisibilityKt$AnimatedVisibility$5$1 animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1799879339);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)278@15785L32,279@15857L6,279@15822L84:AnimatedVisibility.kt#xbi5r1");
        if ((i & 48) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    enterTransitionPlus = enterTransition;
                    if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        if (composerStartRestartGroup.changed(exitTransition2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((1572864 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                        if ((599185 & i3) != 599184) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition2 = enterTransitionPlus;
                            exitTransition3 = exitTransition2;
                            str2 = str;
                        } else {
                            if (i11 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                            }
                            if (i6 != 0) {
                                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                            } else {
                                exitTransitionPlus = exitTransition2;
                            }
                            if (i8 != 0) {
                                str3 = "AnimatedVisibility";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                            }
                            int i12 = i3 >> 3;
                            Transition transitionUpdateTransition = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i12 & 14) | ((i3 >> 12) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                                    public final Boolean invoke(boolean z3) {
                                        return Boolean.valueOf(z3);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EnterTransition enterTransition3 = enterTransitionPlus;
                            AnimatedVisibilityImpl(transitionUpdateTransition, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition3, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i12));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier3 = modifier4;
                            enterTransition2 = enterTransition3;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                        }
                        int i13 = i3 >> 3;
                        Transition transitionUpdateTransition2 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i13 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition4 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionUpdateTransition2, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition4, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i13));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition4;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i14) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                exitTransition2 = exitTransition;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                        }
                        int i14 = i3 >> 3;
                        Transition transitionUpdateTransition3 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i14 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition5 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionUpdateTransition3, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition5, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition5;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                    }
                    int i15 = i3 >> 3;
                    Transition transitionUpdateTransition4 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i15 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition6 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition4, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition6, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i15));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition6;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i16) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            enterTransitionPlus = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                        }
                        int i16 = i3 >> 3;
                        Transition transitionUpdateTransition5 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i16 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition7 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionUpdateTransition5, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition7, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i16));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition7;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i17) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                    }
                    int i17 = i3 >> 3;
                    Transition transitionUpdateTransition6 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i17 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition8 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition6, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition8, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i17));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition8;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i18) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                    }
                    int i18 = i3 >> 3;
                    Transition transitionUpdateTransition7 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i18 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition9 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition7, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition9, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i18));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition9;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i19) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                }
                int i19 = i3 >> 3;
                Transition transitionUpdateTransition8 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i19 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition10 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionUpdateTransition8, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition10, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i19));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition10;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i110) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                enterTransitionPlus = enterTransition;
                if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                        }
                        int i110 = i3 >> 3;
                        Transition transitionUpdateTransition9 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i110 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                                public final Boolean invoke(boolean z3) {
                                    return Boolean.valueOf(z3);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition11 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionUpdateTransition9, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition11, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i110));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition11;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i111) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                    }
                    int i111 = i3 >> 3;
                    Transition transitionUpdateTransition10 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i111 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition12 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition10, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition12, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i111));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition12;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i112) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                    }
                    int i112 = i3 >> 3;
                    Transition transitionUpdateTransition11 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i112 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition13 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition11, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition13, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition13;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i113) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                }
                int i113 = i3 >> 3;
                Transition transitionUpdateTransition12 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i113 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition14 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionUpdateTransition12, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition14, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i113));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition14;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i114) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        enterTransitionPlus = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                exitTransition2 = exitTransition;
                if (composerStartRestartGroup.changed(exitTransition2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                    }
                    int i114 = i3 >> 3;
                    Transition transitionUpdateTransition13 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i114 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                            public final Boolean invoke(boolean z3) {
                                return Boolean.valueOf(z3);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition15 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionUpdateTransition13, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition15, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i114));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition15;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i115) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                }
                int i115 = i3 >> 3;
                Transition transitionUpdateTransition14 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i115 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition16 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionUpdateTransition14, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition16, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i115));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition16;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i116) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        exitTransition2 = exitTransition;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
                }
                int i116 = i3 >> 3;
                Transition transitionUpdateTransition15 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i116 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                        public final Boolean invoke(boolean z3) {
                            return Boolean.valueOf(z3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition17 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionUpdateTransition15, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition17, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i116));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition17;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i117) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        if ((599185 & i3) != 599184) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            enterTransition2 = enterTransitionPlus;
            exitTransition3 = exitTransition2;
            str2 = str;
        } else {
            if (i11 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null));
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i8 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1799879339, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:277)");
            }
            int i117 = i3 >> 3;
            Transition transitionUpdateTransition16 = androidx.compose.animation.core.TransitionKt.updateTransition(Boolean.valueOf(z), str3, composerStartRestartGroup, (i117 & 14) | ((i3 >> 12) & 112), 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1187762319, "CC(remember):AnimatedVisibility.kt#9igjgp");
            animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$5$1
                    public final Boolean invoke(boolean z3) {
                        return Boolean.valueOf(z3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EnterTransition enterTransition18 = enterTransitionPlus;
            AnimatedVisibilityImpl(transitionUpdateTransition16, (Function1) animatedVisibilityKt$AnimatedVisibility$5$1RememberedValue, modifier4, enterTransition18, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i117));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
            modifier3 = modifier4;
            enterTransition2 = enterTransition18;
            exitTransition3 = exitTransitionPlus;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i118) {
                    AnimatedVisibilityKt.AnimatedVisibility(columnScope, z, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    /* JADX WARN: Code duplicated, block: B:31:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:79:0x010d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0110  */
    /* JADX WARN: Code duplicated, block: B:82:0x0113  */
    /* JADX WARN: Code duplicated, block: B:85:0x011b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0149  */
    /* JADX WARN: Code duplicated, block: B:91:0x0172  */
    /* JADX WARN: Code duplicated, block: B:93:0x017a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0188  */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        int i8;
        int i9;
        boolean z;
        final String str2;
        final Modifier modifier3;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        Modifier modifier4;
        EnterTransition enterTransitionPlus;
        ExitTransition exitTransitionPlus;
        String str3;
        AnimatedVisibilityKt$AnimatedVisibility$7$1 animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(657024243);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)377@21247L39,378@21326L6,378@21291L84:AnimatedVisibility.kt#xbi5r1");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(mutableTransitionState) : composerStartRestartGroup.changedInstance(mutableTransitionState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    enterTransition2 = enterTransition;
                    if (composerStartRestartGroup.changed(enterTransition2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        exitTransition2 = exitTransition;
                        if (composerStartRestartGroup.changed(exitTransition2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((196608 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i11 = 131072;
                            } else {
                                i11 = 65536;
                            }
                            i3 |= i11;
                        }
                        if ((74899 & i3) != 74898) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            str2 = str;
                            modifier3 = modifier2;
                            enterTransition3 = enterTransition2;
                            exitTransition3 = exitTransition2;
                        } else {
                            if (i12 != 0) {
                                modifier4 = Modifier.INSTANCE;
                                i10 = i8;
                            } else {
                                i10 = i8;
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                            } else {
                                enterTransitionPlus = enterTransition2;
                            }
                            if (i6 != 0) {
                                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                            } else {
                                exitTransitionPlus = exitTransition2;
                            }
                            if (i10 != 0) {
                                str3 = "AnimatedVisibility";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                            }
                            Transition transitionRememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                                    public final Boolean invoke(boolean z2) {
                                        return Boolean.valueOf(z2);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                            }
                            Function1 function1 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i13 = i3 << 3;
                            AnimatedVisibilityImpl(transitionRememberTransition, function1, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i13 & 57344) | (i13 & 896) | 48 | (i13 & 7168) | (i3 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier3 = modifier4;
                            enterTransition3 = enterTransitionPlus;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i14) {
                                    AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((74899 & i3) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str2 = str;
                        modifier3 = modifier2;
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    } else {
                        if (i12 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i10 = i8;
                        } else {
                            i10 = i8;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i10 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                        }
                        Transition transitionRememberTransition2 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                        }
                        Function1 function2 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i14 = i3 << 3;
                        AnimatedVisibilityImpl(transitionRememberTransition2, function2, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i14 & 57344) | (i14 & 896) | 48 | (i14 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition3 = enterTransitionPlus;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                exitTransition2 = exitTransition;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((74899 & i3) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str2 = str;
                        modifier3 = modifier2;
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    } else {
                        if (i12 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i10 = i8;
                        } else {
                            i10 = i8;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i10 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                        }
                        Transition transitionRememberTransition3 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                        }
                        Function1 function4 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i15 = i3 << 3;
                        AnimatedVisibilityImpl(transitionRememberTransition3, function4, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i15 & 57344) | (i15 & 896) | 48 | (i15 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition3 = enterTransitionPlus;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i16) {
                                AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                    }
                    Transition transitionRememberTransition4 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                    }
                    Function1 function5 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i16 = i3 << 3;
                    AnimatedVisibilityImpl(transitionRememberTransition4, function5, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i16 & 57344) | (i16 & 896) | 48 | (i16 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i17) {
                            AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            enterTransition2 = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((74899 & i3) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str2 = str;
                        modifier3 = modifier2;
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    } else {
                        if (i12 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i10 = i8;
                        } else {
                            i10 = i8;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i10 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                        }
                        Transition transitionRememberTransition5 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                        }
                        Function1 function6 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i17 = i3 << 3;
                        AnimatedVisibilityImpl(transitionRememberTransition5, function6, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i17 & 57344) | (i17 & 896) | 48 | (i17 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition3 = enterTransitionPlus;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i18) {
                                AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                    }
                    Transition transitionRememberTransition6 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                    }
                    Function1 function7 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i18 = i3 << 3;
                    AnimatedVisibilityImpl(transitionRememberTransition6, function7, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i18 & 57344) | (i18 & 896) | 48 | (i18 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i19) {
                            AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                    }
                    Transition transitionRememberTransition7 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                    }
                    Function1 function8 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i19 = i3 << 3;
                    AnimatedVisibilityImpl(transitionRememberTransition7, function8, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i19 & 57344) | (i19 & 896) | 48 | (i19 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i110) {
                            AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                enterTransition3 = enterTransition2;
                exitTransition3 = exitTransition2;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i10 = i8;
                } else {
                    i10 = i8;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i10 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                }
                Transition transitionRememberTransition8 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                }
                Function1 function9 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i110 = i3 << 3;
                AnimatedVisibilityImpl(transitionRememberTransition8, function9, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i110 & 57344) | (i110 & 896) | 48 | (i110 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition3 = enterTransitionPlus;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i111) {
                        AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                enterTransition2 = enterTransition;
                if (composerStartRestartGroup.changed(enterTransition2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i3 |= i11;
                    }
                    if ((74899 & i3) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str2 = str;
                        modifier3 = modifier2;
                        enterTransition3 = enterTransition2;
                        exitTransition3 = exitTransition2;
                    } else {
                        if (i12 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i10 = i8;
                        } else {
                            i10 = i8;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i10 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                        }
                        Transition transitionRememberTransition9 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                        }
                        Function1 function10 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i111 = i3 << 3;
                        AnimatedVisibilityImpl(transitionRememberTransition9, function10, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i111 & 57344) | (i111 & 896) | 48 | (i111 & 7168) | (i3 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition3 = enterTransitionPlus;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i112) {
                                AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                    }
                    Transition transitionRememberTransition10 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                    }
                    Function1 function11 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i112 = i3 << 3;
                    AnimatedVisibilityImpl(transitionRememberTransition10, function11, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i112 & 57344) | (i112 & 896) | 48 | (i112 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i113) {
                            AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                    }
                    Transition transitionRememberTransition11 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                    }
                    Function1 function12 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i113 = i3 << 3;
                    AnimatedVisibilityImpl(transitionRememberTransition11, function12, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i113 & 57344) | (i113 & 896) | 48 | (i113 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i114) {
                            AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                enterTransition3 = enterTransition2;
                exitTransition3 = exitTransition2;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i10 = i8;
                } else {
                    i10 = i8;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i10 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                }
                Transition transitionRememberTransition12 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                }
                Function1 function13 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i114 = i3 << 3;
                AnimatedVisibilityImpl(transitionRememberTransition12, function13, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i114 & 57344) | (i114 & 896) | 48 | (i114 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition3 = enterTransitionPlus;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i115) {
                        AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        enterTransition2 = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                exitTransition2 = exitTransition;
                if (composerStartRestartGroup.changed(exitTransition2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i3 |= i11;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    modifier3 = modifier2;
                    enterTransition3 = enterTransition2;
                    exitTransition3 = exitTransition2;
                } else {
                    if (i12 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i10 = i8;
                    } else {
                        i10 = i8;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i10 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                    }
                    Transition transitionRememberTransition13 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                    }
                    Function1 function14 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i115 = i3 << 3;
                    AnimatedVisibilityImpl(transitionRememberTransition13, function14, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i115 & 57344) | (i115 & 896) | 48 | (i115 & 7168) | (i3 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition3 = enterTransitionPlus;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i116) {
                            AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                enterTransition3 = enterTransition2;
                exitTransition3 = exitTransition2;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i10 = i8;
                } else {
                    i10 = i8;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i10 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                }
                Transition transitionRememberTransition14 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                }
                Function1 function15 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i116 = i3 << 3;
                AnimatedVisibilityImpl(transitionRememberTransition14, function15, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i116 & 57344) | (i116 & 896) | 48 | (i116 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition3 = enterTransitionPlus;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i117) {
                        AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        exitTransition2 = exitTransition;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i3 |= i11;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                modifier3 = modifier2;
                enterTransition3 = enterTransition2;
                exitTransition3 = exitTransition2;
            } else {
                if (i12 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i10 = i8;
                } else {
                    i10 = i8;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i10 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
                }
                Transition transitionRememberTransition15 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
                }
                Function1 function16 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i117 = i3 << 3;
                AnimatedVisibilityImpl(transitionRememberTransition15, function16, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i117 & 57344) | (i117 & 896) | 48 | (i117 & 7168) | (i3 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition3 = enterTransitionPlus;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i118) {
                        AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i3 |= i11;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            str2 = str;
            modifier3 = modifier2;
            enterTransition3 = enterTransition2;
            exitTransition3 = exitTransition2;
        } else {
            if (i12 != 0) {
                modifier4 = Modifier.INSTANCE;
                i10 = i8;
            } else {
                i10 = i8;
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
            } else {
                enterTransitionPlus = enterTransition2;
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i10 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(657024243, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:376)");
            }
            Transition transitionRememberTransition16 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i3 & 14) | ((i3 >> 9) & 112), 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 40118553, "CC(remember):AnimatedVisibility.kt#9igjgp");
            animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$7$1
                    public final Boolean invoke(boolean z2) {
                        return Boolean.valueOf(z2);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue);
            }
            Function1 function17 = (Function1) animatedVisibilityKt$AnimatedVisibility$7$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i118 = i3 << 3;
            AnimatedVisibilityImpl(transitionRememberTransition16, function17, modifier4, enterTransitionPlus, exitTransitionPlus, function3, composerStartRestartGroup, (i118 & 57344) | (i118 & 896) | 48 | (i118 & 7168) | (i3 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
            modifier3 = modifier4;
            enterTransition3 = enterTransitionPlus;
            exitTransition3 = exitTransitionPlus;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i119) {
                    AnimatedVisibilityKt.AnimatedVisibility(mutableTransitionState, modifier3, enterTransition3, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:78:0x0108  */
    /* JADX WARN: Code duplicated, block: B:80:0x010b  */
    /* JADX WARN: Code duplicated, block: B:81:0x010e  */
    /* JADX WARN: Code duplicated, block: B:84:0x0116  */
    /* JADX WARN: Code duplicated, block: B:87:0x0146  */
    /* JADX WARN: Code duplicated, block: B:90:0x016e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0176  */
    /* JADX WARN: Code duplicated, block: B:95:0x0184  */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(final RowScope rowScope, final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransitionPlus;
        int i5;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        int i8;
        int i9;
        boolean z;
        final Modifier modifier3;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition3;
        final String str2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        ExitTransition exitTransitionPlus;
        String str3;
        AnimatedVisibilityKt$AnimatedVisibility$9$1 animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1763490971);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)449@25685L39,450@25764L6,450@25729L84:AnimatedVisibility.kt#xbi5r1");
        if ((i & 48) == 0) {
            i3 = ((i & 64) == 0 ? composerStartRestartGroup.changed(mutableTransitionState) : composerStartRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    enterTransitionPlus = enterTransition;
                    if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        if (composerStartRestartGroup.changed(exitTransition2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((1572864 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                        if ((599185 & i3) != 599184) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition2 = enterTransitionPlus;
                            exitTransition3 = exitTransition2;
                            str2 = str;
                        } else {
                            if (i11 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            }
                            if (i6 != 0) {
                                exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                            } else {
                                exitTransitionPlus = exitTransition2;
                            }
                            if (i8 != 0) {
                                str3 = "AnimatedVisibility";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                            }
                            int i12 = i3 >> 3;
                            Transition transitionRememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i12 & 14) | ((i3 >> 12) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                                    public final Boolean invoke(boolean z2) {
                                        return Boolean.valueOf(z2);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EnterTransition enterTransition3 = enterTransitionPlus;
                            AnimatedVisibilityImpl(transitionRememberTransition, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition3, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i12));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier3 = modifier4;
                            enterTransition2 = enterTransition3;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                        }
                        int i13 = i3 >> 3;
                        Transition transitionRememberTransition2 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i13 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition4 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionRememberTransition2, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition4, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i13));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition4;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i14) {
                                AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                exitTransition2 = exitTransition;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                        }
                        int i14 = i3 >> 3;
                        Transition transitionRememberTransition3 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i14 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition5 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionRememberTransition3, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition5, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition5;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                    }
                    int i15 = i3 >> 3;
                    Transition transitionRememberTransition4 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i15 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition6 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition4, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition6, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i15));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition6;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i16) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            enterTransitionPlus = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                        }
                        int i16 = i3 >> 3;
                        Transition transitionRememberTransition5 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i16 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition7 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionRememberTransition5, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition7, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i16));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition7;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i17) {
                                AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                    }
                    int i17 = i3 >> 3;
                    Transition transitionRememberTransition6 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i17 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition8 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition6, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition8, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i17));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition8;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i18) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                    }
                    int i18 = i3 >> 3;
                    Transition transitionRememberTransition7 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i18 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition9 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition7, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition9, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i18));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition9;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i19) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                }
                int i19 = i3 >> 3;
                Transition transitionRememberTransition8 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i19 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition10 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionRememberTransition8, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition10, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i19));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition10;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i110) {
                        AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                enterTransitionPlus = enterTransition;
                if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                        }
                        int i110 = i3 >> 3;
                        Transition transitionRememberTransition9 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i110 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition11 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionRememberTransition9, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition11, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i110));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition11;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i111) {
                                AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                    }
                    int i111 = i3 >> 3;
                    Transition transitionRememberTransition10 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i111 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition12 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition10, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition12, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i111));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition12;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i112) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                    }
                    int i112 = i3 >> 3;
                    Transition transitionRememberTransition11 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i112 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition13 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition11, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition13, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition13;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i113) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                }
                int i113 = i3 >> 3;
                Transition transitionRememberTransition12 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i113 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition14 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionRememberTransition12, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition14, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i113));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition14;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i114) {
                        AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        enterTransitionPlus = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                exitTransition2 = exitTransition;
                if (composerStartRestartGroup.changed(exitTransition2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                    }
                    int i114 = i3 >> 3;
                    Transition transitionRememberTransition13 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i114 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition15 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition13, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition15, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i114));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition15;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i115) {
                            AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                }
                int i115 = i3 >> 3;
                Transition transitionRememberTransition14 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i115 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition16 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionRememberTransition14, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition16, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i115));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition16;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i116) {
                        AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        exitTransition2 = exitTransition;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
                }
                int i116 = i3 >> 3;
                Transition transitionRememberTransition15 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i116 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition17 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionRememberTransition15, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition17, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i116));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition17;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i117) {
                        AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        if ((599185 & i3) != 599184) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            enterTransition2 = enterTransitionPlus;
            exitTransition3 = exitTransition2;
            str2 = str;
        } else {
            if (i11 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.expandHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.shrinkHorizontally$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i8 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1763490971, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:448)");
            }
            int i117 = i3 >> 3;
            Transition transitionRememberTransition16 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i117 & 14) | ((i3 >> 12) & 112), 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1797244351, "CC(remember):AnimatedVisibility.kt#9igjgp");
            animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$9$1
                    public final Boolean invoke(boolean z2) {
                        return Boolean.valueOf(z2);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EnterTransition enterTransition18 = enterTransitionPlus;
            AnimatedVisibilityImpl(transitionRememberTransition16, (Function1) animatedVisibilityKt$AnimatedVisibility$9$1RememberedValue, modifier4, enterTransition18, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i117));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
            modifier3 = modifier4;
            enterTransition2 = enterTransition18;
            exitTransition3 = exitTransitionPlus;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i118) {
                    AnimatedVisibilityKt.AnimatedVisibility(rowScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:78:0x0108  */
    /* JADX WARN: Code duplicated, block: B:80:0x010b  */
    /* JADX WARN: Code duplicated, block: B:81:0x010e  */
    /* JADX WARN: Code duplicated, block: B:84:0x0116  */
    /* JADX WARN: Code duplicated, block: B:87:0x0146  */
    /* JADX WARN: Code duplicated, block: B:90:0x016e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0176  */
    /* JADX WARN: Code duplicated, block: B:95:0x0184  */
    /* JADX WARN: Code duplicated, block: B:97:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedVisibility(final ColumnScope columnScope, final MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        EnterTransition enterTransitionPlus;
        int i5;
        int i6;
        ExitTransition exitTransition2;
        int i7;
        int i8;
        int i9;
        boolean z;
        final Modifier modifier3;
        final EnterTransition enterTransition2;
        final ExitTransition exitTransition3;
        final String str2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        ExitTransition exitTransitionPlus;
        String str3;
        AnimatedVisibilityKt$AnimatedVisibility$11$1 animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1238803325);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibility)P(5,4,1,2,3)523@30218L39,524@30297L6,524@30262L84:AnimatedVisibility.kt#xbi5r1");
        if ((i & 48) == 0) {
            i3 = ((i & 64) == 0 ? composerStartRestartGroup.changed(mutableTransitionState) : composerStartRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    enterTransitionPlus = enterTransition;
                    if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        exitTransition2 = exitTransition;
                        if (composerStartRestartGroup.changed(exitTransition2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            if (composerStartRestartGroup.changed(str)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((1572864 & i) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i3 |= i10;
                        }
                        if ((599185 & i3) != 599184) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            enterTransition2 = enterTransitionPlus;
                            exitTransition3 = exitTransition2;
                            str2 = str;
                        } else {
                            if (i11 != 0) {
                                modifier4 = Modifier.INSTANCE;
                            } else {
                                modifier4 = modifier2;
                            }
                            if (i4 != 0) {
                                enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                            }
                            if (i6 != 0) {
                                exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                            } else {
                                exitTransitionPlus = exitTransition2;
                            }
                            if (i8 != 0) {
                                str3 = "AnimatedVisibility";
                            } else {
                                str3 = str;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                            }
                            int i12 = i3 >> 3;
                            Transition transitionRememberTransition = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i12 & 14) | ((i3 >> 12) & 112), 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                            animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                                    public final Boolean invoke(boolean z2) {
                                        return Boolean.valueOf(z2);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                        return invoke(bool.booleanValue());
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EnterTransition enterTransition3 = enterTransitionPlus;
                            AnimatedVisibilityImpl(transitionRememberTransition, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition3, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i12));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            str2 = str3;
                            modifier3 = modifier4;
                            enterTransition2 = enterTransition3;
                            exitTransition3 = exitTransitionPlus;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                        }
                        int i13 = i3 >> 3;
                        Transition transitionRememberTransition2 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i13 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition4 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionRememberTransition2, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition4, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i13));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition4;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i14) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                exitTransition2 = exitTransition;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                        }
                        int i14 = i3 >> 3;
                        Transition transitionRememberTransition3 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i14 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition5 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionRememberTransition3, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition5, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition5;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                    }
                    int i15 = i3 >> 3;
                    Transition transitionRememberTransition4 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i15 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition6 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition4, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition6, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i15));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition6;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i16) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            enterTransitionPlus = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                        }
                        int i16 = i3 >> 3;
                        Transition transitionRememberTransition5 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i16 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition7 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionRememberTransition5, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition7, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i16));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition7;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i17) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                    }
                    int i17 = i3 >> 3;
                    Transition transitionRememberTransition6 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i17 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition8 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition6, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition8, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i17));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition8;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i18) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                    }
                    int i18 = i3 >> 3;
                    Transition transitionRememberTransition7 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i18 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition9 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition7, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition9, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i18));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition9;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i19) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                }
                int i19 = i3 >> 3;
                Transition transitionRememberTransition8 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i19 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition10 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionRememberTransition8, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition10, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i19));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition10;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i110) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                enterTransitionPlus = enterTransition;
                if (composerStartRestartGroup.changed(enterTransitionPlus)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    exitTransition2 = exitTransition;
                    if (composerStartRestartGroup.changed(exitTransition2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i3 |= i10;
                    }
                    if ((599185 & i3) != 599184) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        enterTransition2 = enterTransitionPlus;
                        exitTransition3 = exitTransition2;
                        str2 = str;
                    } else {
                        if (i11 != 0) {
                            modifier4 = Modifier.INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition2;
                        }
                        if (i8 != 0) {
                            str3 = "AnimatedVisibility";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                        }
                        int i110 = i3 >> 3;
                        Transition transitionRememberTransition9 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i110 & 14) | ((i3 >> 12) & 112), 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                                public final Boolean invoke(boolean z2) {
                                    return Boolean.valueOf(z2);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                    return invoke(bool.booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EnterTransition enterTransition11 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transitionRememberTransition9, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition11, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i110));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        enterTransition2 = enterTransition11;
                        exitTransition3 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i111) {
                                AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                    }
                    int i111 = i3 >> 3;
                    Transition transitionRememberTransition10 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i111 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition12 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition10, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition12, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i111));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition12;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i112) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            exitTransition2 = exitTransition;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                    }
                    int i112 = i3 >> 3;
                    Transition transitionRememberTransition11 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i112 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition13 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition11, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition13, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition13;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i113) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                }
                int i113 = i3 >> 3;
                Transition transitionRememberTransition12 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i113 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition14 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionRememberTransition12, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition14, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i113));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition14;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i114) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        enterTransitionPlus = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                exitTransition2 = exitTransition;
                if (composerStartRestartGroup.changed(exitTransition2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i3 |= i10;
                }
                if ((599185 & i3) != 599184) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    enterTransition2 = enterTransitionPlus;
                    exitTransition3 = exitTransition2;
                    str2 = str;
                } else {
                    if (i11 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition2;
                    }
                    if (i8 != 0) {
                        str3 = "AnimatedVisibility";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                    }
                    int i114 = i3 >> 3;
                    Transition transitionRememberTransition13 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i114 & 14) | ((i3 >> 12) & 112), 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                            public final Boolean invoke(boolean z2) {
                                return Boolean.valueOf(z2);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                                return invoke(bool.booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransition15 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transitionRememberTransition13, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition15, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i114));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    enterTransition2 = enterTransition15;
                    exitTransition3 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i115) {
                            AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                }
                int i115 = i3 >> 3;
                Transition transitionRememberTransition14 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i115 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition16 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionRememberTransition14, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition16, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i115));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition16;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i116) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        exitTransition2 = exitTransition;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((1572864 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i3 |= i10;
            }
            if ((599185 & i3) != 599184) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                enterTransition2 = enterTransitionPlus;
                exitTransition3 = exitTransition2;
                str2 = str;
            } else {
                if (i11 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition2;
                }
                if (i8 != 0) {
                    str3 = "AnimatedVisibility";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
                }
                int i116 = i3 >> 3;
                Transition transitionRememberTransition15 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i116 & 14) | ((i3 >> 12) & 112), 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
                animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                            return invoke(bool.booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EnterTransition enterTransition17 = enterTransitionPlus;
                AnimatedVisibilityImpl(transitionRememberTransition15, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition17, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i116));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                enterTransition2 = enterTransition17;
                exitTransition3 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i117) {
                        AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((1572864 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 1048576;
            } else {
                i10 = 524288;
            }
            i3 |= i10;
        }
        if ((599185 & i3) != 599184) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            enterTransition2 = enterTransitionPlus;
            exitTransition3 = exitTransition2;
            str2 = str;
        } else {
            if (i11 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null));
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
            } else {
                exitTransitionPlus = exitTransition2;
            }
            if (i8 != 0) {
                str3 = "AnimatedVisibility";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1238803325, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:522)");
            }
            int i117 = i3 >> 3;
            Transition transitionRememberTransition16 = androidx.compose.animation.core.TransitionKt.rememberTransition(mutableTransitionState, str3, composerStartRestartGroup, MutableTransitionState.$stable | (i117 & 14) | ((i3 >> 12) & 112), 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -784039927, "CC(remember):AnimatedVisibility.kt#9igjgp");
            animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue = new Function1<Boolean, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibility$11$1
                    public final Boolean invoke(boolean z2) {
                        return Boolean.valueOf(z2);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                        return invoke(bool.booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EnterTransition enterTransition18 = enterTransitionPlus;
            AnimatedVisibilityImpl(transitionRememberTransition16, (Function1) animatedVisibilityKt$AnimatedVisibility$11$1RememberedValue, modifier4, enterTransition18, exitTransitionPlus, function3, composerStartRestartGroup, (i3 & 896) | 48 | (i3 & 7168) | (i3 & 57344) | (458752 & i117));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
            modifier3 = modifier4;
            enterTransition2 = enterTransition18;
            exitTransition3 = exitTransitionPlus;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.12
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i118) {
                    AnimatedVisibilityKt.AnimatedVisibility(columnScope, mutableTransitionState, modifier3, enterTransition2, exitTransition3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

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
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:78:0x010e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0115  */
    /* JADX WARN: Code duplicated, block: B:83:0x0121  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    public static final <T> void AnimatedVisibility(final Transition<T> transition, final Function1<? super T, Boolean> function1, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        EnterTransition enterTransition2;
        int i5;
        int i6;
        int i7;
        boolean z;
        final EnterTransition enterTransition3;
        final ExitTransition exitTransition2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        EnterTransition enterTransitionPlus;
        ExitTransition exitTransitionPlus;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1699747442);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibility)P(4,3,1,2)593@34536L79:AnimatedVisibility.kt#xbi5r1");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    enterTransition2 = enterTransition;
                    if (composerStartRestartGroup.changed(enterTransition2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(exitTransition)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i8 = 131072;
                        } else {
                            i8 = 65536;
                        }
                        i3 |= i8;
                    }
                    if ((74899 & i3) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        enterTransition3 = enterTransition2;
                        exitTransition2 = exitTransition;
                    } else {
                        if (i9 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                        } else {
                            enterTransitionPlus = enterTransition2;
                        }
                        if (i6 != 0) {
                            exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                        } else {
                            exitTransitionPlus = exitTransition;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1699747442, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
                        }
                        EnterTransition enterTransition4 = enterTransitionPlus;
                        AnimatedVisibilityImpl(transition, function1, modifier3, enterTransition4, exitTransitionPlus, function3, composerStartRestartGroup, i3 & 524286);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        enterTransition3 = enterTransition4;
                        exitTransition2 = exitTransitionPlus;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i10) {
                                AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    enterTransition3 = enterTransition2;
                    exitTransition2 = exitTransition;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1699747442, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
                    }
                    EnterTransition enterTransition5 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transition, function1, modifier3, enterTransition5, exitTransitionPlus, function3, composerStartRestartGroup, i3 & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    enterTransition3 = enterTransition5;
                    exitTransition2 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i10) {
                            AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            enterTransition2 = enterTransition;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(exitTransition)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    enterTransition3 = enterTransition2;
                    exitTransition2 = exitTransition;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1699747442, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
                    }
                    EnterTransition enterTransition6 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transition, function1, modifier3, enterTransition6, exitTransitionPlus, function3, composerStartRestartGroup, i3 & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    enterTransition3 = enterTransition6;
                    exitTransition2 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i10) {
                            AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                enterTransition3 = enterTransition2;
                exitTransition2 = exitTransition;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1699747442, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
                }
                EnterTransition enterTransition7 = enterTransitionPlus;
                AnimatedVisibilityImpl(transition, function1, modifier3, enterTransition7, exitTransitionPlus, function3, composerStartRestartGroup, i3 & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                enterTransition3 = enterTransition7;
                exitTransition2 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i10) {
                        AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                enterTransition2 = enterTransition;
                if (composerStartRestartGroup.changed(enterTransition2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(exitTransition)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    enterTransition3 = enterTransition2;
                    exitTransition2 = exitTransition;
                } else {
                    if (i9 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                    } else {
                        enterTransitionPlus = enterTransition2;
                    }
                    if (i6 != 0) {
                        exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                    } else {
                        exitTransitionPlus = exitTransition;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1699747442, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
                    }
                    EnterTransition enterTransition8 = enterTransitionPlus;
                    AnimatedVisibilityImpl(transition, function1, modifier3, enterTransition8, exitTransitionPlus, function3, composerStartRestartGroup, i3 & 524286);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    enterTransition3 = enterTransition8;
                    exitTransition2 = exitTransitionPlus;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i10) {
                            AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                enterTransition3 = enterTransition2;
                exitTransition2 = exitTransition;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1699747442, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
                }
                EnterTransition enterTransition9 = enterTransitionPlus;
                AnimatedVisibilityImpl(transition, function1, modifier3, enterTransition9, exitTransitionPlus, function3, composerStartRestartGroup, i3 & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                enterTransition3 = enterTransition9;
                exitTransition2 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i10) {
                        AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        enterTransition2 = enterTransition;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(exitTransition)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                enterTransition3 = enterTransition2;
                exitTransition2 = exitTransition;
            } else {
                if (i9 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
                } else {
                    enterTransitionPlus = enterTransition2;
                }
                if (i6 != 0) {
                    exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
                } else {
                    exitTransitionPlus = exitTransition;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1699747442, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
                }
                EnterTransition enterTransition10 = enterTransitionPlus;
                AnimatedVisibilityImpl(transition, function1, modifier3, enterTransition10, exitTransitionPlus, function3, composerStartRestartGroup, i3 & 524286);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                enterTransition3 = enterTransition10;
                exitTransition2 = exitTransitionPlus;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i10) {
                        AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            enterTransition3 = enterTransition2;
            exitTransition2 = exitTransition;
        } else {
            if (i9 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
            } else {
                enterTransitionPlus = enterTransition2;
            }
            if (i6 != 0) {
                exitTransitionPlus = EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null).plus(EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null));
            } else {
                exitTransitionPlus = exitTransition;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1699747442, i3, -1, "androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:593)");
            }
            EnterTransition enterTransition11 = enterTransitionPlus;
            AnimatedVisibilityImpl(transition, function1, modifier3, enterTransition11, exitTransitionPlus, function3, composerStartRestartGroup, i3 & 524286);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            enterTransition3 = enterTransition11;
            exitTransition2 = exitTransitionPlus;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility.13
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    AnimatedVisibilityKt.AnimatedVisibility(transition, function1, modifier2, enterTransition3, exitTransition2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final <T> void AnimatedVisibilityImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        ExitTransition exitTransition2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1706321816);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedVisibilityImpl)P(4,5,3,1,2)682@38821L423,694@39319L62,678@38691L724:AnimatedVisibility.kt#xbi5r1");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(enterTransition) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            exitTransition2 = exitTransition;
            i2 |= composerStartRestartGroup.changed(exitTransition2) ? 16384 : 8192;
        } else {
            exitTransition2 = exitTransition;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1706321816, i2, -1, "androidx.compose.animation.AnimatedVisibilityImpl (AnimatedVisibility.kt:677)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -902229601, "CC(remember):AnimatedVisibility.kt#9igjgp");
            int i3 = i2 & 112;
            int i4 = i2 & 14;
            boolean z = (i3 == 32) | (i4 == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m375invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* JADX WARN: Type inference incomplete: some casts might be missing */
                    /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m375invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        long jM9853constructorimpl;
                        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(j);
                        if (measureScope.isLookingAhead() && !function1.invoke((T) transition.getTargetState()).booleanValue()) {
                            jM9853constructorimpl = IntSize.INSTANCE.m9863getZeroYbymL2g();
                        } else {
                            jM9853constructorimpl = IntSize.m9853constructorimpl((((long) placeableMo8265measureBRTryo0.getWidth()) << 32) | (((long) placeableMo8265measureBRTryo0.getHeight()) & 4294967295L));
                        }
                        return MeasureScope.layout$default(measureScope, (int) (jM9853constructorimpl >> 32), (int) (jM9853constructorimpl & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$1$1.1
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
                                Placeable.PlacementScope.place$default(placementScope, placeableMo8265measureBRTryo0, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayout = LayoutModifierKt.layout(modifier, (Function3) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -902214026, "CC(remember):AnimatedVisibility.kt#9igjgp");
            AnimatedVisibilityKt$AnimatedVisibilityImpl$2$1 animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue = new Function2<EnterExitState, EnterExitState, Boolean>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedVisibilityImpl$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public final Boolean invoke(EnterExitState enterExitState, EnterExitState enterExitState2) {
                        return Boolean.valueOf(enterExitState == enterExitState2 && enterExitState2 == EnterExitState.PostExit);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnimatedEnterExitImpl(transition, function1, modifierLayout, enterTransition, exitTransition2, (Function2) animatedVisibilityKt$AnimatedVisibilityImpl$2$1RememberedValue, null, function3, composerStartRestartGroup, i3 | 196608 | i4 | (i2 & 7168) | (57344 & i2) | ((i2 << 6) & 29360128), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibilityImpl.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    AnimatedVisibilityKt.AnimatedVisibilityImpl(transition, function1, modifier, enterTransition, exitTransition, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final <T> void AnimatedEnterExitImpl(final Transition<T> transition, final Function1<? super T, Boolean> function1, final Modifier modifier, final EnterTransition enterTransition, final ExitTransition exitTransition, final Function2<? super EnterExitState, ? super EnterExitState, Boolean> function2, OnLookaheadMeasured onLookaheadMeasured, final Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer composer2;
        Modifier.Companion companionLayout;
        final OnLookaheadMeasured onLookaheadMeasured2 = onLookaheadMeasured;
        Composer composerStartRestartGroup = composer.startRestartGroup(1912839215);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedEnterExitImpl)P(6,7,3,1,2,5,4):AnimatedVisibility.kt#xbi5r1");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(transition) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(enterTransition) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(exitTransition) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        int i4 = i2 & 64;
        int i5 = 1572864;
        if (i4 != 0) {
            i3 |= i5;
        } else if ((1572864 & i) == 0) {
            i5 = (i & 2097152) == 0 ? composerStartRestartGroup.changed(onLookaheadMeasured2) : composerStartRestartGroup.changedInstance(onLookaheadMeasured2) ? 1048576 : 524288;
            i3 |= i5;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        int i6 = i3;
        boolean z = true;
        if (!composerStartRestartGroup.shouldExecute((4793491 & i6) != 4793490, i6 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                onLookaheadMeasured2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1912839215, i6, -1, "androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:715)");
            }
            if (!function1.invoke(transition.getTargetState()).booleanValue() && !function1.invoke(transition.getCurrentState()).booleanValue() && !transition.isSeeking() && !transition.getHasInitialValueAnimations()) {
                composerStartRestartGroup.startReplaceGroup(-272333293);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(-232413539);
                ComposerKt.sourceInformation(composerStartRestartGroup, "723@40225L124,727@40392L40,733@40641L529,730@40484L686");
                int i7 = i6 & 14;
                int i8 = i7 | 48;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -539313577, "CC(createChildTransition)N(label,transformToChildState)1768@75281L36,1769@75341L74,1770@75438L39,1771@75489L63:Transition.kt#pdpnli");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1410701659, "CC(remember):Transition.kt#9igjgp");
                int i9 = i8 & 14;
                boolean z2 = ((i9 ^ 6) > 4 && composerStartRestartGroup.changed(transition)) || (i8 & 6) == 4;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = transition.getCurrentState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (transition.isSeeking()) {
                    objRememberedValue = transition.getCurrentState();
                }
                composerStartRestartGroup.startReplaceGroup(1844425648);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C724@40307L28:AnimatedVisibility.kt#xbi5r1");
                OnLookaheadMeasured onLookaheadMeasured3 = onLookaheadMeasured2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1844425648, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:724)");
                }
                int i10 = i6 & 126;
                EnterExitState enterExitStateTargetEnterExit = targetEnterExit(transition, function1, objRememberedValue, composerStartRestartGroup, i10);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                T targetState = transition.getTargetState();
                composerStartRestartGroup.startReplaceGroup(1844425648);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C724@40307L28:AnimatedVisibility.kt#xbi5r1");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1844425648, 0, -1, "androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:724)");
                }
                EnterExitState enterExitStateTargetEnterExit2 = targetEnterExit(transition, function1, targetState, composerStartRestartGroup, i10);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composerStartRestartGroup.endReplaceGroup();
                Transition transitionCreateChildTransitionInternal = androidx.compose.animation.core.TransitionKt.createChildTransitionInternal(transition, enterExitStateTargetEnterExit, enterExitStateTargetEnterExit2, "EnterExitTransition", composerStartRestartGroup, i9 | 3072);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i6 >> 15) & 14);
                Boolean boolInvoke = function2.invoke(transitionCreateChildTransitionInternal.getCurrentState(), transitionCreateChildTransitionInternal.getTargetState());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7483872, "CC(remember):AnimatedVisibility.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(transitionCreateChildTransitionInternal) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1 animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue = new AnimatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1(transitionCreateChildTransitionInternal, stateRememberUpdatedState, null);
                    composerStartRestartGroup.updateRememberedValue(animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                State stateProduceState = SnapshotStateKt.produceState(boolInvoke, (Function2) animatedVisibilityKt$AnimatedEnterExitImpl$shouldDisposeAfterExit$2$1RememberedValue, composerStartRestartGroup, 0);
                if (getExitFinished(transitionCreateChildTransitionInternal) && AnimatedEnterExitImpl$lambda$3(stateProduceState)) {
                    composerStartRestartGroup.startReplaceGroup(-272333293);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    onLookaheadMeasured2 = onLookaheadMeasured3;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-231383533);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "749@41268L69,755@41536L47,769@42351L50,750@41350L1066");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7464268, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    boolean z3 = i7 == 4;
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new AnimatedVisibilityScopeImpl(transitionCreateChildTransitionInternal);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    AnimatedVisibilityScopeImpl animatedVisibilityScopeImpl = (AnimatedVisibilityScopeImpl) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i11 = i6 >> 6;
                    onLookaheadMeasured2 = onLookaheadMeasured3;
                    Modifier modifierCreateModifier = EnterExitTransitionKt.createModifier(transitionCreateChildTransitionInternal, enterTransition, exitTransition, null, "Built-in", composerStartRestartGroup, (i11 & 112) | 24576 | (i11 & 896), 4);
                    composer2 = composerStartRestartGroup;
                    if (onLookaheadMeasured2 != null) {
                        composer2.startReplaceGroup(-230964196);
                        ComposerKt.sourceInformation(composer2, "758@41738L479");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -7448818, "CC(remember):AnimatedVisibility.kt#9igjgp");
                        if ((3670016 & i6) != 1048576 && ((i6 & 2097152) == 0 || !composer2.changedInstance(onLookaheadMeasured2))) {
                            z = false;
                        }
                        Object objRememberedValue3 = composer2.rememberedValue();
                        if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                    return m374invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                }

                                /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                                public final MeasureResult m374invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                    final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(j);
                                    OnLookaheadMeasured onLookaheadMeasured4 = onLookaheadMeasured2;
                                    if (measureScope.isLookingAhead()) {
                                        onLookaheadMeasured4.m416invokeozmzZPI(IntSize.m9853constructorimpl((((long) placeableMo8265measureBRTryo0.getHeight()) & 4294967295L) | (((long) placeableMo8265measureBRTryo0.getWidth()) << 32)));
                                    }
                                    return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$2$1$1$1
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
                                            Placeable.PlacementScope.place$default(placementScope, placeableMo8265measureBRTryo0, 0, 0, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        companionLayout = LayoutModifierKt.layout(companion, (Function3) objRememberedValue3);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-7432681);
                        composer2.endReplaceGroup();
                        companionLayout = Modifier.INSTANCE;
                    }
                    Modifier modifierThen = modifier.then(modifierCreateModifier.then(companionLayout));
                    ComposerKt.sourceInformationMarkerStart(composer2, -7429631, "CC(remember):AnimatedVisibility.kt#9igjgp");
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new AnimatedEnterExitMeasurePolicy(animatedVisibilityScopeImpl);
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    AnimatedEnterExitMeasurePolicy animatedEnterExitMeasurePolicy = (AnimatedEnterExitMeasurePolicy) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierThen);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, animatedEnterExitMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -1766274760, "C751@41392L9:AnimatedVisibility.kt#xbi5r1");
                    function3.invoke(animatedVisibilityScopeImpl, composer2, Integer.valueOf((i6 >> 18) & 112));
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final OnLookaheadMeasured onLookaheadMeasured4 = onLookaheadMeasured2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.AnimatedVisibilityKt.AnimatedEnterExitImpl.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i12) {
                    AnimatedVisibilityKt.AnimatedEnterExitImpl(transition, function1, modifier, enterTransition, exitTransition, function2, onLookaheadMeasured4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getExitFinished(Transition<EnterExitState> transition) {
        return transition.getCurrentState() == EnterExitState.PostExit && transition.getTargetState() == EnterExitState.PostExit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> EnterExitState targetEnterExit(Transition<T> transition, Function1<? super T, Boolean> function1, T t, Composer composer, int i) {
        EnterExitState enterExitState;
        ComposerKt.sourceInformationMarkerStart(composer, 361571134, "C(targetEnterExit)P(1):AnimatedVisibility.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(361571134, i, -1, "androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:833)");
        }
        composer.startMovableGroup(-422486745, transition);
        ComposerKt.sourceInformation(composer, "");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(-212166497);
            composer.endReplaceGroup();
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
        } else {
            composer.startReplaceGroup(-211892364);
            ComposerKt.sourceInformation(composer, "845@44894L34");
            ComposerKt.sourceInformationMarkerStart(composer, -422476640, "CC(remember):AnimatedVisibility.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (function1.invoke(transition.getCurrentState()).booleanValue()) {
                mutableState.setValue(true);
            }
            if (function1.invoke(t).booleanValue()) {
                enterExitState = EnterExitState.Visible;
            } else if (((Boolean) mutableState.getValue()).booleanValue()) {
                enterExitState = EnterExitState.PostExit;
            } else {
                enterExitState = EnterExitState.PreEnter;
            }
            composer.endReplaceGroup();
        }
        composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterExitState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<EnterExitState, EnterExitState, Boolean> AnimatedEnterExitImpl$lambda$1(State<? extends Function2<? super EnterExitState, ? super EnterExitState, Boolean>> state) {
        return (Function2) state.getValue();
    }

    private static final boolean AnimatedEnterExitImpl$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
