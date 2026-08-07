package com.pspdfkit.ui.thumbnail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.document.PageBinding;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.ca;
import com.pspdfkit.internal.iu;
import com.pspdfkit.internal.j60;
import com.pspdfkit.internal.jm;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.mn;
import com.pspdfkit.internal.ou;
import com.pspdfkit.internal.oy;
import com.pspdfkit.internal.p40;
import com.pspdfkit.internal.p60;
import com.pspdfkit.internal.q40;
import com.pspdfkit.internal.q60;
import com.pspdfkit.internal.qv;
import com.pspdfkit.internal.uc;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.rx3.RxAwaitKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0093\u00012\u00020\u0001:\u0002\u0093\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\nJ\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\nJ\u0017\u0010&\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\nJ\u001f\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u000eJ\u0017\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u001cH\u0002¢\u0006\u0004\b+\u0010\u001fJ\u0017\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001cH\u0002¢\u0006\u0004\b-\u0010\u001fJ\u001d\u00101\u001a\u00020\b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u0010\nJ\u001f\u00106\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\bH\u0002¢\u0006\u0004\b>\u0010=J\u000f\u0010?\u001a\u00020\bH\u0002¢\u0006\u0004\b?\u0010=J\u000f\u0010@\u001a\u00020\bH\u0002¢\u0006\u0004\b@\u0010=J\u000f\u0010A\u001a\u00020\bH\u0002¢\u0006\u0004\bA\u0010=J\u000f\u0010B\u001a\u00020\bH\u0002¢\u0006\u0004\bB\u0010=J\u0017\u0010C\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\bC\u0010\nJ\u000f\u0010D\u001a\u00020\bH\u0002¢\u0006\u0004\bD\u0010=J\u001d\u0010G\u001a\u00020\b2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060EH\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010\nJ\u001d\u0010J\u001a\u00020\b2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060EH\u0002¢\u0006\u0004\bJ\u0010HJ0\u0010Q\u001a\u00020P2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020K2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020NH\u0082@¢\u0006\u0004\bQ\u0010RJ3\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060U2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u00062\u0006\u0010T\u001a\u00020\u001cH\u0002¢\u0006\u0004\bV\u0010WJ\u001f\u0010Z\u001a\u00020P2\u0006\u00105\u001a\u00020P2\u0006\u0010Y\u001a\u00020XH\u0002¢\u0006\u0004\bZ\u0010[J\u0017\u0010]\u001a\u00020\\2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020\bH\u0002¢\u0006\u0004\b_\u0010=J\u0015\u0010b\u001a\u00020\b2\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\r\u0010d\u001a\u00020\b¢\u0006\u0004\bd\u0010=J\u0017\u0010f\u001a\u00020\b2\u0006\u0010e\u001a\u00020/H\u0016¢\u0006\u0004\bf\u0010gJ\u001f\u0010f\u001a\u00020\b2\u0006\u0010e\u001a\u00020/2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\bf\u0010hR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010iR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020L0m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u001d\u0010q\u001a\b\u0012\u0004\u0012\u00020L0p8\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020v0u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u001d\u0010z\u001a\b\u0012\u0004\u0012\u00020v0y8\u0006¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R#\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u007f0~8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R#\u0010\u0082\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u007f0~8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0081\u0001R\u001f\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060E8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0086\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0017\u0010\u008b\u0001\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001e\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0084\u0001¨\u0006\u0094\u0001"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider$DrawableProviderObserver;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "pageIndex", "", "handleThumbnailClicked", "(I)V", "touchX", "touchY", "handleThumbnailScrolled", "(II)V", "emitNavigateToPage", "Lcom/pspdfkit/document/PdfDocument;", "document", "Lcom/pspdfkit/configuration/PdfConfiguration;", "configuration", "handleDocumentSet", "(Lcom/pspdfkit/document/PdfDocument;Lcom/pspdfkit/configuration/PdfConfiguration;)V", "handlePageChanged", "handlePageUpdated", "Lcom/pspdfkit/ui/thumbnail/LayoutStyle;", "style", "handleLayoutStyleChanged", "(Lcom/pspdfkit/ui/thumbnail/LayoutStyle;)V", "", "isScrollable", "handleScrollableModeChanged", "(Z)V", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;", "theme", "handleThemeChanged", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;)V", "color", "handleBackgroundColorChanged", "handleThumbnailBorderColorChanged", "width", "height", "handleThumbnailSizeChanged", "useAspectRatio", "handleUsePageAspectRatioChanged", "enabled", "handleRedactionPreviewChanged", "", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "providers", "handleDrawableProvidersChanged", "(Ljava/util/List;)V", "handleAvailableWidthChanged", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;", "bitmap", "handleThumbnailRendered", "(ILcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;)V", "", "error", "handleThumbnailRenderFailed", "(ILjava/lang/String;)V", "handleClearDocument", "()V", "recycleBitmaps", "cancelAllRenderJobs", "handleRefresh", "recalculateSelectedPositions", "recalculateLayout", "renderThumbnail", "renderSelectedPages", "", "visiblePages", "handleScrollableVisiblePagesChanged", "(Ljava/util/Set;)V", "renderScrollableThumbnail", "evictDistantScrollableThumbnails", "Lcom/pspdfkit/internal/lm;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;", "state", "Lcom/pspdfkit/configuration/rendering/PageRenderConfiguration;", "renderConfig", "Landroid/graphics/Bitmap;", "renderPageBitmap", "(ILcom/pspdfkit/internal/lm;Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;Lcom/pspdfkit/configuration/rendering/PageRenderConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pageCount", "firstPageSingle", "Lkotlin/Pair;", "calculateDoublePageIndices", "(IIZ)Lkotlin/Pair;", "Landroid/graphics/Paint;", "strokePaint", "addBorderToBitmap", "(Landroid/graphics/Bitmap;Landroid/graphics/Paint;)Landroid/graphics/Bitmap;", "Lcom/pspdfkit/internal/p40;", "createThemeConfigFromTheme", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarTheme;)Lcom/pspdfkit/internal/p40;", "unregisterDrawableProviders", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;", "event", "onEvent", "(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;)V", "dispose", "drawableProvider", "onDrawablesChanged", "(Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;)V", "(Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;I)V", "Landroid/content/Context;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect;", "_effects", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlow;", "effects", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffects", "()Lkotlinx/coroutines/flow/SharedFlow;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/Job;", "renderJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "scrollableRenderJobs", "scrollableVisiblePages", "Ljava/util/Set;", "selectedPageRenderJob", "Lkotlinx/coroutines/Job;", "pageUpdateDebounceJob", "Lcom/pspdfkit/internal/q40;", "staticThumbnailLayout", "Lcom/pspdfkit/internal/q40;", "thumbnailStrokePaint", "Landroid/graphics/Paint;", "gotoPageCallQueried", "Z", "gotoPageCalledQueriedTargetIndex", "I", "", "dirtyPagesSet", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ThumbnailBarStateManager implements PdfDrawableProvider.DrawableProviderObserver {
    private static final String LOG_TAG = "ThumbnailBarStateMgr";
    private static final int SCROLLABLE_EVICTION_BUFFER = 20;
    private static final long SELECTED_PAGE_RENDER_DELAY_MS = 200;
    private static final long THUMBNAIL_RENDERING_DEBOUNCE_MS = 100;
    private final MutableSharedFlow<ThumbnailBarEffect> _effects;
    private final MutableStateFlow<ThumbnailBarUiState> _uiState;
    private final Context context;
    private final Set<Integer> dirtyPagesSet;
    private final SharedFlow<ThumbnailBarEffect> effects;
    private boolean gotoPageCallQueried;
    private int gotoPageCalledQueriedTargetIndex;
    private Job pageUpdateDebounceJob;
    private final ConcurrentHashMap<Integer, Job> renderJobs;
    private final CoroutineScope scope;
    private final ConcurrentHashMap<Integer, Job> scrollableRenderJobs;
    private Set<Integer> scrollableVisiblePages;
    private Job selectedPageRenderJob;
    private q40 staticThumbnailLayout;
    private final Paint thumbnailStrokePaint;
    private final StateFlow<ThumbnailBarUiState> uiState;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager$handlePageChanged$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager$handlePageChanged$3", f = "ThumbnailBarStateManager.kt", i = {}, l = {476}, m = "invokeSuspend", n = {}, nl = {477}, s = {}, v = 2)
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ThumbnailBarStateManager.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(ThumbnailBarStateManager.SELECTED_PAGE_RENDER_DELAY_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ThumbnailBarStateManager.this.renderSelectedPages();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager$handlePageUpdated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager$handlePageUpdated$1", f = "ThumbnailBarStateManager.kt", i = {}, l = {487}, m = "invokeSuspend", n = {}, nl = {488}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ThumbnailBarStateManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            ThumbnailBarUiState thumbnailBarUiState;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Set set = CollectionsKt.toSet(ThumbnailBarStateManager.this.dirtyPagesSet);
            ThumbnailBarStateManager.this.dirtyPagesSet.clear();
            MutableStateFlow mutableStateFlow = ThumbnailBarStateManager.this._uiState;
            do {
                value = mutableStateFlow.getValue();
                thumbnailBarUiState = (ThumbnailBarUiState) value;
            } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, null, null, null, null, null, false, false, false, null, false, null, 0, false, null, SetsKt.plus((Set) thumbnailBarUiState.getDirtyPages(), (Iterable) set), null, false, 0, 1966079, null)));
            boolean zIsScrollableMode = ((ThumbnailBarUiState) ThumbnailBarStateManager.this._uiState.getValue()).isScrollableMode();
            ThumbnailBarStateManager thumbnailBarStateManager = ThumbnailBarStateManager.this;
            if (zIsScrollableMode) {
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : set) {
                    if (thumbnailBarStateManager.scrollableVisiblePages.contains(Boxing.boxInt(((Number) obj2).intValue()))) {
                        arrayList.add(obj2);
                    }
                }
                ThumbnailBarStateManager thumbnailBarStateManager2 = ThumbnailBarStateManager.this;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj3 = arrayList.get(i2);
                    i2++;
                    thumbnailBarStateManager2.renderScrollableThumbnail(((Number) obj3).intValue());
                }
            } else {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    thumbnailBarStateManager.renderThumbnail(((Number) it.next()).intValue());
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager$renderPageBitmap$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager", f = "ThumbnailBarStateManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {1230, 1246}, m = "renderPageBitmap", n = {"document", "state", "renderConfig", "pageSize", "bitmap", "pageIndex", "ar", "renderH", "renderW", "document", "state", "renderConfig", "pageSize", "bitmap", "drawables", "options", "pageIndex", "ar", "renderH", "renderW"}, nl = {1232, 1247}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "F$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "F$0", "I$1", "I$2"}, v = 2)
    public static final class C18611 extends ContinuationImpl {
        float F$0;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C18611(Continuation<? super C18611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ThumbnailBarStateManager.this.renderPageBitmap(0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager$renderScrollableThumbnail$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager$renderScrollableThumbnail$1", f = "ThumbnailBarStateManager.kt", i = {}, l = {1160}, m = "invokeSuspend", n = {}, nl = {1163}, s = {}, v = 2)
    public static final class C18621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ lm $document;
        final /* synthetic */ int $pageIndex;
        final /* synthetic */ PageRenderConfiguration $renderConfig;
        final /* synthetic */ ThumbnailBarUiState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18621(int i, lm lmVar, ThumbnailBarUiState thumbnailBarUiState, PageRenderConfiguration pageRenderConfiguration, Continuation<? super C18621> continuation) {
            super(2, continuation);
            this.$pageIndex = i;
            this.$document = lmVar;
            this.$state = thumbnailBarUiState;
            this.$renderConfig = pageRenderConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ThumbnailBarStateManager.this.new C18621(this.$pageIndex, this.$document, this.$state, this.$renderConfig, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objRenderPageBitmap;
            Object value;
            ThumbnailBarUiState thumbnailBarUiState;
            ThumbnailBitmap thumbnailBitmap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ThumbnailBarStateManager thumbnailBarStateManager = ThumbnailBarStateManager.this;
                        int i2 = this.$pageIndex;
                        lm lmVar = this.$document;
                        ThumbnailBarUiState thumbnailBarUiState2 = this.$state;
                        PageRenderConfiguration pageRenderConfiguration = this.$renderConfig;
                        this.label = 1;
                        objRenderPageBitmap = thumbnailBarStateManager.renderPageBitmap(i2, lmVar, thumbnailBarUiState2, pageRenderConfiguration, this);
                        if (objRenderPageBitmap == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objRenderPageBitmap = obj;
                    }
                    ThumbnailBitmap thumbnailBitmap2 = new ThumbnailBitmap((Bitmap) objRenderPageBitmap);
                    MutableStateFlow mutableStateFlow = ThumbnailBarStateManager.this._uiState;
                    int i3 = this.$pageIndex;
                    do {
                        value = mutableStateFlow.getValue();
                        thumbnailBarUiState = (ThumbnailBarUiState) value;
                        thumbnailBitmap = thumbnailBarUiState.getScrollableThumbnails().get(Boxing.boxInt(i3));
                    } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, null, null, null, null, null, false, false, false, null, false, null, 0, false, null, SetsKt.minus(thumbnailBarUiState.getDirtyPages(), Boxing.boxInt(i3)), MapsKt.plus(thumbnailBarUiState.getScrollableThumbnails(), TuplesKt.to(Boxing.boxInt(i3), thumbnailBitmap2)), false, 0, 1703935, null)));
                    if (thumbnailBitmap != null && thumbnailBitmap != thumbnailBitmap2) {
                        thumbnailBitmap.release();
                    }
                    ThumbnailBarStateManager.this.scrollableRenderJobs.remove(Boxing.boxInt(this.$pageIndex));
                } catch (CancellationException e) {
                    throw e;
                } catch (Exception e2) {
                    PdfLog.e(ThumbnailBarStateManager.LOG_TAG, "Failed to render scrollable thumbnail for page " + this.$pageIndex + ": " + e2.getMessage(), new Object[0]);
                    ThumbnailBarStateManager.this.scrollableRenderJobs.remove(Boxing.boxInt(this.$pageIndex));
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ThumbnailBarStateManager.this.scrollableRenderJobs.remove(Boxing.boxInt(this.$pageIndex));
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager$renderThumbnail$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager$renderThumbnail$2", f = "ThumbnailBarStateManager.kt", i = {}, l = {1091}, m = "invokeSuspend", n = {}, nl = {1092}, s = {}, v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ lm $document;
        final /* synthetic */ int $pageIndex;
        final /* synthetic */ PageRenderConfiguration $renderConfig;
        final /* synthetic */ ThumbnailBarUiState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(int i, lm lmVar, ThumbnailBarUiState thumbnailBarUiState, PageRenderConfiguration pageRenderConfiguration, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$pageIndex = i;
            this.$document = lmVar;
            this.$state = thumbnailBarUiState;
            this.$renderConfig = pageRenderConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ThumbnailBarStateManager.this.new AnonymousClass2(this.$pageIndex, this.$document, this.$state, this.$renderConfig, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x006d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            AnonymousClass2 anonymousClass2;
            Exception exc;
            String message;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        ThumbnailBarStateManager thumbnailBarStateManager = ThumbnailBarStateManager.this;
                        int i2 = this.$pageIndex;
                        lm lmVar = this.$document;
                        ThumbnailBarUiState thumbnailBarUiState = this.$state;
                        PageRenderConfiguration pageRenderConfiguration = this.$renderConfig;
                        this.label = 1;
                        anonymousClass2 = this;
                        try {
                            obj = thumbnailBarStateManager.renderPageBitmap(i2, lmVar, thumbnailBarUiState, pageRenderConfiguration, anonymousClass2);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } catch (CancellationException e) {
                            e = e;
                            throw e;
                        } catch (Exception e2) {
                            e = e2;
                            exc = e;
                            ThumbnailBarStateManager thumbnailBarStateManager2 = ThumbnailBarStateManager.this;
                            int i3 = anonymousClass2.$pageIndex;
                            message = exc.getMessage();
                            if (message == null) {
                                message = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
                            }
                            thumbnailBarStateManager2.handleThumbnailRenderFailed(i3, message);
                        }
                    } catch (CancellationException e3) {
                        e = e3;
                        throw e;
                    } catch (Exception e4) {
                        e = e4;
                        anonymousClass2 = this;
                        exc = e;
                        ThumbnailBarStateManager thumbnailBarStateManager3 = ThumbnailBarStateManager.this;
                        int i4 = anonymousClass2.$pageIndex;
                        message = exc.getMessage();
                        if (message == null) {
                            message = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
                        }
                        thumbnailBarStateManager3.handleThumbnailRenderFailed(i4, message);
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        ThumbnailBarStateManager.this.renderJobs.remove(Boxing.boxInt(this.$pageIndex));
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    try {
                        ResultKt.throwOnFailure(obj);
                        anonymousClass2 = this;
                    } catch (CancellationException e5) {
                        throw e5;
                    } catch (Exception e6) {
                        exc = e6;
                        anonymousClass2 = this;
                        ThumbnailBarStateManager thumbnailBarStateManager4 = ThumbnailBarStateManager.this;
                        int i5 = anonymousClass2.$pageIndex;
                        message = exc.getMessage();
                        if (message == null) {
                            message = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
                        }
                        thumbnailBarStateManager4.handleThumbnailRenderFailed(i5, message);
                    } catch (Throwable th3) {
                        th = th3;
                        ThumbnailBarStateManager.this.renderJobs.remove(Boxing.boxInt(this.$pageIndex));
                        throw th;
                    }
                }
                Bitmap bitmap = (Bitmap) obj;
                ThumbnailBarStateManager thumbnailBarStateManager5 = ThumbnailBarStateManager.this;
                thumbnailBarStateManager5.addBorderToBitmap(bitmap, thumbnailBarStateManager5.thumbnailStrokePaint);
                ThumbnailBarStateManager.this.handleThumbnailRendered(anonymousClass2.$pageIndex, new ThumbnailBitmap(bitmap));
                ThumbnailBarStateManager.this.renderJobs.remove(Boxing.boxInt(anonymousClass2.$pageIndex));
                return Unit.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public ThumbnailBarStateManager(Context context) {
        context.getClass();
        this.context = context;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        MutableStateFlow<ThumbnailBarUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ThumbnailBarUiState(null, null, null, null, null, null, null, j60.a(context), false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097023, null));
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<ThumbnailBarEffect> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 64, null, 5, null);
        this._effects = mutableSharedFlowMutableSharedFlow$default;
        this.effects = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        this.renderJobs = new ConcurrentHashMap<>();
        this.scrollableRenderJobs = new ConcurrentHashMap<>();
        this.scrollableVisiblePages = SetsKt.emptySet();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDisplayMetrics().density);
        this.thumbnailStrokePaint = paint;
        this.gotoPageCalledQueriedTargetIndex = -1;
        this.dirtyPagesSet = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap addBorderToBitmap(Bitmap bitmap, Paint strokePaint) {
        new Canvas(bitmap).drawRect(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight(), strokePaint);
        return bitmap;
    }

    private final Pair<Integer, Integer> calculateDoublePageIndices(int pageIndex, int pageCount, boolean firstPageSingle) {
        int i = -1;
        if (pageIndex == 0) {
            if (!firstPageSingle && pageCount > 1) {
                i = 1;
            }
            return TuplesKt.to(0, Integer.valueOf(i));
        }
        if (pageIndex == 1 && !firstPageSingle) {
            return TuplesKt.to(0, Integer.valueOf(pageCount > 1 ? 1 : -1));
        }
        if ((!(pageIndex % 2 == 0)) ^ (!firstPageSingle)) {
            return TuplesKt.to(Integer.valueOf(pageIndex), Integer.valueOf(pageCount - 1 > pageIndex ? pageIndex + 1 : -1));
        }
        return TuplesKt.to(Integer.valueOf(pageIndex - 1), Integer.valueOf(pageIndex));
    }

    private final void cancelAllRenderJobs() {
        Collection<Job> collectionValues = this.renderJobs.values();
        collectionValues.getClass();
        for (Job job : collectionValues) {
            job.getClass();
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.renderJobs.clear();
        Collection<Job> collectionValues2 = this.scrollableRenderJobs.values();
        collectionValues2.getClass();
        for (Job job2 : collectionValues2) {
            job2.getClass();
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.scrollableRenderJobs.clear();
        Job job3 = this.selectedPageRenderJob;
        if (job3 != null) {
            Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
        }
        Job job4 = this.pageUpdateDebounceJob;
        if (job4 != null) {
            Job.DefaultImpls.cancel$default(job4, (CancellationException) null, 1, (Object) null);
        }
    }

    private final p40 createThemeConfigFromTheme(ThumbnailBarTheme theme) {
        p40 p40Var = new p40(this.context);
        theme.getBackgroundColor();
        theme.getBorderColor();
        theme.getThumbnailBorderColor();
        theme.getThumbnailSelectedBorderColor();
        p40Var.a = theme.getThumbnailWidth();
        p40Var.b = theme.getThumbnailHeight();
        p40Var.c = theme.getUsePageAspectRatio();
        return p40Var;
    }

    private final void emitNavigateToPage(int pageIndex) {
        this._effects.tryEmit(new ThumbnailBarEffect.NavigateToPage(pageIndex));
    }

    private final void evictDistantScrollableThumbnails(Set<Integer> visiblePages) {
        ThumbnailBarUiState value;
        ThumbnailBarUiState thumbnailBarUiState;
        Map<Integer, ThumbnailBitmap> scrollableThumbnails;
        ArrayList arrayList;
        if (visiblePages.isEmpty()) {
            return;
        }
        IntRange intRange = new IntRange(((Number) CollectionsKt.minOrThrow((Iterable<Double>) visiblePages)).intValue() - 20, ((Number) CollectionsKt.maxOrThrow((Iterable<Double>) visiblePages)).intValue() + 20);
        ArrayList arrayList2 = new ArrayList();
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            thumbnailBarUiState = value;
            scrollableThumbnails = thumbnailBarUiState.getScrollableThumbnails();
            Set<Integer> setKeySet = scrollableThumbnails.keySet();
            arrayList = new ArrayList();
            for (Object obj : setKeySet) {
                int iIntValue = ((Number) obj).intValue();
                int first = intRange.getFirst();
                if (iIntValue > intRange.getLast() || first > iIntValue) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                ThumbnailBitmap thumbnailBitmap = scrollableThumbnails.get(Integer.valueOf(((Number) obj2).intValue()));
                if (thumbnailBitmap != null) {
                    arrayList2.add(thumbnailBitmap);
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, null, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, MapsKt.minus((Map) scrollableThumbnails, (Iterable) CollectionsKt.toSet(arrayList)), false, 0, 1835007, null)));
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj3 = arrayList2.get(i2);
            i2++;
            ((ThumbnailBitmap) obj3).release();
        }
    }

    private final void handleAvailableWidthChanged(int width) {
        ThumbnailBarUiState value;
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, null, null, null, null, null, null, null, null, false, false, false, null, false, null, width, false, null, null, null, false, 0, 2080767, null)));
        recalculateLayout();
    }

    private final void handleBackgroundColorChanged(int color) {
        ThumbnailBarUiState value;
        ThumbnailBarUiState thumbnailBarUiState;
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            thumbnailBarUiState = value;
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, null, null, null, null, ThumbnailBarTheme.copy$default(thumbnailBarUiState.getTheme(), color, 0, 0, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16777214, null), false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097023, null)));
    }

    private final void handleClearDocument() {
        ThumbnailBarUiState value;
        ThumbnailBarUiState thumbnailBarUiState;
        cancelAllRenderJobs();
        this.staticThumbnailLayout = null;
        this.dirtyPagesSet.clear();
        recycleBitmaps();
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            thumbnailBarUiState = value;
        } while (!mutableStateFlow.compareAndSet(value, new ThumbnailBarUiState(null, null, null, null, null, null, thumbnailBarUiState.getLayoutStyle(), thumbnailBarUiState.getTheme(), false, false, false, null, false, null, thumbnailBarUiState.getAvailableWidth(), false, null, null, null, thumbnailBarUiState.isScrollableMode(), 0, 1556287, null)));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0090  */
    private final void handleDocumentSet(PdfDocument document, PdfConfiguration configuration) {
        boolean z;
        PdfLog.d(LOG_TAG, "handleDocumentSet: document=" + document, new Object[0]);
        lm lmVar = document instanceof lm ? (lm) document : null;
        if (lmVar == null) {
            PdfLog.e(LOG_TAG, "handleDocumentSet: Document is not InternalPdfDocument, returning", new Object[0]);
            return;
        }
        PdfConfiguration pdfConfiguration = configuration;
        PageRenderConfiguration pageRenderConfigurationA = ca.a(pdfConfiguration, document);
        pageRenderConfigurationA.getClass();
        lm lmVar2 = (lm) document;
        boolean z2 = lmVar2.getPageBinding() == PageBinding.RIGHT_EDGE;
        Context context = this.context;
        context.getClass();
        document.getClass();
        if (pdfConfiguration.getScrollMode() != PageScrollMode.PER_PAGE) {
            z = false;
        } else {
            boolean z3 = pdfConfiguration.getLayoutMode() == PageLayoutMode.DOUBLE;
            boolean z4 = context.getResources().getConfiguration().orientation == 2 && uc.a(context, 540) && pdfConfiguration.getLayoutMode() == PageLayoutMode.AUTO;
            if (document.getPageCount() <= 1 || !(z3 || z4)) {
                z = false;
            } else {
                z = true;
            }
        }
        boolean zIsFirstPageAlwaysSingle = pdfConfiguration.isFirstPageAlwaysSingle();
        List list = CollectionsKt.toList(pdfConfiguration.getExcludedAnnotationTypes());
        boolean zIsScrollableMode = this._uiState.getValue().isScrollableMode();
        ThumbnailBarTheme theme = this._uiState.getValue().getTheme();
        if (zIsScrollableMode && theme.getUsePageAspectRatio()) {
            int i = lmVar2.s;
            float fMin = Float.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                Size pageSize = lmVar.getPageSize(i2);
                fMin = Math.min(fMin, pageSize.width / pageSize.height);
            }
            theme = ThumbnailBarTheme.copy$default(theme, 0, 0, 0, 0, RangesKt.coerceAtLeast((int) (theme.getThumbnailHeight() * fMin), 1), 0, false, 0, 0, 0, 0, 0, 0, 0.0f, 0, theme.getThumbnailHeightDp() * fMin, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16744431, null);
        }
        ThumbnailBarTheme thumbnailBarTheme = theme;
        if (zIsScrollableMode) {
            Collection<Job> collectionValues = this.scrollableRenderJobs.values();
            collectionValues.getClass();
            for (Job job : CollectionsKt.toList(collectionValues)) {
                job.getClass();
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.scrollableRenderJobs.clear();
            this.scrollableVisiblePages = SetsKt.emptySet();
            int iCoerceAtMost = RangesKt.coerceAtMost(this._uiState.getValue().getScrollableSelectedPageIndex(), lmVar2.s - 1);
            MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
            while (true) {
                ThumbnailBarUiState value = mutableStateFlow.getValue();
                if (mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, lmVar2, pdfConfiguration, pageRenderConfigurationA, null, null, null, null, thumbnailBarTheme, z, zIsFirstPageAlwaysSingle, z2, list, false, null, 0, false, null, null, MapsKt.emptyMap(), false, iCoerceAtMost, 749688, null))) {
                    return;
                } else {
                    pdfConfiguration = configuration;
                }
            }
        } else {
            PdfLog.d(LOG_TAG, "handleDocumentSet: Creating StaticThumbnailLayout", new Object[0]);
            this.staticThumbnailLayout = new q40(lmVar);
            ThumbnailItem selectedPageThumbnail = this._uiState.getValue().getSelectedPageThumbnail();
            int iCoerceAtMost2 = RangesKt.coerceAtMost(selectedPageThumbnail != null ? selectedPageThumbnail.getPageIndex() : 0, lmVar2.s - 1);
            int i3 = (!z || zIsFirstPageAlwaysSingle || lmVar2.s <= 1) ? -1 : 1;
            Size size = new Size(100.0f, 140.0f);
            ThumbnailItem thumbnailItem = new ThumbnailItem(iCoerceAtMost2, new p60(iCoerceAtMost2, 0, size), null, true, false, null, null, 116, null);
            ThumbnailItem thumbnailItem2 = i3 != -1 ? new ThumbnailItem(i3, new p60(i3, 0, size), null, true, false, null, null, 116, null) : null;
            PdfLog.d(LOG_TAG, "handleDocumentSet: Updating state with document", new Object[0]);
            MutableStateFlow<ThumbnailBarUiState> mutableStateFlow2 = this._uiState;
            while (true) {
                ThumbnailBarUiState value2 = mutableStateFlow2.getValue();
                ThumbnailItem thumbnailItem3 = thumbnailItem;
                if (mutableStateFlow2.compareAndSet(value2, ThumbnailBarUiState.copy$default(value2, lmVar2, configuration, pageRenderConfigurationA, CollectionsKt.emptyList(), thumbnailItem3, thumbnailItem2, null, thumbnailBarTheme, z, zIsFirstPageAlwaysSingle, z2, list, false, null, 0, true, null, null, null, false, 0, 2060352, null))) {
                    PdfLog.d(LOG_TAG, "handleDocumentSet: State updated, document is now: " + this._uiState.getValue().getDocument(), new Object[0]);
                    PdfLog.d(LOG_TAG, "handleDocumentSet: Calling recalculateLayout", new Object[0]);
                    recalculateLayout();
                    PdfLog.d(LOG_TAG, "handleDocumentSet: Done", new Object[0]);
                    return;
                }
                thumbnailItem = thumbnailItem3;
            }
        }
    }

    private final void handleDrawableProvidersChanged(List<? extends PdfDrawableProvider> providers) {
        ThumbnailBarUiState value;
        ThumbnailBarUiState value2;
        ThumbnailBarUiState thumbnailBarUiState;
        unregisterDrawableProviders();
        Iterator<T> it = providers.iterator();
        while (it.hasNext()) {
            ((PdfDrawableProvider) it.next()).registerDrawableProviderObserver(this);
        }
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, null, null, null, null, null, null, null, null, false, false, false, null, false, providers, 0, false, null, null, null, false, 0, 2088959, null)));
        if (!this._uiState.getValue().isScrollableMode()) {
            handleRefresh();
            return;
        }
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow2 = this._uiState;
        do {
            value2 = mutableStateFlow2.getValue();
            thumbnailBarUiState = value2;
        } while (!mutableStateFlow2.compareAndSet(value2, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, null, null, null, null, null, false, false, false, null, false, null, 0, false, null, SetsKt.plus((Set) thumbnailBarUiState.getDirtyPages(), (Iterable) this.scrollableVisiblePages), null, false, 0, 1966079, null)));
        Iterator<T> it2 = this.scrollableVisiblePages.iterator();
        while (it2.hasNext()) {
            renderScrollableThumbnail(((Number) it2.next()).intValue());
        }
    }

    private final void handleLayoutStyleChanged(LayoutStyle style) {
        ThumbnailBarUiState value;
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, null, null, null, null, null, null, style, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097087, null)));
        if (this._uiState.getValue().isScrollableMode()) {
            return;
        }
        handleRefresh();
    }

    private final void handlePageChanged(int pageIndex) {
        Object next;
        ThumbnailItem thumbnailItem;
        ThumbnailBarUiState value;
        Object next2;
        int iIntValue = pageIndex;
        ThumbnailBarUiState value2 = this._uiState.getValue();
        PdfDocument document = value2.getDocument();
        if (document == null) {
            return;
        }
        if (this.gotoPageCallQueried) {
            if (this.gotoPageCalledQueriedTargetIndex == iIntValue) {
                this.gotoPageCallQueried = false;
                this.gotoPageCalledQueriedTargetIndex = -1;
                return;
            }
            return;
        }
        if (!value2.isScrollableMode()) {
            if (this.staticThumbnailLayout == null) {
                return;
            }
            Pair<Integer, Integer> pairCalculateDoublePageIndices = value2.isDoublePageMode() ? calculateDoublePageIndices(iIntValue, document.getPageCount(), value2.isFirstPageSingle()) : TuplesKt.to(Integer.valueOf(iIntValue), -1);
            int iIntValue2 = pairCalculateDoublePageIndices.component1().intValue();
            int iIntValue3 = pairCalculateDoublePageIndices.component2().intValue();
            PdfLog.d(LOG_TAG, "handlePageChanged: Updating selected page to " + iIntValue2 + ", sibling=" + iIntValue3, new Object[0]);
            Size size = new Size(100.0f, 140.0f);
            p60 p60Var = new p60(iIntValue2, 0, size);
            Iterator<T> it = value2.getThumbnails().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((ThumbnailItem) next).getPageIndex() != iIntValue2);
            ThumbnailItem thumbnailItem2 = (ThumbnailItem) next;
            ThumbnailItem thumbnailItem3 = new ThumbnailItem(iIntValue2, p60Var, thumbnailItem2 != null ? thumbnailItem2.getBitmap() : null, true, false, null, null, 112, null);
            if (iIntValue3 != -1) {
                p60 p60Var2 = new p60(iIntValue3, 0, size);
                Iterator<T> it2 = value2.getThumbnails().iterator();
                do {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                } while (((ThumbnailItem) next2).getPageIndex() != iIntValue3);
                ThumbnailItem thumbnailItem4 = (ThumbnailItem) next2;
                thumbnailItem = new ThumbnailItem(iIntValue3, p60Var2, thumbnailItem4 != null ? thumbnailItem4.getBitmap() : null, true, false, null, null, 112, null);
            } else {
                thumbnailItem = null;
            }
            MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, null, null, null, null, thumbnailItem3, thumbnailItem, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097103, null)));
            recalculateSelectedPositions();
            Job job = this.selectedPageRenderJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.selectedPageRenderJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass3(null), 3, null);
            return;
        }
        if (value2.isDoublePageMode()) {
            iIntValue = calculateDoublePageIndices(iIntValue, document.getPageCount(), value2.isFirstPageSingle()).getFirst().intValue();
        }
        int i = iIntValue;
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow2 = this._uiState;
        while (true) {
            ThumbnailBarUiState value3 = mutableStateFlow2.getValue();
            int i2 = i;
            if (mutableStateFlow2.compareAndSet(value3, ThumbnailBarUiState.copy$default(value3, null, null, null, null, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, i, 1048575, null))) {
                this._effects.tryEmit(new ThumbnailBarEffect.ScrollToPage(i2));
                return;
            }
            i = i2;
        }
    }

    private final void handlePageUpdated(int pageIndex) {
        this.dirtyPagesSet.add(Integer.valueOf(pageIndex));
        Job job = this.pageUpdateDebounceJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.pageUpdateDebounceJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void handleRedactionPreviewChanged(boolean enabled) {
        ThumbnailBarUiState value;
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, null, null, null, null, null, null, null, null, false, false, false, null, enabled, null, 0, false, null, null, null, false, 0, 2093055, null)));
    }

    private final void handleRefresh() {
        cancelAllRenderJobs();
        recalculateLayout();
    }

    private final void handleScrollableModeChanged(boolean isScrollable) {
        ThumbnailBarUiState value;
        ThumbnailBarUiState value2;
        if (isScrollable || !this._uiState.getValue().isScrollableMode()) {
            MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, null, null, null, null, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, null, isScrollable, 0, 1572863, null)));
            return;
        }
        Collection<Job> collectionValues = this.scrollableRenderJobs.values();
        collectionValues.getClass();
        for (Job job : CollectionsKt.toList(collectionValues)) {
            job.getClass();
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.scrollableRenderJobs.clear();
        this.scrollableVisiblePages = SetsKt.emptySet();
        Collection<ThumbnailBitmap> collectionValues2 = this._uiState.getValue().getScrollableThumbnails().values();
        ThumbnailBarTheme thumbnailBarThemeA = j60.a(this.context);
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow2 = this._uiState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, ThumbnailBarUiState.copy$default(value2, null, null, null, null, null, null, null, thumbnailBarThemeA, false, false, false, null, false, null, 0, false, null, null, MapsKt.emptyMap(), false, 0, 1310591, null)));
        Iterator<T> it = collectionValues2.iterator();
        while (it.hasNext()) {
            ((ThumbnailBitmap) it.next()).release();
        }
    }

    private final void handleScrollableVisiblePagesChanged(Set<Integer> visiblePages) {
        ThumbnailBarUiState value = this._uiState.getValue();
        if (value.getDocument() == null || !value.isScrollableMode()) {
            return;
        }
        Set<Integer> set = this.scrollableVisiblePages;
        this.scrollableVisiblePages = visiblePages;
        Iterator it = SetsKt.minus((Set) set, (Iterable) visiblePages).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            Job job = this.scrollableRenderJobs.get(Integer.valueOf(iIntValue));
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.scrollableRenderJobs.remove(Integer.valueOf(iIntValue));
        }
        Iterator it2 = SetsKt.minus((Set) visiblePages, (Iterable) set).iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Number) it2.next()).intValue();
            if (value.getScrollableThumbnails().get(Integer.valueOf(iIntValue2)) == null || value.getDirtyPages().contains(Integer.valueOf(iIntValue2))) {
                renderScrollableThumbnail(iIntValue2);
            }
        }
        evictDistantScrollableThumbnails(visiblePages);
    }

    private final void handleThemeChanged(ThumbnailBarTheme theme) {
        ThumbnailBarUiState value;
        this.thumbnailStrokePaint.setColor(theme.getThumbnailBorderColor());
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, null, null, null, null, null, null, null, theme, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097023, null)));
        handleRefresh();
    }

    private final void handleThumbnailBorderColorChanged(int color) {
        int i = color;
        this.thumbnailStrokePaint.setColor(i);
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        while (true) {
            ThumbnailBarUiState value = mutableStateFlow.getValue();
            ThumbnailBarUiState thumbnailBarUiState = value;
            if (mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, null, null, null, null, ThumbnailBarTheme.copy$default(thumbnailBarUiState.getTheme(), 0, 0, i, 0, 0, 0, false, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16777211, null), false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097023, null))) {
                handleRefresh();
                return;
            }
            i = color;
        }
    }

    private final void handleThumbnailClicked(int pageIndex) {
        int i = pageIndex;
        ThumbnailBarUiState value = this._uiState.getValue();
        if (value.getDocument() == null) {
            return;
        }
        if (value.isDoublePageMode() && !mn.a(i, value.isFirstPageSingle(), false) && i > 0) {
            i--;
        }
        boolean z = true;
        if (!value.isScrollableMode()) {
            int i2 = i;
            this.gotoPageCallQueried = true;
            this.gotoPageCalledQueriedTargetIndex = i2;
            handlePageChanged(i2);
            emitNavigateToPage(i2);
            return;
        }
        if (i == value.getScrollableSelectedPageIndex() || this.gotoPageCalledQueriedTargetIndex == i) {
            return;
        }
        this.gotoPageCalledQueriedTargetIndex = i;
        this.gotoPageCallQueried = false;
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        while (true) {
            ThumbnailBarUiState value2 = mutableStateFlow.getValue();
            boolean z2 = z;
            int i3 = i;
            if (mutableStateFlow.compareAndSet(value2, ThumbnailBarUiState.copy$default(value2, null, null, null, null, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, i3, 1048575, null))) {
                this.gotoPageCallQueried = z2;
                emitNavigateToPage(i3);
                return;
            } else {
                i = i3;
                z = z2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleThumbnailRenderFailed(int pageIndex, String error) {
        ThumbnailBarUiState value;
        ThumbnailBarUiState thumbnailBarUiState;
        ArrayList arrayList;
        PdfLog.e(LOG_TAG, "Failed to render thumbnail for page " + pageIndex + ": " + error, new Object[0]);
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            thumbnailBarUiState = value;
            List<ThumbnailItem> thumbnails = thumbnailBarUiState.getThumbnails();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(thumbnails, 10));
            for (ThumbnailItem thumbnailItemCopy$default : thumbnails) {
                if (thumbnailItemCopy$default.getPageIndex() == pageIndex) {
                    thumbnailItemCopy$default = ThumbnailItem.copy$default(thumbnailItemCopy$default, 0, null, null, false, false, null, null, 111, null);
                }
                arrayList.add(thumbnailItemCopy$default);
            }
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, arrayList, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097143, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleThumbnailRendered(int pageIndex, ThumbnailBitmap bitmap) {
        ThumbnailBarUiState value;
        ThumbnailBarUiState thumbnailBarUiState;
        ArrayList arrayList;
        ThumbnailItem thumbnailItem;
        ThumbnailItem selectedSiblingThumbnail;
        Set<ThumbnailBitmap> setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            thumbnailBarUiState = value;
            List<ThumbnailItem> thumbnails = thumbnailBarUiState.getThumbnails();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(thumbnails, 10));
            for (ThumbnailItem thumbnailItemCopy$default : thumbnails) {
                if (thumbnailItemCopy$default.getPageIndex() == pageIndex) {
                    ThumbnailBitmap bitmap2 = thumbnailItemCopy$default.getBitmap();
                    if (bitmap2 != null) {
                        setNewSetFromMap.add(bitmap2);
                    }
                    thumbnailItemCopy$default = ThumbnailItem.copy$default(thumbnailItemCopy$default, 0, null, bitmap, false, false, null, null, 107, null);
                }
                arrayList.add(thumbnailItemCopy$default);
            }
            ThumbnailItem selectedPageThumbnail = thumbnailBarUiState.getSelectedPageThumbnail();
            ThumbnailItem thumbnailItemCopy$default2 = null;
            if (selectedPageThumbnail != null) {
                if (selectedPageThumbnail.getPageIndex() == pageIndex) {
                    ThumbnailBitmap bitmap3 = selectedPageThumbnail.getBitmap();
                    if (bitmap3 != null) {
                        setNewSetFromMap.add(bitmap3);
                    }
                    selectedPageThumbnail = ThumbnailItem.copy$default(selectedPageThumbnail, 0, null, bitmap, false, false, null, null, 107, null);
                }
                thumbnailItem = selectedPageThumbnail;
            } else {
                thumbnailItem = null;
            }
            selectedSiblingThumbnail = thumbnailBarUiState.getSelectedSiblingThumbnail();
            if (selectedSiblingThumbnail == null) {
                selectedSiblingThumbnail = thumbnailItemCopy$default2;
            } else if (selectedSiblingThumbnail.getPageIndex() == pageIndex) {
                ThumbnailBitmap bitmap4 = selectedSiblingThumbnail.getBitmap();
                if (bitmap4 != null) {
                    setNewSetFromMap.add(bitmap4);
                }
                thumbnailItemCopy$default2 = ThumbnailItem.copy$default(selectedSiblingThumbnail, 0, null, bitmap, false, false, null, null, 107, null);
                selectedSiblingThumbnail = thumbnailItemCopy$default2;
            }
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, arrayList, thumbnailItem, selectedSiblingThumbnail, null, null, false, false, false, null, false, null, 0, false, null, SetsKt.minus(thumbnailBarUiState.getDirtyPages(), Integer.valueOf(pageIndex)), null, false, 0, 1966023, null)));
        setNewSetFromMap.getClass();
        for (ThumbnailBitmap thumbnailBitmap : setNewSetFromMap) {
            if (thumbnailBitmap != bitmap) {
                thumbnailBitmap.release();
            }
        }
    }

    private final void handleThumbnailScrolled(int touchX, int touchY) {
        q40 q40Var;
        ThumbnailBarUiState value = this._uiState.getValue();
        PdfDocument document = value.getDocument();
        if (document == null || (q40Var = this.staticThumbnailLayout) == null || q40Var.i.isEmpty()) {
            return;
        }
        ThumbnailBarTheme theme = value.getTheme();
        if (touchY >= 0) {
            if (touchY <= theme.getThumbnailHeight() + (theme.getContentPaddingPx() * 2)) {
                p60 p60Var = (p60) CollectionsKt.last((List) q40Var.i);
                int i = (int) (p60Var.b + p60Var.c.width);
                int contentPaddingPx = value.getLayoutStyle() == LayoutStyle.FLOATING ? theme.getContentPaddingPx() : (value.getAvailableWidth() - i) / 2;
                int pageCount = document.getPageCount();
                int iCoerceAtMost = RangesKt.coerceAtMost((int) (RangesKt.coerceAtLeast(touchX - contentPaddingPx, 0) / (i / pageCount)), pageCount - 1);
                if (value.isRTL()) {
                    iCoerceAtMost = (document.getPageCount() - iCoerceAtMost) - 1;
                }
                if (value.isDoublePageMode() && !mn.a(iCoerceAtMost, value.isFirstPageSingle(), false) && iCoerceAtMost > 0) {
                    iCoerceAtMost--;
                }
                ThumbnailItem selectedPageThumbnail = value.getSelectedPageThumbnail();
                if (iCoerceAtMost == (selectedPageThumbnail != null ? selectedPageThumbnail.getPageIndex() : -1) || this.gotoPageCalledQueriedTargetIndex == iCoerceAtMost) {
                    return;
                }
                this.gotoPageCalledQueriedTargetIndex = iCoerceAtMost;
                this.gotoPageCallQueried = false;
                handlePageChanged(iCoerceAtMost);
                this.gotoPageCallQueried = true;
                emitNavigateToPage(iCoerceAtMost);
            }
        }
    }

    private final void handleThumbnailSizeChanged(int width, int height) {
        ThumbnailBarUiState value;
        ThumbnailBarUiState thumbnailBarUiState;
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            thumbnailBarUiState = value;
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, null, null, null, null, ThumbnailBarTheme.copy$default(thumbnailBarUiState.getTheme(), 0, 0, 0, 0, width, height, false, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16777167, null), false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097023, null)));
        handleRefresh();
    }

    private final void handleUsePageAspectRatioChanged(boolean useAspectRatio) {
        ThumbnailBarUiState value;
        ThumbnailBarUiState thumbnailBarUiState;
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            thumbnailBarUiState = value;
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, null, null, null, null, ThumbnailBarTheme.copy$default(thumbnailBarUiState.getTheme(), 0, 0, 0, 0, 0, 0, useAspectRatio, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16777151, null), false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097023, null)));
        handleRefresh();
    }

    /* JADX WARN: Code duplicated, block: B:230:0x063b  */
    /* JADX WARN: Code duplicated, block: B:288:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:289:0x0206 A[EDGE_INSN: B:289:0x0206->B:77:0x0206 BREAK  A[LOOP:12: B:67:0x01ca->B:78:0x020a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x01be  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:75:0x0202  */
    /* JADX WARN: Code duplicated, block: B:78:0x020a A[LOOP:12: B:67:0x01ca->B:78:0x020a, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v14, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.pspdfkit.ui.thumbnail.ThumbnailItem] */
    /* JADX WARN: Type inference failed for: r9v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v32, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v63 */
    /* JADX WARN: Type inference failed for: r9v64 */
    private final void recalculateLayout() {
        ThumbnailBarUiState thumbnailBarUiState;
        ThumbnailBarTheme thumbnailBarTheme;
        ?? EmptyList;
        boolean z;
        ?? EmptyList2;
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        int iCeil;
        int i3;
        q40 q40Var;
        ThumbnailBarTheme thumbnailBarTheme2;
        int i4;
        ThumbnailBarUiState thumbnailBarUiState2;
        int i5;
        ThumbnailItem thumbnailItemCopy$default;
        ThumbnailBarUiState value;
        q40 q40Var2;
        Float fB;
        Object obj;
        ThumbnailBitmap bitmap;
        Float fB2;
        Object obj2;
        ThumbnailBitmap bitmap2;
        Object obj3;
        Object next;
        ThumbnailItem selectedSiblingThumbnail;
        ThumbnailBarUiState value2 = this._uiState.getValue();
        int i6 = 1;
        PdfLog.d(LOG_TAG, "recalculateLayout: document=" + (value2.getDocument() != null) + ", layout=" + (this.staticThumbnailLayout != null) + ", width=" + value2.getAvailableWidth(), new Object[0]);
        PdfDocument document = value2.getDocument();
        Object objCopy$default = null;
        if ((document instanceof lm ? (lm) document : null) == null) {
            PdfLog.e(LOG_TAG, "recalculateLayout: No document, returning", new Object[0]);
            return;
        }
        q40 q40Var3 = this.staticThumbnailLayout;
        if (q40Var3 == null) {
            PdfLog.e(LOG_TAG, "recalculateLayout: No layout, returning", new Object[0]);
            return;
        }
        ThumbnailBarTheme theme = value2.getTheme();
        if (value2.getAvailableWidth() == 0) {
            PdfLog.d(LOG_TAG, "recalculateLayout: availableWidth is 0, returning", new Object[0]);
            return;
        }
        int availableWidth = value2.getAvailableWidth() - (theme.getContentPaddingPx() * 2);
        PdfLog.d(LOG_TAG, "recalculateLayout: availableWidth=" + value2.getAvailableWidth() + ", contentPaddingPx=" + theme.getContentPaddingPx() + ", availableSpace=" + availableWidth + ", thumbnailWidth=" + theme.getThumbnailWidth() + ", thumbnailHeight=" + theme.getThumbnailHeight() + ", thumbnailPaddingPx=" + theme.getThumbnailPaddingPx(), new Object[0]);
        int thumbnailPaddingPx = theme.getThumbnailPaddingPx();
        boolean zIsDoublePageMode = value2.isDoublePageMode();
        boolean zIsRTL = value2.isRTL();
        boolean zIsFirstPageSingle = value2.isFirstPageSingle();
        p40 p40VarCreateThemeConfigFromTheme = createThemeConfigFromTheme(theme);
        p40VarCreateThemeConfigFromTheme.getClass();
        q40Var3.b = thumbnailPaddingPx;
        q40Var3.c = zIsDoublePageMode;
        q40Var3.d = zIsRTL;
        q40Var3.e = zIsFirstPageSingle;
        q40Var3.f = p40VarCreateThemeConfigFromTheme;
        q40Var3.h.clear();
        if (availableWidth == q40Var3.g) {
            thumbnailBarUiState = value2;
            z = true;
            thumbnailBarTheme = theme;
        } else {
            q40Var3.g = availableWidth;
            boolean z2 = q40Var3.c;
            int i7 = q40Var3.a.s;
            if (z2) {
                int iMin = Math.min(25, i7);
                int iMax = Math.max(1, iMin / 2);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    arrayList.clear();
                    int i8 = q40Var3.a.s;
                    boolean z3 = q40Var3.e;
                    if (iMax == 0 || i8 == 0) {
                        thumbnailBarUiState = value2;
                        thumbnailBarTheme = theme;
                        EmptyList2 = CollectionsKt.emptyList();
                    } else {
                        ?? arrayList3 = new ArrayList(iMax);
                        arrayList3.add(0);
                        if (z3 || i8 <= i6) {
                            i = i6;
                        } else {
                            arrayList3.add(Integer.valueOf(i6));
                            i = 2;
                        }
                        if (iMax < i) {
                            arrayList3 = CollectionsKt.emptyList();
                        } else {
                            int i9 = i8 % 2 == z3 ? i6 : 0;
                            int i10 = i8 - (i9 != 0 ? 2 : i6);
                            int i11 = i6;
                            Object obj4 = arrayList3.get(arrayList3.size() - 1);
                            obj4.getClass();
                            if (i10 <= ((Number) obj4).intValue()) {
                                i2 = iMax - i;
                                if (i2 % 2 == i11) {
                                    i2--;
                                }
                                if (i2 == 0) {
                                    f = (i8 * 2) / (i2 + i);
                                    f2 = 0.0f;
                                    while (true) {
                                        f2 += f;
                                        f3 = f;
                                        thumbnailBarTheme = theme;
                                        iCeil = (int) Math.ceil(f2);
                                        if (iCeil >= i8) {
                                            thumbnailBarUiState = value2;
                                            break;
                                        }
                                        if (arrayList3.contains(Integer.valueOf(iCeil))) {
                                            thumbnailBarUiState = value2;
                                        } else {
                                            i3 = iCeil + 1;
                                            thumbnailBarUiState = value2;
                                            if (!arrayList3.contains(Integer.valueOf(i3))) {
                                                arrayList3.add(Integer.valueOf(iCeil));
                                                arrayList3.add(Integer.valueOf(i3));
                                                i += 2;
                                            }
                                        }
                                        if (i >= iMax) {
                                            break;
                                        }
                                        theme = thumbnailBarTheme;
                                        f = f3;
                                        value2 = thumbnailBarUiState;
                                    }
                                    CollectionsKt.sort(arrayList3);
                                    EmptyList2 = arrayList3;
                                }
                            } else if (iMax >= (i9 != 0 ? 2 : i11) + i) {
                                arrayList3.add(Integer.valueOf(i10));
                                int i12 = i + 1;
                                if (i9 != 0) {
                                    arrayList3.add(Integer.valueOf(i10 + 1));
                                    i += 2;
                                } else {
                                    i = i12;
                                }
                                i2 = iMax - i;
                                if (i2 % 2 == i11) {
                                    i2--;
                                }
                                if (i2 == 0) {
                                    f = (i8 * 2) / (i2 + i);
                                    f2 = 0.0f;
                                    while (true) {
                                        f2 += f;
                                        f3 = f;
                                        thumbnailBarTheme = theme;
                                        iCeil = (int) Math.ceil(f2);
                                        if (iCeil >= i8) {
                                            thumbnailBarUiState = value2;
                                            break;
                                        }
                                        if (arrayList3.contains(Integer.valueOf(iCeil))) {
                                            i3 = iCeil + 1;
                                            thumbnailBarUiState = value2;
                                            if (!arrayList3.contains(Integer.valueOf(i3))) {
                                                arrayList3.add(Integer.valueOf(iCeil));
                                                arrayList3.add(Integer.valueOf(i3));
                                                i += 2;
                                            }
                                        } else {
                                            thumbnailBarUiState = value2;
                                        }
                                        if (i >= iMax) {
                                            break;
                                            break;
                                        } else {
                                            theme = thumbnailBarTheme;
                                            f = f3;
                                            value2 = thumbnailBarUiState;
                                        }
                                    }
                                    CollectionsKt.sort(arrayList3);
                                    EmptyList2 = arrayList3;
                                }
                            }
                        }
                        thumbnailBarUiState = value2;
                        thumbnailBarTheme = theme;
                        EmptyList2 = arrayList3;
                    }
                    ?? AsReversed = EmptyList2;
                    if (q40Var3.d) {
                        AsReversed = CollectionsKt.asReversed(EmptyList2);
                    }
                    boolean z4 = q40Var3.e;
                    Iterator it = AsReversed.iterator();
                    int i13 = 0;
                    while (it.hasNext()) {
                        int iIntValue = ((Number) it.next()).intValue();
                        Size sizeA = q40Var3.a(iIntValue);
                        arrayList.add(new p60(iIntValue, i13, sizeA));
                        i13 += (int) sizeA.width;
                        if (z4) {
                            i13 += q40Var3.b;
                        }
                        z4 = !z4;
                    }
                    if (!z4) {
                        i13 -= q40Var3.b;
                    }
                    if (i13 <= q40Var3.g) {
                        arrayList2.clear();
                        arrayList2.addAll(arrayList);
                        iMax++;
                    } else if (!arrayList2.isEmpty()) {
                        break;
                    } else {
                        iMax--;
                    }
                    if (1 > iMax || iMax > iMin) {
                        break;
                    }
                    theme = thumbnailBarTheme;
                    value2 = thumbnailBarUiState;
                    i6 = 1;
                }
                q40Var3.i.clear();
                q40Var3.i.addAll(arrayList2);
                z = true;
            } else {
                thumbnailBarUiState = value2;
                thumbnailBarTheme = theme;
                int iMin2 = Math.min(25, i7);
                int iMax2 = Math.max(1, iMin2 / 2);
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                do {
                    arrayList4.clear();
                    int i14 = q40Var3.a.s;
                    if (iMax2 == 0 || i14 == 0) {
                        EmptyList = CollectionsKt.emptyList();
                    } else {
                        EmptyList = new ArrayList(iMax2);
                        if (i14 <= iMax2) {
                            for (int i15 = 0; i15 < i14; i15++) {
                                EmptyList.add(Integer.valueOf(i15));
                            }
                        } else if (iMax2 == 1) {
                            EmptyList.add(0);
                        } else {
                            int i16 = i14 - 1;
                            int i17 = iMax2 - 1;
                            float f4 = i16 / i17;
                            for (int i18 = 0; i18 < i17; i18++) {
                                EmptyList.add(Integer.valueOf(Math.max(0, Math.min((int) Math.ceil(i18 * f4), i16))));
                            }
                            if (!EmptyList.contains(Integer.valueOf(i16))) {
                                EmptyList.add(Integer.valueOf(i16));
                            }
                        }
                    }
                    ?? AsReversed2 = EmptyList;
                    if (q40Var3.d) {
                        AsReversed2 = CollectionsKt.asReversed(EmptyList);
                    }
                    Iterator it2 = AsReversed2.iterator();
                    int i19 = 0;
                    while (it2.hasNext()) {
                        int iIntValue2 = ((Number) it2.next()).intValue();
                        Size sizeA2 = q40Var3.a(iIntValue2);
                        arrayList4.add(new p60(iIntValue2, i19, sizeA2));
                        i19 += ((int) sizeA2.width) + q40Var3.b;
                    }
                    if (i19 - q40Var3.b <= q40Var3.g) {
                        arrayList5.clear();
                        arrayList5.addAll(arrayList4);
                        iMax2++;
                    } else {
                        if (!arrayList5.isEmpty()) {
                            z = true;
                            break;
                        }
                        iMax2--;
                    }
                    z = true;
                    if (1 > iMax2) {
                        break;
                    }
                } while (iMax2 <= iMin2);
                q40Var3.i.clear();
                q40Var3.i.addAll(arrayList5);
            }
        }
        ArrayList arrayList6 = q40Var3.i;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
        int size = arrayList6.size();
        int i20 = 0;
        while (i20 < size) {
            Object obj5 = arrayList6.get(i20);
            i20++;
            arrayList7.add(Integer.valueOf(((p60) obj5).a));
        }
        int size2 = arrayList7.size();
        ArrayList arrayList8 = q40Var3.i;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
        int size3 = arrayList8.size();
        int i21 = 0;
        while (i21 < size3) {
            Object obj6 = arrayList8.get(i21);
            i21++;
            arrayList9.add(Integer.valueOf(((p60) obj6).a));
        }
        PdfLog.d(LOG_TAG, "recalculateLayout: Layout calculated " + size2 + " pages: " + arrayList9, new Object[0]);
        ArrayList arrayList10 = q40Var3.i;
        ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
        int size4 = arrayList10.size();
        int i22 = 0;
        while (i22 < size4) {
            Object obj7 = arrayList10.get(i22);
            i22++;
            p60 p60Var = (p60) obj7;
            Iterator it3 = thumbnailBarUiState.getThumbnails().iterator();
            do {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
            } while (((ThumbnailItem) next).getPageIndex() != p60Var.a);
            ThumbnailItem thumbnailItem = (ThumbnailItem) next;
            int i23 = p60Var.a;
            ThumbnailBitmap bitmap3 = thumbnailItem != null ? thumbnailItem.getBitmap() : null;
            ThumbnailItem selectedPageThumbnail = thumbnailBarUiState.getSelectedPageThumbnail();
            arrayList11.add(new ThumbnailItem(i23, p60Var, bitmap3, ((selectedPageThumbnail == null || p60Var.a != selectedPageThumbnail.getPageIndex()) && ((selectedSiblingThumbnail = thumbnailBarUiState.getSelectedSiblingThumbnail()) == null || p60Var.a != selectedSiblingThumbnail.getPageIndex())) ? false : z, thumbnailItem != null ? thumbnailItem.isRendering() : false, null, null, 96, null));
        }
        ThumbnailItem thumbnailItem2 = (ThumbnailItem) CollectionsKt.lastOrNull((List) arrayList11);
        int availableWidth2 = thumbnailBarUiState.getLayoutStyle() == LayoutStyle.FLOATING ? 0 : ((thumbnailBarUiState.getAvailableWidth() - (thumbnailBarTheme.getContentPaddingPx() * 2)) - (thumbnailItem2 != null ? (int) (thumbnailItem2.getPosition().b + thumbnailItem2.getPosition().c.width) : 0)) / 2;
        if (thumbnailBarUiState.getSelectedPageThumbnail() != null) {
            if (thumbnailBarUiState.isDoublePageMode()) {
                thumbnailBarUiState2 = thumbnailBarUiState;
                thumbnailBarTheme2 = thumbnailBarTheme;
                i4 = 0;
                int i24 = availableWidth2;
                fB2 = q60.a(thumbnailBarUiState.getSelectedPageThumbnail().getPageIndex(), ThumbnailBarUiState.copy$default(thumbnailBarUiState2, null, null, null, arrayList11, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097143, null), q40Var3, i24, thumbnailBarTheme2.getContentPaddingPx(), thumbnailBarTheme2.getThumbnailPaddingPx());
                q40Var = q40Var3;
                i5 = i24;
            } else {
                thumbnailBarTheme2 = thumbnailBarTheme;
                i4 = 0;
                thumbnailBarUiState2 = thumbnailBarUiState;
                i5 = availableWidth2;
                q40Var = q40Var3;
                fB2 = q60.b(thumbnailBarUiState2.getSelectedPageThumbnail().getPageIndex(), ThumbnailBarUiState.copy$default(thumbnailBarUiState2, null, null, null, arrayList11, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097143, null), q40Var3, i5, thumbnailBarTheme2.getContentPaddingPx(), thumbnailBarTheme2.getThumbnailPaddingPx());
            }
            float contentPaddingPx = thumbnailBarTheme2.getContentPaddingPx() - thumbnailBarTheme2.getThumbnailPaddingPx();
            int size5 = arrayList11.size();
            int i25 = i4;
            do {
                if (i25 >= size5) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = arrayList11.get(i25);
                    i25++;
                }
            } while (((ThumbnailItem) obj2).getPageIndex() != thumbnailBarUiState2.getSelectedPageThumbnail().getPageIndex());
            ThumbnailItem thumbnailItem3 = (ThumbnailItem) obj2;
            if (thumbnailItem3 == null || (bitmap2 = thumbnailItem3.getBitmap()) == null) {
                bitmap2 = thumbnailBarUiState2.getSelectedPageThumbnail().getBitmap();
            }
            ThumbnailBitmap thumbnailBitmap = bitmap2;
            Size sizeA3 = q40Var.a(thumbnailBarUiState2.getSelectedPageThumbnail().getPageIndex());
            ArrayList arrayList12 = q40Var.i;
            int size6 = arrayList12.size();
            int i26 = i4;
            do {
                if (i26 >= size6) {
                    obj3 = null;
                    break;
                } else {
                    obj3 = arrayList12.get(i26);
                    i26++;
                }
            } while (((p60) obj3).a != thumbnailBarUiState2.getSelectedPageThumbnail().getPageIndex());
            p60 p60Var2 = (p60) obj3;
            thumbnailItemCopy$default = ThumbnailItem.copy$default(thumbnailBarUiState2.getSelectedPageThumbnail(), 0, new p60(thumbnailBarUiState2.getSelectedPageThumbnail().getPageIndex(), p60Var2 != null ? p60Var2.b : thumbnailBarUiState2.getSelectedPageThumbnail().getPosition().b, sizeA3), thumbnailBitmap, false, false, fB2, Float.valueOf(contentPaddingPx), 25, null);
        } else {
            q40Var = q40Var3;
            thumbnailBarTheme2 = thumbnailBarTheme;
            i4 = 0;
            thumbnailBarUiState2 = thumbnailBarUiState;
            i5 = availableWidth2;
            thumbnailItemCopy$default = null;
        }
        if (thumbnailBarUiState2.getSelectedSiblingThumbnail() != null) {
            if (!thumbnailBarUiState2.isDoublePageMode()) {
                q40Var2 = q40Var;
                fB = q60.b(thumbnailBarUiState2.getSelectedSiblingThumbnail().getPageIndex(), ThumbnailBarUiState.copy$default(thumbnailBarUiState2, null, null, null, arrayList11, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097143, null), q40Var2, i5, thumbnailBarTheme2.getContentPaddingPx(), thumbnailBarTheme2.getThumbnailPaddingPx());
            } else if ((thumbnailItemCopy$default != null ? thumbnailItemCopy$default.getAbsolutePositionX() : null) != null) {
                Float absolutePositionX = thumbnailItemCopy$default.getAbsolutePositionX();
                int pageIndex = thumbnailBarUiState2.getSelectedSiblingThumbnail().getPageIndex();
                ThumbnailItem selectedPageThumbnail2 = thumbnailBarUiState2.getSelectedPageThumbnail();
                fB = Float.valueOf(pageIndex > (selectedPageThumbnail2 != null ? selectedPageThumbnail2.getPageIndex() : i4) ? absolutePositionX.floatValue() + thumbnailItemCopy$default.getPosition().c.width : absolutePositionX.floatValue() - q40Var.a(thumbnailBarUiState2.getSelectedSiblingThumbnail().getPageIndex()).width);
                q40Var2 = q40Var;
            } else {
                q40Var2 = q40Var;
                fB = q60.b(thumbnailBarUiState2.getSelectedSiblingThumbnail().getPageIndex(), ThumbnailBarUiState.copy$default(thumbnailBarUiState2, null, null, null, arrayList11, null, null, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097143, null), q40Var2, i5, thumbnailBarTheme2.getContentPaddingPx(), thumbnailBarTheme2.getThumbnailPaddingPx());
            }
            Float f5 = fB;
            float contentPaddingPx2 = thumbnailBarTheme2.getContentPaddingPx() - thumbnailBarTheme2.getThumbnailPaddingPx();
            int size7 = arrayList11.size();
            int i27 = i4;
            do {
                if (i27 >= size7) {
                    obj = null;
                    break;
                } else {
                    obj = arrayList11.get(i27);
                    i27++;
                }
            } while (((ThumbnailItem) obj).getPageIndex() != thumbnailBarUiState2.getSelectedSiblingThumbnail().getPageIndex());
            ThumbnailItem thumbnailItem4 = (ThumbnailItem) obj;
            if (thumbnailItem4 == null || (bitmap = thumbnailItem4.getBitmap()) == null) {
                bitmap = thumbnailBarUiState2.getSelectedSiblingThumbnail().getBitmap();
            }
            ThumbnailBitmap thumbnailBitmap2 = bitmap;
            Size sizeA4 = q40Var2.a(thumbnailBarUiState2.getSelectedSiblingThumbnail().getPageIndex());
            ArrayList arrayList13 = q40Var2.i;
            int size8 = arrayList13.size();
            int i28 = i4;
            while (i28 < size8) {
                Object obj8 = arrayList13.get(i28);
                i28++;
                if (((p60) obj8).a == thumbnailBarUiState2.getSelectedSiblingThumbnail().getPageIndex()) {
                    objCopy$default = obj8;
                    break;
                }
            }
            p60 p60Var3 = (p60) objCopy$default;
            objCopy$default = ThumbnailItem.copy$default(thumbnailBarUiState2.getSelectedSiblingThumbnail(), 0, new p60(thumbnailBarUiState2.getSelectedSiblingThumbnail().getPageIndex(), p60Var3 != null ? p60Var3.b : thumbnailBarUiState2.getSelectedSiblingThumbnail().getPosition().b, sizeA4), thumbnailBitmap2, false, false, f5, Float.valueOf(contentPaddingPx2), 25, null);
        }
        ?? r33 = objCopy$default;
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, null, null, null, arrayList11, thumbnailItemCopy$default, r33, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2064327, null)));
        int size9 = arrayList11.size();
        int i29 = i4;
        while (i29 < size9) {
            Object obj9 = arrayList11.get(i29);
            i29++;
            renderThumbnail(((ThumbnailItem) obj9).getPageIndex());
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0078  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x0197  */
    private final void recalculateSelectedPositions() {
        Float fValueOf;
        Float fValueOf2;
        Float fMaxOrNull;
        ThumbnailItem thumbnailItemCopy$default;
        ThumbnailItem thumbnailItemCopy$default2;
        ThumbnailBarUiState value;
        Float fB;
        Object obj;
        Object obj2;
        ThumbnailBarUiState value2 = this._uiState.getValue();
        q40 q40Var = this.staticThumbnailLayout;
        if (q40Var == null) {
            return;
        }
        ThumbnailBarTheme theme = value2.getTheme();
        if (value2.getAvailableWidth() == 0) {
            return;
        }
        ThumbnailItem thumbnailItem = (ThumbnailItem) CollectionsKt.lastOrNull((List) value2.getThumbnails());
        Float fValueOf3 = thumbnailItem != null ? Float.valueOf(thumbnailItem.getPosition().b + thumbnailItem.getPosition().c.width) : null;
        if (value2.getSelectedPageThumbnail() != null) {
            ArrayList arrayList = q40Var.i;
            int size = arrayList.size();
            int i = 0;
            do {
                if (i >= size) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = arrayList.get(i);
                    i++;
                }
            } while (((p60) obj2).a != value2.getSelectedPageThumbnail().getPageIndex());
            p60 p60Var = (p60) obj2;
            if (p60Var != null) {
                fValueOf = Float.valueOf(p60Var.b + p60Var.c.width);
            } else {
                fValueOf = null;
            }
        } else {
            fValueOf = null;
        }
        if (value2.getSelectedSiblingThumbnail() != null) {
            ArrayList arrayList2 = q40Var.i;
            int size2 = arrayList2.size();
            int i2 = 0;
            do {
                if (i2 >= size2) {
                    obj = null;
                    break;
                } else {
                    obj = arrayList2.get(i2);
                    i2++;
                }
            } while (((p60) obj).a != value2.getSelectedSiblingThumbnail().getPageIndex());
            p60 p60Var2 = (p60) obj;
            if (p60Var2 != null) {
                fValueOf2 = Float.valueOf(p60Var2.b + p60Var2.c.width);
            } else {
                fValueOf2 = null;
            }
        } else {
            fValueOf2 = null;
        }
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new Float[]{fValueOf3, fValueOf, fValueOf2});
        if (listListOfNotNull.isEmpty() || (fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) listListOfNotNull)) == null) {
            return;
        }
        int availableWidth = value2.getLayoutStyle() == LayoutStyle.FLOATING ? 0 : ((value2.getAvailableWidth() - (theme.getContentPaddingPx() * 2)) - ((int) fMaxOrNull.floatValue())) / 2;
        ThumbnailItem selectedPageThumbnail = value2.getSelectedPageThumbnail();
        if (selectedPageThumbnail != null) {
            thumbnailItemCopy$default = ThumbnailItem.copy$default(selectedPageThumbnail, 0, new p60(selectedPageThumbnail.getPageIndex(), selectedPageThumbnail.getPosition().b, q40Var.a(selectedPageThumbnail.getPageIndex())), null, false, false, value2.isDoublePageMode() ? q60.a(selectedPageThumbnail.getPageIndex(), value2, q40Var, availableWidth, theme.getContentPaddingPx(), theme.getThumbnailPaddingPx()) : q60.b(selectedPageThumbnail.getPageIndex(), value2, q40Var, availableWidth, theme.getContentPaddingPx(), theme.getThumbnailPaddingPx()), Float.valueOf(theme.getContentPaddingPx() - theme.getThumbnailPaddingPx()), 29, null);
        } else {
            thumbnailItemCopy$default = null;
        }
        ThumbnailItem selectedSiblingThumbnail = value2.getSelectedSiblingThumbnail();
        if (selectedSiblingThumbnail != null) {
            if (value2.isDoublePageMode()) {
                if ((thumbnailItemCopy$default != null ? thumbnailItemCopy$default.getAbsolutePositionX() : null) != null) {
                    Float absolutePositionX = thumbnailItemCopy$default.getAbsolutePositionX();
                    fB = Float.valueOf(selectedSiblingThumbnail.getPageIndex() > value2.getSelectedPageThumbnail().getPageIndex() ? absolutePositionX.floatValue() + thumbnailItemCopy$default.getPosition().c.width : absolutePositionX.floatValue() - q40Var.a(selectedSiblingThumbnail.getPageIndex()).width);
                } else {
                    fB = q60.b(selectedSiblingThumbnail.getPageIndex(), value2, q40Var, availableWidth, theme.getContentPaddingPx(), theme.getThumbnailPaddingPx());
                }
            } else {
                fB = q60.b(selectedSiblingThumbnail.getPageIndex(), value2, q40Var, availableWidth, theme.getContentPaddingPx(), theme.getThumbnailPaddingPx());
            }
            thumbnailItemCopy$default2 = ThumbnailItem.copy$default(selectedSiblingThumbnail, 0, new p60(selectedSiblingThumbnail.getPageIndex(), selectedSiblingThumbnail.getPosition().b, q40Var.a(selectedSiblingThumbnail.getPageIndex())), null, false, false, fB, Float.valueOf(theme.getContentPaddingPx() - theme.getThumbnailPaddingPx()), 29, null);
        } else {
            thumbnailItemCopy$default2 = null;
        }
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ThumbnailBarUiState.copy$default(value, null, null, null, null, thumbnailItemCopy$default, thumbnailItemCopy$default2, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097103, null)));
        PdfLog.d(LOG_TAG, "recalculateSelectedPositions: Updated overlay positions - selected at " + (thumbnailItemCopy$default != null ? thumbnailItemCopy$default.getAbsolutePositionX() : null) + ", sibling at " + (thumbnailItemCopy$default2 != null ? thumbnailItemCopy$default2.getAbsolutePositionX() : null), new Object[0]);
    }

    private final void recycleBitmaps() {
        ThumbnailBitmap bitmap;
        ThumbnailBitmap bitmap2;
        ThumbnailBarUiState value = this._uiState.getValue();
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        Iterator<T> it = value.getThumbnails().iterator();
        while (it.hasNext()) {
            ThumbnailBitmap bitmap3 = ((ThumbnailItem) it.next()).getBitmap();
            if (bitmap3 != null) {
                setNewSetFromMap.add(bitmap3);
            }
        }
        ThumbnailItem selectedPageThumbnail = value.getSelectedPageThumbnail();
        if (selectedPageThumbnail != null && (bitmap2 = selectedPageThumbnail.getBitmap()) != null) {
            setNewSetFromMap.add(bitmap2);
        }
        ThumbnailItem selectedSiblingThumbnail = value.getSelectedSiblingThumbnail();
        if (selectedSiblingThumbnail != null && (bitmap = selectedSiblingThumbnail.getBitmap()) != null) {
            setNewSetFromMap.add(bitmap);
        }
        Iterator<T> it2 = value.getScrollableThumbnails().values().iterator();
        while (it2.hasNext()) {
            setNewSetFromMap.add((ThumbnailBitmap) it2.next());
        }
        setNewSetFromMap.getClass();
        Iterator it3 = setNewSetFromMap.iterator();
        while (it3.hasNext()) {
            ((ThumbnailBitmap) it3.next()).release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x0119  */
    /* JADX WARN: Code duplicated, block: B:48:0x01d1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:74:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object renderPageBitmap(int i, lm lmVar, ThumbnailBarUiState thumbnailBarUiState, PageRenderConfiguration pageRenderConfiguration, Continuation<? super Bitmap> continuation) throws Exception {
        C18611 c18611;
        Size pageSize;
        float f;
        int thumbnailHeight;
        Bitmap bitmap;
        Object obj;
        int i2;
        PageRenderConfiguration pageRenderConfiguration2;
        int i3;
        Bitmap bitmap2;
        ThumbnailBarUiState thumbnailBarUiState2;
        oy oyVar;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Object objAwait;
        lm lmVar2 = lmVar;
        if (continuation instanceof C18611) {
            c18611 = (C18611) continuation;
            int i4 = c18611.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c18611.label = i4 - Integer.MIN_VALUE;
            } else {
                c18611 = new C18611(continuation);
            }
        } else {
            c18611 = new C18611(continuation);
        }
        Object obj2 = c18611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c18611.label;
        try {
            if (i5 != 0) {
                if (i5 == 1) {
                    i2 = c18611.I$2;
                    int i6 = c18611.I$1;
                    float f2 = c18611.F$0;
                    int i7 = c18611.I$0;
                    bitmap = (Bitmap) c18611.L$4;
                    pageSize = (Size) c18611.L$3;
                    pageRenderConfiguration2 = (PageRenderConfiguration) c18611.L$2;
                    thumbnailBarUiState2 = (ThumbnailBarUiState) c18611.L$1;
                    lm lmVar3 = (lm) c18611.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        i3 = i7;
                        thumbnailHeight = i6;
                        bitmap2 = bitmap;
                        obj = obj2;
                        f = f2;
                        lmVar2 = lmVar3;
                        try {
                            List list = (List) obj;
                            ou ouVar = lmVar2.c;
                            android.util.Size size = new android.util.Size(bitmap2.getWidth(), bitmap2.getHeight());
                            ouVar.getClass();
                            pageRenderConfiguration2.getClass();
                            if (pageRenderConfiguration2.renderRegion) {
                                try {
                                    bitmap3 = bitmap2;
                                    try {
                                        oyVar = new oy(new Point(pageRenderConfiguration2.regionX, pageRenderConfiguration2.regionY), new android.util.Size(pageRenderConfiguration2.regionFullPageWidth, pageRenderConfiguration2.regionFullPageHeight));
                                    } catch (Exception e) {
                                        e = e;
                                        bitmap2 = bitmap3;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } else {
                                bitmap3 = bitmap2;
                                oyVar = null;
                            }
                            oy oyVar2 = oyVar;
                            try {
                                Bitmap bitmap6 = pageRenderConfiguration2.reuseBitmap;
                                int i8 = pageRenderConfiguration2.paperColor;
                                Integer num = pageRenderConfiguration2.formHighlightColor;
                                Integer num2 = pageRenderConfiguration2.formItemHighlightColor;
                                Integer num3 = pageRenderConfiguration2.formRequiredFieldBorderColor;
                                Integer num4 = pageRenderConfiguration2.signHereOverlayBackgroundColor;
                                boolean z = pageRenderConfiguration2.toGrayscale;
                                boolean z2 = pageRenderConfiguration2.invertColors;
                                boolean z3 = pageRenderConfiguration2.redactionAnnotationPreviewEnabled;
                                List<PdfDrawable> list2 = pageRenderConfiguration2.renderedDrawables;
                                list2.getClass();
                                boolean z4 = pageRenderConfiguration2.showSignHereOverlay;
                                boolean z5 = pageRenderConfiguration2.useCache;
                                List<Integer> list3 = pageRenderConfiguration2.excludedAnnotations;
                                list3.getClass();
                                List<AnnotationType> list4 = pageRenderConfiguration2.excludedAnnotationTypes;
                                list4.getClass();
                                bitmap5 = bitmap3;
                                try {
                                    jm jmVarA = jm.a(new jm(ouVar, i3, bitmap6, size, z5, null, oyVar2, 3, i8, num, num2, num3, num4, z2, z, list3, list4, list2, z3, z4, true), bitmap5, null, null, 3, Boxing.boxInt(0), null, thumbnailBarUiState2.getExcludedAnnotationTypes(), list, thumbnailBarUiState2.isRedactionPreviewEnabled(), false, 1636219);
                                    bitmap4 = bitmap5;
                                    try {
                                        iu iuVar = iu.a;
                                        c18611.L$0 = SpillingKt.nullOutSpilledVariable(lmVar2);
                                        c18611.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailBarUiState2);
                                        c18611.L$2 = SpillingKt.nullOutSpilledVariable(pageRenderConfiguration2);
                                        c18611.L$3 = SpillingKt.nullOutSpilledVariable(pageSize);
                                        c18611.L$4 = bitmap4;
                                        c18611.L$5 = SpillingKt.nullOutSpilledVariable(list);
                                        c18611.L$6 = SpillingKt.nullOutSpilledVariable(jmVarA);
                                        c18611.I$0 = i3;
                                        c18611.F$0 = f;
                                        c18611.I$1 = thumbnailHeight;
                                        c18611.I$2 = i2;
                                        c18611.label = 2;
                                        objAwait = RxAwaitKt.await(iu.b(jmVarA), c18611);
                                        if (objAwait != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return objAwait;
                                    } catch (Exception e3) {
                                        e = e3;
                                        bitmap2 = bitmap4;
                                        bitmap = bitmap2;
                                        bitmap.recycle();
                                        throw e;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    bitmap4 = bitmap5;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                bitmap4 = bitmap3;
                            }
                        } catch (Exception e6) {
                            e = e6;
                        }
                    } catch (Exception e7) {
                        e = e7;
                    }
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bitmap2 = (Bitmap) c18611.L$4;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        return obj2;
                    } catch (Exception e8) {
                        e = e8;
                    }
                }
                bitmap = bitmap2;
            } else {
                ResultKt.throwOnFailure(obj2);
                pageSize = lmVar2.getPageSize(i);
                f = pageSize.width / pageSize.height;
                thumbnailHeight = thumbnailBarUiState.getTheme().getThumbnailHeight();
                int iCoerceAtLeast = RangesKt.coerceAtLeast((int) (thumbnailHeight * f), 1);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iCoerceAtLeast, thumbnailHeight, Bitmap.Config.ARGB_8888);
                try {
                    List<PdfDrawableProvider> drawableProviders = thumbnailBarUiState.getDrawableProviders();
                    Context context = this.context;
                    c18611.L$0 = lmVar2;
                    c18611.L$1 = thumbnailBarUiState;
                    c18611.L$2 = pageRenderConfiguration;
                    c18611.L$3 = SpillingKt.nullOutSpilledVariable(pageSize);
                    c18611.L$4 = bitmapCreateBitmap;
                    c18611.I$0 = i;
                    c18611.F$0 = f;
                    c18611.I$1 = thumbnailHeight;
                    c18611.I$2 = iCoerceAtLeast;
                    c18611.label = 1;
                    Object objA = qv.a(lmVar2, drawableProviders, context, i, c18611);
                    if (objA != coroutine_suspended) {
                        obj = objA;
                        i2 = iCoerceAtLeast;
                        pageRenderConfiguration2 = pageRenderConfiguration;
                        i3 = i;
                        bitmap2 = bitmapCreateBitmap;
                        thumbnailBarUiState2 = thumbnailBarUiState;
                        List list5 = (List) obj;
                        ou ouVar2 = lmVar2.c;
                        android.util.Size size2 = new android.util.Size(bitmap2.getWidth(), bitmap2.getHeight());
                        ouVar2.getClass();
                        pageRenderConfiguration2.getClass();
                        if (pageRenderConfiguration2.renderRegion) {
                            bitmap3 = bitmap2;
                            oyVar = new oy(new Point(pageRenderConfiguration2.regionX, pageRenderConfiguration2.regionY), new android.util.Size(pageRenderConfiguration2.regionFullPageWidth, pageRenderConfiguration2.regionFullPageHeight));
                        } else {
                            bitmap3 = bitmap2;
                            oyVar = null;
                        }
                        oy oyVar3 = oyVar;
                        Bitmap bitmap7 = pageRenderConfiguration2.reuseBitmap;
                        int i9 = pageRenderConfiguration2.paperColor;
                        Integer num5 = pageRenderConfiguration2.formHighlightColor;
                        Integer num6 = pageRenderConfiguration2.formItemHighlightColor;
                        Integer num7 = pageRenderConfiguration2.formRequiredFieldBorderColor;
                        Integer num8 = pageRenderConfiguration2.signHereOverlayBackgroundColor;
                        boolean z6 = pageRenderConfiguration2.toGrayscale;
                        boolean z7 = pageRenderConfiguration2.invertColors;
                        boolean z8 = pageRenderConfiguration2.redactionAnnotationPreviewEnabled;
                        List<PdfDrawable> list6 = pageRenderConfiguration2.renderedDrawables;
                        list6.getClass();
                        boolean z9 = pageRenderConfiguration2.showSignHereOverlay;
                        boolean z10 = pageRenderConfiguration2.useCache;
                        List<Integer> list7 = pageRenderConfiguration2.excludedAnnotations;
                        list7.getClass();
                        List<AnnotationType> list8 = pageRenderConfiguration2.excludedAnnotationTypes;
                        list8.getClass();
                        bitmap5 = bitmap3;
                        jm jmVarA2 = jm.a(new jm(ouVar2, i3, bitmap7, size2, z10, null, oyVar3, 3, i9, num5, num6, num7, num8, z7, z6, list7, list8, list6, z8, z9, true), bitmap5, null, null, 3, Boxing.boxInt(0), null, thumbnailBarUiState2.getExcludedAnnotationTypes(), list5, thumbnailBarUiState2.isRedactionPreviewEnabled(), false, 1636219);
                        bitmap4 = bitmap5;
                        iu iuVar2 = iu.a;
                        c18611.L$0 = SpillingKt.nullOutSpilledVariable(lmVar2);
                        c18611.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailBarUiState2);
                        c18611.L$2 = SpillingKt.nullOutSpilledVariable(pageRenderConfiguration2);
                        c18611.L$3 = SpillingKt.nullOutSpilledVariable(pageSize);
                        c18611.L$4 = bitmap4;
                        c18611.L$5 = SpillingKt.nullOutSpilledVariable(list5);
                        c18611.L$6 = SpillingKt.nullOutSpilledVariable(jmVarA2);
                        c18611.I$0 = i3;
                        c18611.F$0 = f;
                        c18611.I$1 = thumbnailHeight;
                        c18611.I$2 = i2;
                        c18611.label = 2;
                        objAwait = RxAwaitKt.await(iu.b(jmVarA2), c18611);
                        if (objAwait != coroutine_suspended) {
                            return objAwait;
                        }
                    }
                    return coroutine_suspended;
                } catch (Exception e9) {
                    e = e9;
                    bitmap = bitmapCreateBitmap;
                }
            }
            bitmap.recycle();
            throw e;
        } catch (CancellationException e10) {
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderScrollableThumbnail(int pageIndex) {
        PageRenderConfiguration pageRenderConfiguration;
        ThumbnailBarUiState value = this._uiState.getValue();
        PdfDocument document = value.getDocument();
        lm lmVar = document instanceof lm ? (lm) document : null;
        if (lmVar == null || (pageRenderConfiguration = value.getPageRenderConfiguration()) == null) {
            return;
        }
        if (value.getScrollableThumbnails().get(Integer.valueOf(pageIndex)) == null || value.getDirtyPages().contains(Integer.valueOf(pageIndex))) {
            Job job = this.scrollableRenderJobs.get(Integer.valueOf(pageIndex));
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.scrollableRenderJobs.put(Integer.valueOf(pageIndex), BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getMain().getImmediate(), null, new C18621(pageIndex, lmVar, value, pageRenderConfiguration, null), 2, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderSelectedPages() {
        ThumbnailBarUiState value = this._uiState.getValue();
        ThumbnailItem selectedPageThumbnail = value.getSelectedPageThumbnail();
        if (selectedPageThumbnail != null) {
            renderThumbnail(selectedPageThumbnail.getPageIndex());
        }
        ThumbnailItem selectedSiblingThumbnail = value.getSelectedSiblingThumbnail();
        if (selectedSiblingThumbnail != null) {
            renderThumbnail(selectedSiblingThumbnail.getPageIndex());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderThumbnail(int pageIndex) {
        PageRenderConfiguration pageRenderConfiguration;
        Object next;
        ThumbnailItem thumbnailItem;
        ThumbnailBarStateManager thumbnailBarStateManager = this;
        int i = pageIndex;
        ThumbnailBarUiState value = thumbnailBarStateManager._uiState.getValue();
        PdfDocument document = value.getDocument();
        lm lmVar = document instanceof lm ? (lm) document : null;
        if (lmVar == null || (pageRenderConfiguration = value.getPageRenderConfiguration()) == null) {
            return;
        }
        Iterator<T> it = value.getThumbnails().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((ThumbnailItem) next).getPageIndex() != i);
        ThumbnailItem thumbnailItem2 = (ThumbnailItem) next;
        if ((thumbnailItem2 != null ? thumbnailItem2.getBitmap() : null) != null && !value.getDirtyPages().contains(Integer.valueOf(i))) {
            PdfLog.d(LOG_TAG, "renderThumbnail: Page " + i + " already has bitmap, skipping render", new Object[0]);
            return;
        }
        Job job = thumbnailBarStateManager.renderJobs.get(Integer.valueOf(i));
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        MutableStateFlow<ThumbnailBarUiState> mutableStateFlow = thumbnailBarStateManager._uiState;
        while (true) {
            ThumbnailBarUiState value2 = mutableStateFlow.getValue();
            ThumbnailBarUiState thumbnailBarUiState = value2;
            List<ThumbnailItem> thumbnails = thumbnailBarUiState.getThumbnails();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(thumbnails, 10));
            for (ThumbnailItem thumbnailItemCopy$default : thumbnails) {
                if (thumbnailItemCopy$default.getPageIndex() == i) {
                    thumbnailItemCopy$default = ThumbnailItem.copy$default(thumbnailItemCopy$default, 0, null, null, false, true, null, null, 111, null);
                }
                arrayList.add(thumbnailItemCopy$default);
            }
            ThumbnailItem selectedPageThumbnail = thumbnailBarUiState.getSelectedPageThumbnail();
            if (selectedPageThumbnail != null) {
                if (selectedPageThumbnail.getPageIndex() == i) {
                    selectedPageThumbnail = ThumbnailItem.copy$default(selectedPageThumbnail, 0, null, null, false, true, null, null, 111, null);
                }
                thumbnailItem = selectedPageThumbnail;
            } else {
                thumbnailItem = null;
            }
            ThumbnailItem selectedSiblingThumbnail = thumbnailBarUiState.getSelectedSiblingThumbnail();
            if (selectedSiblingThumbnail == null) {
                selectedSiblingThumbnail = null;
            } else if (selectedSiblingThumbnail.getPageIndex() == i) {
                selectedSiblingThumbnail = ThumbnailItem.copy$default(selectedSiblingThumbnail, 0, null, null, false, true, null, null, 111, null);
            }
            if (mutableStateFlow.compareAndSet(value2, ThumbnailBarUiState.copy$default(thumbnailBarUiState, null, null, null, arrayList, thumbnailItem, selectedSiblingThumbnail, null, null, false, false, false, null, false, null, 0, false, null, null, null, false, 0, 2097095, null))) {
                thumbnailBarStateManager.renderJobs.put(Integer.valueOf(i), BuildersKt__Builders_commonKt.launch$default(thumbnailBarStateManager.scope, Dispatchers.getMain().getImmediate(), null, thumbnailBarStateManager.new AnonymousClass2(i, lmVar, value, pageRenderConfiguration, null), 2, null));
                return;
            } else {
                thumbnailBarStateManager = this;
                i = pageIndex;
            }
        }
    }

    private final void unregisterDrawableProviders() {
        Iterator<T> it = this._uiState.getValue().getDrawableProviders().iterator();
        while (it.hasNext()) {
            ((PdfDrawableProvider) it.next()).unregisterDrawableProviderObserver(this);
        }
    }

    public final void dispose() {
        cancelAllRenderJobs();
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        unregisterDrawableProviders();
    }

    public final SharedFlow<ThumbnailBarEffect> getEffects() {
        return this.effects;
    }

    public final StateFlow<ThumbnailBarUiState> getUiState() {
        return this.uiState;
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableProvider.DrawableProviderObserver
    public void onDrawablesChanged(PdfDrawableProvider drawableProvider) {
        drawableProvider.getClass();
        handleRefresh();
    }

    public final void onEvent(ThumbnailBarEvent event) {
        event.getClass();
        PdfLog.d(LOG_TAG, "onEvent: " + event, new Object[0]);
        if (event instanceof ThumbnailBarEvent.ThumbnailClicked) {
            handleThumbnailClicked(((ThumbnailBarEvent.ThumbnailClicked) event).getPageIndex());
            return;
        }
        if (event instanceof ThumbnailBarEvent.ThumbnailScrolled) {
            ThumbnailBarEvent.ThumbnailScrolled thumbnailScrolled = (ThumbnailBarEvent.ThumbnailScrolled) event;
            handleThumbnailScrolled(thumbnailScrolled.getTouchX(), thumbnailScrolled.getTouchY());
            return;
        }
        if (event instanceof ThumbnailBarEvent.DocumentSet) {
            ThumbnailBarEvent.DocumentSet documentSet = (ThumbnailBarEvent.DocumentSet) event;
            handleDocumentSet(documentSet.getDocument(), documentSet.getConfiguration());
            return;
        }
        if (event instanceof ThumbnailBarEvent.PageChanged) {
            handlePageChanged(((ThumbnailBarEvent.PageChanged) event).getPageIndex());
            return;
        }
        if (event instanceof ThumbnailBarEvent.PageUpdated) {
            handlePageUpdated(((ThumbnailBarEvent.PageUpdated) event).getPageIndex());
            return;
        }
        if (event instanceof ThumbnailBarEvent.LayoutStyleChanged) {
            handleLayoutStyleChanged(((ThumbnailBarEvent.LayoutStyleChanged) event).getStyle());
            return;
        }
        if (event instanceof ThumbnailBarEvent.ThemeChanged) {
            handleThemeChanged(((ThumbnailBarEvent.ThemeChanged) event).getTheme());
            return;
        }
        if (event instanceof ThumbnailBarEvent.BackgroundColorChanged) {
            handleBackgroundColorChanged(((ThumbnailBarEvent.BackgroundColorChanged) event).getColor());
            return;
        }
        if (event instanceof ThumbnailBarEvent.ThumbnailBorderColorChanged) {
            handleThumbnailBorderColorChanged(((ThumbnailBarEvent.ThumbnailBorderColorChanged) event).getColor());
            return;
        }
        if (event instanceof ThumbnailBarEvent.ThumbnailSizeChanged) {
            ThumbnailBarEvent.ThumbnailSizeChanged thumbnailSizeChanged = (ThumbnailBarEvent.ThumbnailSizeChanged) event;
            handleThumbnailSizeChanged(thumbnailSizeChanged.getWidth(), thumbnailSizeChanged.getHeight());
            return;
        }
        if (event instanceof ThumbnailBarEvent.UsePageAspectRatioChanged) {
            handleUsePageAspectRatioChanged(((ThumbnailBarEvent.UsePageAspectRatioChanged) event).getUseAspectRatio());
            return;
        }
        if (event instanceof ThumbnailBarEvent.RedactionPreviewChanged) {
            handleRedactionPreviewChanged(((ThumbnailBarEvent.RedactionPreviewChanged) event).getEnabled());
            return;
        }
        if (event instanceof ThumbnailBarEvent.DrawableProvidersChanged) {
            handleDrawableProvidersChanged(((ThumbnailBarEvent.DrawableProvidersChanged) event).getProviders());
            return;
        }
        if (event instanceof ThumbnailBarEvent.AvailableWidthChanged) {
            handleAvailableWidthChanged(((ThumbnailBarEvent.AvailableWidthChanged) event).getWidth());
            return;
        }
        if (event instanceof ThumbnailBarEvent.ThumbnailRendered) {
            ThumbnailBarEvent.ThumbnailRendered thumbnailRendered = (ThumbnailBarEvent.ThumbnailRendered) event;
            handleThumbnailRendered(thumbnailRendered.getPageIndex(), thumbnailRendered.getBitmap());
            return;
        }
        if (event instanceof ThumbnailBarEvent.ThumbnailRenderFailed) {
            ThumbnailBarEvent.ThumbnailRenderFailed thumbnailRenderFailed = (ThumbnailBarEvent.ThumbnailRenderFailed) event;
            handleThumbnailRenderFailed(thumbnailRenderFailed.getPageIndex(), thumbnailRenderFailed.getError());
            return;
        }
        if (event instanceof ThumbnailBarEvent.ClearDocument) {
            handleClearDocument();
            return;
        }
        if (event instanceof ThumbnailBarEvent.Refresh) {
            handleRefresh();
        } else if (event instanceof ThumbnailBarEvent.ScrollableVisiblePagesChanged) {
            handleScrollableVisiblePagesChanged(((ThumbnailBarEvent.ScrollableVisiblePagesChanged) event).getVisiblePages());
        } else {
            if (!(event instanceof ThumbnailBarEvent.ScrollableModeChanged)) {
                throw new NoWhenBranchMatchedException();
            }
            handleScrollableModeChanged(((ThumbnailBarEvent.ScrollableModeChanged) event).isScrollable());
        }
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableProvider.DrawableProviderObserver
    public void onDrawablesChanged(PdfDrawableProvider drawableProvider, int pageIndex) {
        drawableProvider.getClass();
        handlePageUpdated(pageIndex);
    }
}
