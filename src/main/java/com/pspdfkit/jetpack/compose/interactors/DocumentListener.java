package com.pspdfkit.jetpack.compose.interactors;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.PdfDocument;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001BÍ\u0002\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u00124\b\u0002\u0010\u000f\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016\u0012\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\"\b\u0002\u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019\u0012\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dR\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR%\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R!\u0010\u000e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR=\u0010\u000f\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R%\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R+\u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R%\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"¨\u0006."}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/DocumentListener;", "", "onDocumentLoaded", "Lkotlin/Function1;", "Lcom/pspdfkit/document/PdfDocument;", "", "onDocumentLoadFailed", "", "onDocumentSave", "Lkotlin/Function2;", "Lcom/pspdfkit/document/DocumentSaveOptions;", "", "onDocumentSaved", "onDocumentSaveFailed", "onDocumentSaveCancelled", "onPageClick", "Lkotlin/Function5;", "", "Landroid/view/MotionEvent;", "Landroid/graphics/PointF;", "Lcom/pspdfkit/annotations/Annotation;", "onDocumentClick", "Lkotlin/Function0;", "onPageChanged", "onDocumentZoomed", "Lkotlin/Function3;", "", "onPageUpdated", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "getOnDocumentLoaded", "()Lkotlin/jvm/functions/Function1;", "getOnDocumentLoadFailed", "getOnDocumentSave", "()Lkotlin/jvm/functions/Function2;", "getOnDocumentSaved", "getOnDocumentSaveFailed", "getOnDocumentSaveCancelled", "getOnPageClick", "()Lkotlin/jvm/functions/Function5;", "getOnDocumentClick", "()Lkotlin/jvm/functions/Function0;", "getOnPageChanged", "getOnDocumentZoomed", "()Lkotlin/jvm/functions/Function3;", "getOnPageUpdated", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DocumentListener {
    public static final int $stable = 0;
    private final Function0<Boolean> onDocumentClick;
    private final Function1<Throwable, Unit> onDocumentLoadFailed;
    private final Function1<PdfDocument, Unit> onDocumentLoaded;
    private final Function2<PdfDocument, DocumentSaveOptions, Boolean> onDocumentSave;
    private final Function1<PdfDocument, Unit> onDocumentSaveCancelled;
    private final Function2<PdfDocument, Throwable, Unit> onDocumentSaveFailed;
    private final Function1<PdfDocument, Unit> onDocumentSaved;
    private final Function3<PdfDocument, Integer, Float, Unit> onDocumentZoomed;
    private final Function2<PdfDocument, Integer, Unit> onPageChanged;
    private final Function5<PdfDocument, Integer, MotionEvent, PointF, Annotation, Boolean> onPageClick;
    private final Function2<PdfDocument, Integer, Unit> onPageUpdated;

    public DocumentListener() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public final Function0<Boolean> getOnDocumentClick() {
        return this.onDocumentClick;
    }

    public final Function1<Throwable, Unit> getOnDocumentLoadFailed() {
        return this.onDocumentLoadFailed;
    }

    public final Function1<PdfDocument, Unit> getOnDocumentLoaded() {
        return this.onDocumentLoaded;
    }

    public final Function2<PdfDocument, DocumentSaveOptions, Boolean> getOnDocumentSave() {
        return this.onDocumentSave;
    }

    public final Function1<PdfDocument, Unit> getOnDocumentSaveCancelled() {
        return this.onDocumentSaveCancelled;
    }

    public final Function2<PdfDocument, Throwable, Unit> getOnDocumentSaveFailed() {
        return this.onDocumentSaveFailed;
    }

    public final Function1<PdfDocument, Unit> getOnDocumentSaved() {
        return this.onDocumentSaved;
    }

    public final Function3<PdfDocument, Integer, Float, Unit> getOnDocumentZoomed() {
        return this.onDocumentZoomed;
    }

    public final Function2<PdfDocument, Integer, Unit> getOnPageChanged() {
        return this.onPageChanged;
    }

    public final Function5<PdfDocument, Integer, MotionEvent, PointF, Annotation, Boolean> getOnPageClick() {
        return this.onPageClick;
    }

    public final Function2<PdfDocument, Integer, Unit> getOnPageUpdated() {
        return this.onPageUpdated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DocumentListener(Function1<? super PdfDocument, Unit> function1, Function1<? super Throwable, Unit> function2, Function2<? super PdfDocument, ? super DocumentSaveOptions, Boolean> function3, Function1<? super PdfDocument, Unit> function4, Function2<? super PdfDocument, ? super Throwable, Unit> function5, Function1<? super PdfDocument, Unit> function6, Function5<? super PdfDocument, ? super Integer, ? super MotionEvent, ? super PointF, ? super Annotation, Boolean> function7, Function0<Boolean> function0, Function2<? super PdfDocument, ? super Integer, Unit> function8, Function3<? super PdfDocument, ? super Integer, ? super Float, Unit> function9, Function2<? super PdfDocument, ? super Integer, Unit> function10) {
        this.onDocumentLoaded = function1;
        this.onDocumentLoadFailed = function2;
        this.onDocumentSave = function3;
        this.onDocumentSaved = function4;
        this.onDocumentSaveFailed = function5;
        this.onDocumentSaveCancelled = function6;
        this.onPageClick = function7;
        this.onDocumentClick = function0;
        this.onPageChanged = function8;
        this.onDocumentZoomed = function9;
        this.onPageUpdated = function10;
    }

    public /* synthetic */ DocumentListener(Function1 function1, Function1 function2, Function2 function3, Function1 function4, Function2 function5, Function1 function6, Function5 function7, Function0 function0, Function2 function8, Function3 function9, Function2 function10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? null : function3, (i & 8) != 0 ? null : function4, (i & 16) != 0 ? null : function5, (i & 32) != 0 ? null : function6, (i & 64) != 0 ? null : function7, (i & 128) != 0 ? null : function0, (i & 256) != 0 ? null : function8, (i & 512) != 0 ? null : function9, (i & 1024) != 0 ? null : function10);
    }
}
