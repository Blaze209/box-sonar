package com.pspdfkit.ui.note;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.ww;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J,\u0010#\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/pspdfkit/ui/note/AnnotationNoteHinter;", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "Lcom/pspdfkit/annotations/AnnotationProvider$OnAnnotationUpdatedListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "annotationNoteHinterThemeConfiguration", "Lcom/pspdfkit/ui/note/AnnotationNoteHinterThemeConfiguration;", "noteIcon", "Landroid/graphics/drawable/Drawable;", "commentThreadIcon", "drawableCache", "Landroidx/collection/SparseArrayCompat;", "", "Lcom/pspdfkit/ui/note/NoteHinterDrawable;", "cacheMutex", "Lkotlinx/coroutines/sync/Mutex;", "getDrawablesForPage", "Lcom/pspdfkit/ui/drawable/PdfDrawable;", "document", "Lcom/pspdfkit/document/PdfDocument;", "pageIndex", "", "(Landroid/content/Context;Lcom/pspdfkit/document/PdfDocument;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDrawableForAnnotation", "annotation", "Lcom/pspdfkit/annotations/Annotation;", "findCachedDrawableForAnnotation", "cachedDrawables", "notifyDrawablesChangedIfSupported", "", "onAnnotationCreated", "onAnnotationUpdated", "onAnnotationRemoved", "onAnnotationZOrderChanged", "oldOrder", "newOrder", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationNoteHinter extends PdfDrawableProvider implements AnnotationProvider.OnAnnotationUpdatedListener {
    public static final int $stable = 8;
    private final AnnotationNoteHinterThemeConfiguration annotationNoteHinterThemeConfiguration;
    private final Mutex cacheMutex;
    private final Drawable commentThreadIcon;
    private final SparseArrayCompat<List<NoteHinterDrawable>> drawableCache;
    private final Drawable noteIcon;

    /* JADX INFO: renamed from: com.pspdfkit.ui.note.AnnotationNoteHinter$getDrawablesForPage$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.note.AnnotationNoteHinter", f = "AnnotationNoteHinter.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {49, 182}, m = "getDrawablesForPage", n = {"context", "document", "noteIcon", "pageIndex", "context", "document", "noteIcon", "annotations", "$this$withLock_u24default$iv", "pageIndex", "$i$f$withLock"}, nl = {51, 183}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnnotationNoteHinter.this.getDrawablesForPage(null, null, 0, this);
        }
    }

    public AnnotationNoteHinter(Context context) {
        context.getClass();
        AnnotationNoteHinterThemeConfiguration annotationNoteHinterThemeConfiguration = new AnnotationNoteHinterThemeConfiguration(context);
        this.annotationNoteHinterThemeConfiguration = annotationNoteHinterThemeConfiguration;
        this.noteIcon = ContextCompat.getDrawable(context, annotationNoteHinterThemeConfiguration.noteHinterDrawable);
        this.commentThreadIcon = ContextCompat.getDrawable(context, annotationNoteHinterThemeConfiguration.instantCommentHinterDrawable);
        this.drawableCache = new SparseArrayCompat<>(0, 1, null);
        this.cacheMutex = MutexKt.Mutex$default(false, 1, null);
    }

    private final NoteHinterDrawable createDrawableForAnnotation(Annotation annotation, Drawable noteIcon) {
        if (annotation.getInternal().isInstantCommentThreadRoot()) {
            Drawable drawable = this.commentThreadIcon;
            if (drawable != null) {
                noteIcon = drawable;
            }
            return new NoteTextMarkupAnnotationHinterDrawable(noteIcon, annotation, this.annotationNoteHinterThemeConfiguration);
        }
        if (SetsKt.setOf((Object[]) new AnnotationType[]{AnnotationType.INK, AnnotationType.POLYGON, AnnotationType.POLYLINE}).contains(annotation.getType())) {
            return new NoteMultilineAnnotationHinterDrawable(noteIcon, annotation, this.annotationNoteHinterThemeConfiguration);
        }
        if (annotation instanceof BaseRectsAnnotation) {
            return new NoteTextMarkupAnnotationHinterDrawable(noteIcon, annotation, this.annotationNoteHinterThemeConfiguration);
        }
        if (annotation.getType() == AnnotationType.LINE) {
            return new NoteLineAnnotationHinterDrawable(noteIcon, annotation, this.annotationNoteHinterThemeConfiguration);
        }
        if (SetsKt.setOf((Object[]) new AnnotationType[]{AnnotationType.SQUARE, AnnotationType.CIRCLE}).contains(annotation.getType())) {
            return new NoteShapeAnnotationHinterDrawable(noteIcon, annotation, this.annotationNoteHinterThemeConfiguration);
        }
        if (annotation.getType() == AnnotationType.STAMP) {
            return new NoteStampAnnotationHinterDrawable(noteIcon, annotation, this.annotationNoteHinterThemeConfiguration);
        }
        return null;
    }

    private final NoteHinterDrawable findCachedDrawableForAnnotation(List<? extends NoteHinterDrawable> cachedDrawables, Annotation annotation) {
        if (cachedDrawables == null) {
            return null;
        }
        for (NoteHinterDrawable noteHinterDrawable : cachedDrawables) {
            if (noteHinterDrawable.annotation == annotation) {
                return noteHinterDrawable;
            }
        }
        return null;
    }

    private final void notifyDrawablesChangedIfSupported(Annotation annotation) {
        if (ww.g(annotation)) {
            notifyDrawablesChanged(annotation.getPageIndex());
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00cb A[Catch: all -> 0x0135, TryCatch #0 {all -> 0x0135, blocks: (B:28:0x00b5, B:29:0x00c5, B:31:0x00cb, B:33:0x00d7, B:35:0x00dd, B:38:0x00e7, B:36:0x00e1, B:39:0x00ef, B:41:0x00f5, B:42:0x00fe, B:44:0x0104, B:46:0x0111, B:47:0x0115, B:49:0x011b, B:50:0x0127), top: B:56:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00dd A[Catch: all -> 0x0135, TryCatch #0 {all -> 0x0135, blocks: (B:28:0x00b5, B:29:0x00c5, B:31:0x00cb, B:33:0x00d7, B:35:0x00dd, B:38:0x00e7, B:36:0x00e1, B:39:0x00ef, B:41:0x00f5, B:42:0x00fe, B:44:0x0104, B:46:0x0111, B:47:0x0115, B:49:0x011b, B:50:0x0127), top: B:56:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00e1 A[Catch: all -> 0x0135, TryCatch #0 {all -> 0x0135, blocks: (B:28:0x00b5, B:29:0x00c5, B:31:0x00cb, B:33:0x00d7, B:35:0x00dd, B:38:0x00e7, B:36:0x00e1, B:39:0x00ef, B:41:0x00f5, B:42:0x00fe, B:44:0x0104, B:46:0x0111, B:47:0x0115, B:49:0x011b, B:50:0x0127), top: B:56:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00f5 A[Catch: all -> 0x0135, TryCatch #0 {all -> 0x0135, blocks: (B:28:0x00b5, B:29:0x00c5, B:31:0x00cb, B:33:0x00d7, B:35:0x00dd, B:38:0x00e7, B:36:0x00e1, B:39:0x00ef, B:41:0x00f5, B:42:0x00fe, B:44:0x0104, B:46:0x0111, B:47:0x0115, B:49:0x011b, B:50:0x0127), top: B:56:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0104 A[Catch: all -> 0x0135, TryCatch #0 {all -> 0x0135, blocks: (B:28:0x00b5, B:29:0x00c5, B:31:0x00cb, B:33:0x00d7, B:35:0x00dd, B:38:0x00e7, B:36:0x00e1, B:39:0x00ef, B:41:0x00f5, B:42:0x00fe, B:44:0x0104, B:46:0x0111, B:47:0x0115, B:49:0x011b, B:50:0x0127), top: B:56:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x011b A[Catch: all -> 0x0135, LOOP:2: B:48:0x0119->B:49:0x011b, LOOP_END, TryCatch #0 {all -> 0x0135, blocks: (B:28:0x00b5, B:29:0x00c5, B:31:0x00cb, B:33:0x00d7, B:35:0x00dd, B:38:0x00e7, B:36:0x00e1, B:39:0x00ef, B:41:0x00f5, B:42:0x00fe, B:44:0x0104, B:46:0x0111, B:47:0x0115, B:49:0x011b, B:50:0x0127), top: B:56:0x00b5 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.ui.drawable.PdfDrawableProvider
    public Object getDrawablesForPage(Context context, PdfDocument pdfDocument, int i, Continuation<? super List<? extends PdfDrawable>> continuation) {
        AnonymousClass1 anonymousClass1;
        Drawable drawable;
        int i2;
        List<Annotation> list;
        Drawable drawable2;
        Mutex mutex;
        List<NoteHinterDrawable> list2;
        List listCreateListBuilder;
        List listBuild;
        ArrayList arrayList;
        int size;
        NoteHinterDrawable noteHinterDrawableFindCachedDrawableForAnnotation;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i3 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = anonymousClass1.label;
        int i5 = 0;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            Drawable drawable3 = this.noteIcon;
            if (drawable3 == null) {
                return CollectionsKt.emptyList();
            }
            AnnotationProvider annotationProvider = pdfDocument.getAnnotationProvider();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(pdfDocument);
            anonymousClass1.L$2 = drawable3;
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            Object annotations = annotationProvider.getAnnotations(i, anonymousClass1);
            if (annotations != coroutine_suspended) {
                drawable = drawable3;
                obj = annotations;
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            i = anonymousClass1.I$0;
            Drawable drawable4 = (Drawable) anonymousClass1.L$2;
            pdfDocument = (PdfDocument) anonymousClass1.L$1;
            Context context2 = (Context) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            drawable = drawable4;
            context = context2;
        } else {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i2 = anonymousClass1.I$0;
            mutex = (Mutex) anonymousClass1.L$4;
            list = (List) anonymousClass1.L$3;
            drawable2 = (Drawable) anonymousClass1.L$2;
            ResultKt.throwOnFailure(obj);
        }
        try {
            list2 = this.drawableCache.get(i2);
            listCreateListBuilder = CollectionsKt.createListBuilder();
            for (Annotation annotation : list) {
                if (!ww.g(annotation)) {
                    noteHinterDrawableFindCachedDrawableForAnnotation = findCachedDrawableForAnnotation(list2, annotation);
                    if (noteHinterDrawableFindCachedDrawableForAnnotation != null) {
                        noteHinterDrawableFindCachedDrawableForAnnotation.refresh();
                    } else {
                        noteHinterDrawableFindCachedDrawableForAnnotation = createDrawableForAnnotation(annotation, drawable2);
                    }
                    if (noteHinterDrawableFindCachedDrawableForAnnotation != null) {
                        Boxing.boxBoolean(listCreateListBuilder.add(noteHinterDrawableFindCachedDrawableForAnnotation));
                    }
                }
            }
            listBuild = CollectionsKt.build(listCreateListBuilder);
            if (list2 != null) {
                arrayList = new ArrayList();
                for (Object obj2 : list2) {
                    if (!listBuild.contains((NoteHinterDrawable) obj2)) {
                        arrayList.add(obj2);
                    }
                }
                size = arrayList.size();
                while (i5 < size) {
                    Object obj3 = arrayList.get(i5);
                    i5++;
                    ((NoteHinterDrawable) obj3).dispose();
                }
            }
            this.drawableCache.put(i2, new ArrayList(listBuild));
            return listBuild;
        } finally {
            mutex.unlock(null);
        }
        List list3 = (List) obj;
        Mutex mutex2 = this.cacheMutex;
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(context);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(pdfDocument);
        anonymousClass1.L$2 = drawable;
        anonymousClass1.L$3 = list3;
        anonymousClass1.L$4 = mutex2;
        anonymousClass1.I$0 = i;
        anonymousClass1.I$1 = 0;
        anonymousClass1.label = 2;
        if (mutex2.lock(null, anonymousClass1) != coroutine_suspended) {
            i2 = i;
            list = list3;
            drawable2 = drawable;
            mutex = mutex2;
            list2 = this.drawableCache.get(i2);
            listCreateListBuilder = CollectionsKt.createListBuilder();
            while (r12.hasNext()) {
                if (!ww.g(annotation)) {
                    noteHinterDrawableFindCachedDrawableForAnnotation = findCachedDrawableForAnnotation(list2, annotation);
                    if (noteHinterDrawableFindCachedDrawableForAnnotation != null) {
                        noteHinterDrawableFindCachedDrawableForAnnotation.refresh();
                    } else {
                        noteHinterDrawableFindCachedDrawableForAnnotation = createDrawableForAnnotation(annotation, drawable2);
                    }
                    if (noteHinterDrawableFindCachedDrawableForAnnotation != null) {
                        Boxing.boxBoolean(listCreateListBuilder.add(noteHinterDrawableFindCachedDrawableForAnnotation));
                    }
                }
            }
            listBuild = CollectionsKt.build(listCreateListBuilder);
            if (list2 != null) {
                arrayList = new ArrayList();
                while (r13.hasNext()) {
                    if (!listBuild.contains((NoteHinterDrawable) obj2)) {
                        arrayList.add(obj2);
                    }
                }
                size = arrayList.size();
                while (i5 < size) {
                    Object obj4 = arrayList.get(i5);
                    i5++;
                    ((NoteHinterDrawable) obj4).dispose();
                }
            }
            this.drawableCache.put(i2, new ArrayList(listBuild));
            return listBuild;
        }
        return coroutine_suspended;
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public void onAnnotationCreated(Annotation annotation) {
        annotation.getClass();
        notifyDrawablesChangedIfSupported(annotation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public void onAnnotationRemoved(Annotation annotation) {
        annotation.getClass();
        notifyDrawablesChangedIfSupported(annotation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public void onAnnotationUpdated(Annotation annotation) {
        annotation.getClass();
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public void onAnnotationZOrderChanged(int pageIndex, List<? extends Annotation> oldOrder, List<? extends Annotation> newOrder) {
        oldOrder.getClass();
        newOrder.getClass();
        notifyDrawablesChanged();
    }
}
