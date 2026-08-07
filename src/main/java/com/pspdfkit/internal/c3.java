package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Looper;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.ui.rendering.AnnotationOverlayRenderStrategy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c3 extends dw implements nx {
    public final au d;
    public final i4 e;
    public final Matrix f;
    public final LinkedHashMap g;

    public c3(au auVar, i4 i4Var) {
        super(auVar.getContext());
        this.d = auVar;
        this.e = i4Var;
        this.f = new Matrix();
        this.g = new LinkedHashMap();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    public final void a(Annotation annotation, boolean z) {
        Object obj;
        annotation.getClass();
        if (!annotation.isAttached() || !z) {
            z4<?> z4VarA = a(annotation);
            if (z4VarA == null) {
                return;
            }
            removeView(z4VarA.a());
            i4 i4Var = this.e;
            i4Var.b.b(z4VarA);
            i4Var.d.remove(z4VarA);
            return;
        }
        i4 i4Var2 = this.e;
        i4Var2.getClass();
        z4<?> z4VarA2 = i4Var2.l.a(annotation);
        if (z4VarA2 == null) {
            ArrayList arrayList = i4Var2.d;
            int size = arrayList.size();
            int i = 0;
            do {
                if (i >= size) {
                    obj = null;
                    break;
                } else {
                    obj = arrayList.get(i);
                    i++;
                }
            } while (((z4) obj).getAnnotation() != annotation);
            z4VarA2 = (z4) obj;
        }
        if (z4VarA2 == null || z4VarA2.a().getParent() == this) {
            if (z4VarA2 != null) {
                z4VarA2.n();
                z4VarA2.b();
                return;
            }
            i4 i4Var3 = this.e;
            i4Var3.getClass();
            c5 c5Var = i4Var3.b;
            c5Var.getClass();
            AnnotationOverlayRenderStrategy.Strategy overlayRenderStrategy = c5Var.e.getOverlayRenderStrategy(annotation);
            overlayRenderStrategy.getClass();
            z4<?> z4VarA3 = c5Var.a(annotation, overlayRenderStrategy);
            z4VarA3.getClass();
            View viewA = z4VarA3.a();
            if (viewA instanceof yy) {
                addView(viewA, 0);
            } else {
                addView(viewA);
            }
        }
    }

    public final void b(final z4<?> z4Var) {
        if (z4Var == null) {
            return;
        }
        CollectionsKt.removeAll(this.g.entrySet(), new Function1() { // from class: com.pspdfkit.internal.c3$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(c3.a(z4Var, (Map.Entry) obj));
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 66 && hasFocus()) {
            KeyEvent.Callback focusedChild = getFocusedChild();
            if (focusedChild instanceof z4) {
                z4 z4Var = (z4) focusedChild;
                Annotation annotation = z4Var.getAnnotation();
                if (annotation == null) {
                    throw new IllegalStateException("Annotation view has no annotation");
                }
                if (keyEvent.getAction() == 1 && z4Var.getAnnotation() != null) {
                    if (annotation instanceof WidgetAnnotation) {
                        FormElement formElement = ((WidgetAnnotation) annotation).getFormElement();
                        au auVar = this.d;
                        if (formElement == null) {
                            vt pageEditor = auVar.getPageEditor();
                            pageEditor.getClass();
                            List listAsList = ArraysKt.asList(new Annotation[]{annotation});
                            listAsList.getClass();
                            pageEditor.a(false, (Collection<? extends Annotation>) listAsList);
                        } else {
                            auVar.getFormEditor().b(formElement);
                        }
                    } else {
                        vt pageEditor2 = this.d.getPageEditor();
                        pageEditor2.getClass();
                        List listAsList2 = ArraysKt.asList(new Annotation[]{annotation});
                        listAsList2.getClass();
                        pageEditor2.a(false, (Collection<? extends Annotation>) listAsList2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i) {
        view.getClass();
        ArrayList<View> focusables = getFocusables(2);
        int iIndexOf = focusables.indexOf(view);
        if ((iIndexOf == 0 && i == 1) || (iIndexOf == focusables.size() - 1 && i == 2)) {
            return super.focusSearch(view, i);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        return viewFindNextFocus != null ? viewFindNextFocus : super.focusSearch(view, i);
    }

    public final Set<Integer> getAnnotations() {
        return new LinkedHashSet(this.g.keySet());
    }

    @Override // com.pspdfkit.internal.dw
    public RectF getPdfRect() {
        return this.d.getPdfRect();
    }

    @Override // com.pspdfkit.internal.dw
    public float getZoomScale() {
        return this.d.getZoomScale();
    }

    @Override // com.pspdfkit.internal.dw, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a(0, 0);
        Matrix matrixA = this.d.a(this.f);
        Sequence sequenceFilter = SequencesKt.filter(ViewGroupKt.getChildren(this), b3.a);
        sequenceFilter.getClass();
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            ((z4) it.next()).a(matrixA, getZoomScale());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        view.getClass();
        super.onViewAdded(view);
        a(view instanceof z4 ? (z4) view : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        view.getClass();
        b(view instanceof z4 ? (z4) view : null);
        super.onViewRemoved(view);
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("recycle() must be called on the UI thread");
        }
        IdentityHashMap identityHashMap = new IdentityHashMap();
        Iterator it = this.g.values().iterator();
        while (it.hasNext()) {
            identityHashMap.put((z4) it.next(), Unit.INSTANCE);
        }
        Set<z4<?>> setKeySet = identityHashMap.keySet();
        setKeySet.getClass();
        for (z4<?> z4Var : setKeySet) {
            if (z4Var.a().getParent() == this) {
                removeView(z4Var.a());
                i4 i4Var = this.e;
                i4Var.getClass();
                i4Var.b.b(z4Var);
                i4Var.d.remove(z4Var);
            }
        }
        while (getChildCount() != 0) {
            removeViewAt(getChildCount() - 1);
        }
    }

    public final z4<?> a(Annotation annotation) {
        KeyEvent.Callback next;
        boolean zAreEqual;
        annotation.getClass();
        z4<?> z4Var = (z4) this.g.get(Integer.valueOf(annotation.getObjectNumber()));
        if (z4Var != null) {
            if (z4Var.a().getParent() == this) {
                return z4Var;
            }
            b(z4Var);
        }
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            KeyEvent.Callback callback = (View) next;
            if (callback instanceof a5) {
                List annotations = ((a5) callback).getAnnotations();
                annotations.getClass();
                zAreEqual = CollectionsKt.contains(annotations, annotation);
            } else {
                zAreEqual = callback instanceof z4 ? Intrinsics.areEqual(annotation, ((z4) callback).getAnnotation()) : false;
            }
        } while (!zAreEqual);
        z4<?> z4Var2 = next instanceof z4 ? (z4) next : null;
        if (z4Var2 != null) {
            a(z4Var2);
        }
        return z4Var2;
    }

    @Override // com.pspdfkit.internal.dw
    public final Matrix a(Matrix matrix) {
        return this.d.a(matrix);
    }

    public final void a(z4<?> z4Var) {
        if (z4Var == null) {
            return;
        }
        if (z4Var instanceof a5) {
            List<Annotation> annotations = ((a5) z4Var).getAnnotations();
            annotations.getClass();
            for (Annotation annotation : annotations) {
                if (annotation.getObjectNumber() != Integer.MIN_VALUE) {
                    this.g.put(Integer.valueOf(annotation.getObjectNumber()), z4Var);
                }
            }
            return;
        }
        Annotation annotation2 = z4Var.getAnnotation();
        if (annotation2 == null || annotation2.getObjectNumber() == Integer.MIN_VALUE) {
            return;
        }
        this.g.put(Integer.valueOf(annotation2.getObjectNumber()), z4Var);
    }

    public static final boolean a(z4 z4Var, Map.Entry entry) {
        entry.getClass();
        return entry.getValue() == z4Var;
    }
}
