package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.util.ListUtilsKt;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000\u001a:\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u0015\u001a9\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\u001f\u001a\u00020\u000f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003¢\u0006\u0002\u0010!\u001a)\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010#*b\b\u0002\u0010\u0016\"-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t2-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¨\u0006$"}, d2 = {"SnackbarHost", "", "hostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "snackbar", "Lkotlin/Function1;", "Landroidx/compose/material3/SnackbarData;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "toMillis", "", "Landroidx/compose/material3/SnackbarDuration;", "hasAction", "", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "FadeInFadeOutWithScale", "current", "content", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FadeInFadeOutTransition", "Lkotlin/Function0;", "Lkotlin/ParameterName;", "name", "animatedOpacity", "Landroidx/compose/runtime/State;", "", "animation", "Landroidx/compose/animation/core/AnimationSpec;", ViewProps.VISIBLE, "onAnimationFinish", "(Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animatedScale", "(Landroidx/compose/animation/core/AnimationSpec;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnackbarHostKt {

    /* JADX INFO: compiled from: SnackbarHost.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnackbarDuration.values().length];
            try {
                iArr[SnackbarDuration.Indefinite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SnackbarDuration.Long.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SnackbarDuration.Short.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FadeInFadeOutWithScale$lambda$4(SnackbarData snackbarData, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        FadeInFadeOutWithScale(snackbarData, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarHost$lambda$1(SnackbarHostState snackbarHostState, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        SnackbarHost(snackbarHostState, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SnackbarHost(final SnackbarHostState snackbarHostState, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1077081618);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SnackbarHost)N(hostState,modifier,snackbar)222@9520L7,223@9568L349,223@9532L385,234@9922L135:SnackbarHost.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(snackbarHostState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            function4 = function3;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i5 != 0) {
                function3 = ComposableSingletons$SnackbarHostKt.INSTANCE.m3103getLambda$1548712596$material3();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1077081618, i3, -1, "androidx.compose.material3.SnackbarHost (SnackbarHost.kt:220)");
            }
            SnackbarData currentSnackbarData = snackbarHostState.getCurrentSnackbarData();
            ProvidableCompositionLocal<AccessibilityManager> localAccessibilityManager = CompositionLocalsKt.getLocalAccessibilityManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localAccessibilityManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AccessibilityManager accessibilityManager = (AccessibilityManager) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 11694187, "CC(remember):SnackbarHost.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(currentSnackbarData) | composerStartRestartGroup.changedInstance(accessibilityManager);
            SnackbarHostKt$SnackbarHost$1$1 snackbarHostKt$SnackbarHost$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || snackbarHostKt$SnackbarHost$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                snackbarHostKt$SnackbarHost$1$1RememberedValue = new SnackbarHostKt$SnackbarHost$1$1(currentSnackbarData, accessibilityManager, null);
                composerStartRestartGroup.updateRememberedValue(snackbarHostKt$SnackbarHost$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(currentSnackbarData, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) snackbarHostKt$SnackbarHost$1$1RememberedValue, composerStartRestartGroup, 0);
            Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function5 = function3;
            FadeInFadeOutWithScale(snackbarHostState.getCurrentSnackbarData(), modifier3, function5, composerStartRestartGroup, i3 & 1008, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            function4 = function5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarHostKt.SnackbarHost$lambda$1(snackbarHostState, modifier2, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final long toMillis(SnackbarDuration snackbarDuration, boolean z, AccessibilityManager accessibilityManager) {
        long j;
        int i = WhenMappings.$EnumSwitchMapping$0[snackbarDuration.ordinal()];
        if (i == 1) {
            j = Long.MAX_VALUE;
        } else if (i == 2) {
            j = 10000;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            j = 4000;
        }
        long j2 = j;
        return accessibilityManager == null ? j2 : accessibilityManager.calculateRecommendedTimeoutMillis(j2, true, true, z);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0097  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d5 A[LOOP:0: B:46:0x00d3->B:47:0x00d5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:53:0x0116 A[LOOP:1: B:52:0x0114->B:53:0x0116, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x013d  */
    /* JADX WARN: Code duplicated, block: B:58:0x0183  */
    /* JADX WARN: Code duplicated, block: B:61:0x018f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0193  */
    /* JADX WARN: Code duplicated, block: B:67:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:70:0x0212 A[LOOP:2: B:69:0x0210->B:70:0x0212, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x0262  */
    /* JADX WARN: Code duplicated, block: B:74:0x0266  */
    /* JADX WARN: Code duplicated, block: B:77:0x0270  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    private static final void FadeInFadeOutWithScale(final SnackbarData snackbarData, Modifier modifier, final Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        boolean z;
        Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final String strM5086getString2EP1pXo;
        Object objRememberedValue;
        final FadeInFadeOutState fadeInFadeOutState;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        List items;
        int size;
        int i3;
        List items2;
        ArrayList arrayList;
        int size2;
        int i4;
        List mutableList;
        List listFastFilterNotNull;
        List items3;
        int size3;
        int i5;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-977568115);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FadeInFadeOutWithScale)N(current,modifier,content)327@12796L36,328@12849L48,380@15021L162:SnackbarHost.kt#uh7d8r");
        int i7 = (i & 6) == 0 ? (composerStartRestartGroup.changed(snackbarData) ? 4 : 2) | i : i;
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i7 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i7 |= i6;
            }
            if ((i7 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i7 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-977568115, i7, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:326)");
                }
                Strings.Companion companion2 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_snackbar_pane_title), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154886429, "CC(remember):SnackbarHost.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new FadeInFadeOutState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                fadeInFadeOutState = (FadeInFadeOutState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (!Intrinsics.areEqual(snackbarData, fadeInFadeOutState.getCurrent())) {
                    composerStartRestartGroup.startReplaceGroup(1428992245);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1441886385);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*337@13248L1752");
                    fadeInFadeOutState.setCurrent(snackbarData);
                    items2 = fadeInFadeOutState.getItems();
                    arrayList = new ArrayList(items2.size());
                    size2 = items2.size();
                    for (i4 = 0; i4 < size2; i4++) {
                        arrayList.add((SnackbarData) ((FadeInFadeOutAnimationItem) items2.get(i4)).getKey());
                    }
                    mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                    if (!mutableList.contains(snackbarData)) {
                        mutableList.add(snackbarData);
                    }
                    fadeInFadeOutState.getItems().clear();
                    listFastFilterNotNull = ListUtilsKt.fastFilterNotNull(mutableList);
                    items3 = fadeInFadeOutState.getItems();
                    size3 = listFastFilterNotNull.size();
                    i5 = 0;
                    while (i5 < size3) {
                        final SnackbarData snackbarData2 = (SnackbarData) listFastFilterNotNull.get(i5);
                        items3.add(new FadeInFadeOutAnimationItem(snackbarData2, ComposableLambdaKt.rememberComposableLambda(-1952400805, true, new Function3() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return SnackbarHostKt.FadeInFadeOutWithScale$lambda$2$0(snackbarData2, snackbarData, fadeInFadeOutState, strM5086getString2EP1pXo, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54)));
                        i5++;
                        strM5086getString2EP1pXo = strM5086getString2EP1pXo;
                    }
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1595840844, "C381@15059L21:SnackbarHost.kt#uh7d8r");
                fadeInFadeOutState.setScope(ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0));
                composerStartRestartGroup.startReplaceGroup(-1888182177);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                items = fadeInFadeOutState.getItems();
                size = items.size();
                for (i3 = 0; i3 < size; i3++) {
                    FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) items.get(i3);
                    final SnackbarData snackbarData3 = (SnackbarData) fadeInFadeOutAnimationItem.component1();
                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function3Component2 = fadeInFadeOutAnimationItem.component2();
                    composerStartRestartGroup.startMovableGroup(1325010085, snackbarData3);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "382@15154L19,382@15146L27");
                    function3Component2.invoke(ComposableLambdaKt.rememberComposableLambda(-1893791890, true, new Function2() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SnackbarHostKt.FadeInFadeOutWithScale$lambda$3$0$0(function3, snackbarData3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier3 = companion;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarHostKt.FadeInFadeOutWithScale$lambda$4(snackbarData, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i7 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i7 |= i6;
        }
        if ((i7 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i7 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            if (i8 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-977568115, i7, -1, "androidx.compose.material3.FadeInFadeOutWithScale (SnackbarHost.kt:326)");
            }
            Strings.Companion companion3 = Strings.INSTANCE;
            strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_snackbar_pane_title), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1154886429, "CC(remember):SnackbarHost.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new FadeInFadeOutState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            fadeInFadeOutState = (FadeInFadeOutState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!Intrinsics.areEqual(snackbarData, fadeInFadeOutState.getCurrent())) {
                composerStartRestartGroup.startReplaceGroup(1428992245);
            } else {
                composerStartRestartGroup.startReplaceGroup(1441886385);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*337@13248L1752");
                fadeInFadeOutState.setCurrent(snackbarData);
                items2 = fadeInFadeOutState.getItems();
                arrayList = new ArrayList(items2.size());
                size2 = items2.size();
                while (i4 < size2) {
                    arrayList.add((SnackbarData) ((FadeInFadeOutAnimationItem) items2.get(i4)).getKey());
                }
                mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                if (!mutableList.contains(snackbarData)) {
                    mutableList.add(snackbarData);
                }
                fadeInFadeOutState.getItems().clear();
                listFastFilterNotNull = ListUtilsKt.fastFilterNotNull(mutableList);
                items3 = fadeInFadeOutState.getItems();
                size3 = listFastFilterNotNull.size();
                i5 = 0;
                while (i5 < size3) {
                    final SnackbarData snackbarData4 = (SnackbarData) listFastFilterNotNull.get(i5);
                    items3.add(new FadeInFadeOutAnimationItem(snackbarData4, ComposableLambdaKt.rememberComposableLambda(-1952400805, true, new Function3() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return SnackbarHostKt.FadeInFadeOutWithScale$lambda$2$0(snackbarData4, snackbarData, fadeInFadeOutState, strM5086getString2EP1pXo, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54)));
                    i5++;
                    strM5086getString2EP1pXo = strM5086getString2EP1pXo;
                }
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1595840844, "C381@15059L21:SnackbarHost.kt#uh7d8r");
            fadeInFadeOutState.setScope(ComposablesKt.getCurrentRecomposeScope(composerStartRestartGroup, 0));
            composerStartRestartGroup.startReplaceGroup(-1888182177);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            items = fadeInFadeOutState.getItems();
            size = items.size();
            while (i3 < size) {
                FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem2 = (FadeInFadeOutAnimationItem) items.get(i3);
                final SnackbarData snackbarData5 = (SnackbarData) fadeInFadeOutAnimationItem2.component1();
                Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function3Component3 = fadeInFadeOutAnimationItem2.component2();
                composerStartRestartGroup.startMovableGroup(1325010085, snackbarData5);
                ComposerKt.sourceInformation(composerStartRestartGroup, "382@15154L19,382@15146L27");
                function3Component3.invoke(ComposableLambdaKt.rememberComposableLambda(-1893791890, true, new Function2() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SnackbarHostKt.FadeInFadeOutWithScale$lambda$3$0$0(function3, snackbarData5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                composerStartRestartGroup.endMovableGroup();
            }
            composerStartRestartGroup.endReplaceGroup();
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
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = companion;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SnackbarHostKt.FadeInFadeOutWithScale$lambda$4(snackbarData, modifier4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FadeInFadeOutWithScale$lambda$2$0(final SnackbarData snackbarData, SnackbarData snackbarData2, final FadeInFadeOutState fadeInFadeOutState, final String str, Function2 function2, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(children)342@13530L7,344@13628L313,341@13443L521,355@14190L7,353@14013L252,364@14543L374,358@14282L704:SnackbarHost.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | (composer.changedInstance(function2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1952400805, i2, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)");
            }
            final boolean zAreEqual = Intrinsics.areEqual(snackbarData, snackbarData2);
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 643547220, "CC(remember):SnackbarHost.kt#9igjgp");
            boolean zChanged = composer.changed(snackbarData) | composer.changedInstance(fadeInFadeOutState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SnackbarHostKt.FadeInFadeOutWithScale$lambda$2$0$0$0(snackbarData, fadeInFadeOutState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            State<Float> stateAnimatedOpacity = animatedOpacity(finiteAnimationSpecValue, zAreEqual, (Function0) objRememberedValue, composer, 0, 0);
            State<Float> stateAnimatedScale = animatedScale(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6), zAreEqual, composer, 0);
            Modifier modifierM6978graphicsLayerAp8cVGQ = GraphicsLayerModifierKt.m6978graphicsLayerAp8cVGQ(Modifier.INSTANCE, (131064 & 1) != 0 ? 1.0f : stateAnimatedScale.getValue().floatValue(), (131064 & 2) != 0 ? 1.0f : stateAnimatedScale.getValue().floatValue(), (131064 & 4) == 0 ? stateAnimatedOpacity.getValue().floatValue() : 1.0f, (131064 & 8) != 0 ? 0.0f : 0.0f, (131064 & 16) != 0 ? 0.0f : 0.0f, (131064 & 32) != 0 ? 0.0f : 0.0f, (131064 & 64) != 0 ? 0.0f : 0.0f, (131064 & 128) != 0 ? 0.0f : 0.0f, (131064 & 256) == 0 ? 0.0f : 0.0f, (131064 & 512) != 0 ? 8.0f : 0.0f, (131064 & 1024) != 0 ? TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ() : 0L, (131064 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (131064 & 4096) != 0 ? false : false, (131064 & 8192) != 0 ? null : null, (131064 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (32768 & 131064) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131064 & 65536) != 0 ? CompositingStrategy.INSTANCE.m6905getAutoNrFUSI() : 0);
            ComposerKt.sourceInformationMarkerStart(composer, 643576561, "CC(remember):SnackbarHost.kt#9igjgp");
            boolean zChanged2 = composer.changed(zAreEqual) | composer.changed(snackbarData) | composer.changed(str);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SnackbarHostKt.FadeInFadeOutWithScale$lambda$2$0$1$0(zAreEqual, str, snackbarData, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM6978graphicsLayerAp8cVGQ, false, (Function1) objRememberedValue2, 1, null);
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
            ComposerKt.sourceInformationMarkerStart(composer, -2093234184, "C375@14958L10:SnackbarHost.kt#uh7d8r");
            function2.invoke(composer, Integer.valueOf(i2 & 14));
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
    public static final Unit FadeInFadeOutWithScale$lambda$2$0$0$0(final SnackbarData snackbarData, FadeInFadeOutState fadeInFadeOutState) {
        if (!Intrinsics.areEqual(snackbarData, fadeInFadeOutState.getCurrent())) {
            CollectionsKt.removeAll(fadeInFadeOutState.getItems(), new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SnackbarHostKt.FadeInFadeOutWithScale$lambda$2$0$0$0$0(snackbarData, (FadeInFadeOutAnimationItem) obj));
                }
            });
            RecomposeScope scope = fadeInFadeOutState.getScope();
            if (scope != null) {
                scope.invalidate();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FadeInFadeOutWithScale$lambda$2$0$0$0$0(SnackbarData snackbarData, FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem) {
        return Intrinsics.areEqual(fadeInFadeOutAnimationItem.getKey(), snackbarData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FadeInFadeOutWithScale$lambda$2$0$1$0(boolean z, String str, final SnackbarData snackbarData, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (z) {
            SemanticsPropertiesKt.m8850setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8824getPolite0phEisY());
        }
        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(SnackbarHostKt.FadeInFadeOutWithScale$lambda$2$0$1$0$0(snackbarData));
            }
        }, 1, null);
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FadeInFadeOutWithScale$lambda$2$0$1$0$0(SnackbarData snackbarData) {
        snackbarData.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FadeInFadeOutWithScale$lambda$3$0$0(Function3 function3, SnackbarData snackbarData, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C382@15156L15:SnackbarHost.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1893791890, i, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SnackbarHost.kt:382)");
            }
            Intrinsics.checkNotNull(snackbarData);
            function3.invoke(snackbarData, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final State<Float> animatedOpacity(AnimationSpec<Float> animationSpec, boolean z, Function0<Unit> function0, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1431889134, "C(animatedOpacity)N(animation,visible,onAnimationFinish)404@15795L2,406@15833L49,407@15911L111,407@15887L135:SnackbarHost.kt#uh7d8r");
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 1655926768, "CC(remember):SnackbarHost.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function0<Unit> function1 = function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1431889134, i, -1, "androidx.compose.material3.animatedOpacity (SnackbarHost.kt:405)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1655928031, "CC(remember):SnackbarHost.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = AnimatableKt.Animatable$default(!z ? 1.0f : 0.0f, 0.0f, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        Animatable animatable = (Animatable) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Boolean boolValueOf = Boolean.valueOf(z);
        ComposerKt.sourceInformationMarkerStart(composer, 1655930589, "CC(remember):SnackbarHost.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(animatable) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32) | composer.changedInstance(animationSpec) | ((((i & 896) ^ 384) > 256 && composer.changed(function1)) || (i & 384) == 256);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function2) new SnackbarHostKt$animatedOpacity$2$1(animatable, z, animationSpec, function1, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer, (i >> 3) & 14);
        State<Float> stateAsState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAsState;
    }

    private static final State<Float> animatedScale(AnimationSpec<Float> animationSpec, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1966809761, "C(animatedScale)N(animation,visible)416@16174L51,417@16254L85,417@16230L109:SnackbarHost.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1966809761, i, -1, "androidx.compose.material3.animatedScale (SnackbarHost.kt:415)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 318573364, "CC(remember):SnackbarHost.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = AnimatableKt.Animatable$default(!z ? 1.0f : 0.8f, 0.0f, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        Animatable animatable = (Animatable) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Boolean boolValueOf = Boolean.valueOf(z);
        ComposerKt.sourceInformationMarkerStart(composer, 318575958, "CC(remember):SnackbarHost.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(animatable) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32) | composer.changedInstance(animationSpec);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new SnackbarHostKt$animatedScale$1$1(animatable, z, animationSpec, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, (i >> 3) & 14);
        State<Float> stateAsState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAsState;
    }
}
