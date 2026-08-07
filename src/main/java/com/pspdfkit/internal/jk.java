package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationAggregationStrategyConfiguration;
import com.pspdfkit.configuration.annotations.AnnotationAggregationStrategy;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public class jk extends o7<kk> {
    public static final /* synthetic */ boolean M = true;
    public InkAnnotation G;
    public ArrayList H;
    public final ArrayList I;
    public final ArrayList J;
    public final ArrayList K;
    public AnnotationAggregationStrategy L;

    public jk(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
        this.G = null;
        this.H = null;
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = AnnotationAggregationStrategy.AUTOMATIC;
    }

    public void a(InkAnnotation inkAnnotation) {
    }

    @Override // com.pspdfkit.internal.o7, com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        super.a(q30Var);
        AnnotationAggregationStrategyConfiguration annotationAggregationStrategyConfiguration = (AnnotationAggregationStrategyConfiguration) this.a.f.getAnnotationConfiguration().get(AnnotationTool.INK, this.A, AnnotationAggregationStrategyConfiguration.class);
        if (annotationAggregationStrategyConfiguration != null) {
            this.L = annotationAggregationStrategyConfiguration.getAnnotationAggregationStrategy();
        } else {
            this.L = AnnotationAggregationStrategy.AUTOMATIC;
        }
    }

    public final void b(Annotation annotation) {
        au auVarL;
        if (annotation instanceof InkAnnotation) {
            int iIndexOf = this.J.indexOf(annotation);
            List list = (iIndexOf < 0 || iIndexOf >= this.K.size()) ? null : (List) this.K.get(iIndexOf);
            if (list == null || (auVarL = l()) == null) {
                return;
            }
            kk kkVar = new kk(annotation.getColor(), annotation.getFillColor(), ((InkAnnotation) annotation).getLineWidth(), annotation.getAlpha(), auVarL.getPdfConfiguration().getUseCubicInterpolationForInkAnnotations());
            Matrix matrix = this.c;
            float f = this.k;
            matrix.getClass();
            kkVar.a(annotation, matrix, f, true);
            Object obj = this.l;
            if (obj != null && list.contains(obj)) {
                this.l = null;
            }
            this.d.removeAll(list);
            this.d.add(kkVar);
            this.I.removeAll(list);
            this.I.add(kkVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(kkVar);
            int iIndexOf2 = this.J.indexOf(annotation);
            if (iIndexOf2 >= 0 && iIndexOf2 < this.K.size()) {
                this.K.set(iIndexOf2, arrayList);
            }
            if (this.G == annotation) {
                this.H = arrayList;
            }
            r();
        }
    }

    @Override // com.pspdfkit.internal.gu
    public int f() {
        return 1;
    }

    @Override // com.pspdfkit.internal.o7, com.pspdfkit.internal.gu
    public final void g() {
        super.g();
        InkAnnotation inkAnnotation = this.G;
        if (inkAnnotation != null) {
            inkAnnotation.getInternal().removeOnAnnotationPropertyChangeListener(this);
            this.G = null;
        }
    }

    @Override // com.pspdfkit.internal.d3
    public AnnotationTool h() {
        return AnnotationTool.INK;
    }

    @Override // com.pspdfkit.internal.o7
    public final r4 n() {
        q0 q0Var = this.a;
        au auVarL = l();
        q0.a aVar = q0Var.p;
        return new kk(aVar.b, aVar.c, aVar.e, aVar.i, auVarL != null && auVarL.getPdfConfiguration().getUseCubicInterpolationForInkAnnotations());
    }

    @Override // com.pspdfkit.internal.o7, com.pspdfkit.internal.zs
    public final void onAnnotationPropertyChange(final Annotation annotation, int i, Object obj, Object obj2) {
        if (obj2 == null || obj2.equals(obj)) {
            return;
        }
        if (i == 100 || i == 103) {
            h60.a(new Runnable() { // from class: com.pspdfkit.internal.jk$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(annotation);
                }
            });
        }
    }

    @Override // com.pspdfkit.internal.o7, com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        if (annotation.getPageIndex() != k()) {
            return;
        }
        int iIndexOf = this.J.indexOf(annotation);
        if (iIndexOf >= 0 && iIndexOf < this.K.size()) {
            List list = (List) this.K.get(iIndexOf);
            if (list != null) {
                this.d.removeAll(list);
                this.I.removeAll(list);
            }
            this.J.remove(annotation);
            this.K.remove(iIndexOf);
        }
        if (annotation == this.G) {
            this.G = null;
            this.H = null;
            this.l = null;
        }
        r();
        this.b.c();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:84:0x0247  */
    @Override // com.pspdfkit.internal.o7
    public void t() {
        i3 i3Var;
        ArrayList arrayList;
        int i;
        InkAnnotation inkAnnotation;
        au auVarL;
        PointF pointF;
        if (this.d.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(this.d.size());
        InkAnnotation inkAnnotation2 = this.G;
        if (inkAnnotation2 != null) {
            at atVar = this.a.c;
            atVar.getClass();
            i3Var = new i3(CollectionsKt.listOf(inkAnnotation2), atVar);
            i3Var.b();
            this.G.getInternal().removeOnAnnotationPropertyChangeListener(this);
            arrayList2.addAll(this.G.getLines());
        } else {
            i3Var = null;
        }
        ArrayList arrayList4 = this.d;
        int size = arrayList4.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList4.get(i3);
            i3++;
            kk kkVar = (kk) obj;
            if (this.I.contains(kkVar)) {
                arrayList = arrayList4;
                i = size;
            } else {
                this.I.add(kkVar);
                InkAnnotation inkAnnotation3 = this.G;
                if (inkAnnotation3 == null || this.H == null || this.L == AnnotationAggregationStrategy.SEPARATE || inkAnnotation3.getColor() != ((mk) kkVar.a).e || this.G.getFillColor() != ((mk) kkVar.a).f || this.G.getLineWidth() != ((mk) kkVar.a).g) {
                    arrayList = arrayList4;
                    i = size;
                    inkAnnotation = this.G;
                    if (inkAnnotation != null) {
                        inkAnnotation.setLines(arrayList2);
                        if (i3Var != null) {
                            i3Var.c();
                        }
                        a(this.G);
                        arrayList2 = new ArrayList();
                        this.G.getInternal().addOnAnnotationPropertyChangeListener(this);
                    }
                    arrayList2.addAll(kkVar.a(this.c, this.k));
                    InkAnnotation inkAnnotation4 = new InkAnnotation(k());
                    this.G = inkAnnotation4;
                    inkAnnotation4.setLines(arrayList2);
                    q0 q0Var = this.a;
                    InkAnnotation inkAnnotation5 = this.G;
                    q0Var.getClass();
                    inkAnnotation5.getClass();
                    ww.a(q0Var.g, inkAnnotation5);
                    inkAnnotation5.getInternal().setVariant(q0Var.t);
                    this.G.setColor(((mk) kkVar.a).e);
                    this.G.setFillColor(((mk) kkVar.a).f);
                    this.G.setLineWidth(((mk) kkVar.a).g);
                    this.G.setAlpha(((mk) kkVar.a).h);
                    ArrayList arrayList5 = new ArrayList();
                    this.H = arrayList5;
                    arrayList5.add(kkVar);
                    this.J.add(this.G);
                    this.K.add(this.H);
                    auVarL = l();
                    if (auVarL != null) {
                        auVarL.getAnnotationRenderingCoordinator().a(this.G);
                    }
                    arrayList3.add(this.G);
                    InkAnnotation inkAnnotation6 = this.G;
                    at atVar2 = this.a.c;
                    inkAnnotation6.getClass();
                    atVar2.getClass();
                    i3Var = new i3(CollectionsKt.listOf(inkAnnotation6), atVar2);
                    i3Var.b();
                } else {
                    float alpha = this.G.getAlpha();
                    mk mkVar = (mk) kkVar.a;
                    if (alpha == mkVar.h) {
                        AnnotationAggregationStrategy annotationAggregationStrategy = this.L;
                        if (annotationAggregationStrategy == AnnotationAggregationStrategy.AUTOMATIC) {
                            ArrayList arrayList6 = this.H;
                            ArrayList arrayList7 = mkVar.o;
                            if (arrayList7.isEmpty()) {
                                pointF = null;
                            } else {
                                List list = (List) arrayList7.get(i2);
                                if (list.isEmpty()) {
                                    pointF = null;
                                } else {
                                    pointF = (PointF) list.get(i2);
                                }
                            }
                            if (pointF == null || arrayList6.isEmpty()) {
                                arrayList = arrayList4;
                                i = size;
                            } else {
                                kk kkVar2 = (kk) arrayList6.get(arrayList6.size() - 1);
                                au auVarL2 = l();
                                if (auVarL2 == null) {
                                    arrayList = arrayList4;
                                    i = size;
                                } else {
                                    float height = (auVarL2.getHeight() + auVarL2.getWidth()) / 2.0f;
                                    i = size;
                                    float f = kkVar.d - kkVar2.e;
                                    if (f < 150.0f) {
                                        arrayList = arrayList4;
                                    } else {
                                        float f2 = (height * 150.0f) / f;
                                        float f3 = f2 * f2;
                                        int size2 = arrayList6.size();
                                        int i4 = i2;
                                        while (true) {
                                            if (i4 < size2) {
                                                Object obj2 = arrayList6.get(i4);
                                                i4++;
                                                ArrayList arrayList8 = ((mk) ((kk) obj2).a).o;
                                                int size3 = arrayList8.size();
                                                int i5 = i2;
                                                while (true) {
                                                    if (i5 < size3) {
                                                        Object obj3 = arrayList8.get(i5);
                                                        i5++;
                                                        Iterator it = ((List) obj3).iterator();
                                                        while (true) {
                                                            if (it.hasNext()) {
                                                                PointF pointF2 = (PointF) it.next();
                                                                arrayList = arrayList4;
                                                                int i6 = size2;
                                                                int i7 = i4;
                                                                if (ip.a(pointF2.x, pointF2.y, pointF.x, pointF.y) >= f3) {
                                                                    arrayList4 = arrayList;
                                                                    size2 = i6;
                                                                    i4 = i7;
                                                                    i2 = 0;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                arrayList = arrayList4;
                                            }
                                        }
                                    }
                                    arrayList2.addAll(kkVar.a(this.c, this.k));
                                    if (M && this.H == null) {
                                        throw new AssertionError();
                                    }
                                    this.H.add(kkVar);
                                }
                            }
                            inkAnnotation = this.G;
                            if (inkAnnotation != null) {
                                inkAnnotation.setLines(arrayList2);
                                if (i3Var != null) {
                                    i3Var.c();
                                }
                                a(this.G);
                                arrayList2 = new ArrayList();
                                this.G.getInternal().addOnAnnotationPropertyChangeListener(this);
                            }
                            arrayList2.addAll(kkVar.a(this.c, this.k));
                            InkAnnotation inkAnnotation7 = new InkAnnotation(k());
                            this.G = inkAnnotation7;
                            inkAnnotation7.setLines(arrayList2);
                            q0 q0Var2 = this.a;
                            InkAnnotation inkAnnotation8 = this.G;
                            q0Var2.getClass();
                            inkAnnotation8.getClass();
                            ww.a(q0Var2.g, inkAnnotation8);
                            inkAnnotation8.getInternal().setVariant(q0Var2.t);
                            this.G.setColor(((mk) kkVar.a).e);
                            this.G.setFillColor(((mk) kkVar.a).f);
                            this.G.setLineWidth(((mk) kkVar.a).g);
                            this.G.setAlpha(((mk) kkVar.a).h);
                            ArrayList arrayList9 = new ArrayList();
                            this.H = arrayList9;
                            arrayList9.add(kkVar);
                            this.J.add(this.G);
                            this.K.add(this.H);
                            auVarL = l();
                            if (auVarL != null) {
                                auVarL.getAnnotationRenderingCoordinator().a(this.G);
                            }
                            arrayList3.add(this.G);
                            InkAnnotation inkAnnotation9 = this.G;
                            at atVar3 = this.a.c;
                            inkAnnotation9.getClass();
                            atVar3.getClass();
                            i3Var = new i3(CollectionsKt.listOf(inkAnnotation9), atVar3);
                            i3Var.b();
                        } else {
                            arrayList = arrayList4;
                            i = size;
                            if (annotationAggregationStrategy == AnnotationAggregationStrategy.MERGE_IF_POSSIBLE) {
                                arrayList2.addAll(kkVar.a(this.c, this.k));
                                if (M) {
                                }
                                this.H.add(kkVar);
                            } else {
                                inkAnnotation = this.G;
                                if (inkAnnotation != null) {
                                    inkAnnotation.setLines(arrayList2);
                                    if (i3Var != null) {
                                        i3Var.c();
                                    }
                                    a(this.G);
                                    arrayList2 = new ArrayList();
                                    this.G.getInternal().addOnAnnotationPropertyChangeListener(this);
                                }
                                arrayList2.addAll(kkVar.a(this.c, this.k));
                                InkAnnotation inkAnnotation10 = new InkAnnotation(k());
                                this.G = inkAnnotation10;
                                inkAnnotation10.setLines(arrayList2);
                                q0 q0Var3 = this.a;
                                InkAnnotation inkAnnotation11 = this.G;
                                q0Var3.getClass();
                                inkAnnotation11.getClass();
                                ww.a(q0Var3.g, inkAnnotation11);
                                inkAnnotation11.getInternal().setVariant(q0Var3.t);
                                this.G.setColor(((mk) kkVar.a).e);
                                this.G.setFillColor(((mk) kkVar.a).f);
                                this.G.setLineWidth(((mk) kkVar.a).g);
                                this.G.setAlpha(((mk) kkVar.a).h);
                                ArrayList arrayList10 = new ArrayList();
                                this.H = arrayList10;
                                arrayList10.add(kkVar);
                                this.J.add(this.G);
                                this.K.add(this.H);
                                auVarL = l();
                                if (auVarL != null) {
                                    auVarL.getAnnotationRenderingCoordinator().a(this.G);
                                }
                                arrayList3.add(this.G);
                                InkAnnotation inkAnnotation12 = this.G;
                                at atVar4 = this.a.c;
                                inkAnnotation12.getClass();
                                atVar4.getClass();
                                i3Var = new i3(CollectionsKt.listOf(inkAnnotation12), atVar4);
                                i3Var.b();
                            }
                        }
                    } else {
                        arrayList = arrayList4;
                        i = size;
                        inkAnnotation = this.G;
                        if (inkAnnotation != null) {
                            inkAnnotation.setLines(arrayList2);
                            if (i3Var != null) {
                                i3Var.c();
                            }
                            a(this.G);
                            arrayList2 = new ArrayList();
                            this.G.getInternal().addOnAnnotationPropertyChangeListener(this);
                        }
                        arrayList2.addAll(kkVar.a(this.c, this.k));
                        InkAnnotation inkAnnotation13 = new InkAnnotation(k());
                        this.G = inkAnnotation13;
                        inkAnnotation13.setLines(arrayList2);
                        q0 q0Var4 = this.a;
                        InkAnnotation inkAnnotation14 = this.G;
                        q0Var4.getClass();
                        inkAnnotation14.getClass();
                        ww.a(q0Var4.g, inkAnnotation14);
                        inkAnnotation14.getInternal().setVariant(q0Var4.t);
                        this.G.setColor(((mk) kkVar.a).e);
                        this.G.setFillColor(((mk) kkVar.a).f);
                        this.G.setLineWidth(((mk) kkVar.a).g);
                        this.G.setAlpha(((mk) kkVar.a).h);
                        ArrayList arrayList11 = new ArrayList();
                        this.H = arrayList11;
                        arrayList11.add(kkVar);
                        this.J.add(this.G);
                        this.K.add(this.H);
                        auVarL = l();
                        if (auVarL != null) {
                            auVarL.getAnnotationRenderingCoordinator().a(this.G);
                        }
                        arrayList3.add(this.G);
                        InkAnnotation inkAnnotation15 = this.G;
                        at atVar5 = this.a.c;
                        inkAnnotation15.getClass();
                        atVar5.getClass();
                        i3Var = new i3(CollectionsKt.listOf(inkAnnotation15), atVar5);
                        i3Var.b();
                    }
                }
            }
            size = i;
            arrayList4 = arrayList;
            i2 = 0;
        }
        InkAnnotation inkAnnotation16 = this.G;
        if (inkAnnotation16 != null) {
            if (!arrayList2.equals(inkAnnotation16.getLines())) {
                this.G.setLines(arrayList2);
            }
            this.G.getInternal().addOnAnnotationPropertyChangeListener(this);
        }
        if (i3Var != null) {
            i3Var.c();
        }
        int size4 = arrayList3.size();
        int i8 = 0;
        while (i8 < size4) {
            Object obj4 = arrayList3.get(i8);
            i8++;
            this.a.f.addAnnotationToPage((Annotation) obj4, false);
        }
        PdfLog.d("Nutri.InkAnnotMHandler", "Created " + arrayList3.size() + " ink annotations from the drawing session.", new Object[0]);
    }

    @Override // com.pspdfkit.internal.o7
    public final List<? extends Annotation> w() {
        if (this.J.isEmpty() || l() == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = this.J;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Annotation annotation = (Annotation) obj;
            l().getAnnotationRenderingCoordinator().b(annotation);
            annotation.getInternal().removeOnAnnotationPropertyChangeListener(this);
        }
        ArrayList arrayList2 = new ArrayList(this.J);
        this.J.clear();
        this.K.clear();
        return arrayList2;
    }
}
