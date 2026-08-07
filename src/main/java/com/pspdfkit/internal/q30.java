package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.PdfLog;
import java.util.Collections;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q30 extends View implements nx {
    public final k2 a;
    public final fk b;
    public gu c;
    public y50 d;
    public gu e;
    public boolean f;
    public AnnotationTool g;
    public AnnotationToolVariant h;
    public final Handler i;
    public Runnable j;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationTool.values().length];
            try {
                iArr[AnnotationTool.INK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationTool.MAGIC_INK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationTool.ERASER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationTool.NOTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationTool.HIGHLIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationTool.SQUIGGLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationTool.UNDERLINE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AnnotationTool.STRIKEOUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AnnotationTool.FREETEXT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AnnotationTool.FREETEXT_CALLOUT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AnnotationTool.STAMP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AnnotationTool.IMAGE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AnnotationTool.CAMERA.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AnnotationTool.LINE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AnnotationTool.SQUARE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[AnnotationTool.CIRCLE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[AnnotationTool.POLYGON.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[AnnotationTool.POLYLINE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[AnnotationTool.SIGNATURE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[AnnotationTool.REDACTION.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[AnnotationTool.SOUND.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[AnnotationTool.INSTANT_COMMENT_MARKER.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[AnnotationTool.INSTANT_HIGHLIGHT_COMMENT.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_DISTANCE.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_SCALE_CALIBRATION.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_PERIMETER.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_AREA_POLYGON.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_AREA_ELLIPSE.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[AnnotationTool.MEASUREMENT_AREA_RECT.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[AnnotationTool.ANNOTATION_MULTI_SELECTION.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[AnnotationTool.NONE.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q30(Context context, k2 k2Var) {
        super(context);
        context.getClass();
        this.a = k2Var;
        this.b = gk.a(context);
        this.g = AnnotationTool.NONE;
        AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
        annotationToolVariantDefaultVariant.getClass();
        this.h = annotationToolVariantDefaultVariant;
        this.i = new Handler(Looper.getMainLooper());
        setWillNotDraw(false);
    }

    public final void a(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, q0 q0Var) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        q0Var.getClass();
        PdfLog.d("Nutri.SpecialModeView", "Entering annotation creation mode for " + annotationTool + ".", new Object[0]);
        y50 y50Var = this.d;
        if (y50Var != null) {
            y50Var.d();
            this.d = null;
        }
        gu guVar = this.c;
        if (guVar != null) {
            if (guVar.f() == 23) {
                a(false);
            } else {
                d3 d3Var = (d3) guVar;
                if (d3Var.h() == annotationTool && Intrinsics.areEqual(d3Var.i(), annotationToolVariant)) {
                    return;
                }
                if (guVar.c()) {
                    c();
                }
            }
        }
        switch (a.a[annotationTool.ordinal()]) {
            case 1:
                this.c = new jk(q0Var, annotationToolVariant);
                break;
            case 2:
                this.c = new uo(q0Var, annotationToolVariant);
                break;
            case 3:
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                Context context = q0Var.a;
                context.getClass();
                paint.setColor(new lg(context).a);
                paint.setAntiAlias(true);
                paint.setDither(true);
                paint.setColorFilter(ff.a(q0Var.z.isToGrayscale(), q0Var.z.isInvertColors()));
                PdfConfiguration pdfConfiguration = q0Var.z;
                Context context2 = q0Var.a;
                List list = Collections.EMPTY_LIST;
                this.c = new jg(q0Var, paint, new j10(context2, pdfConfiguration, null, 0));
                break;
            case 4:
                this.c = new zr(q0Var, annotationToolVariant);
                break;
            case 5:
                this.c = new qj(q0Var, annotationToolVariant);
                break;
            case 6:
                this.c = new s30(q0Var, annotationToolVariant);
                break;
            case 7:
                this.c = new w60(q0Var, annotationToolVariant);
                break;
            case 8:
                this.c = new t40(q0Var, annotationToolVariant);
                break;
            case 9:
            case 10:
                this.c = new ki(q0Var, annotationTool, annotationToolVariant);
                break;
            case 11:
                this.c = new w30(q0Var, annotationToolVariant);
                break;
            case 12:
                this.c = new ti(q0Var, annotationToolVariant);
                break;
            case 13:
                this.c = new r8(q0Var, annotationToolVariant);
                break;
            case 14:
                this.c = new wn(q0Var, annotationToolVariant);
                break;
            case 15:
                this.c = new r30(q0Var, annotationToolVariant);
                break;
            case 16:
                this.c = new y8(q0Var, annotationToolVariant);
                break;
            case 17:
                this.c = new lw(q0Var, annotationToolVariant);
                break;
            case 18:
                this.c = new ow(q0Var, annotationToolVariant);
                break;
            case 19:
                this.c = new u10(q0Var, annotationToolVariant, this.a);
                break;
            case 20:
                this.c = new xx(q0Var, annotationToolVariant);
                break;
            case 21:
                this.c = new h30(q0Var, annotationToolVariant);
                break;
            case 22:
                this.c = new ol(q0Var, annotationToolVariant);
                break;
            case 23:
                this.c = new vl(q0Var, annotationToolVariant);
                break;
            case 24:
            case 25:
                this.c = new pp(q0Var, annotationToolVariant, annotationTool);
                break;
            case 26:
                this.c = new vp(q0Var, annotationToolVariant);
                break;
            case 27:
                this.c = new lp(q0Var, annotationToolVariant);
                break;
            case 28:
                this.c = new mp(q0Var, annotationToolVariant, 2);
                break;
            case 29:
                this.c = new mp(q0Var, annotationToolVariant, 1);
                break;
            case 30:
                this.c = new a3(q0Var);
                break;
            case 31:
                this.c = new vr(q0Var);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        gu guVar2 = this.c;
        if (guVar2 != null) {
            guVar2.a(this);
        }
        c();
    }

    public final void b() {
        Runnable runnable = this.j;
        if (runnable != null) {
            this.i.removeCallbacks(runnable);
            this.j = null;
        }
        final gu guVar = this.c;
        if (guVar == null) {
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: com.pspdfkit.internal.q30$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                q30.a(this.f$0, guVar);
            }
        };
        this.j = runnable2;
        this.i.postDelayed(runnable2, 1000L);
    }

    public final void c() {
        au parentView = getParentView();
        if (parentView == null || parentView.getState() == null) {
            return;
        }
        Matrix matrixA = parentView.a((Matrix) null);
        gu guVar = this.c;
        if (guVar != null) {
            guVar.a(matrixA);
        }
        gu guVar2 = this.e;
        if (guVar2 != null) {
            guVar2.a(matrixA);
        }
        y50 y50Var = this.d;
        if (y50Var != null) {
            y50Var.a(matrixA);
        }
        postInvalidateOnAnimation();
    }

    public final gu getCurrentMode() {
        return this.c;
    }

    public final au getParentView() {
        return (au) getParent();
    }

    public final TextSelection getTextSelectionOverlay() {
        y50 y50Var = this.d;
        if (y50Var != null) {
            return y50Var.a;
        }
        return null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        super.onDraw(canvas);
        au parentView = getParentView();
        if (parentView == null || !parentView.v) {
            return;
        }
        gu guVar = this.e;
        if (guVar != null) {
            guVar.a(canvas);
        }
        gu guVar2 = this.c;
        if (guVar2 != null) {
            guVar2.a(canvas);
        }
        y50 y50Var = this.d;
        if (y50Var != null) {
            y50Var.a(canvas);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        fk fkVar;
        motionEvent.getClass();
        if (motionEvent.getAction() == 0 && (fkVar = this.b) != null) {
            fkVar.b();
        }
        gu guVar = this.c;
        if (guVar != null) {
            int actionMasked = motionEvent.getActionMasked();
            switch (actionMasked) {
                case BoxCommonConstants.REQUEST_DELETE /* 211 */:
                    actionMasked = 0;
                    break;
                case BoxCommonConstants.REQUEST_RENAME /* 212 */:
                    actionMasked = 1;
                    break;
                case 213:
                    actionMasked = 2;
                    break;
            }
            if (this.f || (actionMasked != 2 && actionMasked != 1)) {
                boolean z = (motionEvent.getButtonState() & 32) != 0;
                boolean z2 = motionEvent.getToolType(motionEvent.getActionIndex()) == 4;
                boolean z3 = z || z2;
                if (this.f || !z3 || !(guVar instanceof d3) || guVar.f() == 21) {
                    boolean z4 = this.f;
                    if (z4 && (guVar instanceof d3) && (!z3 || (z2 && actionMasked == 1))) {
                        Runnable runnable = this.j;
                        if (runnable != null) {
                            this.i.removeCallbacks(runnable);
                            this.j = null;
                        }
                        a(this.g, this.h, ((d3) guVar).a);
                        this.f = false;
                    } else if (z4 && z && !z2) {
                        b();
                    }
                } else {
                    d3 d3Var = (d3) guVar;
                    this.g = d3Var.h();
                    this.h = d3Var.i();
                    this.f = true;
                    AnnotationTool annotationTool = AnnotationTool.ERASER;
                    AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
                    annotationToolVariantDefaultVariant.getClass();
                    a(annotationTool, annotationToolVariantDefaultVariant, d3Var.a);
                    if (!z2) {
                        b();
                    }
                }
            }
        }
        y50 y50Var = this.d;
        if (y50Var != null) {
            boolean zA = y50Var.a(motionEvent);
            if (zA && y50Var.t != y50.b.NO_DRAG && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (zA) {
                return true;
            }
        }
        gu guVar2 = this.c;
        if (guVar2 != null) {
            return guVar2.a(motionEvent);
        }
        return false;
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        a(true);
    }

    public final void setRetainedPageModeHandler(gu guVar) {
        this.e = guVar;
    }

    public final void a(TextSelection textSelection, final a60 a60Var) {
        textSelection.getClass();
        a60Var.getClass();
        y50 y50Var = this.d;
        if (y50Var != null) {
            y50Var.d();
            a60Var.l = null;
        }
        y50 y50Var2 = new y50(textSelection, a60Var);
        a60Var.l = y50Var2;
        y50Var2.q = a60Var.o;
        vo voVar = a60Var.i;
        voVar.getClass();
        y50Var2.w = voVar;
        a60Var.l.I.c = false;
        TextSelection textSelection2 = y50Var2.a;
        if (textSelection2 != null) {
            i0 i0VarA = ar.a();
            Bundle bundleA = z50.a(i0VarA);
            bundleA.putInt(Analytics.Data.PAGE_INDEX, textSelection2.pageIndex);
            i0VarA.a(Analytics.Event.SELECT_TEXT, bundleA);
        }
        y50Var2.r = new Function0() { // from class: com.pspdfkit.internal.q30$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q30.a(this.f$0, a60Var);
            }
        };
        y50Var2.a(this);
        this.d = y50Var2;
        c();
    }

    public static final Unit a(q30 q30Var, a60 a60Var) {
        y50 y50Var = q30Var.d;
        if (y50Var != null) {
            y50Var.d();
            a60Var.l = null;
        }
        q30Var.d = null;
        q30Var.invalidate();
        return Unit.INSTANCE;
    }

    public final boolean a() {
        au parentView;
        DocumentView parentView2;
        return (this.c == null || (parentView = getParentView()) == null || (parentView2 = parentView.getParentView()) == null || !parentView2.i()) ? false : true;
    }

    public static final void a(q30 q30Var, gu guVar) {
        if (q30Var.f && (guVar instanceof d3)) {
            q30Var.a(q30Var.g, q30Var.h, ((d3) guVar).a);
            q30Var.f = false;
            q30Var.j = null;
        }
    }

    public final void a(boolean z) {
        boolean zD;
        boolean zD2;
        gu guVar = this.c;
        if (guVar != null) {
            PdfLog.d("Nutri.SpecialModeView", (z ? "Recycling" : "Exiting").concat(" special mode."), new Object[0]);
            if (z) {
                guVar.g();
                zD2 = false;
            } else {
                zD2 = guVar.d();
            }
            if (zD2) {
                c();
            }
        }
        this.c = null;
        y50 y50Var = this.d;
        if (y50Var != null) {
            if (z) {
                y50Var.g();
                zD = false;
            } else {
                zD = y50Var.d();
            }
            if (zD) {
                c();
            }
        }
        this.d = null;
        if (this.f) {
            Runnable runnable = this.j;
            if (runnable != null) {
                this.i.removeCallbacks(runnable);
                this.j = null;
            }
            this.f = false;
        }
    }
}
