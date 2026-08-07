package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.jni.NativeRectDescriptor;
import com.pspdfkit.internal.jni.NativeTextParser;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.PdfLog;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public abstract class dp extends d3 implements OnAnnotatingModeSettingsChangeListener {
    public static final Paint o;
    public final RectF c;
    public final RectF d;
    public final ArrayList e;
    public int f;
    public BaseRectsAnnotation g;
    public i3 h;
    public boolean i;
    public boolean j;
    public final PSPDFKitPreferences k;
    public final GestureDetector l;
    public a m;
    public final AnnotationToolVariant n;

    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            motionEvent.getClass();
            if (dp.this.l() == null) {
                return false;
            }
            dp dpVar = dp.this;
            if (!br.a(motionEvent, dpVar.i, dpVar.k)) {
                return false;
            }
            dp.this.c.left = motionEvent.getX();
            dp.this.c.top = motionEvent.getY();
            dp.this.c.bottom = motionEvent.getY();
            dp.this.c.right = motionEvent.getX();
            dp.this.a(new RectF(dp.this.c));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            motionEvent2.getClass();
            if (dp.this.l() == null) {
                return false;
            }
            dp.this.c.bottom = motionEvent2.getY();
            dp.this.c.right = motionEvent2.getX();
            dp.this.a(new PointF(motionEvent2.getX(), motionEvent2.getY()));
            au auVarL = dp.this.l();
            if (auVarL == null) {
                return true;
            }
            int i = au.b0;
            auVarL.a(false);
            return true;
        }
    }

    static {
        Paint paint = new Paint();
        o = paint;
        paint.setColor(Color.argb(253, Token.GET, 175, 199));
        paint.setStyle(Paint.Style.FILL);
        gf.a(paint, BlendMode.MULTIPLY);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var);
        q0Var.getClass();
        annotationToolVariant.getClass();
        this.c = new RectF();
        this.d = new RectF();
        this.e = new ArrayList();
        PSPDFKitPreferences pSPDFKitPreferences = PSPDFKitPreferences.get(q0Var.a);
        pSPDFKitPreferences.getClass();
        this.k = pSPDFKitPreferences;
        Context context = q0Var.a;
        context.getClass();
        this.l = new GestureDetector(context, new b());
        this.m = new a(0, 7);
        this.n = annotationToolVariant;
    }

    public abstract BaseRectsAnnotation a(ArrayList arrayList);

    public void a(BaseRectsAnnotation baseRectsAnnotation, q0 q0Var) {
        q0Var.getClass();
    }

    public boolean a(BaseRectsAnnotation baseRectsAnnotation) {
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean c() {
        m();
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean d() {
        PdfLog.d("Nutri.MarkupAnnotMHand", "Exiting highlight editing mode.", new Object[0]);
        m();
        this.a.b(this);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean e() {
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() {
        PdfLog.d("Nutri.MarkupAnnotMHand", "Exiting highlight editing mode due to page recycling.", new Object[0]);
        m();
        this.a.c(this);
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return this.n;
    }

    public void m() {
        this.m = new a(0, 7);
        q0 q0Var = this.a;
        q0Var.getClass();
        q0Var.l.b(this);
        this.g = null;
    }

    public boolean n() {
        return this.j;
    }

    public boolean o() {
        return true;
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener
    public final void onAnnotatingModeSettingsChange(AnnotatingController annotatingController) {
        vt pageEditor;
        annotatingController.getClass();
        BaseRectsAnnotation baseRectsAnnotation = this.g;
        if (baseRectsAnnotation != null) {
            baseRectsAnnotation.setAlpha(annotatingController.getAlpha());
            au auVarL = l();
            if (auVarL == null || (pageEditor = auVarL.getPageEditor()) == null) {
                return;
            }
            Iterator<T> it = pageEditor.d().iterator();
            while (it.hasNext()) {
                z4 z4Var = (z4) it.next();
                ViewGroup.LayoutParams layoutParams = z4Var.a().getLayoutParams();
                layoutParams.getClass();
                OverlayLayoutParams overlayLayoutParams = (OverlayLayoutParams) layoutParams;
                Annotation annotation = z4Var.getAnnotation();
                if (annotation != null) {
                    boolean zAreEqual = Intrinsics.areEqual(overlayLayoutParams.pageRect.getPageRect(), annotation.getBoundingBox());
                    boolean z = pageEditor.v;
                    if (zAreEqual) {
                        if (!z) {
                            z4Var.n();
                        }
                        z4Var.b();
                    } else {
                        if (!z) {
                            z4Var.n();
                        }
                        pageEditor.k.b();
                        z4Var.b();
                    }
                }
            }
        }
    }

    public boolean p() {
        return !(this instanceof vl);
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        PdfConfiguration pdfConfiguration;
        PdfConfiguration pdfConfiguration2;
        this.b = q30Var;
        Context context = this.a.a;
        context.getClass();
        this.f = (int) un.a(context, 1, 1);
        au auVarL = l();
        this.i = (auVarL == null || (pdfConfiguration2 = auVarL.getPdfConfiguration()) == null) ? false : pdfConfiguration2.getEnableStylusOnDetection();
        au auVarL2 = l();
        this.j = (auVarL2 == null || (pdfConfiguration = auVarL2.getPdfConfiguration()) == null) ? false : pdfConfiguration.getUseRectangleSelectionForMarkupAnnotations();
        this.a.a(this);
        q0 q0Var = this.a;
        q0Var.getClass();
        q0Var.l.a(this);
        PdfLog.d("Nutri.MarkupAnnotMHand", "Entering markup editing mode.", new Object[0]);
    }

    public static final class a {
        public final int a;
        public final int b;
        public final boolean c;

        public a(int i, int i2) {
            i = (i2 & 1) != 0 ? -1 : i;
            boolean z = (i2 & 4) == 0;
            this.a = i;
            this.b = -1;
            this.c = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.c) + nd.a(this.b, Integer.hashCode(this.a) * 31, 31);
        }

        public final String toString() {
            return "CharacterSelection(start=" + this.a + ", end=" + this.b + ", isCharacterFound=" + this.c + ")";
        }

        public a(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:50:0x0102  */
    /* JADX WARN: Code duplicated, block: B:53:0x010b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0140  */
    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        i3 i3Var;
        BaseRectsAnnotation baseRectsAnnotation;
        i3 i3Var2;
        if (l() == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z = true;
        if (actionMasked != 1) {
            if (actionMasked != 3) {
                return this.l.onTouchEvent(motionEvent);
            }
            this.c.setEmpty();
            this.d.setEmpty();
            this.e.clear();
            au auVarL = l();
            if (auVarL != null) {
                int i = au.b0;
                auVarL.a(false);
            }
            au auVarL2 = l();
            if (auVarL2 != null) {
                auVarL2.postInvalidateOnAnimation();
            }
            if (!p()) {
                m();
            }
            return true;
        }
        lm lmVarJ = j();
        if (lmVarJ == null) {
            z = false;
        } else {
            BaseRectsAnnotation baseRectsAnnotation2 = this.g;
            ArrayList arrayList = this.e;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                arrayList2.add(((PageRect) obj).getPageRect());
            }
            if (baseRectsAnnotation2 == null || !baseRectsAnnotation2.isAttached() || baseRectsAnnotation2.getColor() != this.a.p.b || baseRectsAnnotation2.getAlpha() != this.a.p.i || baseRectsAnnotation2.getType() != h().toAnnotationType()) {
                m();
                EnumSet<AnnotationType> enumSet = hp.a;
                int iK = k();
                AnnotationType annotationType = h().toAnnotationType();
                annotationType.getClass();
                q0.a aVar = this.a.p;
                BaseRectsAnnotation baseRectsAnnotationA = hp.a(lmVarJ, iK, annotationType, aVar.b, aVar.i, arrayList2);
                if (p() && !Intrinsics.areEqual(baseRectsAnnotationA.getName(), "com.pspdfkit.internal.annotations.markup.default-rect-name")) {
                    this.g = baseRectsAnnotationA;
                    at atVar = this.a.c;
                    atVar.getClass();
                    this.h = new i3(CollectionsKt.listOf(baseRectsAnnotationA), atVar);
                    this.e.clear();
                    if (arrayList2.isEmpty()) {
                        z = false;
                    } else {
                        i3Var = this.h;
                        if (i3Var != null) {
                            i3Var.b();
                        }
                        baseRectsAnnotation = this.g;
                        if (baseRectsAnnotation != null) {
                            a(baseRectsAnnotation, arrayList2, this.d);
                        }
                        i3Var2 = this.h;
                        if (i3Var2 != null) {
                            i3Var2.c();
                        }
                    }
                } else {
                    BaseRectsAnnotation baseRectsAnnotationA2 = a(arrayList2);
                    if (baseRectsAnnotationA2 == null) {
                        baseRectsAnnotationA2 = null;
                    } else {
                        q0 q0Var = this.a;
                        q0Var.getClass();
                        ww.a(q0Var.g, baseRectsAnnotationA2);
                        baseRectsAnnotationA2.getInternal().setVariant(q0Var.t);
                        baseRectsAnnotationA2.setColor(this.a.p.b);
                        baseRectsAnnotationA2.setAlpha(this.a.p.i);
                    }
                    if (baseRectsAnnotationA2 == null) {
                        z = false;
                    } else {
                        a(baseRectsAnnotationA2, arrayList2, this.d);
                        if (!a(baseRectsAnnotationA2)) {
                            this.g = null;
                            PdfLog.d("Nutri.MarkupAnnotMHand", "Skipping invalid annotation for add", new Object[0]);
                            z = false;
                        } else {
                            this.g = baseRectsAnnotationA2;
                            at atVar2 = this.a.c;
                            atVar2.getClass();
                            this.h = new i3(CollectionsKt.listOf(baseRectsAnnotationA2), atVar2);
                            q0 q0Var2 = this.a;
                            CoroutineContext coroutineContextPlus = Dispatchers.getDefault().plus(new ep(CoroutineExceptionHandler.INSTANCE));
                            fp fpVar = new fp(lmVarJ, baseRectsAnnotationA2, this, null);
                            q0Var2.getClass();
                            coroutineContextPlus.getClass();
                            q0Var2.q.incrementAndGet();
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineContextPlus), null, null, new r0(fpVar, q0Var2, null), 3, null);
                        }
                    }
                }
            } else if (arrayList2.isEmpty()) {
                z = false;
            } else {
                i3Var = this.h;
                if (i3Var != null) {
                    i3Var.b();
                }
                baseRectsAnnotation = this.g;
                if (baseRectsAnnotation != null) {
                    a(baseRectsAnnotation, arrayList2, this.d);
                }
                i3Var2 = this.h;
                if (i3Var2 != null) {
                    i3Var2.c();
                }
            }
        }
        this.c.setEmpty();
        this.d.setEmpty();
        this.e.clear();
        au auVarL3 = l();
        if (auVarL3 != null) {
            int i3 = au.b0;
            auVarL3.a(false);
        }
        au auVarL4 = l();
        if (auVarL4 != null) {
            auVarL4.postInvalidateOnAnimation();
        }
        if (!p()) {
            m();
        }
        return z;
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            ((PageRect) this.e.get(i)).updateScreenRect(matrix);
        }
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
        canvas.getClass();
        if (n()) {
            RectF rectF = this.d;
            float f = this.f;
            canvas.drawRoundRect(rectF, f, f, o);
        }
        if (o()) {
            ArrayList arrayList = this.e;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                RectF screenRect = ((PageRect) obj).getScreenRect();
                float f2 = this.f;
                canvas.drawRoundRect(screenRect, f2, f2, o);
            }
        }
    }

    public final void a(PointF pointF) {
        lm lmVarJ;
        List<RectF> listEmptyList;
        int i;
        int i2;
        int i3;
        int i4;
        a aVar;
        a aVar2;
        au auVarL = l();
        if (auVarL == null || (lmVarJ = j()) == null) {
            return;
        }
        Matrix matrixA = auVarL.a((Matrix) null);
        if (!this.j) {
            Matrix matrix = new Matrix();
            matrixA.invert(matrix);
            s60.a(pointF, matrix);
            int charIndexAt = lmVarJ.getCharIndexAt(k(), pointF.x, pointF.y);
            a aVar3 = this.m;
            if (charIndexAt > -1) {
                int i5 = aVar3.a;
                if (i5 == -1) {
                    aVar2 = new a(charIndexAt, 2);
                } else {
                    aVar = new a(i5, charIndexAt, true);
                }
                this.m = aVar2;
            } else {
                aVar = new a(aVar3.a, aVar3.b, false);
            }
            aVar2 = aVar;
            this.m = aVar2;
        }
        this.d.set(this.c);
        this.d.sort();
        RectF rectF = new RectF();
        rectF.set(this.d);
        s60.a(rectF, matrixA);
        if (this.j) {
            RectF rectF2 = new RectF(rectF);
            NativeTextParser nativeTextParserA = lmVarJ.c.b(k()).a();
            if (nativeTextParserA == null) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ArrayList<NativeRectDescriptor> arrayListTextRectsBoundedByRect = nativeTextParserA.textRectsBoundedByRect(rectF2, true, false, true);
                arrayListTextRectsBoundedByRect.getClass();
                listEmptyList = r10.a(arrayListTextRectsBoundedByRect);
            }
        } else {
            a aVar4 = this.m;
            if (aVar4.a != -1 && aVar4.b != -1) {
                int iK = k();
                a aVar5 = this.m;
                int i6 = aVar5.a;
                int i7 = aVar5.b;
                if (i6 < i7) {
                    i = i6;
                } else {
                    i = aVar5.c ? i7 + 1 : i7;
                }
                if (i6 == -1 || i7 == -1) {
                    i2 = 0;
                } else if (i6 < i7) {
                    if (i6 < i7) {
                        i4 = aVar5.c ? i7 : i7 + 1;
                    } else {
                        i4 = i6;
                    }
                    if (i6 >= i7) {
                        i6 = aVar5.c ? i7 + 1 : i7;
                    }
                    i2 = i4 - i6;
                } else {
                    if (i6 < i7) {
                        i3 = aVar5.c ? i7 : i7 + 1;
                    } else {
                        i3 = i6;
                    }
                    if (i6 >= i7) {
                        i6 = aVar5.c ? i7 + 1 : i7;
                    }
                    i2 = (i3 - i6) + 1;
                }
                listEmptyList = lmVarJ.getPageTextRects(iK, i, i2, true);
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
        }
        this.e.clear();
        if (listEmptyList.isEmpty()) {
            return;
        }
        Iterator<Integer> it = CollectionsKt.getIndices(listEmptyList).iterator();
        while (it.hasNext()) {
            PageRect pageRect = new PageRect(listEmptyList.get(((IntIterator) it).nextInt()));
            pageRect.updateScreenRect(matrixA);
            pageRect.getScreenRect().sort();
            this.e.add(pageRect);
        }
        if (this.e.isEmpty()) {
            return;
        }
        CollectionsKt.sort(this.e);
        PdfLog.d("Nutri.MarkupAnnotMHand", "Got " + listEmptyList.size() + " selected rects, see: " + listEmptyList, new Object[0]);
    }

    public void a(RectF rectF) {
        au auVarL;
        if (this.j || (auVarL = l()) == null) {
            return;
        }
        Matrix matrixA = auVarL.a((Matrix) null);
        lm lmVarJ = j();
        if (lmVarJ == null) {
            return;
        }
        PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
        Matrix matrix = new Matrix();
        matrixA.invert(matrix);
        s60.a(pointF, matrix);
        this.m = new a(lmVarJ.getCharIndexAt(k(), pointF.x, pointF.y), 6);
    }

    public void a(BaseRectsAnnotation baseRectsAnnotation, ArrayList arrayList, RectF rectF) {
        baseRectsAnnotation.getClass();
        rectF.getClass();
        if (arrayList.isEmpty()) {
            return;
        }
        hp.a(baseRectsAnnotation, arrayList);
    }
}
