package androidx.compose.material3;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.internal.BasicTooltipKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.window.PopupPositionProvider;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Label.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a^\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0002\u0010\u000f\u001a%\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Label", "", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TooltipScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPersistent", "", "content", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "HandleInteractions", "enabled", "state", "Landroidx/compose/material3/TooltipState;", "(ZLandroidx/compose/material3/TooltipState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LabelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleInteractions$lambda$1(boolean z, TooltipState tooltipState, MutableInteractionSource mutableInteractionSource, int i, Composer composer, int i2) {
        HandleInteractions(z, tooltipState, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$6(Function3 function3, Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, Function2 function2, int i, int i2, Composer composer, int i3) {
        Label(function3, modifier, mutableInteractionSource, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:24:0x0048  */
    /* JADX WARN: Code duplicated, block: B:26:0x004c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00df  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:78:0x010d  */
    /* JADX WARN: Code duplicated, block: B:80:0x012a  */
    /* JADX WARN: Code duplicated, block: B:82:0x013f  */
    /* JADX WARN: Code duplicated, block: B:85:0x0177  */
    /* JADX WARN: Code duplicated, block: B:88:0x0197  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:93:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:96:0x0206  */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v17, types: [T, androidx.compose.runtime.MutableState] */
    public static final void Label(final Function3<? super TooltipScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, MutableInteractionSource mutableInteractionSource, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        int i5;
        int i6;
        boolean z2;
        int i7;
        boolean z3;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource4;
        boolean z5;
        MutableInteractionSource mutableInteractionSource5;
        PopupPositionProvider popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
        PopupPositionProvider popupPositionProvider;
        LabelStateImpl labelStateImplRememberBasicTooltipState;
        final Ref.ObjectRef objectRef;
        Object objRememberedValue;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-458575864);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Label)N(label,modifier,interactionSource,isPersistent,content)74@3260L60,79@3521L33,80@3571L71,82@3693L103,88@3882L17,86@3802L250,95@4057L128:Label.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((i3 & 9363) != 9362) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z4 = z2;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if (i6 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-458575864, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
                        }
                        if (mutableInteractionSource4 == null) {
                            composerStartRestartGroup.startReplaceGroup(857710899);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "71@3114L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690236079, "CC(remember):Label.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue4;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1690235428);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource5 = mutableInteractionSource4;
                        }
                        popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss = TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2);
                        if (z5) {
                            composerStartRestartGroup.startReplaceGroup(857957597);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "76@3363L29");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690244037, "CC(remember):Label.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new LabelStateImpl(false, false, 3, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            labelStateImplRememberBasicTooltipState = (LabelStateImpl) objRememberedValue3;
                            popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1690245440);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@3406L56");
                            popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                            labelStateImplRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), composerStartRestartGroup, 0, 3);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        TooltipState tooltipState = labelStateImplRememberBasicTooltipState;
                        objectRef = new Ref.ObjectRef();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690249097, "CC(remember):Label.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        objectRef.element = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690250735, "CC(remember):Label.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return LabelKt.Label$lambda$3$0(objectRef);
                                }
                            }, popupPositionProvider);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        final TooltipScopeImpl tooltipScopeImpl = (TooltipScopeImpl) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LabelKt.Label$lambda$5(function3, tooltipScopeImpl, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), tooltipState, companion, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LabelKt.Label$lambda$4(objectRef, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 7168) | 102432816, Token.DOTDOT);
                        composerStartRestartGroup = composerStartRestartGroup;
                        HandleInteractions(!z5, tooltipState, mutableInteractionSource5, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        z4 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LabelKt.Label$lambda$6(function3, modifier3, mutableInteractionSource3, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                z2 = z;
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-458575864, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composerStartRestartGroup.startReplaceGroup(857710899);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3114L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690236079, "CC(remember):Label.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue4;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1690235428);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss = TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2);
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(857957597);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "76@3363L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690244037, "CC(remember):Label.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new LabelStateImpl(false, false, 3, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        labelStateImplRememberBasicTooltipState = (LabelStateImpl) objRememberedValue3;
                        popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1690245440);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@3406L56");
                        popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                        labelStateImplRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), composerStartRestartGroup, 0, 3);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    TooltipState tooltipState2 = labelStateImplRememberBasicTooltipState;
                    objectRef = new Ref.ObjectRef();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690249097, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    objectRef.element = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690250735, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LabelKt.Label$lambda$3$0(objectRef);
                            }
                        }, popupPositionProvider);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final TooltipScopeImpl tooltipScopeImpl2 = (TooltipScopeImpl) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LabelKt.Label$lambda$5(function3, tooltipScopeImpl2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), tooltipState2, companion, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LabelKt.Label$lambda$4(objectRef, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 7168) | 102432816, Token.DOTDOT);
                    composerStartRestartGroup = composerStartRestartGroup;
                    HandleInteractions(!z5, tooltipState2, mutableInteractionSource5, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LabelKt.Label$lambda$6(function3, modifier3, mutableInteractionSource3, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            mutableInteractionSource2 = mutableInteractionSource;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-458575864, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composerStartRestartGroup.startReplaceGroup(857710899);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3114L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690236079, "CC(remember):Label.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue4;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1690235428);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss = TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2);
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(857957597);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "76@3363L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690244037, "CC(remember):Label.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new LabelStateImpl(false, false, 3, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        labelStateImplRememberBasicTooltipState = (LabelStateImpl) objRememberedValue3;
                        popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1690245440);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@3406L56");
                        popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                        labelStateImplRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), composerStartRestartGroup, 0, 3);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    TooltipState tooltipState3 = labelStateImplRememberBasicTooltipState;
                    objectRef = new Ref.ObjectRef();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690249097, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    objectRef.element = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690250735, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LabelKt.Label$lambda$3$0(objectRef);
                            }
                        }, popupPositionProvider);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final TooltipScopeImpl tooltipScopeImpl3 = (TooltipScopeImpl) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LabelKt.Label$lambda$5(function3, tooltipScopeImpl3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), tooltipState3, companion, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LabelKt.Label$lambda$4(objectRef, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 7168) | 102432816, Token.DOTDOT);
                    composerStartRestartGroup = composerStartRestartGroup;
                    HandleInteractions(!z5, tooltipState3, mutableInteractionSource5, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LabelKt.Label$lambda$6(function3, modifier3, mutableInteractionSource3, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-458575864, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
                }
                if (mutableInteractionSource4 == null) {
                    composerStartRestartGroup.startReplaceGroup(857710899);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@3114L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690236079, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue4;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1690235428);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss = TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(857957597);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "76@3363L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690244037, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new LabelStateImpl(false, false, 3, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    labelStateImplRememberBasicTooltipState = (LabelStateImpl) objRememberedValue3;
                    popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1690245440);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@3406L56");
                    popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                    labelStateImplRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), composerStartRestartGroup, 0, 3);
                    composerStartRestartGroup.endReplaceGroup();
                }
                TooltipState tooltipState4 = labelStateImplRememberBasicTooltipState;
                objectRef = new Ref.ObjectRef();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690249097, "CC(remember):Label.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                objectRef.element = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690250735, "CC(remember):Label.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LabelKt.Label$lambda$3$0(objectRef);
                        }
                    }, popupPositionProvider);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final TooltipScopeImpl tooltipScopeImpl4 = (TooltipScopeImpl) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LabelKt.Label$lambda$5(function3, tooltipScopeImpl4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), tooltipState4, companion, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LabelKt.Label$lambda$4(objectRef, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 7168) | 102432816, Token.DOTDOT);
                composerStartRestartGroup = composerStartRestartGroup;
                HandleInteractions(!z5, tooltipState4, mutableInteractionSource5, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                mutableInteractionSource3 = mutableInteractionSource4;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LabelKt.Label$lambda$6(function3, modifier3, mutableInteractionSource3, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-458575864, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composerStartRestartGroup.startReplaceGroup(857710899);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@3114L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690236079, "CC(remember):Label.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue4;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1690235428);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss = TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2);
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(857957597);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "76@3363L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690244037, "CC(remember):Label.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new LabelStateImpl(false, false, 3, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        labelStateImplRememberBasicTooltipState = (LabelStateImpl) objRememberedValue3;
                        popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1690245440);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@3406L56");
                        popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                        labelStateImplRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), composerStartRestartGroup, 0, 3);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    TooltipState tooltipState5 = labelStateImplRememberBasicTooltipState;
                    objectRef = new Ref.ObjectRef();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690249097, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    objectRef.element = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690250735, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return LabelKt.Label$lambda$3$0(objectRef);
                            }
                        }, popupPositionProvider);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final TooltipScopeImpl tooltipScopeImpl5 = (TooltipScopeImpl) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LabelKt.Label$lambda$5(function3, tooltipScopeImpl5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), tooltipState5, companion, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LabelKt.Label$lambda$4(objectRef, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 7168) | 102432816, Token.DOTDOT);
                    composerStartRestartGroup = composerStartRestartGroup;
                    HandleInteractions(!z5, tooltipState5, mutableInteractionSource5, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LabelKt.Label$lambda$6(function3, modifier3, mutableInteractionSource3, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-458575864, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
                }
                if (mutableInteractionSource4 == null) {
                    composerStartRestartGroup.startReplaceGroup(857710899);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@3114L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690236079, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue4;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1690235428);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss = TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(857957597);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "76@3363L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690244037, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new LabelStateImpl(false, false, 3, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    labelStateImplRememberBasicTooltipState = (LabelStateImpl) objRememberedValue3;
                    popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1690245440);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@3406L56");
                    popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                    labelStateImplRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), composerStartRestartGroup, 0, 3);
                    composerStartRestartGroup.endReplaceGroup();
                }
                TooltipState tooltipState6 = labelStateImplRememberBasicTooltipState;
                objectRef = new Ref.ObjectRef();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690249097, "CC(remember):Label.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                objectRef.element = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690250735, "CC(remember):Label.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LabelKt.Label$lambda$3$0(objectRef);
                        }
                    }, popupPositionProvider);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final TooltipScopeImpl tooltipScopeImpl6 = (TooltipScopeImpl) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LabelKt.Label$lambda$5(function3, tooltipScopeImpl6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), tooltipState6, companion, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LabelKt.Label$lambda$4(objectRef, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 7168) | 102432816, Token.DOTDOT);
                composerStartRestartGroup = composerStartRestartGroup;
                HandleInteractions(!z5, tooltipState6, mutableInteractionSource5, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                mutableInteractionSource3 = mutableInteractionSource4;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LabelKt.Label$lambda$6(function3, modifier3, mutableInteractionSource3, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        mutableInteractionSource2 = mutableInteractionSource;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-458575864, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
                }
                if (mutableInteractionSource4 == null) {
                    composerStartRestartGroup.startReplaceGroup(857710899);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "71@3114L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690236079, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue4;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1690235428);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss = TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(857957597);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "76@3363L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690244037, "CC(remember):Label.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new LabelStateImpl(false, false, 3, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    labelStateImplRememberBasicTooltipState = (LabelStateImpl) objRememberedValue3;
                    popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1690245440);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@3406L56");
                    popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                    labelStateImplRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), composerStartRestartGroup, 0, 3);
                    composerStartRestartGroup.endReplaceGroup();
                }
                TooltipState tooltipState7 = labelStateImplRememberBasicTooltipState;
                objectRef = new Ref.ObjectRef();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690249097, "CC(remember):Label.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                objectRef.element = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690250735, "CC(remember):Label.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LabelKt.Label$lambda$3$0(objectRef);
                        }
                    }, popupPositionProvider);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final TooltipScopeImpl tooltipScopeImpl7 = (TooltipScopeImpl) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LabelKt.Label$lambda$5(function3, tooltipScopeImpl7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), tooltipState7, companion, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LabelKt.Label$lambda$4(objectRef, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 7168) | 102432816, Token.DOTDOT);
                composerStartRestartGroup = composerStartRestartGroup;
                HandleInteractions(!z5, tooltipState7, mutableInteractionSource5, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                mutableInteractionSource3 = mutableInteractionSource4;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LabelKt.Label$lambda$6(function3, modifier3, mutableInteractionSource3, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            mutableInteractionSource3 = mutableInteractionSource2;
            z4 = z2;
        } else {
            if (i9 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                mutableInteractionSource4 = null;
            } else {
                mutableInteractionSource4 = mutableInteractionSource2;
            }
            if (i6 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-458575864, i3, -1, "androidx.compose.material3.Label (Label.kt:69)");
            }
            if (mutableInteractionSource4 == null) {
                composerStartRestartGroup.startReplaceGroup(857710899);
                ComposerKt.sourceInformation(composerStartRestartGroup, "71@3114L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690236079, "CC(remember):Label.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue4;
            } else {
                composerStartRestartGroup.startReplaceGroup(1690235428);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource5 = mutableInteractionSource4;
            }
            popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss = TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2);
            if (z5) {
                composerStartRestartGroup.startReplaceGroup(857957597);
                ComposerKt.sourceInformation(composerStartRestartGroup, "76@3363L29");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690244037, "CC(remember):Label.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new LabelStateImpl(false, false, 3, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                labelStateImplRememberBasicTooltipState = (LabelStateImpl) objRememberedValue3;
                popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
            } else {
                composerStartRestartGroup.startReplaceGroup(1690245440);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@3406L56");
                popupPositionProvider = popupPositionProviderM4738rememberTooltipPositionProviderHu5FAss;
                labelStateImplRememberBasicTooltipState = BasicTooltipKt.rememberBasicTooltipState(false, false, new MutatorMutex(), composerStartRestartGroup, 0, 3);
                composerStartRestartGroup.endReplaceGroup();
            }
            TooltipState tooltipState8 = labelStateImplRememberBasicTooltipState;
            objectRef = new Ref.ObjectRef();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690249097, "CC(remember):Label.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            objectRef.element = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1690250735, "CC(remember):Label.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new TooltipScopeImpl(new Function0() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LabelKt.Label$lambda$3$0(objectRef);
                    }
                }, popupPositionProvider);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final TooltipScopeImpl tooltipScopeImpl8 = (TooltipScopeImpl) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BasicTooltipKt.BasicTooltipBox(popupPositionProvider, ComposableLambdaKt.rememberComposableLambda(-1572484206, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LabelKt.Label$lambda$5(function3, tooltipScopeImpl8, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), tooltipState8, companion, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-44123786, true, new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LabelKt.Label$lambda$4(objectRef, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 << 6) & 7168) | 102432816, Token.DOTDOT);
            composerStartRestartGroup = composerStartRestartGroup;
            HandleInteractions(!z5, tooltipState8, mutableInteractionSource5, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            mutableInteractionSource3 = mutableInteractionSource4;
            z4 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LabelKt.Label$lambda$6(function3, modifier3, mutableInteractionSource3, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates Label$lambda$3$0(Ref.ObjectRef objectRef) {
        return (LayoutCoordinates) ((MutableState) objectRef.element).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$4(final Ref.ObjectRef objectRef, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C83@3703L87:Label.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-44123786, i, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:83)");
            }
            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(Modifier.INSTANCE, new Function1() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LabelKt.Label$lambda$4$0(objectRef, (LayoutCoordinates) obj);
                }
            });
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierOnGloballyPositioned);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1866336426, "C83@3779L9:Label.kt#uh7d8r");
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
    public static final Unit Label$lambda$4$0(Ref.ObjectRef objectRef, LayoutCoordinates layoutCoordinates) {
        ((MutableState) objectRef.element).setValue(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Label$lambda$5(Function3 function3, TooltipScopeImpl tooltipScopeImpl, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C88@3890L7:Label.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1572484206, i, -1, "androidx.compose.material3.Label.<anonymous> (Label.kt:88)");
            }
            function3.invoke(tooltipScopeImpl, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void HandleInteractions(final boolean z, final TooltipState tooltipState, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-627258109);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HandleInteractions)N(enabled,state,interactionSource):Label.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(tooltipState) : composerStartRestartGroup.changedInstance(tooltipState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
        }
        boolean z2 = false;
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627258109, i2, -1, "androidx.compose.material3.HandleInteractions (Label.kt:108)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(756539298);
                ComposerKt.sourceInformation(composerStartRestartGroup, "110@4434L587,110@4400L621");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499614802, "CC(remember):Label.kt#9igjgp");
                boolean z3 = (i2 & 896) == 256;
                if ((i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(tooltipState))) {
                    z2 = true;
                }
                boolean z4 = z3 | z2;
                LabelKt$HandleInteractions$1$1 labelKt$HandleInteractions$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4 || labelKt$HandleInteractions$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    labelKt$HandleInteractions$1$1RememberedValue = new LabelKt$HandleInteractions$1$1(mutableInteractionSource, tooltipState, null);
                    composerStartRestartGroup.updateRememberedValue(labelKt$HandleInteractions$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) labelKt$HandleInteractions$1$1RememberedValue, composerStartRestartGroup, (i2 >> 6) & 14);
            } else {
                composerStartRestartGroup.startReplaceGroup(752163679);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.LabelKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LabelKt.HandleInteractions$lambda$1(z, tooltipState, mutableInteractionSource, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
