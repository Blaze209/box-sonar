package com.box.android.preview.annotations.managers;

import android.content.Context;
import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.preview.R;
import com.box.android.preview.annotations.AnnotationEditListener;
import com.box.android.preview.annotations.AnnotationUpdateListener;
import com.box.android.preview.annotations.AnnotationUtils;
import com.box.android.preview.annotations.PdfAnnotationScaleValueProvider;
import com.box.android.preview.annotations.PdfDrawingAnnotation;
import com.box.android.preview.annotations.PdfRegionAnnotation;
import com.box.android.preview.annotations.PdfTextSelectionAnnotation;
import com.box.android.preview.annotations.ui.views.MenuItemState;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.BuildConfig;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.HighlightAnnotation;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.SquareAnnotation;
import com.pspdfkit.annotations.configuration.InkAnnotationConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.undo.UndoManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: CreateAnnotationsManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u0002:\u0004\u0086\u0001\u0087\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0006\u0010I\u001a\u00020JJ\b\u0010K\u001a\u00020JH\u0002J\b\u0010L\u001a\u00020JH\u0002J\b\u0010M\u001a\u00020JH\u0002J\u0010\u0010N\u001a\u00020J2\u0006\u00102\u001a\u000203H\u0016J\u0010\u0010O\u001a\u00020J2\u0006\u00102\u001a\u000203H\u0016J\u0010\u0010P\u001a\u00020J2\u0006\u00102\u001a\u000203H\u0002J\u0010\u0010Q\u001a\u00020J2\u0006\u0010R\u001a\u000203H\u0016J\u000e\u0010S\u001a\u00020J2\u0006\u0010T\u001a\u00020\u0016J\u0006\u0010U\u001a\u00020VJ\u0006\u0010W\u001a\u00020JJ\b\u0010X\u001a\u00020JH\u0002J\b\u0010Y\u001a\u00020JH\u0002J\b\u0010Z\u001a\u00020JH\u0002J\b\u0010[\u001a\u00020JH\u0002J\u0016\u0010\\\u001a\u00020J2\u0006\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020GJ\u000e\u0010_\u001a\u00020V2\u0006\u0010^\u001a\u00020GJ\u0006\u0010`\u001a\u00020JJ\u0006\u0010a\u001a\u00020JJ\u0006\u0010b\u001a\u00020JJ\u0006\u0010c\u001a\u00020VJ\u0006\u0010d\u001a\u00020VJ\u0010\u0010e\u001a\u00020J2\b\b\u0002\u0010f\u001a\u00020VJ\u0010\u0010g\u001a\u00020V2\u0006\u0010^\u001a\u00020GH\u0002J\u0006\u0010h\u001a\u00020JJ \u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020l2\u0006\u0010n\u001a\u00020lH\u0007J\u0010\u0010o\u001a\u00020J2\u0006\u0010p\u001a\u00020\u001fH\u0002J\u0012\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020s0rJ\u0010\u0010t\u001a\u00020J2\u0006\u0010p\u001a\u00020\u001fH\u0016J\u0010\u0010u\u001a\u00020J2\u0006\u0010p\u001a\u00020\u001fH\u0016J\u0010\u0010v\u001a\u00020J2\u0006\u0010p\u001a\u00020\u001fH\u0016J6\u0010w\u001a\u00020J2\u0006\u0010x\u001a\u00020\t2\u0011\u0010y\u001a\r\u0012\t\u0012\u00070\u001f¢\u0006\u0002\b{0z2\u0011\u0010|\u001a\r\u0012\t\u0012\u00070\u001f¢\u0006\u0002\b{0zH\u0016J\b\u0010}\u001a\u0004\u0018\u00010~J\u000f\u0010\u007f\u001a\u00020VH\u0087@¢\u0006\u0003\u0010\u0080\u0001J\u0010\u0010\u0081\u0001\u001a\u00020J2\u0007\u0010\u0082\u0001\u001a\u00020\u0016J\u0010\u0010\u0083\u0001\u001a\u00020J2\u0007\u0010\u0084\u0001\u001a\u00020\tJ\u0011\u0010\u0085\u0001\u001a\u00020V2\u0006\u0010p\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R4\u0010)\u001a\u0012\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0007\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001d\u0010F\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\b\n\u0000\u001a\u0004\bH\u0010!¨\u0006\u0088\u0001"}, d2 = {"Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "Lcom/pspdfkit/ui/annotations/OnAnnotatingModeChangeListener;", "Lcom/pspdfkit/annotations/AnnotationProvider$OnAnnotationUpdatedListener;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "()V", "currentPageIndex", "", "getCurrentPageIndex", "()I", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "documentAnnotationMutex", "Lkotlinx/coroutines/sync/Mutex;", "selectedMarkupType", "Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "getSelectedMarkupType$annotations", "getSelectedMarkupType", "()Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "setSelectedMarkupType", "(Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;)V", "createdAnnotations", "", "", "Lcom/pspdfkit/annotations/Annotation;", "getCreatedAnnotations", "()Ljava/util/Map;", "previousHighlightRects", "", "Landroid/graphics/RectF;", "getPreviousHighlightRects", "()Ljava/util/List;", "setPreviousHighlightRects", "(Ljava/util/List;)V", "selectedToolPair", "Lkotlin/Pair;", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationTool;", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationToolVariant;", "getSelectedToolPair$annotations", "getSelectedToolPair", "()Lkotlin/Pair;", "setSelectedToolPair", "(Lkotlin/Pair;)V", "annotationCreationController", "Lcom/pspdfkit/ui/special_mode/controller/AnnotatingController;", BuildConfig.FLAVOR, "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager$AnnotationCreationFragment;", "getFragment", "()Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager$AnnotationCreationFragment;", "setFragment", "(Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager$AnnotationCreationFragment;)V", "pdfAnnotationScaleValueProvider", "Lcom/box/android/preview/annotations/PdfAnnotationScaleValueProvider;", "getPdfAnnotationScaleValueProvider", "()Lcom/box/android/preview/annotations/PdfAnnotationScaleValueProvider;", "setPdfAnnotationScaleValueProvider", "(Lcom/box/android/preview/annotations/PdfAnnotationScaleValueProvider;)V", "creatingAnnotationUpdatedListener", "Lcom/box/android/preview/annotations/AnnotationUpdateListener;", "getCreatingAnnotationUpdatedListener", "()Lcom/box/android/preview/annotations/AnnotationUpdateListener;", "setCreatingAnnotationUpdatedListener", "(Lcom/box/android/preview/annotations/AnnotationUpdateListener;)V", "colorHolderMap", "Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;", "getColorHolderMap", "setAnnotationCreator", "", "registerDrawingListeners", "unregisterDrawingListeners", "setColorToControllerFromMap", "onChangeAnnotatingMode", "onEnterAnnotatingMode", "updateAnnotationCreationController", "onExitAnnotatingMode", "var1", "enterAnnotationMarkupMode", "annotationMarkupType", "areAnnotationsPending", "", "exitAnnotationMarkupMode", "exitDrawingMode", "enterDrawingAnnotationMode", "enterRegionAnnotationMode", "enterHighlightAnnotationMode", "setColor", "color", "annotationTool", "setDrawingTool", "redoOperation", "undoOperation", "removePendingAnnotations", "canUndo", "canRedo", "onAnnotationChanged", "hasToRecreatePopup", "isActiveTool", "setDefaultConfigurations", "getInkAnnotationConfiguration", "Lcom/pspdfkit/annotations/configuration/InkAnnotationConfiguration;", "defaultThickness", "", "minThickness", "maxThickness", "guardLimit", "annotation", "createMenuItemEnableVisibleMap", "", "Lcom/box/android/preview/annotations/ui/views/MenuItemState;", "onAnnotationCreated", "onAnnotationUpdated", "onAnnotationRemoved", "onAnnotationZOrderChanged", "pageIndex", "oldOrder", "", "Lkotlin/jvm/JvmSuppressWildcards;", "newOrder", "getCreatedAnnotation", "Lcom/box/android/preview/annotations/model/Annotation;", "isPendingAnnotationPayloadSizeNotAboveLimit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchMarkupMode", "boxAnnotationMarkupType", "removeAnnotationsNotOnPage", FirebaseAnalytics.Param.INDEX, "isNotPendingAnnotation", "Companion", "AnnotationCreationFragment", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateAnnotationsManager implements OnAnnotatingModeChangeListener, AnnotationProvider.OnAnnotationUpdatedListener {
    private static final String MARKER_VARIANT = "marker";
    private AnnotatingController annotationCreationController;
    private final Map<BoxAnnotationTool, Integer> colorHolderMap;
    private CoroutineScope coroutineScope;
    private final Map<String, Annotation> createdAnnotations;
    private AnnotationUpdateListener creatingAnnotationUpdatedListener;
    private final Mutex documentAnnotationMutex;
    private AnnotationCreationFragment fragment;
    private final CoroutineDispatcher ioDispatcher;
    private PdfAnnotationScaleValueProvider pdfAnnotationScaleValueProvider;
    private List<RectF> previousHighlightRects;
    private BoxAnnotationMarkupType selectedMarkupType;
    private Pair<? extends AnnotationTool, AnnotationToolVariant> selectedToolPair;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BoxAnnotationMarkupType.values().length];
            try {
                iArr[BoxAnnotationMarkupType.DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxAnnotationMarkupType.REGION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxAnnotationMarkupType.HIGHLIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BoxAnnotationMarkupType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BoxAnnotationTool.values().length];
            try {
                iArr2[BoxAnnotationTool.MARKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BoxAnnotationTool.PENCIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BoxAnnotationTool.ERASER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BoxAnnotationTool.SQUARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[BoxAnnotationTool.HIGHLIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.CreateAnnotationsManager$isPendingAnnotationPayloadSizeNotAboveLimit$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.CreateAnnotationsManager", f = "CreateAnnotationsManager.kt", i = {0}, l = {549}, m = "isPendingAnnotationPayloadSizeNotAboveLimit", n = {"payload"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return CreateAnnotationsManager.this.isPendingAnnotationPayloadSizeNotAboveLimit(this);
        }
    }

    public static /* synthetic */ void getCoroutineScope$annotations() {
    }

    public static /* synthetic */ void getSelectedMarkupType$annotations() {
    }

    public static /* synthetic */ void getSelectedToolPair$annotations() {
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public void onAnnotationZOrderChanged(int pageIndex, List<Annotation> oldOrder, List<Annotation> newOrder) {
        Intrinsics.checkNotNullParameter(oldOrder, "oldOrder");
        Intrinsics.checkNotNullParameter(newOrder, "newOrder");
    }

    @Inject
    public CreateAnnotationsManager(CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.ioDispatcher = ioDispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.documentAnnotationMutex = MutexKt.Mutex$default(false, 1, null);
        this.selectedMarkupType = BoxAnnotationMarkupType.NONE;
        this.createdAnnotations = new LinkedHashMap();
        this.previousHighlightRects = new ArrayList();
        this.colorHolderMap = new LinkedHashMap();
    }

    /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager$Companion;", "", "<init>", "()V", "MARKER_VARIANT", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CreateAnnotationsManager() {
        this(Dispatchers.getIO());
    }

    private final int getCurrentPageIndex() {
        PdfFragment pdfFragment;
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null) {
            return -1;
        }
        return pdfFragment.getPageIndex();
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.coroutineScope = coroutineScope;
    }

    public final BoxAnnotationMarkupType getSelectedMarkupType() {
        return this.selectedMarkupType;
    }

    public final void setSelectedMarkupType(BoxAnnotationMarkupType boxAnnotationMarkupType) {
        Intrinsics.checkNotNullParameter(boxAnnotationMarkupType, "<set-?>");
        this.selectedMarkupType = boxAnnotationMarkupType;
    }

    public final Map<String, Annotation> getCreatedAnnotations() {
        return this.createdAnnotations;
    }

    public final List<RectF> getPreviousHighlightRects() {
        return this.previousHighlightRects;
    }

    public final void setPreviousHighlightRects(List<RectF> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.previousHighlightRects = list;
    }

    public final Pair<AnnotationTool, AnnotationToolVariant> getSelectedToolPair() {
        return this.selectedToolPair;
    }

    public final void setSelectedToolPair(Pair<? extends AnnotationTool, AnnotationToolVariant> pair) {
        this.selectedToolPair = pair;
    }

    public final AnnotationCreationFragment getFragment() {
        return this.fragment;
    }

    public final void setFragment(AnnotationCreationFragment annotationCreationFragment) {
        this.fragment = annotationCreationFragment;
    }

    public final PdfAnnotationScaleValueProvider getPdfAnnotationScaleValueProvider() {
        return this.pdfAnnotationScaleValueProvider;
    }

    public final void setPdfAnnotationScaleValueProvider(PdfAnnotationScaleValueProvider pdfAnnotationScaleValueProvider) {
        this.pdfAnnotationScaleValueProvider = pdfAnnotationScaleValueProvider;
    }

    public final AnnotationUpdateListener getCreatingAnnotationUpdatedListener() {
        return this.creatingAnnotationUpdatedListener;
    }

    public final void setCreatingAnnotationUpdatedListener(AnnotationUpdateListener annotationUpdateListener) {
        this.creatingAnnotationUpdatedListener = annotationUpdateListener;
    }

    public final Map<BoxAnnotationTool, Integer> getColorHolderMap() {
        return this.colorHolderMap;
    }

    public final void setAnnotationCreator() {
        PdfFragment pdfFragment;
        Context context;
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null || (context = pdfFragment.getContext()) == null) {
            return;
        }
        PSPDFKitPreferences.get(context).setAnnotationCreator("");
    }

    private final void registerDrawingListeners() {
        PdfFragment pdfFragment;
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null) {
            return;
        }
        pdfFragment.addOnAnnotatingModeChangeListener(this);
        pdfFragment.addOnAnnotationUpdatedListener(this);
    }

    private final void unregisterDrawingListeners() {
        PdfFragment pdfFragment;
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null) {
            return;
        }
        pdfFragment.removeOnAnnotatingModeChangeListener(this);
        pdfFragment.removeOnAnnotationUpdatedListener(this);
    }

    private final void setColorToControllerFromMap() {
        Object next;
        Iterator<T> it = this.colorHolderMap.keySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!isActiveTool((BoxAnnotationTool) next));
        Integer num = this.colorHolderMap.get((BoxAnnotationTool) next);
        if (num != null) {
            int iIntValue = num.intValue();
            AnnotatingController annotatingController = this.annotationCreationController;
            if (annotatingController != null) {
                annotatingController.setColor(iIntValue);
            }
        }
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
    public void onChangeAnnotatingMode(AnnotatingController annotationCreationController) {
        Intrinsics.checkNotNullParameter(annotationCreationController, "annotationCreationController");
        updateAnnotationCreationController(annotationCreationController);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
    public void onEnterAnnotatingMode(AnnotatingController annotationCreationController) {
        PdfFragment pdfFragment;
        UndoManager undoManager;
        Intrinsics.checkNotNullParameter(annotationCreationController, "annotationCreationController");
        updateAnnotationCreationController(annotationCreationController);
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null || (undoManager = pdfFragment.getUndoManager()) == null) {
            return;
        }
        undoManager.setOnAddNewEditListener(new AnnotationEditListener(this.createdAnnotations));
    }

    private final void updateAnnotationCreationController(AnnotatingController annotationCreationController) {
        Float widthScalingFactorForPage;
        this.annotationCreationController = annotationCreationController;
        if (annotationCreationController.getActiveAnnotationTool() == AnnotationTool.INK || annotationCreationController.getActiveAnnotationTool() == AnnotationTool.SQUARE) {
            PdfAnnotationScaleValueProvider pdfAnnotationScaleValueProvider = this.pdfAnnotationScaleValueProvider;
            if (pdfAnnotationScaleValueProvider != null && (widthScalingFactorForPage = pdfAnnotationScaleValueProvider.getWidthScalingFactorForPage(getCurrentPageIndex())) != null) {
                annotationCreationController.setThickness(annotationCreationController.getThickness() * widthScalingFactorForPage.floatValue());
            } else {
                BoxLogUtils.w(ExtensionsKt.getTAG(INSTANCE), "Please set annotation thickness factor for the correct thickness to be rendered ");
            }
        }
        setColorToControllerFromMap();
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
    public void onExitAnnotatingMode(AnnotatingController var1) {
        Intrinsics.checkNotNullParameter(var1, "var1");
        this.annotationCreationController = null;
    }

    public final void enterAnnotationMarkupMode(BoxAnnotationMarkupType annotationMarkupType) {
        Intrinsics.checkNotNullParameter(annotationMarkupType, "annotationMarkupType");
        this.selectedMarkupType = annotationMarkupType;
        int i = WhenMappings.$EnumSwitchMapping$0[annotationMarkupType.ordinal()];
        if (i == 1) {
            enterDrawingAnnotationMode();
            registerDrawingListeners();
        } else if (i == 2) {
            enterRegionAnnotationMode();
            registerDrawingListeners();
        } else if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            enterHighlightAnnotationMode();
            registerDrawingListeners();
        }
    }

    public final boolean areAnnotationsPending() {
        return !this.createdAnnotations.isEmpty();
    }

    public final void exitAnnotationMarkupMode() throws InterruptedException {
        exitDrawingMode();
        this.selectedMarkupType = BoxAnnotationMarkupType.NONE;
        this.selectedToolPair = null;
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment != null) {
            annotationCreationFragment.dismissCommentPopupMenu();
        }
    }

    private final void exitDrawingMode() throws InterruptedException {
        PdfFragment pdfFragment;
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment != null && (pdfFragment = annotationCreationFragment.getPdfFragment()) != null) {
            pdfFragment.exitCurrentlyActiveMode();
        }
        removePendingAnnotations();
        unregisterDrawingListeners();
    }

    private final void enterDrawingAnnotationMode() {
        Pair<? extends AnnotationTool, AnnotationToolVariant> pair;
        AnnotationCreationFragment annotationCreationFragment;
        PdfFragment pdfFragment;
        if (this.selectedMarkupType != BoxAnnotationMarkupType.DRAW || (pair = this.selectedToolPair) == null || (annotationCreationFragment = this.fragment) == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null) {
            return;
        }
        AnnotationTool first = pair.getFirst();
        AnnotationToolVariant second = pair.getSecond();
        if (second == null) {
            second = AnnotationToolVariant.defaultVariant();
            Intrinsics.checkNotNullExpressionValue(second, "defaultVariant(...)");
        }
        pdfFragment.enterAnnotationCreationMode(first, second);
    }

    private final void enterRegionAnnotationMode() {
        AnnotationCreationFragment annotationCreationFragment;
        PdfFragment pdfFragment;
        if (this.selectedMarkupType != BoxAnnotationMarkupType.REGION || (annotationCreationFragment = this.fragment) == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null) {
            return;
        }
        pdfFragment.enterAnnotationCreationMode(AnnotationTool.SQUARE);
        setColor(pdfFragment.requireContext().getColor(R.color.color_picker_yellow), BoxAnnotationTool.SQUARE);
    }

    private final void enterHighlightAnnotationMode() {
        AnnotationCreationFragment annotationCreationFragment;
        PdfFragment pdfFragment;
        if (this.selectedMarkupType != BoxAnnotationMarkupType.HIGHLIGHT || (annotationCreationFragment = this.fragment) == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null) {
            return;
        }
        pdfFragment.enterAnnotationCreationMode(AnnotationTool.HIGHLIGHT);
        setColor(pdfFragment.requireContext().getColor(R.color.color_picker_yellow), BoxAnnotationTool.HIGHLIGHT);
    }

    public final void setColor(int color, BoxAnnotationTool annotationTool) {
        AnnotatingController annotatingController;
        Intrinsics.checkNotNullParameter(annotationTool, "annotationTool");
        if (this.annotationCreationController != null && isActiveTool(annotationTool) && (annotatingController = this.annotationCreationController) != null) {
            annotatingController.setColor(color);
        }
        this.colorHolderMap.put(annotationTool, Integer.valueOf(color));
    }

    public final boolean setDrawingTool(BoxAnnotationTool annotationTool) {
        Pair<? extends AnnotationTool, AnnotationToolVariant> pair;
        Pair<? extends AnnotationTool, AnnotationToolVariant> pair2;
        Intrinsics.checkNotNullParameter(annotationTool, "annotationTool");
        int i = WhenMappings.$EnumSwitchMapping$1[annotationTool.ordinal()];
        if (i != 1) {
            pair = null;
            if (i == 2) {
                pair2 = new Pair<>(AnnotationTool.INK, null);
            } else if (i == 3) {
                pair2 = new Pair<>(AnnotationTool.ERASER, null);
            }
            pair = pair2;
        } else {
            pair = new Pair<>(AnnotationTool.INK, AnnotationToolVariant.fromName("marker"));
        }
        this.selectedToolPair = pair;
        enterDrawingAnnotationMode();
        return true;
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.CreateAnnotationsManager$redoOperation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.CreateAnnotationsManager$redoOperation$1", f = "CreateAnnotationsManager.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C16691(Continuation<? super C16691> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CreateAnnotationsManager.this.new C16691(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PdfFragment pdfFragment;
            UndoManager undoManager;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationCreationFragment fragment = CreateAnnotationsManager.this.getFragment();
                if (fragment != null && (pdfFragment = fragment.getPdfFragment()) != null && (undoManager = pdfFragment.getUndoManager()) != null) {
                    this.label = 1;
                    if (undoManager.redo(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public final void redoOperation() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C16691(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.CreateAnnotationsManager$undoOperation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.CreateAnnotationsManager$undoOperation$1", f = "CreateAnnotationsManager.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C16721(Continuation<? super C16721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CreateAnnotationsManager.this.new C16721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PdfFragment pdfFragment;
            UndoManager undoManager;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationCreationFragment fragment = CreateAnnotationsManager.this.getFragment();
                if (fragment != null && (pdfFragment = fragment.getPdfFragment()) != null && (undoManager = pdfFragment.getUndoManager()) != null) {
                    this.label = 1;
                    if (undoManager.undo(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public final void undoOperation() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C16721(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.CreateAnnotationsManager$removePendingAnnotations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.CreateAnnotationsManager$removePendingAnnotations$1", f = "CreateAnnotationsManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {591, 269}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$this$forEach$iv", "element$iv", "createdAnnotation", "$i$f$withLock", "$i$a$-withLock$default-CreateAnnotationsManager$removePendingAnnotations$1$1", "$i$f$forEach", "$i$a$-forEach-CreateAnnotationsManager$removePendingAnnotations$1$1$1"}, s = {"L$0", "I$0", "L$0", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C16711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Annotation> $createdAnnotationCopy;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C16711(List<? extends Annotation> list, Continuation<? super C16711> continuation) {
            super(2, continuation);
            this.$createdAnnotationCopy = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CreateAnnotationsManager.this.new C16711(this.$createdAnnotationCopy, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0083 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:7:0x002c, B:19:0x007d, B:21:0x0083, B:23:0x0090, B:25:0x0096, B:27:0x009c, B:29:0x00a2, B:32:0x00d6, B:18:0x0072), top: B:37:0x000c }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<Annotation> list;
            Mutex mutex;
            int i;
            CreateAnnotationsManager createAnnotationsManager;
            Iterator it;
            CreateAnnotationsManager createAnnotationsManager2;
            int i2;
            Iterable iterable;
            int i3;
            int i4;
            AnnotationCreationFragment fragment;
            PdfFragment pdfFragment;
            PdfDocument document;
            AnnotationProvider annotationProvider;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            try {
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex2 = CreateAnnotationsManager.this.documentAnnotationMutex;
                    list = this.$createdAnnotationCopy;
                    CreateAnnotationsManager createAnnotationsManager3 = CreateAnnotationsManager.this;
                    this.L$0 = mutex2;
                    this.L$1 = list;
                    this.L$2 = createAnnotationsManager3;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex2.lock(null, this) != coroutine_suspended) {
                        mutex = mutex2;
                        i = 0;
                        createAnnotationsManager = createAnnotationsManager3;
                    }
                    return coroutine_suspended;
                }
                if (i5 == 1) {
                    i = this.I$0;
                    createAnnotationsManager = (CreateAnnotationsManager) this.L$2;
                    list = (List) this.L$1;
                    Mutex mutex3 = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex3;
                } else {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i4 = this.I$2;
                    i2 = this.I$1;
                    i3 = this.I$0;
                    it = (Iterator) this.L$3;
                    iterable = (Iterable) this.L$2;
                    createAnnotationsManager2 = (CreateAnnotationsManager) this.L$1;
                    mutex = (Mutex) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    Annotation annotation = (Annotation) next;
                    fragment = createAnnotationsManager2.getFragment();
                    if (fragment == null && (pdfFragment = fragment.getPdfFragment()) != null && (document = pdfFragment.getDocument()) != null && (annotationProvider = document.getAnnotationProvider()) != null) {
                        annotation.setCustomData(new JSONObject("{\"creator\":\"MARKED FOR DELETION\"}"));
                        this.L$0 = mutex;
                        this.L$1 = createAnnotationsManager2;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(iterable);
                        this.L$3 = it;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(annotation);
                        this.I$0 = i3;
                        this.I$1 = i2;
                        this.I$2 = i4;
                        this.I$3 = 0;
                        this.label = 2;
                        if (annotationProvider.removeAnnotationFromPage(annotation, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
                List<Annotation> list2 = list;
                it = list2.iterator();
                createAnnotationsManager2 = createAnnotationsManager;
                i2 = 0;
                iterable = list2;
                i3 = i;
                i4 = 0;
                while (it.hasNext()) {
                    Object next2 = it.next();
                    Annotation annotation2 = (Annotation) next2;
                    fragment = createAnnotationsManager2.getFragment();
                    if (fragment == null) {
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    public final void removePendingAnnotations() throws InterruptedException {
        PdfFragment pdfFragment;
        BuildersKt__BuildersKt.runBlocking$default(null, new C16711(CollectionsKt.toList(this.createdAnnotations.values()), null), 1, null);
        this.previousHighlightRects.clear();
        this.createdAnnotations.clear();
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment != null && (pdfFragment = annotationCreationFragment.getPdfFragment()) != null) {
            AnnotationUtils.INSTANCE.clearUndoRedoHistory(pdfFragment);
        }
        AnnotationCreationFragment annotationCreationFragment2 = this.fragment;
        if (annotationCreationFragment2 != null) {
            annotationCreationFragment2.dismissCommentPopupMenu();
        }
        AnnotationUpdateListener annotationUpdateListener = this.creatingAnnotationUpdatedListener;
        if (annotationUpdateListener != null) {
            annotationUpdateListener.onAnnotationUpdated(getCreatedAnnotation(), null);
        }
    }

    public final boolean canUndo() {
        PdfFragment pdfFragment;
        UndoManager undoManager;
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        return (annotationCreationFragment == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null || (undoManager = pdfFragment.getUndoManager()) == null || !undoManager.canUndo()) ? false : true;
    }

    public final boolean canRedo() {
        PdfFragment pdfFragment;
        UndoManager undoManager;
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        return (annotationCreationFragment == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null || (undoManager = pdfFragment.getUndoManager()) == null || !undoManager.canRedo()) ? false : true;
    }

    public static /* synthetic */ void onAnnotationChanged$default(CreateAnnotationsManager createAnnotationsManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        createAnnotationsManager.onAnnotationChanged(z);
    }

    public final void onAnnotationChanged(boolean hasToRecreatePopup) {
        if (this.selectedMarkupType == BoxAnnotationMarkupType.NONE) {
            return;
        }
        if (this.selectedMarkupType == BoxAnnotationMarkupType.DRAW) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C16681(hasToRecreatePopup, null), 3, null);
            return;
        }
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment != null) {
            AnnotationCreationFragment.showCommentPopupMenu$default(annotationCreationFragment, false, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.CreateAnnotationsManager$onAnnotationChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.CreateAnnotationsManager$onAnnotationChanged$1", f = "CreateAnnotationsManager.kt", i = {}, l = {BoxCommonConstants.REQUEST_CHOOSE_LOCAL_UPLOAD_DIR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $hasToRecreatePopup;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16681(boolean z, Continuation<? super C16681> continuation) {
            super(2, continuation);
            this.$hasToRecreatePopup = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CreateAnnotationsManager.this.new C16681(this.$hasToRecreatePopup, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BuildersKt.withContext(CreateAnnotationsManager.this.ioDispatcher, new CreateAnnotationsManager$onAnnotationChanged$1$isNotAboveLimit$1(CreateAnnotationsManager.this, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                AnnotationCreationFragment fragment = CreateAnnotationsManager.this.getFragment();
                if (fragment != null) {
                    fragment.showCommentPopupMenu(this.$hasToRecreatePopup);
                }
            } else {
                AnnotationCreationFragment fragment2 = CreateAnnotationsManager.this.getFragment();
                if (fragment2 != null) {
                    fragment2.showAlertDialogForMaxSizeReached();
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final boolean isActiveTool(BoxAnnotationTool annotationTool) {
        int i = WhenMappings.$EnumSwitchMapping$1[annotationTool.ordinal()];
        if (i == 1) {
            AnnotatingController annotatingController = this.annotationCreationController;
            if (annotatingController != null) {
                if ((annotatingController != null ? annotatingController.getActiveAnnotationTool() : null) == AnnotationTool.INK) {
                    AnnotatingController annotatingController2 = this.annotationCreationController;
                    if (Intrinsics.areEqual(annotatingController2 != null ? annotatingController2.getActiveAnnotationToolVariant() : null, AnnotationToolVariant.fromName("marker"))) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (i == 2) {
            AnnotatingController annotatingController3 = this.annotationCreationController;
            if (annotatingController3 != null) {
                if ((annotatingController3 != null ? annotatingController3.getActiveAnnotationTool() : null) == AnnotationTool.INK) {
                    AnnotatingController annotatingController4 = this.annotationCreationController;
                    if (!Intrinsics.areEqual(annotatingController4 != null ? annotatingController4.getActiveAnnotationToolVariant() : null, AnnotationToolVariant.fromName("marker"))) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (i == 3) {
            AnnotatingController annotatingController5 = this.annotationCreationController;
            if (annotatingController5 != null) {
                if ((annotatingController5 != null ? annotatingController5.getActiveAnnotationTool() : null) == AnnotationTool.ERASER) {
                    return true;
                }
            }
            return false;
        }
        if (i == 4) {
            AnnotatingController annotatingController6 = this.annotationCreationController;
            if (annotatingController6 != null) {
                if ((annotatingController6 != null ? annotatingController6.getActiveAnnotationTool() : null) == AnnotationTool.SQUARE) {
                    return true;
                }
            }
            return false;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        AnnotatingController annotatingController7 = this.annotationCreationController;
        if (annotatingController7 != null) {
            if ((annotatingController7 != null ? annotatingController7.getActiveAnnotationTool() : null) == AnnotationTool.HIGHLIGHT) {
                return true;
            }
        }
        return false;
    }

    public final void setDefaultConfigurations() {
        PdfFragment pdfFragment;
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        if (annotationCreationFragment != null && (pdfFragment = annotationCreationFragment.getPdfFragment()) != null) {
            pdfFragment.getAnnotationConfiguration().put(AnnotationType.INK, getInkAnnotationConfiguration(2.0f, 2.0f, 2.0f));
            pdfFragment.getAnnotationConfiguration().put(AnnotationTool.INK, AnnotationToolVariant.fromName("marker"), getInkAnnotationConfiguration(8.0f, 8.0f, 8.0f));
        }
        setAnnotationCreator();
    }

    public final InkAnnotationConfiguration getInkAnnotationConfiguration(float defaultThickness, float minThickness, float maxThickness) {
        AnnotationCreationFragment annotationCreationFragment = this.fragment;
        Intrinsics.checkNotNull(annotationCreationFragment);
        InkAnnotationConfiguration inkAnnotationConfigurationBuild = InkAnnotationConfiguration.builder(annotationCreationFragment.getPreviewActivity()).setDefaultThickness(defaultThickness).setMinThickness(minThickness).setMaxThickness(maxThickness).setForceDefaults(false).setPreviewEnabled(false).build();
        Intrinsics.checkNotNullExpressionValue(inkAnnotationConfigurationBuild, "build(...)");
        return inkAnnotationConfigurationBuild;
    }

    /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager$AnnotationCreationFragment;", "", "getPdfFragment", "Lcom/pspdfkit/ui/PdfFragment;", "getPreviewActivity", "Landroidx/fragment/app/FragmentActivity;", "showCommentPopupMenu", "", "hasToRecreatePopup", "", "isAnnotationPayloadSizeNotAboveLimit", "payload", "Lcom/box/android/preview/annotations/model/Annotation;", "(Lcom/box/android/preview/annotations/model/Annotation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showAlertDialogForMaxSizeReached", "dismissCommentPopupMenu", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface AnnotationCreationFragment {
        void dismissCommentPopupMenu();

        PdfFragment getPdfFragment();

        FragmentActivity getPreviewActivity();

        Object isAnnotationPayloadSizeNotAboveLimit(com.box.android.preview.annotations.model.Annotation annotation, Continuation<? super Boolean> continuation);

        void showAlertDialogForMaxSizeReached();

        void showCommentPopupMenu(boolean hasToRecreatePopup);

        /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class DefaultImpls {
        }

        static /* synthetic */ void showCommentPopupMenu$default(AnnotationCreationFragment annotationCreationFragment, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCommentPopupMenu");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            annotationCreationFragment.showCommentPopupMenu(z);
        }
    }

    private final void guardLimit(Annotation annotation) throws InterruptedException {
        if (this.selectedMarkupType == BoxAnnotationMarkupType.REGION) {
            if (this.createdAnnotations.isEmpty()) {
                return;
            }
            removePendingAnnotations();
        } else if (this.selectedMarkupType == BoxAnnotationMarkupType.HIGHLIGHT && (annotation instanceof HighlightAnnotation)) {
            this.previousHighlightRects = CollectionsKt.toMutableList((Collection) ((HighlightAnnotation) annotation).getRects());
        }
    }

    public final Map<Integer, MenuItemState> createMenuItemEnableVisibleMap() {
        boolean z = this.selectedMarkupType == BoxAnnotationMarkupType.DRAW;
        boolean z2 = this.selectedMarkupType == BoxAnnotationMarkupType.HIGHLIGHT;
        HashMap map = new HashMap();
        map.put(Integer.valueOf(R.id.redo), new MenuItemState(z, canRedo()));
        map.put(Integer.valueOf(R.id.undo), new MenuItemState(z, canUndo()));
        map.put(Integer.valueOf(R.id.remove), new MenuItemState(z2, areAnnotationsPending()));
        map.put(Integer.valueOf(R.id.save_comment), new MenuItemState(true, areAnnotationsPending()));
        return map;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public void onAnnotationCreated(Annotation annotation) throws InterruptedException {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        if (isNotPendingAnnotation(annotation)) {
            return;
        }
        guardLimit(annotation);
        this.createdAnnotations.put(annotation.getUuid(), annotation);
        AnnotationUpdateListener annotationUpdateListener = this.creatingAnnotationUpdatedListener;
        if (annotationUpdateListener != null) {
            annotationUpdateListener.onAnnotationUpdated(getCreatedAnnotation(), Integer.valueOf(annotation.getPageIndex()));
        }
        onAnnotationChanged$default(this, false, 1, null);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public void onAnnotationUpdated(Annotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        if (isNotPendingAnnotation(annotation)) {
            return;
        }
        if (annotation instanceof HighlightAnnotation) {
            HighlightAnnotation highlightAnnotation = (HighlightAnnotation) annotation;
            List<? extends RectF> listMinus = CollectionsKt.minus((Iterable) highlightAnnotation.getRects(), (Iterable) this.previousHighlightRects);
            List<? extends RectF> list = listMinus;
            if (!list.isEmpty()) {
                this.previousHighlightRects = CollectionsKt.toMutableList((Collection) list);
                highlightAnnotation.setRects(listMinus);
            }
        } else {
            this.createdAnnotations.put(annotation.getUuid(), annotation);
        }
        AnnotationUpdateListener annotationUpdateListener = this.creatingAnnotationUpdatedListener;
        if (annotationUpdateListener != null) {
            annotationUpdateListener.onAnnotationUpdated(getCreatedAnnotation(), Integer.valueOf(annotation.getPageIndex()));
        }
        onAnnotationChanged$default(this, false, 1, null);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public void onAnnotationRemoved(Annotation annotation) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        if (isNotPendingAnnotation(annotation)) {
            return;
        }
        this.createdAnnotations.remove(annotation.getUuid());
        AnnotationUpdateListener annotationUpdateListener = this.creatingAnnotationUpdatedListener;
        if (annotationUpdateListener != null) {
            annotationUpdateListener.onAnnotationUpdated(getCreatedAnnotation(), Integer.valueOf(annotation.getPageIndex()));
        }
        onAnnotationChanged$default(this, false, 1, null);
    }

    public final com.box.android.preview.annotations.model.Annotation getCreatedAnnotation() {
        Float widthScalingFactorForPage;
        PdfFragment pdfFragment;
        PdfFragment pdfFragment2;
        List list = CollectionsKt.toList(this.createdAnnotations.values());
        if (list.isEmpty()) {
            return null;
        }
        int pageIndex = ((Annotation) list.get(0)).getPageIndex();
        ArrayList<Annotation> arrayList = new ArrayList();
        for (Object obj : list) {
            if (pageIndex == ((Annotation) obj).getPageIndex()) {
                arrayList.add(obj);
            }
        }
        com.box.android.preview.annotations.model.Annotation pdfDrawingAnnotation = null;
        for (Annotation annotation : arrayList) {
            if (annotation instanceof InkAnnotation) {
                if (pdfDrawingAnnotation == null) {
                    RectF rectF = new RectF();
                    List listEmptyList = CollectionsKt.emptyList();
                    AnnotationCreationFragment annotationCreationFragment = this.fragment;
                    Integer numValueOf = (annotationCreationFragment == null || (pdfFragment = annotationCreationFragment.getPdfFragment()) == null) ? null : Integer.valueOf(pdfFragment.getPageIndex());
                    Intrinsics.checkNotNull(numValueOf);
                    int iIntValue = numValueOf.intValue();
                    AnnotationCreationFragment annotationCreationFragment2 = this.fragment;
                    PdfFragment pdfFragment3 = annotationCreationFragment2 != null ? annotationCreationFragment2.getPdfFragment() : null;
                    Intrinsics.checkNotNull(pdfFragment3);
                    Context contextRequireContext = pdfFragment3.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    pdfDrawingAnnotation = new PdfDrawingAnnotation(rectF, listEmptyList, "", iIntValue, contextRequireContext);
                }
                InkAnnotation inkAnnotationCopy = CreateAnnotationsManagerKt.copy((InkAnnotation) annotation);
                PdfAnnotationScaleValueProvider pdfAnnotationScaleValueProvider = this.pdfAnnotationScaleValueProvider;
                if (pdfAnnotationScaleValueProvider != null && (widthScalingFactorForPage = pdfAnnotationScaleValueProvider.getWidthScalingFactorForPage(inkAnnotationCopy.getPageIndex())) != null) {
                    inkAnnotationCopy.setLineWidth(inkAnnotationCopy.getLineWidth() / widthScalingFactorForPage.floatValue());
                }
                ((PdfDrawingAnnotation) pdfDrawingAnnotation).getInkAnnotations().add(inkAnnotationCopy);
            } else if (annotation instanceof SquareAnnotation) {
                RectF boundingBox = annotation.getBoundingBox();
                AnnotationCreationFragment annotationCreationFragment3 = this.fragment;
                PdfFragment pdfFragment4 = annotationCreationFragment3 != null ? annotationCreationFragment3.getPdfFragment() : null;
                Intrinsics.checkNotNull(pdfFragment4);
                Context contextRequireContext2 = pdfFragment4.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                pdfDrawingAnnotation = new PdfRegionAnnotation(boundingBox, contextRequireContext2, "");
            } else if (annotation instanceof HighlightAnnotation) {
                RectF boundingBox2 = annotation.getBoundingBox();
                List<RectF> rects = ((HighlightAnnotation) annotation).getRects();
                AnnotationCreationFragment annotationCreationFragment4 = this.fragment;
                Integer numValueOf2 = (annotationCreationFragment4 == null || (pdfFragment2 = annotationCreationFragment4.getPdfFragment()) == null) ? null : Integer.valueOf(pdfFragment2.getPageIndex());
                Intrinsics.checkNotNull(numValueOf2);
                pdfDrawingAnnotation = new PdfTextSelectionAnnotation(boundingBox2, rects, "", numValueOf2.intValue());
            } else {
                BoxLogUtils.w(ExtensionsKt.getTAG(this), "Annotation type " + annotation.getType() + " not supported yet!");
            }
        }
        return pdfDrawingAnnotation;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isPendingAnnotationPayloadSizeNotAboveLimit(Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objIsAnnotationPayloadSizeNotAboveLimit = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsAnnotationPayloadSizeNotAboveLimit);
            com.box.android.preview.annotations.model.Annotation createdAnnotation = getCreatedAnnotation();
            if (createdAnnotation == null) {
                return Boxing.boxBoolean(true);
            }
            AnnotationCreationFragment annotationCreationFragment = this.fragment;
            if (annotationCreationFragment != null) {
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(createdAnnotation);
                anonymousClass1.label = 1;
                objIsAnnotationPayloadSizeNotAboveLimit = annotationCreationFragment.isAnnotationPayloadSizeNotAboveLimit(createdAnnotation, anonymousClass1);
                if (objIsAnnotationPayloadSizeNotAboveLimit == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(z);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objIsAnnotationPayloadSizeNotAboveLimit);
        if (((Boolean) objIsAnnotationPayloadSizeNotAboveLimit).booleanValue()) {
            z = true;
        }
        return Boxing.boxBoolean(z);
    }

    public final void switchMarkupMode(BoxAnnotationMarkupType boxAnnotationMarkupType) throws InterruptedException {
        Intrinsics.checkNotNullParameter(boxAnnotationMarkupType, "boxAnnotationMarkupType");
        exitAnnotationMarkupMode();
        enterAnnotationMarkupMode(boxAnnotationMarkupType);
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.CreateAnnotationsManager$removeAnnotationsNotOnPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateAnnotationsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.CreateAnnotationsManager$removeAnnotationsNotOnPage$1", f = "CreateAnnotationsManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {591, 562}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$this$forEach$iv", "element$iv", "annotation", "$i$f$withLock", "$i$a$-withLock$default-CreateAnnotationsManager$removeAnnotationsNotOnPage$1$1", "$i$f$forEach", "$i$a$-forEach-CreateAnnotationsManager$removeAnnotationsNotOnPage$1$1$1"}, s = {"L$0", "I$0", "L$0", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C16701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Annotation> $toRemoveFromDocument;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C16701(List<? extends Annotation> list, Continuation<? super C16701> continuation) {
            super(2, continuation);
            this.$toRemoveFromDocument = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CreateAnnotationsManager.this.new C16701(this.$toRemoveFromDocument, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0085 A[Catch: all -> 0x00e5, TryCatch #1 {all -> 0x00e5, blocks: (B:20:0x007f, B:22:0x0085, B:24:0x0092, B:26:0x0098, B:28:0x009e, B:30:0x00a4, B:34:0x00d0), top: B:48:0x007f }] */
        /* JADX WARN: Code duplicated, block: B:24:0x0092 A[Catch: all -> 0x00e5, TryCatch #1 {all -> 0x00e5, blocks: (B:20:0x007f, B:22:0x0085, B:24:0x0092, B:26:0x0098, B:28:0x009e, B:30:0x00a4, B:34:0x00d0), top: B:48:0x007f }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0090 -> B:33:0x00cd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0096 -> B:33:0x00cd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009c -> B:33:0x00cd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a2 -> B:33:0x00cd). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ca -> B:33:0x00cd). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 238
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.annotations.managers.CreateAnnotationsManager.C16701.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void removeAnnotationsNotOnPage(int index) {
        Collection<Annotation> collectionValues = this.createdAnnotations.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((Annotation) obj).getPageIndex() != index) {
                arrayList.add(obj);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C16701(arrayList, null), 3, null);
    }

    private final boolean isNotPendingAnnotation(Annotation annotation) {
        return annotation.getCustomData() != null;
    }
}
