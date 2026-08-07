package com.pspdfkit.internal.views.document;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.SparseLongArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationProviderRxJava;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.actions.ActionResolver;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.page.PageFitMode;
import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.datastructures.TextSelectionRectangles;
import com.pspdfkit.document.PageBinding;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormField;
import com.pspdfkit.internal.a60;
import com.pspdfkit.internal.a70;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ab;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.at;
import com.pspdfkit.internal.au;
import com.pspdfkit.internal.b2;
import com.pspdfkit.internal.b20;
import com.pspdfkit.internal.br;
import com.pspdfkit.internal.bu;
import com.pspdfkit.internal.c2;
import com.pspdfkit.internal.c5;
import com.pspdfkit.internal.ca;
import com.pspdfkit.internal.cb;
import com.pspdfkit.internal.d1;
import com.pspdfkit.internal.d3;
import com.pspdfkit.internal.d30;
import com.pspdfkit.internal.e1;
import com.pspdfkit.internal.et;
import com.pspdfkit.internal.f3;
import com.pspdfkit.internal.f7;
import com.pspdfkit.internal.fu;
import com.pspdfkit.internal.g60;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.gu;
import com.pspdfkit.internal.h60;
import com.pspdfkit.internal.ho;
import com.pspdfkit.internal.hu;
import com.pspdfkit.internal.i;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.i3;
import com.pspdfkit.internal.i4;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jq;
import com.pspdfkit.internal.kq;
import com.pspdfkit.internal.lh;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.ln;
import com.pspdfkit.internal.m0;
import com.pspdfkit.internal.m30;
import com.pspdfkit.internal.m40;
import com.pspdfkit.internal.nb;
import com.pspdfkit.internal.o3;
import com.pspdfkit.internal.oc;
import com.pspdfkit.internal.pq;
import com.pspdfkit.internal.px;
import com.pspdfkit.internal.q0;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.q30;
import com.pspdfkit.internal.qq;
import com.pspdfkit.internal.qt;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.sb;
import com.pspdfkit.internal.sp;
import com.pspdfkit.internal.ta;
import com.pspdfkit.internal.tq;
import com.pspdfkit.internal.ub;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.vo;
import com.pspdfkit.internal.vt;
import com.pspdfkit.internal.wu;
import com.pspdfkit.internal.ww;
import com.pspdfkit.internal.wz;
import com.pspdfkit.internal.x1;
import com.pspdfkit.internal.x40;
import com.pspdfkit.internal.x50;
import com.pspdfkit.internal.x70;
import com.pspdfkit.internal.xe;
import com.pspdfkit.internal.xz;
import com.pspdfkit.internal.y5;
import com.pspdfkit.internal.y50;
import com.pspdfkit.internal.y70;
import com.pspdfkit.internal.yh;
import com.pspdfkit.internal.yz;
import com.pspdfkit.internal.z1;
import com.pspdfkit.internal.z1.a;
import com.pspdfkit.internal.z50;
import com.pspdfkit.internal.zb;
import com.pspdfkit.internal.zd;
import com.pspdfkit.internal.zt;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.OnDocumentLongPressListener;
import com.pspdfkit.listeners.OnPreparePopupToolbarListener;
import com.pspdfkit.listeners.scrolling.DocumentScrollListener;
import com.pspdfkit.listeners.scrolling.ScrollState;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PopupToolbar;
import com.pspdfkit.ui.annotations.OnAnnotationSelectedListener;
import com.pspdfkit.ui.drawable.PdfDrawableManager;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import com.pspdfkit.ui.overlay.OverlayViewProvider;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import com.pspdfkit.ui.special_mode.manager.TextSelectionManager;
import com.pspdfkit.ui.toolbar.popup.TextSelectionPopupToolbar;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentView extends ViewGroup implements px.a<au>, PdfDrawableManager, m30, TextSelectionManager.OnTextSelectionChangeListener, AnnotationProvider.OnAnnotationUpdatedListener, zb {
    public GestureDetector A;
    public ScaleGestureDetector B;
    public ln C;
    public d D;
    public boolean E;
    public boolean F;
    public q0 G;
    public a60 H;
    public ab I;
    public lh J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public float R;
    public lm S;
    public PdfConfiguration T;
    public ScrollState U;
    public h V;
    public pq W;
    public zd a;
    public int a0;
    public boolean b;
    public int b0;
    public Disposable c;
    public at c0;
    public f d;
    public b20 d0;
    public final hu<PdfDrawableProvider> e;
    public final EnumSet<AnnotationType> e0;
    public final hu<OverlayViewProvider> f;
    public boolean f0;
    public final HashSet g;
    public boolean g0;
    public final ArrayList h;
    public c5 h0;
    public final go<OnAnnotationSelectedListener> i;
    public boolean i0;
    public z1 j;
    public Job j0;
    public final CompositeDisposable k;
    public final HashSet k0;
    public final Handler l;
    public final go<g> l0;
    public final HashSet m;
    public e m0;
    public final nb n;
    public boolean n0;
    public final yh o;
    public long o0;
    public final x50 p;
    public vo p0;
    public int q;
    public sp q0;
    public int r;
    public PSPDFKitPreferences r0;
    public int s;
    public final Runnable s0;
    public float t;
    public Integer t0;
    public float u;
    public x70 u0;
    public DocumentListener v;
    public final Runnable v0;
    public OnDocumentLongPressListener w;
    public int w0;
    public DocumentScrollListener x;
    public px<au> y;
    public i z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            a = iArr;
            try {
                iArr[AnnotationType.INK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AnnotationType.LINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AnnotationType.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AnnotationType.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AnnotationType.POLYGON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AnnotationType.POLYLINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        public static final boolean e = Build.MANUFACTURER.equalsIgnoreCase("samsung");
        public boolean a = false;
        public long b = 0;
        public float c = 0.0f;

        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        
            if (r0 == com.pspdfkit.ui.special_mode.controller.AnnotationTool.ERASER) goto L11;
         */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean onDoubleTap(android.view.MotionEvent r5) {
            /*
                r4 = this;
                com.pspdfkit.internal.views.document.DocumentView r0 = com.pspdfkit.internal.views.document.DocumentView.this
                boolean r0 = r0.i()
                r1 = 0
                if (r0 == 0) goto L26
                com.pspdfkit.internal.views.document.DocumentView r0 = com.pspdfkit.internal.views.document.DocumentView.this
                com.pspdfkit.internal.q0 r0 = r0.G
                com.pspdfkit.ui.special_mode.controller.AnnotationTool r0 = r0.s
                if (r0 != 0) goto L12
                goto L26
            L12:
                com.pspdfkit.annotations.AnnotationType r2 = r0.toAnnotationType()
                int[] r3 = com.pspdfkit.internal.views.document.DocumentView.a.a
                int r2 = r2.ordinal()
                r2 = r3[r2]
                switch(r2) {
                    case 1: goto L25;
                    case 2: goto L25;
                    case 3: goto L25;
                    case 4: goto L25;
                    case 5: goto L25;
                    case 6: goto L25;
                    default: goto L21;
                }
            L21:
                com.pspdfkit.ui.special_mode.controller.AnnotationTool r2 = com.pspdfkit.ui.special_mode.controller.AnnotationTool.ERASER
                if (r0 != r2) goto L26
            L25:
                return r1
            L26:
                com.pspdfkit.internal.views.document.DocumentView r4 = com.pspdfkit.internal.views.document.DocumentView.this
                boolean r0 = r4.L
                if (r0 != 0) goto L2d
                return r1
            L2d:
                com.pspdfkit.internal.ln r4 = r4.C
                android.graphics.Point r0 = new android.graphics.Point
                float r1 = r5.getX()
                int r1 = (int) r1
                float r5 = r5.getY()
                int r5 = (int) r5
                r0.<init>(r1, r5)
                r4.getClass()
                r5 = 1
                r4.B = r5
                r4.C = r0
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.views.document.DocumentView.b.onDoubleTap(android.view.MotionEvent):boolean");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent motionEvent) {
            this.a = false;
            DocumentView documentView = DocumentView.this;
            documentView.w0 = 1;
            documentView.C.k();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int iMax;
            DocumentView documentView = DocumentView.this;
            int iMax2 = 0;
            if (documentView.O || !documentView.K) {
                return false;
            }
            if (documentView.w0 == 1) {
                if (Math.abs(f) > Math.abs(f2) * 3.0f) {
                    documentView.w0 = 2;
                } else if (Math.abs(f2) > Math.abs(f) * 3.0f) {
                    documentView.w0 = 3;
                } else {
                    documentView.w0 = 4;
                }
            }
            DocumentView documentView2 = DocumentView.this;
            if (documentView2.w0 == 3) {
                iMax = 0;
            } else {
                int i = documentView2.r;
                iMax = Math.max(-i, Math.min((int) f, i));
            }
            DocumentView documentView3 = DocumentView.this;
            if (documentView3.w0 != 2) {
                int i2 = documentView3.r;
                iMax2 = Math.max(-i2, Math.min((int) f2, i2));
            }
            return DocumentView.this.C.a(-iMax, -iMax2, this.a);
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            DocumentView documentView = DocumentView.this;
            if (!documentView.O) {
                if (!e) {
                    documentView.O = true;
                } else {
                    if (scaleGestureDetector.getEventTime() - this.b > 200) {
                        this.a = true;
                        return false;
                    }
                    if (Math.abs(this.c - scaleGestureDetector.getCurrentSpan()) / DocumentView.this.getResources().getDisplayMetrics().density <= 16.0f) {
                        return false;
                    }
                    DocumentView.this.O = true;
                    onScaleBegin(scaleGestureDetector);
                }
            }
            ln lnVar = DocumentView.this.C;
            lnVar.B = false;
            lnVar.j();
            return DocumentView.this.C.a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.b = 0L;
            this.c = scaleGestureDetector.getCurrentSpan();
            DocumentView documentView = DocumentView.this;
            if (!documentView.L) {
                documentView.O = false;
                return false;
            }
            ln lnVar = documentView.C;
            scaleGestureDetector.getScaleFactor();
            boolean zA = lnVar.a(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            if (zA) {
                this.b = scaleGestureDetector.getEventTime();
            }
            return zA;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector.getEventTime() - this.b < 200) {
                this.a = true;
            }
            this.b = 0L;
            ln lnVar = DocumentView.this.C;
            scaleGestureDetector.getScaleFactor();
            lnVar.l();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            DocumentView documentView = DocumentView.this;
            if (!documentView.O && documentView.K) {
                if (documentView.w0 == 1) {
                    if (Math.abs(f) > Math.abs(f2) * 3.0f) {
                        documentView.w0 = 2;
                    } else if (Math.abs(f2) > Math.abs(f) * 3.0f) {
                        documentView.w0 = 3;
                    } else {
                        documentView.w0 = 4;
                    }
                }
                DocumentView documentView2 = DocumentView.this;
                int i = documentView2.w0;
                int i2 = i == 3 ? 0 : (int) f;
                int i3 = i == 2 ? 0 : (int) f2;
                if (documentView2.M) {
                    documentView2.C.d(i2, i3);
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            DocumentView documentView = DocumentView.this;
            boolean z = false;
            if (documentView.P || documentView.O) {
                return false;
            }
            if (documentView.b(motionEvent)) {
                return true;
            }
            DocumentListener documentListener = DocumentView.this.v;
            if (documentListener != null && documentListener.onDocumentClick()) {
                return true;
            }
            DocumentView documentView2 = DocumentView.this;
            if (documentView2.D == d.TEXT_SELECTION) {
                documentView2.H.setTextSelection(null);
                z = true;
            }
            if (DocumentView.this.a()) {
                z = true;
            }
            if (!z) {
                DocumentView.this.b();
            }
            DocumentView.this.a.a();
            return true;
        }
    }

    public class c implements View.OnKeyListener {
        public boolean a = true;
        public final SparseLongArray b = new SparseLongArray();

        public c() {
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            d1 d1Var;
            if (DocumentView.this.S == null) {
                return false;
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                this.b.put(i, keyEvent.getDownTime());
            } else if (keyEvent.getAction() == 1 && Math.abs(this.b.get(i) - keyEvent.getDownTime()) >= 300) {
                return false;
            }
            if (DocumentView.this.T.isCopyPasteEnabled() && keyEvent.getAction() == 0 && keyEvent.isCtrlPressed() && this.a) {
                ub copyPasteManager = DocumentView.this.getCopyPasteManager();
                synchronized (ar.class) {
                    if (ar.h == null) {
                        ar.h = new d1();
                    }
                    d1Var = ar.h;
                }
                if (i == 50) {
                    if (!d1Var.d) {
                        ArrayList arrayList = d1Var.b;
                        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 < size) {
                                    Object obj = arrayList.get(i2);
                                    i2++;
                                    if (((e1) obj).b()) {
                                    }
                                }
                            }
                        }
                    }
                    if (copyPasteManager != null) {
                        copyPasteManager.a(DocumentView.this.getPage()).subscribe();
                    }
                    this.a = false;
                    return true;
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.toList(DocumentView.this.G.m));
                if (i == 31 && DocumentView.this.G.isCopyEnabled(arrayList2)) {
                    if (copyPasteManager != null) {
                        copyPasteManager.b(arrayList2).subscribe();
                    }
                    this.a = false;
                    return true;
                }
                if (i == 52 && DocumentView.this.G.isCutEnabled(arrayList2)) {
                    if (copyPasteManager != null) {
                        copyPasteManager.a(arrayList2).subscribe();
                    }
                    this.a = false;
                    return true;
                }
            }
            boolean z = i == 22 || i == 21 || i == 19 || i == 20;
            if (keyEvent.getAction() == 0) {
                return z || (!DocumentView.this.G.m.isEmpty() && (i == 67 || i == 112));
            }
            this.a = true;
            if (z && (a80.a((View) DocumentView.this).getCurrentFocus() instanceof EditText)) {
                return false;
            }
            if (i != 67 && i != 112) {
                switch (i) {
                    case 19:
                        return DocumentView.this.c(true);
                    case 20:
                        return DocumentView.this.b(true);
                    case 21:
                        return DocumentView.this.a(true);
                    case 22:
                        return DocumentView.this.d(true);
                    default:
                        return false;
                }
            }
            if (!DocumentView.this.G.m.isEmpty()) {
                q0 q0Var = DocumentView.this.G;
                if (q0Var.isDeleteEnabled(CollectionsKt.toList(q0Var.m))) {
                    q0 q0Var2 = DocumentView.this.G;
                    q0Var2.a(CollectionsKt.toList(q0Var2.m));
                    return true;
                }
            }
            return false;
        }
    }

    public enum d {
        BROWSE,
        TEXT_SELECTION,
        FORM_EDITING,
        CONTENT_EDITING,
        ANNOTATING
    }

    public interface e {
        void a();
    }

    public interface f {
        void a();
    }

    public interface g {
        void a();
    }

    public DocumentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.e = new hu<>(Schedulers.computation());
        this.f = new hu<>(Schedulers.computation());
        this.g = new HashSet(3);
        this.h = new ArrayList(3);
        this.i = new go<>();
        this.k = new CompositeDisposable();
        this.l = new Handler(Looper.getMainLooper());
        this.m = new HashSet();
        this.n = new nb();
        this.o = new yh();
        this.p = new x50();
        this.s = -1;
        this.z = null;
        this.D = d.BROWSE;
        this.E = false;
        this.F = false;
        this.w0 = 1;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = false;
        this.R = 0.0f;
        this.U = ScrollState.IDLE;
        this.a0 = -1;
        this.e0 = EnumSet.noneOf(AnnotationType.class);
        this.f0 = true;
        this.g0 = false;
        this.j0 = null;
        this.k0 = new HashSet(3);
        this.l0 = new go<>();
        this.n0 = false;
        this.o0 = 0L;
        this.q0 = null;
        this.s0 = new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        };
        this.t0 = null;
        this.u0 = null;
        this.v0 = new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.p();
            }
        };
        f();
    }

    private void setScrollState(ScrollState scrollState) {
        if (this.U == scrollState) {
            return;
        }
        this.U = scrollState;
        DocumentScrollListener documentScrollListener = this.x;
        if (documentScrollListener != null) {
            documentScrollListener.onScrollStateChanged(scrollState);
        }
        if (scrollState == ScrollState.IDLE) {
            zd zdVar = this.a;
            zdVar.d.removeCallbacks(zdVar.j);
            zdVar.d.removeCallbacks(zdVar.k);
            PopupToolbar popupToolbar = zdVar.h;
            if (popupToolbar instanceof TextSelectionPopupToolbar) {
                zdVar.d.removeCallbacks(zdVar.j);
                zdVar.d.postDelayed(zdVar.j, 300L);
            } else if (popupToolbar != null) {
                zdVar.d.postDelayed(zdVar.k, 150L);
            }
        }
    }

    public final void a(PdfFragment pdfFragment, a70 a70Var, b20 b20Var, c5 c5Var, y5 y5Var, f3 f3Var, f fVar) {
        Context context = pdfFragment.getContext();
        if (!pdfFragment.isAdded() || context == null) {
            PdfLog.w("Nutri.DocumentView", "Fragment not attached during configureWithFragment, aborting configuration", new Object[0]);
            return;
        }
        this.z = new i(pdfFragment, this);
        this.T = pdfFragment.getConfiguration();
        getContext();
        this.W = new pq();
        this.j = new z1(this, pdfFragment, a70Var);
        this.r0 = PSPDFKitPreferences.get(context);
        this.p0 = new vo(this, this.T);
        try {
            this.q0 = new sp(getContext(), this, this.p0);
        } catch (IllegalStateException e2) {
            PdfLog.e("Nutri.DocumentView", "Can't initialise measurement text magnifier view: " + e2, new Object[0]);
        }
        this.G = new q0(this.j, y5Var, pdfFragment, f3Var, this.r0, a70Var, this.p0, this);
        this.H = new a60(this.p, this.j, pdfFragment, f3Var, a70Var, this.p0);
        zd zdVar = new zd(pdfFragment, this);
        this.a = zdVar;
        a60 a60Var = this.H;
        a60Var.o = zdVar;
        y50 y50Var = a60Var.k;
        if (y50Var != null) {
            y50Var.q = zdVar;
        }
        getTextSelectionListeners().b.a(this);
        this.I = new ab(this.n, pdfFragment);
        this.J = new lh(this.o, pdfFragment, a70Var);
        this.h0 = c5Var;
        this.c0 = a70Var;
        this.d0 = b20Var;
        if (!this.T.isScrollbarsEnabled()) {
            h60.a(new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.j();
                }
            });
        }
        EnumSet<AnnotationType> enumSet = qt.a;
        boolean zE = ar.b().e(this.T);
        EnumSet<AnnotationType> enumSetCopyOf = qt.d.get() ? EnumSet.copyOf((Collection) AnnotationProvider.ALL_ANNOTATION_TYPES) : EnumSet.copyOf((EnumSet) qt.c);
        if (zE) {
            enumSetCopyOf.add(AnnotationType.WIDGET);
        }
        enumSetCopyOf.getClass();
        setOverlaidAnnotationTypes(enumSetCopyOf);
        setRedactionAnnotationPreviewEnabled(pdfFragment.isRedactionAnnotationPreviewEnabled());
        this.d = (f) uw.a(fVar, "onDocumentViewReadyCallback", null);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public final void addDrawableProvider(PdfDrawableProvider pdfDrawableProvider) {
        uw.a(pdfDrawableProvider, "drawableProvider", null);
        hu<PdfDrawableProvider> huVar = this.e;
        huVar.getClass();
        huVar.b.a(pdfDrawableProvider);
    }

    public final void b(final lm lmVar, final PdfFragment pdfFragment) {
        this.S = lmVar;
        this.a0 = -1;
        tq.b();
        Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda9
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                lmVar.setAutomaticLinkGenerationEnabled(pdfFragment.getConfiguration().isAutomaticLinkGenerationEnabled());
            }
        }).subscribeOn(lmVar.b(5)).subscribe();
        ln lnVar = this.C;
        if (lnVar != null) {
            lnVar.j();
            yz.a(lnVar.z);
        }
        x1 x1Var = null;
        this.C = null;
        while (getChildCount() > 0) {
            au auVar = (au) super.getChildAt(0);
            pq pqVar = this.W;
            if (pqVar != null) {
                kq mediaPlayer = auVar.getMediaPlayer();
                mediaPlayer.j = null;
                for (qq qqVar : mediaPlayer.f.values()) {
                    if (qqVar != null) {
                        qqVar.setOnMediaPlaybackChangeListener(null);
                    }
                }
                pqVar.b.remove(mediaPlayer);
            }
            auVar.setVisibility(8);
            this.y.a(auVar);
            m40 state = auVar.getState();
            if (state != null) {
                this.k0.remove(Integer.valueOf(state.b));
            }
            removeViewAt(0);
        }
        DocumentListener documentListener = this.v;
        if (documentListener != null) {
            documentListener.onDocumentLoaded(lmVar);
        }
        requestLayout();
        a60 a60Var = this.H;
        EnumSet enumSetClone = lmVar.G.clone();
        enumSetClone.getClass();
        a60Var.j = enumSetClone;
        z1 z1Var = this.j;
        if (z1Var != null) {
            PdfFragment pdfFragment2 = z1Var.b;
            at atVar = z1Var.c;
            pdfFragment2.getClass();
            atVar.getClass();
            if (pdfFragment2.getDocument() != null) {
                Fragment fragmentFindFragmentByTag = pdfFragment2.getParentFragmentManager().findFragmentByTag("Nutrient.AnnotationEditor");
                c2 c2Var = fragmentFindFragmentByTag instanceof c2 ? (c2) fragmentFindFragmentByTag : null;
                if (c2Var != null) {
                    c2Var.d = pdfFragment2;
                    c2Var.e = atVar;
                    c2Var.g = pdfFragment2.getAnnotationConfiguration();
                    c2Var.h = pdfFragment2.getAnnotationPreferences();
                    c2Var.f = pdfFragment2.getConfiguration();
                    PdfDocument document = pdfFragment2.getDocument();
                    lm lmVar2 = document instanceof lm ? (lm) document : null;
                    c2Var.a = lmVar2;
                    if (lmVar2 != null) {
                        c2Var.a = lmVar2;
                        wu wuVar = c2Var.b;
                        if (wuVar != null) {
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(c2Var), null, null, new b2(wuVar, lmVar2, c2Var, null), 3, null);
                        }
                    }
                    FragmentManager parentFragmentManager = pdfFragment2.getParentFragmentManager();
                    parentFragmentManager.getClass();
                    x1Var = new x1(c2Var, parentFragmentManager);
                }
            }
            if (x1Var != null) {
                x1Var.c = z1Var.new a();
            }
        }
        o3 annotationProvider = lmVar.getAnnotationProvider();
        annotationProvider.getClass();
        annotationProvider.h.a(this);
    }

    @Override // com.pspdfkit.internal.px.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final au create() {
        if (this.z == null) {
            throw new IllegalStateException("Action resolver is null. Has the document been loaded?");
        }
        au auVar = new au(getContext(), this, this.T, this.i, this.j, this.o, this.h0, this.c0, this.d0, this.V, this.e, this.f, new et() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda10
            @Override // com.pspdfkit.internal.et
            public final void a(int i) {
                this.f$0.g(i);
            }
        });
        auVar.setHorizontalScrollBarEnabled(true);
        auVar.setVerticalScrollBarEnabled(true);
        auVar.setOnKeyListener(new c());
        auVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        a80.a((ViewGroup) auVar);
        return auVar;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        ln lnVar = this.C;
        if (lnVar != null) {
            return lnVar.c();
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        ln lnVar = this.C;
        if (lnVar != null) {
            return lnVar.d();
        }
        return 0;
    }

    @Override // android.view.View
    public final void computeScroll() {
        m40 state;
        ln lnVar = this.C;
        if (lnVar == null) {
            return;
        }
        boolean zA = lnVar.a();
        this.n0 = zA;
        int i = 0;
        if (zA) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((au) super.getChildAt(i2)).a(false);
            }
            awakenScrollBars();
            invalidate();
            setScrollState((this.C.n || this.M) ? ScrollState.DRAGGED : ScrollState.SETTLING);
            zd zdVar = this.a;
            zdVar.d.removeCallbacks(zdVar.j);
            zdVar.d.removeCallbacks(zdVar.k);
            PopupToolbar popupToolbar = zdVar.h;
            if (popupToolbar != null) {
                popupToolbar.dismiss();
                if (Intrinsics.areEqual(popupToolbar, (PopupToolbar) zdVar.e.getValue())) {
                    zdVar.h = null;
                }
            }
            DocumentScrollListener documentScrollListener = this.x;
            if (documentScrollListener != null) {
                documentScrollListener.onDocumentScrolled(computeHorizontalScrollOffset(), computeVerticalScrollOffset(), computeHorizontalScrollRange(), computeVerticalScrollRange(), computeHorizontalScrollExtent(), computeVerticalScrollExtent());
            }
        } else {
            this.w0 = 1;
            int childCount2 = getChildCount();
            for (int i3 = 0; i3 < childCount2; i3++) {
                au auVar = (au) super.getChildAt(i3);
                auVar.b();
                if (!auVar.v && ((state = auVar.getState()) == null || state.b != f7.b.b || System.currentTimeMillis() - f7.b.a > 1000)) {
                    vt.a(auVar.j, false, false, 13);
                    auVar.k.a(false);
                    auVar.g.getClass();
                }
                auVar.a(true);
            }
            setScrollState(ScrollState.IDLE);
        }
        ln lnVar2 = this.C;
        ArrayList arrayList = lnVar2.A;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Function0) obj).invoke();
        }
        lnVar2.A.clear();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        ln lnVar = this.C;
        if (lnVar != null) {
            return lnVar.e();
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        ln lnVar = this.C;
        if (lnVar != null) {
            return lnVar.f();
        }
        return 0;
    }

    public final /* synthetic */ void d(int i) {
        if (i != -1) {
            a(i, Boolean.FALSE);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        vo voVar = this.p0;
        if (voVar != null) {
            voVar.a(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        au auVarB;
        if (!isEnabled()) {
            return true;
        }
        if (!this.g0) {
            Iterator<Integer> it = getVisiblePages().iterator();
            boolean zDispatchTouchEvent = false;
            while (it.hasNext() && (auVarB = b(it.next().intValue())) != null) {
                float scrollX = getScrollX() - auVarB.getLeft();
                float scrollY = getScrollY() - auVarB.getTop();
                motionEvent.offsetLocation(scrollX, scrollY);
                zDispatchTouchEvent |= auVarB.K.dispatchTouchEvent(motionEvent);
                motionEvent.offsetLocation(-scrollX, -scrollY);
            }
            if (zDispatchTouchEvent) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final /* synthetic */ void e(int i) {
        lm lmVar;
        DocumentListener documentListener = this.v;
        if (documentListener == null || (lmVar = this.S) == null) {
            return;
        }
        documentListener.onPageUpdated(lmVar, i);
    }

    @Override // com.pspdfkit.internal.m30
    public final void enterAnnotatingMode(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        if (!ar.b().a(this.T, annotationTool)) {
            throw new NutrientException("Entering annotation creation mode for " + annotationTool + " is not permitted, either by the license or configuration.");
        }
        this.a.a();
        this.D = d.ANNOTATING;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            au auVar = (au) super.getChildAt(i);
            q0 q0Var = this.G;
            auVar.getClass();
            annotationToolVariant.getClass();
            q0Var.getClass();
            auVar.F.a(annotationTool, annotationToolVariant, q0Var);
        }
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        bundleA.putString(Analytics.Data.ANNOTATION_TOOL, annotationTool.name());
        i0VarA.a(Analytics.Event.ENTER_ANNOTATION_CREATION_MODE, bundleA);
    }

    @Override // com.pspdfkit.internal.m30
    public final void exitCurrentlyActiveMode() {
        if (this.F) {
            return;
        }
        this.a.a();
        if (i()) {
            this.F = true;
            try {
                q0 q0Var = this.G;
                List list = Collections.EMPTY_LIST;
                q0Var.m.clear();
                if (list == null || list.isEmpty()) {
                    q0Var.n = null;
                } else {
                    at atVar = q0Var.c;
                    atVar.getClass();
                    q0Var.n = new i3(list, atVar);
                    q0Var.m.addAll(list);
                }
                int iOrdinal = this.D.ordinal();
                if (iOrdinal == 2) {
                    b();
                    this.J.a(null);
                    if (this.E) {
                        this.D = d.ANNOTATING;
                        this.E = false;
                        this.F = false;
                        return;
                    }
                } else if (iOrdinal == 4) {
                    a();
                    this.G.b((List<? extends Annotation>) null);
                    AnnotationTool activeAnnotationTool = getActiveAnnotationTool();
                    i0 i0VarA = ar.a();
                    i0VarA.getClass();
                    Bundle bundle = new Bundle();
                    bundle.putString(Analytics.Data.ANNOTATION_TOOL, activeAnnotationTool != null ? activeAnnotationTool.name() : AbstractJsonLexerKt.NULL);
                    i0VarA.a(Analytics.Event.EXIT_ANNOTATION_CREATION_MODE, bundle);
                    this.H.l = null;
                }
                this.D = d.BROWSE;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ((au) super.getChildAt(i)).F.a(false);
                }
                this.F = false;
            } catch (Throwable th) {
                this.F = false;
                throw th;
            }
        }
    }

    public final void f() {
        setWillNotDraw(false);
        setSaveEnabled(false);
        setSaveFromParentEnabled(false);
        setClipChildren(false);
        setFocusable(false);
        setOnKeyListener(new c());
        this.y = new px<>(3);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.q = viewConfiguration.getScaledTouchSlop();
        this.r = viewConfiguration.getScaledMaximumFlingVelocity();
        b bVar = new b();
        GestureDetector gestureDetector = new GestureDetector(getContext(), bVar);
        this.A = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.B = new ScaleGestureDetector(getContext(), bVar);
        this.V = new h();
        this.b0 = getResources().getConfiguration().orientation;
    }

    public final void g(final int i) {
        post(new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e(i);
            }
        });
    }

    public ActionResolver getActionResolver() {
        i iVar = this.z;
        if (iVar != null) {
            return iVar;
        }
        PdfLog.w("Nutri.DocumentView", "Attempting to get null action resolver. Has the document been loaded?", new Object[0]);
        return null;
    }

    public AnnotationTool getActiveAnnotationTool() {
        q0 q0Var = this.G;
        if (q0Var == null) {
            return null;
        }
        return q0Var.s;
    }

    public AnnotationToolVariant getActiveAnnotationToolVariant() {
        q0 q0Var = this.G;
        if (q0Var == null) {
            return null;
        }
        return q0Var.t;
    }

    public q0 getAnnotatingHandler() {
        return this.G;
    }

    public List<OnAnnotationSelectedListener> getAnnotationSelectionListeners() {
        return new ArrayList(this.i.a);
    }

    @Override // android.view.ViewGroup
    public final View getChildAt(int i) {
        return (au) super.getChildAt(i);
    }

    public ab getContentEditingHandler() {
        return this.I;
    }

    public ContentEditingManager getContentEditingManager() {
        return this.n;
    }

    public cb getContentEditingState() {
        if (getInteractionMode() != d.CONTENT_EDITING) {
            return null;
        }
        int page = getPage();
        cb cbVar = new cb();
        cbVar.a = page;
        return cbVar;
    }

    @Override // com.pspdfkit.internal.zb
    public ub getCopyPasteManager() {
        lm lmVar = this.S;
        if (lmVar != null) {
            return lmVar.o;
        }
        return null;
    }

    public lm getDocument() {
        return this.S;
    }

    public yh getFormListeners() {
        return this.o;
    }

    public d getInteractionMode() {
        return this.D;
    }

    public vo getMagnifierManager() {
        return this.p0;
    }

    public List<jq> getMediaContentStates() {
        pq pqVar = this.W;
        return pqVar != null ? pqVar.a() : new ArrayList();
    }

    public EnumSet<AnnotationType> getOverlaidAnnotationTypes() {
        return this.e0;
    }

    public int getPage() {
        ln lnVar = this.C;
        if (lnVar == null) {
            return -1;
        }
        return lnVar.p;
    }

    public int getPageCount() {
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        return this.S.s;
    }

    public List<Annotation> getSelectedAnnotations() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            List listUnmodifiableList = Collections.unmodifiableList(((au) super.getChildAt(i)).getPageEditor().t);
            listUnmodifiableList.getClass();
            arrayList.addAll(listUnmodifiableList);
        }
        return arrayList;
    }

    public FormElement getSelectedFormElement() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            FormElement formElement = ((au) super.getChildAt(i)).getFormEditor().k;
            if (formElement != null) {
                return formElement;
            }
        }
        return null;
    }

    public TextSelection getTextSelection() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            TextSelection textSelection = ((au) super.getChildAt(i)).getTextSelection();
            if (textSelection != null) {
                return textSelection;
            }
        }
        return null;
    }

    public x50 getTextSelectionListeners() {
        return this.p;
    }

    public a60 getTextSelectionSpecialModeHandler() {
        return this.H;
    }

    public x70 getViewState() {
        ln lnVar = this.C;
        if (lnVar == null) {
            return null;
        }
        x70 x70Var = lnVar.l;
        if (x70Var != null) {
            return x70Var;
        }
        RectF rectFG = lnVar.g(lnVar.p);
        s60.a(rectFG, lnVar.a(lnVar.p, (Matrix) null));
        int i = lnVar.p;
        return new x70(rectFG, i, lnVar.h(i));
    }

    public List<Integer> getVisiblePages() {
        m40 state;
        ArrayList arrayList = new ArrayList();
        Rect rect = new Rect();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            au auVar = (au) super.getChildAt(i);
            if (auVar.getGlobalVisibleRect(rect) && (state = auVar.getState()) != null) {
                arrayList.add(Integer.valueOf(state.b));
            }
        }
        return arrayList;
    }

    public final boolean h() {
        return getInteractionMode() == d.ANNOTATING && getAnnotatingHandler().s == AnnotationTool.ANNOTATION_MULTI_SELECTION;
    }

    public final boolean i() {
        return this.D != d.BROWSE;
    }

    public final /* synthetic */ void j() {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    public final void k() {
        if (this.C == null) {
            PdfLog.w("Nutri.DocumentView", "layoutManager is null. Cannot complete DocumentView layout.", new Object[0]);
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.C.a((au) super.getChildAt(i));
        }
    }

    public final void l() {
        if (this.C == null) {
            PdfLog.w("Nutri.DocumentView", "layoutManager is null. Cannot complete DocumentView measure.", new Object[0]);
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            this.C.b((au) super.getChildAt(i));
        }
    }

    public final void m() {
        int page = getPage();
        if (page < 0) {
            return;
        }
        ln lnVar = this.C;
        float fH = lnVar != null ? lnVar.h(page) : 1.0f;
        DocumentListener documentListener = this.v;
        if (documentListener != null && fH != this.R) {
            Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
            documentListener.onDocumentZoomed(this.S, page, fH);
        }
        this.R = fH;
    }

    public final void n() {
        final int page = getPage();
        ln lnVar = this.C;
        if (lnVar != null) {
            lnVar.j();
            yz.a(lnVar.z);
        }
        this.C = null;
        getViewTreeObserver().addOnGlobalLayoutListener(new y70(this, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f$0.d(page);
            }
        }));
        requestLayout();
    }

    public final void o() {
        ln lnVar = this.C;
        if (lnVar == null || lnVar.l != null) {
            return;
        }
        Iterator<Integer> it = getVisiblePages().iterator();
        while (it.hasNext()) {
            if (this.k0.contains(it.next())) {
                return;
            }
        }
        Iterator<g> it2 = this.l0.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager.OnTextSelectionChangeListener
    public final void onAfterTextSelectionChange(TextSelection textSelection, TextSelection textSelection2) {
        if (textSelection2 != null) {
            zd zdVar = this.a;
            a60 a60Var = this.H;
            zdVar.getClass();
            a60Var.getClass();
            TextSelectionPopupToolbar textSelectionPopupToolbar = (TextSelectionPopupToolbar) zdVar.f.getValue();
            if (textSelectionPopupToolbar == null) {
                return;
            }
            zdVar.g = a60Var;
            textSelectionPopupToolbar.bindController(a60Var);
            OnPreparePopupToolbarListener onPreparePopupToolbarListener = zdVar.i;
            if (onPreparePopupToolbarListener != null) {
                onPreparePopupToolbarListener.onPrepareTextSelectionPopupToolbar(textSelectionPopupToolbar);
            }
            PopupToolbar popupToolbar = zdVar.h;
            if (popupToolbar != null) {
                popupToolbar.dismiss();
            }
            zdVar.h = textSelectionPopupToolbar;
            y50 y50Var = a60Var.k;
            if (y50Var == null || y50Var.t == y50.b.NO_DRAG) {
                zdVar.d.removeCallbacks(zdVar.j);
                zdVar.d.postDelayed(zdVar.j, 300L);
            }
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        a(Collections.singletonList(annotation));
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        a(Collections.singletonList(annotation));
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        a(Collections.singletonList(annotation));
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<Annotation> list, List<Annotation> list2) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        vo voVar = this.p0;
        if (voVar != null && voVar.e && !voVar.d) {
            voVar.c.a.a();
        }
        super.onAttachedToWindow();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager.OnTextSelectionChangeListener
    public final boolean onBeforeTextSelectionChange(TextSelection textSelection, TextSelection textSelection2) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        vo voVar = this.p0;
        if (voVar != null && voVar.e && !voVar.d) {
            voVar.c.a.b();
        }
        sp spVar = this.q0;
        if (spVar != null) {
            spVar.a();
        }
        Job job = tq.a;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        tq.a = null;
        super.onDetachedFromWindow();
        Job job2 = this.j0;
        if (job2 != null) {
            job2.cancel((CancellationException) null);
            this.j0 = null;
        }
        ln lnVar = this.C;
        if (lnVar != null) {
            lnVar.j();
            yz.a(lnVar.z);
        }
        yz.a(this.c);
        this.c = null;
        removeCallbacks(this.s0);
        this.l.removeCallbacks(this.v0);
        this.m.clear();
        while (getChildCount() > 0) {
            au auVar = (au) super.getChildAt(0);
            pq pqVar = this.W;
            if (pqVar != null) {
                kq mediaPlayer = auVar.getMediaPlayer();
                mediaPlayer.j = null;
                for (qq qqVar : mediaPlayer.f.values()) {
                    if (qqVar != null) {
                        qqVar.setOnMediaPlaybackChangeListener(null);
                    }
                }
                pqVar.b.remove(mediaPlayer);
            }
            auVar.setVisibility(8);
            this.y.a(auVar);
            m40 state = auVar.getState();
            if (state != null) {
                this.k0.remove(Integer.valueOf(state.b));
            }
            removeViewAt(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00e5 A[RETURN] */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d dVar;
        d dVar2;
        y50 y50Var;
        ta taVar;
        e eVar = this.m0;
        if (eVar != null) {
            eVar.a();
        }
        if (!isEnabled()) {
            return false;
        }
        if (this.C == null || motionEvent.getPointerCount() >= 3) {
            return true;
        }
        this.P = true;
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        int actionMasked = motionEvent.getActionMasked();
        int iMax = Math.max(motionEvent.findPointerIndex(this.s), 0);
        if (actionMasked == 0) {
            Job job = this.j0;
            if (job != null) {
                job.cancel((CancellationException) null);
                this.j0 = null;
            }
            this.M = true;
            this.N = false;
            this.i0 = this.D == d.ANNOTATING && this.r0.useStylusForAnnotating().booleanValue() && x40.a() && !br.a(motionEvent);
            this.s = pointerId;
            this.t = motionEvent.getX(iMax);
            this.u = motionEvent.getY(iMax);
        } else {
            if (actionMasked == 2) {
                float x = motionEvent.getX(iMax);
                float y = motionEvent.getY(iMax);
                float fAbs = Math.abs(x - this.t);
                float fAbs2 = Math.abs(y - this.u);
                float f2 = this.q;
                boolean z = fAbs > f2 || fAbs2 > f2;
                if (!this.N) {
                    if (!i() || (dVar = this.D) == d.FORM_EDITING) {
                        if (z) {
                            return true;
                        }
                    } else if (dVar == d.CONTENT_EDITING) {
                        ArrayList<ta> arrayList = this.I.i;
                        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i = 0;
                            do {
                                if (i < size) {
                                    ta taVar2 = arrayList.get(i);
                                    i++;
                                    taVar = taVar2;
                                    if (taVar.N != null) {
                                        break;
                                    }
                                }
                            } while (taVar.O == null);
                            dVar2 = this.D;
                            if ((dVar2 != d.ANNOTATING && this.G.s == AnnotationTool.NONE) || this.i0 || ((dVar2 == d.TEXT_SELECTION && ((y50Var = this.H.k) == null || y50Var.t == y50.b.NO_DRAG)) || motionEvent.getPointerCount() == 2)) {
                            }
                        }
                        if (z) {
                            return true;
                        }
                    } else {
                        dVar2 = this.D;
                        if (dVar2 != d.ANNOTATING) {
                            if (z) {
                                return true;
                            }
                        } else if (z) {
                            return true;
                        }
                    }
                }
                return false;
            }
            if (actionMasked == 6 && pointerId != this.s) {
                this.C.a(false);
                this.O = false;
            } else {
                this.i0 = false;
                if (pointerId == this.s) {
                    this.C.a(true);
                    this.O = false;
                    this.M = false;
                }
            }
        }
        this.B.onTouchEvent(motionEvent);
        if (!this.O) {
            this.A.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.S != null) {
            if (this.C == null) {
                g();
            }
            if (getChildCount() == 0) {
                e();
            }
            l();
            k();
        }
    }

    @Override // android.view.View
    public final void onProvideStructure(ViewStructure viewStructure) {
        super.onProvideStructure(viewStructure);
        lm document = getDocument();
        if (document == null || getPage() == -1) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        RectF rectF = new RectF();
        Iterator<Integer> it = getVisiblePages().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            a(rectF, iIntValue);
            sb.append(document.getPageText(iIntValue, rectF));
            sb.append("\n");
        }
        viewStructure.setText(sb.toString());
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.S != null) {
            if (this.C == null || this.b0 != getResources().getConfiguration().orientation) {
                g();
                while (getChildCount() > 0) {
                    au auVar = (au) super.getChildAt(0);
                    pq pqVar = this.W;
                    if (pqVar != null) {
                        kq mediaPlayer = auVar.getMediaPlayer();
                        mediaPlayer.j = null;
                        for (qq qqVar : mediaPlayer.f.values()) {
                            if (qqVar != null) {
                                qqVar.setOnMediaPlaybackChangeListener(null);
                            }
                        }
                        pqVar.b.remove(mediaPlayer);
                    }
                    auVar.setVisibility(8);
                    this.y.a(auVar);
                    m40 state = auVar.getState();
                    if (state != null) {
                        this.k0.remove(Integer.valueOf(state.b));
                    }
                    removeViewAt(0);
                }
                e();
            } else {
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                ln lnVar = this.C;
                if (lnVar.h != width || lnVar.i != height) {
                    lnVar.e(width, height);
                }
                for (int i5 = 0; i5 < getChildCount(); i5++) {
                    ((au) super.getChildAt(i5)).requestLayout();
                }
            }
            this.b0 = getResources().getConfiguration().orientation;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.C == null || motionEvent.getPointerCount() >= 3) {
            return false;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        int actionMasked = motionEvent.getActionMasked();
        int iMax = Math.max(motionEvent.findPointerIndex(this.s), 0);
        if (actionMasked == 0) {
            boolean zA = a(motionEvent);
            this.Q = zA;
            this.P = zA;
        } else if (actionMasked == 1 || actionMasked == 3) {
            if (this.Q) {
                a(motionEvent);
                this.P = false;
                this.Q = false;
            }
        } else if (this.Q) {
            a(motionEvent);
        } else {
            this.P = false;
        }
        if (actionMasked != 0) {
            if (actionMasked == 2) {
                float x = motionEvent.getX(iMax);
                float y = motionEvent.getY(iMax);
                float fAbs = Math.abs(x - this.t);
                float fAbs2 = Math.abs(y - this.u);
                float f2 = this.q;
                if (fAbs > f2 || fAbs2 > f2) {
                    this.t = x;
                    this.u = y;
                }
            } else if (actionMasked != 5) {
                if (actionMasked == 6 && pointerId != this.s) {
                    this.C.a(false);
                    this.O = false;
                } else if (pointerId == this.s) {
                    this.C.a(true);
                    this.O = false;
                    this.M = false;
                }
            }
            this.B.onTouchEvent(motionEvent);
            if (!this.O) {
                this.A.onTouchEvent(motionEvent);
            }
        }
        return true;
    }

    public final void p() {
        g60 g60VarC;
        if (this.S == null || this.m.isEmpty()) {
            this.m.clear();
            return;
        }
        final HashSet hashSet = new HashSet(this.m);
        this.m.clear();
        Completable completableA = q10.a.a().a(this.S.B, hashSet);
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        this.k.add(completableA.subscribeOn(((m0) g60VarC).a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(hashSet);
            }
        }));
    }

    public final void q() {
        Job job = this.j0;
        if (job != null) {
            job.cancel((CancellationException) null);
            this.j0 = null;
        }
        ln lnVar = this.C;
        if (lnVar != null) {
            lnVar.j();
            yz.a(lnVar.z);
        }
        yz.a(this.c);
        this.c = null;
        removeCallbacks(this.s0);
        this.l.removeCallbacks(this.v0);
        this.m.clear();
        while (getChildCount() > 0) {
            au auVar = (au) super.getChildAt(0);
            pq pqVar = this.W;
            if (pqVar != null) {
                kq mediaPlayer = auVar.getMediaPlayer();
                mediaPlayer.j = null;
                for (qq qqVar : mediaPlayer.f.values()) {
                    if (qqVar != null) {
                        qqVar.setOnMediaPlaybackChangeListener(null);
                    }
                }
                pqVar.b.remove(mediaPlayer);
            }
            auVar.setVisibility(8);
            this.y.a(auVar);
            m40 state = auVar.getState();
            if (state != null) {
                this.k0.remove(Integer.valueOf(state.b));
            }
            removeViewAt(0);
        }
    }

    public final lm r() {
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        return this.S;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public final void removeDrawableProvider(PdfDrawableProvider pdfDrawableProvider) {
        uw.a(pdfDrawableProvider, "drawableProvider", null);
        hu<PdfDrawableProvider> huVar = this.e;
        huVar.getClass();
        huVar.b.b(pdfDrawableProvider);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            this.M = false;
        }
    }

    public void setAnnotationOverlayAboveOverlayViews(boolean z) {
        this.g0 = z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((au) super.getChildAt(i)).setAnnotationOverlayAboveOverlayViews(z);
        }
    }

    public void setAnnotationOverlayEnabled(boolean z) {
        this.f0 = z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((au) super.getChildAt(i)).setAnnotationOverlayEnabled(z);
        }
    }

    public void setDocumentListener(DocumentListener documentListener) {
        this.v = documentListener;
    }

    public void setDocumentScrollListener(DocumentScrollListener documentScrollListener) {
        this.x = documentScrollListener;
    }

    public void setMediaContentStates(List<jq> list) {
        pq pqVar = this.W;
        if (pqVar != null) {
            pqVar.d = list;
            pq.a(list, pqVar.b);
        }
    }

    public void setOnDocumentInteractionListener(e eVar) {
        this.m0 = eVar;
    }

    public void setOnDocumentLongPressListener(OnDocumentLongPressListener onDocumentLongPressListener) {
        this.w = onDocumentLongPressListener;
    }

    public void setOnPreparePopupToolbarListener(OnPreparePopupToolbarListener onPreparePopupToolbarListener) {
        this.a.i = onPreparePopupToolbarListener;
    }

    public void setOverlaidAnnotationTypes(EnumSet<AnnotationType> enumSet) {
        this.e0.clear();
        this.e0.addAll(qt.a(enumSet));
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            i4 annotationRenderingCoordinator = ((au) super.getChildAt(i)).getAnnotationRenderingCoordinator();
            EnumSet<AnnotationType> enumSet2 = this.e0;
            annotationRenderingCoordinator.getClass();
            enumSet2.getClass();
            EnumSet<AnnotationType> enumSetA = qt.a(enumSet2);
            if (!Intrinsics.areEqual(annotationRenderingCoordinator.n, enumSetA)) {
                annotationRenderingCoordinator.n = enumSetA;
                annotationRenderingCoordinator.o = false;
                annotationRenderingCoordinator.e();
                annotationRenderingCoordinator.b();
            }
        }
    }

    public void setPage(int i) {
        a(i, (Boolean) null);
    }

    public void setRedactionAnnotationPreviewEnabled(boolean z) {
        this.b = z;
        for (int i = 0; i < getChildCount(); i++) {
            au auVar = (au) super.getChildAt(i);
            if (auVar != null) {
                auVar.setRedactionAnnotationPreviewEnabled(z);
            }
        }
        if (this.S != null) {
            yz.a(this.c);
            this.c = AnnotationProviderRxJava.getAllAnnotationsOfTypeObservable(this.S.getAnnotationProvider(), EnumSet.of(AnnotationType.REDACT)).toList().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda1
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) {
                    this.f$0.a((List<? extends Annotation>) obj);
                }
            }, new Consumer() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda2
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.a((Throwable) obj);
                }
            });
        }
    }

    public void setScrollingEnabled(boolean z) {
        this.K = z;
    }

    public void setSelectedAnnotations(List<Annotation> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Annotation annotation : list) {
            if ((ar.b().a(this.T, annotation) && ww.f(annotation)) || (ar.b().a(NativeLicenseFeatures.ANNOTATION_EDITING) && annotation.getType() == AnnotationType.NONE)) {
                arrayList.add(annotation);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (this.D != d.ANNOTATING) {
            exitCurrentlyActiveMode();
        }
        this.G.b(arrayList);
    }

    public void setViewState(x70 x70Var) {
        ln lnVar = this.C;
        if (lnVar != null) {
            lnVar.a(x70Var);
        } else {
            this.u0 = x70Var;
        }
    }

    public void setZoomingEnabled(boolean z) {
        this.L = z;
    }

    public final boolean d(boolean z) {
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        return this.S.getPageBinding() == PageBinding.RIGHT_EDGE ? c(z) : b(z);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c3  */
    public final void g() {
        x70 x70Var;
        boolean z;
        ln d30Var;
        DocumentView documentView;
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int iA = a80.a(getContext(), this.T.getPagePadding());
        ln lnVar = this.C;
        if (lnVar != null) {
            x70Var = lnVar.l;
            if (x70Var == null) {
                RectF rectFG = lnVar.g(lnVar.p);
                s60.a(rectFG, lnVar.a(lnVar.p, (Matrix) null));
                int i = lnVar.p;
                x70Var = new x70(rectFG, i, lnVar.h(i));
            }
        } else {
            x70Var = this.u0;
        }
        x70 x70Var2 = x70Var;
        this.u0 = null;
        if (x70Var2 != null) {
            this.t0 = Integer.valueOf(x70Var2.b);
        }
        ln lnVar2 = this.C;
        if (lnVar2 != null) {
            lnVar2.j();
            yz.a(lnVar2.z);
        }
        Context context = getContext();
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        lm lmVar = this.S;
        PdfConfiguration pdfConfiguration = this.T;
        context.getClass();
        lmVar.getClass();
        pdfConfiguration.getClass();
        if (pdfConfiguration.getScrollMode() != PageScrollMode.PER_PAGE) {
            z = false;
        } else {
            boolean z2 = pdfConfiguration.getLayoutMode() == PageLayoutMode.DOUBLE;
            boolean z3 = context.getResources().getConfiguration().orientation == 2 && uc.a(context, 540) && pdfConfiguration.getLayoutMode() == PageLayoutMode.AUTO;
            if (lmVar.s <= 1 || !(z2 || z3)) {
                z = false;
            } else {
                z = true;
            }
        }
        PageScrollDirection scrollDirection = this.T.getScrollDirection();
        PageScrollMode scrollMode = this.T.getScrollMode();
        PageFitMode fitMode = this.T.getFitMode();
        float f2 = this.T.getShouldZoomOutBounce() ? 0.9f : 1.0f;
        float maxZoomScale = this.T.getMaxZoomScale();
        boolean zIsFirstPageAlwaysSingle = this.T.isFirstPageAlwaysSingle();
        boolean showGapBetweenPages = this.T.getShowGapBetweenPages();
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        lm lmVar2 = this.S;
        PdfConfiguration pdfConfiguration2 = this.T;
        lmVar2.getClass();
        pdfConfiguration2.getClass();
        PageBinding pageBinding = lmVar2.getPageBinding();
        boolean z4 = z;
        PageBinding pageBinding2 = PageBinding.RIGHT_EDGE;
        zt wzVar = (pageBinding == pageBinding2 && pdfConfiguration2.getScrollDirection() == PageScrollDirection.HORIZONTAL) ? new wz(lmVar2.s) : (lmVar2.getPageBinding() == pageBinding2 && pdfConfiguration2.getScrollDirection() == PageScrollDirection.VERTICAL && z4) ? new xz(lmVar2.s, pdfConfiguration2.isFirstPageAlwaysSingle()) : new oc();
        boolean z5 = fitMode == PageFitMode.FIT_TO_SCREEN;
        if (scrollMode == PageScrollMode.CONTINUOUS) {
            documentView = this;
            d30Var = new sb(documentView, width, height, f2, maxZoomScale, iA, z5, wzVar, scrollDirection);
        } else {
            float f3 = f2;
            zt ztVar = wzVar;
            if (z4) {
                documentView = this;
                d30Var = new xe(documentView, width, height, f3, maxZoomScale, iA, z5, !zIsFirstPageAlwaysSingle, showGapBetweenPages, ztVar, scrollDirection);
            } else {
                documentView = this;
                d30Var = new d30(documentView, width, height, f3, maxZoomScale, iA, z5, ztVar, scrollDirection);
            }
        }
        documentView.C = d30Var;
        if (x70Var2 != null && x70Var2.b != -1) {
            d30Var.a(x70Var2);
        }
        for (int i2 = 0; i2 < documentView.getChildCount(); i2++) {
            au auVar = (au) super.getChildAt(i2);
            m40 state = auVar.getState();
            if (state != null) {
                Size sizeF = documentView.C.f(state.b);
                sizeF.getClass();
                m40 state2 = auVar.getState();
                if (state2 != null) {
                    state2.g = sizeF;
                }
            }
        }
        f fVar = documentView.d;
        if (fVar != null) {
            documentView.d = null;
            fVar.a();
        }
    }

    public final void e() {
        int i;
        int iB;
        ln lnVar = this.C;
        if (lnVar != null && (i = lnVar.p) >= 0 && lnVar.h(i) >= 1.0f) {
            Integer num = this.t0;
            if (num != null && num.intValue() != -1) {
                iB = this.t0.intValue();
            } else {
                iB = lnVar.b(getScrollX(), getScrollY());
            }
            this.t0 = null;
            Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
            int i2 = this.S.s - 1;
            int iE = lnVar.e(iB);
            int iMin = iE == -1 ? iB : Math.min(iB, iE);
            int iMax = iE == -1 ? iB : Math.max(iB, iE);
            int i3 = iMin - 1;
            int iE2 = i3 >= 0 ? lnVar.e(i3) : -1;
            if (i3 >= 0) {
                iMin = Math.min(iMin, i3);
            }
            if (iE2 != -1) {
                iMin = Math.min(iMin, iE2);
            }
            int i4 = iMax + 1;
            int iE3 = i4 <= i2 ? lnVar.e(i4) : -1;
            if (i4 <= i2) {
                iMax = Math.max(iMax, i4);
            }
            if (iE3 != -1) {
                iMax = Math.max(iMax, iE3);
            }
            this.g.clear();
            this.h.clear();
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                au auVar = (au) super.getChildAt(i6);
                m40 state = auVar.getState();
                if (state != null) {
                    int i7 = state.b;
                    if (i7 >= iMin && i7 <= iMax) {
                        this.g.add(Integer.valueOf(i7));
                        if (i7 == iB && (findFocus() instanceof au)) {
                            auVar.requestFocus();
                        }
                    } else {
                        this.h.add(auVar);
                    }
                }
            }
            ArrayList arrayList = this.h;
            int size = arrayList.size();
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                au auVar2 = (au) obj;
                pq pqVar = this.W;
                if (pqVar != null) {
                    kq mediaPlayer = auVar2.getMediaPlayer();
                    mediaPlayer.j = null;
                    for (qq qqVar : mediaPlayer.f.values()) {
                        if (qqVar != null) {
                            qqVar.setOnMediaPlaybackChangeListener(null);
                        }
                    }
                    pqVar.b.remove(mediaPlayer);
                }
                auVar2.setVisibility(8);
                this.y.a(auVar2);
                m40 state2 = auVar2.getState();
                if (state2 != null) {
                    this.k0.remove(Integer.valueOf(state2.b));
                }
            }
            this.h.clear();
            while (iMin <= iMax) {
                if (!this.g.contains(Integer.valueOf(iMin))) {
                    c(iMin);
                }
                iMin++;
            }
        }
    }

    public final void d() {
        if (ar.b().d(this.T)) {
            d dVar = this.D;
            d dVar2 = d.CONTENT_EDITING;
            if (dVar != dVar2) {
                exitCurrentlyActiveMode();
            }
            this.D = dVar2;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                final au auVar = (au) super.getChildAt(i);
                if (auVar.v) {
                    auVar.a(this.I);
                } else {
                    post(new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(auVar);
                        }
                    });
                }
            }
            return;
        }
        throw new NutrientException("Entering content editing mode is not permitted, either by the license or configuration.");
    }

    public final void c(int i) {
        int i2;
        q0 q0Var;
        final AnnotationTool annotationTool;
        final au auVar = (au) this.y.a(this);
        boolean z = System.currentTimeMillis() - this.o0 < 150;
        Size sizeF = this.C.f(i);
        float fH = this.C.h(i);
        auVar.getClass();
        sizeF.getClass();
        lm document = auVar.d.getDocument();
        if (auVar.w.getValue() != null) {
            throw new IllegalStateException("You must call recycle() on this view before binding another page.");
        }
        if (document != null) {
            MutableStateFlow<m40> mutableStateFlow = auVar.w;
            PageRenderConfiguration pageRenderConfiguration = auVar.L;
            boolean z2 = auVar.v;
            Rect rect = auVar.u;
            boolean z3 = auVar.getParentView().n0;
            EnumSet<AnnotationType> enumSetA = ca.a(auVar.e);
            enumSetA.getClass();
            mutableStateFlow.tryEmit(new m40(document, i, pageRenderConfiguration, z2, rect, fH, sizeF, false, false, z3, enumSetA, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList()));
            ho hoVar = auVar.C;
            if (z) {
                hoVar.a(150L);
                auVar.r = document.a(EmptyCoroutineContext.INSTANCE, new bu(auVar, document, i, null));
            } else {
                hoVar.a(50L);
                auVar.a(document, i);
            }
            auVar.setRedactionAnnotationPreviewEnabled(this.b);
            i4 annotationRenderingCoordinator = auVar.getAnnotationRenderingCoordinator();
            EnumSet<AnnotationType> enumSet = this.e0;
            annotationRenderingCoordinator.getClass();
            enumSet.getClass();
            EnumSet<AnnotationType> enumSetA2 = qt.a(enumSet);
            if (Intrinsics.areEqual(annotationRenderingCoordinator.n, enumSetA2)) {
                i2 = 0;
            } else {
                annotationRenderingCoordinator.n = enumSetA2;
                i2 = 0;
                annotationRenderingCoordinator.o = false;
                annotationRenderingCoordinator.e();
                annotationRenderingCoordinator.b();
            }
            auVar.setAnnotationOverlayEnabled(this.f0);
            auVar.setAnnotationOverlayAboveOverlayViews(this.g0);
            this.k0.add(Integer.valueOf(i));
            pq pqVar = this.W;
            if (pqVar != null) {
                kq mediaPlayer = auVar.getMediaPlayer();
                mediaPlayer.j = pqVar;
                for (qq qqVar : mediaPlayer.f.values()) {
                    if (qqVar != null) {
                        qqVar.setOnMediaPlaybackChangeListener(pqVar);
                    }
                }
                pqVar.b.add(mediaPlayer);
                HashSet hashSet = new HashSet();
                hashSet.add(mediaPlayer);
                pq.a(pqVar.d, hashSet);
            }
            this.C.b(auVar);
            this.C.a(auVar);
            int iOrdinal = this.D.ordinal();
            if (iOrdinal == 3) {
                Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.b(auVar);
                    }
                };
                if (auVar.s) {
                    function0.invoke();
                } else {
                    auVar.t.add(function0);
                }
            } else if (iOrdinal == 4 && (annotationTool = (q0Var = this.G).s) != null) {
                final AnnotationToolVariant annotationToolVariantDefaultVariant = q0Var.t;
                if (annotationToolVariantDefaultVariant == null) {
                    annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
                }
                Function0 function1 = new Function0() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.a(annotationTool, auVar, annotationToolVariantDefaultVariant);
                    }
                };
                if (auVar.s) {
                    function1.invoke();
                } else {
                    auVar.t.add(function1);
                }
            }
            auVar.setVisibility(i2);
            if (auVar.getParent() == null) {
                addView(auVar, getChildCount(), auVar.getLayoutParams());
                return;
            } else {
                auVar.setLayoutParams(auVar.getLayoutParams());
                auVar.bringToFront();
                return;
            }
        }
        throw new IllegalStateException("documentView.getDocument() may not return null.");
    }

    public final void f(final int i) {
        Function0<Unit> function0;
        if (i >= 0 && this.C != null) {
            if (i != this.a0 || b(i) == null) {
                boolean z = this.a0 == -1 && i == 0;
                if (!z) {
                    i0 i0VarA = ar.a();
                    Bundle bundleA = z50.a(i0VarA);
                    bundleA.putInt(Analytics.Data.PAGE_INDEX, this.a0);
                    bundleA.putInt(Analytics.Data.TARGET_PAGE_INDEX, i);
                    i0VarA.a(Analytics.Event.CHANGE_PAGE, bundleA);
                }
                this.a0 = i;
                d dVar = this.D;
                if (dVar == d.TEXT_SELECTION) {
                    exitCurrentlyActiveMode();
                } else if (dVar == d.ANNOTATING) {
                    int childCount = getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        y50 y50Var = ((au) super.getChildAt(i2)).getSpecialModeView().d;
                        if (y50Var != null && (function0 = y50Var.r) != null) {
                            function0.invoke();
                        }
                    }
                }
                post(this.s0);
                final DocumentListener documentListener = this.v;
                if (documentListener == null || z) {
                    return;
                }
                post(new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(documentListener, i);
                    }
                });
            }
        }
    }

    public class h implements fu {
        public h() {
        }

        public final boolean a(au auVar, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
            MotionEvent motionEvent2;
            Annotation annotation2;
            boolean zB = (motionEvent == null || annotation != null) ? false : DocumentView.this.b(motionEvent);
            m40 state = auVar.getState();
            if (state == null) {
                return zB;
            }
            if (zB) {
                motionEvent2 = motionEvent;
                annotation2 = annotation;
            } else {
                DocumentView documentView = DocumentView.this;
                DocumentListener documentListener = documentView.v;
                if (documentListener != null) {
                    motionEvent2 = motionEvent;
                    annotation2 = annotation;
                    if (documentListener.onPageClick(documentView.r(), state.b, motionEvent2, pointF, annotation2)) {
                        zB = true;
                    }
                } else {
                    motionEvent2 = motionEvent;
                    annotation2 = annotation;
                }
                zB = false;
            }
            int i = state.b;
            boolean z = annotation2 != null;
            boolean z2 = (motionEvent2 != null ? auVar.getFormEditor().a(motionEvent2) : null) != null;
            int childCount = DocumentView.this.getChildCount();
            int i2 = 0;
            while (true) {
                DocumentView documentView2 = DocumentView.this;
                if (i2 >= childCount) {
                    documentView2.a.a();
                    return zB;
                }
                au auVarA = documentView2.a(i2);
                m40 state2 = auVarA.getState();
                if (state2 != null && state2.b != i) {
                    boolean zA = vt.a(auVarA.j, false, z, 13) | auVarA.k.a(z2);
                    auVarA.g.getClass();
                    if (zA) {
                        zB = true;
                    }
                }
                i2++;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
        
            if (r1 != 21) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean b(com.pspdfkit.internal.au r21, android.view.MotionEvent r22, final android.graphics.PointF r23, com.pspdfkit.annotations.Annotation r24) {
            /*
                r20 = this;
                r0 = r20
                com.pspdfkit.internal.m40 r1 = r21.getState()
                r2 = 0
                if (r1 != 0) goto La
                return r2
            La:
                int r5 = r1.b
                com.pspdfkit.internal.views.document.DocumentView r1 = com.pspdfkit.internal.views.document.DocumentView.this
                kotlinx.coroutines.Job r3 = r1.j0
                r9 = 0
                if (r3 == 0) goto L18
                r3.cancel(r9)
                r1.j0 = r9
            L18:
                com.pspdfkit.internal.views.document.DocumentView r1 = com.pspdfkit.internal.views.document.DocumentView.this
                com.pspdfkit.listeners.OnDocumentLongPressListener r3 = r1.w
                r12 = 1
                if (r3 == 0) goto L30
                com.pspdfkit.internal.lm r4 = r1.r()
                r6 = r22
                r7 = r23
                r8 = r24
                boolean r1 = r3.onDocumentLongPress(r4, r5, r6, r7, r8)
                if (r1 == 0) goto L30
                return r12
            L30:
                if (r22 == 0) goto Lae
                if (r24 == 0) goto L53
                float r1 = com.pspdfkit.internal.ww.a
                com.pspdfkit.annotations.AnnotationType r1 = r24.getType()
                int[] r3 = com.pspdfkit.internal.ww.a.a
                int r1 = r1.ordinal()
                r1 = r3[r1]
                r3 = 2
                if (r1 == r3) goto L53
                r3 = 3
                if (r1 == r3) goto L53
                r3 = 4
                if (r1 == r3) goto L53
                r3 = 6
                if (r1 == r3) goto L53
                r3 = 21
                if (r1 == r3) goto L53
                goto Lae
            L53:
                com.pspdfkit.internal.views.document.DocumentView r1 = com.pspdfkit.internal.views.document.DocumentView.this
                android.graphics.Matrix r2 = new android.graphics.Matrix
                r2.<init>()
                com.pspdfkit.internal.ln r1 = r1.C
                if (r1 == 0) goto L62
                android.graphics.Matrix r2 = r1.a(r5, r9)
            L62:
                r10 = r2
                float r1 = r22.getX()
                float r6 = r22.getY()
                com.pspdfkit.internal.views.document.DocumentView r2 = com.pspdfkit.internal.views.document.DocumentView.this
                android.content.Context r2 = r2.getContext()
                android.content.res.Resources r2 = r2.getResources()
                int r3 = com.pspdfkit.R.dimen.pspdf__min_selectable_text_size
                int r2 = r2.getDimensionPixelSize(r3)
                com.pspdfkit.internal.views.document.DocumentView r3 = com.pspdfkit.internal.views.document.DocumentView.this
                com.pspdfkit.internal.lm r8 = r3.r()
                com.pspdfkit.internal.views.document.DocumentView r13 = com.pspdfkit.internal.views.document.DocumentView.this
                float r7 = (float) r2
                com.pspdfkit.internal.views.document.DocumentView$h$$ExternalSyntheticLambda0 r4 = new com.pspdfkit.internal.views.document.DocumentView$h$$ExternalSyntheticLambda0
                r2 = r23
                r4.<init>()
                r8.getClass()
                kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
                kotlinx.coroutines.CoroutineScope r14 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)
                com.pspdfkit.internal.v50 r17 = new com.pspdfkit.internal.v50
                r11 = 0
                r9 = r5
                r3 = r17
                r5 = r1
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                r18 = 3
                r19 = 0
                r15 = 0
                r16 = 0
                kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r14, r15, r16, r17, r18, r19)
                r13.j0 = r0
                return r12
            Lae:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.views.document.DocumentView.h.b(com.pspdfkit.internal.au, android.view.MotionEvent, android.graphics.PointF, com.pspdfkit.annotations.Annotation):boolean");
        }

        public final /* synthetic */ void a(int i, PointF pointF, TextSelectionRectangles textSelectionRectangles) {
            DocumentView documentView = DocumentView.this;
            documentView.j0 = null;
            if (textSelectionRectangles != null) {
                documentView.a(i, textSelectionRectangles);
            } else if (pointF != null) {
                documentView.a.a(i, pointF.x, pointF.y);
            }
        }
    }

    public final void a(int i, Range range) {
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        a(i, TextSelection.fromTextRange(this.S, i, range));
    }

    public final void a(int i, TextSelectionRectangles textSelectionRectangles) {
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        a(i, TextSelection.fromTextRects(this.S, i, textSelectionRectangles));
    }

    public final boolean a(boolean z) {
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        if (this.S.getPageBinding() == PageBinding.RIGHT_EDGE) {
            return b(z);
        }
        return c(z);
    }

    public final void a(DocumentListener documentListener, int i) {
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        documentListener.onPageChanged(this.S, i);
    }

    public final Unit a(AnnotationTool annotationTool, au auVar, AnnotationToolVariant annotationToolVariant) {
        if (this.D == d.ANNOTATING) {
            q0 q0Var = this.G;
            if (annotationTool == q0Var.s) {
                auVar.getClass();
                annotationTool.getClass();
                annotationToolVariant.getClass();
                auVar.F.a(annotationTool, annotationToolVariant, q0Var);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    public final au b(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            au auVar = (au) super.getChildAt(i2);
            m40 state = auVar.getState();
            if (state != null && state.b == i) {
                return auVar;
            }
        }
        return null;
    }

    public final /* synthetic */ Unit b(au auVar) {
        if (this.D != d.CONTENT_EDITING) {
            return Unit.INSTANCE;
        }
        auVar.a(this.I);
        return Unit.INSTANCE;
    }

    public final void b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((au) super.getChildAt(i)).getFormEditor().a(false);
        }
    }

    public final boolean b(MotionEvent motionEvent) {
        int page;
        if (this.T.getScrollOnEdgeTapEnabled() && this.T.getScrollDirection() == PageScrollDirection.HORIZONTAL && (page = getPage()) != -1) {
            ln lnVar = this.C;
            if ((lnVar != null ? lnVar.h(page) : 1.0f) <= 1.001f) {
                float rawX = motionEvent.getRawX();
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                float f2 = rawX - iArr[0];
                float scrollOnEdgeTapMargin = getResources().getDisplayMetrics().density * this.T.getScrollOnEdgeTapMargin();
                if (f2 <= scrollOnEdgeTapMargin) {
                    return a(this.T.getAnimateScrollOnEdgeTaps());
                }
                if (f2 >= getWidth() - scrollOnEdgeTapMargin) {
                    return d(this.T.getAnimateScrollOnEdgeTaps());
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0052  */
    public final boolean b(boolean z) {
        int i;
        Context context = getContext();
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        lm lmVar = this.S;
        PdfConfiguration pdfConfiguration = this.T;
        context.getClass();
        lmVar.getClass();
        pdfConfiguration.getClass();
        if (pdfConfiguration.getScrollMode() != PageScrollMode.PER_PAGE) {
            i = 1;
        } else {
            boolean z2 = pdfConfiguration.getLayoutMode() == PageLayoutMode.DOUBLE;
            boolean z3 = uc.d(context) && uc.a(context, 540) && pdfConfiguration.getLayoutMode() == PageLayoutMode.AUTO;
            if (lmVar.getPageCount() <= 1 || !(z2 || z3)) {
                i = 1;
            } else {
                i = 2;
            }
        }
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        int iMin = Math.min(this.S.s - 1, getPage() + i);
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        if (iMin >= this.S.s) {
            return false;
        }
        a(iMin, Boolean.valueOf(z));
        return true;
    }

    public final void a(int i, Boolean bool) {
        this.o0 = System.currentTimeMillis();
        ln lnVar = this.C;
        if (lnVar != null) {
            if (bool != null) {
                lnVar.a(i, bool.booleanValue());
            } else {
                lnVar.i(i);
            }
        }
    }

    public final boolean a(RectF rectF, int i) {
        au auVarB;
        if (this.C == null || (auVarB = b(i)) == null) {
            return false;
        }
        Rect rect = new Rect();
        boolean localVisibleRect = auVarB.getLocalVisibleRect(rect);
        if (localVisibleRect) {
            rectF.left = rect.left;
            rectF.top = rect.top;
            rectF.right = rect.right;
            rectF.bottom = rect.bottom;
            s60.a(rectF, this.C.a(i, (Matrix) null));
        }
        return localVisibleRect;
    }

    public final /* synthetic */ void a(Throwable th) throws Throwable {
        PdfLog.w("Nutri.DocumentView", th, "Unable to update redaction preview", new Object[0]);
    }

    public final Matrix a(int i, Matrix matrix) {
        Matrix matrix2 = matrix != null ? matrix : new Matrix();
        ln lnVar = this.C;
        if (lnVar != null) {
            matrix2 = lnVar.a(i, matrix);
        }
        ln lnVar2 = this.C;
        if (lnVar2 != null) {
            matrix2.postTranslate(lnVar2.c(i) - getScrollX(), this.C.d(i) - getScrollY());
        }
        return matrix2;
    }

    public final au a(int i) {
        return (au) super.getChildAt(i);
    }

    public final boolean a(MotionEvent motionEvent) {
        au auVarB;
        Iterator<Integer> it = getVisiblePages().iterator();
        boolean zDispatchTouchEvent = false;
        while (it.hasNext() && (auVarB = b(it.next().intValue())) != null) {
            float f2 = -auVarB.getLeft();
            float f3 = -auVarB.getTop();
            motionEvent.offsetLocation(f2, f3);
            zDispatchTouchEvent |= auVarB.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f2, -f3);
        }
        return zDispatchTouchEvent;
    }

    public final /* synthetic */ void a(au auVar) {
        auVar.a(this.I);
    }

    public final void a(int i, TextSelection textSelection) {
        if (ar.b().a(NativeLicenseFeatures.TEXT_SELECTION) && this.T.isTextSelectionEnabled()) {
            d dVar = this.D;
            boolean z = dVar == d.ANNOTATING;
            if (!z && (dVar != d.TEXT_SELECTION || (this.H.getTextSelection() != null && this.H.getTextSelection().pageIndex != i))) {
                exitCurrentlyActiveMode();
            }
            au auVarB = b(i);
            if (auVarB != null) {
                if (!z) {
                    this.D = d.TEXT_SELECTION;
                }
                a60 a60Var = this.H;
                textSelection.getClass();
                a60Var.getClass();
                q30 q30Var = auVarB.F;
                q30Var.getClass();
                gu guVar = q30Var.c;
                if (guVar instanceof y50) {
                    y50 y50Var = (y50) guVar;
                    y50Var.a(textSelection, y50Var.t);
                } else if (guVar instanceof d3) {
                    q30Var.a(textSelection, a60Var);
                } else {
                    if (guVar != null) {
                        guVar.d();
                        q30Var.c = null;
                    }
                    y50 y50Var2 = new y50(textSelection, a60Var);
                    y50Var2.a(q30Var);
                    q30Var.c = y50Var2;
                    q30Var.c();
                }
                if (this.M) {
                    this.N = true;
                }
                if (!z && this.H.getTextSelection() == null) {
                    this.D = d.BROWSE;
                    return;
                }
            }
            zd zdVar = this.a;
            a60 a60Var2 = this.H;
            zdVar.getClass();
            a60Var2.getClass();
            TextSelectionPopupToolbar textSelectionPopupToolbar = (TextSelectionPopupToolbar) zdVar.f.getValue();
            if (textSelectionPopupToolbar == null) {
                return;
            }
            zdVar.g = a60Var2;
            textSelectionPopupToolbar.bindController(a60Var2);
            OnPreparePopupToolbarListener onPreparePopupToolbarListener = zdVar.i;
            if (onPreparePopupToolbarListener != null) {
                onPreparePopupToolbarListener.onPrepareTextSelectionPopupToolbar(textSelectionPopupToolbar);
            }
            PopupToolbar popupToolbar = zdVar.h;
            if (popupToolbar != null) {
                popupToolbar.dismiss();
            }
            zdVar.h = textSelectionPopupToolbar;
            y50 y50Var3 = a60Var2.k;
            if (y50Var3 == null || y50Var3.t == y50.b.NO_DRAG) {
                zdVar.d.removeCallbacks(zdVar.j);
                zdVar.d.postDelayed(zdVar.j, 300L);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0052  */
    public final boolean c(boolean z) {
        int i;
        Context context = getContext();
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        lm lmVar = this.S;
        PdfConfiguration pdfConfiguration = this.T;
        context.getClass();
        lmVar.getClass();
        pdfConfiguration.getClass();
        if (pdfConfiguration.getScrollMode() != PageScrollMode.PER_PAGE) {
            i = 1;
        } else {
            boolean z2 = pdfConfiguration.getLayoutMode() == PageLayoutMode.DOUBLE;
            boolean z3 = uc.d(context) && uc.a(context, 540) && pdfConfiguration.getLayoutMode() == PageLayoutMode.AUTO;
            if (lmVar.getPageCount() <= 1 || !(z2 || z3)) {
                i = 1;
            } else {
                i = 2;
            }
        }
        Objects.requireNonNull(this.S, "Attempting to get null document. Has the document been loaded?");
        int iMin = Math.min(this.S.s - 1, getPage() - i);
        if (iMin < 0) {
            return false;
        }
        a(iMin, Boolean.valueOf(z));
        return true;
    }

    public DocumentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.pspdf__documentViewStyle);
        this.b = false;
        this.e = new hu<>(Schedulers.computation());
        this.f = new hu<>(Schedulers.computation());
        this.g = new HashSet(3);
        this.h = new ArrayList(3);
        this.i = new go<>();
        this.k = new CompositeDisposable();
        this.l = new Handler(Looper.getMainLooper());
        this.m = new HashSet();
        this.n = new nb();
        this.o = new yh();
        this.p = new x50();
        this.s = -1;
        this.z = null;
        this.D = d.BROWSE;
        this.E = false;
        this.F = false;
        this.w0 = 1;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = false;
        this.R = 0.0f;
        this.U = ScrollState.IDLE;
        this.a0 = -1;
        this.e0 = EnumSet.noneOf(AnnotationType.class);
        this.f0 = true;
        this.g0 = false;
        this.j0 = null;
        this.k0 = new HashSet(3);
        this.l0 = new go<>();
        this.n0 = false;
        this.o0 = 0L;
        this.q0 = null;
        this.s0 = new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        };
        this.t0 = null;
        this.u0 = null;
        this.v0 = new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.p();
            }
        };
        f();
    }

    public final boolean a() {
        int childCount = getChildCount();
        boolean zA = false;
        for (int i = 0; i < childCount; i++) {
            vt pageEditor = ((au) super.getChildAt(i)).getPageEditor();
            pageEditor.getClass();
            zA |= vt.a(pageEditor, false, false, 15);
        }
        return zA;
    }

    public final void a(List<? extends Annotation> list) {
        if (this.S == null || list.isEmpty()) {
            return;
        }
        Iterator<? extends Annotation> it = list.iterator();
        while (it.hasNext()) {
            this.m.add(Integer.valueOf(it.next().getPageIndex()));
        }
        this.l.removeCallbacks(this.v0);
        this.l.postDelayed(this.v0, 50L);
    }

    public final /* synthetic */ void a(Set set) throws Throwable {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            DocumentListener documentListener = this.v;
            if (documentListener != null) {
                documentListener.onPageUpdated(this.S, num.intValue());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Collection, java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.pspdfkit.internal.ut] */
    public final void a(final FormField formField) {
        final ?? hashSet;
        g60 g60VarC;
        if (this.S == null || formField.getFormElements().isEmpty()) {
            return;
        }
        if (formField.getFormElements().size() == 1) {
            hashSet = Collections.singleton(Integer.valueOf(formField.getFormElement().getAnnotation().getPageIndex()));
        } else {
            hashSet = new HashSet();
            Iterator<? extends FormElement> it = formField.getFormElements().iterator();
            while (it.hasNext()) {
                hashSet.add(Integer.valueOf(it.next().getAnnotation().getPageIndex()));
            }
        }
        Completable completableA = q10.a.a().a(this.S.B, hashSet);
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        completableA.subscribeOn(((m0) g60VarC).a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.a(formField, hashSet);
            }
        });
    }

    public final void a(FormField formField, Set set) throws Throwable {
        for (FormElement formElement : formField.getFormElements()) {
            yh yhVar = this.o;
            yhVar.getClass();
            yh.a();
            Iterator<FormManager.OnFormElementUpdatedListener> it = yhVar.c.iterator();
            while (it.hasNext()) {
                it.next().onFormElementUpdated(formElement);
            }
        }
        if (this.v != null) {
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                this.v.onPageUpdated(this.S, ((Integer) it2.next()).intValue());
            }
        }
    }

    public DocumentView(Context context) {
        super(context, null, R.attr.pspdf__documentViewStyle);
        this.b = false;
        this.e = new hu<>(Schedulers.computation());
        this.f = new hu<>(Schedulers.computation());
        this.g = new HashSet(3);
        this.h = new ArrayList(3);
        this.i = new go<>();
        this.k = new CompositeDisposable();
        this.l = new Handler(Looper.getMainLooper());
        this.m = new HashSet();
        this.n = new nb();
        this.o = new yh();
        this.p = new x50();
        this.s = -1;
        this.z = null;
        this.D = d.BROWSE;
        this.E = false;
        this.F = false;
        this.w0 = 1;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = false;
        this.R = 0.0f;
        this.U = ScrollState.IDLE;
        this.a0 = -1;
        this.e0 = EnumSet.noneOf(AnnotationType.class);
        this.f0 = true;
        this.g0 = false;
        this.j0 = null;
        this.k0 = new HashSet(3);
        this.l0 = new go<>();
        this.n0 = false;
        this.o0 = 0L;
        this.q0 = null;
        this.s0 = new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        };
        this.t0 = null;
        this.u0 = null;
        this.v0 = new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.p();
            }
        };
        f();
    }

    public DocumentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = false;
        this.e = new hu<>(Schedulers.computation());
        this.f = new hu<>(Schedulers.computation());
        this.g = new HashSet(3);
        this.h = new ArrayList(3);
        this.i = new go<>();
        this.k = new CompositeDisposable();
        this.l = new Handler(Looper.getMainLooper());
        this.m = new HashSet();
        this.n = new nb();
        this.o = new yh();
        this.p = new x50();
        this.s = -1;
        this.z = null;
        this.D = d.BROWSE;
        this.E = false;
        this.F = false;
        this.w0 = 1;
        this.K = true;
        this.L = true;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = true;
        this.Q = false;
        this.R = 0.0f;
        this.U = ScrollState.IDLE;
        this.a0 = -1;
        this.e0 = EnumSet.noneOf(AnnotationType.class);
        this.f0 = true;
        this.g0 = false;
        this.j0 = null;
        this.k0 = new HashSet(3);
        this.l0 = new go<>();
        this.n0 = false;
        this.o0 = 0L;
        this.q0 = null;
        this.s0 = new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        };
        this.t0 = null;
        this.u0 = null;
        this.v0 = new Runnable() { // from class: com.pspdfkit.internal.views.document.DocumentView$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.p();
            }
        };
        f();
    }
}
