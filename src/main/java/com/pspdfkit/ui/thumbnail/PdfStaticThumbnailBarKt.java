package com.pspdfkit.ui.thumbnail;

import android.content.Context;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.pspdfkit.R;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.e2;
import com.pspdfkit.internal.f2;
import com.pspdfkit.internal.lz;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d\u001a\u0015\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0002\u0010!\u001a\r\u0010\"\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d\u001a\u0017\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u0010&\u001a)\u0010'\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0007¢\u0006\u0002\u0010,\u001a\u001d\u0010-\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010.¨\u0006/²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u00100\u001a\u000201X\u008a\u0084\u0002"}, d2 = {"PdfStaticThumbnailBar", "", "stateManager", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;", "onPageChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pageIndex", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ThumbnailBarContent", "state", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;", "onEvent", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ThumbnailGrid", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;Landroidx/compose/runtime/Composer;I)V", "ThumbnailItem", "thumbnail", "Lcom/pspdfkit/ui/thumbnail/ThumbnailItem;", "theme", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailItem;Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectedThumbnailOverlay", "LoadingState", "(Landroidx/compose/runtime/Composer;I)V", "ErrorState", "error", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "EmptyState", "rememberThumbnailBarStateManager", "context", "Landroid/content/Context;", "(Landroid/content/Context;Landroidx/compose/runtime/Composer;II)Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;", "SetThumbnailBarDocument", "document", "Lcom/pspdfkit/document/PdfDocument;", "configuration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;Lcom/pspdfkit/document/PdfDocument;Lcom/pspdfkit/configuration/PdfConfiguration;Landroidx/compose/runtime/Composer;I)V", "SyncThumbnailBarPage", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;ILandroidx/compose/runtime/Composer;I)V", "sdk-nutrient", "animatedAlpha", ""}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PdfStaticThumbnailBarKt {
    private static final void EmptyState(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1203865893);
        if (composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1203865893, i, -1, "com.pspdfkit.ui.thumbnail.EmptyState (PdfStaticThumbnailBar.kt:501)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.EmptyState$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyState$lambda$1(int i, Composer composer, int i2) {
        EmptyState(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void ErrorState(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(641687225);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(641687225, i2, -1, "com.pspdfkit.ui.thumbnail.ErrorState (PdfStaticThumbnailBar.kt:488)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk("Error: " + str, null, Color.INSTANCE.m6848getRed0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 384, 0, 262138);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.ErrorState$lambda$1(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorState$lambda$1(String str, int i, Composer composer, int i2) {
        ErrorState(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void LoadingState(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(635172566);
        if (composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(635172566, i, -1, "com.pspdfkit.ui.thumbnail.LoadingState (PdfStaticThumbnailBar.kt:478)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(null, 0L, 0.0f, 0L, 0, 0.0f, composerStartRestartGroup, 0, 63);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.LoadingState$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingState$lambda$1(int i, Composer composer, int i2) {
        LoadingState(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x008d  */
    /* JADX WARN: Code duplicated, block: B:43:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00da  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    public static final void PdfStaticThumbnailBar(final ThumbnailBarStateManager thumbnailBarStateManager, final Function1<? super Integer, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        thumbnailBarStateManager.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1973375337);
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(thumbnailBarStateManager) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1973375337, i3, -1, "com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBar (PdfStaticThumbnailBar.kt:74)");
                }
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(thumbnailBarStateManager.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(thumbnailBarStateManager);
                if ((i3 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = zChangedInstance | z2;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1(thumbnailBarStateManager, function1, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                EffectsKt.LaunchedEffect(thumbnailBarStateManager, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composerStartRestartGroup, i3 & 14);
                BoxWithConstraintsKt.BoxWithConstraints(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), null, false, 3, null), null, false, ComposableLambdaKt.rememberComposableLambda(975459073, true, new Function3() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return PdfStaticThumbnailBarKt.PdfStaticThumbnailBar$lambda$2(thumbnailBarStateManager, stateCollectAsStateWithLifecycle, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PdfStaticThumbnailBarKt.PdfStaticThumbnailBar$lambda$3(thumbnailBarStateManager, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1973375337, i3, -1, "com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBar (PdfStaticThumbnailBar.kt:74)");
            }
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(thumbnailBarStateManager.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(thumbnailBarStateManager);
            if ((i3 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = zChangedInstance2 | z2;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3) {
                objRememberedValue = new PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1(thumbnailBarStateManager, function1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1(thumbnailBarStateManager, function1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(thumbnailBarStateManager, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composerStartRestartGroup, i3 & 14);
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), null, false, 3, null), null, false, ComposableLambdaKt.rememberComposableLambda(975459073, true, new Function3() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PdfStaticThumbnailBarKt.PdfStaticThumbnailBar$lambda$2(thumbnailBarStateManager, stateCollectAsStateWithLifecycle2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.PdfStaticThumbnailBar$lambda$3(thumbnailBarStateManager, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ThumbnailBarUiState PdfStaticThumbnailBar$lambda$0(State<ThumbnailBarUiState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfStaticThumbnailBar$lambda$2(ThumbnailBarStateManager thumbnailBarStateManager, State state, BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        int iMo748roundToPx0680j_4;
        boxWithConstraintsScope.getClass();
        if ((i & 6) == 0) {
            i |= composer.changed(boxWithConstraintsScope) ? 4 : 2;
        }
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(975459073, i, -1, "com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBar.<anonymous> (PdfStaticThumbnailBar.kt:108)");
            }
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            if (PdfStaticThumbnailBar$lambda$0(state).getLayoutStyle() == LayoutStyle.FLOATING) {
                composer.startReplaceGroup(152806813);
                iMo748roundToPx0680j_4 = density.mo748roundToPx0680j_4(PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__floating_thumbnail_bar_margin_horizontal, composer, 0)) * 2;
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(152940392);
                composer.endReplaceGroup();
                iMo748roundToPx0680j_4 = 0;
            }
            int iMo754toPx0680j_4 = ((int) density.mo754toPx0680j_4(boxWithConstraintsScope.mo1101getMaxWidthD9Ej5fM())) - iMo748roundToPx0680j_4;
            Integer numValueOf = Integer.valueOf(iMo754toPx0680j_4);
            LayoutStyle layoutStyle = PdfStaticThumbnailBar$lambda$0(state).getLayoutStyle();
            boolean zChanged = composer.changed(iMo754toPx0680j_4) | composer.changedInstance(thumbnailBarStateManager);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$2$1$1(iMo754toPx0680j_4, thumbnailBarStateManager, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(numValueOf, layoutStyle, (Function2) objRememberedValue, composer, 0);
            ThumbnailBarUiState thumbnailBarUiStatePdfStaticThumbnailBar$lambda$0 = PdfStaticThumbnailBar$lambda$0(state);
            boolean zChangedInstance = composer.changedInstance(thumbnailBarStateManager);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$2$2$1(thumbnailBarStateManager);
                composer.updateRememberedValue(objRememberedValue2);
            }
            ThumbnailBarContent(thumbnailBarUiStatePdfStaticThumbnailBar$lambda$0, (Function1) ((KFunction) objRememberedValue2), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfStaticThumbnailBar$lambda$3(ThumbnailBarStateManager thumbnailBarStateManager, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PdfStaticThumbnailBar(thumbnailBarStateManager, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:46:0x012f  */
    /* JADX WARN: Code duplicated, block: B:49:0x013b  */
    /* JADX WARN: Code duplicated, block: B:50:0x013f  */
    /* JADX WARN: Code duplicated, block: B:53:0x015c  */
    /* JADX WARN: Code duplicated, block: B:57:0x0180  */
    /* JADX WARN: Code duplicated, block: B:59:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:61:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:62:0x01da  */
    /* JADX WARN: Code duplicated, block: B:66:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:68:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:71:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    private static final void SelectedThumbnailOverlay(ThumbnailItem thumbnailItem, final ThumbnailBarTheme thumbnailBarTheme, Modifier modifier, Composer composer, final int i, final int i2) {
        final ThumbnailItem thumbnailItem2;
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        float f;
        State<Float> stateAnimateFloatAsState;
        Function0<ComposeUiNode> constructor;
        ThumbnailBitmap bitmap;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1258785006);
        if ((i & 6) == 0) {
            thumbnailItem2 = thumbnailItem;
            i3 = (composerStartRestartGroup.changedInstance(thumbnailItem2) ? 4 : 2) | i;
        } else {
            thumbnailItem2 = thumbnailItem;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(thumbnailBarTheme) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1258785006, i3, -1, "com.pspdfkit.ui.thumbnail.SelectedThumbnailOverlay (PdfStaticThumbnailBar.kt:428)");
                }
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                float thumbnailPaddingPx = thumbnailBarTheme.getThumbnailPaddingPx() * 2;
                float fMo750toDpu2uoSUM = density.mo750toDpu2uoSUM(thumbnailItem2.getPosition().c.width + thumbnailPaddingPx);
                float fMo750toDpu2uoSUM2 = density.mo750toDpu2uoSUM(thumbnailItem2.getPosition().c.height + thumbnailPaddingPx);
                float fMo751toDpu2uoSUM = density.mo751toDpu2uoSUM(thumbnailBarTheme.getThumbnailPaddingPx());
                if (thumbnailItem2.getBitmap() != null) {
                    f = 1.0f;
                } else {
                    f = 0.4f;
                }
                Modifier modifier5 = modifier4;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, AnimationSpecKt.tween$default(100, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, "selectedThumbnailAlpha", null, composerStartRestartGroup, 3072, 20);
                Modifier modifierClip = ClipKt.clip(BorderKt.m604borderxT4_qwU(SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier5, fMo750toDpu2uoSUM), fMo750toDpu2uoSUM2), fMo751toDpu2uoSUM, ColorKt.Color(thumbnailBarTheme.getThumbnailSelectedBorderColor()), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(thumbnailBarTheme.getThumbnailCornerRadiusDp()))), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(thumbnailBarTheme.getThumbnailCornerRadiusDp())));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                constructor = companion.getConstructor();
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
                f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (thumbnailItem2.getBitmap() != null) {
                    composerStartRestartGroup.startReplaceGroup(1240692170);
                    long id = thumbnailItem2.getBitmap().getId();
                    bitmap = thumbnailItem2.getBitmap();
                    zChangedInstance = composerStartRestartGroup.changedInstance(bitmap);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new PdfStaticThumbnailBarKt$SelectedThumbnailOverlay$1$1$1(bitmap);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    lz.a(id, (Function0) ((KFunction) objRememberedValue), "Selected Page " + (thumbnailItem2.getPageIndex() + 1), AlphaKt.alpha(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), SelectedThumbnailOverlay$lambda$3(stateAnimateFloatAsState)), ContentScale.INSTANCE.getFit(), null, composerStartRestartGroup, 24576, 32);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (thumbnailItem2.isRendering()) {
                        composerStartRestartGroup.startReplaceGroup(1241147777);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1241198710);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PdfStaticThumbnailBarKt.SelectedThumbnailOverlay$lambda$5(thumbnailItem2, thumbnailBarTheme, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1258785006, i3, -1, "com.pspdfkit.ui.thumbnail.SelectedThumbnailOverlay (PdfStaticThumbnailBar.kt:428)");
            }
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            float thumbnailPaddingPx2 = thumbnailBarTheme.getThumbnailPaddingPx() * 2;
            float fMo750toDpu2uoSUM3 = density2.mo750toDpu2uoSUM(thumbnailItem2.getPosition().c.width + thumbnailPaddingPx2);
            float fMo750toDpu2uoSUM4 = density2.mo750toDpu2uoSUM(thumbnailItem2.getPosition().c.height + thumbnailPaddingPx2);
            float fMo751toDpu2uoSUM2 = density2.mo751toDpu2uoSUM(thumbnailBarTheme.getThumbnailPaddingPx());
            if (thumbnailItem2.getBitmap() != null) {
                f = 1.0f;
            } else {
                f = 0.4f;
            }
            Modifier modifier6 = modifier4;
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, AnimationSpecKt.tween$default(100, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, "selectedThumbnailAlpha", null, composerStartRestartGroup, 3072, 20);
            Modifier modifierClip2 = ClipKt.clip(BorderKt.m604borderxT4_qwU(SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier6, fMo750toDpu2uoSUM3), fMo750toDpu2uoSUM4), fMo751toDpu2uoSUM2, ColorKt.Color(thumbnailBarTheme.getThumbnailSelectedBorderColor()), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(thumbnailBarTheme.getThumbnailCornerRadiusDp()))), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(thumbnailBarTheme.getThumbnailCornerRadiusDp())));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            constructor = companion2.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion2, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (thumbnailItem2.getBitmap() != null) {
                composerStartRestartGroup.startReplaceGroup(1240692170);
                long id2 = thumbnailItem2.getBitmap().getId();
                bitmap = thumbnailItem2.getBitmap();
                zChangedInstance = composerStartRestartGroup.changedInstance(bitmap);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue = new PdfStaticThumbnailBarKt$SelectedThumbnailOverlay$1$1$1(bitmap);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new PdfStaticThumbnailBarKt$SelectedThumbnailOverlay$1$1$1(bitmap);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                lz.a(id2, (Function0) ((KFunction) objRememberedValue), "Selected Page " + (thumbnailItem2.getPageIndex() + 1), AlphaKt.alpha(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), SelectedThumbnailOverlay$lambda$3(stateAnimateFloatAsState)), ContentScale.INSTANCE.getFit(), null, composerStartRestartGroup, 24576, 32);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (thumbnailItem2.isRendering()) {
                    composerStartRestartGroup.startReplaceGroup(1241147777);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1241198710);
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.SelectedThumbnailOverlay$lambda$5(thumbnailItem2, thumbnailBarTheme, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float SelectedThumbnailOverlay$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedThumbnailOverlay$lambda$5(ThumbnailItem thumbnailItem, ThumbnailBarTheme thumbnailBarTheme, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SelectedThumbnailOverlay(thumbnailItem, thumbnailBarTheme, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SetThumbnailBarDocument(final ThumbnailBarStateManager thumbnailBarStateManager, final PdfDocument pdfDocument, final PdfConfiguration pdfConfiguration, Composer composer, final int i) {
        int i2;
        thumbnailBarStateManager.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-219598463);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(thumbnailBarStateManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(pdfDocument) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(pdfConfiguration) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-219598463, i2, -1, "com.pspdfkit.ui.thumbnail.SetThumbnailBarDocument (PdfStaticThumbnailBar.kt:546)");
            }
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(pdfDocument) | composerStartRestartGroup.changedInstance(pdfConfiguration) | composerStartRestartGroup.changedInstance(thumbnailBarStateManager);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new PdfStaticThumbnailBarKt$SetThumbnailBarDocument$1$1(pdfDocument, pdfConfiguration, thumbnailBarStateManager, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(pdfDocument, pdfConfiguration, (Function2) objRememberedValue, composerStartRestartGroup, (i2 >> 3) & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.SetThumbnailBarDocument$lambda$1(thumbnailBarStateManager, pdfDocument, pdfConfiguration, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetThumbnailBarDocument$lambda$1(ThumbnailBarStateManager thumbnailBarStateManager, PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, int i, Composer composer, int i2) {
        SetThumbnailBarDocument(thumbnailBarStateManager, pdfDocument, pdfConfiguration, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SyncThumbnailBarPage(final ThumbnailBarStateManager thumbnailBarStateManager, final int i, Composer composer, final int i2) {
        int i3;
        thumbnailBarStateManager.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1146514188);
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(thumbnailBarStateManager) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1146514188, i3, -1, "com.pspdfkit.ui.thumbnail.SyncThumbnailBarPage (PdfStaticThumbnailBar.kt:565)");
            }
            Integer numValueOf = Integer.valueOf(i);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(thumbnailBarStateManager) | ((i3 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new PdfStaticThumbnailBarKt$SyncThumbnailBarPage$1$1(thumbnailBarStateManager, i, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composerStartRestartGroup, (i3 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.SyncThumbnailBarPage$lambda$1(thumbnailBarStateManager, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SyncThumbnailBarPage$lambda$1(ThumbnailBarStateManager thumbnailBarStateManager, int i, int i2, Composer composer, int i3) {
        SyncThumbnailBarPage(thumbnailBarStateManager, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    private static final void ThumbnailBarContent(ThumbnailBarUiState thumbnailBarUiState, final Function1<? super ThumbnailBarEvent, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Pair pair;
        float fMo751toDpu2uoSUM;
        final ThumbnailBarUiState thumbnailBarUiState2 = thumbnailBarUiState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-923881700);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(thumbnailBarUiState2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-923881700, i2, -1, "com.pspdfkit.ui.thumbnail.ThumbnailBarContent (PdfStaticThumbnailBar.kt:133)");
            }
            final ThumbnailBarTheme theme = thumbnailBarUiState2.getTheme();
            long jColor = ColorKt.Color(theme.getBackgroundColor());
            final long jColor2 = ColorKt.Color(theme.getBorderColor());
            LayoutStyle layoutStyle = thumbnailBarUiState2.getLayoutStyle();
            LayoutStyle layoutStyle2 = LayoutStyle.FLOATING;
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = layoutStyle == layoutStyle2 ? RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(theme.getFloatingCornerRadiusDp())) : RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(0));
            final Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            int bottom = WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density);
            float fDimensionResource = PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__floating_thumbnail_bar_margin_horizontal, composerStartRestartGroup, 0);
            float fDimensionResource2 = PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__floating_thumbnail_bar_margin_bottom, composerStartRestartGroup, 0);
            float fDimensionResource3 = PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__floating_thumbnail_bar_margin_above_navigation, composerStartRestartGroup, 0);
            float fDimensionResource4 = PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__floating_thumbnail_bar_elevation, composerStartRestartGroup, 0);
            int thumbnailHeight = theme.getThumbnailHeight() + (theme.getContentPaddingPx() * 2);
            LayoutStyle layoutStyle3 = thumbnailBarUiState.getLayoutStyle();
            float fM9687constructorimpl = fDimensionResource4;
            LayoutStyle layoutStyle4 = LayoutStyle.PINNED;
            int i3 = i2;
            float fMo751toDpu2uoSUM2 = density.mo751toDpu2uoSUM(thumbnailHeight + (layoutStyle3 == layoutStyle4 ? theme.getBorderSizePx() : 0) + (thumbnailBarUiState.getLayoutStyle() == layoutStyle4 ? bottom : 0));
            if (thumbnailBarUiState.getLayoutStyle() == layoutStyle2) {
                pair = TuplesKt.to(Dp.m9685boximpl(fDimensionResource), Dp.m9685boximpl(density.mo751toDpu2uoSUM(Math.max(bottom + density.mo748roundToPx0680j_4(fDimensionResource3), density.mo748roundToPx0680j_4(fDimensionResource2)))));
            } else {
                float f = 0;
                pair = TuplesKt.to(Dp.m9685boximpl(Dp.m9687constructorimpl(f)), Dp.m9685boximpl(Dp.m9687constructorimpl(f)));
            }
            float fM9701unboximpl = ((Dp) pair.component1()).m9701unboximpl();
            float fM9701unboximpl2 = ((Dp) pair.component2()).m9701unboximpl();
            if (thumbnailBarUiState.getLayoutStyle() != layoutStyle2) {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            if (thumbnailBarUiState.getLayoutStyle() != layoutStyle2 || thumbnailBarUiState.getDocument() == null) {
                fMo751toDpu2uoSUM = density.mo751toDpu2uoSUM(thumbnailBarUiState.getAvailableWidth());
            } else {
                ThumbnailItem thumbnailItem = (ThumbnailItem) CollectionsKt.lastOrNull((List) thumbnailBarUiState.getThumbnails());
                ThumbnailItem selectedPageThumbnail = thumbnailBarUiState.getSelectedPageThumbnail();
                ThumbnailItem selectedSiblingThumbnail = thumbnailBarUiState.getSelectedSiblingThumbnail();
                Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) CollectionsKt.listOfNotNull((Object[]) new Float[]{thumbnailItem != null ? Float.valueOf(thumbnailItem.getPosition().b + thumbnailItem.getPosition().c.width) : null, selectedPageThumbnail != null ? Float.valueOf(selectedPageThumbnail.getPosition().b + selectedPageThumbnail.getPosition().c.width) : null, selectedSiblingThumbnail != null ? Float.valueOf(selectedSiblingThumbnail.getPosition().b + selectedSiblingThumbnail.getPosition().c.width) : null}));
                fMo751toDpu2uoSUM = fMaxOrNull != null ? density.mo751toDpu2uoSUM(Math.min((theme.getContentPaddingPx() * 2) + ((int) fMaxOrNull.floatValue()), thumbnailBarUiState.getAvailableWidth())) : density.mo751toDpu2uoSUM(thumbnailBarUiState.getAvailableWidth());
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM9701unboximpl, 0.0f, fM9701unboximpl, fM9701unboximpl2, 2, null), fMo751toDpu2uoSUM2), Color.INSTANCE.m6849getTransparent0d7_KjU(), null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m1271width3ABfNKs(companion, fMo751toDpu2uoSUM), 0.0f, 1, null);
            Unit unit = Unit.INSTANCE;
            int i4 = i3 & 112;
            boolean z = i4 == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new PdfStaticThumbnailBarKt$ThumbnailBarContent$2$1$1(function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierFillMaxHeight$default, unit, (PointerInputEventHandler) objRememberedValue);
            boolean z2 = i4 == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new PdfStaticThumbnailBarKt$ThumbnailBarContent$2$2$1(function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierPointerInput2 = SuspendingPointerInputFilterKt.pointerInput(modifierPointerInput, unit, (PointerInputEventHandler) objRememberedValue2);
            thumbnailBarUiState2 = thumbnailBarUiState;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(modifierPointerInput2, roundedCornerShapeM1573RoundedCornerShape0680j_4, jColor, 0L, 0.0f, fM9687constructorimpl, null, ComposableLambdaKt.rememberComposableLambda(851687387, true, new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.ThumbnailBarContent$lambda$5$2(thumbnailBarUiState2, density, jColor2, theme, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 12582912, 88);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.ThumbnailBarContent$lambda$6(thumbnailBarUiState2, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThumbnailBarContent$lambda$5$2(ThumbnailBarUiState thumbnailBarUiState, Density density, long j, ThumbnailBarTheme thumbnailBarTheme, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(851687387, i, -1, "com.pspdfkit.ui.thumbnail.ThumbnailBarContent.<anonymous>.<anonymous> (PdfStaticThumbnailBar.kt:252)");
            }
            if (thumbnailBarUiState.getLayoutStyle() != LayoutStyle.PINNED || thumbnailBarUiState.getDocument() == null) {
                composer.startReplaceGroup(-2047495417);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-2047746238);
                BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), density.mo751toDpu2uoSUM(thumbnailBarTheme.getBorderSizePx())), j, null, 2, null), composer, 0);
                composer.endReplaceGroup();
            }
            if (thumbnailBarUiState.isLoading()) {
                composer.startReplaceGroup(-2047438191);
                LoadingState(composer, 0);
                composer.endReplaceGroup();
            } else if (thumbnailBarUiState.getError() != null) {
                composer.startReplaceGroup(-2047343424);
                ErrorState(thumbnailBarUiState.getError(), composer, 0);
                composer.endReplaceGroup();
            } else if (thumbnailBarUiState.getDocument() == null) {
                composer.startReplaceGroup(-2047229933);
                EmptyState(composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-2047152061);
                ThumbnailGrid(thumbnailBarUiState, composer, 0);
                composer.endReplaceGroup();
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
    public static final Unit ThumbnailBarContent$lambda$6(ThumbnailBarUiState thumbnailBarUiState, Function1 function1, int i, Composer composer, int i2) {
        ThumbnailBarContent(thumbnailBarUiState, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final void ThumbnailGrid(final ThumbnailBarUiState thumbnailBarUiState, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-227408215);
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(thumbnailBarUiState) ? 4 : 2) | i : i;
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-227408215, i2, -1, "com.pspdfkit.ui.thumbnail.ThumbnailGrid (PdfStaticThumbnailBar.kt:283)");
            }
            ThumbnailBarTheme theme = thumbnailBarUiState.getTheme();
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            if (thumbnailBarUiState.getThumbnails().isEmpty() && thumbnailBarUiState.getSelectedPageThumbnail() == null && thumbnailBarUiState.getSelectedSiblingThumbnail() == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PdfStaticThumbnailBarKt.ThumbnailGrid$lambda$0(thumbnailBarUiState, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            ThumbnailItem thumbnailItem = (ThumbnailItem) CollectionsKt.lastOrNull((List) thumbnailBarUiState.getThumbnails());
            Float fValueOf = thumbnailItem != null ? Float.valueOf(thumbnailItem.getPosition().b + thumbnailItem.getPosition().c.width) : null;
            ThumbnailItem selectedPageThumbnail = thumbnailBarUiState.getSelectedPageThumbnail();
            Float fValueOf2 = selectedPageThumbnail != null ? Float.valueOf(selectedPageThumbnail.getPosition().b + selectedPageThumbnail.getPosition().c.width) : null;
            ThumbnailItem selectedSiblingThumbnail = thumbnailBarUiState.getSelectedSiblingThumbnail();
            Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) CollectionsKt.listOfNotNull((Object[]) new Float[]{fValueOf, fValueOf2, selectedSiblingThumbnail != null ? Float.valueOf(selectedSiblingThumbnail.getPosition().b + selectedSiblingThumbnail.getPosition().c.width) : null}));
            int contentPaddingPx = theme.getContentPaddingPx() + (thumbnailBarUiState.getLayoutStyle() == LayoutStyle.FLOATING ? 0 : ((thumbnailBarUiState.getAvailableWidth() - (theme.getContentPaddingPx() * 2)) - (fMaxOrNull != null ? (int) fMaxOrNull.floatValue() : 0)) / 2);
            float fMo751toDpu2uoSUM = density.mo751toDpu2uoSUM(contentPaddingPx);
            float fMo751toDpu2uoSUM2 = density.mo751toDpu2uoSUM(theme.getContentPaddingPx());
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(112074690);
            for (ThumbnailItem thumbnailItem2 : thumbnailBarUiState.getThumbnails()) {
                composerStartRestartGroup.startMovableGroup(-1448675891, Integer.valueOf(thumbnailItem2.getPageIndex()));
                ThumbnailItem(thumbnailItem2, theme, OffsetKt.m1174offsetVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(density.mo751toDpu2uoSUM(thumbnailItem2.getPosition().b) + fMo751toDpu2uoSUM), fMo751toDpu2uoSUM2), composerStartRestartGroup, 0, 0);
                composerStartRestartGroup.endMovableGroup();
            }
            composerStartRestartGroup.endReplaceGroup();
            ThumbnailItem selectedPageThumbnail2 = thumbnailBarUiState.getSelectedPageThumbnail();
            if (selectedPageThumbnail2 == null) {
                composerStartRestartGroup.startReplaceGroup(-819450903);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-819450902);
                Float absolutePositionX = selectedPageThumbnail2.getAbsolutePositionX();
                float fFloatValue = absolutePositionX != null ? absolutePositionX.floatValue() : (contentPaddingPx + selectedPageThumbnail2.getPosition().b) - theme.getThumbnailPaddingPx();
                Float absolutePositionY = selectedPageThumbnail2.getAbsolutePositionY();
                SelectedThumbnailOverlay(selectedPageThumbnail2, theme, OffsetKt.m1174offsetVpY3zN4(Modifier.INSTANCE, density.mo750toDpu2uoSUM(fFloatValue), density.mo750toDpu2uoSUM(absolutePositionY != null ? absolutePositionY.floatValue() : theme.getContentPaddingPx() - theme.getThumbnailPaddingPx())), composerStartRestartGroup, 0, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            ThumbnailItem selectedSiblingThumbnail2 = thumbnailBarUiState.getSelectedSiblingThumbnail();
            if (selectedSiblingThumbnail2 == null) {
                composerStartRestartGroup.startReplaceGroup(-818568364);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-818568363);
                Float absolutePositionX2 = selectedSiblingThumbnail2.getAbsolutePositionX();
                float fFloatValue2 = absolutePositionX2 != null ? absolutePositionX2.floatValue() : (contentPaddingPx + selectedSiblingThumbnail2.getPosition().b) - theme.getThumbnailPaddingPx();
                Float absolutePositionY2 = selectedSiblingThumbnail2.getAbsolutePositionY();
                SelectedThumbnailOverlay(selectedSiblingThumbnail2, theme, OffsetKt.m1174offsetVpY3zN4(Modifier.INSTANCE, density.mo750toDpu2uoSUM(fFloatValue2), density.mo750toDpu2uoSUM(absolutePositionY2 != null ? absolutePositionY2.floatValue() : theme.getContentPaddingPx() - theme.getThumbnailPaddingPx())), composerStartRestartGroup, 0, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.ThumbnailGrid$lambda$7(thumbnailBarUiState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThumbnailGrid$lambda$0(ThumbnailBarUiState thumbnailBarUiState, int i, Composer composer, int i2) {
        ThumbnailGrid(thumbnailBarUiState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThumbnailGrid$lambda$7(ThumbnailBarUiState thumbnailBarUiState, int i, Composer composer, int i2) {
        ThumbnailGrid(thumbnailBarUiState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:43:0x010a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0116  */
    /* JADX WARN: Code duplicated, block: B:47:0x011a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0137  */
    /* JADX WARN: Code duplicated, block: B:54:0x015b  */
    /* JADX WARN: Code duplicated, block: B:56:0x0195  */
    /* JADX WARN: Code duplicated, block: B:58:0x019b  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    private static final void ThumbnailItem(ThumbnailItem thumbnailItem, ThumbnailBarTheme thumbnailBarTheme, Modifier modifier, Composer composer, final int i, final int i2) {
        final ThumbnailItem thumbnailItem2;
        int i3;
        ThumbnailBarTheme thumbnailBarTheme2;
        Modifier modifier2;
        boolean z;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<ComposeUiNode> constructor;
        ThumbnailBitmap bitmap;
        boolean zChangedInstance;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1298540266);
        if ((i & 6) == 0) {
            thumbnailItem2 = thumbnailItem;
            i3 = (composerStartRestartGroup.changedInstance(thumbnailItem2) ? 4 : 2) | i;
        } else {
            thumbnailItem2 = thumbnailItem;
            i3 = i;
        }
        if ((i & 48) == 0) {
            thumbnailBarTheme2 = thumbnailBarTheme;
            i3 |= composerStartRestartGroup.changed(thumbnailBarTheme2) ? 32 : 16;
        } else {
            thumbnailBarTheme2 = thumbnailBarTheme;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i4 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1298540266, i3, -1, "com.pspdfkit.ui.thumbnail.ThumbnailItem (PdfStaticThumbnailBar.kt:389)");
                }
                Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                Modifier modifierClip = ClipKt.clip(BorderKt.m604borderxT4_qwU(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, density.mo750toDpu2uoSUM(thumbnailItem2.getPosition().c.width)), density.mo750toDpu2uoSUM(thumbnailItem2.getPosition().c.height)), ColorKt.Color(thumbnailBarTheme2.getBackgroundColor()), null, 2, null), density.mo751toDpu2uoSUM(thumbnailBarTheme2.getThumbnailBorderWidth()), ColorKt.Color(thumbnailBarTheme2.getThumbnailBorderColor()), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(thumbnailBarTheme2.getThumbnailCornerRadiusDp()))), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(thumbnailBarTheme2.getThumbnailCornerRadiusDp())));
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                constructor = companion.getConstructor();
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
                f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                if (thumbnailItem2.getBitmap() != null) {
                    composerStartRestartGroup.startReplaceGroup(-1941822806);
                    long id = thumbnailItem2.getBitmap().getId();
                    bitmap = thumbnailItem2.getBitmap();
                    zChangedInstance = composerStartRestartGroup.changedInstance(bitmap);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new PdfStaticThumbnailBarKt$ThumbnailItem$1$1$1(bitmap);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    lz.a(id, (Function0) ((KFunction) objRememberedValue), "Page " + (thumbnailItem2.getPageIndex() + 1), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ContentScale.INSTANCE.getFit(), null, composerStartRestartGroup, 27648, 32);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (thumbnailItem2.isRendering()) {
                    composerStartRestartGroup.startReplaceGroup(-1941434252);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1941376282);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final ThumbnailBarTheme thumbnailBarTheme3 = thumbnailBarTheme2;
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PdfStaticThumbnailBarKt.ThumbnailItem$lambda$4(thumbnailItem2, thumbnailBarTheme3, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i4 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1298540266, i3, -1, "com.pspdfkit.ui.thumbnail.ThumbnailItem (PdfStaticThumbnailBar.kt:389)");
            }
            Density density2 = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            Modifier modifierClip2 = ClipKt.clip(BorderKt.m604borderxT4_qwU(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(modifier3, density2.mo750toDpu2uoSUM(thumbnailItem2.getPosition().c.width)), density2.mo750toDpu2uoSUM(thumbnailItem2.getPosition().c.height)), ColorKt.Color(thumbnailBarTheme2.getBackgroundColor()), null, 2, null), density2.mo751toDpu2uoSUM(thumbnailBarTheme2.getThumbnailBorderWidth()), ColorKt.Color(thumbnailBarTheme2.getThumbnailBorderColor()), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(thumbnailBarTheme2.getThumbnailCornerRadiusDp()))), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(thumbnailBarTheme2.getThumbnailCornerRadiusDp())));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            constructor = companion2.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion2, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (thumbnailItem2.getBitmap() != null) {
                composerStartRestartGroup.startReplaceGroup(-1941822806);
                long id2 = thumbnailItem2.getBitmap().getId();
                bitmap = thumbnailItem2.getBitmap();
                zChangedInstance = composerStartRestartGroup.changedInstance(bitmap);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue = new PdfStaticThumbnailBarKt$ThumbnailItem$1$1$1(bitmap);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new PdfStaticThumbnailBarKt$ThumbnailItem$1$1$1(bitmap);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                lz.a(id2, (Function0) ((KFunction) objRememberedValue), "Page " + (thumbnailItem2.getPageIndex() + 1), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ContentScale.INSTANCE.getFit(), null, composerStartRestartGroup, 27648, 32);
                composerStartRestartGroup.endReplaceGroup();
            } else if (thumbnailItem2.isRendering()) {
                composerStartRestartGroup.startReplaceGroup(-1941434252);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1941376282);
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final ThumbnailBarTheme thumbnailBarTheme4 = thumbnailBarTheme2;
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfStaticThumbnailBarKt.ThumbnailItem$lambda$4(thumbnailItem2, thumbnailBarTheme4, modifier5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThumbnailItem$lambda$4(ThumbnailItem thumbnailItem, ThumbnailBarTheme thumbnailBarTheme, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ThumbnailItem(thumbnailItem, thumbnailBarTheme, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final ThumbnailBarStateManager rememberThumbnailBarStateManager(Context context, Composer composer, int i, int i2) {
        if ((i2 & 1) != 0) {
            context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(323318869, i, -1, "com.pspdfkit.ui.thumbnail.rememberThumbnailBarStateManager (PdfStaticThumbnailBar.kt:525)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new ThumbnailBarStateManager(context);
            composer.updateRememberedValue(objRememberedValue);
        }
        final ThumbnailBarStateManager thumbnailBarStateManager = (ThumbnailBarStateManager) objRememberedValue;
        boolean zChangedInstance = composer.changedInstance(thumbnailBarStateManager);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PdfStaticThumbnailBarKt.rememberThumbnailBarStateManager$lambda$1$0(thumbnailBarStateManager, (DisposableEffectScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(thumbnailBarStateManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return thumbnailBarStateManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberThumbnailBarStateManager$lambda$1$0(final ThumbnailBarStateManager thumbnailBarStateManager, DisposableEffectScope disposableEffectScope) {
        disposableEffectScope.getClass();
        return new DisposableEffectResult() { // from class: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$rememberThumbnailBarStateManager$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                thumbnailBarStateManager.dispose();
            }
        };
    }
}
