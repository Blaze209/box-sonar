package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Looper;
import com.pspdfkit.Nutrient;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.configuration.annotations.CopyPasteFeatures;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.annotations.AnnotationAddRemoveEdit;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class wb implements ub {
    public final lm a;
    public final PdfFragment b;
    public final d1 c;
    public final boolean d;
    public PointF e;
    public int f;
    public final lf<Edit> g;
    public final boolean h;

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.clipboard.CopyPasteManagerImpl$cutAnnotations$1$1$1", f = "CopyPasteManagerImpl.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ o3 b;
        public final /* synthetic */ Annotation c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o3 o3Var, Annotation annotation, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = o3Var;
            this.c = annotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 o3Var = this.b;
                Annotation annotation = this.c;
                this.a = 1;
                if (o3Var.removeAnnotationFromPage(annotation, this) == coroutine_suspended) {
                    return coroutine_suspended;
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

    public wb(lm lmVar, PdfFragment pdfFragment) {
        d1 d1Var;
        this.a = lmVar;
        this.b = pdfFragment;
        synchronized (ar.class) {
            if (ar.h == null) {
                ar.h = new d1();
            }
            d1Var = ar.h;
        }
        d1Var.getClass();
        this.c = d1Var;
        this.d = pdfFragment.getConfiguration().getEnabledCopyPasteFeatures().contains(CopyPasteFeatures.CROSS_DOCUMENT_COPY_PASTE);
        this.f = -1;
        this.g = new lf<>(pdfFragment.getRecordedListener());
        this.h = ar.b().c(pdfFragment.getConfiguration());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(wb wbVar, Annotation annotation, int i, Matrix matrix, lf lfVar, ContinuationImpl continuationImpl) {
        xb xbVar;
        Annotation annotation2;
        if (continuationImpl instanceof xb) {
            xbVar = (xb) continuationImpl;
            int i2 = xbVar.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                xbVar.f = i2 - Integer.MIN_VALUE;
            } else {
                xbVar = new xb(wbVar, continuationImpl);
            }
        } else {
            xbVar = new xb(wbVar, continuationImpl);
        }
        xb xbVar2 = xbVar;
        Object obj = xbVar2.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = xbVar2.f;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            annotation.getInternal().setPageIndex(i);
            o3 annotationProvider = wbVar.a.getAnnotationProvider();
            xbVar2.a = annotation;
            xbVar2.b = matrix;
            xbVar2.c = lfVar;
            xbVar2.f = 1;
            Object objA = annotationProvider.a(annotation, (Integer) null, (Integer) null, false, (Continuation<? super Unit>) xbVar2);
            if (objA != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                objA = Unit.INSTANCE;
            }
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            annotation2 = annotation;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lfVar = xbVar2.c;
            matrix = xbVar2.b;
            annotation2 = xbVar2.a;
            ResultKt.throwOnFailure(obj);
        }
        RectF boundingBox = annotation2.getBoundingBox();
        RectF rectF = new RectF(boundingBox);
        matrix.mapRect(rectF);
        float f = rectF.top;
        rectF.top = rectF.bottom;
        rectF.bottom = f;
        annotation2.updateTransformationProperties(rectF, boundingBox);
        annotation2.setBoundingBox(rectF);
        AnnotationAddRemoveEdit annotationAddRemoveEdit = new AnnotationAddRemoveEdit(annotation2, AnnotationAddRemoveEdit.Type.ADD_ANNOTATION);
        lfVar.getClass();
        if (lfVar.b) {
            lfVar.c.add(annotationAddRemoveEdit);
        }
        return Unit.INSTANCE;
    }

    public static RectF c(ArrayList arrayList) {
        RectF rectF = new RectF(((Annotation) CollectionsKt.first((List) arrayList)).getBoundingBox());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            RectF boundingBox = ((Annotation) obj).getBoundingBox();
            rectF.set(RangesKt.coerceAtMost(rectF.left, boundingBox.left), RangesKt.coerceAtLeast(rectF.top, boundingBox.top), RangesKt.coerceAtLeast(rectF.right, boundingBox.right), RangesKt.coerceAtMost(rectF.bottom, boundingBox.bottom));
        }
        return rectF;
    }

    @Override // com.pspdfkit.internal.ub
    public final Completable b(final ArrayList arrayList) {
        Completable completableSubscribeOn = Completable.defer(new Supplier() { // from class: com.pspdfkit.internal.wb$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return wb.a(this.f$0, arrayList);
            }
        }).subscribeOn(this.a.b(5));
        completableSubscribeOn.getClass();
        return completableSubscribeOn;
    }

    @Override // com.pspdfkit.internal.ub
    public final boolean b(List<? extends Annotation> list) {
        list.getClass();
        if (list.isEmpty()) {
            return false;
        }
        final o3 annotationProvider = this.a.getAnnotationProvider();
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayListA = a(list, arrayList);
        if (arrayListA == null || arrayListA.isEmpty()) {
            return false;
        }
        annotationProvider.a(this.b.getRecordedListener(), new Runnable() { // from class: com.pspdfkit.internal.wb$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                wb.a(arrayList, annotationProvider);
            }
        });
        this.b.onAnnotationsCut(arrayListA);
        this.f = -1;
        this.e = null;
        return !arrayListA.isEmpty();
    }

    public static final CompletableSource b(wb wbVar, List list) {
        if (wbVar.b((List<? extends Annotation>) list)) {
            return Completable.complete();
        }
        return Completable.error(new IllegalStateException("Annotation could not be cut."));
    }

    @Override // com.pspdfkit.internal.ub
    public final boolean a(List<? extends Annotation> list) {
        RectF boundingBox;
        list.getClass();
        ArrayList arrayListA = a(list, new ArrayList());
        if (arrayListA == null) {
            return false;
        }
        if (arrayListA.size() > 1) {
            boundingBox = c(arrayListA);
        } else {
            boundingBox = ((Annotation) CollectionsKt.first((List) arrayListA)).getBoundingBox();
        }
        this.f = ((Annotation) CollectionsKt.first((List) arrayListA)).getPageIndex();
        this.e = kx.a(boundingBox);
        this.b.onAnnotationsCopied(arrayListA);
        return !arrayListA.isEmpty();
    }

    public final ArrayList a(List list, ArrayList arrayList) {
        Object t30Var;
        d1 d1Var = this.c;
        String str = this.a.B;
        d1Var.getClass();
        list.getClass();
        arrayList.clear();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            Annotation annotation = null;
            if (!it.hasNext()) {
                break;
            }
            Annotation annotation2 = (Annotation) it.next();
            Annotation copy = annotation2.getInternal().getCopy();
            if (copy != null) {
                arrayList.add(annotation2);
                annotation = copy;
            }
            if (annotation != null) {
                arrayList2.add(annotation);
            }
        }
        if (!arrayList2.isEmpty()) {
            ArrayList arrayList3 = d1Var.b;
            int size = arrayList3.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList3.get(i);
                i++;
                ((e1) obj).c();
            }
            d1Var.b.clear();
            d1Var.d = false;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size2 = arrayList2.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                Annotation annotation3 = (Annotation) obj2;
                annotation3.getClass();
                if (!annotation3.isAttached()) {
                    if (annotation3 instanceof FreeTextAnnotation) {
                        t30Var = new gi((FreeTextAnnotation) annotation3);
                    } else {
                        t30Var = annotation3 instanceof StampAnnotation ? new t30((StampAnnotation) annotation3) : new e1(annotation3, 0);
                    }
                    arrayList4.add(t30Var);
                } else {
                    throw new IllegalStateException("Annotation must be detached from document before it can be added to clipboard!");
                }
            }
            d1Var.b.addAll(arrayList4);
            d1Var.c = str;
            if (Nutrient.getApplicationPolicy().hasPermissionForEvent(ApplicationPolicy.PolicyEvent.ANNOTATION_COPY_PASTE_SYSTEM_INTEGRATION) && arrayList4.size() == 1) {
                d1Var.d = ((e1) CollectionsKt.first((List) arrayList4)).e();
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        return arrayList2;
    }

    public static final CompletableSource a(wb wbVar, List list) {
        if (wbVar.a((List<? extends Annotation>) list)) {
            return Completable.complete();
        }
        return Completable.error(new IllegalStateException("Annotation could not be copied."));
    }

    @Override // com.pspdfkit.internal.ub
    public final Completable a(final ArrayList arrayList) {
        Completable completableSubscribeOn = Completable.defer(new Supplier() { // from class: com.pspdfkit.internal.wb$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return wb.b(this.f$0, arrayList);
            }
        }).subscribeOn(this.a.b(5));
        completableSubscribeOn.getClass();
        return completableSubscribeOn;
    }

    @Override // com.pspdfkit.internal.ub
    public final Maybe<List<Annotation>> a(final int i) {
        Maybe<List<Annotation>> maybeSubscribeOn = Maybe.defer(new Supplier() { // from class: com.pspdfkit.internal.wb$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return wb.a(this.f$0, i);
            }
        }).subscribeOn(this.a.b(5));
        maybeSubscribeOn.getClass();
        return maybeSubscribeOn;
    }

    public static final MaybeSource a(wb wbVar, int i) throws InterruptedException {
        wbVar.getClass();
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ArrayList arrayListA = null;
            ArrayList arrayListA2 = (wbVar.d || Intrinsics.areEqual(wbVar.c.c, wbVar.a.B)) ? wbVar.c.a(wbVar.b.getAnnotationCreator()) : null;
            if (arrayListA2 != null) {
                RectF rectFC = c(arrayListA2);
                PointF pointFA = wbVar.e;
                if (pointFA != null && wbVar.f == i) {
                    pointFA.offset(20.0f, -20.0f);
                } else {
                    pointFA = kx.a(rectFC);
                }
                arrayListA = wbVar.a(i, pointFA, true);
            }
            if (arrayListA != null) {
                return Maybe.just(arrayListA);
            }
            return Maybe.empty();
        }
        throw new IllegalStateException("pasteAnnotations() may not be called from the main thread.");
    }

    public final ArrayList a(int i, PointF pointF, boolean z) throws InterruptedException {
        float fWidth;
        boolean z2;
        Float fValueOf;
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ArrayList arrayListA = (this.d || Intrinsics.areEqual(this.c.c, this.a.B)) ? this.c.a(this.b.getAnnotationCreator()) : null;
            if (arrayListA == null) {
                return null;
            }
            RectF rectFC = c(arrayListA);
            PointF pointFA = kx.a(rectFC);
            Size pageSize = this.a.getPageSize(i);
            float fWidth2 = rectFC.width();
            float f = pageSize.width;
            float fHeight = 1.0f;
            boolean z3 = false;
            if (fWidth2 > f) {
                fWidth = f / rectFC.width();
                z2 = true;
            } else {
                fWidth = 1.0f;
                z2 = false;
            }
            float f2 = -rectFC.height();
            float f3 = pageSize.height;
            if (f2 > f3) {
                fHeight = (-f3) / rectFC.height();
                z3 = true;
            }
            if (z2 || z3) {
                float fCoerceAtMost = RangesKt.coerceAtMost(fWidth, fHeight) * 0.95f;
                float f4 = 2;
                rectFC.inset((rectFC.width() - (rectFC.width() * fCoerceAtMost)) / f4, (rectFC.height() + ((-rectFC.height()) * fCoerceAtMost)) / f4);
                if (z2) {
                    pointF.x = pageSize.width / f4;
                }
                if (z3) {
                    pointF.y = pageSize.height / f4;
                }
                fValueOf = Float.valueOf(fCoerceAtMost);
            } else {
                fValueOf = null;
            }
            a(rectFC, pointF, pageSize, z);
            this.f = i;
            PointF pointFA2 = kx.a(rectFC);
            PointF pointF2 = new PointF(pointFA2.x - pointFA.x, pointFA2.y - pointFA.y);
            Matrix matrix = new Matrix();
            matrix.setTranslate(pointF2.x, pointF2.y);
            if (fValueOf != null) {
                matrix.postScale(fValueOf.floatValue(), fValueOf.floatValue(), pointFA2.x, pointFA2.y);
            }
            this.g.b = true;
            BuildersKt__BuildersKt.runBlocking$default(null, new yb(arrayListA, this, i, matrix, null), 1, null);
            this.g.c();
            this.b.onAnnotationsPasted(arrayListA);
            return arrayListA;
        }
        throw new IllegalStateException("pasteAnnotations() may not be called from the main thread.");
    }

    @Override // com.pspdfkit.internal.ub
    public final Maybe<List<Annotation>> a(final int i, final PointF pointF) {
        Maybe<List<Annotation>> maybeSubscribeOn = Maybe.defer(new Supplier() { // from class: com.pspdfkit.internal.wb$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return wb.a(this.f$0, i, pointF);
            }
        }).subscribeOn(this.a.b(5));
        maybeSubscribeOn.getClass();
        return maybeSubscribeOn;
    }

    public static final MaybeSource a(wb wbVar, int i, PointF pointF) throws InterruptedException {
        wbVar.getClass();
        pointF.getClass();
        ArrayList arrayListA = wbVar.a(i, pointF, false);
        if (arrayListA != null) {
            return Maybe.just(arrayListA);
        }
        return Maybe.empty();
    }

    @Override // com.pspdfkit.internal.ub
    public final boolean a() {
        if (!this.h) {
            return false;
        }
        if (!this.d && !Intrinsics.areEqual(this.c.c, this.a.B)) {
            return false;
        }
        d1 d1Var = this.c;
        if (d1Var.d) {
            return true;
        }
        ArrayList arrayList = d1Var.b;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (((e1) obj).b()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void a(RectF rectF, PointF pointF, Size size, boolean z) {
        float f = 2;
        rectF.offsetTo(pointF.x - (rectF.width() / f), pointF.y - (rectF.height() / f));
        PointF pointFA = kx.a(rectF);
        if (rectF.left < 0.0f) {
            a(rectF, new PointF(rectF.width() / f, pointF.y), size, z);
            return;
        }
        if (rectF.top > size.height) {
            a(rectF, new PointF(pointF.x, (rectF.height() / f) + size.height), size, z);
            return;
        }
        float f2 = rectF.right;
        float f3 = size.width;
        if (f2 > f3) {
            float fWidth = f3 - (rectF.width() / f);
            if (z) {
                fWidth = rectF.width() / f;
            }
            a(rectF, new PointF(fWidth, pointF.y), size, z);
            return;
        }
        if (rectF.bottom < 0.0f) {
            float fHeight = (-rectF.height()) / f;
            if (z) {
                fHeight = size.height + (rectF.height() / f);
            }
            a(rectF, new PointF(pointF.x, fHeight), size, z);
            return;
        }
        this.e = pointFA;
    }

    public static final void a(List list, o3 o3Var) throws InterruptedException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BuildersKt__BuildersKt.runBlocking$default(null, new a(o3Var, (Annotation) it.next(), null), 1, null);
        }
    }
}
