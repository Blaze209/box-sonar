package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewGroupKt;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.theming.AnnotationSelectionViewThemeConfiguration;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import com.pspdfkit.utils.FreeTextAnnotationUtils;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class m4 implements AnnotationSelectionController, q4 {
    public o4 a;
    public final PdfConfiguration b;
    public a3 c;
    public final RectF d;
    public final xv e;
    public final RectF f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public Boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public Size u;
    public boolean v;
    public int w;
    public aq x;
    public final LinkedHashSet y;
    public RectF z;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[o4.b.values().length];
            try {
                o4.b bVar = o4.b.TOP_LEFT;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                o4.b bVar2 = o4.b.TOP_LEFT;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                o4.b bVar3 = o4.b.TOP_LEFT;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                o4.b bVar4 = o4.b.TOP_LEFT;
                iArr[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                o4.b bVar5 = o4.b.TOP_LEFT;
                iArr[7] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                o4.b bVar6 = o4.b.TOP_LEFT;
                iArr[6] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                o4.b bVar7 = o4.b.TOP_LEFT;
                iArr[5] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                o4.b bVar8 = o4.b.TOP_LEFT;
                iArr[3] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                o4.b bVar9 = o4.b.TOP_LEFT;
                iArr[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            a = iArr;
        }
    }

    public m4(o4 o4Var, PdfConfiguration pdfConfiguration, w4 w4Var) {
        pdfConfiguration.getClass();
        w4Var.getClass();
        this.a = o4Var;
        this.b = pdfConfiguration;
        this.d = new RectF();
        this.e = new xv(0);
        this.f = new RectF();
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = true;
        this.u = new Size(0.0f, 0.0f);
        new kf(null, 2);
        this.y = new LinkedHashSet();
        this.a.setPresenter(this);
        this.h = pdfConfiguration.isAnnotationRotationEnabled();
        this.a.a(w4Var);
        this.i = w4Var.a >= 1;
        this.j = pdfConfiguration.getSelectedAnnotationResizeEnabled();
        this.l = pdfConfiguration.getSelectedAnnotationResizeGuidesEnabled();
        this.g = true;
        this.k = true;
        this.s = false;
        this.t = false;
        this.m = null;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean a(o4.b bVar) {
        bVar.getClass();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    @Override // com.pspdfkit.internal.q4
    public final void b() {
        z4 z4VarB;
        Annotation annotation;
        List<Annotation> listListOfNotNull;
        boolean z;
        boolean z2;
        this.p = true;
        this.q = true;
        loop0: for (KeyEvent.Callback callback : ViewGroupKt.getChildren(this.a)) {
            z4 z4Var = callback instanceof z4 ? (z4) callback : null;
            if (z4Var != null) {
                if (z4Var instanceof a5) {
                    listListOfNotNull = ((a5) z4Var).getAnnotations();
                    listListOfNotNull.getClass();
                } else {
                    listListOfNotNull = CollectionsKt.listOfNotNull(z4Var.getAnnotation());
                }
                for (Annotation annotation2 : listListOfNotNull) {
                    if (this.p) {
                        annotation2.getClass();
                        if (!annotation2.getIsResizable() || annotation2.hasFlag(AnnotationFlags.NOZOOM)) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    this.p = z;
                    if (this.q) {
                        annotation2.getClass();
                        float f = ww.a;
                        int i = ww.a.a[annotation2.getType().ordinal()];
                        if (i == 2 || i == 3 || i == 4 || i == 6 || i == 21) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    } else {
                        z2 = false;
                    }
                    this.q = z2;
                    if (!this.p || !z2) {
                        break loop0;
                    }
                }
            }
        }
        n();
        int childCount = this.a.getChildCount();
        a(childCount > 0);
        if (childCount != 1 || (z4VarB = this.a.b()) == null || (annotation = z4VarB.getAnnotation()) == null) {
            return;
        }
        float f2 = ww.a;
        boolean z3 = annotation.getType() == AnnotationType.FREETEXT && ((FreeTextAnnotation) annotation).getIntent() == FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT;
        if (this.v != z3) {
            this.v = z3;
            this.a.invalidate();
        }
        int i2 = ww.a.a[annotation.getType().ordinal()];
        if (i2 != 10) {
            switch (i2) {
                case 18:
                    break;
                case 19:
                case 20:
                    if (!annotation.isMeasurement()) {
                        return;
                    }
                    break;
                default:
                    return;
            }
        }
        a(false);
        this.p = false;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean b(int i) {
        return true;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean c() {
        return this.v;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean d() {
        return this.g;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean e() {
        return (!this.g || this.s || this.t || this.r || this.a.getChildCount() != 1) ? false : true;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean f() {
        return this.i;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean g() {
        return this.g && !this.s && !this.r && this.p && this.j;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final AnnotationSelectionViewThemeConfiguration getAnnotationSelectionViewThemeConfiguration() {
        return this.a.getAnnotationSelectionViewThemeConfiguration();
    }

    @Override // com.pspdfkit.internal.q4
    public final int getPageRotation() {
        return this.w;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean h() {
        return this.n;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean i() {
        return this.r;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final boolean isDraggingEnabled() {
        return this.k && this.q;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final Boolean isKeepAspectRatioEnabled() {
        return this.m;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final boolean isResizeEnabled() {
        return this.j && this.p;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final boolean isResizeGuidesEnabled() {
        return this.l;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final boolean isRotationEnabled() {
        return this.h;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean j() {
        return this.z != null;
    }

    @Override // com.pspdfkit.internal.q4
    public final void k() {
        this.r = false;
    }

    @Override // com.pspdfkit.internal.q4
    public final void l() {
        this.a.d();
        OverlayLayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        RectF pageRect = layoutParams.pageRect.getPageRect();
        pageRect.getClass();
        float fWidth = pageRect.width();
        float fAbs = Math.abs(pageRect.height());
        int childCount = this.a.getChildCount();
        float fA = 0.0f;
        float fA2 = 0.0f;
        for (KeyEvent.Callback callback : ViewGroupKt.getChildren(this.a)) {
            z4 z4Var = callback instanceof z4 ? (z4) callback : null;
            Annotation annotation = z4Var != null ? z4Var.getAnnotation() : null;
            if (annotation != null) {
                RectF boundingBox = annotation.getBoundingBox();
                Size minimumSize = annotation.getMinimumSize();
                float fWidth2 = boundingBox.width();
                float fAbs2 = Math.abs(boundingBox.height());
                float f = childCount > 1 ? fWidth2 / fWidth : 1.0f;
                float f2 = childCount > 1 ? fAbs2 / fAbs : 1.0f;
                fA = ip.a(fA, ip.b(fWidth2, minimumSize.width / f));
                fA2 = ip.a(fA2, ip.b(fAbs2, minimumSize.height / f2));
            }
        }
        this.u = new Size(fA, fA2);
        xv xvVar = this.e;
        xvVar.a = ip.b(xvVar.a, pageRect.left);
        xv xvVar2 = this.e;
        xvVar2.c = ip.a(xvVar2.c, pageRect.right);
        xv xvVar3 = this.e;
        xvVar3.d = ip.b(xvVar3.d, pageRect.bottom);
        xv xvVar4 = this.e;
        xvVar4.b = ip.a(xvVar4.b, pageRect.top);
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean m() {
        if (!this.g || !this.h || !this.a.getRotationHandler().a()) {
            return false;
        }
        o4 o4Var = this.a;
        return (o4Var.getScaleHandleDrawables().get(o4.b.ROTATION) == null && o4Var.o.getColor() == 0) ? false : true;
    }

    public final void n() {
        boolean zBooleanValue;
        Annotation annotation;
        Annotation annotation2;
        Boolean bool = this.m;
        boolean z = true;
        if (bool == null) {
            Iterator<View> it = ViewGroupKt.getChildren(this.a).iterator();
            while (true) {
                if (!it.hasNext()) {
                    zBooleanValue = false;
                    break;
                }
                KeyEvent.Callback callback = (View) it.next();
                z4 z4Var = callback instanceof z4 ? (z4) callback : null;
                if (z4Var != null && (annotation = z4Var.getAnnotation()) != null) {
                    float f = ww.a;
                    if (annotation.getType() == AnnotationType.STAMP) {
                        zBooleanValue = true;
                        break;
                    }
                }
            }
        } else {
            zBooleanValue = bool.booleanValue();
        }
        this.n = zBooleanValue;
        for (KeyEvent.Callback callback2 : ViewGroupKt.getChildren(this.a)) {
            z4 z4Var2 = callback2 instanceof z4 ? (z4) callback2 : null;
            if (z4Var2 != null && (annotation2 = z4Var2.getAnnotation()) != null) {
                float f2 = ww.a;
                if (annotation2.getIsResizable() && !annotation2.isMeasurement() && annotation2.getType() != AnnotationType.LINE) {
                    this.o = z;
                }
            }
        }
        z = false;
        this.o = z;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final void setAnnotationSelectionViewThemeConfiguration(AnnotationSelectionViewThemeConfiguration annotationSelectionViewThemeConfiguration) {
        annotationSelectionViewThemeConfiguration.getClass();
        uw.a(annotationSelectionViewThemeConfiguration, "configuration", null);
        this.a.setAnnotationSelectionViewThemeConfiguration(annotationSelectionViewThemeConfiguration);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final void setDraggingEnabled(boolean z) {
        if (this.k == z) {
            return;
        }
        this.k = z;
        this.a.invalidate();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final void setKeepAspectRatioEnabled(boolean z) {
        Boolean bool = this.m;
        if (bool == null || !Intrinsics.areEqual(bool, Boolean.valueOf(z))) {
            this.m = Boolean.valueOf(z);
            n();
            this.a.requestLayout();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final void setResizeEnabled(boolean z) {
        if (this.j == z) {
            return;
        }
        this.j = z;
        this.a.invalidate();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final void setResizeGuidesEnabled(boolean z) {
        if (this.l == z) {
            return;
        }
        this.l = z;
        this.a.invalidate();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController
    public final void setRotationEnabled(boolean z) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        this.a.invalidate();
    }

    public final void a(jf jfVar, MotionEvent motionEvent, float f, float f2) {
        Annotation annotation;
        PointF pointF;
        aq aqVar;
        Annotation annotation2;
        aq aqVar2;
        jfVar.getClass();
        kf kfVar = jfVar.a;
        int i = kfVar.b;
        if (i == -1) {
            o4.b bVar = kfVar.a;
            if (bVar == o4.b.ROTATION) {
                this.a.getRotationHandler().a(motionEvent);
                return;
            }
            PointF pointF2 = null;
            if (motionEvent != null && bVar != null && this.a.getChildCount() == 1 && !this.o) {
                PointF pointF3 = new PointF(motionEvent.getX(), motionEvent.getY());
                l4.a(this.a.getPdfToViewTransformation(), pointF3);
                z4 z4VarB = this.a.b();
                if (z4VarB != null && (annotation = z4VarB.getAnnotation()) != null) {
                    if (annotation.isMeasurement() && (aqVar = this.x) != null) {
                        pointF3 = aqVar.a(pointF3);
                    }
                    int i2 = o4.N;
                    RectF boundingBox = annotation.getBoundingBox();
                    o4.b bVar2 = jfVar.a.a;
                    boundingBox.getClass();
                    bVar2.getClass();
                    switch (bVar2.ordinal()) {
                        case 0:
                            pointF = new PointF(boundingBox.left, boundingBox.top);
                            break;
                        case 1:
                            pointF = new PointF(boundingBox.centerX(), boundingBox.top);
                            break;
                        case 2:
                            pointF = new PointF(boundingBox.width() + boundingBox.left, boundingBox.top);
                            break;
                        case 3:
                            pointF = new PointF(boundingBox.left, boundingBox.centerY());
                            break;
                        case 4:
                            pointF = new PointF(boundingBox.width() + boundingBox.left, boundingBox.centerY());
                            break;
                        case 5:
                            pointF = new PointF(boundingBox.left, boundingBox.height() + boundingBox.top);
                            break;
                        case 6:
                            pointF = new PointF(boundingBox.centerX(), boundingBox.height() + boundingBox.top);
                            break;
                        case 7:
                            pointF = new PointF(boundingBox.width() + boundingBox.left, boundingBox.height() + boundingBox.top);
                            break;
                        case 8:
                            pointF = null;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    if (pointF != null) {
                        pointF2 = new PointF(pointF3.x - pointF.x, pointF3.y - pointF.y);
                    }
                }
            }
            if (pointF2 != null) {
                a(pointF2.x, pointF2.y, jfVar, motionEvent);
                return;
            } else {
                a(f, f2, jfVar, motionEvent);
                return;
            }
        }
        if (motionEvent == null || i >= this.a.getEditHandleCenters().size() || this.a.getChildCount() != 1) {
            return;
        }
        int i3 = jfVar.a.b;
        z4 z4VarB2 = this.a.b();
        if (z4VarB2 == null || (annotation2 = z4VarB2.getAnnotation()) == null) {
            return;
        }
        List<PointF> listE = ww.e(annotation2);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listE, 10));
        for (PointF pointF4 : listE) {
            arrayList.add(new PointF(pointF4.x, pointF4.y));
        }
        if (i3 >= arrayList.size()) {
            return;
        }
        this.a.setCurrentEditHandlerIndex(i3);
        PointF pointF5 = new PointF(motionEvent.getX(), motionEvent.getY());
        Matrix pdfToViewTransformation = this.a.getPdfToViewTransformation();
        l4.a(pdfToViewTransformation, pointF5);
        RectF pdfRect = this.a.getPdfViewGroup().getPdfRect();
        pointF5.x = Math.max(pdfRect.left, Math.min(pointF5.x, pdfRect.right));
        pointF5.y = Math.max(pdfRect.bottom, Math.min(pointF5.y, pdfRect.top));
        if (p10.a(annotation2.getType()) && (aqVar2 = this.x) != null) {
            pointF5 = aqVar2.a(pointF5);
        }
        s60.a(pointF5, pdfToViewTransformation);
        PointF pointFA = this.a.getAngularGuidesHelper().a(pointF5, this.a.getLeft(), this.a.getTop());
        Matrix matrix = new Matrix();
        pdfToViewTransformation.invert(matrix);
        s60.a(pointFA, matrix);
        ((PointF) arrayList.get(i3)).set(pointFA);
        if (annotation2 instanceof FreeTextAnnotation) {
            FreeTextAnnotation freeTextAnnotation = (FreeTextAnnotation) annotation2;
            if (freeTextAnnotation.getIntent() == FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
                freeTextAnnotation.setCallOutPoints(arrayList);
                if (arrayList.size() == 3) {
                    boolean z = i3 == 1;
                    if (z) {
                        this.y.add(annotation2.getUuid());
                    }
                    if (z || this.y.contains(annotation2.getUuid())) {
                        ji.a(freeTextAnnotation, true);
                    } else {
                        FreeTextAnnotationUtils.placeCallOutPoints(freeTextAnnotation);
                    }
                } else {
                    this.y.remove(annotation2.getUuid());
                    FreeTextAnnotationUtils.placeCallOutPoints(freeTextAnnotation);
                }
            }
        } else {
            float f3 = ww.a;
            int i4 = ww.a.a[annotation2.getType().ordinal()];
            if (i4 == 5) {
                ((FreeTextAnnotation) annotation2).setCallOutPoints(arrayList);
            } else if (i4 != 10) {
                if (i4 == 19 || i4 == 20) {
                    annotation2.getInternal().setPointsWithoutCoreSync(arrayList);
                }
            } else if (arrayList.size() >= 2) {
                annotation2.getInternal().setPointsWithoutCoreSync(arrayList);
            }
        }
        AnnotationType type = annotation2.getType();
        type.getClass();
        switch (p10.a.a[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                annotation2.getInternal().markPreferredForPlatformRendering();
                break;
        }
        s60.a(pointFA, pdfToViewTransformation);
        this.a.getEditHandleCenters().get(i3).set(pointFA);
        this.a.invalidate();
        z4VarB2.getPageRect().set(annotation2.getBoundingBox());
        z4VarB2.b();
        b();
        l();
    }

    public final jf a(MotionEvent motionEvent) {
        int i;
        o4.b bVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        motionEvent.getClass();
        if (this.g && !this.r) {
            o4 o4Var = this.a;
            boolean zE = e();
            o4Var.getClass();
            if (!zE) {
                i = -1;
                break;
            }
            float x = motionEvent.getX() - o4Var.getLeft();
            float y = motionEvent.getY() - o4Var.getTop();
            int size = o4Var.B.size();
            i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                }
                PointF pointF = (PointF) o4Var.B.get(i);
                float f = pointF.x;
                float f2 = o4Var.F;
                if (x >= f - f2 && x < f + f2) {
                    float f3 = pointF.y;
                    if (y >= f3 - f2 && y < f3 + f2) {
                        break;
                    }
                }
                i++;
            }
            if (i != -1) {
                return new jf(new kf(i), false, false, false, false, new RectF(), CollectionsKt.emptyList());
            }
            o4 o4Var2 = this.a;
            boolean zG = g();
            o4Var2.getClass();
            if (!zG) {
                bVar = null;
                break;
            }
            float x2 = motionEvent.getX() - o4Var2.getLeft();
            float y2 = motionEvent.getY() - o4Var2.getTop();
            Iterator it = o4Var2.x.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    bVar = (o4.b) entry.getKey();
                    Point point = (Point) entry.getValue();
                    if (o4Var2.C || (bVar != o4.b.TOP_CENTER && bVar != o4.b.BOTTOM_CENTER)) {
                        if (o4Var2.D || (bVar != o4.b.CENTER_LEFT && bVar != o4.b.CENTER_RIGHT)) {
                            if (bVar != o4.b.ROTATION || o4Var2.k.a()) {
                                int i2 = point.x;
                                int i3 = o4Var2.F;
                                if (x2 >= i2 - i3 && x2 < i2 + i3) {
                                    int i4 = point.y;
                                    if (y2 >= i4 - i3 && y2 < i4 + i3) {
                                        if (((Drawable) o4Var2.n.get(bVar)) != null || o4Var2.o.getColor() != 0) {
                                            break;
                                            break;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                bVar = null;
                break;
            }
            if (bVar != null) {
                OverlayLayoutParams layoutParams = this.a.getLayoutParams();
                if (layoutParams != null) {
                    RectF rectF = new RectF(layoutParams.pageRect.getPageRect());
                    List<Annotation> listA = a();
                    listA.getClass();
                    switch (bVar.ordinal()) {
                        case 0:
                            z = true;
                            z2 = true;
                            z3 = false;
                            z4 = false;
                            return new jf(new kf(bVar, 2), z3, z, z4, z2, rectF, listA);
                        case 1:
                            z = true;
                            z4 = true;
                            z2 = true;
                            z3 = false;
                            return new jf(new kf(bVar, 2), z3, z, z4, z2, rectF, listA);
                        case 2:
                            z4 = true;
                            z2 = true;
                            z3 = false;
                            z = false;
                            return new jf(new kf(bVar, 2), z3, z, z4, z2, rectF, listA);
                        case 3:
                            z3 = true;
                            z = true;
                            z2 = true;
                            z4 = false;
                            return new jf(new kf(bVar, 2), z3, z, z4, z2, rectF, listA);
                        case 4:
                            z3 = true;
                            z4 = true;
                            z2 = true;
                            z = false;
                            return new jf(new kf(bVar, 2), z3, z, z4, z2, rectF, listA);
                        case 5:
                            z3 = true;
                            z = true;
                            z4 = false;
                            z2 = z4;
                            return new jf(new kf(bVar, 2), z3, z, z4, z2, rectF, listA);
                        case 6:
                            z3 = true;
                            z = true;
                            z4 = true;
                            z2 = false;
                            return new jf(new kf(bVar, 2), z3, z, z4, z2, rectF, listA);
                        case 7:
                            z3 = true;
                            z4 = true;
                            z = false;
                            z2 = false;
                            return new jf(new kf(bVar, 2), z3, z, z4, z2, rectF, listA);
                        case 8:
                            z3 = false;
                            z = false;
                            z4 = false;
                            z2 = z4;
                            return new jf(new kf(bVar, 2), z3, z, z4, z2, rectF, listA);
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            if (this.a.a(motionEvent) && this.g && !this.s && this.k && this.q) {
                return new jf(new kf(null, 3), false, false, false, false, new RectF(), CollectionsKt.emptyList());
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Annotation a(View view) {
        view.getClass();
        z4 z4Var = view instanceof z4 ? (z4) view : null;
        if (z4Var != null) {
            return z4Var.getAnnotation();
        }
        return null;
    }

    public final List<Annotation> a() {
        return SequencesKt.toList(SequencesKt.mapNotNull(ViewGroupKt.getChildren(this.a), new Function1() { // from class: com.pspdfkit.internal.m4$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return m4.a((View) obj);
            }
        }));
    }

    public static final Unit a(RectF rectF, Annotation annotation, RectF rectF2) {
        annotation.getClass();
        rectF2.getClass();
        rectF2.left += rectF.left;
        rectF2.top += rectF.top;
        rectF2.right += rectF.right;
        rectF2.bottom += rectF.bottom;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:22:0x005a  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:52:0x0106 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0107  */
    /* JADX WARN: Code duplicated, block: B:55:0x0227  */
    /* JADX WARN: Code duplicated, block: B:56:0x023b  */
    /* JADX WARN: Code duplicated, block: B:58:0x023f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0251 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0253  */
    /* JADX WARN: Code duplicated, block: B:61:0x0267 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x0269  */
    /* JADX WARN: Code duplicated, block: B:65:0x0287  */
    public final void a(o4.b bVar, Annotation annotation, float f, float f2, float f3, float f4, RectF rectF, RectF rectF2) {
        o4.b bVar2;
        int pageRotation;
        int i;
        double dCos;
        double dCos2;
        RectF contentSize;
        PointF pointF;
        PointF pointF2;
        PointF pointF3;
        PointF pointF4;
        boolean zA;
        boolean zA2;
        boolean zA3;
        boolean zA4;
        PointF pointF5;
        PointF pointF6;
        PointF pointF7;
        PointF pointF8;
        float fWidth;
        float fAbs;
        float f5;
        RectF rectF3;
        int i2;
        int i3 = this.w;
        List<o4.b> list = tz.a;
        int i4 = 3;
        if (CollectionsKt.contains(list, bVar)) {
            if (i3 == 0) {
                i2 = 0;
            } else if (i3 == 90) {
                i2 = 3;
            } else if (i3 == 180) {
                i2 = 2;
            } else if (i3 != 270) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            int iIndexOf = CollectionsKt.indexOf((List<? extends o4.b>) list, bVar);
            if (iIndexOf >= 0) {
                bVar2 = list.get((iIndexOf + i2) % list.size());
            } else {
                bVar2 = bVar;
            }
        } else {
            List<o4.b> list2 = tz.b;
            if (CollectionsKt.contains(list2, bVar) && (i3 == 180 || i3 == 270)) {
                bVar2 = list2.get((CollectionsKt.indexOf((List<? extends o4.b>) list2, bVar) + 2) % list2.size());
            } else {
                bVar2 = bVar;
            }
        }
        float f6 = 1.0f;
        float f7 = -1.0f;
        switch (bVar2 == null ? -1 : a.a[bVar2.ordinal()]) {
            case 1:
                f6 = -1.0f;
                i4 = 0;
                pageRotation = annotation.getInternal().getPageRotation();
                if ((bVar != o4.b.TOP_CENTER || bVar == o4.b.CENTER_RIGHT || bVar == o4.b.BOTTOM_CENTER || bVar == o4.b.CENTER_LEFT) && annotation.getInternal().needsFlippedContentSize()) {
                    float f8 = -f6;
                    f6 = f7;
                    f7 = f8;
                }
                i = (i4 + 2) % 4;
                double radians = Math.toRadians(annotation.getInternal().getRotation() + pageRotation);
                double d = f;
                double d2 = f2;
                dCos = ((Math.cos(radians) * d) - (Math.sin(radians) * d2)) * ((double) f6);
                dCos2 = ((Math.cos(radians) * d2) + (Math.sin(radians) * d)) * ((double) f7);
                contentSize = annotation.getInternal().getContentSize(this.f);
                if (contentSize == null) {
                    return;
                }
                contentSize.sort();
                Size sizeB = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                ArrayList arrayListA = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF = (PointF) arrayListA.get(i4);
                pointF2 = (PointF) arrayListA.get(i);
                int i5 = (i + 1) % 4;
                pointF3 = (PointF) arrayListA.get(i5);
                int i6 = (i + 5) % 4;
                pointF4 = (PointF) arrayListA.get(i6);
                float f9 = 2;
                zA = ip.a(pointF2.x, (-sizeB.width) / f9);
                zA2 = ip.a(pointF2.y, sizeB.height / f9);
                zA3 = ip.a(pointF2.x, sizeB.width / f9);
                zA4 = ip.a(pointF2.y, (-sizeB.height) / f9);
                contentSize.set(0.0f, 0.0f, ip.a(f3, (float) (((double) contentSize.width()) + dCos)), ip.a(f4, (float) (((double) contentSize.height()) - dCos2)));
                ArrayList arrayListA2 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF5 = (PointF) arrayListA2.get(i4);
                pointF6 = (PointF) arrayListA2.get(i);
                pointF7 = (PointF) arrayListA2.get(i5);
                pointF8 = (PointF) arrayListA2.get(i6);
                Size sizeB2 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                fWidth = sizeB2.width - rectF.width();
                fAbs = sizeB2.height - Math.abs(rectF.height());
                if (zA) {
                    float f10 = (pointF6.y - pointF7.y) - (pointF2.y - pointF3.y);
                    rectF2.set(0.0f, f10, fWidth, (-fAbs) + f10);
                } else if (zA4) {
                    float f11 = (pointF5.x - pointF8.x) - (pointF.x - pointF4.x);
                    rectF2.set(f11, 0.0f, fWidth + f11, -fAbs);
                } else if (zA3) {
                    float f12 = (pointF5.y - pointF8.y) - (pointF.y - pointF4.y);
                    rectF2.set(-fWidth, -f12, 0.0f, (-fAbs) - f12);
                } else if (zA2) {
                    float f13 = (pointF6.x - pointF8.x) - (pointF2.x - pointF4.x);
                    rectF2.set(-f13, fAbs, fWidth - f13, 0.0f);
                }
                f5 = rectF2.left;
                rectF3 = this.d;
                if (f5 < rectF3.left - rectF.left && rectF2.right <= rectF3.right - rectF.right && rectF2.top <= rectF3.top - rectF.top && rectF2.bottom >= rectF3.bottom - rectF.bottom) {
                    annotation.setContentSize(contentSize, true);
                    return;
                } else {
                    rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                    return;
                }
            case 2:
                f6 = 0.0f;
                i4 = 0;
                pageRotation = annotation.getInternal().getPageRotation();
                if (bVar != o4.b.TOP_CENTER) {
                    float f14 = -f6;
                    f6 = f7;
                    f7 = f14;
                } else {
                    float f15 = -f6;
                    f6 = f7;
                    f7 = f15;
                }
                i = (i4 + 2) % 4;
                double radians2 = Math.toRadians(annotation.getInternal().getRotation() + pageRotation);
                double d3 = f;
                double d4 = f2;
                dCos = ((Math.cos(radians2) * d3) - (Math.sin(radians2) * d4)) * ((double) f6);
                dCos2 = ((Math.cos(radians2) * d4) + (Math.sin(radians2) * d3)) * ((double) f7);
                contentSize = annotation.getInternal().getContentSize(this.f);
                if (contentSize == null) {
                    return;
                }
                contentSize.sort();
                Size sizeB3 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                ArrayList arrayListA3 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF = (PointF) arrayListA3.get(i4);
                pointF2 = (PointF) arrayListA3.get(i);
                int i7 = (i + 1) % 4;
                pointF3 = (PointF) arrayListA3.get(i7);
                int i8 = (i + 5) % 4;
                pointF4 = (PointF) arrayListA3.get(i8);
                float f16 = 2;
                zA = ip.a(pointF2.x, (-sizeB3.width) / f16);
                zA2 = ip.a(pointF2.y, sizeB3.height / f16);
                zA3 = ip.a(pointF2.x, sizeB3.width / f16);
                zA4 = ip.a(pointF2.y, (-sizeB3.height) / f16);
                contentSize.set(0.0f, 0.0f, ip.a(f3, (float) (((double) contentSize.width()) + dCos)), ip.a(f4, (float) (((double) contentSize.height()) - dCos2)));
                ArrayList arrayListA4 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF5 = (PointF) arrayListA4.get(i4);
                pointF6 = (PointF) arrayListA4.get(i);
                pointF7 = (PointF) arrayListA4.get(i7);
                pointF8 = (PointF) arrayListA4.get(i8);
                Size sizeB4 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                fWidth = sizeB4.width - rectF.width();
                fAbs = sizeB4.height - Math.abs(rectF.height());
                if (zA) {
                    float f17 = (pointF6.y - pointF7.y) - (pointF2.y - pointF3.y);
                    rectF2.set(0.0f, f17, fWidth, (-fAbs) + f17);
                } else if (zA4) {
                    float f18 = (pointF5.x - pointF8.x) - (pointF.x - pointF4.x);
                    rectF2.set(f18, 0.0f, fWidth + f18, -fAbs);
                } else if (zA3) {
                    float f19 = (pointF5.y - pointF8.y) - (pointF.y - pointF4.y);
                    rectF2.set(-fWidth, -f19, 0.0f, (-fAbs) - f19);
                } else if (zA2) {
                    float f110 = (pointF6.x - pointF8.x) - (pointF2.x - pointF4.x);
                    rectF2.set(-f110, fAbs, fWidth - f110, 0.0f);
                }
                f5 = rectF2.left;
                rectF3 = this.d;
                if (f5 < rectF3.left - rectF.left) {
                    break;
                }
                rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            case 4:
                f7 = 0.0f;
            case 3:
                i4 = 1;
                pageRotation = annotation.getInternal().getPageRotation();
                if (bVar != o4.b.TOP_CENTER) {
                    float f111 = -f6;
                    f6 = f7;
                    f7 = f111;
                } else {
                    float f112 = -f6;
                    f6 = f7;
                    f7 = f112;
                }
                i = (i4 + 2) % 4;
                double radians3 = Math.toRadians(annotation.getInternal().getRotation() + pageRotation);
                double d5 = f;
                double d6 = f2;
                dCos = ((Math.cos(radians3) * d5) - (Math.sin(radians3) * d6)) * ((double) f6);
                dCos2 = ((Math.cos(radians3) * d6) + (Math.sin(radians3) * d5)) * ((double) f7);
                contentSize = annotation.getInternal().getContentSize(this.f);
                if (contentSize == null) {
                    return;
                }
                contentSize.sort();
                Size sizeB5 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                ArrayList arrayListA5 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF = (PointF) arrayListA5.get(i4);
                pointF2 = (PointF) arrayListA5.get(i);
                int i9 = (i + 1) % 4;
                pointF3 = (PointF) arrayListA5.get(i9);
                int i10 = (i + 5) % 4;
                pointF4 = (PointF) arrayListA5.get(i10);
                float f113 = 2;
                zA = ip.a(pointF2.x, (-sizeB5.width) / f113);
                zA2 = ip.a(pointF2.y, sizeB5.height / f113);
                zA3 = ip.a(pointF2.x, sizeB5.width / f113);
                zA4 = ip.a(pointF2.y, (-sizeB5.height) / f113);
                contentSize.set(0.0f, 0.0f, ip.a(f3, (float) (((double) contentSize.width()) + dCos)), ip.a(f4, (float) (((double) contentSize.height()) - dCos2)));
                ArrayList arrayListA6 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF5 = (PointF) arrayListA6.get(i4);
                pointF6 = (PointF) arrayListA6.get(i);
                pointF7 = (PointF) arrayListA6.get(i9);
                pointF8 = (PointF) arrayListA6.get(i10);
                Size sizeB6 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                fWidth = sizeB6.width - rectF.width();
                fAbs = sizeB6.height - Math.abs(rectF.height());
                if (zA) {
                    float f114 = (pointF6.y - pointF7.y) - (pointF2.y - pointF3.y);
                    rectF2.set(0.0f, f114, fWidth, (-fAbs) + f114);
                } else if (zA4) {
                    float f115 = (pointF5.x - pointF8.x) - (pointF.x - pointF4.x);
                    rectF2.set(f115, 0.0f, fWidth + f115, -fAbs);
                } else if (zA3) {
                    float f116 = (pointF5.y - pointF8.y) - (pointF.y - pointF4.y);
                    rectF2.set(-fWidth, -f116, 0.0f, (-fAbs) - f116);
                } else if (zA2) {
                    float f117 = (pointF6.x - pointF8.x) - (pointF2.x - pointF4.x);
                    rectF2.set(-f117, fAbs, fWidth - f117, 0.0f);
                }
                f5 = rectF2.left;
                rectF3 = this.d;
                if (f5 < rectF3.left - rectF.left) {
                    break;
                }
                rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            case 5:
                f7 = 1.0f;
                i4 = 2;
                pageRotation = annotation.getInternal().getPageRotation();
                if (bVar != o4.b.TOP_CENTER) {
                    float f118 = -f6;
                    f6 = f7;
                    f7 = f118;
                } else {
                    float f119 = -f6;
                    f6 = f7;
                    f7 = f119;
                }
                i = (i4 + 2) % 4;
                double radians4 = Math.toRadians(annotation.getInternal().getRotation() + pageRotation);
                double d7 = f;
                double d8 = f2;
                dCos = ((Math.cos(radians4) * d7) - (Math.sin(radians4) * d8)) * ((double) f6);
                dCos2 = ((Math.cos(radians4) * d8) + (Math.sin(radians4) * d7)) * ((double) f7);
                contentSize = annotation.getInternal().getContentSize(this.f);
                if (contentSize == null) {
                    return;
                }
                contentSize.sort();
                Size sizeB7 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                ArrayList arrayListA7 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF = (PointF) arrayListA7.get(i4);
                pointF2 = (PointF) arrayListA7.get(i);
                int i11 = (i + 1) % 4;
                pointF3 = (PointF) arrayListA7.get(i11);
                int i12 = (i + 5) % 4;
                pointF4 = (PointF) arrayListA7.get(i12);
                float f1110 = 2;
                zA = ip.a(pointF2.x, (-sizeB7.width) / f1110);
                zA2 = ip.a(pointF2.y, sizeB7.height / f1110);
                zA3 = ip.a(pointF2.x, sizeB7.width / f1110);
                zA4 = ip.a(pointF2.y, (-sizeB7.height) / f1110);
                contentSize.set(0.0f, 0.0f, ip.a(f3, (float) (((double) contentSize.width()) + dCos)), ip.a(f4, (float) (((double) contentSize.height()) - dCos2)));
                ArrayList arrayListA8 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF5 = (PointF) arrayListA8.get(i4);
                pointF6 = (PointF) arrayListA8.get(i);
                pointF7 = (PointF) arrayListA8.get(i11);
                pointF8 = (PointF) arrayListA8.get(i12);
                Size sizeB8 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                fWidth = sizeB8.width - rectF.width();
                fAbs = sizeB8.height - Math.abs(rectF.height());
                if (zA) {
                    float f1111 = (pointF6.y - pointF7.y) - (pointF2.y - pointF3.y);
                    rectF2.set(0.0f, f1111, fWidth, (-fAbs) + f1111);
                } else if (zA4) {
                    float f1112 = (pointF5.x - pointF8.x) - (pointF.x - pointF4.x);
                    rectF2.set(f1112, 0.0f, fWidth + f1112, -fAbs);
                } else if (zA3) {
                    float f1113 = (pointF5.y - pointF8.y) - (pointF.y - pointF4.y);
                    rectF2.set(-fWidth, -f1113, 0.0f, (-fAbs) - f1113);
                } else if (zA2) {
                    float f1114 = (pointF6.x - pointF8.x) - (pointF2.x - pointF4.x);
                    rectF2.set(-f1114, fAbs, fWidth - f1114, 0.0f);
                }
                f5 = rectF2.left;
                rectF3 = this.d;
                if (f5 < rectF3.left - rectF.left) {
                    break;
                }
                rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            case 6:
                f7 = 1.0f;
                i4 = 2;
                f6 = 0.0f;
                pageRotation = annotation.getInternal().getPageRotation();
                if (bVar != o4.b.TOP_CENTER) {
                    float f1115 = -f6;
                    f6 = f7;
                    f7 = f1115;
                } else {
                    float f1116 = -f6;
                    f6 = f7;
                    f7 = f1116;
                }
                i = (i4 + 2) % 4;
                double radians5 = Math.toRadians(annotation.getInternal().getRotation() + pageRotation);
                double d9 = f;
                double d10 = f2;
                dCos = ((Math.cos(radians5) * d9) - (Math.sin(radians5) * d10)) * ((double) f6);
                dCos2 = ((Math.cos(radians5) * d10) + (Math.sin(radians5) * d9)) * ((double) f7);
                contentSize = annotation.getInternal().getContentSize(this.f);
                if (contentSize == null) {
                    return;
                }
                contentSize.sort();
                Size sizeB9 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                ArrayList arrayListA9 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF = (PointF) arrayListA9.get(i4);
                pointF2 = (PointF) arrayListA9.get(i);
                int i13 = (i + 1) % 4;
                pointF3 = (PointF) arrayListA9.get(i13);
                int i14 = (i + 5) % 4;
                pointF4 = (PointF) arrayListA9.get(i14);
                float f1117 = 2;
                zA = ip.a(pointF2.x, (-sizeB9.width) / f1117);
                zA2 = ip.a(pointF2.y, sizeB9.height / f1117);
                zA3 = ip.a(pointF2.x, sizeB9.width / f1117);
                zA4 = ip.a(pointF2.y, (-sizeB9.height) / f1117);
                contentSize.set(0.0f, 0.0f, ip.a(f3, (float) (((double) contentSize.width()) + dCos)), ip.a(f4, (float) (((double) contentSize.height()) - dCos2)));
                ArrayList arrayListA10 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF5 = (PointF) arrayListA10.get(i4);
                pointF6 = (PointF) arrayListA10.get(i);
                pointF7 = (PointF) arrayListA10.get(i13);
                pointF8 = (PointF) arrayListA10.get(i14);
                Size sizeB10 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                fWidth = sizeB10.width - rectF.width();
                fAbs = sizeB10.height - Math.abs(rectF.height());
                if (zA) {
                    float f1118 = (pointF6.y - pointF7.y) - (pointF2.y - pointF3.y);
                    rectF2.set(0.0f, f1118, fWidth, (-fAbs) + f1118);
                } else if (zA4) {
                    float f1119 = (pointF5.x - pointF8.x) - (pointF.x - pointF4.x);
                    rectF2.set(f1119, 0.0f, fWidth + f1119, -fAbs);
                } else if (zA3) {
                    float f11110 = (pointF5.y - pointF8.y) - (pointF.y - pointF4.y);
                    rectF2.set(-fWidth, -f11110, 0.0f, (-fAbs) - f11110);
                } else if (zA2) {
                    float f11111 = (pointF6.x - pointF8.x) - (pointF2.x - pointF4.x);
                    rectF2.set(-f11111, fAbs, fWidth - f11111, 0.0f);
                }
                f5 = rectF2.left;
                rectF3 = this.d;
                if (f5 < rectF3.left - rectF.left) {
                    break;
                }
                rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            case 7:
                f7 = 1.0f;
                f6 = -1.0f;
                pageRotation = annotation.getInternal().getPageRotation();
                if (bVar != o4.b.TOP_CENTER) {
                    float f11112 = -f6;
                    f6 = f7;
                    f7 = f11112;
                } else {
                    float f11113 = -f6;
                    f6 = f7;
                    f7 = f11113;
                }
                i = (i4 + 2) % 4;
                double radians6 = Math.toRadians(annotation.getInternal().getRotation() + pageRotation);
                double d11 = f;
                double d12 = f2;
                dCos = ((Math.cos(radians6) * d11) - (Math.sin(radians6) * d12)) * ((double) f6);
                dCos2 = ((Math.cos(radians6) * d12) + (Math.sin(radians6) * d11)) * ((double) f7);
                contentSize = annotation.getInternal().getContentSize(this.f);
                if (contentSize == null) {
                    return;
                }
                contentSize.sort();
                Size sizeB11 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                ArrayList arrayListA11 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF = (PointF) arrayListA11.get(i4);
                pointF2 = (PointF) arrayListA11.get(i);
                int i15 = (i + 1) % 4;
                pointF3 = (PointF) arrayListA11.get(i15);
                int i16 = (i + 5) % 4;
                pointF4 = (PointF) arrayListA11.get(i16);
                float f11114 = 2;
                zA = ip.a(pointF2.x, (-sizeB11.width) / f11114);
                zA2 = ip.a(pointF2.y, sizeB11.height / f11114);
                zA3 = ip.a(pointF2.x, sizeB11.width / f11114);
                zA4 = ip.a(pointF2.y, (-sizeB11.height) / f11114);
                contentSize.set(0.0f, 0.0f, ip.a(f3, (float) (((double) contentSize.width()) + dCos)), ip.a(f4, (float) (((double) contentSize.height()) - dCos2)));
                ArrayList arrayListA12 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF5 = (PointF) arrayListA12.get(i4);
                pointF6 = (PointF) arrayListA12.get(i);
                pointF7 = (PointF) arrayListA12.get(i15);
                pointF8 = (PointF) arrayListA12.get(i16);
                Size sizeB12 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                fWidth = sizeB12.width - rectF.width();
                fAbs = sizeB12.height - Math.abs(rectF.height());
                if (zA) {
                    float f11115 = (pointF6.y - pointF7.y) - (pointF2.y - pointF3.y);
                    rectF2.set(0.0f, f11115, fWidth, (-fAbs) + f11115);
                } else if (zA4) {
                    float f11116 = (pointF5.x - pointF8.x) - (pointF.x - pointF4.x);
                    rectF2.set(f11116, 0.0f, fWidth + f11116, -fAbs);
                } else if (zA3) {
                    float f11117 = (pointF5.y - pointF8.y) - (pointF.y - pointF4.y);
                    rectF2.set(-fWidth, -f11117, 0.0f, (-fAbs) - f11117);
                } else if (zA2) {
                    float f11118 = (pointF6.x - pointF8.x) - (pointF2.x - pointF4.x);
                    rectF2.set(-f11118, fAbs, fWidth - f11118, 0.0f);
                }
                f5 = rectF2.left;
                rectF3 = this.d;
                if (f5 < rectF3.left - rectF.left) {
                    break;
                }
                rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            case 8:
                f6 = -1.0f;
                f7 = 0.0f;
                pageRotation = annotation.getInternal().getPageRotation();
                if (bVar != o4.b.TOP_CENTER) {
                    float f11119 = -f6;
                    f6 = f7;
                    f7 = f11119;
                } else {
                    float f111110 = -f6;
                    f6 = f7;
                    f7 = f111110;
                }
                i = (i4 + 2) % 4;
                double radians7 = Math.toRadians(annotation.getInternal().getRotation() + pageRotation);
                double d13 = f;
                double d14 = f2;
                dCos = ((Math.cos(radians7) * d13) - (Math.sin(radians7) * d14)) * ((double) f6);
                dCos2 = ((Math.cos(radians7) * d14) + (Math.sin(radians7) * d13)) * ((double) f7);
                contentSize = annotation.getInternal().getContentSize(this.f);
                if (contentSize == null) {
                    return;
                }
                contentSize.sort();
                Size sizeB13 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                ArrayList arrayListA13 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF = (PointF) arrayListA13.get(i4);
                pointF2 = (PointF) arrayListA13.get(i);
                int i17 = (i + 1) % 4;
                pointF3 = (PointF) arrayListA13.get(i17);
                int i18 = (i + 5) % 4;
                pointF4 = (PointF) arrayListA13.get(i18);
                float f111111 = 2;
                zA = ip.a(pointF2.x, (-sizeB13.width) / f111111);
                zA2 = ip.a(pointF2.y, sizeB13.height / f111111);
                zA3 = ip.a(pointF2.x, sizeB13.width / f111111);
                zA4 = ip.a(pointF2.y, (-sizeB13.height) / f111111);
                contentSize.set(0.0f, 0.0f, ip.a(f3, (float) (((double) contentSize.width()) + dCos)), ip.a(f4, (float) (((double) contentSize.height()) - dCos2)));
                ArrayList arrayListA14 = ip.a(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                pointF5 = (PointF) arrayListA14.get(i4);
                pointF6 = (PointF) arrayListA14.get(i);
                pointF7 = (PointF) arrayListA14.get(i17);
                pointF8 = (PointF) arrayListA14.get(i18);
                Size sizeB14 = ip.b(new Size(contentSize.width(), contentSize.height()), annotation.getInternal().getRotation() + pageRotation);
                fWidth = sizeB14.width - rectF.width();
                fAbs = sizeB14.height - Math.abs(rectF.height());
                if (zA) {
                    float f111112 = (pointF6.y - pointF7.y) - (pointF2.y - pointF3.y);
                    rectF2.set(0.0f, f111112, fWidth, (-fAbs) + f111112);
                } else if (zA4) {
                    float f111113 = (pointF5.x - pointF8.x) - (pointF.x - pointF4.x);
                    rectF2.set(f111113, 0.0f, fWidth + f111113, -fAbs);
                } else if (zA3) {
                    float f111114 = (pointF5.y - pointF8.y) - (pointF.y - pointF4.y);
                    rectF2.set(-fWidth, -f111114, 0.0f, (-fAbs) - f111114);
                } else if (zA2) {
                    float f111115 = (pointF6.x - pointF8.x) - (pointF2.x - pointF4.x);
                    rectF2.set(-f111115, fAbs, fWidth - f111115, 0.0f);
                }
                f5 = rectF2.left;
                rectF3 = this.d;
                if (f5 < rectF3.left - rectF.left) {
                    break;
                }
                rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                return;
            default:
                throw new IllegalStateException("Touched unhandled handle: " + bVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0236 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x0238 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x023b  */
    /* JADX WARN: Code duplicated, block: B:104:0x024c  */
    /* JADX WARN: Code duplicated, block: B:105:0x025d  */
    /* JADX WARN: Code duplicated, block: B:106:0x026e  */
    /* JADX WARN: Code duplicated, block: B:109:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:110:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:113:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:115:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:123:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:125:0x02f1 A[PHI: r26
      0x02f1: PHI (r26v4 boolean) = (r26v2 boolean), (r26v2 boolean), (r26v5 boolean) binds: [B:112:0x02c7, B:120:0x02dc, B:87:0x0206] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:130:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:131:0x0300  */
    /* JADX WARN: Code duplicated, block: B:132:0x0302  */
    /* JADX WARN: Code duplicated, block: B:133:0x0304  */
    /* JADX WARN: Code duplicated, block: B:134:0x0306  */
    /* JADX WARN: Code duplicated, block: B:140:0x030f  */
    /* JADX WARN: Code duplicated, block: B:142:0x0347  */
    /* JADX WARN: Code duplicated, block: B:144:0x0371  */
    /* JADX WARN: Code duplicated, block: B:146:0x0377  */
    /* JADX WARN: Code duplicated, block: B:148:0x037a  */
    /* JADX WARN: Code duplicated, block: B:152:0x0380  */
    /* JADX WARN: Code duplicated, block: B:154:0x0383  */
    /* JADX WARN: Code duplicated, block: B:158:0x038e  */
    /* JADX WARN: Code duplicated, block: B:159:0x0394  */
    /* JADX WARN: Code duplicated, block: B:161:0x039a  */
    /* JADX WARN: Code duplicated, block: B:173:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:179:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:67:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:76:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:80:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:81:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:82:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:83:0x0200  */
    /* JADX WARN: Code duplicated, block: B:87:0x0206  */
    /* JADX WARN: Code duplicated, block: B:88:0x020a  */
    /* JADX WARN: Code duplicated, block: B:90:0x021e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0222  */
    /* JADX WARN: Code duplicated, block: B:93:0x0225  */
    /* JADX WARN: Code duplicated, block: B:97:0x022e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0234 A[DONT_INVERT] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(float f, float f2, final jf jfVar, MotionEvent motionEvent) {
        o4.b bVar;
        final o4.b bVar2;
        z4<?> z4Var;
        Function2 function2;
        int i;
        Annotation annotation;
        Float f3;
        PointF pointF;
        char c;
        RectF rectF;
        float fAbs;
        float fAbs2;
        int iOrdinal;
        float f4;
        float f5;
        float fB;
        float fD;
        float f6;
        float f7;
        float f8;
        float f9;
        boolean z;
        float fSqrt;
        float f10;
        float f11;
        int iOrdinal2;
        boolean z2;
        float f12;
        char c2;
        RectF rectF2;
        float fAbs3;
        float fAbs4;
        RectF rectF3;
        float f13;
        RectF rectF4;
        int iOrdinal3;
        int iOrdinal4;
        if (this.a.getParent() == null || !this.g || this.s || (bVar = jfVar.a.a) == o4.b.ROTATION) {
            return;
        }
        final RectF rectF5 = new RectF();
        float f14 = f + jfVar.h;
        float f15 = f2 + jfVar.i;
        RectF rectF6 = jfVar.f;
        OverlayLayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams != null) {
            RectF pageRect = layoutParams.pageRect.getPageRect();
            pageRect.getClass();
            this.d.set(this.a.getPdfViewGroup().getPdfRect());
            float fB2 = ip.b(this.e.a, this.d.left);
            float fA = ip.a(this.e.c, this.d.right);
            float fB3 = ip.b(this.e.d, this.d.bottom);
            float fA2 = ip.a(this.e.b, this.d.top);
            float fB4 = ip.b(this.u.width, pageRect.right - pageRect.left);
            float fB5 = ip.b(this.u.height, pageRect.top - pageRect.bottom);
            float f16 = pageRect.left;
            float fMax = Math.max(fB2 - f16, Math.min(f14, (pageRect.right - fB4) - f16));
            float f17 = pageRect.left + fB4;
            float f18 = pageRect.right;
            float fMax2 = Math.max(f17 - f18, Math.min(f14, fA - f18));
            float f19 = pageRect.bottom;
            float fMax3 = Math.max(fB3 - f19, Math.min(f15, (pageRect.top - fB5) - f19));
            float f20 = pageRect.bottom + fB5;
            float f21 = pageRect.top;
            float fMax4 = Math.max(f20 - f21, Math.min(f15, fA2 - f21));
            boolean z3 = jfVar.d;
            if (!z3 && !jfVar.c && !jfVar.b && !jfVar.e) {
                if (this.b.isAnnotationLimitedToPageBounds()) {
                    if (f14 >= 0.0f) {
                        fMax = fMax2;
                    }
                    rectF5.right = fMax;
                    if (f15 >= 0.0f) {
                        fMax3 = fMax4;
                    }
                    rectF5.top = fMax3;
                } else {
                    rectF5.right = f14;
                    rectF5.top = f15;
                }
                rectF5.left = rectF5.right;
                rectF5.bottom = rectF5.top;
            } else {
                if (z3) {
                    fMax = 0.0f;
                }
                rectF5.left = fMax;
                if (jfVar.c) {
                    fMax2 = 0.0f;
                }
                rectF5.right = fMax2;
                if (jfVar.e) {
                    fMax3 = 0.0f;
                }
                rectF5.bottom = fMax3;
                if (jfVar.b) {
                    fMax4 = 0.0f;
                }
                rectF5.top = fMax4;
            }
            if (bVar == null) {
                bVar2 = bVar;
                z4Var = null;
            } else if (!this.n && this.a.getChildCount() == 1) {
                z4 z4VarB = this.a.b();
                if (((z4VarB != null ? z4VarB.getAnnotation() : null) instanceof FreeTextAnnotation) && this.g && this.a.getRotationHandler().a()) {
                    z4 z4VarB2 = this.a.b();
                    Annotation annotation2 = z4VarB2 != null ? z4VarB2.getAnnotation() : null;
                    if (annotation2 != null) {
                        bVar2 = bVar;
                        a(bVar2, annotation2, f14, f15, fB4, fB5, pageRect, rectF5);
                    } else {
                        bVar2 = bVar;
                    }
                } else {
                    bVar2 = bVar;
                    if (this.l) {
                    }
                }
                z4Var = null;
            } else {
                bVar2 = bVar;
                if (this.l || !this.o) {
                    z4Var = null;
                } else {
                    jz jzVar = this.a.l;
                    RectF rectF7 = this.d;
                    boolean z4 = this.n;
                    jzVar.getClass();
                    mx mxVar = new mx(pageRect, rectF5);
                    jzVar.f = bVar2;
                    if (Math.abs((pageRect.right + rectF5.right) - (pageRect.left + rectF5.left)) == fB4) {
                        RectF rectF8 = mxVar.a;
                        float f22 = rectF8.top;
                        RectF rectF9 = mxVar.b;
                        if (Math.abs((f22 + rectF9.top) - (rectF8.bottom + rectF9.bottom)) != fB5) {
                            switch (bVar2.ordinal()) {
                                case 0:
                                case 7:
                                    c = 4;
                                    break;
                                case 1:
                                case 6:
                                    c = 3;
                                    break;
                                case 2:
                                case 5:
                                    c = 5;
                                    break;
                                case 3:
                                case 4:
                                    c = 2;
                                    break;
                                default:
                                    c = 1;
                                    break;
                            }
                            if (c != 4 || c == 5) {
                                rectF = mxVar.b;
                                fAbs = Math.abs(rectF6.width());
                                fAbs2 = Math.abs(rectF6.height());
                                if (z4) {
                                    iOrdinal = bVar2.ordinal();
                                    if (iOrdinal != 0) {
                                        f4 = rectF6.left;
                                        f5 = rectF6.top;
                                        fB = mxVar.b();
                                        fD = mxVar.d();
                                        f6 = rectF6.right;
                                        f7 = rectF6.bottom;
                                    } else if (iOrdinal != 2) {
                                        f4 = rectF6.right;
                                        f5 = rectF6.top;
                                        fB = mxVar.c();
                                        fD = mxVar.d();
                                        f6 = rectF6.left;
                                        f7 = rectF6.bottom;
                                    } else if (iOrdinal != 5) {
                                        if (iOrdinal != 7) {
                                            z = z4;
                                        } else {
                                            f4 = rectF6.right;
                                            f5 = rectF6.bottom;
                                            fB = mxVar.c();
                                            fD = mxVar.a();
                                            f6 = rectF6.left;
                                            f7 = rectF6.top;
                                        }
                                        z2 = false;
                                    } else {
                                        f4 = rectF6.left;
                                        f5 = rectF6.bottom;
                                        fB = mxVar.b();
                                        fD = mxVar.a();
                                        f6 = rectF6.right;
                                        f7 = rectF6.top;
                                    }
                                    f8 = (f7 - f5) / (f6 - f4);
                                    f9 = f7 - (f8 * f6);
                                    float f23 = f7 - fD;
                                    float f24 = f5;
                                    float f25 = f6 - fB;
                                    double dAbs = Math.abs(((f6 * fD) + ((f4 * f23) - (f24 * f25))) - (f7 * fB));
                                    z = z4;
                                    fSqrt = (float) (dAbs / Math.sqrt(Math.pow(f25, 2.0d) + Math.pow(f23, 2.0d)));
                                    if (z) {
                                        f10 = Float.MAX_VALUE;
                                    } else {
                                        f10 = jzVar.b;
                                    }
                                    if (fSqrt < f10 / jzVar.a.getZoomScale()) {
                                        f11 = ((f8 * fB) + f9) - fD;
                                        iOrdinal2 = bVar2.ordinal();
                                        if (iOrdinal2 != 0 || iOrdinal2 == 2) {
                                            rectF.top += f11;
                                        } else if (iOrdinal2 == 5 || iOrdinal2 == 7) {
                                            rectF.bottom += f11;
                                        } else {
                                            z2 = false;
                                        }
                                        jz.a(bVar2, mxVar, rectF7);
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                } else {
                                    if (fAbs > fAbs2) {
                                        f12 = fAbs / fAbs2;
                                    } else {
                                        f12 = fAbs2 / fAbs;
                                    }
                                    if (f12 >= 3.0f) {
                                        z = z4;
                                        z2 = false;
                                    } else {
                                        iOrdinal = bVar2.ordinal();
                                        if (iOrdinal != 0) {
                                            f4 = rectF6.left;
                                            f5 = rectF6.top;
                                            fB = mxVar.b();
                                            fD = mxVar.d();
                                            f6 = rectF6.right;
                                            f7 = rectF6.bottom;
                                        } else if (iOrdinal != 2) {
                                            f4 = rectF6.right;
                                            f5 = rectF6.top;
                                            fB = mxVar.c();
                                            fD = mxVar.d();
                                            f6 = rectF6.left;
                                            f7 = rectF6.bottom;
                                        } else if (iOrdinal != 5) {
                                            if (iOrdinal != 7) {
                                                z = z4;
                                            } else {
                                                f4 = rectF6.right;
                                                f5 = rectF6.bottom;
                                                fB = mxVar.c();
                                                fD = mxVar.a();
                                                f6 = rectF6.left;
                                                f7 = rectF6.top;
                                            }
                                            z2 = false;
                                        } else {
                                            f4 = rectF6.left;
                                            f5 = rectF6.bottom;
                                            fB = mxVar.b();
                                            fD = mxVar.a();
                                            f6 = rectF6.right;
                                            f7 = rectF6.top;
                                        }
                                        f8 = (f7 - f5) / (f6 - f4);
                                        f9 = f7 - (f8 * f6);
                                        float f26 = f7 - fD;
                                        float f27 = f5;
                                        float f28 = f6 - fB;
                                        double dAbs2 = Math.abs(((f6 * fD) + ((f4 * f26) - (f27 * f28))) - (f7 * fB));
                                        z = z4;
                                        fSqrt = (float) (dAbs2 / Math.sqrt(Math.pow(f28, 2.0d) + Math.pow(f26, 2.0d)));
                                        if (z) {
                                            f10 = Float.MAX_VALUE;
                                        } else {
                                            f10 = jzVar.b;
                                        }
                                        if (fSqrt < f10 / jzVar.a.getZoomScale()) {
                                            f11 = ((f8 * fB) + f9) - fD;
                                            iOrdinal2 = bVar2.ordinal();
                                            if (iOrdinal2 != 0) {
                                                rectF.top += f11;
                                            } else {
                                                rectF.top += f11;
                                            }
                                            jz.a(bVar2, mxVar, rectF7);
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                    }
                                }
                            } else {
                                z = z4;
                                z2 = false;
                            }
                            if (!z2 && !z) {
                                switch (bVar2.ordinal()) {
                                    case 0:
                                    case 7:
                                        c2 = 4;
                                        break;
                                    case 1:
                                    case 6:
                                        c2 = 3;
                                        break;
                                    case 2:
                                    case 5:
                                        c2 = 5;
                                        break;
                                    case 3:
                                    case 4:
                                        c2 = 2;
                                        break;
                                    default:
                                        c2 = 1;
                                        break;
                                }
                                if (c2 != 3 || c2 == 2) {
                                    rectF2 = mxVar.b;
                                    RectF rectF10 = mxVar.a;
                                    float fAbs5 = Math.abs((rectF10.right + rectF2.right) - (rectF10.left + rectF2.left));
                                    RectF rectF11 = mxVar.a;
                                    float f29 = rectF11.top;
                                    RectF rectF12 = mxVar.b;
                                    fAbs3 = Math.abs(fAbs5 - Math.abs((f29 + rectF12.top) - (rectF11.bottom + rectF12.bottom)));
                                    if (fAbs3 < jzVar.b / jzVar.a.getZoomScale()) {
                                        RectF rectF13 = mxVar.a;
                                        float f30 = rectF13.right;
                                        RectF rectF14 = mxVar.b;
                                        fAbs4 = Math.abs((f30 + rectF14.right) - (rectF13.left + rectF14.left));
                                        rectF3 = mxVar.a;
                                        f13 = rectF3.top;
                                        rectF4 = mxVar.b;
                                        if (fAbs4 < Math.abs((f13 + rectF4.top) - (rectF3.bottom + rectF4.bottom))) {
                                            iOrdinal4 = bVar2.ordinal();
                                            if (iOrdinal4 != 0) {
                                                if (iOrdinal4 != 7 && iOrdinal4 != 2) {
                                                    if (iOrdinal4 != 3) {
                                                        if (iOrdinal4 != 4) {
                                                            if (iOrdinal4 != 5) {
                                                                z2 = false;
                                                            }
                                                        }
                                                    }
                                                    rectF2.left -= fAbs3;
                                                }
                                                rectF2.right += fAbs3;
                                            } else {
                                                rectF2.left -= fAbs3;
                                            }
                                            z2 = !jz.a(bVar2, mxVar, rectF7);
                                        } else {
                                            iOrdinal3 = bVar2.ordinal();
                                            if (iOrdinal3 != 0 || iOrdinal3 == 1 || iOrdinal3 == 2) {
                                                rectF2.top += fAbs3;
                                            } else if (iOrdinal3 == 5 || iOrdinal3 == 6 || iOrdinal3 == 7) {
                                                rectF2.bottom -= fAbs3;
                                            } else {
                                                z2 = false;
                                            }
                                            z2 = !jz.a(bVar2, mxVar, rectF7);
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                } else {
                                    z2 = false;
                                }
                            }
                        } else {
                            z2 = false;
                        }
                    } else {
                        switch (bVar2.ordinal()) {
                            case 0:
                            case 7:
                                c = 4;
                                break;
                            case 1:
                            case 6:
                                c = 3;
                                break;
                            case 2:
                            case 5:
                                c = 5;
                                break;
                            case 3:
                            case 4:
                                c = 2;
                                break;
                            default:
                                c = 1;
                                break;
                        }
                        if (c != 4) {
                            rectF = mxVar.b;
                            fAbs = Math.abs(rectF6.width());
                            fAbs2 = Math.abs(rectF6.height());
                            if (z4) {
                                iOrdinal = bVar2.ordinal();
                                if (iOrdinal != 0) {
                                    f4 = rectF6.left;
                                    f5 = rectF6.top;
                                    fB = mxVar.b();
                                    fD = mxVar.d();
                                    f6 = rectF6.right;
                                    f7 = rectF6.bottom;
                                } else if (iOrdinal != 2) {
                                    f4 = rectF6.right;
                                    f5 = rectF6.top;
                                    fB = mxVar.c();
                                    fD = mxVar.d();
                                    f6 = rectF6.left;
                                    f7 = rectF6.bottom;
                                } else if (iOrdinal != 5) {
                                    if (iOrdinal != 7) {
                                        z = z4;
                                    } else {
                                        f4 = rectF6.right;
                                        f5 = rectF6.bottom;
                                        fB = mxVar.c();
                                        fD = mxVar.a();
                                        f6 = rectF6.left;
                                        f7 = rectF6.top;
                                    }
                                    z2 = false;
                                } else {
                                    f4 = rectF6.left;
                                    f5 = rectF6.bottom;
                                    fB = mxVar.b();
                                    fD = mxVar.a();
                                    f6 = rectF6.right;
                                    f7 = rectF6.top;
                                }
                                f8 = (f7 - f5) / (f6 - f4);
                                f9 = f7 - (f8 * f6);
                                float f210 = f7 - fD;
                                float f211 = f5;
                                float f212 = f6 - fB;
                                double dAbs3 = Math.abs(((f6 * fD) + ((f4 * f210) - (f211 * f212))) - (f7 * fB));
                                z = z4;
                                fSqrt = (float) (dAbs3 / Math.sqrt(Math.pow(f212, 2.0d) + Math.pow(f210, 2.0d)));
                                if (z) {
                                    f10 = Float.MAX_VALUE;
                                } else {
                                    f10 = jzVar.b;
                                }
                                if (fSqrt < f10 / jzVar.a.getZoomScale()) {
                                    f11 = ((f8 * fB) + f9) - fD;
                                    iOrdinal2 = bVar2.ordinal();
                                    if (iOrdinal2 != 0) {
                                        rectF.top += f11;
                                    } else {
                                        rectF.top += f11;
                                    }
                                    jz.a(bVar2, mxVar, rectF7);
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                if (fAbs > fAbs2) {
                                    f12 = fAbs / fAbs2;
                                } else {
                                    f12 = fAbs2 / fAbs;
                                }
                                if (f12 >= 3.0f) {
                                    z = z4;
                                    z2 = false;
                                } else {
                                    iOrdinal = bVar2.ordinal();
                                    if (iOrdinal != 0) {
                                        f4 = rectF6.left;
                                        f5 = rectF6.top;
                                        fB = mxVar.b();
                                        fD = mxVar.d();
                                        f6 = rectF6.right;
                                        f7 = rectF6.bottom;
                                    } else if (iOrdinal != 2) {
                                        f4 = rectF6.right;
                                        f5 = rectF6.top;
                                        fB = mxVar.c();
                                        fD = mxVar.d();
                                        f6 = rectF6.left;
                                        f7 = rectF6.bottom;
                                    } else if (iOrdinal != 5) {
                                        if (iOrdinal != 7) {
                                            z = z4;
                                        } else {
                                            f4 = rectF6.right;
                                            f5 = rectF6.bottom;
                                            fB = mxVar.c();
                                            fD = mxVar.a();
                                            f6 = rectF6.left;
                                            f7 = rectF6.top;
                                        }
                                        z2 = false;
                                    } else {
                                        f4 = rectF6.left;
                                        f5 = rectF6.bottom;
                                        fB = mxVar.b();
                                        fD = mxVar.a();
                                        f6 = rectF6.right;
                                        f7 = rectF6.top;
                                    }
                                    f8 = (f7 - f5) / (f6 - f4);
                                    f9 = f7 - (f8 * f6);
                                    float f213 = f7 - fD;
                                    float f214 = f5;
                                    float f215 = f6 - fB;
                                    double dAbs4 = Math.abs(((f6 * fD) + ((f4 * f213) - (f214 * f215))) - (f7 * fB));
                                    z = z4;
                                    fSqrt = (float) (dAbs4 / Math.sqrt(Math.pow(f215, 2.0d) + Math.pow(f213, 2.0d)));
                                    if (z) {
                                        f10 = Float.MAX_VALUE;
                                    } else {
                                        f10 = jzVar.b;
                                    }
                                    if (fSqrt < f10 / jzVar.a.getZoomScale()) {
                                        f11 = ((f8 * fB) + f9) - fD;
                                        iOrdinal2 = bVar2.ordinal();
                                        if (iOrdinal2 != 0) {
                                            rectF.top += f11;
                                        } else {
                                            rectF.top += f11;
                                        }
                                        jz.a(bVar2, mxVar, rectF7);
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                }
                            }
                        } else {
                            rectF = mxVar.b;
                            fAbs = Math.abs(rectF6.width());
                            fAbs2 = Math.abs(rectF6.height());
                            if (z4) {
                                iOrdinal = bVar2.ordinal();
                                if (iOrdinal != 0) {
                                    f4 = rectF6.left;
                                    f5 = rectF6.top;
                                    fB = mxVar.b();
                                    fD = mxVar.d();
                                    f6 = rectF6.right;
                                    f7 = rectF6.bottom;
                                } else if (iOrdinal != 2) {
                                    f4 = rectF6.right;
                                    f5 = rectF6.top;
                                    fB = mxVar.c();
                                    fD = mxVar.d();
                                    f6 = rectF6.left;
                                    f7 = rectF6.bottom;
                                } else if (iOrdinal != 5) {
                                    if (iOrdinal != 7) {
                                        z = z4;
                                    } else {
                                        f4 = rectF6.right;
                                        f5 = rectF6.bottom;
                                        fB = mxVar.c();
                                        fD = mxVar.a();
                                        f6 = rectF6.left;
                                        f7 = rectF6.top;
                                    }
                                    z2 = false;
                                } else {
                                    f4 = rectF6.left;
                                    f5 = rectF6.bottom;
                                    fB = mxVar.b();
                                    fD = mxVar.a();
                                    f6 = rectF6.right;
                                    f7 = rectF6.top;
                                }
                                f8 = (f7 - f5) / (f6 - f4);
                                f9 = f7 - (f8 * f6);
                                float f216 = f7 - fD;
                                float f217 = f5;
                                float f218 = f6 - fB;
                                double dAbs5 = Math.abs(((f6 * fD) + ((f4 * f216) - (f217 * f218))) - (f7 * fB));
                                z = z4;
                                fSqrt = (float) (dAbs5 / Math.sqrt(Math.pow(f218, 2.0d) + Math.pow(f216, 2.0d)));
                                if (z) {
                                    f10 = Float.MAX_VALUE;
                                } else {
                                    f10 = jzVar.b;
                                }
                                if (fSqrt < f10 / jzVar.a.getZoomScale()) {
                                    f11 = ((f8 * fB) + f9) - fD;
                                    iOrdinal2 = bVar2.ordinal();
                                    if (iOrdinal2 != 0) {
                                        rectF.top += f11;
                                    } else {
                                        rectF.top += f11;
                                    }
                                    jz.a(bVar2, mxVar, rectF7);
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                if (fAbs > fAbs2) {
                                    f12 = fAbs / fAbs2;
                                } else {
                                    f12 = fAbs2 / fAbs;
                                }
                                if (f12 >= 3.0f) {
                                    z = z4;
                                    z2 = false;
                                } else {
                                    iOrdinal = bVar2.ordinal();
                                    if (iOrdinal != 0) {
                                        f4 = rectF6.left;
                                        f5 = rectF6.top;
                                        fB = mxVar.b();
                                        fD = mxVar.d();
                                        f6 = rectF6.right;
                                        f7 = rectF6.bottom;
                                    } else if (iOrdinal != 2) {
                                        f4 = rectF6.right;
                                        f5 = rectF6.top;
                                        fB = mxVar.c();
                                        fD = mxVar.d();
                                        f6 = rectF6.left;
                                        f7 = rectF6.bottom;
                                    } else if (iOrdinal != 5) {
                                        if (iOrdinal != 7) {
                                            z = z4;
                                        } else {
                                            f4 = rectF6.right;
                                            f5 = rectF6.bottom;
                                            fB = mxVar.c();
                                            fD = mxVar.a();
                                            f6 = rectF6.left;
                                            f7 = rectF6.top;
                                        }
                                        z2 = false;
                                    } else {
                                        f4 = rectF6.left;
                                        f5 = rectF6.bottom;
                                        fB = mxVar.b();
                                        fD = mxVar.a();
                                        f6 = rectF6.right;
                                        f7 = rectF6.top;
                                    }
                                    f8 = (f7 - f5) / (f6 - f4);
                                    f9 = f7 - (f8 * f6);
                                    float f219 = f7 - fD;
                                    float f2110 = f5;
                                    float f2111 = f6 - fB;
                                    double dAbs6 = Math.abs(((f6 * fD) + ((f4 * f219) - (f2110 * f2111))) - (f7 * fB));
                                    z = z4;
                                    fSqrt = (float) (dAbs6 / Math.sqrt(Math.pow(f2111, 2.0d) + Math.pow(f219, 2.0d)));
                                    if (z) {
                                        f10 = Float.MAX_VALUE;
                                    } else {
                                        f10 = jzVar.b;
                                    }
                                    if (fSqrt < f10 / jzVar.a.getZoomScale()) {
                                        f11 = ((f8 * fB) + f9) - fD;
                                        iOrdinal2 = bVar2.ordinal();
                                        if (iOrdinal2 != 0) {
                                            rectF.top += f11;
                                        } else {
                                            rectF.top += f11;
                                        }
                                        jz.a(bVar2, mxVar, rectF7);
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                }
                            }
                        }
                        if (!z2) {
                            switch (bVar2.ordinal()) {
                                case 0:
                                case 7:
                                    c2 = 4;
                                    break;
                                case 1:
                                case 6:
                                    c2 = 3;
                                    break;
                                case 2:
                                case 5:
                                    c2 = 5;
                                    break;
                                case 3:
                                case 4:
                                    c2 = 2;
                                    break;
                                default:
                                    c2 = 1;
                                    break;
                            }
                            if (c2 != 3) {
                                rectF2 = mxVar.b;
                                RectF rectF15 = mxVar.a;
                                float fAbs6 = Math.abs((rectF15.right + rectF2.right) - (rectF15.left + rectF2.left));
                                RectF rectF16 = mxVar.a;
                                float f220 = rectF16.top;
                                RectF rectF17 = mxVar.b;
                                fAbs3 = Math.abs(fAbs6 - Math.abs((f220 + rectF17.top) - (rectF16.bottom + rectF17.bottom)));
                                if (fAbs3 < jzVar.b / jzVar.a.getZoomScale()) {
                                    RectF rectF18 = mxVar.a;
                                    float f31 = rectF18.right;
                                    RectF rectF19 = mxVar.b;
                                    fAbs4 = Math.abs((f31 + rectF19.right) - (rectF18.left + rectF19.left));
                                    rectF3 = mxVar.a;
                                    f13 = rectF3.top;
                                    rectF4 = mxVar.b;
                                    if (fAbs4 < Math.abs((f13 + rectF4.top) - (rectF3.bottom + rectF4.bottom))) {
                                        iOrdinal4 = bVar2.ordinal();
                                        if (iOrdinal4 != 0) {
                                            if (iOrdinal4 != 7) {
                                                if (iOrdinal4 != 3) {
                                                    if (iOrdinal4 != 4) {
                                                        if (iOrdinal4 != 5) {
                                                            z2 = false;
                                                        }
                                                    }
                                                }
                                                rectF2.left -= fAbs3;
                                            }
                                            rectF2.right += fAbs3;
                                        } else {
                                            rectF2.left -= fAbs3;
                                        }
                                        z2 = !jz.a(bVar2, mxVar, rectF7);
                                    } else {
                                        iOrdinal3 = bVar2.ordinal();
                                        if (iOrdinal3 != 0) {
                                            rectF2.top += fAbs3;
                                        } else {
                                            rectF2.top += fAbs3;
                                        }
                                        z2 = !jz.a(bVar2, mxVar, rectF7);
                                    }
                                } else {
                                    z2 = false;
                                }
                            } else {
                                rectF2 = mxVar.b;
                                RectF rectF110 = mxVar.a;
                                float fAbs7 = Math.abs((rectF110.right + rectF2.right) - (rectF110.left + rectF2.left));
                                RectF rectF111 = mxVar.a;
                                float f221 = rectF111.top;
                                RectF rectF112 = mxVar.b;
                                fAbs3 = Math.abs(fAbs7 - Math.abs((f221 + rectF112.top) - (rectF111.bottom + rectF112.bottom)));
                                if (fAbs3 < jzVar.b / jzVar.a.getZoomScale()) {
                                    RectF rectF113 = mxVar.a;
                                    float f32 = rectF113.right;
                                    RectF rectF114 = mxVar.b;
                                    fAbs4 = Math.abs((f32 + rectF114.right) - (rectF113.left + rectF114.left));
                                    rectF3 = mxVar.a;
                                    f13 = rectF3.top;
                                    rectF4 = mxVar.b;
                                    if (fAbs4 < Math.abs((f13 + rectF4.top) - (rectF3.bottom + rectF4.bottom))) {
                                        iOrdinal4 = bVar2.ordinal();
                                        if (iOrdinal4 != 0) {
                                            if (iOrdinal4 != 7) {
                                                if (iOrdinal4 != 3) {
                                                    if (iOrdinal4 != 4) {
                                                        if (iOrdinal4 != 5) {
                                                            z2 = false;
                                                        }
                                                    }
                                                }
                                                rectF2.left -= fAbs3;
                                            }
                                            rectF2.right += fAbs3;
                                        } else {
                                            rectF2.left -= fAbs3;
                                        }
                                        z2 = !jz.a(bVar2, mxVar, rectF7);
                                    } else {
                                        iOrdinal3 = bVar2.ordinal();
                                        if (iOrdinal3 != 0) {
                                            rectF2.top += fAbs3;
                                        } else {
                                            rectF2.top += fAbs3;
                                        }
                                        z2 = !jz.a(bVar2, mxVar, rectF7);
                                    }
                                } else {
                                    z2 = false;
                                }
                            }
                        }
                    }
                    if (z2) {
                        z4Var = null;
                    } else {
                        jz jzVar2 = this.a.l;
                        z4Var = null;
                        jzVar2.f = null;
                        jzVar2.e = null;
                        jzVar2.a.invalidate();
                        this.a.getAngularGuidesHelper().e = false;
                        this.a.getAngularGuidesHelper().f.reset();
                    }
                    jfVar.h = ((f - rectF5.left) - rectF5.right) + jfVar.h;
                    jfVar.i = ((f2 - rectF5.top) - rectF5.bottom) + jfVar.i;
                }
            }
            pageRect.left += rectF5.left;
            pageRect.top += rectF5.top;
            pageRect.right += rectF5.right;
            pageRect.bottom += rectF5.bottom;
            if (this.a.getChildCount() > 1) {
                final Matrix matrix = new Matrix();
                if (bVar2 != null) {
                    float fWidth = pageRect.width() / rectF6.width();
                    float fHeight = pageRect.height() / rectF6.height();
                    switch (bVar2.ordinal()) {
                        case 0:
                            pointF = new PointF(rectF6.right, rectF6.bottom);
                            break;
                        case 1:
                            pointF = new PointF(rectF6.centerX(), rectF6.bottom);
                            break;
                        case 2:
                            pointF = new PointF(rectF6.left, rectF6.bottom);
                            break;
                        case 3:
                            pointF = new PointF(rectF6.right, rectF6.centerY());
                            break;
                        case 4:
                            pointF = new PointF(rectF6.left, rectF6.centerY());
                            break;
                        case 5:
                            pointF = new PointF(rectF6.right, rectF6.top);
                            break;
                        case 6:
                            pointF = new PointF(rectF6.centerX(), rectF6.top);
                            break;
                        case 7:
                            pointF = new PointF(rectF6.left, rectF6.top);
                            break;
                        case 8:
                            pointF = new PointF(0.0f, 0.0f);
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    matrix.setScale(fWidth, fHeight, pointF.x, pointF.y);
                    function2 = new Function2() { // from class: com.pspdfkit.internal.m4$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return m4.a(jfVar, matrix, this, bVar2, (Annotation) obj, (RectF) obj2);
                        }
                    };
                } else {
                    float f33 = rectF5.left;
                    Float fValueOf = Float.valueOf(f33);
                    if (f33 == 0.0f) {
                        f3 = fValueOf;
                        f3 = z4Var;
                    }
                    float fFloatValue = f3 != 0 ? f3.floatValue() : rectF5.right;
                    float f34 = rectF5.top;
                    Float fValueOf2 = Float.valueOf(f34);
                    if (f34 == 0.0f) {
                        fValueOf2 = z4Var;
                    }
                    matrix.setTranslate(fFloatValue, fValueOf2 != 0 ? fValueOf2.floatValue() : rectF5.bottom);
                    function2 = new Function2() { // from class: com.pspdfkit.internal.m4$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return m4.a(matrix, (Annotation) obj, (RectF) obj2);
                        }
                    };
                }
            } else {
                function2 = new Function2() { // from class: com.pspdfkit.internal.m4$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return m4.a(rectF5, (Annotation) obj, (RectF) obj2);
                    }
                };
            }
            boolean z5 = false;
            for (KeyEvent.Callback callback : ViewGroupKt.getChildren(this.a)) {
                z4<?> z4Var2 = callback instanceof z4 ? (z4) callback : z4Var;
                if (z4Var2 != null && (annotation = z4Var2.getAnnotation()) != null) {
                    RectF pageRect2 = z4Var2.getPageRect().getPageRect();
                    pageRect2.getClass();
                    function2.invoke(annotation, pageRect2);
                    if (z4Var2.a(rectF5)) {
                        l1 contentScaler = z4Var2.getContentScaler();
                        if (contentScaler == null || !contentScaler.a(annotation, jfVar, this.b, motionEvent)) {
                            contentScaler = z4Var;
                        }
                        a(z4Var2, contentScaler);
                    } else {
                        z5 = true;
                    }
                }
            }
            this.a.requestLayout();
            if (z5) {
                i = 1;
                this.a.getSelectionLayoutHandler().removeMessages(1);
                this.a.getSelectionLayoutHandler().sendEmptyMessageDelayed(1, 100L);
            } else {
                i = 1;
            }
            u00 rotationHandler = this.a.getRotationHandler();
            if (rotationHandler.f.size() == i) {
                rotationHandler.l.set(rotationHandler.c(rotationHandler.f.get(0)));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public static final Unit a(jf jfVar, Matrix matrix, m4 m4Var, o4.b bVar, Annotation annotation, RectF rectF) {
        annotation.getClass();
        rectF.getClass();
        jfVar.getClass();
        jf.a aVar = jfVar.g.get(annotation.getObjectNumber());
        RectF rectF2 = aVar != null ? aVar.a : null;
        if (rectF2 != null) {
            matrix.mapRect(rectF, rectF2);
            float f = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f;
            jf.a aVar2 = jfVar.g.get(annotation.getObjectNumber());
            Size size = aVar2 != null ? aVar2.b : null;
            if (size != null) {
                m4Var.getClass();
                if (bVar != o4.b.ROTATION) {
                    float fAbs = Math.abs(size.width);
                    float fAbs2 = Math.abs(size.height);
                    float fAbs3 = Math.abs(rectF.width());
                    float fAbs4 = Math.abs(rectF.height());
                    float fA = ip.a(fAbs, fAbs3);
                    float fA2 = ip.a(fAbs2, fAbs4);
                    if (fA2 != fAbs4 || fA != fAbs3) {
                        switch (bVar.ordinal()) {
                            case 0:
                                rectF.left = rectF.right - fA;
                                rectF.top = rectF.bottom + fA2;
                                break;
                            case 1:
                                rectF.top = rectF.bottom + fA2;
                                break;
                            case 2:
                                rectF.right = rectF.left + fA;
                                rectF.top = rectF.bottom + fA2;
                                break;
                            case 3:
                                rectF.left = rectF.right - fA;
                                break;
                            case 4:
                                rectF.right = rectF.left + fA;
                                break;
                            case 5:
                                rectF.left = rectF.right - fA;
                                rectF.bottom = rectF.top - fA2;
                                break;
                            case 6:
                                rectF.bottom = rectF.top - fA2;
                                break;
                            case 7:
                                rectF.right = rectF.left + fA;
                                rectF.bottom = rectF.top - fA2;
                                break;
                            case 8:
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Matrix matrix, Annotation annotation, RectF rectF) {
        annotation.getClass();
        rectF.getClass();
        matrix.mapRect(rectF);
        float f = rectF.top;
        rectF.top = rectF.bottom;
        rectF.bottom = f;
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.q4
    public final boolean a(z4<?> z4Var, l1 l1Var) {
        Annotation annotation = z4Var.getAnnotation();
        if (annotation == null) {
            return false;
        }
        RectF boundingBox = annotation.getBoundingBox();
        RectF rectF = new RectF(z4Var.getPageRect().getPageRect());
        if (Intrinsics.areEqual(boundingBox, rectF)) {
            return false;
        }
        annotation.updateTransformationProperties(rectF, boundingBox);
        annotation.setBoundingBox(rectF);
        AnnotationType type = annotation.getType();
        type.getClass();
        switch (p10.a.a[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                annotation.getInternal().markPreferredForPlatformRendering();
                break;
        }
        if (l1Var != null) {
            boundingBox.getClass();
            l1Var.a(annotation, new xv(boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom), new xv(rectF.left, rectF.top, rectF.right, rectF.bottom));
        }
        u00 rotationHandler = this.a.getRotationHandler();
        if (rotationHandler.f.size() == 1) {
            rotationHandler.l.set(rotationHandler.c(rotationHandler.f.get(0)));
        }
        return true;
    }

    @Override // com.pspdfkit.internal.q4
    public final void a(boolean z) {
        if (this.i == z) {
            return;
        }
        this.i = z;
        this.a.invalidate();
    }

    @Override // com.pspdfkit.internal.q4
    public final void a(int i) {
        this.w = i;
    }
}
