package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BaseRectsAnnotation;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionResolver;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.measurements.MeasurementInfo;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.DocumentPermissions;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.annotations.OnAnnotationSelectedListener;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.ui.rendering.AnnotationOverlayRenderStrategy;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import com.pspdfkit.undo.OnUndoHistoryChangeListener;
import com.pspdfkit.undo.UndoManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.math.MathKt;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class vt implements f7.a, OnAnnotationSelectedListener, nx, OnUndoHistoryChangeListener {
    public static final EnumSet<AnnotationType> E;
    public static final EnumSet<AnnotationType> F;
    public float A;
    public float B;
    public Job C;
    public final e3 D;
    public final au a;
    public final lm b;
    public final PdfConfiguration c;
    public final go<OnAnnotationSelectedListener> d;
    public final z1 e;
    public final at f;
    public final w4 g;
    public final au.b h;
    public final ActionResolver i;
    public o4 j;
    public final m4 k;
    public final nf l;
    public final a m;
    public final DocumentView n;
    public final Matrix o;
    public aq p;
    public Job q;
    public boolean r;
    public jf s;
    public final ArrayList t;
    public boolean u;
    public boolean v;
    public boolean w;
    public long x;
    public float y;
    public float z;

    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Annotation, Boolean> {
        public b(vt vtVar) {
            super(1, vtVar, vt.class, "isRendered", "isRendered(Lcom/pspdfkit/annotations/Annotation;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Annotation annotation) {
            Annotation annotation2 = annotation;
            annotation2.getClass();
            nf nfVar = ((vt) this.receiver).l;
            nfVar.getClass();
            return Boolean.valueOf(nfVar.a.a(annotation2));
        }
    }

    static {
        AnnotationType annotationType = AnnotationType.INK;
        AnnotationType annotationType2 = AnnotationType.FREETEXT;
        AnnotationType annotationType3 = AnnotationType.NOTE;
        AnnotationType annotationType4 = AnnotationType.HIGHLIGHT;
        AnnotationType annotationType5 = AnnotationType.SQUIGGLY;
        AnnotationType annotationType6 = AnnotationType.STRIKEOUT;
        AnnotationType annotationType7 = AnnotationType.UNDERLINE;
        AnnotationType annotationType8 = AnnotationType.STAMP;
        AnnotationType annotationType9 = AnnotationType.LINE;
        AnnotationType annotationType10 = AnnotationType.SQUARE;
        AnnotationType annotationType11 = AnnotationType.CIRCLE;
        AnnotationType annotationType12 = AnnotationType.POLYGON;
        AnnotationType annotationType13 = AnnotationType.POLYLINE;
        AnnotationType annotationType14 = AnnotationType.FILE;
        AnnotationType annotationType15 = AnnotationType.SOUND;
        AnnotationType annotationType16 = AnnotationType.REDACT;
        E = EnumSet.of(annotationType, annotationType2, annotationType3, annotationType4, annotationType5, annotationType6, annotationType7, annotationType8, annotationType9, annotationType10, annotationType11, annotationType12, annotationType13, annotationType14, annotationType15, annotationType16);
        F = EnumSet.of(annotationType, annotationType2, annotationType3, annotationType14, annotationType15, annotationType8, annotationType9, annotationType10, annotationType11, annotationType12, annotationType13, annotationType4, annotationType5, annotationType6, annotationType7, annotationType16);
    }

    public vt(au auVar, lm lmVar, PdfConfiguration pdfConfiguration, go goVar, z1 z1Var, at atVar, k2 k2Var, w4 w4Var, au.b bVar, ActionResolver actionResolver) {
        pdfConfiguration.getClass();
        goVar.getClass();
        z1Var.getClass();
        atVar.getClass();
        w4Var.getClass();
        this.a = auVar;
        this.b = lmVar;
        this.c = pdfConfiguration;
        this.d = goVar;
        this.e = z1Var;
        this.f = atVar;
        this.g = w4Var;
        this.h = bVar;
        this.i = actionResolver;
        o4 o4Var = new o4(auVar, pdfConfiguration, w4Var);
        this.j = o4Var;
        this.k = new m4(o4Var, pdfConfiguration, w4Var);
        nf nfVar = new nf(k2Var);
        this.l = nfVar;
        this.m = new a();
        DocumentView parentView = auVar.getParentView();
        this.n = parentView;
        Matrix matrix = new Matrix();
        this.o = matrix;
        this.t = new ArrayList();
        EnumSet<AnnotationType> enumSetNoneOf = EnumSet.noneOf(AnnotationType.class);
        if (ar.b().a(pdfConfiguration)) {
            DocumentPermissions documentPermissions = DocumentPermissions.ANNOTATIONS_AND_FORMS;
            documentPermissions.getClass();
            if (lmVar.G.contains(documentPermissions)) {
                if (pdfConfiguration.getEditableAnnotationTypes().isEmpty()) {
                    enumSetNoneOf = E;
                } else {
                    enumSetNoneOf.addAll(pdfConfiguration.getEditableAnnotationTypes());
                }
            }
        }
        enumSetNoneOf.getClass();
        nfVar.b = enumSetNoneOf;
        lmVar.getAnnotationProvider();
        UndoManager undoManager = atVar instanceof UndoManager ? (UndoManager) atVar : null;
        if (undoManager != null) {
            undoManager.addOnUndoHistoryChangeListener(this);
        }
        this.D = new e3(auVar, parentView, pdfConfiguration, matrix, new wt(this));
    }

    public final boolean a(final boolean z, final Collection<? extends Annotation> collection) {
        gu currentMode;
        ArrayList arrayList;
        collection.getClass();
        au auVar = this.a;
        if (!auVar.s) {
            Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.vt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return vt.a(this.f$0, z, collection);
                }
            };
            if (auVar.s) {
                function0.invoke();
            } else {
                auVar.t.add(function0);
            }
            return true;
        }
        HashMap map = new HashMap();
        for (Object obj : collection) {
            String group = ((Annotation) obj).getGroup();
            Object arrayList2 = map.get(group);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(group, arrayList2);
            }
            ((List) arrayList2).add(obj);
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            ArrayList arrayListA = this.l.a(str);
            if (arrayListA != null && arrayListA.size() != list.size()) {
                list.clear();
                list.addAll(arrayListA);
            }
        }
        Collection collectionValues = map.values();
        collectionValues.getClass();
        List<Annotation> listFlatten = CollectionsKt.flatten(collectionValues);
        int size = listFlatten.size();
        if (size != 0) {
            if (size != 1) {
                arrayList = new ArrayList();
                for (Object obj2 : listFlatten) {
                    Annotation annotation = (Annotation) obj2;
                    if (ar.b().a(this.c, annotation) && this.l.a(annotation) && !(annotation instanceof BaseRectsAnnotation)) {
                        arrayList.add(obj2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                for (Object obj3 : listFlatten) {
                    Annotation annotation2 = (Annotation) obj3;
                    if (ar.b().a(this.c, annotation2) && this.l.a(annotation2)) {
                        arrayList.add(obj3);
                    }
                }
            }
            listFlatten = arrayList;
        }
        if (!this.t.isEmpty()) {
            if (listFlatten.size() == this.t.size()) {
                if (!listFlatten.isEmpty()) {
                    Iterator it = listFlatten.iterator();
                    while (it.hasNext()) {
                        if (!this.t.contains((Annotation) it.next())) {
                        }
                    }
                }
                return false;
            }
            a(this, true, !listFlatten.isEmpty() || (this.n.getInteractionMode() == DocumentView.d.ANNOTATING && (currentMode = this.a.getSpecialModeView().getCurrentMode()) != null && currentMode.e()), 4);
        }
        ArrayList arrayList3 = new ArrayList(listFlatten.size());
        if (this.j.getParent() != null) {
            this.a.removeView(this.j);
            au auVar2 = this.a;
            PdfConfiguration pdfConfiguration = this.c;
            w4 w4Var = ca.a;
            if (w4Var == null) {
                throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getAnnotationThemeConfiguration()");
            }
            this.j = new o4(auVar2, pdfConfiguration, w4Var);
        } else {
            m4 m4Var = this.k;
            PdfConfiguration pdfConfiguration2 = this.c;
            w4 w4Var2 = this.g;
            m4Var.getClass();
            pdfConfiguration2.getClass();
            w4Var2.getClass();
            m4Var.a.a(w4Var2);
            m4Var.i = w4Var2.a >= 1;
            m4Var.j = pdfConfiguration2.getSelectedAnnotationResizeEnabled();
            m4Var.l = pdfConfiguration2.getSelectedAnnotationResizeGuidesEnabled();
            m4Var.g = true;
            m4Var.k = true;
            m4Var.s = false;
            m4Var.t = false;
            m4Var.m = null;
        }
        m4 m4Var2 = this.k;
        o4 o4Var = this.j;
        m4Var2.getClass();
        o4Var.getClass();
        m4Var2.a = o4Var;
        o4Var.setPresenter(m4Var2);
        this.k.x = this.p;
        ArrayList arrayList4 = new ArrayList(listFlatten.size());
        boolean zIsLocked = false;
        boolean hasLockedContents = false;
        boolean zB = false;
        for (Annotation annotation3 : listFlatten) {
            i0 i0VarA = ar.a();
            Bundle bundleA = z50.a(i0VarA);
            bundleA.putString(Analytics.Data.ANNOTATION_TYPE, annotation3.getType().name());
            bundleA.putInt(Analytics.Data.PAGE_INDEX, annotation3.getPageIndex());
            i0VarA.b.onNext(new Pair<>(Analytics.Event.SELECT_ANNOTATION, bundleA));
            nf nfVar = this.l;
            nfVar.getClass();
            if (nfVar.a.a(annotation3) && this.l.a(annotation3)) {
                Iterable iterable = this.d;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it2 = iterable.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((OnAnnotationSelectedListener) it2.next()).onPrepareAnnotationSelection(this.k, annotation3, z)) {
                            }
                        }
                    }
                }
                this.t.add(annotation3);
                zIsLocked |= annotation3.isLocked();
                hasLockedContents |= annotation3.getHasLockedContents();
                if (F.contains(annotation3.getType())) {
                    z4<?> z4VarA = a(annotation3);
                    arrayList3.add(z4VarA);
                    arrayList4.add(annotation3);
                    zB |= z4VarA.b(z);
                }
            }
        }
        if (this.t.isEmpty()) {
            a(CollectionsKt.emptyList(), false);
            return false;
        }
        this.a.bringToFront();
        m4 m4Var3 = this.k;
        if (m4Var3.g) {
            m4Var3.g = false;
            m4Var3.a.invalidate();
            m4Var3.a.requestLayout();
        }
        m4 m4Var4 = this.k;
        if (m4Var4.s != zIsLocked) {
            m4Var4.s = zIsLocked;
            m4Var4.a.invalidate();
        }
        m4 m4Var5 = this.k;
        if (m4Var5.t != hasLockedContents) {
            m4Var5.t = hasLockedContents;
            m4Var5.a.invalidate();
        }
        m4 m4Var6 = this.k;
        z4[] z4VarArr = (z4[]) arrayList3.toArray(new z4[0]);
        z4[] z4VarArr2 = (z4[]) Arrays.copyOf(z4VarArr, z4VarArr.length);
        m4Var6.getClass();
        m4Var6.a.removeAllViews();
        m4Var6.r = false;
        xv xvVar = m4Var6.e;
        xvVar.a = 0.0f;
        xvVar.b = 0.0f;
        xvVar.c = 0.0f;
        xvVar.d = 0.0f;
        m4Var6.y.clear();
        for (z4 z4Var : z4VarArr2) {
            View viewA = z4Var.a();
            ViewGroup.LayoutParams layoutParams = viewA.getLayoutParams();
            if (!(layoutParams instanceof OverlayLayoutParams)) {
                throw new IllegalArgumentException("Selected views have to use PageViewGroup.LayoutParams");
            }
            if (z4Var.getAnnotation() == null) {
                throw new IllegalArgumentException("Selected views have to be bound to an Annotation.");
            }
            m4Var6.a.addView(viewA, layoutParams);
        }
        if (z4VarArr2.length == 1) {
            Annotation annotation4 = z4VarArr2[0].getAnnotation();
            if (annotation4 == null) {
                throw new IllegalArgumentException("annotationView isn't bound to an annotation.");
            }
            m4Var6.a.setScaleHandleDrawablesSupportRotation(annotation4.getType() != AnnotationType.STAMP);
        }
        ArrayList arrayList5 = new ArrayList();
        for (z4 z4Var2 : z4VarArr2) {
            if (z4Var2 instanceof z4) {
                arrayList5.add(z4Var2);
            }
        }
        z4<?>[] z4VarArr3 = (z4[]) arrayList5.toArray(new z4[0]);
        u00 rotationHandler = m4Var6.a.getRotationHandler();
        rotationHandler.getClass();
        z4VarArr3.getClass();
        rotationHandler.f = ArraysKt.toList(z4VarArr3);
        if (z4VarArr3.length == 1) {
            rotationHandler.l.set(rotationHandler.c(z4VarArr3[0]));
            Annotation annotation5 = z4VarArr3[0].getAnnotation();
            if (annotation5 == null) {
                throw new IllegalArgumentException("annotationView isn't bound to an annotation.");
            }
            rotationHandler.a.setScaleHandleDrawableInitialRotation(annotation5.getInternal().getRotation());
            rotationHandler.a.setScaleHandleDrawableRotation(0.0f);
        }
        m4Var6.b();
        this.a.addView(this.j);
        if (!zB) {
            hn.c(this.a);
        }
        i4 annotationRenderingCoordinator = this.a.getAnnotationRenderingCoordinator();
        annotationRenderingCoordinator.getClass();
        int size2 = arrayList4.size();
        int i = 0;
        while (i < size2) {
            Object obj4 = arrayList4.get(i);
            i++;
            annotationRenderingCoordinator.a((Annotation) obj4);
        }
        annotationRenderingCoordinator.a((List<? extends Annotation>) arrayList4, false, (Function0<Unit>) null);
        this.u = false;
        int size3 = arrayList3.size();
        int i2 = 0;
        while (i2 < size3) {
            Object obj5 = arrayList3.get(i2);
            i2++;
            ((z4) obj5).m();
        }
        this.k.a(true);
        m4 m4Var7 = this.k;
        if (!m4Var7.g) {
            m4Var7.g = true;
            m4Var7.a.invalidate();
            m4Var7.a.requestLayout();
        }
        jf jfVar = this.s;
        if (jfVar != null) {
            this.k.a(jfVar, (MotionEvent) null, 0.0f, 0.0f);
        }
        ArrayList arrayList6 = this.t;
        int size4 = arrayList6.size();
        int i3 = 0;
        while (i3 < size4) {
            Object obj6 = arrayList6.get(i3);
            i3++;
            Annotation annotation6 = (Annotation) obj6;
            Iterator<OnAnnotationSelectedListener> it3 = this.d.iterator();
            while (it3.hasNext()) {
                it3.next().onAnnotationSelected(annotation6, z);
            }
        }
        a(this.t, z);
        m4 m4Var8 = this.k;
        jz jzVar = m4Var8.a.l;
        jzVar.f = null;
        jzVar.e = null;
        jzVar.a.invalidate();
        m4Var8.a.getAngularGuidesHelper().e = false;
        m4Var8.a.getAngularGuidesHelper().f.reset();
        if (z) {
            e();
        }
        return true;
    }

    public final boolean b(MotionEvent motionEvent) {
        motionEvent.getClass();
        List listUnmodifiableList = Collections.unmodifiableList(this.t);
        listUnmodifiableList.getClass();
        if (listUnmodifiableList.isEmpty()) {
            return false;
        }
        nf nfVar = this.l;
        Matrix matrix = this.o;
        nfVar.getClass();
        matrix.getClass();
        List<Annotation> listA = nfVar.a.a(motionEvent, matrix);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA) {
            if (nfVar.a((Annotation) obj, true)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty() || listUnmodifiableList.isEmpty()) {
            return false;
        }
        Iterator it = listUnmodifiableList.iterator();
        while (it.hasNext()) {
            if (arrayList.contains((Annotation) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.pspdfkit.internal.f7.a
    public final boolean c() {
        return this.u;
    }

    public final List<z4<?>> d() {
        return SequencesKt.toList(SequencesKt.mapNotNull(ViewGroupKt.getChildren(this.j), new Function1() { // from class: com.pspdfkit.internal.vt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vt.a((View) obj);
            }
        }));
    }

    public final boolean e() {
        z4 z4VarB;
        m4 m4Var = this.k;
        boolean z = m4Var.r;
        if (m4Var.a.getChildCount() == 1 && m4Var.g && !m4Var.r && !m4Var.t && (z4VarB = m4Var.a.b()) != null && z4VarB.e()) {
            m4Var.r = true;
            m4Var.a.invalidate();
        }
        boolean z2 = m4Var.r;
        if (!z && z2) {
            Iterator<OnAnnotationSelectedListener> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().onAnnotationWritingModeChanged(true);
            }
        }
        return z2;
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public final void onAnnotationSelected(Annotation annotation, boolean z) {
        annotation.getClass();
        m40 state = this.a.getState();
        if (state == null) {
            a(this, false, false, 15);
            return;
        }
        if (annotation.getPageIndex() == state.b) {
            List listUnmodifiableList = Collections.unmodifiableList(this.t);
            listUnmodifiableList.getClass();
            if (listUnmodifiableList.contains(annotation)) {
                return;
            }
        }
        a(this, true, true, 12);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public final boolean onPrepareAnnotationSelection(AnnotationSelectionController annotationSelectionController, Annotation annotation, boolean z) {
        annotationSelectionController.getClass();
        annotation.getClass();
        return true;
    }

    @Override // com.pspdfkit.undo.OnUndoHistoryChangeListener
    public final void onUndoHistoryChanged(UndoManager undoManager) {
        undoManager.getClass();
        ArrayList arrayList = this.t;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Annotation annotation = (Annotation) obj;
            annotation.getClass();
            if (annotation.getGroup() != null) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList2 = this.t;
                arrayList2.getClass();
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    String group = ((Annotation) obj2).getGroup();
                    if (group != null) {
                        arrayList3.add(group);
                    }
                }
                Iterator it = CollectionsKt.toSet(arrayList3).iterator();
                while (it.hasNext()) {
                    ArrayList arrayListA = this.l.a((String) it.next());
                    if (arrayListA != null) {
                        ArrayList arrayList4 = new ArrayList();
                        int size3 = arrayListA.size();
                        int i3 = 0;
                        while (i3 < size3) {
                            Object obj3 = arrayListA.get(i3);
                            i3++;
                            if (!this.t.contains((Annotation) obj3)) {
                                arrayList4.add(obj3);
                            }
                        }
                        hashSet.addAll(arrayList4);
                    }
                }
                if (hashSet.isEmpty()) {
                    return;
                }
                List listPlus = CollectionsKt.plus((Collection) this.t, (Iterable) hashSet);
                listPlus.getClass();
                a(false, (Collection<? extends Annotation>) listPlus);
                return;
            }
        }
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        Job job = this.q;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.p = null;
        at atVar = this.f;
        UndoManager undoManager = atVar instanceof UndoManager ? (UndoManager) atVar : null;
        if (undoManager != null) {
            undoManager.removeOnUndoHistoryChangeListener(this);
        }
        a(this, true, false, 8);
        Job job2 = this.C;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.C = null;
    }

    public final class a extends w20 {
        public Annotation a;
        public jf b;
        public i3 c;
        public Runnable d;
        public final Handler e = new Handler(Looper.getMainLooper());
        public final long f = 100;

        public a() {
        }

        public static final void a(vo voVar, vt vtVar, kotlin.Pair pair) {
            Context context = vtVar.a.getContext();
            context.getClass();
            wo.a(voVar, context, ((Number) pair.getFirst()).floatValue(), ((Number) pair.getSecond()).floatValue(), 2.0f);
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void b(MotionEvent motionEvent) {
            motionEvent.getClass();
            a();
            i3 i3Var = this.c;
            if (i3Var != null) {
                i3Var.c();
            }
            this.c = null;
            e3 e3Var = vt.this.D;
            boolean z = e3Var.g;
            e3Var.g = false;
            if (z) {
                e3Var.b();
            }
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void c(MotionEvent motionEvent) {
            motionEvent.getClass();
            a();
            vt.this.D.g = false;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean d(MotionEvent motionEvent) {
            boolean zA;
            gu currentMode;
            Action action;
            jf jfVar;
            motionEvent.getClass();
            if (!vt.this.t.isEmpty() && (jfVar = this.b) != null) {
                kf kfVar = jfVar.a;
                if (kfVar.a != null || kfVar.b != -1) {
                    o4 o4Var = vt.this.j;
                    if (o4Var.getChildCount() == 1) {
                        o4Var.getChildAt(0).performClick();
                    }
                    return true;
                }
            }
            Annotation annotation = this.a;
            if (annotation != null) {
                vt vtVar = vt.this;
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                vtVar.a.a(vtVar.o);
                l4.a(vtVar.o, pointF);
                au auVar = au.this;
                zA = ((DocumentView.h) auVar.g).a(auVar, motionEvent, pointF, annotation);
                if (!zA) {
                    AnnotationType type = annotation.getType();
                    AnnotationType annotationType = AnnotationType.LINK;
                    if (type == annotationType) {
                        vt vtVar2 = vt.this;
                        if (annotation.getType() == annotationType) {
                            LinkAnnotation linkAnnotation = annotation instanceof LinkAnnotation ? (LinkAnnotation) annotation : null;
                            if (linkAnnotation != null && (action = linkAnnotation.getAction()) != null) {
                                vtVar2.i.executeAction(action, new ActionSender(annotation));
                            }
                        }
                    }
                }
            } else {
                zA = false;
            }
            if (annotation != null && !vt.this.n.h() && !vt.this.t.isEmpty() && vt.this.j.a(motionEvent)) {
                vt vtVar3 = vt.this;
                vtVar3.s = null;
                if (!vtVar3.e()) {
                    if (!vt.this.n.h()) {
                        e3 e3Var = vt.this.D;
                        if (e3Var.f) {
                            e3Var.a();
                        } else {
                            e3Var.b();
                        }
                    }
                    o4 o4Var2 = vt.this.j;
                    if (o4Var2.getChildCount() == 1) {
                        o4Var2.getChildAt(0).performClick();
                    }
                }
                return true;
            }
            boolean zH = vt.this.n.h();
            vt vtVar4 = vt.this;
            if (!zH) {
                boolean zA2 = vt.this.a(true, (annotation != null && vtVar4.l.a(annotation)) || (vtVar4.n.getInteractionMode() == DocumentView.d.ANNOTATING && (currentMode = vtVar4.a.getSpecialModeView().getCurrentMode()) != null && currentMode.e()), false, false);
                if (annotation == null) {
                    vt.this.a(CollectionsKt.emptyList(), false);
                    return zA2;
                }
                if (annotation.getType() == AnnotationType.NOTE && (!vt.this.l.a(annotation) || !ar.b().a(NativeLicenseFeatures.ANNOTATION_EDITING))) {
                    l4.a(vt.this.a.a((Matrix) null), new PointF(motionEvent.getX(), motionEvent.getY()));
                    vt.this.e.a(annotation);
                    return true;
                }
                if (!vt.this.l.a(annotation)) {
                    return zA;
                }
                if (ar.b().a(vt.this.c, annotation)) {
                    vt vtVar5 = vt.this;
                    List listAsList = ArraysKt.asList(new Annotation[]{annotation});
                    listAsList.getClass();
                    vtVar5.a(false, (Collection<? extends Annotation>) listAsList);
                    vt.this.D.b();
                }
                return true;
            }
            if (annotation != null) {
                boolean zContains = vtVar4.t.contains(annotation);
                vt vtVar6 = vt.this;
                if (zContains) {
                    nf nfVar = vtVar6.l;
                    nfVar.getClass();
                    Iterable iterableA = nfVar.a(annotation.getGroup());
                    vt vtVar7 = vt.this;
                    ArrayList arrayList = vtVar7.t;
                    if (iterableA == null) {
                        iterableA = CollectionsKt.listOf(annotation);
                    }
                    List listMinus = CollectionsKt.minus((Iterable) arrayList, iterableA);
                    listMinus.getClass();
                    vtVar7.a(false, (Collection<? extends Annotation>) listMinus);
                } else {
                    List listPlus = CollectionsKt.plus((Collection<? extends Annotation>) vtVar6.t, annotation);
                    listPlus.getClass();
                    vtVar6.a(false, (Collection<? extends Annotation>) listPlus);
                }
            } else {
                List listAsList2 = ArraysKt.asList(new Annotation[0]);
                listAsList2.getClass();
                vtVar4.a(false, (Collection<? extends Annotation>) listAsList2);
            }
            return true;
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean e(MotionEvent motionEvent) {
            motionEvent.getClass();
            return !vt.this.t.isEmpty() && vt.this.j.a(motionEvent) && vt.this.j.getChildCount() == 1;
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean f(MotionEvent motionEvent) {
            motionEvent.getClass();
            if (this.a == null) {
                return vt.this.n.h() && vt.this.j.b(motionEvent);
            }
            return true;
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean g(MotionEvent motionEvent) {
            motionEvent.getClass();
            if (vt.this.k.j()) {
                return true;
            }
            vt vtVar = vt.this;
            vtVar.s = null;
            jf jfVarA = vtVar.t.isEmpty() ? null : vt.this.k.a(motionEvent);
            vt vtVar2 = vt.this;
            if (jfVarA == null) {
                if (!vtVar2.n.h()) {
                    if (this.a != null) {
                        vt vtVar3 = vt.this;
                        if (vtVar3.l.a(motionEvent, vtVar3.o, false) != null) {
                        }
                    }
                    return false;
                }
                return true;
            }
            vtVar2.s = jfVarA;
            if (this.c == null) {
                List listUnmodifiableList = Collections.unmodifiableList(vtVar2.t);
                listUnmodifiableList.getClass();
                at atVar = vt.this.f;
                atVar.getClass();
                i3 i3Var = new i3(listUnmodifiableList, atVar);
                i3Var.b();
                this.c = i3Var;
            }
            vt.this.a.requestDisallowInterceptTouchEvent(true);
            return true;
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean h(MotionEvent motionEvent) {
            motionEvent.getClass();
            return (vt.this.t.isEmpty() && this.a == null) ? false : true;
        }

        public final void i(MotionEvent motionEvent) {
            jf jfVarA;
            String str;
            sp spVar;
            final vo magnifierManager = vt.this.a.getParentView().getMagnifierManager();
            if (magnifierManager == null || (jfVarA = vt.this.k.a(motionEvent)) == null) {
                return;
            }
            kf kfVar = jfVarA.a;
            if (kfVar.a == null && kfVar.b == -1) {
                return;
            }
            List listUnmodifiableList = Collections.unmodifiableList(vt.this.t);
            listUnmodifiableList.getClass();
            if (listUnmodifiableList.size() != 1) {
                return;
            }
            Annotation annotation = (Annotation) CollectionsKt.first(listUnmodifiableList);
            if (!annotation.isMeasurement() || annotation.getType() == AnnotationType.CIRCLE) {
                return;
            }
            final kotlin.Pair<Float, Float> pairA = vt.this.a(motionEvent.getX(), motionEvent.getY(), magnifierManager);
            final vt vtVar = vt.this;
            Runnable runnable = new Runnable() { // from class: com.pspdfkit.internal.vt$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    vt.a.a(magnifierManager, vtVar, pairA);
                }
            };
            this.e.postDelayed(runnable, this.f);
            this.d = runnable;
            MeasurementInfo measurementInfo = annotation.getMeasurementInfo();
            if (measurementInfo == null || (str = measurementInfo.label) == null || (spVar = vt.this.a.getParentView().q0) == null) {
                return;
            }
            spVar.a(str);
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            motionEvent.getClass();
            if (vt.this.t.isEmpty() || !vt.this.j.a(motionEvent) || vt.this.j.getChildCount() != 1) {
                return false;
            }
            z4 z4VarB = vt.this.j.b();
            if (vt.this.e() || !(z4VarB instanceof yj)) {
                return false;
            }
            Annotation annotation = ((yj) z4VarB).getAnnotation();
            if (annotation != null) {
                vt.this.e.a(annotation);
            }
            return true;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void onDown(MotionEvent motionEvent) {
            kf kfVar;
            motionEvent.getClass();
            vt vtVar = vt.this;
            vtVar.v = true;
            vtVar.a.a(vtVar.o);
            this.a = vt.this.a(motionEvent, true);
            Object obj = null;
            jf jfVarA = !vt.this.t.isEmpty() ? vt.this.k.a(motionEvent) : null;
            this.b = jfVarA;
            m4 m4Var = vt.this.k;
            if (jfVarA == null || (kfVar = jfVarA.a) == null) {
                kfVar = new kf(null, 3);
            }
            m4Var.getClass();
            m4Var.a.setTouchedHandleForFeedback(kfVar);
            if (vt.this.t.isEmpty() || !vt.this.j.b(motionEvent)) {
                vt.this.D.a();
            }
            if (this.a instanceof LinkAnnotation) {
                t1 annotationDrawableStateProvider = vt.this.a.getAnnotationDrawableStateProvider();
                Annotation annotation = this.a;
                annotation.getClass();
                LinkAnnotation linkAnnotation = (LinkAnnotation) annotation;
                co coVar = annotationDrawableStateProvider.f;
                int i = 0;
                if (coVar != null && coVar.f) {
                    coVar.f = false;
                    coVar.d = co.h;
                    coVar.e = co.i;
                }
                List<q1> value = annotationDrawableStateProvider.e.getValue();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : value) {
                    if (obj2 instanceof co) {
                        arrayList.add(obj2);
                    }
                }
                int size = arrayList.size();
                while (i < size) {
                    Object obj3 = arrayList.get(i);
                    i++;
                    if (((co) obj3).a.getObjectNumber() == linkAnnotation.getObjectNumber()) {
                        obj = obj3;
                        break;
                    }
                }
                co coVar2 = (co) obj;
                annotationDrawableStateProvider.f = coVar2;
                if (coVar2 != null) {
                    coVar2.f = true;
                    coVar2.d = co.j;
                    coVar2.e = co.k;
                    annotationDrawableStateProvider.c.invoke();
                }
            }
            Annotation annotation2 = this.a;
            if (annotation2 != null) {
                vt vtVar2 = vt.this;
                if (p10.a(annotation2.getType())) {
                    m4 m4Var2 = vtVar2.k;
                    m4Var2.a.getAngularGuidesHelper().e = true;
                    m4Var2.a.getAngularGuidesHelper().f.reset();
                }
                i(motionEvent);
            }
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean onLongPress(MotionEvent motionEvent) {
            jf jfVar;
            motionEvent.getClass();
            if (!vt.this.t.isEmpty() && (jfVar = this.b) != null) {
                kf kfVar = jfVar.a;
                if (kfVar.a != null || kfVar.b != -1) {
                    return true;
                }
            }
            vt vtVar = vt.this;
            Annotation annotationA = vtVar.l.a(motionEvent, vtVar.o, true);
            if ((vt.this.n.h() || vt.this.t.size() > 1) && vt.this.j.b(motionEvent)) {
                e3 e3Var = vt.this.D;
                if (e3Var.f) {
                    e3Var.a();
                } else {
                    e3Var.b();
                }
                return true;
            }
            if (annotationA == null) {
                return false;
            }
            vt vtVar2 = vt.this;
            au.b bVar = vtVar2.h;
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            vtVar2.a.a(vtVar2.o);
            l4.a(vtVar2.o, pointF);
            au auVar = au.this;
            if (((DocumentView.h) auVar.g).b(auVar, motionEvent, pointF, annotationA) || !vt.this.l.a(annotationA)) {
                return true;
            }
            boolean zContains = vt.F.contains(annotationA.getType());
            if (!vt.this.t.contains(annotationA) && ar.b().a(vt.this.c, annotationA)) {
                vt vtVar3 = vt.this;
                if (!vtVar3.k.r && zContains) {
                    vt.a(vtVar3, true, true, 4);
                    vt vtVar4 = vt.this;
                    List listAsList = ArraysKt.asList(new Annotation[]{annotationA});
                    listAsList.getClass();
                    vtVar4.a(false, (Collection<? extends Annotation>) listAsList);
                    vt.this.a.requestDisallowInterceptTouchEvent(true);
                    if (vt.this.k.isDraggingEnabled()) {
                        vt vtVar5 = vt.this;
                        if (!vtVar5.k.s) {
                            vtVar5.s = new jf(new kf(null, 3), false, false, false, false, new RectF(), CollectionsKt.emptyList());
                        }
                    }
                }
            }
            return zContains;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Iterable iterableEmptyList;
            motionEvent.getClass();
            motionEvent2.getClass();
            vt vtVar = vt.this;
            jf jfVar = vtVar.s;
            if (jfVar == null && vtVar.n.h() && !vt.this.k.j() && !vt.this.k.j()) {
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                l4.a(vt.this.o, pointF);
                vt vtVar2 = vt.this;
                m4 m4Var = vtVar2.k;
                w4 w4Var = vtVar2.g;
                m4Var.getClass();
                w4Var.getClass();
                if (!m4Var.j()) {
                    float f3 = pointF.x;
                    float f4 = pointF.y;
                    m4Var.z = new RectF(f3, f4, f3, f4);
                    a3 a3Var = m4Var.c;
                    if (a3Var != null) {
                        float fA = s60.a(w4Var.a, a3Var.c);
                        GradientDrawable gradientDrawable = a3Var.e;
                        gradientDrawable.setStroke(MathKt.roundToInt(fA), w4Var.b);
                        int i = w4Var.b;
                        gradientDrawable.setColor(Color.argb((Color.alpha(i) * 15) / 100, Color.red(i), Color.green(i), Color.blue(i)));
                        a3Var.f.setColor(w4Var.b);
                        a3Var.f.setStrokeWidth(fA);
                    }
                }
                vt.a(vt.this, true, true, 12);
            }
            if (!vt.this.k.j()) {
                if (jfVar == null) {
                    return false;
                }
                vt vtVar3 = vt.this;
                vtVar3.w = true;
                e3 e3Var = vtVar3.D;
                if (e3Var.f) {
                    e3Var.g = true;
                }
                e3Var.a();
                vt.this.k.a(jfVar, motionEvent2, -s60.a(f, vt.this.o), s60.a(f2, vt.this.o));
                vt.this.a(motionEvent2.getX(), motionEvent2.getY());
                return true;
            }
            PointF pointF2 = new PointF(motionEvent2.getX(), motionEvent2.getY());
            l4.a(vt.this.o, pointF2);
            m4 m4Var2 = vt.this.k;
            m4Var2.getClass();
            RectF rectF = m4Var2.z;
            if (rectF != null) {
                rectF.right = pointF2.x;
                rectF.bottom = pointF2.y;
                a3 a3Var2 = m4Var2.c;
                if (a3Var2 != null) {
                    a3Var2.d.clear();
                    Rect rect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    rect.sort();
                    a3Var2.e.setBounds(rect);
                    au auVarL = a3Var2.l();
                    vt pageEditor = auVarL != null ? auVarL.getPageEditor() : null;
                    if (pageEditor != null) {
                        ArrayList arrayList = a3Var2.d;
                        RectF rectF2 = a3Var2.j;
                        rectF2.set(rectF);
                        rectF2.sort();
                        float f5 = rectF2.top;
                        float f6 = rectF2.bottom;
                        if (f5 < f6) {
                            rectF2.top = f6;
                            rectF2.bottom = f5;
                        }
                        EnumSet<AnnotationType> enumSet = vt.E;
                        nf nfVar = pageEditor.l;
                        nfVar.getClass();
                        k2 k2Var = nfVar.a;
                        k2Var.getClass();
                        if (k2Var.c.isEmpty()) {
                            iterableEmptyList = CollectionsKt.emptyList();
                        } else {
                            ArrayList arrayListA = k2Var.a();
                            iterableEmptyList = arrayListA.isEmpty() ? CollectionsKt.emptyList() : h2.a(arrayListA, rectF2, 0.0f, SetsKt.emptySet(), false);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : iterableEmptyList) {
                            if (nfVar.a((Annotation) obj, false)) {
                                arrayList2.add(obj);
                            }
                        }
                        arrayList.addAll(arrayList2);
                    }
                    q30 q30Var = a3Var2.b;
                    if (q30Var != null) {
                        q30Var.invalidate();
                    }
                }
            }
            return true;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean a(MotionEvent motionEvent) {
            motionEvent.getClass();
            return (vt.this.t.isEmpty() || vt.this.k.a(motionEvent) == null) ? false : true;
        }

        public final void a() {
            bm internal;
            vt vtVar = vt.this;
            vtVar.w = false;
            if (vtVar.k.j()) {
                m4 m4Var = vt.this.k;
                a3 a3Var = m4Var.c;
                if (a3Var != null) {
                    au auVarL = a3Var.l();
                    vt pageEditor = auVarL != null ? auVarL.getPageEditor() : null;
                    if (pageEditor != null) {
                        ArrayList arrayList = a3Var.d;
                        arrayList.getClass();
                        pageEditor.a(false, (Collection<? extends Annotation>) arrayList);
                    }
                    a3Var.d.clear();
                    q30 q30Var = a3Var.b;
                    if (q30Var != null) {
                        q30Var.invalidate();
                    }
                }
                m4Var.z = null;
            }
            vt vtVar2 = vt.this;
            vtVar2.v = false;
            m4 m4Var2 = vtVar2.k;
            jz jzVar = m4Var2.a.l;
            jzVar.f = null;
            jzVar.e = null;
            jzVar.a.invalidate();
            m4Var2.a.getAngularGuidesHelper().e = false;
            m4Var2.a.getAngularGuidesHelper().f.reset();
            Runnable runnable = this.d;
            if (runnable != null) {
                this.e.removeCallbacks(runnable);
            }
            vo magnifierManager = vt.this.a.getParentView().getMagnifierManager();
            if (magnifierManager != null) {
                magnifierManager.d();
            }
            sp spVar = vt.this.a.getParentView().q0;
            if (spVar != null) {
                spVar.c.setVisibility(4);
                j10 j10Var = spVar.d;
                if (j10Var != null) {
                    j10Var.a(true);
                }
            }
            m4 m4Var3 = vt.this.k;
            kf kfVar = new kf(null, 3);
            m4Var3.getClass();
            m4Var3.a.setTouchedHandleForFeedback(kfVar);
            vt vtVar3 = vt.this;
            vtVar3.k.getClass();
            t1 annotationDrawableStateProvider = vtVar3.a.getAnnotationDrawableStateProvider();
            co coVar = annotationDrawableStateProvider.f;
            if (coVar != null && coVar.f) {
                coVar.f = false;
                coVar.d = co.h;
                coVar.e = co.i;
                annotationDrawableStateProvider.c.invoke();
            }
            annotationDrawableStateProvider.f = null;
            vt.this.j.a();
            o4 o4Var = vt.this.j;
            o4Var.getClass();
            for (KeyEvent.Callback callback : ViewGroupKt.getChildren(o4Var)) {
                callback.getClass();
                Annotation annotation = ((z4) callback).getAnnotation();
                if (annotation != null) {
                    if (!annotation.isAttached()) {
                        annotation = null;
                    }
                    if (annotation != null && (internal = annotation.getInternal()) != null) {
                        internal.syncToBackend();
                    }
                }
            }
        }
    }

    public final void b(List<? extends z4<Annotation>> list, boolean z) {
        li liVar;
        if (list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            z4 z4Var = (z4) it.next();
            if (z4Var instanceof e00) {
                liVar = ((e00) z4Var).b;
            } else {
                liVar = z4Var instanceof li ? (li) z4Var : null;
            }
            if (liVar != null) {
                liVar.setEditTextViewListener(null);
                liVar.setOnEditRecordedListener(null);
            }
        }
        this.a.getAnnotationRenderingCoordinator().a(list, z);
    }

    @Override // com.pspdfkit.internal.f7.a
    public final int b() {
        m40 state = this.a.getState();
        if (state != null) {
            return state.b;
        }
        return -1;
    }

    public static final Unit a(vt vtVar, boolean z, Collection collection) {
        vtVar.a(z, (Collection<? extends Annotation>) collection);
        return Unit.INSTANCE;
    }

    public final void a(List<? extends Annotation> list, boolean z) {
        q0 annotatingHandler = this.n.getAnnotatingHandler();
        annotatingHandler.m.clear();
        if (list != null && !list.isEmpty()) {
            at atVar = annotatingHandler.c;
            atVar.getClass();
            annotatingHandler.n = new i3(list, atVar);
            annotatingHandler.m.addAll(list);
        } else {
            annotatingHandler.n = null;
        }
        Iterator<OnAnnotationSelectedListener> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onAnnotationSelectionFinished(list, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final z4 a(View view) {
        view.getClass();
        if (view instanceof z4) {
            return (z4) view;
        }
        return null;
    }

    public static /* synthetic */ boolean a(vt vtVar, boolean z, boolean z2, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return vtVar.a(z, z2, (i & 4) == 0, (i & 8) != 0);
    }

    public final boolean a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.r) {
            return false;
        }
        if (this.t.isEmpty()) {
            if (z3 && this.j.getParent() == this.a) {
                b(this.j.c(), true);
                this.a.removeView(this.j);
            }
            return false;
        }
        this.r = true;
        this.D.a();
        this.u = z2;
        this.s = null;
        Job job = this.C;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.C = null;
        ArrayList arrayList = new ArrayList(this.t);
        this.t.clear();
        final o4 o4Var = this.j;
        m4 m4Var = this.k;
        if (m4Var.g) {
            m4Var.g = false;
            m4Var.a.invalidate();
            m4Var.a.requestLayout();
        }
        a();
        o4Var.setAlpha(1.0f);
        Iterator<T> it = d().iterator();
        while (it.hasNext()) {
            ((z4) it.next()).i();
        }
        if (z) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Annotation annotation = (Annotation) obj;
                Iterator<OnAnnotationSelectedListener> it2 = this.d.iterator();
                while (it2.hasNext()) {
                    it2.next().onAnnotationDeselected(annotation, z2);
                }
            }
        }
        if (z4) {
            a(CollectionsKt.emptyList(), false);
        }
        if (z3) {
            b(o4Var.c(), true);
            this.a.removeView(o4Var);
        } else {
            i4 annotationRenderingCoordinator = this.a.getAnnotationRenderingCoordinator();
            Function0<Unit> function0 = new Function0() { // from class: com.pspdfkit.internal.vt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return vt.a(this.f$0, o4Var);
                }
            };
            annotationRenderingCoordinator.getClass();
            int size2 = arrayList.size();
            int i2 = 0;
            while (i2 < size2) {
                Object obj2 = arrayList.get(i2);
                i2++;
                annotationRenderingCoordinator.b((Annotation) obj2);
            }
            annotationRenderingCoordinator.a((List<? extends Annotation>) arrayList, true, function0);
        }
        this.r = false;
        return true;
    }

    public static final Unit a(vt vtVar, o4 o4Var) {
        vtVar.b(o4Var.c(), false);
        vtVar.a.removeView(o4Var);
        return Unit.INSTANCE;
    }

    public final z4<?> a(Annotation annotation) {
        i4 annotationRenderingCoordinator = this.a.getAnnotationRenderingCoordinator();
        annotationRenderingCoordinator.getClass();
        annotation.getClass();
        c3 c3Var = annotationRenderingCoordinator.l;
        c3Var.getClass();
        z4<?> z4VarA = c3Var.a(annotation);
        li liVar = null;
        if (z4VarA == null) {
            z4VarA = null;
        } else {
            ViewParent parent = z4VarA.a().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(z4VarA.a());
            }
        }
        if (z4VarA == null || !z4VarA.h()) {
            if (z4VarA != null) {
                annotationRenderingCoordinator.b.b(z4VarA);
                annotationRenderingCoordinator.d.remove(z4VarA);
            }
            c5 c5Var = annotationRenderingCoordinator.b;
            c5Var.getClass();
            z4VarA = c5Var.a(annotation, AnnotationOverlayRenderStrategy.Strategy.PLATFORM_RENDERING, false);
        }
        if (!annotationRenderingCoordinator.d.contains(z4VarA)) {
            annotationRenderingCoordinator.d.add(z4VarA);
        }
        if (z4VarA instanceof e00) {
            liVar = ((e00) z4VarA).b;
        } else if (z4VarA instanceof li) {
            liVar = (li) z4VarA;
        }
        if (liVar != null) {
            liVar.setEditTextViewListener(this);
            liVar.setOnEditRecordedListener(this.f);
        }
        z4VarA.b();
        z4VarA.n();
        return z4VarA;
    }

    public static final void a(vt vtVar, RectF rectF) {
        if (vtVar.t.isEmpty()) {
            return;
        }
        au auVar = vtVar.a;
        rectF.getClass();
        m40 state = auVar.getState();
        if (state == null) {
            return;
        }
        int i = state.b;
        long j = 200;
        ln lnVar = auVar.getParentView().C;
        if (lnVar != null) {
            lnVar.a(rectF, i, j, false);
        }
    }

    public final void a(float f, float f2) {
        String str;
        sp spVar;
        vo magnifierManager = this.a.getParentView().getMagnifierManager();
        if (magnifierManager != null && magnifierManager.h) {
            List listUnmodifiableList = Collections.unmodifiableList(this.t);
            listUnmodifiableList.getClass();
            if (listUnmodifiableList.size() != 1) {
                return;
            }
            Annotation annotation = (Annotation) CollectionsKt.first(listUnmodifiableList);
            if (!annotation.isMeasurement() || annotation.getType() == AnnotationType.CIRCLE) {
                return;
            }
            kotlin.Pair<Float, Float> pairA = a(f, f2, magnifierManager);
            Context context = this.a.getContext();
            context.getClass();
            wo.a(magnifierManager, context, pairA.getFirst().floatValue(), pairA.getSecond().floatValue(), 2.0f);
            MeasurementInfo measurementInfo = annotation.getMeasurementInfo();
            if (measurementInfo == null || (str = measurementInfo.label) == null || (spVar = this.a.getParentView().q0) == null) {
                return;
            }
            spVar.a(str);
        }
    }

    public final kotlin.Pair<Float, Float> a(float f, float f2, vo voVar) {
        int[] iArr = new int[2];
        this.a.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        voVar.a.getLocationInWindow(iArr2);
        return new kotlin.Pair<>(Float.valueOf((f + iArr[0]) - iArr2[0]), Float.valueOf((f2 + iArr[1]) - iArr2[1]));
    }

    public final boolean a(MotionEvent motionEvent) {
        motionEvent.getClass();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.y = motionEvent.getX();
            this.z = motionEvent.getY();
            this.A = motionEvent.getX();
            this.B = motionEvent.getY();
            this.x = System.currentTimeMillis();
        } else if (action == 2) {
            if (System.currentTimeMillis() - this.x < ViewConfiguration.getLongPressTimeout() || this.w) {
                return false;
            }
            e3 e3Var = this.D;
            float f = this.A;
            float f2 = this.B;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (e3Var.f) {
                Context context = e3Var.a.getContext();
                context.getClass();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                displayMetrics.getClass();
                float fApplyDimension = TypedValue.applyDimension(1, 5.0f, displayMetrics);
                if (Math.abs(x - f) <= fApplyDimension && Math.abs(y - f2) <= fApplyDimension) {
                    return false;
                }
            }
            jf jfVar = this.s;
            if (jfVar != null) {
                e3 e3Var2 = this.D;
                if (e3Var2.f) {
                    e3Var2.g = true;
                }
                e3Var2.a();
                float x2 = motionEvent.getX() - this.y;
                float y2 = motionEvent.getY() - this.z;
                this.y = motionEvent.getX();
                this.z = motionEvent.getY();
                this.k.a(jfVar, motionEvent, s60.a(x2, this.o), -s60.a(y2, this.o));
                a(motionEvent.getX(), motionEvent.getY());
            }
        }
        return !this.n.h() && !this.t.isEmpty() && this.j.a(motionEvent) && this.j.dispatchTouchEvent(motionEvent);
    }

    @Override // com.pspdfkit.internal.f7.a, com.pspdfkit.internal.rj.a
    public final void a(final RectF rectF) {
        this.a.postOnAnimation(new Runnable() { // from class: com.pspdfkit.internal.vt$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                vt.a(this.f$0, rectF);
            }
        });
    }

    public final void a() {
        z4 z4VarB;
        m4 m4Var = this.k;
        boolean z = m4Var.r;
        if (z) {
            if (m4Var.a.getChildCount() == 1 && (z4VarB = m4Var.a.b()) != null) {
                z4VarB.f();
            }
            m4Var.r = false;
            m4Var.a.invalidate();
        }
        if (z) {
            Iterator<OnAnnotationSelectedListener> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().onAnnotationWritingModeChanged(false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Annotation a(MotionEvent motionEvent, boolean z) {
        Object obj;
        Annotation annotation;
        Object obj2;
        Annotation annotation2;
        motionEvent.getClass();
        nf nfVar = this.l;
        Matrix matrix = this.o;
        nfVar.getClass();
        matrix.getClass();
        List<Annotation> listA = nfVar.a.a(motionEvent, matrix);
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : listA) {
            if (nfVar.a((Annotation) obj3, z)) {
                arrayList.add(obj3);
            }
        }
        boolean annotationsBlockLinks = this.c.getAnnotationsBlockLinks();
        b bVar = new b(this);
        Object obj4 = null;
        if (arrayList.isEmpty()) {
            return null;
        }
        int i = 0;
        if (arrayList.size() == 1) {
            Annotation annotation3 = (Annotation) arrayList.get(0);
            if (((Boolean) bVar.invoke(annotation3)).booleanValue()) {
                return annotation3;
            }
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i2 < size) {
            Object obj5 = arrayList.get(i2);
            i2++;
            switch (n4.a[((Annotation) obj5).getType().ordinal()]) {
                case 1:
                    z2 = true;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    z3 = true;
                    break;
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        if (z2 && z3) {
            if (annotationsBlockLinks) {
                int size2 = arrayList.size();
                int i3 = 0;
                do {
                    if (i3 < size2) {
                        obj2 = arrayList.get(i3);
                        i3++;
                    } else {
                        obj2 = null;
                    }
                    annotation2 = (Annotation) obj2;
                    if (annotation2 != null && ((Boolean) bVar.invoke(annotation2)).booleanValue()) {
                        return annotation2;
                    }
                } while (((Annotation) obj2).getType() == AnnotationType.LINK);
                annotation2 = (Annotation) obj2;
                if (annotation2 != null) {
                    return annotation2;
                }
            } else {
                int size3 = arrayList.size();
                int i4 = 0;
                do {
                    if (i4 < size3) {
                        obj = arrayList.get(i4);
                        i4++;
                    } else {
                        obj = null;
                    }
                    annotation = (Annotation) obj;
                    if (annotation != null && ((Boolean) bVar.invoke(annotation)).booleanValue()) {
                        return annotation;
                    }
                } while (((Annotation) obj).getType() != AnnotationType.LINK);
                annotation = (Annotation) obj;
                if (annotation != null) {
                    return annotation;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size4 = arrayList.size();
        int i5 = 0;
        while (i5 < size4) {
            Object obj6 = arrayList.get(i5);
            i5++;
            if (((Annotation) obj6).getType() != AnnotationType.WIDGET) {
                arrayList2.add(obj6);
            }
        }
        if (!arrayList2.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            int size5 = arrayList2.size();
            int i6 = 0;
            while (i6 < size5) {
                Object obj7 = arrayList2.get(i6);
                i6++;
                if (((Boolean) bVar.invoke(obj7)).booleanValue()) {
                    arrayList3.add(obj7);
                }
            }
            if (!arrayList3.isEmpty()) {
                return (Annotation) arrayList3.get(0);
            }
        }
        int size6 = arrayList.size();
        while (i < size6) {
            Object obj8 = arrayList.get(i);
            i++;
            if (((Boolean) bVar.invoke(obj8)).booleanValue()) {
                obj4 = obj8;
                return (Annotation) obj4;
            }
        }
        return (Annotation) obj4;
    }
}
