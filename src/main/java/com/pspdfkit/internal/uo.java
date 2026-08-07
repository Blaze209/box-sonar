package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.PointF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProviderBlocking;
import com.pspdfkit.annotations.CircleAnnotation;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.ShapeAnnotation;
import com.pspdfkit.annotations.SquareAnnotation;
import com.pspdfkit.internal.jni.NativeShapeDetectorResult;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class uo extends jk {
    public Disposable N;

    public uo(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ce A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00d0  */
    public final MaybeSource a(InkAnnotation inkAnnotation, l10 l10Var) throws Throwable {
        int i;
        List list;
        SquareAnnotation squareAnnotation;
        CircleAnnotation circleAnnotation;
        LineAnnotation lineAnnotation;
        if (l10Var.b < 75.0f || (i = l10Var.a) == 6 || i == 7) {
            return Maybe.empty();
        }
        inkAnnotation.getClass();
        Annotation annotation = null;
        annotation = null;
        annotation = null;
        annotation = null;
        annotation = null;
        annotation = null;
        annotation = null;
        annotation = null;
        annotation = null;
        annotation = null;
        if (i == 0) {
            throw null;
        }
        int iA = y30.a(i);
        if (iA == 0 || iA == 1) {
            List<List<PointF>> lines = inkAnnotation.getLines();
            lines.getClass();
            if (lines.size() == 1 && (list = (List) CollectionsKt.firstOrNull((List) lines)) != null && list.size() >= 2) {
                int iA2 = y30.a(i);
                if (iA2 == 0) {
                    squareAnnotation = new SquareAnnotation(inkAnnotation.getPageIndex(), inkAnnotation.getBoundingBox());
                } else if (iA2 == 1) {
                    circleAnnotation = new CircleAnnotation(inkAnnotation.getPageIndex(), inkAnnotation.getBoundingBox());
                }
            }
        } else if (iA == 2 || iA == 3 || iA == 4) {
            List<List<PointF>> lines2 = inkAnnotation.getLines();
            lines2.getClass();
            if (!lines2.isEmpty()) {
                boolean z = false;
                boolean z2 = lines2.size() >= 2;
                boolean z3 = z2 && i == 5;
                if (z2 && i == 4) {
                    z = true;
                }
                if (!((List) CollectionsKt.first((List) lines2)).isEmpty() && !((List) CollectionsKt.last((List) lines2)).isEmpty()) {
                    Object objFirst = CollectionsKt.first((List<? extends Object>) lines2);
                    objFirst.getClass();
                    PointF pointF = (PointF) CollectionsKt.first((List) objFirst);
                    Object objLast = CollectionsKt.last((List<? extends Object>) lines2);
                    objLast.getClass();
                    PointF pointF2 = (PointF) CollectionsKt.last((List) objLast);
                    if (z3 || z) {
                        List list2 = (List) (z3 ? CollectionsKt.first((List) lines2) : CollectionsKt.last((List) lines2));
                        if (list2.size() >= 2) {
                            PointF pointF3 = (PointF) CollectionsKt.first(list2);
                            pointF2 = (PointF) CollectionsKt.last(list2);
                            pointF = pointF3;
                            lineAnnotation = new LineAnnotation(inkAnnotation.getPageIndex(), pointF, pointF2);
                            annotation = lineAnnotation;
                            if (z3) {
                                lineAnnotation.setLineEnds(LineEndType.NONE, LineEndType.OPEN_ARROW);
                            } else if (z) {
                                lineAnnotation.setLineEnds(LineEndType.OPEN_ARROW, LineEndType.NONE);
                            }
                        }
                    } else if (lines2.size() == 1) {
                        lineAnnotation = new LineAnnotation(inkAnnotation.getPageIndex(), pointF, pointF2);
                        annotation = lineAnnotation;
                        if (z3) {
                            lineAnnotation.setLineEnds(LineEndType.NONE, LineEndType.OPEN_ARROW);
                        } else if (z) {
                            lineAnnotation.setLineEnds(LineEndType.OPEN_ARROW, LineEndType.NONE);
                        }
                    }
                }
            }
        }
        if (annotation != null) {
            annotation = squareAnnotation;
            annotation = circleAnnotation;
            annotation = lineAnnotation;
            annotation = lineAnnotation;
            if (ar.b().a(this.a.z, annotation)) {
                return Maybe.just(annotation);
            }
        }
        annotation = squareAnnotation;
        annotation = circleAnnotation;
        annotation = lineAnnotation;
        annotation = lineAnnotation;
        return Maybe.empty();
    }

    public final Disposable b(final InkAnnotation inkAnnotation) {
        final List<List<PointF>> lines = inkAnnotation.getLines();
        if (lines.isEmpty() || lines.get(0).size() < 2) {
            return null;
        }
        Single singleDelaySubscription = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.uo$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return uo.a(lines);
            }
        }).delaySubscription(300L, TimeUnit.MILLISECONDS);
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        return singleDelaySubscription.subscribeOn(schedulerIo).flatMapMaybe(new Function() { // from class: com.pspdfkit.internal.uo$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.a(inkAnnotation, (l10) obj);
            }
        }).subscribe(new Consumer() { // from class: com.pspdfkit.internal.uo$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a(inkAnnotation, (ShapeAnnotation) obj);
            }
        }, new Consumer() { // from class: com.pspdfkit.internal.uo$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.a((Throwable) obj);
            }
        });
    }

    @Override // com.pspdfkit.internal.o7
    public final void c(float f, float f2) {
        yz.a(this.N);
        this.N = null;
        super.c(f, f2);
    }

    @Override // com.pspdfkit.internal.jk, com.pspdfkit.internal.gu
    public final int f() {
        return 2;
    }

    @Override // com.pspdfkit.internal.jk, com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return AnnotationTool.MAGIC_INK;
    }

    @Override // com.pspdfkit.internal.o7, com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        yz.a(this.N);
        this.N = null;
        InkAnnotation inkAnnotation = this.G;
        if (inkAnnotation != null) {
            this.N = b(inkAnnotation);
        }
    }

    @Override // com.pspdfkit.internal.jk, com.pspdfkit.internal.o7
    public final void t() {
        super.t();
        yz.a(this.N);
        this.N = null;
        InkAnnotation inkAnnotation = this.G;
        if (inkAnnotation != null) {
            this.N = b(inkAnnotation);
        }
    }

    @Override // com.pspdfkit.internal.jk
    public final void a(InkAnnotation inkAnnotation) {
        b(inkAnnotation);
    }

    public static l10 a(List list) throws Exception {
        k10 k10Var;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll((List) it.next());
        }
        synchronized (ar.class) {
            if (ar.j == null) {
                Context context = n5.a;
                if (context != null) {
                    ar.j = new k10(context);
                } else {
                    throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
                }
            }
            k10Var = ar.j;
        }
        NativeShapeDetectorResult nativeShapeDetectorResultDetectShape = k10Var.a.detectShape(new kw(arrayList));
        if (nativeShapeDetectorResultDetectShape != null) {
            return new l10(nativeShapeDetectorResultDetectShape.getMatchingTemplateIdentifier(), nativeShapeDetectorResultDetectShape.getMatchConfidence());
        }
        return null;
    }

    public static /* synthetic */ void a(o3 o3Var, InkAnnotation inkAnnotation, ShapeAnnotation shapeAnnotation) {
        AnnotationProviderBlocking.removeAnnotationFromPageBlocking(o3Var, inkAnnotation);
        AnnotationProviderBlocking.addAnnotationToPageBlocking(o3Var, shapeAnnotation);
    }

    public final /* synthetic */ void a(Throwable th) throws Throwable {
        PdfLog.e("Nutri.MagicInkAnnotMHan", th, "Could not perform magic ink transformation", new Object[0]);
    }

    public final void a(final InkAnnotation inkAnnotation, final ShapeAnnotation shapeAnnotation) throws Throwable {
        shapeAnnotation.setFillColor(inkAnnotation.getFillColor());
        shapeAnnotation.setAlpha(inkAnnotation.getAlpha());
        shapeAnnotation.setBorderWidth(inkAnnotation.getBorderWidth());
        shapeAnnotation.setBorderColor(inkAnnotation.getBorderColor());
        final o3 annotationProvider = j().getAnnotationProvider();
        Runnable runnable = new Runnable() { // from class: com.pspdfkit.internal.uo$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                uo.a(annotationProvider, inkAnnotation, shapeAnnotation);
            }
        };
        annotationProvider.getClass();
        annotationProvider.a((at) null, runnable);
    }
}
