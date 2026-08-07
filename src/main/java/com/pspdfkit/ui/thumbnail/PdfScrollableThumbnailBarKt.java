package com.pspdfkit.ui.thumbnail;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.e2;
import com.pspdfkit.internal.f2;
import com.pspdfkit.internal.lz;
import com.pspdfkit.internal.mn;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001aB\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a;\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0019\u001a]\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060&H\u0003¢\u0006\u0002\u0010'\u001aK\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010)2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0001H\u0002¢\u0006\u0004\b+\u0010,\u001a(\u0010-\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0002\u001a\"\u0010/\u001a\u00020\u0006*\u00020\u00162\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u00102\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00063²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002"}, d2 = {"NonSelectedCornerRadius", "Landroidx/compose/ui/unit/Dp;", "F", "LOG_TAG", "", "PdfScrollableThumbnailBar", "", "stateManager", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;", "onPageChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pageIndex", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ScrollableThumbnailBarContent", "state", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "onEvent", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ScrollableThumbnailItem", "bitmap", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;", "isSelected", "", "theme", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;", "isDoublePageMode", "isFirstPageSingle", "isRTL", "totalPageCount", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(ILcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;ZLcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;ZZZILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculateItemMargins", "Lkotlin/Pair;", "thumbnailMarginDp", "calculateItemMargins-JTrpX9M", "(IZZZIF)Lkotlin/Pair;", "isPageSelected", "selectedPage", "scrollToItemCentered", FirebaseAnalytics.Param.INDEX, "animate", "(Landroidx/compose/foundation/lazy/LazyListState;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PdfScrollableThumbnailBarKt {
    private static final String LOG_TAG = "ScrollableThumbnailBar";
    private static final float NonSelectedCornerRadius = Dp.m9687constructorimpl(2);

    /* JADX INFO: renamed from: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$scrollToItemCentered$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt", f = "PdfScrollableThumbnailBar.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {450, 452, 461}, m = "scrollToItemCentered", n = {"$this$scrollToItemCentered", FirebaseAnalytics.Param.INDEX, "animate", "$this$scrollToItemCentered", FirebaseAnalytics.Param.INDEX, "animate", "$this$scrollToItemCentered", "itemInfo", FirebaseAnalytics.Param.INDEX, "animate", "viewportWidth", "itemCenter", "viewportCenter", "delta"}, nl = {452, 455, 463}, s = {"L$0", "I$0", "Z$0", "L$0", "I$0", "Z$0", "L$0", "L$1", "I$0", "Z$0", "I$1", "I$2", "I$3", "F$0"}, v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PdfScrollableThumbnailBarKt.scrollToItemCentered(null, 0, false, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:61:0x010e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0113  */
    /* JADX WARN: Code duplicated, block: B:66:0x011d  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    public static final void PdfScrollableThumbnailBar(final ThumbnailBarStateManager thumbnailBarStateManager, final Function1<? super Integer, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        LazyListState lazyListStateRememberLazyListState;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean zChanged;
        Object objRememberedValue2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        thumbnailBarStateManager.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-302610139);
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
                    ComposerKt.traceEventStart(-302610139, i3, -1, "com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBar (PdfScrollableThumbnailBar.kt:81)");
                }
                State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(thumbnailBarStateManager.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                zChangedInstance = composerStartRestartGroup.changedInstance(thumbnailBarStateManager) | ((i3 & 112) == 32) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1(thumbnailBarStateManager, function1, lazyListStateRememberLazyListState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                EffectsKt.LaunchedEffect(thumbnailBarStateManager, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composerStartRestartGroup, i3 & 14);
                zChanged = composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | composerStartRestartGroup.changedInstance(thumbnailBarStateManager);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1(lazyListStateRememberLazyListState, thumbnailBarStateManager, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                EffectsKt.LaunchedEffect(lazyListStateRememberLazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 0);
                ThumbnailBarUiState thumbnailBarUiStatePdfScrollableThumbnailBar$lambda$0 = PdfScrollableThumbnailBar$lambda$0(stateCollectAsStateWithLifecycle);
                zChangedInstance2 = composerStartRestartGroup.changedInstance(thumbnailBarStateManager);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$3$1(thumbnailBarStateManager);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Modifier modifier5 = modifier4;
                ScrollableThumbnailBarContent(thumbnailBarUiStatePdfScrollableThumbnailBar$lambda$0, lazyListStateRememberLazyListState, (Function1) ((KFunction) objRememberedValue3), modifier5, composerStartRestartGroup, (i3 << 3) & 7168, 0);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PdfScrollableThumbnailBarKt.PdfScrollableThumbnailBar$lambda$4(thumbnailBarStateManager, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                ComposerKt.traceEventStart(-302610139, i3, -1, "com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBar (PdfScrollableThumbnailBar.kt:81)");
            }
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(thumbnailBarStateManager.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            zChangedInstance = composerStartRestartGroup.changedInstance(thumbnailBarStateManager) | ((i3 & 112) == 32) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue = new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1(thumbnailBarStateManager, function1, lazyListStateRememberLazyListState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$1$1(thumbnailBarStateManager, function1, lazyListStateRememberLazyListState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            EffectsKt.LaunchedEffect(thumbnailBarStateManager, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composerStartRestartGroup, i3 & 14);
            zChanged = composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | composerStartRestartGroup.changedInstance(thumbnailBarStateManager);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                objRememberedValue2 = new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1(lazyListStateRememberLazyListState, thumbnailBarStateManager, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$2$1(lazyListStateRememberLazyListState, thumbnailBarStateManager, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(lazyListStateRememberLazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 0);
            ThumbnailBarUiState thumbnailBarUiStatePdfScrollableThumbnailBar$lambda$1 = PdfScrollableThumbnailBar$lambda$0(stateCollectAsStateWithLifecycle2);
            zChangedInstance2 = composerStartRestartGroup.changedInstance(thumbnailBarStateManager);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue3 = new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$3$1(thumbnailBarStateManager);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new PdfScrollableThumbnailBarKt$PdfScrollableThumbnailBar$3$1(thumbnailBarStateManager);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifier6 = modifier4;
            ScrollableThumbnailBarContent(thumbnailBarUiStatePdfScrollableThumbnailBar$lambda$1, lazyListStateRememberLazyListState, (Function1) ((KFunction) objRememberedValue3), modifier6, composerStartRestartGroup, (i3 << 3) & 7168, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfScrollableThumbnailBarKt.PdfScrollableThumbnailBar$lambda$4(thumbnailBarStateManager, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ThumbnailBarUiState PdfScrollableThumbnailBar$lambda$0(State<ThumbnailBarUiState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfScrollableThumbnailBar$lambda$4(ThumbnailBarStateManager thumbnailBarStateManager, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PdfScrollableThumbnailBar(thumbnailBarStateManager, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00af  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:59:0x0156  */
    /* JADX WARN: Code duplicated, block: B:62:0x0162  */
    /* JADX WARN: Code duplicated, block: B:63:0x0166  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:67:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:75:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:80:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:83:? A[RETURN, SYNTHETIC] */
    private static final void ScrollableThumbnailBarContent(final ThumbnailBarUiState thumbnailBarUiState, final LazyListState lazyListState, final Function1<? super ThumbnailBarEvent, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        LazyListState lazyListState2;
        Modifier modifier2;
        boolean z;
        final ThumbnailBarUiState thumbnailBarUiState2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Modifier modifier4;
        final ThumbnailBarTheme theme;
        Density density;
        PdfDocument document;
        final int pageCount;
        Function0<ComposeUiNode> constructor;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1910339478);
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(thumbnailBarUiState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            lazyListState2 = lazyListState;
            i3 |= composerStartRestartGroup.changed(lazyListState2) ? 32 : 16;
        } else {
            lazyListState2 = lazyListState;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
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
                    ComposerKt.traceEventStart(-1910339478, i3, -1, "com.pspdfkit.ui.thumbnail.ScrollableThumbnailBarContent (PdfScrollableThumbnailBar.kt:136)");
                }
                theme = thumbnailBarUiState.getTheme();
                density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                document = thumbnailBarUiState.getDocument();
                if (document == null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final LazyListState lazyListState3 = lazyListState2;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PdfScrollableThumbnailBarKt.ScrollableThumbnailBarContent$lambda$0(thumbnailBarUiState, lazyListState3, function1, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                thumbnailBarUiState2 = thumbnailBarUiState;
                Modifier modifier5 = modifier4;
                pageCount = document.getPageCount();
                float fMo751toDpu2uoSUM = density.mo751toDpu2uoSUM(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density));
                float f = (float) 2;
                float fM9687constructorimpl = Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(theme.getViewPaddingDp()) * f) + Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(theme.getSelectionBorderWidthDp()) * f) + Dp.m9687constructorimpl(theme.getThumbnailHeightDp()))) + fMo751toDpu2uoSUM);
                boolean zIsRTL = thumbnailBarUiState2.isRTL();
                float fM9687constructorimpl2 = Dp.m9687constructorimpl(theme.getViewPaddingDp());
                Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, null), fM9687constructorimpl), ColorKt.Color(theme.getBackgroundColor()), null, 2, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
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
                PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(fM9687constructorimpl2, 0.0f, fM9687constructorimpl2, fMo751toDpu2uoSUM, 2, null);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                boolean zChanged = composerStartRestartGroup.changed(pageCount) | composerStartRestartGroup.changedInstance(thumbnailBarUiState2) | composerStartRestartGroup.changed(theme);
                if ((i3 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = zChanged | z2;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PdfScrollableThumbnailBarKt.ScrollableThumbnailBarContent$lambda$2$0$0(pageCount, thumbnailBarUiState2, theme, function1, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                LazyDslKt.LazyRow(modifierFillMaxSize$default, lazyListState, paddingValuesM1215PaddingValuesa9UjIt4$default, zIsRTL, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, (i3 & 112) | 6, 496);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                thumbnailBarUiState2 = thumbnailBarUiState;
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final ThumbnailBarUiState thumbnailBarUiState3 = thumbnailBarUiState2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PdfScrollableThumbnailBarKt.ScrollableThumbnailBarContent$lambda$3(thumbnailBarUiState3, lazyListState, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
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
                ComposerKt.traceEventStart(-1910339478, i3, -1, "com.pspdfkit.ui.thumbnail.ScrollableThumbnailBarContent (PdfScrollableThumbnailBar.kt:136)");
            }
            theme = thumbnailBarUiState.getTheme();
            density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            document = thumbnailBarUiState.getDocument();
            if (document == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    final LazyListState lazyListState4 = lazyListState2;
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PdfScrollableThumbnailBarKt.ScrollableThumbnailBarContent$lambda$0(thumbnailBarUiState, lazyListState4, function1, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            thumbnailBarUiState2 = thumbnailBarUiState;
            Modifier modifier6 = modifier4;
            pageCount = document.getPageCount();
            float fMo751toDpu2uoSUM2 = density.mo751toDpu2uoSUM(WindowInsets_androidKt.getNavigationBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6).getBottom(density));
            float f2 = (float) 2;
            float fM9687constructorimpl3 = Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(theme.getViewPaddingDp()) * f2) + Dp.m9687constructorimpl(Dp.m9687constructorimpl(Dp.m9687constructorimpl(theme.getSelectionBorderWidthDp()) * f2) + Dp.m9687constructorimpl(theme.getThumbnailHeightDp()))) + fMo751toDpu2uoSUM2);
            boolean zIsRTL2 = thumbnailBarUiState2.isRTL();
            float fM9687constructorimpl4 = Dp.m9687constructorimpl(theme.getViewPaddingDp());
            Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier6, 0.0f, 1, null), fM9687constructorimpl3), ColorKt.Color(theme.getBackgroundColor()), null, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default2);
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
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default2 = PaddingKt.m1215PaddingValuesa9UjIt4$default(fM9687constructorimpl4, 0.0f, fM9687constructorimpl4, fMo751toDpu2uoSUM2, 2, null);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            boolean zChanged2 = composerStartRestartGroup.changed(pageCount) | composerStartRestartGroup.changedInstance(thumbnailBarUiState2) | composerStartRestartGroup.changed(theme);
            if ((i3 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = zChanged2 | z2;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PdfScrollableThumbnailBarKt.ScrollableThumbnailBarContent$lambda$2$0$0(pageCount, thumbnailBarUiState2, theme, function1, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PdfScrollableThumbnailBarKt.ScrollableThumbnailBarContent$lambda$2$0$0(pageCount, thumbnailBarUiState2, theme, function1, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyRow(modifierFillMaxSize$default2, lazyListState, paddingValuesM1215PaddingValuesa9UjIt4$default2, zIsRTL2, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, (i3 & 112) | 6, 496);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            thumbnailBarUiState2 = thumbnailBarUiState;
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final ThumbnailBarUiState thumbnailBarUiState4 = thumbnailBarUiState2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfScrollableThumbnailBarKt.ScrollableThumbnailBarContent$lambda$3(thumbnailBarUiState4, lazyListState, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableThumbnailBarContent$lambda$0(ThumbnailBarUiState thumbnailBarUiState, LazyListState lazyListState, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ScrollableThumbnailBarContent(thumbnailBarUiState, lazyListState, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableThumbnailBarContent$lambda$2$0$0(final int i, final ThumbnailBarUiState thumbnailBarUiState, final ThumbnailBarTheme thumbnailBarTheme, final Function1 function1, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        LazyListScope.items$default(lazyListScope, i, new Function1() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(((Integer) obj).intValue());
            }
        }, null, ComposableLambdaKt.composableLambdaInstance(-1673808700, true, new Function4() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PdfScrollableThumbnailBarKt.ScrollableThumbnailBarContent$lambda$2$0$0$1(thumbnailBarUiState, thumbnailBarTheme, i, function1, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableThumbnailBarContent$lambda$2$0$0$1(ThumbnailBarUiState thumbnailBarUiState, ThumbnailBarTheme thumbnailBarTheme, int i, final Function1 function1, LazyItemScope lazyItemScope, final int i2, Composer composer, int i3) {
        int i4;
        lazyItemScope.getClass();
        if ((i3 & 48) == 0) {
            i4 = i3 | (composer.changed(i2) ? 32 : 16);
        } else {
            i4 = i3;
        }
        if (composer.shouldExecute((i4 & Token.COLONCOLON) != 144, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1673808700, i4, -1, "com.pspdfkit.ui.thumbnail.ScrollableThumbnailBarContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PdfScrollableThumbnailBar.kt:179)");
            }
            ThumbnailBitmap thumbnailBitmap = thumbnailBarUiState.getScrollableThumbnails().get(Integer.valueOf(i2));
            boolean zIsPageSelected = isPageSelected(i2, thumbnailBarUiState.getScrollableSelectedPageIndex(), thumbnailBarUiState.isDoublePageMode(), thumbnailBarUiState.isFirstPageSingle());
            boolean zIsDoublePageMode = thumbnailBarUiState.isDoublePageMode();
            int i5 = i4;
            boolean zIsFirstPageSingle = thumbnailBarUiState.isFirstPageSingle();
            boolean zIsRTL = thumbnailBarUiState.isRTL();
            boolean zChanged = composer.changed(function1) | ((i5 & 112) == 32);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PdfScrollableThumbnailBarKt.ScrollableThumbnailBarContent$lambda$2$0$0$1$0$0(function1, i2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ScrollableThumbnailItem(i2, thumbnailBitmap, zIsPageSelected, thumbnailBarTheme, zIsDoublePageMode, zIsFirstPageSingle, zIsRTL, i, (Function0) objRememberedValue, composer, (i5 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableThumbnailBarContent$lambda$2$0$0$1$0$0(Function1 function1, int i) {
        function1.invoke(new ThumbnailBarEvent.ThumbnailClicked(i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableThumbnailBarContent$lambda$3(ThumbnailBarUiState thumbnailBarUiState, LazyListState lazyListState, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ScrollableThumbnailBarContent(thumbnailBarUiState, lazyListState, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final void ScrollableThumbnailItem(final int i, final ThumbnailBitmap thumbnailBitmap, final boolean z, final ThumbnailBarTheme thumbnailBarTheme, final boolean z2, final boolean z3, final boolean z4, final int i2, final Function0<Unit> function0, Composer composer, final int i3) {
        int i4;
        ThumbnailBarTheme thumbnailBarTheme2;
        Function0<Unit> function1;
        Composer composer2;
        Alignment centerStart;
        Modifier modifierClip;
        Alignment centerStart2;
        Composer composerStartRestartGroup = composer.startRestartGroup(233803181);
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(thumbnailBitmap) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            thumbnailBarTheme2 = thumbnailBarTheme;
            i4 |= composerStartRestartGroup.changed(thumbnailBarTheme2) ? 2048 : 1024;
        } else {
            thumbnailBarTheme2 = thumbnailBarTheme;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerStartRestartGroup.changed(z4) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            function1 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
        } else {
            function1 = function0;
        }
        int i5 = i4;
        if (composerStartRestartGroup.shouldExecute((38347923 & i5) != 38347922, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(233803181, i5, -1, "com.pspdfkit.ui.thumbnail.ScrollableThumbnailItem (PdfScrollableThumbnailBar.kt:214)");
            }
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            float fM9687constructorimpl = Dp.m9687constructorimpl(thumbnailBarTheme2.getThumbnailWidthDp());
            float fM9687constructorimpl2 = Dp.m9687constructorimpl(thumbnailBarTheme2.getThumbnailHeightDp());
            float fM9687constructorimpl3 = Dp.m9687constructorimpl(thumbnailBarTheme2.getSelectionBorderWidthDp());
            float fM9687constructorimpl4 = Dp.m9687constructorimpl(thumbnailBarTheme2.getThumbnailMarginDp());
            float fM9687constructorimpl5 = Dp.m9687constructorimpl(thumbnailBarTheme2.getSelectionBorderCornerRadiusDp());
            float fM9687constructorimpl6 = Dp.m9687constructorimpl(fM9687constructorimpl3 / 2);
            float fM9687constructorimpl7 = Dp.m9687constructorimpl(fM9687constructorimpl + fM9687constructorimpl3);
            float fM9687constructorimpl8 = Dp.m9687constructorimpl(fM9687constructorimpl2 + fM9687constructorimpl3);
            Pair<Dp, Dp> pairM14290calculateItemMarginsJTrpX9M = m14290calculateItemMarginsJTrpX9M(i, z2, z3, z4, i2, fM9687constructorimpl4);
            float fM9701unboximpl = pairM14290calculateItemMarginsJTrpX9M.component1().m9701unboximpl();
            float fM9701unboximpl2 = pairM14290calculateItemMarginsJTrpX9M.component2().m9701unboximpl();
            boolean z5 = z2 && ((i == 0 && z3) || ((i == 0 && i2 == 1) || (i == i2 + (-1) && i % 2 == z3)));
            boolean z6 = z2 && !z5 && mn.a(i, z3, z4);
            boolean z7 = (!z2 || z5 || z6) ? false : true;
            if (z6) {
                centerStart = Alignment.INSTANCE.getCenterEnd();
            } else {
                centerStart = z7 ? Alignment.INSTANCE.getCenterStart() : Alignment.INSTANCE.getCenter();
            }
            Alignment alignment = centerStart;
            boolean z8 = z5;
            Shape doublePageBorderShape = (z && z2 && !z8) ? new DoublePageBorderShape(fM9687constructorimpl5, z6, null) : RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(fM9687constructorimpl5);
            final long jColor = z ? ColorKt.Color(thumbnailBarTheme2.getThumbnailSelectedBorderColor()) : ColorKt.Color(thumbnailBarTheme2.getThumbnailBorderColor());
            if (!z) {
                fM9687constructorimpl6 = Dp.m9687constructorimpl(thumbnailBarTheme2.getThumbnailBorderWidthDp());
            }
            float f = fM9687constructorimpl6;
            boolean z9 = z2 && !z8;
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(companion, fM9701unboximpl, 0.0f, fM9701unboximpl2, 0.0f, 10, null), fM9687constructorimpl7), fM9687constructorimpl8);
            if (z9) {
                composerStartRestartGroup.startReplaceGroup(-1203455688);
                final float fMo754toPx0680j_4 = density.mo754toPx0680j_4(f);
                float fMo754toPx0680j_5 = z ? density.mo754toPx0680j_4(fM9687constructorimpl5) : density.mo754toPx0680j_4(NonSelectedCornerRadius);
                if (!z) {
                    fM9687constructorimpl5 = NonSelectedCornerRadius;
                }
                DoublePageBorderShape doublePageBorderShape2 = new DoublePageBorderShape(fM9687constructorimpl5, z6, null);
                final float f2 = fMo754toPx0680j_5;
                boolean zChanged = composerStartRestartGroup.changed(fMo754toPx0680j_4) | composerStartRestartGroup.changed(fMo754toPx0680j_5) | composerStartRestartGroup.changed(z6) | composerStartRestartGroup.changed(jColor);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final boolean z10 = z6;
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PdfScrollableThumbnailBarKt.ScrollableThumbnailItem$lambda$3$0(fMo754toPx0680j_4, f2, z10, jColor, (ContentDrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                modifierClip = ClipKt.clip(DrawModifierKt.drawWithContent(companion, (Function1) objRememberedValue), doublePageBorderShape2);
                composerStartRestartGroup.endReplaceGroup();
            } else if (z) {
                composerStartRestartGroup.startReplaceGroup(-1200860244);
                composerStartRestartGroup.endReplaceGroup();
                modifierClip = ClipKt.clip(BorderKt.m604borderxT4_qwU(companion, f, jColor, doublePageBorderShape), doublePageBorderShape);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1200502132);
                composerStartRestartGroup.endReplaceGroup();
                float f3 = NonSelectedCornerRadius;
                modifierClip = ClipKt.clip(BorderKt.m604borderxT4_qwU(companion, f, jColor, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(f3)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(f3));
            }
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierM1252height3ABfNKs.then(modifierClip), false, null, null, null, function1, 15, null);
            boolean z11 = (i5 & 896) == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PdfScrollableThumbnailBarKt.ScrollableThumbnailItem$lambda$4$0(z, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM632clickableoSLSa3U$default, false, (Function1) objRememberedValue2, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default);
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
            if (thumbnailBitmap != null) {
                composerStartRestartGroup.startReplaceGroup(-520354518);
                if (z6) {
                    centerStart2 = Alignment.INSTANCE.getCenterEnd();
                } else {
                    centerStart2 = z7 ? Alignment.INSTANCE.getCenterStart() : Alignment.INSTANCE.getCenter();
                }
                Alignment alignment2 = centerStart2;
                long id = thumbnailBitmap.getId();
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(thumbnailBitmap);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new PdfScrollableThumbnailBarKt$ScrollableThumbnailItem$3$1$1(thumbnailBitmap);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                lz.a(id, (Function0) ((KFunction) objRememberedValue3), "Page " + (i + 1), SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), ContentScale.INSTANCE.getFit(), alignment2, composerStartRestartGroup, 27648, 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(-519630885);
                composer2.endReplaceGroup();
            }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfScrollableThumbnailBarKt.ScrollableThumbnailItem$lambda$6(i, thumbnailBitmap, z, thumbnailBarTheme, z2, z3, z4, i2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableThumbnailItem$lambda$3$0(float f, float f2, boolean z, long j, ContentDrawScope contentDrawScope) {
        long jM6561constructorimpl;
        contentDrawScope.getClass();
        contentDrawScope.drawContent();
        float f3 = f / 2;
        float fCoerceAtLeast = RangesKt.coerceAtLeast(f2 - f3, 0.0f);
        float f4 = f2 + f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() & 4294967295L));
        int iM6803getIntersectrtfAjoo = ClipOp.INSTANCE.m6803getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long jMo7316getSizeNHjbRc = drawContext.mo7316getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo7319clipRectN_I0leg(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2, iM6803getIntersectrtfAjoo);
            if (z) {
                jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
            } else {
                jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(-f4)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
            }
            long j2 = jM6561constructorimpl;
            DrawScope.m7391drawRoundRectuAw5IA$default(contentDrawScope, j, j2, Size.m6629constructorimpl((((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() >> 32)) + f4) - f3)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (contentDrawScope.mo7395getSizeNHjbRc() & 4294967295L)) - f)) & 4294967295L)), CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(fCoerceAtLeast)) & 4294967295L) | (Float.floatToRawIntBits(fCoerceAtLeast) << 32)), new Stroke(f, 0.0f, 0, 0, null, 30, null), 0.0f, null, 0, 224, null);
            return Unit.INSTANCE;
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo7317setSizeuvyYCjk(jMo7316getSizeNHjbRc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableThumbnailItem$lambda$4$0(boolean z, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.getClass();
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableThumbnailItem$lambda$6(int i, ThumbnailBitmap thumbnailBitmap, boolean z, ThumbnailBarTheme thumbnailBarTheme, boolean z2, boolean z3, boolean z4, int i2, Function0 function0, int i3, Composer composer, int i4) {
        ScrollableThumbnailItem(i, thumbnailBitmap, z, thumbnailBarTheme, z2, z3, z4, i2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: calculateItemMargins-JTrpX9M, reason: not valid java name */
    private static final Pair<Dp, Dp> m14290calculateItemMarginsJTrpX9M(int i, boolean z, boolean z2, boolean z3, int i2, float f) {
        if (!z) {
            if (i2 == 1) {
                float f2 = 0;
                return TuplesKt.to(Dp.m9685boximpl(Dp.m9687constructorimpl(f2)), Dp.m9685boximpl(Dp.m9687constructorimpl(f2)));
            }
            if (i == 0) {
                return TuplesKt.to(Dp.m9685boximpl(Dp.m9687constructorimpl(0)), Dp.m9685boximpl(f));
            }
            return i == i2 - 1 ? TuplesKt.to(Dp.m9685boximpl(f), Dp.m9685boximpl(Dp.m9687constructorimpl(0))) : TuplesKt.to(Dp.m9685boximpl(f), Dp.m9685boximpl(f));
        }
        boolean z4 = (i == 0 && z2) || (i == 0 && i2 == 1) || (i == i2 + (-1) && i % 2 == z2);
        boolean zA = mn.a(i, z2, z3);
        if (i == 0) {
            if (z4) {
                return TuplesKt.to(Dp.m9685boximpl(Dp.m9687constructorimpl(0)), Dp.m9685boximpl(f));
            }
            float f3 = 0;
            return TuplesKt.to(Dp.m9685boximpl(Dp.m9687constructorimpl(f3)), Dp.m9685boximpl(Dp.m9687constructorimpl(f3)));
        }
        if (i != i2 - 1) {
            return zA ? TuplesKt.to(Dp.m9685boximpl(f), Dp.m9685boximpl(Dp.m9687constructorimpl(0))) : TuplesKt.to(Dp.m9685boximpl(Dp.m9687constructorimpl(0)), Dp.m9685boximpl(f));
        }
        if (z4) {
            return TuplesKt.to(Dp.m9685boximpl(f), Dp.m9685boximpl(Dp.m9687constructorimpl(0)));
        }
        float f4 = 0;
        return TuplesKt.to(Dp.m9685boximpl(Dp.m9687constructorimpl(f4)), Dp.m9685boximpl(Dp.m9687constructorimpl(f4)));
    }

    private static final boolean isPageSelected(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            return i == i2;
        }
        if (i != 0 && (i != 1 || z2)) {
            if (!((!z2) ^ (!(i % 2 == 0)))) {
                i--;
            }
        } else {
            i = 0;
        }
        return i == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        if (androidx.compose.foundation.lazy.LazyListState.animateScrollToItem$default(r1, r2, 0, r4, 2, null) == r0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0079, code lost:
    
        if (androidx.compose.foundation.lazy.LazyListState.scrollToItem$default(r1, r2, 0, r4, 2, null) == r0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f2, code lost:
    
        if (androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy$default(r1, r5, null, r4, 2, null) == r0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object scrollToItemCentered(androidx.compose.foundation.lazy.LazyListState r9, int r10, boolean r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt.scrollToItemCentered(androidx.compose.foundation.lazy.LazyListState, int, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
