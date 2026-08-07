package com.box.android.preview.annotations.managers;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.fragment.app.FragmentActivity;
import com.box.android.domain.models.annotations.AnnotationLocationModel;
import com.box.android.preview.annotations.AnnotationUtils;
import com.box.android.preview.annotations.PdfAnnotationScaleValueProvider;
import com.box.android.preview.annotations.PdfDrawingAnnotation;
import com.box.android.preview.annotations.PdfRegionAnnotation;
import com.box.android.preview.annotations.PdfTextSelectionAnnotation;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.AnnotationWithLocation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.BuildConfig;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.HighlightAnnotation;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: BoxPdfAnnotationManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0002YZB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020+H\u0002J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u0012H\u0016J\u0014\u00102\u001a\u00020+2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001204J\u0010\u00105\u001a\u00020+2\u0006\u00101\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u00020+2\u0006\u00101\u001a\u00020\u0012H\u0002J\f\u00107\u001a\u00020\u0018*\u000208H\u0002J\u0016\u00109\u001a\u00020+2\u0006\u0010-\u001a\u00020.H\u0082@¢\u0006\u0002\u0010:J\u0016\u0010;\u001a\u00020+2\u0006\u00101\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020+2\u0006\u00101\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010<J\u0018\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u000bH\u0002J\b\u0010A\u001a\u00020+H\u0016J\u0006\u0010B\u001a\u00020+J.\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010@\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010HJ\u0016\u0010I\u001a\b\u0012\u0004\u0012\u000208042\u0006\u0010J\u001a\u00020KH\u0016J\u0018\u0010L\u001a\u00020+2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u000208\u0018\u000104H\u0002J\"\u0010N\u001a\u00020+2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001042\b\u0010O\u001a\u0004\u0018\u000108H\u0002J\u0018\u0010P\u001a\u00020+2\u0006\u0010O\u001a\u0002082\u0006\u0010J\u001a\u00020KH\u0002J\u001a\u0010Q\u001a\u0004\u0018\u0001082\u0006\u0010R\u001a\u00020S2\u0006\u0010J\u001a\u00020KH\u0016J\u000e\u0010T\u001a\u00020\u00182\u0006\u0010U\u001a\u00020VJ\u001a\u0010W\u001a\u0004\u0018\u0001082\u0006\u0010U\u001a\u00020V2\u0006\u0010J\u001a\u00020KH\u0016J\b\u0010X\u001a\u00020+H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006["}, d2 = {"Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "Lcom/box/android/preview/annotations/managers/BoxAnnotationManager;", "<init>", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "annotationDocumentMutex", "Lkotlinx/coroutines/sync/Mutex;", "drawableMap", "", "", "", "Lcom/pspdfkit/ui/drawable/PdfDrawable;", "getDrawableMap$annotations", "getDrawableMap", "()Ljava/util/Map;", "annotations", "Lcom/box/android/preview/annotations/model/AnnotationWithLocation;", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "value", "", "annotationVisibility", "getAnnotationVisibility", "()Z", "setAnnotationVisibility", "(Z)V", BuildConfig.FLAVOR, "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager$DocumentPreviewFragment;", "getFragment", "()Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager$DocumentPreviewFragment;", "setFragment", "(Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager$DocumentPreviewFragment;)V", "pdfAnnotationScaleValueProvider", "Lcom/box/android/preview/annotations/PdfAnnotationScaleValueProvider;", "getPdfAnnotationScaleValueProvider", "()Lcom/box/android/preview/annotations/PdfAnnotationScaleValueProvider;", "setPdfAnnotationScaleValueProvider", "(Lcom/box/android/preview/annotations/PdfAnnotationScaleValueProvider;)V", "setFlagsOnAllAnnotations", "", "setFlagsOnAnnotation", "annotation", "Lcom/pspdfkit/annotations/Annotation;", "handleVisibilityChange", "addAnnotation", "annotationWithLocation", "replaceAnnotationsFromServer", "newAnnotations", "", "addAnnotationWithoutPersistingToDocument", "addPdfDrawingAnnotationWithoutPersisting", "needsPersistingToPdfDocument", "Lcom/box/android/preview/annotations/model/Annotation;", "addAnnotationToPage", "(Lcom/pspdfkit/annotations/Annotation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistAnnotationToDocument", "(Lcom/box/android/preview/annotations/model/AnnotationWithLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAnnotationFromDocument", "addDrawable", "pdfDrawable", "pageIndex", "removeAllAnnotations", "removeAllDrawables", "getDrawablesForPage", "context", "Landroid/content/Context;", "document", "Lcom/pspdfkit/document/PdfDocument;", "(Landroid/content/Context;Lcom/pspdfkit/document/PdfDocument;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnnotationsForLocation", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "clearInterSections", "annotationList", "markIntersections", "selectedAnnotation", "onAnnotationSelected", "selectAnnotationContainingPoint", "point", "Landroid/graphics/PointF;", "navigateToAnnotation", "annotationId", "", "selectAnnotationWithId", "notifyAnnotationsChanged", "Companion", "DocumentPreviewFragment", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxPdfAnnotationManager extends PdfDrawableProvider implements BoxAnnotationManager {
    private static final EnumSet<AnnotationFlags> flagSetAnnotationHidden;
    private static final EnumSet<AnnotationFlags> flagSetAnnotationVisible;
    public DocumentPreviewFragment fragment;
    private PdfAnnotationScaleValueProvider pdfAnnotationScaleValueProvider;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    private final Mutex annotationDocumentMutex = MutexKt.Mutex$default(false, 1, null);
    private final Map<Integer, List<PdfDrawable>> drawableMap = new LinkedHashMap();
    private List<AnnotationWithLocation> annotations = new ArrayList();
    private boolean annotationVisibility = true;

    /* JADX INFO: compiled from: BoxPdfAnnotationManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager$DocumentPreviewFragment;", "", "getPdfFragment", "Lcom/pspdfkit/ui/PdfFragment;", "getPreviewActivity", "Landroidx/fragment/app/FragmentActivity;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface DocumentPreviewFragment {
        PdfFragment getPdfFragment();

        FragmentActivity getPreviewActivity();
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.BoxPdfAnnotationManager$addAnnotationToPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxPdfAnnotationManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.BoxPdfAnnotationManager", f = "BoxPdfAnnotationManager.kt", i = {0}, l = {198}, m = "addAnnotationToPage", n = {"annotation"}, s = {"L$0"}, v = 1)
    static final class C16651 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C16651(Continuation<? super C16651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxPdfAnnotationManager.this.addAnnotationToPage(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.BoxPdfAnnotationManager$persistAnnotationToDocument$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxPdfAnnotationManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.BoxPdfAnnotationManager", f = "BoxPdfAnnotationManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {208, 213}, m = "persistAnnotationToDocument", n = {"annotationWithLocation", "modelAnnotation", "annotationWithLocation", "modelAnnotation", "$this$forEach$iv", "element$iv", "inkAnnotation", "$i$f$forEach", "$i$a$-forEach-BoxPdfAnnotationManager$persistAnnotationToDocument$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C16661 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C16661(Continuation<? super C16661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxPdfAnnotationManager.this.persistAnnotationToDocument(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.BoxPdfAnnotationManager$removeAnnotationFromDocument$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxPdfAnnotationManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.BoxPdfAnnotationManager", f = "BoxPdfAnnotationManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {226, 233}, m = "removeAnnotationFromDocument", n = {"annotationWithLocation", "modelAnnotation", "annotationWithLocation", "modelAnnotation", "$this$forEach$iv", "element$iv", "inkAnnotation", "$i$f$forEach", "$i$a$-forEach-BoxPdfAnnotationManager$removeAnnotationFromDocument$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C16671 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C16671(Continuation<? super C16671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxPdfAnnotationManager.this.removeAnnotationFromDocument(null, this);
        }
    }

    public static /* synthetic */ void getDrawableMap$annotations() {
    }

    @Inject
    public BoxPdfAnnotationManager() {
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public /* bridge */ RectF getIntersectionIfAny(RectF rectF, RectF rectF2) {
        return super.getIntersectionIfAny(rectF, rectF2);
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public /* bridge */ Annotation getSmallestAnnotation(List<? extends Annotation> list) {
        return super.getSmallestAnnotation(list);
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public /* bridge */ boolean isPointInAnnotation(Annotation annotation, PointF pointF) {
        return super.isPointInAnnotation(annotation, pointF);
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public /* bridge */ void unselectAllAnnotations() {
        super.unselectAllAnnotations();
    }

    public final Map<Integer, List<PdfDrawable>> getDrawableMap() {
        return this.drawableMap;
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public List<AnnotationWithLocation> getAnnotations() {
        return this.annotations;
    }

    public void setAnnotations(List<AnnotationWithLocation> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.annotations = list;
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public boolean getAnnotationVisibility() {
        return this.annotationVisibility;
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public void setAnnotationVisibility(boolean z) {
        this.annotationVisibility = z;
        handleVisibilityChange();
    }

    public final DocumentPreviewFragment getFragment() {
        DocumentPreviewFragment documentPreviewFragment = this.fragment;
        if (documentPreviewFragment != null) {
            return documentPreviewFragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException(BuildConfig.FLAVOR);
        return null;
    }

    public final void setFragment(DocumentPreviewFragment documentPreviewFragment) {
        Intrinsics.checkNotNullParameter(documentPreviewFragment, "<set-?>");
        this.fragment = documentPreviewFragment;
    }

    public final PdfAnnotationScaleValueProvider getPdfAnnotationScaleValueProvider() {
        return this.pdfAnnotationScaleValueProvider;
    }

    public final void setPdfAnnotationScaleValueProvider(PdfAnnotationScaleValueProvider pdfAnnotationScaleValueProvider) {
        this.pdfAnnotationScaleValueProvider = pdfAnnotationScaleValueProvider;
    }

    /* JADX INFO: compiled from: BoxPdfAnnotationManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager$Companion;", "", "<init>", "()V", "flagSetAnnotationVisible", "Ljava/util/EnumSet;", "Lcom/pspdfkit/annotations/AnnotationFlags;", "getFlagSetAnnotationVisible", "()Ljava/util/EnumSet;", "flagSetAnnotationHidden", "getFlagSetAnnotationHidden", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EnumSet<AnnotationFlags> getFlagSetAnnotationVisible() {
            return BoxPdfAnnotationManager.flagSetAnnotationVisible;
        }

        public final EnumSet<AnnotationFlags> getFlagSetAnnotationHidden() {
            return BoxPdfAnnotationManager.flagSetAnnotationHidden;
        }
    }

    static {
        EnumSet<AnnotationFlags> enumSetOf = EnumSet.of(AnnotationFlags.READONLY, AnnotationFlags.PRINT);
        Intrinsics.checkNotNullExpressionValue(enumSetOf, "of(...)");
        flagSetAnnotationVisible = enumSetOf;
        EnumSet<AnnotationFlags> enumSetOf2 = EnumSet.of(AnnotationFlags.READONLY, AnnotationFlags.HIDDEN);
        Intrinsics.checkNotNullExpressionValue(enumSetOf2, "of(...)");
        flagSetAnnotationHidden = enumSetOf2;
    }

    private final void setFlagsOnAllAnnotations() {
        for (AnnotationWithLocation annotationWithLocation : getAnnotations()) {
            if (annotationWithLocation.getAnnotation() instanceof HighlightAnnotation) {
                setFlagsOnAnnotation((com.pspdfkit.annotations.Annotation) annotationWithLocation.getAnnotation());
            } else if (annotationWithLocation.getAnnotation() instanceof PdfDrawingAnnotation) {
                Iterator<T> it = ((PdfDrawingAnnotation) annotationWithLocation.getAnnotation()).getInkAnnotations().iterator();
                while (it.hasNext()) {
                    setFlagsOnAnnotation((InkAnnotation) it.next());
                }
            }
        }
        notifyAnnotationsChanged();
    }

    private final void setFlagsOnAnnotation(com.pspdfkit.annotations.Annotation annotation) {
        annotation.setFlags(getAnnotationVisibility() ? flagSetAnnotationVisible : flagSetAnnotationHidden);
        annotation.setCustomData(new JSONObject("{\"creator\":\"com.box.android\"}"));
    }

    private final void handleVisibilityChange() {
        setFlagsOnAllAnnotations();
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public void addAnnotation(AnnotationWithLocation annotationWithLocation) {
        Intrinsics.checkNotNullParameter(annotationWithLocation, "annotationWithLocation");
        addAnnotationWithoutPersistingToDocument(annotationWithLocation);
        if (this.fragment == null || !needsPersistingToPdfDocument(annotationWithLocation.getAnnotation())) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(annotationWithLocation, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.BoxPdfAnnotationManager$addAnnotation$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxPdfAnnotationManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.BoxPdfAnnotationManager$addAnnotation$1", f = "BoxPdfAnnotationManager.kt", i = {0, 0, 1, 1, 1}, l = {396, 112}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-BoxPdfAnnotationManager$addAnnotation$1$1"}, s = {"L$0", "I$0", "L$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnnotationWithLocation $annotationWithLocation;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnnotationWithLocation annotationWithLocation, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$annotationWithLocation = annotationWithLocation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxPdfAnnotationManager.this.new AnonymousClass1(this.$annotationWithLocation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            BoxPdfAnnotationManager boxPdfAnnotationManager;
            AnnotationWithLocation annotationWithLocation;
            int i;
            Throwable th;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = BoxPdfAnnotationManager.this.annotationDocumentMutex;
                    boxPdfAnnotationManager = BoxPdfAnnotationManager.this;
                    AnnotationWithLocation annotationWithLocation2 = this.$annotationWithLocation;
                    this.L$0 = mutex;
                    this.L$1 = boxPdfAnnotationManager;
                    this.L$2 = annotationWithLocation2;
                    this.I$0 = 0;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                        annotationWithLocation = annotationWithLocation2;
                        i = 0;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                i = this.I$0;
                annotationWithLocation = (AnnotationWithLocation) this.L$2;
                boxPdfAnnotationManager = (BoxPdfAnnotationManager) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this.L$0 = mutex;
                this.L$1 = null;
                this.L$2 = null;
                this.I$0 = i;
                this.I$1 = 0;
                this.label = 2;
                if (boxPdfAnnotationManager.persistAnnotationToDocument(annotationWithLocation, this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    public final void replaceAnnotationsFromServer(List<AnnotationWithLocation> newAnnotations) {
        Intrinsics.checkNotNullParameter(newAnnotations, "newAnnotations");
        List list = CollectionsKt.toList(getAnnotations());
        super.removeAllAnnotations();
        removeAllDrawables();
        Iterator<T> it = newAnnotations.iterator();
        while (it.hasNext()) {
            addAnnotationWithoutPersistingToDocument((AnnotationWithLocation) it.next());
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass2(list, newAnnotations, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.annotations.managers.BoxPdfAnnotationManager$replaceAnnotationsFromServer$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxPdfAnnotationManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.annotations.managers.BoxPdfAnnotationManager$replaceAnnotationsFromServer$2", f = "BoxPdfAnnotationManager.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {396, 129, Token.LABEL}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$this$forEach$iv", "element$iv", "it", "$i$f$withLock", "$i$a$-withLock$default-BoxPdfAnnotationManager$replaceAnnotationsFromServer$2$1", "$i$f$forEach", "$i$a$-forEach-BoxPdfAnnotationManager$replaceAnnotationsFromServer$2$1$1", "$this$withLock_u24default$iv", "$this$forEach$iv", "element$iv", "it", "$i$f$withLock", "$i$a$-withLock$default-BoxPdfAnnotationManager$replaceAnnotationsFromServer$2$1", "$i$f$forEach", "$i$a$-forEach-BoxPdfAnnotationManager$replaceAnnotationsFromServer$2$1$2"}, s = {"L$0", "I$0", "L$0", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<AnnotationWithLocation> $newAnnotations;
        final /* synthetic */ List<AnnotationWithLocation> $previousForPdf;
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
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<AnnotationWithLocation> list, List<AnnotationWithLocation> list2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$previousForPdf = list;
            this.$newAnnotations = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxPdfAnnotationManager.this.new AnonymousClass2(this.$previousForPdf, this.$newAnnotations, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00c3 A[Catch: all -> 0x0155, TryCatch #0 {all -> 0x0155, blocks: (B:36:0x0113, B:38:0x0119, B:41:0x014d, B:26:0x00bd, B:28:0x00c3, B:32:0x00f8, B:34:0x0102, B:35:0x0107), top: B:50:0x00bd }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00f4  */
        /* JADX WARN: Code duplicated, block: B:31:0x00f5 A[PHI: r2 r5 r8 r9 r10 r11 r12 r13 r14
          0x00f5: PHI (r2v11 int) = (r2v6 int), (r2v14 int) binds: [B:29:0x00f2, B:16:0x0063] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r5v7 int) = (r5v5 int), (r5v11 int) binds: [B:29:0x00f2, B:16:0x0063] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r8v5 int) = (r8v3 int), (r8v9 int) binds: [B:29:0x00f2, B:16:0x0063] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r9v6 java.util.Iterator) = (r9v4 java.util.Iterator), (r9v13 java.util.Iterator) binds: [B:29:0x00f2, B:16:0x0063] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r10v5 java.lang.Iterable) = (r10v3 java.lang.Iterable), (r10v10 java.lang.Iterable) binds: [B:29:0x00f2, B:16:0x0063] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r11v5 kotlinx.coroutines.sync.Mutex) = (r11v4 kotlinx.coroutines.sync.Mutex), (r11v13 kotlinx.coroutines.sync.Mutex) binds: [B:29:0x00f2, B:16:0x0063] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r12v4 java.util.List<com.box.android.preview.annotations.model.AnnotationWithLocation>) = 
          (r12v2 java.util.List<com.box.android.preview.annotations.model.AnnotationWithLocation>)
          (r12v9 java.util.List<com.box.android.preview.annotations.model.AnnotationWithLocation>)
         binds: [B:29:0x00f2, B:16:0x0063] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r13v2 com.box.android.preview.annotations.managers.BoxPdfAnnotationManager) = 
          (r13v1 com.box.android.preview.annotations.managers.BoxPdfAnnotationManager)
          (r13v5 com.box.android.preview.annotations.managers.BoxPdfAnnotationManager)
         binds: [B:29:0x00f2, B:16:0x0063] A[DONT_GENERATE, DONT_INLINE]
          0x00f5: PHI (r14v2 java.lang.Object) = (r14v1 java.lang.Object), (r14v6 java.lang.Object) binds: [B:29:0x00f2, B:16:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f2 -> B:31:0x00f5). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 350
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.annotations.managers.BoxPdfAnnotationManager.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void addAnnotationWithoutPersistingToDocument(AnnotationWithLocation annotationWithLocation) {
        Float widthScalingFactorForPage;
        super.addAnnotation(annotationWithLocation);
        if ((annotationWithLocation.getAnnotation() instanceof PdfRegionAnnotation) && (annotationWithLocation.getLocationModel() instanceof AnnotationLocationModel.Page)) {
            PdfAnnotationScaleValueProvider pdfAnnotationScaleValueProvider = this.pdfAnnotationScaleValueProvider;
            if (pdfAnnotationScaleValueProvider != null && (widthScalingFactorForPage = pdfAnnotationScaleValueProvider.getWidthScalingFactorForPage(((AnnotationLocationModel.Page) annotationWithLocation.getLocationModel()).getPageNumber() - 1)) != null) {
                ((PdfRegionAnnotation) annotationWithLocation.getAnnotation()).setWidthScalingFactor(widthScalingFactorForPage.floatValue());
            }
            int pageNumber = ((AnnotationLocationModel.Page) annotationWithLocation.getLocationModel()).getPageNumber();
            if (pageNumber >= 1) {
                Object annotation = annotationWithLocation.getAnnotation();
                Intrinsics.checkNotNull(annotation, "null cannot be cast to non-null type com.pspdfkit.ui.drawable.PdfDrawable");
                addDrawable((PdfDrawable) annotation, pageNumber - 1);
                return;
            }
            return;
        }
        if (annotationWithLocation.getAnnotation() instanceof PdfTextSelectionAnnotation) {
            if (this.fragment != null) {
                setFlagsOnAnnotation((com.pspdfkit.annotations.Annotation) annotationWithLocation.getAnnotation());
            }
        } else {
            if (!(annotationWithLocation.getAnnotation() instanceof PdfDrawingAnnotation) || this.fragment == null) {
                return;
            }
            addPdfDrawingAnnotationWithoutPersisting(annotationWithLocation);
        }
    }

    private final void addPdfDrawingAnnotationWithoutPersisting(AnnotationWithLocation annotationWithLocation) {
        int pageNumber;
        PdfAnnotationScaleValueProvider pdfAnnotationScaleValueProvider;
        Float widthScalingFactorForPage;
        Annotation annotation = annotationWithLocation.getAnnotation();
        Intrinsics.checkNotNull(annotation, "null cannot be cast to non-null type com.box.android.preview.annotations.PdfDrawingAnnotation");
        PdfDrawingAnnotation pdfDrawingAnnotation = (PdfDrawingAnnotation) annotation;
        for (InkAnnotation inkAnnotation : pdfDrawingAnnotation.getInkAnnotations()) {
            if (MathKt.roundToInt(inkAnnotation.getLineWidth()) - inkAnnotation.getLineWidth() == 0.0f && (pdfAnnotationScaleValueProvider = this.pdfAnnotationScaleValueProvider) != null && (widthScalingFactorForPage = pdfAnnotationScaleValueProvider.getWidthScalingFactorForPage(inkAnnotation.getPageIndex())) != null) {
                inkAnnotation.setLineWidth(inkAnnotation.getLineWidth() * widthScalingFactorForPage.floatValue());
            }
            setFlagsOnAnnotation(inkAnnotation);
        }
        if (!(annotationWithLocation.getLocationModel() instanceof AnnotationLocationModel.Page) || (pageNumber = ((AnnotationLocationModel.Page) annotationWithLocation.getLocationModel()).getPageNumber()) < 1) {
            return;
        }
        addDrawable(pdfDrawingAnnotation.getSelectedShadowRect(), pageNumber - 1);
    }

    private final boolean needsPersistingToPdfDocument(Annotation annotation) {
        return (annotation instanceof PdfTextSelectionAnnotation) || (annotation instanceof PdfDrawingAnnotation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object addAnnotationToPage(com.pspdfkit.annotations.Annotation annotation, Continuation<? super Unit> continuation) {
        C16651 c16651;
        PdfDocument document;
        AnnotationProvider annotationProvider;
        if (continuation instanceof C16651) {
            c16651 = (C16651) continuation;
            if ((c16651.label & Integer.MIN_VALUE) != 0) {
                c16651.label -= Integer.MIN_VALUE;
            } else {
                c16651 = new C16651(continuation);
            }
        } else {
            c16651 = new C16651(continuation);
        }
        Object obj = c16651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16651.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PdfFragment pdfFragment = getFragment().getPdfFragment();
            if (pdfFragment != null && (document = pdfFragment.getDocument()) != null && (annotationProvider = document.getAnnotationProvider()) != null) {
                c16651.L$0 = annotation;
                c16651.label = 1;
                if (annotationProvider.addAnnotationToPage(annotation, c16651) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            annotation = (com.pspdfkit.annotations.Annotation) c16651.L$0;
            ResultKt.throwOnFailure(obj);
        }
        PdfFragment pdfFragment2 = getFragment().getPdfFragment();
        if (pdfFragment2 != null) {
            pdfFragment2.notifyAnnotationHasChanged(annotation);
        }
        PdfFragment pdfFragment3 = getFragment().getPdfFragment();
        if (pdfFragment3 != null) {
            AnnotationUtils.INSTANCE.clearUndoRedoHistory(pdfFragment3);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:? A[LOOP:0: B:26:0x009a->B:36:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:
    
        if (addAnnotationToPage((com.pspdfkit.annotations.Annotation) r13, r0) == r1) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object persistAnnotationToDocument(com.box.android.preview.annotations.model.AnnotationWithLocation r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.annotations.managers.BoxPdfAnnotationManager.persistAnnotationToDocument(com.box.android.preview.annotations.model.AnnotationWithLocation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:34:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:47:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00af A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0102 -> B:44:0x0104). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:48:0x00c6
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object removeAnnotationFromDocument(com.box.android.preview.annotations.model.AnnotationWithLocation r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.annotations.managers.BoxPdfAnnotationManager.removeAnnotationFromDocument(com.box.android.preview.annotations.model.AnnotationWithLocation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void addDrawable(PdfDrawable pdfDrawable, int pageIndex) {
        ArrayList arrayList = this.drawableMap.get(Integer.valueOf(pageIndex));
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(pdfDrawable);
        this.drawableMap.put(Integer.valueOf(pageIndex), arrayList);
        notifyDrawablesChanged();
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public void removeAllAnnotations() {
        replaceAnnotationsFromServer(CollectionsKt.emptyList());
    }

    public final void removeAllDrawables() {
        this.drawableMap.clear();
        notifyDrawablesChanged();
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableProvider
    public Object getDrawablesForPage(Context context, PdfDocument pdfDocument, int i, Continuation<? super List<? extends PdfDrawable>> continuation) {
        ArrayList arrayList = this.drawableMap.get(Boxing.boxInt(i));
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (getAnnotationVisibility()) {
            return CollectionsKt.toMutableList((Collection) arrayList);
        }
        return new ArrayList();
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public List<Annotation> getAnnotationsForLocation(AnnotationLocationModel location) {
        Intrinsics.checkNotNullParameter(location, "location");
        List<AnnotationWithLocation> annotations = getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (Object obj : annotations) {
            if (Intrinsics.areEqual(((AnnotationWithLocation) obj).getLocationModel(), location)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((AnnotationWithLocation) it.next()).getAnnotation());
        }
        return CollectionsKt.toList(arrayList3);
    }

    private final void clearInterSections(List<? extends Annotation> annotationList) {
        if (annotationList != null) {
            for (Annotation annotation : annotationList) {
                if (annotation instanceof PdfRegionAnnotation) {
                    ((PdfRegionAnnotation) annotation).clearIntersection();
                }
            }
        }
    }

    private final void markIntersections(List<? extends Annotation> annotationList, Annotation selectedAnnotation) {
        if (annotationList == null || !(selectedAnnotation instanceof PdfRegionAnnotation)) {
            return;
        }
        for (Annotation annotation : annotationList) {
            if (!Intrinsics.areEqual(annotation, selectedAnnotation)) {
                RectF intersectionIfAny = getIntersectionIfAny(annotation.getBoundingRect(), ((PdfRegionAnnotation) selectedAnnotation).getBoundingRect());
                if (intersectionIfAny != null && (annotation instanceof PdfRegionAnnotation)) {
                    ((PdfRegionAnnotation) annotation).setIntersectingRect(intersectionIfAny);
                }
            }
        }
    }

    private final void onAnnotationSelected(Annotation selectedAnnotation, AnnotationLocationModel location) {
        List<Annotation> annotationsForLocation = getAnnotationsForLocation(location);
        clearInterSections(annotationsForLocation);
        markIntersections(annotationsForLocation, selectedAnnotation);
        notifyAnnotationsChanged();
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public Annotation selectAnnotationContainingPoint(PointF point, AnnotationLocationModel location) {
        Intrinsics.checkNotNullParameter(point, "point");
        Intrinsics.checkNotNullParameter(location, "location");
        Annotation annotationSelectAnnotationContainingPoint = super.selectAnnotationContainingPoint(point, location);
        if (annotationSelectAnnotationContainingPoint != null) {
            onAnnotationSelected(annotationSelectAnnotationContainingPoint, location);
        }
        return annotationSelectAnnotationContainingPoint;
    }

    public final boolean navigateToAnnotation(final String annotationId) {
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        if (this.fragment == null) {
            return false;
        }
        final PdfFragment pdfFragment = getFragment().getPdfFragment();
        Object obj = null;
        if ((pdfFragment != null ? pdfFragment.getDocument() : null) == null) {
            return false;
        }
        for (Object obj2 : getAnnotations()) {
            if (Intrinsics.areEqual(((AnnotationWithLocation) obj2).getAnnotation().getAnnotationId(), annotationId)) {
                obj = obj2;
                break;
            }
        }
        final AnnotationWithLocation annotationWithLocation = (AnnotationWithLocation) obj;
        if (annotationWithLocation == null) {
            return false;
        }
        pdfFragment.requireView().post(new Runnable() { // from class: com.box.android.preview.annotations.managers.BoxPdfAnnotationManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BoxPdfAnnotationManager.navigateToAnnotation$lambda$1(this.f$0, annotationId, annotationWithLocation, pdfFragment);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateToAnnotation$lambda$1(BoxPdfAnnotationManager boxPdfAnnotationManager, String str, AnnotationWithLocation annotationWithLocation, PdfFragment pdfFragment) {
        boxPdfAnnotationManager.selectAnnotationWithId(str, annotationWithLocation.getLocationModel());
        AnnotationLocationModel locationModel = annotationWithLocation.getLocationModel();
        if (locationModel instanceof AnnotationLocationModel.Page) {
            pdfFragment.setPageIndex(((AnnotationLocationModel.Page) locationModel).getPageNumber() - 1, false);
        }
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public Annotation selectAnnotationWithId(String annotationId, AnnotationLocationModel location) {
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        Intrinsics.checkNotNullParameter(location, "location");
        Annotation annotationSelectAnnotationWithId = super.selectAnnotationWithId(annotationId, location);
        if (annotationSelectAnnotationWithId != null) {
            onAnnotationSelected(annotationSelectAnnotationWithId, location);
        }
        return annotationSelectAnnotationWithId;
    }

    @Override // com.box.android.preview.annotations.managers.BoxAnnotationManager
    public void notifyAnnotationsChanged() {
        notifyDrawablesChanged();
        for (AnnotationWithLocation annotationWithLocation : getAnnotations()) {
            if (annotationWithLocation.getAnnotation() instanceof HighlightAnnotation) {
                PdfFragment pdfFragment = getFragment().getPdfFragment();
                if (pdfFragment != null) {
                    pdfFragment.notifyAnnotationHasChanged((com.pspdfkit.annotations.Annotation) annotationWithLocation.getAnnotation());
                }
            } else if (annotationWithLocation.getAnnotation() instanceof PdfDrawingAnnotation) {
                for (InkAnnotation inkAnnotation : ((PdfDrawingAnnotation) annotationWithLocation.getAnnotation()).getInkAnnotations()) {
                    PdfFragment pdfFragment2 = getFragment().getPdfFragment();
                    if (pdfFragment2 != null) {
                        pdfFragment2.notifyAnnotationHasChanged(inkAnnotation);
                    }
                }
            }
        }
    }
}
