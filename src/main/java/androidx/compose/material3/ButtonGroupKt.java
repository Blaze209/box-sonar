package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001a]\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0010\u001ag\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0082@¢\u0006\u0002\u0010#\u001a:\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(H\u0003¢\u0006\u0002\u0010)\"\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u0019\u001a\u00020\u0005*\u0004\u0018\u00010\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u000e\u0010*\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000¨\u0006,²\u0006\n\u0010-\u001a\u00020&X\u008a\u0084\u0002"}, d2 = {"ButtonGroup", "", "modifier", "Landroidx/compose/ui/Modifier;", "expandedRatio", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/ButtonGroupScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "overflowIndicator", "Landroidx/compose/material3/ButtonGroupMenuState;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "buttonGroupParentData", "Landroidx/compose/material3/ButtonGroupParentData;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getButtonGroupParentData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/material3/ButtonGroupParentData;", "weight", "getWeight", "(Landroidx/compose/material3/ButtonGroupParentData;)F", "rememberOverflowState", "Landroidx/compose/material3/ButtonGroupOverflowState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonGroupOverflowState;", "waitUntil", "condition", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rememberButtonGroupScopeState", "Landroidx/compose/runtime/State;", "Landroidx/compose/material3/ButtonGroupScopeImpl;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "MAX_WAIT_TIME_MILLIS", "", "material3", "scope"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ButtonGroupKt {
    private static final long MAX_WAIT_TIME_MILLIS = 1000;

    /* JADX INFO: renamed from: androidx.compose.material3.ButtonGroupKt$waitUntil$1, reason: invalid class name */
    /* JADX INFO: compiled from: ButtonGroup.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.ButtonGroupKt", f = "ButtonGroup.kt", i = {0, 1, 1}, l = {1343, 1345}, m = "waitUntil", n = {"condition", "condition", "initialTimeMillis"}, s = {"L$0", "L$0", "J$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ButtonGroupKt.waitUntil(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonGroup$lambda$10(Function3 function3, Modifier modifier, float f, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, Function1 function1, int i, int i2, Composer composer, int i3) {
        ButtonGroup(function3, modifier, f, horizontal, vertical, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonGroup$lambda$3(Modifier modifier, float f, Arrangement.Horizontal horizontal, Function3 function3, int i, int i2, Composer composer, int i3) {
        ButtonGroup(modifier, f, horizontal, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonGroup$lambda$4(Function3 function3, Modifier modifier, float f, Arrangement.Horizontal horizontal, Function1 function1, int i, int i2, Composer composer, int i3) {
        ButtonGroup(function3, modifier, f, horizontal, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long waitUntil$lambda$0(long j) {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long waitUntil$lambda$1(long j) {
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:73:0x0130  */
    /* JADX WARN: Code duplicated, block: B:76:0x013c  */
    /* JADX WARN: Code duplicated, block: B:77:0x0140  */
    /* JADX WARN: Code duplicated, block: B:80:0x0165  */
    /* JADX WARN: Code duplicated, block: B:82:0x0173  */
    /* JADX WARN: Code duplicated, block: B:85:0x01af  */
    /* JADX WARN: Code duplicated, block: B:86:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:89:0x01be  */
    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use the overload with overflowIndicator parameter. This overload will create a composable that is cut off if there are too many items to fit on the screen neatly.", replaceWith = @ReplaceWith(expression = "ButtonGroup(overflowIndicator, modifier, expandedRatio, horizontalArrangement, content)", imports = {}))
    public static final void ButtonGroup(Modifier modifier, float f, Arrangement.Horizontal horizontal, final Function3<? super ButtonGroupScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        int i4;
        Arrangement.Horizontal horizontalArrangement;
        int i5;
        boolean z;
        Modifier.Companion companion;
        float expandedRatio;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        FiniteAnimationSpec finiteAnimationSpecValue;
        Object objRememberedValue;
        boolean z2;
        Object objRememberedValue2;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-231123238);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonGroup)N(modifier,expandedRatio,horizontalArrangement,content)130@6478L14,131@6509L55,134@6598L216,141@6820L89:ButtonGroup.kt#uh7d8r");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    horizontalArrangement = horizontal;
                    if (composerStartRestartGroup.changed(horizontalArrangement)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                if ((i3 & 1171) != 1170) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    expandedRatio = f2;
                } else {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i8 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    } else {
                        expandedRatio = f2;
                    }
                    if (i4 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-231123238, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:128)");
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1228882193, "CC(remember):ButtonGroup.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ButtonGroupScopeImpl(finiteAnimationSpecValue);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ButtonGroupScopeImpl buttonGroupScopeImpl = (ButtonGroupScopeImpl) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1228885202, "CC(remember):ButtonGroup.kt#9igjgp");
                    z2 = (i3 & 896) == 256;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new NonAdaptiveButtonGroupMeasurePolicy(horizontalArrangement, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NonAdaptiveButtonGroupMeasurePolicy nonAdaptiveButtonGroupMeasurePolicy = (NonAdaptiveButtonGroupMeasurePolicy) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, nonAdaptiveButtonGroupMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1007632733, "C141@6897L9:ButtonGroup.kt#uh7d8r");
                    function3.invoke(buttonGroupScopeImpl, composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 112));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final float f3 = expandedRatio;
                    final Arrangement.Horizontal horizontal2 = horizontalArrangement;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$3(modifier3, f3, horizontal2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            horizontalArrangement = horizontal;
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                expandedRatio = f2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                } else {
                    expandedRatio = f2;
                }
                if (i4 != 0) {
                    horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-231123238, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:128)");
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1228882193, "CC(remember):ButtonGroup.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ButtonGroupScopeImpl(finiteAnimationSpecValue);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ButtonGroupScopeImpl buttonGroupScopeImpl2 = (ButtonGroupScopeImpl) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1228885202, "CC(remember):ButtonGroup.kt#9igjgp");
                if ((i3 & 896) == 256) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new NonAdaptiveButtonGroupMeasurePolicy(horizontalArrangement, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new NonAdaptiveButtonGroupMeasurePolicy(horizontalArrangement, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NonAdaptiveButtonGroupMeasurePolicy nonAdaptiveButtonGroupMeasurePolicy2 = (NonAdaptiveButtonGroupMeasurePolicy) objRememberedValue2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                Updater.m6070setimpl(composerM6062constructorimpl, nonAdaptiveButtonGroupMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1007632733, "C141@6897L9:ButtonGroup.kt#uh7d8r");
                function3.invoke(buttonGroupScopeImpl2, composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = companion;
                final float f4 = expandedRatio;
                final Arrangement.Horizontal horizontal3 = horizontalArrangement;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$3(modifier4, f4, horizontal3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        f2 = f;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                horizontalArrangement = horizontal;
                if (composerStartRestartGroup.changed(horizontalArrangement)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                expandedRatio = f2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i8 != 0) {
                    expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                } else {
                    expandedRatio = f2;
                }
                if (i4 != 0) {
                    horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-231123238, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:128)");
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1228882193, "CC(remember):ButtonGroup.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ButtonGroupScopeImpl(finiteAnimationSpecValue);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ButtonGroupScopeImpl buttonGroupScopeImpl3 = (ButtonGroupScopeImpl) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1228885202, "CC(remember):ButtonGroup.kt#9igjgp");
                if ((i3 & 896) == 256) {
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue2 = new NonAdaptiveButtonGroupMeasurePolicy(horizontalArrangement, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new NonAdaptiveButtonGroupMeasurePolicy(horizontalArrangement, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NonAdaptiveButtonGroupMeasurePolicy nonAdaptiveButtonGroupMeasurePolicy3 = (NonAdaptiveButtonGroupMeasurePolicy) objRememberedValue2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                Updater.m6070setimpl(composerM6062constructorimpl, nonAdaptiveButtonGroupMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1007632733, "C141@6897L9:ButtonGroup.kt#uh7d8r");
                function3.invoke(buttonGroupScopeImpl3, composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = companion;
                final float f5 = expandedRatio;
                final Arrangement.Horizontal horizontal4 = horizontalArrangement;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$3(modifier5, f5, horizontal4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        horizontalArrangement = horizontal;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            expandedRatio = f2;
        } else {
            if (i7 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i8 != 0) {
                expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
            } else {
                expandedRatio = f2;
            }
            if (i4 != 0) {
                horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-231123238, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:128)");
            }
            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1228882193, "CC(remember):ButtonGroup.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ButtonGroupScopeImpl(finiteAnimationSpecValue);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ButtonGroupScopeImpl buttonGroupScopeImpl4 = (ButtonGroupScopeImpl) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1228885202, "CC(remember):ButtonGroup.kt#9igjgp");
            if ((i3 & 896) == 256) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue2 = new NonAdaptiveButtonGroupMeasurePolicy(horizontalArrangement, expandedRatio);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new NonAdaptiveButtonGroupMeasurePolicy(horizontalArrangement, expandedRatio);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            NonAdaptiveButtonGroupMeasurePolicy nonAdaptiveButtonGroupMeasurePolicy4 = (NonAdaptiveButtonGroupMeasurePolicy) objRememberedValue2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl, nonAdaptiveButtonGroupMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1007632733, "C141@6897L9:ButtonGroup.kt#uh7d8r");
            function3.invoke(buttonGroupScopeImpl4, composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = companion;
            final float f6 = expandedRatio;
            final Arrangement.Horizontal horizontal5 = horizontalArrangement;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonGroupKt.ButtonGroup$lambda$3(modifier6, f6, horizontal5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00be  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:72:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:75:0x0105  */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with `verticalAlignment` parameter", replaceWith = @ReplaceWith(expression = "ButtonGroup(overflowIndicator, modifier, expandedRatio, horizontalArrangement, verticalAlignment, content)", imports = {}))
    public static final /* synthetic */ void ButtonGroup(final Function3 function3, Modifier modifier, float f, Arrangement.Horizontal horizontal, final Function1 function1, Composer composer, final int i, final int i2) {
        Function3 function4;
        int i3;
        Modifier modifier2;
        int i4;
        float f2;
        int i5;
        int i6;
        int i7;
        boolean z;
        final Modifier modifier3;
        final float f3;
        final Arrangement.Horizontal horizontal2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Modifier modifier4;
        float expandedRatio;
        Arrangement.Horizontal horizontalArrangement;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1908613913);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonGroup)N(overflowIndicator,modifier,expandedRatio,horizontalArrangement,content)194@9946L258:ButtonGroup.kt#uh7d8r");
        if ((i & 6) == 0) {
            function4 = function3;
            i3 = (composerStartRestartGroup.changedInstance(function4) ? 4 : 2) | i;
        } else {
            function4 = function3;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        if (composerStartRestartGroup.changed(horizontal)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        f3 = f2;
                        horizontal2 = horizontal;
                    } else {
                        if (i10 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i8 = i6;
                        } else {
                            i8 = i6;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                        } else {
                            expandedRatio = f2;
                        }
                        if (i8 != 0) {
                            horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                        } else {
                            horizontalArrangement = horizontal;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1908613913, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:193)");
                        }
                        ButtonGroup(function4, modifier4, expandedRatio, horizontalArrangement, Alignment.INSTANCE.getTop(), function1, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        f3 = expandedRatio;
                        horizontal2 = horizontalArrangement;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$4(function3, modifier3, f3, horizontal2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = f2;
                    horizontal2 = horizontal;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i8 = i6;
                    } else {
                        i8 = i6;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    } else {
                        expandedRatio = f2;
                    }
                    if (i8 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    } else {
                        horizontalArrangement = horizontal;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1908613913, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:193)");
                    }
                    ButtonGroup(function4, modifier4, expandedRatio, horizontalArrangement, Alignment.INSTANCE.getTop(), function1, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    f3 = expandedRatio;
                    horizontal2 = horizontalArrangement;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$4(function3, modifier3, f3, horizontal2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            f2 = f;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = f2;
                    horizontal2 = horizontal;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i8 = i6;
                    } else {
                        i8 = i6;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    } else {
                        expandedRatio = f2;
                    }
                    if (i8 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    } else {
                        horizontalArrangement = horizontal;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1908613913, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:193)");
                    }
                    ButtonGroup(function4, modifier4, expandedRatio, horizontalArrangement, Alignment.INSTANCE.getTop(), function1, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    f3 = expandedRatio;
                    horizontal2 = horizontalArrangement;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$4(function3, modifier3, f3, horizontal2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = f2;
                horizontal2 = horizontal;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i8 = i6;
                } else {
                    i8 = i6;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                } else {
                    expandedRatio = f2;
                }
                if (i8 != 0) {
                    horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                } else {
                    horizontalArrangement = horizontal;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1908613913, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:193)");
                }
                ButtonGroup(function4, modifier4, expandedRatio, horizontalArrangement, Alignment.INSTANCE.getTop(), function1, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                f3 = expandedRatio;
                horizontal2 = horizontalArrangement;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$4(function3, modifier3, f3, horizontal2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(horizontal)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f3 = f2;
                    horizontal2 = horizontal;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i8 = i6;
                    } else {
                        i8 = i6;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    } else {
                        expandedRatio = f2;
                    }
                    if (i8 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    } else {
                        horizontalArrangement = horizontal;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1908613913, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:193)");
                    }
                    ButtonGroup(function4, modifier4, expandedRatio, horizontalArrangement, Alignment.INSTANCE.getTop(), function1, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    f3 = expandedRatio;
                    horizontal2 = horizontalArrangement;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$4(function3, modifier3, f3, horizontal2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = f2;
                horizontal2 = horizontal;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i8 = i6;
                } else {
                    i8 = i6;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                } else {
                    expandedRatio = f2;
                }
                if (i8 != 0) {
                    horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                } else {
                    horizontalArrangement = horizontal;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1908613913, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:193)");
                }
                ButtonGroup(function4, modifier4, expandedRatio, horizontalArrangement, Alignment.INSTANCE.getTop(), function1, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                f3 = expandedRatio;
                horizontal2 = horizontalArrangement;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$4(function3, modifier3, f3, horizontal2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        f2 = f;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(horizontal)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                f3 = f2;
                horizontal2 = horizontal;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i8 = i6;
                } else {
                    i8 = i6;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                } else {
                    expandedRatio = f2;
                }
                if (i8 != 0) {
                    horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                } else {
                    horizontalArrangement = horizontal;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1908613913, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:193)");
                }
                ButtonGroup(function4, modifier4, expandedRatio, horizontalArrangement, Alignment.INSTANCE.getTop(), function1, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                f3 = expandedRatio;
                horizontal2 = horizontalArrangement;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$4(function3, modifier3, f3, horizontal2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
            horizontal2 = horizontal;
        } else {
            if (i10 != 0) {
                modifier4 = Modifier.INSTANCE;
                i8 = i6;
            } else {
                i8 = i6;
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
            } else {
                expandedRatio = f2;
            }
            if (i8 != 0) {
                horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
            } else {
                horizontalArrangement = horizontal;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1908613913, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:193)");
            }
            ButtonGroup(function4, modifier4, expandedRatio, horizontalArrangement, Alignment.INSTANCE.getTop(), function1, composerStartRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            f3 = expandedRatio;
            horizontal2 = horizontalArrangement;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonGroupKt.ButtonGroup$lambda$4(function3, modifier3, f3, horizontal2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:101:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:104:0x0215  */
    /* JADX WARN: Code duplicated, block: B:106:0x0223  */
    /* JADX WARN: Code duplicated, block: B:109:0x0254  */
    /* JADX WARN: Code duplicated, block: B:110:0x0258  */
    /* JADX WARN: Code duplicated, block: B:113:0x0264  */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:80:0x0114  */
    /* JADX WARN: Code duplicated, block: B:83:0x0133  */
    /* JADX WARN: Code duplicated, block: B:84:0x0135  */
    /* JADX WARN: Code duplicated, block: B:87:0x0141  */
    /* JADX WARN: Code duplicated, block: B:89:0x0149  */
    /* JADX WARN: Code duplicated, block: B:92:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:94:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e0  */
    public static final void ButtonGroup(final Function3<? super ButtonGroupMenuState, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, float f, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, final Function1<? super ButtonGroupScope, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        float expandedRatio;
        int i5;
        int i6;
        Arrangement.Horizontal horizontalArrangement;
        int i7;
        int i8;
        Alignment.Vertical top;
        int i9;
        boolean z;
        final float f2;
        final Arrangement.Horizontal horizontal2;
        final Alignment.Vertical vertical2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue;
        final ButtonGroupOverflowState buttonGroupOverflowStateRememberOverflowState;
        boolean z2;
        boolean zChanged;
        Object objRememberedValue2;
        ButtonGroupMeasurePolicy buttonGroupMeasurePolicy;
        boolean zChanged2;
        Object objRememberedValue3;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-928854167);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonGroup)N(overflowIndicator,modifier,expandedRatio,horizontalArrangement,verticalAlignment,content)249@13228L14,251@13290L86,252@13397L35,253@13457L23,256@13514L322,268@13905L55,269@13978L583,265@13842L809:ButtonGroup.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    expandedRatio = f;
                    if (composerStartRestartGroup.changed(expandedRatio)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        horizontalArrangement = horizontal;
                        if (composerStartRestartGroup.changed(horizontalArrangement)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            top = vertical;
                            if (composerStartRestartGroup.changed(top)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i3 |= i10;
                        }
                        if ((i3 & 74899) != 74898) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                            }
                            if (i6 != 0) {
                                horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                            }
                            if (i8 != 0) {
                                top = Alignment.INSTANCE.getTop();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                            }
                            final State<ButtonGroupScopeImpl> stateRememberButtonGroupScopeState = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            final ButtonGroupMenuState buttonGroupMenuState = (ButtonGroupMenuState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                            if ((i3 & 7168) == 2048) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54)});
                            buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
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
                        f2 = expandedRatio;
                        horizontal2 = horizontalArrangement;
                        vertical2 = top;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier3, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    top = vertical;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 74899) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                        }
                        if (i6 != 0) {
                            horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                        }
                        if (i8 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                        }
                        final State stateRememberButtonGroupScopeState2 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final ButtonGroupMenuState buttonGroupMenuState2 = (ButtonGroupMenuState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        List listListOf2 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState2, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54)});
                        buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts2 = LayoutKt.combineAsVirtualLayouts(listListOf2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy2 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                        function2CombineAsVirtualLayouts2.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    f2 = expandedRatio;
                    horizontal2 = horizontalArrangement;
                    vertical2 = top;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier4 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier4, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                horizontalArrangement = horizontal;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        top = vertical;
                        if (composerStartRestartGroup.changed(top)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 74899) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                        }
                        if (i6 != 0) {
                            horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                        }
                        if (i8 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                        }
                        final State stateRememberButtonGroupScopeState3 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final ButtonGroupMenuState buttonGroupMenuState3 = (ButtonGroupMenuState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        List listListOf3 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState3, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54)});
                        buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts3 = LayoutKt.combineAsVirtualLayouts(listListOf3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy3 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                        function2CombineAsVirtualLayouts3.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    f2 = expandedRatio;
                    horizontal2 = horizontalArrangement;
                    vertical2 = top;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier5 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier5, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                top = vertical;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    }
                    if (i6 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    }
                    if (i8 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                    }
                    final State stateRememberButtonGroupScopeState4 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ButtonGroupMenuState buttonGroupMenuState4 = (ButtonGroupMenuState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    List listListOf4 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState4, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54)});
                    buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts4 = LayoutKt.combineAsVirtualLayouts(listListOf4);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy4 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                    function2CombineAsVirtualLayouts4.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f2 = expandedRatio;
                horizontal2 = horizontalArrangement;
                vertical2 = top;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier6 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier6, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            expandedRatio = f;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    horizontalArrangement = horizontal;
                    if (composerStartRestartGroup.changed(horizontalArrangement)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        top = vertical;
                        if (composerStartRestartGroup.changed(top)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 74899) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                        }
                        if (i6 != 0) {
                            horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                        }
                        if (i8 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                        }
                        final State stateRememberButtonGroupScopeState5 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final ButtonGroupMenuState buttonGroupMenuState5 = (ButtonGroupMenuState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        List listListOf5 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState5, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54)});
                        buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts5 = LayoutKt.combineAsVirtualLayouts(listListOf5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy5 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts5.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    f2 = expandedRatio;
                    horizontal2 = horizontalArrangement;
                    vertical2 = top;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier7 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier7, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                top = vertical;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    }
                    if (i6 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    }
                    if (i8 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                    }
                    final State stateRememberButtonGroupScopeState6 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ButtonGroupMenuState buttonGroupMenuState6 = (ButtonGroupMenuState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    List listListOf6 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState6, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54)});
                    buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts6 = LayoutKt.combineAsVirtualLayouts(listListOf6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy6 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts6.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f2 = expandedRatio;
                horizontal2 = horizontalArrangement;
                vertical2 = top;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier8 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier8, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            horizontalArrangement = horizontal;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    top = vertical;
                    if (composerStartRestartGroup.changed(top)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    }
                    if (i6 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    }
                    if (i8 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                    }
                    final State stateRememberButtonGroupScopeState7 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ButtonGroupMenuState buttonGroupMenuState7 = (ButtonGroupMenuState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    List listListOf7 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState7, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54)});
                    buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts7 = LayoutKt.combineAsVirtualLayouts(listListOf7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy7 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                    function2CombineAsVirtualLayouts7.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f2 = expandedRatio;
                horizontal2 = horizontalArrangement;
                vertical2 = top;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier9 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier9, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            top = vertical;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                }
                if (i6 != 0) {
                    horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                }
                if (i8 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                }
                final State stateRememberButtonGroupScopeState8 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ButtonGroupMenuState buttonGroupMenuState8 = (ButtonGroupMenuState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                List listListOf8 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState8, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54)});
                buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts8 = LayoutKt.combineAsVirtualLayouts(listListOf8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy8 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts8.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f2 = expandedRatio;
            horizontal2 = horizontalArrangement;
            vertical2 = top;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier10 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier10, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                expandedRatio = f;
                if (composerStartRestartGroup.changed(expandedRatio)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    horizontalArrangement = horizontal;
                    if (composerStartRestartGroup.changed(horizontalArrangement)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        top = vertical;
                        if (composerStartRestartGroup.changed(top)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i3 |= i10;
                    }
                    if ((i3 & 74899) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                        }
                        if (i6 != 0) {
                            horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                        }
                        if (i8 != 0) {
                            top = Alignment.INSTANCE.getTop();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                        }
                        final State stateRememberButtonGroupScopeState9 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        final ButtonGroupMenuState buttonGroupMenuState9 = (ButtonGroupMenuState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        List listListOf9 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState9, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState9, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState9, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54)});
                        buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts9 = LayoutKt.combineAsVirtualLayouts(listListOf9);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        MeasurePolicy measurePolicy9 = (MeasurePolicy) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        function2CombineAsVirtualLayouts9.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    f2 = expandedRatio;
                    horizontal2 = horizontalArrangement;
                    vertical2 = top;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier11 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier11, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                top = vertical;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    }
                    if (i6 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    }
                    if (i8 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                    }
                    final State stateRememberButtonGroupScopeState10 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ButtonGroupMenuState buttonGroupMenuState10 = (ButtonGroupMenuState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    List listListOf10 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState10, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54)});
                    buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts10 = LayoutKt.combineAsVirtualLayouts(listListOf10);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy10 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                    function2CombineAsVirtualLayouts10.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f2 = expandedRatio;
                horizontal2 = horizontalArrangement;
                vertical2 = top;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier12 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier12, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            horizontalArrangement = horizontal;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    top = vertical;
                    if (composerStartRestartGroup.changed(top)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    }
                    if (i6 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    }
                    if (i8 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                    }
                    final State stateRememberButtonGroupScopeState11 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ButtonGroupMenuState buttonGroupMenuState11 = (ButtonGroupMenuState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    List listListOf11 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState11, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54)});
                    buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts11 = LayoutKt.combineAsVirtualLayouts(listListOf11);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy11 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts11.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f2 = expandedRatio;
                horizontal2 = horizontalArrangement;
                vertical2 = top;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier13 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier13, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            top = vertical;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                }
                if (i6 != 0) {
                    horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                }
                if (i8 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                }
                final State stateRememberButtonGroupScopeState12 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ButtonGroupMenuState buttonGroupMenuState12 = (ButtonGroupMenuState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                List listListOf12 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState12, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54)});
                buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts12 = LayoutKt.combineAsVirtualLayouts(listListOf12);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy12 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts12.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f2 = expandedRatio;
            horizontal2 = horizontalArrangement;
            vertical2 = top;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier14 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier14, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        expandedRatio = f;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                horizontalArrangement = horizontal;
                if (composerStartRestartGroup.changed(horizontalArrangement)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    top = vertical;
                    if (composerStartRestartGroup.changed(top)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i3 |= i10;
                }
                if ((i3 & 74899) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                    }
                    if (i6 != 0) {
                        horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                    }
                    if (i8 != 0) {
                        top = Alignment.INSTANCE.getTop();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                    }
                    final State stateRememberButtonGroupScopeState13 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final ButtonGroupMenuState buttonGroupMenuState13 = (ButtonGroupMenuState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    List listListOf13 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState13, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54)});
                    buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts13 = LayoutKt.combineAsVirtualLayouts(listListOf13);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MeasurePolicy measurePolicy13 = (MeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                    function2CombineAsVirtualLayouts13.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f2 = expandedRatio;
                horizontal2 = horizontalArrangement;
                vertical2 = top;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier15 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier15, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            top = vertical;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                }
                if (i6 != 0) {
                    horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                }
                if (i8 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                }
                final State stateRememberButtonGroupScopeState14 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ButtonGroupMenuState buttonGroupMenuState14 = (ButtonGroupMenuState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                List listListOf14 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState14, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState14, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState14, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54)});
                buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts14 = LayoutKt.combineAsVirtualLayouts(listListOf14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy14 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts14.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f2 = expandedRatio;
            horizontal2 = horizontalArrangement;
            vertical2 = top;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier16 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier16, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        horizontalArrangement = horizontal;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                top = vertical;
                if (composerStartRestartGroup.changed(top)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i3 |= i10;
            }
            if ((i3 & 74899) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
                }
                if (i6 != 0) {
                    horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
                }
                if (i8 != 0) {
                    top = Alignment.INSTANCE.getTop();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
                }
                final State stateRememberButtonGroupScopeState15 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final ButtonGroupMenuState buttonGroupMenuState15 = (ButtonGroupMenuState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                List listListOf15 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState15, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState15, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState15, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54)});
                buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts15 = LayoutKt.combineAsVirtualLayouts(listListOf15);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                MeasurePolicy measurePolicy15 = (MeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts15.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f2 = expandedRatio;
            horizontal2 = horizontalArrangement;
            vertical2 = top;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier17 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier17, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        top = vertical;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i10 = 131072;
            } else {
                i10 = 65536;
            }
            i3 |= i10;
        }
        if ((i3 & 74899) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i4 != 0) {
                expandedRatio = ButtonGroupDefaults.INSTANCE.getExpandedRatio();
            }
            if (i6 != 0) {
                horizontalArrangement = ButtonGroupDefaults.INSTANCE.getHorizontalArrangement();
            }
            if (i8 != 0) {
                top = Alignment.INSTANCE.getTop();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-928854167, i3, -1, "androidx.compose.material3.ButtonGroup (ButtonGroup.kt:247)");
            }
            final State stateRememberButtonGroupScopeState16 = rememberButtonGroupScopeState(function1, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, (i3 >> 15) & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724365644, "CC(remember):ButtonGroup.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ButtonGroupMenuState(false, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ButtonGroupMenuState buttonGroupMenuState16 = (ButtonGroupMenuState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            buttonGroupOverflowStateRememberOverflowState = rememberOverflowState(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 724369675, "CC(remember):ButtonGroup.kt#9igjgp");
            if ((i3 & 7168) == 2048) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged = composerStartRestartGroup.changed(buttonGroupOverflowStateRememberOverflowState) | z2;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new ButtonGroupMeasurePolicy(buttonGroupOverflowStateRememberOverflowState, horizontalArrangement, top, expandedRatio);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            List listListOf16 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1700074793, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonGroupKt.ButtonGroup$lambda$8(stateRememberButtonGroupScopeState16, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(431404714, true, new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonGroupKt.ButtonGroup$lambda$9(function3, buttonGroupMenuState16, buttonGroupOverflowStateRememberOverflowState, stateRememberButtonGroupScopeState16, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54)});
            buttonGroupMeasurePolicy = (ButtonGroupMeasurePolicy) objRememberedValue2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts16 = LayoutKt.combineAsVirtualLayouts(listListOf16);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(buttonGroupMeasurePolicy);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(buttonGroupMeasurePolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MeasurePolicy measurePolicy16 = (MeasurePolicy) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
            function2CombineAsVirtualLayouts16.invoke(composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        f2 = expandedRatio;
        horizontal2 = horizontalArrangement;
        vertical2 = top;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier18 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonGroupKt.ButtonGroup$lambda$10(function3, modifier18, f2, horizontal2, vertical2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonGroup$lambda$8(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C*268@13936L20:ButtonGroup.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1700074793, i, -1, "androidx.compose.material3.ButtonGroup.<anonymous> (ButtonGroup.kt:268)");
            }
            List<ButtonGroupItem> items = ButtonGroup$lambda$5(state).getItems();
            int size = items.size();
            for (int i2 = 0; i2 < size; i2++) {
                items.get(i2).ButtonGroupContent(composer, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonGroup$lambda$9(Function3 function3, final ButtonGroupMenuState buttonGroupMenuState, final ButtonGroupOverflowState buttonGroupOverflowState, final State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C270@14000L543:ButtonGroup.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(431404714, i, -1, "androidx.compose.material3.ButtonGroup.<anonymous> (ButtonGroup.kt:270)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composer, 649804808, "C271@14030L28,274@14204L23,275@14255L266,272@14083L438:ButtonGroup.kt#uh7d8r");
            function3.invoke(buttonGroupMenuState, composer, 0);
            boolean zIsExpanded = buttonGroupMenuState.isExpanded();
            ComposerKt.sourceInformationMarkerStart(composer, 1822081863, "CC(remember):ButtonGroup.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(buttonGroupMenuState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ButtonGroupKt.ButtonGroup$lambda$9$0$0$0(buttonGroupMenuState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.m2743DropdownMenuIlH_yew(zIsExpanded, (Function0) objRememberedValue, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1656627541, true, new Function3() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ButtonGroupKt.ButtonGroup$lambda$9$0$1(buttonGroupOverflowState, buttonGroupMenuState, state, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, 48, 2044);
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
    public static final Unit ButtonGroup$lambda$9$0$0$0(ButtonGroupMenuState buttonGroupMenuState) {
        buttonGroupMenuState.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonGroup$lambda$9$0$1(ButtonGroupOverflowState buttonGroupOverflowState, ButtonGroupMenuState buttonGroupMenuState, State state, ColumnScope columnScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C*278@14443L22:ButtonGroup.kt#uh7d8r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1656627541, i, -1, "androidx.compose.material3.ButtonGroup.<anonymous>.<anonymous>.<anonymous> (ButtonGroup.kt:276)");
            }
            int totalItemCount = buttonGroupOverflowState.getTotalItemCount();
            for (int visibleItemCount = buttonGroupOverflowState.getVisibleItemCount(); visibleItemCount < totalItemCount; visibleItemCount++) {
                ButtonGroup$lambda$5(state).getItems().get(visibleItemCount).MenuContent(buttonGroupMenuState, composer, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final ButtonGroupParentData getButtonGroupParentData(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        if (parentData instanceof ButtonGroupParentData) {
            return (ButtonGroupParentData) parentData;
        }
        return null;
    }

    public static final float getWeight(ButtonGroupParentData buttonGroupParentData) {
        if (buttonGroupParentData != null) {
            return buttonGroupParentData.getWeight();
        }
        return 0.0f;
    }

    private static final ButtonGroupOverflowState rememberOverflowState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1571410000, "C(rememberOverflowState)1338@56913L23,1338@56863L73:ButtonGroup.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1571410000, i, -1, "androidx.compose.material3.rememberOverflowState (ButtonGroup.kt:1337)");
        }
        Object[] objArr = new Object[0];
        Saver<OverflowStateImpl, ?> saver = OverflowStateImpl.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, -1703474425, "CC(remember):ButtonGroup.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ButtonGroupKt.rememberOverflowState$lambda$0$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        OverflowStateImpl overflowStateImpl = (OverflowStateImpl) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, 384);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return overflowStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OverflowStateImpl rememberOverflowState$lambda$0$0() {
        return new OverflowStateImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    /* JADX WARN: Code duplicated, block: B:29:0x008b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
    
        if (r11 == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r11 == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
    
        return r1;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0078 -> B:25:0x007b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object waitUntil(kotlin.jvm.functions.Function0<java.lang.Boolean> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.material3.ButtonGroupKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.material3.ButtonGroupKt$waitUntil$1 r0 = (androidx.compose.material3.ButtonGroupKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.material3.ButtonGroupKt$waitUntil$1 r0 = new androidx.compose.material3.ButtonGroupKt$waitUntil$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L33
            long r4 = r0.J$0
            java.lang.Object r10 = r0.L$0
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7b
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            java.lang.Object r10 = r0.L$0
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L57
        L44:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda4 r11 = new androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda4
            r11.<init>()
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r11 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r11, r0)
            if (r11 != r1) goto L57
            goto L7a
        L57:
            java.lang.Number r11 = (java.lang.Number) r11
            long r4 = r11.longValue()
        L5d:
            java.lang.Object r11 = r10.invoke()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L8b
            androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda5 r11 = new androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda5
            r11.<init>()
            r0.L$0 = r10
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r11 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameMillis(r11, r0)
            if (r11 != r1) goto L7b
        L7a:
            return r1
        L7b:
            java.lang.Number r11 = (java.lang.Number) r11
            long r6 = r11.longValue()
            long r6 = r6 - r4
            r8 = 1000(0x3e8, double:4.94E-321)
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 <= 0) goto L5d
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L8b:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ButtonGroupKt.waitUntil(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final State<ButtonGroupScopeImpl> rememberButtonGroupScopeState(Function1<? super ButtonGroupScope, Unit> function1, final AnimationSpec<Float> animationSpec, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 97726316, "C(rememberButtonGroupScopeState)N(content,animationSpec)1380@58254L29,1381@58295L142:ButtonGroup.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(97726316, i, -1, "androidx.compose.material3.rememberButtonGroupScopeState (ButtonGroup.kt:1379)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, -574283782, "CC(remember):ButtonGroup.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.ButtonGroupKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ButtonGroupKt.rememberButtonGroupScopeState$lambda$0$0(animationSpec, stateRememberUpdatedState);
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        State<ButtonGroupScopeImpl> state = (State) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ButtonGroupScopeImpl rememberButtonGroupScopeState$lambda$0$0(AnimationSpec animationSpec, State state) {
        ButtonGroupScopeImpl buttonGroupScopeImpl = new ButtonGroupScopeImpl(animationSpec);
        ((Function1) state.getValue()).invoke(buttonGroupScopeImpl);
        return buttonGroupScopeImpl;
    }

    private static final ButtonGroupScopeImpl ButtonGroup$lambda$5(State<ButtonGroupScopeImpl> state) {
        return state.getValue();
    }
}
